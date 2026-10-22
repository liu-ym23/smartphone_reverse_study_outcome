package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.LandscapeRootViewChangeManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.vr.VrMediaViewType;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.h5;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.e3;
import zg1.o2;
import zg1.w0;
import zg1.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeSpiltControllerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lzg1/e3;", "event", "", "onEvent", "Lzg1/w0;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeSpiltControllerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public Room a;
    public boolean b;
    public final Lazy c;
    public final CompositeDisposable d;
    public final r e;
    public final h80.d<LandscapeRootViewChangeManager> f;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            boolean r0 = h5.a;
            h5.b(((Boolean) r2).booleanValue());
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LandscapeSpiltControllerWidget a;

        public b(LandscapeSpiltControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LandscapeSpiltControllerWidget r0 = this.a;
            r0.onEvent((e3) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LandscapeSpiltControllerWidget a;

        public c(LandscapeSpiltControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LandscapeSpiltControllerWidget r0 = this.a;
            r0.onEvent((w0) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LandscapeSpiltControllerWidget a;

        public d(LandscapeSpiltControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            o2 r9 = (o2) r8;
            LandscapeSpiltControllerWidget r6 = this.a;
            r6.getClass();
            if (r9 != null) goto L6;
            return;
        L6:
            if (r9.a == false) goto L11;
            if (r6.wq() == false) goto L14;
            LandscapeSpiltControllerWidget.yq(r6, 8, false, false, false, 14);
            return;
        L14:
            return;
        L11:
            if (r6.wq() == false) goto L16;
            LandscapeSpiltControllerWidget.yq(r6, 0, false, false, false, 14);
            r6.zq();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LandscapeSpiltControllerWidget a;

        public e(LandscapeSpiltControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.zq();
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ LandscapeSpiltControllerWidget a;

        public f(LandscapeSpiltControllerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == true) goto L5;
        L11:
            r r3 = this.a.e;
            if (r3 == null) goto L20;
            View r4 = r3.b;
            if (r4 == null) goto L21;
            r4.setAlpha(1.0f);
            return;
        L21:
            return;
        L20:
            return;
        L5:
            if (com.bytedance.android.livesdk.f.d().c == true) goto L11;
            r r5 = this.a.e;
            if (r5 == null) goto L17;
            View r6 = r5.b;
            if (r6 == null) goto L18;
            r6.setAlpha(0.4f);
            return;
        L18:
            return;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final boolean wq() {
        boolean r0 = this.b;
        Room r1 = this.a;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L6:
        return com.bytedance.android.livesdk.utils.landscape.e.b(r0, r1);
    }

    public final void zq() {
        r r0 = this.e;
        if (r0 == null) goto L30;
        FrameLayout r1 = r0.e;
        if (r1 == null) goto L31;
        Room r2 = this.a;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L9:
        RoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L14;
        if (r3.isEnableLandscapeChat() == true) goto L14;
    L27:
        int r4 = 8;
    L28:
        r1.setVisibility(r4);
        return;
    L14:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L27;
        if (xq() == true) goto L27;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        r4 = 0;
        if (r5 == null) goto L25;
        com.bytedance.live.datacontext.m r6 = r5.isLandscapeLock();
        if (r6 == null) goto L25;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L25;
        boolean r8 = r7.booleanValue();
    L26:
        if (r8 == false) goto L28;
    L25:
        r8 = false;
        goto L26
    L31:
        return;
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        boolean r1 = true;
        if (VrUtils.t(((Widget) this).dataCenter, true) == false) goto L10;
        Room r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L8:
        if (r0.isMediaRoom() == false) goto L10;
    L11:
        if (r1 == false) goto L20;
        boolean r2 = h5.a;
        r r3 = this.e;
        View r4 = null;
        if (r3 == null) goto L15;
        View r5 = r3.i;
    L16:
        VrMediaViewType r6 = VrMediaViewType.TOP;
        h5.c(r5, false, r6);
        r r7 = this.e;
        if (r7 == null) goto L19;
        r4 = r7.j;
    L19:
        h5.c(r4, false, r6);
        goto L20
    L15:
        r5 = null;
    L20:
        this.d.clear();
        return;
    L10:
        r1 = false;
        goto L11
    }

    public final boolean xq() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L13;
        IAbilityCenter r1 = a0.a(r0);
        if (r1 == null) goto L13;
        IRoomRecordService r2 = r1.getAbility(IRoomRecordService.class);
        if (r2 == null) goto L13;
        if (r2.isRecording() != true) goto L13;
        if (com.bytedance.android.livesdk.service.l.d().e().isClearScreen() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void onChanged(Object r7) {
        KVData r0 = (KVData) r7;
        if (isViewValid() == false) goto L45;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getKey();
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L51;
        if (r0 == null) goto L19;
        r1 = r0.getKey();
    L19:
        if (r1 == null) goto L52;
        int r4 = r1.hashCode();
        if (r4 == 966223177) goto L42;
        if (r4 == 1871873441) goto L27;
        return;
    L27:
        if (r1.equals("data_room_comment_status") == true) goto L29;
        return;
    L29:
        if (wq() == false) goto L47;
        Room r5 = this.a;
        if (r5 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L34:
        if (com.bytedance.android.livesdk.utils.landscape.e.a(r5) == true) goto L36;
        yq(this, 8, false, false, false, 12);
        return;
    L36:
        if (VrUtils.u(((Widget) this).dataCenter, true) == false) goto L38;
        int r6 = 8;
    L39:
        yq(this, r6, false, false, false, 12);
        return;
    L38:
        r6 = 0;
        goto L39
    L47:
        return;
    L42:
        if (r1.equals("cmd_start_replay") == false) goto L50;
        yq(this, 8, false, false, false, 12);
        return;
    L50:
        return;
    L52:
        return;
    L51:
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    L7:
        r2 = null;
        goto L9
    }

    public final void onEvent(w0 r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (m50.a.getValue().e() == true) goto L5;
        r r0 = this.e;
        if (r0 == null) goto L20;
        View r1 = r0.b;
        if (r1 != null) goto L15;
        return;
    L15:
        if (r8.a == false) goto L17;
        UtilityKotlinExtentionsKt.w(r1);
        return;
    L17:
        UtilityKotlinExtentionsKt.u(r1);
        return;
    L20:
        return;
    L5:
        if (r8.a == false) goto L7;
        int r2 = 0;
    L8:
        yq(this, r2, true, r8.b, false, 8);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final void onLoad(Object[] r10) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L75;
        Room r12 = (Room) r11.get("data_room");
        if (r12 == null) goto L76;
        this.a = r12;
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L12;
        Boolean r14 = (Boolean) r13.get("data_is_anchor");
        if (r14 == null) goto L12;
        boolean r15 = r14.booleanValue();
    L13:
        this.b = r15;
        if (VrUtils.t(((Widget) this).dataCenter, true) == false) goto L21;
        Room r16 = this.a;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L19:
        if (r16.isMediaRoom() == false) goto L21;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L50;
        boolean r18 = h5.a;
        r r19 = this.e;
        if (r19 == null) goto L27;
        View r110 = r19.i;
    L28:
        h5.c(r110, true, VrMediaViewType.TOP);
        r r111 = this.e;
        if (r111 == null) goto L31;
        View r112 = r111.j;
    L32:
        h5.c(r112, true, VrMediaViewType.BOTTOM);
        r r113 = this.e;
        if (r113 == null) goto L39;
        View r114 = r113.i;
        if (r114 == null) goto L39;
        if (r114.getVisibility() != 0) goto L39;
        boolean r115 = true;
    L40:
        h5.a = r115;
        IVSPlayerService r116 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r116 == null) goto L50;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r117 = r116.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r117 == null) goto L50;
        VSPlayerViewControlContext r118 = r117.provideContext();
        if (r118 == null) goto L50;
        com.bytedance.live.datacontext.m<Boolean> r119 = r118.getPlayerViewVisible();
        if (r119 == null) goto L50;
        h5.b(((Boolean) r119.getValue()).booleanValue());
        RxUtilKt.c(r119.a().subscribe(a.a), this.d);
    L39:
        r115 = false;
        goto L40
    L31:
        r112 = null;
        goto L32
    L27:
        r110 = null;
    L50:
        if (wq() == true) goto L52;
    L56:
        L7(e3.class, new b(this));
        L7(w0.class, new c(this));
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(a0.p(((Widget) this).dataCenter)).b(o2.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new d(this));
        DataCenter r120 = ((Widget) this).dataCenter;
        if (r120 == null) goto L59;
        r120.put("data_is_hiding_landscape_buttons", Boolean.FALSE);
    L59:
        DataCenter r121 = ((Widget) this).dataCenter;
        if (r121 == null) goto L64;
        DataCenter r122 = r121.observe("data_room_comment_status", this);
        if (r122 == null) goto L64;
        r122.observe("cmd_start_replay", this);
    L64:
        RoomContext r123 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r123 == null) goto L73;
        com.bytedance.live.datacontext.m r124 = r123.isLandscapeLock();
        if (r124 == null) goto L73;
        Observable r125 = r124.a();
        if (r125 == null) goto L73;
        Disposable r126 = r125.subscribe(new e(this));
        if (r126 == null) goto L73;
        RxUtilKt.c(r126, this.d);
    L73:
        int r127 = com.bytedance.android.livesdk.utils.landscape.d.a;
        com.bytedance.android.livesdk.f.d().a.observe(this, new f(this));
        return;
    L52:
        if (VrUtils.u(((Widget) this).dataCenter, true) == false) goto L54;
        int r4 = 8;
    L55:
        yq(this, r4, false, false, VrUtils.u(((Widget) this).dataCenter, true), 4);
        zq();
        goto L56
    L54:
        r4 = 0;
    L21:
        r17 = false;
    L12:
        r15 = false;
        goto L13
    L76:
        return;
    }

    public final void onEvent(e3 r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (VrUtils.u(((Widget) this).dataCenter, true) == false) goto L6;
    L7:
        int r2 = 8;
    L10:
        if (wq() == false) goto L13;
        yq(this, r2, true, r8.a, false, 8);
        zq();
        return;
    L13:
        return;
    L6:
        if (r8.b == true) goto L7;
        r2 = 0;
        goto L10
    }

    public LandscapeSpiltControllerWidget(r r2, h80.d<LandscapeRootViewChangeManager> r3) {
        Intrinsics.checkNotNullParameter(r3, "landscapeRootViewChangeManagerGetter");
        this.e = r2;
        this.f = r3;
        this.c = LazyKt.lazy(LandscapeSpiltControllerWidget$ignoreFalse$2.INSTANCE);
        this.d = new CompositeDisposable();
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    public static void yq(LandscapeSpiltControllerWidget r15, int r16, boolean r17, boolean r18, boolean r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        boolean r0 = true;
    L6:
        int r4 = 0;
        if ((r20 & 4) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r20 & 8) == 0) goto L13;
        boolean r6 = false;
    L14:
        r r7 = r15.e;
        if (r7 == null) goto L86;
        View r8 = r7.b;
        IMediaReplayService r9 = jc1.k.f(IMediaReplayService.class);
        int r10 = r8.getVisibility();
        Room r11 = r15.a;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L21:
        if (com.bytedance.android.livesdk.utils.landscape.e.a(r11) == true) goto L23;
    L34:
        int r12 = 8;
    L35:
        if (r12 != 0) goto L37;
        boolean r13 = true;
    L38:
        LandscapeRootViewChangeManager r2 = (LandscapeRootViewChangeManager) r15.f.get();
        if (r2 == null) goto L44;
        r2.j = r13;
        if (r13 == true) goto L43;
        r2.b();
        goto L44
    L43:
        r2.d(2131381282, 0, 0);
        r2.e(0, 0);
    L44:
        if (r10 != r12) goto L50;
        if (r6 == true) goto L50;
        if (((Boolean) r15.c.getValue()).booleanValue() == true) goto L85;
        if (r3 == true) goto L50;
        return;
    L85:
        return;
    L50:
        if (r3 == false) goto L52;
        boolean r14 = false;
    L53:
        float r5 = UtilityKotlinExtentionsKt.h(200.0f);
        if (r14 == false) goto L69;
        if (r13 == false) goto L65;
        View r21 = r7.k;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L64;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        int r1 = r21.getWidth();
        int r110 = (r7.a.getWidth() - r1) / 2;
        r23.width = -1;
        r23.leftMargin = r110;
        r23.rightMargin = r110;
        r21.setLayoutParams(r23);
        int r111 = (int) r5;
        if (DigHoleScreenUtil.isDigHole(((Widget) r15).context) == false) goto L61;
        int r24 = UIUtils.getStatusBarHeight(((Widget) r15).context);
    L62:
        u4.c(new LandscapeSpiltControllerWidget$updateSpiltAreaVisibility$1(r15, r8, r5, r7, r110, r24, r111, r12)).c();
    L83:
        xs2.b.a().post(new y0(r13, r14));
        r.f(r13);
        return;
    L61:
        r24 = 0;
        goto L62
    L64:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L65:
        ViewGroup.LayoutParams r25 = r7.k.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == true) goto L68;
        r25 = null;
    L68:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
        u4.c(new LandscapeSpiltControllerWidget$updateSpiltAreaVisibility$2(r15, r5, r8, r7, r12)).c();
        goto L83
    L69:
        r8.setVisibility(r12);
        if (r13 == true) goto L72;
        r7.d(0, 0);
        r7.c(ILandscapeSpiltManager.State.HIDE);
        goto L83
    L72:
        if (DigHoleScreenUtil.isDigHole(((Widget) r15).context) == false) goto L75;
        r4 = UIUtils.getStatusBarHeight(((Widget) r15).context);
    L75:
        if (((Boolean) j40.y0.a.getValue()).booleanValue() == false) goto L81;
        View r27 = r7.k;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L80;
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r28;
        r29.width = -1;
        r27.setLayoutParams(r29);
        goto L81
    L80:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L81:
        r7.d(r4, (int) r5);
        r7.c(ILandscapeSpiltManager.State.SHOW);
        goto L83
    L52:
        r14 = r0;
        goto L53
    L37:
        r13 = false;
        goto L38
    L23:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L34;
        if (r15.xq() == true) goto L34;
        if (r9 == null) goto L33;
        Room r112 = r15.a;
        if (r112 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L31:
        if (r9.isReplaySync(r112.id) == true) goto L34;
    L33:
        r12 = r16;
        goto L35
    L86:
        return;
    L13:
        r6 = r19;
        goto L14
    L9:
        r3 = r18;
        goto L11
    L5:
        r0 = r17;
        goto L6
    }
}
