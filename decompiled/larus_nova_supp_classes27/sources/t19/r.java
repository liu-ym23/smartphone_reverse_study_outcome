package t19;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ s.a a;

    public /* synthetic */ r(s.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.a r0 = this.a;
        AtomicReference<u19.f> r1 = s.b;
        if (r1.get() != r0.a) goto L5;
        FLogger.a.d("ToastLogger", "clear toast holder by handle dismiss");
        r1.set(null);
    L5:
        r0.a.dismiss();
    }
}
