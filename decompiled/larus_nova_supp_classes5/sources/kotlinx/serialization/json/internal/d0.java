package kotlinx.serialization.json.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d0 extends g {
    public final ArrayList<ouc.i> g;

    @Override // kotlinx.serialization.json.internal.g
    public final ouc.i q() {
        return new ouc.b(this.g);
    }

    public d0(ouc.a r2, Function1<? super ouc.i, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "nodeConsumer");
        super(r2, r3);
        this.g = new ArrayList();
    }

    @Override // kotlinx.serialization.json.internal.g, nuc.n1
    public final String p(f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return String.valueOf(r3);
    }

    @Override // kotlinx.serialization.json.internal.g
    public final void r(String r2, ouc.i r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        int r4 = CastIntegerProtector.parseInt(r2);
        ListProtector.add(this.g, r4, r3);
    }
}
