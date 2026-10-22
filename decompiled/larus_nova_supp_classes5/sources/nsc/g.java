package nsc;

import io.noties.markwon.core.CoreProps;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g implements x {
    public final int a;
    public final Integer b;
    public final Map<Integer, Float> c;

    @Override // lsc.x
    public final Object a(lsc.h r8, t r9) {
        Intrinsics.checkNotNullParameter(r8, "configuration");
        Intrinsics.checkNotNullParameter(r9, "props");
        return new io.noties.markwon.core.spans.m(r8.a, ((Number) CoreProps.f.b(r9)).intValue(), this.a, this.b, this.c);
    }

    public g(int r1, Integer r2, Map<Integer, Float> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
