package com.larus.avlink.plugins;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.model.TimerScene;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.l;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class BaseDoraCallAudioPlugin extends com.larus.audio.call.plugins.u<n4> implements l4 {
    public final String I;
    public final Lazy J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final List<r58.d> N;
    public final List<byte[]> O;
    public final List<Integer> P;

    public static final class a {
    }

    public class b extends com.larus.audio.call.play.e {
        public long a;
        public long b;
        public long c;
        public final /* synthetic */ BaseDoraCallAudioPlugin d;

        public final void a() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
            if (Intrinsics.areEqual(((n4) this.d.getContext()).params().k.o, "dora_half_duplex") == false) goto L5;
            String r1 = "radio";
        L6:
            Intrinsics.checkNotNullParameter(r1, "audioType");
            IDoraService r2 = x2.c();
            if (r2 == null) goto L9;
            r2.Z(r1);
        L9:
            Lazy r3 = ia8.m.a;
            ia8.m.b(DoraEvent.TTSPlayEnd);
            return;
        L5:
            r1 = "TTS";
            goto L6
        }

        public final void c() {
            if (this.d.l0() == false) goto L6;
            com.larus.avlink.n1.d(this.d.I, "ignore onPlayFirstFrame after env observe stop conversation");
            return;
        L6:
            com.larus.avlink.n1.a(this.d.I, "onPlayFirstFrame");
            this.d.k4();
            long r0 = System.currentTimeMillis();
            IRealtimeCallTracer r3 = ((n4) this.d.getContext()).k();
            long r4 = this.a;
            r3.Y(r0 - r4, this.c - r4, r0 - this.b);
            id9.d r1 = ((n4) this.d.getContext()).j();
            if (r1 == null) goto L10;
            r1.p(TriggerMode.TTS_PLAYBACK_START, null);
            return;
        }

        public final void onPlayComplete() {
            com.larus.avlink.n1.a(this.d.I, "onPlayComplete");
        }

        public b(BaseDoraCallAudioPlugin r1) {
            this.d = r1;
        }

        public final void b(Map<String, String> r3) {
            if (this.d.l0() == false) goto L6;
            com.larus.avlink.n1.d(this.d.I, "ignore beforeAudioPlay after env observe stop conversation");
            return;
        L6:
            this.a = System.currentTimeMillis();
            this.b = 0;
            this.c = 0;
            DoraEvent r4 = DoraEvent.TTSPlayStart;
            m58.y r0 = m58.y.a;
            r4.setExtra(m58.y.e(AppHost.a.getApplication()));
            ia8.m.b(r4);
        }

        public final void e(boolean r2) {
            com.larus.avlink.n1.a(this.d.I, "onInterrupt");
        }

        public final void f(TtsPlayEndType r2) {
            Intrinsics.checkNotNullParameter(r2, "endType");
            this.d.l4("onPlayEnd");
        }

        public final void g(byte[] r6) {
            Intrinsics.checkNotNullParameter(r6, "audio");
            if (this.d.l0() == false) goto L6;
            com.larus.avlink.n1.d(this.d.I, "ignore beforeAudioPlay after env observe stop conversation");
            return;
        L6:
            Intrinsics.checkNotNullParameter(r6, "audio");
            if (this.a <= 0) goto L9;
            this.b = System.currentTimeMillis();
            this.c = System.currentTimeMillis();
        L9:
            ((n4) this.d.getContext()).o(r6);
        }
    }

    public static final class c implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ BaseDoraCallAudioPlugin c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public c(BaseDoraCallAudioPlugin r1) {
            this.c = r1;
            this.a = r1.I;
            this.b = DataType.PLAYER;
        }

        public final void a(l r2) {
            Intrinsics.checkNotNullParameter(r2, "frame");
            com.larus.avlink.n1.d(this.c.I, "onReceiveFrame");
            BaseDoraCallAudioPlugin r3 = this.c;
            r3.K = false;
            r3.getClass();
            this.c.M = true;
        }
    }

    public static final class d implements m4 {
        public final /* synthetic */ n4 a;
        public final /* synthetic */ BaseDoraCallAudioPlugin b;

        public final IRealtimeCallTracer U9() {
            return ((com.larus.audio.call.plugins.u) this.b).E.U9();
        }

        public final u68.a e0() {
            return ((com.larus.audio.call.plugins.u) this.b).E.e0();
        }

        @Override // com.larus.avlink.plugins.m4
        public final void a(TriggerMode r3) {
            Intrinsics.checkNotNullParameter(r3, "triggerType");
            id9.d r0 = this.a.j();
            if (r0 == null) goto L6;
            r0.p(r3, null);
            return;
        }

        public d(n4 r1, BaseDoraCallAudioPlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public void F1(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public final boolean J3() {
        return false;
    }

    public void V3() {
        this.L = false;
        this.M = false;
    }

    public void W3() {
        this.L = true;
        if (this.K == true) goto L5;
        return;
    L5:
        if (this.M == false) goto L9;
        com.larus.avlink.n1.d(this.I, "Thread: " + ThreadMethodProxy.currentThread().getName() + ", TTSEnded and ttsDataExhaustion");
        l4("onLLMReplyEnd");
        return;
    }

    @Override // com.larus.avlink.plugins.l4
    public void a() {
    }

    public void j4() {
    }

    public void k4() {
    }

    @Override // com.larus.avlink.plugins.l4
    public boolean l0() {
        return false;
    }

    public final com.larus.im.service.audio.x Q2() {
        return new c(this);
    }

    public final void l3() {
        if (((ArrayList) this.N).isEmpty() == false) goto L5;
        return;
    L5:
        com.larus.avlink.n1.d(this.I, "checkAndSendCachedData, audio data size: " + ((ArrayList) this.N).size() + ", vad data size: " + ((ArrayList) this.O).size());
        int r0 = ((ArrayList) this.N).size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L27;
        List<r58.d> r3 = this.N;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r5 = null;
        if (r2 < 0) goto L13;
        ArrayList r4 = (ArrayList) r3;
        if (r2 >= r4.size()) goto L13;
        Object r6 = ListProtector.get(r4, r2);
    L14:
        r58.d r7 = (r58.d) r6;
        if (r7 == null) goto L17;
        com.larus.audio.call.arch.b.c(getContext()).m2(new l(r7.b, r3().toString(), ((com.larus.audio.call.plugins.u) this).k, false));
    L17:
        List<byte[]> r8 = this.O;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r2 < 0) goto L23;
        ArrayList r9 = (ArrayList) r8;
        if (r2 >= r9.size()) goto L23;
        r5 = ListProtector.get(r9, r2);
    L23:
        byte[] r10 = (byte[]) r5;
        if (r10 == null) goto L26;
        e4(r10);
    L26:
        r2 = r2 + 1;
    L13:
        r6 = null;
        goto L14
    L27:
        ((ArrayList) this.N).clear();
        ((ArrayList) this.O).clear();
    }

    public final com.larus.audio.call.plugins.a z3() {
        return (com.larus.audio.call.plugins.a) this.J.getValue();
    }

    public final boolean b1() {
        com.larus.audio.call.plugins.y0 r0 = com.larus.audio.call.arch.b.d(getContext());
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b1();
    }

    public final void c4() {
        s3().i(new b(this));
    }

    public void e3() {
        super.e3();
        this.L = false;
    }

    public void g3() {
        super.g3();
        ((ArrayList) this.N).clear();
        ((ArrayList) this.O).clear();
    }

    public final n3 h4() {
        return (n3) getContext().b(Reflection.getOrCreateKotlinClass(n3.class), null);
    }

    public final x3 i4() {
        return (x3) getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
    }

    public final boolean k3() {
        if (((n4) getContext()).q() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void m4() {
        x3 r0 = i4();
        if (r0 == null) goto L6;
        r0.Z1();
        return;
    }

    public final String T2() {
        return this.I;
    }

    public BaseDoraCallAudioPlugin(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.I = "DoraCallAudioPlugin";
        this.J = LazyKt.lazy(new com.larus.avlink.plugins.b(r2, this));
        this.K = true;
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.P = new ArrayList();
    }

    public final void O3(pf9.q r20) {
        Intrinsics.checkNotNullParameter(r20, "event");
        List r1 = r20.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L26;
        pf9.p r4 = (pf9.p) r3.next();
        Long r5 = r4.a;
        if (r5 == null) goto L25;
        int r6 = (int) r5.longValue();
        if (r6 != 5) goto L10;
    L12:
        Map r7 = r4.b;
        long r8 = System.currentTimeMillis();
        Long r9 = null;
        if (r7 == null) goto L15;
        String r10 = (String) r7.get("msg_id");
    L16:
        if (r7 == null) goto L18;
        String r11 = (String) r7.get("cmd_start_time");
    L19:
        n3 r12 = h4();
        Integer r13 = Integer.valueOf(r6);
        if (r11 == null) goto L22;
        r9 = Long.valueOf(CastLongProtector.parseLong(r11));
    L22:
        r12.w0(r13, r10, r9, Long.valueOf(r8));
        h4().N1("doubao_recv");
        com.larus.audio.call.tracer.c.a.a(((n4) getContext()).k(), "doubao_recv", Integer.valueOf(r6), r10, null, null, null, null, 248);
        com.larus.avlink.n1.d(this.I, "buildAndReportDoraCommandSend>>>>command is " + r6 + ", messageId is " + r10 + ", commandStartTime is " + r11 + ", commandReceivedTime is " + r8);
        ((ArrayList) this.P).add(Integer.valueOf(r6));
        Map<Function1<Boolean, Unit>, k4> r14 = x2.a;
        IDoraService r15 = x2.c();
        if (r15 == null) goto L25;
        r15.c0();
        goto L25
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L10:
        if (r6 == 21) goto L12;
    L25:
        r2.add(r4);
        goto L4
    }

    public final void Q3(pf9.v r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        com.larus.avlink.n1.d(this.I, "onFlowLLMGenerateEnd event.noContent: " + r4.a + " doraTimePlugin: " + i4());
        if (r4.a == false) goto L8;
        x3 r5 = i4();
        if (r5 == null) goto L9;
        r5.G(TimerScene.OnReplyNoContent);
        return;
    L9:
        return;
    }

    public void T3(pf9.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r2.c == true) goto L5;
        return;
    L5:
        if (r2.d == true) goto L9;
        this.L = true;
        l4("onLLMQueryEnd_noContent");
        return;
    }

    public final void e4(byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "vad");
        if (DoraConfig.a.getBoolean("key_dora_switch_vad", false) == true) goto L5;
        return;
    L5:
        if (r8.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == false) goto L21;
        com.larus.audio.call.plugins.s0 r1 = com.larus.audio.call.arch.b.c(getContext());
        LinkedHashMap r3 = new LinkedHashMap();
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L15;
        com.larus.home.impl.sdk.s r5 = r4.s0();
        if (r5 == null) goto L15;
        String r6 = r5.w();
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        ouc.g0 r7 = ouc.k.c(r6);
        Intrinsics.checkNotNullParameter("engine_version", "key");
        Intrinsics.checkNotNullParameter(r7, "element");
        ouc.i r9 = (ouc.i) r3.put("engine_version", r7);
        r1.m2(new l(r8, new ouc.d0(r3).toString(), ue9.g.d.b, false));
        return;
    L15:
        r6 = null;
        goto L16
    L21:
        return;
    L7:
        r0 = false;
        goto L9
    }

    public void l4(String r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        if (this.K == true) goto L6;
        this.K = true;
        Lazy r0 = ia8.m.a;
        ia8.m.b(DoraEvent.TTSDataExhaustion);
        h4().y2();
    L6:
        if (this.L == false) goto L38;
        boolean r1 = false;
        this.L = false;
        j4();
        com.larus.avlink.n1.d(this.I, "Audio play complete from " + r12 + ", audioPlayer hash:" + s3().hashCode() + ", DoraAudioPlugin:" + hashCode());
        Lazy r2 = ia8.m.a;
        ia8.m.b(DoraEvent.VuiDataEnd);
        Iterator r3 = ((ArrayList) this.P).iterator();
    L9:
        if (r3.hasNext() == false) goto L22;
        int r4 = ((Number) r3.next()).intValue();
        if (r4 == 5) goto L18;
        if (r4 != 21) goto L9;
        CoroutineScope r5 = ((n4) getContext()).r();
        if (r5 == null) goto L21;
        BuildersKt.launch$default(r5, null, null, new BaseDoraCallAudioPlugin$handleVUIENDCommand$1(this, null), 3, null);
    L21:
        r1 = true;
        goto L9
    L18:
        CoroutineScope r6 = ((n4) getContext()).r();
        if (r6 == null) goto L21;
        BuildersKt.launch$default(r6, null, null, new BaseDoraCallAudioPlugin$handleVUIENDCommand$2(this, null), 3, null);
        goto L21
    L22:
        ((ArrayList) this.P).clear();
        if (r1 == true) goto L39;
        Map<Function1<Boolean, Unit>, k4> r7 = x2.a;
        x2.j("DATA_END", null);
        m4();
        com.larus.avlink.n1.d(this.I, "DATA_END in onTtsPlayFinished from ".concat(r12));
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == true) goto L27;
        return;
    L27:
        if (h4().K() == true) goto L41;
        CoroutineScope r8 = ((n4) getContext()).r();
        if (r8 == null) goto L42;
        BuildersKt.launch$default(r8, null, null, new BaseDoraCallAudioPlugin$onTtsPlayFinished$1(this, null), 3, null);
        return;
    L42:
        return;
    L41:
        return;
    L39:
        return;
    }

    public final void j3(r58.d r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "audioData");
        ((ArrayList) this.O).add(r3);
        ((ArrayList) this.N).add(r2);
        ((com.larus.audio.call.plugins.u) this).B.a(new com.larus.avlink.plugins.a(this));
    }
}
