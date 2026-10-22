package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;

/* JADX INFO: loaded from: classes2.dex */
public class DebugOverlayImageOriginListener implements ImageOriginListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7745a;

    public DebugOverlayImageOriginListener() {
        this.f7745a = 1;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public final void a(String r5, int r10, boolean r11, String r12) {
        this.f7745a = r10;
    }
}
