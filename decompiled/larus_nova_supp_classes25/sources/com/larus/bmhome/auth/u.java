package com.larus.bmhome.auth;

import com.google.gson.Gson;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function0 {
    public final /* synthetic */ AuthViewModel a;

    public /* synthetic */ u(AuthViewModel r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AuthViewModel r0 = this.a;
        AtomicBoolean r1 = AuthViewModel.A;
        r0.O("clear launch cache");
        Gson r2 = z0.a;
        z0.l = null;
        z0.m = null;
        z0.n = null;
        z0.o = null;
        return Unit.INSTANCE;
    }
}
