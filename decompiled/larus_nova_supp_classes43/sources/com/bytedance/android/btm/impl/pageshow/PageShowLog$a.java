package com.bytedance.android.btm.impl.pageshow;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.k;
import com.bytedance.android.btm.impl.b;
import com.bytedance.android.btm.impl.event.d;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PageShowLog$a implements Runnable {
    public final /* synthetic */ PageInfo a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;

    public PageShowLog$a(PageInfo r1, long r10, boolean r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void a() {
        final JSONObject r0 = PageShowLog.e.e(this.a, this.b, this.c);
        ALogger.d(ALogger.d, "pageShow", new PageShowLog$sendSync$1(r0));
        if (r0.has("offset_duration") == true) goto L7;
        long r10 = r0.optLong("enter_time", 0);
        if (r10 <= 0) goto L7;
        r0.put("offset_duration", System.currentTimeMillis() - r10);
    L7:
        k r1 = new k("btm_page_show", r0);
        b.e.a().onEventV3(r1);
        BtmHostDependManager r11 = BtmHostDependManager.F;
        r11.getClass();
        if (((Boolean) BtmHostDependManager.r.getValue(r11, BtmHostDependManager.a[16])).booleanValue() == true) goto L10;
        int r12 = d.a;
    L10:
        int r13 = com.bytedance.android.btm.impl.pageshow.checker.a.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
