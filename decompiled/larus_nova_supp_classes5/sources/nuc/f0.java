package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import luc.j;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f0 extends g2 {
    public final o.b m;
    public final Lazy n;

    @Override // nuc.g2
    public final int hashCode() {
        int r0 = this.a.hashCode();
        Intrinsics.checkNotNullParameter(this, "<this>");
        j r1 = new j(this);
        int r2 = 1;
    L4:
        if (r1.hasNext() == false) goto L11;
        int r3 = r2 * 31;
        String r4 = (String) r1.next();
        if (r4 == null) goto L8;
        int r5 = r4.hashCode();
    L9:
        r2 = r3 + r5;
        goto L4
    L8:
        r5 = 0;
        goto L9
    L11:
        return (r0 * 31) + r2;
    }

    @Override // nuc.g2
    public final String toString() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return CollectionsKt.joinToString$default(new luc.k(this), ", ", this.a + '(', ")", 0, null, null, 56, null);
    }

    @Override // nuc.g2, luc.f
    public final o getKind() {
        return this.m;
    }

    @Override // nuc.g2
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof luc.f) == true) goto L11;
        return false;
    L11:
        luc.f r6 = (luc.f) r5;
        if (r6.getKind() == o.b.a) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.a, r6.f()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(a2.a(this), a2.a(r6)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // nuc.g2, luc.f
    public final luc.f h(int r2) {
        return ((luc.f[]) this.n.getValue())[r2];
    }

    public f0(final String r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        super(r2, null, r3);
        this.m = o.b.a;
        this.n = LazyKt.lazy(new e0(r3, r2, this));
    }
}
