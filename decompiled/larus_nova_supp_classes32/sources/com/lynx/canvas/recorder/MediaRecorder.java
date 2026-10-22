package com.lynx.canvas.recorder;

import android.view.Surface;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonMediaRecorder;
import com.lynx.canvas.KryptonMediaRecorderService;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MediaRecorder implements KryptonMediaRecorder.Listener {
    public static final String TAG = "KryptonMediaRecorder";
    private final KryptonApp mKryptonApp;
    private volatile long mNativePtr;
    private KryptonMediaRecorder mRecorderImpl;

    private native void nativeNotifyClipEndWithError(long r1, String r3);

    private native void nativeNotifyClipEndWithResult(long r1, String r3, String r4, float r5, long r6);

    private native void nativeNotifyFlushRecord(long r1);

    private native void nativeNotifyStartError(long r1, String r3);

    private native void nativeNotifyStopWithError(long r1, String r3);

    private native void nativeNotifyStopWithResult(long r1, String r3, String r4, float r5, long r6);

    private KryptonMediaRecorder createMediaRecorder() {
        KryptonMediaRecorderService r0 = (KryptonMediaRecorderService) this.mKryptonApp.getService(KryptonMediaRecorderService.class);
        if (r0 != null) goto L6;
        KryptonLLog.e("KryptonMediaRecorder", "media recorder service not found");
        return null;
    L6:
        KryptonMediaRecorder r1 = r0.createMediaRecorder();
        if (r1 != null) goto L10;
        KryptonLLog.e("KryptonMediaRecorder", "service create media recorder return null");
        return null;
    L10:
        return r1;
    }

    public long lastPresentationTime() {
        return this.mRecorderImpl.lastPresentationTime();
    }

    public void pauseRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "pause record");
        this.mRecorderImpl.pauseRecord();
    }

    public void resumeRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "resume record");
        this.mRecorderImpl.resumeRecord();
    }

    public Surface startRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "start record");
        return this.mRecorderImpl.startRecord();
    }

    public void stopRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "stop record");
        this.mRecorderImpl.stopRecord();
    }

    public boolean clipVideo(long[] r3) {
        KryptonLLog.i("KryptonMediaRecorder", "clip video");
        return this.mRecorderImpl.clipVideo(r3);
    }

    public synchronized void destroy(boolean r3) {
        monitor-enter(this);
        KryptonLLog.i("KryptonMediaRecorder", "destroy");     // Catch: Throwable -> L6
        this.mNativePtr = 0;     // Catch: Throwable -> L6
        this.mRecorderImpl.destroy(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordFlush(KryptonMediaRecorder r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativePtr == 0) goto L6;
        nativeNotifyFlushRecord(this.mNativePtr);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public MediaRecorder(long r1, KryptonApp r3) {
        this.mNativePtr = r1;
        this.mKryptonApp = r3;
        KryptonMediaRecorder r2 = createMediaRecorder();
        this.mRecorderImpl = r2;
        r2.setListener(this);
    }

    public static MediaRecorder create(long r1, KryptonApp r3) {
        return new MediaRecorder(r1, r3);
    }

    public void onAudioSample(ByteBuffer r2, int r3) {
        this.mRecorderImpl.onAudioSample(r2, r3);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onClipVideoEndWithError(KryptonMediaRecorder r6, String r7) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.w("KryptonMediaRecorder", "on recorder clip end with error " + r7);     // Catch: Throwable -> L9
        nativeNotifyClipEndWithError(this.mNativePtr, r7);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStartError(KryptonMediaRecorder r6, String r7) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.w("KryptonMediaRecorder", "on recorder start error " + r7);     // Catch: Throwable -> L9
        nativeNotifyStartError(this.mNativePtr, r7);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStopWithError(KryptonMediaRecorder r6, String r7) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.w("KryptonMediaRecorder", "on recorder stop with error " + r7);     // Catch: Throwable -> L9
        nativeNotifyStopWithError(this.mNativePtr, r7);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    public void configAudio(int r3, int r4, int r5) {
        KryptonLLog.i("KryptonMediaRecorder", "use audio");
        this.mRecorderImpl.configAudio(r3, r4, r5);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onClipVideoEnd(KryptonMediaRecorder r10, String r11, String r12, float r13, long r14) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.i("KryptonMediaRecorder", "on recorder clip end with result. duration:" + r13 + ", size:" + r14);     // Catch: Throwable -> L9
        nativeNotifyClipEndWithResult(this.mNativePtr, r11, r12, r13, r14);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStop(KryptonMediaRecorder r10, String r11, String r12, float r13, long r14) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.i("KryptonMediaRecorder", "on recorder stop with result. duration:" + r13 + ", size:" + r14);     // Catch: Throwable -> L9
        nativeNotifyStopWithResult(this.mNativePtr, r11, r12, r13, r14);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    public void configVideo(String r8, int r9, int r10, int r11, int r12, int r13) {
        this.mRecorderImpl.configVideo(r8, r9, r10, r11, r12, r13);
    }
}
