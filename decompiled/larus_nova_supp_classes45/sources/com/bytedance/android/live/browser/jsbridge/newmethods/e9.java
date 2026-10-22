package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e9 implements DialogInterface.OnClickListener {
    public final /* synthetic */ f9 a;

    public e9(f9 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        jc1.k.n(IOpenPlatformAnchorService.class).unmount();
        r1.dismiss();
        this.a.finishWithSuccess();
        com.bytedance.android.live.core.utils.f2.b(2131920893, 0);
    }
}
