package hm9;

import com.larus.utils.logger.FLogger;
import pda.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h implements a {
    public h() {
    }

    @Override // pda.a
    public final void a() {
        s r0 = j.h;
        r0.x = true;
        FLogger.a.i("BackgroundNetworkInterceptor", "onMainProcessBackground, mode=" + r0.y);
        j.a.b();
    }

    @Override // pda.a
    public final void b() {
        s r0 = j.h;
        r0.x = false;
        FLogger.a.i("BackgroundNetworkInterceptor", "onMainProcessForeground, mode=" + r0.y);
        r0.d(false);
        j.a.b();
    }
}
