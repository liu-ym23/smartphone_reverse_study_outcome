package com.larus.voicecall.impl.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.obric.aivoice.core.data.NameKeys;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.plugins.TtsPlaybackReportPlugin$onStart$1", f = "TtsPlaybackReportPlugin.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class TtsPlaybackReportPlugin$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Integer> $stateFlow;
    int label;
    final /* synthetic */ TtsPlaybackReportPlugin<C> this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ TtsPlaybackReportPlugin<C> a;

        public a(TtsPlaybackReportPlugin<C> r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            int r6 = ((Number) r4).intValue();
            TtsPlaybackReportPlugin<C> r7 = this.a;
            if (r7.h == false) goto L7;
            if (r6 != 3) goto L7;
            r7.h = false;
            return Unit.INSTANCE;
        L7:
            if (r6 != 5) goto L12;
            id9.d r8 = r7.getContext().j();
            if (r8 == null) goto L12;
            r8.p(TriggerMode.TTS_PLAYBACK_START, new JSONObject().toString());
        L12:
            if (r6 == 2) goto L15;
            if (r6 == 3) goto L15;
        L19:
            return Unit.INSTANCE;
        L15:
            id9.d r9 = this.a.getContext().j();
            if (r9 == null) goto L19;
            r9.p(TriggerMode.TTS_PLAYBACK_END, new JSONObject().toString());
            goto L19
        }
    }

    public TtsPlaybackReportPlugin$onStart$1(Flow<Integer> r1, TtsPlaybackReportPlugin<C> r2, Continuation<? super TtsPlaybackReportPlugin$onStart$1> r3) {
        this.$stateFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsPlaybackReportPlugin$onStart$1(this.$stateFlow, this.this$0, r4);
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
        Flow<Integer> r6 = this.$stateFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
