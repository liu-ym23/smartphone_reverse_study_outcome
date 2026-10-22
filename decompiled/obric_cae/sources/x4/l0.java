package x4;

import android.os.Handler;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f13526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f13527b;

    public l0(k0 r8, s r10) {
        this.f13527b = r8;
        this.f13526a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13527b.f13520e.get() == false) goto L12;
        d0 r8 = this.f13527b.f13517b;
        s r10 = this.f13526a;
        r8.c(r10);
        Handler r11 = r8.f13394m;
        r11.removeMessages(1235);
        if (r11.hasMessages(1234) == false) goto L7;
        r11.removeMessages(1234);
        r11.sendMessage(r11.obtainMessage(1234, Boolean.TRUE));
        return;
    L7:
        d5.l r12 = r8.f13393b;
        y4.b r13 = r8.f13395n;
        j0 r14 = r8.f13392a;
        t0 r15 = new t0(r10, r14, r13, r12);
        r8.f(r15, false);
        r8.f13398q = r15;
        if (r14.f13475m == true) goto L10;
        return;
    L10:
        if (r8.f13397p.get() == false) goto L16;
        r8.b(new c(r14, r10));
        return;
    L16:
        return;
    L12:
        Objects.toString(this.f13526a);
        int r16 = r.f13543a;
        this.f13527b.f13517b.c(this.f13526a);
        k0.k(this.f13527b, true);
        this.f13527b.l();
    }
}
