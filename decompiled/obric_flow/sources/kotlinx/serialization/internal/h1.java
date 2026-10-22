package kotlinx.serialization.internal;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 implements kotlinx.serialization.descriptors.g, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.g f19291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f19293c;

    public h1(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "original");
        this.f19291a = r5;
        this.f19292b = r5.h() + '?';
        this.f19293c = z0.b(r5);
    }

    @Override // kotlinx.serialization.internal.l
    public final Set a() {
        return this.f19293c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.f19291a.c(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return this.f19291a.d();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return this.f19291a.e(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h1) == true) goto L8;
        return false;
    L8:
        kotlinx.serialization.descriptors.g r10 = ((h1) r5).f19291a;
        if (Intrinsics.areEqual(this.f19291a, r10) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        return this.f19291a.f(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        return this.f19291a.g(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return this.f19291a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return this.f19291a.getKind();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19292b;
    }

    public final int hashCode() {
        return this.f19291a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        return this.f19291a.i(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return this.f19291a.isInline();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f19291a);
        r5.append('?');
        return r5.toString();
    }
}
