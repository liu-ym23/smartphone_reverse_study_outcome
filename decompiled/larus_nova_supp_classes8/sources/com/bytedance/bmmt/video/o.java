package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ SurfaceTextureHelper a;

    public /* synthetic */ o(SurfaceTextureHelper r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTextureHelper.g(this.a);
    }
}
