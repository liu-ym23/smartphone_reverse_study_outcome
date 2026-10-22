package com.bytedance.android.live.livepkaudience.presenter;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.livepkaudience.base.PkAudienceApi;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.config.vh1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import dl0.m;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends com.bytedance.android.live.livepkaudience.dialog.b {
    public final IRoom c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ long b;

        public a(g r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            m.o(this.b, r5.logId);
            a1 r6 = (a1) r5.data;
            if (r6 == null) goto L8;
            BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
            if (r0 == null) goto L9;
            r0.aa0(r6);
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ long b;

        public b(g r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            m.n(this.b, r4);
            BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
            if (r0 == null) goto L6;
            r0.V90(r4);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ long b;

        public c(g r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            m.o(this.b, r5.logId);
            a1 r6 = (a1) r5.data;
            if (r6 == null) goto L13;
            BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
            if (r0 == null) goto L14;
            List<ILinkPlayerInfoBridge> r7 = r6.getPlayerInfo();
            if (r7 == null) goto L15;
            List<? extends LinkPlayerInfo> r8 = jm2.a.a(r7);
            if (r8 == null) goto L16;
            r0.W90(r8);
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
        public final /* synthetic */ g a;
        public final /* synthetic */ long b;

        public d(g r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            m.n(this.b, r4);
            ((BasePkAudienceInviteListContract$View) this.a.b).V90(r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ g a;

        public e(g r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Response r3 = (Response) r2;
            if (r3 == null) goto L10;
            bl0.b r4 = (bl0.b) r3.data;
            if (r4 == null) goto L11;
            BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
            if (r0 == null) goto L12;
            r0.X90(r4);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ g a;

        public f(g r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
            r0.V90((Throwable) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.presenter.g$g, reason: collision with other inner class name */
    public static final class C0117g<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ LinkPlayerInfo b;

        public C0117g(g r1, LinkPlayerInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Response r3 = (Response) r2;
            vh7.c r4 = this.b.getUser();
            if (r4 == null) goto L10;
            User r5 = jm2.a.e(r4);
            if (r5 == null) goto L11;
            BasePkAudienceInviteListContract$View r0 = (BasePkAudienceInviteListContract$View) this.a.b;
            if (r0 == null) goto L12;
            r0.Y90(r5);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ g a;

        public h(g r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = ((BasePkAudienceInviteListContract$View) this.a.b).getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.b
    public final void f() {
        if (this.c == null) goto L6;
        ((ObservableSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).getAnchorFriends(10).as(c())).subscribe(new e(this), new f(this));
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.b
    public final void e(boolean r7) {
        IRoom r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        PkAudienceApi r3 = (PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class);
        long r4 = r0.getId();
        int r2 = BasePkAudienceInviteListFragment.A;
        if (r7 == false) goto L11;
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r8 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r8 == null) goto L10;
        String r9 = r8.Wc();
    L12:
        ((SingleSubscribeProxy) r3.getInviteList(r4, 1, r9).as(c())).subscribe(new c(this, r1), new d(this, r1));
        return;
    L10:
        r9 = null;
        goto L12
    L11:
        r9 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.b
    public final void g(LinkPlayerInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "userInfo");
        IRoom r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (dl0.k.a() == false) goto L9;
        f2.c(s1.B(2131917794), 0);
        return;
    L9:
        PkAudienceApi r2 = (PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class);
        long r3 = r0.getId();
        IBaseUser r1 = r10.getUser();
        if (r1 == null) goto L12;
        String r4 = r1.getIdString();
    L13:
        ((SingleSubscribeProxy) r2.inviteFriends(r3, new JSONArray(CollectionsKt.listOf(Long.valueOf(d5.c(r4)))).toString(), 0, 0).as(c())).subscribe(new C0117g(this, r10), new h(this));
        return;
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.b
    public final void i(Activity r23) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        ShareParams.Builder r1 = ShareParams.buildUponRoom(this.c);
        IUserService r2 = jc1.k.f(IUserService.class);
        if (r2 == null) goto L20;
        com.bytedance.android.livesdk.user.f r3 = r2.user();
        if (r3 == null) goto L21;
        IUser r4 = r3.b();
        if (r4 == null) goto L22;
        r1.setUserId(r4.getIdString());
        r1.setAnchor(true);
        r1.setShareScene(ShareScene.LIVE);
        if (this.c == null) goto L14;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L14;
        o0.a(r5, r1);
    L14:
        ILiveShareService r14 = jc1.k.n(ILiveShareService.class);
        i81.a r6 = new i81.a(null, r23, null, r1.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false);
        LiveShareType r7 = LiveShareType.SHARE_DIALOG;
        if (((Boolean) vh1.a.getValue()).booleanValue() == false) goto L17;
        IShareCallback r8 = new j();
    L18:
        r14.share(r6, "PkAudienceInviteListPresenter", r7, r8);
        return;
    L17:
        r8 = new k();
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public g(Room r2, BasePkAudienceInviteListContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.c = r2;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.b
    public final void d(boolean r7, boolean r8) {
        IRoom r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        PkAudienceApi r3 = (PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class);
        long r4 = r0.getId();
        if (r7 == false) goto L8;
        int r9 = BasePkAudienceInviteListFragment.A;
        byte r10 = (byte) 3;
    L9:
        if (r8 == false) goto L14;
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r11 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r11 == null) goto L13;
        String r12 = r11.Wc();
    L15:
        ((SingleSubscribeProxy) r3.getInviteList(r4, r10, r12).as(c())).subscribe(new a(this, r1), new b(this, r1));
        return;
    L13:
        r12 = null;
        goto L15
    L14:
        r12 = "";
        goto L15
    L8:
        int r13 = BasePkAudienceInviteListFragment.A;
        r10 = 2;
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.b
    public final void h(List r11, BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1.AnonymousClass1.a.C0113a r12) {
        Intrinsics.checkNotNullParameter(r11, "friendList");
        Intrinsics.checkNotNullParameter(r12, "callback");
        boolean r1 = false;
        if (dl0.k.a() == false) goto L6;
        f2.c(s1.B(2131917794), 0);
        return;
    L6:
        IRoom r0 = this.c;
        if (r0 != null) goto L9;
        return;
    L9:
        List r2 = r11;
        if ((r2 instanceof Collection) == true) goto L12;
    L14:
        Iterator r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        if (((IMiddlewareHostSocial.InviteFriendsConfig.Friend) r3.next()).isNormalUser() == false) goto L16;
    L21:
        if (r1 == false) goto L26;
        r12.invoke(r11, r0);
        BasePkAudienceInviteListContract$View r13 = (BasePkAudienceInviteListContract$View) this.b;
        if (r13 == null) goto L31;
        r13.Z90(r11);
        return;
    L31:
        return;
    L26:
        ((SingleSubscribeProxy) ((PkAudienceApi) com.bytedance.android.live.network.c.b().e(PkAudienceApi.class)).inviteFriends(r0.getId(), new JSONArray(SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r2), PkAudienceInviteListPresenter$inviteFriends$2.INSTANCE), new PkAudienceInviteListPresenter$inviteFriends$3(this)))).toString(), 0, 0).as(c())).subscribe(new com.bytedance.android.live.livepkaudience.presenter.h(this, r11, r12, r0), new i(this));
        return;
    L20:
        r1 = true;
        goto L21
    L12:
        if (r2.isEmpty() == false) goto L14;
        goto L14
    }
}
