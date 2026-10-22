package com.bytedance.sdk.account.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements WeakHandler.IHandler, IRequest, Comparable<IRequest>, Runnable {
    private static e d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f3129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicBoolean f3130b;
    protected final IRequest.Priority c;
    private WeakHandler e;
    private int f;
    private final String g;

    static {
        d = e.a();
    }

    public c(String r3, IRequest.Priority r4) {
        this.f3129a = new AtomicBoolean(false);
        this.f3130b = new AtomicBoolean(false);
        this.e = new WeakHandler(Looper.getMainLooper(), this);
        this.c = r4;
        if (h.a(r3) == false) goto L5;
        r3 = getClass().getSimpleName();
    L5:
        this.g = r3;
    }

    public int a(IRequest r3) {
        IRequest r4 = (IRequest) ZeusTransformUtils.wrapperContextForParams(r3, IRequest.class, "com.obric.memorydata.plugin");
        IRequest.Priority r0 = g();
        IRequest.Priority r1 = r4.g();
        if (r0 != null) goto L5;
        r0 = IRequest.Priority.NORMAL;
    L5:
        if (r1 != null) goto L7;
        r1 = IRequest.Priority.NORMAL;
    L7:
        if (r0 != r1) goto L9;
        int r2 = h();
        int r5 = r4.h();
    L11:
        return r2 - r5;
    L9:
        r2 = r1.ordinal();
        r5 = r0.ordinal();
        goto L11
    }

    public final c a(int r1) {
        this.f = r1;
        return this;
    }

    public boolean a() {
        return this.f3130b.get();
    }

    public String b() {
        return this.g;
    }

    public boolean c() {
        return false;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(IRequest r3) {
        return a((IRequest) ZeusTransformUtils.preCheckCast(r3, IRequest.class, "com.obric.memorydata.plugin"));
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public final void f() {
        if (this.f3129a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (d != null) goto L8;
        d = e.a();
    L8:
        if (c() == false) goto L10;
        d.a(this);
        return;
    L10:
        d.b(this);
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.IRequest
    public IRequest.Priority g() {
        return this.c;
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.IRequest
    public int h() {
        return this.f;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
        if (r1 != null) goto L16;
        return;
    L16:
        int r0 = r1.what;     // Catch: Throwable -> L12
        if (r0 != 0) goto L7;
        d.e();     // Catch: Throwable -> L12
    L15:
        return;
    L7:
        if (r0 != 1) goto L15;
        d.f();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void i() {
        j();
        this.e.sendEmptyMessageDelayed(0, 1000);
    }

    public void j() {
        this.e.removeMessages(0);
    }

    public void k() {
        l();
        this.e.sendEmptyMessageDelayed(1, 1000);
    }

    public void l() {
        this.e.removeMessages(1);
    }

    public void run() {
    }
}
