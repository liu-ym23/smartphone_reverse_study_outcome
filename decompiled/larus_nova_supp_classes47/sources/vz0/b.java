package vz0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.revenue.network.d;
import com.bytedance.android.livesdk.revenue.network.e;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.bytedance.android.livesdk.revenue.network.a {
    public static final ReadOnlyProperty a = null;
    public static final a b = null;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "disableLocalTraceMiddleware", "getDisableLocalTraceMiddleware()Z", 0))};
        }

        public a() {
        }
    }

    static {
        b = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_local_trace_middleware", Boolean.FALSE, Boolean.TYPE, false);
        KProperty r10 = a.a[0];
        a = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
    }

    public b() {
    }

    public static JSONObject I(d r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        JSONObject r0 = new JSONObject();
        Map r4 = r3.d;
        if (r4 == null) goto L10;
        Set r5 = r4.entrySet();
        if (r5 == null) goto L10;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.put((String) r1.getKey(), r1.getValue());
    L10:
        return r0;
    }

    public static JSONObject K(d r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        JSONObject r0 = new JSONObject();
        Map r4 = r3.c;
        if (r4 == null) goto L10;
        Set r5 = r4.entrySet();
        if (r5 == null) goto L10;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.put((String) r1.getKey(), r1.getValue());
    L10:
        return r0;
    }

    public final void E(String r8, d r9, com.bytedance.android.live.network.response.d.b r10) {
        Intrinsics.checkNotNullParameter(r8, "path");
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "response");
        a r1 = b;
        r1.getClass();
        if (((Boolean) a.getValue(r1, a.a[0])).booleanValue() == false) goto L6;
        super.E(r8, r9, r10);
        return;
    L6:
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        String r4 = GsonHelper.get().toJson(r10);     // Catch: Throwable -> L14
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L14
        r5.put("log_id", ((ExtraResponse) r10).logId);     // Catch: Throwable -> L14
        r3.put("body", r4);     // Catch: Throwable -> L14
        r3.put(Constants.Keys.HEADER, r5);     // Catch: Throwable -> L14
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L14
        Iterator r7 = r9.b.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r12 = (Map.Entry) r7.next();     // Catch: Throwable -> L14
        r6.put((String) r12.getKey(), r12.getValue());     // Catch: Throwable -> L14
        goto L9
    L11:
        r2.put("params", K(r9));     // Catch: Throwable -> L14
        r2.put("form", I(r9));     // Catch: Throwable -> L14
        r2.put(Constants.Keys.HEADER, r6);     // Catch: Throwable -> L14
    L12:
        c.b(bs2.a.class).consumeRevNetWork(((ExtraResponse) r10).logId, "[GET]" + r8, r2.toString(), r3.toString());
        super.E(r8, r9, r10);
    }

    public final e A(String r8, d r9, int r10, e r12, Extra r13) {
        Intrinsics.checkNotNullParameter(r8, "path");
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r12, "error");
        Intrinsics.checkNotNullParameter(r13, "extra");
        a r1 = b;
        r1.getClass();
        if (((Boolean) a.getValue(r1, a.a[0])).booleanValue() == false) goto L6;
        super.A(r8, r9, r10, r12, r13);
        return r12;
    L6:
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        String r4 = GsonHelper.get().toJson(r12);     // Catch: Throwable -> L14
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L14
        r5.put("log_id", r12.f);     // Catch: Throwable -> L14
        r3.put("body", r4);     // Catch: Throwable -> L14
        r3.put(Constants.Keys.HEADER, r5);     // Catch: Throwable -> L14
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L14
        Iterator r7 = r9.b.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r14 = (Map.Entry) r7.next();     // Catch: Throwable -> L14
        r6.put((String) r14.getKey(), r14.getValue());     // Catch: Throwable -> L14
        goto L9
    L11:
        r2.put("params", K(r9));     // Catch: Throwable -> L14
        r2.put("form", I(r9));     // Catch: Throwable -> L14
        r2.put(Constants.Keys.HEADER, r6);     // Catch: Throwable -> L14
    L12:
        c.b(bs2.a.class).consumeRevNetWork("", "[GET]" + r8, r2.toString(), r3.toString());
        super.A(r8, r9, r10, r12, r13);
        return r12;
    }
}
