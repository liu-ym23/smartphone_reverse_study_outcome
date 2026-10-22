package com.bytedance.android.live.liveinteract.api.fulllink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gd0.n;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import jc1.k;
import jy0.d;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import nd0.c;
import nd0.e;
import org.json.JSONObject;
import r27.a;
import tc0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InteractLinkFullLinkMonitor {
    public static final Set<Long> a = null;
    public static final Map<String, Long> b = null;
    public static long c;
    public static long d;
    public static long e;
    public static boolean f;
    public static boolean g;
    public static b h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/fulllink/InteractLinkFullLinkMonitor$LinkSource;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "APPLY", "APPLY_AUTO", "REPLY", "JOIN", "UNKNOWN", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkSource extends Enum<LinkSource> {
        public static final LinkSource APPLY = null;
        public static final LinkSource APPLY_AUTO = null;
        public static final LinkSource JOIN = null;
        public static final LinkSource REPLY = null;
        public static final LinkSource UNKNOWN = null;
        public static final /* synthetic */ LinkSource[] a = null;
        private final String des;

        static {
            LinkSource r1 = new LinkSource("APPLY", 0, "apply");
            APPLY = r1;
            LinkSource r2 = new LinkSource("APPLY_AUTO", 1, "apply_auto");
            APPLY_AUTO = r2;
            LinkSource r3 = new LinkSource("REPLY", 2, "reply");
            REPLY = r3;
            LinkSource r4 = new LinkSource("JOIN", 3, "join");
            JOIN = r4;
            LinkSource r5 = new LinkSource("UNKNOWN", 4, "unknown");
            UNKNOWN = r5;
            a = new LinkSource[]{r1, r2, r3, r4, r5};
        }

        public static LinkSource valueOf(String r1) {
            return (LinkSource) a.a(LinkSource.class, r1);
        }

        public static LinkSource[] values() {
            return (LinkSource[]) a.clone();
        }

        public final String getDes() {
            return this.des;
        }

        public LinkSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.des = r3;
        }
    }

    static {
        a = new LinkedHashSet();
        b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void A() {
        JSONObject r2 = new JSONObject();
        a(r2);
        if (f == false) goto L6;
        i97.a r0 = i97.a.a;
        long r4 = System.currentTimeMillis() - c;
        r2.put("duration", r4);
        jy0.b.a("ttlive_multi_advance_link", "advance apply link server set up duration " + r4);
        c.o(c.a, LinkMonitorData.ApplyJoinChannelSuccess, r2, 0, null, false, 28);
        return;
    L6:
        if (g == false) goto L10;
        i97.a r1 = i97.a.a;
        long r5 = System.currentTimeMillis() - d;
        r2.put("duration", r5);
        jy0.b.a("ttlive_multi_advance_link", "advance reply link server set up duration " + r5);
        c.o(c.a, LinkMonitorData.ReplyJoinChannelSuccess, r2, 0, null, false, 28);
        return;
    }

    @JvmStatic
    public static final void B() {
        i97.a r0 = i97.a.a;
        System.currentTimeMillis();
        JSONObject r3 = new JSONObject();
        c.o(c.a, LinkMonitorData.LiveCoreAudioCaptureStarted, r3, 0, null, false, 28);
    }

    @JvmStatic
    public static final void C() {
        if (e != 0) goto L5;
        return;
    L5:
        JSONObject r7 = new JSONObject();
        i97.a r0 = i97.a.a;
        r7.put("duration", System.currentTimeMillis() - e);
        e = 0;
        c.o(c.a, LinkMonitorData.LiveCoreVideoCaptureFirstFrame, r7, 0, null, false, 28);
    }

    @JvmStatic
    public static final void F() {
        i97.a r0 = i97.a.a;
        e = System.currentTimeMillis();
        JSONObject r4 = new JSONObject();
        c.o(c.a, LinkMonitorData.LiveCoreVideoCaptureStarted, r4, 0, null, false, 28);
    }

    @JvmStatic
    public static final void c0() {
        JSONObject r7 = new JSONObject();
        a(r7);
        if (f == false) goto L6;
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "startRtc", 0, null, r7, 88);
    L8:
        c.o(c.a, LinkMonitorData.StartRtc, r7, 0, null, false, 28);
        return;
    L6:
        if (g == false) goto L8;
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "startRtc", 0, null, r7, 88);
        goto L8
    }

    @JvmStatic
    public static final void h0() {
        JSONObject r7 = new JSONObject();
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "stopRtc", 0, null, r7, 88);
        c.o(c.a, LinkMonitorData.StopRtc, r7, 0, null, false, 28);
    }

    @JvmStatic
    public static final void p() {
        JSONObject r7 = new JSONObject();
        a(r7);
        if (f == false) goto L7;
        MultiTraceData$TraceEvent r0 = MultiTraceData$TraceEvent.AudienceApplyLink;
    L5:
        MultiTraceData$TraceEvent r1 = r0;
        if (r1 == null) goto L12;
        int r2 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, r1, "start_join_channel", 0, null, r7, 88);
    L12:
        c.s(c.a, LinkMonitorData.StartJoinChannel, null, 0, "", r7, 98);
        return;
    L7:
        if (g == false) goto L9;
        r0 = MultiTraceData$TraceEvent.InviteAudienceLink;
        goto L5
    L9:
        r0 = null;
        goto L5
    }

    @JvmStatic
    public static final void z() {
        JSONObject r2 = new JSONObject();
        a(r2);
        if (f == false) goto L6;
        i97.a r0 = i97.a.a;
        long r4 = System.currentTimeMillis() - c;
        r2.put("duration", r4);
        jy0.b.a("ttlive_multi_advance_link", "advance apply link rtc set up duration " + r4);
        c.o(c.a, LinkMonitorData.ApplyRTCSetupSuccess, r2, 0, null, false, 28);
        return;
    L6:
        if (g == false) goto L10;
        i97.a r1 = i97.a.a;
        long r5 = System.currentTimeMillis() - d;
        r2.put("duration", r5);
        jy0.b.a("ttlive_multi_advance_link", "advance reply link rtc set up duration " + r5);
        c.o(c.a, LinkMonitorData.ReplyRTCSetupSuccess, r2, 0, null, false, 28);
        return;
    }

    @JvmStatic
    public static final void J(com.bytedance.android.live.liveinteract.multianchor.model.b r7) {
        JSONObject r2 = new JSONObject();
        String r0 = null;
        if (r7 == null) goto L5;
        Intrinsics.checkNotNullParameter(r7, "$this$messageIdExt");
        Long r1 = Long.valueOf(r7.getMessageId2());
    L6:
        r2.put("msg_id", r1);
        if (r7 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "$this$fromUserId");
        r0 = r7.get_fromUserId();
    L9:
        r2.put("from_user_id", r0);
        c.o(c.a, LinkMonitorData.AdminFirstInviteMessage, r2, 0, null, false, 28);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void K(z0 r7) {
        JSONObject r2 = new JSONObject();
        Long r0 = null;
        if (r7 == null) goto L5;
        Intrinsics.checkNotNullParameter(r7, "$this$messageIdExt");
        Long r1 = Long.valueOf(r7.getMessageId2());
    L6:
        r2.put("msg_id", r1);
        if (r7 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "$this$fromUserId");
        String r3 = r7.get_fromUserId();
    L10:
        r2.put("from_user_id", r3);
        if (r7 == null) goto L13;
        Integer r4 = Integer.valueOf(r7.getReplyType());
    L14:
        r2.put("reply_type", r4);
        if (r7 != null) goto L17;
    L25:
        Map<String, Long> r5 = b;
        if (r7 == null) goto L29;
        Intrinsics.checkNotNullParameter(r7, "$this$fromUserId");
        String r8 = r7.get_fromUserId();
        if (r8 == null) goto L29;
    L30:
        i97.a r6 = i97.a.a;
        r5.put(r8, Long.valueOf(System.currentTimeMillis()));
    L31:
        c.o(c.a, LinkMonitorData.ReplyMessage, r2, 0, null, false, 28);
        return;
    L29:
        r8 = "";
        goto L30
    L17:
        if (r7.getReplyType() != ReplyType.Reject.ordinal()) goto L25;
        Set<Long> r9 = a;
        Intrinsics.checkNotNullParameter(r7, "$this$fromUserId");
        String r10 = r7.get_fromUserId();
        if (r10 == null) goto L21;
        r0 = StringsKt.toLongOrNull(r10);
    L21:
        if (r9 == null) goto L24;
        TypeIntrinsics.asMutableCollection(r9).remove(r0);
        goto L31
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void L(String r8) {
        Intrinsics.checkNotNullParameter(r8, "linkMicId");
        JSONObject r3 = new JSONObject();
        r3.put("link_user_id", h(r8));
        r3.put("link_mic_id", r8);
        c.o(c.a, LinkMonitorData.RTCFirstAudioFrame, r3, 0, null, false, 28);
    }

    @JvmStatic
    public static final void M(String r8) {
        Intrinsics.checkNotNullParameter(r8, "linkMicId");
        JSONObject r3 = new JSONObject();
        r3.put("link_user_id", h(r8));
        r3.put("link_mic_id", r8);
        c.o(c.a, LinkMonitorData.RTCFirstVideoFrame, r3, 0, null, false, 28);
    }

    @JvmStatic
    public static final void O(String r8) {
        JSONObject r7 = new JSONObject();
        c.o(c.a, LinkMonitorData.RTCConnectionLost, r7, 0, String.valueOf(r8), false, 20);
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.RtcLinkError, "rtc_connection_lost", 0, String.valueOf(r8), r7, 72);
    }

    @JvmStatic
    public static final void Q(String r15) {
        Intrinsics.checkNotNullParameter(r15, "linkMicId");
        JSONObject r3 = new JSONObject();
        String r0 = h(r15);
        r3.put("link_mic_id", r15);
        r3.put("link_user_id", r0);
        Set<Long> r1 = a;
        if (CollectionsKt.contains(r1, StringsKt.toLongOrNull(r0)) == false) goto L12;
        Long r2 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L11;
        TypeIntrinsics.asMutableCollection(r1).remove(r2);
        r3.put("link_source", "invite");
        Map<String, Long> r4 = b;
        Long r5 = (Long) ((LinkedHashMap) r4).get(r0);
        if (r5 == null) goto L9;
        long r6 = r5.longValue();
        i97.a r7 = i97.a.a;
        long r8 = System.currentTimeMillis() - r6;
        JSONObject r10 = new JSONObject();
        r10.put("link_user_id", r0);
        r10.put("duration", r8);
        c.o(c.a, LinkMonitorData.InviteLinkSuccess, r10, 0, null, false, 28);
    L9:
        r4.remove(r0);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L12:
        c.o(c.a, LinkMonitorData.RTCUserJoined, r3, 0, null, false, 28);
    }

    @JvmStatic
    public static final void S(int r9) {
        if (e.b() == true) goto L6;
        int r0 = rd0.b.a;
        if (hd0.c.f().h() == true) goto L6;
        return;
    L6:
        JSONObject r7 = new JSONObject();
        r7.put("signal_type", r9);
        c.s(c.a, LinkMonitorData.StartSendSignaling, null, 0, "", r7, 98);
    }

    @JvmStatic
    public static final void V(String r9) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.s(c.a, LinkMonitorData.StartSilence, null, 0, "", r7, 98);
    }

    public static void a(JSONObject r2) {
        if (f == false) goto L6;
        LinkSource r0 = LinkSource.APPLY;
    L9:
        r2.put("link_source", r0.getDes());
        return;
    L6:
        if (g == false) goto L8;
        r0 = LinkSource.REPLY;
        goto L9
    L8:
        r0 = LinkSource.JOIN;
        goto L9
    }

    @JvmStatic
    public static final void e0(long r8) {
        JSONObject r7 = new JSONObject();
        a(r7);
        r7.put("duration", r8);
        if (f == false) goto L6;
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "startRtcSuccess", 0, null, r7, 88);
    L8:
        c.o(c.a, LinkMonitorData.RTCStartSuccess, r7, 0, null, false, 28);
        return;
    L6:
        if (g == false) goto L8;
        int r10 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "startRtcSuccess", 0, null, r7, 88);
        goto L8
    }

    @JvmStatic
    public static final void g0(String r7) {
        JSONObject r2 = new JSONObject();
        r2.put("rtc_ext_info", r7);
        c.o(c.a, LinkMonitorData.StopForwardRoom, r2, 0, null, false, 28);
    }

    public static String h(String r1) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        i<? extends ILinkPlayerInfoBridge> r0 = ((n) k.n(n.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L8;
        IBaseUser r2 = r0.U4(r1);
        if (r2 == null) goto L8;
        String r3 = r2.getIdString();
        if (r3 == null) goto L8;
        return r3;
    L8:
        return "";
    }

    @JvmStatic
    public static final void j0(long r8) {
        JSONObject r7 = new JSONObject();
        r7.put("duration", r8);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "stopRtcSuccess", 0, null, r7, 88);
        c.o(c.a, LinkMonitorData.RTCStopSuccess, r7, 0, null, false, 28);
    }

    public static void k(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > 15000) goto L20;
        JSONObject r0 = new JSONObject();
        r0.put("duration", r10);
        a(r0);
        if (f == false) goto L12;
        MultiTraceData$TraceEvent r11 = MultiTraceData$TraceEvent.AudienceApplyLink;
    L10:
        MultiTraceData$TraceEvent r4 = r11;
        if (r4 == null) goto L17;
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, r4, "init_live_core", 0, null, r0, 88);
    L17:
        c.o(c.a, LinkMonitorData.InitLiveClient, r0, 0, null, false, 28);
        return;
    L12:
        if (g == false) goto L14;
        r11 = MultiTraceData$TraceEvent.InviteAudienceLink;
        goto L10
    L14:
        r11 = null;
        goto L10
    }

    @JvmStatic
    public static final void m0(String r7) {
        JSONObject r2 = new JSONObject();
        r2.put("trace_null_client", "client = null");
        r2.put("req_src", r7);
        c.o(c.a, LinkMonitorData.StopForwardRoom, r2, 0, null, false, 28);
    }

    @JvmStatic
    public static final void n0(String r9) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.s(c.a, LinkMonitorData.StartUnSilence, null, 0, "", r7, 98);
    }

    @JvmStatic
    public static final void s(String r9) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.s(c.a, LinkMonitorData.StartKickOut, null, 0, "", r7, 98);
    }

    public static void u0(String r7) {
        JSONObject r2 = new JSONObject();
        r2.put("rtc_ext_info", r7);
        c.o(c.a, LinkMonitorData.UpdateRtcExtInfo, r2, 0, null, false, 28);
    }

    @JvmStatic
    public static final void v(String r8) {
        JSONObject r7 = new JSONObject();
        r7.put("request_source", r8);
        a(r7);
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "start_leave", 0, ExceptionsKt.stackTraceToString(new Throwable()), r7, 64);
        c.s(c.a, LinkMonitorData.StartLeave, null, 0, "", r7, 98);
    }

    public static /* synthetic */ void E(String r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        LinkSource r0 = LinkSource.UNKNOWN;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = "null";
    L9:
        D(r0, r3, 0, false);
        return;
    L5:
        r0 = null;
        goto L7
    }

    @JvmStatic
    public static final void G(String r8, String r9) {
        JSONObject r6 = new JSONObject();
        r6.put("to_user_id", r8);
        r6.put("sec_to_user_id", r9);
        c.s(c.a, LinkMonitorData.StartPermit, null, 0, "", r6, 98);
    }

    @JvmStatic
    public static final void N(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "linkMicId");
        JSONObject r3 = new JSONObject();
        r3.put("link_user_id", h(r8));
        r3.put("link_mic_id", r8);
        r3.put("duration", r9);
        c.o(c.a, LinkMonitorData.RTCFirstVideoFrameRender, r3, 0, null, false, 28);
    }

    @JvmStatic
    public static final void P(int r8, String r9) {
        JSONObject r7 = new JSONObject();
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.RtcLinkError, "rtcError", r8, r9, r7, 64);
        c.o(c.a, LinkMonitorData.RTCError, r7, r8, String.valueOf(r9), false, 16);
    }

    @JvmStatic
    public static final void R(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "linkMicId");
        JSONObject r3 = new JSONObject();
        String r0 = h(r8);
        r3.put("link_mic_id", r8);
        r3.put("link_user_id", r0);
        r3.put("duration", r9);
        c.o(c.a, LinkMonitorData.RTCUserLeaved, r3, 0, null, false, 28);
    }

    public static void Y(int r7, String r8) {
        JSONObject r2 = new JSONObject();
        c r0 = c.a;
        LinkMonitorData r1 = LinkMonitorData.LiveCoreAudioCaptureFailed;
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        c.o(r0, r1, r2, r7, r8, false, 16);
    }

    @JvmStatic
    public static final void a0(String r7, String r8) {
        JSONObject r2 = new JSONObject();
        r2.put("stat", r7);
        r2.put("params", r8);
        c.o(c.a, LinkMonitorData.RTCForwardRoomFailed, r2, -1, r7, false, 16);
    }

    @JvmStatic
    public static final void d0(int r8, String r9) {
        JSONObject r7 = new JSONObject();
        a(r7);
        if (f == false) goto L6;
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "startRtcFailed", r8, r9, r7, 64);
    L8:
        c.o(c.a, LinkMonitorData.RTCStartFailed, r7, r8, String.valueOf(r9), false, 16);
        return;
    L6:
        if (g == false) goto L8;
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "startRtcFailed", r8, r9, r7, 64);
        goto L8
    }

    @JvmStatic
    public static final void f(int r8, int r9) {
        JSONObject r7 = new JSONObject();
        r7.put("link_type", r9);
        r7.put("operation_type", r8);
        if (r8 != OperateType.APPLY.ordinal()) goto L6;
        int r10 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "checkLinkPermission", 0, null, r7, 88);
    L8:
        c.o(c.a, LinkMonitorData.CheckLinkPermission, r7, 0, null, false, 28);
        return;
    L6:
        if (r8 != OperateType.REPLY.ordinal()) goto L8;
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "checkLinkPermission", 0, null, r7, 88);
        goto L8
    }

    @JvmStatic
    public static final void f0(int r9, String r10) {
        e = 0;
        JSONObject r4 = new JSONObject();
        c r2 = c.a;
        LinkMonitorData r3 = LinkMonitorData.LiveCoreVideoCaptureFailed;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        c.o(r2, r3, r4, r9, r10, false, 16);
    }

    @JvmStatic
    public static final void i0(long r8, String r10) {
        JSONObject r7 = new JSONObject();
        int r0 = rd0.a.a;
        int r9 = (int) r8;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "stopRtcFailed", r9, String.valueOf(r10), r7, 64);
        c.o(c.a, LinkMonitorData.RTCStopFailed, r7, r9, String.valueOf(r10), false, 16);
    }

    @JvmStatic
    public static final void k0(boolean r7, String r8) {
        JSONObject r2 = new JSONObject();
        r2.put("enable", r7);
        if (r8 != null) goto L5;
    L7:
        r2.put("reason", ExceptionsKt.stackTraceToString(new Throwable()));
    L8:
        c.o(c.a, LinkMonitorData.SwitchAudio, r2, 0, null, false, 28);
        return;
    L5:
        if ((!StringsKt.isBlank(r8)) != true) goto L7;
        r2.put("reason", r8);
        goto L8
    }

    @JvmStatic
    public static final void l0(MixStreamType r7, MixStreamType r8) {
        JSONObject r2 = new JSONObject();
        r2.put("from", r7);
        r2.put("to", r8);
        c.o(c.a, LinkMonitorData.SwitchMixType, r2, 0, null, false, 28);
    }

    @JvmStatic
    public static final void m(String r8, String r9) {
        JSONObject r6 = new JSONObject();
        r6.put("to_user_id", r8);
        r6.put("sec_to_user_id", r9);
        c.s(c.a, LinkMonitorData.StartInviteAudience, null, 0, "", r6, 98);
    }

    @JvmStatic
    public static final void q(long r10, Throwable r12) {
        JSONObject r7 = new JSONObject();
        a(r7);
        c r8 = c.a;
        r8.getClass();
        Pair r0 = c.t(r12, r7);
        if (f == false) goto L6;
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "joinChannel", ((Number) r0.getFirst()).intValue(), (String) r0.getSecond(), r7, 64);
    L8:
        c.r(r8, LinkMonitorData.JoinChannel, null, r10, r12, r7, 34);
        return;
    L6:
        if (g == false) goto L8;
        int r2 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "joinChannel", ((Number) r0.getFirst()).intValue(), (String) r0.getSecond(), r7, 64);
        goto L8
    }

    @JvmStatic
    public static final void q0(int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "targetUserId");
        JSONObject r7 = new JSONObject();
        r7.put("link_type", r9);
        r7.put("to_user_id", r10);
        c.s(c.a, LinkMonitorData.StartUpdateLinkType, null, 0, "", r7, 98);
    }

    @JvmStatic
    public static final void T(int r9, long r10, Throwable r12) {
        if (e.b() == true) goto L6;
        int r0 = rd0.b.a;
        if (hd0.c.f().h() == true) goto L6;
        return;
    L6:
        JSONObject r7 = new JSONObject();
        r7.put("signal_type", r9);
        c.r(c.a, LinkMonitorData.SendSignaling, null, r10, r12, r7, 34);
    }

    @JvmStatic
    public static final void U(int r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "logId");
        if (e.b() == true) goto L6;
        int r0 = rd0.b.a;
        if (hd0.c.f().h() == true) goto L6;
        return;
    L6:
        JSONObject r7 = new JSONObject();
        r7.put("signal_type", r9);
        c.s(c.a, LinkMonitorData.SendSignaling, null, r10, r12, r7, 98);
    }

    @JvmStatic
    public static final void W(String r9, long r10, Throwable r12) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.r(c.a, LinkMonitorData.Silence, null, r10, r12, r7, 34);
    }

    @JvmStatic
    public static final void X(String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        Intrinsics.checkNotNullParameter(r12, "logId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.s(c.a, LinkMonitorData.Silence, null, r10, r12, r7, 98);
    }

    @JvmStatic
    public static final void Z(String r7, String r8, String r9) {
        JSONObject r2 = new JSONObject();
        r2.put("to_room_id", r7);
        r2.put("rtc_ext_info", r8);
        r2.put("remote_rtc_ext_info", r9);
        c.o(c.a, LinkMonitorData.StartForwardRoom, r2, 0, null, false, 28);
    }

    @JvmStatic
    public static final void b(int r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "applySource");
        f = true;
        g = false;
        JSONObject r7 = new JSONObject();
        r7.put("apply_position", r9);
        r7.put("apply_link_type", r10);
        r7.put("apply_source", r11);
        c.s(c.a, LinkMonitorData.StartApply, null, 0, "", r7, 98);
    }

    @JvmStatic
    public static final void b0(Object r7, Object r8, long r9) {
        JSONObject r2 = new JSONObject();
        r2.put("stat", String.valueOf(r7));
        r2.put("params", String.valueOf(r8));
        r2.put("duration", r9);
        c.o(c.a, LinkMonitorData.RTCForwardRoomSuccess, r2, 0, null, false, 28);
    }

    @JvmStatic
    public static final void e(int r8, int r9, Throwable r10) {
        JSONObject r7 = new JSONObject();
        f = false;
        g = false;
        r7.put("operation_type", r8);
        r7.put("link_type", r9);
        c r11 = c.a;
        r11.getClass();
        Pair r12 = c.t(r10, r7);
        if (r8 != OperateType.APPLY.ordinal()) goto L6;
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "checkLinkPermission", ((Number) r12.getFirst()).intValue(), (String) r12.getSecond(), r7, 64);
    L8:
        c.o(r11, LinkMonitorData.CheckLinkPermission, r7, ((Number) r12.getFirst()).intValue(), (String) r12.getSecond(), false, 16);
        return;
    L6:
        if (r8 != OperateType.REPLY.ordinal()) goto L8;
        int r14 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "checkLinkPermission", ((Number) r12.getFirst()).intValue(), (String) r12.getSecond(), r7, 64);
        goto L8
    }

    @JvmStatic
    public static final void i(String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "supportedScene");
        Intrinsics.checkNotNullParameter(r11, "openSource");
        JSONObject r0 = new JSONObject();
        r0.put("supported_scene", r9);
        r0.put("request_scene", r10);
        r0.put("open_source", r11);
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "startInit", 0, null, r0, 88);
        c.s(c.a, LinkMonitorData.StartInit, null, 0, "", r0, 98);
        Intrinsics.checkNotNullParameter("ttlive_link", "tag");
        d.a(3, "ttlive_link", ThreadMethodProxy.currentThread().getStackTrace());
    }

    @JvmStatic
    public static final void o0(String r9, long r10, Throwable r12) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.r(c.a, LinkMonitorData.UnSilence, null, r10, r12, r7, 34);
    }

    @JvmStatic
    public static final void p0(String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        Intrinsics.checkNotNullParameter(r12, "logId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.s(c.a, LinkMonitorData.UnSilence, null, r10, r12, r7, 98);
    }

    @JvmStatic
    public static final void t(String r9, long r10, Throwable r12) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.r(c.a, LinkMonitorData.KickOut, null, r10, r12, r7, 34);
    }

    @JvmStatic
    public static final void u(String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        Intrinsics.checkNotNullParameter(r12, "logId");
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        c.s(c.a, LinkMonitorData.KickOut, null, r10, r12, r7, 98);
    }

    @JvmStatic
    public static final void w(String r9, long r10, Throwable r12) {
        JSONObject r7 = new JSONObject();
        r7.put("request_source", r9);
        c r11 = c.a;
        r11.getClass();
        Pair r0 = c.t(r12, r7);
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "leaveChannel", ((Number) r0.getFirst()).intValue(), (String) r0.getSecond(), r7, 64);
        c.r(r11, LinkMonitorData.Leave, null, r10, r12, r7, 34);
    }

    @JvmStatic
    public static final void x(String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r12, "logId");
        JSONObject r0 = new JSONObject();
        a(r0);
        r0.put("request_source", r9);
        int r11 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "leaveChannel", 0, ExceptionsKt.stackTraceToString(new Throwable()), r0, 64);
        c.s(c.a, LinkMonitorData.Leave, null, r10, r12, r0, 98);
    }

    @JvmStatic
    public static final void D(LinkSource r10, String r11, long r12, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "linkType");
        Intrinsics.checkNotNullParameter(r11, "linkOptInfo");
        if (r10 == LinkSource.UNKNOWN) goto L7;
        if (r12 <= 0) goto L7;
    L12:
        JSONObject r0 = new JSONObject();
        r0.put("link_source", r10.getDes());
        r0.put("duration", r12);
        r0.put("link_opt_info", r11);
        if (r14 == false) goto L15;
        String r13 = "LinkSuccessFirstFrame";
    L16:
        int r15 = nd0.d.a[r10.ordinal()];
        if (r15 != 1) goto L19;
    L28:
        c r3 = c.a;
        if (r14 == false) goto L31;
        LinkMonitorData r16 = LinkMonitorData.LinkSuccessFirstFrame;
    L32:
        c.o(r3, r16, r0, 0, null, false, 28);
        int r17 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, r13, 0, null, r0, 88);
    L33:
        c = 0;
        d = 0;
        f = false;
        g = false;
        return;
    L31:
        r16 = LinkMonitorData.ApplyLinkSuccess;
        goto L32
    L19:
        if (r15 == 2) goto L28;
        if (r15 != 3) goto L33;
        c r4 = c.a;
        if (r14 == false) goto L26;
        LinkMonitorData r18 = LinkMonitorData.LinkSuccessFirstFrame;
    L27:
        c.o(r4, r18, r0, 0, null, false, 28);
        int r19 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, r13, 0, null, r0, 88);
        goto L33
    L26:
        r18 = LinkMonitorData.ReplyLinkSuccess;
        goto L27
    L15:
        r13 = "LinkSuccess";
    L7:
        if (f == false) goto L10;
        i97.a r110 = i97.a.a;
        r12 = System.currentTimeMillis() - c;
        r10 = LinkSource.APPLY;
        goto L12
    L10:
        if (g == false) goto L12;
        i97.a r111 = i97.a.a;
        r12 = System.currentTimeMillis() - d;
        r10 = LinkSource.REPLY;
        goto L12
    }

    @JvmStatic
    public static final void H(String r8, String r9, long r10, Throwable r12) {
        JSONObject r6 = new JSONObject();
        r6.put("to_user_id", r8);
        r6.put("sec_to_user_id", r9);
        c.r(c.a, LinkMonitorData.Permit, null, r10, r12, r6, 34);
    }

    @JvmStatic
    public static final void g(String r9, String r10, long r11, Throwable r13) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        JSONObject r7 = new JSONObject();
        r7.put("request_source", r9);
        r7.put("reason", r10);
        c.r(c.a, LinkMonitorData.CheckLinkers, null, r11, r13, r7, 34);
    }

    @JvmStatic
    public static final void n(String r9, String r10, long r11, Throwable r13) {
        Intrinsics.checkNotNullParameter(r10, "secToUserId");
        JSONObject r0 = new JSONObject();
        r0.put("to_user_id", r9);
        r0.put("sec_to_user_id", r10);
        Set<Long> r12 = a;
        if (r9 == null) goto L5;
        Long r14 = StringsKt.toLongOrNull(r9);
    L6:
        if (r12 == null) goto L10;
        TypeIntrinsics.asMutableCollection(r12).remove(r14);
        c r15 = c.a;
        r15.getClass();
        Pair r16 = c.t(r13, r0);
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "invite", ((Number) r16.getFirst()).intValue(), (String) r16.getSecond(), r0, 64);
        c.r(r15, LinkMonitorData.InviteAudience, null, r11, r13, r0, 34);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L5:
        r14 = null;
        goto L6
    }

    @JvmStatic
    public static final void r0(int r9, String r10, long r11, Throwable r13) {
        Intrinsics.checkNotNullParameter(r10, "targetUserId");
        JSONObject r7 = new JSONObject();
        r7.put("link_type", r9);
        r7.put("to_user_id", r10);
        c.r(c.a, LinkMonitorData.UpdateLinkType, null, r11, r13, r7, 34);
    }

    @JvmStatic
    public static final void s0(int r9, String r10, long r11, String r13) {
        Intrinsics.checkNotNullParameter(r10, "targetUserId");
        Intrinsics.checkNotNullParameter(r13, "logId");
        JSONObject r7 = new JSONObject();
        r7.put("link_type", r9);
        r7.put("to_user_id", r10);
        c.s(c.a, LinkMonitorData.UpdateLinkType, null, r11, r13, r7, 98);
    }

    @JvmStatic
    public static final void I(String r9, String r10, long r11, String r13, t2 r14) {
        Intrinsics.checkNotNullParameter(r13, "logId");
        Intrinsics.checkNotNullParameter(r14, "response");
        b r0 = h;
        if (r0 == null) goto L5;
        r0.Jm(r14.getRemoteLinkerSessionId());
    L5:
        JSONObject r7 = new JSONObject();
        r7.put("to_user_id", r9);
        r7.put("sec_to_user_id", r10);
        c.s(c.a, LinkMonitorData.Permit, null, r11, r13, r7, 98);
    }

    @JvmStatic
    public static final void c(int r9, int r10, String r11, long r12, Throwable r14) {
        Intrinsics.checkNotNullParameter(r11, "applySource");
        JSONObject r0 = new JSONObject();
        f = false;
        r0.put("apply_position", r9);
        r0.put("apply_link_type", r10);
        r0.put("apply_source", r11);
        c r13 = c.a;
        r13.getClass();
        Pair r15 = c.t(r14, r0);
        int r16 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "apply", ((Number) r15.getFirst()).intValue(), (String) r15.getSecond(), r0, 64);
        c.r(r13, LinkMonitorData.Apply, null, r12, r14, r0, 34);
    }

    @JvmStatic
    public static final void j(String r9, int r10, long r11, Throwable r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "supportedScene");
        Intrinsics.checkNotNullParameter(r14, "openSource");
        JSONObject r0 = new JSONObject();
        r0.put("supported_scene", r9);
        r0.put("request_scene", r10);
        r0.put("open_source", r14);
        c r12 = c.a;
        r12.getClass();
        Pair r15 = c.t(r13, r0);
        int r16 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "init", ((Number) r15.getFirst()).intValue(), (String) r15.getSecond(), r0, 64);
        c.r(r12, LinkMonitorData.Init, null, r11, r13, r0, 34);
    }

    @JvmStatic
    public static final void o(String r9, String r10, long r11, String r13, v r14) {
        Intrinsics.checkNotNullParameter(r13, "logId");
        Intrinsics.checkNotNullParameter(r14, "response");
        b r0 = h;
        if (r0 == null) goto L5;
        r0.Jm(r14.getRemoteLinkerSessionId());
    L5:
        JSONObject r15 = new JSONObject();
        r15.put("to_user_id", r9);
        r15.put("sec_to_user_id", r10);
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "invite", 0, null, r15, 80);
        c.s(c.a, LinkMonitorData.InviteAudience, null, r11, r13, r15, 98);
    }

    @JvmStatic
    public static final void r(String r14, Long r15, String r16, long r17, String r19) {
        Intrinsics.checkNotNullParameter(r19, "logId");
        if (r17 > 0) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("token", r14);
        r0.put("list_version", r15);
        r0.put("list_data", r16);
        a(r0);
        if (f == false) goto L9;
        int r1 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "joinChannel", 0, null, r0, 88);
    L11:
        c.s(c.a, LinkMonitorData.JoinChannel, null, r17, r19, r0, 98);
        return;
    L9:
        if (g == false) goto L11;
        int r2 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "joinChannel", 0, null, r0, 88);
        goto L11
    }

    @JvmStatic
    public static final void t0(String r8, String r9, String r10, u1 r11, v1 r12) {
        Intrinsics.checkNotNullParameter(r8, "fromSource");
        JSONObject r3 = new JSONObject();
        r3.put("from_source", r8);
        if (r9 == null) goto L5;
        r3.put("live_core_ext_info_from_server", r9);
    L5:
        if (r11 == null) goto L7;
        r3.put("multi_live_core_ext_info_from_server", GsonProtectorUtils.toJson(l97.a.a, r11));
    L7:
        if (r10 == null) goto L9;
        r3.put("rtc_ext_info_from_server", r10);
    L9:
        if (r12 == null) goto L11;
        r3.put("multi_rtc_ext_info_from_server", GsonProtectorUtils.toJson(l97.a.a, r12));
    L11:
        c.o(c.a, LinkMonitorData.UpdateLiveCoreAndRtcExtInfoFromServer, r3, 0, null, false, 28);
    }

    public static void y(int r7, Boolean r8, Boolean r9, int r10, int r11) {
        JSONObject r2 = new JSONObject();
        r2.put("diff_count", r7);
        r2.put("video_capture_is_open", r8);
        r2.put("audio_capture_is_open", r9);
        r2.put("silence_status", r10);
        r2.put("link_type", r11);
        c.o(c.a, LinkMonitorData.LinkSecurityCheckCountLog, r2, 0, null, false, 28);
    }

    @JvmStatic
    public static final void d(int r15, int r16, String r17, int r18, int r19, long r20, String r22) {
        Intrinsics.checkNotNullParameter(r17, "applySource");
        Intrinsics.checkNotNullParameter(r22, "logId");
        JSONObject r1 = new JSONObject();
        r1.put("apply_position", r15);
        r1.put("apply_link_type", r16);
        r1.put("apply_source", r17);
        r1.put("is_auto_join", r18);
        r1.put("is_auto_join_full", r19);
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "apply", 0, null, r1, 80);
        c.s(c.a, LinkMonitorData.Apply, null, r20, r22, r1, 98);
    }

    @JvmStatic
    public static final void l(String r17, int r18, int r19, j0 r20, long r21, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r17, "supportedScene");
        Intrinsics.checkNotNullParameter(r20, "initResult");
        Intrinsics.checkNotNullParameter(r23, "logId");
        Intrinsics.checkNotNullParameter(r24, "openSource");
        b r2 = h;
        if (r2 == null) goto L5;
        r2.Ah(r20.getLinkerSessionId());
    L5:
        JSONObject r3 = new JSONObject();
        r3.put("response_scene", r19);
        r3.put("supported_scene", r17);
        r3.put("request_scene", r18);
        r3.put("open_source", r24);
        int r0 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "init", 0, null, r3, 88);
        c.s(c.a, LinkMonitorData.Init, null, r21, r23, r3, 98);
        t0("init_success", r20.getLiveCoreExtInfo(), r20.getRtcExtInfo(), r20.getMultiLiveCoreInfo(), r20.getMultiRtcInfo());
    }
}
