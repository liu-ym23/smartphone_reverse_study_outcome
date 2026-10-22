package com.bytedance.android.bcm.impl.paramcheck.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final List<a> a;
    public boolean b;

    public final a.C0106a b() {
        List<a> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r10 = r0.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r11 = r10.next();
        if ((r11 instanceof a.C0106a) == false) goto L4;
        r1.add(r11);
        goto L4
    L9:
        return (a.C0106a) CollectionsKt.firstOrNull(r1);
    }

    public b() {
        this.a = new ArrayList();
        this.b = true;
    }

    public final void a(JSONObject r10) {
        List<a> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator r11 = ((ArrayList) r0).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((r12 instanceof a.b) == false) goto L4;
        r1.add(r12);
        goto L4
    L8:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r14 = r1.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.add(((a.b) r14.next()).c);
        goto L10
    L12:
        r10.put("illegal_params", new JSONArray(r13));
        a.C0106a r15 = b();
        if (r15 == null) goto L22;
        r10.put("extra_rule", r15.a);
        return;
    }
}
