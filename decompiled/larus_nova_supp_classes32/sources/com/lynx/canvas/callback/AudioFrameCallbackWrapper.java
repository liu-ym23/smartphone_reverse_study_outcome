package com.lynx.canvas.callback;

import com.lynx.canvas.KryptonLLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AudioFrameCallbackWrapper implements AudioFrameCallback {
    private static final String TAG = "AudioFrameCallbackWrapper";
    private final AudioFrameCallback mCallback;

    public AudioFrameCallbackWrapper(AudioFrameCallback r1) {
        this.mCallback = r1;
    }

    @Override // com.lynx.canvas.callback.AudioFrameCallback
    public void onAudioFrame(ByteBuffer r10, int r11, int r12, int r13, int r14, long r15) {
        if (this.mCallback != null) goto L5;
        return;
    L5:
        if (r11 != 0) goto L7;
        return;
    L7:
        ByteBuffer r2 = r10.duplicate().order(ByteOrder.nativeOrder());
        int r1 = r2.capacity();
        if (r11 < 0) goto L13;
        if (r11 > r1) goto L13;
        r2.position(0);
        r2.limit(r11);
        this.mCallback.onAudioFrame(r2, r11, r12, r13, r14, r15);
        return;
    L13:
        KryptonLLog.e(TAG, "invalid audio frame byteLength=" + r11 + ", capacity=" + r1);
    }
}
