package afa;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements Function1<Throwable, Unit> {
    public final /* synthetic */ AtomicBoolean a;

    public a(AtomicBoolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.set(true);
        FLogger.a.i("DismissKeyguardActionHandler", "dismissKeyguard continuation cancelled");
        return Unit.INSTANCE;
    }
}
