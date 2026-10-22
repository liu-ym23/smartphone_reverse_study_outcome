package v19;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g7 implements Function1<Throwable, Unit> {
    public final /* synthetic */ View a;
    public final /* synthetic */ h7 b;

    public g7(View r1, h7 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.b);
        return Unit.INSTANCE;
    }
}
