package bf;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, Boolean> a = null;
    public static final Map<String, c> b = null;
    public static final List<e> c = null;
    public static final List<d> d = null;
    public static final Map<String, Boolean> e = null;
    public static final CopyOnWriteArrayList<C0007a> f = null;

    /* JADX INFO: renamed from: bf.a$a, reason: collision with other inner class name */
    public static class C0007a {
        public C0007a() {
        }
    }

    static {
        Boolean r1 = Boolean.TRUE;
        Map<String, Boolean> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("ec_goods_detail", r1), TuplesKt.to("goods/detail/", r1), TuplesKt.to("goods/seeding/", r1), TuplesKt.to("ec_shop/goods/list", r1), TuplesKt.to("goods/shop", r1), TuplesKt.to("goods/store", r1), TuplesKt.to("ec_good_comment", r1), TuplesKt.to("product_inner_feed", r1), TuplesKt.to("ecom_order_list", r1), TuplesKt.to("ec_goods_pdp", r1), TuplesKt.to("ecom_tabkit", r1)});
        a = r0;
        b = new LinkedHashMap();
        c = new ArrayList();
        d = new ArrayList();
        e = new LinkedHashMap();
        f = new CopyOnWriteArrayList();
        Iterator<Map.Entry<String, Boolean>> r10 = r0.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        Map.Entry<String, Boolean> r11 = r10.next();
        int r12 = b.a;
        String r13 = r11.getKey();
        String r14 = null;
        if (r13 == null) goto L10;
        Uri r15 = UriProtector.parse(r13);
        if (r15 == null) goto L10;
        String r16 = b.a(r15.getHost(), r15.getPath());
    L12:
        if (r16 == null) goto L4;
        if (r16.length() <= 0) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == false) goto L19;
        r14 = r16;
    L19:
        if (r14 == null) goto L4;
        e.put(r14, r11.getValue());
        goto L4
    L16:
        r17 = false;
    L10:
        r16 = null;
        goto L12
    }

    public static void a(c r10) {
        Intrinsics.checkNotNullParameter(r10, "router");
        int r0 = b.a;
        String r1 = r10.b();
        String r11 = null;
        if (r1 == null) goto L9;
        Uri r12 = UriProtector.parse(r1);
        if (r12 == null) goto L9;
        r11 = b.a(r12.getHost(), r12.getPath());
    L9:
        if (r11 != null) goto L12;
        int r13 = ye.a.a;
        ye.a.a(r10.getClass().getName().concat("has wrong schema"));
        return;
    L12:
        b.put(r11, r10);
    }

    public static c b(Uri r10, boolean r11) {
        int r0 = b.a;
        String r12 = b.a(r10.getHost(), r10.getPath());
        if (r12 != null) goto L5;
        return null;
    L5:
        c r13 = (c) ((LinkedHashMap) b).get(r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        if (r11 == false) goto L10;
        r13.a();
    L10:
        return r13;
    }

    public static boolean c(Context r10, Uri r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (r11 != null) goto L5;
        return false;
    L5:
        Iterator r1 = ((ArrayList) d).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((d) r1.next()).a(r10, r11);
        goto L7
    L9:
        Iterator r14 = ((ArrayList) c).iterator();
    L11:
        if (r14.hasNext() == false) goto L21;
        e r15 = (e) r14.next();
        if (r15.a(r11) == false) goto L11;
        boolean r16 = r15.open(r10, r11, r12, r13);
        if (r16 == false) goto L20;
        Iterator<C0007a> r17 = f.iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        r17.next().getClass();
        Intrinsics.checkNotNullParameter(r11, "uri");
    L20:
        return r16;
    L21:
        c r18 = b(r11, r12);
        if (r18 != null) goto L24;
        return false;
    L24:
        boolean r19 = r18.c(r10, r11, r13);
        if (r19 == false) goto L30;
        Iterator<C0007a> r20 = f.iterator();
    L28:
        if (r20.hasNext() == false) goto L30;
        r20.next().getClass();
        Intrinsics.checkNotNullParameter(r11, "uri");
    L30:
        return r19;
    }
}
