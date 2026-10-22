package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p2 implements luc.f, n {
    public final luc.f a;
    public final String b;
    public final Set<String> c;

    @Override // luc.f
    public final boolean a() {
        return true;
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final String b(int r2) {
        return this.a.b(r2);
    }

    @Override // luc.f
    public final int d() {
        return this.a.d();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final List<Annotation> e(int r2) {
        return this.a.e(r2);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final int g(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        return this.a.g(r2);
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // luc.f
    public final o getKind() {
        return this.a.getKind();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final luc.f h(int r2) {
        return this.a.h(r2);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final boolean i(int r2) {
        return this.a.i(r2);
    }

    @Override // luc.f
    public final boolean isInline() {
        return this.a.isInline();
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.a);
        r0.append('?');
        return r0.toString();
    }

    @Override // nuc.n
    public final Set<String> c() {
        return this.c;
    }

    @Override // luc.f
    public final String f() {
        return this.b;
    }

    public p2(luc.f r3) {
        Intrinsics.checkNotNullParameter(r3, "original");
        this.a = r3;
        this.b = r3.f() + '?';
        this.c = a2.a(r3);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof p2) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((p2) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
