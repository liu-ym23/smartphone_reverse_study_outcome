package com.bytedance.android.ec.core.address;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.z1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AddressEventReporter {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        kc.a.C0174a r0 = null;
        Object r1 = null;
        r0 = null;
        kc.a r11 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, null, 3, false, 4, null);
        String r12 = null;
        if (r11 == null) goto L23;
        List<kc.a.C0174a> r13 = r11.a;
        if (r13 == null) goto L23;
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L21;
        Object r15 = r14.next();
        kc.a.C0174a r16 = (kc.a.C0174a) r15;
        if (BtmSDK.INSTANCE.removeBcmChainPageId() == false) goto L15;
        if (r16 == null) goto L13;
        String r17 = r16.c;
    L14:
        String r18 = cd.a.b(r17);
    L19:
        if ((!Intrinsics.areEqual(r18, "a1.b0440.c0.d0")) == false) goto L8;
        r1 = r15;
        goto L21
    L13:
        r17 = null;
        goto L14
    L15:
        if (r16 == null) goto L17;
        r18 = r16.b;
        goto L19
    L17:
        r18 = null;
    L21:
        r0 = (kc.a.C0174a) r1;
    L23:
        if (BtmSDK.INSTANCE.removeBcmChainPageId() == false) goto L27;
        if (r0 == null) goto L26;
        r12 = r0.c;
    L26:
        r12 = cd.a.b(r12);
    L29:
        JSONObject r19 = new JSONObject();
        r19.put("address_strategy_type", z.d(r10));
        r19.put("btm", r12);
        r19.put("enable_location_stub", true);
        r19.put("receive_address_id", z.b(r10));
        r19.put("address_type", z.e(r10));
        Unit r20 = Unit.INSTANCE;
        d("ec_sdk_change_address", r19);
        return;
    L27:
        if (r0 == null) goto L29;
        r12 = r0.b;
        goto L29
    }

    public static void c(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        String r0 = z.f();
        JSONObject r1 = new JSONObject();
        r1.put("address_strategy_type", z.d(r10));
        r1.put("btm", r0);
        r1.put("enable_location_stub", true);
        r1.put("receive_address_id", z.b(r10));
        r1.put("address_type", z.e(r10));
        Unit r11 = Unit.INSTANCE;
        d("ec_sdk_select_address", r1);
    }

    public static void d(final String r1, final JSONObject r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r10, "params");
        b2.a(new AddressEventReporter$sendEvent$1(r10, r1));
    }

    public static void b(String r10, String r11, o83.b r12) {
        Intrinsics.checkNotNullParameter(r12, "item");
        JSONObject r0 = new JSONObject();
        if (r12.d == false) goto L5;
        int r1 = 1;
    L6:
        r0.put("source_address_type", r1);
        r0.put("sdk_address_type", r12.c);
        JSONObject r13 = r12.a;
        if (r13 == null) goto L10;
        String r14 = z.d(r13);
        if (r14 == null) goto L10;
    L11:
        r0.put("address_strategy_type", r14);
        r0.put("btm", r10);
        r0.put("enable_location_stub", true);
        JSONObject r15 = r12.a;
        if (r15 == null) goto L16;
        JSONObject r16 = r15.optJSONObject(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA);
        if (r16 == null) goto L16;
        z1.b(r0, r16);
    L16:
        JSONObject r17 = r12.a;
        Integer r18 = null;
        if (r17 == null) goto L19;
        String r19 = z.b(r17);
    L20:
        r0.put("receive_address_id", r19);
        JSONObject r20 = r12.a;
        if (r20 == null) goto L23;
        r18 = z.e(r20);
    L23:
        r0.put("address_type", r18);
        r0.put("request_time", z.j());
        r0.put("pre_main_btm", r11);
        Unit r21 = Unit.INSTANCE;
        d("ec_sdk_get_address", r0);
        return;
    L19:
        r19 = null;
    L10:
        r14 = "no_address";
        goto L11
    L5:
        r1 = 2;
        goto L6
    }
}
