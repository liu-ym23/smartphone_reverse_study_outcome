package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.ur;
import com.bytedance.android.livesdk.config.vs;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.eventbus.LogEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/DrawerServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljo1/e;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerServiceWidget extends MiddlewareRoomWidget implements jo1.e {
    public final List<String> a;
    public final int b;
    public final int c;
    public final int d;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public DrawerServiceWidget() {
        this.a = CollectionsKt.mutableListOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        this.b = 100;
        this.c = 1;
        this.d = 1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L6;
        ho1.a.p(r0, jo1.e.class, this);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L6;
        ho1.a.q(r0, jo1.e.class);
        return;
    }

    @Override // jo1.e
    public final void da(float r6) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        if (r0 == null) goto L5;
        r0.Wl();
    L5:
        DataContext r1 = this.dataContext;
        FragmentActivity r2 = null;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r1, "$this$getRoomDataCtxExt");
        com.bytedance.android.livesdk.chatroom.o r3 = z51.a.g(r1);
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        if (com.bytedance.android.livesdk.chatroom.utils.p0.b(r5) == true) goto L16;
        return;
    L16:
        if (this.a.contains(com.bytedance.android.livesdk.chatroom.c0.b().getReqFrom()) == false) goto L20;
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L20;
        return;
    L20:
        if (r6 != 0.0f) goto L28;
        Bundle r7 = new Bundle();
        r7.putString("pull_type", "draw");
        r7.putBoolean("bundle_extra_direct_expend_drawer", true);
        xs2.b.a().post(new LogEvent("draw"));
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = ho1.a.d(getComponentContext());
        if (r8 == null) goto L24;
        r2 = r8.p0();
    L24:
        ut1.j.g(r2, true, r7, ((Widget) this).dataCenter, 16);
        return;
    L28:
        return;
    L12:
        r5 = null;
        goto L14
    }

    @Override // jo1.e
    public final boolean Uf(float r16, boolean r17, float r18) {
        if (r17 == false) goto L5;
    L7:
        boolean r4 = false;
    L8:
        FragmentActivity r5 = null;
        if (r4 == true) goto L18;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r6 = ho1.a.d(getComponentContext());
        if (r6 == null) goto L13;
        Boolean r7 = Boolean.valueOf(r6.dg());
    L15:
        if (wt2.a.b(r7) == true) goto L17;
    L77:
        return false;
    L17:
        if (ClearScreenHelper.a() == true) goto L77;
    L13:
        r7 = null;
    L18:
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r9 = RoomContext.a.c(r8, ((Widget) this).dataCenter, 0, 2);
        if (r9 != null) goto L22;
    L75:
        boolean r10 = false;
    L76:
        if (r10 == true) goto L77;
        if (r4 == true) goto L80;
    L134:
        return false;
    L80:
        if (ClearScreenHelper.a() == false) goto L86;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L86;
        RoomContext r12 = RoomContext.a.c(r8, r11, 0, 2);
        Intrinsics.checkNotNull(r12);
        if (((Boolean) r12.isMultiTabRoom().getValue()).booleanValue() == false) goto L86;
        return false;
    L86:
        MiddlewareRoomContext r13 = getMiddlewareRoomContext();
        if ((r13 instanceof RoomContext) == true) goto L89;
        r13 = null;
    L89:
        RoomContext r14 = (RoomContext) r13;
        if (r14 == null) goto L92;
        com.bytedance.live.datacontext.n r15 = r14.getExternalConfigJudger();
    L93:
        if (r15 == null) goto L99;
        IExternalConfigJudger r19 = (IExternalConfigJudger) r15.getValue();
        if (r19 == null) goto L99;
        if (r19.disable(EXTERNAL_CONFIG_TYPE.Gesture, "leftScroll") != true) goto L99;
        return false;
    L99:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r20 = ho1.a.d(getComponentContext());
        if (r20 == null) goto L102;
        r20.Wl();
    L102:
        DataContext r21 = this.dataContext;
        if (r21 == null) goto L109;
        Intrinsics.checkNotNullParameter(r21, "$this$getRoomDataCtxExt");
        com.bytedance.android.livesdk.chatroom.o r22 = z51.a.g(r21);
        if (r22 == null) goto L109;
        com.bytedance.live.datacontext.m r23 = r22.getRoom();
        if (r23 == null) goto L109;
        IRoom r24 = (IRoom) r23.getValue();
    L111:
        if (com.bytedance.android.livesdk.chatroom.utils.p0.b(r24) == false) goto L134;
        if (this.a.contains(com.bytedance.android.livesdk.chatroom.c0.b().getReqFrom()) == false) goto L117;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L134;
    L117:
        if (r16 != 0.0f) goto L134;
        if (Math.abs(r18) < this.b) goto L134;
        Bundle r1 = new Bundle();
        r1.putString("pull_type", "draw");
        xs2.b.a().post(new LogEvent("draw"));
        if (vs.a.getValue().booleanValue() == true) goto L123;
    L130:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r25 = ho1.a.d(getComponentContext());
        if (r25 == null) goto L133;
        r5 = r25.p0();
    L133:
        ut1.j.g(r5, true, r1, ((Widget) this).dataCenter, 16);
        pg1.b.b();
        goto L134
    L123:
        if (ur.a.getValue().booleanValue() == false) goto L130;
        DataCenter r26 = ((Widget) this).dataCenter;
        if (r26 == null) goto L130;
        Float r27 = (Float) r26.get("data_video_scale_value", Float.valueOf(-1.0f));
        if (r27.floatValue() <= 1.0f) goto L130;
        Logger.d("DrawerServiceWidget", "scale value = " + r27);
        return true;
    L109:
        r24 = null;
        goto L111
    L92:
        r15 = null;
        goto L93
    L22:
        if (((Room) r9.getRoom().getValue()).isVrRoom() == true) goto L48;
        DataCenter r28 = ((Widget) this).dataCenter;
        if (r28 == null) goto L40;
        ym0.a r29 = (ym0.a) r28.get("cmd_current_camera_info", null);
        if (r29 == null) goto L40;
        if (r29.c() != this.c) goto L32;
        boolean r110 = true;
    L34:
        if (r29.d() != this.d) goto L36;
        boolean r30 = true;
    L37:
        if (r30 == true) goto L40;
        if (r110 == false) goto L40;
        boolean r31 = true;
    L41:
        if (r31 == true) goto L48;
        if (pm1.f.l() == null) goto L47;
        nm1.m r32 = pm1.f.l();
        Intrinsics.checkNotNull(r32);
        if (r32.J(((Widget) this).dataCenter) == true) goto L48;
    L47:
        boolean r33 = false;
    L49:
        if (r33 == false) goto L75;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r111 = LiveVrContext.c.a();
        if (r111 == null) goto L75;
        boolean r112 = ((Boolean) r111.isVrSensorOpen().getValue()).booleanValue();
        DataCenter r113 = ((Widget) this).dataCenter;
        if (r113 != null) goto L57;
    L59:
        boolean r114 = false;
    L61:
        if (SettingKeyUtils.d() == true) goto L63;
    L65:
        boolean r115 = false;
    L66:
        if (r115 == false) goto L69;
        if (r114 == true) goto L69;
        boolean r116 = true;
    L70:
        if (r33 == false) goto L75;
        if (r112 == false) goto L73;
        if (r115 == false) goto L75;
    L73:
        if (r116 == true) goto L75;
        r10 = true;
    L69:
        r116 = false;
        goto L70
    L63:
        if (SettingKeyUtils.c() == false) goto L65;
        r115 = true;
        goto L66
    L57:
        if (((Boolean) r113.get("data_hide_screen", Boolean.FALSE)).booleanValue() == false) goto L59;
        r114 = true;
        goto L61
    L36:
        r30 = false;
        goto L37
    L32:
        r110 = false;
    L40:
        r31 = false;
    L48:
        r33 = true;
        goto L49
    L5:
        if (r16 != 0.0f) goto L7;
        r4 = true;
        goto L8
    }
}
