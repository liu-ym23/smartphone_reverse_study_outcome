package com.larus.drive.biz.impl.view.space;

import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.service.n0;
import com.larus.platform.service.z2;
import hq9.d2;
import hq9.e2;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static OfficeSpaceConfig a(boolean r24) {
        d2 r0 = z2.a.getLarkDriveConfigV2();
        OfficeSpaceTab r3 = OfficeSpaceTab.RECENT;
        boolean r5 = true;
        Set r4 = SetsKt.mutableSetOf(new OfficeSpaceTab[]{r3, OfficeSpaceTab.MINE});
        if (n0.a.b() == false) goto L5;
        r4.add(OfficeSpaceTab.SHARED);
    L5:
        r4.add(OfficeSpaceTab.FAVORITE);
        OfficeSpaceHeaderConfig r14 = new OfficeSpaceHeaderConfig(r24, false, false, 6, null);
        Integer r8 = r0.d();
        if (r8 != null) goto L8;
    L13:
        Integer r21 = null;
    L14:
        OfficeListConfig r9 = new OfficeListConfig(null, false, true, true, null, r21, 19, null);
        Gson r6 = new Gson();
        e2 r1 = r0.b();
        if (r1 != null) goto L18;
        r1 = new e2(0);
    L18:
        return new OfficeSpaceConfig(r3, r4, false, false, false, r14, r9, GsonProtectorUtils.toJson(r6, MapsKt.mapOf(TuplesKt.to("menu_config", r1))), 28, null);
    L8:
        if (r8.intValue() >= 0) goto L11;
        r5 = false;
    L11:
        if (r5 == false) goto L13;
        r21 = r8;
        goto L14
    }
}
