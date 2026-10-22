package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/VRLandscapeServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VRLandscapeServiceWidget extends MiddlewareRoomWidget {
    public com.bytedance.android.livesdk.chatroom.ui.framework.d a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ VRLandscapeServiceWidget a;

        public a(VRLandscapeServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            this.a.zq();
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ VRLandscapeServiceWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == false) goto L5;
            VRLandscapeServiceWidget.wq(this.a);
            this.c.setCanShowGestureGuideLandscapeLock(false);
            return;
        L5:
            LottieAnimationView r3 = this.a.Oc();
            int r0 = bo1.a.a;
            if (r3 == null) goto L8;
            r3.setImageAssetsFolder("swipe_upDown/images");
            r3.setAnimation("swipe_upDown/swipeUpDown.json");
        L8:
            this.a.yq(true);
            LottieAnimationView r4 = this.a.Oc();
            if (r4 == null) goto L13;
            r4.playAnimation();
            return;
        }

        public b(VRLandscapeServiceWidget r1, boolean r2, com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VRLandscapeServiceWidget a;

        public c(VRLandscapeServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L5;
            VRLandscapeServiceWidget.xq(this.a);
            return;
        L5:
            VRLandscapeServiceWidget.wq(this.a);
        }
    }

    public final LinearLayout C6() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.C6();
    }

    public final LottieAnimationView Oc() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Oc();
    }

    public final void zq() {
        DataContext r0 = this.dataContext;
        if (r0 == null) goto L14;
        Intrinsics.checkNotNullParameter(r0, "$this$getRoomDataCtxExt");
        com.bytedance.android.livesdk.chatroom.o r1 = z51.a.g(r0);
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.m r2 = r1.x1();
        if (r2 == null) goto L16;
        Observable r3 = r2.a();
        if (r3 == null) goto L17;
        ObservableSubscribeProxy r4 = (ObservableSubscribeProxy) r3.as(AutoDispose.bind(this));
        if (r4 == null) goto L18;
        r4.subscribe(new c(this));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        com.bytedance.live.datacontext.m r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(r0);
    L6:
        this.b = r2;
        this.a = ho1.a.i(getComponentContext());
        DataContext r3 = this.dataContext;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "$this$getExpRoomServiceExt");
        com.bytedance.android.livesdk.chatroom.r r4 = z51.a.d(r3);
        if (r4 == null) goto L11;
        r1 = r4.x();
    L11:
        if (r1 != null) goto L13;
    L15:
        if (r1 == null) goto L23;
        Observable r5 = r1.a();
        if (r5 == null) goto L24;
        ObservableSubscribeProxy r6 = (ObservableSubscribeProxy) r5.as(AutoDispose.bind(this));
        if (r6 == null) goto L25;
        r6.subscribe(new a(this));
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L15;
        zq();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
    }

    public VRLandscapeServiceWidget() {
    }

    public static final void wq(VRLandscapeServiceWidget r1) {
        if (r1.Oc() != null) goto L5;
        return;
    L5:
        if (r1.C6() == null) goto L16;
        LottieAnimationView r0 = r1.Oc();
        if (r0 == null) goto L10;
        r0.removeAllAnimatorListeners();
    L10:
        LinearLayout r2 = r1.C6();
        if (r2 == null) goto L15;
        r2.setVisibility(8);
        return;
    L15:
        return;
    }

    public static final void xq(VRLandscapeServiceWidget r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = r3.b;
        Room r1 = null;
        if (r0 == null) goto L5;
        Room r2 = r0.getRoom();
    L6:
        if (r2 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = r3.b;
        if (r4 == null) goto L10;
        r1 = r4.getRoom();
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isVrRoom() != true) goto L48;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r5 = LiveVrContext.c.a();
        if (r5 != null) goto L17;
        return;
    L17:
        if (VrUtils.t(((Widget) r3).dataCenter, true) == true) goto L20;
        return;
    L20:
        if (r5.isInVrMode() == false) goto L23;
        return;
    L23:
        if (r5.canShowGestureGuideLandscapeLock() == true) goto L26;
        return;
    L26:
        if (r3.C6() != null) goto L28;
        return;
    L28:
        if (r3.Oc() != null) goto L31;
        return;
    L31:
        if (r3.dataContext == null) goto L53;
        LinearLayout r6 = r3.C6();
        if (r6 == null) goto L36;
        r6.setVisibility(0);
    L36:
        LottieAnimationView r7 = r3.Oc();
        int r8 = bo1.a.a;
        if (r7 == null) goto L39;
        r7.setImageAssetsFolder("swipe_leftRight/images");
        r7.setAnimation("swipe_leftRight/swipeLeftRight.json");
    L39:
        r3.yq(false);
        LottieAnimationView r9 = r3.Oc();
        if (r9 == null) goto L47;
        r9.playAnimation();
        return;
    L47:
        return;
    L53:
        return;
    L48:
        return;
    L43:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void yq(boolean r4) {
        if (Oc() != null) goto L5;
        return;
    L5:
        if (C6() == null) goto L19;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r0 = LiveVrContext.c.a();
        if (r0 != null) goto L10;
        return;
    L10:
        LottieAnimationView r1 = Oc();
        if (r1 == null) goto L13;
        r1.removeAllAnimatorListeners();
    L13:
        LottieAnimationView r2 = Oc();
        if (r2 == null) goto L18;
        r2.addAnimatorListener(new b(this, r4, r0));
        return;
    L18:
        return;
    }
}
