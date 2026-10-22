package kotlinx.serialization.json;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f19390b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f19391c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.serialization.internal.c f19392a;

    static {
        f19390b = new e();
        f19391c = "kotlinx.serialization.json.JsonArray";
    }

    public e() {
        n r5 = n.f19442a;
        Intrinsics.checkNotNullParameter(r5, "elementSerializer");
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r5, "element");
        kotlinx.serialization.descriptors.g r10 = r5.getDescriptor();
        Intrinsics.checkNotNullParameter(r10, "elementDesc");
        this.f19392a = new kotlinx.serialization.internal.c(r10, 1);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        this.f19392a.getClass();
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.f19392a.c(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        this.f19392a.getClass();
        return 1;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        this.f19392a.getClass();
        return String.valueOf(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        return this.f19392a.f(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        return this.f19392a.g(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        this.f19392a.getClass();
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        this.f19392a.getClass();
        return kotlinx.serialization.descriptors.n.f19244c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return f19391c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        this.f19392a.i(r5);
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        this.f19392a.getClass();
        return false;
    }
}
