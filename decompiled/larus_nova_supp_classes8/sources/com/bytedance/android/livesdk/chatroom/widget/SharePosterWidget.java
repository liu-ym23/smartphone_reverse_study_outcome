package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livehostapi.business.depend.share.ShareOutsideDialogParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.config.x10;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShareResource;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.MatchRoomInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/SharePosterWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SharePosterWidget extends RoomRecyclableWidget {
    public final CompositeDisposable a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SharePosterWidget a;

        public a(SharePosterWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            b30.n r14 = (b30.n) r13;
            SharePosterWidget r0 = this.a;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r1 = null;
            int r2 = 0;
            if (r14 == null) goto L19;
            r0.getClass();
            com.bytedance.android.livesdk.chatroom.ssposter.util.c.n.getClass();
            com.bytedance.android.livesdk.chatroom.ssposter.util.c r4 = com.bytedance.android.livesdk.chatroom.ssposter.util.c.m;
            if (r4 == null) goto L19;
            List r5 = r14.b;
            if (r5 == null) goto L19;
            ArrayList r6 = new ArrayList();
            Iterator<T> r7 = r5.iterator();
        L10:
            if (r7.hasNext() == false) goto L14;
            String r8 = (String) r7.next();
            if (r8 == null) goto L10;
            ImageModel r9 = new ImageModel();
            r9.setUrls(CollectionsKt.arrayListOf(new String[]{r8}));
            r9.setUri(r8);
            r6.add(r9);
            goto L10
        L14:
            Intrinsics.checkNotNullParameter(r6, "list");
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r11 = r6.iterator();
        L16:
            if (r11.hasNext() == false) goto L18;
            r10.add(new com.bytedance.android.livesdk.chatroom.ssposter.util.e((ImageModel) r11.next(), null));
            goto L16
        L18:
            r4.m(CollectionsKt.toMutableList(r10));
            r4.i = r14.a;
        L19:
            RoomContext r12 = r0.getDataContext();
            if (r12 == null) goto L127;
            com.bytedance.live.datacontext.m r15 = r12.getRoom();
            if (r15 == null) goto L134;
            Room r16 = (Room) r15.getValue();
            if (r16 == null) goto L135;
            ShareParams.Builder r17 = ShareParams.buildUponRoom(r16);
            if (r14 == null) goto L28;
            String r18 = r14.c;
        L29:
            if (r14 == null) goto L31;
            String r19 = r14.d;
        L32:
            int r20 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.o.a;
            Intrinsics.checkNotNullParameter(r16, "room");
            Intrinsics.checkNotNullParameter(r17, "builder");
            ShareOutsideDialogParam r21 = new ShareOutsideDialogParam();
            EpisodeExtraInfo r22 = r16.getEpisodeExtra2();
            if (r22 == null) goto L35;
            IMatchRoomInfo r23 = r22.getMatchRoomInfo();
        L37:
            if ((r23 instanceof MatchRoomInfo) == true) goto L39;
            r23 = null;
        L39:
            MatchRoomInfo r24 = (MatchRoomInfo) r23;
            if (r24 == null) goto L46;
            IMatchRoomImInfo r25 = r24.getImInfo();
            if (r25 == null) goto L46;
            py.k r26 = r25.getIcon();
            if (r26 == null) goto L46;
            ImageModel r27 = (ImageModel) com.bytedance.android.live.base.model.m.b(r26, ImageModel.class);
        L47:
            r21.setShareCardIcon(r27);
            EpisodeExtraInfo r28 = r16.getEpisodeExtra2();
            if (r28 == null) goto L50;
            IMatchRoomInfo r29 = r28.getMatchRoomInfo();
        L52:
            if ((r29 instanceof MatchRoomInfo) == true) goto L54;
            r29 = null;
        L54:
            MatchRoomInfo r30 = (MatchRoomInfo) r29;
            if (r30 == null) goto L59;
            IMatchRoomImInfo r31 = r30.getImInfo();
            if (r31 == null) goto L59;
            String r32 = r31.getTitle();
        L60:
            r21.setShareCardTitle(r32);
            EpisodeExtraInfo r33 = r16.getEpisodeExtra2();
            if (r33 == null) goto L69;
            IMatchRoomInfo r34 = r33.getMatchRoomInfo();
            if (r34 == null) goto L69;
            List r35 = r34.backgroundImageUrlList();
            if (r35 == null) goto L69;
            py.k r36 = (py.k) CollectionsKt.firstOrNull(r35);
            if (r36 == null) goto L69;
            ImageModel r37 = (ImageModel) com.bytedance.android.live.base.model.m.b(r36, ImageModel.class);
        L70:
            r21.setPosterShareBackground(r37);
            ShareResource r38 = r16.shareResource;
            if (r38 == null) goto L73;
            ImageModel r39 = r38.getToastBackground();
        L74:
            r21.setToastBackground(r39);
            Unit r40 = Unit.INSTANCE;
            r17.setCustomCommandDialogParam(r21);
            HashMap r41 = new HashMap();
            Map r42 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
            if (r42 == null) goto L77;
            r41.putAll(r42);
        L77:
            Map r43 = com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap();
            if (r43 == null) goto L80;
            r41.putAll(r43);
        L80:
            int r44 = ju2.f.M;
            r41.putAll(ju2.f.a.a(r16).b());
            r41.put("room_type", "live");
            com.bytedance.android.livesdk.chatroom.ssposter.util.c.n.getClass();
            com.bytedance.android.livesdk.chatroom.ssposter.util.c r45 = com.bytedance.android.livesdk.chatroom.ssposter.util.c.m;
            if (r45 == null) goto L83;
            r45.n();
        L83:
            com.bytedance.android.livesdk.chatroom.ssposter.util.c r46 = com.bytedance.android.livesdk.chatroom.ssposter.util.c.m;
            if (r46 == null) goto L86;
            r2 = r46.getPicNum();
        L86:
            if (r2 <= 0) goto L99;
            if (r18 == null) goto L89;
            Map r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.o.a(r18);
        L90:
            HashMap r47 = new HashMap();
            r47.put("enable_replay", "1");
            if (r3 == null) goto L93;
            r41.putAll(r3);
            r47.putAll(r3);
        L93:
            r17.setExtraParams(r47);
            HashMap r48 = new HashMap();
            if (r19 == null) goto L98;
            Map r110 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.o.a(r19);
            if (r110 == null) goto L98;
            r48.putAll(r110);
        L98:
            r17.setActivityInfo(r48);
            goto L99
        L89:
            r3 = null;
        L99:
            r17.setLogExtraParams(r41);
            r17.getExtras().putBoolean("is_match_room", true);
            r17.getExtras().putInt("panel_type", 3);
            Bundle r111 = r17.getExtras();
            ShareResource r49 = r16.shareResource;
            if (r49 == null) goto L102;
            String r50 = r49.getUgShareInfo();
        L103:
            r111.putString("downgrade_share_info", r50);
            com.bytedance.android.livesdk.user.f r51 = (com.bytedance.android.livesdk.user.f) ((Widget) r0).dataCenter.get("data_user_center");
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r112 = y3.f(((Widget) r0).dataCenter).t(ToolbarButton.SHARE);
            if ((r112 instanceof e5) == true) goto L106;
            r112 = null;
        L106:
            e5 r113 = (e5) r112;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r52 = y3.m(((Widget) r0).dataCenter);
            if ((r52 instanceof x3) == true) goto L109;
            r52 = null;
        L109:
            x3 r53 = (x3) r52;
            if (r53 == null) goto L112;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r54 = r53.t(ToolbarButton.SHARE);
        L114:
            if ((r54 instanceof e5) == false) goto L117;
            r1 = r54;
        L117:
            e5 r55 = (e5) r1;
            if (r113 == null) goto L120;
            r113.h(r17);
            return;
        L120:
            if (r55 == null) goto L122;
            r55.h(r17);
            return;
        L122:
            Context r56 = r0.getContext();
            FragmentActivity r57 = ((Widget) r0).context;
            if (r57 == null) goto L126;
            new e5(r56, r57, r51, r0.getDataContext(), ((Widget) r0).dataCenter).h(r17);
            return;
        L126:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L112:
            r54 = null;
            goto L114
        L102:
            r50 = null;
            goto L103
        L73:
            r39 = null;
        L69:
            r37 = null;
        L59:
            r32 = null;
            goto L60
        L50:
            r29 = null;
        L46:
            r27 = null;
            goto L47
        L35:
            r23 = null;
            goto L37
        L31:
            r19 = null;
            goto L32
        L28:
            r18 = null;
            goto L29
        L135:
            return;
        L134:
            return;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.a.clear();
        if (x10.a.getValue().booleanValue() == false) goto L6;
        com.bytedance.android.livesdk.chatroom.ssposter.util.c.n.getClass();
        com.bytedance.android.livesdk.chatroom.ssposter.util.c.m = null;
        return;
    }

    public SharePosterWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onLoad(Object[] r6) {
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r7 == null) goto L22;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L22;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L22;
        long r0 = r9.id;
        com.bytedance.android.livesdk.chatroom.ssposter.util.c.n.getClass();
        com.bytedance.android.livesdk.chatroom.ssposter.util.c r2 = com.bytedance.android.livesdk.chatroom.ssposter.util.c.m;
        if (r2 == null) goto L11;
        long r3 = r2.h;
    L13:
        if (r0 == r3) goto L22;
        com.bytedance.android.livesdk.chatroom.ssposter.util.c r1 = new com.bytedance.android.livesdk.chatroom.ssposter.util.c();
        com.bytedance.android.livesdk.chatroom.ssposter.util.c.m = r1;
        r1.h = r9.id;
        User r10 = r9.getOwner();
        if (r10 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.ssposter.util.c r4 = com.bytedance.android.livesdk.chatroom.ssposter.util.c.m;
        if (r4 == null) goto L22;
        ImageModel r5 = r10.getAvatarThumb();
        if ((r5 instanceof ImageModel) == true) goto L21;
        r5 = null;
    L21:
        r4.j = r5;
        r4.k = r10.getNickName();
        r4.l = r10.getDisplayId();
        goto L22
    L11:
        r3 = -1;
    L22:
        Disposable r11 = xs2.b.a().b(b30.n.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.a.add(r11);
    }
}
