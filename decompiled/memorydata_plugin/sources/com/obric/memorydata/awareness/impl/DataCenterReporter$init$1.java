package com.obric.memorydata.awareness.impl;

import android.content.Context;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.impl.DataCenterReporter$init$1", f = "DataCenterReporter.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
final class DataCenterReporter$init$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ com.a.a.a.a $locationManager;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    DataCenterReporter$init$1(com.a.a.a.a r3, Context r4, Continuation<? super DataCenterReporter$init$1> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$locationManager = r3;
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataCenterReporter$init$1(this.$locationManager, this.$context, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataCenterReporter$init$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataCenterReporter$init$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x006c -> B:13:0x006f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r5 = this.I$0;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(this.L$1, Context.class, "com.obric.memorydata.plugin");
        com.a.a.a.a r7 = (com.a.a.a.a) ZeusTransformUtils.preCheckCast(this.L$0, com.a.a.a.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L14:
        if (r7.a() == false) goto L18;
        RunLog.INSTANCE.debug("DataCenterReporter", "location service available after retry: true");
        i r10 = i.f8695a;
        Intrinsics.checkNotNull(r7);
        i.a(r10, r6, r7);
        i.a(i.f8695a, r7);
    L17:
        return Unit.INSTANCE;
    L18:
        RunLog.INSTANCE.debug("DataCenterReporter", "location service still unavailable, reconnect ...");
        r7.b();
        r2 = r2 + 1;
    L9:
        if (r2 >= r5) goto L19;
        RunLog.INSTANCE.debug("DataCenterReporter", "retry check service available, attempt: " + (r2 + 1));
        this.L$0 = r7;
        this.L$1 = r6;
        this.I$0 = r5;
        this.I$1 = r2;
        this.label = 1;
        if (au.a(10000, this) != r0) goto L14;
        return r0;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataCenterReporter", "Location report service unavailable after retries", null, 4, null);
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r7 = this.$locationManager;
        r2 = 0;
        r6 = this.$context;
        r5 = 6;
        goto L9
    }
}
