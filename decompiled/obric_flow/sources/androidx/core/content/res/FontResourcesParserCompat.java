package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
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
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static int getType(TypedArray r5, int r10) {
            return r5.getType(r10);
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

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] r5) {
            this.mEntries = r5;
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

        public FontFileResourceEntry(@NonNull String r5, int r10, boolean r11, @Nullable String r12, int r13, int r14) {
            this.mFileName = r5;
            this.mWeight = r10;
            this.mItalic = r11;
            this.mVariationSettings = r12;
            this.mTtcIndex = r13;
            this.mResourceId = r14;
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

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@NonNull FontRequest r5, int r10, int r11, @Nullable String r12) {
            this.mRequest = r5;
            this.mStrategy = r10;
            this.mTimeoutMs = r11;
            this.mSystemFontFamilyName = r12;
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

        public ProviderResourceEntry(@NonNull FontRequest r5, int r10, int r11) {
            this(r5, r10, r11, null);
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray r5, int r10) {
        return Api21Impl.getType(r5, r10);
    }

    @Nullable
    public static FamilyResourceEntry parse(@NonNull XmlPullParser r5, @NonNull Resources r10) throws XmlPullParserException, IOException {
    L2:
        int r11 = r5.next();
        if (r11 == 2) goto L7;
        if (r11 != 1) goto L2;
    L7:
        if (r11 != 2) goto L11;
        return readFamilies(r5, r10);
    L11:
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> readCerts(@NonNull Resources r5, @ArrayRes int r10) {
        if (r10 == 0) goto L4;
        TypedArray r11 = r5.obtainTypedArray(r10);
    L11:
        th = move-exception;
        r11.recycle();
        throw th;
    L7:
        if (r11.length() != 0) goto L13;
        List<List<byte[]>> r12 = Collections.emptyList();     // Catch: Throwable -> L11
        r11.recycle();
        return r12;
    L13:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L11
        if (getType(r11, 0) != 1) goto L22;
        int r14 = 0;
    L17:
        if (r14 >= r11.length()) goto L23;
        int r15 = r11.getResourceId(r14, 0);     // Catch: Throwable -> L11
        if (r15 == 0) goto L21;
        r13.add(toByteArrayList(r5.getStringArray(r15)));     // Catch: Throwable -> L11
    L21:
        r14 = r14 + 1;     // Catch: Throwable -> L11
    L23:
        r11.recycle();
        return r13;
    L22:
        r13.add(toByteArrayList(r5.getStringArray(r10)));     // Catch: Throwable -> L11
        goto L23
    L4:
        return Collections.emptyList();
    }

    @Nullable
    private static FamilyResourceEntry readFamilies(XmlPullParser r5, Resources r10) throws XmlPullParserException, IOException {
        r5.require(2, null, "font-family");
        if (r5.getName().equals("font-family") == true) goto L5;
        skip(r5);
        return null;
    L5:
        return readFamily(r5, r10);
    }

    @Nullable
    private static FamilyResourceEntry readFamily(XmlPullParser r10, Resources r11) throws XmlPullParserException, IOException {
        TypedArray r5 = r11.obtainAttributes(Xml.asAttributeSet(r10), R.styleable.FontFamily);
        String r12 = r5.getString(R.styleable.FontFamily_fontProviderAuthority);
        String r13 = r5.getString(R.styleable.FontFamily_fontProviderPackage);
        String r14 = r5.getString(R.styleable.FontFamily_fontProviderQuery);
        int r15 = r5.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int r16 = r5.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int r17 = r5.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, DEFAULT_TIMEOUT_MILLIS);
        String r18 = r5.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        r5.recycle();
        if (r12 == null) goto L11;
        if (r13 == null) goto L11;
        if (r14 == null) goto L11;
    L7:
        if (r10.next() == 3) goto L10;
        skip(r10);
        goto L7
    L10:
        return new ProviderResourceEntry(new FontRequest(r12, r13, r14, readCerts(r11, r15)), r16, r17, r18);
    L11:
        ArrayList r19 = new ArrayList();
    L13:
        if (r10.next() == 3) goto L22;
        if (r10.getEventType() != 2) goto L13;
        if (r10.getName().equals("font") == true) goto L19;
        skip(r10);
        goto L13
    L19:
        r19.add(readFont(r10, r11));
        goto L13
    L22:
        if (r19.isEmpty() == false) goto L26;
        return null;
    L26:
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) r19.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser r10, Resources r11) throws XmlPullParserException, IOException {
        TypedArray r12 = r11.obtainAttributes(Xml.asAttributeSet(r10), R.styleable.FontFamilyFont);
        if (r12.hasValue(R.styleable.FontFamilyFont_fontWeight) == false) goto L5;
        int r5 = R.styleable.FontFamilyFont_fontWeight;
    L6:
        int r13 = r12.getInt(r5, NORMAL_WEIGHT);
        if (r12.hasValue(R.styleable.FontFamilyFont_fontStyle) == false) goto L9;
        int r14 = R.styleable.FontFamilyFont_fontStyle;
    L11:
        if (1 != r12.getInt(r14, 0)) goto L13;
        boolean r15 = true;
    L15:
        if (r12.hasValue(R.styleable.FontFamilyFont_ttcIndex) == false) goto L17;
        int r16 = R.styleable.FontFamilyFont_ttcIndex;
    L19:
        if (r12.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) == false) goto L21;
        int r17 = R.styleable.FontFamilyFont_fontVariationSettings;
    L22:
        String r18 = r12.getString(r17);
        int r19 = r12.getInt(r16, 0);
        if (r12.hasValue(R.styleable.FontFamilyFont_font) == false) goto L25;
        int r20 = R.styleable.FontFamilyFont_font;
    L26:
        int r21 = r12.getResourceId(r20, 0);
        String r22 = r12.getString(r20);
        r12.recycle();
    L28:
        if (r10.next() == 3) goto L31;
        skip(r10);
        goto L28
    L31:
        return new FontFileResourceEntry(r22, r13, r15, r18, r19, r21);
    L25:
        r20 = R.styleable.FontFamilyFont_android_font;
        goto L26
    L21:
        r17 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        goto L22
    L17:
        r16 = R.styleable.FontFamilyFont_android_ttcIndex;
        goto L19
    L13:
        r15 = false;
        goto L15
    L9:
        r14 = R.styleable.FontFamilyFont_android_fontStyle;
        goto L11
    L5:
        r5 = R.styleable.FontFamilyFont_android_fontWeight;
        goto L6
    }

    private static void skip(XmlPullParser r5) throws XmlPullParserException, IOException {
        int r10 = 1;
    L3:
        if (r10 <= 0) goto L11;
        int r11 = r5.next();
        if (r11 != 2) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        if (r11 != 3) goto L3;
        r10 = r10 - 1;
        goto L3
    }

    private static List<byte[]> toByteArrayList(String[] r5) {
        ArrayList r10 = new ArrayList();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(Base64.decode(r5[r12], 0));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }
}
