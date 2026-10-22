package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends a1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f19276l;

    public e0(String r5, f0 r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "generatedSerializer");
        super(r5, r10, 1);
        this.f19276l = true;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e0) == false) goto L27;
        kotlinx.serialization.descriptors.g r5 = (kotlinx.serialization.descriptors.g) r10;
        if (Intrinsics.areEqual(this.f19252a, r5.h()) == false) goto L27;
        e0 r11 = (e0) r10;
        if (r11.f19276l == false) goto L27;
        if (Arrays.equals((kotlinx.serialization.descriptors.g[]) this.f19257j.getValue(), (kotlinx.serialization.descriptors.g[]) r11.f19257j.getValue()) == false) goto L27;
        int r12 = r5.d();
        int r13 = this.f19254c;
        if (r13 != r12) goto L27;
        int r14 = 0;
    L19:
        if (r14 >= r13) goto L32;
        if (Intrinsics.areEqual(g(r14).h(), r5.g(r14).h()) == false) goto L27;
        if (Intrinsics.areEqual(g(r14).getKind(), r5.g(r14).getKind()) == false) goto L27;
        r14 = r14 + 1;
        goto L19
    L32:
        return true;
    L27:
        return false;
    }

    @Override // kotlinx.serialization.internal.a1
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.a1, kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return this.f19276l;
    }
}
