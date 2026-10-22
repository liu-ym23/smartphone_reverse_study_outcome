package m58;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import o68.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ h$a a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ long e;
    public final /* synthetic */ Function0 f;

    public /* synthetic */ c(h$a r1, Function0 r2, Ref.ObjectRef r3, Ref.ObjectRef r4, long r5, Function0 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final h$a r0 = this.a;
        final Function0 r1 = this.b;
        final Ref.ObjectRef r2 = this.c;
        final Ref.ObjectRef r3 = this.d;
        long r4 = this.e;
        final Function0 r6 = this.f;
        if (r0.a.get() == true) goto L39;
        MutableLiveData r7 = h.p;
        Object r8 = r7.getValue();
        Boolean r9 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r9) == true) goto L8;
        r2.element = new f(r0, r2, r3, r1);
        if (r4 <= 0) goto L13;
        Runnable r10 = new g(r0, r2, r6);
    L14:
        r3.element = r10;
        Observer r11 = (Observer) r2.element;
        if (r11 == null) goto L18;
        r7.observeForever(r11);
    L18:
        if (r0.a.get() == true) goto L36;
        Runnable r12 = (Runnable) r3.element;
        if (r12 == null) goto L23;
        b.a.postDelayed(r12, r4);
    L23:
        if (Intrinsics.areEqual(r7.getValue(), r9) == true) goto L25;
        return;
    L25:
        if (r0.a.compareAndSet(false, true) == false) goto L38;
        Observer r5 = (Observer) r2.element;
        if (r5 == null) goto L29;
        r7.removeObserver(r5);
    L29:
        Runnable r13 = (Runnable) r3.element;
        if (r13 == null) goto L32;
        b.a.removeCallbacks(r13);
    L32:
        r1.invoke();
        return;
    L38:
        return;
    L36:
        return;
    L13:
        r10 = null;
        goto L14
    L8:
        if (r0.a.compareAndSet(false, true) == false) goto L34;
        r1.invoke();
        return;
    L34:
        return;
    }
}
