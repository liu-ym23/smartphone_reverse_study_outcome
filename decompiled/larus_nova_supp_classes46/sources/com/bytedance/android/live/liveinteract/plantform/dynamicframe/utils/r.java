package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.livesdk.config.l51;
import com.bytedance.android.livesdk.config.wp;
import com.bytedance.android.livesdk.config.y50;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r {
    public static final boolean a = false;

    public r() {
    }

    static {
        boolean r1 = true;
        if (vm2.d.d0().j() == true) goto L6;
        r1 = false;
    L6:
        a = r1;
    }

    public static boolean k() {
        com.bytedance.android.livesdk.gecko.n r0 = com.bytedance.android.livesdk.gecko.n.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        LiveResourcesDistributionImpl r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        com.bytedance.android.livesdk.gecko.j r2 = r1.a;
        if (r2 == null) goto L5;
        Long r3 = r2.c();
    L7:
        if (r3 == null) goto L9;
        long r4 = r3.longValue();
    L11:
        if (r4 > 0) goto L13;
        return true;
    L13:
        if (r4 >= vm2.d.d0().h()) goto L18;
        return false;
    L18:
        return true;
    L9:
        r4 = 0;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public static boolean l() {
        return ((Boolean) vm2.d.T7.getValue(null, vm2.d.a[458(0x1ca, float:6.42E-43)])).booleanValue();
    }

    public static String c() {
        l51 r0 = vm2.d.d0().k();
        if (r0 == null) goto L5;
        String r1 = r0.a();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        return "sslocal://webcast_lynxview";
    L15:
        return r1;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static String d() {
        l51 r0 = vm2.d.d0().k();
        if (r0 == null) goto L5;
        String r1 = r0.b();
    L6:
        if (r1 != null) goto L8;
    L12:
        r1 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_linkmic_dynamic_lynx_saas/pages/render_widget/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L13:
        String r2 = (String) y50.a.getValue();
        if (r2.a(r2) == false) goto L17;
        r1 = "http://" + r2 + ":60001/pages/render_widget/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L17:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L19;
        return r1;
    L19:
        return r1 + "&enable_debug=true";
    L8:
        if (r1.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static String e() {
        List r0 = vm2.d.d0().l();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        String r2 = "";
    L8:
        if (r2 != null) goto L10;
    L14:
        return "sslocal://webcast_lynxview";
    L10:
        if (r2.length() == 0) goto L13;
        r1 = false;
    L13:
        if (r1 == true) goto L14;
        return r2;
    L5:
        if ((!r0.isEmpty()) == false) goto L7;
        r2 = ((l51) ListProtector.get(r0, 0)).a();
        goto L8
    }

    public static String f() {
        List r0 = vm2.d.d0().l();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        String r2 = "";
    L8:
        if (r2 != null) goto L10;
    L14:
        r2 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_linkmic_dynamic_lynx_saas/pages/root_widget/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L15:
        String r3 = (String) y50.a.getValue();
        if (r2.a(r3) == false) goto L19;
        r2 = "http://" + r3 + ":60001/pages/logic_widget/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L19:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L21;
        return r2;
    L21:
        return r2 + "&enable_debug=true";
    L10:
        if (r2.length() == 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
    L5:
        if ((!r0.isEmpty()) == false) goto L7;
        r2 = ((l51) ListProtector.get(r0, 0)).b();
        goto L8
    }

    public static boolean h() {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.d.d0().b() != true) goto L7;
        return true;
    }

    public static boolean m() {
        return vm2.d.d0().g();
    }

    public static List b(int r1) {
        if (k() == false) goto L12;
        if (r1 == 0) goto L13;
        if (com.bytedance.android.live.liveinteract.utils.h.e(r1) == true) goto L13;
        if (vm2.d.d0().i() == false) goto L12;
    L13:
        return vm2.d.d0().d();
    L12:
        return CollectionsKt.emptyList();
    }

    public static boolean i(int r1) {
        if (vm2.d.d0().c() == false) goto L12;
        if (r1 == 0) goto L10;
        if (com.bytedance.android.live.liveinteract.utils.h.e(r1) == true) goto L10;
        if (vm2.d.d0().i() == false) goto L12;
    L10:
        if (k() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean a(Integer r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = je0.d.h();
    L6:
        if (j(r2, 0, 4) == true) goto L8;
    L10:
        return false;
    L8:
        if (((Boolean) wp.a.getValue()).booleanValue() == false) goto L10;
        return true;
    }

    public static boolean g(String r1, DynamicUpdateType r2) {
        Intrinsics.checkNotNullParameter(r1, "bizId");
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicUpdateType.TEAM_FIGHT) goto L5;
    L13:
        return true;
    L5:
        if (r2 == DynamicUpdateType.ROOM_BATTLE) goto L13;
        if (r1.hashCode() != (-1785657516)) goto L13;
        if (r1.equals("party_ktv") == false) goto L13;
        return false;
    }

    public static /* synthetic */ boolean j(Integer r0, int r1, int r2) {
        if ((r2 & 1) == 0) goto L6;
        je0.d.h();
    L6:
        if ((r2 & 2) == 0) goto L9;
        r1 = 0;
    L9:
        if ((r2 & 4) == 0) goto L14;
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L14;
        IRoom r4 = (IRoom) r3.getValue();
    L14:
        return i(r1);
    }
}
