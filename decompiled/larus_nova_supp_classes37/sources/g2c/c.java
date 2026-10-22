package g2c;

import com.ss.android.lark.qrcode.zxing.qrcode.decoder.Mode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final int[] a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Mode.values().length];
            a = r0;
            r0[Mode.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[Mode.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[Mode.KANJI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    }
}
