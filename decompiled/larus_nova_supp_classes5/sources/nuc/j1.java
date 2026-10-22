package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import luc.o;
import luc.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class j1 implements luc.f {
    public final String a;
    public final luc.f b;
    public final luc.f c;
    public final int d;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return this.a + '(' + this.b + ", " + this.c + ')';
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final int d() {
        return this.d;
    }

    @Override // luc.f
    public final String f() {
        return this.a;
    }

    @Override // luc.f
    public final o getKind() {
        return p.c.a;
    }

    @Override // luc.f
    public final String b(int r1) {
        return String.valueOf(r1);
    }

    @Override // luc.f
    public final List<Annotation> e(int r3) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + this.a + " expects only non-negative indices").toString());
    L4:
        r0 = false;
        goto L5
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r6 = (j1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // luc.f
    public final int g(String r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        Integer r0 = StringsKt.toIntOrNull(r3);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        throw new IllegalArgumentException(r3 + " is not a valid map index");
    }

    @Override // luc.f
    public final luc.f h(int r3) {
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L16;
        int r4 = r3 % 2;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L12;
        return this.c;
    L12:
        throw new IllegalStateException("Unreached".toString());
    L14:
        return this.b;
    L16:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + this.a + " expects only non-negative indices").toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // luc.f
    public final boolean i(int r3) {
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + this.a + " expects only non-negative indices").toString());
    L5:
        r1 = false;
        goto L6
    }

    public j1(String r1, luc.f r2, luc.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 2;
    }
}
