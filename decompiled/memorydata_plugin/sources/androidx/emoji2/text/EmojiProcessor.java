package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence r5, int r6, int r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            int r0 = r8.length();
            if (r6 < 0) goto L30;
            if (r0 < r6) goto L30;
            if (r7 >= 0) goto L9;
            return -1;
        L9:
            boolean r2 = false;
        L10:
            if (r7 == 0) goto L11;
            r6 = r6 - 1;
            if (r6 < 0) goto L14;
            char r3 = r8.charAt(r6);
            if (r2 == true) goto L20;
            if (Character.isSurrogate(r3) == false) goto L25;
            if (Character.isHighSurrogate(r3) == true) goto L28;
            r2 = true;
            goto L10
        L28:
            return -1;
        L25:
            r7 = r7 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r3) == false) goto L21;
            r7 = r7 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r2 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r6;
        L30:
            return -1;
        }

        static int findIndexForward(CharSequence r6, int r7, int r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
            int r0 = r9.length();
            if (r7 < 0) goto L29;
            if (r0 < r7) goto L29;
            if (r8 >= 0) goto L9;
            return -1;
        L9:
            boolean r3 = false;
        L10:
            if (r8 == 0) goto L11;
            if (r7 >= r0) goto L13;
            char r4 = r9.charAt(r7);
            if (r3 == true) goto L19;
            if (Character.isSurrogate(r4) == false) goto L24;
            if (Character.isLowSurrogate(r4) == true) goto L27;
            r7 = r7 + 1;
            r3 = true;
            goto L10
        L27:
            return -1;
        L24:
            r8 = r8 - 1;
            r7 = r7 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r4) == false) goto L20;
            r8 = r8 - 1;
            r7 = r7 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r3 == false) goto L15;
            return -1;
        L15:
            return r0;
        L11:
            return r7;
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

        ProcessorSm(MetadataRepo.Node r2, boolean r3, int[] r4) {
            this.mState = 1;
            this.mRootNode = r2;
            this.mCurrentNode = r2;
            this.mUseEmojiAsDefaultStyle = r3;
            this.mEmojiAsDefaultStyleExceptions = r4;
        }

        private static boolean isEmojiStyle(int r1) {
            if (r1 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTextStyle(int r1) {
            if (r1 != 65038) goto L5;
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
            int r0 = this.mCurrentNode.getData().getCodepointAt(0);
            if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, r0) >= 0) goto L16;
            return true;
        }

        int check(int r6) {
            MetadataRepo.Node r0 = this.mCurrentNode.get(r6);
            int r2 = 3;
            if (this.mState == 2) goto L8;
            if (r0 != null) goto L6;
        L5:
            r2 = reset();
        L23:
            this.mLastCodepoint = r6;
            return r2;
        L6:
            this.mState = 2;
            this.mCurrentNode = r0;
            this.mCurrentDepth = 1;
        L7:
            r2 = 2;
            goto L23
        L8:
            if (r0 == null) goto L11;
            this.mCurrentNode = r0;
            this.mCurrentDepth++;
            goto L7
        L11:
            if (isTextStyle(r6) == true) goto L5;
            if (isEmojiStyle(r6) == true) goto L7;
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

    EmojiProcessor(MetadataRepo r3, EmojiCompat.SpanFactory r4, EmojiCompat.GlyphChecker r5, boolean r6, int[] r7) {
        EmojiCompat.GlyphChecker r8 = (EmojiCompat.GlyphChecker) ZeusTransformUtils.wrapperContextForParams(r5, EmojiCompat.GlyphChecker.class, "com.obric.memorydata.plugin");
        this.mSpanFactory = r4;
        this.mMetadataRepo = r3;
        this.mGlyphChecker = r8;
        this.mUseEmojiAsDefaultStyle = r6;
        this.mEmojiAsDefaultStyleExceptions = r7;
    }

    private void addEmoji(Spannable r3, EmojiMetadata r4, int r5, int r6) {
        ((Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.memorydata.plugin")).setSpan(this.mSpanFactory.createSpan(r4), r5, r6, 33);
    }

    private static boolean delete(Editable r6, KeyEvent r7, boolean r8) {
        Editable r9 = (Editable) ZeusTransformUtils.wrapperContextForParams(r6, Editable.class, "com.obric.memorydata.plugin");
        if (hasModifiers(r7) == false) goto L5;
        return false;
    L5:
        int r10 = Selection.getSelectionStart(r9);
        int r2 = Selection.getSelectionEnd(r9);
        if (hasInvalidSelection(r10, r2) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r1 = (EmojiSpan[]) ZeusTransformUtils.preCheckCast(r9.getSpans(r10, r2, EmojiSpan.class), EmojiSpan[].class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
    L24:
        return false;
    L11:
        if (r1.length <= 0) goto L24;
        int r3 = r1.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L24;
        EmojiSpan r5 = r1[r4];
        int r11 = r9.getSpanStart(r5);
        int r12 = r9.getSpanEnd(r5);
        if (r8 == false) goto L17;
        if (r11 != r10) goto L17;
    L21:
        r9.delete(r11, r12);
        return true;
    L17:
        if (r8 == true) goto L19;
        if (r12 == r10) goto L21;
    L19:
        if (r10 <= r11) goto L23;
        if (r10 < r12) goto L21;
    L23:
        r4 = r4 + 1;
        goto L13
    }

    static boolean handleDeleteSurroundingText(InputConnection r5, Editable r6, int r7, int r8, boolean r9) {
        InputConnection r10 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r5, InputConnection.class, "com.obric.memorydata.plugin");
        Editable r11 = (Editable) ZeusTransformUtils.wrapperContextForParams(r6, Editable.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        if (r10 == null) goto L27;
        if (r7 < 0) goto L27;
        if (r8 < 0) goto L27;
        int r2 = Selection.getSelectionStart(r11);
        int r3 = Selection.getSelectionEnd(r11);
        if (hasInvalidSelection(r2, r3) == false) goto L12;
        return false;
    L12:
        if (r9 == false) goto L17;
        int r12 = CodepointIndexFinder.findIndexBackward(r11, r2, Math.max(r7, 0));
        int r13 = CodepointIndexFinder.findIndexForward(r11, r3, Math.max(r8, 0));
        if (r12 == (-1)) goto L16;
        if (r13 == (-1)) goto L16;
    L18:
        EmojiSpan[] r14 = (EmojiSpan[]) ZeusTransformUtils.preCheckCast(r11.getSpans(r12, r13, EmojiSpan.class), EmojiSpan[].class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L27;
        if (r14.length <= 0) goto L27;
        int r1 = r14.length;
        int r4 = 0;
    L23:
        if (r4 >= r1) goto L25;
        EmojiSpan r15 = r14[r4];
        int r16 = r11.getSpanStart(r15);
        int r17 = r11.getSpanEnd(r15);
        r12 = Math.min(r16, r12);
        r13 = Math.max(r17, r13);
        r4 = r4 + 1;
        goto L23
    L25:
        int r18 = Math.max(r12, 0);
        int r19 = Math.min(r13, r11.length());
        r10.beginBatchEdit();
        r11.delete(r18, r19);
        r10.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r12 = Math.max(r2 - r7, 0);
        r13 = Math.min(r3 + r8, r11.length());
    L27:
        return false;
    }

    static boolean handleOnKeyDown(Editable r3, int r4, KeyEvent r5) {
        Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
        if (r4 != 67) goto L5;
        boolean r7 = delete(r6, r5, false);
    L9:
        if (r7 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r6);
        return true;
    L12:
        return false;
    L5:
        if (r4 == 112) goto L7;
        r7 = false;
        goto L9
    L7:
        r7 = delete(r6, r5, true);
        goto L9
    }

    private boolean hasGlyph(CharSequence r3, int r4, int r5, EmojiMetadata r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6.getHasGlyph() != 0) goto L6;
        r6.setHasGlyph(this.mGlyphChecker.hasGlyph(r7, r4, r5, r6.getSdkAdded()));
    L6:
        if (r6.getHasGlyph() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean hasInvalidSelection(int r1, int r2) {
        if (r1 == (-1)) goto L8;
        if (r2 == (-1)) goto L8;
        if (r1 != r2) goto L8;
        return false;
    L8:
        return true;
    }

    private static boolean hasModifiers(KeyEvent r0) {
        return !KeyEvent.metaStateHasNoModifiers(r0.getMetaState());
    }

    int getEmojiMatch(CharSequence r3) {
        return getEmojiMatch((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), this.mMetadataRepo.getMetadataVersion());
    }

    int getEmojiMatch(CharSequence r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        ProcessorSm r0 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r10 = r13.length();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2 >= r10) goto L20;
        int r7 = Character.codePointAt(r13, r2);
        int r8 = r0.check(r7);
        EmojiMetadata r9 = r0.getCurrentMetadata();
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L9;
        r2 = r2 + Character.charCount(r7);
    L16:
        if (r9 == null) goto L4;
        if (r9.getCompatAdded() > r12) goto L4;
        r4 = r4 + 1;
        goto L4
    L9:
        if (r8 != 3) goto L16;
        r9 = r0.getFlushMetadata();
        if (r9.getCompatAdded() > r12) goto L16;
        r3 = r3 + 1;
        goto L16
    L15:
        r2 = r2 + Character.charCount(r7);
        r4 = 0;
        goto L16
    L20:
        if (r3 == 0) goto L23;
        return 2;
    L23:
        if (r0.isInFlushableState() == true) goto L25;
    L27:
        if (r4 != 0) goto L29;
        return 0;
    L29:
        return 2;
    L25:
        if (r0.getCurrentMetadata().getCompatAdded() > r12) goto L27;
        return 1;
    }

    CharSequence process(CharSequence r11, int r12, int r13, int r14, boolean r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = ZeusTransformUtils.instanceOf(r16, SpannableBuilder.class);
        if (r0 == false) goto L5;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.memorydata.plugin")).beginBatchEdit();
    L5:
        UnprecomputeTextOnModificationSpannable r2 = null;
        if (r0 == false) goto L84;
    L15:
        r2 = new UnprecomputeTextOnModificationSpannable((Spannable) ZeusTransformUtils.preCheckCast(r16, Spannable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L80
    L17:
        if (r2 == null) goto L28;
        EmojiSpan[] r4 = (EmojiSpan[]) ZeusTransformUtils.preCheckCast(r2.getSpans(r12, r13, EmojiSpan.class), EmojiSpan[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L80
        if (r4 == null) goto L28;
        if (r4.length <= 0) goto L28;
        int r5 = r4.length;     // Catch: Throwable -> L80
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L28;
        EmojiSpan r7 = r4[r6];     // Catch: Throwable -> L80
        int r8 = r2.getSpanStart(r7);     // Catch: Throwable -> L80
        int r9 = r2.getSpanEnd(r7);     // Catch: Throwable -> L80
        if (r8 == r13) goto L27;
        r2.removeSpan(r7);     // Catch: Throwable -> L80
    L27:
        r12 = Math.min(r8, r12);     // Catch: Throwable -> L80
        r13 = Math.max(r9, r13);     // Catch: Throwable -> L80
        r6 = r6 + 1;     // Catch: Throwable -> L80
    L28:
        if (r12 != r13) goto L30;
    L77:
        if (r0 == false) goto L79;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.memorydata.plugin")).endBatchEdit();
    L79:
        return r16;
    L30:
        if (r12 >= r16.length()) goto L77;
        if (r14 == Integer.MAX_VALUE) goto L36;
        if (r2 == null) goto L36;
        r14 = r14 - ((EmojiSpan[]) ZeusTransformUtils.preCheckCast(r2.getSpans(0, r2.length(), EmojiSpan.class), EmojiSpan[].class, "com.obric.memorydata.plugin")).length;     // Catch: Throwable -> L80
    L36:
        ProcessorSm r10 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);     // Catch: Throwable -> L80
        int r17 = Character.codePointAt(r16, r12);     // Catch: Throwable -> L80
        int r18 = 0;
        UnprecomputeTextOnModificationSpannable r3 = r2;
    L37:
        int r19 = r12;
    L38:
        if (r12 >= r13) goto L61;
        if (r18 >= r14) goto L61;
        int r20 = r10.check(r17);     // Catch: Throwable -> L80
        if (r20 != 1) goto L43;
        r19 = r19 + Character.charCount(Character.codePointAt(r16, r19));     // Catch: Throwable -> L80
        if (r19 >= r13) goto L59;
        r17 = Character.codePointAt(r16, r19);     // Catch: Throwable -> L80
    L59:
        r12 = r19;
        goto L38
    L43:
        if (r20 != 2) goto L45;
        r12 = r12 + Character.charCount(r17);     // Catch: Throwable -> L80
        if (r12 >= r13) goto L38;
        r17 = Character.codePointAt(r16, r12);     // Catch: Throwable -> L80
        goto L38
    L45:
        if (r20 != 3) goto L38;
        if (r15 == true) goto L50;
        if (hasGlyph(r16, r19, r12, r10.getFlushMetadata()) == true) goto L37;
    L50:
        if (r3 != null) goto L52;
        r3 = new UnprecomputeTextOnModificationSpannable(new SpannableString(r16));     // Catch: Throwable -> L80
    L52:
        addEmoji(r3, r10.getFlushMetadata(), r19, r12);     // Catch: Throwable -> L80
        r18 = r18 + 1;     // Catch: Throwable -> L80
    L61:
        if (r10.isInFlushableState() == false) goto L69;
        if (r18 >= r14) goto L69;
        if (r15 == false) goto L65;
    L66:
        if (r3 != null) goto L68;
        r3 = new UnprecomputeTextOnModificationSpannable(r16);     // Catch: Throwable -> L80
    L68:
        addEmoji(r3, r10.getCurrentMetadata(), r19, r12);     // Catch: Throwable -> L80
        goto L69
    L65:
        if (hasGlyph(r16, r19, r12, r10.getCurrentMetadata()) == false) goto L66;
    L69:
        if (r3 == null) goto L74;
        Spannable r110 = r3.getUnwrappedSpannable();     // Catch: Throwable -> L80
        if (r0 == false) goto L73;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.memorydata.plugin")).endBatchEdit();
    L73:
        return r110;
    L80:
        th = move-exception;
        if (r0 == false) goto L83;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.memorydata.plugin")).endBatchEdit();
    L83:
        throw th;
    L74:
        if (r0 == false) goto L76;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.memorydata.plugin")).endBatchEdit();
    L76:
        return r16;
    L84:
        if (ZeusTransformUtils.instanceOf(r16, Spannable.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r16, Spanned.class) == false) goto L17;
        if (((Spanned) ZeusTransformUtils.preCheckCast(r16, Spanned.class, "com.obric.memorydata.plugin")).nextSpanTransition(r12 - 1, r13 + 1, EmojiSpan.class) > r13) goto L17;
        r2 = new UnprecomputeTextOnModificationSpannable(r16);     // Catch: Throwable -> L80
        goto L17
    }
}
