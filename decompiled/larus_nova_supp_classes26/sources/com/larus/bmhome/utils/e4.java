package com.larus.bmhome.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e4 {
    public final Function1<List<Long>, Unit> a;
    public final List<d4> b;

    public e4(q0 r4) {
        Intrinsics.checkNotNullParameter(r4, "eventsCompleteHandler");
        this.a = r4;
        ArrayList r5 = new ArrayList(3);
        int r1 = 0;
    L3:
        if (r1 >= 3) goto L5;
        r5.add(new d4());
        r1 = r1 + 1;
        goto L3
    L5:
        this.b = r5;
    }

    public final void a(int r8) {
        if (r8 >= 0) goto L4;
        return;
    L4:
        if (r8 >= ((ArrayList) this.b).size()) goto L28;
        if (r8 > 0) goto L8;
    L10:
        ((d4) ListProtector.get(this.b, r8)).a = System.currentTimeMillis();
        ((d4) ListProtector.get(this.b, r8)).b = true;
        if (r8 != (((ArrayList) this.b).size() - 1)) goto L21;
        Iterator<T> r0 = this.b.iterator();
    L14:
        if (r0.hasNext() == false) goto L16;
        ((d4) r0.next()).b = false;
        goto L14
    L16:
        Function1<List<Long>, Unit> r1 = this.a;
        List<d4> r3 = this.b;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        r4.add(Long.valueOf(((d4) r5.next()).a));
        goto L18
    L20:
        r1.invoke(r4);
    L21:
        int r9 = r8 + 1;
        int r2 = ((ArrayList) this.b).size();
    L22:
        if (r9 >= r2) goto L29;
        ((d4) ListProtector.get(this.b, r9)).b = false;
        r9 = r9 + 1;
        goto L22
    L29:
        return;
    L8:
        if (((d4) ListProtector.get(this.b, r8 - 1)).b == true) goto L10;
        return;
    }
}
