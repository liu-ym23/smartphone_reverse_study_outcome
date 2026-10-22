package v98;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ n(b1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1 r0 = this.a;
        FLogger.a.i("ShareCallbackUtils", "Assuming share completed successfully");
        r0.invoke(Boolean.TRUE);
    }
}
