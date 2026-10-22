package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.plugin.ObricContTalkPlugin$createSessionListener$1$onReceiveEvent$2", f = "ObricContTalkPlugin.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContTalkPlugin$createSessionListener$1$onReceiveEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z0.a $event;
    final /* synthetic */ hia.a.b $llmContextProvider;
    int label;
    final /* synthetic */ ObricContTalkPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ ObricContTalkPlugin b;
        public final /* synthetic */ z0.a c;

        public a(Ref.IntRef r1, ObricContTalkPlugin r2, z0.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r8, Continuation r9) {
            hia.a.c r10 = (hia.a.c) r8;
            JSONObject r11 = new JSONObject(r10.a);
            Ref.IntRef r0 = this.a;
            int r1 = r0.element;
            r0.element = r1 + 1;
            id9.d r2 = ((com.obric.audio.continuous_talk.session.impl.a) this.b.getContext()).j();
            if (r2 == null) goto L5;
            TriggerMode r3 = TriggerMode.UPDATE_ROUND_CONTEXT;
            JSONObject r4 = new JSONObject();
            r4.put("round_id", this.c.c);
            r4.put("seq_num", r1);
            r4.put("params", r11);
            r4.put("is_finish", r10.b);
            r4.put("ts", System.currentTimeMillis());
            Unit r12 = Unit.INSTANCE;
            r2.p(r3, r4.toString());
        L5:
            com.larus.audio.call.util.e.a.i(this.b.f, "UpdateRoundContext uploaded round_id: " + this.c.c + ", seq_num: " + r1 + ", is_finish: " + r10.b + ", params_empty: " + r10.a.isEmpty() + ", ");
            return Unit.INSTANCE;
        }
    }

    public ObricContTalkPlugin$createSessionListener$1$onReceiveEvent$2(hia.a.b r1, z0.a r2, ObricContTalkPlugin r3, Continuation<? super ObricContTalkPlugin$createSessionListener$1$onReceiveEvent$2> r4) {
        this.$llmContextProvider = r1;
        this.$event = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricContTalkPlugin$createSessionListener$1$onReceiveEvent$2(this.$llmContextProvider, this.$event, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 1;
        Flow r2 = kotlinx.coroutines.flow.e.w(this.$llmContextProvider.a(this.$event.c), Dispatchers.getIO());
        a r3 = new a(r8, this.this$0, this.$event);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
