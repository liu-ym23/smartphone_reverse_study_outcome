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
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import com.bytedance.common.wschannel.WsConstants;
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
        public FontFamilyResult(int r5, @Nullable FontInfo[] r10) {
            this.mStatusCode = r5;
            this.mFonts = r10;
        }

        public static FontFamilyResult create(int r5, @Nullable FontInfo[] r10) {
            return new FontFamilyResult(r5, r10);
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
        public FontInfo(@NonNull Uri r5, @IntRange(from = 0) int r10, @IntRange(from = 1, to = WsConstants.RELEASE_DELAY) int r11, boolean r12, int r13) {
            this.mUri = (Uri) Preconditions.checkNotNull(r5);
            this.mTtcIndex = r10;
            this.mWeight = r11;
            this.mItalic = r12;
            this.mResultCode = r13;
        }

        public static FontInfo create(@NonNull Uri r10, @IntRange(from = 0) int r11, @IntRange(from = 1, to = WsConstants.RELEASE_DELAY) int r12, boolean r13, int r14) {
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

        @IntRange(from = 1, to = WsConstants.RELEASE_DELAY)
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

        public void onTypefaceRequestFailed(int r5) {
        }

        public void onTypefaceRetrieved(Typeface r5) {
        }
    }

    private FontsContractCompat() {
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context r5, @Nullable CancellationSignal r10, @NonNull FontInfo[] r11) {
        return TypefaceCompat.createFromFontInfo(r5, r10, r11, 0);
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context r5, @Nullable CancellationSignal r10, @NonNull FontRequest r11) throws PackageManager.NameNotFoundException {
        return FontProvider.getFontFamilyResult(r5, r11, r10);
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
    public static ProviderInfo getProvider(@NonNull PackageManager r5, @NonNull FontRequest r10, @Nullable Resources r11) throws PackageManager.NameNotFoundException {
        return FontProvider.getProvider(r5, r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context r5, FontInfo[] r10, CancellationSignal r11) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(r5, r10, r11);
    }

    public static void requestFont(@NonNull Context r5, @NonNull FontRequest r10, @NonNull FontRequestCallback r11, @NonNull Handler r12) {
        CallbackWithHandler r13 = new CallbackWithHandler(r11);
        Executor r14 = RequestExecutor.createHandlerExecutor(r12);
        FontRequestWorker.requestFontAsync(r5.getApplicationContext(), r10, 0, r14, r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface requestFont(@NonNull Context r5, @NonNull FontRequest r10, int r11, boolean r12, @IntRange(from = 0) int r13, @NonNull Handler r14, @NonNull FontRequestCallback r15) {
        CallbackWithHandler r16 = new CallbackWithHandler(r15, r14);
        if (r12 == false) goto L7;
        return FontRequestWorker.requestFontSync(r5, r10, r16, r11, r13);
    L7:
        return FontRequestWorker.requestFontAsync(r5, r10, r11, null, r16);
    }
}
