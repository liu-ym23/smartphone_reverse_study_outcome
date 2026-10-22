package com.larus.call_plugins_doubao_common;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.call_plugins_doubao_common.CommonFeedbackVoicePluginV2$createCallStateObserver$1", f = "CommonFeedbackVoicePluginV2.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class CommonFeedbackVoicePluginV2$createCallStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonFeedbackVoicePluginV2<C> this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> a;

        public a(CommonFeedbackVoicePluginV2<C> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            CommonFeedbackVoicePluginV2<C> r3 = this.a;
            r3.getClass();
            if ((((AVKitDuplexState.DownState) r1) instanceof AVKitCoreStates.Paused) == false) goto L6;
            r3.r3(null);
        L6:
            return Unit.INSTANCE;
        }
    }

    public CommonFeedbackVoicePluginV2$createCallStateObserver$1(CommonFeedbackVoicePluginV2<C> r1, Continuation<? super CommonFeedbackVoicePluginV2$createCallStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonFeedbackVoicePluginV2$createCallStateObserver$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final i1 r6 = this.this$0.getContext().a().y();
        Flow r7 = kotlinx.coroutines.flow.e.n(new CommonFeedbackVoicePluginV2$createCallStateObserver$1$invokeSuspend$$inlined$map$1(r6));
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
