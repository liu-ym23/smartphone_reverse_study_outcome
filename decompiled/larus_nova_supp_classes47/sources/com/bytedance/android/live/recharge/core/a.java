package com.bytedance.android.live.recharge.core;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, e {
    public g a;

    public a() {
    }

    public final void onStop() {
    }

    public final void onStart() {
        cy0.e.a.getClass();
        g r0 = new g(cy0.e.a.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = k.a;
        l.a(r0);
        Unit r2 = Unit.INSTANCE;
        this.a = r0;
    }

    @Override // com.bytedance.android.live.recharge.core.d
    public final <T extends c> T a(KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        m r0 = m.e;
        g r1 = this.a;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_rechargeScope");
    L6:
        return (T) r0.d(r1, JvmClassMappingKt.getJavaClass(r4));
    }

    @Override // com.bytedance.android.live.recharge.core.d
    public final <T extends c> T f(KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        m r0 = m.e;
        g r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_rechargeScope");
    L5:
        T r2 = (T) r0.d(r1, JvmClassMappingKt.getJavaClass(r4));
        if (r2 == null) goto L9;
        return r2;
    L9:
        throw new IllegalStateException(("Required service " + r4 + " not found").toString());
    }
}
