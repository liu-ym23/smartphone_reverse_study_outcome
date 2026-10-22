package kh;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.android.ec.core.monitor.param.b {
    public final String a;

    public b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        this.a = r10;
    }

    @Override // com.bytedance.android.ec.core.monitor.param.b
    public final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "curKey");
        String r0 = this.a;
        int r1 = r0.hashCode();
        if (r1 == 83197) goto L11;
        if (r1 == 2043610225) goto L8;
    L13:
        return false;
    L8:
        if (r0.equals("Detail") == false) goto L13;
        return CollectionsKt.listOf(new String[]{"outer_buyNow", "outer_ultimateBuy"}).contains(r10);
    L11:
        if (r0.equals("Sku") == false) goto L13;
        return CollectionsKt.listOf("outer_buyNow").contains(r10);
    }

    @Override // com.bytedance.android.ec.core.monitor.param.b
    public final void b(String r10, JSONObject r11, Map<String, ? extends JSONObject> r12) {
        Intrinsics.checkNotNullParameter(r10, "curKey");
        Intrinsics.checkNotNullParameter(r12, "pageParams");
        String r0 = this.a;
        int r1 = r0.hashCode();
        if (r1 == 83197) goto L11;
        if (r1 == 2043610225) goto L8;
    L13:
        String r13 = null;
    L15:
        switch(r10.hashCode()) {
            case 169829394: goto L27;
            case 243376817: goto L24;
            case 611142324: goto L21;
            case 1142016945: goto L18;
            default: goto L39;
        };
    L39:
        String r14 = null;
    L30:
        if (r13 == null) goto L40;
        if (r14 == null) goto L41;
        int r15 = ECSdk.a;
        pi.b r16 = (pi.b) ECSdk.a(pi.b.class);
        if (r16 == null) goto L42;
        r16.monitorEvent("schema_report", k.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("in_schema", ((ConcurrentHashMap) r12).get("enter_page")), TuplesKt.to("out_schema", r11), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LOCATION, r14), TuplesKt.to("business", r13)})), null, null);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L18:
        if (r10.equals("request_cartAdd") == true) goto L28;
        r14 = null;
    L28:
        r14 = "addCart";
        goto L30
    L21:
        if (r10.equals("outer_buyNow") == false) goto L36;
        r14 = "buyNow";
        goto L30
    L36:
        r14 = null;
        goto L30
    L24:
        if (r10.equals("outer_ultimateBuy") == false) goto L37;
        r14 = "ultimateBuy";
        goto L30
    L37:
        r14 = null;
        goto L30
    L27:
        if (r10.equals("request_cartAdd_new") == true) goto L28;
        r14 = null;
        goto L30
    L8:
        if (r0.equals("Detail") == false) goto L13;
        r13 = "productDetail";
        goto L15
    L11:
        if (r0.equals("Sku") == false) goto L13;
        r13 = "commonSKU";
        goto L15
    }
}
