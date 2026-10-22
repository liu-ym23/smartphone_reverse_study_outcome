package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends a {
    public final kotlinx.serialization.json.l e;

    public h(kotlinx.serialization.json.b r5, kotlinx.serialization.json.l r10) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r10, "value");
        super(r5);
        this.e = r10;
        this.f19317a.add("primitive");
    }

    @Override // kotlinx.serialization.json.internal.a
    public final kotlinx.serialization.json.l O(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        if (r5 != "primitive") goto L7;
        return this.e;
    L7:
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // kotlinx.serialization.json.internal.a
    public final kotlinx.serialization.json.l T() {
        return this.e;
    }

    @Override // eu.a
    public final int l(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return 0;
    }
}
