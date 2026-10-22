package com.larus.asr.session.clicktalk;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.session.clicktalk.ClickTalkComponentBizPlugin$onStart$1", f = "ClickTalkComponentBizPlugin.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class ClickTalkComponentBizPlugin$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ClickTalkComponentBizPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ClickTalkComponentBizPlugin a;

        public a(ClickTalkComponentBizPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            int r6 = ((Number) ((Pair) r4).component2()).intValue();
            ClickTalkComponentBizPlugin r7 = this.a;
            if (r7.j == false) goto L7;
            if (r6 != 3) goto L7;
            r7.j = false;
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

    public ClickTalkComponentBizPlugin$onStart$1(ClickTalkComponentBizPlugin r1, Continuation<? super ClickTalkComponentBizPlugin$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ClickTalkComponentBizPlugin$onStart$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow r6 = ObricRealtimeCallServiceDelegate.b.o(this.this$0.getContext()).i1();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
