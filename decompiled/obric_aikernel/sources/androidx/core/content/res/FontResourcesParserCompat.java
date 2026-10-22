package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getType(TypedArray r10, int r11) {
            return r10.getType(r11);
        }
    }

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        @NonNull
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] r10) {
            this.mEntries = r10;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {

        @NonNull
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public FontFileResourceEntry(@NonNull String r10, int r11, boolean r12, @Nullable String r13, int r14, int r15) {
            this.mFileName = r10;
            this.mWeight = r11;
            this.mItalic = r12;
            this.mVariationSettings = r13;
            this.mTtcIndex = r14;
            this.mResourceId = r15;
        }

        @NonNull
        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @Nullable
        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        @NonNull
        private final FontRequest mRequest;
        private final int mStrategy;

        @Nullable
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(@NonNull FontRequest r10, int r11, int r12) {
            this(r10, r11, r12, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@NonNull FontRequest r10, int r11, int r12, @Nullable String r13) {
            this.mRequest = r10;
            this.mStrategy = r11;
            this.mTimeoutMs = r12;
            this.mSystemFontFamilyName = r13;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.mRequest;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray r10, int r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        TypedValue r12 = new TypedValue();
        r10.getValue(r11, r12);
        return r12.type;
    L5:
        return Api21Impl.getType(r10, r11);
    }

    @Nullable
    public static FamilyResourceEntry parse(@NonNull XmlPullParser r10, @NonNull Resources r11) {
    L2:
        int r12 = r10.next();
        if (r12 == 2) goto L7;
        if (r12 != 1) goto L2;
    L7:
        if (r12 != 2) goto L11;
        return readFamilies(r10, r11);
    L11:
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> readCerts(@NonNull Resources r10, @ArrayRes int r11) {
        if (r11 == 0) goto L4;
        TypedArray r12 = r10.obtainTypedArray(r11);
    L23:
        th = move-exception;
        r12.recycle();
        throw th;
    L7:
        if (r12.length() != 0) goto L11;
        List<List<byte[]>> r13 = Collections.emptyList();     // Catch: Throwable -> L23
        r12.recycle();
        return r13;
    L11:
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L23
        if (getType(r12, 0) != 1) goto L20;
        int r15 = 0;
    L15:
        if (r15 >= r12.length()) goto L21;
        int r16 = r12.getResourceId(r15, 0);     // Catch: Throwable -> L23
        if (r16 == 0) goto L19;
        r14.add(toByteArrayList(r10.getStringArray(r16)));     // Catch: Throwable -> L23
    L19:
        r15 = r15 + 1;     // Catch: Throwable -> L23
    L21:
        r12.recycle();
        return r14;
    L20:
        r14.add(toByteArrayList(r10.getStringArray(r11)));     // Catch: Throwable -> L23
        goto L21
    L4:
        return Collections.emptyList();
    }

    @Nullable
    private static FamilyResourceEntry readFamilies(XmlPullParser r10, Resources r11) {
        r10.require(2, null, "font-family");
        if (r10.getName().equals("font-family") == true) goto L5;
        skip(r10);
        return null;
    L5:
        return readFamily(r10, r11);
    }

    @Nullable
    private static FamilyResourceEntry readFamily(XmlPullParser r10, Resources r11) {
        TypedArray r12 = r11.obtainAttributes(Xml.asAttributeSet(r10), R.styleable.FontFamily);
        String r13 = r12.getString(R.styleable.FontFamily_fontProviderAuthority);
        String r14 = r12.getString(R.styleable.FontFamily_fontProviderPackage);
        String r15 = r12.getString(R.styleable.FontFamily_fontProviderQuery);
        int r16 = r12.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int r17 = r12.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int r18 = r12.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String r19 = r12.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        r12.recycle();
        if (r13 == null) goto L11;
        if (r14 == null) goto L11;
        if (r15 == null) goto L11;
    L7:
        if (r10.next() == 3) goto L10;
        skip(r10);
        goto L7
    L10:
        return new ProviderResourceEntry(new FontRequest(r13, r14, r15, readCerts(r11, r16)), r17, r18, r19);
    L11:
        ArrayList r20 = new ArrayList();
    L13:
        if (r10.next() == 3) goto L22;
        if (r10.getEventType() != 2) goto L13;
        if (r10.getName().equals("font") == true) goto L19;
        skip(r10);
        goto L13
    L19:
        r20.add(readFont(r10, r11));
        goto L13
    L22:
        if (r20.isEmpty() == false) goto L26;
        return null;
    L26:
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) r20.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser r10, Resources r11) {
        TypedArray r12 = r11.obtainAttributes(Xml.asAttributeSet(r10), R.styleable.FontFamilyFont);
        int r13 = R.styleable.FontFamilyFont_fontWeight;
        if (r12.hasValue(r13) == true) goto L6;
        r13 = R.styleable.FontFamilyFont_android_fontWeight;
    L6:
        int r14 = r12.getInt(r13, 400);
        int r15 = R.styleable.FontFamilyFont_fontStyle;
        if (r12.hasValue(r15) == true) goto L11;
        r15 = R.styleable.FontFamilyFont_android_fontStyle;
    L11:
        if (1 != r12.getInt(r15, 0)) goto L13;
        boolean r16 = true;
    L14:
        int r17 = R.styleable.FontFamilyFont_ttcIndex;
        if (r12.hasValue(r17) == true) goto L18;
        r17 = R.styleable.FontFamilyFont_android_ttcIndex;
    L18:
        int r18 = R.styleable.FontFamilyFont_fontVariationSettings;
        if (r12.hasValue(r18) == true) goto L22;
        r18 = R.styleable.FontFamilyFont_android_fontVariationSettings;
    L22:
        String r19 = r12.getString(r18);
        int r20 = r12.getInt(r17, 0);
        int r21 = R.styleable.FontFamilyFont_font;
        if (r12.hasValue(r21) == true) goto L26;
        r21 = R.styleable.FontFamilyFont_android_font;
    L26:
        int r22 = r12.getResourceId(r21, 0);
        String r23 = r12.getString(r21);
        r12.recycle();
    L28:
        if (r10.next() == 3) goto L31;
        skip(r10);
        goto L28
    L31:
        return new FontFileResourceEntry(r23, r14, r16, r19, r20, r22);
    L13:
        r16 = false;
        goto L14
    }

    private static void skip(XmlPullParser r10) {
        int r11 = 1;
    L3:
        if (r11 <= 0) goto L11;
        int r12 = r10.next();
        if (r12 != 2) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        if (r12 != 3) goto L3;
        r11 = r11 - 1;
        goto L3
    }

    private static List<byte[]> toByteArrayList(String[] r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(Base64.decode(r10[r13], 0));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }
}
