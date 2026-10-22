package com.bytedance.android.btm.impl.pageshow;

import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EnterPageParamsChecker {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(PageInfo r10, int r11, final JSONArray r12, int r13) {
        if (r11 == 0) goto L25;
        if (r12 == null) goto L32;
        if (r13 <= 0) goto L33;
        List r14 = BtmSetting.d.c().c().z();
        String r0 = r10.getPageBtm();
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        if (r14.contains(r0) == false) goto L13;
        Lazy r15 = BtmMonitor.a;
        BtmMonitor.j(2008, r10, null, null, new EnterPageParamsChecker$checkUnknown$1(r12), null, 188);
    L13:
        int r1 = 0;
    L14:
        if (r1 >= r13) goto L34;
        final String r16 = r12.optString(r1);
        Iterator r17 = BtmSetting.d.c().c().y().iterator();
    L17:
        if (r17.hasNext() == false) goto L21;
        if (StringsKt.contains$default(r16, (String) r17.next(), false, 2, null) == false) goto L17;
        boolean r18 = true;
    L22:
        if (r18 == false) goto L24;
        Lazy r19 = BtmMonitor.a;
        BtmMonitor.j(2007, r10, null, null, new EnterPageParamsChecker$checkUnknown$2(r16), null, 188);
    L24:
        r1 = r1 + 1;
        goto L14
    L21:
        r18 = false;
        goto L22
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }
}
