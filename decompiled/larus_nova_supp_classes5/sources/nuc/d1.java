package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import luc.o;
import luc.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public abstract class d1 implements luc.f {
    public final luc.f a;
    public final int b;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + f().hashCode();
    }

    public final String toString() {
        return f() + '(' + this.a + ')';
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final int d() {
        return this.b;
    }

    @Override // luc.f
    public final o getKind() {
        return p.b.a;
    }

    public d1(luc.f r1) {
        this.a = r1;
        this.b = 1;
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
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + f() + " expects only non-negative indices").toString());
    L4:
        r0 = false;
        goto L5
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r6 = (d1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(f(), r6.f()) == false) goto L13;
        return true;
    }

    @Override // luc.f
    public final int g(String r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        Integer r0 = StringsKt.toIntOrNull(r3);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        throw new IllegalArgumentException(r3 + " is not a valid list index");
    }

    @Override // luc.f
    public final luc.f h(int r3) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return this.a;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + f() + " expects only non-negative indices").toString());
    L4:
        r0 = false;
        goto L5
    }

    @Override // luc.f
    public final boolean i(int r3) {
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + f() + " expects only non-negative indices").toString());
    L5:
        r1 = false;
        goto L6
    }
}
