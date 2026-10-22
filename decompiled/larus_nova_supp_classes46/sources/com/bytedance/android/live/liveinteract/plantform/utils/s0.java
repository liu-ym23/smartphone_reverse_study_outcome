package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.m60;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean b() {
        if (((Boolean) vm2.d.u6.getValue(null, vm2.d.a[382(0x17e, float:5.35E-43)])).booleanValue() == true) goto L7;
        return false;
    L7:
        return true;
    }

    static {
    }

    @JvmStatic
    public static final boolean a(IRoom r6) {
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        boolean r0 = tb1.d.a;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L30;
        if (r1.getCurrentScene() != 4) goto L30;
        if (((Number) vm2.d.e7.getValue(null, vm2.d.a[417(0x1a1, float:5.84E-43)])).intValue() == 1) goto L9;
        return false;
    L9:
        if (fj0.e.g(r6) == false) goto L18;
        cj0.c r7 = PaidLinkMicContext.Companion.a();
        if (r7 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L31;
        Integer r10 = (Integer) com.bytedance.android.livesdk.sharedpref.c.e1.getValue();
        if (r10 != null) goto L24;
    L25:
        boolean r11 = true;
    L27:
        if (r11 == true) goto L31;
        return false;
    L24:
        if (r10.intValue() != 0) goto L25;
        r11 = false;
    L31:
        return true;
    L13:
        if (r7.isIncreasePriceOn() != true) goto L15;
        r8 = true;
    L18:
        r9 = false;
    L30:
        if (((Number) vm2.d.e7.getValue(null, vm2.d.a[417(0x1a1, float:5.84E-43)])).intValue() == 1) goto L31;
        return false;
    }

    @JvmStatic
    public static final boolean c(boolean r3) {
        if (r3 == false) goto L6;
        return ((Boolean) vm2.d.i1.getValue(null, vm2.d.a[110(0x6e, float:1.54E-43)])).booleanValue();
    L6:
        return ((Boolean) vm2.d.j1.getValue(null, vm2.d.a[111(0x6f, float:1.56E-43)])).booleanValue();
    }

    @JvmStatic
    public static final boolean d(DataCenter r3) {
        if (r3 == null) goto L23;
        IRoom r4 = (IRoom) r3.get("data_room");
        if (r4 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r1 = r4.getLinkInitResult();
        if (r1 == null) goto L10;
        int r2 = r1.getUiLayout();
    L11:
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r5 = r4.getLinkInitResult();
        if (r5 == null) goto L14;
        int r6 = r5.getScene();
    L16:
        if (r6 == 8) goto L18;
        return false;
    L18:
        if (r2 != 102) goto L20;
    L21:
        return true;
    L20:
        if (r2 == 103) goto L21;
        return false;
    L14:
        r6 = 0;
        goto L16
    L10:
        r2 = 0;
        goto L11
    L26:
        return false;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean e(DataCenter r3) {
        if (r3 == null) goto L15;
        IRoom r1 = (IRoom) r3.get("data_room");
        if (r1 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual((Boolean) r3.get("data_is_anchor"), Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (r1.isLiveTypeAudio() != true) goto L12;
        return false;
    L12:
        if (vm2.d.r0() == false) goto L18;
        return true;
    L18:
        return false;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean f(DataCenter r4) {
        if (r4 == null) goto L19;
        IRoom r1 = (IRoom) r4.get("data_room");
        if (r1 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual((Boolean) r4.get("data_is_anchor"), Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (r1.isLiveTypeAudio() != true) goto L12;
        return false;
    L12:
        if (vm2.d.r0() == true) goto L14;
        return false;
    L14:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L16;
    L17:
        return true;
    L16:
        if (d(r4) == true) goto L17;
        return false;
    L19:
        return false;
    }

    @JvmStatic
    public static final boolean g(IRoom r3) {
        if (r3 != null) goto L5;
        r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
    L5:
        if (r3 == null) goto L7;
        String r4 = r3.getAnchorAbValue("linkmic_order_sing_upgrade");
    L9:
        if (Intrinsics.areEqual(r4, "1") == false) goto L11;
    L14:
        return true;
    L11:
        if (((Boolean) vm2.h.D0.getValue(null, vm2.h.a[80])).booleanValue() == true) goto L14;
        return false;
    L7:
        r4 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean h(DataCenter r2) {
        if (((Boolean) m60.a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r2 == null) goto L17;
        IRoom r3 = (IRoom) r2.get("data_room");
        if (r3 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r4 = r3.getLinkInitResult();
        if (r4 == null) goto L12;
        int r5 = r4.getUiLayout();
    L14:
        if (r5 != 7) goto L18;
        return true;
    L18:
        return false;
    L12:
        r5 = 0;
        goto L14
    L19:
        return false;
    L17:
        return false;
    }
}
