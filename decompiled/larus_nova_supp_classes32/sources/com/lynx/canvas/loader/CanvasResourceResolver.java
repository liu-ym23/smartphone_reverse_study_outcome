package com.lynx.canvas.loader;

import android.graphics.Bitmap;
import com.lynx.canvas.KryptonLLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasResourceResolver extends ResourceResolver {
    private static final String TAG = "KryptonCanvasResourceResolver";
    private final long mNativeResolverPtr;
    private final String mUrl;

    private native void nativeReject(String r1, long r2);

    private native void nativeResolveBytes(byte[] r1, int r2, int r3, long r4);

    private native void nativeResolveImage(Bitmap r1, long r2, boolean r4);

    private native void nativeResolveStreamLoadData(byte[] r1, int r2, int r3, long r4);

    private native void nativeResolveStreamLoadEnd(boolean r1, String r2, long r3);

    private native void nativeResolveStreamLoadStart(int r1, long r2);

    private native void nativeResolveText(String r1, long r2);

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void reject(String r3) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Resource request is rejected with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeReject(r3, this.mNativeResolverPtr);
    L5:
        setStatus(ResolverStatus.REJECTED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(Bitmap r4) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Image resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeResolveImage(r4, this.mNativeResolverPtr, r4.isPremultiplied());
    L5:
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadStart(int r3) {
        nativeResolveStreamLoadStart(r3, this.mNativeResolverPtr);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(String r3) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeResolveText(r3, this.mNativeResolverPtr);
    L5:
        setStatus(ResolverStatus.RESOLVED);
    }

    public CanvasResourceResolver(long r1, String r3) {
        this.mNativeResolverPtr = r1;
        this.mUrl = r3;
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadEnd(boolean r3, String r4) {
        nativeResolveStreamLoadEnd(r3, r4, this.mNativeResolverPtr);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolve(byte[] r9, int r10, int r11) {
        if (getStatus() != ResolverStatus.PENDING) goto L5;
        KryptonLLog.i(TAG, "Resource request is resolved with url: " + KryptonResourceUtils.getTruncatePath(this.mUrl));
        nativeResolveBytes(r9, r10, r11, this.mNativeResolverPtr);
    L5:
        setStatus(ResolverStatus.RESOLVED);
    }

    @Override // com.lynx.canvas.loader.ResourceResolver
    public void resolveStreamLoadData(byte[] r7, int r8, int r9) {
        nativeResolveStreamLoadData(r7, r8, r9, this.mNativeResolverPtr);
    }
}
