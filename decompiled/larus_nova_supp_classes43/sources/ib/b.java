package ib;

import android.net.Uri;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y36.i;
import y36.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends com.bytedance.ies.bullet.service.sdk.e {
    public final String a;

    public final String getName() {
        return "AnnieXLiteGlobalPropsInterceptor";
    }

    public b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.a = r10;
    }

    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        List r0 = (List) ((i) new o(r10, "append_global_props", CollectionsKt.emptyList())).b;
        if (r0 != null) goto L5;
    L13:
        return true;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        Lazy r11 = HybridSecureUtil.a;
        if (HybridSecureUtil.a(r10.c) == false) goto L13;
        ConcurrentHashMap<String, Object> r12 = com.bytedance.android.anniex.ability.f.a;
        Map r1 = com.bytedance.android.anniex.ability.f.m(this.a, r0, r10.c);
        Uri.Builder r13 = r10.c.buildUpon();
        r13.appendQueryParameter("appended_global_props", new JSONObject(r1).toString());
        r10.k(r13.build());
        goto L13
    }
}
