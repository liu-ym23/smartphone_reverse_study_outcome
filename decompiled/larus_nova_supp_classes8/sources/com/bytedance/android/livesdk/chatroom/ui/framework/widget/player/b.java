package com.bytedance.android.livesdk.chatroom.ui.framework.widget.player;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {
    public final /* synthetic */ AudiencePlayerCompositeWidget a;
    public final /* synthetic */ ViewGroup b;

    public b(AudiencePlayerCompositeWidget r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Rect r0 = new Rect();
        this.b.getGlobalVisibleRect(r0);
        int r1 = r0.bottom - r0.top;
        Logger.d("PlayerCompositeWidget", "computeVideoBottom->fullScreenHeight " + r1);
        AudiencePlayerCompositeWidget r2 = this.a;
        r2.d = r1 - r2.c;
        Logger.d("PlayerCompositeWidget", "computeVideoBottom->Viewable area： " + this.a.d);
        AudiencePlayerCompositeWidget r3 = this.a;
        ((Widget) r3).dataCenter.put("data_abs_bottom_to_video_height", Integer.valueOf(r3.d));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
