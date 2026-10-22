package com.ss.android.lark.contact.base.statistics;

import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactHitPoint {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ContactHitPoint$contactMainClickTargetMap$2.INSTANCE);
    }

    public static String a() {
        ContactBaseModuleDependency r0 = ContactBaseModuleDependency.b;
        if (r0.isSimpleTenant() == true) goto L5;
        return "member";
    L5:
        if (r0.isSmallB() == false) goto L7;
        return "simple_user";
    L7:
        return "c_user";
    }

    @JvmStatic
    public static final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        JSONObject r0 = new JSONObject();
        r0.put("click", r2);
        r0.put("target", ((Map) a.getValue()).get(r2));
        Statistics.sendEvent("contact_external_click", r0);
    }

    @JvmStatic
    public static final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        JSONObject r0 = new JSONObject();
        r0.put("click", r2);
        r0.put("target", ((Map) a.getValue()).get(r2));
        Statistics.sendEvent("contact_group_click", r0);
    }

    @JvmStatic
    public static final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        JSONObject r0 = new JSONObject();
        r0.put("click", r2);
        r0.put("target", ((Map) a.getValue()).get(r2));
        Statistics.sendEvent("contact_new_click", r0);
    }
}
