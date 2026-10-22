package com.bytedance.android.ec.core.address;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    public s() {
    }

    static {
    }

    public static void c(boolean r10, String r11) {
        Pair[] r0 = new Pair[2];
        if (r10 == false) goto L5;
        String r12 = "setting_null";
    L6:
        r0[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r12);
        r0[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, r11);
        a(1002, "SETTINGS_RETURN_NULL", MapsKt.mapOf(r0));
        return;
    L5:
        r12 = "parse_error";
        goto L6
    }

    public static void a(int r10, String r11, Map r12) {
        JSONObject r0 = new JSONObject();
        r0.put("code", r10);
        r0.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r11);
        if (r12 == null) goto L10;
        Set r13 = r12.entrySet();
        if (r13 == null) goto L10;
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) r14.next();
        r0.put((String) r15.getKey(), r15.getValue());
    L10:
        AddressEventReporter.d("ec_address_sdk_monitor", r0);
    }

    public static void d(Integer r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "source");
        a(2002, "REPORT_ADDRESS_NET_ERROR", MapsKt.mapOf(new Pair[]{TuplesKt.to("status_code", r10), TuplesKt.to("source", r11), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r12)}));
    }

    public static void b(boolean r10, Integer r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "changeType");
        Pair[] r0 = new Pair[4];
        if (r10 == false) goto L5;
        String r14 = "list_empty";
    L6:
        r0[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r14);
        r0[1] = TuplesKt.to("status_code", r11);
        r0[2] = TuplesKt.to("change_type", r12);
        r0[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r13);
        a(2001, "GET_ADDRESS_NET_ERROR", MapsKt.mapOf(r0));
        return;
    L5:
        r14 = "net_error";
        goto L6
    }
}
