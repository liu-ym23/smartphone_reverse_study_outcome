package com.larus.bmhome.auth;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function0 {
    public final /* synthetic */ AuthViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ r(AuthViewModel r1, String r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        AuthViewModel r0 = this.a;
        String r1 = this.b;
        boolean r2 = this.c;
        boolean r3 = this.d;
        AtomicBoolean r4 = AuthViewModel.A;
        AuthViewModel.Z(r0, r1, r2, r3, false, r0.e0(r1, SetsKt.setOf(LaunchBiz.CORE), false));
        return Unit.INSTANCE;
    }
}
