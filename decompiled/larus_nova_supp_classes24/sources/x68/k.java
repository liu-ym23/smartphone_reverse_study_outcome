package x68;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ Exception a;

    public /* synthetic */ k(Exception r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Exception r0 = this.a;
        Map r5 = (Map) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$params2");
        r5.put("error", r0.getClass().getSimpleName());
        String r1 = r0.getMessage();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r5.put("error_msg", r1);
        return Unit.INSTANCE;
    }
}
