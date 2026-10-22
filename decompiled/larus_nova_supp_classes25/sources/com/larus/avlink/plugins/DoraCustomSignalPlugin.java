package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.business.debug.base.audio.module.TTSModule;
import com.larus.im.internal.audio.ability.DoraCustomSignalType;
import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraCustomSignalPlugin extends com.larus.audio.call.arch.a<n4> implements p4 {
    public final String f;
    public volatile boolean g;
    public final DoraCustomSignalPlugin$llmDataListener$1 h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraCustomSignalType.values().length];
            r0[DoraCustomSignalType.VUI_RESET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraCustomSignalType.SESSION_WAKE_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraCustomSignalType.SESSION_CONF_RESPONSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final void e3() {
        super.e3();
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L6;
        r0.q(this.h);
        return;
    }

    public final void g3() {
        super.g3();
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L6;
        r0.n(this.h);
        return;
    }

    public final String T2() {
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.avlink.plugins.DoraCustomSignalPlugin$llmDataListener$1] */
    public DoraCustomSignalPlugin(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraCustomSignalPlugin";
        this.g = true;
        this.h = new DoraCustomSignalPlugin$llmDataListener$1(this, r2);
    }

    @Override // com.larus.avlink.plugins.p4
    public final void K2(x88.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        ouc.v r0 = xt7.d.b;
        r0.getClass();
        ouc.d0 r4 = b78.g.a(r0.a(x88.a.Companion.serializer(), r3));
        k3(DoraCustomSignalType.WAKE_UP_ON_SESSION, r4);
    }

    @Override // com.larus.avlink.plugins.p4
    public final void T0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        DoraCustomSignalType r0 = DoraCustomSignalType.SET_TRANSLATE_SCENE_SWITCH;
        ouc.e0 r1 = new ouc.e0();
        q68.d.b(r1, "sami_si_scene", r4);
        Unit r5 = Unit.INSTANCE;
        k3(r0, r1.a());
    }

    public final void j3(b5 r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "sessionConfInfo");
        RealtimeCallParam r0 = ((n4) getContext()).params();
        RealtimeCallParam.d r1 = r0.l;
        String r2 = r8.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.c = r2;
        RealtimeCallParam.p r3 = r0.o;
        String r4 = r8.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.h = r4;
        RealtimeCallParam.p r5 = r0.o;
        String r6 = r8.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.c = r6;
        RealtimeCallParam.p r7 = r0.o;
        String r10 = r8.d;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r7.t = r10;
        RealtimeCallParam.p r11 = r0.o;
        String r12 = r8.c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.d = r12;
        if (r9 == true) goto L12;
        String r13 = r8.d;
        Intrinsics.checkNotNullParameter(r13, "audioMetrics");
        DoraCustomSignalType r14 = DoraCustomSignalType.SET_LOUDNESS_STRATEGY;
        ouc.e0 r15 = new ouc.e0();
        q68.d.b(r15, "sami_loudness_meta_data", r13);
        float r16 = ia8.e.c().b();
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter("sami_tts_target_lufs", "key");
        r15.b("sami_tts_target_lufs", ouc.k.b(Float.valueOf(r16)));
        q68.d.b(r15, "sami_loudness_device_ai_data", "{\"target_lufs\": " + ia8.e.c().b() + '}');
        int r17 = ia8.e.c().c();
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter("sami_loudness_loud_norm_algo_type", "key");
        r15.b("sami_loudness_loud_norm_algo_type", ouc.k.b(Integer.valueOf(r17)));
        m58.q r18 = m58.h.d;
        if (r18 == null) goto L10;
        TTSModule r19 = r18.d();
        if (r19 == null) goto L10;
        String r20 = r19.c();
        if (r20 == null) goto L10;
    L11:
        q68.d.b(r15, "sami_tts_loudness_audio_dump_path", r20);
        Unit r21 = Unit.INSTANCE;
        k3(r14, r15.a());
    L10:
        r20 = "";
    L12:
        CoroutineScope r22 = ((n4) getContext()).r();
        if (r22 == null) goto L16;
        BuildersKt.launch$default(r22, null, null, new DoraCustomSignalPlugin$handleSessionConfigResponse$1$1(r0, null), 3, null);
    L16:
        if (this.g == false) goto L18;
        this.g = false;
        ((n4) getContext()).k().X(r8.a, ((n4) getContext()).params());
    L18:
        ((e1) getContext().b(Reflection.getOrCreateKotlinClass(e1.class), null)).v1(r8.b);
    }

    public final void k3(DoraCustomSignalType r7, ouc.d0 r8) {
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L21;
        TriggerMode r1 = TriggerMode.UNUSED;
        ouc.v r2 = xt7.d.b;
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        DoraCustomSignalType.Companion.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r7, "type");     // Catch: Throwable -> L11
        Integer r9 = Integer.valueOf(r7.getValue());     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        String r10 = r8.toString();     // Catch: Throwable -> L11
    L9:
        id9.a r5 = new id9.a(r9, r10);     // Catch: Throwable -> L11
        r2.getClass();     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(r2.a(id9.a.Companion.serializer(), r5));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r11) == true) goto L17;
        r3 = r11;
    L17:
        r0.p(r1, (String) r3);
        return;
    L8:
        r10 = null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
