package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import android.os.Bundle;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.model.c;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    static {
    }

    public static void a(Object r10, Bundle r11) {
        if (BtmSetting.d.c().b().N() == 1) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        return;
    L7:
        String r12 = BtmPageRecorder.a;
        c r13 = BtmPageRecorder.h(r10);
        if (r13 != null) goto L10;
        return;
    L10:
        if (BtmPageRecorder.j(r10) == null) goto L12;
        return;
    L12:
        BufferBtm r0 = BufferQueue.i(null);
        if (r0 == null) goto L19;
        List<String> r1 = r0.getTargetPagesBtm();
        if (r1 == null) goto L19;
        if ((!r1.isEmpty()) != true) goto L19;
        return;
    L19:
        r13.c = BufferQueue.j(null, null);
    }
}
