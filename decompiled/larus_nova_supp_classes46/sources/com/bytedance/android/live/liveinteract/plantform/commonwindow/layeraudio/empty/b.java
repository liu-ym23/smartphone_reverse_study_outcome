package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty;

import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Runnable {
    public final /* synthetic */ MultiLinkAudioCommonEmptyMicSeatBasicLayer a;
    public final /* synthetic */ View b;

    public b(MultiLinkAudioCommonEmptyMicSeatBasicLayer r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r0 = this.a.i;     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        int r1 = this.b.getWidth();     // Catch: Throwable -> L12
        if (r0.m == false) goto L10;
        r0.d = r1;     // Catch: Throwable -> L12
        if (r0.a() == false) goto L10;
        UIUtils.updateLayout(r0.j, r1, r1);     // Catch: Throwable -> L12
    L10:
        this.a.u(true);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
