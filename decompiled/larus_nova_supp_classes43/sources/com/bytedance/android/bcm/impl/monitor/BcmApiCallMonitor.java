package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.impl.page.BtmPageFinder;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.thread.ThreadUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BcmApiCallMonitor {
    public static final ConcurrentHashMap<String, Integer> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r0, PageFinder r1, String r10, BcmParams r11) {
        b(r0, r1, CollectionsKt.listOf(r10), r11);
    }

    public static void b(String r16, PageFinder r17, List r18, BcmParams r19) {
        if (BtmSetting.d.c().c().k() != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        String r1 = BtmPageFinder.a;
        Object r10 = BtmPageFinder.a(r17);
        String r11 = BtmPageRecorder.a;
        PageInfo r12 = BtmPageRecorder.j(r10);
        String r13 = null;
        if (r12 == null) goto L11;
        String r14 = r12.getPageBtm();
    L12:
        JSONObject r15 = new JSONObject();
        r15.put("api", r16);     // Catch: Throwable -> L23
        r15.put("biz", CollectionsKt.joinToString$default(r18, null, null, null, 0, null, BcmApiCallMonitor$report$eventParams$1$1.INSTANCE, 31, null));     // Catch: Throwable -> L23
        if (r19 == null) goto L18;
        JSONObject r20 = r19.toJSONObject();     // Catch: Throwable -> L23
        if (r20 == null) goto L18;
        r15.put("params", r20.toString());     // Catch: Throwable -> L23
    L18:
        r15.put("page_btm", r14);     // Catch: Throwable -> L23
        if (r10 == null) goto L21;
        r13 = r10.getClass().getName();     // Catch: Throwable -> L23
    L21:
        r15.put("host", r13);     // Catch: Throwable -> L23
    L24:
        if (r14 != null) goto L27;
        r14 = "";
    L27:
        ConcurrentHashMap<String, Integer> r21 = a;
        Integer r22 = r21.get(r14);
        if (r22 != null) goto L31;
        r22 = 0;
    L31:
        r21.put(r14, Integer.valueOf(r22.intValue() + 1));
        ThreadUtils.a().postDelayed(new a(r15), 3000);
        return;
    L11:
        r14 = null;
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}
