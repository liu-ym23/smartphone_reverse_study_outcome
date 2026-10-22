package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.widget.TapGuideView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements Runnable {
    public final /* synthetic */ GestureGuideCompositeWidget a;

    public m(GestureGuideCompositeWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    L23:
        return;
    L3:
        if (this.a.isViewValid() == false) goto L18;
        GestureGuideCompositeWidget r0 = this.a;     // Catch: Throwable -> L15
        if (r0.e == null) goto L22;
        ViewGroup r1 = r0.xq();     // Catch: Throwable -> L15
        if (r1 == null) goto L10;
        r1.removeView(this.a.e);     // Catch: Throwable -> L15
    L10:
        TapGuideView r2 = this.a.e;     // Catch: Throwable -> L15
        if (r2 == null) goto L13;
        r2.b();     // Catch: Throwable -> L15
    L13:
        this.a.e = null;     // Catch: Throwable -> L15
        return;
    L22:
        return;
    }
}
