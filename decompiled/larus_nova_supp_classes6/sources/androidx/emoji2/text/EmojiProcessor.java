package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

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

    private void initExclusions(Set<int[]> r9) {
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<int[]> r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        int[] r0 = r10.next();
        String r2 = new String(r0, 0, r0.length);
        MarkExclusionCallback r7 = new MarkExclusionCallback(r2);
        process(r2, 0, r2.length(), 1, true, r7);
        goto L7
    }

    public int getEmojiMatch(CharSequence r2) {
        return getEmojiMatch(r2, this.mMetadataRepo.getMetadataVersion());
    }

    public int getEmojiEnd(CharSequence r10, int r11) {
        if (r11 >= 0) goto L4;
        return -1;
    L4:
        if (r11 < r10.length()) goto L7;
        return -1;
    L7:
        if ((r10 instanceof Spanned) == false) goto L13;
        Spanned r0 = (Spanned) r10;
        EmojiSpan[] r2 = (EmojiSpan[]) r0.getSpans(r11, r11 + 1, EmojiSpan.class);
        if (r2.length <= 0) goto L13;
        return r0.getSpanEnd(r2[0]);
    L13:
        return ((EmojiProcessLookupCallback) process(r10, Math.max(0, r11 - 16), Math.min(r10.length(), r11 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(r11))).end;
    }

    public int getEmojiMatch(CharSequence r12, int r13) {
        ProcessorSm r0 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r1 = r12.length();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3 >= r1) goto L20;
        int r8 = Character.codePointAt(r12, r3);
        int r9 = r0.check(r8);
        TypefaceEmojiRasterizer r10 = r0.getCurrentMetadata();
        if (r9 == 1) goto L15;
        if (r9 != 2) goto L9;
        r3 = r3 + Character.charCount(r8);
    L16:
        if (r10 == null) goto L4;
        if (r10.getCompatAdded() > r13) goto L4;
        r5 = r5 + 1;
        goto L4
    L9:
        if (r9 != 3) goto L16;
        r10 = r0.getFlushMetadata();
        if (r10.getCompatAdded() > r13) goto L16;
        r4 = r4 + 1;
        goto L16
    L15:
        r3 = r3 + Character.charCount(r8);
        r5 = 0;
        goto L16
    L20:
        if (r4 == 0) goto L23;
        return 2;
    L23:
        if (r0.isInFlushableState() == true) goto L25;
    L27:
        if (r5 != 0) goto L29;
        return 0;
    L29:
        return 2;
    L25:
        if (r0.getCurrentMetadata().getCompatAdded() > r13) goto L27;
        return 1;
    }

    public int getEmojiStart(CharSequence r10, int r11) {
        if (r11 >= 0) goto L4;
        return -1;
    L4:
        if (r11 < r10.length()) goto L7;
        return -1;
    L7:
        if ((r10 instanceof Spanned) == false) goto L13;
        Spanned r0 = (Spanned) r10;
        EmojiSpan[] r2 = (EmojiSpan[]) r0.getSpans(r11, r11 + 1, EmojiSpan.class);
        if (r2.length <= 0) goto L13;
        return r0.getSpanStart(r2[0]);
    L13:
        return ((EmojiProcessLookupCallback) process(r10, Math.max(0, r11 - 16), Math.min(r10.length(), r11 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(r11))).start;
    }

    private static boolean delete(Editable r6, KeyEvent r7, boolean r8) {
        if (hasModifiers(r7) == false) goto L5;
        return false;
    L5:
        int r9 = Selection.getSelectionStart(r6);
        int r1 = Selection.getSelectionEnd(r6);
        if (hasInvalidSelection(r9, r1) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r2 = (EmojiSpan[]) r6.getSpans(r9, r1, EmojiSpan.class);
        if (r2 != null) goto L11;
    L24:
        return false;
    L11:
        if (r2.length <= 0) goto L24;
        int r3 = r2.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L24;
        EmojiSpan r5 = r2[r4];
        int r10 = r6.getSpanStart(r5);
        int r11 = r6.getSpanEnd(r5);
        if (r8 == false) goto L17;
        if (r10 != r9) goto L17;
    L21:
        r6.delete(r10, r11);
        return true;
    L17:
        if (r8 == true) goto L19;
        if (r11 == r9) goto L21;
    L19:
        if (r9 <= r10) goto L23;
        if (r9 < r11) goto L21;
    L23:
        r4 = r4 + 1;
        goto L13
    }

    public static boolean handleOnKeyDown(Editable r3, int r4, KeyEvent r5) {
        if (r4 != 67) goto L5;
        boolean r6 = delete(r3, r5, false);
    L9:
        if (r6 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r3);
        return true;
    L12:
        return false;
    L5:
        if (r4 == 112) goto L7;
        r6 = false;
        goto L9
    L7:
        r6 = delete(r3, r5, true);
        goto L9
    }

    private boolean hasGlyph(CharSequence r3, int r4, int r5, TypefaceEmojiRasterizer r6) {
        if (r6.getHasGlyph() != 0) goto L6;
        r6.setHasGlyph(this.mGlyphChecker.hasGlyph(r3, r4, r5, r6.getSdkAdded()));
    L6:
        if (r6.getHasGlyph() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean handleDeleteSurroundingText(InputConnection r5, Editable r6, int r7, int r8, boolean r9) {
        if (r6 == null) goto L27;
        if (r5 == null) goto L27;
        if (r7 < 0) goto L27;
        if (r8 < 0) goto L27;
        int r1 = Selection.getSelectionStart(r6);
        int r2 = Selection.getSelectionEnd(r6);
        if (hasInvalidSelection(r1, r2) == false) goto L12;
        return false;
    L12:
        if (r9 == false) goto L17;
        int r10 = CodepointIndexFinder.findIndexBackward(r6, r1, Math.max(r7, 0));
        int r11 = CodepointIndexFinder.findIndexForward(r6, r2, Math.max(r8, 0));
        if (r10 == (-1)) goto L16;
        if (r11 == (-1)) goto L16;
    L18:
        EmojiSpan[] r12 = (EmojiSpan[]) r6.getSpans(r10, r11, EmojiSpan.class);
        if (r12 == null) goto L27;
        if (r12.length <= 0) goto L27;
        int r3 = r12.length;
        int r4 = 0;
    L23:
        if (r4 >= r3) goto L25;
        EmojiSpan r13 = r12[r4];
        int r14 = r6.getSpanStart(r13);
        int r15 = r6.getSpanEnd(r13);
        r10 = Math.min(r14, r10);
        r11 = Math.max(r15, r11);
        r4 = r4 + 1;
        goto L23
    L25:
        int r16 = Math.max(r10, 0);
        int r17 = Math.min(r11, r6.length());
        r5.beginBatchEdit();
        r6.delete(r16, r17);
        r5.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r10 = Math.max(r1 - r7, 0);
        r11 = Math.min(r2 + r8, r6.length());
    L27:
        return false;
    }

    public CharSequence process(CharSequence r10, int r11, int r12, int r13, boolean r14) {
        boolean r0 = r10 instanceof SpannableBuilder;
        if (r0 == false) goto L5;
        ((SpannableBuilder) r10).beginBatchEdit();
    L5:
        if (r0 == false) goto L53;
    L15:
        UnprecomputeTextOnModificationSpannable r1 = new UnprecomputeTextOnModificationSpannable((Spannable) r10);     // Catch: Throwable -> L49
    L17:
        if (r1 == null) goto L28;
        EmojiSpan[] r3 = (EmojiSpan[]) r1.getSpans(r11, r12, EmojiSpan.class);     // Catch: Throwable -> L49
        if (r3 == null) goto L28;
        if (r3.length <= 0) goto L28;
        int r4 = r3.length;     // Catch: Throwable -> L49
        int r5 = 0;
    L23:
        if (r5 >= r4) goto L28;
        EmojiSpan r6 = r3[r5];     // Catch: Throwable -> L49
        int r7 = r1.getSpanStart(r6);     // Catch: Throwable -> L49
        int r8 = r1.getSpanEnd(r6);     // Catch: Throwable -> L49
        if (r7 == r12) goto L27;
        r1.removeSpan(r6);     // Catch: Throwable -> L49
    L27:
        r11 = Math.min(r7, r11);     // Catch: Throwable -> L49
        r12 = Math.max(r8, r12);     // Catch: Throwable -> L49
        r5 = r5 + 1;     // Catch: Throwable -> L49
    L28:
        int r9 = r11;
        int r15 = r12;
        if (r9 != r15) goto L31;
    L46:
        if (r0 == false) goto L48;
        ((SpannableBuilder) r10).endBatchEdit();
    L48:
        return r10;
    L31:
        if (r9 >= r10.length()) goto L46;
        if (r13 == Integer.MAX_VALUE) goto L37;
        if (r1 == null) goto L37;
        r13 = r13 - ((EmojiSpan[]) r1.getSpans(0, r1.length(), EmojiSpan.class)).length;     // Catch: Throwable -> L49
    L37:
        UnprecomputeTextOnModificationSpannable r16 = (UnprecomputeTextOnModificationSpannable) process(r10, r9, r15, r13, r14, new EmojiProcessAddSpanCallback(r1, this.mSpanFactory));     // Catch: Throwable -> L49
        if (r16 == null) goto L43;
        Spannable r17 = r16.getUnwrappedSpannable();     // Catch: Throwable -> L49
        if (r0 == false) goto L42;
        ((SpannableBuilder) r10).endBatchEdit();
    L42:
        return r17;
    L49:
        th = move-exception;
        if (r0 == false) goto L52;
        ((SpannableBuilder) r10).endBatchEdit();
    L52:
        throw th;
    L43:
        if (r0 == false) goto L45;
        ((SpannableBuilder) r10).endBatchEdit();
    L45:
        return r10;
    L53:
        if ((r10 instanceof Spannable) == true) goto L15;
        if ((r10 instanceof Spanned) == true) goto L12;
    L14:
        r1 = null;
        goto L17
    L12:
        if (((Spanned) r10).nextSpanTransition(r11 - 1, r12 + 1, EmojiSpan.class) > r12) goto L14;
        r1 = new UnprecomputeTextOnModificationSpannable(r10);     // Catch: Throwable -> L49
        goto L17
    }

    public EmojiProcessor(MetadataRepo r1, EmojiCompat.SpanFactory r2, EmojiCompat.GlyphChecker r3, boolean r4, int[] r5, Set<int[]> r6) {
        this.mSpanFactory = r2;
        this.mMetadataRepo = r1;
        this.mGlyphChecker = r3;
        this.mUseEmojiAsDefaultStyle = r4;
        this.mEmojiAsDefaultStyleExceptions = r5;
        initExclusions(r6);
    }

    private <T> T process(CharSequence r9, int r10, int r11, int r12, boolean r13, EmojiProcessCallback<T> r14) {
        ProcessorSm r0 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r2 = Character.codePointAt(r9, r10);
        int r4 = 0;
        boolean r5 = true;
    L3:
        int r1 = r10;
    L4:
        if (r10 >= r11) goto L26;
        if (r4 >= r12) goto L26;
        if (r5 == false) goto L26;
        int r6 = r0.check(r2);
        if (r6 != 1) goto L10;
        r1 = r1 + Character.charCount(Character.codePointAt(r9, r1));
        if (r1 >= r11) goto L24;
        r2 = Character.codePointAt(r9, r1);
    L24:
        r10 = r1;
        goto L4
    L10:
        if (r6 != 2) goto L12;
        r10 = r10 + Character.charCount(r2);
        if (r10 >= r11) goto L4;
        r2 = Character.codePointAt(r9, r10);
        goto L4
    L12:
        if (r6 != 3) goto L4;
        if (r13 == true) goto L17;
        if (hasGlyph(r9, r1, r10, r0.getFlushMetadata()) == true) goto L3;
    L17:
        r4 = r4 + 1;
        r5 = r14.handleEmoji(r9, r1, r10, r0.getFlushMetadata());
    L26:
        if (r0.isInFlushableState() == false) goto L34;
        if (r4 >= r12) goto L34;
        if (r5 == false) goto L34;
        if (r13 == false) goto L31;
    L32:
        r14.handleEmoji(r9, r1, r10, r0.getCurrentMetadata());
        goto L34
    L31:
        if (hasGlyph(r9, r1, r10, r0.getCurrentMetadata()) == false) goto L32;
    L34:
        return (T) r14.getResult();
    }
}
