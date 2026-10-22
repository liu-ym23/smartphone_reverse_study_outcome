package com.bytedance.android.ec.core.monitor.param;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.b2;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECParamTrackerCenter {
    public static final Map<String, ECParamTracker> a = null;
    public static final Lazy b = null;

    public static ParamReportConfigSetting b() {
        return (ParamReportConfigSetting) b.getValue();
    }

    static {
        a = new ConcurrentHashMap();
        b = LazyKt.lazy(ECParamTrackerCenter$configSettings$2.INSTANCE);
    }

    public static void a(final String r1) {
        if (b().getEnable() == false) goto L14;
        if (r1 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L15;
        b2.b(new ECParamTrackerCenter$destroyTracker$1(r1));
        return;
    L15:
        return;
    L6:
        if (r1.length() == 0) goto L9;
        r0 = false;
        goto L10
    }

    public static a c(String r1) {
        if (b().getEnable() == false) goto L14;
        if (r1 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        return null;
    L13:
        return (a) ((ConcurrentHashMap) a).get(r1);
    L6:
        if (r1.length() == 0) goto L9;
        r0 = false;
        goto L10
    L14:
        return null;
    }

    public static void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        if (b().getEnable() == false) goto L23;
        if (r11 == null) goto L24;
        ConcurrentHashMap r0 = (ConcurrentHashMap) a;
        ECParamTracker r1 = (ECParamTracker) r0.get(r11);
        if (r1 == null) goto L16;
        String r12 = r1.e;
        if (r12 == null) goto L16;
        String r13 = a2.d(r12);
        if (r13 == null) goto L16;
        if (Intrinsics.areEqual(r13, r10) == false) goto L16;
        a r14 = (a) r0.get(r11);
        return;
    L16:
        r0.put(r11, new ECParamTracker(r10, r11, b()));
        if (b().getEnableSchemaDiff() == false) goto L21;
        ECParamTracker r15 = (ECParamTracker) r0.get(r11);
        if (r15 == null) goto L21;
        kh.b r16 = new kh.b(r10);
        Intrinsics.checkNotNullParameter(r16, "listener");
        ((ArrayList) r15.d).add(r16);
    L21:
        a r17 = (a) r0.get(r11);
        return;
    L24:
        return;
    }
}
