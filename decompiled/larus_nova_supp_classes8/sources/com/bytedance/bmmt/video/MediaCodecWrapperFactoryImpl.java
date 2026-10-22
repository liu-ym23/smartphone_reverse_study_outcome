package com.bytedance.bmmt.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {

    public static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        private final MediaCodec mediaCodec;

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public Surface createInputSurface() {
            return this.mediaCodec.createInputSurface();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void flush() {
            this.mediaCodec.flush();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaCodecInfo getCodecInfo() {
            return this.mediaCodec.getCodecInfo();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer[] getInputBuffers() {
            return this.mediaCodec.getInputBuffers();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer[] getOutputBuffers() {
            return this.mediaCodec.getOutputBuffers();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            return this.mediaCodec.getOutputFormat();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public List<String> getSupportedVendorParameters() {
            if (Build.VERSION.SDK_INT >= 31) goto L5;
            return null;
        L5:
            return this.mediaCodec.getSupportedVendorParameters();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void release() {
            this.mediaCodec.release();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void start() {
            this.mediaCodec.start();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void stop() {
            this.mediaCodec.stop();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaCodec getRealCodec() {
            return this.mediaCodec;
        }

        public MediaCodecWrapperImpl(MediaCodec r1) {
            this.mediaCodec = r1;
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public int dequeueInputBuffer(long r2) {
            return this.mediaCodec.dequeueInputBuffer(r2);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer getInputBuffer(int r2) {
            return this.mediaCodec.getInputBuffer(r2);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer getOutputBuffer(int r2) {
            return this.mediaCodec.getOutputBuffer(r2);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaFormat getOutputFormat(int r2) {
            return this.mediaCodec.getOutputFormat(r2);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void setOutputSurface(Surface r3) {
            if (Build.VERSION.SDK_INT < 23) goto L6;
            this.mediaCodec.setOutputSurface(r3);
            return;
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void setParameters(Bundle r2) {
            this.mediaCodec.setParameters(r2);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo r2, long r3) {
            return this.mediaCodec.dequeueOutputBuffer(r2, r3);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void releaseOutputBuffer(int r2, long r3) {
            this.mediaCodec.releaseOutputBuffer(r2, r3);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void setCallback(MediaCodec.Callback r3, Handler r4) {
            if (Build.VERSION.SDK_INT < 23) goto L8;
            if (r4 != null) goto L7;
            this.mediaCodec.setCallback(r3);
            return;
        L7:
            this.mediaCodec.setCallback(r3, r4);
            return;
        L8:
            this.mediaCodec.setCallback(r3);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void releaseOutputBuffer(int r2, boolean r3) {
            this.mediaCodec.releaseOutputBuffer(r2, r3);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void configure(MediaFormat r2, Surface r3, MediaCrypto r4, int r5) {
            this.mediaCodec.configure(r2, r3, r4, r5);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void queueInputBuffer(int r8, int r9, int r10, long r11, int r13) {
            this.mediaCodec.queueInputBuffer(r8, r9, r10, r11, r13);
        }
    }

    public MediaCodecWrapperFactoryImpl() {
    }

    @Override // com.bytedance.bmmt.video.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String r2) throws IOException {
        return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(r2));
    }
}
