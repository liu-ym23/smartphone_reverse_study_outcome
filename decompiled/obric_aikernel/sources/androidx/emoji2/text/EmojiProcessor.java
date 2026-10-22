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
    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence r10, int r11, int r12) {
            int r13 = r10.length();
            if (r11 < 0) goto L30;
            if (r13 < r11) goto L30;
            if (r12 >= 0) goto L9;
            return -1;
        L9:
            boolean r14 = false;
        L10:
            if (r12 == 0) goto L11;
            r11 = r11 - 1;
            if (r11 < 0) goto L14;
            char r15 = r10.charAt(r11);
            if (r14 == true) goto L20;
            if (Character.isSurrogate(r15) == false) goto L25;
            if (Character.isHighSurrogate(r15) == true) goto L28;
            r14 = true;
            goto L10
        L28:
            return -1;
        L25:
            r12 = r12 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r15) == false) goto L21;
            r12 = r12 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r14 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r11;
        L30:
            return -1;
        }

        static int findIndexForward(CharSequence r10, int r11, int r12) {
            int r13 = r10.length();
            if (r11 < 0) goto L29;
            if (r13 < r11) goto L29;
            if (r12 >= 0) goto L9;
            return -1;
        L9:
            boolean r14 = false;
        L10:
            if (r12 == 0) goto L11;
            if (r11 >= r13) goto L13;
            char r15 = r10.charAt(r11);
            if (r14 == true) goto L19;
            if (Character.isSurrogate(r15) == false) goto L24;
            if (Character.isLowSurrogate(r15) == true) goto L27;
            r11 = r11 + 1;
            r14 = true;
            goto L10
        L27:
            return -1;
        L24:
            r12 = r12 - 1;
            r11 = r11 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r15) == false) goto L20;
            r12 = r12 - 1;
            r11 = r11 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r14 == false) goto L15;
            return -1;
        L15:
            return r13;
        L11:
            return r11;
        L29:
            return -1;
        }
    }

    static final class ProcessorSm {
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

        ProcessorSm(MetadataRepo.Node r10, boolean r11, int[] r12) {
            this.mState = 1;
            this.mRootNode = r10;
            this.mCurrentNode = r10;
            this.mUseEmojiAsDefaultStyle = r11;
            this.mEmojiAsDefaultStyleExceptions = r12;
        }

        private static boolean isEmojiStyle(int r10) {
            if (r10 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTextStyle(int r10) {
            if (r10 != 65038) goto L5;
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
            int r10 = this.mCurrentNode.getData().getCodepointAt(0);
            if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, r10) >= 0) goto L16;
            return true;
        }

        int check(int r10) {
            MetadataRepo.Node r11 = this.mCurrentNode.get(r10);
            int r12 = 3;
            if (this.mState == 2) goto L8;
            if (r11 != null) goto L6;
        L5:
            r12 = reset();
        L23:
            this.mLastCodepoint = r10;
            return r12;
        L6:
            this.mState = 2;
            this.mCurrentNode = r11;
            this.mCurrentDepth = 1;
        L7:
            r12 = 2;
            goto L23
        L8:
            if (r11 == null) goto L11;
            this.mCurrentNode = r11;
            this.mCurrentDepth++;
            goto L7
        L11:
            if (isTextStyle(r10) == true) goto L5;
            if (isEmojiStyle(r10) == true) goto L7;
            if (this.mCurrentNode.getData() == null) goto L5;
            if (this.mCurrentDepth == 1) goto L21;
        L22:
            this.mFlushNode = this.mCurrentNode;
            reset();
            goto L23
        L21:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L5;
            goto L5
        }

        EmojiMetadata getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        EmojiMetadata getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
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

    EmojiProcessor(@NonNull MetadataRepo r10, @NonNull EmojiCompat.SpanFactory r11, @NonNull EmojiCompat.GlyphChecker r12, boolean r13, @Nullable int[] r14) {
        this.mSpanFactory = r11;
        this.mMetadataRepo = r10;
        this.mGlyphChecker = r12;
        this.mUseEmojiAsDefaultStyle = r13;
        this.mEmojiAsDefaultStyleExceptions = r14;
    }

    private void addEmoji(@NonNull Spannable r10, EmojiMetadata r11, int r12, int r13) {
        r10.setSpan(this.mSpanFactory.createSpan(r11), r12, r13, 33);
    }

    private static boolean delete(@NonNull Editable r10, @NonNull KeyEvent r11, boolean r12) {
        if (hasModifiers(r11) == false) goto L5;
        return false;
    L5:
        int r13 = Selection.getSelectionStart(r10);
        int r14 = Selection.getSelectionEnd(r10);
        if (hasInvalidSelection(r13, r14) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r15 = (EmojiSpan[]) r10.getSpans(r13, r14, EmojiSpan.class);
        if (r15 != null) goto L11;
    L24:
        return false;
    L11:
        if (r15.length <= 0) goto L24;
        int r16 = r15.length;
        int r17 = 0;
    L13:
        if (r17 >= r16) goto L24;
        EmojiSpan r18 = r15[r17];
        int r19 = r10.getSpanStart(r18);
        int r20 = r10.getSpanEnd(r18);
        if (r12 == false) goto L17;
        if (r19 != r13) goto L17;
    L21:
        r10.delete(r19, r20);
        return true;
    L17:
        if (r12 == true) goto L19;
        if (r20 == r13) goto L21;
    L19:
        if (r13 <= r19) goto L23;
        if (r13 < r20) goto L21;
    L23:
        r17 = r17 + 1;
        goto L13
    }

    static boolean handleDeleteSurroundingText(@NonNull InputConnection r10, @NonNull Editable r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, boolean r14) {
        if (r11 == null) goto L27;
        if (r10 == null) goto L27;
        if (r12 < 0) goto L27;
        if (r13 < 0) goto L27;
        int r15 = Selection.getSelectionStart(r11);
        int r16 = Selection.getSelectionEnd(r11);
        if (hasInvalidSelection(r15, r16) == false) goto L12;
        return false;
    L12:
        if (r14 == false) goto L17;
        int r17 = CodepointIndexFinder.findIndexBackward(r11, r15, Math.max(r12, 0));
        int r18 = CodepointIndexFinder.findIndexForward(r11, r16, Math.max(r13, 0));
        if (r17 == (-1)) goto L16;
        if (r18 == (-1)) goto L16;
    L18:
        EmojiSpan[] r19 = (EmojiSpan[]) r11.getSpans(r17, r18, EmojiSpan.class);
        if (r19 == null) goto L27;
        if (r19.length <= 0) goto L27;
        int r20 = r19.length;
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L25;
        EmojiSpan r22 = r19[r21];
        int r23 = r11.getSpanStart(r22);
        int r24 = r11.getSpanEnd(r22);
        r17 = Math.min(r23, r17);
        r18 = Math.max(r24, r18);
        r21 = r21 + 1;
        goto L23
    L25:
        int r25 = Math.max(r17, 0);
        int r26 = Math.min(r18, r11.length());
        r10.beginBatchEdit();
        r11.delete(r25, r26);
        r10.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r17 = Math.max(r15 - r12, 0);
        r18 = Math.min(r16 + r13, r11.length());
    L27:
        return false;
    }

    static boolean handleOnKeyDown(@NonNull Editable r10, int r11, @NonNull KeyEvent r12) {
        if (r11 != 67) goto L5;
        boolean r13 = delete(r10, r12, false);
    L9:
        if (r13 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r10);
        return true;
    L12:
        return false;
    L5:
        if (r11 == 112) goto L7;
        r13 = false;
        goto L9
    L7:
        r13 = delete(r10, r12, true);
        goto L9
    }

    private boolean hasGlyph(CharSequence r10, int r11, int r12, EmojiMetadata r13) {
        if (r13.getHasGlyph() != 0) goto L6;
        r13.setHasGlyph(this.mGlyphChecker.hasGlyph(r10, r11, r12, r13.getSdkAdded()));
    L6:
        if (r13.getHasGlyph() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean hasInvalidSelection(int r10, int r11) {
        if (r10 == (-1)) goto L8;
        if (r11 == (-1)) goto L8;
        if (r10 != r11) goto L8;
        return false;
    L8:
        return true;
    }

    private static boolean hasModifiers(@NonNull KeyEvent r10) {
        return !KeyEvent.metaStateHasNoModifiers(r10.getMetaState());
    }

    int getEmojiMatch(@NonNull CharSequence r10) {
        return getEmojiMatch(r10, this.mMetadataRepo.getMetadataVersion());
    }

    int getEmojiMatch(@NonNull CharSequence r11, int r12) {
        ProcessorSm r10 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r13 = r11.length();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14 >= r13) goto L20;
        int r17 = Character.codePointAt(r11, r14);
        int r18 = r10.check(r17);
        EmojiMetadata r19 = r10.getCurrentMetadata();
        if (r18 == 1) goto L15;
        if (r18 != 2) goto L9;
        r14 = r14 + Character.charCount(r17);
    L16:
        if (r19 == null) goto L4;
        if (r19.getCompatAdded() > r12) goto L4;
        r16 = r16 + 1;
        goto L4
    L9:
        if (r18 != 3) goto L16;
        r19 = r10.getFlushMetadata();
        if (r19.getCompatAdded() > r12) goto L16;
        r15 = r15 + 1;
        goto L16
    L15:
        r14 = r14 + Character.charCount(r17);
        r16 = 0;
        goto L16
    L20:
        if (r15 == 0) goto L23;
        return 2;
    L23:
        if (r10.isInFlushableState() == true) goto L25;
    L27:
        if (r16 != 0) goto L29;
        return 0;
    L29:
        return 2;
    L25:
        if (r10.getCurrentMetadata().getCompatAdded() > r12) goto L27;
        return 1;
    }

    CharSequence process(@NonNull CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, boolean r14) {
        boolean r15 = r10 instanceof SpannableBuilder;
        if (r15 == false) goto L5;
        ((SpannableBuilder) r10).beginBatchEdit();
    L5:
        UnprecomputeTextOnModificationSpannable r16 = null;
        if (r15 == false) goto L84;
    L15:
        r16 = new UnprecomputeTextOnModificationSpannable((Spannable) r10);     // Catch: Throwable -> L80
    L17:
        if (r16 == null) goto L28;
        EmojiSpan[] r17 = (EmojiSpan[]) r16.getSpans(r11, r12, EmojiSpan.class);     // Catch: Throwable -> L80
        if (r17 == null) goto L28;
        if (r17.length <= 0) goto L28;
        int r18 = r17.length;     // Catch: Throwable -> L80
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L28;
        EmojiSpan r20 = r17[r19];     // Catch: Throwable -> L80
        int r21 = r16.getSpanStart(r20);     // Catch: Throwable -> L80
        int r22 = r16.getSpanEnd(r20);     // Catch: Throwable -> L80
        if (r21 == r12) goto L27;
        r16.removeSpan(r20);     // Catch: Throwable -> L80
    L27:
        r11 = Math.min(r21, r11);     // Catch: Throwable -> L80
        r12 = Math.max(r22, r12);     // Catch: Throwable -> L80
        r19 = r19 + 1;     // Catch: Throwable -> L80
    L28:
        if (r11 != r12) goto L30;
    L77:
        if (r15 == false) goto L79;
        ((SpannableBuilder) r10).endBatchEdit();
    L79:
        return r10;
    L30:
        if (r11 >= r10.length()) goto L77;
        if (r13 == Integer.MAX_VALUE) goto L36;
        if (r16 == null) goto L36;
        r13 = r13 - ((EmojiSpan[]) r16.getSpans(0, r16.length(), EmojiSpan.class)).length;     // Catch: Throwable -> L80
    L36:
        ProcessorSm r23 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);     // Catch: Throwable -> L80
        int r24 = Character.codePointAt(r10, r11);     // Catch: Throwable -> L80
        int r25 = 0;
        UnprecomputeTextOnModificationSpannable r26 = r16;
    L37:
        int r27 = r11;
    L38:
        if (r11 >= r12) goto L61;
        if (r25 >= r13) goto L61;
        int r28 = r23.check(r24);     // Catch: Throwable -> L80
        if (r28 != 1) goto L43;
        r27 = r27 + Character.charCount(Character.codePointAt(r10, r27));     // Catch: Throwable -> L80
        if (r27 >= r12) goto L59;
        r24 = Character.codePointAt(r10, r27);     // Catch: Throwable -> L80
    L59:
        r11 = r27;
        goto L38
    L43:
        if (r28 != 2) goto L45;
        r11 = r11 + Character.charCount(r24);     // Catch: Throwable -> L80
        if (r11 >= r12) goto L38;
        r24 = Character.codePointAt(r10, r11);     // Catch: Throwable -> L80
        goto L38
    L45:
        if (r28 != 3) goto L38;
        if (r14 == true) goto L50;
        if (hasGlyph(r10, r27, r11, r23.getFlushMetadata()) == true) goto L37;
    L50:
        if (r26 != null) goto L52;
        r26 = new UnprecomputeTextOnModificationSpannable(new SpannableString(r10));     // Catch: Throwable -> L80
    L52:
        addEmoji(r26, r23.getFlushMetadata(), r27, r11);     // Catch: Throwable -> L80
        r25 = r25 + 1;     // Catch: Throwable -> L80
    L61:
        if (r23.isInFlushableState() == false) goto L69;
        if (r25 >= r13) goto L69;
        if (r14 == false) goto L65;
    L66:
        if (r26 != null) goto L68;
        r26 = new UnprecomputeTextOnModificationSpannable(r10);     // Catch: Throwable -> L80
    L68:
        addEmoji(r26, r23.getCurrentMetadata(), r27, r11);     // Catch: Throwable -> L80
        goto L69
    L65:
        if (hasGlyph(r10, r27, r11, r23.getCurrentMetadata()) == false) goto L66;
    L69:
        if (r26 == null) goto L74;
        Spannable r29 = r26.getUnwrappedSpannable();     // Catch: Throwable -> L80
        if (r15 == false) goto L73;
        ((SpannableBuilder) r10).endBatchEdit();
    L73:
        return r29;
    L80:
        th = move-exception;
        if (r15 == false) goto L83;
        ((SpannableBuilder) r10).endBatchEdit();
    L83:
        throw th;
    L74:
        if (r15 == false) goto L76;
        ((SpannableBuilder) r10).endBatchEdit();
    L76:
        return r10;
    L84:
        if ((r10 instanceof Spannable) == true) goto L15;
        if ((r10 instanceof Spanned) == false) goto L17;
        if (((Spanned) r10).nextSpanTransition(r11 - 1, r12 + 1, EmojiSpan.class) > r12) goto L17;
        r16 = new UnprecomputeTextOnModificationSpannable(r10);     // Catch: Throwable -> L80
        goto L17
    }
}
