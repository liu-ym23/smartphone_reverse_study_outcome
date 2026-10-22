package af0;

import bb0.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdk.config.tz;
import com.bytedance.android.livesdk.log.j0;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nd0.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends BaseMonitor {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static /* synthetic */ void m(LinkMonitorData r1) {
        l(r1, new JSONObject());
    }

    @JvmStatic
    public static final void l(LinkMonitorData r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "extra");
        c.p(c.a, r10, r11, MultiLinkEventModule.HAMLET_AVATAR, 0, null, false, null, 120);
        String r0 = "businessName:" + r10.getEventTypeValue() + ", extra:" + r11;
        ALogger.i(b.b(), "HamletAvatarFullMonitor :" + r0 + ", invoke class :" + a.class.getSimpleName());
        if (((Boolean) tz.a.getValue()).booleanValue() == false) goto L19;
        j0 r1 = j0.l();
        String r12 = r10.getEventTypeValue();
        Intrinsics.checkNotNullParameter(r11, "$this$toAnyMap");
        HashMap r2 = new HashMap();
        Iterator<String> r3 = r11.keys();
    L6:
        if (r3.hasNext() == false) goto L11;
        String r4 = r3.next();
        Object r5 = r11.get(r4);
        if ((r5 instanceof String) == true) goto L9;
        r2.put(r4, r5.toString());
        goto L6
    L9:
        r2.put(r4, r5);
        goto L6
    L11:
        r1.sendLog(r12, r2, new Object[0]);
        return;
    }
}
