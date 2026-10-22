package v19;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class w5 implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ w5(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        Function1 r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        FLogger.a.i("setImeAnimationCallback", "onStartCompat, isIMEShow:" + r6);
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r6));
    L6:
        return Unit.INSTANCE;
    }
}
