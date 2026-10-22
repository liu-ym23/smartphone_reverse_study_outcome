package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.castscreen.views.bytecast.LiveCastControlLayout;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.pj;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/CastScreenCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastScreenCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public final CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CastScreenCompositeWidget a;

        public a(CastScreenCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            h80.c r4 = (h80.c) r3;
            MiddlewareRoomContext r0 = this.a.getMiddlewareRoomContext();
            if ((r0 instanceof RoomContext) == true) goto L5;
            r0 = null;
        L5:
            RoomContext r1 = (RoomContext) r0;
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.isVSRoom() == false) goto L10;
            return;
        L10:
            if (((n.a) r4.a()).b == true) goto L12;
            return;
        L12:
            if (((n.a) r4.a()).a.orientation != 2) goto L18;
            xs2.b.a().post(new com.bytedance.android.livesdk.castscreen.utils.b(true));
            return;
        }
    }

    public final void wq() {
        boolean r0 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).isPaidLive();
        boolean r1 = xq();
        boolean r2 = VrUtils.c(((Widget) this).dataCenter);
        if (r1 == true) goto L6;
        if (r0 == true) goto L6;
        return;
    L6:
        if (y3.f(((Widget) this).dataCenter).n(ToolbarButton.CAST_SCREEN) == true) goto L21;
        if (r2 == true) goto L22;
        int r3 = com.bytedance.android.livesdk.castscreen.api.b.a;
        Room r4 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter);
        DataContext r5 = this.dataContext;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r6 = null;
        if ((r5 instanceof RoomContext) == true) goto L11;
        r5 = null;
    L11:
        RoomContext r7 = (RoomContext) r5;
        Intrinsics.checkNotNullParameter(r4, "room");
        String r8 = LiveByteCastUIManager.a;
        if (LiveByteCastUIManager.r() == false) goto L17;
        if (LiveByteCastManager.a() == false) goto L17;
        r6 = new com.bytedance.android.livesdk.castscreen.views.bytecast.k(null);
    L17:
        if ((r6 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L23;
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.CAST_SCREEN, r6);
        return;
    L23:
        return;
    L22:
        return;
    }

    public final boolean xq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L11;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 == null) goto L11;
        RoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L11;
        if (r2.getCastScreen() != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public CastScreenCompositeWidget() {
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        this.c = ho1.a.c(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        n r1 = null;
        if (r0 == null) goto L5;
        LiveCastControlLayout r2 = r0.Vo();
    L7:
        if ((r2 instanceof LiveCastControlLayout) == true) goto L9;
        r2 = null;
    L9:
        boolean r3 = false;
        if (r2 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.a;
        if (r4 == null) goto L15;
        boolean r5 = r4.o5();
    L16:
        if (r5 == false) goto L35;
        pj r6 = pj.a;
        if (r6.getValue().booleanValue() == false) goto L21;
        r2.setEnable(r6.getValue().booleanValue());
    L21:
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r7 = CastScreenViewModel.a.a();
        if (r7 != null) goto L24;
    L26:
        r2.setVisibility(8);
    L27:
        if (r7 == null) goto L35;
        com.bytedance.live.datacontext.m r8 = r7.getCastOrMirrorScreenMode();
        if (r8 == null) goto L35;
        Observable r9 = r8.a();
        if (r9 == null) goto L35;
        Disposable r10 = r9.subscribe(new c(r2));
        if (r10 == null) goto L35;
        RxUtilKt.c(r10, this.d);
        goto L35
    L24:
        if (((Boolean) r7.getCastOrMirrorScreenMode().getValue()).booleanValue() == false) goto L26;
        r2.setVisibility(0);
        goto L27
    L15:
        r5 = false;
    L35:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r11 = this.a;
        if (r11 == null) goto L38;
        r3 = r11.o5();
    L38:
        if (r3 == false) goto L74;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L74;
        Room r13 = com.bytedance.android.live.core.utils.z.o(r12);
        if (r13 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r14 = y3.i(((Widget) this).dataCenter);
        int r15 = com.bytedance.android.livesdk.castscreen.api.b.a;
        com.bytedance.android.livesdk.castscreen.api.a r16 = new com.bytedance.android.livesdk.castscreen.api.a();
        if (r13.isThirdParty() == true) goto L50;
        if (r13.isScreenshot() == true) goto L50;
    L52:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).e1(PaidSceneEnum.PAID_ROOM) == false) goto L74;
    L53:
        f r17 = new f(this);
        if (LiveByteCastManager.b() == true) goto L74;
        if (xq() == false) goto L74;
        Intrinsics.checkNotNull(r16);
        Intrinsics.checkNotNullParameter(r13, "room");
        if (LiveByteCastUIManager.r() == true) goto L60;
    L62:
        com.bytedance.android.livesdk.castscreen.views.bytecast.k r18 = null;
    L64:
        if ((r18 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L66;
        r14.k(ToolbarButton.GAME_CAST_SCREEN, r18);
    L66:
        lk1.c.a r19 = lk1.c.i2;
        DataCenter r20 = ((Widget) this).dataCenter;
        r19.getClass();
        com.bytedance.android.live.core.arch.mvvm.d r21 = lk1.c.a.a(r20).observeStatusChanged("room_auth_cast_screen");
        if (r21 == null) goto L71;
        Disposable r22 = r21.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r18, r14));
        if (r22 == null) goto L71;
        this.d.add(r22);
    L71:
        ILiveExpOptService r23 = jc1.k.f(ILiveExpOptService.class);
        if (r23 == null) goto L74;
        this.d.add(r23.registerExpBizListener(l61.d.a.f.e, new d(r14, r18)));
        goto L74
    L60:
        if (LiveByteCastManager.a() == false) goto L62;
        r18 = new com.bytedance.android.livesdk.castscreen.views.bytecast.k(r17);
    L50:
        if (xq() == true) goto L53;
    L74:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r24 = this.a;
        if (r24 == null) goto L77;
        boolean r25 = r24.V9();
    L78:
        if (r25 == false) goto L97;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r26 = this.c;
        if (r26 == null) goto L87;
        PropertyOwner r27 = r26.getLoadState();
        if (r27 == null) goto L87;
        Disposable r28 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r27, new CastScreenCompositeWidget$preparePortraitCastScreenToolbarButton$1(this));
        if (r28 == null) goto L87;
        RxUtilKt.c(r28, this.d);
    L87:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r29 = this.c;
        if (r29 == null) goto L94;
        PropertyOwner r30 = r29.Na();
        if (r30 == null) goto L94;
        Disposable r31 = r30.subscribe(new g(this));
        if (r31 == null) goto L94;
        RxUtilKt.c(r31, this.d);
    L94:
        DataCenter r32 = ((Widget) this).dataCenter;
        if (r32 == null) goto L97;
        r32.observe("paid_live_paid_info_update", this);
    L97:
        h70.b r33 = getComponentContext();
        if (r33 == null) goto L100;
        r1 = ho1.a.e(r33);
    L100:
        if (r1 == null) goto L107;
        PropertyOwner r34 = r1.sa();
        if (r34 == null) goto L108;
        Disposable r35 = r34.subscribe(new a(this));
        if (r35 == null) goto L109;
        RxUtilKt.c(r35, this.d);
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L77:
        r25 = true;
        goto L78
    L5:
        r2 = null;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.d.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L21;
        if (r4 == null) goto L9;
        String r5 = r4.getKey();
    L10:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.hashCode() == (-1060623801)) goto L16;
        return;
    L16:
        if (r5.equals("paid_live_paid_info_update") == false) goto L20;
        wq();
        return;
    L20:
        return;
    L9:
        r5 = null;
        goto L10
    }
}
