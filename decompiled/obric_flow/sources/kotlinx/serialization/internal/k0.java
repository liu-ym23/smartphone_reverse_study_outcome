package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.g f19303a;

    public k0(kotlinx.serialization.descriptors.g r5) {
        this.f19303a = r5;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Integer r10 = StringsKt.toIntOrNull(r5);
        if (r10 == null) goto L7;
        return r10.intValue();
    L7:
        throw new IllegalArgumentException(ai.j0.j(r5, " is not a valid list index"));
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return 1;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return String.valueOf(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r10 = (k0) r5;
        kotlinx.serialization.descriptors.g r11 = r10.f19303a;
        if (Intrinsics.areEqual(this.f19303a, r11) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(h(), r10.h()) == false) goto L13;
        return true;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        if (r5 >= 0) goto L4;
        StringBuilder r10 = ai.j0.s(r5, "Illegal index ", ", ");
        r10.append(h());
        r10.append(" expects only non-negative indices");
        throw new IllegalArgumentException(r10.toString().toString());
    L4:
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        if (r5 >= 0) goto L4;
        StringBuilder r10 = ai.j0.s(r5, "Illegal index ", ", ");
        r10.append(h());
        r10.append(" expects only non-negative indices");
        throw new IllegalArgumentException(r10.toString().toString());
    L4:
        return this.f19303a;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return kotlinx.serialization.descriptors.n.f19244c;
    }

    public final int hashCode() {
        int r5 = this.f19303a.hashCode() * 31;
        return h().hashCode() + r5;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        if (r5 < 0) goto L5;
        return false;
    L5:
        StringBuilder r10 = ai.j0.s(r5, "Illegal index ", ", ");
        r10.append(h());
        r10.append(" expects only non-negative indices");
        throw new IllegalArgumentException(r10.toString().toString());
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return h() + '(' + this.f19303a + ')';
    }
}
