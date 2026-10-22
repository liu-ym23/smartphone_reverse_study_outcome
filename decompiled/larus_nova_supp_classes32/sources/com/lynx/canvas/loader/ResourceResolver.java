package com.lynx.canvas.loader;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class ResourceResolver {
    private ResolverStatus mStatus;

    public void reject(String r1) {
    }

    public void resolve(Bitmap r1) {
    }

    public void resolve(String r1) {
    }

    public void resolve(byte[] r1, int r2, int r3) {
    }

    public void resolveStreamLoadData(byte[] r1, int r2, int r3) {
    }

    public void resolveStreamLoadEnd(boolean r1, String r2) {
    }

    public void resolveStreamLoadStart(int r1) {
    }

    public ResourceResolver() {
        this.mStatus = ResolverStatus.PENDING;
    }

    public ResolverStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(ResolverStatus r1) {
        this.mStatus = r1;
    }
}
