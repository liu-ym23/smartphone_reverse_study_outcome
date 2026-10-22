package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
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
    private static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static CharSequence getInitialSelectedText(@NonNull EditorInfo r5, int r10) {
            return r5.getInitialSelectedText(r10);
        }

        public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo r5, int r10, int r11) {
            return r5.getInitialTextAfterCursor(r10, r11);
        }

        public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo r5, int r10, int r11) {
            return r5.getInitialTextBeforeCursor(r10, r11);
        }

        public static void setInitialSurroundingSubText(@NonNull EditorInfo r5, CharSequence r10, int r11) {
            r5.setInitialSurroundingSubText(r10, r11);
        }
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo r5) {
        String[] r10 = r5.contentMimeTypes;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo r5, int r10) {
        return Api30Impl.getInitialSelectedText(r5, r10);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo r5, int r10, int r11) {
        return Api30Impl.getInitialTextAfterCursor(r5, r10, r11);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo r5, int r10, int r11) {
        return Api30Impl.getInitialTextBeforeCursor(r5, r10, r11);
    }

    public static int getProtocol(EditorInfo r5) {
        return 1;
    }

    private static boolean isCutOnSurrogate(CharSequence r5, int r10, int r11) {
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L8;
        return false;
    L8:
        return Character.isHighSurrogate(r5.charAt(r10));
    L10:
        return Character.isLowSurrogate(r5.charAt(r10));
    }

    private static boolean isPasswordInputType(int r5) {
        int r10 = r5 & 4095;
        if (r10 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r10 == 225) goto L10;
        if (r10 == 18) goto L10;
        return false;
    }

    public static boolean isStylusHandwritingEnabled(@NonNull EditorInfo r5) {
        Bundle r10 = r5.extras;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
    }

    public static void setContentMimeTypes(@NonNull EditorInfo r5, @Nullable String[] r10) {
        r5.contentMimeTypes = r10;
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo r5, @NonNull CharSequence r10, int r11) {
        Preconditions.checkNotNull(r10);
        Api30Impl.setInitialSurroundingSubText(r5, r10, r11);
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo r5, @NonNull CharSequence r10) {
        Api30Impl.setInitialSurroundingSubText(r5, r10, 0);
    }

    public static void setStylusHandwritingEnabled(@NonNull EditorInfo r5, boolean r10) {
        if (r5.extras != null) goto L5;
        r5.extras = new Bundle();
    L5:
        r5.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, r10);
    }

    private static void setSurroundingText(EditorInfo r5, CharSequence r10, int r11, int r12) {
        if (r5.extras != null) goto L5;
        r5.extras = new Bundle();
    L5:
        if (r10 == null) goto L7;
        SpannableStringBuilder r13 = new SpannableStringBuilder(r10);
    L8:
        r5.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, r13);
        r5.extras.putInt(CONTENT_SELECTION_HEAD_KEY, r11);
        r5.extras.putInt(CONTENT_SELECTION_END_KEY, r12);
        return;
    L7:
        r13 = null;
        goto L8
    }

    private static void trimLongSurroundingText(EditorInfo r10, CharSequence r11, int r12, int r13) {
        int r5 = r13 - r12;
        if (r5 <= 1024) goto L5;
        int r14 = 0;
    L6:
        int r15 = 2048 - r14;
        int r16 = Math.min(r11.length() - r13, r15 - Math.min(r12, (int) (((double) r15) * 0.8d)));
        int r17 = Math.min(r12, r15 - r16);
        int r18 = r12 - r17;
        if (isCutOnSurrogate(r11, r18, 0) == false) goto L10;
        r18 = r18 + 1;
        r17 = r17 - 1;
    L10:
        if (isCutOnSurrogate(r11, (r13 + r16) - 1, 1) == false) goto L12;
        r16 = r16 - 1;
    L12:
        int r19 = (r17 + r14) + r16;
        if (r14 == r5) goto L15;
        CharSequence r110 = TextUtils.concat(new CharSequence[]{r11.subSequence(r18, r18 + r17), r11.subSequence(r13, r16 + r13)});
    L16:
        setSurroundingText(r10, r110, r17, r14 + r17);
        return;
    L15:
        r110 = r11.subSequence(r18, r19 + r18);
        goto L16
    L5:
        r14 = r5;
        goto L6
    }
}
