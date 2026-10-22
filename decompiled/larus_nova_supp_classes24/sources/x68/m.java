package x68;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ m(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        boolean r0 = this.a;
        Map r4 = (Map) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$params2");
        r4.put("started", Boolean.valueOf(r0));
        return Unit.INSTANCE;
    }
}
