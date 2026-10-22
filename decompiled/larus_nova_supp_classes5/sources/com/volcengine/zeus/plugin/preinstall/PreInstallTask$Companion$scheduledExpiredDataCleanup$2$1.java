package com.volcengine.zeus.plugin.preinstall;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
public final class PreInstallTask$Companion$scheduledExpiredDataCleanup$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Job $job;

    public PreInstallTask$Companion$scheduledExpiredDataCleanup$2$1(Job r1) {
        this.$job = r1;
        super(1);
    }

    public final void invoke(Throwable r2) {
        if (Intrinsics.areEqual(this.$job, PreInstallTask.f) == false) goto L6;
        PreInstallTask.f = null;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
