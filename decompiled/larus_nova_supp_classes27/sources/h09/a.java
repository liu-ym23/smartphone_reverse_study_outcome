package h09;

import com.bytedance.retrofit2.client.Header;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u09.c;
import vx5.b;
import zv9.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements b {
    public a() {
    }

    public final vx5.e a(vx5.a r24) {
        int r1 = i.a;
        long r2 = System.nanoTime();
        AtomicBoolean r3 = h.a;
        String r4 = r24.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        if (Intrinsics.areEqual(h.b().i(), Boolean.FALSE) == true) goto L26;
        List r5 = h.b().h();
        if (r5 == null) goto L22;
        List r6 = r5;
        if ((r6 instanceof Collection) == true) goto L9;
    L11:
        Iterator r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L22;
        String r10 = (String) r7.next();
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == false) goto L13;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L26;
        boolean r9 = false;
    L28:
        if (r9 == false) goto L30;
        vx5.e r12 = new vx5.e();
        Object r13 = "skip audit path";
    L80:
        Pair r14 = TuplesKt.to(r12, Long.valueOf((System.nanoTime() - r2) / 1000));
        vx5.e r15 = (vx5.e) r14.component1();
        final long r18 = ((Number) r14.component2()).longValue();
        AtomicBoolean r16 = h.a;
        final String r0 = r24.a;
        Set r17 = r15.a;
        if (r17 != null) goto L83;
    L85:
        final boolean r21 = false;
    L86:
        final String r22 = (String) r13;
        Intrinsics.checkNotNullParameter(r0, "url");
        Intrinsics.checkNotNullParameter("ttnet", "netType");
        int r20 = c.a;
        c.a("security_ttnet_audit_perf", h.b().e(), new f(r18, r0, r21, r22));
        return r15;
    L83:
        if ((!r17.isEmpty()) != true) goto L85;
        r21 = true;
        goto L86
    L30:
        r12 = new vx5.e();
        AtomicBoolean r110 = h.a;
        final String r111 = r24.a;
        List r112 = r24.b;
        Intrinsics.checkNotNullParameter("ttnet", "netType");
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "requestHeaders");
        List r113 = h.b().b();
        if (r113 != null) goto L33;
    L35:
        boolean r114 = false;
    L36:
        if (r114 == false) goto L56;
        ArrayList r115 = new ArrayList();
        Iterator r116 = r112.iterator();
    L39:
        if (r116.hasNext() == false) goto L49;
        Object r117 = r116.next();
        Header r118 = (Header) r117;
        p r119 = h.b();
        if (r119 == null) goto L44;
        List r120 = r119.b();
        if (r120 == null) goto L44;
    L46:
        if (r120.contains(r118.getName()) == false) goto L39;
        r115.add(r117);
    L44:
        r120 = CollectionsKt.emptyList();
        goto L46
    L49:
        final ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r25 = r115.iterator();
    L51:
        if (r25.hasNext() == false) goto L54;
        r23.add(((Header) r25.next()).getName());
        goto L51
    L54:
        if ((!r23.isEmpty()) == false) goto L56;
        int r26 = c.a;
        c.a("security_ttnet_audit_report", h.b().g(), new d(r111, r23));
    L56:
        Lazy r27 = h.c;
        if ((!((HashMap) r27.getValue()).isEmpty()) == false) goto L78;
        HashMap r28 = (HashMap) r27.getValue();
        LinkedHashMap r30 = new LinkedHashMap();
        Iterator r31 = r28.entrySet().iterator();
    L60:
        if (r31.hasNext() == false) goto L65;
        Map.Entry r121 = (Map.Entry) r31.next();
        if (StringsKt.contains$default(r111, (String) r121.getKey(), false, 2, null) == false) goto L60;
        r30.put(r121.getKey(), r121.getValue());
        goto L60
    L65:
        List r32 = CollectionsKt.filterNotNull(CollectionsKt.flatten(CollectionsKt.filterNotNull(r30.values())));
        if ((!r32.isEmpty()) == false) goto L77;
        final HashSet r33 = new HashSet();
        Iterator r34 = r112.iterator();
    L69:
        if (r34.hasNext() == false) goto L74;
        Header r122 = (Header) r34.next();
        if (r32.contains(r122.getName()) == false) goto L69;
        r33.add(r122.getName());
        goto L69
    L74:
        if ((!r33.isEmpty()) == false) goto L76;
        int r35 = c.a;
        c.a("security_ttnet_audit_remove", h.b().f(), new e(r111, r33));
    L76:
        Pair r36 = new Pair(CollectionsKt.toSet(r32), "do_audit");
    L79:
        r12.a = (Set) r36.getFirst();
        r13 = r36.getSecond();
        goto L80
    L77:
        r36 = new Pair(null, "not_match");
        goto L79
    L78:
        r36 = new Pair(null, "default");
        goto L79
    L33:
        if ((!r113.isEmpty()) != true) goto L35;
        r114 = true;
        goto L36
    L17:
        if (StringsKt.contains$default(r4, r10, false, 2, null) != true) goto L19;
        r11 = true;
        goto L20
    L9:
        if (r6.isEmpty() == false) goto L11;
    L22:
        r8 = false;
    L26:
        r9 = true;
        goto L28
    }
}
