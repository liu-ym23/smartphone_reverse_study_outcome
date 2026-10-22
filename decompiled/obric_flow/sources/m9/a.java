package m9;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f20025c;
    public final /* synthetic */ int d;
    public final /* synthetic */ c e;

    public a(int r5, long r10, String r11, String r12, c r13) {
        this.e = r13;
        this.f20023a = r11;
        this.f20024b = r12;
        this.f20025c = r10;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r5 = this.f20025c;
        String r10 = this.f20024b;
        String r11 = this.f20023a;
        c r12 = this.e;     // Catch: Throwable -> L18
        int r13 = r12.e.size();     // Catch: Throwable -> L18
        int r14 = r12.f20048t;     // Catch: Throwable -> L18
        LinkedList r15 = r12.e;
        if (r13 < r14) goto L9;
        b r16 = (b) r15.poll();     // Catch: Throwable -> L18
        if (r16 == null) goto L10;
        r15.add(r16);     // Catch: Throwable -> L18
    L10:
        if (r16 != null) goto L12;
        r16 = new b();     // Catch: Throwable -> L18
        r16.f20027b = r10;     // Catch: Throwable -> L18
        r16.f20028c = r5;     // Catch: Throwable -> L18
        r16.f20026a = r11;     // Catch: Throwable -> L18
        r15.add(r16);     // Catch: Throwable -> L18
    L12:
        r16.f20027b = r10;     // Catch: Throwable -> L18
        r16.f20026a = r11;     // Catch: Throwable -> L18
        r16.f20028c = r5;     // Catch: Throwable -> L18
        goto L13
    L9:
        r16 = null;
    L13:
        String r17 = r11 + '.' + r10 + '@' + Long.toHexString(this.d);
        File r18 = com.bytedance.android.anniex.base.service.e.c();     // Catch: Throwable -> L19
        if (r18 == null) goto L24;
        cl.a.u(com.bytedance.android.anniex.base.service.e.f3128b + " activityLifeCycle " + r17 + ' ' + p.o().format(new Date(r5)) + '\n', r18, true);     // Catch: Throwable -> L19
        return;
    L24:
        return;
    }
}
