package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m2 implements luc.f {
    public final String a;
    public final luc.e b;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final int d() {
        return 0;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "PrimitiveDescriptor(" + this.a + ')';
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final String f() {
        return this.a;
    }

    @Override // luc.f
    public final o getKind() {
        return this.b;
    }

    @Override // luc.f
    public final String b(int r2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // luc.f
    public final List<Annotation> e(int r2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r6 = (m2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.b, r6.b) == false) goto L13;
        return true;
    }

    @Override // luc.f
    public final int g(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // luc.f
    public final luc.f h(int r2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // luc.f
    public final boolean i(int r2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public m2(String r2, luc.e r3) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, "kind");
        this.a = r2;
        this.b = r3;
    }
}
