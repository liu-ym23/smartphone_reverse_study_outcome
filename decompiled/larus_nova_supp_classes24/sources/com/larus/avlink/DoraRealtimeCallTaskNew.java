package com.larus.avlink;

import android.app.Application;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.audio.AudioSessionType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DoraRealtimeCallTaskNew extends u {
    public final com.larus.voicecall.impl.tracer.q m;

    /* JADX INFO: renamed from: com.larus.avlink.DoraRealtimeCallTaskNew$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.avlink.DoraRealtimeCallTaskNew$1", f = "DoraRealtimeCallTaskNew.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraRealtimeCallTaskNew this$0;

        public AnonymousClass1(DoraRealtimeCallTaskNew r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r2);
            if (this.this$0.p().d == false) goto L8;
            t19.s r3 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r3.getClass();
            t19.s.p(r0, "MMT");
        L15:
            return Unit.INSTANCE;
        L8:
            if (this.this$0.p().a == false) goto L11;
            t19.s r4 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            r4.getClass();
            t19.s.p(r1, "QUIC");
            goto L15
        L11:
            if (this.this$0.p().b == false) goto L13;
            t19.s r5 = t19.s.a;
            Application r6 = AppHost.a.getApplication();
            r5.getClass();
            t19.s.p(r6, "RTC");
            goto L15
        L13:
            t19.s r7 = t19.s.a;
            Application r8 = AppHost.a.getApplication();
            r7.getClass();
            t19.s.p(r8, "SAMI");
            goto L15
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final boolean i() {
        return o().B;
    }

    public DoraRealtimeCallTaskNew(String r7, BotModel r8, int r9, Integer r10) {
        super(r7, r8, r9, r10);
        JSONObject r11 = new JSONObject();
        r11.put("task_id", this.f);
        r11.put("is_rtc", p().b ? 1 : 0);
        r11.put("is_mmt", p().d ? 1 : 0);
        if (p().d == false) goto L6;
        AudioSessionType r12 = AudioSessionType.MMT;
    L12:
        r11.put("av_session_type", r12.getType());
        switch(r9) {
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            default: goto L14;
        };
    L14:
        int r13 = 0;
    L16:
        r11.put("is_dora_si", r13);
        this.m = new com.larus.voicecall.impl.tracer.q(z2a.g.e("dora_voice_call", r11), "dora_voice_call");
        if (AppHost.a.isDebugChannel() == false) goto L20;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L20:
        return;
    L15:
        r13 = 1;
        goto L16
    L6:
        if (p().b == false) goto L9;
        r12 = AudioSessionType.RTC;
        goto L12
    L9:
        if (p().a == false) goto L11;
        r12 = AudioSessionType.QUIC;
        goto L12
    L11:
        r12 = AudioSessionType.SAMI;
        goto L12
    }

    public final void e(final int r15, final int r16, final int r17, final int r19, final int r110, final String r20, final String r21) {
        o r1 = o();
        Function0<CoroutineScope> r0 = r1.d;
        if (r0 == null) goto L5;
        CoroutineScope r2 = (CoroutineScope) r0.invoke();
    L6:
        CoroutineScope r10 = r2;
        if (r10 == null) goto L9;
        BuildersKt.launch$default(r10, null, null, new BaseDoraCallLLMController$onVoiceWakeUp$1(r1, r15, r16, r17, r19, r110, r20, r21, null), 3, null);
        return;
    L9:
        r1.W(new c(r15, r16, r17, r19, r110, r20, r21));
        return;
    L5:
        r2 = null;
        goto L6
    }
}
