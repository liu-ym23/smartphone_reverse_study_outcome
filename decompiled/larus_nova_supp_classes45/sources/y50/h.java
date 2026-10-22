package y50;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.mutableListOf(new String[]{"ttlive_network_apm", "tlive_setting_monitor", "widget_unload_data_center_null", "ttlive_audience_enter_room_full_new_all"});
    }

    @JvmStatic
    public static final boolean a(String r3) {
        if (r3 == null) goto L16;
        IHostMonitor r1 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r1 != null) goto L8;
        return true;
    L8:
        if (r1.isNotHitSampled(r3) == false) goto L10;
    L14:
        return true;
    L10:
        if (a.contains(r3) == false) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L14;
        return false;
    L12:
        r4 = false;
        goto L13
    L16:
        return false;
    }
}
