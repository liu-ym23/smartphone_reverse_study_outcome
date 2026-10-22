package e0;

import com.bumptech.glide.load.data.l;
import d0.g;
import d0.o;
import d0.p;
import d0.q;
import d0.r;
import java.util.ArrayDeque;
import ym.j;

/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z.e f16723b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f16724a;

    static {
        f16723b = z.e.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");
    }

    public a(j r5) {
        this.f16724a = r5;
    }

    @Override // d0.r
    public final /* bridge */ /* synthetic */ boolean a(Object r5) {
        g r10 = (g) r5;
        return true;
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        g r13 = (g) r5;
        j r14 = this.f16724a;
        if (r14 == null) goto L16;
        p r15 = p.a(r13);
        o r16 = (o) r14.f23302a;
        Object r17 = r16.a(r15);
        ArrayDeque r18 = p.f16563b;
        monitor-enter(r18);
        r18.offer(r15);     // Catch: Throwable -> L12
        monitor-exit(r18);     // Catch: Throwable -> L12
        g r19 = (g) r17;
        if (r19 != null) goto L11;
        r16.e(p.a(r13), r13);
        goto L16
    L11:
        r13 = r19;
    L12:
        th = move-exception;
        throw th;
    L16:
        return new q(r13, new l(r13, ((Integer) r12.c(f16723b)).intValue()));
    }
}
