package fob;

import android.text.Spannable;
import hob.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class f<I extends hob.b> implements c<Spannable, List<? extends b<I>>> {
    public static final /* synthetic */ int b = 0;
    public final d<I> a;

    public static final class a {
    }

    public static final class b<I> {
        public final I a;
        public final IntRange b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            I r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedUrl(info=" + this.a + ", range=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(hob.b r2, IntRange r3) {
            Intrinsics.checkNotNullParameter(r3, "range");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public abstract List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r1);

    public abstract I b(com.ss.android.lark.keyboard.edittext2.utils.b.a r1);

    public c.a<List<b<I>>> c(Spannable r7) {
        Intrinsics.checkNotNullParameter(r7, "value");
        List<com.ss.android.lark.keyboard.edittext2.utils.b.a> r8 = a(r7);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        com.ss.android.lark.keyboard.edittext2.utils.b.a r1 = (com.ss.android.lark.keyboard.edittext2.utils.b.a) r9.next();
        hob.b r3 = b(r1);
        int r5 = r1.b;
        r0.add(new b(r3, new IntRange(r5, r1.a.length() + r5)));
        goto L4
    L7:
        return new c.a(!r0.isEmpty(), r0);
    }

    @Override // fob.c
    public /* bridge */ /* synthetic */ c.a resolve(Spannable r1) {
        return c(r1);
    }

    public f(d<I> r2, eob.a r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "editor");
        this.a = r2;
    }
}
