package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements o60.e {
    public final /* synthetic */ p1 a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ int d;

    @Override // o60.e
    public final void onPermissionDenied(String... r1) {
        TokenCert r2 = q.a;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r4) {
        p1 r5 = this.a;
        if (r5 == null) goto L6;
        r5.onCallback();
    L6:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L9;
        UIUtils.displayToastWithIcon(this.b, 2131250233, 2131916013);
        return;
    L9:
        Intent r6 = new Intent();
        r6.setType("image/*");
        r6.setAction("android.intent.action.GET_CONTENT");
        Fragment r1 = this.c;     // Catch: Exception -> L15
        if (r1 == null) goto L13;
        r1.startActivityForResult(r6, this.d);     // Catch: Exception -> L15
    L17:
        return;
    L13:
        this.b.startActivityForResult(r6, this.d);     // Catch: Exception -> L15
    L15:
        UIUtils.displayToastWithIcon(this.b, 2131250233, 2131916012);
    }

    public j(com.bytedance.android.livesdk.utils.k2.a r1, Activity r2, Fragment r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
