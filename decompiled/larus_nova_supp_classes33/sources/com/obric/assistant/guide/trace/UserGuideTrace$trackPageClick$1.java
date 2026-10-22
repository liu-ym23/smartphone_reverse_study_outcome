package com.obric.assistant.guide.trace;

import com.larus.applog.api.IApplog;
import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
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
@DebugMetadata(c = "com.obric.assistant.guide.trace.UserGuideTrace$trackPageClick$1", f = "UserGuideTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserGuideTrace$trackPageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ Map<String, Object> $extraParams;
    int label;

    public UserGuideTrace$trackPageClick$1(String r1, String r2, String r3, Map<String, ? extends Object> r4, Continuation<? super UserGuideTrace$trackPageClick$1> r5) {
        this.$currentPage = r1;
        this.$actionType = r2;
        this.$enterFrom = r3;
        this.$extraParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UserGuideTrace$trackPageClick$1(this.$currentPage, this.$actionType, this.$enterFrom, this.$extraParams, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r5);
        JSONObject r6 = new JSONObject();
        IObricTraceParam r0 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r0 == null) goto L7;
        r0.a(r6, this.$currentPage, this.$actionType, this.$enterFrom);
    L7:
        Map<String, Object> r1 = this.$extraParams;
        if (r1 == null) goto L13;
        Iterator<Map.Entry<String, Object>> r2 = r1.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, Object> r3 = r2.next();
        r6.put(r3.getKey(), r3.getValue());
    L13:
        IApplog.a.reportEvent("obric_page_click", r6);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
