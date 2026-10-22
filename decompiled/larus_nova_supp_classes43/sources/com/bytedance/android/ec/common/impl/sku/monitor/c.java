package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public c(SkuParams r10) {
        Intrinsics.checkNotNullParameter(r10, "skuParams");
        Set<String> r0 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.e r1 = ECProcessMonitor.p();
        JSONObject r11 = new JSONObject();
        r11.put("EVENT_PAGE_TECHNOLOGY", "Native_Android");
        r11.put("scene_type", r10.getSceneType());
        r11.put(com.bytedance.android.ec.core.event.a.KEY_ACTION_TYPE, r10.getActionType());
        int r12 = qf.a.a;
        r11.put("use_new_api", qf.a.e.a(r10));
        Unit r13 = Unit.INSTANCE;
        ActionRateListener.c(r1, r11, null, false, 6);
    }
}
