package com.bytedance.android.btm.impl.page;

import android.app.Activity;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PageWoods {
    public static final ConcurrentHashMap<f<Activity>, h> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static h a(final Object r10) {
        if ((r10 instanceof Activity) == true) goto L5;
        Activity r0 = d.a.getActivity(r10);
        if (r0 != null) goto L9;
        if (r10 == null) goto L14;
        ALogger.i(ALogger.d, "1108", false, new PageWoods$getTree$$inlined$apply$lambda$1(r10), 6);
        return null;
    L14:
        return null;
    L9:
        return a.get(new f(r0));
    L5:
        return a.get(new f(r10));
    }

    public static void b(h r10) {
        Object r0 = r10.c.a();
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L9;
        a.put(new f(r1), r10);
        return;
    }
}
