package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import luc.o;
import luc.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p1 implements luc.f {
    public static final p1 a = null;
    public static final p.d b = null;
    public static final String c = null;

    public p1() {
    }

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final int d() {
        return 0;
    }

    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "NothingSerialDescriptor";
    }

    static {
        a = new p1();
        b = p.d.a;
        c = "kotlin.Nothing";
    }

    public final int hashCode() {
        return c.hashCode() + (b.hashCode() * 31);
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final String f() {
        return c;
    }

    @Override // luc.f
    public final o getKind() {
        return b;
    }

    @Override // luc.f
    public final String b(int r2) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final List<Annotation> e(int r2) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final int g(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final luc.f h(int r2) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final boolean i(int r2) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }
}
