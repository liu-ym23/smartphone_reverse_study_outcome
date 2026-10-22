package com.larus.profile.impl;

import com.google.android.material.tabs.TabLayout;
import com.larus.profile.api.bean.LandingTab;
import com.larus.profile.impl.creation.x3;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w {
    public b a;
    public int b;
    public final CopyOnWriteArrayList<e2> c;
    public boolean d;

    public static final class a {
    }

    public interface b {
        void a(e2 r1, int r2);
    }

    static {
    }

    public w() {
        this.b = -1;
        this.c = new CopyOnWriteArrayList();
    }

    public final void a(e2 r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        FLogger.a.i("ProfileDefaultTabSelector", "addTabChild = " + r4);
        this.c.add(r4);
    }

    public final boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((e2) r1).a, r4) == false) goto L4;
    L9:
        e2 r2 = (e2) r1;
        if (r2 == null) goto L12;
        boolean r5 = Intrinsics.areEqual(r2.c, Boolean.FALSE);
    L14:
        return !r5;
    L12:
        r5 = false;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public final boolean c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Iterator<e2> r0 = this.c.iterator();
    L3:
        Boolean r2 = null;
        if (r0.hasNext() == false) goto L8;
        e2 r1 = r0.next();
        if (Intrinsics.areEqual(r1.a, r5) == false) goto L3;
    L9:
        e2 r3 = r1;
        if (r3 == null) goto L12;
        r2 = r3.c;
    L12:
        if (r2 != null) goto L14;
        return true;
    L14:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public final void e(int r4) {
        FLogger.a.i("ProfileDefaultTabSelector", "updateLandingIndex, index = " + r4);
        this.b = r4;
    }

    public final void f(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "tag");
        FLogger.a.i("ProfileDefaultTabSelector", "updateTabChildState, " + r9 + " = isEmpty " + r10);
        Iterator<T> r0 = this.c.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        e2 r4 = (e2) r2;
        if (Intrinsics.areEqual(r4.a, r9) == false) goto L11;
        CopyOnWriteArrayList<e2> r5 = this.c;
        Boolean r6 = Boolean.valueOf(r10);
        String r7 = r4.a;
        LandingTab r8 = r4.b;
        Intrinsics.checkNotNullParameter(r7, "fragmentTag");
        Intrinsics.checkNotNullParameter(r8, "landingTab");
        r5.set(r1, new e2(r7, r8, r6));
    L11:
        r1 = r3;
        goto L4
    }

    public final boolean d(TabLayout r9, boolean r10, boolean r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "tabLayout");
        boolean r2 = false;
        if (this.d == false) goto L7;
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, already defaultSelected, ignore");
        return false;
    L7:
        if (r11 == false) goto L18;
        TabLayout.Tab r13 = r9.getTabAt(0);
        if (r13 == null) goto L11;
        r13.select();
    L11:
        this.d = true;
        if (this.c.size() <= 0) goto L17;
        b r14 = this.a;
        if (r14 == null) goto L17;
        r14.a(this.c.get(0), 0);
    L17:
        return this.d;
    L18:
        if (r10 == true) goto L20;
    L44:
        int r15 = r9.getTabCount();
        int r16 = this.b;
        if (r16 < 0) goto L48;
        if (r16 >= r15) goto L48;
        boolean r17 = true;
    L50:
        if (r17 == false) goto L59;
        TabLayout.Tab r18 = r9.getTabAt(r16);
        if (r18 == null) goto L54;
        r18.select();
    L54:
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, tabCount = " + r15 + ", landingIndex = " + this.b);
        this.d = true;
        int r19 = this.c.size();
        int r110 = this.b;
        if (r19 <= r110) goto L111;
        b r20 = this.a;
        if (r20 == null) goto L111;
        r20.a(this.c.get(r110), this.b);
    L111:
        if (r15 > 1) goto L116;
        if (this.d == true) goto L116;
        this.d = true;
    L116:
        return this.d;
    L59:
        Iterator<e2> r111 = this.c.iterator();
        int r112 = 0;
    L61:
        if (r111.hasNext() == false) goto L66;
        if (Intrinsics.areEqual(r111.next().c, Boolean.FALSE) == true) goto L67;
        r112 = r112 + 1;
    L67:
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, firstTabWithDataIndex = " + r112);
        if (r112 < 0) goto L94;
        int r4 = r112 + 1;
        if (this.c.size() < r4) goto L79;
        Iterator r113 = CollectionsKt.take(this.c, r4).iterator();
        boolean r5 = true;
    L73:
        if (r113.hasNext() == false) goto L80;
        if (((e2) r113.next()).c == null) goto L77;
        boolean r6 = true;
    L78:
        r5 = r5 & r6;
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, queryFinishedBefore = " + r5);
        goto L73
    L77:
        r6 = false;
    L80:
        if (r5 == false) goto L111;
        if (r112 < 0) goto L84;
        if (r112 >= r15) goto L84;
        r2 = true;
    L84:
        if (r2 == true) goto L86;
        if (r112 != 0) goto L111;
    L86:
        TabLayout.Tab r21 = r9.getTabAt(r112);
        if (r21 == null) goto L89;
        r21.select();
    L89:
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, tabCount = " + r15 + ", firstTabWithDataIndex = " + r112);
        this.d = true;
        if (this.c.size() <= r112) goto L111;
        b r22 = this.a;
        if (r22 == null) goto L111;
        r22.a(this.c.get(r112), r112);
        goto L111
    L79:
        r5 = true;
        goto L80
    L94:
        Iterator<e2> r114 = this.c.iterator();
        boolean r115 = true;
    L96:
        if (r114.hasNext() == false) goto L102;
        if (r114.next().c == null) goto L100;
        boolean r3 = true;
    L101:
        r115 = r115 & r3;
        goto L96
    L100:
        r3 = false;
        goto L101
    L102:
        if (r115 == false) goto L111;
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, all tab is empty");
        TabLayout.Tab r23 = r9.getTabAt(0);
        if (r23 == null) goto L106;
        r23.select();
    L106:
        this.d = true;
        if (this.c.size() <= 0) goto L111;
        b r24 = this.a;
        if (r24 == null) goto L111;
        r24.a(this.c.get(0), 0);
        goto L111
    L66:
        r112 = -1;
    L48:
        r17 = false;
        goto L50
    L20:
        if (com.larus.bmhome.utils.u.i() == false) goto L44;
        Iterator<e2> r116 = this.c.iterator();
    L23:
        if (r116.hasNext() == false) goto L27;
        e2 r117 = r116.next();
        String r7 = r117.a;
        int r8 = x3.a;
        if (Intrinsics.areEqual(r7, x3.a(2)) == false) goto L23;
    L28:
        e2 r118 = r117;
        if (r118 == null) goto L31;
        boolean r119 = Intrinsics.areEqual(r118.c, Boolean.FALSE);
    L32:
        if (r119 == false) goto L34;
        return false;
    L34:
        TabLayout.Tab r25 = r9.getTabAt(r12);
        if (r25 == null) goto L37;
        r25.select();
    L37:
        FLogger.a.i("ProfileDefaultTabSelector", "selectDefaultTab, privatePosition = " + r12);
        this.d = true;
        if (this.c.size() <= r12) goto L43;
        b r26 = this.a;
        if (r26 == null) goto L43;
        r26.a(this.c.get(r12), r12);
    L43:
        return this.d;
    L31:
        r119 = false;
        goto L32
    L27:
        r117 = null;
        goto L28
    }
}
