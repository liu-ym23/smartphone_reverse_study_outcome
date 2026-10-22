package kotlinx.serialization.json;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f19444a;

    public o(Function0 r5) {
        this.f19444a = LazyKt.lazy(r5);
    }

    public final kotlinx.serialization.descriptors.g a() {
        return (kotlinx.serialization.descriptors.g) this.f19444a.getValue();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return a().c(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return a().d();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return a().e(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        return a().f(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        return a().g(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return a().getKind();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return a().h();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        return a().i(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }
}
