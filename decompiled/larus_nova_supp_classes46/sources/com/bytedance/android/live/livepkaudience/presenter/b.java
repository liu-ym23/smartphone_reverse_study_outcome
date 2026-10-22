package com.bytedance.android.live.livepkaudience.presenter;

import android.app.Activity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListResponse;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.livepkaudience.base.PkAudienceApi;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.config.vh1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dl0.m;
import dl0.n;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends com.bytedance.android.live.livepkaudience.dialog.a {
    public boolean c;
    public boolean d;
    public final String e;
    public final Room f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public a(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            m.r(this.a, r5.logId);
            WaitingListResponse r6 = (WaitingListResponse) r5.data;
            if (r6 == null) goto L10;
            List<WaitingListUser> r7 = r6.getMWaitingUserInfo();
            if (r7 == null) goto L11;
            ArrayList<LinkPlayerInfo> r8 = n.f(r7);
            BasePkAudienceApplyListContract$View r0 = (BasePkAudienceApplyListContract$View) this.b.b;
            if (r0 == null) goto L12;
            r0.X90(r8);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.presenter.b$b, reason: collision with other inner class name */
    public static final class C0116b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public C0116b(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            m.q(this.a, r4);
            ((BasePkAudienceApplyListContract$View) this.b.b).Z90(r4);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public c(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            m.o(this.a, r5.logId);
            a1 r6 = (a1) r5.data;
            if (r6 == null) goto L13;
            BasePkAudienceApplyListContract$View r0 = (BasePkAudienceApplyListContract$View) this.b.b;
            if (r0 == null) goto L14;
            List<ILinkPlayerInfoBridge> r7 = r6.getPlayerInfo();
            if (r7 == null) goto L15;
            List<? extends LinkPlayerInfo> r8 = jm2.a.a(r7);
            if (r8 == null) goto L16;
            r0.Y90(r8);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public d(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            m.n(this.a, r4);
            ((BasePkAudienceApplyListContract$View) this.b.b).Z90(r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public e(long r1, b r3, boolean r4, String r5) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r9) {
            Response r10 = (Response) r9;
            m.r(this.a, r10.logId);
            b r0 = this.b;
            if (this.c == true) goto L12;
            List<WaitingListUser> r1 = ((WaitingListResponse) r10.data).getMWaitingUserInfo();
            if (r1 == null) goto L8;
            ArrayList<LinkPlayerInfo> r2 = n.f(r1);
        L9:
            r0.getClass();
            int r3 = Integer.valueOf(r2.size()).intValue();
            if (r3 <= 0) goto L12;
            long r4 = ((LinkPlayerInfo) ListProtector.get(r2, r3 - 1)).modifyTimeInNano;
            goto L12
        L8:
            r2 = new ArrayList();
        L12:
            r0.getClass();
            WaitingListResponse r11 = (WaitingListResponse) r10.data;
            if (r11 == null) goto L34;
            tc0.c.h().Q = r11.getNow();
            this.b.c = r11.getHasMore();
            if (r11.getSortStrategy() != 71) goto L17;
        L20:
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, 41);
        L21:
            BasePkAudienceApplyListContract$View r6 = (BasePkAudienceApplyListContract$View) this.b.b;
            if (r6 == null) goto L31;
            List<WaitingListUser> r7 = r11.getMWaitingUserInfo();
            if (r7 == null) goto L26;
            ArrayList<LinkPlayerInfo> r8 = n.f(r7);
        L27:
            ArrayList<LinkPlayerInfo> r12 = r8;
            int r13 = (int) r11.getTotalCount();
            boolean r14 = this.b.c;
            String r15 = r11.getNextCursor();
            if (r15 != null) goto L30;
            r15 = "";
        L30:
            r6.aa0(r12, r13, r14, r15, this.d, r11.getWaitingListType());
            goto L31
        L26:
            r8 = new ArrayList();
        L31:
            BasePkAudienceApplyListContract$View r16 = (BasePkAudienceApplyListContract$View) this.b.b;
            if (r16 == null) goto L34;
            r16.V90(r11.getHasPreApply());
            goto L34
        L17:
            if (r11.getSortStrategy() == 41) goto L20;
            com.bytedance.android.livesdk.sharedpref.e r17 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r17.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r17, 40);
        L34:
            this.b.d = false;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public f(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.b.d = false;
            m.q(this.a, r6);
            ((BasePkAudienceApplyListContract$View) this.b.b).Z90(r6);
            ((BasePkAudienceApplyListContract$View) this.b.b).W90(false);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public g(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r11) {
            Response r12 = (Response) r11;
            if (r12 == null) goto L10;
            bl0.b r0 = (bl0.b) r12.data;
            if (r0 == null) goto L11;
            long r1 = this.a;
            String r13 = r12.logId;
            m r3 = m.a;
            Intrinsics.checkNotNullParameter(r13, "logId");
            JSONObject r9 = new JSONObject();
            BaseMonitor.add(r9, "api_log_id", r13);
            m r14 = m.a;
            long r7 = System.currentTimeMillis() - r1;
            r14.getClass();
            m.z("linkmic_audience/list_friends", 0, "", r7, r9);
            BasePkAudienceApplyListContract$View r15 = (BasePkAudienceApplyListContract$View) this.b.b;
            if (r15 == null) goto L12;
            r15.ba0(r0);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public h(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r12) {
            ApiServerException r13 = (Throwable) r12;
            long r0 = this.a;
            m r2 = m.a;
            JSONObject r8 = new JSONObject();
            if (r13 != null) goto L5;
        L11:
            ((BasePkAudienceApplyListContract$View) this.b.b).Z90(r13);
            return;
        L5:
            if ((r13 instanceof ApiServerException) == false) goto L10;
            m r3 = m.a;
            ApiServerException r4 = r13;
            int r5 = r4.getErrorCode();
            String r6 = r4.getErrorMsg();
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            long r1 = System.currentTimeMillis() - r0;
            r3.getClass();
            m.z("linkmic_audience/list_friends", r5, r6, r1, r8);
            goto L11
        L10:
            m r7 = m.a;
            String r9 = r13.toString();
            long r10 = System.currentTimeMillis() - r0;
            r7.getClass();
            m.z("linkmic_audience/list_friends", 1, r9, r10, r8);
            goto L11
        }
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void d() {
        Room r0 = this.f;
        if (r0 == null) goto L6;
        long r1 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getLinkWaitingList(r0.id, 50, "", WaitingListType.UNKNOWN.ordinal(), WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new a(r1, this), new C0116b(r1, this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void e() {
        Room r0 = this.f;
        if (r0 == null) goto L6;
        long r1 = System.currentTimeMillis();
        PkAudienceApi r3 = (PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class);
        long r4 = r0.id;
        int r2 = BasePkAudienceInviteListFragment.A;
        ((SingleSubscribeProxy) r3.getInviteList(r4, 1, "").as(c())).subscribe(new c(r1, this), new d(r1, this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void h() {
        if (this.f == null) goto L6;
        long r0 = System.currentTimeMillis();
        ((ObservableSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getAnchorFriends(10).as(c())).subscribe(new g(r0, this), new h(r0, this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void i(Activity r23) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        ShareParams.Builder r1 = ShareParams.buildUponRoom(this.f);
        IUserService r2 = jc1.k.f(IUserService.class);
        if (r2 == null) goto L20;
        com.bytedance.android.livesdk.user.f r3 = r2.user();
        if (r3 == null) goto L21;
        IUser r4 = r3.b();
        if (r4 == null) goto L22;
        r1.setUserId(r4.getIdString());
        r1.setAnchor(true);
        r1.setShareScene(ShareScene.LIVE);
        if (this.f == null) goto L14;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L14;
        o0.a(r5, r1);
    L14:
        ILiveMiddlewareShareService r14 = jc1.k.n(ILiveMiddlewareShareService.class);
        i81.a r6 = new i81.a(null, r23, null, r1.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false);
        String r7 = this.e;
        LiveShareType r8 = LiveShareType.SHARE_DIALOG;
        if (((Boolean) vh1.a.getValue()).booleanValue() == false) goto L17;
        IShareCallback r9 = new com.bytedance.android.live.livepkaudience.presenter.c(this);
    L18:
        r14.share(r6, r7, r8, r9);
        return;
    L17:
        r9 = new com.bytedance.android.live.livepkaudience.presenter.d(this);
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public b(Room r2, BasePkAudienceApplyListContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.f = r2;
        this.c = true;
        this.e = "PkAudienceApplyListPresenter";
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.a
    public final void f(boolean r16, String r17, long r18, String r20, int r21) {
        Intrinsics.checkNotNullParameter(r17, "reqSource");
        Intrinsics.checkNotNullParameter(r20, "cursor");
        if (r16 == false) goto L5;
        this.c = true;
    L7:
        if (this.c == true) goto L9;
        return;
    L9:
        if (this.d == true) goto L15;
        this.d = true;
        Room r0 = this.f;
        if (r0 == null) goto L16;
        long r3 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getLinkWaitingList(r0.id, r18, r20, r21, WaitingListSource.ANCHOR_PANEL.ordinal()).as(c())).subscribe(new e(r3, this, r16, r17), new f(r3, this));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        ((BasePkAudienceApplyListContract$View) this.b).W90(this.c);
        goto L7
    }
}
