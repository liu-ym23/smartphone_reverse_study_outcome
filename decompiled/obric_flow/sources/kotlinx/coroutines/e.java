package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18821b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0[] f18822a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    static {
        f18821b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");
    }

    public e(m0[] r5) {
        this.f18822a = r5;
        this.notCompletedCount$volatile = r5.length;
    }

    public final Object a(ContinuationImpl r10) {
        l r5 = new l(1, IntrinsicsKt.intercepted(r10));
        r5.w();
        Job[] r11 = this.f18822a;
        int r12 = r11.length;
        c[] r13 = new c[r12];
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        Job r16 = r11[r15];
        ((r1) r16).start();
        c r17 = new c(this, r5);
        r17.f = j0.i(r16, r17);
        Unit r18 = Unit.INSTANCE;
        r13[r15] = r17;
        r15 = r15 + 1;
        goto L3
    L5:
        d r19 = new d(r13);
    L6:
        if (r14 >= r12) goto L9;
        c r20 = r13[r14];
        r20.getClass();
        c.f18774h.set(r20, r19);
        r14 = r14 + 1;
        goto L6
    L9:
        if ((l.g.get(r5) instanceof w1) == true) goto L11;
        r19.a();
    L12:
        Object r21 = r5.v();
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L15:
        return r21;
    L11:
        r5.z(r19);
        goto L12
    }
}
