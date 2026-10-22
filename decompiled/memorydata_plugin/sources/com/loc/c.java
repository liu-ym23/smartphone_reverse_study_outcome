package com.loc;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f5394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5395b;
    private final String c;

    private c(Context r3) {
        this.f5395b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = j.a(fx.c("RYW1hcF9kZXZpY2VfYWRpdQ"));
    }

    public static c a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f5394a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5394a != null) goto L9;
        f5394a = new c(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f5394a;
    }

    public final synchronized void a() {
        monitor-enter(this);
        if (fp.c() != null) goto L6;
        fp.a(g.a());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    }

    public final void a(String r3) {
        d.a(this.f5395b).a(this.c);
        d.a(this.f5395b).b(r3);
    }
}
