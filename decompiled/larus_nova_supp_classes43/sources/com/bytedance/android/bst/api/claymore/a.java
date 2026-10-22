package com.bytedance.android.bst.api.claymore;

import com.bytedance.android.bst.api.ab.EmptyBstAbPageControlService;
import com.bytedance.android.bst.api.ab.IBstAbPageControl;
import com.bytedance.android.bst.api.inner.IBstMonitorService;
import com.bytedance.android.btm.api.bst.EmptyBstInnerService;
import com.bytedance.android.btm.api.bst.b;
import java.util.concurrent.CopyOnWriteArrayList;
import uc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static volatile boolean a;

    public static void a() {
        if (a == false) goto L5;
        return;
    L5:
        a = true;
        CopyOnWriteArrayList r0 = yc.a.a;
        yc.a.b(c.class, uc.a.class);
        yc.a.c(c.class, "com.bytedance.android.bst.impl.BstServiceImpl");
        yc.a.b(com.bytedance.android.btm.api.bst.a.class, tc.a.class);
        yc.a.c(com.bytedance.android.btm.api.bst.a.class, "com.bytedance.android.bst.devtools.BstDebugService");
        yc.a.b(IBstAbPageControl.class, EmptyBstAbPageControlService.class);
        yc.a.c(IBstAbPageControl.class, "com.bytedance.android.bst.impl.ab.BstAbPageControlService");
        yc.a.b(b.class, EmptyBstInnerService.class);
        yc.a.c(b.class, "com.bytedance.android.bst.impl.inner.BstInnerService");
        yc.a.b(IBstMonitorService.class, uc.b.class);
        yc.a.c(IBstMonitorService.class, "com.bytedance.android.bst.devtools.monitor.BstMonitorService");
    }

    static {
    }
}
