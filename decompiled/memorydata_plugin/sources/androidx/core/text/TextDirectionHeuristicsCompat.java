package androidx.core.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        private AnyStrong(boolean r1) {
            this.mLookForRtl = r1;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r5, int r6, int r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            int r9 = r7 + r6;
            boolean r1 = false;
        L3:
            if (r6 >= r9) goto L16;
            int r2 = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(r8.charAt(r6)));
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L15;
            if (this.mLookForRtl == false) goto L10;
        L14:
            r1 = true;
            goto L15
        L10:
            return 1;
        L15:
            r6 = r6 + 1;
            r1 = r1;
            goto L3
        L12:
            if (this.mLookForRtl == false) goto L14;
            return 0;
        L16:
            if (r1 == true) goto L18;
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
        public int checkRtl(CharSequence r2, int r3, int r4) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            int r5 = r4 + r3;
            int r0 = 2;
        L3:
            if (r3 >= r5) goto L6;
            if (r0 != 2) goto L6;
            r0 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(r1.charAt(r3)));
            r3 = r3 + 1;
        L6:
            return r0;
        }
    }

    private interface TextDirectionAlgorithm {
        int checkRtl(CharSequence r1, int r2, int r3);
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm r3) {
            this.mAlgorithm = (TextDirectionAlgorithm) ZeusTransformUtils.wrapperContextForParams(r3, TextDirectionAlgorithm.class, "com.obric.memorydata.plugin");
        }

        private boolean doCheck(CharSequence r3, int r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            int r7 = this.mAlgorithm.checkRtl(r6, r4, r5);
            if (r7 == 0) goto L9;
            if (r7 != 1) goto L6;
            return false;
        L6:
            return defaultIsRtl();
        L9:
            return true;
        }

        public abstract boolean defaultIsRtl();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence r3, int r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            if (r4 < 0) goto L15;
            if (r5 < 0) goto L15;
            if ((r6.length() - r5) < r4) goto L15;
            if (this.mAlgorithm != null) goto L13;
            return defaultIsRtl();
        L13:
            return doCheck(r6, r4, r5);
        L15:
            throw new IllegalArgumentException();
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] r1, int r2, int r3) {
            return isRtl(CharBuffer.wrap(r1), r2, r3);
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm r3, boolean r4) {
            super((TextDirectionAlgorithm) ZeusTransformUtils.wrapperContextForParams(r3, TextDirectionAlgorithm.class, "com.obric.memorydata.plugin"));
            this.mDefaultIsRtl = r4;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
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
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int r1) {
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L6;
        return 0;
    L6:
        if (r1 == 2) goto L11;
        return 2;
    L11:
        return 0;
    L10:
        return 1;
    }

    static int isRtlTextOrFormat(int r2) {
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L6;
        return 0;
    L6:
        if (r2 == 2) goto L12;
        switch(r2) {
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
