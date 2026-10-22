package com.larus.avlink.plugins;

import com.bytedance.common.utility.Logger;
import com.google.gson.Gson;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.DoraImageManager;
import com.larus.avlink.e.l;
import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.event.FileBizType;
import com.larus.network.http.AsyncThrowable;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.VisionIntentionItem;
import com.larus.voicecall.api.bean.VisionIntentionItems;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h4 extends com.larus.audio.call.arch.a<n4> implements j4, com.larus.avlink.e.r {
    public final List<f98.a> f;
    public Pair<b49.h, String> g;
    public we9.e h;
    public String i;
    public boolean j;

    public static final class a implements com.larus.im.service.audio.v {
        public final /* synthetic */ h4 a;

        public final String getName() {
            return "DoraVisionPlugin";
        }

        public a(h4 r1) {
            this.a = r1;
            r1.getClass();
        }

        public final void O1(jd9.c r12, jd9.c r13) {
            Intrinsics.checkNotNullParameter(r12, "oldState");
            Intrinsics.checkNotNullParameter(r13, "newState");
            FLogger r14 = FLogger.a;
            this.a.getClass();
            r14.i("DoraVisionPlugin", "onConnectionStateChanged status=" + r13);
            if ((r13 instanceof jd9.c.a) == false) goto L38;
            h4 r15 = this.a;
            Iterator r16 = ((ArrayList) r15.f).iterator();
        L6:
            if (r16.hasNext() == false) goto L8;
            f98.a r0 = (f98.a) r16.next();
            FLogger.a.i("DoraVisionPlugin", "resend sendAudioPictureEvent. ImageUUID: " + r0.a + ", side: " + r0.b + ", intentionMode: " + r0.c + ", status: " + r0.d);
            h4.k3(r0, ((n4) r15.getContext()).j());
            goto L6
        L8:
            ((ArrayList) r15.f).clear();
            h4 r17 = this.a;
            Pair<b49.h, String> r18 = r17.g;
            if (r18 == null) goto L25;
            b49.h r4 = (b49.h) r18.component1();
            String r19 = (String) r18.component2();
            Map<String, com.larus.avlink.model.a> r5 = DoraImageManager.a;
            com.larus.avlink.model.a r6 = DoraImageManager.a(Integer.valueOf(r4.a));
            boolean r7 = false;
            if (r6 == null) goto L22;
            long r8 = System.currentTimeMillis();
            Long r9 = r6.b(DoraImageEvent.IMAGE_TRANS_FINISH);
            if (r9 == null) goto L15;
            long r10 = r9.longValue();
        L17:
            if ((r8 - r10) >= 5000) goto L19;
            boolean r11 = true;
        L20:
            if (r11 != true) goto L22;
            r7 = true;
            goto L22
        L19:
            r11 = false;
            goto L20
        L15:
            r10 = 0;
        L22:
            if (r7 == false) goto L24;
            r17.j3(r4, r19);
        L24:
            r17.g = null;
        L25:
            h4 r110 = this.a;
            we9.e r111 = r110.h;
            if (r111 != null) goto L28;
        L33:
            h4 r112 = this.a;
            if (r112.j == false) goto L39;
            l r113 = l.a;
            l.i(((n4) r112.getContext()).q(), null);
            return;
        L39:
            return;
        L28:
            if ((System.currentTimeMillis() - r111.c) >= 5000) goto L32;
            FLogger.a.e("DoraVisionPlugin", "uploadPendingOcrData");
            id9.d r1 = ((n4) r110.getContext()).j();
            if (r1 == null) goto L32;
            r1.B(r111);
        L32:
            r110.h = null;
            goto L33
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ h4 b;

        public final String g() {
            return this.a;
        }

        public b(h4 r1) {
            this.b = r1;
            r1.getClass();
            this.a = "DoraVisionPlugin";
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void n(com.larus.im.service.audio.z0.a r14) {
            Intrinsics.checkNotNullParameter(r14, "event");
            Map r2 = null;
            boolean r4 = false;
            if ((r14 instanceof pf9.q) == false) goto L58;
            List r15 = ((pf9.q) r14).a;
            h4 r0 = this.b;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r16 = r15.iterator();
        L6:
            if (r16.hasNext() == false) goto L208;
            pf9.p r6 = (pf9.p) r16.next();
            Long r7 = r6.a;
            if (r7 == null) goto L56;
            int r8 = (int) r7.longValue();
            JSONObject r9 = new JSONObject();
            Map r10 = r6.b;
            if (r10 == null) goto L15;
            Iterator r11 = r10.entrySet().iterator();
        L13:
            if (r11.hasNext() == false) goto L15;
            Map.Entry r12 = (Map.Entry) r11.next();
            r9.putOpt((String) r12.getKey(), r12.getValue());
        L15:
            FLogger r13 = FLogger.a;
            r0.getClass();
            r13.i("DoraVisionPlugin", "handleCommandResponse: cmd:" + r8 + ", params: " + r9 + '.');
            Gson r17 = ha8.a.a;
            ChatParam r18 = (ChatParam) ha8.a.a(r9.toString(), ChatParam.class);
            if (r8 != 23) goto L56;
            id9.d r19 = ((n4) r0.getContext()).j();
            if (r19 == null) goto L24;
            jd9.c r20 = r19.state();
            if (r20 == null) goto L24;
            if (r20.a != true) goto L24;
            boolean r21 = true;
        L25:
            if (r21 == false) goto L55;
            r13.i("DoraVisionPlugin", "handleChatResponseResult: DORA_VISION_INTENTION. param: " + r9);
            if (r18 == null) goto L56;
            String r22 = r18.getIntentionItems();
            if (r22 == null) goto L56;
            VisionIntentionItems r23 = (VisionIntentionItems) new Gson().fromJson(r22, VisionIntentionItems.class);     // Catch: Exception -> L32
        L34:
            if (r23 == null) goto L56;
            List r24 = r23.getItems();
            if (r24 == null) goto L56;
            List r25 = CollectionsKt.filterNotNull(r24);
            if (r25 == null) goto L56;
            Iterator r26 = r25.iterator();
        L41:
            if (r26.hasNext() == false) goto L56;
            VisionIntentionItem r27 = (VisionIntentionItem) r26.next();
            Integer r28 = r27.getSource();
            if (r28 != null) goto L46;
        L47:
            Integer r29 = r27.getSource();
            if (r29 == null) goto L41;
            if (r29.intValue() != 2) goto L41;
        L52:
            l r30 = l.a;
            ((n4) r0.getContext()).q();
            boolean r110 = r27.getHighQuality();
            r30.k(7, r110 ? 1 : 0, r0.i);
            q4 r31 = (q4) r0.getContext().c(Reflection.getOrCreateKotlinClass(q4.class), null);
            if (r31 == null) goto L41;
            r31.U0(r27);
            goto L41
        L46:
            if (r28.intValue() == 3) goto L52;
        L32:
            e = move-exception;
            FLogger.a.e("DoraVisionPlugin", "handleChatResponseResult: intentionItems.", e);
            r23 = null;
            goto L34
        L55:
            r13.i("DoraVisionPlugin", "handleChatResponseResult: DORA_VISION_INTENTION, call stopped.");
        L24:
            r21 = false;
        L56:
            r1.add(r6);
            goto L6
        L208:
            return;
        L58:
            if ((r14 instanceof pf9.f0) == false) goto L76;
            pf9.f0 r111 = (pf9.f0) r14;
            if (pf9.i.i(r111) == false) goto L158;
            this.b.getClass();
            AppHost.Companion r3 = AppHost.a;     // Catch: JSONException -> L73
            if (r3.isTestChannel() == false) goto L65;
        L66:
            pf9.k0 r112 = r111.b;     // Catch: JSONException -> L73
            if (r112 == null) goto L70;
            String r113 = r112.a;     // Catch: JSONException -> L73
            if (r113 == null) goto L70;
        L71:
            String r114 = new JSONObject(r113).optString(ChatDraftItem.TYPE_TEXT);     // Catch: JSONException -> L73
            DoraEvent r5 = DoraEvent.TTSText;     // Catch: JSONException -> L73
            StringBuilder r32 = new StringBuilder("TTS Sentence Start ");     // Catch: JSONException -> L73
            Intrinsics.checkNotNull(r114);     // Catch: JSONException -> L73
            r32.append(StringsKt.take(r114, 5));     // Catch: JSONException -> L73
            r5.setMessage(r32.toString());     // Catch: JSONException -> L73
            r5.setExtra("text:" + r114);     // Catch: JSONException -> L73
            ia8.m.b(r5);     // Catch: JSONException -> L73
            return;
        L70:
            r113 = "{}";
            goto L71
        L65:
            if (Intrinsics.areEqual(r3.getBuildChannel(), "inhouse") == true) goto L66;
            return;
        L73:
            e = move-exception;
            FLogger.a.i("DoraVisionPlugin", "TTSSentenceStart :" + e);
            return;
        L158:
            return;
        L76:
            if ((r14 instanceof pf9.c0) == false) goto L92;
            this.b.getClass();
            StringBuilder r33 = new StringBuilder("FlowLLMQueryUpdateEvent received1: ");
            pf9.c0 r115 = (pf9.c0) r14;
            pf9.a r34 = r115.a;
            if (r34 == null) goto L80;
            r2 = r34.d;
        L80:
            r33.append(r2);
            Logger.e("DoraVisionPlugin", r33.toString());
            pf9.a r116 = r115.a;
            if (r116 == null) goto L198;
            Map r117 = r116.d;
            if (r117 == null) goto L199;
            final String r118 = (String) r117.get("command_list");
            if (r118 == null) goto L200;
            final h4 r35 = this.b;
            if (r118.length() != 0) goto L89;
            r4 = true;
        L89:
            if (r4 == true) goto L201;
            com.larus.utils.l0.b(new i4(r118, r35));
            return;
        L201:
            return;
        L200:
            return;
        L199:
            return;
        L198:
            return;
        L92:
            if ((r14 instanceof pf9.z) == false) goto L99;
            h4 r36 = this.b;
            if (r36.j == false) goto L96;
            r36.j = false;
        L97:
            this.b.i = ((pf9.z) r14).a;
            return;
        L96:
            l r37 = l.a;
            l.i(((n4) r36.getContext()).q(), ((pf9.z) r14).a);
            goto L97
        L99:
            if ((r14 instanceof pf9.a0) == false) goto L104;
            Map<String, com.larus.avlink.model.a> r119 = DoraImageManager.a;
            com.larus.avlink.model.a r120 = DoraImageManager.b(this.b.i);
            if (r120 == null) goto L204;
            r120.J = true;
            l r38 = l.a;
            l.j(r120);
            return;
        L204:
            return;
        L104:
            if ((r14 instanceof pf9.w) == false) goto L206;
            l r39 = l.a;
            pf9.w r121 = (pf9.w) r14;
            Intrinsics.checkNotNullParameter(r121, "event");
            FLogger.a.i("DoraE_Camera", "onImageUploadFinish event: " + r121);
            List r40 = r121.d;
            ArrayList r41 = new ArrayList();
            Iterator r42 = r40.iterator();
        L107:
            if (r42.hasNext() == false) goto L114;
            Object r43 = r42.next();
            if (((pf9.h) r43).d.a != FileBizType.DoraImage) goto L111;
            boolean r44 = true;
        L112:
            if (r44 == false) goto L107;
            r41.add(r43);
            goto L107
        L111:
            r44 = false;
            goto L112
        L114:
            Iterator r45 = r41.iterator();
        L116:
            if (r45.hasNext() == false) goto L209;
            String r46 = ((pf9.h) r45.next()).d.b;
            f98.d r47 = (f98.d) new Gson().fromJson(r46, f98.d.class);     // Catch: Exception -> L120
        L121:
            if (r47 == null) goto L127;
            String r48 = r47.a();
            if (r48 == null) goto L127;
            Integer r49 = StringsKt.toIntOrNull(r48);
            if (r49 == null) goto L127;
            int r50 = r49.intValue();
            Map<String, com.larus.avlink.model.a> r51 = DoraImageManager.a;
            com.larus.avlink.model.a r52 = DoraImageManager.a(Integer.valueOf(r50));
        L128:
            if (r52 == null) goto L116;
            Gson r53 = new Gson();     // Catch: Exception -> L135
            Map r54 = r121.e;     // Catch: Exception -> L135
            if (r54 == null) goto L132;
            String r55 = (String) r54.get("perf_info");     // Catch: Exception -> L135
        L133:
            f98.q r56 = (f98.q) r53.fromJson(r55, f98.q.class);     // Catch: Exception -> L135
        L136:
            if (r56 == null) goto L140;
            f98.n r57 = r56.b();
            if (r57 == null) goto L140;
            Long r58 = r57.a();
        L141:
            r52.B = r58;
            if (r56 == null) goto L146;
            f98.n r59 = r56.b();
            if (r59 == null) goto L146;
            Integer r60 = r59.b();
        L147:
            r52.A = r60;
            if (r121.a == true) goto L154;
            long r61 = r121.b;
            String r62 = r121.c;
            if (r62 != null) goto L153;
            r62 = "unknown error";
        L153:
            new AsyncThrowable(r61, r62, new Throwable());
        L154:
            com.larus.avlink.e.q r63 = l.e;
            Integer r64 = r52.a;
            int r65 = r52.m;
            boolean r66 = r121.a;
            r63.getClass();
            com.larus.avlink.e.q.c(r64, r65, r56, r66);
            Iterator<com.larus.avlink.e.s> r67 = l.c.iterator();
        L156:
            if (r67.hasNext() == false) goto L116;
            com.larus.avlink.e.s r68 = r67.next();
            Intrinsics.checkNotNull(r68);
            Intrinsics.checkNotNullParameter(r68, "it");
            r68.p1(r52, DoraImageEvent.IMAGE_UPLOAD_FINISH);
            Unit r69 = Unit.INSTANCE;
        L146:
            r60 = null;
        L140:
            r58 = null;
            goto L141
        L132:
            r55 = null;
        L135:
            FLogger.a.e("DoraE_Camera", "parse perf_info error " + r121.e);
            r56 = null;
        L127:
            FLogger.a.e("DoraE_Camera", "transformDoraImageDownlinkBizInfoToPicModel model: " + r47);
            r52 = null;
        L120:
            FLogger.a.e("DoraE_Camera", "transformDoraImageDownlinkBizInfoToPicModel error " + r46);
            r47 = null;
            goto L121
        L209:
            return;
        }
    }

    public final String T2() {
        return "DoraVisionPlugin";
    }

    public final com.larus.im.service.audio.v R2() {
        return new a(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    @Override // com.larus.avlink.plugins.j4
    public final void a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.L() != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        T(TriggerMode.QUERY_WHEN_SILENCE, null);
        return;
    L13:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void b3() {
        l r0 = l.a;
        FLogger.a.i("DoraE_Camera", "releaseCameraEventAction");
        com.larus.avlink.e.mock.g r1 = null;
        if (Intrinsics.areEqual(l.b, this) == false) goto L5;
        l.b = null;
    L5:
        Integer r2 = l.f;
        if (r2 == null) goto L8;
        DoraImageManager.c(r2.intValue(), new com.larus.avlink.e.d());
    L8:
        l.f = null;
        com.larus.avlink.e.mock.e.a.a();
        com.larus.avlink.e.mock.g r3 = com.larus.avlink.e.mock.e.b;
        if ((r3 instanceof com.larus.avlink.e.mock.g) == false) goto L11;
        r1 = r3;
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.b.get() == false) goto L18;
        r1.g();
        return;
    }

    @Override // com.larus.avlink.e.r
    public final boolean A() {
        return ((n4) getContext()).A();
    }

    @Override // com.larus.avlink.e.r
    public final boolean E() {
        return ((n4) getContext()).E();
    }

    @Override // com.larus.avlink.e.r
    public final int q() {
        return ((n4) getContext()).q();
    }

    @Override // com.larus.avlink.e.r
    public final boolean x() {
        return ((n4) getContext()).x();
    }

    public h4(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = new ArrayList();
        this.j = true;
        l r3 = l.a;
        l.b = this;
    }

    @Override // com.larus.avlink.e.r
    public final void P0(we9.e r5) {
        Intrinsics.checkNotNullParameter(r5, "ocrData");
        FLogger r0 = FLogger.a;
        r0.i("DoraVisionPlugin", "uploadOcrData: " + r5);
        id9.d r1 = ((n4) getContext()).j();
        if (r1 == null) goto L5;
        jd9.c r3 = r1.state();
    L7:
        if ((r3 instanceof jd9.c.a) == false) goto L9;
        r1.B(r5);
        return;
    L9:
        r0.e("DoraVisionPlugin", "uploadOcrData mediaSession not connected");
        this.h = r5;
        return;
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.larus.avlink.e.r
    public final void u0(f98.a r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L5;
        jd9.c r1 = r0.state();
    L7:
        if ((r1 instanceof jd9.c.a) == false) goto L9;
        FLogger.a.e("DoraVisionPlugin", "sendAudioPictureEvent directly.");
        k3(r5, r0);
        return;
    L9:
        List<f98.a> r2 = this.f;
        if ((r2 instanceof Collection) == true) goto L12;
    L14:
        Iterator r3 = ((ArrayList) r2).iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        boolean r4 = true;
        if ((!Intrinsics.areEqual(((f98.a) r3.next()).a, r5.a)) == false) goto L16;
    L21:
        if (r4 == false) goto L23;
        ((ArrayList) this.f).clear();
    L23:
        FLogger.a.e("DoraVisionPlugin", "sendAudioPictureEvent cached: " + r5 + '.');
        ((ArrayList) this.f).add(r5);
        return;
    L20:
        r4 = false;
        goto L21
    L12:
        if (((ArrayList) r2).isEmpty() == false) goto L14;
    L5:
        r1 = null;
        goto L7
    }

    public static void k3(f98.a r3, id9.d r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        r0.put("image_id", r3.a);
        r0.put("image_type", r3.b);
        r0.put("intent_mode", r3.c);
        r0.put("status", r3.d);
        r0.put("high_quality", r3.e);
        r4.p(TriggerMode.VOICE_ASSISTANT_SEND_IMAGE, r0.toString());
    }

    @Override // com.larus.avlink.e.r
    public final void E2(b49.h r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "imageInfo");
        Intrinsics.checkNotNullParameter(r6, "uploadId");
        if (((n4) getContext()).x() == false) goto L5;
    L8:
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L11;
        jd9.c r1 = r0.state();
    L13:
        if ((r1 instanceof jd9.c.a) == false) goto L15;
        j3(r5, r6);
        return;
    L15:
        FLogger.a.e("DoraVisionPlugin", "uploadImage mediaSession not connected. imageUUID: " + r5.a);
        this.g = TuplesKt.to(r5, r6);
        return;
    L11:
        r1 = null;
        goto L13
    L5:
        if (((n4) getContext()).E() == true) goto L8;
        FLogger.a.e("DoraVisionPlugin", "uploadImage mediaSession is not RTC/MMT. imageUUID: " + r5.a);
    }

    @Override // com.larus.avlink.e.r
    public final void T(TriggerMode r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "triggerType");
        if (r5 != null) goto L5;
        JSONObject r6 = null;
    L10:
        com.larus.avlink.n1.d("DoraVisionPlugin", "sendDoraEBotTrigger: " + r4 + ", " + r6);
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L15;
        r0.p(r4, String.valueOf(r6));
        return;
    L15:
        return;
    L5:
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r7 = r5.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry<String, Object> r2 = r7.next();
        r1.put(r2.getKey(), r2.getValue());
        goto L7
    L9:
        r6 = r1;
        goto L10
    }

    public final void j3(b49.h r13, String r14) {
        Map<String, com.larus.avlink.model.a> r0 = DoraImageManager.a;
        com.larus.avlink.model.a r1 = DoraImageManager.a(Integer.valueOf(r13.a));
        byte[] r3 = r13.b;
        if (r3 != null) goto L6;
        FLogger.a.e("DoraVisionPlugin", "uploadImage imageData is null. imageUUID: " + r13.a);
        return;
    L6:
        id9.d r8 = ((n4) getContext()).j();
        if (r8 == null) goto L51;
        int r4 = r13.c;
        int r5 = r13.d;
        int r6 = r13.e;
        Pair[] r2 = new Pair[11];
        int r7 = 0;
        r2[0] = TuplesKt.to("pic_id", String.valueOf(r13.a));
        if (r1 == null) goto L11;
        int r9 = r1.h;
    L12:
        boolean r10 = true;
        r2[1] = TuplesKt.to("side_type", Integer.valueOf(r9));
        if (r1 != null) goto L15;
    L17:
        r10 = false;
    L18:
        r2[2] = TuplesKt.to("high_quality", Boolean.valueOf(r10));
        if (r1 == null) goto L21;
        boolean r11 = r1.p;
    L22:
        r2[3] = TuplesKt.to("has_ocr", Boolean.valueOf(r11));
        r2[4] = TuplesKt.to("status", 0);
        l r12 = l.a;
        Integer r15 = null;
        if (r1 == null) goto L25;
        Integer r16 = r1.n;
    L26:
        r2[5] = TuplesKt.to("scene", Integer.valueOf(l.d(r16)));
        if (r1 == null) goto L29;
        r15 = r1.n;
    L29:
        r2[6] = TuplesKt.to("vision_intent_source", Integer.valueOf(f98.g.a(r15)));
        DoraVisionBizScene.a r17 = DoraVisionBizScene.Companion;
        if (r1 == null) goto L32;
        int r18 = r1.m;
    L33:
        r17.getClass();
        if (r18 != 2) goto L36;
        DoraVisionBizScene r19 = DoraVisionBizScene.LIVE_AI;
    L40:
        r2[7] = TuplesKt.to("vision_biz_scene", Integer.valueOf(r19.getValue()));
        r2[8] = TuplesKt.to("shooting_time_ms_app", Long.valueOf(System.currentTimeMillis()));
        if (r1 == null) goto L45;
        Long r110 = r1.o;
        if (r110 == null) goto L45;
        long r111 = r110.longValue();
    L46:
        r2[9] = TuplesKt.to("shooting_time_ms_hardware", Long.valueOf(r111));
        if (r1 == null) goto L49;
        r7 = r1.L;
    L49:
        r2[10] = TuplesKt.to("camera_take_image_state", Integer.valueOf(r7));
        r8.B(new we9.n(r14, r3, r4, r5, r6, MapsKt.mapOf(r2)));
        return;
    L45:
        r111 = System.currentTimeMillis();
        goto L46
    L36:
        if (r18 == 17) goto L38;
        r19 = DoraVisionBizScene.DEFAULT;
        goto L40
    L38:
        r19 = DoraVisionBizScene.ENV_OBSERVE;
        goto L40
    L32:
        r18 = 0;
        goto L33
    L25:
        r16 = null;
        goto L26
    L21:
        r11 = false;
        goto L22
    L15:
        if (r1.e != 1) goto L17;
    L11:
        r9 = 2;
        goto L12
    }
}
