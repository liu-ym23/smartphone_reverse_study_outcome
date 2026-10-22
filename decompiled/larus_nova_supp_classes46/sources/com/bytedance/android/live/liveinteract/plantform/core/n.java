package com.bytedance.android.live.liveinteract.plantform.core;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.soloktv.IPlatformSoloKtvService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.config.x21;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
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
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements vlc.l {
    public final vlc.d a;
    public final CompositeDisposable b;
    public final ArrayList<s> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final DataCenter h;
    public final tf0.i i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ h80.a e;

        public a(n r1, String r2, long r3, boolean r5, h80.a r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r6) {
            this.a.e = false;
            String r0 = this.b;
            long r1 = this.c;
            InteractLinkFullLinkMonitor.x(r0, System.currentTimeMillis() - r1, ((com.bytedance.android.live.network.response.e) r6).logId);
            long r2 = this.c;
            com.bytedance.android.live.liveinteract.plantform.utils.x.f(System.currentTimeMillis() - r2, this.b);
            Iterator<s> r7 = this.a.c.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            r7.next().R3(this.b, this.d);
            goto L4
        L6:
            h80.a r8 = this.e;
            if (r8 == null) goto L11;
            r8.accept(Boolean.TRUE);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ h80.a d;

        public b(n r1, String r2, long r3, h80.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            this.a.e = false;
            String r0 = this.b;
            long r1 = this.c;
            InteractLinkFullLinkMonitor.w(r0, System.currentTimeMillis() - r1, r7);
            long r2 = this.c;
            com.bytedance.android.live.liveinteract.plantform.utils.x.e(r7, System.currentTimeMillis() - r2, this.b);
            Iterator<s> r3 = this.a.c.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().D0(this.b, r7);
            goto L4
        L6:
            h80.a r8 = this.d;
            if (r8 == null) goto L11;
            r8.accept(Boolean.FALSE);
            return;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.b(r0, r4));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ long b;

        public d(n r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r12 = (com.bytedance.android.live.network.response.e) r11;
            this.a.d = false;
            PaidLinkMicContext r0 = PaidLinkMicContext.Companion.getContext();
            String r2 = null;
            if (r0 == null) goto L65;
            com.bytedance.live.datacontext.n<py.k> r1 = r0.getAnonymousGuestImageModel();
            if (r1 == null) goto L65;
            n r3 = this.a;
            Intrinsics.checkNotNullParameter(r12, "$this$castTo");
            Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.link.model.bridge.i0.class, "type");
            if (r12.getClass().isAssignableFrom(com.bytedance.android.live.network.response.f.b.class) == true) goto L9;
        L28:
            com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r5 = r12;
        L29:
            r3.getClass();
            com.bytedance.android.livesdk.link.model.bridge.i0 r4 = r5.data;
            if (r4 == null) goto L62;
            List r6 = r4.getLinkedUsers();
            if (r6 == null) goto L62;
            Iterator<T> r7 = r6.iterator();
            py.k r8 = null;
        L35:
            if (r7.hasNext() == false) goto L63;
            com.bytedance.android.livesdk.link.model.bridge.k r9 = (com.bytedance.android.livesdk.link.model.bridge.k) r7.next();
            if (r9 == null) goto L35;
            IBaseUser r10 = r9.getUser();
            if (r10 == null) goto L35;
            if (r10.isAnonymous() != true) goto L35;
            IBaseUser r13 = r9.getUser();
            if (r13 == null) goto L45;
            String r14 = r13.getIdString();
        L46:
            IMiddlewareUserService r15 = jc1.k.f(IMiddlewareUserService.class);
            if (r15 == null) goto L51;
            com.bytedance.android.livesdk.user.e r16 = r15.user();
            if (r16 == null) goto L51;
            String r17 = r16.n();
        L53:
            if (Intrinsics.areEqual(r14, r17) == false) goto L35;
            IBaseUser r18 = r9.getUser();
            if (r18 == null) goto L57;
            py.k r19 = r18.getAvatarThumbKt();
        L58:
            vh7.c r20 = jm2.a.d((vh7.c) r19);
            if ((r20 instanceof py.k) == true) goto L61;
            r20 = null;
        L61:
            r8 = (py.k) r20;
            goto L35
        L57:
            r19 = null;
        L51:
            r17 = null;
            goto L53
        L45:
            r14 = null;
        L63:
            r1.setValue(r8);
        L62:
            r8 = null;
            goto L63
        L9:
            if (vh7.e.class.isAssignableFrom(com.bytedance.android.livesdk.link.model.bridge.i0.class) == false) goto L28;
            vh7.c r21 = r12.data;
            if ((r21 instanceof vh7.c) == false) goto L20;
            if (r21 == null) goto L18;
            vh7.e r22 = r21.castToOrNull(com.bytedance.android.livesdk.link.model.bridge.i0.class);
            if (r22 == null) goto L28;
            r5 = new com.bytedance.android.live.network.response.f.b(r22, r12.extra);
            goto L29
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
        L20:
            if ((r21 instanceof vh7.e) == false) goto L28;
            if (r21 == null) goto L27;
            vh7.c r23 = jm2.a.d(r21);
            if (r23 == null) goto L28;
            r5 = new com.bytedance.android.live.network.response.f.b(r23, r12.extra);
            goto L29
        L27:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
        L65:
            if (r12 == null) goto L89;
            com.bytedance.android.livesdk.link.model.bridge.i0 r24 = r12.data;
            if (r24 == null) goto L89;
            if (r24.getApplyType() != LinkApplyType.PREPARE_APPLY.getValue()) goto L89;
            com.bytedance.android.livesdk.link.model.bridge.i0 r25 = r12.data;
            if (r25 == null) goto L86;
            List r26 = r25.getLinkedUsers();
            if (r26 == null) goto L86;
            Iterator<T> r27 = r26.iterator();
        L76:
            if (r27.hasNext() == false) goto L86;
            com.bytedance.android.livesdk.link.model.bridge.k r28 = (com.bytedance.android.livesdk.link.model.bridge.k) r27.next();
            if (r28 == null) goto L82;
            IBaseUser r29 = r28.getUser();
            if (r29 == null) goto L82;
            String r30 = r29.getIdString();
        L84:
            if (Intrinsics.areEqual(r30, je0.d.b0().toString()) == false) goto L76;
            tc0.c.h().f = r28.getLinkMicIdStr();
        L82:
            r30 = null;
        L86:
            DigitAvatarContext r31 = DigitAvatarContext.Companion.getContext();
            if (r31 == null) goto L89;
            DigitAvatarContext.setVideoShowMode$default(r31, VideoShowMode.AUDIO, null, 2, null);
        L89:
            com.bytedance.android.livesdk.link.model.bridge.i0 r32 = r12.data;
            if (r32 == null) goto L105;
            List r33 = r32.getLinkedUsers();
            if (r33 == null) goto L105;
            Iterator<T> r34 = r33.iterator();
        L95:
            if (r34.hasNext() == false) goto L105;
            com.bytedance.android.livesdk.link.model.bridge.k r35 = (com.bytedance.android.livesdk.link.model.bridge.k) r34.next();
            if (r35 == null) goto L101;
            IBaseUser r36 = r35.getUser();
            if (r36 == null) goto L101;
            String r37 = r36.getIdString();
        L103:
            if (Intrinsics.areEqual(r37, je0.d.b0().toString()) == false) goto L95;
            this.a.i.setInteractId(r35.getLinkMicIdStr());
        L101:
            r37 = null;
        L105:
            hd0.c.f().k(2);
            com.bytedance.android.livesdk.link.model.bridge.i0 r38 = r12.data;
            if (r38 == null) goto L108;
            String r39 = r38.getToken();
        L109:
            com.bytedance.android.livesdk.link.model.bridge.i0 r40 = r12.data;
            if (r40 == null) goto L112;
            Long r41 = Long.valueOf(r40.getVersion());
        L113:
            com.bytedance.android.livesdk.link.model.bridge.i0 r42 = r12.data;
            if (r42 == null) goto L118;
            List r43 = r42.getLinkedUsers();
            if (r43 == null) goto L118;
            String r44 = je0.d.g0(r43);
        L119:
            InteractLinkFullLinkMonitor.r(r39, r41, r44, System.currentTimeMillis() - this.b, r12.logId);
            long r45 = System.currentTimeMillis() - this.b;
            com.bytedance.android.livesdk.link.model.bridge.i0 r46 = r12.data;
            if (r46 == null) goto L122;
            String r47 = r46.getToken();
        L123:
            com.bytedance.android.livesdk.link.model.bridge.i0 r48 = r12.data;
            if (r48 == null) goto L126;
            Long r49 = Long.valueOf(r48.getVersion());
        L127:
            com.bytedance.android.livesdk.link.model.bridge.i0 r50 = r12.data;
            if (r50 == null) goto L132;
            List r51 = r50.getLinkedUsers();
            if (r51 == null) goto L132;
            String r52 = je0.d.g0(r51);
        L133:
            com.bytedance.android.live.liveinteract.plantform.utils.x.v(r45, r47, r49, r52);
            TalkRoomBusinessFullLinkMonitor r53 = TalkRoomBusinessFullLinkMonitor.a;
            long r54 = this.b;
            r53.getClass();
            TalkRoomBusinessFullLinkMonitor.N(r12, r54);
            Iterator<s> r55 = this.a.c.iterator();
        L135:
            if (r55.hasNext() == false) goto L137;
            r55.next().b2(r12);
            goto L135
        L137:
            com.bytedance.android.livesdk.link.model.bridge.i0 r110 = r12.data;
            if (r110 == null) goto L174;
            com.bytedance.live.datacontext.m r56 = com.bytedance.android.live.liveinteract.api.utils.m.i().X1();
            if (r56 != null) goto L142;
        L147:
            IJoinChannelResult r111 = r110.castToOrNull(IJoinChannelResult.class);
            if (r111 == null) goto L150;
            r2 = r111.getPrompt();
        L150:
            f2.c(r2, 0);
            return;
        L142:
            if (((Boolean) r56.getValue()).booleanValue() == true) goto L147;
            IJoinChannelResult r112 = r110.castToOrNull(IJoinChannelResult.class);
            if (r112 == null) goto L146;
            r2 = r112.getPromptWithEarphone();
        L146:
            f2.c(r2, 0);
            return;
        L174:
            return;
        L132:
            r52 = null;
            goto L133
        L126:
            r49 = null;
            goto L127
        L122:
            r47 = null;
        L118:
            r44 = null;
            goto L119
        L112:
            r41 = null;
            goto L113
        L108:
            r39 = null;
            goto L109
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ long b;

        public e(n r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            Intrinsics.checkNotNullParameter(r6, "throwable");
            this.a.d = false;
            com.bytedance.android.live.liveinteract.videotalk.a.a = false;
            long r0 = this.b;
            InteractLinkFullLinkMonitor.q(System.currentTimeMillis() - r0, r6);
            long r1 = this.b;
            com.bytedance.android.live.liveinteract.plantform.utils.x.u(r6, System.currentTimeMillis() - r1);
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            long r3 = this.b;
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.M(r6, r3);
            Iterator<s> r4 = this.a.c.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r4.next().m0(r6);
            goto L4
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public f(n r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            String r0 = this.b;
            long r1 = this.c;
            long r3 = System.currentTimeMillis() - r1;
            if (r7 == null) goto L6;
            String r2 = r7.logId;
            if (r2 == null) goto L6;
        L7:
            InteractLinkFullLinkMonitor.x(r0, r3, r2);
            long r4 = this.c;
            com.bytedance.android.live.liveinteract.plantform.utils.x.z(System.currentTimeMillis() - r4, this.b);
            Iterator<s> r5 = this.a.c.iterator();
        L9:
            if (r5.hasNext() == false) goto L15;
            s r8 = r5.next();
            if (r7 == null) goto L13;
            g1 r9 = (g1) r7.data;
        L14:
            r8.l1(r9);
            goto L9
        L13:
            r9 = null;
            goto L14
        L15:
            return;
        L6:
            r2 = "";
            goto L7
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public g(n r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            String r0 = this.b;
            long r1 = this.c;
            InteractLinkFullLinkMonitor.w(r0, System.currentTimeMillis() - r1, r7);
            long r2 = this.c;
            long r3 = System.currentTimeMillis() - r2;
            String r4 = this.b;
            int r5 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.y(r7, r3, r4, Boolean.FALSE);
            Iterator<s> r8 = this.a.c.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            r8.next().c0(r7);
            goto L4
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;

        public h(n r1, int r2, String r3, long r4, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r9;
            if (r3 == null) goto L22;
            com.bytedance.android.livesdk.chatroom.model.interact.m r10 = (com.bytedance.android.livesdk.chatroom.model.interact.m) r3.data;
            if (r10 != null) goto L7;
            return;
        L7:
            if (this.b == ReplyType.Agree.ordinal()) goto L9;
        L15:
            String r0 = this.c;
            int r1 = this.b;
            long r4 = this.d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.q(r0, r1, System.currentTimeMillis() - r4);
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            String r5 = this.c;
            int r6 = this.b;
            int r7 = this.e;
            long r8 = this.d;
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.J(r5, r6, r7, r3, r8);
            Iterator<s> r11 = this.a.c.iterator();
        L17:
            if (r11.hasNext() == false) goto L19;
            r11.next().T3(r10, this.b);
            goto L17
        L19:
            this.a.getClass();
            return;
        L9:
            if (TextUtils.isEmpty(r10.getLinkMicIdStr()) == false) goto L11;
            this.a.i.setInteractId(String.valueOf(r10.getLinkMicId()));
        L12:
            this.a.i.a(r10.getRtcExtInfo());
            this.a.i.R0(r10.getConfluenceType());
            if (r10.getAnchorLinkMicIdStr() == null) goto L15;
            this.a.i.c1(r10.getAnchorLinkMicIdStr());
            goto L15
        L11:
            this.a.i.setInteractId(r10.getLinkMicIdStr());
            goto L12
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ long i;

        public i(n r1, Boolean r2, int r3, int r4, long r5, String r7, String r8, int r9, long r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }

        public final void accept(Object r7) {
            final Throwable r8 = (Throwable) r7;
            if (Intrinsics.areEqual(this.b, Boolean.TRUE) == false) goto L5;
            new qh0.h(this.d, new GuestLinkManager$reply$4$1(this, r8), GuestLinkManager$reply$4$2.INSTANCE).c(r8);
        L5:
            String r0 = this.f;
            int r1 = this.h;
            long r2 = this.i;
            com.bytedance.android.live.liveinteract.plantform.utils.x.r(r0, r1, r8, System.currentTimeMillis() - r2);
            TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
            String r4 = this.f;
            int r5 = this.h;
            int r6 = this.d;
            long r9 = this.i;
            r3.getClass();
            TalkRoomBusinessFullLinkMonitor.I(r4, r5, r6, r8, r9);
            Iterator<s> r10 = this.a.c.iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            r10.next().b1(r8);
            goto L7
        L9:
            this.a.getClass();
        }
    }

    public final IRoom c() {
        IRoom r0 = (IRoom) this.h.get("data_room", vh7.f.c(IRoom.class));
        if (r0 == null) goto L5;
        return r0;
    L5:
        return vh7.f.c(IRoom.class);
    }

    public final void d() {
        if (tb1.c.c == true) goto L5;
    L8:
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L16;
        ai0.e r1 = r0.getAdventureService();
        if (r1 == null) goto L16;
        if (ai0.e.a.a(r1) != true) goto L16;
        return;
    L16:
        if (GuestLinkContext.Companion.b(true) == false) goto L19;
        return;
    L19:
        if (this.d == false) goto L21;
        return;
    L21:
        this.d = true;
        long r2 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.p();
        Disposable r3 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).joinChannelV1(c().getId()).subscribeOn(Schedulers.io()).flatMap(c.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r2), new e(this, r2));
        this.b.add(r3);
        return;
    L5:
        if (vm2.g.b() == true) goto L8;
        f2.b(2131918784, 0);
    }

    public final void e(String r9) {
        Intrinsics.checkNotNullParameter(r9, "reqFrom");
        int r1 = nd0.g.a;
        Intrinsics.checkNotNullParameter(r9, "reqFrom");
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r2 == null) goto L7;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.getGuestInfo(r0, "");
        if (r3 == null) goto L7;
        int r4 = r3.getLinkType();
    L8:
        JSONObject r5 = new JSONObject();
        pd0.b r6 = pd0.b.a;
        r5.put("link_type", pd0.b.g(r4));
        r5.put("disconnect_reason", r9);
        nd0.c.o(nd0.c.a, LinkMonitorData.GuestDisconnectActionMonitorData, r5, 0, null, false, 28);
        long r7 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v(r9);
        Disposable r10 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(c().getId(), r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r9, r7), new g(this, r9, r7));
        this.b.add(r10);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public final void onMessage(tlc.d r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r7 instanceof z0) == false) goto L37;
        z0 r8 = (z0) r7;
        int r0 = (int) r8.getType2();
        if (r0 != 2) goto L9;
        Intrinsics.checkNotNullParameter(r8, "linkMicMessage");
        IPlatformSoloKtvService r1 = jc1.k.f(IPlatformSoloKtvService.class);
        if (r1 == null) goto L32;
        r1.onGuestLinkPermit();
    L32:
        com.bytedance.android.live.liveinteract.videotalk.a.a = true;
        this.i.c1(r8.getAnchorLinkMicIdStr());
        this.i.D0(r8.getBackupInfo());
        this.i.a(r8.getRtcExtInfo());
        com.bytedance.android.live.liveinteract.plantform.utils.x.p(r8.getMessageId2(), r8.getRtcExtInfo());
        TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
        com.bytedance.android.live.liveinteract.multianchor.model.b r3 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r8.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        r2.getClass();
        TalkRoomBusinessFullLinkMonitor.n0(r3);
        Iterator<s> r4 = this.c.iterator();
    L34:
        if (r4.hasNext() == false) goto L112;
        r4.next().Fc(r8);
        goto L34
    L112:
        return;
    L9:
        if (r0 != 3) goto L11;
        TalkRoomBusinessFullLinkMonitor r5 = TalkRoomBusinessFullLinkMonitor.a;
        long r6 = r8.getMessageId2();
        r5.getClass();
        TalkRoomBusinessFullLinkMonitor.m0(r6);
        com.bytedance.android.live.liveinteract.plantform.utils.x.o(r8.getMessageId2(), r8.getControlType());
        Iterator<s> r9 = this.c.iterator();
    L23:
        if (r9.hasNext() == false) goto L26;
        r9.next().x2(r8);
        goto L23
    L26:
        if (2 == r8.getKickOutSource()) goto L109;
        this.f = true;
        return;
    L109:
        return;
    L11:
        if (r0 == 4) goto L19;
        if (r0 != 12) goto L108;
        this.i.c1(r8.getAnchorLinkMicIdStr());
        this.i.D0(r8.getBackupInfo());
        TalkRoomBusinessFullLinkMonitor r10 = TalkRoomBusinessFullLinkMonitor.a;
        com.bytedance.android.live.liveinteract.multianchor.model.b r11 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r8.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        r10.getClass();
        TalkRoomBusinessFullLinkMonitor.l0(r11);
        com.bytedance.android.live.liveinteract.plantform.utils.x.n(r8.getMessageId2(), r8.getFromUserIdStr());
        Iterator<s> r12 = this.c.iterator();
    L16:
        if (r12.hasNext() == false) goto L111;
        r12.next().xf(r8);
        goto L16
    L111:
        return;
    L108:
        return;
    L19:
        if (this.g == false) goto L101;
        this.f = true;
        return;
    L101:
        return;
    L37:
        if ((r7 instanceof h1) == false) goto L70;
        h1 r13 = (h1) r7;
        int r14 = r13.getMType();
        if (r14 != 12) goto L41;
        Iterator<s> r15 = this.c.iterator();
    L67:
        if (r15.hasNext() == false) goto L117;
        r15.next().kp(r13);
        goto L67
    L117:
        return;
    L41:
        if (r14 != 13) goto L43;
        TalkRoomBusinessFullLinkMonitor r16 = TalkRoomBusinessFullLinkMonitor.a;
        long r17 = r13.getMessageId3();
        r16.getClass();
        TalkRoomBusinessFullLinkMonitor.m0(r17);
        Iterator<s> r18 = this.c.iterator();
    L63:
        if (r18.hasNext() == false) goto L116;
        r18.next().Y(r13);
        goto L63
    L116:
        return;
    L43:
        if (r14 != 24) goto L45;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.i0(r13);
        Iterator<s> r19 = this.c.iterator();
    L59:
        if (r19.hasNext() == false) goto L115;
        r19.next().G1(r13);
        goto L59
    L115:
        return;
    L45:
        if (r14 != 34) goto L47;
        Iterator<s> r20 = this.c.iterator();
    L55:
        if (r20.hasNext() == false) goto L114;
        r20.next().Ja(r13);
        goto L55
    L114:
        return;
    L47:
        if (r14 != 101) goto L110;
        TalkRoomBusinessFullLinkMonitor r21 = TalkRoomBusinessFullLinkMonitor.a;
        long r22 = r13.getMessageId3();
        r21.getClass();
        TalkRoomBusinessFullLinkMonitor.p0(r22);
        Iterator<s> r23 = this.c.iterator();
    L51:
        if (r23.hasNext() == false) goto L113;
        r23.next().f5(r13);
        goto L51
    L113:
        return;
    L110:
        return;
    L70:
        if ((r7 instanceof ILinkMicGuideMessageBridge) == false) goto L76;
        Iterator<s> r24 = this.c.iterator();
    L73:
        if (r24.hasNext() == false) goto L118;
        r24.next().X5((ILinkMicGuideMessageBridge) r7);
        goto L73
    L118:
        return;
    L76:
        if ((r7 instanceof d9) == false) goto L84;
        d9 r25 = (d9) r7;
        if (r25.getPaidOrTimeLimitChangeContent() == null) goto L104;
        Iterator<s> r26 = this.c.iterator();
    L81:
        if (r26.hasNext() == false) goto L119;
        r26.next().G2(r25);
        goto L81
    L119:
        return;
    L104:
        return;
    L84:
        if ((r7 instanceof o0) == true) goto L86;
        return;
    L86:
        if (((o0) r7).getAction() == 3) goto L88;
        return;
    L88:
        if (this.g == false) goto L107;
        this.f = true;
        return;
    }

    public n(DataCenter r2, tf0.i r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        this.h = r2;
        this.i = r3;
        this.a = (vlc.d) r2.get("data_message_manager");
        this.b = new CompositeDisposable();
        this.c = new ArrayList();
    }

    public final void b(String r12, h80.a<Boolean> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "reqFrom");
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        long r8 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v(r12);
        Disposable r15 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(c().getId(), r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r12, r8, r14, r13), new b(this, r12, r8, r13));
        this.b.add(r15);
    }

    public static /* synthetic */ void g(n r9, long r10, String r12, String r13, int r14, int r15, int r16) {
        r9.f(r10, r12, r13, r14, r15, r16, Boolean.TRUE);
    }

    public final void f(long r18, String r20, String r21, int r22, int r23, int r24, Boolean r25) {
        Intrinsics.checkNotNullParameter(r20, "secToUserId");
        Intrinsics.checkNotNullParameter(r21, "toUserIdString");
        long r14 = System.currentTimeMillis();
        Object r0 = this.h.get("user_distribution_source", "");
        String r1 = (String) r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if ((!r2) == true) goto L13;
        r0 = null;
    L13:
        String r3 = (String) r0;
        if (r3 == null) goto L16;
        String r9 = r3;
    L17:
        tc0.c.h().C = false;
        hd0.c.f().g = r23;
        this.b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).reply(r18, r20, r21, r21, r22, 16, r23, r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r22, r20, r14, r23), new i(this, r25, r24, r23, r18, r20, r21, r22, r14)));
        Iterator<s> r4 = this.c.iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        r4.next().Eh(r20, r22);
        goto L19
    L21:
        return;
    L16:
        r9 = "";
        goto L17
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static void a(n r28, int r29, int r30, int r31, LinkApplyType r32, boolean r33, String r34, Integer r35, Integer r36, Integer r37, boolean r38, boolean r39, int r40, tf0.b r41, xc.a r42, int r43) {
        if ((r43 & 8) == 0) goto L5;
        LinkApplyType r5 = LinkApplyType.NORMAL;
    L7:
        if ((r43 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        String r4 = "";
        if ((r43 & 32) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r43 & 64) == 0) goto L17;
        Integer r9 = null;
    L19:
        if ((r43 & 128) == 0) goto L21;
        Integer r10 = null;
    L23:
        if ((r43 & 256) == 0) goto L25;
        Integer r11 = null;
    L27:
        if ((r43 & 512) == 0) goto L29;
        boolean r12 = false;
    L31:
        if ((r43 & 1024) == 0) goto L33;
        boolean r13 = false;
    L35:
        if ((r43 & 2048) == 0) goto L37;
        int r17 = 0;
    L39:
        if ((r43 & 4096) == 0) goto L41;
        tf0.b r18 = null;
    L43:
        if ((r43 & 8192) == 0) goto L45;
        xc.a r0 = null;
    L46:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r5, "applyType");
        Intrinsics.checkNotNullParameter(r7, "fromSource");
        fj0.e.n(r12);
        hd0.c.f().g = r29;
        tc0.c.h().C = false;
        LinkmicApplyFloatWindowManager.d r1 = LinkmicApplyFloatWindowManager.y;
        LinkmicApplyFloatWindowManager.e.a().f = false;
        HashMap r2 = new HashMap();
        r2.put("link_type", String.valueOf(r29));
        r2.put("position", String.valueOf(r30));
        r2.put("layout", String.valueOf(r31));
        r2.put("apply_type", String.valueOf(r5.getValue()));
        r2.put("apply_after_follow", String.valueOf(r6));
        if (ChatMatchWidget.p == false) goto L49;
        Object r8 = "1";
    L50:
        boolean r20 = r6;
        x21 r14 = (x21) vm2.e.b.getValue(null, vm2.e.a[0]);
        Intrinsics.checkNotNullParameter(r14, "$this$isEnableSilenceMemory");
        if (r14.U3() != 1) goto L53;
        boolean r3 = true;
    L55:
        if (r3 == false) goto L58;
        r2.put("silence_status", r8);
    L58:
        if (r5 != LinkApplyType.LINK_FROM_LINK_RESULT) goto L64;
        Object r15 = null;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.d.b.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[0])).booleanValue() == false) goto L62;
        Object r16 = "1";
    L63:
        r2.put("silence_status", r16);
    L65:
        Object r19 = r28.h.get("user_distribution_source", "");
        String r110 = (String) r19;
        if (r110 != null) goto L68;
    L71:
        boolean r111 = true;
    L73:
        if ((!r111) == true) goto L76;
        r19 = r15;
    L76:
        String r21 = (String) r19;
        if (r21 == null) goto L79;
        r2.put("user_distribution_source", r21);
    L79:
        if (r13 == false) goto L82;
        if (r17 <= 0) goto L82;
        r2.put("use_member_benefits", String.valueOf(r13));
        r2.put("member_discount_amount", String.valueOf(r17));
    L82:
        if (r9 == null) goto L94;
        if (r10 == null) goto L94;
        r2.put("paid_count", String.valueOf(r9.intValue()));
        r2.put("limited_time", String.valueOf(r10.intValue()));
        String r22 = tc0.c.h().F;
        if (r22 != null) goto L87;
    L90:
        boolean r23 = true;
    L91:
        if (r23 == true) goto L93;
        r2.put("apply_reason", tc0.c.h().F);
    L93:
        r2.put("is_anonymous", String.valueOf(r12));
        goto L94
    L87:
        if (r22.length() == 0) goto L90;
        r23 = false;
    L94:
        if (r11 == null) goto L96;
        r2.put("teamfight_team_id", String.valueOf(r11.intValue()));
    L96:
        if (r0 == null) goto L101;
        Integer r24 = r0.b();
        if (r24 == null) goto L101;
        String r25 = String.valueOf(r24.intValue());
        if (r25 == null) goto L101;
    L102:
        r2.put("discount_mode", r25);
        if (r0 == null) goto L110;
        Integer r26 = r0.a();
        if (r26 == null) goto L110;
        String r27 = String.valueOf(r26.intValue());
        if (r27 == null) goto L110;
        r4 = r27;
    L110:
        r2.put("discount_amount", r4);
        r2.put("source_page", r7);
        ALogger.w("ttlive_link", "apply params=" + r2);
        long r210 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.b(r30, r29, r7);
        r28.b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).apply(r28.c().getId(), r28.c().getAnchorId(), r28.c().getAnchorId(), r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(r28, r29, r11, r30, r7, r210, r5, r18), new m(r28, r31, r29, r30, r5, r20, r7, r9, r10, r11, r12, r13, r17, r18, r210)));
        return;
    L101:
        r25 = "";
        goto L102
    L68:
        if (r110.length() == 0) goto L71;
        r111 = false;
        goto L73
    L62:
        r16 = "0";
        goto L63
    L64:
        r15 = null;
        goto L65
    L53:
        r3 = false;
        goto L55
    L49:
        r8 = "0";
        goto L50
    L45:
        r0 = r42;
        goto L46
    L41:
        r18 = r41;
        goto L43
    L37:
        r17 = r40;
        goto L39
    L33:
        r13 = r39;
        goto L35
    L29:
        r12 = r38;
        goto L31
    L25:
        r11 = r37;
        goto L27
    L21:
        r10 = r36;
        goto L23
    L17:
        r9 = r35;
        goto L19
    L13:
        r7 = r34;
        goto L15
    L9:
        r6 = r33;
        goto L10
    L5:
        r5 = r32;
        goto L7
    }
}
