package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f1962b;
    PluginBroadcastReceiver c;
    NetworkUtils.NetworkType d;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f1962b = false;
        this.d = NetworkUtils.NetworkType.MOBILE;
        this.f1961a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        b();
    }

    private void b() {
        if (this.f1962b == true) goto L6;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        PluginBroadcastReceiver r1 = new AnonymousClass1(this);
        this.c = r1;
        this.f1962b = true;
        ZeusTransformUtils.registerReceiver(this.f1961a, r1, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L6:
        this.d = NetworkUtils.e(this.f1961a);
    }

    public NetworkUtils.NetworkType a() {
        return this.d;
    }
}
