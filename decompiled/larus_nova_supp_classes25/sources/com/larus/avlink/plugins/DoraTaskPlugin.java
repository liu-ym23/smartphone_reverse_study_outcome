package com.larus.avlink.plugins;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.dora.DoraType;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.model.VuiEndScene;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.cmd.ReplyStage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraTaskPlugin extends com.larus.audio.call.arch.a<n4> implements n3 {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;
    public final String f;
    public Function1<? super z98.f, Unit> g;
    public boolean h;
    public String i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final buc.a m;
    public final buc.a n;
    public boolean o;
    public com.larus.audio.call.o p;
    public final buc.e<Pair<Integer, Integer>> q;
    public com.larus.audio.call.p r;
    public com.larus.audio.call.o s;
    public final buc.a t;
    public final buc.a u;
    public final buc.e<i> v;
    public final buc.e<CommandSendStatus> w;
    public String x;
    public String y;
    public final int z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommandSendStatus.values().length];
            r0[CommandSendStatus.DOUBAO_RECV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommandSendStatus.DOUBAO_SEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ DoraTaskPlugin b;

        public final String getName() {
            return this.a;
        }

        public c(DoraTaskPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r10, jd9.c r11) {
            Intrinsics.checkNotNullParameter(r10, "oldState");
            Intrinsics.checkNotNullParameter(r11, "newState");
            if ((r11 instanceof jd9.c.a) == false) goto L16;
            this.b.n.d(false);
            com.larus.audio.call.o r12 = this.b.p;
            if (r12 == null) goto L7;
            r12.a();
        L7:
            Lazy r13 = ia8.m.a;
            ia8.m.b(DoraEvent.SessionStarted);
            this.b.m.d(true);
            DoraTaskPlugin r14 = this.b;
            r14.o = true;
            com.larus.avlink.n1.d(r14.f, "Session connected, sessionType: " + com.larus.im.service.audio.y0.c(((n4) this.b.getContext()).params().s));
            if (com.larus.im.service.audio.y0.c(((n4) this.b.getContext()).params().s) == false) goto L53;
            com.larus.audio.call.p r15 = this.b.r;
            if (r15 == null) goto L12;
            r15.a();
        L12:
            com.larus.audio.call.o r16 = this.b.s;
            if (r16 == null) goto L54;
            r16.a();
            return;
        L54:
            return;
        L53:
            return;
        L16:
            if ((r11 instanceof jd9.c.b) == false) goto L23;
            if (com.larus.im.service.audio.y0.b(((n4) this.b.getContext()).params().s) == false) goto L56;
            com.larus.avlink.n1.d(this.b.f, "MMT reconnecting after " + r10);
            if ((r10 instanceof jd9.c.a) == false) goto L57;
            this.b.n.d(true);
            final DoraTaskPlugin r17 = this.b;
            r17.o3("mmt_reconnecting", new l3(r17));
            return;
        L57:
            return;
        L56:
            return;
        L23:
            if ((r11 instanceof jd9.c.d) == false) goto L59;
            this.b.n.d(false);
            DoraTaskPlugin r0 = this.b;
            jd9.c.d r18 = (jd9.c.d) r11;
            int r3 = r18.c;
            int r19 = r18.d;
            String r110 = r10.toString();
            com.larus.avlink.n1.d(r0.f, "onConnectionStateChanged receive error: " + r110 + ", " + r3);
            if (com.larus.audio.call.arch.b.a(r0.getContext()).e0().isPlaying() == false) goto L32;
            buc.e<Pair<Integer, Integer>> r111 = r0.q;
            if (r19 != 0) goto L29;
            Pair r112 = TuplesKt.to(13, Integer.valueOf(r19));
        L30:
            r111.d(r112);
        L48:
            if (com.larus.im.service.audio.y0.c(((n4) this.b.getContext()).params().s) == false) goto L60;
            com.larus.audio.call.o r113 = this.b.s;
            if (r113 == null) goto L61;
            r113.a();
            return;
        L61:
            return;
        L60:
            return;
        L29:
            r112 = TuplesKt.to(6, Integer.valueOf(r19));
            goto L30
        L32:
            if (r19 == 0) goto L34;
            com.larus.avlink.n1.d(r0.f, "trySendNetworkError code: " + r19);
            ((n4) r0.getContext()).m(r19);
            com.larus.avlink.n1.d(r0.f, "tryNetworkError code: " + r19);
            DoraEvent r6 = DoraEvent.NetworkError;
            r6.setExtra("NetworkError Code::" + r19);
            ia8.m.b(r6);
            if (r19 != 2) goto L40;
            Map<Function1<Boolean, Unit>, k4> r7 = x2.a;
            x2.g(DoraCallStateCode.DOUBAO_VUI_ERROR, "trySendNetworkError", r0.p3(MapsKt.mapOf(new Pair[]{TuplesKt.to("detail_code", "2-3-1"), TuplesKt.to("err_msg", "websocket state changed to 2")})));
        L42:
            if (r0.h == true) goto L48;
            com.larus.avlink.n1.d(r0.f, "updateVUIState STOP");
            CoroutineScope r4 = ((n4) r0.getContext()).r();
            if (r4 == null) goto L46;
            BuildersKt.launch$default(r4, Dispatchers.getIO(), null, new DoraTaskPlugin$trySendNetworkError$1(r19, null), 2, null);
        L46:
            r0.h = true;
            goto L48
        L40:
            Map<Function1<Boolean, Unit>, k4> r114 = x2.a;
            x2.g(r19, "trySendNetworkError", MapsKt.emptyMap());
            goto L42
        L34:
            if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L36;
            Map<Function1<Boolean, Unit>, k4> r115 = x2.a;
            x2.g(DoraCallStateCode.DOUBAO_VUI_ERROR, "network error", r0.p3(MapsKt.mapOf(new Pair[]{TuplesKt.to("detail_code", "3-1-2"), TuplesKt.to("err_msg", "network error")})));
        L36:
            ((n4) r0.getContext()).d(false, 5, DoraCallStateCode.DOUBAO_NETWORK_ERROR_INVALID);
            goto L48
        }
    }

    public static final class d extends com.larus.im.service.audio.a1 {
        public final String a;
        public final /* synthetic */ DoraTaskPlugin b;

        public final String g() {
            return this.a;
        }

        public d(DoraTaskPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r17) {
            Intrinsics.checkNotNullParameter(r17, "event");
            DoraTaskPlugin r3 = this.b;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r17, "event");
            String r4 = "";
            if ((r17 instanceof pf9.z) == false) goto L5;
            r3.x = "";
            r3.y = "";
            r3.i = ((pf9.z) r17).a;
            return;
        L5:
            String r5 = null;
            if ((r17 instanceof pf9.c0) == false) goto L21;
            pf9.a r0 = ((pf9.c0) r17).a;
            if (r0 == null) goto L10;
            String r1 = r0.a;
        L11:
            r3.x = r1;
            r3.y = "";
            r3.q.d(TuplesKt.to(-1, 0));
            com.larus.audio.call.o r2 = r3.p;
            if (r2 == null) goto L14;
            r2.a();
        L14:
            r3.j = false;
            r3.k = false;
            if (r3.l == false) goto L157;
            r3.l = false;
            CoroutineScope r6 = ((n4) r3.getContext()).r();
            if (r6 == null) goto L19;
            BuildersKt.launch$default(r6, Dispatchers.getIO(), null, new DoraTaskPlugin$handleReceiverEvent$1(r3, null), 2, null);
        L19:
            Lazy r7 = ia8.m.a;
            ia8.m.b(DoraEvent.FirstASRResponse);
            return;
        L157:
            return;
        L10:
            r1 = null;
            goto L11
        L21:
            if ((r17 instanceof pf9.a0) == false) goto L29;
            String r8 = r3.i;
            if (r8 == null) goto L25;
            Lazy r9 = ia8.m.a;
            Intrinsics.checkNotNullParameter(r8, "questionId");
            Keva r10 = ia8.m.b;
            r10.storeStringJustDisk(r8, ia8.m.d);
            r10.storeStringJustDisk("session_type_" + ia8.m.d, ia8.m.h);
        L25:
            Lazy r11 = ia8.m.a;
            ia8.m.b(DoraEvent.ASREnded);
            r3.j = false;
            r3.l = true;
            CoroutineScope r12 = ((n4) r3.getContext()).r();
            if (r12 == null) goto L159;
            BuildersKt.launch$default(r12, Dispatchers.getIO(), null, new DoraTaskPlugin$handleReceiverEvent$3(r3, r17, null), 2, null);
            return;
        L159:
            return;
        L29:
            if ((r17 instanceof pf9.d0) == false) goto L32;
            r3.y = "";
            return;
        L32:
            if ((r17 instanceof pf9.f0) == false) goto L58;
            pf9.f0 r13 = (pf9.f0) r17;
            if (r13.d != ReplyStage.Begin) goto L51;
            String r14 = r3.y;
            pf9.m r15 = r13.c;
            if (r15 == null) goto L40;
            Map r16 = r15.a;
            if (r16 == null) goto L40;
            r5 = (String) r16.get(ChatDraftItem.TYPE_TEXT);
        L40:
            if (r5 == null) goto L49;
            if (r14 == null) goto L45;
            r4 = r14;
        L45:
            String r18 = r4.concat(r5);
            int r19 = r18.length();
            int r20 = r3.z;
            if (r19 <= r20) goto L48;
            r18 = r18.substring(0, r20);
        L48:
            r14 = r18;
        L49:
            r3.y = r14;
            return;
        L51:
            if (pf9.i.b(r13) == true) goto L53;
            return;
        L53:
            if (r3.j == true) goto L164;
            Lazy r21 = ia8.m.a;
            ia8.m.b(DoraEvent.FirstTTSResponse);
            r3.j = true;
            CoroutineScope r22 = ((n4) r3.getContext()).r();
            if (r22 == null) goto L165;
            BuildersKt.launch$default(r22, Dispatchers.getIO(), null, new DoraTaskPlugin$handleReceiverEvent$4(r3, null), 2, null);
            return;
        L165:
            return;
        L164:
            return;
        L58:
            if ((r17 instanceof pf9.e0) == false) goto L67;
            if (((pf9.e0) r17).a == false) goto L62;
            Map<Function1<Boolean, Unit>, k4> r23 = x2.a;
            x2.j("TTS_START", null);
            x2.j("DATA_END", null);
        L62:
            r3.j = false;
            r3.k = true;
            CoroutineScope r24 = ((n4) r3.getContext()).r();
            if (r24 == null) goto L65;
            BuildersKt.launch$default(r24, Dispatchers.getIO(), null, new DoraTaskPlugin$handleReceiverEvent$5(r3, null), 2, null);
        L65:
            Lazy r25 = ia8.m.a;
            ia8.m.b(DoraEvent.TTSEnded);
            return;
        L67:
            if ((r17 instanceof pf9.q) == false) goto L168;
            List r26 = ((pf9.q) r17).a;
            ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
            Iterator r28 = r26.iterator();
        L70:
            if (r28.hasNext() == false) goto L169;
            pf9.p r110 = (pf9.p) r28.next();
            Long r29 = r110.a;
            if (r29 == null) goto L143;
            int r30 = (int) r29.longValue();
            if (r30 != 3) goto L76;
            Map r111 = r110.b;
            if (r111 == null) goto L143;
            ia8.q r31 = ia8.q.a;
            String r112 = (String) r111.get("cover_uri");
            if (r112 != null) goto L93;
            r112 = "";
        L93:
            String r113 = (String) r111.get("cover_urls");
            if (r113 != null) goto L96;
            r113 = "";
        L96:
            String r114 = (String) r111.get("template_prefix");
            if (r114 != null) goto L99;
            r114 = "";
        L99:
            r31.getClass();
            Intrinsics.checkNotNullParameter(r112, "coverUri");
            Intrinsics.checkNotNullParameter(r113, "coverUrls");
            Intrinsics.checkNotNullParameter(r114, "templatePrefix");
            if (r113.length() <= 0) goto L102;
            boolean r32 = true;
        L103:
            if (r32 == true) goto L147;
            com.larus.avlink.n1.b(ia8.q.b, "getMusicCoverUrl: commandType.param?.coverUrls is null");
        L133:
            String r33 = "";
        L134:
            String r34 = (String) r111.get("song_name");
            if (r34 != null) goto L137;
            r34 = "";
        L137:
            String r115 = (String) r111.get("artist_name");
            if (r115 != null) goto L140;
            r115 = "";
        L140:
            z98.f r116 = new z98.f(r33, r34, r115);
            Function1<? super z98.f, Unit> r35 = r3.g;
            if (r35 == null) goto L143;
            r35.invoke(r116);
            goto L143
        L147:
            Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L126
            Object r37 = Result.constructor-impl(ouc.a.d.e(r113));     // Catch: Throwable -> L107
        L110:
            if (Result.isFailure-impl(r37) == false) goto L112;
            r37 = null;
        L112:
            ouc.b r38 = (ouc.i) r37;     // Catch: Throwable -> L126
            if (r38 != null) goto L115;
        L117:
            ouc.b r39 = null;
        L118:
            if (r39 != null) goto L120;
        L124:
            Object r40 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L126
        L128:
            Throwable r41 = Result.exceptionOrNull-impl(r40);
            if (r41 == null) goto L131;
            com.larus.avlink.n1.c(ia8.q.b, "getMusicCoverUrl: failed", r41);
        L131:
            Result.box-impl(r40);
            goto L133
        L120:
            if ((!r39.isEmpty()) == false) goto L124;
            r33 = ia8.q.a(ouc.k.o(r39.a(0)).a(), r112, r114);     // Catch: Throwable -> L126
            com.larus.avlink.n1.d(ia8.q.b, "getMusicCoverUrl: coverUrl=" + r33);     // Catch: Throwable -> L126
            if (r33 != null) goto L134;
        L115:
            if ((r38 instanceof ouc.b) == false) goto L117;
            r39 = r38;     // Catch: Throwable -> L126
        L107:
            th = move-exception;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L126
            r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        L126:
            th = move-exception;
            Result.Companion r42 = Result.Companion;
            r40 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L128
        L102:
            r32 = false;
            goto L103
        L76:
            switch(r30) {
                case 12: goto L87;
                case 13: goto L78;
                case 14: goto L78;
                default: goto L143;
            };
        L78:
            DoraEvent r118 = DoraEvent.ChatCommend;
            r118.setMessage("ChatCommend: " + r110.a);
            r118.setExtra("ChatCommend:" + r110.a);
            ia8.m.b(r118);
            com.larus.avlink.n1.d(r3.f, "DORA_STOP_LISTEN_NOW_IF_NO_TTS ttsContentScene: voice appease stop");
            if (r30 != 14) goto L81;
            boolean r43 = true;
        L82:
            n4 r119 = (n4) r3.getContext();
            if (r43 == true) goto L85;
            int r120 = DoraCallStateCode.DOUBAO_CMD_13;
        L86:
            r119.d(r43, 10, r120);
            goto L143
        L85:
            r120 = DoraCallStateCode.DOUBAO_CMD_14;
            goto L86
        L81:
            r43 = false;
            goto L82
        L87:
            DoraEvent r44 = DoraEvent.ChatCommend;
            r44.setMessage("ChatCommend:" + r110.a);
            r44.setExtra("ChatCommend:" + r110.a);
            ia8.m.b(r44);
            ((n4) r3.getContext()).d(false, 9, DoraCallStateCode.DOUBAO_CMD_12);
        L143:
            r27.add(r110);
            goto L70
        L169:
            return;
        }

        public final void q(String r5, Object r6) {
            Intrinsics.checkNotNullParameter(r5, "event");
            switch(r5.hashCode()) {
                case -1821848923: goto L69;
                case -796984634: goto L65;
                case 1310460179: goto L47;
                case 1517194242: goto L16;
                case 1624133454: goto L10;
                case 2027072059: goto L6;
                default: goto L86;
            };
        L86:
            return;
        L6:
            if (r5.equals("OTHER_EVENT_REQUEST_RETRIED_TOAST") == false) goto L87;
            this.b.m.d(true);
            Lazy r7 = ia8.m.a;
            ia8.m.b(DoraEvent.NetworkRecover);
            return;
        L87:
            return;
        L10:
            if (r5.equals("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST") == true) goto L13;
            return;
        L13:
            if (com.larus.im.service.audio.y0.c(((n4) this.b.getContext()).params().s) == false) goto L74;
            this.b.o3("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST", new i3());
            return;
        L74:
            return;
        L16:
            if (r5.equals("OTHER_UPDATE_SESSION_STATUS") == true) goto L19;
            return;
        L19:
            if (Intrinsics.areEqual(r6, 21) == false) goto L21;
        L42:
            com.larus.audio.call.o r8 = this.b.s;
            if (r8 == null) goto L45;
            r8.a();
        L45:
            Lazy r9 = ia8.m.a;
            ia8.m.a(DoraEvent.SessionFailed);
            return;
        L21:
            if (Intrinsics.areEqual(r6, 31) == true) goto L42;
            if (Intrinsics.areEqual(r6, 12) == false) goto L30;
            com.larus.audio.call.o r10 = this.b.s;
            if (r10 == null) goto L28;
            r10.a();
        L28:
            DoraEvent r11 = DoraEvent.WSDisconnected;
            r11.setMessage("WS DC State: 3");
            ia8.m.a(r11);
            return;
        L30:
            if (Intrinsics.areEqual(r6, 11) == false) goto L33;
            DoraEvent r12 = DoraEvent.WSDisconnected;
            r12.setMessage("WS DC State: 2");
            ia8.m.a(r12);
            return;
        L33:
            if (Intrinsics.areEqual(r6, 30) == false) goto L78;
            this.b.m.d(true);
            DoraTaskPlugin r13 = this.b;
            r13.o = true;
            if (v88.a.f(Integer.valueOf(((n4) r13.getContext()).q())) == true) goto L39;
            com.larus.audio.call.p r14 = this.b.r;
            if (r14 == null) goto L39;
            r14.a();
        L39:
            com.larus.audio.call.o r15 = this.b.s;
            if (r15 == null) goto L79;
            r15.a();
            return;
        L79:
            return;
        L78:
            return;
        L47:
            if (r5.equals("OTHER_EVENT_RTC_NETWORK_CHANGE") == true) goto L50;
            return;
        L50:
            if ((r6 instanceof Integer) == false) goto L52;
            Integer r16 = (Integer) r6;
        L53:
            com.larus.avlink.n1.d(this.b.f, "network type: " + r16);
            if (r16 != null) goto L57;
        L59:
            if (r16 != null) goto L62;
        L63:
            this.b.m.d(true);
            return;
        L62:
            if (r16.intValue() != (-1)) goto L63;
            return;
        L57:
            if (r16.intValue() != 0) goto L59;
            this.b.o3("OTHER_EVENT_RTC_NETWORK_CHANGE", new i3());
            return;
        L52:
            r16 = null;
            goto L53
        L65:
            if (r5.equals("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY") == false) goto L91;
            Lazy r17 = ia8.m.a;
            ia8.m.a(DoraEvent.WSReConnect);
            return;
        L91:
            return;
        L69:
            if (r5.equals("OTHER_EVENT_START_SESSION") == false) goto L92;
            Lazy r18 = ia8.m.a;
            ia8.m.b(DoraEvent.StartSession);
            return;
        }
    }

    static {
    }

    @Override // com.larus.avlink.plugins.n3
    public final boolean K() {
        boolean r0 = this.u.c();
        this.u.d(false);
        return r0;
    }

    @Override // com.larus.avlink.plugins.n3
    public final void N0() {
        this.u.d(true);
    }

    @Override // com.larus.avlink.plugins.n3
    public final void O() {
        this.u.d(true);
        if (this.t.c() == true) goto L7;
        if (this.k == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_half_duplex") == true) goto L13;
        CoroutineScope r1 = ((n4) getContext()).r();
        if (r1 == null) goto L14;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new DoraTaskPlugin$postponeVadIfNeed$1(this, null), 2, null);
        return;
    L14:
        return;
    }

    public final com.larus.im.service.audio.v R2() {
        return new c(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new d(this);
    }

    public final void m3() {
        i r1 = (i) this.v.c();
        int r2 = b.a[((CommandSendStatus) this.w.c()).ordinal()];
        Long r10 = null;
        if (r2 != 1) goto L5;
        long r3 = System.currentTimeMillis();
        Long r11 = r1.c;
        if (r11 == null) goto L38;
        long r12 = r11.longValue();
        Long r13 = r1.d;
        if (r13 == null) goto L36;
        Long r14 = Long.valueOf(r13.longValue() - r12);
    L37:
        Long r15 = r14;
    L39:
        Long r16 = r1.d;
        if (r16 == null) goto L42;
        Long r17 = Long.valueOf(r3 - r16.longValue());
    L43:
        Long r18 = r1.c;
        if (r18 == null) goto L46;
        r10 = Long.valueOf(r3 - r18.longValue());
    L46:
        com.larus.audio.call.tracer.c.a.a(((n4) getContext()).k(), "doubao_send", r1.a, r1.b, r15, r17, r10, 11, 32);
        com.larus.avlink.n1.d(this.f, "reportDoraCommandSend in Abnormal end >>>command is " + r1.a + ", messageId is " + r1.b + ", commandStartTime is " + r1.c + ", commandReceiveTime is " + r1.d + ", commandSendTime is " + r3);
        return;
    L42:
        r17 = null;
        goto L43
    L36:
        r14 = null;
        goto L37
    L38:
        r15 = null;
        goto L39
    L5:
        if (r2 != 2) goto L49;
        long r4 = System.currentTimeMillis();
        Long r19 = r1.c;
        if (r19 == null) goto L14;
        long r110 = r19.longValue();
        Long r111 = r1.d;
        if (r111 == null) goto L12;
        Long r112 = Long.valueOf(r111.longValue() - r110);
    L13:
        Long r113 = r112;
    L15:
        Long r114 = r1.d;
        if (r114 == null) goto L22;
        long r115 = r114.longValue();
        Long r116 = r1.e;
        if (r116 == null) goto L20;
        Long r117 = Long.valueOf(r116.longValue() - r115);
    L21:
        Long r118 = r117;
    L23:
        Long r119 = r1.e;
        if (r119 == null) goto L26;
        Long r120 = Long.valueOf(r4 - r119.longValue());
    L27:
        Long r121 = r1.c;
        if (r121 == null) goto L30;
        r10 = Long.valueOf(r4 - r121.longValue());
    L30:
        ((n4) getContext()).k().V("dora", r1.a, r1.b, r113, r118, r120, r10, 11);
        com.larus.avlink.n1.d(this.f, "reportDoraCommandSend in Abnormal end >>>command is " + r1.a + ", messageId is " + r1.b + ", commandStartTime is " + r1.c + ", commandReceiveTime is " + r1.d + ", commandSendTime is " + r4);
        return;
    L26:
        r120 = null;
        goto L27
    L20:
        r117 = null;
        goto L21
    L22:
        r118 = null;
        goto L23
    L12:
        r112 = null;
        goto L13
    L14:
        r113 = null;
        goto L15
    }

    @Override // com.larus.avlink.plugins.n3
    public final boolean y2() {
        Pair r0 = (Pair) this.q.c();
        com.larus.avlink.n1.d(this.f, "handPendingIfTtsStop onFinish millisInFuture, pendingError = " + r0);
        if (((Number) r0.getFirst()).intValue() != 6) goto L5;
    L16:
        final int r1 = ((Number) r0.getSecond()).intValue();
        com.larus.avlink.n1.d(this.f, "handPendingIfTtsStop NETWORK_ERROR");
        n3(2000, new e3(this, r1));
        return true;
    L5:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L16;
        if (((Number) r0.getFirst()).intValue() != 13) goto L11;
        com.larus.avlink.n1.d(this.f, "handPendingIfTtsStop DORA_STOP");
        n3(2000, new f3(this));
        return false;
    L11:
        if (this.m.c() == true) goto L18;
        n3(15000, new g3(this));
        return true;
    L18:
        return false;
    }

    @Override // com.larus.avlink.plugins.n3
    public final void I1() {
        if (Intrinsics.areEqual(((n4) getContext()).params().o.a, ia8.m.d) == false) goto L5;
        ia8.m.b(DoraEvent.VuiTtsEnd);
    L5:
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        x2.j("TTS_END", this.y);
        x2.k((k4) this.A.getValue());
        m3();
    }

    @Override // com.larus.avlink.plugins.n3
    public final void a() {
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == false) goto L8;
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        v2 r1 = x2.b();
        com.larus.avlink.n1.d(this.f, "[onTick] startSendResetEventTimerOnRation sendVUIEvent: Reset start, startSessionTimeoutEnable=" + r1.a + ", startSessionTimeoutOnRadio=" + r1.c);
        if (r1.a == false) goto L9;
        final long r2 = (((long) r1.c) * 1000) + 2000;
        com.larus.audio.call.p r3 = new DoraTaskPlugin$startSendResetEventTimerOnRation$1(r2, this);
        this.r = r3;
        r3.d();
        return;
    L9:
        return;
    }

    public final void e3() {
        super.e3();
        this.h = false;
        this.m.d(true);
        int r0 = ((n4) getContext()).q();
        Lazy r2 = ia8.m.a;
        String r3 = ((n4) getContext()).params().o.a;
        String r4 = ((n4) getContext()).params().e;
        if (v88.a.f(Integer.valueOf(r0)) == false) goto L5;
        DoraType r5 = DoraType.DORA_RADIO;
    L6:
        String r6 = r5.getValue();
        String r7 = ((n4) getContext()).params().k.t;
        String r8 = ((n4) getContext()).params().s.name();
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "doraMode");
        Intrinsics.checkNotNullParameter(r8, "sessionType");
        ia8.m.d = r3;
        ia8.m.e = r4;
        ia8.m.f = r6;
        ia8.m.g = r7;
        ia8.m.h = r8;
        ia8.m.c.d(r3, new JSONArray());
        DoraEvent r9 = DoraEvent.DoraStart;
        if (r0 != 1) goto L9;
        String r1 = "Voice";
    L10:
        r9.setMessage(r1.concat(" Start"));
        ia8.m.b(r9);
        Map<Function1<Boolean, Unit>, k4> r10 = x2.a;
        x2.d((k4) this.A.getValue());
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == true) goto L16;
        v2 r11 = x2.b();
        com.larus.avlink.n1.d(this.f, "[onTick] sendVUIEvent: Reset start, startSessionTimeoutEnable=" + r11.a + ", startSessionTimeout=" + r11.b);
        if (r11.a == false) goto L17;
        com.larus.audio.call.p r12 = new DoraTaskPlugin$startSendResetEventTimer$1(this);
        this.r = r12;
        r12.d();
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r1 = "Radio";
        goto L10
    L5:
        r5 = DoraType.DORA;
        goto L6
    }

    public final void g3() {
        super.g3();
        com.larus.audio.call.o r0 = this.p;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        com.larus.audio.call.o r1 = this.s;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        com.larus.audio.call.p r2 = this.r;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        Lazy r3 = ia8.m.a;
        ia8.m.b(DoraEvent.SessionStop);
    }

    public final com.larus.audio.call.plugins.t0 l3() {
        return getContext().b(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
    }

    public final String T2() {
        return this.f;
    }

    public DoraTaskPlugin(n4 r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.f = "DoraTaskPlugin";
        this.i = "";
        this.l = true;
        this.m = buc.b.a(true);
        this.n = buc.b.a(false);
        this.q = buc.b.d(TuplesKt.to(-1, 0));
        this.t = buc.b.a(false);
        this.u = buc.b.a(false);
        this.v = buc.b.d(new i(null, null, null, null, 31));
        this.w = buc.b.d(CommandSendStatus.INITIALIZE);
        this.z = 20;
        this.A = LazyKt.lazy(new j3(this));
    }

    public static final com.larus.call_plugins_doubao_common.k j3(DoraTaskPlugin r2) {
        return r2.getContext().b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null);
    }

    @Override // com.larus.avlink.plugins.n3
    public final void N1(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        buc.e<CommandSendStatus> r1 = this.w;
        CommandSendStatus.Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        CommandSendStatus r0 = CommandSendStatus.DOUBAO_RECV;
        if (Intrinsics.areEqual(r4, r0.getValue()) == true) goto L12;
        r0 = CommandSendStatus.DOUBAO_SEND;
        if (Intrinsics.areEqual(r4, r0.getValue()) == true) goto L12;
        r0 = CommandSendStatus.DORA_SDK;
        if (Intrinsics.areEqual(r4, r0.getValue()) == true) goto L12;
        r0 = CommandSendStatus.INITIALIZE;
    L12:
        r1.d(r0);
    }

    @Override // com.larus.avlink.plugins.n3
    public final void m(Function1<? super z98.f, Unit> r1) {
        this.g = r1;
    }

    public final Map<String, Object> p3(Map<String, ? extends Object> r4) {
        AudioSessionType r0 = ((n4) getContext()).params().s;
        Map r1 = MapsKt.createMapBuilder();
        r1.putAll(r4);
        r1.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.a(r0)));
        r1.put("is_mmt", Boolean.valueOf(com.larus.im.service.audio.y0.b(r0)));
        r1.put("av_session_type", Integer.valueOf(r0.getType()));
        r1.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") ? 1 : 0));
        return MapsKt.build(r1);
    }

    public final void n3(long r2, Function0<Unit> r4) {
        com.larus.audio.call.o r0 = this.p;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        com.larus.audio.call.o r1 = new com.larus.audio.call.o(r2, r4);
        this.p = r1;
        r1.d();
    }

    public final void o3(String r8, Function0<Boolean> r9) {
        CoroutineScope r1 = ((n4) getContext()).r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new DoraTaskPlugin$startNetworkErrorTimer$2(this, r8, r9, null), 2, null);
        return;
    }

    @Override // com.larus.avlink.plugins.n3
    public final void I2(boolean r12, VuiEndScene r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        com.larus.avlink.n1.d(this.f, "stopVUI final send vuiEnd ,isSilent: " + r12);
        Integer r0 = ((i) this.v.c()).a;
        if (r12 == false) goto L20;
        DoraEvent r15 = DoraEvent.VUISilent;
        r15.setExtra("scene:" + r13);
        ia8.m.b(r15);
        if (r0 != null) goto L8;
    L9:
        if (r0 != null) goto L12;
    L14:
        com.larus.avlink.n1.d(this.f, "not report command send in END_SILENT, command is " + r0);
        CoroutineScope r5 = ((n4) getContext()).r();
        if (r5 == null) goto L36;
        BuildersKt.launch$default(r5, Dispatchers.getIO(), null, new DoraTaskPlugin$stopVUI$2(r14, this, null), 2, null);
    L36:
        m3();
        return;
    L12:
        if (r0.intValue() != 21) goto L14;
    L17:
        CoroutineScope r6 = ((n4) getContext()).r();
        if (r6 == null) goto L36;
        BuildersKt.launch$default(r6, Dispatchers.getIO(), null, new DoraTaskPlugin$stopVUI$1(this, r14, null), 2, null);
        goto L36
    L8:
        if (r0.intValue() == 5) goto L17;
    L20:
        DoraEvent r16 = DoraEvent.VUIEnd;
        r16.setExtra("scene:" + r13);
        ia8.m.b(r16);
        if (r0 != null) goto L24;
    L25:
        if (r0 != null) goto L28;
    L30:
        com.larus.avlink.n1.d(this.f, "not report command send in END, command is " + r0);
        CoroutineScope r7 = ((n4) getContext()).r();
        if (r7 == null) goto L36;
        BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new DoraTaskPlugin$stopVUI$4(r14, this, null), 2, null);
        goto L36
    L28:
        if (r0.intValue() != 21) goto L30;
    L33:
        CoroutineScope r8 = ((n4) getContext()).r();
        if (r8 == null) goto L36;
        BuildersKt.launch$default(r8, Dispatchers.getIO(), null, new DoraTaskPlugin$stopVUI$3(this, r14, null), 2, null);
        goto L36
    L24:
        if (r0.intValue() == 5) goto L33;
        goto L25
    }

    public static final Object k3(DoraTaskPlugin r24, int r25, int r26, Continuation r27) {
        r24.getClass();
        if ((r27 instanceof DoraTaskPlugin$stopAndReportCommandSend$1) == false) goto L7;
        DoraTaskPlugin$stopAndReportCommandSend$1 r2 = (DoraTaskPlugin$stopAndReportCommandSend$1) r27;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.J$0;
        i r7 = (i) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        Integer r17 = (Integer) r1;
        long r14 = System.currentTimeMillis();
        Long r8 = r7.c;
        Long r9 = null;
        if (r8 == null) goto L25;
        long r10 = r8.longValue();
        Long r11 = r7.d;
        if (r11 == null) goto L23;
        Long r12 = Boxing.boxLong(r11.longValue() - r10);
    L24:
        Long r13 = r12;
    L26:
        Long r15 = r7.d;
        if (r15 == null) goto L29;
        Long r16 = Boxing.boxLong(r6 - r15.longValue());
    L30:
        long r18 = r14 - r6;
        Long r19 = r7.c;
        if (r19 == null) goto L33;
        r9 = Boxing.boxLong(r14 - r19.longValue());
    L33:
        r24.N1("dora");
        Long r110 = r16;
        ((n4) r24.getContext()).k().V("dora", r7.a, r7.b, r13, r110, Boxing.boxLong(r18), r9, r17);
        com.larus.avlink.n1.d(r24.f, "reportDoraCommandSend after updateVUIState>>>command is " + r7.a + ", messageId is " + r7.b + ", commandStartTime is " + r7.c + ", commandReceiveTime is " + r7.d + ", commandSendTime is " + r6 + ", commandEndTime is " + r14);
        return Unit.INSTANCE;
    L29:
        r16 = null;
        goto L30
    L23:
        r12 = null;
        goto L24
    L25:
        r13 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        long r111 = System.currentTimeMillis();
        buc.e<i> r20 = r24.v;
        i r21 = (i) r20.c();
        r20.d(new i(r21.a, r21.b, r21.c, r21.d, Long.valueOf(r111)));
        r24.N1("doubao_send");
        i r22 = (i) r24.v.c();
        com.larus.audio.call.tracer.c.a.a(((n4) r24.getContext()).k(), "doubao_send", r22.a, r22.b, null, null, null, null, 248);
        com.larus.avlink.n1.d(r24.f, "reportDoraCommandSend before updateVUIState>>>command is " + r22.a + ", messageId is " + r22.b + ", commandStartTime is " + r22.c + ", commandReceiveTime is " + r22.d + ", commandSendTime is " + r111);
        Map<Function1<Boolean, Unit>, k4> r23 = x2.a;
        boolean r28 = Intrinsics.areEqual(((n4) r24.getContext()).params().p.A, Boxing.boxBoolean(true));
        r2.L$0 = r22;
        r2.J$0 = r111;
        r2.label = 1;
        Object r29 = x2.l(r25, r26, r28, r2);
        if (r29 == r4) goto L35;
        r6 = r111;
        r7 = r22;
        r1 = r29;
        goto L18
    L35:
        return r4;
    L7:
        r2 = new DoraTaskPlugin$stopAndReportCommandSend$1(r24, r27);
        goto L8
    }

    @Override // com.larus.avlink.plugins.n3
    public final void w0(Integer r9, String r10, Long r11, Long r12) {
        this.v.d(new i(r9, r10, r11, r12, 16));
    }
}
