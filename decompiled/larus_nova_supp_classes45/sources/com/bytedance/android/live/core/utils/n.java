package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements o60.e {
    public final /* synthetic */ p1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Activity d;
    public final /* synthetic */ Fragment e;
    public final /* synthetic */ int f;

    @Override // o60.e
    public final void onPermissionDenied(String... r1) {
        TokenCert r2 = q.a;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r5) {
        p1 r6 = this.a;
        if (r6 == null) goto L5;
        r6.onCallback();
    L5:
        Intent r7 = new Intent("android.media.action.IMAGE_CAPTURE");
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.b);
        if (r0.exists() == true) goto L8;
        r0.mkdirs();
    L8:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0, this.c);
        Uri r2 = TTLiveFileProvider.getUri(this.d, this.d.getPackageName() + ".ttlive_provider", r1);
        if (Build.VERSION.SDK_INT < 24) goto L11;
        r7.addFlags(1);
        r7.addFlags(2);
    L11:
        r7.putExtra("output", r2);
        Fragment r3 = this.e;     // Catch: Exception -> L17
        if (r3 == null) goto L15;
        r3.startActivityForResult(r7, this.f);     // Catch: Exception -> L17
    L19:
        return;
    L15:
        this.d.startActivityForResult(r7, this.f);     // Catch: Exception -> L17
    L17:
        UIUtils.displayToastWithIcon(this.d, 2131250233, 2131916011);
    }

    public n(String r2, String r3, FragmentActivity r4, Fragment r5) {
        this.a = null;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = 40004;
    }
}
