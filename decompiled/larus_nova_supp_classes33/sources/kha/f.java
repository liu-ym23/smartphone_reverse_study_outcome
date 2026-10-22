package kha;

import android.app.Activity;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.storage.ObricLowStorageServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ ObricLowStorageServiceImpl a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ f(ObricLowStorageServiceImpl r1, int r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricLowStorageServiceImpl r0 = this.a;
        int r1 = this.b;
        String r2 = this.c;
        boolean r3 = this.d;
        Activity r4 = null;
        r0.c = null;
        if (r1 < 10) goto L5;
        FLogger.a.w("LowStorageService", "scheduleForegroundCheck: reach max retry count, stop retrying, reason=" + r2 + ", retryCount=" + r1);
        return;
    L5:
        Activity r5 = AppHost.a.a().getCurrentActivity();
        if (r5 != null) goto L8;
    L13:
        FLogger.a.i("LowStorageService", "currentForegroundActivity: unavailable, activity=" + r5);
    L14:
        if (r4 != null) goto L17;
        FLogger.a.i("LowStorageService", "scheduleForegroundCheck: activity unavailable, retry, reason=" + r2);
        ObricLowStorageServiceImpl.e(r0, r2, 2000, r1 + 1, 4);
        return;
    L17:
        if (ObricLowStorageServiceImpl.e.contains(r4.getClass().getSimpleName()) == false) goto L20;
        FLogger.a.i("LowStorageService", "scheduleForegroundCheck: transient activity, retry, reason=" + r2 + ", activity=" + r4);
        ObricLowStorageServiceImpl.e(r0, r2, 2000, r1 + 1, 4);
        return;
    L20:
        if ((r4 instanceof j4) == false) goto L27;
        if (r3 == true) goto L24;
        FLogger.a.i("LowStorageService", "scheduleForegroundCheck: wait MainActivity confirm, reason=" + r2);
        r0.d(r2, 2000, true, r1 + 1);
        return;
    L24:
        if (ObricLowStorageServiceImpl.c(r4) == false) goto L34;
        FLogger.a.i("LowStorageService", "scheduleForegroundCheck: blocked on MainActivity, reason=" + r2);
        return;
    L34:
        return;
    L27:
        if (ObricLowStorageServiceImpl.c(r4) == false) goto L36;
        FLogger.a.i("LowStorageService", "scheduleForegroundCheck: blocked on stable activity, reason=" + r2 + ", activity=" + r4);
        return;
    L36:
        return;
    L8:
        if (r5.isFinishing() == true) goto L13;
        if (r5.isDestroyed() == true) goto L13;
        r4 = r5;
        goto L14
    }
}
