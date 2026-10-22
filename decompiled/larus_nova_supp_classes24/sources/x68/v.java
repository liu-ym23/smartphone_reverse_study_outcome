package x68;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v implements Function1<Map<String, Object>, Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map<String, Object> b;

    public v(String r1, Map<String, ? extends Object> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        Map r4 = (Map) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$params2");
        r4.put("type", this.a);
        r4.putAll(this.b);
        return Unit.INSTANCE;
    }
}
