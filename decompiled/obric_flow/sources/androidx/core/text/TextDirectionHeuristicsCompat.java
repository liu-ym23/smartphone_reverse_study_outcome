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

    public static class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong INSTANCE_RTL = null;
        private final boolean mLookForRtl;

        static {
            INSTANCE_RTL = new AnyStrong(true);
        }

        private AnyStrong(boolean r5) {
            this.mLookForRtl = r5;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r5, int r10, int r11) {
            int r12 = r11 + r10;
            boolean r13 = false;
        L3:
            if (r10 >= r12) goto L16;
            int r14 = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(r5.charAt(r10)));
            if (r14 == 0) goto L13;
            if (r14 != 1) goto L15;
            if (this.mLookForRtl == false) goto L10;
        L11:
            r13 = true;
            goto L15
        L10:
            return 1;
        L15:
            r10 = r10 + 1;
            r13 = r13;
            goto L3
        L13:
            if (this.mLookForRtl == false) goto L11;
            return 0;
        L16:
            if (r13 == true) goto L18;
            return 2;
        L18:
            return this.mLookForRtl ? 1 : 0;
        }
    }

    public static class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong INSTANCE = null;

        static {
            INSTANCE = new FirstStrong();
        }

        private FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r5, int r10, int r11) {
            int r12 = r11 + r10;
            int r13 = 2;
        L3:
            if (r10 >= r12) goto L6;
            if (r13 != 2) goto L6;
            r13 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(r5.charAt(r10)));
            r10 = r10 + 1;
        L6:
            return r13;
        }
    }

    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence r5, int r10, int r11);
    }

    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm r5) {
            this.mAlgorithm = r5;
        }

        private boolean doCheck(CharSequence r5, int r10, int r11) {
            int r12 = this.mAlgorithm.checkRtl(r5, r10, r11);
            if (r12 == 0) goto L9;
            if (r12 != 1) goto L6;
            return false;
        L6:
            return defaultIsRtl();
        L9:
            return true;
        }

        public abstract boolean defaultIsRtl();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] r5, int r10, int r11) {
            return isRtl(CharBuffer.wrap(r5), r10, r11);
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence r5, int r10, int r11) {
            if (r5 == null) goto L14;
            if (r10 < 0) goto L14;
            if (r11 < 0) goto L14;
            if ((r5.length() - r11) < r10) goto L14;
            if (this.mAlgorithm != null) goto L12;
            return defaultIsRtl();
        L12:
            return doCheck(r5, r10, r11);
        L14:
            throw new IllegalArgumentException();
        }
    }

    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        public TextDirectionHeuristicInternal(TextDirectionAlgorithm r5, boolean r10) {
            super(r5);
            this.mDefaultIsRtl = r10;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale INSTANCE = null;

        static {
            INSTANCE = new TextDirectionHeuristicLocale();
        }

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    static {
        LTR = new TextDirectionHeuristicInternal(null, false);
        RTL = new TextDirectionHeuristicInternal(null, true);
        FirstStrong r5 = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(r5, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(r5, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
    }

    public static int isRtlText(int r5) {
        if (r5 == 0) goto L10;
        if (r5 != 1) goto L6;
        return 0;
    L6:
        if (r5 == 2) goto L11;
        return 2;
    L11:
        return 0;
    L10:
        return 1;
    }

    public static int isRtlTextOrFormat(int r5) {
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L6;
        return 0;
    L6:
        if (r5 == 2) goto L12;
        switch(r5) {
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
