package com.larus.audio.utils;

import android.os.SystemClock;
import com.bytedance.services.apm.api.EnsureManager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.SoundsSource;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.utils.SoundsMobHelper$onPlayFinish$1$1", f = "SoundsMobHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SoundsMobHelper$onPlayFinish$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ SoundsSource $source;
    private /* synthetic */ Object L$0;
    int label;

    public SoundsMobHelper$onPlayFinish$1$1(SoundsSource r1, String r2, Continuation<? super SoundsMobHelper$onPlayFinish$1$1> r3) {
        this.$source = r1;
        this.$botId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SoundsMobHelper$onPlayFinish$1$1 r0 = new SoundsMobHelper$onPlayFinish$1$1(this.$source, this.$botId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L64;
        ResultKt.throwOnFailure(r19);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        if (SoundsMobHelper.q == false) goto L15;
        SoundsMobHelper r1 = SoundsMobHelper.a;
        SoundsSource r2 = SoundsMobHelper.h;
        boolean r4 = true;
        if (r2 != SoundsSource.MESSAGE_TTS) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
    L16:
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = "default";
        Ref.LongRef r6 = new Ref.LongRef();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L22
        if (r4 == false) goto L20;
        long r8 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        SoundsMobHelper r9 = SoundsMobHelper.a;     // Catch: Throwable -> L22
        SoundsMobHelper.l().process_tail();     // Catch: Throwable -> L22
        r5.element = SoundsMobHelper.l().get_result();     // Catch: Throwable -> L22
        r6.element = SystemClock.elapsedRealtime() - r8;     // Catch: Throwable -> L22
    L20:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L30;
        EnsureManager.ensureNotReachHere(r11);
        m58.v r12 = m58.h.i;
        if (r12 == null) goto L30;
        r12.e("SoundsMobHelper", "onPlayFinish. err=" + r11);
    L30:
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L35;
        com.larus.home.impl.sdk.s r14 = r13.s0();
        if (r14 == null) goto L35;
        String r15 = r14.t();
    L36:
        SoundsMobHelper r16 = SoundsMobHelper.a;
        e r17 = SoundsMobHelper.n();
        long r20 = SystemClock.elapsedRealtime() - SoundsMobHelper.g;
        int r110 = SoundsMobHelper.i();
        m58.s r111 = m58.h.b;
        if (r111 == null) goto L51;
        JSONObject r112 = new JSONObject();
        String r113 = this.$botId;
        r112.put("get_result_duration", r6.element);
        r112.put("total_process_duration", SoundsMobHelper.r);
        SoundsSource r21 = SoundsMobHelper.h;
        if (r21 == null) goto L41;
        String r22 = r21.getKeyStr();
    L42:
        r112.put("audio_content_type", r22);
        r112.put("audio_id", SoundsMobHelper.k);
        r112.put("duration", r20);
        r112.put("bot_id", r113);
        if (r17 == null) goto L45;
        String r23 = ic8.n.f(r17);
    L46:
        r112.put("chat_type", r23);
        r112.put("start_method", SoundsMobHelper.d);
        r112.put("end_method", SoundsMobHelper.e);
        r112.put("audio_output_device_connetion", SoundsMobHelper.o());
        r112.put("FW_version", r15);
        if (r4 == false) goto L49;
        Ref.ObjectRef r24 = r5;
        r112.put("audio_quality", r24.element);
    L50:
        r112.put("speaker_volume", r110);
        Unit r25 = Unit.INSTANCE;
        r111.report("finish_audio_content_play", r112);
    L52:
        m58.v r26 = m58.h.i;
        if (r26 == null) goto L55;
        r26.d("SoundsMobHelper", "startMethod=" + SoundsMobHelper.d + "  endMethod=" + SoundsMobHelper.e + " onPlayFinish type=" + this.$source + ". result=" + ((String) r24.element));
    L55:
        SoundsMobHelper.d = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        SoundsMobHelper.e = "";
        SoundsMobHelper.f = null;
        SoundsSource r27 = SoundsSource.NOT_PLAY;
        SoundsSource r29 = SoundsMobHelper.h;
        if (com.larus.utils.o0.d(SoundsMobHelper.k) == false) goto L58;
        SoundsMobHelper.j = SoundsMobHelper.k;
    L58:
        SoundsMobHelper.k = "";
        if (r29 == r27) goto L61;
        SoundsMobHelper.p = false;
        SoundsMobHelper.s = SystemClock.elapsedRealtime();
        SoundsMobHelper.i = r29;
    L61:
        SoundsMobHelper.h = r27;
        SoundsMobHelper.r = 0;
        return Unit.INSTANCE;
    L49:
        r24 = r5;
        goto L50
    L45:
        r23 = null;
        goto L46
    L41:
        r22 = null;
        goto L42
    L51:
        r24 = r5;
    L35:
        r15 = null;
    L22:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L9:
        if (r2 == SoundsSource.REALTIME_CALL) goto L12;
        r3 = false;
    L15:
        r4 = false;
        goto L16
    L64:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
