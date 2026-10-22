package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.ui.behavior.LandscapePictureTypeBehavior;
import com.bytedance.android.livesdk.chatroom.ui.behavior.ToolbarVideoQualityBehavior;
import com.bytedance.android.livesdk.chatroom.ui.g6;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.p1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.LandscapeToolbarMoreBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorBacktrackBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarManageBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.o2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.r2;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.utils.r6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ToolbarCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/u;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData>, u {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public final CompositeDisposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ToolbarCompositeWidget a;

        public a(ToolbarCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            h80.c r2 = (h80.c) r1;
            this.a.wq();
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.u
    public final View fh() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L19;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 == null) goto L19;
        if (r1.isMediaRoom() == false) goto L19;
        if (com.bytedance.android.live.core.utils.z.e(((Widget) this).dataCenter, false) == true) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r2 = y3.m(((Widget) this).dataCenter);
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r3 = ((x3) r2).t(ToolbarButton.CLOSE_ROOM);
        if ((r3 instanceof r2) == false) goto L19;
        return ((r2) r3).a;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L19:
        return null;
    }

    public final void wq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        Room r1 = null;
        if (r0 == null) goto L5;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r0);
    L6:
        if (r2 == null) goto L11;
        if (VrUtils.p(r2) == false) goto L11;
        RoomAuthStatus.Style r3 = new RoomAuthStatus.Style();
        r3.setUnableStyle(0);
        lk1.c.a r4 = lk1.c.i2;
        DataCenter r5 = ((Widget) this).dataCenter;
        r4.getClass();
        lk1.c.a.a(r5).updateComponentRule("room_auth_cast_screen", new g6(VrUtils.k(((Widget) this).dataCenter, r2), r3));
    L11:
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L19;
        kh1.a r6 = kh1.a.a;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L16;
        r1 = com.bytedance.android.live.core.utils.z.o(r7);
    L16:
        if (kh1.a.d(r1) == true) goto L20;
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.ANCHOR_BACKTRACK, new ToolbarAnchorBacktrackBehavior());
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public ToolbarCompositeWidget() {
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        wq();
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = ho1.a.c(getComponentContext());
        if (r0 == null) goto L9;
        PropertyOwner r1 = r0.Na();
        if (r1 == null) goto L9;
        Disposable r2 = r1.subscribe(new a(this));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, this.b);
    L9:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L12;
        r3.observeForever("cmd_widget_loaded", this);
    L12:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L15;
        r4.observeForever("data_toolbar_visible", this);
    L15:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = this.a;
        if (r5 == null) goto L97;
        boolean r6 = true;
        if (r5.o5() != true) goto L97;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L97;
        Room r8 = com.bytedance.android.live.core.utils.z.o(r7);
        if (r8 == null) goto L97;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r9 = y3.i(((Widget) this).dataCenter);
        h70.b r10 = getComponentContext();
        com.bytedance.android.livesdk.widgetdescriptor.e0 r11 = null;
        if ((r10 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L28;
        r10 = null;
    L28:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r12 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r10;
        if (r12 != null) goto L31;
    L46:
        boolean r13 = true;
    L47:
        if (r13 == false) goto L49;
        r9.k(ToolbarButton.SWITCH_SCREEN_ORIENTATION, new com.bytedance.android.livesdk.chatroom.ui.behavior.c());
    L49:
        r9.k(ToolbarButton.MANAGE, new ToolbarManageBehavior(true));
        if (x6.d() == false) goto L59;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r14 = this.a;
        if (r14 == null) goto L57;
        Bundle r15 = r14.Wl();
        if (r15 == null) goto L57;
        if (r15.getBoolean("extra_longer_video_with_live", false) == true) goto L59;
    L57:
        r9.k(ToolbarButton.LIVE_PICTURE_TYPE, new LandscapePictureTypeBehavior(r8));
    L59:
        if (x6.a != 0) goto L61;
        x6.c = true;
    L63:
        if (r8.isMediaRoom() == true) goto L66;
        r9.k(ToolbarButton.BLOCK, new o2());
    L77:
        ToolbarVideoQualityBehavior r16 = new ToolbarVideoQualityBehavior(getContext(), r8, false, new l1(this));
        if (r16.a(r8) == true) goto L80;
    L90:
        nm1.t r17 = pm1.f.q();
        if (getContext() == null) goto L96;
        if (r17 == null) goto L96;
        if (r8.isMergeVSRoom() == true) goto L96;
        r9.k(ToolbarButton.QUICK_SCREEN_SHOT, r17.f(getContext(), r8));
    L96:
        r9.k(ToolbarButton.MORE, new LandscapeToolbarMoreBehavior(getContext(), ((Widget) this).dataCenter, new k1(this)));
        goto L97
    L80:
        if (r8.isMergeVSRoom() == false) goto L82;
    L89:
        r9.d(ToolbarButton.SWITCH_VIDEO_QUALITY, r16);
        goto L90
    L82:
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == true) goto L89;
        if (m50.a.getValue().a() == true) goto L87;
    L88:
        r9.k(ToolbarButton.SWITCH_VIDEO_QUALITY, r16);
        goto L90
    L87:
        if (r8.isMediaRoom() == false) goto L90;
    L66:
        if (w32.a.a() == true) goto L77;
        IMediaReplayService r18 = jc1.k.f(IMediaReplayService.class);
        if (r18 != null) goto L70;
    L74:
        r6 = false;
    L75:
        if (r6 == true) goto L77;
        r9.k(ToolbarButton.BLOCK_MEDIA, new o2());
        goto L77
    L70:
        if (r18.isReplaySync(r8.id) == true) goto L75;
        if (r18.shouldStartReplay(r8) == false) goto L74;
    L61:
        x6.c = false;
        goto L63
    L31:
        if (((d90.d) r12).f == null) goto L46;
        j70.f r19 = d90.d.a.B2;
        if (r19 == null) goto L46;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r20 = getComponentContext();
        if ((r20 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == false) goto L38;
        r11 = r20;
    L38:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r21 = r11;
        if (r21 == null) goto L46;
        z70.b r22 = ((h70.b) r21).a;
        if (r22 == null) goto L46;
        if (r22.d(r19) != true) goto L46;
        r13 = false;
    L97:
        h70.b r23 = getComponentContext();
        if (r23 == null) goto L103;
        IAbilityCenter r24 = r23.a();
        if (r24 == null) goto L104;
        r24.registerAbility(u.class, this);
        return;
    L104:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(u.class);
    L7:
        this.b.dispose();
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.removeObserver(this);
    L10:
        this.a = null;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L94;
        Bundle r1 = null;
        if (r6 == null) goto L10;
        String r2 = r6.getKey();
    L11:
        if (r2 == null) goto L95;
        int r3 = r2.hashCode();
        if (r3 == (-1836833765)) goto L38;
        if (r3 == 1324558617) goto L19;
        return;
    L19:
        if (r2.equals("data_toolbar_visible") == false) goto L87;
        String r7 = (String) r6.getData();
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L28;
        Room r8 = com.bytedance.android.live.core.utils.z.o(r4);
        if (r8 == null) goto L28;
        long r9 = r8.getRoomId();
    L29:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.a;
        if (r10 == null) goto L32;
        r1 = r10.Wl();
    L32:
        IRoomModuleService r11 = jc1.k.f(IRoomModuleService.class);
        if (r11 == null) goto L88;
        q81.c r12 = r11.getLiveMkMetricHelper();
        if (r12 == null) goto L89;
        r12.k(r7, r9, r1);
        return;
    L89:
        return;
    L88:
        return;
    L28:
        r9 = 0;
        goto L29
    L87:
        return;
    L38:
        if (r2.equals("cmd_widget_loaded") == true) goto L40;
        return;
    L40:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r6) == false) goto L92;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r13 = this.a;
        if (r13 == null) goto L97;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r14 = y3.m(((Widget) this).dataCenter);
        if (r14 == null) goto L85;
        x3 r15 = (x3) r14;
        if (r13.dg() == false) goto L49;
    L50:
        int r16 = r6.a;
        if (r6.a.a() == false) goto L56;
        ToolbarButton r17 = ToolbarButton.FAST_GIFT;
        if (r15.n(r17) == false) goto L56;
        r15.i(r17.extended());
    L83:
        r15.B();
        p1.a(((Widget) this).dataCenter);
        return;
    L56:
        if (r6.a.b() == false) goto L63;
        if (r15.z() == true) goto L63;
        ToolbarButton r18 = ToolbarButton.FAST_GIFT;
        if (r15.n(r18) == false) goto L63;
        r15.i(r18.extended());
    L63:
        if (r6.a.b() == false) goto L70;
        if (r15.z() == false) goto L70;
        ToolbarButton r19 = ToolbarButton.FAST_GIFT;
        if (r15.n(r19) == true) goto L70;
        r15.c(r19.extended());
    L70:
        if (r6.a.c() == false) goto L77;
        if (r15.z() == false) goto L77;
        ToolbarButton r20 = ToolbarButton.FAST_GIFT;
        if (r15.n(r20) == false) goto L77;
        r15.i(r20.extended());
    L77:
        if (r6.a.c() == false) goto L83;
        if (r15.z() == true) goto L83;
        ToolbarButton r21 = ToolbarButton.FAST_GIFT;
        if (r15.n(r21) == true) goto L83;
        r15.c(r21.extended());
        goto L83
    L49:
        if (r13.V9() == false) goto L83;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L97:
        return;
    L92:
        return;
    L95:
        return;
    L10:
        r2 = null;
        goto L11
    }
}
