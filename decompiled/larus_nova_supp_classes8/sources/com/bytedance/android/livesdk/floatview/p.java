package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.az0;
import com.bytedance.android.livesdk.config.ex;
import com.bytedance.android.livesdk.config.ld1;
import com.bytedance.android.livesdk.config.md1;
import com.bytedance.android.livesdk.config.q00;
import com.bytedance.android.livesdk.config.ve0;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p {
    public static boolean a;
    public static final boolean b = false;
    public static final List<String> c = null;
    public static boolean d;
    public static boolean e;
    public static boolean f;

    static {
        Boolean r0 = ex.a.getValue();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        b = r1;
        c = CollectionsKt.mutableListOf(new String[]{"ecom_order", "ecom_consulting", "ecom_product_detail"});
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static boolean a() {
        Integer r0 = q00.a.getValue();
        if (r0 == null) goto L9;
        if (r0.intValue() != 1) goto L9;
        return false;
    L9:
        if (((Number) LiveConfigSettingKeys.LIVE_SAAS_SMALL_WINDOW_ENABLE.getValue()).intValue() <= 0) goto L14;
        com.bytedance.android.livesdk.chatroom.c0.b().getClass();
        if (jc1.k.n(IHostAction.class).isGreyMode() == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public static boolean b() {
        if (ve0.a.getValue().booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (c() == false) goto L7;
    L8:
        return true;
    L7:
        if (e() == false) goto L9;
        goto L8
    }

    public static boolean c() {
        if (tb1.c.a == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == true) goto L7;
        return true;
    }

    public static boolean e() {
        if (tb1.c.a == true) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return false;
    L7:
        if (az0.a.getValue().booleanValue() == true) goto L9;
        return false;
    L9:
        if (jc1.a.b().getPackageManager().hasSystemFeature("android.software.picture_in_picture") == true) goto L11;
        return false;
    L11:
        if (d == false) goto L13;
    L18:
        boolean r0 = true;
    L19:
        if (r0 == false) goto L26;
        return true;
    L26:
        return false;
    L13:
        if (md1.a.getValue().booleanValue() == true) goto L15;
    L17:
        r0 = false;
        goto L19
    L15:
        if (ld1.a.getValue().contains(RomUtils.getName()) == true) goto L17;
        goto L17
    }

    public static boolean f() {
        if (e() == true) goto L5;
    L9:
        return false;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k0.getValue()).booleanValue() == false) goto L9;
        if (rx1.m.f(jc1.a.b()) == false) goto L9;
        return true;
    }

    public static boolean d(Context r1) {
        if (c() == true) goto L5;
    L9:
        return false;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k0.getValue()).booleanValue() == false) goto L9;
        if (rx1.m.e(r1) == false) goto L9;
        return true;
    }

    public static void g(Context r2) {
        e = true;
        String r0 = rx1.n.a;
        Intrinsics.checkNotNullParameter("91101698", "<set-?>");
        rx1.n.a = "91101698";
        rx1.n.b = b;
        rx1.m.h(r2);
    }

    public static void h(Context r2) {
        f = true;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        rx1.m.j(r2, "android.settings.PICTURE_IN_PICTURE_SETTINGS");
        return;
    L5:
        rx1.m.i(r2);
    }

    public static void i(FragmentActivity r1) {
        if (e() == false) goto L12;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.i0.getValue()).booleanValue() == false) goto L7;
    L23:
        boolean r0 = false;
    L24:
        if (r0 == false) goto L32;
        if (r1 == null) goto L32;
        if (r1.isFinishing() == true) goto L32;
        j(r1);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        if (r1 != null) goto L34;
        return;
    L34:
        if (e5.f(r1.getRequestedOrientation()) == false) goto L40;
        d = x1.l(r1);
        return;
    L40:
        return;
    L7:
        if (a == false) goto L23;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k0.getValue()).booleanValue() == true) goto L23;
    L22:
        r0 = true;
        goto L24
    L12:
        if (c() == false) goto L23;
        if (ve0.a.getValue().booleanValue() == false) goto L23;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.i0.getValue()).booleanValue() == true) goto L23;
        if (a == false) goto L23;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k0.getValue()).booleanValue() == true) goto L23;
        goto L22
    }

    public static void j(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        o r0 = new o(r3);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r0);
    L7:
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.i0;
        Boolean r1 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r1);
        Lazy r5 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        am2.x r2 = new am2.x();
        r2.a = "live_view";
        r2.b = "live_detail";
        r6.sendLog("mini_window_guide_show", null, new Object[]{r2, Room.class});
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L7
    }
}
