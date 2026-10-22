package t19;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Runnable {
    public /* synthetic */ b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference<u19.f> r0 = s.b;
        u19.f r1 = r0.get();
        if ((r1 instanceof u19.c) == false) goto L5;
        FLogger.a.i("ToastLogger", "skip action toast dismiss on page destroy");
        return;
    L5:
        if (r1 == null) goto L8;
        r1.dismiss();
    L8:
        if (r0.compareAndSet(r1, null) == true) goto L12;
        if (r0.get() == r1) goto L8;
    L12:
        FLogger.a.d("ToastLogger", "clear toast holder on page destroy");
    }
}
