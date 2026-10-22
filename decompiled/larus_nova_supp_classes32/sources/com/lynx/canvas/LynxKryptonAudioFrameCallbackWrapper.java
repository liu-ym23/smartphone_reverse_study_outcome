package com.lynx.canvas;

import com.lynx.canvas.callback.AudioFrameCallback;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonAudioFrameCallback;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class LynxKryptonAudioFrameCallbackWrapper implements AudioFrameCallback {
    private final LynxKryptonAudioFrameCallback mCallback;

    public LynxKryptonAudioFrameCallbackWrapper(LynxKryptonAudioFrameCallback r2) {
        Objects.requireNonNull(r2, "callback");
        this.mCallback = r2;
    }

    @Override // com.lynx.canvas.callback.AudioFrameCallback
    public void onAudioFrame(ByteBuffer r9, int r10, int r11, int r12, int r13, long r14) {
        this.mCallback.onAudioFrame(r9, r10, r11, r12, r13, r14);
    }
}
