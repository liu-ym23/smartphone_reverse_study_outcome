package com.larus.audio.ttsV2;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsFinishPlayingType;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.utils.j0;
import com.larus.im.bean.bot.BotModel;
import com.larus.media.MediaResourceManager;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.v3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TtsClientManager$e implements l68.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map<String, String> d;
    public final /* synthetic */ Function0<Unit> e;
    public final /* synthetic */ Function1<String, Unit> f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[TtsLifeState.values().length];
            r0[TtsLifeState.TTS_FINISH_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[TtsLifeState.TTS_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[TtsLifeState.TTS_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[TtsEventEnum.values().length];
            r1[TtsEventEnum.TTS_FIRST_PACKAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[TtsEventEnum.TTS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[TtsEventEnum.TTS_SENTENCE_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    @Override // l68.b
    public final void b(byte[] r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    @Override // l68.b
    public final void a(TtsTracer r2) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
    }

    @Override // l68.b
    public final void d(TtsState r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        f2a.c r0 = TtsClientManager.i.b("[TTS] onStateChanged");
        r0.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r1 = new Pair[4];
        f2a.f r2 = f2a.f.h;
        String r3 = this.a;
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r1[0] = TuplesKt.to(r2, r3);
        f2a.f r5 = f2a.f.i;
        String r6 = this.b;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r1[1] = TuplesKt.to(r5, r6);
        f2a.f r7 = new f2a.f("start_read_message_reason");
        String r9 = this.c;
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        r1[2] = TuplesKt.to(r7, r9);
        r1[3] = TuplesKt.to(new f2a.f("tts_state"), r8.name());
        r0.d(MapsKt.mapOf(r1));
        f2a.c.c(r0, null, 15);
        if (r8 != TtsState.TTS_STARTED) goto L15;
        FLogger.a.b("TTS", r8.name(), TtsClientManager.d);
    L17:
        Map<String, String> r10 = this.d;
        if (r8 == TtsState.TTS_STOPPED) goto L20;
    L22:
        TtsClientManager.g = r8;
        if (r10 == null) goto L28;
        String r11 = r10.get("question_id");
        if (r11 == null) goto L28;
        r4 = r11;
    L28:
        JsonObject r12 = new JsonObject();
        r12.addProperty("question_id", r4);
        int r13 = TtsClientManager$c.a[r8.ordinal()];
        if (r13 == 1) goto L34;
        if (r13 != 2) goto L33;
        com.larus.platform.service.k.a.a(IAppletJsbEventService.TriggeredEvent.TTS_END, r12);
        return;
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        com.larus.platform.service.k.a.a(IAppletJsbEventService.TriggeredEvent.TTS_START, r12);
        return;
    L20:
        if (TtsClientManager.g != r8) goto L22;
        return;
    L15:
        if (r8 != TtsState.TTS_STOPPED) goto L17;
        FLogger.a.c("TTS", r8.name(), TtsClientManager.d);
        goto L17
    }

    @Override // l68.b
    public final void e(TtsLifeState r19, String r110, Map<String, String> r20) {
        Intrinsics.checkNotNullParameter(r19, "lifeState");
        f2a.d r2 = TtsClientManager.i;
        f2a.c r4 = r2.b("[TTS] onLifeStateChange");
        r4.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r6 = new Pair[6];
        f2a.f r7 = f2a.f.h;
        String r8 = this.a;
        String r9 = "";
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        r6[0] = TuplesKt.to(r7, r8);
        f2a.f r10 = f2a.f.i;
        String r11 = this.b;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        r6[1] = TuplesKt.to(r10, r11);
        f2a.f r12 = f2a.f.c;
        if (r110 != null) goto L11;
        String r13 = "";
    L12:
        r6[2] = TuplesKt.to(r12, r13);
        f2a.f r14 = new f2a.f("start_read_message_reason");
        String r15 = this.c;
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        r6[3] = TuplesKt.to(r14, r15);
        r6[4] = TuplesKt.to(new f2a.f("tts_life_state"), r19.name());
        r6[5] = TuplesKt.to(new f2a.f("extra_ap"), GsonProtectorUtils.toJson(new Gson(), r20));
        r4.d(MapsKt.mapOf(r6));
        f2a.c.c(r4, null, 15);
        if (r20 == null) goto L18;
        String r1 = r20.get("scene_from");
    L19:
        int r5 = a.a[r19.ordinal()];
        if (r5 != 1) goto L22;
        f2a.c r3 = r2.b("[TTS][LIFE_STATE] TTS_FINISH_PLAYING");
        r3.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r16 = new Pair[4];
        String r17 = this.a;
        if (r17 != null) goto L50;
        r17 = "";
    L50:
        r16[0] = TuplesKt.to(r7, r17);
        String r21 = this.b;
        if (r21 != null) goto L53;
        r21 = "";
    L53:
        r16[1] = TuplesKt.to(r10, r21);
        if (r110 != null) goto L56;
        String r22 = "";
    L57:
        r16[2] = TuplesKt.to(r12, r22);
        f2a.f r23 = new f2a.f("start_read_message_reason");
        String r24 = this.c;
        if (r24 == null) goto L61;
        r9 = r24;
    L61:
        r16[3] = TuplesKt.to(r23, r9);
        r3.d(MapsKt.mapOf(r16));
        f2a.c.c(r3, null, 15);
        if (Intrinsics.areEqual(r1, TtsFinishPlayingType.PLAY_DONE.getType()) == false) goto L64;
        this.e.invoke();
        return;
    L64:
        Function1<String, Unit> r25 = this.f;
        if (r1 != null) goto L67;
        r1 = "unknown";
    L67:
        r25.invoke(r1);
        return;
    L56:
        r22 = r110;
        goto L57
    L22:
        if (r5 != 2) goto L24;
    L26:
        f2a.c r26 = r2.b("[TTS][LIFE_STATE] TtsLifeState change");
        r26.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r27 = new Pair[5];
        String r29 = this.a;
        if (r29 != null) goto L29;
        r29 = "";
    L29:
        r27[0] = TuplesKt.to(r7, r29);
        String r30 = this.b;
        if (r30 != null) goto L32;
        r30 = "";
    L32:
        r27[1] = TuplesKt.to(r10, r30);
        if (r110 != null) goto L35;
        String r31 = "";
    L36:
        r27[2] = TuplesKt.to(r12, r31);
        f2a.f r32 = new f2a.f("start_read_message_reason");
        String r33 = this.c;
        if (r33 == null) goto L40;
        r9 = r33;
    L40:
        r27[3] = TuplesKt.to(r32, r9);
        r27[4] = TuplesKt.to(new f2a.f("tts_life_state"), r19.name());
        r26.d(MapsKt.mapOf(r27));
        f2a.c.c(r26, null, 15);
        if (Intrinsics.areEqual(r1, TtsFinishPlayingType.PLAY_DONE.getType()) == false) goto L43;
        this.e.invoke();
        return;
    L43:
        Function1<String, Unit> r34 = this.f;
        if (r1 != null) goto L46;
        r1 = "stop or error";
    L46:
        r34.invoke(r1);
        return;
    L35:
        r31 = r110;
        goto L36
    L24:
        if (r5 == 3) goto L26;
        return;
    L18:
        r1 = null;
        goto L19
    L11:
        r13 = r110;
        goto L12
    }

    @Override // l68.b
    public final void c(TtsEventEnum r9, String r10, int r11, String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r10, "customErrorMsg");
        Intrinsics.checkNotNullParameter(r12, "ext");
        Intrinsics.checkNotNullParameter(r13, "extMap");
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L5;
        r14.K0();
        com.larus.music.i.a.h();
    L5:
        int r15 = a.b[r9.ordinal()];
        String r0 = null;
        String r7 = "";
        if (r15 == 1) goto L45;
        if (r15 == 2) goto L39;
        if (r15 == 3) goto L20;
        f2a.c r16 = TtsClientManager.i.b("other events " + r9.getMassage());
        r16.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r17 = new Pair[3];
        f2a.f r19 = f2a.f.h;
        String r110 = this.a;
        if (r110 != null) goto L12;
        r110 = "";
    L12:
        r17[0] = TuplesKt.to(r19, r110);
        f2a.f r111 = f2a.f.i;
        String r112 = this.b;
        if (r112 != null) goto L15;
        r112 = "";
    L15:
        r17[1] = TuplesKt.to(r111, r112);
        f2a.f r113 = new f2a.f("start_read_message_reason");
        String r114 = this.c;
        if (r114 == null) goto L19;
        r7 = r114;
    L19:
        r17[2] = TuplesKt.to(r113, r7);
        r16.d(MapsKt.mapOf(r17));
        f2a.c.c(r16, null, 15);
        return;
    L20:
        Object r20 = r13.get("text");
        if ((r20 instanceof String) == false) goto L23;
        String r21 = (String) r20;
    L24:
        Object r115 = r13.get("lang");
        if ((r115 instanceof m68.a) == false) goto L27;
        m68.a r116 = (m68.a) r115;
    L28:
        IAIChatTtsPlayTraceService.Companion r117 = IAIChatTtsPlayTraceService.a;
        String r118 = this.h;
        if (r118 == null) goto L32;
        r7 = r118;
    L32:
        if (r116 == null) goto L34;
        String r119 = r116.a();
    L35:
        if (r116 == null) goto L37;
        r0 = r116.b();
    L37:
        r117.d(r7, r21, r119, r0);
        return;
    L34:
        r119 = null;
        goto L35
    L27:
        r116 = null;
        goto L28
    L23:
        r21 = null;
        goto L24
    L39:
        if (new JSONObject(r12).optBoolean("is_cache") == false) goto L100;
        String r22 = this.c;
        String r120 = this.b;
        BotModel r121 = TtsClientManager.b;
        if (r121 == null) goto L43;
        r0 = r121.getBotId();
    L43:
        v3.a(r22, r120, r0, this.g, this.a);
        return;
    L100:
        return;
    L45:
        if (TtsClientManager.a.g() == false) goto L59;
        f2a.c r23 = TtsClientManager.i.b("[TTS][ASR_RECORDING] skip startAudioPlay on first package");
        r23.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r122 = new Pair[3];
        f2a.f r123 = f2a.f.h;
        String r124 = this.a;
        if (r124 != null) goto L49;
        r124 = "";
    L49:
        r122[0] = TuplesKt.to(r123, r124);
        f2a.f r125 = f2a.f.i;
        String r126 = this.b;
        if (r126 != null) goto L52;
        r126 = "";
    L52:
        r122[1] = TuplesKt.to(r125, r126);
        f2a.f r127 = new f2a.f("start_read_message_reason");
        String r128 = this.c;
        if (r128 == null) goto L56;
        r7 = r128;
    L56:
        r122[2] = TuplesKt.to(r127, r7);
        r23.d(MapsKt.mapOf(r122));
        f2a.c.c(r23, null, 15);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().g(TtsClientManager.d, false, "TtsClientManager TTS_FIRST_PACKAGE skipped by ASR recording");
        return;
    L59:
        if (j0.a() == false) goto L72;
        f2a.c r24 = TtsClientManager.i.a("[TTS][O_CALL PLAYING] O_CALL is playing, return");
        r24.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r129 = new Pair[3];
        f2a.f r130 = f2a.f.h;
        String r131 = this.a;
        if (r131 != null) goto L63;
        r131 = "";
    L63:
        r129[0] = TuplesKt.to(r130, r131);
        f2a.f r132 = f2a.f.i;
        String r133 = this.b;
        if (r133 != null) goto L66;
        r133 = "";
    L66:
        r129[1] = TuplesKt.to(r132, r133);
        f2a.f r134 = new f2a.f("start_read_message_reason");
        String r135 = this.c;
        if (r135 == null) goto L70;
        r7 = r135;
    L70:
        r129[2] = TuplesKt.to(r134, r7);
        r24.d(MapsKt.mapOf(r129));
        f2a.c.c(r24, null, 15);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().g(TtsClientManager.d, false, "TtsClientManager TTS_FIRST_PACKAGE skipped by O_CALL playing");
        return;
    L72:
        IFlowSdkDepend r25 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r25 == null) goto L75;
        r25.K0();
        boolean r26 = com.larus.music.i.a.h();
    L77:
        if (ObricTtsControlDelegate.b.e() == false) goto L80;
        TtsClientManager.m = TtsClientManager.m(r26);
    L86:
        f2a.c r136 = TtsClientManager.i.b("[TTS] TTS_FIRST_PACKAGE");
        r136.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r137 = new Pair[5];
        f2a.f r138 = f2a.f.h;
        String r3 = this.a;
        if (r3 != null) goto L89;
        r3 = "";
    L89:
        r137[0] = TuplesKt.to(r138, r3);
        f2a.f r139 = f2a.f.i;
        String r4 = this.b;
        if (r4 != null) goto L92;
        r4 = "";
    L92:
        r137[1] = TuplesKt.to(r139, r4);
        f2a.f r140 = new f2a.f("start_read_message_reason");
        String r2 = this.c;
        if (r2 == null) goto L96;
        r7 = r2;
    L96:
        r137[2] = TuplesKt.to(r140, r7);
        r137[3] = TuplesKt.to(new f2a.f("is_qq_music_play"), Boolean.valueOf(r26));
        r137[4] = TuplesKt.to(new f2a.f("current_application"), TtsClientManager.m);
        r136.d(MapsKt.mapOf(r137));
        f2a.c.c(r136, null, 15);
        Lazy r27 = MediaResourceManager.a;
        com.larus.media.model.a r29 = TtsClientManager.m;
        final String r141 = this.a;
        final String r142 = this.b;
        final String r143 = this.c;
        MediaResourceManager.m(r29, new r(r141, r142, r143), new s(r141, r142, r143), 0, 8);
        return;
    L80:
        if (TtsClientManager.j == true) goto L84;
        if (r26 == true) goto L84;
        com.larus.media.model.a r144 = TtsClientManager.k;
    L85:
        TtsClientManager.m = r144;
    L84:
        r144 = TtsClientManager.l;
        goto L85
    L75:
        r26 = false;
        goto L77
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TtsClientManager$e(String r1, String r2, String r3, Map<String, String> r4, Function0<Unit> r5, Function1<? super String, Unit> r6, String r7, String r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
