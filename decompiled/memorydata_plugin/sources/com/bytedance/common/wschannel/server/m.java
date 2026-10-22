package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class m extends PluginBroadcastReceiver {
    private static boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f2195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2196b;
    private NetworkUtils.NetworkType c;

    static {
    }

    @Deprecated
    public m() {
        this.f2196b = true;
    }

    public m(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f2196b = true;
        this.c = NetworkUtils.b(r5);
        this.f2195a = r4;
    }

    static /* synthetic */ b a(m r0) {
        return r0.f2195a;
    }

    private void a(Context r2) {
        boolean r1 = com.bytedance.common.wschannel.l.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).c();     // Catch: Throwable -> L7
        if (r1 == d) goto L10;
        d = r1;     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    static /* synthetic */ void a(m r2, Context r3) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a() {
        return d;
    }

    public void onReceive(Context r3, Intent r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.f2195a != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r4.getAction()) == false) goto L12;
        return;
    L12:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r4.getAction()) == true) goto L15;
        return;
    L15:
        if (this.f2196b == false) goto L19;
        this.f2196b = false;
        if (NetworkUtils.b(r5) != this.c) goto L19;
        return;
    L19:
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r5));
        return;
    }
}
