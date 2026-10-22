package j51;

import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final String a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "douyinV");
        Intrinsics.checkNotNullParameter(r2, "huoshanV");
        Intrinsics.checkNotNullParameter(r3, "saasV");
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L6;
        return r1;
    L6:
        if (KmpEnv.c() == false) goto L9;
        return r2;
    L9:
        return r3;
    }
}
