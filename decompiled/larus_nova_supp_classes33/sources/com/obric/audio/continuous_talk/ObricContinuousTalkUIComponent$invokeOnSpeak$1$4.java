package com.obric.audio.continuous_talk;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.capabilitykit.entity.ResultCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$4", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {ResultCode.ERROR_DONATE_TEMPORARY_FAILED}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ hia.a $newSession;
    final /* synthetic */ String $personalCtx;
    final /* synthetic */ boolean $personalCtxIsFinish;
    final /* synthetic */ String $speakTaskId;
    final /* synthetic */ uga.b $startupSession;
    int label;
    final /* synthetic */ ObricContinuousTalkUIComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContinuousTalkUIComponent a;
        public final /* synthetic */ uga.b b;
        public final /* synthetic */ Ref.BooleanRef c;
        public final /* synthetic */ String d;
        public final /* synthetic */ hia.a e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;

        public a(ObricContinuousTalkUIComponent r1, uga.b r2, Ref.BooleanRef r3, String r4, hia.a r5, boolean r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final Object emit(Object r12, Continuation r13) {
            AVKitDuplexState r14 = (AVKitDuplexState) r12;
            ObricContinuousTalkUIComponent r0 = this.a;
            int r1 = ObricContinuousTalkUIComponent.M;
            r0.getClass();
            StateTriggerEvent.QueryEnd r2 = r14.getUpState().getTriggerBy();
            boolean r3 = false;
            if ((r2 instanceof StateTriggerEvent.QueryEnd) == true) goto L5;
        L22:
            AVKitCoreStates.Error r4 = r14.getUpState();
            if ((r4 instanceof AVKitCoreStates.Error) == false) goto L28;
            this.a.m3(this.b, "dropped", "continuous_talk_error", MapsKt.mapOf(TuplesKt.to("error_code", String.valueOf(r4.a))));
            c r5 = this.a.p3();
            if (r5 == null) goto L31;
            c.a.a(r5, ObricContinuousTalkEndType.OTHER, null, false, true, 6);
        L31:
            if (this.c.element == false) goto L33;
        L55:
            Object r15 = BuildersKt.withContext(Dispatchers.getMain(), new ObricContinuousTalkUIComponent$invokeOnSpeak$1$4$1$1(this.a, r14, this.g, null), r13);
            if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
            return r15;
        L59:
            return Unit.INSTANCE;
        L33:
            if ((r14.getUpState() instanceof AVKitCoreStates.Connecting) == true) goto L55;
            if ((r14.getUpState() instanceof AVKitCoreStates.Error) == true) goto L55;
            if ((r14.getUpState() instanceof AVKitCoreStates.Invalid) == true) goto L55;
            if (ObricAsrDelegate.b.q() == false) goto L54;
            String r6 = this.d;
            if (r6 != null) goto L43;
        L44:
            r3 = true;
        L45:
            if (r3 == true) goto L54;
            JSONArray r7 = new JSONArray(this.d);     // Catch: JSONException -> L48
        L49:
            if (r7 == null) goto L53;
            JSONObject r8 = new JSONObject();
            boolean r9 = this.f;
            r8.put("personal_ctx", r7);
            r8.put("update_nonstream_context_finish", r9);
            if ((this.e.d(r8) instanceof hia.a.d.b) == false) goto L55;
            this.c.element = true;
            goto L55
        L53:
            this.c.element = true;
        L48:
            r7 = null;
            goto L49
        L43:
            if (r6.length() != 0) goto L45;
        L54:
            this.c.element = true;
            goto L55
        L28:
            if ((r4 instanceof AVKitCoreStates.Finished) == false) goto L31;
            this.a.m3(this.b, "cancelled", "continuous_talk_finished_before_pcm", MapsKt.emptyMap());
            goto L31
        L5:
            if (r2.a == true) goto L22;
            if ((r14.getDownState() instanceof AVKitCoreStates.Speaking) == true) goto L22;
            IObricChatService r10 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
            if (r10 == null) goto L13;
            e r11 = r10.h();
            if (r11 == null) goto L13;
            final String r16 = r11.a;
        L14:
            if (r16 != null) goto L17;
            r16 = "";
        L17:
            if (r16.length() <= 0) goto L19;
            boolean r17 = true;
        L20:
            if (r17 == false) goto L22;
            com.larus.utils.y.d(new g0(r16), 50);
            goto L22
        L19:
            r17 = false;
        L13:
            r16 = null;
            goto L14
        }
    }

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$4(hia.a r1, ObricContinuousTalkUIComponent r2, uga.b r3, String r4, boolean r5, String r6, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$4> r7) {
        this.$newSession = r1;
        this.this$0 = r2;
        this.$startupSession = r3;
        this.$personalCtx = r4;
        this.$personalCtxIsFinish = r5;
        this.$speakTaskId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$4(this.$newSession, this.this$0, this.$startupSession, this.$personalCtx, this.$personalCtxIsFinish, this.$speakTaskId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r12);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        i1<AVKitDuplexState> r13 = this.$newSession.h();
        a r2 = new a(this.this$0, this.$startupSession, r6, this.$personalCtx, this.$newSession, this.$personalCtxIsFinish, this.$speakTaskId);
        this.label = 1;
        if (r13.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
