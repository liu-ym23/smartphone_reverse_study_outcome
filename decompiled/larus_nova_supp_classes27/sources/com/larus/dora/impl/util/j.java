package com.larus.dora.impl.util;

import android.app.Application;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.larus.common.apphost.AppHost;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements ActivityResultCallback {
    public final /* synthetic */ DoraConnectChecker a;
    public final /* synthetic */ String b;

    public /* synthetic */ j(DoraConnectChecker r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onActivityResult(Object r7) {
        DoraConnectChecker r0 = this.a;
        String r1 = this.b;
        ActivityResult r8 = (ActivityResult) r7;
        StringBuilder r2 = new StringBuilder("checkReady: request bluetooth switch, result ");
        if (r8.getResultCode() != (-1)) goto L5;
        boolean r3 = true;
    L6:
        r2.append(r3);
        g49.d.d("DoraConnectChecker", r2.toString());
        if (r8.getResultCode() != (-1)) goto L9;
        r0.a("bt_ok", r1, r0.d);
        return;
    L9:
        s r9 = s.a;
        Application r4 = AppHost.a.getApplication();
        r9.getClass();
        s.b(r4, 2131903984, false);
        r0.getClass();
        return;
    L5:
        r3 = false;
        goto L6
    }
}
