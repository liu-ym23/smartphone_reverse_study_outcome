package g78;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.bytedance.flow_audio.api.tracer.FlowTtsTraceHelper;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import com.larus.audio.audiov3.task.TtsManager;
import com.larus.audio.audiov3.task.tts.TtsFinishPlayingType;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsStopType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.audiov3.tts.TtsStep;
import com.larus.audio.flow.client.FlowTtsClientImpl;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1;
import com.larus.business.debug.base.audio.module.TTSModule;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import t58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ FlowTtsClientImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ d0(FlowTtsClientImpl r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowTtsClientImpl r1 = this.a;
        String r2 = this.b;
        String r3 = this.c;
    L3:
        String r10 = "";
        if (r1.n == PlayStateEnum.PLAY_STATE_PAUSED) goto L5;
        if ((!r1.m.isEmpty()) == false) goto L17;
        byte[] r4 = (byte[]) r1.m.take();
    L21:
        if (r1.C == true) goto L191;
        if (b.a(null) == false) goto L25;
    L27:
        if (r4 != null) goto L29;
    L111:
        if (r4 == null) goto L131;
        if (r1.k.b == AudioPlayerState.STOPPED) goto L116;
        r1.k.a(r4, r4.length);
    L116:
        if (r4.length != 0) goto L118;
        int r5 = 1;
        boolean r17 = true;
    L120:
        if ((!r17) == false) goto L122;
        int r7 = l78.a.d;
        l78.a.i += r5;
        l78.a.j = System.currentTimeMillis();
    L122:
        m58.q r6 = m58.h.d;
        if (r6 == null) goto L127;
        TTSModule r8 = r6.d();
        if (r8 == null) goto L127;
        r8.h(r2, r4);
    L127:
        TtsTracer r9 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r2);
        if (r9 == null) goto L131;
        r9.playData(r4.length);
        goto L131
    L118:
        r5 = 1;
        r17 = false;
    L131:
        if (r1.D == false) goto L3;
        if (r1.m.size() != 0) goto L3;
        if (r1.k.e() == true) goto L169;
        p58.a r11 = r1.k;
        r11.getClass();
        m58.t r12 = m58.h.m;
        if (r12 != null) goto L139;
    L141:
        boolean r13 = false;
    L142:
        if (r13 == false) goto L167;
        AudioTrack r14 = r11.c;
        if (r14 == null) goto L167;
        int r15 = r14.getPlayState();
        int r16 = r14.getPlaybackHeadPosition();
        int r19 = c68.b.a;
        c68.b.a("TTSAudioPlayer", r14.hashCode() + ":PlayState: " + r15 + ", AudioTrackState: " + r14.getState() + ", PlaybackHead: " + r16);
        if (r15 == 3) goto L151;
        c68.b.e("TTSAudioPlayer", r14.hashCode() + ":Not in PLAYING state: " + r15);
    L164:
        boolean r20 = true;
    L168:
        if (r20 == false) goto L3;
    L151:
        if (r16 > 0) goto L153;
    L166:
        r11.h = r16;
        r11.j = 0;
        goto L167
    L153:
        if (r16 != r11.h) goto L166;
        long r21 = System.currentTimeMillis();
        long r110 = r11.i;
        if (r110 > 0) goto L157;
    L165:
        r11.j = 0;
        goto L167
    L157:
        if ((r21 - r110) <= 5000) goto L165;
        c68.b.e("TTSAudioPlayer", r14.hashCode() + ":No data written for " + (r21 - r11.i) + "ms");
        long r111 = r11.j;
        if (r111 != 0) goto L162;
        r11.j = r21;
        goto L167
    L162:
        if ((r21 - r111) <= 3000) goto L167;
        c68.b.b("TTSAudioPlayer", r14.hashCode() + ":Silent playback detected for 3+ seconds, forcing completion");
    L167:
        r20 = false;
        goto L168
    L139:
        if (r12.enableAudioPlayerTimeoutCheck() != true) goto L141;
        r13 = true;
    L169:
        com.larus.audio.utils.z r22 = r1.F.b("[TTS][AUDIO_PLAY_COMPLETED] audio play completed");
        r22.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r23 = new Pair[2];
        r23[0] = TuplesKt.to(com.larus.audio.utils.a0.b, r2);
        com.larus.audio.utils.a0 r24 = com.larus.audio.utils.a0.e;
        if (r3 == null) goto L173;
        r10 = r3;
    L173:
        r23[1] = TuplesKt.to(r24, r10);
        r22.b(MapsKt.mapOf(r23));
        com.larus.audio.utils.z.a(r22);
        if (r1.k.b == AudioPlayerState.STOPPED) goto L181;
        n68.a r25 = r1.p;
        if (r25 == null) goto L178;
        r25.a(r1.r, r1.d, r2);
    L178:
        TtsTracer r26 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r2);
        if (r26 == null) goto L181;
        boolean r27 = false;
        r26.playEnd(0);
    L182:
        r1.J(r2, r27);
        TtsManager r29 = TtsManager.a;
        l68.b r30 = TtsManager.e(r2);
        if (r30 == null) goto L185;
        TtsLifeState r31 = TtsLifeState.TTS_FINISH_PLAYING;
        LinkedHashMap r32 = new LinkedHashMap();
        r32.put("scene_from", TtsFinishPlayingType.PLAY_DONE.getType());
        Unit r33 = Unit.INSTANCE;
        r30.e(r31, r2, r32);
    L185:
        l68.b r34 = TtsManager.e(r2);
        if (r34 == null) goto L188;
        TtsLifeState r35 = TtsLifeState.TTS_STOP;
        LinkedHashMap r36 = new LinkedHashMap();
        r36.put("scene_from", TtsStopType.PLAY_DONE.getType());
        Unit r37 = Unit.INSTANCE;
        r34.e(r35, r2, r36);
    L188:
        r1.l.remove(r2);
        r29.stop(r2);
        r29.c(r2);
        m58.a r38 = m58.h.h;
        if (r38 == null) goto L196;
        r38.d();
    L196:
        r1.D();
        m58.q r39 = m58.h.d;
        if (r39 == null) goto L213;
        TTSModule r40 = r39.d();
        if (r40 == null) goto L214;
        r40.i(r2, r3);
        return;
    L214:
        return;
    L213:
        return;
    L181:
        r27 = false;
        goto L182
    L29:
        if (r4.length != 0) goto L31;
        boolean r112 = true;
    L33:
        if ((!r112) == false) goto L111;
        PlayStateEnum r113 = PlayStateEnum.PLAY_STATE_PLAYING;
        n68.a r114 = r1.p;
        if (r114 == null) goto L38;
        r114.d(r113);
    L38:
        if (r1.o.compareAndSet(false, true) == false) goto L111;
        m58.a r115 = m58.h.h;
        if (r115 == null) goto L42;
        r115.c();
    L42:
        r1.v(r113);
        r1.f = r1.h;
        r1.g = r2;
        Lazy r116 = d68.c.a;
        String r117 = r1.h;
        if (r117 != null) goto L45;
    L48:
        boolean r118 = true;
    L49:
        if (r118 == false) goto L51;
        boolean r119 = true;
    L52:
        if (r119 == true) goto L61;
        k78.c r120 = r1.q;
        if (r120 == null) goto L56;
        r120.d(TtsStep.STEP_TTS_TO_AUDIO_PLAY.getTraceName(), null);
    L56:
        Lazy r121 = FlowAudioAsrAndTTSCostMobHelper.a;
        if (r3 != null) goto L59;
        String r122 = "";
    L60:
        FlowAudioAsrAndTTSCostMobHelper.c(r122, "tryPlay");
        goto L61
    L59:
        r122 = r3;
    L61:
        TtsManager r123 = TtsManager.a;
        l68.b r124 = TtsManager.e(r2);
        if (r124 == null) goto L65;
        r124.e(TtsLifeState.TTS_START_PLAYING, r2, null);
    L65:
        if (r1.w != (-1)) goto L70;
        r1.w = System.currentTimeMillis();
        TtsTracer r125 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r2);
        if (r125 == null) goto L69;
        r125.startPlay();
    L69:
        int r126 = l78.a.d;
        l78.a.a = System.currentTimeMillis();
    L70:
        Lazy r127 = FlowAudioAsrAndTTSCostMobHelper.a;
        if (r3 != null) goto L73;
        String r128 = "";
    L74:
        Intrinsics.checkNotNullParameter(r128, "msgId");
        JSONObject r129 = (JSONObject) ((FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1) FlowAudioAsrAndTTSCostMobHelper.b.getValue()).get(r128);
        if (r129 != null) goto L77;
    L95:
        k78.c r41 = r1.q;
        if (r41 == null) goto L98;
        r41.e(TtsStep.STEP_TTS_TO_AUDIO_PLAY.getTraceName(), null);
    L98:
        k78.c r42 = r1.q;
        if (r42 == null) goto L101;
        r42.e(TtsStep.STEP_TTS_GET_FIRST_AUDIO_DATA.getTraceName(), null);
    L101:
        com.larus.audio.utils.z r43 = r1.F.b("[TTS] reportStepSuccess STEP_TTS_TO_AUDIO_PLAY");
        r43.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r44 = new Pair[2];
        r44[0] = TuplesKt.to(com.larus.audio.utils.a0.b, r2);
        com.larus.audio.utils.a0 r130 = com.larus.audio.utils.a0.e;
        String r131 = r1.h;
        if (r131 != null) goto L104;
        r131 = "";
    L104:
        r44[1] = TuplesKt.to(r130, r131);
        r43.b(MapsKt.mapOf(r44));
        com.larus.audio.utils.z.a(r43);
        m58.u r45 = m58.h.l;
        if (r45 == null) goto L107;
        r45.j(r3, "tts_chat_first_pkg_to_tts_first_pkg", null, null);
    L107:
        m58.u r46 = m58.h.l;
        if (r46 == null) goto L110;
        r46.e(r3);
    L110:
        Lazy r47 = d68.c.a;
        ((List) r47.getValue()).clear();
        int r48 = c68.b.a;
        c68.b.d("FlowTtsMobHelper", "FlowTtsMobHelper clearAll list=" + GsonProtectorUtils.toJson(new Gson(), (List) r47.getValue()));
        goto L111
    L77:
        if (r129.has("on_tts_play") == true) goto L95;
        String r132 = (String) TtsManager.c.get(r128);
        if (r132 == null) goto L84;
        l68.a r133 = TtsManager.b.get(r132);
        if (r133 == null) goto L84;
        z58.a r134 = r133.c();
    L86:
        if (r134 == null) goto L90;
        Map<String, String> r135 = r134.m;
        if (r135 == null) goto L90;
        String r136 = r135.get("bot_id");
    L91:
        r129.put("on_tts_play", SystemClock.elapsedRealtime());
        m58.s r49 = m58.h.b;
        if (r49 == null) goto L94;
        r49.report("flow_tts_play_mob", r129);
    L94:
        r129.put("bot_id", r136);
    L90:
        r136 = null;
    L84:
        r134 = null;
        goto L86
    L73:
        r128 = r3;
        goto L74
    L51:
        r119 = ((List) d68.c.a.getValue()).contains(r117);
        goto L52
    L45:
        if (StringsKt.isBlank(r117) == true) goto L48;
        r118 = false;
        goto L49
    L31:
        r112 = false;
        goto L33
    L25:
        if (Intrinsics.areEqual(r1.f, r1.h) == true) goto L27;
    L191:
        com.larus.audio.utils.z r50 = r1.F.a("[TTS] tryPlay cancel");
        r50.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r51 = new Pair[3];
        r51[0] = TuplesKt.to(com.larus.audio.utils.a0.b, r2);
        com.larus.audio.utils.a0 r52 = com.larus.audio.utils.a0.e;
        if (r3 == null) goto L195;
        r10 = r3;
    L195:
        r51[1] = TuplesKt.to(r52, r10);
        r51[2] = TuplesKt.to(new com.larus.audio.utils.a0("need_cancel"), Boolean.valueOf(r1.C));
        r50.b(MapsKt.mapOf(r51));
        com.larus.audio.utils.z.a(r50);
        r1.m.clear();
        goto L196
    L17:
        if (r1.D == true) goto L19;
        r4 = (byte[]) r1.m.take();
        goto L21
    L19:
        r4 = null;
        goto L21
    L5:
        com.larus.audio.utils.z r53 = r1.F.b("[TTS] tryPlay pause");
        r53.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r54 = new Pair[2];
        com.larus.audio.utils.a0 r55 = com.larus.audio.utils.a0.b;
        String r56 = r1.g;
        if (r56 != null) goto L8;
        r56 = "";
    L8:
        r54[0] = TuplesKt.to(r55, r56);
        com.larus.audio.utils.a0 r57 = com.larus.audio.utils.a0.e;
        String r59 = r1.f;
        if (r59 == null) goto L12;
        r10 = r59;
    L12:
        r54[1] = TuplesKt.to(r57, r10);
        r53.b(MapsKt.mapOf(r54));
        com.larus.audio.utils.z.a(r53);
        goto L196
    }
}
