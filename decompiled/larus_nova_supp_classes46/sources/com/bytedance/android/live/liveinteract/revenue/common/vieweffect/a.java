package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ View b;

    public a(b r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b.getWidth();     // Catch: Throwable -> L9
        UIUtils.updateLayout(this.a.a, r0, r0);     // Catch: Throwable -> L9
        HSImageView r1 = this.a.a;     // Catch: Throwable -> L9
        if (r1 == null) goto L5;
        r1.setTranslationX(r0 / 2);     // Catch: Throwable -> L9
    L5:
        HSImageView r2 = this.a.a;     // Catch: Throwable -> L9
        if (r2 == null) goto L12;
        r2.setTranslationY(-(r0 / 2));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
