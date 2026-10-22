package com.larus.api.serviceimpl;

import com.larus.e_commerce.api.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import n48.b;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AoEcomServiceImpl$c implements d {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ Function1<Boolean, Unit> c;
    public final /* synthetic */ Function2<Float, Float, Unit> d;
    public final /* synthetic */ Function0<Unit> e;

    public final void b() {
        this.e.invoke();
    }

    public final void c() {
        this.a.set(true);
    }

    public final void onDestroy() {
        this.e.invoke();
    }

    public final void onResume() {
        if (this.a.get() == true) goto L5;
        return;
    L5:
        if (this.b.get() == false) goto L9;
        this.c.invoke(Boolean.TRUE);
        return;
    }

    public final void a(boolean r2) {
        this.b.set(r2);
        this.c.invoke(Boolean.valueOf(r2));
    }

    public final void d(int r3, int r4) {
        this.d.invoke(Float.valueOf(r3 - c7.b(46)), Float.valueOf(r4));
    }

    public AoEcomServiceImpl$c(AtomicBoolean r1, AtomicBoolean r2, Function1 r3, Function2 r4, b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
