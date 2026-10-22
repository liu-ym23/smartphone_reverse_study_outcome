package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE = null;
    static final BidiFormatter DEFAULT_RTL_INSTANCE = null;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char LRM = 8206;
    private static final String LRM_STRING = null;
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private static final char RLM = 8207;
    private static final String RLM_STRING = null;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale r1) {
            initialize(BidiFormatter.isRtlLocale(r1));
        }

        public Builder(boolean r1) {
            initialize(r1);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean r0) {
            if (r0 == false) goto L5;
            return BidiFormatter.DEFAULT_RTL_INSTANCE;
        L5:
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean r1) {
            this.mIsRtlContext = r1;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            if (this.mFlags != 2) goto L9;
            if (this.mTextDirectionHeuristicCompat != BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) goto L9;
            return getDefaultInstanceFromContext(this.mIsRtlContext);
        L9:
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat r3) {
            this.mTextDirectionHeuristicCompat = (TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r3, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder stereoReset(boolean r1) {
            if (r1 == false) goto L4;
            int r2 = this.mFlags | 2;
        L5:
            this.mFlags = r2;
            return this;
        L4:
            r2 = this.mFlags & (-3);
            goto L5
        }
    }

    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
            int r1 = 0;
        L3:
            if (r1 >= DIR_TYPE_CACHE_SIZE) goto L5;
            DIR_TYPE_CACHE[r1] = Character.getDirectionality(r1);
            r1 = r1 + 1;
            goto L3
        }

        DirectionalityEstimator(CharSequence r3, boolean r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.text = r5;
            this.isHtml = r4;
            this.length = r5.length();
        }

        private static byte getCachedDirectionality(char r1) {
            if (r1 >= DIR_TYPE_CACHE_SIZE) goto L6;
            return DIR_TYPE_CACHE[r1];
        L6:
            return Character.getDirectionality(r1);
        }

        private byte skipEntityBackward() {
            int r0 = this.charIndex;
        L3:
            int r1 = this.charIndex;
            if (r1 <= 0) goto L10;
            CharSequence r3 = this.text;
            int r2 = r1 - 1;
            this.charIndex = r2;
            char r4 = r3.charAt(r2);
            this.lastChar = r4;
            if (r4 == '&') goto L7;
            if (r4 != ';') goto L3;
        L7:
            return 12;
        L10:
            this.charIndex = r0;
            this.lastChar = ';';
            return 13;
        }

        private byte skipEntityForward() {
        L2:
            int r0 = this.charIndex;
            if (r0 >= this.length) goto L7;
            CharSequence r1 = this.text;
            this.charIndex = r0 + 1;
            char r2 = r1.charAt(r0);
            this.lastChar = r2;
            if (r2 != ';') goto L2;
            return 12;
        L7:
            return 12;
        }

        private byte skipTagBackward() {
            int r0 = this.charIndex;
        L3:
            int r1 = this.charIndex;
            if (r1 <= 0) goto L20;
            CharSequence r3 = this.text;
            int r2 = r1 - 1;
            this.charIndex = r2;
            char r4 = r3.charAt(r2);
            this.lastChar = r4;
            if (r4 == '<') goto L7;
            if (r4 == '>') goto L20;
            if (r4 == '\"') goto L15;
            if (r4 != '\'') goto L3;
        L15:
            int r5 = this.charIndex;
            if (r5 <= 0) goto L3;
            CharSequence r6 = this.text;
            int r7 = r5 - 1;
            this.charIndex = r7;
            char r8 = r6.charAt(r7);
            this.lastChar = r8;
            if (r8 == r4) goto L3;
        L7:
            return 12;
        L20:
            this.charIndex = r0;
            this.lastChar = Typography.greater;
            return 13;
        }

        private byte skipTagForward() {
            int r0 = this.charIndex;
        L3:
            int r1 = this.charIndex;
            if (r1 >= this.length) goto L18;
            CharSequence r2 = this.text;
            this.charIndex = r1 + 1;
            char r3 = r2.charAt(r1);
            this.lastChar = r3;
            if (r3 == '>') goto L7;
            if (r3 == '\"') goto L13;
            if (r3 != '\'') goto L3;
        L13:
            int r4 = this.charIndex;
            if (r4 >= this.length) goto L3;
            CharSequence r5 = this.text;
            this.charIndex = r4 + 1;
            char r6 = r5.charAt(r4);
            this.lastChar = r6;
            if (r6 == r3) goto L3;
        L7:
            return 12;
        L18:
            this.charIndex = r0;
            this.lastChar = Typography.less;
            return 13;
        }

        byte dirTypeBackward() {
            char r0 = this.text.charAt(this.charIndex - 1);
            this.lastChar = r0;
            if (Character.isLowSurrogate(r0) == false) goto L6;
            int r1 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(r1);
            return Character.getDirectionality(r1);
        L6:
            this.charIndex--;
            byte r2 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r3 = this.lastChar;
            if (r3 != '>') goto L12;
            return skipTagBackward();
        L12:
            if (r3 == ';') goto L14;
            return r2;
        L14:
            return skipEntityBackward();
        L15:
            return r2;
        }

        byte dirTypeForward() {
            char r0 = this.text.charAt(this.charIndex);
            this.lastChar = r0;
            if (Character.isHighSurrogate(r0) == false) goto L6;
            int r1 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(r1);
            return Character.getDirectionality(r1);
        L6:
            this.charIndex++;
            byte r2 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r3 = this.lastChar;
            if (r3 != '<') goto L12;
            return skipTagForward();
        L12:
            if (r3 == '&') goto L14;
            return r2;
        L14:
            return skipEntityForward();
        L15:
            return r2;
        }

        int getEntryDir() {
            this.charIndex = 0;
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
        L4:
            if (this.charIndex >= this.length) goto L23;
            if (r3 != 0) goto L23;
            byte r6 = dirTypeForward();
            if (r6 == 0) goto L20;
            if (r6 == 1) goto L18;
            if (r6 == 2) goto L18;
            if (r6 == 9) goto L4;
            switch(r6) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r5 = r5 + 1;
            r4 = 1;
            goto L4
        L17:
            r5 = r5 + 1;
            r4 = -1;
        L22:
            r3 = r5;
            goto L4
        L15:
            r5 = r5 - 1;
            r4 = 0;
        L18:
            if (r5 != 0) goto L22;
            return 1;
        L20:
            if (r5 != 0) goto L22;
            return -1;
        L23:
            if (r3 != 0) goto L25;
            return 0;
        L25:
            if (r4 == 0) goto L28;
            return r4;
        L28:
            if (this.charIndex <= 0) goto L38;
            switch(dirTypeBackward()) {
                case 14: goto L35;
                case 15: goto L35;
                case 16: goto L33;
                case 17: goto L33;
                case 18: goto L32;
                default: goto L28;
            };
        L32:
            r5 = r5 + 1;
            goto L28
        L33:
            if (r3 == r5) goto L34;
        L37:
            r5 = r5 - 1;
            goto L28
        L34:
            return 1;
        L35:
            if (r3 != r5) goto L37;
            return -1;
        L38:
            return 0;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int r1 = 0;
        L3:
            int r2 = r1;
        L5:
            if (this.charIndex <= 0) goto L31;
            byte r3 = dirTypeBackward();
            if (r3 != 0) goto L9;
            if (r1 == 0) goto L28;
            if (r2 != 0) goto L5;
        L28:
            return -1;
        L9:
            if (r3 == 1) goto L23;
            if (r3 == 2) goto L23;
            if (r3 == 9) goto L5;
            switch(r3) {
                case 14: goto L20;
                case 15: goto L20;
                case 16: goto L18;
                case 17: goto L18;
                case 18: goto L17;
                default: goto L15;
            };
        L17:
            r1 = r1 + 1;
            goto L5
        L18:
            if (r2 == r1) goto L19;
        L22:
            r1 = r1 - 1;
            goto L5
        L19:
            return 1;
        L20:
            if (r2 != r1) goto L22;
            return -1;
        L15:
            if (r2 != 0) goto L5;
        L23:
            if (r1 == 0) goto L24;
            if (r2 != 0) goto L5;
        L24:
            return 1;
        L31:
            return 0;
        }
    }

    static {
        TextDirectionHeuristicCompat r0 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = r0;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, r0);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, r0);
    }

    BidiFormatter(boolean r3, int r4, TextDirectionHeuristicCompat r5) {
        TextDirectionHeuristicCompat r6 = (TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r5, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin");
        this.mIsRtlContext = r3;
        this.mFlags = r4;
        this.mDefaultTextDirectionHeuristicCompat = r6;
    }

    private static int getEntryDir(CharSequence r2) {
        return new DirectionalityEstimator((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), false).getEntryDir();
    }

    private static int getExitDir(CharSequence r2) {
        return new DirectionalityEstimator((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale r1) {
        return new Builder(r1).build();
    }

    public static BidiFormatter getInstance(boolean r1) {
        return new Builder(r1).build();
    }

    static boolean isRtlLocale(Locale r1) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private String markAfter(CharSequence r3, TextDirectionHeuristicCompat r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r6 = ((TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin")).isRtl(r5, 0, r5.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r6 == true) goto L8;
        if (getExitDir(r5) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r6 == false) goto L15;
        if (getExitDir(r5) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    private String markBefore(CharSequence r3, TextDirectionHeuristicCompat r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r6 = ((TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin")).isRtl(r5, 0, r5.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r6 == true) goto L8;
        if (getEntryDir(r5) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r6 == false) goto L15;
        if (getEntryDir(r5) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    public boolean getStereoReset() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRtl(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(r4, 0, r4.length());
    }

    public boolean isRtl(String r1) {
        return isRtl(r1);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public CharSequence unicodeWrap(CharSequence r3) {
        return unicodeWrap((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence r3, TextDirectionHeuristicCompat r4) {
        return unicodeWrap((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin"), true);
    }

    public CharSequence unicodeWrap(CharSequence r3, TextDirectionHeuristicCompat r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        TextDirectionHeuristicCompat r7 = (TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        boolean r8 = r7.isRtl(r6, 0, r6.length());
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        if (getStereoReset() == false) goto L14;
        if (r5 == false) goto L14;
        if (r8 == false) goto L11;
        TextDirectionHeuristicCompat r1 = TextDirectionHeuristicsCompat.RTL;
    L12:
        r0.append(markBefore(r6, r1));
        goto L14
    L11:
        r1 = TextDirectionHeuristicsCompat.LTR;
    L14:
        if (r8 == this.mIsRtlContext) goto L19;
        if (r8 == false) goto L17;
        char r2 = RLE;
    L18:
        r0.append(r2);
        r0.append(r6);
        r0.append(PDF);
    L20:
        if (r5 == false) goto L25;
        if (r8 == false) goto L23;
        TextDirectionHeuristicCompat r9 = TextDirectionHeuristicsCompat.RTL;
    L24:
        r0.append(markAfter(r6, r9));
        goto L25
    L23:
        r9 = TextDirectionHeuristicsCompat.LTR;
    L25:
        return r0;
    L17:
        r2 = LRE;
        goto L18
    L19:
        r0.append(r6);
        goto L20
    }

    public CharSequence unicodeWrap(CharSequence r3, boolean r4) {
        return unicodeWrap((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), this.mDefaultTextDirectionHeuristicCompat, r4);
    }

    public String unicodeWrap(String r3) {
        return unicodeWrap(r3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String r3, TextDirectionHeuristicCompat r4) {
        return unicodeWrap(r3, (TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin"), true);
    }

    public String unicodeWrap(String r3, TextDirectionHeuristicCompat r4, boolean r5) {
        TextDirectionHeuristicCompat r6 = (TextDirectionHeuristicCompat) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristicCompat.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return unicodeWrap(r3, r6, r5).toString();
    }

    public String unicodeWrap(String r2, boolean r3) {
        return unicodeWrap(r2, this.mDefaultTextDirectionHeuristicCompat, r3);
    }
}
