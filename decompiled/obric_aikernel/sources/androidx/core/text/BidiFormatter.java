package androidx.core.text;

import android.text.SpannableStringBuilder;
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

        public Builder(Locale r10) {
            initialize(BidiFormatter.isRtlLocale(r10));
        }

        public Builder(boolean r10) {
            initialize(r10);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean r10) {
            if (r10 == false) goto L5;
            return BidiFormatter.DEFAULT_RTL_INSTANCE;
        L5:
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean r10) {
            this.mIsRtlContext = r10;
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

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat r10) {
            this.mTextDirectionHeuristicCompat = r10;
            return this;
        }

        public Builder stereoReset(boolean r10) {
            if (r10 == false) goto L4;
            int r11 = this.mFlags | 2;
        L5:
            this.mFlags = r11;
            return this;
        L4:
            r11 = this.mFlags & (-3);
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
            int r10 = 0;
        L3:
            if (r10 >= DIR_TYPE_CACHE_SIZE) goto L5;
            DIR_TYPE_CACHE[r10] = Character.getDirectionality(r10);
            r10 = r10 + 1;
            goto L3
        }

        DirectionalityEstimator(CharSequence r10, boolean r11) {
            this.text = r10;
            this.isHtml = r11;
            this.length = r10.length();
        }

        private static byte getCachedDirectionality(char r10) {
            if (r10 >= DIR_TYPE_CACHE_SIZE) goto L6;
            return DIR_TYPE_CACHE[r10];
        L6:
            return Character.getDirectionality(r10);
        }

        private byte skipEntityBackward() {
            int r10 = this.charIndex;
        L3:
            int r11 = this.charIndex;
            if (r11 <= 0) goto L10;
            CharSequence r12 = this.text;
            int r13 = r11 - 1;
            this.charIndex = r13;
            char r14 = r12.charAt(r13);
            this.lastChar = r14;
            if (r14 == '&') goto L7;
            if (r14 != ';') goto L3;
        L7:
            return 12;
        L10:
            this.charIndex = r10;
            this.lastChar = ';';
            return 13;
        }

        private byte skipEntityForward() {
        L2:
            int r10 = this.charIndex;
            if (r10 >= this.length) goto L7;
            CharSequence r11 = this.text;
            this.charIndex = r10 + 1;
            char r12 = r11.charAt(r10);
            this.lastChar = r12;
            if (r12 != ';') goto L2;
            return 12;
        L7:
            return 12;
        }

        private byte skipTagBackward() {
            int r10 = this.charIndex;
        L3:
            int r11 = this.charIndex;
            if (r11 <= 0) goto L20;
            CharSequence r12 = this.text;
            int r13 = r11 - 1;
            this.charIndex = r13;
            char r14 = r12.charAt(r13);
            this.lastChar = r14;
            if (r14 == '<') goto L7;
            if (r14 == '>') goto L20;
            if (r14 == '\"') goto L15;
            if (r14 != '\'') goto L3;
        L15:
            int r15 = this.charIndex;
            if (r15 <= 0) goto L3;
            CharSequence r16 = this.text;
            int r17 = r15 - 1;
            this.charIndex = r17;
            char r18 = r16.charAt(r17);
            this.lastChar = r18;
            if (r18 == r14) goto L3;
        L7:
            return 12;
        L20:
            this.charIndex = r10;
            this.lastChar = Typography.greater;
            return 13;
        }

        private byte skipTagForward() {
            int r10 = this.charIndex;
        L3:
            int r11 = this.charIndex;
            if (r11 >= this.length) goto L18;
            CharSequence r12 = this.text;
            this.charIndex = r11 + 1;
            char r13 = r12.charAt(r11);
            this.lastChar = r13;
            if (r13 == '>') goto L7;
            if (r13 == '\"') goto L13;
            if (r13 != '\'') goto L3;
        L13:
            int r14 = this.charIndex;
            if (r14 >= this.length) goto L3;
            CharSequence r15 = this.text;
            this.charIndex = r14 + 1;
            char r16 = r15.charAt(r14);
            this.lastChar = r16;
            if (r16 == r13) goto L3;
        L7:
            return 12;
        L18:
            this.charIndex = r10;
            this.lastChar = Typography.less;
            return 13;
        }

        byte dirTypeBackward() {
            char r10 = this.text.charAt(this.charIndex - 1);
            this.lastChar = r10;
            if (Character.isLowSurrogate(r10) == false) goto L6;
            int r11 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(r11);
            return Character.getDirectionality(r11);
        L6:
            this.charIndex--;
            byte r12 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r13 = this.lastChar;
            if (r13 != '>') goto L12;
            return skipTagBackward();
        L12:
            if (r13 == ';') goto L14;
            return r12;
        L14:
            return skipEntityBackward();
        L15:
            return r12;
        }

        byte dirTypeForward() {
            char r10 = this.text.charAt(this.charIndex);
            this.lastChar = r10;
            if (Character.isHighSurrogate(r10) == false) goto L6;
            int r11 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(r11);
            return Character.getDirectionality(r11);
        L6:
            this.charIndex++;
            byte r12 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r13 = this.lastChar;
            if (r13 != '<') goto L12;
            return skipTagForward();
        L12:
            if (r13 == '&') goto L14;
            return r12;
        L14:
            return skipEntityForward();
        L15:
            return r12;
        }

        int getEntryDir() {
            this.charIndex = 0;
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L4:
            if (this.charIndex >= this.length) goto L23;
            if (r10 != 0) goto L23;
            byte r13 = dirTypeForward();
            if (r13 == 0) goto L20;
            if (r13 == 1) goto L18;
            if (r13 == 2) goto L18;
            if (r13 == 9) goto L4;
            switch(r13) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r12 = r12 + 1;
            r11 = 1;
            goto L4
        L17:
            r12 = r12 + 1;
            r11 = -1;
        L22:
            r10 = r12;
            goto L4
        L15:
            r12 = r12 - 1;
            r11 = 0;
        L18:
            if (r12 != 0) goto L22;
            return 1;
        L20:
            if (r12 != 0) goto L22;
            return -1;
        L23:
            if (r10 != 0) goto L25;
            return 0;
        L25:
            if (r11 == 0) goto L28;
            return r11;
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
            r12 = r12 + 1;
            goto L28
        L33:
            if (r10 == r12) goto L34;
        L37:
            r12 = r12 - 1;
            goto L28
        L34:
            return 1;
        L35:
            if (r10 != r12) goto L37;
            return -1;
        L38:
            return 0;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int r10 = 0;
        L3:
            int r11 = r10;
        L5:
            if (this.charIndex <= 0) goto L31;
            byte r12 = dirTypeBackward();
            if (r12 != 0) goto L9;
            if (r10 == 0) goto L28;
            if (r11 != 0) goto L5;
        L28:
            return -1;
        L9:
            if (r12 == 1) goto L23;
            if (r12 == 2) goto L23;
            if (r12 == 9) goto L5;
            switch(r12) {
                case 14: goto L20;
                case 15: goto L20;
                case 16: goto L18;
                case 17: goto L18;
                case 18: goto L17;
                default: goto L15;
            };
        L17:
            r10 = r10 + 1;
            goto L5
        L18:
            if (r11 == r10) goto L19;
        L22:
            r10 = r10 - 1;
            goto L5
        L19:
            return 1;
        L20:
            if (r11 != r10) goto L22;
            return -1;
        L15:
            if (r11 != 0) goto L5;
        L23:
            if (r10 == 0) goto L24;
            if (r11 != 0) goto L5;
        L24:
            return 1;
        L31:
            return 0;
        }
    }

    static {
        TextDirectionHeuristicCompat r10 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = r10;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, r10);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, r10);
    }

    BidiFormatter(boolean r10, int r11, TextDirectionHeuristicCompat r12) {
        this.mIsRtlContext = r10;
        this.mFlags = r11;
        this.mDefaultTextDirectionHeuristicCompat = r12;
    }

    private static int getEntryDir(CharSequence r10) {
        return new DirectionalityEstimator(r10, false).getEntryDir();
    }

    private static int getExitDir(CharSequence r10) {
        return new DirectionalityEstimator(r10, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale r10) {
        return new Builder(r10).build();
    }

    public static BidiFormatter getInstance(boolean r10) {
        return new Builder(r10).build();
    }

    static boolean isRtlLocale(Locale r10) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private String markAfter(CharSequence r10, TextDirectionHeuristicCompat r11) {
        boolean r12 = r11.isRtl(r10, 0, r10.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r12 == true) goto L8;
        if (getExitDir(r10) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r12 == false) goto L15;
        if (getExitDir(r10) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    private String markBefore(CharSequence r10, TextDirectionHeuristicCompat r11) {
        boolean r12 = r11.isRtl(r10, 0, r10.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r12 == true) goto L8;
        if (getEntryDir(r10) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r12 == false) goto L15;
        if (getEntryDir(r10) == (-1)) goto L15;
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

    public boolean isRtl(CharSequence r10) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(r10, 0, r10.length());
    }

    public boolean isRtl(String r10) {
        return isRtl(r10);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public CharSequence unicodeWrap(CharSequence r10) {
        return unicodeWrap(r10, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence r10, TextDirectionHeuristicCompat r11) {
        return unicodeWrap(r10, r11, true);
    }

    public CharSequence unicodeWrap(CharSequence r10, TextDirectionHeuristicCompat r11, boolean r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        boolean r13 = r11.isRtl(r10, 0, r10.length());
        SpannableStringBuilder r14 = new SpannableStringBuilder();
        if (getStereoReset() == false) goto L13;
        if (r12 == false) goto L13;
        if (r13 == false) goto L10;
        TextDirectionHeuristicCompat r15 = TextDirectionHeuristicsCompat.RTL;
    L11:
        r14.append(markBefore(r10, r15));
        goto L13
    L10:
        r15 = TextDirectionHeuristicsCompat.LTR;
    L13:
        if (r13 == this.mIsRtlContext) goto L18;
        if (r13 == false) goto L16;
        char r16 = RLE;
    L17:
        r14.append(r16);
        r14.append(r10);
        r14.append(PDF);
    L19:
        if (r12 == false) goto L24;
        if (r13 == false) goto L22;
        TextDirectionHeuristicCompat r17 = TextDirectionHeuristicsCompat.RTL;
    L23:
        r14.append(markAfter(r10, r17));
        goto L24
    L22:
        r17 = TextDirectionHeuristicsCompat.LTR;
    L24:
        return r14;
    L16:
        r16 = LRE;
        goto L17
    L18:
        r14.append(r10);
        goto L19
    }

    public CharSequence unicodeWrap(CharSequence r10, boolean r11) {
        return unicodeWrap(r10, this.mDefaultTextDirectionHeuristicCompat, r11);
    }

    public String unicodeWrap(String r10) {
        return unicodeWrap(r10, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String r10, TextDirectionHeuristicCompat r11) {
        return unicodeWrap(r10, r11, true);
    }

    public String unicodeWrap(String r10, TextDirectionHeuristicCompat r11, boolean r12) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return unicodeWrap(r10, r11, r12).toString();
    }

    public String unicodeWrap(String r10, boolean r11) {
        return unicodeWrap(r10, this.mDefaultTextDirectionHeuristicCompat, r11);
    }
}
