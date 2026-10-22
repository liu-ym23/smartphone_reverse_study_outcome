package com.obric.audio.continuous_talk;

import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import r58.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$5", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ hia.a $newSession;
    final /* synthetic */ uga.b $startupSession;
    int label;
    final /* synthetic */ ObricContinuousTalkUIComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContinuousTalkUIComponent a;
        public final /* synthetic */ uga.b b;

        public a(ObricContinuousTalkUIComponent r1, uga.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            d r7 = (d) r5;
            ObricContinuousTalkUIComponent r0 = this.a;
            uga.b r1 = this.b;
            int r2 = r7.a;
            int r3 = ObricContinuousTalkUIComponent.M;
            r0.getClass();
            boolean r4 = false;
            if (r1 != null) goto L5;
        L11:
            if (r4 == false) goto L14;
            r1.a(IAssistantStartupTelemetry.a.c(AssistantStartupTelemetry.a, r1.a, "asr_record_ready"));
        L14:
            Object r8 = BuildersKt.withContext(Dispatchers.getMain(), new ObricContinuousTalkUIComponent$invokeOnSpeak$1$5$1$1(this.a, r7, null), r6);
            if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
            return r8;
        L18:
            return Unit.INSTANCE;
        L5:
            if (r2 <= 0) goto L7;
            boolean r9 = true;
        L9:
            if (r1.b(r9) != true) goto L11;
            r4 = true;
            goto L11
        L7:
            r9 = false;
            goto L9
        }
    }

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$5(hia.a r1, ObricContinuousTalkUIComponent r2, uga.b r3, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$5> r4) {
        this.$newSession = r1;
        this.this$0 = r2;
        this.$startupSession = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$5(this.$newSession, this.this$0, this.$startupSession, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Flow<d> r7 = this.$newSession.i();
        a r2 = new a(this.this$0, this.$startupSession);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
