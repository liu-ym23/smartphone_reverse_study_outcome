package com.ss.android.lark.passportc.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ Ref.ObjectRef<List<Function1<f0c.h, Unit>>> a;
    public final /* synthetic */ f0c.h b;

    public i0(Ref.ObjectRef<List<Function1<f0c.h, Unit>>> r1, f0c.h r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterable r0 = (Iterable) this.a.element;     // Catch: Throwable -> L7
        f0c.h r1 = this.b;     // Catch: Throwable -> L7
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L7
    L4:
        if (r2.hasNext() == false) goto L16;
        ((Function1) r2.next()).invoke(r1);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
