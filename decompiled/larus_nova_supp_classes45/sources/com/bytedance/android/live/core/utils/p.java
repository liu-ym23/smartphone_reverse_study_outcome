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
public final class p implements o60.e {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ int e;

    @Override // o60.e
    public final void onPermissionDenied(String... r1) {
        TokenCert r2 = q.a;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r5) {
        Intent r6 = new Intent("android.media.action.IMAGE_CAPTURE");
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.a.getCacheDir().getPath() + this.b, "live_jsb_photo");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0, this.c);
        Uri r2 = TTLiveFileProvider.getUri(this.a, this.a.getPackageName() + ".ttlive_provider", r1);
        if (Build.VERSION.SDK_INT < 24) goto L8;
        r6.addFlags(1);
        r6.addFlags(2);
    L8:
        r6.putExtra("output", r2);
        Fragment r3 = this.d;     // Catch: Exception -> L14
        if (r3 == null) goto L12;
        r3.startActivityForResult(r6, this.e);     // Catch: Exception -> L14
    L16:
        return;
    L12:
        this.a.startActivityForResult(r6, this.e);     // Catch: Exception -> L14
    L14:
        UIUtils.displayToastWithIcon(this.a, 2131250233, 2131916011);
    }

    public p(FragmentActivity r1, String r2, Fragment r3) {
        this.a = r1;
        this.b = "/EncryptedUploadMethod/";
        this.c = r2;
        this.d = r3;
        this.e = 40004;
    }
}
