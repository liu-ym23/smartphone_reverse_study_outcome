package com.larus.community.impl.applet;

import android.app.Activity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ Activity a;

    public /* synthetic */ j(Activity r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Activity r0 = this.a;
        boolean r2 = false;
        if (r0.isFinishing() == true) goto L9;
        if (r0.isDestroyed() == true) goto L9;
        FLogger.a.i("AICreationAppletNavigator", "finish native host below AI creation applet: ".concat(r0.getClass().getSimpleName()));
        r0.finish();
        r0.overridePendingTransition(0, 0);
        r2 = true;
    L9:
        return Boolean.valueOf(r2);
    }
}
