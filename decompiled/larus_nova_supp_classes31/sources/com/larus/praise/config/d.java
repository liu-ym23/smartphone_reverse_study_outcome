package com.larus.praise.config;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements y57.e {
    public d() {
    }

    public void startActivity(Context r2, Intent r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L9;
        AppHost.Companion r4 = AppHost.a;
        Activity r0 = r4.a().getCurrentActivity();
        if (r0 == null) goto L8;
        r2 = r0;
        goto L9
    L8:
        r2 = r4.getApplication();
    L9:
        r2.startActivity(r3);
    }

    public void startActivityForResult(Activity r1, Intent r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        return;
    L6:
        r1.startActivityForResult(r2, r3);
    }
}
