package v19;

import androidx.core.graphics.Insets;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class x5 implements Function2 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ x5(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, Object r5) {
        Function1 r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        Intrinsics.checkNotNullParameter((Insets) r4, "<unused var>");
        FLogger.a.i("setImeAnimationCallback", "onProgressCompat, isIMEShow:" + r6);
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r6));
    L6:
        return Unit.INSTANCE;
    }
}
