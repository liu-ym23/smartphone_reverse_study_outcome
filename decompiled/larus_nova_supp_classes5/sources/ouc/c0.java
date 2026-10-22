package ouc;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class c0 implements Function1 {
    public /* synthetic */ c0() {
    }

    public final Object invoke(Object r3) {
        Map.Entry r4 = (Map.Entry) r3;
        Intrinsics.checkNotNullParameter(r4, "<destruct>");
        String r0 = (String) r4.getKey();
        i r5 = (i) r4.getValue();
        StringBuilder r1 = new StringBuilder();
        o0.a(r1, r0);
        r1.append(':');
        r1.append(r5);
        return r1.toString();
    }
}
