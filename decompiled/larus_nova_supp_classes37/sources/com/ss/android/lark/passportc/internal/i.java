package com.ss.android.lark.passportc.internal;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements t {
    @Inject
    public i() {
    }

    @Override // com.ss.android.lark.passportc.internal.t
    public final Executor d() {
        return (ExecutorService) DefaultPassportExecutorsKt.d.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.t
    public final ExecutorScheduler e() {
        return new ExecutorScheduler(d(), false);
    }

    @Override // com.ss.android.lark.passportc.internal.t
    public final Executor f() {
        return (ExecutorService) DefaultPassportExecutorsKt.b.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.t
    public final Executor h() {
        return (Executor) DefaultPassportExecutorsKt.a.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.t
    public final Executor g() {
        return DefaultPassportExecutorsKt.c;
    }
}
