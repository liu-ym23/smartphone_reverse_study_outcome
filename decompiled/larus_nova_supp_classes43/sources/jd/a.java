package jd;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<Class, am3.c> a = null;

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put(TraceTimeMetricV2.class, new com.bytedance.android.ec.adapter.api.messagev2.model.a());
        r0.put(TraceTimeMetric.class, new de.c());
        r0.put(UpdatedCartInfo.class, new com.bytedance.android.ec.adapter.api.message.model.a());
        r0.put(UpdatedCartInfo.RoomCartStateVertical.class, new com.bytedance.android.ec.adapter.api.message.model.c());
        r0.put(UpdatedCartInfo.RoomCartStateHorizontal.class, new com.bytedance.android.ec.adapter.api.message.model.b());
        r0.put(ve.a.class, new ve.b());
        r0.put(com.bytedance.android.ec.adapter.impl.messagev2.a.class, new com.bytedance.android.ec.adapter.impl.messagev2.b());
    }
}
