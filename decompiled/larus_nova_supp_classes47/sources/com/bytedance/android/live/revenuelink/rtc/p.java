package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final CopyOnWriteArrayList<o> a;

    public final List<String> c() {
        CopyOnWriteArrayList<o> r0 = this.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((o) r2.next()).b);
        goto L4
    L6:
        return r1;
    }

    public final vc0.c d() {
        HashMap r0 = new HashMap();
        Iterator<o> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        o r2 = r1.next();
        Object r3 = r2.c;
        if (r3 == null) goto L4;
        r0.put(r2.b, r3);
        goto L4
    L9:
        return new vc0.c(r0);
    }

    public final List<o> l() {
        return CollectionsKt.toList(this.a);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("RtcUserList{cnt=");
        r0.append(this.a.size());
        r0.append(",");
        CopyOnWriteArrayList<o> r1 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((o) r3.next()).toString());
        goto L4
    L6:
        r0.append(r2);
        r0.append("}");
        return r0.toString();
    }

    public p() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "interactId");
        this.a.add(new o(r6, null, false, 8190));
        int r0 = w51.a.a;
        String r7 = "add " + r6 + ", current=" + this.a;
        Intrinsics.checkNotNullParameter("ttlive_anchor_link_rtc_user", "tag");
        Intrinsics.checkNotNullParameter(r7, Constants.OperatorKey.MSG);
        ALogger.w("ttlive_anchor_link_rtc_user", r7);
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        int r0 = w51.a.a;
        w51.a.C0337a.b("ttlive_anchor_link_rtc_user", "clear rtc users " + r3);
        this.a.clear();
    }

    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "interactId");
        boolean r0 = this.a.remove(k(r4));
        int r1 = w51.a.a;
        String r5 = "remove " + r4 + ' ' + r0 + ", current=" + this.a;
        Intrinsics.checkNotNullParameter("ttlive_anchor_link_rtc_user", "tag");
        Intrinsics.checkNotNullParameter(r5, Constants.OperatorKey.MSG);
        ALogger.w("ttlive_anchor_link_rtc_user", r5);
    }

    public final o k(String r5) {
        Object r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<T> r1 = this.a.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((o) r2).b, r5) == false) goto L7;
        r0 = r2;
    L12:
        return (o) r0;
    }

    public final void g(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        o r4 = k(r2);
        if (r4 == null) goto L6;
        r4.f = r3;
        return;
    }

    public final void h(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        o r4 = k(r2);
        if (r4 == null) goto L6;
        r4.e = r3;
        return;
    }

    public final void i(String r2, Pair<Integer, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r3, "videoSize");
        o r4 = k(r2);
        if (r4 == null) goto L6;
        r4.i = r3;
        return;
    }

    public final void e(String r2, Object r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r4, "videoSize");
        if (k(r2) != null) goto L5;
        a(r2);
    L5:
        o r5 = k(r2);
        if (r5 == null) goto L9;
        r5.c = r3;
        r5.i = r4;
        return;
    }

    public final void f(String r3, Object r4, Pair<Integer, Integer> r5) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        Intrinsics.checkNotNullParameter(r5, "videoSize");
        if (k(r3) != null) goto L5;
        a(r3);
    L5:
        o r6 = k(r3);
        if (r6 == null) goto L11;
        r6.d = true;
        if ((true ^ Intrinsics.areEqual(r6.c, r4)) == false) goto L12;
        r6.c = r4;
        r6.i = r5;
        return;
    L12:
        return;
    }
}
