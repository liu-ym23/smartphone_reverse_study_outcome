package com.bytedance.android.live.room.widget;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/widget/LandscapeRankInfoWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/live/room/api/rank/IAudienceWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lzg1/n3;", "event", "", "onEvent", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeRankInfoWidget extends MiddlewareRoomRecyclableWidget implements IAudienceWidget, Observer<KVData> {
    public IRoom a;
    public da1.c b;
    public boolean c;
    public boolean d;
    public final CompositeDisposable e;

    public static final class a {
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ LandscapeRankInfoWidget a;

        public b(LandscapeRankInfoWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IRoom r3 = (IRoom) r2;
            LandscapeRankInfoWidget r0 = this.a;
            r0.a = r3;
            r0.wq(r3);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LandscapeRankInfoWidget a;

        public c(LandscapeRankInfoWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            long r0 = SystemClock.uptimeMillis();
            long r2 = r0 - com.bytedance.android.live.room.util.f.a;
            com.bytedance.android.live.room.util.f.a = r0;
            if (r2 <= 500) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L36;
            LandscapeRankInfoWidget r3 = this.a;
            if (r3.d == true) goto L11;
            return;
        L11:
            if (UnLoginFeatureUtils.INSTANCE.disableUserListWhenUnLogin(r3.a) == false) goto L27;
            IMiddlewareUserService r4 = k.f(IMiddlewareUserService.class);
            if (r4 == null) goto L18;
            com.bytedance.android.livesdk.user.e r5 = r4.user();
            if (r5 == null) goto L18;
            if (r5.isLogin() == true) goto L27;
        L18:
            IMiddlewareUserService r7 = k.f(IMiddlewareUserService.class);
            if (r7 == null) goto L37;
            com.bytedance.android.livesdk.user.e r8 = r7.user();
            if (r8 == null) goto L38;
            Context r9 = ((Widget) r3).context;
            l.a r10 = new l.a();
            r10.e = "live_detail";
            r10.f = "click_live_rank";
            Observable r12 = r8.login(r9, new l(r10));
            if (r12 == null) goto L39;
            Observable r13 = r12.compose(r3.getAutoUnbindTransformer());
            if (r13 == null) goto L40;
            r13.subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L27:
            DataCenter r14 = ((Widget) r3).dataCenter;
            if (r14 == null) goto L34;
            IRoom r15 = a0.n(r14);
            if (r15 == null) goto L34;
            ILiveExperienceProxyService r16 = (ILiveExperienceProxyService) k.f(ILiveExperienceProxyService.class);
            if (r16 == null) goto L34;
            r16.showUserDialog(-1, ((Widget) r3).context, ((Widget) r3).dataCenter, r15);
        L34:
            ((Widget) r3).dataCenter.put("cmd_show_landscape_rank_info_dialog", new Object());
            int r17 = com.bytedance.android.live.room.util.a.a;
            com.bytedance.android.live.room.util.a.a(r3.a);
            return;
        L36:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566685;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a263";
    }

    @Override // com.bytedance.android.live.room.api.rank.IAudienceWidget
    public final void ii(List<x71.a> r1) {
    }

    public final void onUnload() {
        da1.c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLiveWatchUserPresenter");
    L5:
        r0.detachView();
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        this.e.clear();
    }

    public LandscapeRankInfoWidget() {
        this.d = true;
        this.e = new CompositeDisposable();
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (isViewValid() == false) goto L32;
        String r0 = null;
        if (r6 == null) goto L7;
        String r1 = r6.getKey();
    L8:
        boolean r2 = true;
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L34;
        if (r6 == null) goto L19;
        r0 = r6.getKey();
    L19:
        if (r0 != null) goto L22;
        return;
    L22:
        if (r0.hashCode() == 146203553) goto L25;
        return;
    L25:
        if (r0.equals("cmd_enable_click_online") == false) goto L33;
        if (r6 == null) goto L30;
        Boolean r7 = (Boolean) r6.getData();
        if (r7 == null) goto L30;
        r2 = r7.booleanValue();
    L30:
        this.d = r2;
        ALogger.i("LiveRoomAudienceWidget", "cmd  enableClickOnline is :  " + this.d);
        return;
    L33:
        return;
    L34:
        return;
    L11:
        if (r1.length() == 0) goto L14;
        r3 = false;
        goto L15
    L7:
        r1 = null;
        goto L8
    }

    public final void onEvent(n3 r3) {
        r r0 = z51.a.e(((Widget) this).dataCenter);
        if (r0 != null) goto L5;
    L7:
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L16;
        if (r3 != null) goto L11;
    L13:
        int r4 = 0;
    L14:
        r1.setVisibility(r4);
        return;
    L11:
        if (r3.a != true) goto L13;
        r4 = 8;
        goto L14
    L16:
        return;
    L5:
        if (r0.isInVrLandscape(((Widget) this).dataCenter) == true) goto L7;
    }

    public final void onInit(Object[] r2) {
        da1.c r3 = new da1.c();
        this.b = r3;
        r3.e = this.c;
    }

    public final void onLoad(Object[] r10) {
        this.a = (IRoom) ((Widget) this).dataCenter.get("data_room");
        Object r12 = ((Widget) this).dataCenter.get("log_enter_live_source");
        String r0 = "";
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        String r13 = (String) r12;
        if (((Widget) this).context == null) goto L86;
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L10;
        this.c = ((Boolean) r14.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    L10:
        da1.c r15 = this.b;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mLiveWatchUserPresenter");
    L13:
        r15.c0(this);
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L16;
        r16.observe("cmd_enable_click_online", this);
    L16:
        r r17 = z51.a.e(((Widget) this).dataCenter);
        if (r17 != null) goto L19;
    L21:
        wq(this.a);
        runWithRoomEntered(new b(this));
        r r18 = z51.a.e(((Widget) this).dataCenter);
        if (r18 != null) goto L24;
    L38:
        View r19 = ((Widget) this).contentView;
        if (r19 == null) goto L41;
        TextView r110 = (TextView) r19.findViewById(2131391026);
    L42:
        if (r110 == null) goto L45;
        r110.setOnClickListener(new c(this));
    L45:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L87;
        IRoomContextService r7 = k.f(IRoomContextService.class);
        if (r7 == null) goto L55;
        o r8 = IRoomContextService.a.a(r7, null, 0, 3);
        if (r8 == null) goto L55;
        n r9 = r8.getTemplateContext();
        if (r9 == null) goto L55;
        z70.b r20 = (z70.b) r9.getValue();
        if (r20 == null) goto L55;
        boolean r22 = r20.c("user_count");
    L56:
        if (r22 == true) goto L87;
        IRoomContextService r23 = k.f(IRoomContextService.class);
        if (r23 == null) goto L64;
        o r2 = IRoomContextService.a.a(r23, null, 0, 3);
        if (r2 == null) goto L64;
        if (r2.H2() != true) goto L64;
        float r3 = 20.0f;
    L65:
        if (r110 == null) goto L87;
        a1.m(r110, s1.f(r3));
    L64:
        r3 = 28.0f;
    L55:
        r22 = false;
    L87:
        String[] r111 = {"money", "fans", "nothing", "room_money"};     // Catch: Exception -> L82
        Pair[] r4 = new Pair[3];     // Catch: Exception -> L82
        IRoom r6 = this.a;     // Catch: Exception -> L82
        if (r6 == null) goto L73;
        IBaseUser r24 = r6.getOwner();     // Catch: Exception -> L82
        if (r24 == null) goto L73;
        String r25 = r24.getIdString();     // Catch: Exception -> L82
        if (r25 == null) goto L73;
    L74:
        r4[0] = TuplesKt.to("anchor_id", r25);     // Catch: Exception -> L82
        IRoom r5 = this.a;     // Catch: Exception -> L82
        if (r5 == null) goto L80;
        String r26 = r5.getIdStr();     // Catch: Exception -> L82
        if (r26 == null) goto L80;
        r0 = r26;
    L80:
        r4[1] = TuplesKt.to("room_id", r0);     // Catch: Exception -> L82
        r4[2] = TuplesKt.to("rank_type", r111[3]);     // Catch: Exception -> L82
        k.n(IHostLog.class).logV3("livesdk_live_room_info", MapsKt.mapOf(r4));     // Catch: Exception -> L82
        return;
    L73:
        r25 = "";
    L82:
        e = move-exception;
        Logger.throwException(e);
        return;
    L41:
        r110 = null;
        goto L42
    L24:
        if (r18.isInVrLandscape(((Widget) this).dataCenter) != true) goto L38;
        View r112 = ((Widget) this).contentView;
        if (r112 == null) goto L38;
        IRoomContextService r27 = k.f(IRoomContextService.class);
        if (r27 == null) goto L36;
        o r28 = IRoomContextService.a.a(r27, null, 0, 3);
        if (r28 == null) goto L36;
        m r29 = r28.A1();
        if (r29 == null) goto L36;
        if (((Boolean) r29.getValue()).booleanValue() != true) goto L36;
        int r30 = 8;
    L37:
        r112.setVisibility(r30);
    L36:
        r30 = 0;
        goto L37
    L19:
        if (r17.isInVrLandscape(((Widget) this).dataCenter) != true) goto L21;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(n3.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.widget.a(new LandscapeRankInfoWidget$initEvents$1(this))), this.e);
        goto L21
    L86:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void wq(IRoom r5) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L11;
        IRoomAuthStatus r0 = r5.getRoomAuthStatus();
        if (r0 == null) goto L11;
        boolean r1 = true;
        if (r0.isEnableUpRightStatsFloatingLayer() != true) goto L11;
    L12:
        this.d = r1;
        da1.c r2 = this.b;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mLiveWatchUserPresenter");
    L15:
        if (r2 == null) goto L28;
        Long r3 = null;
        if ((r5 instanceof Room) == true) goto L19;
        IRoom r4 = null;
    L20:
        Room r6 = (Room) r4;
        if (r6 == null) goto L23;
        RoomViewStats r7 = r6.viewStats;
    L24:
        if (r5 == null) goto L26;
        r3 = Long.valueOf(r5.getRoomId());
    L26:
        r2.k0(r7, r3);
        return;
    L23:
        r7 = null;
        goto L24
    L19:
        r4 = r5;
        goto L20
    L28:
        return;
    L11:
        r1 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.room.api.rank.IAudienceWidget
    public final void sn(boolean r2, long r3, String r5, String r6) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L8;
        TextView r8 = (TextView) r7.findViewById(2131391026);
    L9:
        if (r2 == false) goto L11;
    L19:
        if (r8 == null) goto L21;
        r8.setVisibility(8);
    L21:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L30;
        r4.put("data_member_count_str", r6);
        r4.put("data_room_pcu", Long.valueOf(r3));
        int r9 = com.bytedance.android.live.room.util.b.a;
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        w71.a r0 = z51.a.b(r4);
        if (r0 == null) goto L26;
        r0.updateRoomDynamicMemberCount(r3);
    L26:
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        w71.a r10 = z51.a.b(r4);
        if (r10 == null) goto L31;
        r10.setShareCountText(r6);
        return;
    L31:
        return;
    L30:
        return;
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L19;
        if (r8 == null) goto L15;
        r8.setVisibility(0);
    L15:
        if (r6 == null) goto L21;
        if (r8 == null) goto L18;
        r8.setText(r6);
    L18:
        r3.c(r8, r6, true);
        goto L21
    L8:
        r8 = null;
        goto L9
    }
}
