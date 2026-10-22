package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = null;
    public static final TextDirectionHeuristicCompat LOCALE = null;
    public static final TextDirectionHeuristicCompat LTR = null;
    public static final TextDirectionHeuristicCompat RTL = null;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    private static class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong INSTANCE_RTL = null;
        private final boolean mLookForRtl;

        static {
            INSTANCE_RTL = new AnyStrong(true);
        }

        private AnyStrong(boolean r10) {
            this.mLookForRtl = r10;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r10, int r11, int r12) {
            int r13 = r12 + r11;
            boolean r14 = false;
        L3:
            if (r11 >= r13) goto L16;
            int r15 = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(r10.charAt(r11)));
            if (r15 == 0) goto L12;
            if (r15 != 1) goto L15;
            if (this.mLookForRtl == false) goto L10;
        L14:
            r14 = true;
            goto L15
        L10:
            return 1;
        L15:
            r11 = r11 + 1;
            r14 = r14;
            goto L3
        L12:
            if (this.mLookForRtl == false) goto L14;
            return 0;
        L16:
            if (r14 == true) goto L18;
            return 2;
        L18:
            return this.mLookForRtl ? 1 : 0;
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong INSTANCE = null;

        static {
            INSTANCE = new FirstStrong();
        }

        private FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r10, int r11, int r12) {
            int r13 = r12 + r11;
            int r14 = 2;
        L3:
            if (r11 >= r13) goto L6;
            if (r14 != 2) goto L6;
            r14 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(r10.charAt(r11)));
            r11 = r11 + 1;
        L6:
            return r14;
        }
    }

    private interface TextDirectionAlgorithm {
        int checkRtl(CharSequence r10, int r11, int r12);
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm r10) {
            this.mAlgorithm = r10;
        }

        private boolean doCheck(CharSequence r10, int r11, int r12) {
            int r13 = this.mAlgorithm.checkRtl(r10, r11, r12);
            if (r13 == 0) goto L9;
            if (r13 != 1) goto L6;
            return false;
        L6:
            return defaultIsRtl();
        L9:
            return true;
        }

        protected abstract boolean defaultIsRtl();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence r10, int r11, int r12) {
            if (r10 == null) goto L14;
            if (r11 < 0) goto L14;
            if (r12 < 0) goto L14;
            if ((r10.length() - r12) < r11) goto L14;
            if (this.mAlgorithm != null) goto L12;
            return defaultIsRtl();
        L12:
            return doCheck(r10, r11, r12);
        L14:
            throw new IllegalArgumentException();
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] r10, int r11, int r12) {
            return isRtl(CharBuffer.wrap(r10), r11, r12);
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm r10, boolean r11) {
            super(r10);
            this.mDefaultIsRtl = r11;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale INSTANCE = null;

        static {
            INSTANCE = new TextDirectionHeuristicLocale();
        }

        TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    static {
        LTR = new TextDirectionHeuristicInternal(null, false);
        RTL = new TextDirectionHeuristicInternal(null, true);
        FirstStrong r10 = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(r10, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(r10, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L6;
        return 0;
    L6:
        if (r10 == 2) goto L11;
        return 2;
    L11:
        return 0;
    L10:
        return 1;
    }

    static int isRtlTextOrFormat(int r10) {
        if (r10 == 0) goto L11;
        if (r10 != 1) goto L6;
        return 0;
    L6:
        if (r10 == 2) goto L12;
        switch(r10) {
            case 14: goto L11;
            case 15: goto L11;
            case 16: goto L13;
            case 17: goto L13;
            default: goto L8;
        };
    L8:
        return 2;
    L13:
        return 0;
    L12:
        return 0;
    L11:
        return 1;
    }
}
