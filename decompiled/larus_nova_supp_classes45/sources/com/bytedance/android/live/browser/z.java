package com.bytedance.android.live.browser;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.jsbridge.newmethods.j8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends y6.b<j8> {
    public final /* synthetic */ Fragment b;

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
        return new j8(this.b);
    }

    public z(Fragment r1) {
        this.b = r1;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        j8 r0 = (j8) ((y6.b) this).a;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }
}
