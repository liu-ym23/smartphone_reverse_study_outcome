package tl0;

import android.net.Uri;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.lynx.c;
import com.bytedance.android.live.lynx.monitor.LynxMonitor;
import com.bytedance.android.livesdk.config.v3;
import com.bytedance.android.livesdk.config.w3;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final Map<String, LynxGroup> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(LynxViewBuilder r8, String r9, String r10) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(r8, "$this$setupLynxGroup");
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r10, "containerId");
        boolean r2 = false;
        if (((Boolean) w3.a.getValue()).booleanValue() == true) goto L5;
    L13:
        boolean r1 = LynxMonitor.a;
        Intrinsics.checkNotNullParameter(r9, "url");
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_business_type_not_specified", 0, MapsKt.mapOf(TuplesKt.to("url", r9)));
        String r11 = "unspecified-" + r10;
    L14:
        if (r2 == false) goto L24;
        LinkedHashMap r12 = (LinkedHashMap) a;
        Object r0 = r12.get(r11);
        if (r0 != null) goto L23;
        com.bytedance.android.live.lynx.a r3 = (com.bytedance.android.live.lynx.a) c.a(com.bytedance.android.live.lynx.a.class);
        if (r3 == null) goto L21;
        r0 = r3.e(r11, null, false, true, false, -1);
        if (r0 == null) goto L21;
    L22:
        r12.put(r11, r0);
    L21:
        r0 = LynxGroup.Create(r11, null);
    L23:
        r8.setLynxGroup((LynxGroup) r0);
        return;
    L24:
        com.bytedance.android.live.lynx.a r4 = (com.bytedance.android.live.lynx.a) c.a(com.bytedance.android.live.lynx.a.class);
        if (r4 == null) goto L28;
        LynxGroup r13 = r4.e(r11, null, false, true, false, -1);
        if (r13 == null) goto L28;
    L29:
        r8.setLynxGroup(r13);
        return;
    L28:
        r13 = LynxGroup.Create(r11, null);
        goto L29
    L5:
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        Uri r14 = UriProtector.parse(r9);
        if (r14 == null) goto L9;
        r11 = UriProtector.getQueryParameter(r14, "business_type");
    L10:
        if (r11 == null) goto L12;
        r2 = ((Boolean) v3.a.getValue()).booleanValue();
        goto L14
    L12:
        r11 = "unspecified-" + r10;
        goto L14
    L9:
        r11 = null;
        goto L10
    }
}
