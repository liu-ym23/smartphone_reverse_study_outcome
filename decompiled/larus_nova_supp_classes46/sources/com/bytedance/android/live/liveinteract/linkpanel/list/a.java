package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a extends yf0.a {
    public long c;
    public boolean d;
    public boolean e;
    public final String f;
    public Pair<Integer, Integer> g;
    public final IRoom h;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.list.a$a, reason: collision with other inner class name */
    public static final class C0040a<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ a b;

        public C0040a(long r1, a r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
            com.bytedance.android.live.liveinteract.linkpanel.util.p.d("apply_panel", this.a);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.a;
            String r3 = r6.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r2, r3);
            m0 r7 = (m0) r6.data;
            if (r7 == null) goto L10;
            List<n0> r8 = r7.getMWaitingUserInfo();
            if (r8 == null) goto L11;
            ArrayList<ILinkPlayerInfoBridge> r9 = com.bytedance.android.live.liveinteract.linkpanel.util.o.N(r8);
            BaseTalkApplyListWidgetContract$View r4 = (BaseTalkApplyListWidgetContract$View) this.b.b;
            if (r4 == null) goto L12;
            r4.yq(KotlinTypeUtilsKt.castElementType(r9));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ a b;

        public b(long r1, a r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r1, r5);
            x.F(r5, this.b.h.getId(), this.b.h.getOwnerUserIdString());
            ((BaseTalkApplyListWidgetContract$View) this.b.b).Aq(r5);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L13;
            a1 r4 = (a1) r3.data;
            if (r4 == null) goto L14;
            BaseTalkApplyListWidgetContract$View r0 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            if (r0 == null) goto L15;
            List<ILinkPlayerInfoBridge> r5 = r4.getPlayerInfo();
            if (r5 != null) goto L11;
            r5 = CollectionsKt.emptyList();
        L11:
            r0.yq(r5);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            x.F(r5, this.a.h.getId(), this.a.h.getOwnerUserIdString());
            ((BaseTalkApplyListWidgetContract$View) this.a.b).Aq(r5);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ a b;

        public e(long r1, a r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            String r3 = r6.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r1, r3);
            a1 r7 = (a1) r6.data;
            if (r7 == null) goto L11;
            BaseTalkApplyListWidgetContract$View r2 = (BaseTalkApplyListWidgetContract$View) this.b.b;
            if (r2 == null) goto L12;
            List<ILinkPlayerInfoBridge> r8 = r7.getPlayerInfo();
            if (r8 != null) goto L9;
            r8 = CollectionsKt.emptyList();
        L9:
            r2.zq(r8);
            return;
        L12:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ a b;

        public f(long r1, a r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r1, r5);
            ((BaseTalkApplyListWidgetContract$View) this.b.b).Aq(r5);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L13;
            a1 r4 = (a1) r3.data;
            if (r4 == null) goto L14;
            BaseTalkApplyListWidgetContract$View r0 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            if (r0 == null) goto L15;
            List<ILinkPlayerInfoBridge> r5 = r4.getPlayerInfo();
            if (r5 != null) goto L11;
            r5 = CollectionsKt.emptyList();
        L11:
            r0.zq(r5);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ a a;

        public h(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseTalkApplyListWidgetContract$View r0 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            r0.Aq((Throwable) r2);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ a a;

        public i(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            ALogger.d(this.a.f, "closePaidLinkGuide success");
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ a a;

        public j(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ALogger.d(this.a.f, "closePaidLinkGuide failed, " + ((Throwable) r4).getMessage());
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ a b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public k(long r1, a r3, boolean r4, String r5, boolean r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e<m0> r7 = (com.bytedance.android.live.network.response.e) r6;
            ALogger.i("panel_first_frame_opt_tag", "getLinkWaitingList ;; duration == " + (System.currentTimeMillis() - this.a) + " ;; logId == " + r7.logId);
            Map<String, cm2.a> r0 = com.bytedance.android.live.liveinteract.linkpanel.util.p.a;
            com.bytedance.android.live.liveinteract.linkpanel.util.p.d("apply_panel", this.a);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.a;
            String r3 = r7.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r2, r3);
            this.b.m(this.c, r7, this.d, this.e);
            x.Q(r7.data.getTotalCount(), false, true);
            this.b.e = false;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ IRoom b;
        public final /* synthetic */ a c;

        public l(long r1, IRoom r3, a r4) {
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
            x.H(r6, this.b.getId(), this.b.getOwnerUserIdString());
            ((BaseTalkApplyListWidgetContract$View) this.c.b).Aq(r6);
            ((BaseTalkApplyListWidgetContract$View) this.c.b).xq(false);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public m(a r1, boolean r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            a r0 = this.a;
            if (this.b == false) goto L5;
            long r1 = 0;
        L12:
            r0.c = r1;
            if (r15 == null) goto L39;
            a1 r16 = (a1) r15.data;
            if (r16 == null) goto L39;
            tc0.c r2 = tc0.c.h();
            r2.Q = r16.getNow();
            a r3 = this.a;
            r3.d = r16.getHasMore();
            if (r16.getSortStrategy() != 71) goto L19;
        L25:
            com.bytedance.android.livesdk.sharedpref.e r4 = b6.B;
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, 41);
        L26:
            BaseTalkApplyListWidgetContract$View r5 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            if (r5 == null) goto L35;
            List<ILinkPlayerInfoBridge> r6 = r16.getPlayerInfo();
            if (r6 != null) goto L31;
            r6 = CollectionsKt.emptyList();
        L31:
            List<ILinkPlayerInfoBridge> r7 = r6;
            long r8 = r16.getTotalCount();
            boolean r9 = this.a.d;
            String r10 = r16.getNextCursor();
            if (r10 != null) goto L34;
            r10 = "";
        L34:
            r5.Bq(r7, r8, r9, r10, this.c, r16.getShowPaidLinkGuide(), WaitingListType.NORMAL.ordinal(), false, this.d);
        L35:
            BaseTalkApplyListWidgetContract$View r11 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            if (r11 == null) goto L38;
            r11.wq(r16.getHasPreApply());
        L38:
            x.Q(r16.getTotalCount(), false, true);
            goto L39
        L19:
            if (r16.getSortStrategy() == 41) goto L25;
            if (r16.getSortStrategy() != 42) goto L24;
            com.bytedance.android.livesdk.sharedpref.e r12 = b6.B;
            r12.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r12, 42);
            goto L26
        L24:
            com.bytedance.android.livesdk.sharedpref.e r13 = b6.B;
            r13.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r13, 40);
        L39:
            this.a.e = false;
            return;
        L5:
            if (r15 == null) goto L10;
            a1 r17 = (a1) r15.data;
            if (r17 == null) goto L10;
            List<ILinkPlayerInfoBridge> r18 = r17.getPlayerInfo();
            if (r18 == null) goto L10;
        L11:
            r1 = r0.n(r18);
        L10:
            r18 = CollectionsKt.emptyList();
            goto L11
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ a b;

        public n(IRoom r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.b.e = false;
            x.H(r6, this.a.getId(), this.a.getOwnerUserIdString());
            ((BaseTalkApplyListWidgetContract$View) this.b.b).Aq(r6);
            ((BaseTalkApplyListWidgetContract$View) this.b.b).xq(false);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ a a;

        public o(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L10;
            com.bytedance.android.live.liveinteract.linkpanel.model.a r4 = (com.bytedance.android.live.liveinteract.linkpanel.model.a) r3.data;
            if (r4 == null) goto L11;
            BaseTalkApplyListWidgetContract$View r0 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            if (r0 == null) goto L12;
            r0.Cq(r4);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ a a;

        public p(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseTalkApplyListWidgetContract$View r0 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            r0.Aq((Throwable) r2);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Function1 c;

        public q(a r1, int r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            ALogger.d(this.a.f, "update sort setting success");
            this.c.invoke(Integer.valueOf(this.b));
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1 b;

        public r(a r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            BaseTalkApplyListWidgetContract$View r0 = (BaseTalkApplyListWidgetContract$View) this.a.b;
            r0.Aq((Throwable) r2);
        }
    }

    @Override // yf0.a
    public final void d() {
        IRoom r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (vm2.d.k() == false) goto L7;
    L10:
        long r1 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(r0.getId(), 50, "", WaitingListType.UNKNOWN.ordinal(), WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new C0040a(r1, this), new b(r1, this));
        return;
    L7:
        if (vm2.d.q() == true) goto L10;
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAllList(r0.getId(), r0.getOwnerUserIdString(), d5.c(r0.getOwnerUserIdString()), 1, 0, false, "linkCheckApply").as(c())).subscribe(new c(this), new d(this));
    }

    @Override // yf0.a
    public final void e() {
        IRoom r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (vm2.d.k() == false) goto L7;
        long r1 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getInviteList(r0.getId(), 1).as(c())).subscribe(new e(r1, this), new f(r1, this));
        return;
    L7:
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAllList(r0.getId(), r0.getOwnerUserIdString(), d5.c(r0.getOwnerUserIdString()), 1, 1, false, "linkCheckInvite").as(c())).subscribe(new g(this), new h(this));
    }

    @Override // yf0.a
    public final void i() {
        if (this.h == null) goto L6;
        ((ObservableSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAnchorFriends(10).as(c())).subscribe(new o(this), new p(this));
        return;
    }

    @Override // yf0.a
    public final Pair<Integer, Integer> j() {
        return this.g;
    }

    @Override // yf0.a
    public final void f(long r3) {
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).closePaidLinkGuide(r3).as(c())).subscribe(new i(this), new j(this));
    }

    @Override // yf0.a
    public final void k(Activity r23) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        ShareParams.Builder r1 = ShareParams.buildUponRoom(this.h);
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L19;
        IBaseUser r4 = r3.b();
        if (r4 == null) goto L20;
        r1.setUserId(r4.getIdString());
        r1.setAnchor(true);
        r1.setShareScene(ShareScene.LIVE);
        IRoom r5 = this.h;
        if (r5 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.p.a(com.bytedance.android.live.liveinteract.api.utils.m.n(null, Long.valueOf(r5.getId()), 1), r1);
    L12:
        ILiveMiddlewareShareService r6 = jc1.k.n(ILiveMiddlewareShareService.class);
        i81.a r7 = new i81.a(null, r23, null, r1.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false);
        String r8 = this.f;
        LiveShareType r9 = LiveShareType.SHARE_DIALOG;
        if (((Boolean) vm2.d.d1.getValue(null, vm2.d.a[105(0x69, float:1.47E-43)])).booleanValue() == false) goto L15;
        IShareCallback r10 = new com.bytedance.android.live.liveinteract.linkpanel.list.b(this);
    L16:
        r6.share(r7, r8, r9, r10);
        return;
    L15:
        r10 = new com.bytedance.android.live.liveinteract.linkpanel.list.c(this);
        goto L16
    L20:
        return;
    L19:
        return;
    }

    public final long n(List<? extends ILinkPlayerInfoBridge> r3) {
        if (r3 == null) goto L4;
        Integer r0 = Integer.valueOf(r3.size());
    L5:
        int r1 = r0.intValue();
        if (r1 > 0) goto L8;
        return 0;
    L8:
        return ((ILinkPlayerInfoBridge) ListProtector.get(r3, r1 - 1)).getModifyTimeInNano();
    L4:
        r0 = null;
        goto L5
    }

    public a(IRoom r2, BaseTalkApplyListWidgetContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.h = r2;
        this.d = true;
        this.f = "BaseTalkApplyListPresenter";
        this.g = new Pair(0, 0);
    }

    @Override // yf0.a
    public final void l(int r9, Function1<? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onUpdateSuccess");
        IRoom r0 = this.h;
        if (r0 == null) goto L13;
        Map<String, Object> r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", 4)});
        JSONArray r3 = new JSONArray();
        JSONObject r5 = new JSONObject();
        r5.put("key", 58);
        r5.put("value", r9);
        Unit r6 = Unit.INSTANCE;
        r3.put(r5);
        r2.put("incremental_update", r3);
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(r0.getRoomId(), r2).as(c())).subscribe(new q(this, r9, r10), new r(this, r10));
        if (r9 != 41) goto L7;
        String r11 = "money_first";
    L11:
        HashMap r12 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ordering_type", r11)});
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r12, null, 6);
        j0.l().sendLog("livesdk_anchor_apply_list_order_change_success", r12, new Object[]{am2.x.class, IRoom.class});
        return;
    L7:
        if (r9 == 42) goto L9;
        r11 = "time_first";
        goto L11
    L9:
        r11 = "complex_value";
        goto L11
    }

    public final void m(boolean r15, com.bytedance.android.live.network.response.e<m0> r16, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "response");
        Intrinsics.checkNotNullParameter(r17, "reqSource");
        ArrayList<ILinkPlayerInfoBridge> r2 = null;
        if (r15 == false) goto L5;
        long r3 = 0;
    L10:
        this.c = r3;
        m0 r1 = r16.data;
        tc0.c.h().Q = r1.getNow();
        this.d = r1.getHasMore();
        if (r1.getSortStrategy() != 71) goto L13;
    L19:
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.B;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, 41);
    L20:
        this.g = new Pair(Integer.valueOf((int) r1.getNormalListTotalCount()), Integer.valueOf((int) r1.getPaidListTotalCount()));
        BaseTalkApplyListWidgetContract$View r5 = (BaseTalkApplyListWidgetContract$View) this.b;
        if (r5 == null) goto L32;
        List<n0> r6 = r1.getMWaitingUserInfo();
        if (r6 == null) goto L25;
        r2 = com.bytedance.android.live.liveinteract.linkpanel.util.o.N(r6);
    L25:
        List<? extends ILinkPlayerInfoBridge> r7 = KotlinTypeUtilsKt.castElementType(r2);
        if (r7 != null) goto L28;
        r7 = new ArrayList();
    L28:
        List<? extends ILinkPlayerInfoBridge> r8 = r7;
        long r9 = r1.getTotalCount();
        boolean r10 = this.d;
        String r11 = r1.getNextCursor();
        if (r11 != null) goto L31;
        r11 = "";
    L31:
        r5.Bq(r8, r9, r10, r11, r17, r1.getShowPaidLinkGuide(), r1.getWaitingListType(), r1.getShowPaidListTab(), r18);
    L32:
        BaseTalkApplyListWidgetContract$View r12 = (BaseTalkApplyListWidgetContract$View) this.b;
        if (r12 == null) goto L36;
        r12.wq(r1.getHasPreApply());
        return;
    L36:
        return;
    L13:
        if (r1.getSortStrategy() == 41) goto L19;
        if (r1.getSortStrategy() != 42) goto L18;
        com.bytedance.android.livesdk.sharedpref.e r13 = b6.B;
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, 42);
        goto L20
    L18:
        com.bytedance.android.livesdk.sharedpref.e r14 = b6.B;
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, 40);
        goto L20
    L5:
        List<n0> r19 = r16.data.getMWaitingUserInfo();
        if (r19 == null) goto L8;
        ArrayList<ILinkPlayerInfoBridge> r20 = com.bytedance.android.live.liveinteract.linkpanel.util.o.N(r19);
    L9:
        r3 = n(KotlinTypeUtilsKt.castElementType(r20));
        goto L10
    L8:
        r20 = null;
        goto L9
    }

    @Override // yf0.a
    public final void g(boolean r25, String r26, long r27, String r29, int r30, boolean r31) {
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
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(r3.getId(), r27, r29, r30, WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new k(r14, this, r25, r26, r31), new l(r14, r3, this));
        return;
    L17:
        if (vm2.d.q() == true) goto L20;
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getPageList(r3.getId(), d5.c(r3.getOwnerUserIdString()), r3.getOwnerUserIdString(), 1, 0, r27, true, "", this.c, r29, r26).as(c())).subscribe(new m(this, r25, r26, r31), new n(r3, this));
        return;
    L23:
        return;
    L5:
        ((BaseTalkApplyListWidgetContract$View) this.b).xq(this.d);
        goto L6
    }
}
