package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentWidget;
import com.bytedance.android.livesdk.interactivity.medialink.logs.MediaMultiEnterRoomTracer;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorTitleView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLayoutManagerWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAudienceWindowManager;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.j;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.k;
import com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAudienceView;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import y82.m;
import y82.n;
import y82.o;
import zg1.h1;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaMultiLinkAudienceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAudienceView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAudienceWidget extends RoomWidget implements IMediaMultiLinkAudienceView, Observer<KVData>, l {
    public final com.bytedance.android.livesdk.interactivity.medialink.contract.g b;
    public final CompositeDisposable c;
    public com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.c d;
    public hy.e e;
    public int f;
    public MediaMultiLinkAudienceWindowManager g;
    public String h;
    public MediaInteractCommentWidget i;
    public long j;
    public MediaMultiLayoutManagerWidget k;
    public final a l;
    public vlc.d m;

    public static final class a extends hy.f.a {
        public final /* synthetic */ MediaMultiLinkAudienceWidget a;

        public a(MediaMultiLinkAudienceWidget r1) {
            this.a = r1;
        }

        public final void d(int r3, List<AnchorLinkUser> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            if ((!r4.isEmpty()) == false) goto L8;
            CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) r4;
            int r6 = r5.size();
            MediaMultiLinkAudienceWidget r0 = this.a;
            if (r6 <= r0.f) goto L9;
            r0.f = r5.size();
            return;
        L9:
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566917;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final void onCreate() {
        MediaMultiEnterRoomTracer.MultiLoadSource r0 = MediaMultiEnterRoomTracer.a;
        MediaMultiEnterRoomTracer.c = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "multiLinkLoaded source=" + MediaMultiEnterRoomTracer.a);
        MediaMultiEnterRoomTracer.k = false;
        if (((Widget) this).widgetCallback != null) goto L5;
        return;
    L5:
        super.onCreate();
        StringBuilder r2 = new StringBuilder("MultiLinkAudienceWidget onCreate channelId:");
        com.bytedance.android.livesdk.interactivity.medialink.contract.g r3 = this.b;
        if (r3 == null) goto L8;
        long r6 = r3.a;
    L9:
        r2.append(r6);
        r2.append(" sei:");
        r2.append(this.h);
        ALogger.e("MediaLinkTracer", r2.toString());
        Pair r4 = com.bytedance.live.datacontext.d.a(MediaMultiLinkAudienceWidget$onCreate$pairs$1.INSTANCE);
        ((MediaMultiAnchorLinkContext) r4.getFirst()).getCommonService().d(this);
        MediaMultiAnchorLinkContext r5 = (MediaMultiAnchorLinkContext) r4.getFirst();
        com.bytedance.live.datacontext.b.a((DataContext) r4.getFirst(), MediaMultiAnchorLinkContext.class);
        MediaMultiAnchorLinkContext r7 = (MediaMultiAnchorLinkContext) r4.getFirst();
        com.bytedance.android.livesdk.interactivity.medialink.contract.g r8 = this.b;
        if (r8 == null) goto L12;
        long r9 = r8.a;
    L13:
        r7.setChannelId(r9);
        this.c.add((Disposable) r4.getSecond());
        com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.c r10 = new com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.c((MediaMultiAnchorLinkContext) r4.getFirst());
        this.d = r10;
        r10.g0(this);
        vlc.d r11 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.m = r11;
        if (r11 == null) goto L16;
        r11.addMessageListener(MessageType.LINKER.getIntType(), this);
    L16:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r13 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        m r14 = null;
        if (r13 == null) goto L19;
        hy.e r15 = r13.Np();
    L20:
        this.e = r15;
        if (r15 == null) goto L23;
        r15.i(this.l);
    L23:
        ((Widget) this).dataCenter.observe("data_pk_renderview_width", this);
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == false) goto L26;
    L46:
        this.g = new MediaMultiLinkAudienceWindowManager((FrameLayout) ((Widget) this).contentView.findViewById(2131393289), ((RoomWidget) this).a, ((Widget) this).dataCenter, this.e, (MediaMultiAnchorLinkContext) r4.getFirst(), this);
        MediaMultiAnchorLinkContext r16 = (MediaMultiAnchorLinkContext) r4.getFirst();
        MediaMultiLinkAudienceWindowManager r17 = this.g;
        if (r17 == null) goto L57;
        enableSubWidgetManager();
        MediaMultiLayoutManagerWidget r18 = new MediaMultiLayoutManagerWidget(r17, null);
        this.k = r18;
        RecyclableWidgetManager r19 = ((Widget) this).subWidgetManager;
        if ((r19 instanceof RecyclableWidgetManager) == true) goto L52;
        RecyclableWidgetManager r20 = null;
    L53:
        RecyclableWidgetManager r21 = r20;
        if (r21 == null) goto L56;
        r21.h = true;
    L56:
        r19.load(r18);
        r16.getLayoutService().d(this.k);
        goto L57
    L52:
        r20 = r19;
    L57:
        MediaMultiLinkAudienceWindowManager r23 = this.g;
        if (r23 == null) goto L85;
        MediaMultiEnterRoomTracer.i = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "windowManagerStart source=" + MediaMultiEnterRoomTracer.a);
        MediaMultiEnterRoomTracer.g = 0;
        MediaMultiEnterRoomTracer.h = 0;
        ALogger.e("ttlive_anchor_link_wm", "start");
        r23.z.observe("cmd_gift_dialog_switch", r23.w);
        r23.z.observe("data_video_size_pair", r23.w);
        boolean r24 = r23.isPortrait();
        r23.q = r24;
        Context r25 = r23.x.getContext();
        LiveMode r26 = (LiveMode) r23.z.get("data_live_mode");
        if (r26 != null) goto L62;
        r26 = LiveMode.UNDEFINED;
    L62:
        n r27 = new n(r25, r26, r23.z);
        r23.t = r27;
        r27.b(r24);
        n r28 = r23.t;
        if (r28 == null) goto L65;
        r28.c = r23;
    L65:
        if (r28 == null) goto L67;
        r14 = r28.b;
    L67:
        r23.e = r14;
        r23.h = (Room) r23.z.get("data_room", new Room());
        hy.e r29 = r23.A;
        if (r29 == null) goto L70;
        r29.i(r23);
    L70:
        r23.g.add(xs2.b.a().b(h1.class).subscribe(new j(r23)));
        r23.z.observeForever("DATA_IS_HIDE_INTERACTION", r23);
        MediaMultiAnchorTitleView r30 = new MediaMultiAnchorTitleView(r23.x.getContext());
        r23.f = r30;
        r30.setState(r23.v);
        Object r31 = r23.z.get("data_first_frame_sei", BuildConfig.FLAVOR);
        if ((r31 instanceof String) == false) goto L75;
        String r33 = (String) r31;
        if (TextUtils.isEmpty(r33) == true) goto L75;
        MediaMultiEnterRoomTracer.l = true;
        MediaMultiLinkAudienceWindowManager.r(r23, r33, false, true, 2);
    L75:
        RoomContext r34 = r23.y;
        if (r34 == null) goto L84;
        com.bytedance.live.datacontext.m r35 = r34.getCleanMode();
        if (r35 == null) goto L84;
        Observable r36 = r35.a();
        if (r36 == null) goto L84;
        Disposable r37 = r36.subscribe(new k(r23));
        if (r37 == null) goto L84;
        RxUtilKt.c(r37, r23.g);
    L84:
        MediaMultiEnterRoomTracer.j = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "windowManagerDone source=" + MediaMultiEnterRoomTracer.a);
        MediaMultiEnterRoomTracer.a();
    L85:
        final MediaMultiLinkAudienceWindowManager r38 = this.g;
        if (r38 != null) goto L88;
    L91:
        hy.e r1 = this.e;
        if (r1 == null) goto L100;
        List r39 = r1.getOnlineUserList();
        if (r39 == null) goto L100;
        if (r39.isEmpty() != true) goto L100;
        MediaMultiEnterRoomTracer.e = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "linkListCall source=" + MediaMultiEnterRoomTracer.a);
        hy.e r40 = this.e;
        if (r40 == null) goto L101;
        r40.b(2, "multi_anchor_link_widget_create");
    L101:
        this.j = System.currentTimeMillis();
        DataCenter r41 = ((Widget) this).dataCenter;
        if (r41 == null) goto L104;
        r41.put("cmd_update_sticker_visible", Boolean.FALSE);
    L104:
        MediaMultiEnterRoomTracer.d = System.currentTimeMillis();
        MediaMultiEnterRoomTracer.a();
        ALogger.w("MediaLinkEnterRoomTracer", "multiLinkCreated source=" + MediaMultiEnterRoomTracer.a);
        return;
    L100:
        long r43 = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "linkListSkip source=" + MediaMultiEnterRoomTracer.a);
        MediaMultiEnterRoomTracer.e = r43;
        MediaMultiEnterRoomTracer.f = r43;
        MediaMultiEnterRoomTracer.a();
        goto L101
    L88:
        if (TextUtils.isEmpty(this.h) == true) goto L90;
        MediaMultiLinkAudienceWindowManager.r(r38, this.h, true, false, 4);
    L90:
        this.i = new MediaInteractCommentWidget(new MediaMultiLinkAudienceWidget$onCreate$1$1(r38));
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(this.i);
        goto L91
    L26:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L46;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L46;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L46;
        View r44 = ((Widget) this).contentView;
        UIUtils.updateLayoutMargin(r44, -3, -StatusBarUtil.getStatusBarHeight(r44.getContext()), -3, -3);
        FrameLayout r45 = (FrameLayout) ((Widget) this).contentView.findViewById(2131393289);
        if (r45 == null) goto L34;
        r45.setClipChildren(false);
    L34:
        View r46 = ((Widget) this).contentView;
        if ((r46 instanceof ViewGroup) == true) goto L37;
        r46 = null;
    L37:
        ViewGroup r47 = (ViewGroup) r46;
        if (r47 == null) goto L40;
        r47.setClipChildren(false);
    L40:
        ViewParent r48 = ((Widget) this).contentView.getParent();
        if ((r48 instanceof ViewGroup) == true) goto L43;
        r48 = null;
    L43:
        ViewGroup r49 = (ViewGroup) r48;
        if (r49 == null) goto L46;
        r49.setClipChildren(false);
        goto L46
    L19:
        r15 = null;
        goto L20
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        ALogger.w("MediaLinkTracer", "MultiLinkAudienceWidget onDestroy");
        MediaMultiEnterRoomTracer.MultiLoadSource r0 = MediaMultiEnterRoomTracer.a;
        ALogger.w("MediaLinkEnterRoomTracer", "reset source=" + MediaMultiEnterRoomTracer.a);
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r1 = null;
        MediaMultiEnterRoomTracer.a = null;
        MediaMultiEnterRoomTracer.b = 0;
        MediaMultiEnterRoomTracer.c = 0;
        MediaMultiEnterRoomTracer.d = 0;
        MediaMultiEnterRoomTracer.e = 0;
        MediaMultiEnterRoomTracer.f = 0;
        MediaMultiEnterRoomTracer.g = 0;
        MediaMultiEnterRoomTracer.h = 0;
        MediaMultiEnterRoomTracer.i = 0;
        MediaMultiEnterRoomTracer.j = 0;
        MediaMultiEnterRoomTracer.k = false;
        MediaMultiEnterRoomTracer.l = false;
        this.c.clear();
        com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.c r4 = this.d;
        if (r4 == null) goto L5;
        r4.detachView();
    L5:
        com.bytedance.android.livesdk.interactivity.medialink.contract.g r5 = this.b;
        if (r5 == null) goto L8;
        long r6 = r5.a;
    L9:
        long r7 = this.j;
        int r8 = w82.b.a;
        LinkedHashMap r9 = new LinkedHashMap();
        long r10 = (System.currentTimeMillis() - r7) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        r9.put("from_media", "1");
        r9.put("channel_id", String.valueOf(r6));
        r9.put("watch_connection_duration", String.valueOf(r10));
        u.l().sendLog("livesdk_connection_watch_duration", r9, new Object[]{Room.class});
        hy.e r11 = this.e;
        if (r11 == null) goto L12;
        r11.j();
    L12:
        MediaMultiLinkAudienceWindowManager r13 = this.g;
        if (r13 == null) goto L27;
        ALogger.e("ttlive_anchor_link_wm", "end switchToPK=false");
        CompositeDisposable r14 = r13.g;
        if (r14 == null) goto L17;
        r14.dispose();
    L17:
        DataCenter r15 = r13.z;
        if (r15 == null) goto L20;
        r15.put("data_first_frame_sei", BuildConfig.FLAVOR);
    L20:
        DataCenter r16 = r13.z;
        if (r16 == null) goto L23;
        r16.removeObserver(r13);
    L23:
        hy.e r17 = r13.A;
        if (r17 == null) goto L26;
        r17.h(r13);
    L26:
        r13.d.clear();
        r13.x.removeAllViews();
        r13.r.clear();
        u1 r18 = new u1();
        r18.f = 2;
        r13.z.put("cmd_multi_state_change", r18);
        r13.z.removeObserver("cmd_gift_dialog_switch", r13.w);
        r13.z.removeObserver("data_video_size_pair", r13.w);
    L27:
        x82.c.w2.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r19 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if ((r19 instanceof x82.c) == false) goto L31;
        r1 = r19;
    L31:
        x82.c r2 = (x82.c) r1;
        if (r2 == null) goto L34;
        long r20 = r2.getChannelId();
    L36:
        if (r20 != 0) goto L40;
        hy.e r3 = this.e;
        if (r3 == null) goto L40;
        r3.clear(false);
    L40:
        hy.e r21 = this.e;
        if (r21 == null) goto L43;
        r21.h(this.l);
    L43:
        hy.e r23 = this.e;
        if (r23 == null) goto L46;
        r23.clear(false);
    L46:
        DataCenter r24 = ((Widget) this).dataCenter;
        if (r24 == null) goto L49;
        r24.put("cmd_update_sticker_visible", Boolean.TRUE);
    L49:
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L53;
        r25.removeObserver(this);
        return;
    L53:
        return;
    L34:
        r20 = 0;
        goto L36
    L8:
        r6 = 0;
        goto L9
    }

    public MediaMultiLinkAudienceWidget(x32.b r3) {
        x32.d r0 = null;
        if (r3 == null) goto L5;
        x32.d r4 = r3.W0();
    L7:
        if ((r4 instanceof com.bytedance.android.livesdk.interactivity.medialink.contract.g) == false) goto L10;
        r0 = r4;
    L10:
        this.b = (com.bytedance.android.livesdk.interactivity.medialink.contract.g) r0;
        this.c = new CompositeDisposable();
        this.f = 1;
        this.h = BuildConfig.FLAVOR;
        this.l = new a(this);
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L13;
        String r5 = r4.getKey();
        if (r5.hashCode() == 1797384049) goto L8;
        return;
    L8:
        if (r5.equals("data_pk_renderview_width") == false) goto L14;
        MediaMultiLinkAudienceWindowManager r6 = this.g;
        if (r6 == null) goto L15;
        r6.onSeiUpdated(r6.n);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        MediaMultiLinkAudienceWindowManager r0 = this.g;
        if (r0 == null) goto L10;
        if (r2 == null) goto L6;
        int r3 = r2.orientation;
    L7:
        r0.l = r3;
        boolean r4 = r0.isPortrait();
        r0.q = r4;
        n r1 = r0.t;
        if (r1 == null) goto L10;
        r1.b(r4);
        goto L10
    L6:
        r3 = -1;
    L10:
        MediaMultiLinkAudienceWindowManager r5 = this.g;
        if (r5 == null) goto L18;
        n r6 = r5.t;
        if (r6 == null) goto L19;
        m r7 = r6.a();
        r6.b = r7;
        o r8 = r6.c;
        if (r8 == null) goto L20;
        r8.i(r7);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void onMessage(tlc.d r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if ((r6 instanceof if) == false) goto L28;
        if r7 = (if) r6;
        if (r7.getMType() != 7) goto L29;
        hy.e r0 = this.e;
        if (r0 == null) goto L30;
        LinkerLeaveContent r1 = r7.mLeave;
        Integer r2 = null;
        if (r1 == null) goto L13;
        String r3 = r1.getUserIdStr();
    L14:
        AnchorLinkUser r4 = r0.getGuestInfo(r3, BuildConfig.FLAVOR);
        if (r4 == null) goto L31;
        AnchorLinkUser r5 = jm2.a.d(r4);
        if (r5 == null) goto L27;
        AnchorLinkUser r8 = r5;
        LinkerLeaveContent r9 = r7.mLeave;
        Intrinsics.checkNotNullParameter(r8, "leaveAnchor");
        IBaseUser r10 = r8.getUser();
        if (r10 == null) goto L32;
        if (r9 == null) goto L23;
        r2 = Integer.valueOf(r9.getLeaveSource());
    L23:
        if (r2.intValue() == LinkerLeaveContent.LeaveSource.AnchorLeaveSourceOrganizerKickOut.ordinal()) goto L34;
        f2.c(s1.C(2131920253, new Object[]{r10.getNickName()}), 0);
        return;
    L34:
        return;
    L32:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L31:
        return;
    L13:
        r3 = null;
        goto L14
    L30:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAudienceView
    public final void R6(String r5, boolean r6) {
        StringBuilder r0 = new StringBuilder("onAnchorStateChanged ");
        r0.append(r5);
        r0.append(' ');
        if (r6 == false) goto L5;
        String r1 = "foreground";
    L6:
        r0.append(r1);
        ALogger.w("MediaLinkTracer", r0.toString());
        MediaMultiLinkAudienceWindowManager r2 = this.g;
        if (r2 == null) goto L14;
        Iterator<MediaMultiAnchorWindowV2> r3 = r2.d.iterator();
    L10:
        if (r3.hasNext() == false) goto L20;
        MediaMultiAnchorWindowV2 r4 = r3.next();
        if (TextUtils.equals(r4.getInteractId(), r5) == false) goto L10;
        r4.r(r6, r2.d.size());
        goto L10
    L20:
        return;
    L14:
        return;
    L5:
        r1 = "background";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAudienceView
    public final void pA(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "reqSrc");
        ALogger.w("MediaLinkTracer", "MultiAudienceLinkWidget call finishInernal reqSrc=" + r3 + ", clearAfterSuccess=" + r4);
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r5 == null) goto L6;
        r5.K4(256);
        return;
    }
}
