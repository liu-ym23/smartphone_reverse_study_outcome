package t19;

import android.content.Context;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ u19.f a;
    public final /* synthetic */ Context b;

    public /* synthetic */ f(u19.f r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u19.f r0 = this.a;
        Context r1 = this.b;
        s r2 = s.a;
        r2.a();
        r2.r(r0);
        FLogger.a.d("ToastLogger", "toast utils show, method name: warningSticky");
        r0.show(r1, false);
    }
}
