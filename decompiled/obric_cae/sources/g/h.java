package g;

import android.view.View;
import android.view.animation.Interpolator;
import j0.h0;
import j0.i0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<h0> f7490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f7492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0 f7493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f7495f;

    public class a extends t2.b {
        public boolean H;
        public int I;
        public final /* synthetic */ h J;

        public a(h r8) {
            this.J = r8;
            this.H = false;
            this.I = 0;
        }

        @Override // t2.b, j0.i0
        public final void c() {
            if (this.H == false) goto L5;
            return;
        L5:
            this.H = true;
            i0 r8 = this.J.f7493d;
            if (r8 == null) goto L9;
            r8.c();
            return;
        }

        @Override // j0.i0
        public final void d() {
            int r8 = this.I + 1;
            this.I = r8;
            h r10 = this.J;
            if (r8 != r10.f7490a.size()) goto L9;
            i0 r11 = r10.f7493d;
            if (r11 == null) goto L7;
            r11.d();
        L7:
            this.I = 0;
            this.H = false;
            r10.f7494e = false;
            return;
        }
    }

    public h() {
        this.f7491b = -1;
        this.f7495f = new a(this);
        this.f7490a = new ArrayList();
    }

    public final void a() {
        if (this.f7494e == true) goto L5;
        return;
    L5:
        Iterator<h0> r8 = this.f7490a.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        r8.next().b();
        goto L7
    L9:
        this.f7494e = false;
    }

    public final void b() {
        if (this.f7494e == false) goto L5;
        return;
    L5:
        Iterator<h0> r8 = this.f7490a.iterator();
    L7:
        if (r8.hasNext() == false) goto L22;
        h0 r10 = r8.next();
        long r11 = this.f7491b;
        if (r11 < 0) goto L11;
        r10.c(r11);
    L11:
        Interpolator r12 = this.f7492c;
        if (r12 == null) goto L17;
        View r13 = r10.f8388a.get();
        if (r13 == null) goto L17;
        r13.animate().setInterpolator(r12);
    L17:
        if (this.f7493d == null) goto L19;
        r10.d(this.f7495f);
    L19:
        View r14 = r10.f8388a.get();
        if (r14 == null) goto L7;
        r14.animate().start();
        goto L7
    L22:
        this.f7494e = true;
    }
}
