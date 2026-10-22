package kotlinx.serialization.json;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.internal.m1;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements kotlinx.serialization.descriptors.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f19452b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f19453c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.serialization.internal.c0 f19454a;

    static {
        f19452b = new y();
        f19453c = "kotlinx.serialization.json.JsonObject";
    }

    public y() {
        du.a.b(StringCompanionObject.INSTANCE);
        m1 r5 = m1.f19311a;
        n r10 = n.f19442a;
        m1 r11 = m1.f19311a;
        n r12 = n.f19442a;
        Intrinsics.checkNotNullParameter(r11, "keySerializer");
        Intrinsics.checkNotNullParameter(r12, "valueSerializer");
        Intrinsics.checkNotNullParameter(r11, "kSerializer");
        Intrinsics.checkNotNullParameter(r12, "vSerializer");
        kotlinx.serialization.descriptors.g r13 = r11.getDescriptor();
        kotlinx.serialization.descriptors.g r14 = r12.getDescriptor();
        Intrinsics.checkNotNullParameter(r13, "keyDesc");
        Intrinsics.checkNotNullParameter(r14, "valueDesc");
        this.f19454a = new kotlinx.serialization.internal.c0("kotlin.collections.LinkedHashMap", r13, r14);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        this.f19454a.getClass();
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.f19454a.c(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        this.f19454a.getClass();
        return 2;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        this.f19454a.getClass();
        return String.valueOf(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        return this.f19454a.f(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        return this.f19454a.g(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        this.f19454a.getClass();
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        this.f19454a.getClass();
        return kotlinx.serialization.descriptors.n.d;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return f19453c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        this.f19454a.i(r5);
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        this.f19454a.getClass();
        return false;
    }
}
