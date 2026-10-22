package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f19219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass f19220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19221c;

    public b(h r5, KClass r10) {
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r10, "kClass");
        this.f19219a = r5;
        this.f19220b = r10;
        this.f19221c = r5.f19229a + Typography.less + r10.getSimpleName() + Typography.greater;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.f19219a.c(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return this.f19219a.f19231c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return this.f19219a.f[r5];
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof b) == false) goto L5;
        b r10 = (b) r5;
    L7:
        if (r10 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f19219a, r10.f19219a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r10.f19220b, this.f19220b) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r10 = null;
        goto L7
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        return this.f19219a.f19232h[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final g g(int r5) {
        return this.f19219a.g[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return this.f19219a.d;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final k getKind() {
        return this.f19219a.f19230b;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19221c;
    }

    public final int hashCode() {
        int r5 = this.f19220b.hashCode() * 31;
        return this.f19221c.hashCode() + r5;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        return this.f19219a.f19233i[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f19220b + ", original: " + this.f19219a + ')';
    }
}
