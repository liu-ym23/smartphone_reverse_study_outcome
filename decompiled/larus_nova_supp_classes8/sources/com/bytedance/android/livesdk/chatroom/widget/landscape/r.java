package com.bytedance.android.livesdk.chatroom.widget.landscape;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements ILandscapeSpiltManager {
    public static final /* synthetic */ int l = 0;
    public final View a;
    public final View b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final View f;
    public final PropertyOwner<ILandscapeSpiltManager.State> g;
    public final PropertyOwner h;
    public final View i;
    public final View j;
    public final View k;

    public static final class a {
    }

    static {
    }

    public static void a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.n r1 = r0.getLandscapeSpiltManager();
        if (r1 == null) goto L9;
        r1.setValue(null);
        return;
    L9:
        return;
    }

    public static boolean b() {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.j r6 = r5.getDataCenter2();
        if (r6 == null) goto L7;
        DataCenter r7 = (DataCenter) r6.getValue();
    L9:
        if (VrUtils.t(r7, true) == false) goto L19;
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L19;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L19;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L19;
        if (r3.isMediaRoom() != true) goto L19;
        return true;
    L19:
        return false;
    L7:
        r7 = null;
        goto L9
    }

    private final Context getContext() {
        return this.k.getContext();
    }

    public final void g() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n r1 = r0.getLandscapeSpiltManager();
        if (r1 == null) goto L7;
        r1.setValue(this);
    L7:
        this.c.addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r2 = this.c;
        View r3 = this.b;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(s1.j(2131168866), -1);
        r4.gravity = 5;
        Unit r5 = Unit.INSTANCE;
        r2.addView(r3, r4);
        View r6 = this.k;
        if (r6 == null) goto L11;
        r6.setFitsSystemWindows(false);
        return;
    }

    public final PropertyOwner getState() {
        return this.h;
    }

    public r(View r10) {
        Intrinsics.checkNotNullParameter(r10, "interactionRootView");
        this.k = r10;
        View r1 = null;
        View r11 = LayoutInflater.from(getContext()).inflate(2131566564, null);
        this.a = r11;
        View r0 = LayoutInflater.from(getContext()).inflate(2131566563, null);
        this.b = r0;
        this.c = (FrameLayout) r11.findViewById(2131387104);
        this.d = (FrameLayout) r0.findViewById(2131387102);
        this.e = (FrameLayout) r0.findViewById(2131387099);
        this.f = r0.findViewById(2131387101);
        PropertyOwner<ILandscapeSpiltManager.State> r2 = new PropertyOwner(ILandscapeSpiltManager.State.HIDE);
        this.g = r2;
        this.h = r2;
        View r3 = r11.findViewById(2131378467);
        int r5 = 8;
        if (r3 == null) goto L20;
        nm1.s r8 = pm1.f.p();
        if (r8 == null) goto L8;
        r8.h();
        r3.setBackgroundResource(2131253416);
    L8:
        if (b() == false) goto L18;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L15;
        com.bytedance.live.datacontext.n r12 = r9.getDataCenter();
        if (r12 == null) goto L15;
        DataCenter r13 = (DataCenter) r12.getValue();
    L15:
        if (VrUtils.s() == true) goto L18;
        int r14 = 0;
    L19:
        r3.setVisibility(r14);
        Unit r15 = Unit.INSTANCE;
    L21:
        this.i = r3;
        View r16 = r11.findViewById(2131378465);
        if (r16 == null) goto L38;
        nm1.s r4 = pm1.f.p();
        if (r4 == null) goto L27;
        r4.h();
        r16.setBackgroundResource(2131253416);
    L27:
        if (b() == false) goto L37;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L34;
        com.bytedance.live.datacontext.n r7 = r6.getDataCenter();
        if (r7 == null) goto L34;
        DataCenter r17 = (DataCenter) r7.getValue();
    L34:
        if (VrUtils.s() == true) goto L37;
        r5 = 0;
    L37:
        r16.setVisibility(r5);
        Unit r18 = Unit.INSTANCE;
        r1 = r16;
    L38:
        this.j = r1;
        return;
    L18:
        r14 = 8;
        goto L19
    L20:
        r3 = null;
        goto L21
    }

    public static void f(boolean r4) {
        if (r4 == false) goto L5;
        HashMap r5 = new HashMap();
        j0.l().sendLog("livesdk_landscape_pannel_show", r5, new Object[]{new x(), IRoom.class});
        return;
    }

    public final void c(ILandscapeSpiltManager.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.g.a(r2);
    }

    public final void e(int r3) {
        UIUtils.updateLayoutMargin(this.k, -3, -3, r3, -3);
    }

    public final void d(int r3, int r4) {
        UIUtils.updateLayoutMargin(this.k, r3, -3, r4, -3);
    }
}
