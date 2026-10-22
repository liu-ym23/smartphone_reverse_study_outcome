package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;

    @Nullable
    private final int[] mEmojiAsDefaultStyleExceptions;

    @NonNull
    private EmojiCompat.GlyphChecker mGlyphChecker;

    @NonNull
    private final MetadataRepo mMetadataRepo;

    @NonNull
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    @RequiresApi(19)
    public static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        public static int findIndexBackward(CharSequence r5, int r10, int r11) {
            int r12 = r5.length();
            if (r10 < 0) goto L30;
            if (r12 < r10) goto L30;
            if (r11 >= 0) goto L9;
            return -1;
        L9:
            boolean r13 = false;
        L10:
            if (r11 == 0) goto L11;
            r10 = r10 - 1;
            if (r10 < 0) goto L14;
            char r14 = r5.charAt(r10);
            if (r13 == true) goto L20;
            if (Character.isSurrogate(r14) == false) goto L25;
            if (Character.isHighSurrogate(r14) == true) goto L28;
            r13 = true;
            goto L10
        L28:
            return -1;
        L25:
            r11 = r11 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r14) == false) goto L21;
            r11 = r11 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r13 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r10;
        L30:
            return -1;
        }

        public static int findIndexForward(CharSequence r10, int r11, int r12) {
            int r5 = r10.length();
            if (r11 < 0) goto L29;
            if (r5 < r11) goto L29;
            if (r12 >= 0) goto L9;
            return -1;
        L9:
            boolean r13 = false;
        L10:
            if (r12 == 0) goto L11;
            if (r11 >= r5) goto L13;
            char r14 = r10.charAt(r11);
            if (r13 == true) goto L19;
            if (Character.isSurrogate(r14) == false) goto L24;
            if (Character.isLowSurrogate(r14) == true) goto L27;
            r11 = r11 + 1;
            r13 = true;
            goto L10
        L27:
            return -1;
        L24:
            r12 = r12 - 1;
            r11 = r11 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r14) == false) goto L20;
            r12 = r12 - 1;
            r11 = r11 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r13 == false) goto L15;
            return -1;
        L15:
            return r5;
        L11:
            return r11;
        L29:
            return -1;
        }
    }

    public static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState;
        private final boolean mUseEmojiAsDefaultStyle;

        public ProcessorSm(MetadataRepo.Node r5, boolean r10, int[] r11) {
            this.mState = 1;
            this.mRootNode = r5;
            this.mCurrentNode = r5;
            this.mUseEmojiAsDefaultStyle = r10;
            this.mEmojiAsDefaultStyleExceptions = r11;
        }

        private static boolean isEmojiStyle(int r5) {
            if (r5 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTextStyle(int r5) {
            if (r5 != 65038) goto L5;
            return true;
        L5:
            return false;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() == false) goto L6;
            return true;
        L6:
            if (isEmojiStyle(this.mLastCodepoint) == false) goto L9;
            return true;
        L9:
            if (this.mUseEmojiAsDefaultStyle == true) goto L11;
        L16:
            return false;
        L11:
            if (this.mEmojiAsDefaultStyleExceptions != null) goto L13;
            return true;
        L13:
            int r5 = this.mCurrentNode.getData().getCodepointAt(0);
            if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, r5) >= 0) goto L16;
            return true;
        }

        public int check(int r5) {
            MetadataRepo.Node r10 = this.mCurrentNode.get(r5);
            int r11 = 2;
            if (this.mState == 2) goto L7;
            if (r10 != null) goto L6;
            r11 = reset();
        L25:
            this.mLastCodepoint = r5;
            return r11;
        L6:
            this.mState = 2;
            this.mCurrentNode = r10;
            this.mCurrentDepth = 1;
            goto L25
        L7:
            if (r10 == null) goto L10;
            this.mCurrentNode = r10;
            this.mCurrentDepth++;
            goto L25
        L10:
            if (isTextStyle(r5) == false) goto L13;
            r11 = reset();
            goto L25
        L13:
            if (isEmojiStyle(r5) == true) goto L25;
            if (this.mCurrentNode.getData() == null) goto L24;
            r11 = 3;
            if (this.mCurrentDepth == 1) goto L20;
            this.mFlushNode = this.mCurrentNode;
            reset();
            goto L25
        L20:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L22;
            this.mFlushNode = this.mCurrentNode;
            reset();
            goto L25
        L22:
            r11 = reset();
            goto L25
        L24:
            r11 = reset();
            goto L25
        }

        public EmojiMetadata getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        public EmojiMetadata getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        public boolean isInFlushableState() {
            if (this.mState == 2) goto L5;
        L11:
            return false;
        L5:
            if (this.mCurrentNode.getData() == null) goto L11;
            if (this.mCurrentDepth <= 1) goto L9;
            return true;
        L9:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L11;
            return true;
        }
    }

    public EmojiProcessor(@NonNull MetadataRepo r5, @NonNull EmojiCompat.SpanFactory r10, @NonNull EmojiCompat.GlyphChecker r11, boolean r12, @Nullable int[] r13) {
        this.mSpanFactory = r10;
        this.mMetadataRepo = r5;
        this.mGlyphChecker = r11;
        this.mUseEmojiAsDefaultStyle = r12;
        this.mEmojiAsDefaultStyleExceptions = r13;
    }

    private void addEmoji(@NonNull Spannable r5, EmojiMetadata r10, int r11, int r12) {
        r5.setSpan(this.mSpanFactory.createSpan(r10), r11, r12, 33);
    }

    private static boolean delete(@NonNull Editable r10, @NonNull KeyEvent r11, boolean r12) {
        if (hasModifiers(r11) == false) goto L5;
        return false;
    L5:
        int r13 = Selection.getSelectionStart(r10);
        int r5 = Selection.getSelectionEnd(r10);
        if (hasInvalidSelection(r13, r5) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r14 = (EmojiSpan[]) r10.getSpans(r13, r5, EmojiSpan.class);
        if (r14 != null) goto L11;
    L24:
        return false;
    L11:
        if (r14.length <= 0) goto L24;
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L24;
        EmojiSpan r17 = r14[r16];
        int r18 = r10.getSpanStart(r17);
        int r19 = r10.getSpanEnd(r17);
        if (r12 == false) goto L17;
        if (r18 != r13) goto L17;
    L21:
        r10.delete(r18, r19);
        return true;
    L17:
        if (r12 == true) goto L19;
        if (r19 == r13) goto L21;
    L19:
        if (r13 <= r18) goto L23;
        if (r13 < r19) goto L21;
    L23:
        r16 = r16 + 1;
        goto L13
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection r5, @NonNull Editable r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, boolean r13) {
        if (r10 == null) goto L27;
        if (r5 == null) goto L27;
        if (r11 < 0) goto L27;
        if (r12 < 0) goto L27;
        int r14 = Selection.getSelectionStart(r10);
        int r15 = Selection.getSelectionEnd(r10);
        if (hasInvalidSelection(r14, r15) == false) goto L12;
        return false;
    L12:
        if (r13 == false) goto L17;
        int r16 = CodepointIndexFinder.findIndexBackward(r10, r14, Math.max(r11, 0));
        int r17 = CodepointIndexFinder.findIndexForward(r10, r15, Math.max(r12, 0));
        if (r16 == (-1)) goto L16;
        if (r17 == (-1)) goto L16;
    L18:
        EmojiSpan[] r18 = (EmojiSpan[]) r10.getSpans(r16, r17, EmojiSpan.class);
        if (r18 == null) goto L27;
        if (r18.length <= 0) goto L27;
        int r19 = r18.length;
        int r20 = 0;
    L23:
        if (r20 >= r19) goto L25;
        EmojiSpan r21 = r18[r20];
        int r22 = r10.getSpanStart(r21);
        int r23 = r10.getSpanEnd(r21);
        r16 = Math.min(r22, r16);
        r17 = Math.max(r23, r17);
        r20 = r20 + 1;
        goto L23
    L25:
        int r24 = Math.max(r16, 0);
        int r25 = Math.min(r17, r10.length());
        r5.beginBatchEdit();
        r10.delete(r24, r25);
        r5.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r16 = Math.max(r14 - r11, 0);
        r17 = Math.min(r15 + r12, r10.length());
    L27:
        return false;
    }

    public static boolean handleOnKeyDown(@NonNull Editable r5, int r10, @NonNull KeyEvent r11) {
        if (r10 != 67) goto L5;
        boolean r12 = delete(r5, r11, false);
    L9:
        if (r12 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r5);
        return true;
    L12:
        return false;
    L5:
        if (r10 == 112) goto L7;
        r12 = false;
        goto L9
    L7:
        r12 = delete(r5, r11, true);
        goto L9
    }

    private boolean hasGlyph(CharSequence r5, int r10, int r11, EmojiMetadata r12) {
        if (r12.getHasGlyph() != 0) goto L6;
        r12.setHasGlyph(this.mGlyphChecker.hasGlyph(r5, r10, r11, r12.getSdkAdded()));
    L6:
        if (r12.getHasGlyph() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean hasInvalidSelection(int r5, int r10) {
        if (r5 == (-1)) goto L8;
        if (r10 == (-1)) goto L8;
        if (r5 != r10) goto L8;
        return false;
    L8:
        return true;
    }

    private static boolean hasModifiers(@NonNull KeyEvent r5) {
        return !KeyEvent.metaStateHasNoModifiers(r5.getMetaState());
    }

    public int getEmojiMatch(@NonNull CharSequence r5) {
        return getEmojiMatch(r5, this.mMetadataRepo.getMetadataVersion());
    }

    public CharSequence process(@NonNull CharSequence r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, @IntRange(from = 0) int r14, boolean r15) {
        boolean r5 = r11 instanceof SpannableBuilder;
        if (r5 == false) goto L6;
        ((SpannableBuilder) r11).beginBatchEdit();
    L6:
        if (r5 == false) goto L86;
    L18:
        UnprecomputeTextOnModificationSpannable r10 = new UnprecomputeTextOnModificationSpannable((Spannable) r11);     // Catch: Throwable -> L15
    L20:
        if (r10 == null) goto L31;
        EmojiSpan[] r16 = (EmojiSpan[]) r10.getSpans(r12, r13, EmojiSpan.class);     // Catch: Throwable -> L15
        if (r16 == null) goto L31;
        if (r16.length <= 0) goto L31;
        int r17 = r16.length;     // Catch: Throwable -> L15
        int r18 = 0;
    L26:
        if (r18 >= r17) goto L31;
        EmojiSpan r19 = r16[r18];     // Catch: Throwable -> L15
        int r20 = r10.getSpanStart(r19);     // Catch: Throwable -> L15
        int r21 = r10.getSpanEnd(r19);     // Catch: Throwable -> L15
        if (r20 == r13) goto L30;
        r10.removeSpan(r19);     // Catch: Throwable -> L15
    L30:
        r12 = Math.min(r20, r12);     // Catch: Throwable -> L15
        r13 = Math.max(r21, r13);     // Catch: Throwable -> L15
        r18 = r18 + 1;     // Catch: Throwable -> L15
    L31:
        if (r12 != r13) goto L33;
    L80:
        if (r5 == false) goto L82;
        ((SpannableBuilder) r11).endBatchEdit();
    L82:
        return r11;
    L33:
        if (r12 >= r11.length()) goto L80;
        if (r14 == Integer.MAX_VALUE) goto L39;
        if (r10 == null) goto L39;
        r14 = r14 - ((EmojiSpan[]) r10.getSpans(0, r10.length(), EmojiSpan.class)).length;     // Catch: Throwable -> L15
    L39:
        ProcessorSm r22 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);     // Catch: Throwable -> L15
        int r23 = Character.codePointAt(r11, r12);     // Catch: Throwable -> L15
        int r24 = 0;
        UnprecomputeTextOnModificationSpannable r25 = r10;
    L40:
        int r26 = r12;
    L41:
        if (r12 >= r13) goto L64;
        if (r24 >= r14) goto L64;
        int r27 = r22.check(r23);     // Catch: Throwable -> L15
        if (r27 != 1) goto L46;
        r26 = r26 + Character.charCount(Character.codePointAt(r11, r26));     // Catch: Throwable -> L15
        if (r26 >= r13) goto L62;
        r23 = Character.codePointAt(r11, r26);     // Catch: Throwable -> L15
    L62:
        r12 = r26;
        goto L41
    L46:
        if (r27 != 2) goto L48;
        r12 = r12 + Character.charCount(r23);     // Catch: Throwable -> L15
        if (r12 >= r13) goto L41;
        r23 = Character.codePointAt(r11, r12);     // Catch: Throwable -> L15
        goto L41
    L48:
        if (r27 != 3) goto L41;
        if (r15 == true) goto L53;
        if (hasGlyph(r11, r26, r12, r22.getFlushMetadata()) == true) goto L40;
    L53:
        if (r25 != null) goto L55;
        r25 = new UnprecomputeTextOnModificationSpannable(new SpannableString(r11));     // Catch: Throwable -> L15
    L55:
        addEmoji(r25, r22.getFlushMetadata(), r26, r12);     // Catch: Throwable -> L15
        r24 = r24 + 1;     // Catch: Throwable -> L15
    L64:
        if (r22.isInFlushableState() == false) goto L72;
        if (r24 >= r14) goto L72;
        if (r15 == false) goto L68;
    L69:
        if (r25 != null) goto L71;
        r25 = new UnprecomputeTextOnModificationSpannable(r11);     // Catch: Throwable -> L15
    L71:
        addEmoji(r25, r22.getCurrentMetadata(), r26, r12);     // Catch: Throwable -> L15
        goto L72
    L68:
        if (hasGlyph(r11, r26, r12, r22.getCurrentMetadata()) == false) goto L69;
    L72:
        if (r25 == null) goto L77;
        Spannable r110 = r25.getUnwrappedSpannable();     // Catch: Throwable -> L15
        if (r5 == false) goto L76;
        ((SpannableBuilder) r11).endBatchEdit();
    L76:
        return r110;
    L15:
        th = move-exception;
        if (r5 == false) goto L85;
        ((SpannableBuilder) r11).endBatchEdit();
    L85:
        throw th;
    L77:
        if (r5 == false) goto L79;
        ((SpannableBuilder) r11).endBatchEdit();
    L79:
        return r11;
    L86:
        if ((r11 instanceof Spannable) == true) goto L18;
        if ((r11 instanceof Spanned) == true) goto L13;
    L17:
        r10 = null;
        goto L20
    L13:
        if (((Spanned) r11).nextSpanTransition(r12 - 1, r13 + 1, EmojiSpan.class) > r13) goto L17;
        r10 = new UnprecomputeTextOnModificationSpannable(r11);     // Catch: Throwable -> L15
        goto L20
    }

    public int getEmojiMatch(@NonNull CharSequence r11, int r12) {
        ProcessorSm r5 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r10 = r11.length();
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r10) goto L20;
        int r16 = Character.codePointAt(r11, r13);
        int r17 = r5.check(r16);
        EmojiMetadata r18 = r5.getCurrentMetadata();
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L9;
        r13 = r13 + Character.charCount(r16);
    L16:
        if (r18 == null) goto L4;
        if (r18.getCompatAdded() > r12) goto L4;
        r15 = r15 + 1;
        goto L4
    L9:
        if (r17 != 3) goto L16;
        r18 = r5.getFlushMetadata();
        if (r18.getCompatAdded() > r12) goto L16;
        r14 = r14 + 1;
        goto L16
    L15:
        r13 = r13 + Character.charCount(r16);
        r15 = 0;
        goto L16
    L20:
        if (r14 == 0) goto L23;
        return 2;
    L23:
        if (r5.isInFlushableState() == true) goto L25;
    L27:
        if (r15 != 0) goto L29;
        return 0;
    L29:
        return 2;
    L25:
        if (r5.getCurrentMetadata().getCompatAdded() > r12) goto L27;
        return 1;
    }
}
