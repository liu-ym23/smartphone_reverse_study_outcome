package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence getInitialSelectedText(EditorInfo r0, int r1) {
            return r0.getInitialSelectedText(r1);
        }

        static CharSequence getInitialTextAfterCursor(EditorInfo r0, int r1, int r2) {
            return r0.getInitialTextAfterCursor(r1, r2);
        }

        static CharSequence getInitialTextBeforeCursor(EditorInfo r0, int r1, int r2) {
            return r0.getInitialTextBeforeCursor(r1, r2);
        }

        static void setInitialSurroundingSubText(EditorInfo r2, CharSequence r3, int r4) {
            r2.setInitialSurroundingSubText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    public static String[] getContentMimeTypes(EditorInfo r2) {
        if (Build.VERSION.SDK_INT < 25) goto L10;
        String[] r3 = r2.contentMimeTypes;
        if (r3 == null) goto L8;
        return r3;
    L8:
        return EMPTY_STRING_ARRAY;
    L10:
        if (r2.extras == null) goto L12;
        String[] r0 = r2.extras.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (r0 != null) goto L16;
        r0 = r2.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
    L16:
        if (r0 == null) goto L19;
        return r0;
    L19:
        return EMPTY_STRING_ARRAY;
    L12:
        return EMPTY_STRING_ARRAY;
    }

    public static CharSequence getInitialSelectedText(EditorInfo r6, int r7) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getInitialSelectedText(r6, r7);
    L7:
        if (r6.extras != null) goto L9;
        return null;
    L9:
        int r0 = Math.min(r6.initialSelStart, r6.initialSelEnd);
        int r2 = Math.max(r6.initialSelStart, r6.initialSelEnd);
        int r3 = r6.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r4 = r6.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r5 = r2 - r0;
        if (r6.initialSelStart >= 0) goto L12;
    L24:
        return null;
    L12:
        if (r6.initialSelEnd < 0) goto L24;
        if ((r4 - r3) != r5) goto L24;
        CharSequence r8 = r6.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r8 != null) goto L20;
        return null;
    L20:
        if ((r7 & 1) == 0) goto L23;
        return r8.subSequence(r3, r4);
    L23:
        return TextUtils.substring(r8, r3, r4);
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getInitialTextAfterCursor(r3, r4, r5);
    L7:
        if (r3.extras != null) goto L9;
        return null;
    L9:
        CharSequence r0 = r3.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r0 != null) goto L12;
        return null;
    L12:
        int r6 = r3.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r7 = r5 & 1;
        int r8 = Math.min(r4, r0.length() - r6) + r6;
        if (r7 == 0) goto L16;
        return r0.subSequence(r6, r8);
    L16:
        return TextUtils.substring(r0, r6, r8);
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getInitialTextBeforeCursor(r3, r4, r5);
    L7:
        if (r3.extras != null) goto L9;
        return null;
    L9:
        CharSequence r0 = r3.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r0 != null) goto L12;
        return null;
    L12:
        int r6 = r3.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r7 = r5 & 1;
        int r8 = r6 - Math.min(r4, r6);
        if (r7 == 0) goto L16;
        return r0.subSequence(r8, r6);
    L16:
        return TextUtils.substring(r0, r8, r6);
    }

    static int getProtocol(EditorInfo r3) {
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return 1;
    L7:
        if (r3.extras != null) goto L9;
        return 0;
    L9:
        boolean r0 = r3.extras.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean r4 = r3.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (r0 == false) goto L14;
        if (r4 == false) goto L14;
        return 4;
    L14:
        if (r0 == false) goto L17;
        return 3;
    L17:
        if (r4 == false) goto L20;
        return 2;
    L20:
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 == 0) goto L11;
        if (r4 == 1) goto L9;
        return false;
    L9:
        return Character.isHighSurrogate(r5.charAt(r3));
    L11:
        return Character.isLowSurrogate(r5.charAt(r3));
    }

    private static boolean isPasswordInputType(int r1) {
        int r2 = r1 & 4095;
        if (r2 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 225) goto L10;
        if (r2 == 18) goto L10;
        return false;
    }

    public static void setContentMimeTypes(EditorInfo r2, String[] r3) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        r2.contentMimeTypes = r3;
        return;
    L6:
        if (r2.extras != null) goto L8;
        r2.extras = new Bundle();
    L8:
        r2.extras.putStringArray(CONTENT_MIME_TYPES_KEY, r3);
        r2.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, r3);
    }

    public static void setInitialSurroundingSubText(EditorInfo r5, CharSequence r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Preconditions.checkNotNull(r8);
        if (Build.VERSION.SDK_INT < 30) goto L7;
        Api30Impl.setInitialSurroundingSubText(r5, r8, r7);
        return;
    L7:
        if (r5.initialSelStart <= r5.initialSelEnd) goto L9;
        int r0 = r5.initialSelEnd;
    L10:
        int r1 = r0 - r7;
        if (r5.initialSelStart <= r5.initialSelEnd) goto L13;
        int r2 = r5.initialSelStart;
    L14:
        int r3 = r2 - r7;
        int r4 = r8.length();
        if (r7 < 0) goto L29;
        if (r1 < 0) goto L29;
        if (r3 > r4) goto L29;
        if (isPasswordInputType(r5.inputType) == false) goto L24;
        setSurroundingText(r5, null, 0, 0);
        return;
    L24:
        if (r4 > 2048) goto L27;
        setSurroundingText(r5, r8, r1, r3);
        return;
    L27:
        trimLongSurroundingText(r5, r8, r1, r3);
        return;
    L29:
        setSurroundingText(r5, null, 0, 0);
        return;
    L13:
        r2 = r5.initialSelEnd;
        goto L14
    L9:
        r0 = r5.initialSelStart;
        goto L10
    }

    public static void setInitialSurroundingText(EditorInfo r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Api30Impl.setInitialSurroundingSubText(r3, r5, 0);
        return;
    L5:
        setInitialSurroundingSubText(r3, r5, 0);
    }

    private static void setSurroundingText(EditorInfo r2, CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2.extras != null) goto L5;
        r2.extras = new Bundle();
    L5:
        if (r6 == null) goto L7;
        SpannableStringBuilder r0 = new SpannableStringBuilder(r6);
    L8:
        r2.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, r0);
        r2.extras.putInt(CONTENT_SELECTION_HEAD_KEY, r4);
        r2.extras.putInt(CONTENT_SELECTION_END_KEY, r5);
        return;
    L7:
        r0 = null;
        goto L8
    }

    private static void trimLongSurroundingText(EditorInfo r9, CharSequence r10, int r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r12 - r11;
        if (r0 <= 1024) goto L5;
        int r2 = 0;
    L6:
        int r4 = 2048 - r2;
        int r3 = Math.min(r13.length() - r12, r4 - Math.min(r11, (int) (((double) r4) * 0.8d)));
        int r5 = Math.min(r11, r4 - r3);
        int r14 = r11 - r5;
        if (isCutOnSurrogate(r13, r14, 0) == false) goto L10;
        r14 = r14 + 1;
        r5 = r5 - 1;
    L10:
        if (isCutOnSurrogate(r13, (r12 + r3) - 1, 1) == false) goto L12;
        r3 = r3 - 1;
    L12:
        int r6 = (r5 + r2) + r3;
        if (r2 == r0) goto L15;
        CharSequence r15 = TextUtils.concat(new CharSequence[]{r13.subSequence(r14, r14 + r5), r13.subSequence(r12, r3 + r12)});
    L16:
        int r7 = r5 + 0;
        setSurroundingText(r9, r15, r7, r2 + r7);
        return;
    L15:
        r15 = r13.subSequence(r14, r6 + r14);
        goto L16
    L5:
        r2 = r0;
        goto L6
    }
}
