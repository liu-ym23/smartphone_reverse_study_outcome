package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;

    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence getInitialSelectedText(@NonNull EditorInfo r10, int r11) {
            return r10.getInitialSelectedText(r11);
        }

        static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo r10, int r11, int r12) {
            return r10.getInitialTextAfterCursor(r11, r12);
        }

        static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo r10, int r11, int r12) {
            return r10.getInitialTextBeforeCursor(r11, r12);
        }

        static void setInitialSurroundingSubText(@NonNull EditorInfo r10, CharSequence r11, int r12) {
            r10.setInitialSurroundingSubText(r11, r12);
        }
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo r10) {
        if (Build.VERSION.SDK_INT < 25) goto L9;
        String[] r11 = r10.contentMimeTypes;
        if (r11 == null) goto L8;
        return r11;
    L8:
        return EMPTY_STRING_ARRAY;
    L9:
        Bundle r12 = r10.extras;
        if (r12 == null) goto L12;
        String[] r13 = r12.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (r13 != null) goto L16;
        r13 = r10.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
    L16:
        if (r13 == null) goto L19;
        return r13;
    L19:
        return EMPTY_STRING_ARRAY;
    L12:
        return EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo r10, int r11) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getInitialSelectedText(r10, r11);
    L7:
        if (r10.extras != null) goto L9;
        return null;
    L9:
        int r12 = Math.min(r10.initialSelStart, r10.initialSelEnd);
        int r13 = Math.max(r10.initialSelStart, r10.initialSelEnd);
        int r14 = r10.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r15 = r10.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r16 = r13 - r12;
        if (r10.initialSelStart >= 0) goto L12;
    L24:
        return null;
    L12:
        if (r10.initialSelEnd < 0) goto L24;
        if ((r15 - r14) != r16) goto L24;
        CharSequence r17 = r10.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r17 != null) goto L20;
        return null;
    L20:
        if ((r11 & 1) == 0) goto L23;
        return r17.subSequence(r14, r15);
    L23:
        return TextUtils.substring(r17, r14, r15);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo r10, int r11, int r12) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Bundle r13 = r10.extras;
        if (r13 != null) goto L9;
        return null;
    L9:
        CharSequence r14 = r13.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r14 != null) goto L12;
        return null;
    L12:
        int r15 = r10.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r16 = r12 & 1;
        int r17 = Math.min(r11, r14.length() - r15) + r15;
        if (r16 == 0) goto L16;
        return r14.subSequence(r15, r17);
    L16:
        return TextUtils.substring(r14, r15, r17);
    L5:
        return Api30Impl.getInitialTextAfterCursor(r10, r11, r12);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo r10, int r11, int r12) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Bundle r13 = r10.extras;
        if (r13 != null) goto L9;
        return null;
    L9:
        CharSequence r14 = r13.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r14 != null) goto L12;
        return null;
    L12:
        int r15 = r10.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r16 = r12 & 1;
        int r17 = r15 - Math.min(r11, r15);
        if (r16 == 0) goto L16;
        return r14.subSequence(r17, r15);
    L16:
        return TextUtils.substring(r14, r17, r15);
    L5:
        return Api30Impl.getInitialTextBeforeCursor(r10, r11, r12);
    }

    static int getProtocol(EditorInfo r10) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        return 1;
    L6:
        Bundle r11 = r10.extras;
        if (r11 != null) goto L9;
        return 0;
    L9:
        boolean r12 = r11.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean r13 = r10.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (r12 == false) goto L14;
        if (r13 == false) goto L14;
        return 4;
    L14:
        if (r12 == false) goto L17;
        return 3;
    L17:
        if (r13 == false) goto L20;
        return 2;
    L20:
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence r10, int r11, int r12) {
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L8;
        return false;
    L8:
        return Character.isHighSurrogate(r10.charAt(r11));
    L10:
        return Character.isLowSurrogate(r10.charAt(r11));
    }

    private static boolean isPasswordInputType(int r10) {
        int r11 = r10 & 4095;
        if (r11 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r11 == 225) goto L10;
        if (r11 == 18) goto L10;
        return false;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo r10, @Nullable String[] r11) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        r10.contentMimeTypes = r11;
        return;
    L6:
        if (r10.extras != null) goto L8;
        r10.extras = new Bundle();
    L8:
        r10.extras.putStringArray(CONTENT_MIME_TYPES_KEY, r11);
        r10.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, r11);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo r10, @NonNull CharSequence r11, int r12) {
        Preconditions.checkNotNull(r11);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setInitialSurroundingSubText(r10, r11, r12);
        return;
    L6:
        int r13 = r10.initialSelStart;
        int r14 = r10.initialSelEnd;
        if (r13 <= r14) goto L9;
        int r15 = r14 - r12;
    L10:
        if (r13 <= r14) goto L12;
        int r16 = r13 - r12;
    L13:
        int r17 = r11.length();
        if (r12 < 0) goto L28;
        if (r15 < 0) goto L28;
        if (r16 > r17) goto L28;
        if (isPasswordInputType(r10.inputType) == false) goto L23;
        setSurroundingText(r10, null, 0, 0);
        return;
    L23:
        if (r17 > 2048) goto L26;
        setSurroundingText(r10, r11, r15, r16);
        return;
    L26:
        trimLongSurroundingText(r10, r11, r15, r16);
        return;
    L28:
        setSurroundingText(r10, null, 0, 0);
        return;
    L12:
        r16 = r14 - r12;
        goto L13
    L9:
        r15 = r13 - r12;
        goto L10
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo r10, @NonNull CharSequence r11) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Api30Impl.setInitialSurroundingSubText(r10, r11, 0);
        return;
    L5:
        setInitialSurroundingSubText(r10, r11, 0);
    }

    private static void setSurroundingText(EditorInfo r10, CharSequence r11, int r12, int r13) {
        if (r10.extras != null) goto L5;
        r10.extras = new Bundle();
    L5:
        if (r11 == null) goto L7;
        SpannableStringBuilder r14 = new SpannableStringBuilder(r11);
    L8:
        r10.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, r14);
        r10.extras.putInt(CONTENT_SELECTION_HEAD_KEY, r12);
        r10.extras.putInt(CONTENT_SELECTION_END_KEY, r13);
        return;
    L7:
        r14 = null;
        goto L8
    }

    private static void trimLongSurroundingText(EditorInfo r10, CharSequence r11, int r12, int r13) {
        int r14 = r13 - r12;
        if (r14 <= 1024) goto L5;
        int r15 = 0;
    L6:
        int r16 = 2048 - r15;
        int r17 = Math.min(r11.length() - r13, r16 - Math.min(r12, (int) (((double) r16) * 0.8d)));
        int r18 = Math.min(r12, r16 - r17);
        int r19 = r12 - r18;
        if (isCutOnSurrogate(r11, r19, 0) == false) goto L10;
        r19 = r19 + 1;
        r18 = r18 - 1;
    L10:
        if (isCutOnSurrogate(r11, (r13 + r17) - 1, 1) == false) goto L12;
        r17 = r17 - 1;
    L12:
        int r20 = (r18 + r15) + r17;
        if (r15 == r14) goto L15;
        CharSequence r110 = TextUtils.concat(new CharSequence[]{r11.subSequence(r19, r19 + r18), r11.subSequence(r13, r17 + r13)});
    L16:
        int r21 = r18 + 0;
        setSurroundingText(r10, r110, r21, r15 + r21);
        return;
    L15:
        r110 = r11.subSequence(r19, r20 + r19);
        goto L16
    L5:
        r15 = r14;
        goto L6
    }
}
