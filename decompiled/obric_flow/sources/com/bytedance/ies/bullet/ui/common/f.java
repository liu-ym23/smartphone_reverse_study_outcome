package com.bytedance.ies.bullet.ui.common;

import android.app.Activity;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BulletContainerView f6205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6206b;

    public f(BulletContainerView r5, long r10) {
        this.f6205a = r5;
        this.f6206b = r10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        BulletContainerView r5 = this.f6205a;
        Activity r10 = ug.a.a(r5.getContext());
        if (r10 == null) goto L6;
        r10.runOnUiThread(new e(r5, this.f6206b, 0));
        return;
    }
}
