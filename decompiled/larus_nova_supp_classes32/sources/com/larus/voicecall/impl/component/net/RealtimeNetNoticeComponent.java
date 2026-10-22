package com.larus.voicecall.impl.component.net;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.y0;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.network.NetworkQualityType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.impl.RealtimeCallService;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002*\u00019\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u001a\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020)H\u0002J\u0018\u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u001bH\u0002J\u001a\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u001f2\b\b\u0002\u0010-\u001a\u00020!H\u0002J\f\u0010=\u001a\u00020\u001b*\u00020\u001fH\u0002J\f\u0010>\u001a\u00020\u001d*\u00020\u001fH\u0002J\u0012\u0010?\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020!H\u0002J\u0018\u0010@\u001a\u00020)2\u0006\u00106\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0002J\u001a\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b$\u0010%R\u000e\u00107\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006N"}, d2 = {"Lcom/larus/voicecall/impl/component/net/RealtimeNetNoticeComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/net/IRealtimeNetNoticeAbility;", "<init>", "()V", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "currentState", "Lcom/larus/voicecall/impl/component/net/INetworkViewState;", "lastQuality", NameKeys.UnloadStrategy_No_Strategy, "lastTtnetQuality", "Lcom/larus/network/NetworkQualityType;", "hasMultiPathToastToday", NameKeys.UnloadStrategy_No_Strategy, "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "needShowBadNetNotice", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onDestroy", "onNetworkQualityChange", "quality", "force", "onMultiPathWork", "isSameDay", "lastShowTime", NameKeys.UnloadStrategy_No_Strategy, "currentTime", "initQualityState", "initQuality", "transitionTo", "newState", "lastPoorToastTime", "ttnetNetworkQualityChangeListener", "com/larus/voicecall/impl/component/net/RealtimeNetNoticeComponent$ttnetNetworkQualityChangeListener$1", "Lcom/larus/voicecall/impl/component/net/RealtimeNetNoticeComponent$ttnetNetworkQualityChangeListener$1;", "onTtnetNetworkQualityChange", "type", "toNetworkViewState", "toNetInfoQuality", "syncTtnetNetworkQuality", "enterNewState", "oldState", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "mobNoticeShow", "noticeContent", NameKeys.UnloadStrategy_No_Strategy, "noticeType", "otherEvent", "event", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeNetNoticeComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.net.b {
    public static final /* synthetic */ int y = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public com.larus.voicecall.impl.component.net.a r;
    public int s;
    public NetworkQualityType t;
    public boolean u;
    public final Lazy v;
    public long w;
    public final c x;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkQualityType.values().length];
            r0[NetworkQualityType.NO_NET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[NetworkQualityType.WEAK_NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[NetworkQualityType.NORMAL_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements com.larus.network.k {
        public final /* synthetic */ RealtimeNetNoticeComponent a;

        public c(RealtimeNetNoticeComponent r1) {
            this.a = r1;
        }

        public final void a(final NetworkQualityType r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            RealtimeNetNoticeComponent r0 = this.a;
            int r1 = RealtimeNetNoticeComponent.y;
            if (y0.b(((h88.b) ((e3a.b) r0.p.getValue())).e) == true) goto L5;
            return;
        L5:
            final RealtimeNetNoticeComponent r2 = this.a;
            t0.e(new o(r2, r3));
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.component.net.b
    public final boolean fo() {
        return this.r instanceof p;
    }

    public final void onDestroy() {
        if (y0.b(((h88.b) ((e3a.b) this.p.getValue())).e) == false) goto L6;
        NetConnectionTypeProvider.NetworkStatus r0 = NetConnectionTypeProvider.a;
        c r1 = this.x;
        NetConnectionTypeProvider.d.remove(r1);
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.net.b.class);
        if (y0.b(((h88.b) ((e3a.b) this.p.getValue())).e) == false) goto L9;
        NetConnectionTypeProvider.NetworkStatus r0 = NetConnectionTypeProvider.a;
        c r1 = this.x;
        if (r1 == null) goto L7;
        NetConnectionTypeProvider.d.addIfAbsent(r1);
    L7:
        z3(false);
        return;
    }

    public RealtimeNetNoticeComponent() {
        this.n = LazyKt.lazy(new g(this));
        this.o = LazyKt.lazy(new h(this));
        this.p = LazyKt.lazy(new i(this));
        this.q = LazyKt.lazy(new j(this));
        this.r = new e();
        this.s = -1;
        this.v = LazyKt.lazy(new k(this));
        t0.a(new l(this));
        this.x = new c(this);
    }

    public final void B3(com.larus.voicecall.impl.component.net.a r9) {
        FLogger.a.i("RealtimeNetNoticeComponent", "transitionTo newState=" + r9.getLogTag() + ' ');
        if (Intrinsics.areEqual(this.r, r9) == true) goto L29;
        com.larus.voicecall.impl.component.net.a r0 = this.r;
        this.r = r9;
        boolean r2 = false;
        if ((r9 instanceof e) == false) goto L17;
        if ((SystemClock.elapsedRealtime() - this.w) > 3000) goto L12;
        if ((r0 instanceof f) == false) goto L12;
        s.a.a();
    L12:
        if ((r0 instanceof p) == false) goto L30;
        com.larus.voicecall.impl.component.bottom.b r10 = (com.larus.voicecall.impl.component.bottom.b) this.n.getValue();
        if (r10 == null) goto L31;
        r10.ci(false);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        if ((r9 instanceof f) == false) goto L24;
        Lazy r11 = d.a;
        if ((SystemClock.elapsedRealtime() - ((Keva) r11.getValue()).getLong("LAST_POOR_NET_STATE_TOAST_SHOW_TIME", 0)) <= 900000) goto L21;
        r2 = true;
    L21:
        if (r2 == false) goto L33;
        String r1 = Y2(2131900057);
        m3(r1, "toast");
        s r3 = s.a;
        Context r4 = getContext();
        r3.getClass();
        s.u(r4, r1, 3000);
        ((Keva) r11.getValue()).storeLong("LAST_POOR_NET_STATE_TOAST_SHOW_TIME", SystemClock.elapsedRealtime());
        this.w = SystemClock.elapsedRealtime();
        return;
    L33:
        return;
    L24:
        if ((r9 instanceof p) == false) goto L35;
        m3(getContext().getString(2131900059), "text");
        com.larus.voicecall.impl.component.bottom.b r12 = (com.larus.voicecall.impl.component.bottom.b) this.n.getValue();
        if (r12 == null) goto L36;
        r12.ci(true);
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void I6(jd9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        h3(0);
        if ((r2 instanceof jd9.c.a) == false) goto L10;
        z3(true);
        if (z2.a.updateNetInfoAndSubtitleStatusEnabled() == true) goto L7;
        return;
    L7:
        if (this.s == (-1)) goto L12;
        ((RealtimeCallService) this.v.getValue()).p().L(this.s);
        return;
    L12:
        return;
    }

    public final void h3(int r2) {
        if (r2 >= 4) goto L5;
        com.larus.voicecall.impl.component.net.a r3 = new e();
    L10:
        B3(r3);
        return;
    L5:
        if (r2 != 4) goto L7;
        r3 = new f();
        goto L10
    L7:
        if (r2 <= 4) goto L9;
        r3 = new p();
        goto L10
    L9:
        r3 = new e();
        goto L10
    }

    public final void z3(boolean r5) {
        if (y0.b(((h88.b) ((e3a.b) this.p.getValue())).e) == true) goto L5;
        return;
    L5:
        NetworkQualityType r0 = NetConnectionTypeProvider.a(NetConnectionTypeProvider.a);
        FLogger.a.i("RealtimeNetNoticeComponent", "syncTtnetNetworkQuality quality=" + r0);
        p3(r0, r5);
    }

    public final void m3(String r5, String r6) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("scene", "call");
        r1.put("call_id", ((e3a.b) this.p.getValue()).a().e);
        com.larus.voicecall.impl.component.scene.a r2 = (com.larus.voicecall.impl.component.scene.a) this.q.getValue();
        if (r2 == null) goto L11;
        LiveData<com.larus.voicecall.impl.scene.m> r3 = r2.getCurrentScene();
        if (r3 == null) goto L11;
        com.larus.voicecall.impl.scene.m r4 = (com.larus.voicecall.impl.scene.m) r3.getValue();
        if (r4 == null) goto L11;
        SceneModel r7 = r4.a;
        if (r7 == null) goto L11;
        String r8 = r7.getKey();
    L12:
        r1.put("call_scene", r8);
        r1.put("bot_id", ((h88.a) ((e3a.a) this.o.getValue())).d);
        r1.put("prompt_content", r5);
        r1.put("prompt_type", r6);
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("call_scene_network_quality_prompt_show", r1);
        return;
    L11:
        r8 = null;
        goto L12
    }

    public final void p3(NetworkQualityType r6, boolean r7) {
        if (r7 == false) goto L4;
    L6:
        int[] r8 = b.a;
        int r0 = r8[r6.ordinal()];
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L12;
        int r1 = 2;
    L15:
        int r9 = r8[r6.ordinal()];
        if (r9 == 1) goto L23;
        if (r9 == 2) goto L22;
        if (r9 != 3) goto L21;
        com.larus.voicecall.impl.component.net.a r10 = new e();
    L24:
        B3(r10);
        FLogger.a.i("RealtimeNetNoticeComponent", "onTtnetNetworkQualityChange type=" + r6 + " quality=" + r1 + " lastType=" + this.t + " currentState=" + this.r.getLogTag());
        if (z2.a.updateNetInfoAndSubtitleStatusEnabled() == false) goto L27;
        ((RealtimeCallService) this.v.getValue()).p().L(r1);
    L27:
        this.t = r6;
        this.s = r1;
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r10 = new f();
        goto L24
    L23:
        r10 = new p();
        goto L24
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        r1 = 4;
        goto L15
    L14:
        r1 = 6;
        goto L15
    L4:
        if (r6 != this.t) goto L6;
    }

    public final void z2(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r5, "event");
        if (Intrinsics.areEqual(r5, "OTHER_EVENT_RTC_NETWORK_QUALITY_CHANGE") == false) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        if ((r6 instanceof String) == false) goto L7;
        String r1 = (String) r6;     // Catch: Throwable -> L10
    L8:
        JSONObject r2 = new JSONObject(r1);     // Catch: Throwable -> L10
        final int r3 = Math.min(JSONObjectProtectorUtils.getInt(r2, "upQuality"), JSONObjectProtectorUtils.getInt(r2, "downQuality"));     // Catch: Throwable -> L10
        t0.e(new m(this, r3));     // Catch: Throwable -> L10
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.exceptionOrNull-impl(r4);
        if (r7 == null) goto L24;
        FLogger.a.i("RealtimeNetNoticeComponent", "otherEvent error.err=" + r7 + " event=" + r5 + " content=" + r6 + ' ');
        return;
    L24:
        return;
    L7:
        r1 = null;
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L17:
        if (Intrinsics.areEqual(r5, "OTHER_EVENT_RTC_MULTIPATH_WORK") == false) goto L23;
        t0.e(new n(this));
        return;
    }
}
