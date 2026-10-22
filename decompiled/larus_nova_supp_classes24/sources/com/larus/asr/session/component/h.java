package com.larus.asr.session.component;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.larus.asr.KmpAsrSessionAdapter;
import com.larus.asr.b2;
import com.larus.asr.x5;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import hq9.g1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class h implements p0 {
    public final com.larus.asr.session.p a;
    public final String b;
    public final f0 c;
    public final e d;
    public final f2a.d e;
    public final Lazy f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AsrEngineRoute.values().length];
            r0[AsrEngineRoute.KMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AsrEngineRoute.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AsrEngineRoute.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public void e(b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void f(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "engineTaskId");
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "chatType");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
    }

    public void g() {
    }

    public void h() {
    }

    @Override // com.larus.asr.session.component.p0
    public final void b(b0 r37, com.larus.asr.session.i r38) {
        Intrinsics.checkNotNullParameter(r37, "event");
        Intrinsics.checkNotNullParameter(r38, "complete");
        f0 r9 = r37.getContext();
        String r5 = r9.m;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L87:
        r38.invoke(c0.a.a);
        return;
    L11:
        if (((Boolean) r37.e.invoke()).booleanValue() == false) goto L87;
        f0 r2 = r37.getContext();
        k0 r3 = r2.b();
        wc9.e r4 = this.a.h();
        if (r4 == null) goto L16;
        String r10 = r4.a;
    L18:
        if (r10 != null) goto L20;
        String r14 = "";
    L21:
        if (r4 != null) goto L23;
    L25:
        boolean r11 = false;
    L26:
        boolean r12 = !r11;
        if (r4 == null) goto L29;
        String r6 = ic8.n.f(r4);
    L30:
        if (r6 != null) goto L32;
        r6 = "";
    L32:
        BotModel r13 = this.a.i();
        if (r13 == null) goto L35;
        String r15 = r13.getBotId();
    L36:
        if (r15 != null) goto L38;
        String r16 = "";
    L39:
        BotModel r17 = this.a.i();
        if (r17 == null) goto L42;
        String r19 = r17.getName();
    L43:
        if (r19 != null) goto L45;
        String r110 = "";
    L46:
        long r0 = ((Number) this.d.f.invoke(r3)).longValue();
        if (this.d.a == true) goto L49;
    L51:
        AsrEngineRoute r111 = AsrEngineRoute.NORMAL;
    L52:
        e(r37);
        r37.c.c(r3.g);
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Intrinsics.checkNotNullParameter(r111, "route");
        r2.m = r5;
        r2.n = r0;
        r2.o = r111;
        this.a.O9(this.b);
        x5.a().f(r12);
        this.a.setKeepScreenOn(true);
        f2a.c r112 = this.e.b("start ASR engine");
        LinkedHashMap r113 = new LinkedHashMap();
        String r21 = r6;
        r113.put(new f2a.f("engine_route"), r111.name());
        r113.put(new f2a.f("start_time"), String.valueOf(r0));
        f2a.f r7 = f2a.f.c;
        r113.put(r7, r5);
        r113.put(f2a.f.e, r16);
        r113.put(f2a.f.h, r14);
        r112.d(r113);
        r112.c.d = "onSpeak";
        List r8 = CollectionsKt.listOf(r3.d.a);
        f2a.g r20 = r112.c;
        r20.b = r8;
        r20.e = r3.d.b;
        f2a.c.c(r112, null, 15);
        int r22 = b.a[r111.ordinal()];
        if (r22 != 1) goto L55;
        String r23 = r16;
        String r114 = r14;
        f0 r115 = r37.getContext();
        k0 r116 = r115.b();
        Message r24 = r115.d;
        if (r24 != null) goto L74;
    L72:
        boolean r25 = false;
    L81:
        if (r25 == true) goto L85;
        Message r26 = r9.d;
        if (r26 == null) goto L85;
        ((com.larus.asr.session.n) this.f.getValue()).deleteOnNoAudioContent(r26);
    L85:
        h();
        r38.invoke(c0.b.a);
        return;
    L74:
        if (this.d.d == false) goto L76;
        String r117 = r116.a;
    L77:
        r25 = ((KmpAsrSessionAdapter) this.c.p.getValue()).e(r12, r114, r23, r5, d(r5, r117, r23, r110, r37.c).toString(), r116.h.c, r115.n, r116.d, new b2(), com.larus.asr.d.b, new i(r115, this, r37));
        f2a.c r27 = this.e.b("startWithKmpAsr");
        LinkedHashMap r29 = new LinkedHashMap();
        r29.put(new f2a.f("is_start"), String.valueOf(r25));
        r29.put(new f2a.f("chat_type"), r21);
        String r30 = r24.getLocalMessageId();
        if (r30 != null) goto L80;
        r30 = "";
    L80:
        r29.put(r7, r30);
        r27.d(r29);
        r27.c.d = "onSpeak";
        f2a.c.c(r27, null, 15);
        goto L81
    L76:
        r117 = "";
        goto L77
    L55:
        if (r22 != 2) goto L57;
        final f0 r31 = r37.getContext();
        k0 r32 = r31.b();
        com.larus.audio.o0 r118 = x5.b();
        AsrEngineStartPreComponent$startWithNormalAsr$1 r119 = new AsrEngineStartPreComponent$startWithNormalAsr$1(r37.b);
        if (this.d.b == false) goto L64;
        AsrEngineStartPreComponent$startWithNormalAsr$2 r33 = new AsrEngineStartPreComponent$startWithNormalAsr$2(r37.b);
    L65:
        String r34 = r16;
        AsrEngineStartPreComponent$startWithNormalAsr$2 r120 = r33;
        String r35 = r14;
        com.larus.audio.o0.a.a(r118, r5, r119, r120, new AsrEngineStartPreComponent$startWithNormalAsr$3(r37.b), new AsrEngineStartPreComponent$startWithNormalAsr$4(r37.b), null, null, 96);
        if (this.d.d == false) goto L68;
        String r36 = r32.a;
    L69:
        JSONObject r121 = d(r5, r36, r34, r110, r37.c);
        f(r5, r34, r21, r35);
        com.larus.audio.o0 r122 = x5.b();
        Message r39 = r31.d;
        String r40 = RepoDispatcherDelegate.b.c().S0();
        Integer r41 = r32.g;
        b2 r42 = new b2();
        long r43 = r31.n;
        Long r44 = r32.f;
        com.larus.audio.o0.a.b(r122, r39, r5, r35, null, r40, r121, false, r34, false, null, r42, (String) this.d.e.invoke(), r43, r41, r44, com.larus.asr.d.b, new g(r31, this), r32.h.c, r32.d, 840);
        r25 = true;
        goto L81
    L68:
        r36 = "";
        goto L69
    L64:
        r33 = null;
        goto L65
    L57:
        if (r22 == 3) goto L72;
        throw new NoWhenBranchMatchedException();
    L49:
        if (z2.a.enableKmpAsr() == false) goto L51;
        r111 = AsrEngineRoute.KMP;
        goto L52
    L45:
        r110 = r19;
        goto L46
    L42:
        r19 = null;
        goto L43
    L38:
        r16 = r15;
        goto L39
    L35:
        r15 = null;
        goto L36
    L29:
        r6 = null;
        goto L30
    L23:
        if (ic8.n.r(r4) == true) goto L25;
        r11 = true;
        goto L26
    L20:
        r14 = r10;
        goto L21
    L16:
        r10 = null;
        goto L18
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public h(com.larus.asr.session.p r2, String r3, f0 r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r4, "asrContext");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new f2a.d("VoiceInput", "AsrEngineStartPre");
        this.f = LazyKt.lazy(new f(this));
    }

    public final JSONObject d(String r5, String r6, String r7, String r8, n0 r9) {
        int r0 = AsrSessionComponentUtils.a;
        com.larus.asr.session.p r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "sessionContext");
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Intrinsics.checkNotNullParameter(r6, "itemId");
        JSONObject r2 = new JSONObject();
        r2.put("local_message_id", r5);
        r2.put("item_id", r6);
        boolean r3 = false;
        if (com.larus.bmhome.utils.i.f(r1.h()) == false) goto L7;
        g1 r10 = z2.a.getAsrCheckAudioConfig();
        if (r10 == null) goto L7;
        int r11 = r10.a();
    L8:
        r2.put("check_audio_tag", r11);
        e58.a.a(r2);
        e58.a.d(r2, r1.L0(), r1.E9());
        e58.a.c(r2);
        e58.a.b(r2);
        hq9.n r12 = z2.a.U0().a();
        if (r12 != null) goto L11;
    L13:
        if (r3 == false) goto L19;
        JSONObject r13 = new JSONObject();
        r13.put("version", 1);
        if (this.d.b == false) goto L17;
        r13.put("chat", this.a.Xa());
    L17:
        JSONObject r4 = new JSONObject();
        r4.put("id", r7);
        r4.put("name", r8);
        Unit r14 = Unit.INSTANCE;
        r13.put("bot_info", r4);
        r2.put("context", r13);
    L19:
        if (this.d.b == false) goto L24;
        if (this.a.Ra() == false) goto L24;
        r2.put("enable_asr_twopass", true);
    L24:
        if (this.d.c == false) goto L32;
        Map r15 = this.a.qa();
        if (r15 == null) goto L32;
        Iterator r16 = r15.entrySet().iterator();
    L29:
        if (r16.hasNext() == false) goto L32;
        Map.Entry r17 = (Map.Entry) r16.next();
        r2.put((String) r17.getKey(), (String) r17.getValue());
    L32:
        if (this.d.b == false) goto L54;
        JsonObject r19 = z2.a.getStreamAsrConfig().c();
        if (r19 == null) goto L54;
        Set r20 = r19.keySet();
        if (r20 == null) goto L54;
        Iterator r21 = r20.iterator();
    L39:
        if (r21.hasNext() == false) goto L54;
        String r22 = (String) r21.next();
        JsonPrimitive r23 = r19.get(r22);
        if ((r23 instanceof JsonPrimitive) == false) goto L43;
        JsonPrimitive r24 = r23;
    L44:
        if (r24 == null) goto L39;
        if (r24.isNumber() == true) goto L47;
        if (r24.isString() == true) goto L50;
        if (r24.isBoolean() == false) goto L39;
        r2.put(r22, r24.getAsBoolean());
        goto L39
    L50:
        r2.put(r22, r24.getAsString());
        goto L39
    L47:
        r2.put(r22, r24.getAsNumber());
        goto L39
    L43:
        r24 = null;
    L54:
        r9.a(r5, r2);
        return r2;
    L11:
        if (r12.b() != true) goto L13;
        r3 = true;
    L7:
        r11 = 0;
        goto L8
    }
}
