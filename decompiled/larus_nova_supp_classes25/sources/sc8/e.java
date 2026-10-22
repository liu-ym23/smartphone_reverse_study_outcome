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
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ List a;
    public final /* synthetic */ b b;
    public final /* synthetic */ a c;

    public /* synthetic */ e(List r1, b r2, a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        List r0 = this.a;
        b r1 = this.b;
        a r2 = this.c;
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        BubbleBannerSourceListener r4 = (BubbleBannerSourceListener) r3.next();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        r4.h(r1, r2);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L4;
        FLogger.a.w("BubbleBannerEventDispatcher", "dispatch action result failed, bannerSource=" + r1.a + ", promptId=" + r1.b, r7);
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L14:
        return Unit.INSTANCE;
    }
}
