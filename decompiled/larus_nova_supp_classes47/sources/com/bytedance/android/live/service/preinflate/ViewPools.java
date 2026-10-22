package com.bytedance.android.live.service.preinflate;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ViewPools {
    public static final Map<FragmentActivity, a> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static a a(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Map<FragmentActivity, a> r0 = a;
        if (r0.containsKey(r4) == false) goto L5;
        Object r5 = ((LinkedHashMap) r0).get(r4);
        Intrinsics.checkNotNull(r5);
        return (a) r5;
    L5:
        ViewPool r1 = new ViewPool(r4);
        ALogger.i("NewUserProfile_PreLayout", "ViewPool init, context hashcode = " + r1.i.hashCode());
        r1.i.getLifecycle().addObserver(r1);
        r0.put(r4, r1);
        ViewPools$obtainViewPool$1 r6 = ViewPools$obtainViewPool$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "destroyAction");
        r1.f = r6;
        return r1;
    }
}
