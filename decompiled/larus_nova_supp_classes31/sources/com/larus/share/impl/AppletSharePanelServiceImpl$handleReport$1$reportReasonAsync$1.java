package com.larus.share.impl;

import com.larus.bmhome.tipoff.TipOffApi;
import com.larus.bmhome.tipoff.b;
import com.larus.platform.model.CollectionType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/tipoff/ReportReasonsData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.AppletSharePanelServiceImpl$handleReport$1$reportReasonAsync$1", f = "AppletSharePanelServiceImpl.kt", i = {}, l = {CollectionType.SINGLE_QISHUI_ALBUM}, m = "invokeSuspend", n = {}, s = {})
public final class AppletSharePanelServiceImpl$handleReport$1$reportReasonAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b>, Object> {
    int label;

    public AppletSharePanelServiceImpl$handleReport$1$reportReasonAsync$1(Continuation<? super AppletSharePanelServiceImpl$handleReport$1$reportReasonAsync$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AppletSharePanelServiceImpl$handleReport$1$reportReasonAsync$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return ((com.larus.network.http.a) r4).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        int r5 = TipOffApi.a;
        this.label = 1;
        r4 = TipOffApi.a("17", this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
