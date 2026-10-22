package x4;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f13433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f13436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d0.d.a f13438g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f13441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13442d;

        public a() {
            this.f13439a = false;
            this.f13440b = 0;
            this.f13441c = 0;
            this.f13442d = 0;
        }
    }

    public i(Context r8, j0 r10) {
        this.f13434c = 0;
        this.f13432a = r8;
        this.f13433b = r10;
        this.f13436e = j.c(String.valueOf(r10.f13463a));
    }

    public abstract void a();

    public abstract boolean b();

    public abstract String c();

    public abstract long[] d();

    public abstract void e();

    public abstract void f();

    public abstract long g();

    public abstract void h(boolean r8);

    public abstract void i(int r8);

    /* JADX WARN: Multi-variable type inference failed */
    public final a j() {
        f();
        int r8 = 1;
        boolean r10 = 0;
        r10 = 0;
        if (k5.e.a(this.f13432a) == false) goto L5;
        Object[] r11 = true;
    L6:
        a r12 = new a();
        if (r11 == true) goto L9;
        c();
        int r13 = r.f13543a;
        long r14 = 60000;
    L24:
        r12.f13440b = r8;
        r12.f13439a = r10;
        r12.f13441c = r14;
        return r12;
    L9:
        long r15 = g() + this.f13435d;
        long r16 = System.currentTimeMillis();
        if (r15 <= (1000 + r16)) goto L26;
        r14 = r15 - r16;
        c();
        int r17 = r.f13543a;
        r8 = 2;
        goto L24
    L26:
        boolean r18 = b();     // Catch: Exception -> L13
    L15:
        if (r18 == false) goto L17;
        r12.f13442d = this.f13434c;
        this.f13434c = 0;
        this.f13435d = System.currentTimeMillis();
        r14 = g();
        int r19 = 0;
    L22:
        c();
        int r110 = r.f13543a;
        r10 = r8;
        r8 = r19;
        goto L24
    L17:
        long[] r20 = d();
        int r21 = this.f13434c;
        int r22 = r21 + 1;
        this.f13434c = r22;
        int r23 = r21 % r20.length;
        long r24 = r20[r23];
        if (r23 != (r20.length - 1)) goto L20;
        r12.f13442d = r22;
        r19 = 4;
    L21:
        r8 = 0;
        r14 = r24;
        goto L22
    L20:
        r19 = 3;
    L13:
        e = move-exception;
        e.printStackTrace();
        int r25 = r.f13543a;
        r18 = false;
        goto L15
    L5:
        r11 = false;
        goto L6
    }

    public i(Context r8, j0 r10, long r11) {
        this.f13434c = 0;
        this.f13432a = r8;
        this.f13433b = r10;
        this.f13435d = r11;
        this.f13436e = j.c(String.valueOf(r10.f13463a));
    }
}
