package zk8;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ Context a;

    public /* synthetic */ p(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        t19.s r1 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        String r3 = r0.getString(2131901103);
        r1.getClass();
        t19.s.c(r2, r3);
    }
}
