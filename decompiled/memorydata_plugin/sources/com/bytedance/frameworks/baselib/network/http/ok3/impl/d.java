package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2461a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.e f2462b;
    private PluginBroadcastReceiver c;

    static {
    }

    public d() {
        this.f2462b = new com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.e();
        this.c = new AnonymousClass1(this);
    }

    private void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ZeusTransformUtils.registerReceiver(r5, this.c, r0, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L9;
        Logger.d(f2461a, "register network state changed completed");
        return;
    L9:
        return;
    }

    private void c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(f2461a, "register activity forground and background switch Callback");
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Application.class) == false) goto L11;
        Application r6 = (Application) ZeusTransformUtils.preCheckCast(r5, Application.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        this.f2462b.a(this);
        r6.registerActivityLifecycleCallbacks(this.f2462b);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.e.a
    public void a() {
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.a().h();
    }

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        b(r4);
        c(r4);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.e.a
    public void b() {
    }
}
