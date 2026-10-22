package jc8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.im.FlowRuntime;
import jc8.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class b<T extends a> {
    public k a;
    public String b;
    public View c;

    public b() {
    }

    public void a() {
    }

    public void g(T r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
    }

    public void i() {
    }

    public String c() {
        return getClass().getSimpleName();
    }

    public final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        this.b = r2.h();
        if (FlowRuntime.a().isDebug() == false) goto L12;
        g(r2);
    L10:
        a();
        return;
    L12:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        g(r2);     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Result.box-impl(r3);
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final d e(a r4) {
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        if (FlowRuntime.a().isDebug() == false) goto L15;
        d r0 = f(r4);
    L14:
        return e.a(r4, r0);
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(f(r4));     // Catch: Throwable -> L7
    L9:
        d r3 = new d(0, 0, 0, 0);
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = r3;
    L12:
        r0 = (d) r2;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public d f(T r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        return new d(0, 0, 0, 0);
    }

    public View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        return new View(r2.getContext());
    }
}
