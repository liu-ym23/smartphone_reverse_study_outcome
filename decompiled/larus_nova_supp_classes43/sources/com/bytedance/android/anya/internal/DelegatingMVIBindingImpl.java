package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.DiffContext;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.d0;
import com.bytedance.android.anya.p;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class DelegatingMVIBindingImpl<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p, VIEW extends BaseMVIView<STATE, ACTION>> implements m<STATE, ACTION> {
    public final CompositeDisposable a;
    public boolean b;
    public final m<?, ACTION> c;
    public final VIEW d;
    public STATE e;
    public final Function1<DelegatingMVIBindingImpl<STATE, ACTION, VIEW>, Unit> f;

    @Override // com.bytedance.android.anya.q
    public final void a() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.f.invoke(this);
        VIEW r0 = this.d;
        STATE r1 = this.e;
        if (r1 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r0.h(r1, this);
        this.a.add(this.c.d(new DelegatingMVIBindingImpl$bind$1(this.d)));
        this.b = true;
    }

    @Override // com.bytedance.android.anya.internal.m
    public final DiffContext f() {
        return this.c.f();
    }

    @Override // com.bytedance.android.anya.q
    public final void unbind() {
        if (this.b == true) goto L5;
        return;
    L5:
        this.b = false;
        this.d.j();
        this.e = null;
        this.a.clear();
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void b(ACTION r10) {
        this.c.b(r10);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void c(Map<q<?, ?>, ? extends d0<?, ?>> r10) {
        this.c.c(r10);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final Disposable d(Function1<? super a0, Boolean> r10) {
        Disposable r11 = this.c.d(r10);
        this.a.add(r11);
        return r11;
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void e(Map<q<?, ?>, ? extends d0<?, ?>> r10) {
        this.c.e(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingMVIBindingImpl(m<?, ACTION> r1, VIEW r10, STATE r11, Function1<? super DelegatingMVIBindingImpl<STATE, ACTION, VIEW>, Unit> r12) {
        this.c = r1;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.a = new CompositeDisposable();
    }
}
