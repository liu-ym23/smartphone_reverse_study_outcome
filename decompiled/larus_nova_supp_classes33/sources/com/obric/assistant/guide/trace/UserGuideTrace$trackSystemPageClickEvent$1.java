package com.obric.assistant.guide.trace;

import com.obric.assistant.reporter.IObricSystemReporter;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.guide.trace.UserGuideTrace$trackSystemPageClickEvent$1", f = "UserGuideTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserGuideTrace$trackSystemPageClickEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $currentPage;
    int label;

    public UserGuideTrace$trackSystemPageClickEvent$1(String r1, String r2, Continuation<? super UserGuideTrace$trackSystemPageClickEvent$1> r3) {
        this.$currentPage = r1;
        this.$actionType = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UserGuideTrace$trackSystemPageClickEvent$1(this.$currentPage, this.$actionType, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        JSONObject r4 = new JSONObject();
        r4.put("current_page", this.$currentPage);
        r4.put("action_type", this.$actionType);
        IObricSystemReporter.a.getClass();
        IObricSystemReporter r0 = IObricSystemReporter.a.a();
        if (r0 == null) goto L8;
        r0.b("obric_page_click", r4);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
