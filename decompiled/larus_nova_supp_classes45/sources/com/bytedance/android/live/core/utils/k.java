package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements o60.e {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ p1 b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ int d;

    @Override // o60.e
    public final void onPermissionDenied(String... r1) {
        p1 r2 = this.b;
        if (r2 == null) goto L5;
        r2.onCallback();
    L5:
        TokenCert r3 = q.a;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r4) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        UIUtils.displayToastWithIcon(this.a, 2131250233, 2131916013);
        p1 r5 = this.b;
        if (r5 == null) goto L19;
        r5.onCallback();
        return;
    L19:
        return;
    L8:
        Intent r6 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Fragment r1 = this.c;     // Catch: Exception -> L14
        if (r1 == null) goto L12;
        r1.startActivityForResult(r6, this.d);     // Catch: Exception -> L14
    L16:
        return;
    L12:
        this.a.startActivityForResult(r6, this.d);     // Catch: Exception -> L14
    L14:
        UIUtils.displayToastWithIcon(this.a, 2131250233, 2131916012);
    }

    public k(Activity r1, Fragment r2, int r3) {
        this.a = r1;
        this.b = null;
        this.c = r2;
        this.d = r3;
    }
}
