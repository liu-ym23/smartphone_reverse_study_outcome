package com.bytedance.android.live.openplatform.api.utils;

import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class d {
    public d() {
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public final boolean h() {
        if (c() == false) goto L5;
    L18:
        return true;
    L5:
        if (f() == true) goto L18;
        if (d() == true) goto L18;
        if (a() == true) goto L18;
        if (b() == true) goto L18;
        if (g() == true) goto L18;
        if (e() == true) goto L18;
        return false;
    }

    public final boolean i() {
        if (d() == false) goto L5;
    L8:
        return true;
    L5:
        if (a() == true) goto L8;
        return false;
    }

    public final boolean j() {
        if (b() == false) goto L5;
    L8:
        return true;
    L5:
        if (g() == true) goto L8;
        return false;
    }

    public final List<ProductIntroductionInfo> k(List<ProductIntroductionInfo> r7) {
        Intrinsics.checkNotNullParameter(r7, "list");
        if (d() == true) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L13;
        Object r3 = r8.next();
        if (((ProductIntroductionInfo) r3).introductionType == 1) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r0.add(r3);
        goto L6
    L10:
        r4 = false;
        goto L11
    L13:
        r7 = r0;
    L15:
        if (a() == true) goto L37;
        ArrayList r1 = new ArrayList();
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L26;
        Object r5 = r9.next();
        if (((ProductIntroductionInfo) r5).introductionType == 2) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L18;
        r1.add(r5);
        goto L18
    L22:
        r6 = false;
        goto L23
    L26:
        return r1;
    L37:
        return r7;
    }

    public final List<ProductLabelInfo> l(List<ProductLabelInfo> r7) {
        Intrinsics.checkNotNullParameter(r7, "list");
        if (b() == true) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L13;
        Object r3 = r8.next();
        if (((ProductLabelInfo) r3).labelType == 2) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r0.add(r3);
        goto L6
    L10:
        r4 = false;
        goto L11
    L13:
        r7 = r0;
    L15:
        if (g() == true) goto L37;
        ArrayList r1 = new ArrayList();
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L26;
        Object r5 = r9.next();
        if (((ProductLabelInfo) r5).labelType == 3) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L18;
        r1.add(r5);
        goto L18
    L22:
        r6 = false;
        goto L23
    L26:
        return r1;
    L37:
        return r7;
    }
}
