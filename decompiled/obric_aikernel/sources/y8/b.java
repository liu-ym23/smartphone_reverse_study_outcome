package y8;

import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13719a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final char[] f13720a = null;

        static {
            new a();
            f13720a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }

        private a() {
        }

        @JvmStatic
        public static final String a(byte[] r10) {
            if (r10 == null) goto L6;
            return b(r10, 0, r10.length);
        L6:
            throw new IllegalArgumentException("bytes is null".toString());
        }

        @JvmStatic
        public static final String b(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "bytes");
            int r13 = 0;
            if (r11 >= 0) goto L5;
        L7:
            boolean r14 = false;
        L8:
            if (r14 == false) goto L15;
            char[] r15 = new char[r12 * 2];
        L10:
            if (r13 >= r12) goto L13;
            int r16 = r10[r11 + r13] & 255;
            int r17 = r13 * 2;
            char[] r18 = f13720a;
            r15[r17] = r18[r16 >> 4];
            r15[r17 + 1] = r18[r16 & 15];
            r13 = r13 + 1;
            goto L10
        L13:
            return new String(r15);
        L15:
            throw new IllegalArgumentException(("offset=" + r11 + ", length=" + r12 + ", bytes.length=" + r10.length).toString());
        L5:
            if ((r11 + r12) > r10.length) goto L7;
            r14 = true;
            goto L8
        }

        @JvmStatic
        public static final String c(String r10) {
            if (r10 != null) goto L4;
        L7:
            boolean r11 = true;
        L9:
            if (r11 == false) goto L14;
            return null;
        L14:
            MessageDigest r12 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L13
            byte[] r13 = r10.getBytes(Charsets.UTF_8);     // Catch: Exception -> L13
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).getBytes(charset)");     // Catch: Exception -> L13
            return a(r12.digest(r13));
        L16:
            return null;
        L4:
            if (r10.length() == 0) goto L7;
            r11 = false;
            goto L9
        }
    }

    static {
        f13719a = new b();
    }

    private b() {
    }

    public final int a(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return 0;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        String r12 = a.c(r11 + "_" + r10);
        if (TextUtils.isEmpty(r12) == true) goto L16;
        if (r12 != null) goto L12;
        return 0;
    L12:
        return r12.hashCode();
    L16:
        return 0;
    L15:
        return 0;
    }
}
