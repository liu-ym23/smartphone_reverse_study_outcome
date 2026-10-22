package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.arch.k0;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.utils.AvBizType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends LLMCallController<com.larus.audio.call.arch.c> {
    public final AutoStopAsrTracer A;
    public b B;
    public final a3a.b v;
    public final Function1<a3a.a.d, Unit> w;
    public final Function2<com.larus.audio.call.arch.c, com.larus.audio.call.arch.d<com.larus.audio.call.arch.c>, Unit> x;
    public final s y;
    public final String z;

    public final boolean O() {
        return true;
    }

    public final com.larus.audio.call.arch.c K() {
        return new LLMCallController.a(this);
    }

    public final Deferred<LLMCallController.b> L() {
        Deferred<LLMCallController.b> r0 = super.L();
        r0.invokeOnCompletion(new e(this));
        return r0;
    }

    public final String A() {
        return this.z;
    }

    public final IRealtimeCallTracer B() {
        return this.A;
    }

    public final CompletableDeferred R(RealtimeCallParam r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        s r0 = this.y;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "param");
        if (r0.a != null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        int r2 = z2a.g.a;
        JSONObject r3 = new JSONObject();
        r3.put("bot_id", r5.o.h);
        r3.put("bot_name", r5.o.i);
        r3.put("conversation_id", r5.l.c);
        r3.put("recommend_from", r5.p.e);
        r3.put("chat_type", r5.p.g);
        r3.put("llm_model", r5.i);
        r3.put("voice_style", r5.o.d);
        r3.put("call_id", r5.e);
        r3.put("task_id", r5.l.a);
        Unit r4 = Unit.INSTANCE;
        r0.a = z2a.g.e("voice_call", r3);
        return super.R(r5, r6);
    L10:
        throw new IllegalStateException("AutoStop ASR trace span already initialized".toString());
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.voicecall.impl.autostop.d] */
    public final void p(com.larus.audio.call.arch.c r4, k0 r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "registry");
        final b r0 = new b(r4, this.v, this.w);
        this.B = r0;
        r5.a(new com.larus.audio.call.mgr.c(r4));
        r5.a(new r(r4));
        r5.a(r0);
        r5.a(new UplinkAudioPlugin(r4, new d(r0)));
        r5.a(new com.larus.audio.call.plugins.h(r4, ((LLMCallController) this).b.a(), ((LLMCallController) this).i));
        r5.a(new a(r4));
        r5.a(new l(r4));
        if (c78.a.a == false) goto L5;
        r5.a(new com.larus.audio.call.plugins.c(r4));
    L5:
        Function2<com.larus.audio.call.arch.c, com.larus.audio.call.arch.d<com.larus.audio.call.arch.c>, Unit> r1 = this.x;
        if (r1 == null) goto L9;
        r1.invoke(r4, r5);
        return;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.voicecall.impl.autostop.c] */
    public f(com.larus.asr.session.clicktalk.s r4, Function1 r5, Function2 r6, Function0 r7) {
        s r0 = new s();
        Intrinsics.checkNotNullParameter(r4, "eventListener");
        Intrinsics.checkNotNullParameter(r5, "onFailure");
        Intrinsics.checkNotNullParameter(r7, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r0, "traceSpan");
        super(new b78.h(AvBizType.VOICE_CALL), r0, r7);
        this.v = r4;
        this.w = r5;
        this.x = r6;
        this.y = r0;
        this.z = "AutoStopAsrLLMCallController";
        this.A = new AutoStopAsrTracer(new c(this));
    }
}
