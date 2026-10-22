package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f0 extends b0 {
    public String h;
    public boolean i;

    @Override // kotlinx.serialization.json.internal.b0, kotlinx.serialization.json.internal.g
    public final ouc.i q() {
        return new ouc.d0(this.g);
    }

    public f0(ouc.a r2, Function1<? super ouc.i, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "nodeConsumer");
        super(r2, r3);
        this.i = true;
    }

    @Override // kotlinx.serialization.json.internal.b0, kotlinx.serialization.json.internal.g
    public final void r(String r2, ouc.i r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        if (this.i == true) goto L5;
        Map<String, ouc.i> r4 = this.g;
        String r0 = this.h;
        if (r0 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tag");
        r0 = null;
    L20:
        r4.put(r0, r3);
        this.i = true;
        return;
    L5:
        if ((r3 instanceof ouc.g0) == false) goto L8;
        this.h = ((ouc.g0) r3).a();
        this.i = false;
        return;
    L8:
        if ((r3 instanceof ouc.d0) == true) goto L16;
        if ((r3 instanceof ouc.b) == false) goto L14;
        throw s.b(ouc.d.b);
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        throw s.b(ouc.f0.b);
    }
}
