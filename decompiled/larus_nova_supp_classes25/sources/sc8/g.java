package sc8;

import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ List a;
    public final /* synthetic */ b b;

    public /* synthetic */ g(List r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        List r0 = this.a;
        b r1 = this.b;
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        BubbleBannerSourceListener r3 = (BubbleBannerSourceListener) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        r3.e(r1);     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L4;
        FLogger.a.w("BubbleBannerEventDispatcher", "dispatch show failed, bannerSource=" + r1.a + ", promptId=" + r1.b, r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L14:
        return Unit.INSTANCE;
    }
}
