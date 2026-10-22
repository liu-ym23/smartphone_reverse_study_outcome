package com.bytedance.android.annie.card.web;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements a {
    public final /* synthetic */ UploadFileFragment a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ Activity c;

    @Override // com.bytedance.android.annie.card.web.a
    public final void onPermissionDenied() {
        com.bytedance.android.annie.util.c.b(this.c, 2131897336);
        UploadFileFragment r0 = this.a;
        int r1 = UploadFileFragment.i;
        r0.T90(null);
    }

    @Override // com.bytedance.android.annie.card.web.a
    public final void onPermissionGranted() {
        UploadFileFragment r0 = this.a;
        Intent r1 = this.b;
        int r10 = UploadFileFragment.i;
        r0.V90(r1);
    }

    public b(UploadFileFragment r1, Intent r10, FragmentActivity r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
