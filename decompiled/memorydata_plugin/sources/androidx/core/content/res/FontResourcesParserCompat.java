package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.provider.FontRequest;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    static class Api21Impl {
        private Api21Impl() {
        }

        static int getType(TypedArray r0, int r1) {
            return r0.getType(r1);
        }
    }

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] r1) {
            this.mEntries = r1;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public FontFileResourceEntry(String r1, int r2, boolean r3, String r4, int r5, int r6) {
            this.mFileName = r1;
            this.mWeight = r2;
            this.mItalic = r3;
            this.mVariationSettings = r4;
            this.mTtcIndex = r5;
            this.mResourceId = r6;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

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
        private final FontRequest mRequest;
        private final int mStrategy;
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(FontRequest r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        public ProviderResourceEntry(FontRequest r1, int r2, int r3, String r4) {
            this.mRequest = r1;
            this.mStrategy = r2;
            this.mTimeoutMs = r3;
            this.mSystemFontFamilyName = r4;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        public FontRequest getRequest() {
            return this.mRequest;
        }

        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray r2, int r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        TypedValue r0 = new TypedValue();
        r2.getValue(r3, r0);
        return r0.type;
    L5:
        return Api21Impl.getType(r2, r3);
    }

    public static FamilyResourceEntry parse(XmlPullParser r3, Resources r4) {
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
    L3:
        int r0 = r5.next();
        if (r0 == 2) goto L8;
        if (r0 != 1) goto L3;
    L8:
        if (r0 != 2) goto L12;
        return readFamilies(r5, r4);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources r5, int r6) {
        if (r6 == 0) goto L4;
        TypedArray r0 = r5.obtainTypedArray(r6);
    L23:
        th = move-exception;
        r0.recycle();
        throw th;
    L7:
        if (r0.length() != 0) goto L11;
        List<List<byte[]>> r7 = Collections.emptyList();     // Catch: Throwable -> L23
        r0.recycle();
        return r7;
    L11:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L23
        if (getType(r0, 0) != 1) goto L20;
        int r8 = 0;
    L15:
        if (r8 >= r0.length()) goto L21;
        int r3 = r0.getResourceId(r8, 0);     // Catch: Throwable -> L23
        if (r3 == 0) goto L19;
        r1.add(toByteArrayList(r5.getStringArray(r3)));     // Catch: Throwable -> L23
    L19:
        r8 = r8 + 1;     // Catch: Throwable -> L23
    L21:
        r0.recycle();
        return r1;
    L20:
        r1.add(toByteArrayList(r5.getStringArray(r6)));     // Catch: Throwable -> L23
        goto L21
    L4:
        return Collections.emptyList();
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser r3, Resources r4) {
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        r5.require(2, null, "font-family");
        if (r5.getName().equals("font-family") == true) goto L5;
        skip(r5);
        return null;
    L5:
        return readFamily(r5, r4);
    }

    private static FamilyResourceEntry readFamily(XmlPullParser r12, Resources r13) {
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r12, XmlPullParser.class, "com.obric.memorydata.plugin");
        TypedArray r0 = r13.obtainAttributes(Xml.asAttributeSet(r14), R.styleable.FontFamily);
        String r2 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderAuthority, "styleable", "FontFamily_fontProviderAuthority"));
        String r4 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderPackage, "styleable", "FontFamily_fontProviderPackage"));
        String r5 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderQuery, "styleable", "FontFamily_fontProviderQuery"));
        int r6 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderCerts, "styleable", "FontFamily_fontProviderCerts"), 0);
        int r8 = r0.getInteger(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderFetchStrategy, "styleable", "FontFamily_fontProviderFetchStrategy"), 1);
        int r9 = r0.getInteger(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderFetchTimeout, "styleable", "FontFamily_fontProviderFetchTimeout"), 500);
        String r3 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderSystemFontFamily, "styleable", "FontFamily_fontProviderSystemFontFamily"));
        r0.recycle();
        if (r2 == null) goto L11;
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
    L7:
        if (r14.next() == 3) goto L10;
        skip(r14);
        goto L7
    L10:
        return new ProviderResourceEntry(new FontRequest(r2, r4, r5, readCerts(r13, r6)), r8, r9, r3);
    L11:
        ArrayList r7 = new ArrayList();
    L13:
        if (r14.next() == 3) goto L22;
        if (r14.getEventType() != 2) goto L13;
        if (r14.getName().equals("font") == true) goto L19;
        skip(r14);
        goto L13
    L19:
        r7.add(readFont(r14, r13));
        goto L13
    L22:
        if (r7.isEmpty() == false) goto L26;
        return null;
    L26:
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) ZeusTransformUtils.preCheckCast(r7.toArray(new FontFileResourceEntry[0]), FontFileResourceEntry[].class, "com.obric.memorydata.plugin"));
    }

    private static FontFileResourceEntry readFont(XmlPullParser r10, Resources r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.memorydata.plugin");
        TypedArray r13 = r11.obtainAttributes(Xml.asAttributeSet(r12), R.styleable.FontFamilyFont);
        String r2 = "FontFamilyFont_fontWeight";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontWeight, "styleable", "FontFamilyFont_fontWeight")) == false) goto L5;
        int r0 = R.styleable.FontFamilyFont_fontWeight;
    L6:
        int r5 = r13.getInt(ZeusTransformUtils.mapRes(r0, "styleable", r2), 400);
        String r3 = "FontFamilyFont_fontStyle";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontStyle, "styleable", "FontFamilyFont_fontStyle")) == false) goto L9;
        int r1 = R.styleable.FontFamilyFont_fontStyle;
    L11:
        if (1 != r13.getInt(ZeusTransformUtils.mapRes(r1, "styleable", r3), 0)) goto L13;
        boolean r6 = true;
    L14:
        String r4 = "FontFamilyFont_ttcIndex";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_ttcIndex, "styleable", "FontFamilyFont_ttcIndex")) == false) goto L17;
        int r7 = R.styleable.FontFamilyFont_ttcIndex;
    L18:
        int r8 = ZeusTransformUtils.mapRes(r7, "styleable", r4);
        String r9 = "FontFamilyFont_fontVariationSettings";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontVariationSettings, "styleable", "FontFamilyFont_fontVariationSettings")) == false) goto L21;
        int r14 = R.styleable.FontFamilyFont_fontVariationSettings;
    L22:
        String r15 = r13.getString(ZeusTransformUtils.mapRes(r14, "styleable", r9));
        int r16 = r13.getInt(r8, 0);
        String r17 = "FontFamilyFont_font";
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_font, "styleable", "FontFamilyFont_font")) == false) goto L25;
        int r18 = R.styleable.FontFamilyFont_font;
    L26:
        int r19 = ZeusTransformUtils.mapRes(r18, "styleable", r17);
        int r20 = r13.getResourceId(r19, 0);
        String r21 = r13.getString(r19);
        r13.recycle();
    L28:
        if (r12.next() == 3) goto L31;
        skip(r12);
        goto L28
    L31:
        return new FontFileResourceEntry(r21, r5, r6, r15, r16, r20);
    L25:
        r18 = R.styleable.FontFamilyFont_android_font;
        r17 = "FontFamilyFont_android_font";
        goto L26
    L21:
        r14 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        r9 = "FontFamilyFont_android_fontVariationSettings";
        goto L22
    L17:
        r7 = R.styleable.FontFamilyFont_android_ttcIndex;
        r4 = "FontFamilyFont_android_ttcIndex";
        goto L18
    L13:
        r6 = false;
        goto L14
    L9:
        r1 = R.styleable.FontFamilyFont_android_fontStyle;
        r3 = "FontFamilyFont_android_fontStyle";
        goto L11
    L5:
        r0 = R.styleable.FontFamilyFont_android_fontWeight;
        r2 = "FontFamilyFont_android_fontWeight";
        goto L6
    }

    private static void skip(XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        int r0 = 1;
    L3:
        if (r0 <= 0) goto L11;
        int r1 = r4.next();
        if (r1 != 2) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (r1 != 3) goto L3;
        r0 = r0 - 1;
        goto L3
    }

    private static List<byte[]> toByteArrayList(String[] r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(Base64.decode(r5[r3], 0));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }
}
