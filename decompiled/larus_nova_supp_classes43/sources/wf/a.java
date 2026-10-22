package wf;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.data.EntranceInfoReportConfig;
import com.bytedance.android.ec.core.data.EntranceInfoWriteConfig;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "entrance_info settings")
public final class a {
    public static EntranceInfoWriteConfig a;
    public static EntranceInfoReportConfig b;

    public static EntranceInfoWriteConfig c() {
        if (a != null) goto L5;
        a = ECSettingKeys.i0();
    L5:
        EntranceInfoWriteConfig r0 = a;
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new EntranceInfoWriteConfig(null, null, null, null, null, 31, null);
    }

    public static boolean a() {
        return Intrinsics.areEqual(c().getEnable(), Boolean.TRUE);
    }

    public static boolean b() {
        Integer r0 = ECSettingKeys.k0().getEnable();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() != 1) goto L17;
        HashSet<String> r1 = ECSettingKeys.k0().getWhiteList();
        if (r1 != null) goto L10;
    L13:
        boolean r10 = true;
    L14:
        if (r10 == true) goto L18;
        return true;
    L18:
        return false;
    L10:
        if (r1.isEmpty() == true) goto L13;
        r10 = false;
        goto L14
    L17:
        return false;
    }

    static {
    }
}
