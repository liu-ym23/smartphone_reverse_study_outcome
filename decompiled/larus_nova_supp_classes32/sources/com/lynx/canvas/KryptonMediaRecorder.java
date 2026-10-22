package com.lynx.canvas;

import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface KryptonMediaRecorder {

    public interface Listener {
        void onClipVideoEnd(KryptonMediaRecorder r1, String r2, String r3, float r4, long r5);

        void onClipVideoEndWithError(KryptonMediaRecorder r1, String r2);

        void onRecordFlush(KryptonMediaRecorder r1);

        void onRecordStartError(KryptonMediaRecorder r1, String r2);

        void onRecordStop(KryptonMediaRecorder r1, String r2, String r3, float r4, long r5);

        void onRecordStopWithError(KryptonMediaRecorder r1, String r2);
    }

    boolean clipVideo(long[] r1);

    void configAudio(int r1, int r2, int r3);

    void configVideo(String r1, int r2, int r3, int r4, int r5, int r6);

    void destroy(boolean r1);

    long lastPresentationTime();

    void onAudioSample(ByteBuffer r1, int r2);

    void pauseRecord();

    void resumeRecord();

    void setListener(Listener r1);

    Surface startRecord();

    void stopRecord();
}
