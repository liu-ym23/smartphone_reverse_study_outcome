package qqb;

import com.ss.android.lark.log.Log;
import java.security.SecureRandom;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final ThreadLocal<String> a = null;
    public static final ThreadLocal<SecureRandom> b = null;

    static {
        a = new ThreadLocal();
        b = new ThreadLocal();
    }

    @JvmStatic
    public static final void a() {
        a.set("");
    }

    @JvmStatic
    public static final String d() {
        String r0 = a.get();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @JvmStatic
    public static final UUID e() {
        ThreadLocal<SecureRandom> r0 = b;
        SecureRandom r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new SecureRandom();
        r0.set(r1);
    L5:
        byte[] r2 = new byte[16];
        r1.nextBytes(r2);
        byte r3 = (byte) (r2[6] & 15);
        r2[6] = r3;
        r2[6] = (byte) (r3 | 64);
        byte r4 = (byte) (r2[8] & 63);
        r2[8] = r4;
        r2[8] = (byte) (r4 | (-128));
        int r5 = 0;
        long r6 = 0;
    L7:
        if (r5 >= 8) goto L9;
        r6 = (r6 << 8) | (255 & (((long) r2[r5]) + 0));
        r5 = r5 + 1;
        goto L7
    L9:
        long r10 = 0;
        int r7 = 8;
    L10:
        if (r7 >= 16) goto L13;
        r10 = (r10 << 8) | ((((long) r2[r7]) + 0) & 255);
        r7 = r7 + 1;
        goto L10
    L13:
        return new UUID(r6, r10);
    }

    @JvmStatic
    public static final String c() {
        String r0 = d();
        Intrinsics.checkNotNullParameter(r0, "traceId");
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return i(e());
    L9:
        return r0 + '_' + i(e());
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final String b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "contextId");
        String r8 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r7, new String[]{"_"}, false, 0, 6, null));
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8;
    }

    @JvmStatic
    public static final void f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        g(r1);
    }

    @JvmStatic
    public static final void g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        a.set(r1);
    }

    @JvmStatic
    public static final void h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "mark");
        if (Intrinsics.areEqual(d(), "") == true) goto L5;
        Log.e("TraceIdUtils", "Please check if the traceId is set repeatedly or forget to clear");
    L5:
        g(i(e()));
        Log.i("TraceIdUtils", StringsKt.trimIndent("\n            Start traceable log\n            " + r3 + "\n            "));
    }

    @JvmStatic
    public static final String i(UUID r6) {
        return StringsKt.replace$default(String.valueOf(r6), "-", "", false, 4, null).substring(0, 10);
    }
}
