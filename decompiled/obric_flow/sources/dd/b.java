package dd;

import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.ies.bullet.core.e;
import h.d;
import h.f;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16638b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f16637a = r10;
        this.f16638b = r5;
    }

    @Override // h.d
    public final Object a(f r5) {
        switch(this.f16637a) {
            case 0: goto L61;
            case 1: goto L35;
            default: goto L4;
        };
    L4:
        Object r10 = r5.f17267a;
        monitor-enter(r10);
        boolean r11 = r5.f17269c;     // Catch: Throwable -> L31
        monitor-exit(r10);     // Catch: Throwable -> L31
        i r12 = (i) this.f16638b;
        if (r11 == false) goto L16;
        if (((f) ((k6.a) r12.d).f18623a).g() == false) goto L14;
        return null;
    L14:
        throw new IllegalStateException("Cannot cancel a completed task.");
    L16:
        if (r5.e() == false) goto L18;
        ((k6.a) r12.d).h(r5.c());
        return null;
    L18:
        k6.a r13 = (k6.a) r12.d;
        Object r14 = r5.f17267a;
        monitor-enter(r14);
        Object r15 = r5.d;     // Catch: Throwable -> L28
        monitor-exit(r14);     // Catch: Throwable -> L28
        if (((f) r13.f18623a).d(r15) == false) goto L27;
        return null;
    L27:
        throw new IllegalStateException("Cannot set the result of a completed task.");
    L28:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    L61:
        e r16 = (e) this.f16638b;
        if (r16 == null) goto L67;
        com.bytedance.ies.bullet.service.monitor.b r17 = r16.f5293c;
        if (r17 == null) goto L67;
        r17.t();
    L67:
        return Unit.INSTANCE;
    L35:
        if (r5.e() == false) goto L50;
        Exception r18 = r5.c();
        f r19 = new f();
        Object r20 = r19.f17267a;
        monitor-enter(r20);
    L43:
        th = move-exception;
        throw th;
    L39:
        if (r19.f17268b == true) goto L45;
        r19.f17268b = true;     // Catch: Throwable -> L43
        r19.e = r18;     // Catch: Throwable -> L43
        r19.f17267a.notifyAll();     // Catch: Throwable -> L43
        r19.f();     // Catch: Throwable -> L43
        monitor-exit(r20);     // Catch: Throwable -> L43
        return r19;
    L45:
        monitor-exit(r20);     // Catch: Throwable -> L43
        throw new IllegalStateException("Cannot set the error on a completed task.");
    L50:
        Object r21 = r5.f17267a;
        monitor-enter(r21);
        boolean r22 = r5.f17269c;     // Catch: Throwable -> L58
        monitor-exit(r21);     // Catch: Throwable -> L58
        if (r22 == false) goto L57;
        return f.f17266l;
    L57:
        return r5.a((b) this.f16638b);
    L58:
        th = move-exception;
        throw th;
    }
}
