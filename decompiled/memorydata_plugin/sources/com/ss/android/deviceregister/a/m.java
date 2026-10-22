package com.ss.android.deviceregister.a;

import android.content.Context;
import com.bytedance.bdinstall.oaid.Oaid;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f15139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15140b;

    private m(Context r3) {
        this.f15140b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public static m a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f15139a != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15139a != null) goto L9;
        f15139a = new m(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f15139a;
    }

    public String a() {
        boolean r0 = com.ss.android.deviceregister.f.a();
        Context r1 = this.f15140b;
        if (r0 == false) goto L7;
        return Oaid.instance(r1).getOaidId();
    L7:
        return s.a(r1).b();
    }

    Map<String, String> a(long r2) {
        boolean r0 = com.ss.android.deviceregister.f.a();
        Context r1 = this.f15140b;
        if (r0 == false) goto L7;
        return Oaid.instance(r1).getOaid(r2);
    L7:
        return s.a(r1).a(r2);
    }

    boolean b() {
        boolean r0 = com.ss.android.deviceregister.f.a();
        Context r1 = this.f15140b;
        if (r0 == false) goto L7;
        return Oaid.instance(r1).maySupport();
    L7:
        return s.a(r1).c();
    }
}
