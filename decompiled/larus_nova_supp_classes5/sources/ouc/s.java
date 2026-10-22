package ouc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s implements luc.f {
    public final Lazy a;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final luc.f c() {
        return (luc.f) this.a.getValue();
    }

    @Override // luc.f
    public final int d() {
        return c().d();
    }

    @Override // luc.f
    public final String f() {
        return c().f();
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final luc.o getKind() {
        return c().getKind();
    }

    public s(Function0<? extends luc.f> r1) {
        this.a = LazyKt.lazy(r1);
    }

    @Override // luc.f
    public final String b(int r2) {
        return c().b(r2);
    }

    @Override // luc.f
    public final List<Annotation> e(int r2) {
        return c().e(r2);
    }

    @Override // luc.f
    public final int g(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        return c().g(r2);
    }

    @Override // luc.f
    public final luc.f h(int r2) {
        return c().h(r2);
    }

    @Override // luc.f
    public final boolean i(int r2) {
        return c().i(r2);
    }
}
