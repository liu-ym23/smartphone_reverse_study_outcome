package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final Lazy e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r9.c f6144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f6145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f6146c;
    public final ConcurrentHashMap d;

    static {
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SchemaService$Companion$instance$2.f6131a);
    }

    public d() {
        this.f6144a = new r9.c(6);
        this.f6145b = new LinkedHashMap();
        this.f6146c = new LinkedHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static void b(rd.b r5, Class r10) {
        Intrinsics.checkNotNullParameter(r5, "schemaData");
        Intrinsics.checkNotNullParameter(r10, "type");
        if (rd.c.class.isAssignableFrom(r10) == true) goto L13;
        return;
    L13:
        ((b) r5).getClass();     // Catch: Exception -> L12
        System.currentTimeMillis();     // Catch: Exception -> L12
        if (r10.newInstance() != null) goto L10;
        throw null;     // Catch: Exception -> L12
    L10:
        throw new ClassCastException();     // Catch: Exception -> L12
    }

    public final b a(String r12, Uri r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "url");
        boolean r5 = Intrinsics.areEqual(r13, Uri.EMPTY);
        rd.d r10 = this.f6144a;
        if (r5 == true) goto L5;
        ArrayList r11 = new ArrayList();
        a r15 = (a) this.f6146c.remove(r13);
        if (r15 == null) goto L9;
        r11.addAll(r15.f6132a);
    L9:
        String r16 = null;
        if (r12 == null) goto L16;
        LinkedHashMap r17 = this.f6145b;
        rd.a r18 = (rd.a) r17.get(r12);
        if (r18 != null) goto L14;
        r18 = (rd.a) r17.get("default_bid");
    L14:
        if (r18 == null) goto L16;
        r11.addAll(r18.f6132a);
        j r19 = r18.f21722b;
    L17:
        if (r19 == null) goto L20;
        r10 = r19;
    L20:
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r11, "interceptors");
        Intrinsics.checkNotNullParameter(r10, "schemaMonitor");
        b r110 = new b(r13, r10, r14);
        r110.f6137i = System.currentTimeMillis();
        String r111 = r13.toString();
        int r112 = StringsKt.r("://", 0, 6, r111);
        LinkedHashMap r113 = r110.f6140l;
        LinkedHashMap r20 = r110.f6139k;
        if (r112 != (-1)) goto L24;
        r20.put("parse_duration", Long.valueOf(System.currentTimeMillis() - r110.f6137i));
        r113.put("parse_error", "invalid url");
        r110.d();
        Intrinsics.checkNotNullParameter("invalid url", "message");
        r10.a("invalid url");
        return r110;
    L24:
        int r21 = r111.length();
        r110.d = r111.substring(0, r112);
        int r114 = r112 + 3;
        int r22 = StringsKt.q(r111, '?', r114, 4);
        if (r22 != (-1)) goto L27;
        r110.e = r111.substring(r114, r21);
    L31:
        if (r16 == null) goto L33;
        cl.a.t(r16, r110, 0);
    L33:
        r20.put("parse_duration", Long.valueOf(System.currentTimeMillis() - r110.f6137i));
        Iterator r115 = r11.iterator();
    L35:
        if (r115.hasNext() == false) goto L42;
        c r116 = (c) r115.next();
        String r23 = r116.b();
        Intrinsics.checkNotNullParameter(r23, "name");
        r20.put(r23, Long.valueOf(System.currentTimeMillis()));
        boolean r24 = r116.a(r110);
        String r25 = r116.b();
        Intrinsics.checkNotNullParameter(r25, "name");
        Long r26 = (Long) r20.get(r25);
        if (r26 == null) goto L39;
        r20.put(r25, Long.valueOf(System.currentTimeMillis() - r26.longValue()));
    L39:
        if (r24 == true) goto L35;
        String r27 = r116.b();
        Intrinsics.checkNotNullParameter(r27, "name");
        Intrinsics.checkNotNullParameter("No Error", "message");
        r113.put(r27, "No Error");
        String r117 = r116.b().concat(":No Error");
        Intrinsics.checkNotNullParameter(r117, "message");
        r110.f6133a.a(r117);
        goto L35
    L42:
        if (r110.g == true) goto L44;
        r110.d();
    L44:
        return r110;
    L27:
        r110.e = r111.substring(r114, r22);
        int r28 = r22 + 1;
        int r118 = StringsKt.q(r111, '#', r28, 4);
        if (r118 != (-1)) goto L30;
        r16 = r111.substring(r28, r21);
        goto L31
    L30:
        r16 = r111.substring(r28, r118);
        r110.f = r111.substring(r118 + 1, r21);
    L16:
        r19 = null;
        goto L17
    L5:
        return new b(r13, r10, r14);
    }
}
