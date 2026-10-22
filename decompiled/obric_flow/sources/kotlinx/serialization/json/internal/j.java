package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends a {
    public final kotlinx.serialization.json.d e;
    public final int f;
    public int g;

    public j(kotlinx.serialization.json.b r5, kotlinx.serialization.json.d r10) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r10, "value");
        super(r5);
        this.e = r10;
        this.f = r10.f19389a.size();
        this.g = -1;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final kotlinx.serialization.json.l O(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        int r10 = Integer.parseInt(r5);
        return (kotlinx.serialization.json.l) this.e.f19389a.get(r10);
    }

    @Override // kotlinx.serialization.json.internal.a
    public final String Q(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return String.valueOf(r10);
    }

    @Override // kotlinx.serialization.json.internal.a
    public final kotlinx.serialization.json.l T() {
        return this.e;
    }

    @Override // eu.a
    public final int l(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        int r10 = this.g;
        if (r10 >= (this.f - 1)) goto L6;
        int r11 = r10 + 1;
        this.g = r11;
        return r11;
    L6:
        return -1;
    }
}
