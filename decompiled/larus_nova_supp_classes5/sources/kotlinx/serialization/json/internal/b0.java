package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import juc.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class b0 extends g {
    public final Map<String, ouc.i> g;

    @Override // kotlinx.serialization.json.internal.g
    public ouc.i q() {
        return new ouc.d0(this.g);
    }

    public b0(ouc.a r2, Function1<? super ouc.i, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "nodeConsumer");
        super(r2, r3);
        this.g = new LinkedHashMap();
    }

    @Override // kotlinx.serialization.json.internal.g
    public void r(String r2, ouc.i r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        this.g.put(r2, r3);
    }

    @Override // nuc.x2, muc.d
    public final <T> void encodeNullableSerializableElement(f r2, int r3, n<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        if (r5 == null) goto L5;
    L6:
        super.encodeNullableSerializableElement(r2, r3, r4, r5);
        return;
    L5:
        if (this.d.f == true) goto L6;
    }
}
