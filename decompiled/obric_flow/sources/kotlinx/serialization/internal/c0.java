package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.g f19267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.g f19268c;

    public c0(String r5, kotlinx.serialization.descriptors.g r10, kotlinx.serialization.descriptors.g r11) {
        this.f19266a = r5;
        this.f19267b = r10;
        this.f19268c = r11;
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
        throw new IllegalArgumentException(ai.j0.j(r5, " is not a valid map index"));
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return 2;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return String.valueOf(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r10 = (c0) r5;
        String r11 = r10.f19266a;
        if (Intrinsics.areEqual(this.f19266a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19267b, r10.f19267b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19268c, r10.f19268c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        if (r5 < 0) goto L6;
        return CollectionsKt.emptyList();
    L6:
        throw new IllegalArgumentException(ai.j0.q(ai.j0.s(r5, "Illegal index ", ", "), this.f19266a, " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        if (r5 < 0) goto L13;
        int r10 = r5 % 2;
        if (r10 == 0) goto L11;
        if (r10 != 1) goto L9;
        return this.f19268c;
    L9:
        throw new IllegalStateException("Unreached");
    L11:
        return this.f19267b;
    L13:
        throw new IllegalArgumentException(ai.j0.q(ai.j0.s(r5, "Illegal index ", ", "), this.f19266a, " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return kotlinx.serialization.descriptors.n.d;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19266a;
    }

    public final int hashCode() {
        int r5 = this.f19266a.hashCode() * 31;
        int r10 = (this.f19267b.hashCode() + r5) * 31;
        return this.f19268c.hashCode() + r10;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        if (r5 < 0) goto L6;
        return false;
    L6:
        throw new IllegalArgumentException(ai.j0.q(ai.j0.s(r5, "Illegal index ", ", "), this.f19266a, " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return this.f19266a + '(' + this.f19267b + ", " + this.f19268c + ')';
    }
}
