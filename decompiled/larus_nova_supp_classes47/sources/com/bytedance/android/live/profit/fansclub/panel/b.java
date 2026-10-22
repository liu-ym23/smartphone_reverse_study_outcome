package com.bytedance.android.live.profit.fansclub.panel;

import android.net.Uri;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.FansClubRepository;
import com.bytedance.android.live.profit.fansclub.g;
import com.bytedance.android.live.profit.fansclub.i;
import com.bytedance.android.live.profit.vip.h;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o {
    public final k a;
    public final FansClubRepository b;
    public final com.bytedance.android.live.revenue.core.a c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Uri d() {
        du0.a r0 = (du0.a) i.b.getValue(null, i.a[0]);
        String r3 = "";
        if (this.a.isAnchor() == false) goto L14;
        if (r0.b() == true) goto L7;
        return null;
    L7:
        String r1 = r0.c();
        if (r1 == null) goto L12;
        r3 = r1;
    L12:
        return c(r3);
    L14:
        if (r0.e() == true) goto L17;
        return null;
    L17:
        if (((g) this.b.i.a).c() == false) goto L19;
        String r2 = r0.a();
    L20:
        if (r2 == null) goto L24;
        r3 = r2;
    L24:
        return c(r3);
    L19:
        r2 = r0.d();
        goto L20
    }

    public static Uri c(String r4) {
        Uri r5 = UriProtector.parse(r4);
        Intrinsics.checkNotNullParameter(r5, "baseUri");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5.isHierarchical() == false) goto L8;
        Iterator r1 = UriProtector.getQueryParameterNames(r5).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        String r3 = UriProtector.getQueryParameter(r5, r2);
        Intrinsics.checkNotNull(r3);
        r0.put(r2, r3);
    L8:
        Intrinsics.checkNotNullParameter("url", "key");
        Object r6 = r0.get("url");
        if ((r6 instanceof x0) == false) goto L12;
        String r7 = ((x0) r6).c().toString();
    L16:
        if (r7 != null) goto L18;
    L21:
        boolean r8 = true;
    L23:
        if ((!r8) == false) goto L26;
        return r5;
    L26:
        return null;
    L18:
        if (r7.length() == 0) goto L21;
        r8 = false;
        goto L23
    L12:
        if ((r6 instanceof String) == false) goto L14;
        r7 = (String) r6;
        goto L16
    L14:
        r7 = null;
        goto L16
    }

    public final Uri a(FansClubEntranceParams.Page r8) {
        Intrinsics.checkNotNullParameter(r8, "page");
        ReadOnlyProperty r0 = i.c;
        KProperty[] r1 = i.a;
        du0.b r2 = (du0.b) r0.getValue(null, r1[1]);
        du0.d r3 = (du0.d) i.d.getValue(null, r1[2]);
        com.bytedance.android.live.profit.vip.e r4 = yt0.d.a(this.c).b();
        if (r4 == null) goto L9;
        m<? extends h> r5 = r4.getSubscribeInfo();
        if (r5 == null) goto L9;
        h r6 = (h) r5.getValue();
        if (r6 == null) goto L9;
        Boolean r7 = Boolean.valueOf(r6.f);
    L10:
        int r9 = a.a[r8.ordinal()];
        if (r9 == 1) goto L41;
        if (r9 != 2) goto L14;
        Uri r10 = d();
    L45:
        return r10;
    L14:
        if (r9 == 3) goto L21;
        if (r9 != 4) goto L19;
        return null;
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if ((!Intrinsics.areEqual(r7, Boolean.TRUE)) == false) goto L23;
        r10 = d();
        goto L45
    L23:
        String r12 = "";
        if (this.a.isAnchor() == false) goto L32;
        String r13 = r2.b();
        if (r13 != null) goto L30;
        r13 = r2.a();
        if (r13 != null) goto L30;
    L31:
        r10 = c(r12);
    L30:
        r12 = r13;
        goto L31
    L32:
        String r14 = r2.d();
        if (r14 != null) goto L37;
        r14 = r2.c();
        if (r14 != null) goto L37;
    L38:
        r10 = c(r12);
    L37:
        r12 = r14;
        goto L38
    L41:
        if (this.a.isAnchor() == false) goto L43;
        r10 = c(r3.a());
        goto L45
    L43:
        r10 = c(r3.b());
    L9:
        r7 = null;
        goto L10
    }

    public b(k r2, FansClubRepository r3, com.bytedance.android.live.revenue.core.a r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "repo");
        Intrinsics.checkNotNullParameter(r4, "inst");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
