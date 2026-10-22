package com.bytedance.bmmt.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
interface MediaCodecWrapper {
    void configure(MediaFormat r1, Surface r2, MediaCrypto r3, int r4);

    Surface createInputSurface();

    int dequeueInputBuffer(long r1);

    int dequeueOutputBuffer(MediaCodec.BufferInfo r1, long r2);

    void flush();

    MediaCodecInfo getCodecInfo();

    ByteBuffer getInputBuffer(int r1);

    ByteBuffer[] getInputBuffers();

    ByteBuffer getOutputBuffer(int r1);

    ByteBuffer[] getOutputBuffers();

    MediaFormat getOutputFormat();

    MediaFormat getOutputFormat(int r1);

    MediaCodec getRealCodec();

    List<String> getSupportedVendorParameters();

    void queueInputBuffer(int r1, int r2, int r3, long r4, int r6);

    void release();

    void releaseOutputBuffer(int r1, long r2);

    void releaseOutputBuffer(int r1, boolean r2);

    void setCallback(MediaCodec.Callback r1, Handler r2);

    void setOutputSurface(Surface r1);

    void setParameters(Bundle r1);

    void start();

    void stop();
}
