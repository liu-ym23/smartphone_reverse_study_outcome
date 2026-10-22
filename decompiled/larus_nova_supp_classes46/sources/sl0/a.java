package sl0;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.g91;
import com.bytedance.android.monitor.lynx.LynxMonitor;
import com.bytedance.android.monitor.webview.g;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.lynx.tasm.LynxView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final boolean a = false;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
    }

    public final void b(LynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        if (a == false) goto L5;
        pz2.a r0 = new pz2.a("", new com.bytedance.android.monitorV2.webview.a());
        r0.b = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG().e();
        r0.e = "2021";
        com.bytedance.android.monitorV2.lynx_helper.b.a(r5, r0);
        return;
    L5:
        uy2.b r1 = new uy2.b(new g());
        g91 r2 = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
        r1.b = r2.e();
        r1.c = r2.d();
        r1.d = r2.a();
        r1.e = r2.c();
        r1.f = r2.b();
        r1.h = "2021";
        int r3 = yy2.a.a;
        if (r1.b == false) goto L10;
        ((WeakHashMap) LynxMonitor.j.a.a).put(r5, r1);
        r5.addLynxViewClient(new yy2.b(r5));
        return;
    }

    public final void a(LynxView r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        Intrinsics.checkNotNullParameter(r5, "paramsMap");
        if (a == false) goto L8;
        Iterator r6 = ((HashMap) r5).entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) r6.next();
        LynxViewMonitor r1 = LynxViewMonitor.b;
        String r2 = (String) r0.getKey();
        String r3 = r0.getValue().toString();
        r1.getClass();
        LynxViewMonitor.g(r4, r2, r3);
        goto L6
    L12:
        return;
    L8:
        Iterator r7 = ((HashMap) r5).entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r8 = (Map.Entry) r7.next();
        LynxMonitor.j.c(r4, (String) r8.getKey(), r8.getValue().toString());
        goto L10
    }
}
