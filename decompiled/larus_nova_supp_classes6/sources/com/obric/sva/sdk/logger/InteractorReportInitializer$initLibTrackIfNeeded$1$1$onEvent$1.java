package com.obric.sva.sdk.logger;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.applog.InteractorLegacyAppLogHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.sva.sdk.logger.InteractorReportInitializer$initLibTrackIfNeeded$1$1$onEvent$1", f = "InteractorReportInitializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InteractorReportInitializer$initLibTrackIfNeeded$1$1$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ JSONObject $params;
    int label;

    public InteractorReportInitializer$initLibTrackIfNeeded$1$1$onEvent$1(String r1, JSONObject r2, Continuation<? super InteractorReportInitializer$initLibTrackIfNeeded$1$1$onEvent$1> r3) {
        this.$name = r1;
        this.$params = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InteractorReportInitializer$initLibTrackIfNeeded$1$1$onEvent$1(this.$name, this.$params, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        InteractorLegacyAppLogHelper.INSTANCE.reportEvent(this.$name, this.$params);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
