package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Runnable {
    public final /* synthetic */ BaseGLTextureView.a a;

    @Override // java.lang.Runnable
    public final void run() {
        BaseGLTextureView r0 = this.a.a;     // Catch: Throwable -> L4
        int r1 = BaseGLTextureView.g;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BaseGLTextureView.a r1, hb0.a r2) {
        this.a = r1;
    }
}
