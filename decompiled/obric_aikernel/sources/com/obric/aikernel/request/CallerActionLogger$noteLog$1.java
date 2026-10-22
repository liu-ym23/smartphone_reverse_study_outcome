package com.obric.aikernel.request;

import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.request.CallerActionLogger$noteLog$1", f = "CallerActionLogger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CallerActionLogger$noteLog$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $info;
    int label;

    CallerActionLogger$noteLog$1(JSONObject r10, Continuation<? super CallerActionLogger$noteLog$1> r11) {
        this.$info = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CallerActionLogger$noteLog$1(this.$info, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((CallerActionLogger$noteLog$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        AIKLog r11 = AIKLog.INSTANCE;
        String r12 = this.$info.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "info.toString()");
        r11.d("AI-TRACK", r12);
        TrackerApi.INSTANCE.onEvent("request_entry_track", this.$info);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
