package x68;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ u a;

    public /* synthetic */ j(u r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        u r0 = this.a;
        Map r5 = (Map) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$params2");
        r5.put("reason", "USER_STOP");
        r5.put("isExternalCaptureRunning", Boolean.valueOf(r0.h));
        return Unit.INSTANCE;
    }
}
