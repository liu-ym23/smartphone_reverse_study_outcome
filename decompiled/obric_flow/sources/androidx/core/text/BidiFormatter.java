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

        private static BidiFormatter getDefaultInstanceFromContext(boolean r5) {
            if (r5 == false) goto L5;
            return BidiFormatter.DEFAULT_RTL_INSTANCE;
        L5:
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean r5) {
            this.mIsRtlContext = r5;
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

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat r5) {
            this.mTextDirectionHeuristicCompat = r5;
            return this;
        }

        public Builder stereoReset(boolean r5) {
            if (r5 == false) goto L4;
            this.mFlags |= 2;
        L5:
            return this;
        L4:
            this.mFlags &= -3;
            goto L5
        }

        public Builder(boolean r5) {
            initialize(r5);
        }

        public Builder(Locale r5) {
            initialize(BidiFormatter.isRtlLocale(r5));
        }
    }

    public static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
            int r5 = 0;
        L3:
            if (r5 >= DIR_TYPE_CACHE_SIZE) goto L5;
            DIR_TYPE_CACHE[r5] = Character.getDirectionality(r5);
            r5 = r5 + 1;
            goto L3
        }

        public DirectionalityEstimator(CharSequence r5, boolean r10) {
            this.text = r5;
            this.isHtml = r10;
            this.length = r5.length();
        }

        private static byte getCachedDirectionality(char r5) {
            if (r5 >= DIR_TYPE_CACHE_SIZE) goto L6;
            return DIR_TYPE_CACHE[r5];
        L6:
            return Character.getDirectionality(r5);
        }

        private byte skipEntityBackward() {
            int r5 = this.charIndex;
        L3:
            int r10 = this.charIndex;
            if (r10 <= 0) goto L10;
            CharSequence r11 = this.text;
            int r12 = r10 - 1;
            this.charIndex = r12;
            char r13 = r11.charAt(r12);
            this.lastChar = r13;
            if (r13 == '&') goto L7;
            if (r13 != ';') goto L3;
        L7:
            return 12;
        L10:
            this.charIndex = r5;
            this.lastChar = ';';
            return 13;
        }

        private byte skipEntityForward() {
        L2:
            int r5 = this.charIndex;
            if (r5 >= this.length) goto L7;
            CharSequence r10 = this.text;
            this.charIndex = r5 + 1;
            char r11 = r10.charAt(r5);
            this.lastChar = r11;
            if (r11 != ';') goto L2;
            return 12;
        L7:
            return 12;
        }

        private byte skipTagBackward() {
            int r5 = this.charIndex;
        L3:
            int r10 = this.charIndex;
            if (r10 <= 0) goto L20;
            CharSequence r11 = this.text;
            int r12 = r10 - 1;
            this.charIndex = r12;
            char r13 = r11.charAt(r12);
            this.lastChar = r13;
            if (r13 == '<') goto L7;
            if (r13 == '>') goto L20;
            if (r13 == '\"') goto L15;
            if (r13 != '\'') goto L3;
        L15:
            int r14 = this.charIndex;
            if (r14 <= 0) goto L3;
            CharSequence r15 = this.text;
            int r16 = r14 - 1;
            this.charIndex = r16;
            char r17 = r15.charAt(r16);
            this.lastChar = r17;
            if (r17 == r13) goto L3;
        L7:
            return 12;
        L20:
            this.charIndex = r5;
            this.lastChar = Typography.greater;
            return 13;
        }

        private byte skipTagForward() {
            int r5 = this.charIndex;
        L3:
            int r10 = this.charIndex;
            if (r10 >= this.length) goto L18;
            CharSequence r11 = this.text;
            this.charIndex = r10 + 1;
            char r12 = r11.charAt(r10);
            this.lastChar = r12;
            if (r12 == '>') goto L7;
            if (r12 == '\"') goto L13;
            if (r12 != '\'') goto L3;
        L13:
            int r13 = this.charIndex;
            if (r13 >= this.length) goto L3;
            CharSequence r14 = this.text;
            this.charIndex = r13 + 1;
            char r15 = r14.charAt(r13);
            this.lastChar = r15;
            if (r15 == r12) goto L3;
        L7:
            return 12;
        L18:
            this.charIndex = r5;
            this.lastChar = Typography.less;
            return 13;
        }

        public byte dirTypeBackward() {
            char r5 = this.text.charAt(this.charIndex - 1);
            this.lastChar = r5;
            if (Character.isLowSurrogate(r5) == false) goto L6;
            int r10 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(r10);
            return Character.getDirectionality(r10);
        L6:
            this.charIndex--;
            byte r11 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r12 = this.lastChar;
            if (r12 != '>') goto L12;
            return skipTagBackward();
        L12:
            if (r12 == ';') goto L14;
            return r11;
        L14:
            return skipEntityBackward();
        L15:
            return r11;
        }

        public byte dirTypeForward() {
            char r5 = this.text.charAt(this.charIndex);
            this.lastChar = r5;
            if (Character.isHighSurrogate(r5) == false) goto L6;
            int r10 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex = Character.charCount(r10) + this.charIndex;
            return Character.getDirectionality(r10);
        L6:
            this.charIndex++;
            byte r11 = getCachedDirectionality(this.lastChar);
            if (this.isHtml == false) goto L15;
            char r12 = this.lastChar;
            if (r12 != '<') goto L12;
            return skipTagForward();
        L12:
            if (r12 == '&') goto L14;
            return r11;
        L14:
            return skipEntityForward();
        L15:
            return r11;
        }

        public int getEntryDir() {
            this.charIndex = 0;
            int r5 = 0;
            int r10 = 0;
            int r11 = 0;
        L4:
            if (this.charIndex >= this.length) goto L23;
            if (r5 != 0) goto L23;
            byte r12 = dirTypeForward();
            if (r12 == 0) goto L20;
            if (r12 == 1) goto L18;
            if (r12 == 2) goto L18;
            if (r12 == 9) goto L4;
            switch(r12) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r11 = r11 + 1;
            r10 = 1;
            goto L4
        L17:
            r11 = r11 + 1;
            r10 = -1;
        L22:
            r5 = r11;
            goto L4
        L15:
            r11 = r11 - 1;
            r10 = 0;
        L18:
            if (r11 != 0) goto L22;
            return 1;
        L20:
            if (r11 != 0) goto L22;
            return -1;
        L23:
            if (r5 != 0) goto L25;
            return 0;
        L25:
            if (r10 == 0) goto L28;
            return r10;
        L28:
            if (this.charIndex <= 0) goto L38;
            switch(dirTypeBackward()) {
                case 14: goto L36;
                case 15: goto L36;
                case 16: goto L33;
                case 17: goto L33;
                case 18: goto L32;
                default: goto L28;
            };
        L32:
            r11 = r11 + 1;
            goto L28
        L33:
            if (r5 == r11) goto L34;
        L35:
            r11 = r11 - 1;
            goto L28
        L34:
            return 1;
        L36:
            if (r5 != r11) goto L35;
            return -1;
        L38:
            return 0;
        }

        public int getExitDir() {
            this.charIndex = this.length;
            int r5 = 0;
        L3:
            int r10 = r5;
        L5:
            if (this.charIndex <= 0) goto L31;
            byte r11 = dirTypeBackward();
            if (r11 != 0) goto L9;
            if (r5 == 0) goto L28;
            if (r10 != 0) goto L5;
        L28:
            return -1;
        L9:
            if (r11 == 1) goto L23;
            if (r11 == 2) goto L23;
            if (r11 == 9) goto L5;
            switch(r11) {
                case 14: goto L21;
                case 15: goto L21;
                case 16: goto L18;
                case 17: goto L18;
                case 18: goto L17;
                default: goto L15;
            };
        L17:
            r5 = r5 + 1;
            goto L5
        L18:
            if (r10 == r5) goto L19;
        L20:
            r5 = r5 - 1;
            goto L5
        L19:
            return 1;
        L21:
            if (r10 != r5) goto L20;
            return -1;
        L15:
            if (r10 != 0) goto L5;
        L23:
            if (r5 == 0) goto L24;
            if (r10 != 0) goto L5;
        L24:
            return 1;
        L31:
            return 0;
        }
    }

    static {
        TextDirectionHeuristicCompat r5 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = r5;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, r5);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, r5);
    }

    public BidiFormatter(boolean r5, int r10, TextDirectionHeuristicCompat r11) {
        this.mIsRtlContext = r5;
        this.mFlags = r10;
        this.mDefaultTextDirectionHeuristicCompat = r11;
    }

    private static int getEntryDir(CharSequence r5) {
        return new DirectionalityEstimator(r5, false).getEntryDir();
    }

    private static int getExitDir(CharSequence r5) {
        return new DirectionalityEstimator(r5, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static boolean isRtlLocale(Locale r5) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(r5) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private String markAfter(CharSequence r5, TextDirectionHeuristicCompat r10) {
        boolean r11 = r10.isRtl(r5, 0, r5.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r11 == true) goto L8;
        if (getExitDir(r5) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r11 == false) goto L15;
        if (getExitDir(r5) == (-1)) goto L15;
        return "";
    L15:
        return RLM_STRING;
    L16:
        return "";
    }

    private String markBefore(CharSequence r5, TextDirectionHeuristicCompat r10) {
        boolean r11 = r10.isRtl(r5, 0, r5.length());
        if (this.mIsRtlContext == true) goto L10;
        if (r11 == true) goto L8;
        if (getEntryDir(r5) != 1) goto L10;
    L8:
        return LRM_STRING;
    L10:
        if (this.mIsRtlContext == false) goto L16;
        if (r11 == false) goto L15;
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

    public boolean isRtl(String r5) {
        return isRtl(r5);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String r5, TextDirectionHeuristicCompat r10, boolean r11) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return unicodeWrap(r5, r10, r11).toString();
    }

    public static BidiFormatter getInstance(boolean r5) {
        return new Builder(r5).build();
    }

    public boolean isRtl(CharSequence r5) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(r5, 0, r5.length());
    }

    public CharSequence unicodeWrap(CharSequence r5, TextDirectionHeuristicCompat r10, boolean r11) {
        if (r5 != null) goto L5;
        return null;
    L5:
        boolean r12 = r10.isRtl(r5, 0, r5.length());
        SpannableStringBuilder r13 = new SpannableStringBuilder();
        if (getStereoReset() == false) goto L13;
        if (r11 == false) goto L13;
        if (r12 == false) goto L10;
        TextDirectionHeuristicCompat r14 = TextDirectionHeuristicsCompat.RTL;
    L11:
        r13.append(markBefore(r5, r14));
        goto L13
    L10:
        r14 = TextDirectionHeuristicsCompat.LTR;
    L13:
        if (r12 == this.mIsRtlContext) goto L18;
        if (r12 == false) goto L16;
        char r15 = RLE;
    L17:
        r13.append(r15);
        r13.append(r5);
        r13.append(PDF);
    L19:
        if (r11 == false) goto L24;
        if (r12 == false) goto L22;
        TextDirectionHeuristicCompat r16 = TextDirectionHeuristicsCompat.RTL;
    L23:
        r13.append(markAfter(r5, r16));
        goto L24
    L22:
        r16 = TextDirectionHeuristicsCompat.LTR;
    L24:
        return r13;
    L16:
        r15 = LRE;
        goto L17
    L18:
        r13.append(r5);
        goto L19
    }

    public static BidiFormatter getInstance(Locale r5) {
        return new Builder(r5).build();
    }

    public String unicodeWrap(String r5, TextDirectionHeuristicCompat r10) {
        return unicodeWrap(r5, r10, true);
    }

    public CharSequence unicodeWrap(CharSequence r5, TextDirectionHeuristicCompat r10) {
        return unicodeWrap(r5, r10, true);
    }

    public String unicodeWrap(String r5, boolean r10) {
        return unicodeWrap(r5, this.mDefaultTextDirectionHeuristicCompat, r10);
    }

    public CharSequence unicodeWrap(CharSequence r5, boolean r10) {
        return unicodeWrap(r5, this.mDefaultTextDirectionHeuristicCompat, r10);
    }

    public String unicodeWrap(String r5) {
        return unicodeWrap(r5, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence r5) {
        return unicodeWrap(r5, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
