package kotlinx.serialization.json.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e0 extends a0 {
    public final ouc.d0 j;
    public final List<String> k;
    public final int l;
    public int m;

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.c, muc.c
    public final void endStructure(f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
    }

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.c
    public final ouc.i t() {
        return this.j;
    }

    @Override // kotlinx.serialization.json.internal.a0
    public final ouc.d0 w() {
        return this.j;
    }

    @Override // kotlinx.serialization.json.internal.a0, muc.c
    public final int decodeElementIndex(f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        int r3 = this.m;
        if (r3 >= (this.l - 1)) goto L6;
        int r4 = r3 + 1;
        this.m = r4;
        return r4;
    L6:
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.c
    public final ouc.i r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if ((this.m % 2) != 0) goto L6;
        return ouc.k.c(r2);
    L6:
        return (ouc.i) MapsKt.getValue(this.j, r2);
    }

    public e0(ouc.a r3, ouc.d0 r4) {
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, "value");
        super(r3, r4, null, 12);
        this.j = r4;
        List<String> r5 = CollectionsKt.toList(r4.keySet());
        this.k = r5;
        this.l = r5.size() * 2;
        this.m = -1;
    }

    @Override // kotlinx.serialization.json.internal.a0, nuc.m1
    public final String o(f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        List<String> r4 = this.k;
        return (String) ListProtector.get(r4, r3 / 2);
    }
}
