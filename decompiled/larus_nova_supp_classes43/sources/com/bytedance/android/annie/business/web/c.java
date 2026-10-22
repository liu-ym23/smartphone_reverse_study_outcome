package com.bytedance.android.annie.business.web;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements d {
    public final /* synthetic */ FixedUploadFileFragment a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ Activity c;

    @Override // com.bytedance.android.annie.business.web.d
    public final void onPermissionDenied() {
        com.bytedance.android.annie.util.c.b(this.c, 2131897336);
        FixedUploadFileFragment r0 = this.a;
        int r1 = FixedUploadFileFragment.i;
        r0.T90(null);
    }

    @Override // com.bytedance.android.annie.business.web.d
    public final void onPermissionGranted() {
        FixedUploadFileFragment r0 = this.a;
        Intent r1 = this.b;
        int r10 = FixedUploadFileFragment.i;
        r0.W90(r1);
    }

    public c(FixedUploadFileFragment r1, Intent r10, FragmentActivity r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
