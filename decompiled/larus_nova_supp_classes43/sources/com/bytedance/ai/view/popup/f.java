package com.bytedance.ai.view.popup;

import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ FragmentTransaction b;

    public /* synthetic */ f(String r1, FragmentTransaction r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        FragmentTransaction r1 = this.b;
        int r10 = AppletPopup.R;
        if (r0 != null) goto L10;
    L5:
        r1.commitAllowingStateLoss();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletPopup", "commitNowAllowingStateLossSafely", th);
        return;
    L10:
        r1.addToBackStack(r0);     // Catch: Throwable -> L7
        goto L5
    }
}
