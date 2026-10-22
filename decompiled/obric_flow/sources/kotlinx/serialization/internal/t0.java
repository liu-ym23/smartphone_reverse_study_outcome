package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f19346a = null;

    static {
        f19346a = new t0();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return kotlinx.serialization.descriptors.n.e;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return "kotlin.Nothing";
    }

    public final int hashCode() {
        return (kotlinx.serialization.descriptors.n.e.hashCode() * 31) - 1818355776;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "NothingSerialDescriptor";
    }
}
