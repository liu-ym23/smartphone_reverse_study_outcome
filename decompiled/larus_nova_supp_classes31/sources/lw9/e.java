package lw9;

import android.graphics.Bitmap;
import in7.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ a a;

    public /* synthetic */ e(eo7.a.a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        a r0 = this.a;
        Bitmap r3 = (Bitmap) r2;
        if (r3 == null) goto L5;
        r0.onSuccess(r3);
    L7:
        return Unit.INSTANCE;
    L5:
        r0.onFailed();
        goto L7
    }
}
