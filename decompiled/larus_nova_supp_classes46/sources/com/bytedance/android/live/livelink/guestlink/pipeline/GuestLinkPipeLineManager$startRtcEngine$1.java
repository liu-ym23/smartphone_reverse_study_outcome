package com.bytedance.android.live.livelink.guestlink.pipeline;

import com.bytedance.android.live.base.model.message.guestlink.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.bytedance.live.kmp.util.d;
import com.bytedance.live.kmp.util.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vm2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestLinkPipeLineManager$startRtcEngine$1 implements ob6.a.b {
    public final /* synthetic */ GuestLinkPipeLineManager a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public static final class a implements ub6.a.a {
        public final /* synthetic */ GuestLinkPipeLineManager$startRtcEngine$1 a;

        public final void n() {
            GuestLinkPipeLineManager r0 = this.a.a;
            int r1 = GuestLinkPipeLineManager.o;
            com.bytedance.android.live.base.model.message.guestlink.a r2 = r0.G().f;
            String r3 = null;
            if ((r2 instanceof pb6.a) == false) goto L5;
            r2 = null;
        L5:
            boolean r4 = false;
            if (r2 == null) goto L23;
            List r5 = r2.getLinkedUsers();
            if (r5 != null) goto L10;
        L21:
            if (r4 == false) goto L23;
            tb6.a.d(true, r2, "timeout", (e.b() - r2.getStartTimeMs()) / ((long) 1000));
            goto L23
        L10:
            if (r5.size() != 2) goto L21;
            List r6 = r2.getLinkedUsers();
            if (r6 == null) goto L19;
            k r7 = (k) CollectionsKt.getOrNull(r6, 0);
            if (r7 == null) goto L19;
            IBaseUser r8 = r7.getUser();
            if (r8 == null) goto L19;
            r3 = r8.getIdString();
        L19:
            if (Intrinsics.areEqual(r3, rk0.b.a()) == false) goto L21;
            r4 = true;
        L23:
            jy0.b.d("GuestLinkPipeLineManager", "onCountDownEnd, needFinishChannel: " + r4);
            if (r4 == false) goto L26;
            GuestLinkPipeLineManager$startRtcEngine$1 r9 = this.a;
            r9.a.c(r9.b, r9.c, "onCountDownEnd", ChannelFinishReason.CLIENT_TIME_OUT.getRequestSource(), true);
        L27:
            nb6.a r10 = this.a.a.c;
            if (r10 == null) goto L35;
            CopyOnWriteArraySet r11 = r10.a;
            if (r11 == null) goto L37;
            Iterator r12 = r11.iterator();
        L33:
            if (r12.hasNext() == false) goto L38;
            ((nb6.b) r12.next()).a.n();
            goto L33
        L38:
            return;
        L37:
            return;
        L35:
            return;
        L26:
            this.a.a.k("onCountDownEnd");
            goto L27
        }

        public a(GuestLinkPipeLineManager$startRtcEngine$1 r1) {
            this.a = r1;
        }

        public final void e(long r3, long r5) {
            nb6.a r0 = this.a.a.c;
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

    public final void a() {
        jy0.b.c("GuestLinkPipeLineManager", "startRtcEngine onInitFailed", null, 4);
        this.a.c(this.b, this.c, "onInitFailed", ChannelFinishReason.SELF_RTC_EXCEPTION.getRequestSource(), true);
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.a();
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void g() {
        jy0.b.d("GuestLinkPipeLineManager", "startRtcEngine onBothJoinRtcRoomSuccess");
        this.a.n.setStartTime(e.a());
        ub6.a r0 = this.a.n;
        r0.y(r0.getCallDuration(), this.a.n.getStartTime());
        this.a.n.o(new a(this));
    }

    public final void m() {
        jy0.b.c("GuestLinkPipeLineManager", "onSelfConnectionStateLostOrFailed", null, 4);
        this.a.c(this.b, this.c, "onSelfConnectionStateLostOrFailed", ChannelFinishReason.SELF_RTC_EXCEPTION.getRequestSource(), false);
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.m();
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void onInitSuccess() {
        jy0.b.d("GuestLinkPipeLineManager", "startRtcEngine onInitSuccess");
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.onInitSuccess();
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void d(String r3) {
        jy0.b.d("GuestLinkPipeLineManager", "startRtcEngine onRemoteRtcUserJoined, rtcUserId: " + r3);
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.d(r3);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void p(String r3) {
        Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
        jy0.b.d("GuestLinkPipeLineManager", "startRtcEngine onSelfLeaveRtcRoomSuccess");
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.p(r3);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r4, "rtcUserId");
        jy0.b.d("GuestLinkPipeLineManager", "startRtcEngine onSelfJoinRtcRoomSuccess, rtcRoomId: " + r3 + ", rtcUserId: " + r4);
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.b(r3, r4);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void k(String r13, int r14) {
        jy0.b.c("GuestLinkPipeLineManager", "startRtcEngine onRemoteRtcUserLeave, rtcUserId: " + r13 + ", reason: " + r14, null, 4);
        if (r14 == 0) goto L5;
        this.a.c(this.b, this.c, "onRemoteRtcUserLeave", ChannelFinishReason.REMOTE_USER_LEAVE.getRequestSource(), true);
    L8:
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L16;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        ((nb6.b) r2.next()).a.k(r13, r14);
        goto L14
    L19:
        return;
    L18:
        return;
    L16:
        return;
    L5:
        this.a.k("onRemoteRtcUserLeave");
        long r3 = i.e().getFinishChannelDelayInMillis();
        if (r3 <= 0) goto L8;
        this.a.f = new GuestLinkPipeLineManager$startRtcEngine$1$onRemoteRtcUserLeave$1(this);
        this.a.g = false;
        d.b(r3, true, new GuestLinkPipeLineManager$startRtcEngine$1$onRemoteRtcUserLeave$2(this), 2);
        goto L8
    }

    public final void l(String r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "rtcRoomId");
        jy0.b.c("GuestLinkPipeLineManager", "startRtcEngine onSelfJoinRtcRoomFailed", null, 4);
        this.a.c(this.b, this.c, "onSelfJoinRtcRoomFailed", ChannelFinishReason.SELF_RTC_EXCEPTION.getRequestSource(), true);
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.l(r13, r14);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public GuestLinkPipeLineManager$startRtcEngine$1(GuestLinkPipeLineManager r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
