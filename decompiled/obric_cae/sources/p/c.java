package p;

import android.content.Context;
import android.util.SparseArray;
import he.i;
import p1.k;
import p1.l;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f9869d;

    public c(int r8) {
        if (r8 == 1) goto L6;
        this.f9866a = new f(0);
        this.f9867b = new f(0);
        this.f9868c = new f(0);
        this.f9869d = new h[32];
        return;
    L6:
        this.f9866a = new n.b();
        this.f9867b = new SparseArray();
        this.f9868c = new n.e();
        this.f9869d = new n.b();
    }

    public c(Context r8, u1.b r10) {
        i.f(r8, "context");
        Context r11 = r8.getApplicationContext();
        i.e(r11, "context.applicationContext");
        p1.a r12 = new p1.a(r11, r10);
        Context r13 = r8.getApplicationContext();
        i.e(r13, "context.applicationContext");
        p1.c r14 = new p1.c(r13, r10, 0);
        Context r15 = r8.getApplicationContext();
        i.e(r15, "context.applicationContext");
        String r16 = l.f9931a;
        k r17 = new k(r15, r10);
        Context r18 = r8.getApplicationContext();
        i.e(r18, "context.applicationContext");
        p1.c r19 = new p1.c(r18, r10, 1);
        this.f9866a = r12;
        this.f9867b = r14;
        this.f9868c = r17;
        this.f9869d = r19;
    }
}
