package ms.bd.c;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class z2 {
    public static volatile z2 d;
    public String a;
    public String b;
    public String c;

    public z2(Context r7) {
        this.a = null;
        this.b = null;
        this.c = null;
        ThreadMethodProxy.start(new PthreadThreadV2(new b0(new d0(new y2(this)), r7), "ms/bd/c/z2"));     // Catch: Throwable -> L5
        return;
    L5:
        String r8 = (String) p2.a(16777217, 0, 0, "ac18ae", new byte[]{ByteCompanionObject.MAX_VALUE, 116, 65});
    }

    public static z2 a(Context r2) {
        if (d != null) goto L15;
        monitor-enter(z2.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new z2(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(z2.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public static boolean b(Context r2, String r3) {
        if (r2.getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
