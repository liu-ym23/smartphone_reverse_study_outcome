package x68;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ da9.d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ u c;

    public /* synthetic */ f(da9.d r1, int r2, u r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        da9.d r0 = this.a;
        int r1 = this.b;
        u r2 = this.c;
        Map r7 = (Map) r6;
        Intrinsics.checkNotNullParameter(r7, "$this$params2");
        r7.put("width", Integer.valueOf(r0.c.b.b));
        r7.put("height", Integer.valueOf(r0.c.b.c));
        r7.put("fps", Integer.valueOf(r1));
        r7.put("minPushFrameIntervalMs", Long.valueOf(r2.j));
        return Unit.INSTANCE;
    }
}
