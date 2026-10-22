package t19;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ i(Context r1, int r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        boolean r5 = this.d;
        if (r0 != null) goto L5;
        Context r3 = AppHost.a.getApplication();
    L6:
        String r4 = r3.getResources().getString(r1);
        FLogger.a.d("ToastLogger", "toast utils show, method name: showWithIcon");
        s.a.getClass();
        s.l(r0, r2, r4, null, null, r5);
        return;
    L5:
        r3 = r0;
        goto L6
    }
}
