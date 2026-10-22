package com.ss.android.lark.coremd.facade.richtext;

import com.ss.android.lark.biz.im.api.extension.message.d;
import com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.c0;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends RichTextTagHandlers.t {
    public final List<d> a;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            ((d.a) r1).getClass();
            ((d.a) r2).getClass();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    public c(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        this.a = r2;
    }

    public final s b(b3c.b r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        s r8 = super.b(r7);
        ArrayList r0 = new ArrayList();
        Iterator<d> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Iterator r2 = CollectionsKt.sortedWith(r1.next().intercept(), new b()).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        d.a r3 = (d.a) r2.next();
        r3.getClass();
        Iterator r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((d.a) r4.next()).getClass();
        goto L10
    L12:
        r0.add(r3);
        goto L7
    L14:
        if (r0.isEmpty() == false) goto L16;
        return r8;
    L16:
        String r9 = ((b0) r8).j;
        c0 r5 = new c0();
        Iterator r6 = CollectionsKt.sortedWith(r0, new a()).iterator();
        if (r6.hasNext() == false) goto L19;
        ((d.a) r6.next()).getClass();
        r5.e(null);
        throw null;
    L19:
        if ((r9.length() - 0) <= 0) goto L21;
        Intrinsics.checkNotNull(r9);
        r5.e(new b0(r9.substring(0)));
    L21:
        return r5;
    }
}
