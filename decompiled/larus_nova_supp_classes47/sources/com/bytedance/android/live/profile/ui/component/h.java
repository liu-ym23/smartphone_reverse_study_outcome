package com.bytedance.android.live.profile.ui.component;

import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements Runnable {
    public final /* synthetic */ ProfileCommonComponent a;

    public h(ProfileCommonComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = s1.h(2131107936);     // Catch: Throwable -> L5
        ProfileCommonComponent r1 = this.a;     // Catch: Throwable -> L5
        ProfileCommonComponent.a(r1, r1.i(), r0, r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
