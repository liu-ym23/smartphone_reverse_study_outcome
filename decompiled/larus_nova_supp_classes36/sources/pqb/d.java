package pqb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    static {
    }

    public static String a(com.ss.android.lark.log.f r3) {
        if (r3 == null) goto L6;
        StringBuilder r0 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r3, "logConfig");
        r0.append(r3.e + "alog/");
        r0.append(r3.c);
        r0.append('/');
        String r4 = r0.toString();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4);
        if (r1.exists() == true) goto L8;
        r1.mkdirs();
        return r4;
    L8:
        return r4;
    L6:
        return "";
    }
}
