package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends d implements f {
    public static final HashMap<String, CopyOnWriteArraySet<String>> b = null;
    public static final b c = null;

    @Override // z90.d
    public final <T> T getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return null;
    }

    static {
        b r0 = new b();
        c = r0;
        b = new HashMap();
        FeatureManager.u.getClass();
        Intrinsics.checkNotNullParameter(r0, FileUtils.FILTER);
        FeatureManager.m.add(r0);
    }

    public b() {
    }

    @Override // com.bytedance.android.live.impl.logfilter.d
    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "name");
        HashMap<String, CopyOnWriteArraySet<String>> r0 = b;
        if (r0.containsKey(r3) == true) goto L5;
        r0.put(r3, new CopyOnWriteArraySet());
    L5:
        CopyOnWriteArraySet<String> r5 = r0.get(r3);
        if (r5 == null) goto L9;
        r5.add(r4);
        return;
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r12, "params");
        CopyOnWriteArraySet<String> r0 = b.get(r11);
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        FeatureManager.u.i(r11 + "#" + r2, r12.get(r2), FeatureType.MONITOR);
    L8:
        FeatureManager.u.getClass();
        Map<String, z90.a.b> r13 = FeatureManager.l;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r14 = ((LinkedHashMap) r13).entrySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r14.next();
        if (StringsKt.split$default((CharSequence) r4.getKey(), new String[]{","}, false, 0, 6, null).contains(r11) == false) goto L10;
        r3.put(r4.getKey(), r4.getValue());
        goto L10
    L14:
        Iterator r15 = r3.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L19;
        ((z90.a.b) ((Map.Entry) r15.next()).getValue()).a(r11, null);
        goto L16
    L19:
        if (r11.hashCode() == (-773966155)) goto L22;
        return;
    L22:
        if (r11.equals("livesdk_live_leave") == false) goto L32;
        z90.a.C0301a.a(FeatureManager.u, "live_watch_count", 0);
        return;
    }
}
