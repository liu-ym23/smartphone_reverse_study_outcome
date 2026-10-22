package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AddressSDKLog$e$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $logTime;
    final /* synthetic */ String $msg;
    final /* synthetic */ Throwable $throwable;

    public AddressSDKLog$e$1(String r1, long r10, Throwable r11) {
        this.$msg = r1;
        this.$logTime = r10;
        this.$throwable = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1141invoke() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        dm.a.a("AddressSdk").b(this.$msg + " log_time=" + this.$logTime, this.$throwable);     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r10 = Result.exceptionOrNull-impl(r1);
        if (r10 == null) goto L12;
        ECExceptionMonitor.e(r10);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1141invoke();
        return Unit.INSTANCE;
    }
}
