package com.bytedance.android.live.livepkaudience.base;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.chatroom.model.ApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.LeaveChannelResponse;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.AudienceLinkReplyResult;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.chatroom.model.r1;
import com.bytedance.android.livesdk.config.rp;
import com.bytedance.android.livesdk.link.model.bridge.i0;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements vlc.l {
    public final vlc.d a;
    public final CompositeDisposable b;
    public final ArrayList<com.bytedance.android.live.livepkaudience.base.h> c;
    public String d;
    public MultiChannelInfo e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public MultiLiveCoreInfo m;
    public MultiRtcInfo n;
    public final DataCenter o;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ LinkApplyType e;

        public a(q r1, int r2, int r3, long r4, LinkApplyType r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r15) {
            com.bytedance.android.live.network.response.e r16 = (com.bytedance.android.live.network.response.e) r15;
            Intrinsics.checkNotNullParameter(r16, "response");
            ApplyResult r17 = (IApplyResult) r16.data;
            if (TextUtils.isEmpty(r17.getLinkMicIdStr()) == false) goto L7;
            tc0.c r0 = tc0.c.h();
            r0.f = String.valueOf(r17.getLinkMicId());
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r1 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            if (r1 == null) goto L10;
            r1.setAudienceSelfLinkMicId(String.valueOf(r17.getLinkMicId()));
        L10:
            hd0.c.f().k(1);
            hd0.c r2 = hd0.c.f();
            int r3 = this.b;
            r2.g = r3;
            int r4 = this.c;
            String r5 = String.valueOf(r3);
            boolean r6 = r17.getAutoJoin();
            boolean r7 = r17.getAutoJoinFull();
            long r8 = this.d;
            long r11 = System.currentTimeMillis() - r8;
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r9 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            if (r9 == null) goto L14;
            String r10 = r9.getAudienceSelfLinkMicId();
            if (r10 == null) goto L14;
        L15:
            dl0.m r12 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r5, "applyMode");
            Intrinsics.checkNotNullParameter(r10, "linkmicId");
            JSONObject r13 = new JSONObject();
            BaseMonitor.add(r13, "apply_position", r4);
            BaseMonitor.add(r13, "apply_mode", r5);
            BaseMonitor.add(r13, "link_mic_id", r10);
            BaseMonitor.add(r13, "is_auto_join", r6 ? 1 : 0);
            BaseMonitor.add(r13, "added_to_alternate_list", r7 ? 1 : 0);
            dl0.m.a.getClass();
            dl0.m.z("audience_apply", 0, "", r11, r13);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r14 = this.a.c.iterator();
        L17:
            if (r14.hasNext() == false) goto L19;
            this.e.getValue();
            r14.next().Ee(r17);
            goto L17
        L19:
            f2.c(r17.getPrompts(), 0);
            this.a.i = false;
            return;
        L14:
            r10 = "";
            goto L15
        L7:
            tc0.c r18 = tc0.c.h();
            r18.f = r17.getLinkMicIdStr();
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r19 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            if (r19 == null) goto L10;
            r19.setAudienceSelfLinkMicId(r17.getLinkMicIdStr());
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ LinkApplyType e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Integer h;
        public final /* synthetic */ Integer i;
        public final /* synthetic */ Integer j;
        public final /* synthetic */ long k;

        public b(q r1, int r2, int r3, int r4, LinkApplyType r5, boolean r6, String r7, Integer r8, Integer r9, Integer r10, long r11) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
        }

        public final void accept(Object r13) {
            ApiServerException r14 = (Throwable) r13;
            new qh0.h(this.c, new PkGuestLinkManager$apply$4$1(this), PkGuestLinkManager$apply$4$2.INSTANCE).c(r14);
            int r0 = this.d;
            String r1 = String.valueOf(this.c);
            long r2 = this.k;
            long r9 = System.currentTimeMillis() - r2;
            dl0.m r3 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r1, "applyMode");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "apply_position", r0);
            BaseMonitor.add(r11, "apply_mode", r1);
            if (r14 != null) goto L5;
        L11:
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r4 = this.a.c.iterator();
        L13:
            if (r4.hasNext() == false) goto L15;
            r4.next().Q2(r14);
            goto L13
        L15:
            this.a.i = false;
            return;
        L5:
            if ((r14 instanceof ApiServerException) == false) goto L10;
            dl0.m r5 = dl0.m.a;
            ApiServerException r6 = r14;
            int r7 = r6.getErrorCode();
            String r8 = r6.getErrorMsg();
            if (r8 != null) goto L9;
            r8 = "";
        L9:
            r5.getClass();
            dl0.m.z("audience_apply", r7, r8, r9, r11);
            goto L11
        L10:
            dl0.m r10 = dl0.m.a;
            String r12 = r14.toString();
            r10.getClass();
            dl0.m.z("audience_apply", 1, r12, r9, r11);
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ long b;

        public c(q r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            Intrinsics.checkNotNullParameter(r12, "response");
            long r0 = this.b;
            long r7 = System.currentTimeMillis() - r0;
            dl0.m r1 = dl0.m.a;
            JSONObject r9 = new JSONObject();
            dl0.m.a.getClass();
            dl0.m.z("audience_pre_apply", 0, "", r7, r9);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r2 = this.a.c.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            com.bytedance.android.live.livepkaudience.base.h r3 = r2.next();
            a5 r4 = ((r1) r12.data).getDisplayText();
            if ((r4 instanceof Text) == true) goto L8;
            r4 = null;
        L8:
            r3.xn((Text) r4);
            goto L4
        L9:
            this.a.h = false;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ long b;

        public d(q r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            new qh0.h(1, new PkGuestLinkManager$doPrepareApply$2$1(this), PkGuestLinkManager$doPrepareApply$2$2.INSTANCE).c(r6);
            ALogger.w("ttlive_link", "preApply " + r6);
            dl0.m.s(r6, System.currentTimeMillis() - this.b);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r7 = this.a.c.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            r7.next().Ke();
            goto L4
        L6:
            this.a.h = false;
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.b(r0, r4));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ long b;

        public f(q r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            this.a.f = false;
            List r0 = ((i0) r15.data).getLinkedUsers();
            String r1 = null;
            if (r0 == null) goto L18;
            Iterator<T> r2 = r0.iterator();
        L6:
            if (r2.hasNext() == false) goto L18;
            com.bytedance.android.livesdk.link.model.bridge.k r3 = (com.bytedance.android.livesdk.link.model.bridge.k) r2.next();
            if (r3 == null) goto L12;
            IBaseUser r4 = r3.getUser();
            if (r4 == null) goto L12;
            String r5 = r4.getIdString();
        L14:
            if (Intrinsics.areEqual(r5, dl0.n.d()) == false) goto L6;
            tc0.c.h().f = r3.getLinkMicIdStr();
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r6 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            if (r6 == null) goto L6;
            r6.setAudienceSelfLinkMicId(r3.getLinkMicIdStr());
        L12:
            r5 = null;
        L18:
            hd0.c.f().k(2);
            i0 r7 = (i0) r15.data;
            if (r7 == null) goto L21;
            String r8 = r7.getToken();
        L22:
            i0 r9 = (i0) r15.data;
            if (r9 == null) goto L25;
            Long r10 = Long.valueOf(r9.getVersion());
        L26:
            i0 r11 = (i0) r15.data;
            if (r11 == null) goto L31;
            List r12 = r11.getLinkedUsers();
            if (r12 == null) goto L31;
            r1 = dl0.q.a(r12);
        L31:
            long r13 = System.currentTimeMillis() - this.b;
            dl0.m r16 = dl0.m.a;
            JSONObject r17 = new JSONObject();
            if (r8 != null) goto L34;
            r8 = "";
        L34:
            BaseMonitor.add(r17, "token", r8);
            if (r10 == null) goto L37;
            long r18 = r10.longValue();
        L38:
            BaseMonitor.add(r17, "list_version", r18);
            if (r1 == null) goto L41;
            BaseMonitor.add(r17, "list_data", r1);
        L41:
            dl0.m.a.getClass();
            dl0.m.z("audience_join_channel", 0, "", r13, r17);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r19 = this.a.c.iterator();
        L43:
            if (r19.hasNext() == false) goto L45;
            r19.next().b2(new com.bytedance.android.live.network.response.f.b(r15.data, r15.extra));
            goto L43
        L45:
            return;
        L37:
            r18 = -1;
            goto L38
        L25:
            r10 = null;
            goto L26
        L21:
            r8 = null;
            goto L22
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ long b;

        public g(q r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            ApiServerException r12 = (Throwable) r11;
            Intrinsics.checkNotNullParameter(r12, "throwable");
            this.a.f = false;
            long r0 = this.b;
            long r7 = System.currentTimeMillis() - r0;
            dl0.m r1 = dl0.m.a;
            if (r12 != null) goto L5;
        L11:
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r2 = this.a.c.iterator();
        L13:
            if (r2.hasNext() == false) goto L15;
            r2.next().m0(r12);
            goto L13
        L15:
            return;
        L5:
            if ((r12 instanceof ApiServerException) == false) goto L10;
            dl0.m r3 = dl0.m.a;
            ApiServerException r4 = r12;
            int r5 = r4.getErrorCode();
            String r6 = r4.getErrorMsg();
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            JSONObject r9 = new JSONObject();
            r3.getClass();
            dl0.m.z("audience_join_channel", r5, r6, r7, r9);
            goto L11
        L10:
            dl0.m r8 = dl0.m.a;
            String r10 = r12.toString();
            JSONObject r13 = new JSONObject();
            r8.getClass();
            dl0.m.z("audience_join_channel", 1, r10, r7, r13);
            goto L11
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public h(q r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            String r0 = this.b;
            long r8 = System.currentTimeMillis() - this.c;
            dl0.m r1 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r0, "reqFrom");
            JSONObject r10 = new JSONObject();
            BaseMonitor.add(r10, "request_source", r0);
            dl0.m.a.getClass();
            dl0.m.z("audience_leave", 0, "", r8, r10);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r2 = this.a.c.iterator();
        L4:
            if (r2.hasNext() == false) goto L14;
            com.bytedance.android.live.livepkaudience.base.h r3 = r2.next();
            g1 r4 = null;
            if (r13 == null) goto L8;
            g1 r5 = (g1) r13.data;
        L10:
            if ((r5 instanceof LeaveChannelResponse) == false) goto L13;
            r4 = r5;
        L13:
            LeaveChannelResponse r6 = (LeaveChannelResponse) r4;
            r3.I3();
            goto L4
        L8:
            r5 = null;
            goto L10
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public i(q r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            long r0 = this.b;
            dl0.m.u(r6, System.currentTimeMillis() - r0, this.c);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r1 = this.a.c.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().c0(r6);
            goto L4
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public j(q r1, int r2, long r3, String r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r13) {
            com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
            if (r14 == null) goto L53;
            AudienceLinkReplyResult r15 = (com.bytedance.android.livesdk.chatroom.model.interact.m) r14.data;
            if (r15 != null) goto L7;
            return;
        L7:
            if (this.b == ReplyType.Agree.ordinal()) goto L9;
        L37:
            String r0 = this.d;
            int r1 = this.b;
            long r9 = System.currentTimeMillis() - this.e;
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r2 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            String r3 = "";
            if (r2 == null) goto L41;
            String r4 = r2.getAudienceSelfLinkMicId();
            if (r4 == null) goto L41;
        L42:
            String r5 = this.a.d;
            dl0.m r6 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r0, "secToUserId");
            Intrinsics.checkNotNullParameter(r4, "linkmicId");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "to_user_id", 0);
            BaseMonitor.add(r11, "sec_to_user_id", r0);
            BaseMonitor.add(r11, "reply_type", r1);
            BaseMonitor.add(r11, "link_mic_id", r4);
            if (r5 == null) goto L46;
            r3 = r5;
        L46:
            BaseMonitor.add(r11, "rtc_extra_info", r3);
            dl0.m.a.getClass();
            dl0.m.z("audience_reply", 0, "", r9, r11);
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r7 = this.a.c.iterator();
        L48:
            if (r7.hasNext() == false) goto L50;
            r7.next().mo464do(r15, this.b);
            goto L48
        L50:
            this.a.j = false;
            return;
        L41:
            r4 = "";
            goto L42
        L9:
            if (TextUtils.isEmpty(r15.getLinkMicIdStr()) == false) goto L13;
            tc0.c.h().f = String.valueOf(r15.getLinkMicId());
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r8 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            if (r8 == null) goto L16;
            r8.setAudienceSelfLinkMicId(String.valueOf(r15.getLinkMicId()));
        L16:
            this.a.d = r15.getRtcExtInfo();
            q r10 = this.a;
            u1 r12 = r15.getMultiLiveCoreInfo();
            MultiChannelInfo r16 = null;
            if ((r12 instanceof MultiLiveCoreInfo) == true) goto L19;
            r12 = null;
        L19:
            r10.m = (MultiLiveCoreInfo) r12;
            q r17 = this.a;
            v1 r18 = r15.getMultiRtcInfo();
            if ((r18 instanceof MultiRtcInfo) == true) goto L22;
            r18 = null;
        L22:
            r17.n = (MultiRtcInfo) r18;
            q r19 = this.a;
            MultiChannelInfo r20 = r15.getMultiChannelInfo();
            if ((r20 instanceof MultiChannelInfo) == false) goto L26;
            r16 = r20;
        L26:
            r19.e = r16;
            s1 r21 = r15.getMultiChannelInfo();
            if (r21 == null) goto L37;
            if (r21.getUseMultiChannel() != true) goto L37;
            s1 r22 = r15.getMultiChannelInfo();
            if (r22 == null) goto L37;
            Map r23 = r22.getChannelMap();
            if (r23 == null) goto L37;
            String r24 = (String) r23.get(Long.valueOf(this.c));
            if (r24 == null) goto L37;
            this.a.d = r24;
            goto L37
        L13:
            tc0.c.h().f = r15.getLinkMicIdStr();
            com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
            LinkPkInteractGuestDataContext r25 = com.bytedance.android.live.livepkaudience.service.c.a.a();
            if (r25 == null) goto L16;
            r25.setAudienceSelfLinkMicId(r15.getLinkMicIdStr());
            goto L16
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;

        public k(q r1, int r2, int r3, long r4, String r6, int r7, long r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final void accept(Object r13) {
            final ApiServerException r14 = (Throwable) r13;
            new qh0.h(this.c, new PkGuestLinkManager$reply$4$1(this, r14), PkGuestLinkManager$reply$4$2.INSTANCE).c(r14);
            String r0 = this.e;
            int r1 = this.f;
            long r2 = this.g;
            long r9 = System.currentTimeMillis() - r2;
            dl0.m r3 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r0, "secToUserId");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "to_user_id", 0);
            BaseMonitor.add(r11, "sec_to_user_id", r0);
            BaseMonitor.add(r11, "reply_type", r1);
            if (r14 != null) goto L5;
        L11:
            Iterator<com.bytedance.android.live.livepkaudience.base.h> r4 = this.a.c.iterator();
        L13:
            if (r4.hasNext() == false) goto L15;
            r4.next().b1(r14);
            goto L13
        L15:
            this.a.j = false;
            return;
        L5:
            if ((r14 instanceof ApiServerException) == false) goto L10;
            dl0.m r5 = dl0.m.a;
            ApiServerException r6 = r14;
            int r7 = r6.getErrorCode();
            String r8 = r6.getErrorMsg();
            if (r8 != null) goto L9;
            r8 = "";
        L9:
            r5.getClass();
            dl0.m.z("audience_reply", r7, r8, r9, r11);
            goto L11
        L10:
            dl0.m r10 = dl0.m.a;
            String r12 = r14.toString();
            r10.getClass();
            dl0.m.z("audience_reply", 1, r12, r9, r11);
            goto L11
        }
    }

    public final void c() {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        long r0 = System.currentTimeMillis();
        Disposable r1 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApply(d().id, 4, 2, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r0), new d(this, r0));
        this.b.add(r1);
    }

    public final Room d() {
        return (Room) this.o.get("data_room", new Room());
    }

    public final void e() {
        if (HostEnv.a() == false) goto L9;
        if (((Boolean) rp.a.getValue()).booleanValue() == true) goto L9;
        f2.b(2131918784, 0);
        return;
    L9:
        if (this.f == false) goto L11;
        return;
    L11:
        this.f = true;
        long r0 = System.currentTimeMillis();
        Disposable r1 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).joinChannelV1(d().id).subscribeOn(Schedulers.io()).flatMap(e.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r0), new g(this, r0));
        this.b.add(r1);
    }

    public q(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.o = r2;
        this.a = (vlc.d) r2.get("data_message_manager");
        this.b = new CompositeDisposable();
        this.c = new ArrayList();
    }

    public final void f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reqFrom");
        long r0 = System.currentTimeMillis();
        Disposable r7 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(d().id, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r6, r0), new i(this, r0, r6));
        this.b.add(r7);
    }

    public final void onMessage(tlc.d r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        String r3 = "";
        int r4 = 0;
        String r8 = null;
        if ((r18 instanceof xe) == false) goto L86;
        xe r0 = (xe) r18;
        int r1 = (int) r0.getType2();
        if (r1 == 2) goto L50;
        if (r1 != 3) goto L12;
        Intrinsics.checkNotNullParameter(r0, MultiLinkOpenSource.MESSAGE);
        dl0.m.y(r0, r0.getChannelId(), (int) r0.getType2(), System.currentTimeMillis());
        Iterator<com.bytedance.android.live.livepkaudience.base.h> r2 = this.c.iterator();
    L46:
        if (r2.hasNext() == false) goto L48;
        r2.next().Bg(r0);
        goto L46
    L48:
        this.k = true;
        return;
    L12:
        if (r1 == 4) goto L42;
        if (r1 == 12) goto L16;
        return;
    L16:
        if (us1.b.c() == false) goto L19;
        g(d().id, r0.getSecFromUserId(), ReplyType.UnsupportedDevice.ordinal(), 2, 1);
        return;
    L19:
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 == null) goto L23;
        r4 = r5.getLinkMode();
    L23:
        if (gd0.v.a(r4, 2) == false) goto L27;
        g(d().id, r0.getSecFromUserId(), ReplyType.UnsupportedDevice.ordinal(), 2, 1);
        return;
    L27:
        if (TextUtils.isEmpty(r0.getAnchorLinkMicIdStr()) == false) goto L31;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r6 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r6 == null) goto L34;
        r6.setSelfAnchorLinkMicId(String.valueOf(r0.getAnchorLinkMicId()));
    L34:
        tc0.c r7 = tc0.c.h();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r9 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r9 == null) goto L37;
        r8 = r9.getSelfAnchorLinkMicId();
    L37:
        r7.e = r8;
        Intrinsics.checkNotNullParameter(r0, MultiLinkOpenSource.MESSAGE);
        dl0.m.y(r0, r0.getChannelId(), (int) r0.getType2(), System.currentTimeMillis());
        Iterator<com.bytedance.android.live.livepkaudience.base.h> r10 = this.c.iterator();
    L39:
        if (r10.hasNext() == false) goto L141;
        r10.next().bn(r0);
        goto L39
    L141:
        return;
    L31:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r11 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r11 == null) goto L34;
        r11.setSelfAnchorLinkMicId(r0.getAnchorLinkMicIdStr());
        goto L34
    L42:
        if (this.l == false) goto L133;
        this.k = true;
        return;
    L133:
        return;
    L50:
        if (TextUtils.isEmpty(r0.getAnchorLinkMicIdStr()) == false) goto L54;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r12 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r12 == null) goto L57;
        r12.setSelfAnchorLinkMicId(String.valueOf(r0.getAnchorLinkMicId()));
    L57:
        tc0.c r13 = tc0.c.h();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r14 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r14 == null) goto L63;
        String r15 = r14.getSelfAnchorLinkMicId();
        if (r15 == null) goto L63;
        r3 = r15;
    L63:
        r13.e = r3;
        this.d = r0.getRtcExtInfo();
        MultiLiveCoreInfo r16 = r0.getMultiLiveCoreInfo();
        if ((r16 instanceof MultiLiveCoreInfo) == true) goto L66;
        r16 = null;
    L66:
        this.m = r16;
        String r17 = r0.getMultiRtcInfo();
        if ((r17 instanceof MultiRtcInfo) == false) goto L70;
        r8 = r17;
    L70:
        this.n = (MultiRtcInfo) r8;
        this.e = r0.getMultiChannelInfo();
        MultiChannelInfo r19 = r0.getMultiChannelInfo();
        if (r19 != null) goto L73;
    L81:
        dl0.m r20 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r0, MultiLinkOpenSource.MESSAGE);
        dl0.m.x(r0, r0.getChannelId(), (int) r0.getType2(), System.currentTimeMillis(), new JSONObject());
        Iterator<com.bytedance.android.live.livepkaudience.base.h> r21 = this.c.iterator();
    L83:
        if (r21.hasNext() == false) goto L142;
        r21.next().Yn(r0);
        goto L83
    L142:
        return;
    L73:
        if (r19.getUseMultiChannel() != true) goto L81;
        MultiChannelInfo r22 = r0.getMultiChannelInfo();
        if (r22 == null) goto L81;
        Map r23 = r22.getChannelMap();
        if (r23 == null) goto L81;
        String r24 = (String) r23.get(Long.valueOf(d().id));
        if (r24 == null) goto L81;
        this.d = r24;
        goto L81
    L54:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r25 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r25 == null) goto L57;
        r25.setSelfAnchorLinkMicId(r0.getAnchorLinkMicIdStr());
        goto L57
    L86:
        if ((r18 instanceof if) == false) goto L120;
        if r26 = (if) r18;
        int r27 = r26.getMType();
        if (r27 == 2) goto L115;
        if (r27 != 12) goto L91;
        Iterator<com.bytedance.android.live.livepkaudience.base.h> r28 = this.c.iterator();
    L113:
        if (r28.hasNext() == false) goto L144;
        r28.next().Hl(r26);
        goto L113
    L144:
        return;
    L91:
        if (r27 != 101) goto L140;
        Intrinsics.checkNotNullParameter(r26, MultiLinkOpenSource.MESSAGE);
        dl0.m.y(r26, r26.getLinkerId(), r26.getMType(), System.currentTimeMillis());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L107;
        LinkerSysKickOutContent r29 = r26.getMLinkerSysKickOutContent();
        if (r29 == null) goto L99;
        r8 = r29.getLocalReasonToast();
    L99:
        if (TextUtils.isEmpty(r8) == true) goto L107;
        LinkerSysKickOutContent r30 = r26.getMLinkerSysKickOutContent();
        if (r30 == null) goto L106;
        String r31 = r30.getLocalReasonToast();
        if (r31 == null) goto L106;
        r3 = r31;
    L106:
        f2.c(r3, 0);
    L107:
        Iterator<com.bytedance.android.live.livepkaudience.base.h> r32 = this.c.iterator();
    L109:
        if (r32.hasNext() == false) goto L143;
        r32.next().Ea(r26);
        goto L109
    L143:
        return;
    L140:
        return;
    L115:
        Intrinsics.checkNotNullParameter(r26, MultiLinkOpenSource.MESSAGE);
        dl0.m.y(r26, r26.getLinkerId(), r26.getMType(), System.currentTimeMillis());
        Iterator<com.bytedance.android.live.livepkaudience.base.h> r33 = this.c.iterator();
    L117:
        if (r33.hasNext() == false) goto L145;
        r33.next().Of(r26);
        goto L117
    L145:
        return;
    L120:
        if ((r18 instanceof ControlMessage) == true) goto L122;
        return;
    L122:
        if (((ControlMessage) r18).getAction() == 3) goto L124;
        return;
    L124:
        if (this.l == false) goto L138;
        this.k = true;
        return;
    }

    public final void g(long r17, String r19, int r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r19, "secToUserId");
        this.j = true;
        long r11 = System.currentTimeMillis();
        Object r1 = this.o.get("user_distribution_source", "");
        String r2 = (String) r1;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if ((true ^ r3) == true) goto L13;
        r1 = null;
    L13:
        String r4 = (String) r1;
        if (r4 == null) goto L16;
        String r8 = r4;
    L17:
        tc0.c.h().C = false;
        hd0.c.f().g = r21;
        Disposable r0 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).reply(r17, r19, r20, 16, r21, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this, r20, r17, r19, r11), new k(this, r22, r21, r17, r19, r20, r11));
        this.b.add(r0);
        return;
    L16:
        r8 = "";
        goto L17
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public static /* synthetic */ void b(q r10, int r11, int r12, int r13, LinkApplyType r14, String r15) {
        r10.a(r11, r12, r13, r14, false, r15, null, null, null);
    }

    public final void a(int r21, int r22, int r23, LinkApplyType r24, boolean r25, String r26, Integer r27, Integer r28, Integer r29) {
        Intrinsics.checkNotNullParameter(r24, "applyType");
        Intrinsics.checkNotNullParameter(r26, "fromSource");
        boolean r0 = true;
        this.i = true;
        hd0.c.f().g = r21;
        tc0.c.h().C = false;
        HashMap r1 = new HashMap();
        r1.put("link_type", String.valueOf(r21));
        r1.put("position", String.valueOf(r22));
        r1.put("layout", String.valueOf(r23));
        r1.put("apply_type", String.valueOf(r24.getValue()));
        r1.put("apply_after_follow", String.valueOf(r25));
        Object r3 = this.o.get("user_distribution_source", "");
        String r5 = (String) r3;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if ((!r6) == true) goto L13;
        r3 = null;
    L13:
        String r4 = (String) r3;
        if (r4 == null) goto L16;
        r1.put("user_distribution_source", r4);
    L16:
        String r7 = tc0.c.h().F;
        if (r7 != null) goto L19;
    L22:
        if (r0 == true) goto L24;
        r1.put("apply_reason", tc0.c.h().F);
    L24:
        ALogger.w("ttlive_link", "apply params=" + r1);
        long r11 = System.currentTimeMillis();
        this.b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).apply(d().id, d().getOwnerUserIdString(), d().getOwnerUserIdString(), r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r21, r22, r11, r24), new b(this, r23, r21, r22, r24, r25, r26, r27, r28, r29, r11)));
        return;
    L19:
        if (r7.length() == 0) goto L22;
        r0 = false;
        goto L22
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L10
    }
}
