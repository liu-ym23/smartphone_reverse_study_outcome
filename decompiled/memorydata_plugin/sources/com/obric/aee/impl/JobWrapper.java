package com.obric.aee.impl;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/aee/impl/JobWrapper;", "", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JobWrapper {
    private final bx job;

    public JobWrapper(bx r3) {
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "job");
        this.job = r4;
    }

    public final void cancel() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        bx.a.a(((JobWrapper) ZeusTransformUtils.preCheckCast(this, JobWrapper.class, "com.obric.memorydata.plugin")).job, null, 1, null);     // Catch: Throwable -> L4
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public final bx getJob() {
        return this.job;
    }
}
