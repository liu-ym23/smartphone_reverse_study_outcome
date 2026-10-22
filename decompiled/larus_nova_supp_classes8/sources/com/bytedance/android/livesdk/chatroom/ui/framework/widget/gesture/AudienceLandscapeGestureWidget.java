package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.p0;
import com.bytedance.android.livesdk.config.b41;
import com.bytedance.android.livesdk.config.c41;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.h0;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.eventbus.LogEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/AudienceLandscapeGestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/GestureWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLandscapeGestureWidget extends GestureWidget {
    public static final List<String> A = null;
    public Disposable z;

    public static final class a {
    }

    static {
        A = CollectionsKt.mutableListOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Yq() {
        View r0 = Gq();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = r0.getX();
        float r2 = r0.getWidth();
        b41 r3 = c41.a;
        if (r3.b() == false) goto L8;
        float r4 = r3.d();
    L10:
        if (r1 < (r2 / r4)) goto L12;
        jr(200, 0.0f);
        return;
    L12:
        jr(-1.0f, 0.0f);
        return;
    L8:
        r4 = 2.0f;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void cr() {
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r2 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r1.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L8:
        if (r2 == null) goto L11;
        r2.rf();
        return;
    L11:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        RoomContext r0 = Iq();
        GestureDetectLayout r1 = this.d;
        if (r0 == null) goto L14;
        if (r1 == null) goto L14;
        if (VrUtils.t(((Widget) this).dataCenter, true) == true) goto L9;
        ALogger.e("GestureDetectEvent", "registerGestureLayoutListener fail for not in vr landscape mode.");
        return;
    L9:
        this.z = r0.getGestureLayoutBehaviorEvent().onEvent().subscribe(new com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.a(this), b.a);
        List r2 = r0.getStickyBehaviorEvents();
        r0.setStickyBehaviorEvents(null);
        if (r2 == null) goto L18;
        int r3 = r2.size();
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L19;
        kr((gh1.a) ListProtector.get(r2, r4));
        r4 = r4 + 1;
        goto L12
    L19:
        return;
    L18:
        return;
    L14:
        ALogger.e("GestureDetectEvent", "registerGestureLayoutListener fail for dataContext or mGestureDetectLayout is null.");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.z;
        if (r0 == null) goto L11;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isDisposed() == true) goto L13;
        Disposable r1 = this.z;
        if (r1 == null) goto L14;
        r1.dispose();
        return;
    L14:
        return;
    L13:
        return;
    }

    public AudienceLandscapeGestureWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean D8(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        h70.b r0 = getComponentContext();
        h0 r1 = null;
        if (r0 == null) goto L5;
        h0 r2 = ho1.a.l(r0);
    L6:
        if (r2 == null) goto L17;
        if (r2.mb(r4) != true) goto L17;
        ALogger.e("GestureWidget", "onDiggTap isMagicClick is true ");
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L12;
        r1 = ho1.a.l(r5);
    L12:
        if (r1 == null) goto L18;
        r1.T7();
        return false;
    L18:
        return false;
    L17:
        return super.D8(r4);
    L5:
        r2 = null;
        goto L6
    }

    public final void kr(gh1.a r4) {
        if (r4 != null) goto L6;
        ALogger.e("GestureDetectEvent", "registerBehaviorEvents fail for null gestureDetectEvent.");
        return;
    L6:
        y r1 = r4.b;
        GestureDetectLayout r2 = this.d;
        if (r1 == null) goto L17;
        if (r2 == null) goto L17;
        int r5 = r4.a;
        if (r5 != 1) goto L14;
        r2.a(r1);
        return;
    L14:
        if (r5 != 2) goto L20;
        r2.d(r1);
        return;
    L20:
        return;
    L17:
        ALogger.e("GestureDetectEvent", "registerBehaviorEvents fail for null behavior or mGestureDetectLayout.");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Cq(float r2, float r3) {
        if (r2 <= 0) goto L8;
        jo1.e r4 = Eq();
        if (r4 == null) goto L9;
        r4.da(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean br(MotionEvent r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "e");
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L7;
        IAbilityCenter r4 = r3.a();
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r5 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r4.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L8:
        if (r5 == null) goto L12;
        r5.f7();
        return true;
    L12:
        return true;
    L7:
        r5 = null;
        goto L8
    }

    public final boolean jr(float r7, float r8) {
        View r9 = Gq();
        Room r0 = getRoom();
        RoomContext r1 = Iq();
        if (r9 != null) goto L5;
        return false;
    L5:
        boolean r3 = RTLUtil.isAppRTL(getContext());
        if (r3 == true) goto L8;
    L9:
        if (r3 == false) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == true) goto L22;
    L57:
        return false;
    L22:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == false) goto L57;
        if (r0 == null) goto L57;
        if (r0.isMediaRoom() == true) goto L57;
        if (isAnchor() == true) goto L57;
        if (r0.withAggregateColumn == true) goto L57;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L34;
        r2.Wl();
    L34:
        if (p0.b(getRoom()) == false) goto L57;
        if (A.contains(c0.b().getReqFrom()) == false) goto L40;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L57;
    L40:
        if (r9.getTranslationX() != 0.0f) goto L57;
        if (Math.abs(r7) < 100) goto L57;
        Intrinsics.checkNotNull(r1);
        if (((Boolean) r1.isLandscapeLock().getValue()).booleanValue() == true) goto L57;
        RoomContext r10 = Iq();
        if (r10 == null) goto L54;
        com.bytedance.live.datacontext.n r11 = r10.getExternalConfigJudger();
        if (r11 == null) goto L54;
        IExternalConfigJudger r12 = (IExternalConfigJudger) r11.getValue();
        if (r12 == null) goto L54;
        if (r12.disable(EXTERNAL_CONFIG_TYPE.Gesture, "leftScroll") != true) goto L54;
        boolean r13 = true;
    L55:
        if (r13 == true) goto L57;
        Bundle r14 = new Bundle();
        r14.putString("pull_type", "draw");
        xs2.b.a().post(new LogEvent("draw"));
        ut1.j.g(getActivity(), true, r14, ((Widget) this).dataCenter, 16);
        pg1.b.b();
    L54:
        r13 = false;
        goto L55
    L17:
        if (r9.getTranslationX() != 0.0f) goto L19;
        r5 = true;
        goto L20
    L11:
        if (r7 <= 0) goto L13;
    L12:
        r4 = true;
        goto L15
    L8:
        if (r7 < 0) goto L12;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean Zq(MotionEvent r7, MotionEvent r8, float r9, float r10) {
        if (r7 == null) goto L21;
        if (r8 == null) goto L21;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        boolean r4 = true;
        Logger.d("GestureWidget", String.format("onFling, Event1={%f, %f}, Event2={%f, %f}, deltaX=%f, deltaY=%f, velocityX=%f, velocityY=%f", Arrays.copyOf(new Object[]{Float.valueOf(r7.getX()), Float.valueOf(r7.getY()), Float.valueOf(r8.getX()), Float.valueOf(r8.getY()), Float.valueOf(r7.getX() - r8.getX()), Float.valueOf(r7.getY() - r8.getY()), Float.valueOf(r9), Float.valueOf(r10)}, 8)));
        float r2 = r8.getX() - r7.getX();
        float r11 = r8.getY() - r7.getY();
        float r3 = 100;
        if (Math.abs(r2) >= r3) goto L9;
    L11:
        boolean r12 = false;
    L13:
        if (Math.abs(r11) >= r3) goto L15;
    L17:
        r4 = false;
    L18:
        Logger.d("GestureWidget", "onFling" + r2 + r11 + r12 + r4);
        if (r12 == false) goto L21;
        jr(r2, r9);
        goto L21
    L15:
        if (Math.abs(r10) < r3) goto L17;
    L9:
        if (Math.abs(r9) < r3) goto L11;
        r12 = true;
    L21:
        return false;
    }
}
