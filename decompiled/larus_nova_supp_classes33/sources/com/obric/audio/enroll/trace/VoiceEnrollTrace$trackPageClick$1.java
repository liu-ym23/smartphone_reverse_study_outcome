package com.obric.audio.enroll.trace;

import com.larus.applog.api.IApplog;
import com.obric.assistant.spi.audio.ObricEnrollTraceParamDelegate;
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
@DebugMetadata(c = "com.obric.audio.enroll.trace.VoiceEnrollTrace$trackPageClick$1", f = "VoiceEnrollTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollTrace$trackPageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ Map<String, Object> $extraParams;
    int label;

    public VoiceEnrollTrace$trackPageClick$1(String r1, String r2, String r3, Map<String, ? extends Object> r4, Continuation<? super VoiceEnrollTrace$trackPageClick$1> r5) {
        this.$currentPage = r1;
        this.$actionType = r2;
        this.$enterFrom = r3;
        this.$extraParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VoiceEnrollTrace$trackPageClick$1(this.$currentPage, this.$actionType, this.$enterFrom, this.$extraParams, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        JSONObject r6 = new JSONObject();
        ObricEnrollTraceParamDelegate.b.a(r6, this.$currentPage, this.$actionType, this.$enterFrom);
        Map<String, Object> r0 = this.$extraParams;
        if (r0 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r1 = r0.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Object> r2 = r1.next();
        r6.put(r2.getKey(), r2.getValue());
    L10:
        IApplog.a.reportEvent("obric_page_click", r6);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
