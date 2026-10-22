package c7;

import android.view.Choreographer;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f1139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.sdk.xbridge.cn.auth.g f1140c;
    public com.lynx.tasm.behavior.d d;
    public e e;
    public LinkedList f;
    public HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1144k;

    public final void a() {
        if (this.f1139b == true) goto L5;
        return;
    L5:
        long r5 = this.f1143j - this.f1142i;
        if (r5 <= 0) goto L15;
        int r10 = this.f1144k;
        if (r10 <= 1) goto L15;
        long r11 = (((long) (r10 - 1)) * 1000000000) / r5;
        com.bytedance.sdk.xbridge.cn.auth.g r12 = this.f1140c;
        if (r12 == null) goto L13;
        r12.c();
    L13:
        d r13 = c.f1133a;
        HashMap r14 = this.g;
        r13.getClass();
        z6.b.f23409a.d(new a(r13, this.f1138a, r14, r11));
    L15:
        if (this.e == null) goto L17;
        Choreographer.getInstance().removeFrameCallback(this.e);
    L17:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L19:
        if (this.f.isEmpty() == false) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L22
    L27:
        this.f1139b = false;
        return;
    L24:
        LinkedList r15 = this.f;     // Catch: Throwable -> L22
        this.f = new LinkedList();     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        z6.b.f23409a.d(new ab.b(1, this, false, r15));
        goto L27
    }
}
