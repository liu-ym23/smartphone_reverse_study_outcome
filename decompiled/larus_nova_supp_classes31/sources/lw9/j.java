package lw9;

import in7.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ g a;

    public /* synthetic */ j(g r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        g r0 = this.a;
        if (((Boolean) r2).booleanValue() == false) goto L5;
        r0.onGranted();
    L7:
        return Unit.INSTANCE;
    L5:
        r0.onDenied();
        goto L7
    }
}
