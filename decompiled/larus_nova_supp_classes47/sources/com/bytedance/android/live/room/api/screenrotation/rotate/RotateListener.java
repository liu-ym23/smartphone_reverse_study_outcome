package com.bytedance.android.live.room.api.screenrotation.rotate;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RotateListener<T> implements b<T>, a {
    public Function2<? super d, ? super h<T>, Boolean> a;
    public Function2<? super d, ? super h<T>, Unit> b;
    public Function2<? super d, ? super h<T>, Unit> c;
    public Function2<? super d, ? super h<T>, Unit> d;

    public RotateListener() {
        this.a = RotateListener$onIsForceRotate$1.INSTANCE;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void b(Function2<? super d, ? super h<T>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "rotateCallback");
        this.c = r2;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void d(Function2<? super d, ? super h<T>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "rotateCallback");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void e(Function2<? super d, ? super h<T>, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "rotateCallback");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.b
    public final void f(Function2<? super d, ? super h<T>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "rotateCallback");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void a(d r2, RotateInnerRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "request");
        Function2<? super d, ? super h<T>, Unit> r0 = this.c;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void c(d r2, RotateInnerRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "request");
        Function2<? super d, ? super h<T>, Unit> r0 = this.b;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final boolean g(d r2, RotateInnerRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "request");
        Function2<? super d, ? super h<T>, Boolean> r0 = this.a;
        if (r0 == null) goto L5;
        Boolean r4 = (Boolean) r0.invoke(r2, r3);
    L7:
        return r4.booleanValue();
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.a
    public final void h(d r2, RotateInnerRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "request");
        Function2<? super d, ? super h<T>, Unit> r0 = this.d;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r2, r3);
        return;
    }
}
