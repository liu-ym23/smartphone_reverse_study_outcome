package com.bytedance.android.live.livelink.multilink.pipeline;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.model.q0;
import com.bytedance.android.live.liveinteract.plantform.model.t0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.a0;
import com.bytedance.android.livesdk.chatroom.model.interact.m;
import com.bytedance.android.livesdk.config.LiveLinkMicUpdateLiveCoreParamsConfig;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffectKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContentDef;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.revenue.platform.api.core.rx.p;
import fr2.u;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkPipelineManager extends vb6.b implements cc6.a {
    public static final /* synthetic */ int u = 0;
    public MultiLinkConfig b;
    public final Lazy c;
    public String d;
    public ExtraResponse<? extends IJoinChannelResult, Extra> e;
    public com.bytedance.android.live.network.response.d.b f;
    public int g;
    public final tc0.b h;
    public final hd0.b i;
    public final c j;
    public final d k;
    public final e l;
    public final LinkPipelineManager$mRtcInfoListener$1 m;
    public final LinkPipelineManager$mMsgListener$1 n;
    public final Context o;
    public final bc6.a p;
    public final wb6.a q;
    public final ac6.a r;
    public final yb6.e s;
    public final bn0.b t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livelink/multilink/pipeline/LinkPipelineManager$LinkSuccessSource;", "", "NORMAL", "ADVANCE_RTC", "ADVANCE_SERVER", "multi-link-service-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkSuccessSource extends Enum<LinkSuccessSource> {
        public static final LinkSuccessSource ADVANCE_RTC = null;
        public static final LinkSuccessSource ADVANCE_SERVER = null;
        public static final LinkSuccessSource NORMAL = null;
        public static final /* synthetic */ LinkSuccessSource[] a = null;

        static {
            LinkSuccessSource r1 = new LinkSuccessSource("NORMAL", 0);
            NORMAL = r1;
            LinkSuccessSource r2 = new LinkSuccessSource("ADVANCE_RTC", 1);
            ADVANCE_RTC = r2;
            LinkSuccessSource r3 = new LinkSuccessSource("ADVANCE_SERVER", 2);
            ADVANCE_SERVER = r3;
            a = new LinkSuccessSource[]{r1, r2, r3};
        }

        public static LinkSuccessSource valueOf(String r1) {
            return (LinkSuccessSource) r27.a.a(LinkSuccessSource.class, r1);
        }

        public static LinkSuccessSource[] values() {
            return (LinkSuccessSource[]) a.clone();
        }

        public LinkSuccessSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final Object b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            Object r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "PipelineMessage(what=" + this.a + ", obj=" + this.b + ")";
        }

        public b(int r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements hd0.d<Integer> {
        public final /* synthetic */ LinkPipelineManager a;

        public c(LinkPipelineManager r1) {
            this.a = r1;
        }

        @Override // hd0.d
        public final void onChanged(Integer r8) {
            Integer r9 = r8;
            if (r9 == null) goto L12;
            int r10 = r9.intValue();
            LinkMonitor.a("PipeLineM", "LinkPlayerStateChange", "last " + this.a.g + "  current " + r10, null, null, false, 88);
            LinkPipelineManager r0 = this.a;
            if (r0.g != 1) goto L10;
            if (r10 != 0) goto L10;
            r0.N0("cancelApply");
            this.a.v0().a("linker canceled apply");
            MultiLinkConfig r1 = this.a.b;
            if (r1 == null) goto L10;
            r1.b("linker canceled apply");
        L10:
            this.a.g = r10;
            return;
        }
    }

    public static final class d implements u {
        public final /* synthetic */ LinkPipelineManager a;

        public d(LinkPipelineManager r1) {
            this.a = r1;
        }

        public final void X1(int r3, int r4, Exception r5) {
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((xb6.f) r2.next()).a.X1(r3, r4, r5);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public final void q2(int r3, int r4, int r5) {
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((xb6.f) r2.next()).a.q2(r3, r4, r5);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class e implements yb6.i {
        public final /* synthetic */ LinkPipelineManager a;

        public final void s1() {
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((xb6.f) r2.next()).a.s1();
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public final void t1() {
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((xb6.f) r2.next()).a.t1();
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public e(LinkPipelineManager r1) {
            this.a = r1;
        }

        public final void I2(ei6.a r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "client");
            Intrinsics.checkNotNullParameter(r4, "source");
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((xb6.f) r2.next()).a.I2(r3, r4);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public final void t5(ec6.a r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "client");
            Intrinsics.checkNotNullParameter(r4, "source");
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((xb6.f) r2.next()).a.t5(r3, r4);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class f implements wb6.a.a {
        public final /* synthetic */ LinkPipelineManager a;

        public f(LinkPipelineManager r1) {
            this.a = r1;
        }

        public final void U8(long r12, ExtraResponse<IApplyResult, Extra> r14) {
            Intrinsics.checkNotNullParameter(r14, "response");
            this.a.h.Pd((int) r14.data.getWaitingListOffset());
            LinkMonitor.l = r12;
            boolean r2 = true;
            if (r14.data.getAutoJoin() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            LinkMonitor.h = r0;
            LinkMonitor.a("PipeLineM", "startApplyApi", "[duration] onApplySuccess " + r12, null, null, true, 56);
            MultiLinkConfig r1 = this.a.b;
            if (r1 == null) goto L16;
            CopyOnWriteArraySet r3 = r1.k;
            if (r3 == null) goto L16;
            Iterator r4 = r3.iterator();
        L14:
            if (r4.hasNext() == false) goto L16;
            ((xb6.f) r4.next()).a.U8(r12, r14);
        L16:
            com.bytedance.android.live.liveinteract.plantform.model.g r13 = r14.data.getEarlyInitRtInfo();
            if (r13 == null) goto L71;
            j1 r15 = r13.getMediaInfo();
            if (r15 == null) goto L31;
            String r16 = r15.getLiveCoreExtInfo();
            if (r16 == null) goto L31;
            if ((!StringsKt.isBlank(r16)) != true) goto L31;
            j1 r17 = r13.getMediaInfo();
            if (r17 == null) goto L31;
            String r18 = r17.getRtcExtInfo();
            if (r18 == null) goto L31;
            if ((!StringsKt.isBlank(r18)) != true) goto L31;
            boolean r19 = true;
        L32:
            v1 r5 = null;
            if (r19 == true) goto L36;
            r13 = null;
        L36:
            if (r13 == null) goto L71;
            ReadOnlyProperty r110 = vm2.i.n;
            KProperty[] r6 = vm2.i.a;
            boolean r111 = ((Boolean) r110.getValue(null, r6[12])).booleanValue();
            boolean r7 = ((Boolean) vm2.i.m.getValue(null, r6[11])).booleanValue();
            LinkMonitor.a("PipeLineM", "startApplyApi", "isAutoJoin " + r14.data.getAutoJoin() + " autoApplyEarlyInitSetting is " + r111 + " waitingApplyEarlyInitSetting is " + r7, null, null, false, 120);
            if (r14.data.getAutoJoin() == true) goto L40;
        L42:
            boolean r8 = false;
        L43:
            LinkMonitor.h = r8;
            if (r14.data.getAutoJoin() == true) goto L46;
        L49:
            if (r7 == false) goto L51;
            this.a.v0().e(true, "waiting link early init");
        L51:
            cc6.c r112 = this.a.v0();
            if (r112.g.get() == false) goto L54;
        L57:
            if (r2 == false) goto L72;
            tc0.b r113 = this.a.h;
            j1 r114 = r13.getMediaInfo();
            if (r114 == null) goto L61;
            String r115 = r114.getLiveCoreExtInfo();
        L62:
            r113.setLiveCoreExtInfo(r115);
            tc0.b r116 = this.a.h;
            j1 r117 = r13.getMediaInfo();
            if (r117 == null) goto L66;
            String r118 = r117.getRtcExtInfo();
            if (r118 == null) goto L66;
        L67:
            r116.setRtcExtInfo(r118);
            tc0.b r119 = this.a.h;
            j1 r120 = r13.getMediaInfo();
            if (r120 == null) goto L70;
            r5 = r120.getMultiRtcInfo();
        L70:
            r119.setMultiRtcInfo(r5);
            this.a.J0("ApplyResp");
            this.a.K0("ApplyResp");
        L66:
            r118 = "";
            goto L67
        L61:
            r115 = null;
        L72:
            this.a.v0().b(false, "apply req success wait permit msg reset apply state");
            return;
        L54:
            if (r112.j.get() == true) goto L57;
            r2 = false;
            goto L57
        L46:
            if (r14.data.getAutoJoinFull() == true) goto L49;
            if (r111 == false) goto L51;
            this.a.v0().d(true, "auto link early init");
            goto L51
        L40:
            if (r14.data.getAutoJoinFull() == true) goto L42;
            r8 = true;
        L31:
            r19 = false;
        L71:
            LinkMonitor.a("PipeLineM", "startApplyApi", "invalid early init data in apply resp", null, null, false, 120);
            goto L72
        L5:
            if (r14.data.getAutoJoinFull() == true) goto L7;
            r0 = true;
            goto L8
        }

        public final void Wb(long r9, Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            LinkMonitor.a("PipeLineM", "startApplyApi", "OnApplyFailed " + r11, null, null, true, 56);
            this.a.v0().b(false, "apply req failed");
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L10;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((xb6.f) r2.next()).a.Wb(r9, r11);
        L10:
            JSONObject r10 = new JSONObject();
            nd0.c.a.getClass();
            nd0.c.t(r11, r10);
            LinkPipelineManager r12 = this.a;
            cc6.b.a r13 = cc6.b.a.c;
            ((cc6.b) r13).a = r10.optLong("error_code", ((cc6.b) r13).a);
            String r14 = r10.optString("error_msg", ((cc6.b) r13).b);
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            ((cc6.b) r13).b = r14;
            Unit r15 = Unit.INSTANCE;
            LinkPipelineManager.u0(r12, r13);
        }
    }

    public static final class g implements bc6.b {
        public final /* synthetic */ MultiLinkConfig a;
        public final /* synthetic */ OperateType b;
        public final /* synthetic */ LinkPipelineManager c;

        public final void W(long r9, OperateType r11) {
            Intrinsics.checkNotNullParameter(r11, "operationType");
            LinkMonitor.a("PipeLineM", "OnPermissionCheckSuccess", " duration " + r9, null, null, true, 56);
            Iterator r0 = this.a.k.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((xb6.f) r0.next()).a.W(r9, r11);
            goto L4
        L6:
            int r10 = com.bytedance.android.live.livelink.multilink.pipeline.a.c[r11.ordinal()];
            if (r10 != 1) goto L9;
            this.c.H0();
            return;
        L9:
            if (r10 != 2) goto L11;
            this.c.M0();
            return;
        L11:
            if (r10 == 3) goto L14;
            LinkMonitor.a("PipeLineM", "operationType unsupported " + this.b, null, null, null, false, 60);
            this.c.v0().a("unsupported operationType " + r11 + " ignore current permission check");
            return;
        L14:
            this.c.L0();
        }

        public g(MultiLinkConfig r1, OperateType r2, LinkPipelineManager r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void c1(long r9, OperateType r11, BaseCheckException r12) {
            Intrinsics.checkNotNullParameter(r11, "operationType");
            Intrinsics.checkNotNullParameter(r12, "exception");
            LinkMonitor.a("PipeLineM", "OnPermissionCheckFailed", String.valueOf(r12), null, null, false, 120);
            MultiLinkConfig r0 = this.c.b;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.k;
            if (r1 == null) goto L10;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((xb6.f) r2.next()).a.c1(r9, r11, r12);
        L10:
            LinkPipelineManager r10 = this.c;
            cc6.b.b r13 = cc6.b.b.c;
            String r14 = r12.getMessage();
            if (r14 != null) goto L13;
        L18:
            Unit r15 = Unit.INSTANCE;
            LinkPipelineManager.u0(r10, r13);
            if (com.bytedance.android.live.livelink.multilink.pipeline.a.d[r11.ordinal()] != 1) goto L27;
            MultiLinkConfig r16 = this.c.b;
            if (r16 == null) goto L24;
            r16.h = ReplyType.Reject.ordinal();
        L24:
            this.c.M0();
            return;
        L27:
            return;
        L13:
            if ((!StringsKt.isBlank(r14)) == true) goto L16;
            r14 = null;
        L16:
            if (r14 == null) goto L18;
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            ((cc6.b) r13).b = r14;
            goto L18
        }
    }

    public static final class h implements yb6.f {
        public final /* synthetic */ MultiLinkConfig a;
        public final /* synthetic */ LinkPipelineManager b;
        public final /* synthetic */ String c;

        public final ec6.a O2(String r3) {
            Intrinsics.checkNotNullParameter(r3, "liveCoreSetting");
            Iterator r0 = this.a.k.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            ec6.a r1 = ((xb6.f) r0.next()).a.O2(r3);
            if (r1 == null) goto L4;
            return r1;
        L8:
            return null;
        }

        public final void lf(long r9, Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            LinkMonitor.a("PipeLineM", "startInitLiveClient", "OnLiveClientInitFailed " + r11, null, null, true, 56);
            Iterator r0 = this.a.k.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((xb6.f) r0.next()).a.lf(r9, r11);
            goto L4
        L6:
            LinkPipelineManager r10 = this.b;
            cc6.b.d r12 = cc6.b.d.c;
            String r13 = r11.getMessage();
            if (r13 != null) goto L9;
        L14:
            Unit r14 = Unit.INSTANCE;
            LinkPipelineManager.u0(r10, r12);
            return;
        L9:
            if ((!StringsKt.isBlank(r13)) == true) goto L12;
            r13 = null;
        L12:
            if (r13 == null) goto L14;
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            ((cc6.b) r12).b = r13;
            goto L14
        }

        public final void u4(long r9, ec6.a r11) {
            Intrinsics.checkNotNullParameter(r11, "client");
            LinkMonitor.a("PipeLineM", "startInitLiveClient", "[source] " + this.c + " [duration] OnLiveClientInitSuccess " + r9, null, null, true, 56);
            InteractLinkFullLinkMonitor.k(r9);
            Iterator r0 = this.a.k.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((xb6.f) r0.next()).a.u4(r9, r11);
            goto L4
        }

        public h(MultiLinkConfig r1, LinkPipelineManager r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class i implements yb6.k {
        public final /* synthetic */ MultiLinkConfig a;
        public final /* synthetic */ LinkPipelineManager b;
        public final /* synthetic */ String c;

        public final void Zk(long r22, ei6.a r24) {
            Intrinsics.checkNotNullParameter(r24, "client");
            Set<Long> r4 = InteractLinkFullLinkMonitor.a;
            if (r22 > 0) goto L5;
        L18:
            LinkMonitor.a("PipeLineM", "startInitRtcClient", "[source] " + this.c + " [duration] OnRtcClientInitSuccess duration " + r22, null, null, true, 56);
            Iterator r5 = this.a.k.iterator();
        L20:
            if (r5.hasNext() == false) goto L22;
            ((xb6.f) r5.next()).a.Zk(r22, r24);
            goto L20
        L22:
            return;
        L5:
            if (r22 > 15000) goto L18;
            JSONObject r6 = new JSONObject();
            r6.put("duration", r22);
            InteractLinkFullLinkMonitor.a(r6);
            if (InteractLinkFullLinkMonitor.f == false) goto L12;
            MultiTraceData$TraceEvent r7 = MultiTraceData$TraceEvent.AudienceApplyLink;
        L10:
            MultiTraceData$TraceEvent r8 = r7;
            if (r8 == null) goto L17;
            int r9 = rd0.a.a;
            rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, r8, "init_rtc_client", 0, null, r6, 88);
        L17:
            nd0.c.o(nd0.c.a, LinkMonitorData.InitRtcClient, r6, 0, null, false, 28);
            goto L18
        L12:
            if (InteractLinkFullLinkMonitor.g == false) goto L14;
            r7 = MultiTraceData$TraceEvent.InviteAudienceLink;
            goto L10
        L14:
            r7 = null;
            goto L10
        }

        public final void uf(long r9, Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            LinkMonitor.a("PipeLineM", "startInitRtcClient", "OnRtcClientInitFailed" + r11, null, null, true, 56);
            Iterator r0 = this.a.k.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((xb6.f) r0.next()).a.uf(r9, r11);
            goto L4
        L6:
            LinkPipelineManager r10 = this.b;
            cc6.b.f r12 = cc6.b.f.c;
            String r13 = r11.getMessage();
            if (r13 != null) goto L9;
        L14:
            Unit r14 = Unit.INSTANCE;
            LinkPipelineManager.u0(r10, r12);
            return;
        L9:
            if ((!StringsKt.isBlank(r13)) == true) goto L12;
            r13 = null;
        L12:
            if (r13 == null) goto L14;
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            ((cc6.b) r12).b = r13;
            goto L14
        }

        public i(MultiLinkConfig r1, LinkPipelineManager r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class j implements wb6.a.c {
        public final /* synthetic */ MultiLinkConfig a;
        public final /* synthetic */ LinkPipelineManager b;

        public j(MultiLinkConfig r1, LinkPipelineManager r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void C2(long r12, ExtraResponse<? extends IJoinChannelResult, Extra> r14) {
            Intrinsics.checkNotNullParameter(r14, "response");
            String r5 = ((IJoinChannelResult) r14.data).getToken();
            Long r6 = Long.valueOf(((IJoinChannelResult) r14.data).getVersion());
            List r0 = ((IJoinChannelResult) r14.data).getLinkedUsers();
            if (r0 == null) goto L5;
            String r1 = r0.toString();
        L6:
            InteractLinkFullLinkMonitor.r(r5, r6, r1, r12, r14.logId);
            this.b.x0(this.a, r12, r14, "join channel api");
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void o1(long r9, Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            LinkMonitor.a("PipeLineM", "OnJoinChannelFailed", String.valueOf(r11), null, null, false, 120);
            InteractLinkFullLinkMonitor.q(r9, r11);
            Iterator r0 = this.a.k.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((xb6.f) r0.next()).a.o1(r9, r11);
            goto L4
        L6:
            JSONObject r10 = new JSONObject();
            nd0.c.a.getClass();
            nd0.c.t(r11, r10);
            LinkPipelineManager r12 = this.b;
            cc6.b.c r13 = cc6.b.c.c;
            ((cc6.b) r13).a = r10.optLong("error_code", ((cc6.b) r13).a);
            String r14 = r10.optString("error_msg", ((cc6.b) r13).b);
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            ((cc6.b) r13).b = r14;
            Unit r15 = Unit.INSTANCE;
            LinkPipelineManager.u0(r12, r13);
        }
    }

    public static final class k implements wb6.a.h {
        public final /* synthetic */ MultiLinkConfig a;
        public final /* synthetic */ LinkPipelineManager b;
        public final /* synthetic */ Map c;

        public final void Fk(long r12, Throwable r14) {
            Intrinsics.checkNotNullParameter(r14, "throwable");
            LinkMonitor.a("PipeLineM", "startReplyApi", "OnReplyFailed " + r14, null, null, false, 120);
            MultiLinkConfig r0 = this.a;
            String r1 = r0.f;
            int r2 = r0.h;
            Set<Long> r3 = InteractLinkFullLinkMonitor.a;
            Intrinsics.checkNotNullParameter(r1, "secToUserId");
            JSONObject r4 = new JSONObject();
            r4.put("sec_to_user_id", r1);
            r4.put("reply_type", r2);
            InteractLinkFullLinkMonitor.a(r4);
            InteractLinkFullLinkMonitor.d = 0;
            InteractLinkFullLinkMonitor.g = false;
            nd0.c r5 = nd0.c.a;
            r5.getClass();
            Pair r6 = nd0.c.t(r14, r4);
            int r7 = rd0.a.a;
            rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "replyInvite", ((Number) r6.getFirst()).intValue(), (String) r6.getSecond(), r4, 64);
            nd0.c.r(r5, LinkMonitorData.Reply, null, r12, r14, r4, 34);
            MultiLinkConfig r8 = this.b.b;
            if (r8 == null) goto L10;
            CopyOnWriteArraySet r9 = r8.k;
            if (r9 == null) goto L10;
            Iterator r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L10;
            ((xb6.f) r10.next()).a.Fk(r12, r14);
        L10:
            JSONObject r13 = new JSONObject();
            nd0.c.a.getClass();
            nd0.c.t(r14, r13);
            LinkPipelineManager r15 = this.b;
            cc6.b.e r16 = cc6.b.e.c;
            ((cc6.b) r16).a = r13.optLong("error_code", ((cc6.b) r16).a);
            String r17 = r13.optString("error_msg", ((cc6.b) r16).b);
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            ((cc6.b) r16).b = r17;
            Unit r18 = Unit.INSTANCE;
            LinkPipelineManager.u0(r15, r16);
        }

        public final void wn(long r20, ExtraResponse<m, Extra> r22) {
            Intrinsics.checkNotNullParameter(r22, "response");
            LinkMonitor.k = r20;
            MultiLinkConfig r1 = this.a;
            String r2 = r1.f;
            int r3 = r1.h;
            String r6 = r22.logId;
            Set<Long> r4 = InteractLinkFullLinkMonitor.a;
            Intrinsics.checkNotNullParameter(r2, "secToUserId");
            Intrinsics.checkNotNullParameter(r6, "logId");
            JSONObject r7 = new JSONObject();
            r7.put("sec_to_user_id", r2);
            r7.put("reply_type", r3);
            int r5 = rd0.a.a;
            rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "replyInvite", 0, null, r7, 88);
            nd0.c.s(nd0.c.a, LinkMonitorData.Reply, null, r20, r6, r7, 98);
            LinkMonitor.a("PipeLineM", "startReplyApi", "[duration] onReplySuccess duration " + r20, null, null, true, 56);
            MultiLinkConfig r8 = this.b.b;
            if (r8 == null) goto L11;
            CopyOnWriteArraySet r9 = r8.k;
            if (r9 == null) goto L11;
            Iterator r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L11;
            ((xb6.f) r10.next()).a.wn(r20, r22);
        L11:
            if (this.a.h != ReplyType.Agree.ordinal()) goto L24;
            LinkPipelineManager r11 = this.b;
            r11.e = null;
            r11.v0().i(false, "reset before check reply resp");
            com.bytedance.android.live.liveinteract.plantform.model.h r12 = r22.data.getEarlyJoinChannelData();
            if (r12 != null) goto L15;
        L22:
            this.b.L0();
            return;
        L15:
            if (r12.getAlreadyJoinChannel() != true) goto L22;
            this.b.v0().i(true, "reply resp alreadyJoinChannel is true");
            com.bytedance.android.live.liveinteract.plantform.model.h r13 = r22.data.getEarlyJoinChannelData();
            if (r13 == null) goto L21;
            vh7.e r14 = r13.getJoinChannelResp();
            if (r14 == null) goto L21;
            this.b.e = k97.a.a(r14, r22.extra, r22.logId);
        L21:
            LinkMonitor.a("PipeLineM", "invalid early join channel parameter " + r22.logId, null, null, null, false, 124);
            goto L22
        L24:
            if (this.a.h != ReplyType.Reject.ordinal()) goto L31;
            this.b.N0("RejectReply");
            this.b.v0().a("reject invite, reset link state");
            MultiLinkConfig r15 = this.b.b;
            if (r15 == null) goto L32;
            r15.b("reject invite reset!");
            return;
        L32:
            return;
        }

        public k(MultiLinkConfig r1, LinkPipelineManager r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class l implements yb6.m {
        public final /* synthetic */ LinkPipelineManager a;

        public final void E2() {
            MultiLinkConfig r0 = this.a.b;
            if (r0 == null) goto L8;
            Iterator r1 = r0.k.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((xb6.f) r1.next()).a.E2();
            goto L6
        L10:
            return;
        }

        public l(LinkPipelineManager r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final cc6.c v0() {
        return (cc6.c) this.c.getValue();
    }

    public final boolean D0() {
        if (this.g == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.s.K().e == false) goto L7;
        return true;
    }

    public final void H0() {
        LinkMonitor.a("PipeLineM", "startApplyApi", null, null, null, true, 60);
        MultiLinkConfig r1 = this.b;
        if (r1 == null) goto L19;
        CopyOnWriteArraySet r2 = r1.j;
        if (r2 == null) goto L19;
        Iterator r3 = r2.iterator();
        boolean r4 = false;
    L8:
        if (r3.hasNext() == false) goto L20;
        Pair r5 = ((xb6.e) r3.next()).a.b();
        Object r6 = r5.getSecond();
        if ((!StringsKt.isBlank((String) r6)) == true) goto L14;
        r6 = null;
    L14:
        if (((String) r6) == null) goto L8;
        if (((Boolean) r5.getFirst()).booleanValue() == true) goto L17;
        LinkMonitor.a("PipeLineM", "startApplyApi", "apply intercepted false by " + ((String) r5.getSecond()), null, null, false, 88);
        goto L8
    L17:
        LinkMonitor.a("PipeLineM", "startApplyApi", "apply intercepted true by " + ((String) r5.getSecond()), null, null, true, 56);
        r4 = true;
    L20:
        if (r4 == false) goto L25;
        v0().b(false, "apply req intercepted");
        MultiLinkConfig r7 = this.b;
        if (r7 == null) goto L77;
        r7.b("apply req intercepted");
        return;
    L77:
        return;
    L25:
        boolean r8 = LinkMonitor.h;
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        LinkMonitor.b = SystemClock.elapsedRealtime();
        LinkedHashMap r10 = new LinkedHashMap();
        MultiLinkConfig r9 = this.b;
        if (r9 == null) goto L36;
        CopyOnWriteArraySet r11 = r9.i;
        if (r11 == null) goto L36;
        Iterator r12 = r11.iterator();
    L31:
        if (r12.hasNext() == false) goto L36;
        String r13 = ((xb6.d) r12.next()).a.e(r10);
        if ((!r10.isEmpty()) == false) goto L31;
        LinkMonitor.a("PipeLineM", "startApplyApi", "inject api params " + r10 + " from " + r13, null, null, false, 88);
    L36:
        if (vm2.i.i() == false) goto L38;
        String r14 = "1";
    L39:
        r10.put("live_multi_link_enable_link_opt_v4", r14);
        v0().d(false, "resetBeforeApply");
        v0().e(false, "resetBeforeApply");
        wb6.a r15 = this.q;
        MultiLinkConfig r16 = this.b;
        if (r16 == null) goto L42;
        long r17 = r16.n;
    L43:
        long r18 = r17;
        if (r16 == null) goto L47;
        String r19 = r16.o;
        if (r19 == null) goto L47;
    L48:
        r15.R(r18, r19, r10, new f(this));
        if (vm2.i.i() == false) goto L78;
        tc0.b r20 = this.h;
        if (r20 == null) goto L79;
        String r21 = r20.getRtcExtInfo();
        if (r21 != null) goto L55;
        return;
    L55:
        if ((!StringsKt.isBlank(r21)) != true) goto L81;
        tc0.b r22 = this.h;
        if (r22 == null) goto L82;
        String r23 = r22.getLiveCoreExtInfo();
        if (r23 != null) goto L61;
        return;
    L61:
        if ((!StringsKt.isBlank(r23)) != true) goto L84;
        J0("StartApply");
        K0("StartApply");
        return;
    L84:
        return;
    L82:
        return;
    L81:
        return;
    L79:
        return;
    L78:
        return;
    L47:
        r19 = "";
        goto L48
    L42:
        r17 = 0;
        goto L43
    L38:
        r14 = "0";
    L19:
        r4 = false;
        goto L20
    }

    public final void I0() {
        LinkMonitor.a("PipeLineM", "startCheckLinkPermission", null, null, null, false, 124);
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L17;
        MultiLinkConfig.LinkSource r1 = r0.a;
        int r2 = com.bytedance.android.live.livelink.multilink.pipeline.a.b[r1.ordinal()];
        if (r2 != 1) goto L7;
        OperateType r3 = OperateType.APPLY;
    L15:
        this.p.E(this.o, r3, r0.e, new g(r0, r3, this));
        return;
    L7:
        if (r2 != 2) goto L9;
        r3 = OperateType.REPLY;
        goto L15
    L9:
        if (r2 == 3) goto L12;
        LinkMonitor.a("PipeLineM", "unknown link source ignore!", null, null, null, false, 124);
        v0().a("check link permission with unknown link source");
        return;
    L12:
        r3 = OperateType.JOIN;
        goto L15
    }

    public final void L0() {
        if (v0().f.get() == false) goto L5;
    L54:
        LinkMonitor.a("PipeLineM", "startJoinChannelReq", "ignore current req isJoiningChannel " + v0().f.get() + " joinChannelFinish " + v0().e.get(), null, null, false, 120);
        return;
    L5:
        if (v0().e.get() == true) goto L54;
        LinkMonitor.a("PipeLineM", "startJoinChannelReq", null, null, null, false, 124);
        v0().h(true, "startJoinChannelReq");
        boolean r3 = false;
        v0().g(false, "startJoinChannelReq");
        this.d = "";
        MultiLinkConfig r2 = this.b;
        if (r2 == null) goto L70;
        com.bytedance.android.live.network.response.d.b r4 = this.f;
        if (r4 == null) goto L13;
        x0(r2, 0, r4, "permit join channel");
        return;
    L13:
        ExtraResponse<? extends IJoinChannelResult, Extra> r5 = this.e;
        if (r5 == null) goto L17;
        x0(r2, 0, r5, "reply join channel");
        return;
    L17:
        Iterator r6 = r2.j.iterator();
        String r7 = "";
    L18:
        xb6.c r8 = null;
        Object r9 = null;
        if (r6.hasNext() == false) goto L29;
        Pair r10 = ((xb6.e) r6.next()).a.e();
        Object r11 = r10.getSecond();
        if ((!StringsKt.isBlank((String) r11)) == false) goto L24;
        r9 = r11;
    L24:
        if (((String) r9) == null) goto L18;
        if (((Boolean) r10.getFirst()).booleanValue() == true) goto L27;
        LinkMonitor.a("PipeLineM", "startJoinChannelReq", "join channel intercepted false by " + ((String) r10.getSecond()), null, null, false, 88);
        goto L18
    L27:
        r7 = (String) r10.getSecond();
        LinkMonitor.a("PipeLineM", "startJoinChannelReq", "join channel intercepted true by " + ((String) r10.getSecond()), null, null, true, 56);
        r3 = true;
        goto L18
    L29:
        if (r3 == false) goto L34;
        v0().a("join channel req intercepted " + r7);
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L69;
        r0.b("join channel req intercepted " + r7);
        return;
    L69:
        return;
    L34:
        LinkedHashMap r12 = new LinkedHashMap();
        MultiLinkConfig r13 = this.b;
        if (r13 == null) goto L44;
        CopyOnWriteArraySet r14 = r13.i;
        if (r14 == null) goto L44;
        Iterator r15 = r14.iterator();
    L40:
        if (r15.hasNext() == false) goto L44;
        ((xb6.d) r15.next()).a.a(r12);
        if ((!r12.isEmpty()) == false) goto L40;
        LinkMonitor.a("PipeLineM", "startJoinChannelReq", "inject join channel api params " + r12 + " from ", null, null, false, 88);
    L44:
        MultiLinkConfig r1 = this.b;
        if (r1 == null) goto L47;
        xb6.c r16 = r1.l;
    L48:
        if (r16 == null) goto L52;
        if (r1 == null) goto L51;
        r8 = r1.l;
    L51:
        Intrinsics.checkNotNull(r8);
        x0(r2, 0, k97.a.a(r8.getPreRtcInfo(), new Extra(), ""), "join channel pre");
        return;
    L52:
        InteractLinkFullLinkMonitor.p();
        this.q.i0(r2.n, r12, new j(r2, this));
        return;
    L47:
        r16 = null;
        goto L48
    }

    public final void M0() {
        LinkMonitor.a("PipeLineM", "startReplyApi", null, null, null, true, 60);
        MultiLinkConfig r1 = this.b;
        if (r1 == null) goto L38;
        CopyOnWriteArraySet r2 = r1.j;
        if (r2 == null) goto L38;
        Iterator r3 = r2.iterator();
        boolean r6 = false;
    L8:
        if (r3.hasNext() == false) goto L39;
        xb6.b r8 = ((xb6.e) r3.next()).a;
        MultiLinkConfig r7 = this.b;
        if (r7 == null) goto L12;
        long r9 = r7.n;
    L14:
        if (r7 == null) goto L17;
        String r12 = r7.f;
        if (r12 == null) goto L17;
    L18:
        if (r7 == null) goto L21;
        String r13 = r7.g;
        if (r13 == null) goto L21;
    L22:
        if (r7 == null) goto L24;
        int r14 = r7.h;
    L25:
        if (r7 == null) goto L27;
        int r10 = r7.e;
    L28:
        Pair r11 = r8.i(r9, r12, r13, r14, r10);
        Object r15 = r11.getSecond();
        if ((!StringsKt.isBlank((String) r15)) == true) goto L33;
        r15 = null;
    L33:
        if (((String) r15) == null) goto L8;
        if (((Boolean) r11.getFirst()).booleanValue() == true) goto L36;
        LinkMonitor.a("PipeLineM", "startReplyApi", "reply intercepted false by " + ((String) r11.getSecond()), null, null, false, 88);
        goto L8
    L36:
        LinkMonitor.a("PipeLineM", "startReplyApi", "reply intercepted true by " + ((String) r11.getSecond()), null, null, true, 56);
        r6 = true;
        goto L8
    L27:
        r10 = 0;
        goto L28
    L24:
        r14 = 0;
    L21:
        r13 = "";
    L17:
        r12 = "";
        goto L18
    L12:
        r9 = 0;
    L39:
        if (r6 == false) goto L44;
        v0().c(false, "reply req intercepted");
        MultiLinkConfig r4 = this.b;
        if (r4 == null) goto L91;
        r4.b("reply req intercepted");
        return;
    L91:
        return;
    L44:
        boolean r5 = LinkMonitor.h;
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        LinkMonitor.a = SystemClock.elapsedRealtime();
        LinkedHashMap r16 = new LinkedHashMap();
        MultiLinkConfig r17 = this.b;
        if (r17 == null) goto L55;
        CopyOnWriteArraySet r18 = r17.i;
        if (r18 == null) goto L55;
        Iterator r19 = r18.iterator();
    L50:
        if (r19.hasNext() == false) goto L55;
        String r20 = ((xb6.d) r19.next()).a.d(r16);
        if ((!r16.isEmpty()) == false) goto L50;
        LinkMonitor.a("PipeLineM", "startReplyApi", "inject reply params " + r16 + " from " + r20, null, null, false, 88);
    L55:
        if (vm2.i.i() == false) goto L57;
        String r21 = "1";
    L58:
        r16.put("live_multi_link_enable_link_opt_v4", r21);
        MultiLinkConfig r22 = this.b;
        if (r22 == null) goto L92;
        String r23 = r22.f;
        String r24 = r22.g;
        int r25 = r22.h;
        Set<Long> r26 = InteractLinkFullLinkMonitor.a;
        Intrinsics.checkNotNullParameter(r23, "secToUserId");
        Intrinsics.checkNotNullParameter(r24, "toUserIdString");
        InteractLinkFullLinkMonitor.g = true;
        i97.a r27 = i97.a.a;
        InteractLinkFullLinkMonitor.d = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.f = false;
        InteractLinkFullLinkMonitor.c = 0;
        JSONObject r28 = new JSONObject();
        r28.put("sec_to_user_id", r23);
        r28.put("to_user_id", r24);
        r28.put("reply_type", r25);
        InteractLinkFullLinkMonitor.a(r28);
        nd0.c.s(nd0.c.a, LinkMonitorData.StartReply, null, 0, "", r28, 98);
        this.q.f0(r22.n, r22.f, r22.g, r22.h, r22.e, r16, new k(r22, this, r16));
        MultiLinkConfig r29 = this.b;
        if (r29 != null) goto L63;
        return;
    L63:
        if (r29.h != ReplyType.Agree.ordinal()) goto L94;
        tc0.b r30 = this.h;
        if (r30 == null) goto L95;
        String r31 = r30.getLiveCoreExtInfo();
        if (r31 != null) goto L69;
        return;
    L69:
        if ((!StringsKt.isBlank(r31)) != true) goto L97;
        tc0.b r32 = this.h;
        if (r32 == null) goto L98;
        String r33 = r32.getRtcExtInfo();
        if (r33 != null) goto L75;
        return;
    L75:
        if ((!StringsKt.isBlank(r33)) != true) goto L100;
        C0(this, false, "StartReplyAgree", 7);
        return;
    L100:
        return;
    L98:
        return;
    L97:
        return;
    L95:
        return;
    L94:
        return;
    L92:
        return;
    L57:
        r21 = "0";
    L38:
        r6 = false;
        goto L39
    }

    public final void attach() {
        this.r.s(this.n);
        this.s.D(this.m);
        this.s.k0(this.k);
        this.s.A(this.l);
        this.i.y8(this.j);
        LinkMonitor.b();
    }

    public final Context getContext() {
        return this.o;
    }

    public final void A0(h1 r15) {
        ILinkerRTCActionContent r16 = r15.getRtcActionContent();
        if (r16 == null) goto L60;
        boolean r1 = false;
        if (r16.getActionType() != 1) goto L7;
        boolean r0 = true;
    L8:
        String r3 = null;
        if (r0 == true) goto L12;
        r16 = null;
    L12:
        if (r16 == null) goto L61;
        ILinkerRTCActionJoinRTCContent r2 = r16.getJoinRtcContent();
        if (r2 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        LinkMonitor.a("PipeLineM", "handleRtcActionMsg", "canJoinRtc " + r4, null, null, true, 56);
        ILinkerRTCActionJoinRTCContent r5 = r16.getJoinRtcContent();
        if (r5 == null) goto L22;
        String r6 = r5.getLiveCoreExtInfo();
    L23:
        ILinkerRTCActionJoinRTCContent r17 = r16.getJoinRtcContent();
        if (r17 == null) goto L26;
        String r18 = r17.getRtcExtInfo();
    L27:
        tc0.b r7 = this.h;
        if (r7 == null) goto L30;
        String r8 = r7.getLiveCoreExtInfo();
    L31:
        tc0.b r9 = this.h;
        if (r9 == null) goto L34;
        r3 = r9.getRtcExtInfo();
    L34:
        if (r4 == true) goto L36;
        return;
    L36:
        if (r8 != null) goto L38;
    L43:
        if (r6 != null) goto L45;
    L56:
        LinkMonitor.a("PipeLineM", "handleRtcActionMsg", "no valid media info livecore " + r8 + " rtc " + r3, null, null, true, 56);
    L57:
        if (r1 == false) goto L63;
        B0(false, false, false, false, "RtcActionMsg");
        return;
    L63:
        return;
    L45:
        if ((!StringsKt.isBlank(r6)) != true) goto L56;
        if (r18 == null) goto L56;
        if ((!StringsKt.isBlank(r18)) != true) goto L56;
        LinkMonitor.a("PipeLineM", "handleRtcActionMsg", "current media info is invalid, msg media info is valid livecoreInfo " + r6 + " rtcInfo " + r18, null, null, false, 120);
        tc0.b r10 = this.h;
        if (r10 == null) goto L52;
        r10.setLiveCoreExtInfo(r6);
    L52:
        tc0.b r11 = this.h;
        if (r11 == null) goto L55;
        r11.setRtcExtInfo(r18);
    L55:
        r1 = true;
        goto L57
    L38:
        if ((!StringsKt.isBlank(r8)) != true) goto L43;
        if (r3 == null) goto L43;
        if ((!StringsKt.isBlank(r3)) != true) goto L43;
        LinkMonitor.a("PipeLineM", "handleRtcActionMsg", "current media info is valid livecoreInfo" + r8 + " rtcInfo " + r3, null, null, false, 120);
        goto L55
    L30:
        r8 = null;
        goto L31
    L26:
        r18 = null;
        goto L27
    L22:
        r6 = null;
        goto L23
    L16:
        if (r2.getCanJoinRtcAdvance() != true) goto L18;
        r4 = true;
        goto L19
    L61:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void E0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if (this.s.O().b == false) goto L5;
    L6:
        this.s.l0();
        return;
    L5:
        if (this.s.O().a == true) goto L6;
    }

    public final void F0(LinkSuccessSource r14) {
        LinkMonitor.a("PipeLineM", "LinkSuccess", String.valueOf(r14), null, null, true, 56);
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.k;
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((xb6.f) r2.next()).a.k4();
    L10:
        MultiLinkConfig r3 = this.b;
        if (r3 == null) goto L20;
        CopyOnWriteArraySet r4 = r3.j;
        if (r4 == null) goto L20;
        Iterator r5 = r4.iterator();
        boolean r6 = false;
    L16:
        if (r5.hasNext() == false) goto L22;
        xb6.e r7 = (xb6.e) r5.next();
        if (((Boolean) r7.a.k().getFirst()).booleanValue() == false) goto L16;
        LinkMonitor.a("PipeLineM", "pushDataIntercepted", (String) r7.a.k().getSecond(), null, null, true, 56);
        r6 = true;
    L22:
        if (r6 == true) goto L24;
        this.s.f("LinkSuccess");
    L24:
        this.s.P(StreamType.AUDIO_VIDEO, "LinkSuccess");
        this.s.g0(true, "LinkSuccess");
        MultiLinkConfig r8 = this.b;
        if (r8 != null) goto L27;
    L31:
        boolean r9 = false;
    L32:
        MultiLinkConfig r10 = this.b;
        if (r10 != null) goto L35;
    L39:
        boolean r11 = false;
    L41:
        if (r9 == true) goto L43;
        if (r11 == true) goto L43;
    L52:
        if (r6 == true) goto L54;
        this.s.j();
    L54:
        com.bytedance.live.kmp.util.d.b(0, false, new LinkPipelineManager$onLinkSuccess$3(this), 7);
        boolean r12 = LinkMonitor.h;
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        LinkMonitor.e = SystemClock.elapsedRealtime();
        MultiLinkConfig r13 = this.b;
        if (r13 == null) goto L76;
        cc6.c r15 = v0();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r13, "linkConfig");
        if (r13.a != MultiLinkConfig.LinkSource.JOIN) goto L60;
        String r16 = "null";
    L75:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        LinkMonitor.i = r16;
        MultiLinkConfig.LinkSource r17 = r13.a;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        LinkMonitor.j = r17;
        goto L76
    L60:
        if (vm2.i.i() == false) goto L63;
        r16 = "link_opt_v4";
        goto L75
    L63:
        if (r15.i.get() == false) goto L65;
    L74:
        r16 = "link_opt_v3";
        goto L75
    L65:
        if (r15.j.get() == true) goto L74;
        if (r15.g.get() == false) goto L70;
    L73:
        r16 = "link_opt_v2";
        goto L75
    L70:
        if (r15.h.get() == true) goto L73;
        r16 = "link_opt_v1";
    L76:
        com.bytedance.revenue.platform.api.core.rx.l r18 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r19 = ((Number) vm2.i.l.getValue(null, vm2.i.a[10])).longValue() * ((long) 1000);
        int r20 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(r19, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.live.livelink.multilink.pipeline.b.a), ((vb6.b) this).a);
        if (r14 != LinkSuccessSource.ADVANCE_RTC) goto L89;
        LinkMonitor.a("PipeLineM", "notifyRtcInfo", null, null, null, false, 124);
        MultiLinkConfig r110 = this.b;
        if (r110 == null) goto L89;
        CopyOnWriteArraySet r111 = r110.k;
        if (r111 == null) goto L89;
        Iterator r112 = r111.iterator();
    L84:
        if (r112.hasNext() == false) goto L89;
        xb6.f r21 = (xb6.f) r112.next();
        ei6.a r22 = this.s.Z0();
        r21.a.vc(r22, 4, 0, new Object[0]);
        Iterator r113 = this.s.m().entrySet().iterator();
    L87:
        if (r113.hasNext() == false) goto L84;
        Map.Entry r23 = (Map.Entry) r113.next();
        String r24 = (String) r23.getKey();
        yb6.j r25 = (yb6.j) r23.getValue();
        r21.a.vc(r22, 11, 0, new Object[]{r24, r25.a, Integer.valueOf(r25.b), Integer.valueOf(r25.c)});
    L89:
        MultiLinkConfig r114 = this.b;
        if (r114 == null) goto L97;
        CopyOnWriteArraySet r115 = r114.k;
        if (r115 == null) goto L97;
        Iterator r116 = r115.iterator();
    L95:
        if (r116.hasNext() == false) goto L97;
        ((xb6.f) r116.next()).a.H1();
    L97:
        LinkMonitor.a("PipeLineM", "startNotifyJoinRtc", null, null, null, true, 60);
        MultiLinkConfig r117 = this.b;
        if (r117 == null) goto L100;
        this.q.p0(r117.n, this.d, new com.bytedance.android.live.livelink.multilink.pipeline.e());
    L100:
        G0("onLinkSuccess");
        return;
    L43:
        yb6.e r26 = this.s;
        tc0.b r27 = this.h;
        if (r27 == null) goto L46;
        String r28 = r27.getLiveCoreExtInfo();
    L47:
        r26.X(r28);
        yb6.e r29 = this.s;
        tc0.b r30 = this.h;
        if (r30 == null) goto L50;
        String r31 = r30.getRtcExtInfo();
    L51:
        r29.c(r31);
        goto L52
    L50:
        r31 = null;
        goto L51
    L46:
        r28 = null;
        goto L47
    L35:
        if (r10.m == true) goto L39;
        if (((LiveLinkMicUpdateLiveCoreParamsConfig) MultiLinkSettingHelper.b.getValue()).getGuestEnable() == false) goto L39;
        r11 = true;
        goto L41
    L27:
        if (r8.m != true) goto L31;
        if (((LiveLinkMicUpdateLiveCoreParamsConfig) MultiLinkSettingHelper.b.getValue()).getAnchorEnable() == false) goto L31;
        r9 = true;
    L20:
        r6 = false;
        goto L22
    }

    public final void G0(String r2) {
        v0().a(r2);
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L5;
        r0.b(r2);
    L5:
        this.f = null;
        this.e = null;
        this.d = "";
    }

    public final void J0(String r23) {
        if (this.s.O().a == false) goto L5;
    L35:
        LinkMonitor.a("PipeLineM", "startInitLiveClient", "ignore init, live client " + this.s.O(), null, null, false, 120);
        return;
    L5:
        if (this.s.O().b == true) goto L35;
        LinkMonitor.a("PipeLineM", "startInitLiveClient", "[source] " + r23, null, null, false, 120);
        MultiLinkConfig r2 = this.b;
        if (r2 == null) goto L50;
        Iterator r3 = r2.j.iterator();
        boolean r4 = false;
        String r5 = "";
    L10:
        Object r8 = null;
        if (r3.hasNext() == false) goto L21;
        Pair r6 = ((xb6.e) r3.next()).a.c();
        Object r9 = r6.getSecond();
        if ((!StringsKt.isBlank((String) r9)) == false) goto L16;
        r8 = r9;
    L16:
        if (((String) r8) == null) goto L10;
        if (((Boolean) r6.getFirst()).booleanValue() == true) goto L19;
        LinkMonitor.a("PipeLineM", "startInitLiveClient", "live client init intercepted false by " + ((String) r6.getSecond()), null, null, false, 88);
        goto L10
    L19:
        r5 = (String) r6.getSecond();
        LinkMonitor.a("PipeLineM", "startInitLiveClient", "live client init intercepted true by " + ((String) r6.getSecond()), null, null, true, 56);
        r4 = true;
        goto L10
    L21:
        if (r4 == false) goto L24;
        v0().a("live client init intercepted " + r5);
        r2.b("live client init intercepted");
        return;
    L24:
        yb6.g r7 = new yb6.g();
        tc0.b r10 = this.h;
        if (r10 == null) goto L27;
        r8 = r10.getLiveCoreExtInfo();
    L27:
        String r11 = String.valueOf(r8);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r7.a = r11;
        Iterator r12 = r2.i.iterator();
    L29:
        if (r12.hasNext() == false) goto L33;
        String r13 = ((xb6.d) r12.next()).a.f(r7);
        if ((!StringsKt.isBlank(r13)) == false) goto L29;
        LinkMonitor.a("PipeLineM", "startInitLiveClient", "inject live client init params " + r7 + " from " + r13, null, null, false, 120);
        goto L29
    L33:
        this.s.H(r7, new h(r2, this, r23));
        return;
    }

    public final void K0(String r24) {
        if (this.s.K().a == false) goto L5;
    L36:
        LinkMonitor.a("PipeLineM", "startInitRtcClient", "ignore init rtc client " + this.s.K(), null, null, false, 120);
        return;
    L5:
        if (this.s.K().b == true) goto L36;
        LinkMonitor.a("PipeLineM", "startInitRtcClient", "[source] ".concat(r24), null, null, false, 120);
        MultiLinkConfig r2 = this.b;
        if (r2 == null) goto L51;
        CopyOnWriteArraySet r3 = r2.j;
        boolean r6 = false;
        if (r3 == null) goto L24;
        Iterator r4 = r3.iterator();
        String r7 = "";
    L13:
        if (r4.hasNext() == false) goto L25;
        Pair r8 = ((xb6.e) r4.next()).a.m();
        Object r9 = r8.getSecond();
        if ((!StringsKt.isBlank((String) r9)) == true) goto L19;
        r9 = null;
    L19:
        if (((String) r9) == null) goto L13;
        if (((Boolean) r8.getFirst()).booleanValue() == true) goto L22;
        LinkMonitor.a("PipeLineM", "startInitRtcClient", "intercept false by " + ((String) r8.getSecond()), null, null, false, 88);
        goto L13
    L22:
        r7 = (String) r8.getSecond();
        LinkMonitor.a("PipeLineM", "startInitRtcClient", "intercept true by " + ((String) r8.getSecond()), null, null, false, 120);
        r6 = true;
    L25:
        if (r6 == false) goto L28;
        v0().a("init rtc client intercepted by " + r7);
        return;
    L28:
        fi6.a r5 = new fi6.a();
        Iterator r10 = r2.i.iterator();
    L30:
        if (r10.hasNext() == false) goto L34;
        ((xb6.d) r10.next()).a.c(r5);
        if ((!StringsKt.isBlank("")) == false) goto L30;
        LinkMonitor.a("PipeLineM", "startInitRtcClient", "inject rtc interact config from ", null, null, false, 120);
        goto L30
    L34:
        this.s.c0(r5, new i(r2, this, r24));
        return;
    L24:
        r7 = "";
        goto L25
    }

    public final void N0(String r23) {
        LinkMonitor.a("PipeLineM", "stopRtcEngine", "[source] " + r23 + " LiveClientState " + this.s.O() + " \n RtcClientState " + this.s.K(), null, null, true, 56);
        if (this.s.K().b == false) goto L5;
    L16:
        MultiLinkConfig r1 = this.b;
        if (r1 == null) goto L46;
        Iterator r2 = r1.j.iterator();
        boolean r3 = false;
    L20:
        if (r2.hasNext() == false) goto L31;
        Pair r4 = ((xb6.e) r2.next()).a.g();
        Object r5 = r4.getSecond();
        if ((!StringsKt.isBlank((String) r5)) == true) goto L26;
        r5 = null;
    L26:
        if (((String) r5) == null) goto L20;
        if (((Boolean) r4.getFirst()).booleanValue() == true) goto L29;
        LinkMonitor.a("PipeLineM", "stopRtcEngine", "intercepted false by " + ((String) r4.getSecond()), null, null, false, 88);
        goto L20
    L29:
        LinkMonitor.a("PipeLineM", "stopRtcEngine", "intercepted true by " + ((String) r4.getSecond()), null, null, true, 56);
        r3 = true;
        goto L20
    L31:
        if (r3 == false) goto L34;
        LinkMonitor.a("PipeLineM", "stopRtcEngine", "stop engine intercepted", null, LinkMonitor.LogLevel.WARN, false, 104);
        v0().f(false, "stop rtc engine intercepted");
        return;
    L34:
        this.s.n();
        return;
    L46:
        return;
    L5:
        if (this.s.K().a == true) goto L16;
        if (this.s.K().e == true) goto L16;
        if (this.s.K().c == true) goto L16;
        v0().f(false, "engine not init");
        LinkMonitor.a("PipeLineM", "stopRtcEngine", "rtc engine not init , check and stop live client", null, null, false, 120);
        if (this.s.O().b == false) goto L14;
    L15:
        this.s.l0();
        return;
    L14:
        if (this.s.O().a == true) goto L15;
    }

    public final void a1(vb6.f r8) {
        LinkMonitor.a("PipeLineM", "removeLinkListener", String.valueOf(r8), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L9;
        r0.a(r8);
        return;
    }

    public final void c1(int r11) {
        LinkMonitor.a("PipeLineM", "joinLink", null, null, null, true, 60);
        if (D0() == false) goto L9;
        LinkMonitor.a("PipeLineM", "already in link when join link", null, null, null, false, 124);
        MultiLinkConfig r12 = this.b;
        if (r12 == null) goto L7;
        r12.b("already in link when join link");
    L7:
        v0().a("already in link when join link");
        return;
    L9:
        cc6.c r0 = v0();
        r0.getClass();
        Intrinsics.checkNotNullParameter("joinLink", "reason");
        LinkMonitor.a("LinkState", "setInJoinLink", " true : joinLink", null, null, false, 120);
        r0.c.set(true);
        MultiLinkConfig r1 = this.b;
        if (r1 == null) goto L12;
        MultiLinkConfig.LinkSource r2 = MultiLinkConfig.LinkSource.JOIN;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.a = r2;
    L12:
        MultiLinkConfig r3 = this.b;
        if (r3 == null) goto L15;
        r3.b = false;
    L15:
        if (r3 == null) goto L17;
        r3.c = r11;
    L17:
        if (r3 == null) goto L19;
        r3.e = 2;
    L19:
        LinkMonitor.a("PipeLineM", "joinLinkConfig", "config" + this.b, null, null, false, 120);
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$joinLink$1(this), 3);
    }

    public final void f1(xb6.b r8) {
        LinkMonitor.a("PipeLineM", "removeLinkInterceptor", String.valueOf(r8), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullParameter(r8, "interceptor");
        Iterator r1 = r0.j.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        xb6.e r2 = (xb6.e) r1.next();
        if (Intrinsics.areEqual(r2.a, r8) == false) goto L9;
        r0.j.remove(r2);
        return;
    L18:
        return;
    }

    public final void g(vb6.f r8) {
        LinkMonitor.a("PipeLineM", "removeListener", String.valueOf(r8), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L9;
        r0.a(r8);
        return;
    }

    public final void g1(xb6.a r8) {
        LinkMonitor.a("PipeLineM", "removeLinkInjector", String.valueOf(r8), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullParameter(r8, "injector");
        Iterator r1 = r0.i.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        xb6.d r2 = (xb6.d) r1.next();
        if (Intrinsics.areEqual(r2.a, r8) == false) goto L9;
        r0.i.remove(r2);
        return;
    L18:
        return;
    }

    public final void h(xb6.b r10) {
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.k;
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((xb6.f) r2.next()).a.ra();
    L10:
        super.h(r10);
        LinkMonitor.a("PipeLineM", "detach", null, null, null, false, 92);
        this.r.h0(this.n);
        this.i.rh(this.j);
        this.s.T(this.k);
        this.s.V(this.m);
        this.s.e0(this.l);
        MultiLinkConfig r11 = this.b;
        if (r11 == null) goto L13;
        Intrinsics.checkNotNullParameter("PipeLineM detach", "source");
        LinkMonitor.a("MultiLinkConfig", "clearConfig", "source PipeLineM detach", null, null, false, 120);
        r11.b("PipeLineM detach");
        r11.i.clear();
        r11.j.clear();
        r11.k.clear();
    L13:
        LinkMonitor.b();
    }

    public final void k1(MultiLinkConfig r9) {
        Intrinsics.checkNotNullParameter(r9, "linkConfig");
        LinkMonitor.a("PipeLineM", "initLinkConfig", String.valueOf(r9), null, null, false, 88);
        this.b = r9;
    }

    public final void y0(h1 r14) {
        ILinkerChangeMediaInfoContent r0 = r14.getLinkerChangeMediaInfoContent();
        if (r0 == null) goto L16;
        ILinkmicMediaParam r1 = r0.getLinkmicMediaParam();
        if (r1 == null) goto L16;
        j1 r2 = r1.getLinkmicMediaInfo();
        if (r2 == null) goto L16;
        String r3 = r2.getBizTag();
        if (r3 == null) goto L16;
        if ((!StringsKt.isBlank(r3)) == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        w0(r3, "media info change msg");
    L16:
        ILinkerChangeMediaInfoContentDef r4 = r14.getLinkerChangeMediaInfoContent();
        boolean r5 = false;
        if (r4 == null) goto L56;
        ILinkmicMediaParam r6 = r4.getLinkmicMediaParam();
        if (r6 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == true) goto L27;
        r4 = null;
    L27:
        if (r4 == null) goto L56;
        ILinkmicMediaParam r8 = r4.getLinkmicMediaParam();
        if (r8 == null) goto L56;
        com.bytedance.android.live.liveinteract.plantform.model.k r9 = r8.getLinkMediaInfoForEnterRoom();
        if (r9 == null) goto L56;
        LinkMonitor.a("PipeLineM", "handleMediaInfoChangeMsg", "received enter room media info: liveCoreExtInfo " + r9.getLiveCoreExtInfo() + " rtcExtInfo " + r9.getRtcExtInfo(), null, null, false, 120);
        String r10 = r9.getLiveCoreExtInfo();
        if (r10 != null) goto L35;
    L45:
        boolean r11 = false;
    L46:
        if (r11 == true) goto L49;
        r9 = null;
    L49:
        if (r9 == null) goto L56;
        if (((Boolean) vm2.i.i.getValue(null, vm2.i.a[7])).booleanValue() == false) goto L56;
        tc0.b r12 = this.h;
        String r13 = r9.getRtcExtInfo();
        if (r13 != null) goto L55;
        r13 = "";
    L55:
        r12.setRtcExtInfo(r13);
        this.h.setLiveCoreExtInfo(r9.getLiveCoreExtInfo());
        LinkMonitor.a("PipeLineM", "handleMediaInfoChangeMsg", "update media info by room enter msg", null, null, true, 56);
        goto L56
    L35:
        if ((!StringsKt.isBlank(r10)) != true) goto L45;
        String r15 = r9.getRtcExtInfo();
        if (r15 == null) goto L45;
        if ((!StringsKt.isBlank(r15)) != true) goto L45;
        String r16 = r9.getLinkMicIdStr();
        if (r16 == null) goto L45;
        if ((!StringsKt.isBlank(r16)) != true) goto L45;
        r11 = true;
        goto L46
    L21:
        if (r6.getLinkmicMediaType() != ILinkmicMediaParam.Companion.getTYPE_LINKMIC_MEDIA_ENTER_ROOM()) goto L23;
        r7 = true;
    L56:
        ILinkerChangeMediaInfoContentDef r17 = r14.getLinkerChangeMediaInfoContent();
        if (r17 == null) goto L98;
        ILinkmicMediaParam r18 = r17.getLinkmicMediaParam();
        if (r18 != null) goto L61;
    L63:
        boolean r19 = false;
    L64:
        if (r19 == true) goto L67;
        r17 = null;
    L67:
        if (r17 == null) goto L99;
        ILinkmicMediaParam r110 = r17.getLinkmicMediaParam();
        if (r110 == null) goto L100;
        j1 r111 = r110.getLinkmicMediaInfo();
        if (r111 == null) goto L101;
        LinkMonitor.a("PipeLineM", "handleMediaInfoChangeMsg", "received media change info: liveCoreExtInfo " + r111.getLiveCoreExtInfo() + " rtcExtInfo " + r111.getRtcExtInfo(), null, null, false, 120);
        String r20 = r111.getLiveCoreExtInfo();
        if (r20 != null) goto L75;
    L85:
        if (r5 == true) goto L88;
        r111 = null;
    L88:
        if (r111 != null) goto L90;
        return;
    L90:
        if (((Boolean) vm2.i.F.getValue(null, vm2.i.a[30])).booleanValue() == false) goto L103;
        this.h.setLiveCoreExtInfo(r111.getLiveCoreExtInfo());
        this.h.setMultiLiveCoreInfo(r111.getMultiLiveCoreInfo());
        this.h.setRtcExtInfo(r111.getRtcExtInfo());
        this.h.setMultiRtcInfo(r111.getMultiRtcInfo());
        this.s.X(r111.getLiveCoreExtInfo());
        MultiLinkConfig r21 = this.b;
        if (r21 != null) goto L94;
    L96:
        this.s.c(r111.getRtcExtInfo());
        LinkMonitor.a("PipeLineM", "handleMediaInfoChangeMsg", "update media info by media change msg", null, null, true, 56);
        return;
    L94:
        if (r21.m != true) goto L96;
        this.s.S(r111.getLiveCoreExtInfo());
        goto L96
    L103:
        return;
    L75:
        if ((!StringsKt.isBlank(r20)) != true) goto L85;
        String r22 = r111.getRtcExtInfo();
        if (r22 == null) goto L85;
        if ((!StringsKt.isBlank(r22)) != true) goto L85;
        String r23 = r111.getLinkMicIdStr();
        if (r23 == null) goto L85;
        if ((!StringsKt.isBlank(r23)) != true) goto L85;
        r5 = true;
        goto L85
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L61:
        if (r18.getLinkmicMediaType() != ILinkmicMediaParam.Companion.getTYPE_LINKMIC_MEDIA_CHANGE()) goto L63;
        r19 = true;
        goto L64
    }

    public static final void t0(LinkPipelineManager r32, b r33) {
        r32.getClass();
        LinkMonitor.a("PipeLineM", "handleMsg", "msg " + r33.a, null, null, false, 88);
        py.k r12 = null;
        switch(r33.a) {
            case 0: goto L407;
            case 1: goto L401;
            case 2: goto L395;
            case 3: goto L364;
            case 4: goto L187;
            case 5: goto L116;
            case 6: goto L81;
            case 7: goto L39;
            case 8: goto L27;
            case 9: goto L15;
            case 10: goto L491;
            case 11: goto L10;
            case 12: goto L5;
            default: goto L491;
        };
    L5:
        Object r0 = r33.b;
        if (r0 == null) goto L9;
        r32.A0((h1) r0);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkerMessageBridge");
    L10:
        Object r1 = r33.b;
        if (r1 == null) goto L14;
        r32.y0((h1) r1);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkerMessageBridge");
    L15:
        Object r2 = r33.b;
        if (r2 == null) goto L26;
        z0 r3 = (z0) r2;
        LinkMonitor.a("PipeLineM", "handleAdminFirstMsg", null, null, null, false, 124);
        MultiLinkConfig r4 = r32.b;
        if (r4 == null) goto L459;
        CopyOnWriteArraySet r5 = r4.k;
        if (r5 == null) goto L460;
        Iterator r6 = r5.iterator();
    L23:
        if (r6.hasNext() == false) goto L495;
        ((xb6.f) r6.next()).a.y1(r3);
        goto L23
    L495:
        return;
    L460:
        return;
    L459:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkMicMessageBridge");
    L27:
        Object r7 = r33.b;
        if (r7 == null) goto L38;
        z0 r8 = (z0) r7;
        LinkMonitor.a("PipeLineM", "handleAudienceReplyMsg", null, null, null, false, 124);
        MultiLinkConfig r9 = r32.b;
        if (r9 == null) goto L461;
        CopyOnWriteArraySet r10 = r9.k;
        if (r10 == null) goto L462;
        Iterator r11 = r10.iterator();
    L35:
        if (r11.hasNext() == false) goto L496;
        ((xb6.f) r11.next()).a.z2(r8);
        goto L35
    L496:
        return;
    L462:
        return;
    L461:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkMicMessageBridge");
    L39:
        Object r13 = r33.b;
        if (r13 == null) goto L80;
        h1 r14 = (h1) r13;
        LinkMonitor.a("PipeLineM", "handleSysKickOutMsg", null, null, null, false, 124);
        MultiLinkConfig r15 = r32.b;
        if (r15 == null) goto L58;
        CopyOnWriteArraySet r16 = r15.j;
        if (r16 == null) goto L58;
        Iterator r17 = r16.iterator();
        boolean r18 = false;
    L47:
        if (r17.hasNext() == false) goto L59;
        Pair r19 = ((xb6.e) r17.next()).a.l(r14);
        Object r20 = r19.getSecond();
        if ((!StringsKt.isBlank((String) r20)) == true) goto L53;
        r20 = null;
    L53:
        if (((String) r20) == null) goto L47;
        if (((Boolean) r19.getFirst()).booleanValue() == true) goto L56;
        LinkMonitor.a("PipeLineM", "sysKickOutMsgIntercept", "sys kick out msg intercepted false by " + ((String) r19.getSecond()), null, null, false, 88);
        goto L47
    L56:
        LinkMonitor.a("PipeLineM", "sysKickOutMsgIntercepted", "sys kick out msg intercepted true by " + ((String) r19.getSecond()), null, null, true, 56);
        r18 = true;
    L59:
        if (r18 == true) goto L492;
        Set<Long> r21 = InteractLinkFullLinkMonitor.a;
        Intrinsics.checkNotNullParameter(r14, "msg");
        JSONObject r110 = new JSONObject();
        int r22 = rd0.a.a;
        MultiTraceData$TraceBusiness r111 = MultiTraceData$TraceBusiness.MultiLink;
        MultiTraceData$TraceEvent r112 = MultiTraceData$TraceEvent.CloseLink;
        StringBuilder r23 = new StringBuilder("kickOutSource");
        LinkerSysKickOutContent r24 = r14.getMLinkerSysKickOutContent();
        if (r24 == null) goto L64;
        Integer r25 = Integer.valueOf(r24.getKickOutSource());
    L65:
        r23.append(r25.intValue());
        rd0.a.b(r111, r112, "sysKickOut", 0, r23.toString(), null, 96);
        nd0.c r113 = nd0.c.a;
        LinkMonitorData r114 = LinkMonitorData.SysKickOutMessage;
        LinkerSysKickOutContent r26 = r14.getMLinkerSysKickOutContent();
        if (r26 == null) goto L68;
        r12 = Integer.valueOf(r26.getKickOutSource());
    L68:
        nd0.c.o(r113, r114, r110, 0, String.valueOf(r12.intValue()), false, 20);
        MultiLinkConfig r27 = r32.b;
        if (r27 == null) goto L76;
        CopyOnWriteArraySet r28 = r27.k;
        if (r28 == null) goto L76;
        Iterator r29 = r28.iterator();
    L74:
        if (r29.hasNext() == false) goto L76;
        ((xb6.f) r29.next()).a.ag(r14);
    L76:
        r32.N0("SysKickOut");
        r32.v0().a("sys kick out");
        MultiLinkConfig r30 = r32.b;
        if (r30 == null) goto L463;
        r30.b("sys kick out");
        return;
    L463:
        return;
    L64:
        r25 = null;
        goto L65
    L492:
        return;
    L58:
        r18 = false;
        goto L59
    L80:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkerMessageBridge");
    L81:
        Object r31 = r33.b;
        if (r31 == null) goto L115;
        z0 r34 = (z0) r31;
        LinkMonitor.a("PipeLineM", "handleKickOutMsg", null, null, null, false, 124);
        MultiLinkConfig r35 = r32.b;
        if (r35 == null) goto L100;
        CopyOnWriteArraySet r36 = r35.j;
        if (r36 == null) goto L100;
        Iterator r37 = r36.iterator();
        boolean r38 = false;
    L89:
        if (r37.hasNext() == false) goto L101;
        Pair r39 = ((xb6.e) r37.next()).a.d(r34);
        Object r40 = r39.getSecond();
        if ((!StringsKt.isBlank((String) r40)) == true) goto L95;
        r40 = null;
    L95:
        if (((String) r40) == null) goto L89;
        if (((Boolean) r39.getFirst()).booleanValue() == true) goto L98;
        LinkMonitor.a("PipeLineM", "kick out msg intercepted false by " + ((String) r39.getSecond()), null, null, null, false, 92);
        goto L89
    L98:
        LinkMonitor.a("PipeLineM", "kickOutMsgIntercepted", "kick out msg intercepted true by " + ((String) r39.getSecond()), null, null, true, 56);
        r38 = true;
    L101:
        if (r38 == true) goto L493;
        MultiLinkConfig r41 = r32.b;
        if (r41 == null) goto L111;
        CopyOnWriteArraySet r42 = r41.k;
        if (r42 == null) goto L111;
        Iterator r43 = r42.iterator();
    L109:
        if (r43.hasNext() == false) goto L111;
        ((xb6.f) r43.next()).a.fe(r34);
    L111:
        r32.N0("KickOut from source " + Integer.valueOf(r34.getKickOutSource()).intValue());
        r32.v0().a("kick out");
        MultiLinkConfig r44 = r32.b;
        if (r44 == null) goto L465;
        r44.b("kick out");
        return;
    L465:
        return;
    L493:
        return;
    L100:
        r38 = false;
        goto L101
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkMicMessageBridge");
    L116:
        Object r45 = r33.b;
        if (r45 == null) goto L186;
        com.bytedance.android.live.liveinteract.multianchor.model.b r115 = (com.bytedance.android.live.liveinteract.multianchor.model.b) ((z0) r45).castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        LinkMonitor.a("PipeLineM", "handleInviteMsg", null, null, null, true, 60);
        j1 r46 = r115.getGuestLinkMicInfo();
        if (r46 == null) goto L165;
        String r47 = r46.getRtcExtInfo();
        String r48 = r46.getLiveCoreExtInfo();
        MultiLinkConfig r49 = r32.b;
        if (r49 == null) goto L138;
        CopyOnWriteArraySet r50 = r49.j;
        if (r50 == null) goto L138;
        Iterator r51 = r50.iterator();
        boolean r116 = false;
    L126:
        if (r51.hasNext() == false) goto L139;
        Pair r117 = ((xb6.e) r51.next()).a.f(r115);
        Object r118 = r117.getSecond();
        if ((!StringsKt.isBlank((String) r118)) == true) goto L132;
        r118 = null;
    L132:
        if (((String) r118) == null) goto L126;
        if (((Boolean) r117.getFirst()).booleanValue() == true) goto L135;
        LinkMonitor.a("PipeLineM", "handleInviteMsg", "Invite msg intercepted false by " + ((String) r117.getSecond()), null, null, false, 88);
        goto L126
    L135:
        LinkMonitor.a("PipeLineM", "handleInviteMsg", "Invite msg intercepted true by " + ((String) r117.getSecond()), null, null, true, 56);
        r116 = true;
    L139:
        if (r116 == false) goto L141;
    L164:
        LinkMonitor.a("PipeLineM", "handleInviteMsg", "incomplete link mic info" + r46 + " with", null, null, true, 56);
    L166:
        tc0.b r52 = InteractLinkFullLinkMonitor.h;
        if (r52 == null) goto L169;
        r52.Ah(r115.getLinkerSessionId());
    L169:
        tc0.b r53 = InteractLinkFullLinkMonitor.h;
        if (r53 == null) goto L172;
        r53.Jm(r115.getRemoteLinkerSessionId());
    L172:
        JSONObject r54 = new JSONObject();
        Intrinsics.checkNotNullParameter(r115, "$this$messageIdExt");
        r54.put("msg_id", Long.valueOf(r115.getMessageId2()));
        Intrinsics.checkNotNullParameter(r115, "$this$fromUserId");
        r54.put("from_user_id", r115.get_fromUserId());
        com.bytedance.android.live.liveinteract.multianchor.model.b r55 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r115.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        if (r55 == null) goto L177;
        j1 r56 = r55.getGuestLinkMicInfo();
        if (r56 == null) goto L177;
        r54.put("guest_linkmic_info", r56.toString());
    L177:
        int r57 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "receiveInviteMsg", 0, null, r54, 88);
        nd0.c.o(nd0.c.a, LinkMonitorData.InviteMessage, r54, 0, null, false, 28);
        MultiLinkConfig r58 = r32.b;
        if (r58 == null) goto L467;
        CopyOnWriteArraySet r59 = r58.k;
        if (r59 == null) goto L468;
        Iterator r60 = r59.iterator();
    L183:
        if (r60.hasNext() == false) goto L497;
        ((xb6.f) r60.next()).a.Ra(r115);
        goto L183
    L497:
        return;
    L468:
        return;
    L467:
        return;
    L141:
        if (r47.length() <= 0) goto L143;
        boolean r61 = true;
    L144:
        if (r61 == false) goto L164;
        if (r48.length() <= 0) goto L148;
        boolean r62 = true;
    L149:
        if (r62 == false) goto L164;
        tc0.b r63 = r32.h;
        if (r63 == null) goto L153;
        r63.setLiveCoreExtInfo(r48);
    L153:
        tc0.b r65 = r32.h;
        if (r65 == null) goto L156;
        r65.setRtcExtInfo(r47);
    L156:
        tc0.b r66 = r32.h;
        if (r66 == null) goto L160;
        r66.setMultiRtcInfo(r46.getMultiRtcInfo());
    L160:
        if (((Boolean) vm2.i.j.getValue(null, vm2.i.a[8])).booleanValue() == false) goto L166;
        cc6.c r67 = r32.v0();
        r67.getClass();
        Intrinsics.checkNotNullParameter("setIsEarlyInitRtcWithInviteIm on invite msg", "reason");
        LinkMonitor.a("LinkState", "setIsInviteImEarlyInitRtc", " true : setIsEarlyInitRtcWithInviteIm on invite msg", null, null, false, 120);
        r67.i.set(true);
        r32.J0("InviteMsg");
        r32.K0("InviteMsg");
        if (vm2.i.i() == false) goto L166;
        r32.Y0(false, false, false, false, "StartEngineOnInviteMsg");
        goto L166
    L148:
        r62 = false;
        goto L149
    L143:
        r61 = false;
    L138:
        r116 = false;
        goto L139
    L165:
        LinkMonitor.a("PipeLineM", "handleInviteMsg", "guest link mic info is null with invite im", null, null, true, 56);
        goto L166
    L186:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.ILinkMicMessageBridge");
    L187:
        Object r68 = r33.b;
        if (r68 == null) goto L494;
        LinkMonitor.a("PipeLineM", "handlePermitMsg", null, null, null, true, 60);
        if (r32.D0() == false) goto L193;
        LinkMonitor.a("PipeLineM", "handlePermitMsg", "online state ignore", null, null, true, 56);
        return;
    L193:
        r32.v0().b(true, "received permit msg");
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        LinkMonitor.c = SystemClock.elapsedRealtime();
        if ((r68 instanceof z0) == false) goto L470;
        MultiLinkConfig r69 = r32.b;
        if (r69 == null) goto L212;
        CopyOnWriteArraySet r70 = r69.j;
        if (r70 == null) goto L212;
        Iterator r71 = r70.iterator();
        boolean r72 = false;
    L201:
        if (r71.hasNext() == false) goto L213;
        Pair r73 = ((xb6.e) r71.next()).a.j((z0) r68);
        Object r74 = r73.getSecond();
        if ((!StringsKt.isBlank((String) r74)) == true) goto L207;
        r74 = null;
    L207:
        if (((String) r74) == null) goto L201;
        if (((Boolean) r73.getFirst()).booleanValue() == true) goto L210;
        LinkMonitor.a("PipeLineM", "handlePermitMsg", "permit msg intercepted false by " + ((String) r73.getSecond()), null, null, false, 88);
        goto L201
    L210:
        LinkMonitor.a("PipeLineM", "handlePermitMsg", "permit msg intercepted true by " + ((String) r73.getSecond()), null, null, true, 56);
        r72 = true;
    L213:
        if (r72 == false) goto L217;
        r32.v0().b(false, "permit msg intercepted");
        MultiLinkConfig r75 = r32.b;
        if (r75 == null) goto L471;
        r75.b("permit msg intercepted");
        return;
    L471:
        return;
    L217:
        MultiLinkConfig r76 = r32.b;
        if (r76 == null) goto L225;
        CopyOnWriteArraySet r77 = r76.k;
        if (r77 == null) goto L225;
        Iterator r78 = r77.iterator();
    L223:
        if (r78.hasNext() == false) goto L225;
        ((xb6.f) r78.next()).a.H4((z0) r68);
    L225:
        z0 r79 = (z0) r68;
        tc0.b r80 = InteractLinkFullLinkMonitor.h;
        if (r80 == null) goto L228;
        r80.Ah(r79.getLinkerSessionId());
    L228:
        tc0.b r81 = InteractLinkFullLinkMonitor.h;
        if (r81 == null) goto L231;
        r81.Jm(r79.getRemoteLinkerSessionId());
    L231:
        JSONObject r82 = new JSONObject();
        Intrinsics.checkNotNullParameter(r79, "$this$messageIdExt");
        r82.put("msg_id", Long.valueOf(r79.getMessageId2()));
        Intrinsics.checkNotNullParameter(r79, "$this$fromUserId");
        String r83 = r79.get_fromUserId();
        Object r84 = "";
        if (r83 != null) goto L234;
        r83 = "";
    L234:
        r82.put("from_user_id", r83);
        String r85 = r79.getRtcExtInfo();
        if (r85 != null) goto L237;
        r85 = "";
    L237:
        r82.put("rtc_ext_info", r85);
        v1 r86 = r79.getMultiRtcInfo();
        if (r86 != null) goto L240;
        r86 = "";
    L240:
        r82.put("multi_rtc_ext_info", r86);
        Object r87 = r79.getMcuContent();
        if (r87 != null) goto L243;
        r87 = "";
    L243:
        r82.put("mcu_content", r87);
        com.bytedance.android.live.liveinteract.plantform.model.f r88 = r79.getActionSource();
        if (r88 == null) goto L249;
        Integer r89 = r88.getPermitSource();
        if (r89 == null) goto L249;
        r84 = r89;
    L249:
        r82.put("permit_source", r84);
        j1 r90 = r79.getGuestLinkMicInfo();
        if (r90 == null) goto L252;
        r82.put("guest_linkmic_info", r90.toString());
    L252:
        InteractLinkFullLinkMonitor.f = true;
        i97.a r91 = i97.a.a;
        InteractLinkFullLinkMonitor.c = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.g = false;
        InteractLinkFullLinkMonitor.d = 0;
        int r92 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "receivedPermitMsg", 0, null, r82, 80);
        nd0.c.o(nd0.c.a, LinkMonitorData.PermitMessage, r82, 0, null, false, 28);
        MultiLinkConfig r93 = r32.b;
        if (r93 == null) goto L255;
        MultiLinkConfig.LinkSource r94 = MultiLinkConfig.LinkSource.APPLY;
        Intrinsics.checkNotNullParameter(r94, "<set-?>");
        r93.a = r94;
    L255:
        r32.f = null;
        q0 r95 = r79.getJoinChannelData();
        if (r95 == null) goto L338;
        int r96 = rk0.a.a;
        Intrinsics.checkNotNullParameter(r95, "data");
        vh7.e r97 = (IJoinChannelResult) vh7.f.c(IJoinChannelResult.class);
        ICityEffect r98 = r97.getCityEffect();
        if (r98 == null) goto L264;
        com.bytedance.android.live.liveinteract.plantform.model.c r99 = r95.getCityEffect();
        if (r99 == null) goto L262;
        String r100 = r99.getCity();
    L263:
        r98.setCity(r100);
        goto L264
    L262:
        r100 = null;
    L264:
        ICityEffect r101 = r97.getCityEffect();
        if (r101 == null) goto L271;
        com.bytedance.android.live.liveinteract.plantform.model.c r102 = r95.getCityEffect();
        if (r102 == null) goto L269;
        py.k r103 = r102.getCityEffect();
    L270:
        r101.setCityEffect(r103);
        goto L271
    L269:
        r103 = null;
    L271:
        ICityEffect r104 = r97.getCityEffect();
        if (r104 == null) goto L283;
        com.bytedance.android.live.liveinteract.plantform.model.c r105 = r95.getCityEffect();
        if (r105 == null) goto L281;
        List<Long> r106 = r105.getShowEffectUserIdList();
        if (r106 == null) goto L281;
        List<Long> r107 = r106;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L279:
        if (r109.hasNext() == false) goto L282;
        r108.add(String.valueOf(((Number) r109.next()).longValue()));
    L282:
        ICityEffectKtKt.setShowEffectUserIdListExt(r104, r108);
    L281:
        r108 = null;
    L283:
        a0 r119 = r97.getDelegateSetting();
        if (r119 == null) goto L290;
        com.bytedance.android.live.liveinteract.plantform.model.d r120 = r95.getDelegateSetting();
        if (r120 == null) goto L288;
        String r121 = r120.getPrompt();
    L289:
        r119.setPrompt(r121);
        goto L290
    L288:
        r121 = null;
    L290:
        a0 r122 = r97.getDelegateSetting();
        if (r122 == null) goto L299;
        com.bytedance.android.live.liveinteract.plantform.model.d r123 = r95.getDelegateSetting();
        if (r123 != null) goto L295;
    L297:
        boolean r124 = false;
    L298:
        r122.setEnableDelegate(r124);
        goto L299
    L295:
        if (r123.getEnableDelegate() != true) goto L297;
        r124 = true;
    L299:
        a0 r125 = r97.getDelegateSetting();
        if (r125 == null) goto L308;
        com.bytedance.android.live.liveinteract.plantform.model.d r126 = r95.getDelegateSetting();
        if (r126 != null) goto L304;
    L306:
        boolean r127 = false;
    L307:
        r125.setShowPanel(r127);
        goto L308
    L304:
        if (r126.getShowPanel() != true) goto L306;
        r127 = true;
    L308:
        a0 r128 = r97.getDelegateSetting();
        if (r128 == null) goto L315;
        com.bytedance.android.live.liveinteract.plantform.model.d r129 = r95.getDelegateSetting();
        if (r129 == null) goto L313;
        Integer r130 = r129.getStatus();
    L314:
        r128.setStatus(r130);
        goto L315
    L313:
        r130 = null;
    L315:
        a0 r131 = r97.getDelegateSetting();
        if (r131 == null) goto L322;
        com.bytedance.android.live.liveinteract.plantform.model.d r132 = r95.getDelegateSetting();
        if (r132 == null) goto L320;
        py.k r133 = r132.getTagImageUrl();
    L321:
        r131.setTagImageUrl(r133);
        goto L322
    L320:
        r133 = null;
    L322:
        IMatchEffect r134 = r97.getMatchEffect();
        if (r134 == null) goto L328;
        t0 r135 = r95.getMatchEffect();
        if (r135 == null) goto L327;
        r12 = r135.getMatchEffect();
    L327:
        r134.setMatchEffect(r12);
    L328:
        IMatchEffect r136 = r97.getMatchEffect();
        if (r136 == null) goto L337;
        t0 r137 = r95.getMatchEffect();
        if (r137 != null) goto L333;
    L335:
        boolean r138 = false;
    L336:
        r136.setShowEffect(r138);
        goto L337
    L333:
        if (r137.getShowEffect() != true) goto L335;
        r138 = true;
    L337:
        r97.setPrompt(r95.getPrompt());
        r97.setPaidLinkmic(Intrinsics.areEqual(r95.isPaidLinkMic(), Boolean.TRUE));
        r97.setPayCount(r95.getPayCount());
        r97.setLiveCoreSettings(r95.getLiveCoreSettings());
        r97.setLinkedUsers(r95.getLinkedUsers());
        r97.setApplyType(r95.getApplyType());
        r97.setVersion(r95.getVersion());
        r97.setToken(r95.getToken());
        r97.setPromptWithEarphone(r95.getPromptWithEarphone());
        r97.setLinkGameInfo(r95.getLinkGameInfo());
        r97.setClientUiInfo(r95.getClientUiInfo());
        Extra r139 = new Extra();
        Intrinsics.checkNotNullParameter(r79, "$this$messageIdExt");
        r32.f = k97.a.a(r97, r139, String.valueOf(r79.getMessageId2()));
        LinkMonitor.a("PipeLineM", "handlePermitMsg", "permit join channel is valid", null, null, true, 56);
    L338:
        r32.L0();
        if (vm2.i.c() == false) goto L473;
        j1 r140 = ((com.bytedance.android.live.liveinteract.multianchor.model.b) ((vh7.c) r68).castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getGuestLinkMicInfo();
        if (r140 == null) goto L363;
        String r141 = r140.getRtcExtInfo();
        String r142 = r140.getLiveCoreExtInfo();
        if (r141.length() <= 0) goto L345;
        boolean r143 = true;
    L346:
        if (r143 == true) goto L348;
    L362:
        LinkMonitor.a("PipeLineM", "handlePermitMsg", "incomplete link mic info " + r140, null, null, false, 120);
        return;
    L348:
        if (r142.length() <= 0) goto L350;
        boolean r144 = true;
    L351:
        if (r144 == false) goto L362;
        tc0.b r145 = r32.h;
        if (r145 == null) goto L355;
        r145.setLiveCoreExtInfo(r142);
    L355:
        tc0.b r146 = r32.h;
        if (r146 == null) goto L358;
        r146.setRtcExtInfo(r141);
    L358:
        tc0.b r147 = r32.h;
        if (r147 == null) goto L361;
        r147.setMultiRtcInfo(r140.getMultiRtcInfo());
    L361:
        nd0.c.o(nd0.c.a, LinkMonitorData.AdvanceStartOnApply, new JSONObject(), 0, null, false, 28);
        C0(r32, false, "PermitMsg", 7);
        return;
    L350:
        r144 = false;
        goto L351
    L345:
        r143 = false;
        goto L346
    L363:
        LinkMonitor.a("PipeLineM", "handlePermitMsg", "guest link mic info is null", null, null, false, 120);
        return;
    L473:
        return;
    L212:
        r72 = false;
        goto L213
    L470:
        return;
    L494:
        return;
    L364:
        Object r148 = r33.b;
        if (r148 == null) goto L394;
        boolean r149 = ((Boolean) r148).booleanValue();
        StringBuilder r150 = new StringBuilder("isAnchor ");
        MultiLinkConfig r151 = r32.b;
        if (r151 == null) goto L369;
        r12 = Boolean.valueOf(r151.m);
    L369:
        r150.append(r12);
        LinkMonitor.a("PipeLineM", "startCloseLink", r150.toString(), null, null, false, 120);
        MultiLinkConfig r152 = r32.b;
        if (r152 != null) goto L372;
    L386:
        if (r149 == false) goto L390;
        LinkMonitor.a("PipeLineM", "startLeaveChannelReq", null, null, null, false, 124);
        MultiLinkConfig r153 = r32.b;
        if (r153 == null) goto L479;
        r32.q.F(r153.n, r153.d, new com.bytedance.android.live.livelink.multilink.pipeline.d(r153, r32));
        return;
    L479:
        return;
    L390:
        r32.N0("startCloseLink");
        r32.v0().a("startCloseLink isNeedLeaveChanel false");
        MultiLinkConfig r154 = r32.b;
        if (r154 == null) goto L481;
        r154.b("startCloseLink isNeedLeaveChanel false");
        return;
    L481:
        return;
    L372:
        if (r152.m != true) goto L386;
        LinkMonitor.a("PipeLineM", "startFinishReq", null, null, null, false, 124);
        MultiLinkConfig r155 = r32.b;
        if (r155 == null) goto L477;
        LinkedHashMap r156 = new LinkedHashMap();
        MultiLinkConfig r157 = r32.b;
        if (r157 == null) goto L385;
        CopyOnWriteArraySet r158 = r157.i;
        if (r158 == null) goto L385;
        Iterator r159 = r158.iterator();
    L381:
        if (r159.hasNext() == false) goto L385;
        String r160 = ((xb6.d) r159.next()).a.b(r156);
        if ((!r156.isEmpty()) == false) goto L381;
        LinkMonitor.a("PipeLineM", "startFinishReq", "inject finish api params " + r156 + " from " + r160, null, null, false, 88);
    L385:
        r32.q.y(r155.n, r155.d, r156, new com.bytedance.android.live.livelink.multilink.pipeline.c(r155, r32));
        return;
    L477:
        return;
    L394:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L395:
        LinkMonitor.a("PipeLineM", "startJoinLink", null, null, null, false, 124);
        MultiLinkConfig r161 = r32.b;
        if (r161 != null) goto L398;
        return;
    L398:
        if (r161.b == false) goto L400;
        r32.I0();
        return;
    L400:
        r32.L0();
        return;
    L401:
        LinkMonitor.a("PipeLineM", "startReplyLink", null, null, null, false, 124);
        MultiLinkConfig r162 = r32.b;
        if (r162 != null) goto L404;
        return;
    L404:
        if (r162.b == false) goto L406;
        r32.I0();
        return;
    L406:
        r32.M0();
        return;
    L407:
        LinkMonitor.a("PipeLineM", "startApplyLink", null, null, null, false, 124);
        MultiLinkConfig r163 = r32.b;
        if (r163 != null) goto L410;
        return;
    L410:
        if (r163.b == false) goto L412;
        r32.I0();
        return;
    L412:
        r32.H0();
        return;
    }

    public static final void u0(LinkPipelineManager r7, cc6.b r8) {
        r7.getClass();
        LinkMonitor.a("PipeLineM", "onLinkFailed", String.valueOf(r8), null, null, true, 56);
        MultiLinkConfig r0 = r7.b;
        if (r0 == null) goto L11;
        CopyOnWriteArraySet r1 = r0.k;
        if (r1 == null) goto L11;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        ((xb6.f) r2.next()).a.M4(r8);
    L11:
        if ((!Intrinsics.areEqual(r8, cc6.b.h.c)) == false) goto L13;
        r7.N0(r8.b);
    L13:
        r7.G0(r8.b);
        LinkMonitor.b();
    }

    public final void W0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "source");
        tc0.b r0 = this.h;
        if (r0 == null) goto L5;
        r0.setLiveCoreExtInfo(r2);
    L5:
        J0(r3);
    }

    public final void X0(vb6.f r8, boolean r9) {
        StringBuilder r2 = new StringBuilder();
        r2.append(r8);
        r2.append(' ');
        r2.append(r9);
        LinkMonitor.a("PipeLineM", "addLinkListener", r2.toString(), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L23;
        Intrinsics.checkNotNullParameter(r8, "listener");
        Iterator r1 = r0.k.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        xb6.f r3 = (xb6.f) r1.next();
        if (Intrinsics.areEqual(r3.a, r8) == false) goto L9;
        if (r3.b != r9) goto L9;
        return;
    L15:
        r0.k.add(new xb6.f(r8, r9));
        return;
    }

    public final void b1(xb6.a r8, boolean r9) {
        StringBuilder r2 = new StringBuilder();
        r2.append(r8);
        r2.append(' ');
        r2.append(r9);
        LinkMonitor.a("PipeLineM", "addLinkInjector", r2.toString(), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L23;
        Intrinsics.checkNotNullParameter(r8, "injector");
        Iterator r1 = r0.i.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        xb6.d r3 = (xb6.d) r1.next();
        if (Intrinsics.areEqual(r3.a, r8) == false) goto L9;
        if (r3.b != r9) goto L9;
        return;
    L15:
        r0.i.add(new xb6.d(r8, r9));
        return;
    }

    public final void d1(int r11, int r12) {
        if (D0() == false) goto L9;
        LinkMonitor.a("PipeLineM", "already in link when apply link", null, null, null, false, 124);
        MultiLinkConfig r13 = this.b;
        if (r13 == null) goto L7;
        r13.b("already in link when apply link");
    L7:
        v0().a("already in link when apply link");
        return;
    L9:
        v0().b(true, "applyLink");
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L12;
        r0.e = r11;
    L12:
        if (r0 == null) goto L14;
        r0.c = r12;
    L14:
        if (r0 == null) goto L16;
        r0.b = true;
    L16:
        if (r0 == null) goto L18;
        MultiLinkConfig.LinkSource r14 = MultiLinkConfig.LinkSource.APPLY;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r0.a = r14;
    L18:
        LinkMonitor.a("PipeLineM", "applyLinkConfig", String.valueOf(this.b), null, null, false, 120);
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$applyLink$1(this), 3);
    }

    public final void e1(xb6.b r8, boolean r9) {
        StringBuilder r2 = new StringBuilder();
        r2.append(r8);
        r2.append(' ');
        r2.append(r9);
        LinkMonitor.a("PipeLineM", "addLinkInterceptor", r2.toString(), null, null, false, 88);
        if (r8 != null) goto L5;
        return;
    L5:
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L23;
        Intrinsics.checkNotNullParameter(r8, "interceptor");
        Iterator r1 = r0.j.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        xb6.e r3 = (xb6.e) r1.next();
        if (Intrinsics.areEqual(r3.a, r8) == false) goto L9;
        if (r3.b != r9) goto L9;
        return;
    L15:
        r0.j.add(new xb6.e(r8, r9));
        return;
    }

    public final void i1(String r8, final boolean r9) {
        LinkMonitor.a("PipeLineM", "closeLink", String.valueOf(r8), null, null, false, 120);
        v0().f(true, "closeLink");
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L7;
        if (r8 != null) goto L6;
        r8 = "";
    L6:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r0.d = r8;
    L7:
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$closeLink$1(this, r9), 3);
    }

    public final void w0(String r12, String r13) {
        MultiLinkConfig r1 = this.b;
        if (r1 == null) goto L8;
        if (r1.m == true) goto L8;
        return;
    L8:
        if (r12 != null) goto L10;
    L13:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L35;
        ec6.a r14 = this.s.r0();
        if (r14 == null) goto L37;
        sk0.c r15 = r14.r();
        if (r15 == null) goto L38;
        sk0.a r16 = r15.b;
        if (r16 == null) goto L39;
        r16.e(new kb6.b(0, "", ""));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L35:
        LinkMonitor.a("PipeLineM", "handleAudioSceneVideoExpOpt", "updateBizTag " + r12 + " from " + r13, null, null, false, 120);     // Catch: Exception -> L32
        JSONObject r17 = new JSONObject(r12);     // Catch: Exception -> L32
        int r18 = r17.optInt("LiveRoomMode", 0);     // Catch: Exception -> L32
        String r0 = r17.optString("BizType", "");     // Catch: Exception -> L32
        String r19 = r17.optString("SceneType", "");     // Catch: Exception -> L32
        ec6.a r3 = this.s.r0();     // Catch: Exception -> L32
        if (r3 == null) goto L40;
        sk0.c r4 = r3.r();     // Catch: Exception -> L32
        if (r4 == null) goto L41;
        sk0.a r5 = r4.b;     // Catch: Exception -> L32
        if (r5 == null) goto L42;
        r5.e(new kb6.b(r18, r0, r19));     // Catch: Exception -> L32
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L32:
        e = move-exception;
        LinkMonitor.a("PipeLineM", "handleAudioSceneVideoExpOpt", "set biz tag failed " + e.getMessage(), null, null, false, 120);
        return;
    L10:
        if (StringsKt.isBlank(r12) == true) goto L13;
        r2 = false;
        goto L15
    }

    public final void O0(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        tc0.b r0 = this.h;
        if (r0 == null) goto L5;
        r0.setLiveCoreExtInfo(r2);
    L5:
        tc0.b r5 = this.h;
        if (r5 == null) goto L8;
        r5.setRtcExtInfo(r3);
    L8:
        C0(this, r4, "applySilenceLink", 6);
    }

    public final void h1(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r4, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r5, "source");
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L9;
        this.h.setLiveCoreExtInfo(r3);
        this.h.setRtcExtInfo(r4);
        if (r0.m == true) goto L7;
        J0(r5);
    L7:
        K0(r5);
        return;
    }

    public static /* synthetic */ void C0(LinkPipelineManager r9, boolean r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r12 & 2) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r12 & 4) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r12 & 8) == 0) goto L17;
        boolean r7 = true;
    L18:
        r9.B0(r4, r5, r6, r7, r11);
        return;
    L17:
        r7 = r10;
        goto L18
    L13:
        r6 = false;
        goto L15
    L9:
        r5 = false;
        goto L11
    L5:
        r4 = false;
        goto L7
    }

    public final void x0(MultiLinkConfig r9, long r10, ExtraResponse<? extends IJoinChannelResult, Extra> r12, String r13) {
        LinkMonitor.m = r10;
        LinkMonitor.a("PipeLineM", "handleJoinChannelSuccess", "[duration] JoinChannelSuccess " + r10 + " [source] " + r13, null, null, true, 56);
        v0().h(false, "join channel success");
        v0().g(true, "join channel success");
        String r14 = ((IJoinChannelResult) r12.data).getToken();
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        this.d = r14;
        Iterator r11 = r9.k.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((xb6.f) r11.next()).a.C2(r10, r12);
        goto L7
    L9:
        InteractLinkFullLinkMonitor.A();
        if (this.s.K().e == false) goto L12;
        LinkMonitor.a("PipeLineM", "handleJoinChannelSuccess", "rtc engine is on when join channel success", null, null, true, 56);
        F0(LinkSuccessSource.ADVANCE_RTC);
        return;
    L12:
        LinkMonitor.a("PipeLineM", "handleJoinChannelSuccess", "join channel success, wait rtc start success", null, null, true, 56);
        C0(this, true, "JoinChannelFinishRtcStartNotFinish", 7);
    }

    public final void B0(boolean r8, boolean r9, boolean r10, boolean r11, String r12) {
        LinkMonitor.a("PipeLineM", "initAndStartEngine", "needPushStream" + r11 + " isUserVisible " + r8 + " needSubscribeAudio " + r9 + ", needSubscribeVideo " + r10 + " source: " + r12, null, null, false, 120);
        MultiLinkConfig r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.m == true) goto L7;
        J0(r12);
    L7:
        K0(r12);
        Y0(r11, r9, r10, r8, r12);
    }

    public final void Y0(boolean r30, boolean r31, boolean r32, boolean r33, String r34) {
        Intrinsics.checkNotNullParameter(r34, "source");
        if (r33 == false) goto L6;
        this.s.g0(true, "startRtcEngine ".concat(r34));
    L6:
        if (this.s.K().e == false) goto L8;
    L35:
        LinkMonitor.a("PipeLineM", "startRtcEngine", "rtc client is started or starting , ignore", null, null, false, 120);
        return;
    L8:
        if (this.s.K().c == true) goto L35;
        LinkMonitor.a("PipeLineM", "startRtcEngine", "[source] " + r34 + " needPushStream " + r30 + " isUserVisible " + r33 + " needSubscribeAudio " + r31 + " needSubscribeVideo " + r32, null, null, true, 56);
        MultiLinkConfig r2 = this.b;
        if (r2 == null) goto L45;
        CopyOnWriteArraySet r3 = r2.j;
        boolean r7 = false;
        String r8 = "";
        if (r3 == null) goto L27;
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L27;
        Pair r9 = ((xb6.e) r4.next()).a.a();
        Object r10 = r9.getSecond();
        if ((!StringsKt.isBlank((String) r10)) == true) goto L22;
        r10 = null;
    L22:
        if (((String) r10) == null) goto L16;
        if (((Boolean) r9.getFirst()).booleanValue() == true) goto L25;
        LinkMonitor.a("PipeLineM", "startRtcEngine", "intercept false by " + ((String) r9.getSecond()), null, null, false, 88);
        goto L16
    L25:
        r8 = (String) r9.getSecond();
        LinkMonitor.a("PipeLineM", "startRtcEngine", "intercept true by " + ((String) r9.getSecond()), null, null, false, 120);
        r7 = true;
    L27:
        if (r7 == false) goto L31;
        v0().a("star rtc engine intercepted by " + r8);
        return;
    L31:
        if (this.s.K().e == false) goto L33;
        LinkMonitor.a("PipeLineM", "engine is in start state", null, null, null, false, 124);
        v0().a("engine started");
        return;
    L33:
        boolean r1 = LinkMonitor.h;
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        LinkMonitor.d = SystemClock.elapsedRealtime();
        this.s.q0(r30, r33, r31, r32, r34, new l(this));
        return;
    }

    public final void j1(int r11, String r12, String r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "replySecToUserId");
        Intrinsics.checkNotNullParameter(r13, "replyToUserIdString");
        LinkMonitor.a("PipeLineM", "replyLink", null, null, null, false, 124);
        if (D0() == false) goto L9;
        LinkMonitor.a("PipeLineM", "already in link when reply link", null, null, null, false, 124);
        MultiLinkConfig r16 = this.b;
        if (r16 == null) goto L7;
        r16.b("already in link when reply link");
    L7:
        v0().a("already in link when reply link");
        return;
    L9:
        v0().c(true, "replyLink");
        MultiLinkConfig r0 = this.b;
        if (r0 == null) goto L12;
        r0.e = r14;
    L12:
        if (r0 == null) goto L15;
        r0.h = r11;
    L15:
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.f = r12;
    L17:
        MultiLinkConfig r17 = this.b;
        if (r17 == null) goto L20;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r17.g = r13;
    L20:
        MultiLinkConfig r18 = this.b;
        if (r18 == null) goto L23;
        MultiLinkConfig.LinkSource r19 = MultiLinkConfig.LinkSource.REPLY;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.a = r19;
    L23:
        MultiLinkConfig r110 = this.b;
        if (r110 == null) goto L26;
        r110.b = r15;
    L26:
        LinkMonitor.a("PipeLineM", "replyLinkConfig", "config " + this.b, null, null, false, 120);
        com.bytedance.live.kmp.util.d.b(0, true, new LinkPipelineManager$replyLink$1(this), 3);
    }

    public LinkPipelineManager(Context r2, bc6.a r3, wb6.a r4, ac6.a r5, yb6.e r6, bn0.b r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "permissionManager");
        Intrinsics.checkNotNullParameter(r4, "apiManager");
        Intrinsics.checkNotNullParameter(r5, "msgManager");
        Intrinsics.checkNotNullParameter(r6, "mediaManager");
        Intrinsics.checkNotNullParameter(r7, "multiLinkRoomScope");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.c = LazyKt.lazy(LinkPipelineManager$mLinkState$2.INSTANCE);
        this.d = "";
        this.h = hc6.b.a(r7, Reflection.getOrCreateKotlinClass(tc0.b.class));
        this.i = (hd0.b) hc6.b.a(r7, Reflection.getOrCreateKotlinClass(hd0.b.class));
        this.j = new c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new LinkPipelineManager$mRtcInfoListener$1(this);
        this.n = new LinkPipelineManager$mMsgListener$1(this);
    }
}
