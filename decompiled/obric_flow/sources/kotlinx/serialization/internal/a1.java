package kotlinx.serialization.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 implements kotlinx.serialization.descriptors.g, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f19253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19254c;
    public int d;
    public final String[] e;
    public final List[] f;
    public final boolean[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f19255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f19256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f19257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f19258k;

    public a1(String r5, f0 r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "serialName");
        this.f19252a = r5;
        this.f19253b = r10;
        this.f19254c = r11;
        this.d = -1;
        String[] r12 = new String[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = "[UNINITIALIZED]";
        r13 = r13 + 1;
        goto L3
    L5:
        this.e = r12;
        int r14 = this.f19254c;
        this.f = new List[r14];
        this.g = new boolean[r14];
        this.f19255h = MapsKt.emptyMap();
        LazyThreadSafetyMode r15 = LazyThreadSafetyMode.PUBLICATION;
        this.f19256i = LazyKt.lazy(r15, new PluginGeneratedSerialDescriptor$childSerializers$2(this));
        this.f19257j = LazyKt.lazy(r15, new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this));
        this.f19258k = LazyKt.lazy(r15, new PluginGeneratedSerialDescriptor$_hashCode$2(this));
    }

    @Override // kotlinx.serialization.internal.l
    public final Set a() {
        return this.f19255h.keySet();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Integer r10 = (Integer) this.f19255h.get(r5);
        if (r10 != null) goto L7;
        return -3;
    L7:
        return r10.intValue();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return this.f19254c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return this.e[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        List r10 = this.f[r5];
        if (r10 == null) goto L5;
        return r10;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public kotlinx.serialization.descriptors.g g(int r5) {
        return ((kotlinx.serialization.c[]) this.f19256i.getValue())[r5].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.g
    public kotlinx.serialization.descriptors.k getKind() {
        return kotlinx.serialization.descriptors.n.f19243b;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19252a;
    }

    public int hashCode() {
        return ((Number) this.f19258k.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        return this.g[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public boolean isInline() {
        return false;
    }

    public String toString() {
        return CollectionsKt.q(RangesKt.until(0, this.f19254c), ", ", ai.j0.p(new StringBuilder(), this.f19252a, '('), ")", 0, null, new PluginGeneratedSerialDescriptor$toString$1(this), 24);
    }
}
