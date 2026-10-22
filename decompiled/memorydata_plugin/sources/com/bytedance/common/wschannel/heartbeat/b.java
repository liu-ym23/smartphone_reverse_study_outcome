package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppState f2117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f2118b;
    private com.bytedance.common.wschannel.channel.a.a.b.b c;
    private a d;
    private Handler e;
    private Runnable f;

    public interface a {
        void a();
    }

    public b(a r3, Handler r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f2118b = new AtomicBoolean(false);
        this.f = new AnonymousClass1(this);
        this.d = r5;
        this.e = r4;
    }

    static /* synthetic */ AtomicBoolean a(b r0) {
        return r0.f2118b;
    }

    static /* synthetic */ a b(b r0) {
        return r0.d;
    }

    private boolean b(AppState r2) {
        if (this.f2117a == AppState.STATE_BACKGROUND) goto L5;
    L7:
        return false;
    L5:
        if (r2 != AppState.STATE_FOREGROUND) goto L7;
        return true;
    }

    private void c() {
        this.f2118b.set(true);
        this.e.removeCallbacks(this.f);
        this.e.postDelayed(this.f, 5000);
    }

    public void a(com.bytedance.common.wschannel.channel.a.a.b.b r3) {
        this.c = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
    }

    public void a(AppState r3) {
        if (this.f2118b.get() == true) goto L14;
        boolean r0 = false;
        if (b(r3) == false) goto L7;
        Logger.d("WsChannelSdk_ok", "Switch the foreground in the background, send compensation ping");
        r0 = true;
    L7:
        if (r0 == false) goto L14;
        com.bytedance.common.wschannel.channel.a.a.b.b r1 = this.c;     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        r1.c();     // Catch: Exception -> L12
        c();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        this.f2117a = r3;
    }

    public boolean a() {
        return this.f2118b.get();
    }

    public void b() {
        Logger.d("WsChannelSdk_ok", "After compensating for ping, received pong");
        this.f2118b.set(false);
        this.e.removeCallbacks(this.f);
    }
}
