package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.gesture.EffectGestureDetectorV2;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ad;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nz.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/AnchorPortraitGestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/GestureWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPortraitGestureWidget extends GestureWidget {
    public static final /* synthetic */ int E = 0;
    public View.OnTouchListener A;
    public EffectGestureDetectorV2 B;
    public com.bytedance.android.livesdk.chatroom.broadcast.b C;
    public com.bytedance.android.livesdk.chatroom.broadcast.c D;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c z;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ AnchorPortraitGestureWidget a;

        public a(AnchorPortraitGestureWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            AnchorPortraitGestureWidget r0 = this.a;
            int r1 = AnchorPortraitGestureWidget.E;
            h70.b r2 = r0.getComponentContext();
            iy.d r3 = null;
            if (r2 == null) goto L5;
            gd0.k r6 = ho1.a.k(r2);
        L6:
            if (r6 == null) goto L8;
            r6.a(r4, r5);
        L8:
            h70.b r7 = this.a.getComponentContext();
            if (r7 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.ui.framework.widget.p r8 = ho1.a.j(r7);
        L12:
            if (r8 == null) goto L14;
            r8.a(r4, r5);
        L14:
            h70.b r9 = this.a.getComponentContext();
            if (r9 == null) goto L19;
            IAbilityCenter r10 = r9.a();
            if (r10 == null) goto L19;
            x32.a r11 = (x32.a) r10.getAbility(x32.a.class);
        L20:
            if (r11 == null) goto L22;
            r11.a(r4, r5);
        L22:
            h70.b r12 = this.a.getComponentContext();
            if (r12 == null) goto L25;
            r3 = ho1.a.a(r12);
        L25:
            if (r3 == null) goto L29;
            r3.a(r4, r5);
            return false;
        L29:
            return false;
        L19:
            r11 = null;
            goto L20
        L11:
            r8 = null;
            goto L12
        L5:
            r6 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void er() {
        this.A = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean Mq() {
        return !z.h(((Widget) this).dataCenter);
    }

    public AnchorPortraitGestureWidget() {
        this.A = new a(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        this.z = ho1.a.d(getComponentContext());
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void onWidgetLoaded() {
        super.onWidgetLoaded();
        this.B = new EffectGestureDetectorV2(getContext(), LiveEffectContextFactoryDelegate.Type.DEFAULT);
        this.C = new com.bytedance.android.livesdk.chatroom.broadcast.b();
        this.D = new com.bytedance.android.livesdk.chatroom.broadcast.c(((Widget) this).dataCenter);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final View.OnTouchListener Fq() {
        return this.A;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Jq(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.c;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNullParameter(r0, "$this$getAnchorStatusPanelInterface");
        Element<?> r1 = r0.w8(d90.d.a.Z1);
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.broadcast.d r2 = (com.bytedance.android.livesdk.chatroom.broadcast.d) r1.f(com.bytedance.android.livesdk.chatroom.broadcast.d.class);
    L8:
        if (r2 == null) goto L35;
        boolean r3 = false;
        if (this.C == null) goto L23;
        if (com.bytedance.android.livesdk.utils.p.a() == true) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 != true) goto L23;
        com.bytedance.android.livesdk.chatroom.broadcast.b r6 = this.C;
        if (r6 == null) goto L34;
        r6.a(r5, r2);
        return;
    L34:
        return;
    L14:
        if (ad.a.getValue().booleanValue() == true) goto L16;
        r4 = true;
    L23:
        if (this.D != null) goto L25;
        return;
    L25:
        if (com.bytedance.android.livesdk.utils.p.a() == true) goto L27;
    L29:
        if (r3 != true) goto L37;
        com.bytedance.android.livesdk.chatroom.broadcast.c r7 = this.D;
        if (r7 == null) goto L38;
        r7.a(r5, r2);
        return;
    L38:
        return;
    L37:
        return;
    L27:
        if (ad.a.getValue().booleanValue() == false) goto L29;
        r3 = true;
        goto L29
    L35:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean Nq(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        EffectGestureDetectorV2 r0 = this.B;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d() != true) goto L22;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        ViewGroup r2 = null;
        if (r1 == null) goto L9;
        r r3 = ho1.b.a(r1);
    L10:
        if (r3 == null) goto L12;
        r2 = r3.b();
    L12:
        if (r2 == null) goto L16;
        ViewGroup r4 = r3.b();
        EffectGestureDetectorV2 r5 = this.B;
        if (r5 == null) goto L16;
        int r6 = r4.getWidth();
        int r8 = r4.getHeight();
        int r9 = r4.getTop();
        int r10 = r4.getLeft();
        r5.e = r6;
        r5.f = r8;
        r5.g = r9;
        r5.h = r10;
    L16:
        EffectGestureDetectorV2 r11 = this.B;
        if (r11 == null) goto L19;
        r11.f(r7);
    L19:
        return true;
    L9:
        r3 = null;
        goto L10
    L22:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void dr(String r1) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L5;
        r r3 = ho1.b.a(r2);
    L6:
        if (r3 == null) goto L9;
        r3.d();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean jr(float r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.z;
        LiveMode r0 = null;
        if (r4 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "$this$getAnchorFlingCallback");
        Object r5 = r4.Ep();
        if ((r5 instanceof com.bytedance.android.live.room.h.a) == true) goto L7;
        r5 = null;
    L7:
        com.bytedance.android.live.room.h.a r6 = (com.bytedance.android.live.room.h.a) r5;
    L9:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.z;
        if (r1 == null) goto L13;
        r0 = r1.getLiveMode();
    L13:
        if (r0 != null) goto L15;
    L22:
        return true;
    L15:
        if (r0.isUsingCamera() != true) goto L22;
        if (r6 == null) goto L22;
        if (com.bytedance.android.livesdk.utils.p.a() == false) goto L21;
        return false;
    L21:
        r6.a();
        goto L22
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Cq(float r1, float r2) {
        jr(-r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final void I4(boolean r3, boolean r4) {
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        jo1.a r2 = (jo1.a) r1.getAbility(jo1.a.class);
    L8:
        if (r2 == null) goto L11;
        r2.I4(r3, r4);
        return;
    L11:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean br(MotionEvent r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "e");
        RoomContext r1 = Iq();
        if (r1 == null) goto L9;
        IFocusContext r2 = (IFocusContext) r1.getFocusContext().getValue();
        if (r2 == null) goto L8;
        if (r4 == false) goto L8;
        return r2.onSingleTap(r3);
    L8:
        Intrinsics.checkNotNullParameter(r3, "e");
    L10:
        return false;
    L9:
        Intrinsics.checkNotNullParameter(r3, "e");
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean Zq(MotionEvent r10, MotionEvent r11, float r12, float r13) {
        if (r10 == null) goto L30;
        if (r11 == null) goto L30;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        boolean r4 = true;
        Logger.d("GestureWidget", String.format("onFling, Event1={%f, %f}, Event2={%f, %f}, velocityX=%f, velocityY=%f", Arrays.copyOf(new Object[]{Float.valueOf(r10.getX()), Float.valueOf(r10.getY()), Float.valueOf(r11.getX()), Float.valueOf(r11.getY()), Float.valueOf(r12), Float.valueOf(r13)}, 6)));
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.z;
        if (r2 == null) goto L9;
        LiveMode r3 = r2.getLiveMode();
    L10:
        if (r3 != null) goto L12;
    L14:
        float r5 = r11.getX() - r10.getX();
        double r14 = r11.getY() - r10.getY();
        if (Math.abs(r5) >= Math.abs(r14)) goto L17;
    L19:
        r4 = false;
    L21:
        if (Math.abs(r14) < 100) goto L23;
        Math.abs(r13);
    L23:
        if (r4 == false) goto L30;
        List r15 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().U(d0.a) <= 0) goto L29;
        f2.b(2131916364, 0);
        return false;
    L29:
        return jr(r5);
    L17:
        if (Math.abs(r12) < 100) goto L19;
    L12:
        if (r3.isStreamingBackground() != true) goto L14;
        return false;
    L9:
        r3 = null;
    L30:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean ar(MotionEvent r4, MotionEvent r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r4, "e1");
        Intrinsics.checkNotNullParameter(r5, "e2");
        RoomContext r0 = Iq();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getFocusContext();
        if (r1 == null) goto L7;
        IFocusContext r2 = (IFocusContext) r1.getValue();
    L8:
        if (r2 != null) goto L10;
    L12:
        super.ar(r4, r5, r6, r7);
        return true;
    L10:
        if (Math.abs(r6) >= Math.abs(r7)) goto L12;
        return r2.onScroll(r4, r5, r6, r7);
    L7:
        r2 = null;
        goto L8
    }
}
