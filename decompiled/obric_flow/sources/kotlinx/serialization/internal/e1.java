package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.f f19278b;

    public e1(String r5, kotlinx.serialization.descriptors.f r10) {
        Intrinsics.checkNotNullParameter(r5, "serialName");
        Intrinsics.checkNotNullParameter(r10, "kind");
        this.f19277a = r5;
        this.f19278b = r10;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r10 = (e1) r5;
        String r11 = r10.f19277a;
        if (Intrinsics.areEqual(this.f19277a, r11) == false) goto L13;
        kotlinx.serialization.descriptors.f r12 = r10.f19278b;
        if (Intrinsics.areEqual(this.f19278b, r12) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return this.f19278b;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19277a;
    }

    public final int hashCode() {
        int r5 = this.f19277a.hashCode();
        return (this.f19278b.hashCode() * 31) + r5;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return ai.j0.p(new StringBuilder("PrimitiveDescriptor("), this.f19277a, ')');
    }
}
