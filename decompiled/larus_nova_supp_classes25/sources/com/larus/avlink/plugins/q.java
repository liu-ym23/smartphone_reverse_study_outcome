package com.larus.avlink.plugins;

import com.google.gson.JsonObject;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.l;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.LightEffectBrightness;
import com.larus.dora.api.LightEffectStatus;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.service.audio.AvAecType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.settings.value.e10;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends BaseDoraCallAudioPlugin implements o4, com.larus.avlink.e.s {
    public static final /* synthetic */ int a0 = 0;
    public final Lazy Q;
    public final com.larus.audio.call.record.f R;
    public rx9.k S;
    public final List<Integer> T;
    public volatile boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public final Lazy Y;
    public IAppletJsbEventService.TriggeredEvent Z;

    public static final class a extends k4 {
        public final /* synthetic */ q a;

        @Override // com.larus.avlink.plugins.k4
        public final void b() {
            com.larus.avlink.n1.d(this.a.I, "onDBTtsPlayerPlayEnd");
            q r0 = this.a;
            int r1 = q.a0;
            r0.s3().f();
        }

        public a(q r1) {
            this.a = r1;
        }
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void F1(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.avlink.e.s
    public final void M() {
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin, com.larus.avlink.plugins.l4
    public final void a() {
        this.V = true;
    }

    public final Map<String, Object> I3() {
        if (this.V == false) goto L8;
        if (((n4) getContext()).E() == false) goto L8;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("need_end_asr", Boolean.TRUE), TuplesKt.to("with_image", Boolean.valueOf(this.W)), TuplesKt.to("with_ocr", Boolean.valueOf(this.X))});
    L8:
        return MapsKt.emptyMap();
    }

    public final void S3() {
        if (this.U == false) goto L10;
        if (((n4) getContext()).e() == true) goto L8;
        com.larus.avlink.n1.d(this.I, "ignore query begin after env observe stop conversation");
        return;
    L8:
        n4("query_begin");
        return;
    L10:
        if (((n4) getContext()).e() == true) goto L14;
        com.larus.avlink.n1.d(this.I, "ignore query begin while env observe conversation stopped");
        return;
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void V3() {
        n4("onLLMReplyBegin");
        super.V3();
        e10 r0 = e10.a;
        if (e10.p() == true) goto L6;
        s3().a();
        return;
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void W3() {
        if (this.U == false) goto L6;
        com.larus.avlink.n1.d(this.I, "ignore reply end after env observe stop conversation");
        return;
    L6:
        super.W3();
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void j4() {
        p4(IAppletJsbEventService.TriggeredEvent.TTS_END);
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void k4() {
        p4(IAppletJsbEventService.TriggeredEvent.TTS_START);
    }

    public final v68.a n3() {
        com.larus.audio.call.record.f r0 = this.R;
        if (r0 == null) goto L5;
        return r0;
    L5:
        id9.d r2 = ((n4) getContext()).j();
        Intrinsics.checkNotNull(r2);
        return new com.larus.audio.call.record.a(r2, AvAecType.NONE, new m(this), 0, new com.larus.audio.call.record.m(new n(this)), 8);
    }

    public final boolean o4() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        DeviceService r1 = r0.device();
    L7:
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == true) goto L18;
        if (r1 == null) goto L12;
        boolean r3 = true;
        if (r1.M() != true) goto L12;
    L13:
        if (r3 == true) goto L15;
        return false;
    L15:
        if (r1.n0("rtos_player") == true) goto L17;
        return false;
    L17:
        return r1.A();
    L12:
        r3 = false;
        goto L13
    L18:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.avlink.plugins.l4
    public final boolean d1() {
        return o4();
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void e3() {
        super.e3();
        this.U = false;
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_half_duplex") == false) goto L5;
        String r1 = "dora_radio";
    L6:
        rx9.k r0 = new rx9.k(r1);
        this.S = r0;
        r0.b();
        if (o4() == false) goto L10;
        Map<Function1<Boolean, Unit>, k4> r2 = x2.a;
        x2.d((a) this.Y.getValue());
        return;
    L10:
        return;
    L5:
        r1 = "dora_call";
        goto L6
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void g3() {
        super.g3();
        this.U = false;
        rx9.k r0 = this.S;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.S = null;
        if (o4() == false) goto L8;
        Map<Function1<Boolean, Unit>, k4> r1 = x2.a;
        x2.k((a) this.Y.getValue());
    L8:
        l r2 = l.a;
        l.c.remove(this);
    }

    public final u68.c m3() {
        if (o4() == true) goto L33;
        int r1 = 0;
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == false) goto L17;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r2 = true;
        if (r0 == null) goto L14;
        DeviceService r3 = r0.device();
        if (r3 == null) goto L14;
        if (r3.M() != true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
    L18:
        if (r2 == false) goto L25;
        RealtimeCallParam r5 = ((n4) getContext()).params();
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L34;
        DeviceService r7 = r6.device();
        if (r7 == null) goto L34;
        r1 = r7.y();
    L34:
        return new fa8.c(r5, 24000, r1);
    L25:
        RealtimeCallParam r8 = ((n4) getContext()).params();
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L30;
        DeviceService r10 = r9.device();
        if (r10 == null) goto L30;
        int r11 = r10.y();
    L32:
        return new com.larus.audio.call.play.c(r8, false, false, 24000, r11);
    L30:
        r11 = 0;
    L14:
        r4 = false;
    L17:
        r2 = false;
        goto L18
    L33:
        return new b98.c(((n4) getContext()).params(), 24000);
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void m4() {
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == false) goto L7;
        r4 r0 = (r4) getContext().c(Reflection.getOrCreateKotlinClass(r4.class), null);
        if (r0 == null) goto L10;
        r0.N2(LightEffectStatus.TURN_OFF, LightEffectBrightness.LOW, "onTtsPlayFinished in WALK_TALK");
    L10:
        x3 r1 = i4();
        if (r1 == null) goto L14;
        r1.Z1();
        return;
    L14:
        return;
    L7:
        r4 r2 = (r4) getContext().c(Reflection.getOrCreateKotlinClass(r4.class), null);
        if (r2 == null) goto L10;
        r2.N2(LightEffectStatus.SLOWLY_FLASHING, LightEffectBrightness.LOW, "onTtsPlayFinished");
        goto L10
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin, com.larus.avlink.plugins.l4
    public final boolean l0() {
        return this.U;
    }

    public q(final n4 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        Lazy r0 = LazyKt.lazy(new o(r5));
        this.Q = r0;
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L14;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L9;
        r1.a0();
        com.larus.home.impl.sdk.g r2 = com.larus.home.impl.sdk.g.a;
        boolean r3 = true;
        if (com.larus.home.impl.sdk.x.a.a() != true) goto L9;
    L11:
        if (r3 == false) goto L13;
        com.larus.audio.call.record.f r4 = new com.larus.audio.call.record.f(new com.larus.avlink.p1(r5), 0, false, 2);
    L15:
        this.R = r4;
        this.T = new ArrayList();
        l r6 = l.a;
        l.c.add(this);
        this.Y = LazyKt.lazy(new p(this));
        this.Z = IAppletJsbEventService.TriggeredEvent.TTS_END;
        return;
    L13:
        r4 = new com.larus.audio.call.record.f(new com.larus.avlink.w(0), 0, false, 2);
    L9:
        r3 = false;
        goto L11
    L14:
        r4 = null;
        goto L15
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r2) {
        Intrinsics.checkNotNullParameter("onConversationEnd", "source");
        if (this.U == true) goto L5;
        com.larus.avlink.n1.d(this.I, "mark drop audio after env observe stop conversation, source=onConversationEnd");
    L5:
        this.U = true;
        this.L = false;
        this.K = true;
        this.M = false;
        ((ArrayList) this.T).clear();
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void T3(pf9.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.U == false) goto L6;
        com.larus.avlink.n1.d(this.I, "ignore query end after env observe stop conversation");
        return;
    L6:
        super.T3(r2);
    }

    @Override // com.larus.avlink.plugins.BaseDoraCallAudioPlugin
    public final void l4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (this.U == false) goto L6;
        com.larus.avlink.n1.d(this.I, "ignore tts play finished after env observe stop conversation, source=".concat(r3));
        this.K = true;
        this.L = false;
        return;
    L6:
        super.l4(r3);
    }

    public final void n4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (this.U == false) goto L5;
        com.larus.avlink.n1.d(this.I, "clear drop audio after env observe stop conversation, source=".concat(r3));
    L5:
        this.U = false;
    }

    public final void p4(IAppletJsbEventService.TriggeredEvent r5) {
        if (r5 == IAppletJsbEventService.TriggeredEvent.TTS_END) goto L5;
    L7:
        this.Z = r5;
        com.larus.platform.service.k r0 = com.larus.platform.service.k.a;
        JsonObject r1 = new JsonObject();
        r1.addProperty("question_id", ((com.larus.audio.call.plugins.u) this).A);
        Unit r2 = Unit.INSTANCE;
        r0.a(r5, r1);
        return;
    L5:
        if (r5 != this.Z) goto L7;
    }

    @Override // com.larus.avlink.e.s
    public final void w(b49.k r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
    }

    public final void Y3(r58.d r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "audioData");
        if (((Boolean) this.Q.getValue()).booleanValue() == false) goto L8;
        com.larus.audio.call.plugins.v0 r4 = com.larus.audio.call.arch.b.b(getContext());
        if (r4 == null) goto L10;
        r4.q2(r2.b, 0);
        return;
    L10:
        return;
    L8:
        super.Y3(r2, r3);
    }

    @Override // com.larus.avlink.e.s
    public final void p1(com.larus.avlink.model.a r4, DoraImageEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r0 = this.I;
        StringBuilder r1 = new StringBuilder("onImageEvent, event=");
        r1.append(r5);
        r1.append(" imageUuid=");
        if (r4 == null) goto L5;
        Integer r6 = r4.a;
    L6:
        r1.append(r6);
        com.larus.avlink.n1.d(r0, r1.toString());
        boolean r7 = true;
        if (r4 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L15;
    L13:
        r7 = false;
    L17:
        this.X = r7;
        return;
    L15:
        if (Intrinsics.areEqual(r4.q, Boolean.TRUE) == true) goto L17;
    L9:
        if (r4.p != true) goto L11;
        r2 = true;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        n4("onConversationStart");
    }

    @Override // com.larus.avlink.e.s
    public final void j(boolean r4, int r5, byte r6) {
        com.larus.avlink.n1.d(this.I, "onImageOcrStateUpdate, ocrDetectionRes=" + r4 + ", imageUuid=" + r5 + ", ocrProcessFlag=" + r6);
        if (this.X == true) goto L7;
        if (r4 == false) goto L8;
        this.X = true;
        return;
    L8:
        return;
    }

    @Override // com.larus.avlink.e.s
    public final boolean D0(int r1, int r2, int r3, int r4, int r5) {
        com.larus.avlink.n1.d(this.I, "onTakeImageStart");
        this.W = true;
        return false;
    }
}
