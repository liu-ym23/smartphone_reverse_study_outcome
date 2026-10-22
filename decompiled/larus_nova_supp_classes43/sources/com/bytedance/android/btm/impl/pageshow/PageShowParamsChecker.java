package com.bytedance.android.btm.impl.pageshow;

import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PageShowParamsChecker {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(PageShowParamsChecker$btmFormatRegex$2.INSTANCE);
    }

    public static void a(int r12, String r13, PageInfo r14, Object r15) {
        BtmMonitor.k(BtmMonitor.c, r12, r13, r15, r14, true, false, null, false, null, null, 992);
    }
}
