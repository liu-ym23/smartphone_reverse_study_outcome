package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostAction;
import w20.nc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a3 implements w2.a {
    public final /* synthetic */ w2 a;
    public final /* synthetic */ nc b;
    public final /* synthetic */ Activity c;

    @Override // com.bytedance.android.livesdk.jsbridge.methods.w2.a
    public final void a() {
        this.a.finishWithFailure(new Throwable("System permissionDenied."));
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.w2.a
    public final void b() {
        Integer r0 = this.b.b();
        if (r0 == null) goto L5;
        int r4 = r0.intValue();
    L6:
        w2 r1 = this.a;
        Integer r2 = this.b.a();
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        r1.a = r3;
        jc1.k.n(IHostAction.class).openMultiSelectPhotoLibraryForMultiLink(this.c, 100200, r4, this.a.a, "live_choose_photo", "live_album");
        return;
    L9:
        r3 = 6144;
        goto L10
    L5:
        r4 = 9;
        goto L6
    }

    public a3(w2 r1, nc r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
