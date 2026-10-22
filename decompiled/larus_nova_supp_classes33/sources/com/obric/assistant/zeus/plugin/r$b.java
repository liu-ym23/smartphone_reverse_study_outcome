package com.obric.assistant.zeus.plugin;

import android.app.Activity;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.volcengine.zeus.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r$b implements c {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ r c;

    public final void onLoadSuccess() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        FLogger.a.i("ZeusStartActivityFallback", "plugin load success, try relaunch activity " + this.a.getComponent() + ", currentActivity = " + r0);
        if (r0 == null) goto L5;
        r0.startActivity(this.b);
    L5:
        this.c.a = false;
    }

    public final void a(String r1, long r2) {
        FLogger.a.i("ZeusStartActivityFallback", "plugin load timeout, won't relaunch activity " + this.a.getComponent());
        this.c.a = false;
    }

    public final void b(String r2, String r3) {
        FLogger.a.i("ZeusStartActivityFallback", "plugin load failed, won't relaunch activity " + this.a.getComponent());
        this.c.a = false;
    }

    public r$b(Intent r1, Intent r2, r r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
