package com.larus.avlink.plugins;

import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 extends c<n4> {
    public static boolean i;
    public Long f;
    public boolean g;
    public String h;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final /* synthetic */ k0 a;

        public final String getName() {
            this.a.getClass();
            return "DoraEnvObservePlugin";
        }

        public b(k0 r1) {
            this.a = r1;
        }

        public final void O1(jd9.c r2, jd9.c r3) {
            Intrinsics.checkNotNullParameter(r2, "oldState");
            Intrinsics.checkNotNullParameter(r3, "newState");
            if ((r3 instanceof jd9.c.a) == false) goto L13;
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DoraEnvObservePlugin", "SessionState.CONNECTED, isInConversation: " + ((n4) this.a.getContext()).e() + ", pendingTriggerStopConversation: " + this.a.g + ", pendingStopConversationExtra: " + this.a.h);
            if (((n4) this.a.getContext()).e() == true) goto L11;
            k0 r5 = this.a;
            if (r5.g == false) goto L11;
            id9.d r6 = ((n4) r5.getContext()).j();
            if (r6 == null) goto L11;
            r6.p(TriggerMode.DORA_STOP_CONVERSATION, this.a.h);
        L11:
            k0 r7 = this.a;
            r7.g = false;
            r7.h = "";
            return;
        }
    }

    static {
    }

    public final String T2() {
        return "DoraEnvObservePlugin";
    }

    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    @Override // com.larus.avlink.plugins.c
    public final void V2() {
        com.larus.avlink.n1.d("DoraEnvObservePlugin", "onAfterStart, mode: " + ((n4) getContext()).q() + ". 进入环境感知模式");
        i = true;
        com.larus.audio.call.o r2 = g98.d.a;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        com.larus.audio.call.o r3 = g98.d.b;
        if (r3 == null) goto L8;
        r3.a();
    L8:
        b98.b.f(2, 1);
        com.larus.avlink.n1.d("DoraEnvObservePlugin", "开始会话记忆计时器, botId: " + ((n4) getContext()).params().o.h + ", conversationId: " + ((n4) getContext()).params().o.c);
    }

    public final void W2() {
        com.larus.avlink.n1.d("DoraEnvObservePlugin", "onBeforeStop, mode: " + ((n4) getContext()).q() + ". 退出环境感知模式");
        i = false;
        b98.b.f(2, 2);
    }

    public final void a3() {
        com.larus.audio.call.o r0 = g98.d.a;
        String r1 = ((n4) getContext()).params().e;
        Object r2 = g98.d.g;
        monitor-enter(r2);
        if (r1 != null) goto L22;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        r1 = null;
    L15:
        g98.d.e = r1;     // Catch: Throwable -> L9
        if (r1 == null) goto L18;
        Integer r4 = g98.d.f.remove(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(r2);
        return;
    L22:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r3 = false;
        goto L12
    }

    public final String k3() {
        if (((n4) getContext()).A() == false) goto L5;
        String r0 = "video";
    L6:
        JSONObject r1 = new JSONObject();
        r1.put("trans_mode", r0);
        return r1.toString();
    L5:
        r0 = "image";
        goto L6
    }

    public k0(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = "";
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void Q0(int r6) {
        StringBuilder r0 = new StringBuilder("stop conversation in env observe. current Session state: ");
        id9.d r1 = ((n4) getContext()).j();
        if (r1 == null) goto L5;
        jd9.c r2 = r1.state();
    L6:
        r0.append(r2);
        r0.append(", isInConversation: ");
        r0.append(((n4) getContext()).e());
        r0.append(", reason: ");
        r0.append(r6);
        com.larus.avlink.n1.d("DoraEnvObservePlugin", r0.toString());
        String r7 = k3();
        id9.d r3 = ((n4) getContext()).j();
        if (r3 == null) goto L9;
        jd9.c r4 = r3.state();
    L11:
        if ((r4 instanceof jd9.c.a) == false) goto L16;
        id9.d r5 = ((n4) getContext()).j();
        if (r5 == null) goto L15;
        r5.p(TriggerMode.DORA_STOP_CONVERSATION, r7);
    L15:
        this.g = false;
        this.h = "";
    L17:
        com.larus.audio.call.arch.b.a(getContext()).e0().d(true, true, "env observe end");
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L20;
        r8.Y0(9);
    L20:
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.G = false;
        Long r9 = this.f;
        if (r9 == null) goto L25;
        long r10 = System.currentTimeMillis() - r9.longValue();
        u4 r11 = (u4) getContext().c(Reflection.getOrCreateKotlinClass(u4.class), null);
        if (r11 == null) goto L25;
        r11.E1(r10);
    L25:
        this.f = null;
        return;
    L16:
        this.g = true;
        this.h = r7;
        goto L17
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void i0(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        Intrinsics.checkNotNullParameter(r3, "caller");
        com.larus.avlink.n1.d("DoraEnvObservePlugin", "start conversation in env observe, keyword: " + r4);
        this.f = Long.valueOf(System.currentTimeMillis());
        ((n4) getContext()).a().a1(MajorState.j.c, "DoraEnvObservePlugin");
        ((n4) getContext()).a().n2(StateTriggerEvent.RequestWaiting.a);
        id9.d r6 = ((n4) getContext()).j();
        if (r6 == null) goto L5;
        r6.p(TriggerMode.DORA_START_CONVERSATION, k3());
    L5:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L8;
        r7.Y0(8);
    L8:
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.G = true;
        u4 r8 = (u4) getContext().c(Reflection.getOrCreateKotlinClass(u4.class), null);
        if (r8 == null) goto L12;
        r8.s0();
        return;
    }

    @Override // com.larus.avlink.plugins.c
    public final void j3(int r2, int r3, String r4, String r5) {
        if (r3 != 7) goto L5;
        id9.d r6 = ((n4) getContext()).j();
        if (r6 == null) goto L11;
        jd9.c r7 = r6.state();
    L13:
        if ((r7 instanceof jd9.c.a) == false) goto L15;
        ((n4) getContext()).p(r4, r5);
        return;
    L15:
        IDoraAVLinkService r8 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r8 == null) goto L18;
        r8.N0(100);
    L18:
        IDoraAVLinkService r9 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r9 == null) goto L21;
        r9.D1();
    L21:
        ((n4) getContext()).d(false, 12, 181);
        return;
    L11:
        r7 = null;
        goto L13
    L5:
        if (r3 != 8) goto L25;
        ((n4) getContext()).f(r2);
        return;
    }
}
