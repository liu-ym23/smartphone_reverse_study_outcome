package com.bytedance.android.live.profile.ui.component;

import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements Runnable {
    public final /* synthetic */ ProfileCustomSkin.GradientColor a;
    public final /* synthetic */ ProfileCommonComponent b;

    public g(ProfileCustomSkin.GradientColor r1, ProfileCommonComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProfileCommonComponent r0 = this.b;     // Catch: Throwable -> L4
        ProfileCommonComponent.a(r0, r0.i(), ColorProtector.parseColor(this.a.from), ColorProtector.parseColor(this.a.to));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
