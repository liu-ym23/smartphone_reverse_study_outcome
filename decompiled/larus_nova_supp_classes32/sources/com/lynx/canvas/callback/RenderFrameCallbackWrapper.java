package com.lynx.canvas.callback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RenderFrameCallbackWrapper implements RenderFrameCallback {
    private final RenderFrameCallback mCallback;

    public RenderFrameCallbackWrapper(RenderFrameCallback r1) {
        this.mCallback = r1;
    }

    @Override // com.lynx.canvas.callback.RenderFrameCallback
    public void onFrameRender(String r7, long r8, long r10) {
        this.mCallback.onFrameRender(r7, r8, r10);
    }
}
