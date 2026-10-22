package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.model.AudienceInviteSource;
import com.bytedance.android.live.liveinteract.linkpanel.util.p;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class BaseTalkInviteListWidgetPresenter extends yf0.c {
    public final IRoom c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;
        public final /* synthetic */ long b;

        public a(BaseTalkInviteListWidgetPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            Map<String, cm2.a> r0 = p.a;
            p.d("invite_panel", this.b);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.b;
            String r3 = r6.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r2, r3);
            a1 r7 = (a1) r6.data;
            if (r7 == null) goto L8;
            BaseTalkInviteListWidgetContract$View r4 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            if (r4 == null) goto L9;
            r4.Aq(r7);
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;
        public final /* synthetic */ long b;

        public b(BaseTalkInviteListWidgetPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r1, r5);
            BaseTalkInviteListWidgetContract$View r2 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            if (r2 == null) goto L6;
            r2.wq(r5);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;
        public final /* synthetic */ long b;

        public c(BaseTalkInviteListWidgetPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            String r3 = r6.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r1, r3);
            a1 r7 = (a1) r6.data;
            if (r7 == null) goto L11;
            BaseTalkInviteListWidgetContract$View r2 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            if (r2 == null) goto L12;
            List<ILinkPlayerInfoBridge> r8 = r7.getPlayerInfo();
            if (r8 != null) goto L9;
            r8 = CollectionsKt.emptyList();
        L9:
            r2.xq(r8);
            return;
        L12:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;
        public final /* synthetic */ long b;

        public d(BaseTalkInviteListWidgetPresenter r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r1, r5);
            ((BaseTalkInviteListWidgetContract$View) this.a.b).wq(r5);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;

        public e(BaseTalkInviteListWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L13;
            a1 r4 = (a1) r3.data;
            if (r4 == null) goto L14;
            BaseTalkInviteListWidgetContract$View r0 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            if (r0 == null) goto L15;
            List<ILinkPlayerInfoBridge> r5 = r4.getPlayerInfo();
            if (r5 != null) goto L11;
            r5 = CollectionsKt.emptyList();
        L11:
            r0.xq(r5);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;

        public f(BaseTalkInviteListWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseTalkInviteListWidgetContract$View r0 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            r0.wq((Throwable) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;

        public g(BaseTalkInviteListWidgetPresenter r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            if (r3 == null) goto L10;
            com.bytedance.android.live.liveinteract.linkpanel.model.a r4 = (com.bytedance.android.live.liveinteract.linkpanel.model.a) r3.data;
            if (r4 == null) goto L11;
            BaseTalkInviteListWidgetContract$View r0 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            if (r0 == null) goto L12;
            r0.yq(r4);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;

        public h(BaseTalkInviteListWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseTalkInviteListWidgetContract$View r0 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            r0.wq((Throwable) r2);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;
        public final /* synthetic */ List b;
        public final /* synthetic */ Function2 c;
        public final /* synthetic */ IRoom d;

        public i(BaseTalkInviteListWidgetPresenter r1, List r2, Function2 r3, IRoom r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            List r0 = ((v) r6.data).getInvitedUserList();
            if (r0 == null) goto L9;
            Sequence r1 = CollectionsKt.asSequence(r0);
            if (r1 == null) goto L9;
            Sequence r2 = SequencesKt.map(r1, BaseTalkInviteListWidgetPresenter$inviteFriends$6$uidSet$1.INSTANCE);
            if (r2 == null) goto L9;
            final Set r3 = SequencesKt.toSet(r2);
        L10:
            List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r4 = SequencesKt.toList(SequencesKt.onEach(SequencesKt.filter(CollectionsKt.asSequence(this.b), new BaseTalkInviteListWidgetPresenter$inviteFriends$6$filteredList$1(r3)), BaseTalkInviteListWidgetPresenter$inviteFriends$6$filteredList$2.INSTANCE));
            this.c.invoke(this.b, this.d);
            BaseTalkInviteListWidgetContract$View r7 = (BaseTalkInviteListWidgetContract$View) this.a.b;
            if (r7 == null) goto L14;
            r7.zq(r4, ((v) r6.data).getNoticeInfoList());
            return;
        L14:
            return;
        L9:
            r3 = null;
            goto L10
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ BaseTalkInviteListWidgetPresenter a;

        public j(BaseTalkInviteListWidgetPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = ((Widget) ((BaseTalkInviteListWidgetContract$View) this.a.b)).context;
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    @Override // yf0.c
    public final void e() {
        IRoom r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (vm2.d.k() == false) goto L8;
        long r1 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getInviteList(r0.getId(), 1).as(c())).subscribe(new c(this, r1), new d(this, r1));
        return;
    L8:
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAllList(r0.getId(), r0.getOwnerUserIdString(), d5.c(r0.getOwnerUserIdString()), 1, 1, false, "fetchInviteList").as(c())).subscribe(new e(this), new f(this));
    }

    @Override // yf0.c
    public final void f() {
        if (this.c == null) goto L6;
        ((ObservableSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAnchorFriends(10).as(c())).subscribe(new g(this), new h(this));
        return;
    }

    @Override // yf0.c
    public final void d(boolean r7) {
        IRoom r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        LinkAnchorApi r3 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r4 = r0.getId();
        if (r7 == false) goto L8;
        byte r8 = (byte) 3;
    L9:
        ((SingleSubscribeProxy) r3.getInviteList(r4, r8).as(c())).subscribe(new a(this, r1), new b(this, r1));
        return;
    L8:
        r8 = 2;
        goto L9
    }

    @Override // yf0.c
    public final void h(Activity r23) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        ShareParams.Builder r1 = ShareParams.buildUponRoom(this.c);
        IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L19;
        IBaseUser r4 = r3.b();
        if (r4 == null) goto L20;
        r1.setUserId(r4.getIdString());
        r1.setAnchor(true);
        r1.setShareScene(ShareScene.LIVE);
        IRoom r5 = this.c;
        if (r5 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.p.a(m.n(null, Long.valueOf(r5.getId()), 1), r1);
    L12:
        ILiveMiddlewareShareService r6 = k.n(ILiveMiddlewareShareService.class);
        i81.a r7 = new i81.a(null, r23, null, r1.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false);
        LiveShareType r8 = LiveShareType.SHARE_DIALOG;
        if (((Boolean) vm2.d.d1.getValue(null, vm2.d.a[105(0x69, float:1.47E-43)])).booleanValue() == false) goto L15;
        IShareCallback r9 = new com.bytedance.android.live.liveinteract.linkpanel.presenter.e(this);
    L16:
        r6.share(r7, "BaseTalkInviteListPresenter", r8, r9);
        return;
    L15:
        r9 = new com.bytedance.android.live.liveinteract.linkpanel.presenter.f(this);
        goto L16
    L20:
        return;
    L19:
        return;
    }

    public BaseTalkInviteListWidgetPresenter(IRoom r2, BaseTalkInviteListWidgetContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.c = r2;
    }

    @Override // yf0.c
    public final void g(int r22, List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r23, Function2<? super List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend>, ? super IRoom, Unit> r24) {
        Intrinsics.checkNotNullParameter(r23, "friendList");
        Intrinsics.checkNotNullParameter(r24, "callback");
        IRoom r3 = this.c;
        if (r3 != null) goto L5;
        return;
    L5:
        List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r4 = r23;
        if ((r4 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        if (((IMiddlewareHostSocial.InviteFriendsConfig.Friend) r5.next()).isNormalUser() == false) goto L12;
        boolean r6 = false;
    L17:
        if (r6 == false) goto L22;
        r24.invoke(r23, r3);
        BaseTalkInviteListWidgetContract$View r2 = (BaseTalkInviteListWidgetContract$View) this.b;
        if (r2 == null) goto L33;
        r2.zq(r23, null);
        return;
    L33:
        return;
    L22:
        int r7 = com.bytedance.android.live.liveinteract.linkpanel.util.j.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.j.a.a("panel_friends");
        if (vm2.d.V() == true) goto L25;
    L27:
        int r20 = 0;
    L28:
        ((ObservableSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).invite(r3.getId(), null, null, new JSONArray(SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r4), BaseTalkInviteListWidgetPresenter$inviteFriends$2.INSTANCE), new BaseTalkInviteListWidgetPresenter$inviteFriends$3(this)))).toString(), new JSONArray(SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r4), BaseTalkInviteListWidgetPresenter$inviteFriends$4.INSTANCE), new BaseTalkInviteListWidgetPresenter$inviteFriends$5(this)))).toString(), 0, r22, 0, 0, 0, r20).as(c())).subscribe(new i(this, r23, r24, r3), new j(this));
        return;
    L25:
        if (jc0.a.a() == false) goto L27;
        r20 = AudienceInviteSource.REALTIME_CHORUS.getValue();
    L16:
        r6 = true;
        goto L17
    L8:
        if (r4.isEmpty() == false) goto L10;
        goto L10
    }
}
