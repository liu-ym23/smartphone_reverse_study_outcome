package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.hilt.EntryPoints;
import dagger.hilt.components.SingletonComponent;
import dagger.internal.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements com.ss.android.lark.passportc.internal.b0 {
    public final Application a;

    @Override // com.ss.android.lark.passportc.internal.w
    public final e0c.m a() {
        v r0 = new v();
        Object r1 = EntryPoints.get(this.a, SingletonComponent.class);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.officesdk.HiltRoot_HiltComponents.SingletonC");
        r0.d = (w0) Preconditions.checkNotNull((w0) r1);
        return r0;
    }

    @Override // com.ss.android.lark.passportc.internal.c
    public final e0c.b b() {
        c r0 = new c();
        Object r1 = EntryPoints.get(this.a, SingletonComponent.class);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.officesdk.HiltRoot_HiltComponents.SingletonC");
        r0.d = (w0) Preconditions.checkNotNull((w0) r1);
        return r0;
    }

    @Inject
    public a(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a = r2;
    }
}
