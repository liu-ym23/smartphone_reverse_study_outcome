package kotlinx.serialization.json.internal;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c0 extends c {
    public final ouc.b f;
    public final int g;
    public int h;

    @Override // kotlinx.serialization.json.internal.c
    public final ouc.i t() {
        return this.f;
    }

    @Override // muc.c
    public final int decodeElementIndex(f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        int r3 = this.h;
        if (r3 >= (this.g - 1)) goto L6;
        int r4 = r3 + 1;
        this.h = r4;
        return r4;
    L6:
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.c
    public final ouc.i r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.f.a(CastIntegerProtector.parseInt(r2));
    }

    public c0(ouc.a r2, ouc.b r3) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "value");
        super(r2, r3, null);
        this.f = r3;
        this.g = r3.size();
        this.h = -1;
    }

    @Override // nuc.m1
    public final String o(f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return String.valueOf(r3);
    }
}
