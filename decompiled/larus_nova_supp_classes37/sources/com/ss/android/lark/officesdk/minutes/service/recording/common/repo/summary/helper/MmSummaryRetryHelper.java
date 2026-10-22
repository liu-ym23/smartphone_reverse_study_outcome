package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSummaryRetryHelper {
    public static final List<Long> e = null;
    public static final int f = 0;
    public final CoroutineScope a;
    public final Function1<Continuation<? super Unit>, Object> b;
    public Job c;
    public final AtomicInteger d;

    public static final class a {
    }

    static {
        List<Long> r0 = CollectionsKt.listOf(new Long[]{5000L, 15000L, Long.valueOf(MmUploadRetryConfigSetting.MAX_INTERVAL_MS), 60000L});
        e = r0;
        f = r0.size();
    }

    public final void a() {
        lvb.a.e("MmSummaryRetryHelper", "reset, retryCount: " + this.d.get());
        Job r0 = this.c;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.c = null;
        this.d.set(0);
    }

    public final void b() {
        if (this.d.get() < f) goto L6;
        lvb.a.a("MmSummaryRetryHelper", "startRetry, max retry count reached: " + this.d.get());
        return;
    L6:
        Job r0 = this.c;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        this.c = null;
        this.c = BuildersKt.launch$default(this.a, null, null, new MmSummaryRetryHelper$startRetry$1(this.d.get(), this, null), 3, null);
    }

    public MmSummaryRetryHelper(CoroutineScope r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "onRetry");
        this.a = r2;
        this.b = r3;
        this.d = new AtomicInteger(0);
    }
}
