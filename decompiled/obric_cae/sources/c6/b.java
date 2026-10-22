package c6;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.wschannel.server.WsChannelService;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3358a;

    public b(Application r8) {
        this.f3358a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r8 = this.f3358a;
        r8.startService(new Intent(r8, WsChannelService.class));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
