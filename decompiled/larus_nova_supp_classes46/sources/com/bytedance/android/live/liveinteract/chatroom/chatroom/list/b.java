package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a {
    public long c;
    public boolean d;
    public boolean e;
    public final String f;
    public Pair<Integer, Integer> g;
    public final IRoom h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            ALogger.d(this.a.f, "closePaidLinkGuide success");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.list.b$b, reason: collision with other inner class name */
    public static final class C0022b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0022b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ALogger.d(this.a.f, "closePaidLinkGuide failed, " + ((Throwable) r4).getMessage());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public c(long r1, b r3, boolean r4, String r5, boolean r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            String r3 = r15.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r1, r3);
            b r2 = this.b;
            if (this.c == false) goto L5;
            long r4 = 0;
        L10:
            r2.c = r4;
            m0 r16 = (m0) r15.data;
            if (r16 == null) goto L33;
            tc0.c r5 = tc0.c.h();
            r5.Q = r16.getNow();
            b r6 = this.b;
            r6.d = r16.getHasMore();
            if (r16.getSortStrategy() != 71) goto L15;
        L18:
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r7.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r7, 41);
        L19:
            b r8 = this.b;
            r8.g = new Pair(Integer.valueOf((int) r16.getNormalListTotalCount()), Integer.valueOf((int) r16.getPaidListTotalCount()));
            BaseTalkApplyListContract$View r9 = (BaseTalkApplyListContract$View) this.b.b;
            if (r9 == null) goto L29;
            List<n0> r10 = r16.getMWaitingUserInfo();
            if (r10 == null) goto L24;
            ArrayList<ILinkPlayerInfoBridge> r11 = je0.d.e0(r10);
        L25:
            ArrayList<ILinkPlayerInfoBridge> r12 = r11;
            long r13 = r16.getTotalCount();
            boolean r17 = this.b.d;
            String r18 = r16.getNextCursor();
            if (r18 != null) goto L28;
            r18 = "";
        L28:
            r9.V90(r12, r13, r17, r18, this.d, r16.getShowPaidLinkGuide(), r16.getWaitingListType(), r16.getShowPaidListTab(), this.e);
            goto L29
        L24:
            r11 = new ArrayList();
        L29:
            BaseTalkApplyListContract$View r19 = (BaseTalkApplyListContract$View) this.b.b;
            if (r19 == null) goto L32;
            r19.S90(r16.getHasPreApply());
        L32:
            x.Q(r16.getTotalCount(), false, true);
            goto L33
        L15:
            if (r16.getSortStrategy() == 41) goto L18;
            com.bytedance.android.livesdk.sharedpref.e r20 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r20.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r20, 40);
        L33:
            this.b.e = false;
            return;
        L5:
            List<n0> r21 = ((m0) r15.data).getMWaitingUserInfo();
            if (r21 == null) goto L8;
            ArrayList<ILinkPlayerInfoBridge> r22 = je0.d.e0(r21);
        L9:
            r4 = b.i(r2, r22);
            goto L10
        L8:
            r22 = new ArrayList();
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ IRoom b;
        public final /* synthetic */ b c;

        public d(long r1, IRoom r3, b r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.c.e = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r2, r6);
            long r3 = this.b.getId();
            String r1 = this.b.getAnchorId();
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            x.H(r6, r3, r1);
            ((BaseTalkApplyListContract$View) this.c.b).U90(r6);
            ((BaseTalkApplyListContract$View) this.c.b).T90(false);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public e(b r1, boolean r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            b r0 = this.a;
            if (this.b == false) goto L5;
            long r1 = 0;
        L9:
            r0.c = r1;
            if (r15 == null) goto L33;
            a1 r16 = (a1) r15.data;
            if (r16 == null) goto L33;
            tc0.c r2 = tc0.c.h();
            r2.Q = r16.getNow();
            b r3 = this.a;
            r3.d = r16.getHasMore();
            if (r16.getSortStrategy() != 71) goto L16;
        L19:
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, 41);
        L20:
            BaseTalkApplyListContract$View r5 = (BaseTalkApplyListContract$View) this.a.b;
            if (r5 == null) goto L29;
            List<ILinkPlayerInfoBridge> r6 = r16.getPlayerInfo();
            if (r6 != null) goto L25;
            r6 = CollectionsKt.emptyList();
        L25:
            List<ILinkPlayerInfoBridge> r7 = r6;
            long r8 = r16.getTotalCount();
            boolean r9 = this.a.d;
            String r10 = r16.getNextCursor();
            if (r10 != null) goto L28;
            r10 = "";
        L28:
            r5.V90(r7, r8, r9, r10, this.c, r16.getShowPaidLinkGuide(), WaitingListType.NORMAL.ordinal(), false, this.d);
        L29:
            BaseTalkApplyListContract$View r11 = (BaseTalkApplyListContract$View) this.a.b;
            if (r11 == null) goto L32;
            r11.S90(r16.getHasPreApply());
        L32:
            x.Q(r16.getTotalCount(), false, true);
            goto L33
        L16:
            if (r16.getSortStrategy() == 41) goto L19;
            com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r12.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r12, 40);
        L33:
            this.a.e = false;
            return;
        L5:
            List<ILinkPlayerInfoBridge> r13 = ((a1) r15.data).getPlayerInfo();
            if (r13 != null) goto L8;
            r13 = CollectionsKt.emptyList();
        L8:
            r1 = b.i(r0, r13);
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ b b;

        public f(IRoom r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.b.e = false;
            long r2 = this.a.getId();
            String r0 = this.a.getAnchorId();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            x.H(r6, r2, r0);
            ((BaseTalkApplyListContract$View) this.b.b).U90(r6);
            ((BaseTalkApplyListContract$View) this.b.b).T90(false);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ b a;

        public g(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((com.bytedance.android.live.network.response.e) r1) == null) goto L8;
            BaseTalkApplyListContract$View r2 = (BaseTalkApplyListContract$View) this.a.b;
            if (r2 == null) goto L9;
            r2.X90();
            return;
        L9:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ b a;

        public h(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseTalkApplyListContract$View r0 = (BaseTalkApplyListContract$View) this.a.b;
            r0.W90((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a
    public final void h() {
        IRoom r0 = this.h;
        if (r0 == null) goto L6;
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).sendLinkCall(r0.getId()).as(c())).subscribe(new g(this), new h(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a
    public final Pair<Integer, Integer> g() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a
    public final void d(long r3) {
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).closePaidLinkGuide(r3).as(c())).subscribe(new a(this), new C0022b(this));
    }

    public b(IRoom r2, BaseTalkApplyListContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.h = r2;
        this.d = true;
        this.f = "BaseTalkApplyListPresenter";
        this.g = new Pair(0, 0);
    }

    public static final long i(b r0, List r1) {
        r0.getClass();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.size());
    L6:
        int r3 = r2.intValue();
        if (r3 > 0) goto L11;
        return 0;
    L11:
        return ((ILinkPlayerInfoBridge) ListProtector.get(r1, r3 - 1)).getModifyTimeInNano();
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.list.a
    public final void e(boolean r25, String r26, long r27, String r29, int r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r26, "reqSource");
        Intrinsics.checkNotNullParameter(r29, "cursor");
        if (r25 == false) goto L5;
        this.d = true;
    L6:
        if (r31 == false) goto L9;
        this.e = false;
    L9:
        if (this.d == true) goto L11;
        return;
    L11:
        if (this.e == true) goto L23;
        this.e = true;
        IRoom r3 = this.h;
        if (r3 != null) goto L15;
        return;
    L15:
        if (vm2.d.k() == false) goto L17;
    L20:
        long r14 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(r3.getId(), r27, r29, r30, WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new c(r14, this, r25, r26, r31), new d(r14, r3, this));
        return;
    L17:
        if (vm2.d.q() == true) goto L20;
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getPageList(r3.getId(), d5.c(r3.getAnchorId()), r3.getAnchorId(), 1, 0, r27, true, "", this.c, r29, r26).as(c())).subscribe(new e(this, r25, r26, r31), new f(r3, this));
        return;
    L23:
        return;
    L5:
        ((BaseTalkApplyListContract$View) this.b).T90(this.d);
        goto L6
    }
}
