package wpb;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.FlowableEmitter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ FlowableEmitter<Bitmap> a;
    public final /* synthetic */ Bitmap b;

    public b(FlowableEmitter<Bitmap> r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onNext(this.b);     // Catch: Throwable -> L4
        this.a.onComplete();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
