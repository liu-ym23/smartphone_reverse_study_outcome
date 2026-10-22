package com.larus.audio.ttsV2;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.utils.j0;
import com.larus.im.bean.bot.BotModel;
import com.larus.media.MediaResourceManager;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.v3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z implements l68.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[TtsLifeState.values().length];
            r0[TtsLifeState.TTS_FINISH_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[TtsLifeState.TTS_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[TtsLifeState.TTS_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
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
    public final void d(TtsState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // l68.b
    public final void a(TtsTracer r2) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
    }

    @Override // l68.b
    public final void e(TtsLifeState r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "lifeState");
        int r0 = c68.b.a;
        TtsClientManager r1 = TtsClientManager.a;
        c68.b.d("TtsClientManager", "startByText onLifeStateChange lifeState=" + r3 + " taskId=" + r4 + " extraMap=" + GsonProtectorUtils.toJson(new Gson(), r5));
        if (ObricTtsControlDelegate.b.e() == false) goto L13;
        int r6 = a.a[r3.ordinal()];
        if (r6 != 1) goto L7;
    L11:
        c68.b.d("TtsClientManager", "reset isLastTaskFromText to false");
        TtsClientManager.e = false;
        return;
    L7:
        if (r6 == 2) goto L11;
        if (r6 == 3) goto L11;
        return;
    }

    public z(String r1, String r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // l68.b
    public final void c(TtsEventEnum r9, String r10, int r11, String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r10, "customErrorMsg");
        Intrinsics.checkNotNullParameter(r12, "ext");
        Intrinsics.checkNotNullParameter(r13, "extMap");
        int r14 = a.b[r9.ordinal()];
        String r15 = null;
        String r2 = "";
        if (r14 == 1) goto L32;
        if (r14 == 2) goto L26;
        if (r14 != 3) goto L74;
        Object r16 = r13.get("text");
        if ((r16 instanceof String) == false) goto L10;
        String r17 = (String) r16;
    L11:
        Object r19 = r13.get("lang");
        if ((r19 instanceof m68.a) == false) goto L14;
        m68.a r110 = (m68.a) r19;
    L15:
        IAIChatTtsPlayTraceService.Companion r111 = IAIChatTtsPlayTraceService.a;
        String r112 = this.e;
        if (r112 == null) goto L19;
        r2 = r112;
    L19:
        if (r110 == null) goto L21;
        String r113 = r110.a();
    L22:
        if (r110 == null) goto L24;
        r15 = r110.b();
    L24:
        r111.d(r2, r17, r113, r15);
        return;
    L21:
        r113 = null;
        goto L22
    L14:
        r110 = null;
        goto L15
    L10:
        r17 = null;
        goto L11
    L74:
        return;
    L26:
        if (new JSONObject(r12).optBoolean("is_cache") == false) goto L72;
        String r20 = this.c;
        String r114 = this.b;
        BotModel r115 = TtsClientManager.b;
        if (r115 == null) goto L30;
        r15 = r115.getBotId();
    L30:
        v3.a(r20, r114, r15, this.d, this.a);
        return;
    L72:
        return;
    L32:
        if (j0.a() == false) goto L45;
        f2a.c r21 = TtsClientManager.i.a("[TTS][O_CALL PLAYING] O_CALL is playing, return");
        r21.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r116 = new Pair[3];
        f2a.f r4 = f2a.f.h;
        String r5 = this.a;
        if (r5 != null) goto L36;
        r5 = "";
    L36:
        r116[0] = TuplesKt.to(r4, r5);
        f2a.f r6 = f2a.f.i;
        String r7 = this.b;
        if (r7 != null) goto L39;
        r7 = "";
    L39:
        r116[1] = TuplesKt.to(r6, r7);
        f2a.f r1 = new f2a.f("start_read_message_reason");
        String r3 = this.c;
        if (r3 == null) goto L43;
        r2 = r3;
    L43:
        r116[2] = TuplesKt.to(r1, r2);
        r21.d(MapsKt.mapOf(r116));
        f2a.c.c(r21, null, 15);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().g(TtsClientManager.d, false, "TtsClientManager TTS_FIRST_PACKAGE skipped by O_CALL playing");
        return;
    L45:
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L48;
        r22.K0();
        boolean r23 = com.larus.music.i.a.h();
    L50:
        if (ObricTtsControlDelegate.b.e() == false) goto L53;
        TtsClientManager.m = TtsClientManager.m(r23);
    L59:
        f2a.c r8 = TtsClientManager.i.b("[TTS] TTS_FIRST_PACKAGE");
        r8.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r24 = new Pair[5];
        f2a.f r25 = f2a.f.h;
        String r26 = this.a;
        if (r26 != null) goto L62;
        r26 = "";
    L62:
        r24[0] = TuplesKt.to(r25, r26);
        f2a.f r27 = f2a.f.i;
        String r29 = this.b;
        if (r29 != null) goto L65;
        r29 = "";
    L65:
        r24[1] = TuplesKt.to(r27, r29);
        f2a.f r30 = new f2a.f("start_read_message_reason");
        String r31 = this.c;
        if (r31 == null) goto L69;
        r2 = r31;
    L69:
        r24[2] = TuplesKt.to(r30, r2);
        r24[3] = TuplesKt.to(new f2a.f("is_qq_music_play"), Boolean.valueOf(r23));
        r24[4] = TuplesKt.to(new f2a.f("current_application"), TtsClientManager.m);
        r8.d(MapsKt.mapOf(r24));
        f2a.c.c(r8, null, 15);
        Lazy r32 = MediaResourceManager.a;
        com.larus.media.model.a r33 = TtsClientManager.m;
        final String r117 = this.b;
        Function1 r118 = new v(r117);
        final String r119 = this.a;
        final String r0 = this.c;
        MediaResourceManager.m(r33, r118, new w(r119, r117, r0), 0, 8);
        return;
    L53:
        if (TtsClientManager.j == true) goto L57;
        if (r23 == true) goto L57;
        com.larus.media.model.a r34 = TtsClientManager.k;
    L58:
        TtsClientManager.m = r34;
    L57:
        r34 = TtsClientManager.l;
        goto L58
    L48:
        r23 = false;
        goto L50
    }
}
