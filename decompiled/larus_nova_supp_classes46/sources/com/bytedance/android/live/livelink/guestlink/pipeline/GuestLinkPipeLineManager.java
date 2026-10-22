package com.bytedance.android.live.livelink.guestlink.pipeline;

import android.content.Context;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.guestlink.LinkChannelMessageType;
import com.bytedance.android.live.base.model.message.guestlink.i;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.bytedance.live.kmp.util.KmpToastUtil;
import com.bytedance.live.livelink.kmp.impl.base.thread.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestLinkPipeLineManager extends lb6.b implements sb6.b {
    public static final /* synthetic */ int o = 0;
    public final Lazy b;
    public nb6.a c;
    public Long d;
    public Long e;
    public Function0<Unit> f;
    public boolean g;
    public final e h;
    public final Context i;
    public final rb6.a j;
    public final mb6.b k;
    public final qb6.a l;
    public final ob6.a m;
    public final ub6.a n;

    public static final class a {
    }

    public static final class b implements mb6.b.a {
        public final /* synthetic */ GuestLinkPipeLineManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public static final class a implements ub6.a.a {
            public final /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.a a;
            public final /* synthetic */ b b;

            public final void n() {
                b r0 = this.b;
                r0.a.g(r0.b, this.a.getChannelId(), "onCountDownEnd", true);
                nb6.a r1 = this.b.a.c;
                if (r1 == null) goto L10;
                CopyOnWriteArraySet r2 = r1.a;
                if (r2 == null) goto L12;
                Iterator r3 = r2.iterator();
            L8:
                if (r3.hasNext() == false) goto L13;
                ((nb6.b) r3.next()).a.n();
                goto L8
            L13:
                return;
            L12:
                return;
            }

            public a(com.bytedance.android.live.base.model.message.guestlink.a r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void e(long r3, long r5) {
                nb6.a r0 = this.b.a.c;
                if (r0 == null) goto L10;
                CopyOnWriteArraySet r1 = r0.a;
                if (r1 == null) goto L12;
                Iterator r2 = r1.iterator();
            L8:
                if (r2.hasNext() == false) goto L13;
                ((nb6.b) r2.next()).a.e(r3, r5);
                goto L8
            L13:
                return;
            L12:
                return;
            }
        }

        public b(GuestLinkPipeLineManager r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void h(long r10, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r12, long r13) {
            Intrinsics.checkNotNullParameter(r12, "response");
            jy0.b.d("GuestLinkPipeLineManager", "onEnterChannelSuccess, duration: " + r10);
            if (r13 != 1) goto L5;
        L6:
            jy0.b.d("GuestLinkPipeLineManager", "onEnterChannelSuccess, leaveChannel");
            this.a.k.B(this.b, this.c, "enterChannelUpDown", null);
        L7:
            Intrinsics.checkNotNullParameter(r12, "response");
            this.a.G().c = true;
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r0 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r12.data;
            if (r0 == null) goto L10;
            this.a.G().d = r0;
        L10:
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r1 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r12.data;
            if (r1 == null) goto L15;
            com.bytedance.android.live.base.model.message.guestlink.a r2 = r1.getChannelInfo();
            if (r2 == null) goto L15;
            this.a.G().b(r2, "enterChannel");
        L15:
            nb6.a r3 = this.a.c;
            if (r3 == null) goto L23;
            CopyOnWriteArraySet r4 = r3.a;
            if (r4 == null) goto L23;
            Iterator r5 = r4.iterator();
        L21:
            if (r5.hasNext() == false) goto L23;
            ((nb6.b) r5.next()).a.h(r10, r12, r13);
        L23:
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r11 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r12.data;
            if (r11 == null) goto L28;
            com.bytedance.android.live.base.model.message.guestlink.a r14 = r11.getChannelInfo();
            if (r14 == null) goto L28;
            this.a.n.E(r14.getCallDuration(), r14.getStartTimeMs());
            this.a.n.o(new a(r14, this));
        L28:
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r15 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r12.data;
            if (r15 == null) goto L35;
            com.bytedance.android.live.base.model.message.guestlink.a r16 = r15.getChannelInfo();
            if (r16 == null) goto L36;
            this.a.l.q(r16.getChannelId(), "enterChannel");
            return;
        L36:
            return;
        L35:
            return;
        L5:
            if (r13 != 2) goto L7;
            goto L6
        }

        public final void o(long r9, Throwable r11, long r12) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            jy0.b.b("GuestLinkPipeLineManager", "onEnterChannelFailed, duration: " + r9, r11);
            Intrinsics.checkNotNullParameter(r11, "throwable");
            if (r12 != 3) goto L5;
            this.a.G().c = false;
        L5:
            nb6.a r0 = this.a.c;
            if (r0 == null) goto L13;
            CopyOnWriteArraySet r1 = r0.a;
            if (r1 == null) goto L15;
            Iterator r2 = r1.iterator();
        L11:
            if (r2.hasNext() == false) goto L16;
            ((nb6.b) r2.next()).a.o(r9, r11, r12);
            goto L11
        L16:
            return;
        L15:
            return;
        }
    }

    public static final class c implements rb6.a.a {
        public final /* synthetic */ GuestLinkPipeLineManager a;
        public final /* synthetic */ Function0 b;

        public c(GuestLinkPipeLineManager r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void W(long r2, OperateType r4) {
            Intrinsics.checkNotNullParameter(r4, "operationType");
            Intrinsics.checkNotNullParameter(r4, "operationType");
            jy0.b.d("GuestLinkPipeLineManager", "onPermissionCheckSuccess, duration: " + r2);
            this.b.invoke();
        }

        public final void c1(long r3, OperateType r5, BaseCheckException r6) {
            Intrinsics.checkNotNullParameter(r5, "operationType");
            Intrinsics.checkNotNullParameter(r6, "exception");
            Intrinsics.checkNotNullParameter(r5, "operationType");
            Intrinsics.checkNotNullParameter(r6, "exception");
            this.a.G().a = false;
            jy0.b.b("GuestLinkPipeLineManager", "onPermissionCheckFailed, duration: " + r3, r6);
            nb6.a r7 = this.a.c;
            if (r7 == null) goto L10;
            CopyOnWriteArraySet r8 = r7.a;
            if (r8 == null) goto L12;
            Iterator r9 = r8.iterator();
        L8:
            if (r9.hasNext() == false) goto L13;
            ((nb6.b) r9.next()).a.o1(r3, new Throwable("onPermissionCheckFailed"));
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class d implements mb6.b.d {
        public final /* synthetic */ GuestLinkPipeLineManager a;

        public d(GuestLinkPipeLineManager r1) {
            this.a = r1;
        }

        public final void i(long r4, Throwable r6) {
            Intrinsics.checkNotNullParameter(r6, "throwable");
            jy0.b.b("GuestLinkPipeLineManager", "onLeaveChannelFailed, duration: " + r4, r6);
            Intrinsics.checkNotNullParameter(r6, "throwable");
            nb6.a r0 = this.a.c;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.a;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((nb6.b) r2.next()).a.i(r4, r6);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public final void q(long r4, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.d, Extra> r6) {
            Intrinsics.checkNotNullParameter(r6, "response");
            jy0.b.d("GuestLinkPipeLineManager", "onLeaveChannelSuccess, duration: " + r4);
            Intrinsics.checkNotNullParameter(r6, "response");
            nb6.a r0 = this.a.c;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.a;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((nb6.b) r2.next()).a.q(r4, r6);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class e implements qb6.a.a {
        public final /* synthetic */ GuestLinkPipeLineManager a;

        public e(GuestLinkPipeLineManager r1) {
            this.a = r1;
        }

        public final void f(i r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            nb6.a r0 = this.a.c;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.a;
            if (r1 == null) goto L10;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((nb6.b) r2.next()).a.f(r5);
        L10:
            int r3 = r5.getMsgType();
            if (r3 != LinkChannelMessageType.LinkmicGuestLink_ChannelInfoUpdate.getValue()) goto L18;
            com.bytedance.android.live.base.model.message.guestlink.b r6 = r5.getUpdateChannelContent();
            if (r6 == null) goto L53;
            com.bytedance.android.live.base.model.message.guestlink.a r7 = r6.getChannelInfo();
            if (r7 == null) goto L54;
            this.a.G().b(r7, "LinkmicGuestLink_ChannelInfoUpdate");
            return;
        L54:
            return;
        L53:
            return;
        L18:
            if (r3 != LinkChannelMessageType.LinkmicGuestLink_ChannelFinish.getValue()) goto L49;
            jy0.b.d("GuestLinkPipeLineManager", "received LinkmicGuestLinkMessage, finish_channel_content: " + r5.getFinishChannelContent());
            boolean r4 = true;
            if (this.a.G().a == false) goto L32;
            com.bytedance.android.live.base.model.message.guestlink.d r8 = r5.getFinishChannelContent();
            if (r8 == null) goto L43;
            String r9 = r8.getLinkerToast();
            if (r9 == null) goto L43;
            if (r9.length() > 0) goto L29;
            r4 = false;
        L29:
            if (r4 == false) goto L43;
            KmpToastUtil.a(r9, 0);
        L43:
            GuestLinkPipeLineManager r10 = this.a;
            StringBuilder r11 = new StringBuilder("LinkmicGuestLink_ChannelFinish#");
            com.bytedance.android.live.base.model.message.guestlink.d r12 = r5.getFinishChannelContent();
            if (r12 == null) goto L46;
            String r13 = r12.getReason();
        L47:
            r11.append(r13);
            GuestLinkPipeLineManager.F(r10, r11.toString());
            return;
        L46:
            r13 = null;
            goto L47
        L32:
            if (this.a.G().c == false) goto L43;
            com.bytedance.android.live.base.model.message.guestlink.d r14 = r5.getFinishChannelContent();
            if (r14 == null) goto L43;
            String r15 = r14.getAduienceToast();
            if (r15 == null) goto L43;
            if (r15.length() > 0) goto L41;
            r4 = false;
        L41:
            if (r4 == false) goto L43;
            KmpToastUtil.a(r15, 0);
            goto L43
        L49:
            if (r3 != LinkChannelMessageType.LinkmicGuestLink_Finish.getValue()) goto L57;
            GuestLinkPipeLineManager.F(this.a, "LinkmicGuestLink_Finish");
            return;
        }
    }

    public static final class f implements mb6.b.b {
        public final /* synthetic */ GuestLinkPipeLineManager a;

        public f(GuestLinkPipeLineManager r1) {
            this.a = r1;
        }

        public final void r(long r3, Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "throwable");
            Intrinsics.checkNotNullParameter(r5, "throwable");
            jy0.b.b("GuestLinkPipeLineManager", "sendFinishChannelReq failed, duration: " + r3, r5);
            nb6.a r0 = this.a.c;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.a;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((nb6.b) r2.next()).a.r(r3, r5);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public final void j(long r3, String r5, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.a, Extra> r6) {
            Intrinsics.checkNotNullParameter(r5, "requestSource");
            Intrinsics.checkNotNullParameter(r6, "response");
            Intrinsics.checkNotNullParameter(r5, "requestSource");
            Intrinsics.checkNotNullParameter(r6, "response");
            jy0.b.d("GuestLinkPipeLineManager", "sendFinishChannelReq success, duration: " + r3);
            nb6.a r0 = this.a.c;
            if (r0 == null) goto L10;
            CopyOnWriteArraySet r1 = r0.a;
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L13;
            ((nb6.b) r2.next()).a.j(r3, r5, r6);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final sb6.a G() {
        return (sb6.a) this.b.getValue();
    }

    public final void attach() {
        this.l.z(this.h);
    }

    public final boolean e() {
        boolean r0 = this.m.C();
        jy0.b.d("GuestLinkPipeLineManager", "checkChannel: " + r0);
        if (r0 == true) goto L9;
        Long r1 = this.d;
        if (r1 == null) goto L9;
        long r3 = r1.longValue();
        Long r2 = this.e;
        if (r2 == null) goto L9;
        c(r3, r2.longValue(), "checkChannelFailed", ChannelFinishReason.CLIENT_CHECK.getRequestSource(), false);
    L9:
        return r0;
    }

    public final void detach() {
        super.detach();
        k("GuestLinkPipeLineManager#detach");
        this.l.r(this.h);
        G().a();
        this.g = true;
    }

    public final sb6.a getLinkState() {
        return G();
    }

    public final Context getContext() {
        return this.i;
    }

    public final void b(lb6.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        nb6.a r1 = this.c;
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r5, "listener");
        Iterator r0 = r1.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        nb6.b r2 = (nb6.b) r0.next();
        if (Intrinsics.areEqual(r2.a, r5) == false) goto L6;
        r1.a.remove(r2);
        return;
    L15:
        return;
    }

    public final void j(nb6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "linkConfig");
        this.c = r2;
    }

    public final void k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (G().a == false) goto L6;
        jy0.b.d("GuestLinkPipeLineManager", "releaseRtcEngine, reason: " + r3);
        this.m.p();
        this.m.destroyEngine();
        this.n.release();
        return;
    }

    public static final void F(GuestLinkPipeLineManager r14, String r15) {
        r14.getClass();
        jy0.b.d("GuestLinkPipeLineManager", "releaseChannel, reason: " + r15);
        r14.g = true;
        long r1 = 0;
        com.bytedance.android.live.base.model.message.guestlink.a r3 = null;
        if (r14.G().a == false) goto L16;
        com.bytedance.android.live.base.model.message.guestlink.a r0 = r14.G().f;
        if ((r0 instanceof pb6.a) == false) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L16;
        g r4 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), g.class);
        if (r4 == null) goto L13;
        IRoomBase r5 = r4.getRoom();
        if (r5 == null) goto L13;
        long r7 = IRoomKtKt.getId(r5);
    L14:
        r14.c(r7, r0.getChannelId(), r15, ChannelFinishReason.CLIENT_CHECK.getRequestSource(), false);
    L13:
        r7 = 0;
    L16:
        if (r14.G().c == false) goto L29;
        com.bytedance.android.live.base.model.message.guestlink.a r2 = r14.G().f;
        if ((r2 instanceof pb6.a) == true) goto L21;
        r3 = r2;
    L21:
        if (r3 == null) goto L30;
        g r6 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), g.class);
        if (r6 == null) goto L27;
        IRoomBase r8 = r6.getRoom();
        if (r8 == null) goto L27;
        r1 = IRoomKtKt.getId(r8);
    L27:
        r14.g(r1, r3.getChannelId(), r15, false);
        return;
    L30:
        return;
    }

    public final void a(int r4, GuestLinkMainPageDialogForLinker.g r5) {
        this.j.x(this.i, OperateType.JOIN, r4, r5);
    }

    public final void d(lb6.a r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        nb6.a r1 = this.c;
        if (r1 == null) goto L20;
        Intrinsics.checkNotNullParameter(r5, "listener");
        Iterator r0 = r1.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        nb6.b r2 = (nb6.b) r0.next();
        if (Intrinsics.areEqual(r2.a, r5) == false) goto L6;
        if (r2.b != r6) goto L6;
        return;
    L12:
        r1.a.add(new nb6.b(r5, r6));
        return;
    }

    public final void g(long r10, long r12, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "source");
        jy0.b.d("GuestLinkPipeLineManager", "leaveChannel, roomId: " + r10 + ", channelId: " + r12 + ", source: " + r14 + ", needSendLeaveChannelReq: " + r15);
        if (G().c == true) goto L6;
        jy0.b.c("GuestLinkPipeLineManager", "leaveChannel return, cause: isEnterChannel is false", null, 4);
        return;
    L6:
        G().c = false;
        if (r15 == false) goto L9;
        this.k.B(r10, r12, r14, new d(this));
    L9:
        G().a();
        this.n.release();
        this.l.w("leaveChannel");
    }

    public final void h(long r9, long r11, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r14, "requestSource");
        jy0.b.d("GuestLinkPipeLineManager", "sendFinishChannelReq, roomId: " + r9 + ", channelId: " + r11 + ", source: " + r13 + ", requestSource: " + r14);
        this.k.t(r9, r11, r13, r14, new f(this));
    }

    public final void i(long r18, long r20, long r22, long r24) {
        jy0.b.d("GuestLinkPipeLineManager", "enterChannel, roomId: " + r18 + ", curChannelId: " + r20 + ", toChannelId: " + r22 + ", enterType: " + r24);
        this.k.m(r18, r20, r22, r24, new b(this, r18, r20));
    }

    public final void c(long r3, long r5, String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "requestSource");
        jy0.b.d("GuestLinkPipeLineManager", "finishChannel, roomId: " + r3 + ", channelId: " + r5 + ", reason: " + r7 + ", requestSource: " + r8 + ", needSendFinishChannelReq: " + r9);
        if (r9 == false) goto L5;
        h(r3, r5, r7, r8);
    L5:
        this.g = true;
        k(r7);
        this.l.w("finishChannel");
        this.n.release();
        G().a();
    }

    public GuestLinkPipeLineManager(Context r2, rb6.a r3, mb6.b r4, qb6.a r5, ob6.a r6, ub6.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "permissionManager");
        Intrinsics.checkNotNullParameter(r4, "apiManager");
        Intrinsics.checkNotNullParameter(r5, "msgManager");
        Intrinsics.checkNotNullParameter(r6, "mediaManager");
        Intrinsics.checkNotNullParameter(r7, "countDownManager");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.b = LazyKt.lazy(GuestLinkPipeLineManager$mLinkState$2.INSTANCE);
        new ThreadManager();
        this.h = new e(this);
    }

    public final void l(final long r14, final long r16, final int r18, final int r19, final String r20, final String r21, long r22, boolean r24) {
        Intrinsics.checkNotNullParameter(r20, "rtcExtInfo");
        jy0.b.d("GuestLinkPipeLineManager", "joinChannel, roomId: " + r14 + ", channelId: " + r16 + ", rtcExtInfo: " + r20 + ", liveCoreInfo: " + r21 + ", needCheckPermission: " + r24);
        this.n.setCallDuration(r22);
        G().a = true;
        G().b = true;
        this.d = Long.valueOf(r14);
        this.e = Long.valueOf(r16);
        Function0<Unit> r12 = new GuestLinkPipeLineManager$joinChannel$joinChannelTask$1(this, r16, r14, r18, r19, r20, r21);
        if (r24 == false) goto L5;
        this.j.x(this.i, OperateType.JOIN, r18, new c(this, r12));
        return;
    L5:
        r12.invoke();
    }
}
