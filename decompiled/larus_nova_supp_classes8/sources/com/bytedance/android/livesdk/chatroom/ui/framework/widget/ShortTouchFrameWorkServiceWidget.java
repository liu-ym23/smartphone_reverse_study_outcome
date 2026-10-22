package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.PopularCardIconModel;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ShortTouchFrameWorkServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchFrameWorkServiceWidget extends MiddlewareRoomWidget {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        this.a = r0;
        ViewGroup r2 = null;
        if (this.dataContext == null) goto L33;
        if (r0 == null) goto L6;
        boolean r1 = r0.dg();
    L7:
        if (r1 == false) goto L33;
        DataContext r3 = this.dataContext;
        if ((r3 instanceof RoomContext) == true) goto L11;
        r3 = null;
    L11:
        RoomContext r4 = (RoomContext) r3;
        if (r4 == null) goto L16;
        com.bytedance.live.datacontext.j r5 = r4.getShortTermIconFramework();
        if (r5 == null) goto L16;
        IShortTermIconFramework r6 = (IShortTermIconFramework) r5.getValue();
    L18:
        if (tb1.c.c == false) goto L33;
        DataContext r7 = this.dataContext;
        if ((r7 instanceof RoomContext) == true) goto L22;
        r7 = null;
    L22:
        RoomContext r8 = (RoomContext) r7;
        if (r8 == null) goto L30;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L30;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L30;
        if (r10.isStar() == true) goto L33;
    L30:
        if (r6 == null) goto L33;
        r6.load(PopularCardIconModel.class);
    L16:
        r6 = null;
        goto L18
    L6:
        r1 = false;
    L33:
        if (SettingUtil.isLocalTest() == false) goto L82;
        h70.b r11 = getComponentContext();
        if ((r11 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L37;
        r11 = null;
    L37:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r12 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r11;
        if (r12 == null) goto L83;
        DataCenter r13 = ((d90.d) r12).h;
        if (r13 == null) goto L85;
        h70.b r14 = getComponentContext();
        if ((r14 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L45;
        r14 = null;
    L45:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r15 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r14;
        if (r15 == null) goto L84;
        MiddlewareRoomContext r16 = d90.e.l(r15);
        if (r16 == null) goto L86;
        h70.b r17 = getComponentContext();
        if (r17 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r18 = ho1.a.i(r17);
        if (r18 == null) goto L55;
        View r19 = r18.Fo();
    L57:
        if ((r19 instanceof ViewGroup) == true) goto L59;
        r19 = null;
    L59:
        ViewGroup r20 = (ViewGroup) r19;
        if (r20 == null) goto L87;
        h70.b r21 = getComponentContext();
        if (r21 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r22 = ho1.a.i(r21);
        if (r22 == null) goto L67;
        ViewGroup r23 = r22.Wa();
    L69:
        if ((r23 instanceof RelativeLayout) == false) goto L72;
        r2 = r23;
    L72:
        RelativeLayout r24 = (RelativeLayout) r2;
        if (r24 == null) goto L88;
        com.bytedance.android.livesdk.chatroom.indicator.shortterm.h.a(r13, r16, r20, this, r24);     // Catch: Exception -> L77
        return;
    L77:
        e = move-exception;
        e.printStackTrace();
        return;
    L88:
        return;
    L67:
        r23 = null;
        goto L69
    L87:
        return;
    L55:
        r19 = null;
        goto L57
    L86:
        return;
    L84:
        return;
    L85:
        return;
    L83:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
    }

    public ShortTouchFrameWorkServiceWidget() {
    }
}
