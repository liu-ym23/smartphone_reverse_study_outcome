package com.ss.android.deviceregister.c;

import android.content.Context;
import com.ss.android.deviceregister.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f15203b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f15204a;

    private c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f15204a = null;
        if (f.a() == false) goto L5;
        b r0 = new a(r4);
    L6:
        this.f15204a = r0;
        return;
    L5:
        r0 = new d(r4);
        goto L6
    }

    public static c a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f15203b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15203b != null) goto L9;
        f15203b = new c(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f15203b;
    }

    public void a(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.f15204a.a(r4);
    }

    public boolean a() {
        return this.f15204a.a();
    }

    public boolean b() {
        return this.f15204a.b();
    }

    public void c() {
        this.f15204a.c();
    }
}
