package com.obric.assistant.state.impl.multitask.producer;

import aha.b0;
import aha.c0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import jha.g;
import jha.l;
import jha.m;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0013\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u001e\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/SelfUpdateDownloadStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateService", "Lcom/obric/update/api/v2/IObricUpdateService;", "activeHandle", "Lcom/obric/assistant/state/multitask/core/TaskHandle;", "Lcom/obric/assistant/state/api/multitask/state/SelfUpdateDownloadTaskState;", "refreshJob", "Lkotlinx/coroutines/Job;", "maxHoldJob", "maxExpiredUntilStateExit", "", "refreshSequence", "", "updateListener", "com/obric/assistant/state/impl/multitask/producer/SelfUpdateDownloadStateProducer$updateListener$1", "Lcom/obric/assistant/state/impl/multitask/producer/SelfUpdateDownloadStateProducer$updateListener$1;", "initProducer", "", "handleUpdateState", "state", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startOrRefreshTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleRefresh", "handle", "scheduleMaxHold", "endTask", "reason", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelfUpdateDownloadStateProducer implements TaskFlowAutoInitProducer {
    public static final /* synthetic */ int i = 0;
    public final CoroutineScope a;
    public IObricUpdateService b;
    public l<c0> c;
    public Job d;
    public Job e;
    public boolean f;
    public int g;
    public final SelfUpdateDownloadStateProducer$updateListener$1 h;

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 != null) goto L6;
        FLogger.a.e("SelfUpdateDownloadStateProducer", "IObricUpdateService is unavailable");
        return;
    L6:
        this.b = r0;
        r0.f(this.h);
        FLogger.a.i("SelfUpdateDownloadStateProducer", "initialized");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer$updateListener$1] */
    public SelfUpdateDownloadStateProducer() {
        ExecutorCoroutineDispatcher r0 = jha.f.a;
        Intrinsics.checkNotNullParameter("SelfUpdateDownloadStateProducer", "orderingDomain");
        this.a = jha.f.b("SelfUpdateDownloadStateProducer").b;
        this.h = new SelfUpdateDownloadStateProducer$updateListener$1(this);
    }

    public final void a(String r5) {
        l<c0> r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        this.c = null;
        Job r2 = this.d;
        if (r2 == null) goto L8;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L8:
        this.d = null;
        Job r3 = this.e;
        if (r3 == null) goto L11;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L11:
        this.e = null;
        TaskFlowDslKt.c(r0, new c0.b(r5));
        FLogger.a.i("SelfUpdateDownloadStateProducer", "self-update download task ended, reason=".concat(r5));
    }

    public final Object b(Continuation<? super Unit> r12) {
        if ((r12 instanceof startOrRefreshTask.1) == false) goto L7;
        startOrRefreshTask.1 r0 = (startOrRefreshTask.1) r12;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        c0.a r4 = (c0.a) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L22:
        m r14 = (m) r13;
        if (r14 != null) goto L26;
        FLogger.a.e("SelfUpdateDownloadStateProducer", "failed to acquire self-update download task handle");
        return Unit.INSTANCE;
    L26:
        l<c0> r5 = r14.a;
        this.c = r5;
        if (r14.b == true) goto L29;
        TaskFlowDslKt.f(r5, r4);
    L29:
        l r6 = r14.a;
        Job r7 = this.d;
        if (r7 == null) goto L32;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L32:
        this.d = BuildersKt.launch$default(this.a, null, null, new scheduleRefresh.1(this, r6, null), 3, null);
        l r15 = r14.a;
        Job r8 = this.e;
        if (r8 == null) goto L35;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L35:
        this.e = BuildersKt.launch$default(this.a, null, null, new scheduleMaxHold.1(this, r15, null), 3, null);
        FLogger.a.i("SelfUpdateDownloadStateProducer", "self-update download task started");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        l<c0> r16 = this.c;
        if (r16 == null) goto L18;
        TaskFlowDslKt.f(r16, new c0.a(this.g));
        return Unit.INSTANCE;
    L18:
        this.g = 0;
        c0.a r9 = new c0.a(0);
        g r17 = TaskFlowDslKt.b(b0.a, "self_update_download");
        jha.c r10 = jha.j.a.a(this);
        r0.L$0 = r9;
        r0.label = 1;
        r13 = TaskFlowDslKt.e(r17, r9, r10, r0);
        if (r13 != r2) goto L21;
        return r2;
    L21:
        r4 = r9;
    L7:
        r0 = new startOrRefreshTask.1(this, r12);
        goto L8
    }
}
