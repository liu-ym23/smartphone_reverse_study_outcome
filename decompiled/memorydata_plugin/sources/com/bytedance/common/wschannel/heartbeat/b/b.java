package com.bytedance.common.wschannel.heartbeat.b;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.heartbeat.c;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.common.wschannel.heartbeat.a<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2122b;
    private Handler c;
    private AtomicBoolean d;
    private Runnable e;
    private Runnable f;

    public b(a r2) {
        super(r2);
        this.d = new AtomicBoolean(false);
        this.e = new AnonymousClass1(this);
        this.f = new AnonymousClass2(this);
    }

    static /* synthetic */ AtomicBoolean a(b r0) {
        return r0.d;
    }

    static /* synthetic */ void b(b r0) {
        r0.d();
    }

    private void b(Response r14) {
        if (((a) ZeusTransformUtils.preCheckCast(this.f2114a, a.class, "com.obric.memorydata.plugin")).a() == (-1)) goto L6;
        return;
    L6:
        if (r14 != null) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(this.f2114a, a.class, "com.obric.memorydata.plugin")).a(270000);
        return;
    L9:
        String r15 = r14.header("Handshake-Options");
        if (r15 == null) goto L22;
        String[] r16 = r15.split(";");
        int r5 = r16.length;
        long r8 = -1;
        int r7 = 0;
    L12:
        if (r7 >= r5) goto L23;
        String r10 = r16[r7];
        if (TextUtils.isEmpty(r10) == true) goto L21;
        String[] r11 = r10.split("=");
        if ("ping-interval".equals(r11[0]) == false) goto L21;
        r8 = Long.parseLong(r11[1]) * 1000;
    L20:
        r8 = 270000;
    L21:
        r7 = r7 + 1;
    L23:
        T r13 = this.f2114a;
        if (r8 != (-1)) goto L26;
        ((a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin")).a(270000);
        return;
    L26:
        ((a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin")).a(r8);
        return;
    L22:
        r8 = -1;
        goto L23
    }

    static /* synthetic */ c c(b r0) {
        return r0.f2122b;
    }

    private void d() {
        this.c.removeCallbacks(this.e);
        this.c.removeCallbacks(this.f);
        this.d.set(false);
    }

    static /* synthetic */ void d(b r0) {
        r0.e();
    }

    private void e() {
        long r0 = ((a) ZeusTransformUtils.preCheckCast(this.f2114a, a.class, "com.obric.memorydata.plugin")).a();
        Logger.d("WsChannelSdk_ok", "interval :" + r0 + " ms,the next time to send heartbeat is " + com.bytedance.common.wschannel.c.c.a(System.currentTimeMillis() + r0));
        this.c.removeCallbacks(this.f);
        this.c.postDelayed(this.f, r0);
    }

    private void f() {
        this.d.set(true);
        this.c.removeCallbacks(this.e);
        this.c.postDelayed(this.e, ((a) ZeusTransformUtils.preCheckCast(this.f2114a, a.class, "com.obric.memorydata.plugin")).b());
    }

    @Override // com.bytedance.common.wschannel.heartbeat.d
    public void a() {
        Logger.d("WsChannelSdk_ok", "receive pong");
        this.d.set(false);
        this.c.removeCallbacks(this.e);
        com.bytedance.common.wschannel.heartbeat.a.a.a().b();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.a
    public void a(c r3, Handler r4) {
        this.f2122b = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.d
    public void a(AppState r1) {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.d
    public void a(Response r3) {
        Logger.d("WsChannelSdk_ok", "connect success，ready to send ping");
        b(r3);
        e();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.d
    public void b() {
        Logger.d("WsChannelSdk_ok", "ping sent，waiting for pong");
        f();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.d
    public void c() {
        Logger.d("WsChannelSdk_ok", "disconnected，stop to send ping");
        d();
    }
}
