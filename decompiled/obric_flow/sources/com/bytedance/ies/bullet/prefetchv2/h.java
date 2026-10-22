package com.bytedance.ies.bullet.prefetchv2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f5853c;
    public final JSONObject d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5854h;

    public h(String r5, String r10, LinkedHashMap r11, LinkedHashMap r12, JSONObject r13, boolean r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "method");
        this.f5851a = r5;
        this.f5852b = r10;
        this.f5853c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r11.entrySet().iterator();
    L4:
        if (r18.hasNext() == false) goto L10;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        if (r20 == null) goto L9;
        r17.put(r20.toLowerCase(), r19.getValue());
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L10:
        Object r21 = MapsKt.toSortedMap(r17);
        Object r22 = MapsKt.toSortedMap(this.f5853c);
        Object r23 = MapsKt.toSortedMap(c.f(this.d));
        StringBuilder r24 = new StringBuilder();
        r24.append(this.f5851a);
        r24.append(',');
        String r25 = this.f5852b;
        Locale r26 = Locale.ROOT;
        if (r25 == null) goto L24;
        r24.append(r25.toLowerCase(r26));
        r24.append(',');
        if (r21 != null) goto L15;
        r21 = "{}";
    L15:
        r24.append(r21);
        r24.append(',');
        if (r22 != null) goto L18;
        r22 = "{}";
    L18:
        r24.append(r22);
        r24.append(',');
        if (r23 != null) goto L21;
        r23 = "{}";
    L21:
        r24.append(r23);
        r24.append(',');
        r24.append(this.e);
        r24.append(", ");
        r24.append(this.f);
        r24.append(", ");
        r24.append(this.g);
        this.f5854h = r24.toString();
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
