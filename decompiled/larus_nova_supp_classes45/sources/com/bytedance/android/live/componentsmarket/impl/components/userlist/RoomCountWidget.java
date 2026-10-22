package com.bytedance.android.live.componentsmarket.impl.components.userlist;

import am2.x;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.n1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import yt0.c;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.MatchRoomCount, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/userlist/RoomCountWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lo70/a;", "Lcom/bytedance/android/live/componentsmarket/impl/components/userlist/IWatchUserListView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCountWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a, o70.a, IWatchUserListView, Observer<KVData> {
    public Room a;
    public com.bytedance.android.live.componentsmarket.impl.components.userlist.b b;
    public ViewGroup c;
    public TextView d;
    public View e;
    public final CompositeDisposable f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RoomCountWidget a;

        public a(RoomCountWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            if (this.a.xq() == true) goto L5;
            return;
        L5:
            if (n1.a() == false) goto L42;
            Room r13 = this.a.a;
            if (r13 != null) goto L9;
            return;
        L9:
            RoomAuthStatus r14 = r13.getRoomAuthStatus();
            if (r14 == null) goto L12;
            boolean r15 = r14.isEnableUpRightStatsFloatingLayer();
        L13:
            if (r15 == false) goto L43;
            RoomCountWidget r16 = this.a;
            r16.getClass();
            long r6 = System.currentTimeMillis();
            HashMap r1 = new HashMap();
            IKtvService r2 = k.f(IKtvService.class);
            if (r2 != null) goto L17;
        L19:
            u.l().sendLog("livesdk_rd_live_user_rank_click_enter", r1, new Object[]{new x(), Room.class});
            DataCenter r3 = ((Widget) r16).dataCenter;
            if (r3 == null) goto L24;
            Integer r4 = (Integer) r3.get("data_member_count", 0);
            if (r4 == null) goto L24;
            int r5 = r4.intValue();
        L25:
            av0.a r7 = c.j();
            if (r7 == null) goto L28;
            av0.a.a.a(r7, ((Widget) r16).context, -1, r16.a, String.valueOf(r5), r6, RoomCountWidget$showUserDialog$1.INSTANCE);
        L28:
            HashMap r8 = new HashMap();
            r8.put("event_belong", GamePromoteDataContext.LIVE);
            r8.put("event_type", "click");
            r8.put("event_page", "live_detail");
            r8.put("event_module", "top_tab");
            Room r9 = r16.a;
            String r11 = "";
            if (r9 == null) goto L32;
            String r17 = r9.getIdStr();
            if (r17 == null) goto L32;
        L33:
            r8.put("room_id", r17);
            Room r18 = r16.a;
            if (r18 == null) goto L39;
            String r19 = r18.getOwnerUserIdString();
            if (r19 == null) goto L39;
            r11 = r19;
        L39:
            r8.put("anchor_id", r11);
            u.l().sendLog("livesdk_audience_list_click_v2", r8, new Object[]{new x()});
            return;
        L32:
            r17 = "";
        L24:
            r5 = 0;
            goto L25
        L17:
            if (r2.isInKtvState(8) == false) goto L19;
            r1.put("live_type", "voice_live");
            r1.put("function_type", "ktv");
            goto L19
        L43:
            return;
        L12:
            r15 = true;
            goto L13
        }
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final int getLayoutId() {
        return 2131565340;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.userlist.IWatchUserListView
    public final void ka() {
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.userlist.IWatchUserListView
    public final void v9() {
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L6;
        return CollectionsKt.listOf(new Class[]{s.class, bh1.b.class});
    L6:
        return CollectionsKt.listOf(bh1.b.class);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.live.componentsmarket.impl.components.userlist.b r0 = this.b;
        if (r0 == null) goto L5;
        r0.detachView();
    L5:
        ((Widget) this).dataCenter.removeObserver("cmd_enable_click_online", this);
        this.f.clear();
    }

    public final void wq() {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L20;
        String r2 = "";
        if (xq() == false) goto L13;
        RoomViewStats r1 = z.o(((Widget) this).dataCenter).viewStats;
        if (r1 == null) goto L12;
        String r3 = r1.getDisplayMiddle();
        if (r3 == null) goto L12;
        r2 = r3;
    L12:
        r2 = r2.concat("人在线  按钮");
    L19:
        r3.a(r0, r2);
        goto L20
    L13:
        RoomViewStats r4 = z.o(((Widget) this).dataCenter).viewStats;
        if (r4 == null) goto L19;
        String r5 = r4.getDisplayMiddle();
        if (r5 == null) goto L19;
        r2 = r5;
    L20:
        TextView r6 = this.d;
        if (r6 == null) goto L23;
        r6.setImportantForAccessibility(4);
    L23:
        View r7 = this.e;
        if (r7 == null) goto L27;
        r7.setImportantForAccessibility(4);
        return;
    }

    public final boolean xq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L13;
        Room r1 = z.o(r0);
        if (r1 == null) goto L13;
        RoomPlatformComponentsData r2 = r1.roomPlatformComponentsData;
        if (r2 == null) goto L13;
        RoomViewStats r3 = r2.getRoomCount();
        if (r3 == null) goto L13;
        if (r3.isPCU() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public RoomCountWidget() {
        this.f = new CompositeDisposable();
    }

    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return !z.m(((Widget) this).dataCenter, true);
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L7:
        if (Intrinsics.areEqual(r0, "cmd_enable_click_online") == false) goto L18;
        Room r1 = this.a;
        if (r1 == null) goto L19;
        RoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 != null) goto L13;
        return;
    L13:
        if ((!Intrinsics.areEqual((Boolean) r5.getData(), Boolean.FALSE)) == false) goto L15;
        long r3 = 1;
    L16:
        r2.upRightStatsFloatingLayer = r3;
        return;
    L15:
        r3 = 2;
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r0 = null;
        goto L7
    }

    @Override // o70.a
    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof bh1.b) == false) goto L8;
        int r4 = ((bh1.b) r3).a;
        ViewGroup r0 = this.c;
        if (r0 == null) goto L18;
        r0.setTranslationY(r4);
        return;
    L18:
        return;
    L8:
        if ((r3 instanceof s) == false) goto L20;
        int r1 = 0;
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L21;
        View r2 = ((Widget) this).contentView;
        if (r2 != null) goto L14;
        return;
    L14:
        if (((s) r3).a == false) goto L16;
        r1 = 4;
    L16:
        r2.setVisibility(r1);
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r3) {
        this.b = new com.bytedance.android.live.componentsmarket.impl.components.userlist.b();
        z.f(((Widget) this).dataCenter);
        View r4 = ((Widget) this).contentView;
        View r0 = null;
        if (r4 == null) goto L5;
        ViewGroup r5 = (ViewGroup) r4.findViewById(2131389515);
    L6:
        this.c = r5;
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L9;
        TextView r7 = (TextView) r6.findViewById(2131389655);
    L10:
        this.d = r7;
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L13;
        r0 = r8.findViewById(2131389654);
    L13:
        this.e = r0;
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r4) {
        this.a = z.o(((Widget) this).dataCenter);
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L5;
        r5.setOnClickListener(new a(this));
    L5:
        com.bytedance.android.live.componentsmarket.impl.components.userlist.b r6 = this.b;
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "iWatchUserListView");
        r6.c0(this);
        d r0 = ((n) r6).d;
        if (r0 == null) goto L10;
        r0.addMessageListener(MessageType.USER_SEQ.getIntType(), r6);
        ((n) r6).d.addMessageListener(MessageType.ROOM_RANK.getWsMethod(), r6);
        ((n) r6).d.addMessageListener(MessageType.ROOM_STATS.getWsMethod(), r6);
    L10:
        DataCenter r7 = ((Widget) this).dataCenter;
        int r1 = 0;
        if (r7 == null) goto L26;
        Room r8 = z.o(r7);
        if (r8 == null) goto L26;
        RoomPlatformComponentsData r9 = r8.roomPlatformComponentsData;
        if (r9 == null) goto L26;
        RoomViewStats r11 = r9.getRoomCount();
        if (r11 == null) goto L26;
        TextView r2 = this.d;
        if (r2 == null) goto L21;
        r2.setText(r11.getDisplayMiddle());
    L21:
        ALogger.d("RoomCountWidget", "it.displayMiddle = " + r11.getDisplayMiddle());
        View r3 = ((Widget) this).contentView;
        if (r11.isHidden() == false) goto L24;
        int r12 = 4;
    L25:
        r3.setVisibility(r12);
        goto L26
    L24:
        r12 = 0;
    L26:
        View r13 = this.e;
        if (r13 != null) goto L29;
    L33:
        wq();
        ((Widget) this).dataCenter.observe("cmd_enable_click_online", this);
        yq(bh1.a.class, new RoomCountWidget$initEvent$1(this));
        yq(bh1.b.class, new RoomCountWidget$initEvent$2(this));
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r14 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l = ((Widget) this).containerView;
        return;
    L29:
        if (xq() == true) goto L32;
        r1 = 8;
    L32:
        r13.setVisibility(r1);
        goto L33
    }

    public final <T> void yq(Class<T> r2, Function1<? super T, Unit> r3) {
        RxUtilKt.c(xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r3)), this.f);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.userlist.IWatchUserListView
    public final void e3(boolean r2, String r3, String r4, int r5) {
        TextView r0 = this.d;
        if (r0 == null) goto L5;
        r0.setText(r3);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L14;
        Room r6 = z.o(r1);
        if (r6 == null) goto L14;
        RoomPlatformComponentsData r7 = r6.roomPlatformComponentsData;
        if (r7 == null) goto L14;
        RoomViewStats r8 = r7.getRoomCount();
        if (r8 == null) goto L14;
        r8.setDisplayMiddle(r3);
        r8.setDisplayLong(r4);
        r8.setDisplayType(r5);
        r8.setHidden(r2);
    L14:
        View r9 = ((Widget) this).contentView;
        if (r2 == false) goto L17;
        int r11 = 4;
    L18:
        r9.setVisibility(r11);
        View r12 = this.e;
        if (r12 == null) goto L26;
        if (xq() == false) goto L23;
        int r13 = 0;
    L24:
        r12.setVisibility(r13);
        goto L26
    L23:
        r13 = 8;
    L26:
        if (VrUtils.u(((Widget) this).dataCenter, false) == false) goto L30;
        View r14 = ((Widget) this).contentView;
        if (r14 == null) goto L30;
        r14.setVisibility(4);
    L30:
        wq();
        return;
    L17:
        r11 = 0;
        goto L18
    }
}
