package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FontsContractCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";

        public Columns() {
        }
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public FontFamilyResult(int r10, @Nullable FontInfo[] r11) {
            this.mStatusCode = r10;
            this.mFonts = r11;
        }

        static FontFamilyResult create(int r10, @Nullable FontInfo[] r11) {
            return new FontFamilyResult(r10, r11);
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public FontInfo(@NonNull Uri r10, @IntRange(from = 0) int r11, @IntRange(from = 1, to = 1000) int r12, boolean r13, int r14) {
            this.mUri = (Uri) Preconditions.checkNotNull(r10);
            this.mTtcIndex = r11;
            this.mWeight = r12;
            this.mItalic = r13;
            this.mResultCode = r14;
        }

        static FontInfo create(@NonNull Uri r10, @IntRange(from = 0) int r11, @IntRange(from = 1, to = 1000) int r12, boolean r13, int r14) {
            return new FontInfo(r10, r11, r12, r13, r14);
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @NonNull
        public Uri getUri() {
            return this.mUri;
        }

        @IntRange(from = 1, to = 1000)
        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static final int RESULT_OK = 0;
        static final int RESULT_SUCCESS = 0;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public FontRequestCallback() {
        }

        public void onTypefaceRequestFailed(int r10) {
        }

        public void onTypefaceRetrieved(Typeface r10) {
        }
    }

    private FontsContractCompat() {
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context r10, @Nullable CancellationSignal r11, @NonNull FontInfo[] r12) {
        return TypefaceCompat.createFromFontInfo(r10, r11, r12, 0);
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context r10, @Nullable CancellationSignal r11, @NonNull FontRequest r12) {
        return FontProvider.getFontFamilyResult(r10, r12, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface getFontSync(Context r10, FontRequest r11, @Nullable ResourcesCompat.FontCallback r12, @Nullable Handler r13, boolean r14, int r15, int r16) {
        TypefaceCompat.ResourcesCallbackAdapter r17 = new TypefaceCompat.ResourcesCallbackAdapter(r12);
        return requestFont(r10, r11, r16, r14, r15, ResourcesCompat.FontCallback.getHandler(r13), r17);
    }

    @VisibleForTesting
    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ProviderInfo getProvider(@NonNull PackageManager r10, @NonNull FontRequest r11, @Nullable Resources r12) {
        return FontProvider.getProvider(r10, r11, r12);
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context r10, FontInfo[] r11, CancellationSignal r12) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(r10, r11, r12);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface requestFont(@NonNull Context r10, @NonNull FontRequest r11, int r12, boolean r13, @IntRange(from = 0) int r14, @NonNull Handler r15, @NonNull FontRequestCallback r16) {
        CallbackWithHandler r17 = new CallbackWithHandler(r16, r15);
        if (r13 == false) goto L7;
        return FontRequestWorker.requestFontSync(r10, r11, r17, r12, r14);
    L7:
        return FontRequestWorker.requestFontAsync(r10, r11, r12, null, r17);
    }

    public static void requestFont(@NonNull Context r10, @NonNull FontRequest r11, @NonNull FontRequestCallback r12, @NonNull Handler r13) {
        CallbackWithHandler r14 = new CallbackWithHandler(r12);
        Executor r15 = RequestExecutor.createHandlerExecutor(r13);
        FontRequestWorker.requestFontAsync(r10.getApplicationContext(), r11, 0, r15, r14);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }
}
