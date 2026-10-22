package com.larus.voicecall.impl.plugins;

import android.util.LruCache;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.audio.call.plugins.CommonUIStatePlugin;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SceneModel;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.network.NetworkQualityType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeServerErrorDetail;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l1 extends CommonUIStatePlugin<r> {
    public static final List<Integer> D = null;
    public boolean A;
    public final c B;
    public final b C;
    public final boolean p;
    public final Lazy q;
    public final LruCache<String, Integer> r;
    public final com.larus.voicecall.impl.d s;
    public MajorState.f t;
    public StateTriggerEvent.Error u;
    public boolean v;
    public String w;
    public Job x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ l1 a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            l1 r0 = this.a;
            if (r0.A == false) goto L6;
            r0.w3("app_foreground");
            return;
        }

        public b(l1 r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.network.k {
        public final /* synthetic */ l1 a;

        public c(l1 r1) {
            this.a = r1;
        }

        public final void a(NetworkQualityType r11) {
            Intrinsics.checkNotNullParameter(r11, "type");
            if (r11 != NetworkQualityType.NORMAL_NETWORK) goto L5;
        L6:
            l1 r0 = this.a;
            String r12 = "network_quality_" + r11;
            r0.getClass();
            if (com.larus.audio.call.f.f() == false) goto L12;
            if (r0.u != null) goto L13;
        L14:
            boolean r1 = false;
        L15:
            if (r1 == true) goto L17;
            return;
        L17:
            if (r0.v == true) goto L30;
            Job r2 = r0.x;
            if (r2 == null) goto L22;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
        L22:
            CoroutineScope r4 = ((r) r0.getContext()).r();
            if (r4 != null) goto L25;
            r0.w3(r12);
            return;
        L25:
            r0.x = BuildersKt.launch$default(r4, null, null, new RealtimeCallUIStatePlugin$onNetworkRecovered$1(r0, r12, null), 3, null);
            return;
        L30:
            return;
        L13:
            r1 = true;
            goto L15
        L12:
            if (r0.t == null) goto L14;
        L5:
            if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L6;
        }
    }

    public final void u3() {
        this.t = null;
        this.u = null;
        this.A = false;
        Job r1 = this.x;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.x = null;
        G3();
    }

    static {
        D = CollectionsKt.listOf(622);
    }

    public final void D3() {
        if (this.y == true) goto L9;
        NetConnectionTypeProvider.NetworkStatus r0 = NetConnectionTypeProvider.a;
        c r1 = this.B;
        if (r1 == null) goto L7;
        NetConnectionTypeProvider.d.addIfAbsent(r1);
    L7:
        this.y = true;
    L9:
        if (this.z == true) goto L12;
        AppHost.a.a().j(this.C);
        this.z = true;
        return;
    }

    public final void G3() {
        if (this.y == false) goto L6;
        NetConnectionTypeProvider.NetworkStatus r0 = NetConnectionTypeProvider.a;
        c r1 = this.B;
        NetConnectionTypeProvider.d.remove(r1);
        this.y = false;
    L6:
        if (this.z == false) goto L9;
        AppHost.a.a().c(this.C);
        this.z = false;
        return;
    }

    public final lq9.z x3() {
        return (lq9.z) this.q.getValue();
    }

    public final boolean H() {
        return ((n) getContext().b(Reflection.getOrCreateKotlinClass(n.class), null)).H();
    }

    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L6;
        return null;
    L6:
        return new CommonUIStatePlugin.a(this);
    }

    public final void e3() {
        String r0 = ((r) getContext()).params().e;
        if (Intrinsics.areEqual(this.w, r0) == true) goto L5;
        this.v = false;
        this.w = r0;
    L5:
        super.e3();
    }

    public final void g3() {
        super.g3();
        if (com.larus.audio.call.f.f() == false) goto L10;
        StateTriggerEvent.Error r0 = this.u;
        if (r0 != null) goto L7;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == true) goto L18;
        u3();
        return;
    L18:
        return;
    L7:
        if (com.larus.voicecall.impl.f0.a((AVKitDuplexState) ((r) getContext()).a().y().getValue()) != r0) goto L14;
    L13:
        r1 = true;
        goto L15
    L10:
        if (this.t == null) goto L14;
        if ((((r) getContext()).a().s1() instanceof MajorState.f) == false) goto L14;
        goto L13
    }

    public final void b3() {
        u3();
    }

    public final boolean l3() {
        return this.p;
    }

    public l1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.p = true;
        this.q = LazyKt.lazy(new k1());
        this.r = new LruCache(3);
        this.s = new com.larus.voicecall.impl.d();
        this.B = new c(this);
        this.C = new b(this);
    }

    public final boolean A3(MajorState.f r3) {
        List<Integer> r0 = x3().f();
        if (r0 != null) goto L5;
        r0 = D;
    L5:
        Integer r4 = r3.f;
        if (r4 != null) goto L8;
        return false;
    L8:
        if (r0.contains(Integer.valueOf(r4.intValue())) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean B3(StateTriggerEvent.Error r3) {
        List<Integer> r0 = x3().f();
        if (r0 != null) goto L5;
        r0 = D;
    L5:
        Object r4 = r3.c.get("sub_error_code");
        if ((r4 instanceof Integer) == false) goto L8;
        Integer r5 = (Integer) r4;
    L9:
        if (r5 != null) goto L11;
    L13:
        return false;
    L11:
        if (r0.contains(Integer.valueOf(r5.intValue())) != true) goto L13;
        return true;
    L8:
        r5 = null;
        goto L9
    }

    public final Integer p3(AVKitDuplexState r21) {
        Intrinsics.checkNotNullParameter(r21, "duplex");
        StateTriggerEvent.Error r2 = this.s.a(r21);
        if (r2 == null) goto L5;
        Object r1 = r2.c.get("sub_error_code");
        if ((r1 instanceof Integer) == false) goto L13;
        Integer r3 = (Integer) r1;
    L14:
        Integer r5 = com.larus.voicecall.impl.tracer.x.a(r2.b);
        String r6 = ((r) getContext()).params().e;
        Integer r7 = this.r.get(r6);
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
    L18:
        Integer r9 = x3().d();
        if (r9 == null) goto L21;
        int r10 = r9.intValue();
    L22:
        boolean r11 = NetworkUtils.isNetworkAvailable(AppHost.a.getApplication());
        RealtimeServerErrorDetail.a r12 = RealtimeServerErrorDetail.f;
        String r13 = r2.b;
        r12.getClass();
        RealtimeServerErrorDetail r14 = RealtimeServerErrorDetail.a.a(r13);
        boolean r15 = B3(r2);
        if (Intrinsics.areEqual(x3().a(), Boolean.TRUE) == true) goto L25;
    L55:
        FLogger r16 = FLogger.a;
        String r17 = ((CommonUIStatePlugin) this).f;
        StringBuilder r18 = new StringBuilder("onDuplexNetworkErrorArrived do not retry! call_id=");
        r18.append(r6);
        r18.append(" times=");
        r18.append(r8);
        r18.append(" maxTimes=");
        r18.append(r10);
        r18.append(" code=");
        r18.append(r2.a);
        r18.append(" subErrorCode=");
        r18.append(r3);
        r18.append(" detailErrCode=");
        r18.append(r5);
        r18.append(" isNetworkAvailable=");
        r18.append(r11);
        r18.append(" roomId=");
        r18.append(((r) getContext()).params().d);
        r18.append(" scene=");
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r0 = RealtimeCallUtil.l;
        if (r0 == null) goto L60;
        SceneModel r4 = r0.a;
        if (r4 == null) goto L60;
        String r19 = r4.getKey();
    L61:
        r18.append(r19);
        r16.e(r17, r18.toString());
        Object r20 = r2.c.get("sub_error_code");
        if ((r20 instanceof Integer) == false) goto L64;
        Integer r22 = (Integer) r20;
    L65:
        com.larus.im.internal.delegate.w.b r23 = com.larus.im.internal.delegate.w.j().d;
        if (r23 == null) goto L68;
        boolean r24 = r23.h;
    L70:
        if (r24 == true) goto L72;
    L93:
        l1 r25 = this;
    L94:
        boolean r26 = false;
    L95:
        if (r26 == false) goto L106;
        r25.u = r2;
        AtomicReference<String> r27 = com.larus.voicecall.impl.utils.r.a;
        String r28 = r2.b;
        if (r28 != null) goto L99;
    L102:
        boolean r29 = true;
    L103:
        if (r29 == true) goto L105;
        com.larus.voicecall.impl.utils.r.a.set(r28);
    L105:
        D3();
        r16.i(((CommonUIStatePlugin) r25).f, "onDuplexNetworkErrorArrived wait network recovery, call_id=" + r6 + " code=" + r2.a + " subErrorCode=" + r3);
        goto L106
    L99:
        if (StringsKt.isBlank(r28) == true) goto L102;
        r29 = false;
    L106:
        return null;
    L72:
        if (com.larus.im.service.audio.y0.e(((r) getContext()).params().s) == false) goto L93;
        if (((r) getContext()).params().u != 1) goto L93;
        r25 = this;
        if (r25.v == true) goto L94;
        if (r11 == true) goto L94;
        if (r25.z3(r2, RealtimeServerErrorDetail.a.a(r2.b)) == false) goto L94;
        if (RealtimeCallUtil.x(r2.a, r22) == true) goto L94;
        if (com.larus.utils.o0.d(((r) getContext()).params().e) == false) goto L94;
        com.larus.voicecall.impl.scene.o r30 = RealtimeCallUtil.l;
        if (r30 == null) goto L89;
        SceneModel r31 = r30.a;
        if (r31 == null) goto L89;
        String r32 = r31.getKey();
    L91:
        if (Intrinsics.areEqual(r32, "interview_v2") == true) goto L94;
        r26 = true;
    L89:
        r32 = null;
        goto L91
    L68:
        r24 = false;
        goto L70
    L64:
        r22 = null;
    L60:
        r19 = null;
        goto L61
    L25:
        if (z3(r2, r14) == false) goto L55;
        if (r15 == true) goto L31;
        RealtimeCallUtil r110 = RealtimeCallUtil.a;
        int r111 = r2.a;
        r110.getClass();
        if (RealtimeCallUtil.x(r111, r3) == true) goto L55;
    L31:
        if (r11 == false) goto L55;
        if (com.larus.utils.o0.d(r6) == false) goto L55;
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r112 = RealtimeCallUtil.l;
        if (r112 == null) goto L39;
        SceneModel r113 = r112.a;
        if (r113 == null) goto L39;
        String r114 = r113.getKey();
    L41:
        if (Intrinsics.areEqual(r114, "interview_v2") == true) goto L55;
        if (r15 == true) goto L44;
        if (r8 >= r10) goto L55;
    L44:
        if (r15 == true) goto L50;
        LruCache<String, Integer> r33 = this.r;
        if (r6 != null) goto L48;
        String r115 = NameKeys.UnloadStrategy_No_Strategy;
    L49:
        r33.put(r115, Integer.valueOf(r8 + 1));
        goto L50
    L48:
        r115 = r6;
    L50:
        FLogger.a.e(((CommonUIStatePlugin) this).f, "onDuplexNetworkErrorArrived call_id=" + r6 + " times=" + r8 + " code=" + r2.a + " subErrorCode=" + r3 + " detailErrCode=" + r5 + " roomId=" + ((r) getContext()).params().d);
        if (r5 == null) goto L53;
        int r34 = r5.intValue();
    L54:
        v3(r2, r34, F3(r2, r14));
        return 16;
    L53:
        r34 = -1;
    L39:
        r114 = null;
        goto L41
    L21:
        r10 = 0;
        goto L22
    L17:
        r8 = 0;
        goto L18
    L13:
        r3 = null;
        goto L14
    L5:
        if (com.larus.voicecall.impl.f0.a(r21) == null) goto L7;
    L9:
        return null;
    L7:
        if (this.u == null) goto L9;
        u3();
        goto L9
    }

    public final void q3(MajorState.f r20) {
        Intrinsics.checkNotNullParameter(r20, "state");
        Integer r2 = com.larus.voicecall.impl.tracer.x.a(r20.e);
        String r3 = ((r) getContext()).params().e;
        Integer r4 = this.r.get(r3);
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        Integer r6 = x3().d();
        if (r6 == null) goto L9;
        int r7 = r6.intValue();
    L10:
        boolean r8 = NetworkUtils.isNetworkAvailable(AppHost.a.getApplication());
        RealtimeServerErrorDetail.a r9 = RealtimeServerErrorDetail.f;
        String r10 = r20.e;
        r9.getClass();
        RealtimeServerErrorDetail r11 = RealtimeServerErrorDetail.a.a(r10);
        boolean r12 = A3(r20);
        if (Intrinsics.areEqual(x3().a(), Boolean.TRUE) == true) goto L13;
    L44:
        String r13 = " roomId=";
    L45:
        FLogger r14 = FLogger.a;
        String r15 = ((CommonUIStatePlugin) this).f;
        StringBuilder r16 = new StringBuilder("onNetworkErrorArrived do not retry! call_id=");
        r16.append(r3);
        r16.append("  times=");
        r16.append(r5);
        r16.append(" maxTimes=");
        r16.append(r7);
        r16.append(" code=");
        r16.append(r20.c);
        r16.append(" subErrorCode=");
        r16.append(r20.f);
        r16.append(" detailErrCode=");
        r16.append(r2);
        r16.append(" isNetworkAvailable=");
        r16.append(r8);
        r16.append(r13);
        r16.append(((r) getContext()).params().d);
        r16.append(" scene=");
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r17 = RealtimeCallUtil.l;
        if (r17 == null) goto L50;
        SceneModel r18 = r17.a;
        if (r18 == null) goto L50;
        String r19 = r18.getKey();
    L51:
        r16.append(r19);
        r14.e(r15, r16.toString());
        com.larus.im.internal.delegate.w.b r21 = com.larus.im.internal.delegate.w.j().d;
        if (r21 == null) goto L54;
        boolean r22 = r21.h;
    L56:
        if (r22 == true) goto L58;
    L79:
        boolean r23 = false;
    L80:
        if (r23 == false) goto L91;
        this.t = r20;
        AtomicReference<String> r24 = com.larus.voicecall.impl.utils.r.a;
        String r25 = r20.e;
        if (r25 != null) goto L84;
    L87:
        boolean r110 = true;
    L88:
        if (r110 == true) goto L90;
        com.larus.voicecall.impl.utils.r.a.set(r25);
    L90:
        D3();
        r14.i(((CommonUIStatePlugin) this).f, "onNetworkErrorArrived wait network recovery, call_id=" + r3 + " code=" + r20.c + " subErrorCode=" + r20.f);
        goto L91
    L84:
        if (StringsKt.isBlank(r25) == true) goto L87;
        r110 = false;
    L91:
        super.q3(r20);
        return;
    L58:
        if (com.larus.im.service.audio.y0.e(((r) getContext()).params().s) == false) goto L79;
        if (((r) getContext()).params().u != 1) goto L79;
        if (this.v == true) goto L79;
        if (r8 == true) goto L79;
        if (y3(r20, RealtimeServerErrorDetail.a.a(r20.e)) == false) goto L79;
        if (RealtimeCallUtil.x(r20.c, r20.f) == true) goto L79;
        if (com.larus.utils.o0.d(((r) getContext()).params().e) == false) goto L79;
        com.larus.voicecall.impl.scene.o r26 = RealtimeCallUtil.l;
        if (r26 == null) goto L75;
        SceneModel r27 = r26.a;
        if (r27 == null) goto L75;
        String r28 = r27.getKey();
    L77:
        if (Intrinsics.areEqual(r28, "interview_v2") == true) goto L79;
        r23 = true;
    L75:
        r28 = null;
        goto L77
    L54:
        r22 = false;
    L50:
        r19 = null;
        goto L51
    L13:
        if (y3(r20, r11) == false) goto L44;
        if (r12 == true) goto L19;
        RealtimeCallUtil r111 = RealtimeCallUtil.a;
        int r29 = r20.c;
        String r112 = " roomId=";
        Integer r113 = r20.f;
        r111.getClass();
        if (RealtimeCallUtil.x(r29, r113) == false) goto L20;
    L18:
        r13 = r112;
    L20:
        if (r8 == false) goto L18;
        if (com.larus.utils.o0.d(r3) == false) goto L18;
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r30 = RealtimeCallUtil.l;
        if (r30 == null) goto L28;
        SceneModel r31 = r30.a;
        if (r31 == null) goto L28;
        String r32 = r31.getKey();
    L30:
        if (Intrinsics.areEqual(r32, "interview_v2") == true) goto L18;
        if (r12 == true) goto L33;
        if (r5 >= r7) goto L18;
    L33:
        if (r12 == true) goto L39;
        LruCache<String, Integer> r33 = this.r;
        if (r3 != null) goto L37;
        String r34 = NameKeys.UnloadStrategy_No_Strategy;
    L38:
        r33.put(r34, Integer.valueOf(r5 + 1));
        goto L39
    L37:
        r34 = r3;
    L39:
        FLogger.a.e(((CommonUIStatePlugin) this).f, "onNetworkErrorArrived call_id=" + r3 + "  times=" + r5 + " code=" + r20.c + " subErrorCode=" + r20.f + " detailErrCode=" + r2 + r112 + ((r) getContext()).params().d);
        int r35 = r20.c;
        if (r2 == null) goto L42;
        int r36 = r2.intValue();
    L43:
        C3(r35, r36, E3(r20, r11));
        r3(r20, 16);
        t3();
        return;
    L42:
        r36 = -1;
    L28:
        r32 = null;
        goto L30
    L19:
        r112 = " roomId=";
        goto L20
    L9:
        r7 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final void w3(String r10) {
        int r2 = -1;
        if (com.larus.audio.call.f.f() == false) goto L21;
        StateTriggerEvent.Error r0 = this.u;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.v == true) goto L43;
        AppHost.Companion r7 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r7.getApplication()) == true) goto L14;
        FLogger.a.i(((CommonUIStatePlugin) this).f, "emitPendingDuplexNetworkRecoveryRetry skip, network unavailable, source=" + r10);
        return;
    L14:
        if (r7.a().isAppBackground() == false) goto L16;
        this.A = true;
        FLogger.a.i(((CommonUIStatePlugin) this).f, "emitPendingDuplexNetworkRecoveryRetry wait foreground, source=" + r10);
        return;
    L16:
        this.v = true;
        this.u = null;
        this.A = false;
        G3();
        FLogger.a.i(((CommonUIStatePlugin) this).f, "emitPendingDuplexNetworkRecoveryRetry, source=" + r10 + " code=" + r0.a);
        Integer r11 = com.larus.voicecall.impl.tracer.x.a(r0.b);
        if (r11 == null) goto L19;
        r2 = r11.intValue();
    L19:
        StringBuilder r12 = new StringBuilder("network_recovery:");
        RealtimeServerErrorDetail.a r1 = RealtimeServerErrorDetail.f;
        String r3 = r0.b;
        r1.getClass();
        r12.append(F3(r0, RealtimeServerErrorDetail.a.a(r3)));
        v3(r0, r2, r12.toString());
        return;
    L43:
        return;
    L21:
        MajorState.f r4 = this.t;
        if (r4 != null) goto L25;
        return;
    L25:
        if (this.v == false) goto L27;
        return;
    L27:
        AppHost.Companion r8 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r8.getApplication()) == true) goto L32;
        FLogger.a.i(((CommonUIStatePlugin) this).f, "emitPendingNetworkRecoveryRetry skip, network unavailable, source=" + r10);
        return;
    L32:
        if (r8.a().isAppBackground() == false) goto L35;
        this.A = true;
        FLogger.a.i(((CommonUIStatePlugin) this).f, "emitPendingNetworkRecoveryRetry wait foreground, source=" + r10);
        return;
    L35:
        this.v = true;
        this.t = null;
        this.A = false;
        G3();
        FLogger.a.i(((CommonUIStatePlugin) this).f, "emitPendingNetworkRecoveryRetry, source=" + r10 + " code=" + r4.c + " subErrorCode=" + r4.f);
        int r13 = r4.c;
        Integer r5 = com.larus.voicecall.impl.tracer.x.a(r4.e);
        if (r5 == null) goto L38;
        r2 = r5.intValue();
    L38:
        RealtimeServerErrorDetail.a r6 = RealtimeServerErrorDetail.f;
        String r9 = r4.e;
        r6.getClass();
        C3(r13, r2, "network_recovery:".concat(E3(r4, RealtimeServerErrorDetail.a.a(r9))));
        r3(r4, 16);
        t3();
    }

    public static String E3(MajorState.f r2, RealtimeServerErrorDetail r3) {
        if (r3 == null) goto L5;
        String r4 = "server_decision:" + r3.a + ':' + r3.b.name();
        if (r4 == null) goto L5;
        return r4;
    L5:
        String r5 = r2.e;
        if (r5 != null) goto L10;
        return NameKeys.UnloadStrategy_No_Strategy;
    L10:
        return r5;
    }

    public static String F3(StateTriggerEvent.Error r2, RealtimeServerErrorDetail r3) {
        if (r3 == null) goto L6;
        String r4 = "server_decision:" + r3.a + ':' + r3.b.name();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return r2.b;
    }

    public final boolean y3(MajorState.f r3, RealtimeServerErrorDetail r4) {
        if (A3(r3) == false) goto L5;
        return true;
    L5:
        if (r4 == null) goto L7;
        Boolean r5 = r4.d;
    L9:
        if (x3().b() == false) goto L12;
        if (r5 == null) goto L12;
        return r5.booleanValue();
    L12:
        List r6 = x3().e();
        if (r6 != null) goto L15;
    L17:
        return false;
    L15:
        if (r6.contains(Integer.valueOf(r3.c)) != true) goto L17;
        return true;
    L7:
        r5 = null;
        goto L9
    }

    public final boolean z3(StateTriggerEvent.Error r3, RealtimeServerErrorDetail r4) {
        if (B3(r3) == false) goto L5;
        return true;
    L5:
        if (r4 == null) goto L7;
        Boolean r5 = r4.d;
    L9:
        if (x3().b() == false) goto L12;
        if (r5 == null) goto L12;
        return r5.booleanValue();
    L12:
        List r6 = x3().e();
        if (r6 != null) goto L15;
    L17:
        return false;
    L15:
        if (r6.contains(Integer.valueOf(r3.a)) != true) goto L17;
        return true;
    L7:
        r5 = null;
        goto L9
    }

    public final void C3(int r5, int r6, String r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;     // Catch: Throwable -> L4
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put(LynxResourceModule.CODE_KEY, r5);     // Catch: Throwable -> L4
        r2.put("detail_code", r6);     // Catch: Throwable -> L4
        r2.put("msg", r7);     // Catch: Throwable -> L4
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r1.reportEvent("client_retry_call", r2);     // Catch: Throwable -> L4
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L13;
        FLogger.a.e(((CommonUIStatePlugin) this).f, "mobClientRetry, err=" + r10);
        return;
    L13:
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void v3(StateTriggerEvent.Error r6, int r7, String r8) {
        String r0 = ((r) getContext()).params().e;
        if (r0 != null) goto L5;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        com.larus.voicecall.impl.c0 r1 = new com.larus.voicecall.impl.c0(r0, r6);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;     // Catch: Throwable -> L8
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L8
        r4.put(LynxResourceModule.CODE_KEY, r6.a);     // Catch: Throwable -> L8
        r4.put("detail_code", r7);     // Catch: Throwable -> L8
        r4.put("msg", r8);     // Catch: Throwable -> L8
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r3.reportEvent("client_retry_call", r4);     // Catch: Throwable -> L8
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L14;
        FLogger.a.e(((CommonUIStatePlugin) this).f, "emitDuplexRetryRequest, err=" + r11);
    L14:
        com.larus.voicecall.impl.q r12 = ((r) getContext()).h();
        if (r12 == null) goto L20;
        r12.b(r1);
        return;
    L20:
        return;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void n3(String r2, Function0<Unit> r3, Function0<Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "onIdle");
        Intrinsics.checkNotNullParameter(r4, "onAllEnd");
        Intrinsics.checkNotNullParameter(r5, "onOccupied");
        com.larus.call_plugins_doubao_common.manager.m.a(r2, r3, r4, r5);
    }
}
