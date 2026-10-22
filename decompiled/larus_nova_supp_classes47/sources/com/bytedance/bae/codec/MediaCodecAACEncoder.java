package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.bytedance.realx.base.RXLogging;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class MediaCodecAACEncoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACEncoder";
    private MediaCodec mAACEncoder;
    private int mBitrate;
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannels;
    private byte[] mEncodedData;
    private int mFrameSize;
    private ByteBuffer[] mInputBuffers;
    private String mMimeType;
    private ByteBuffer[] mOutputBuffers;
    private int mProfile;
    private int mSampleRate;

    public void closeEncoder() {
        MediaCodec r1 = this.mAACEncoder;     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        r1.stop();     // Catch: Exception -> L7
        this.mAACEncoder.release();     // Catch: Exception -> L7
        this.mAACEncoder = null;     // Catch: Exception -> L7
        RXLogging.e(TAG, "close AAC encoder success");     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "close AAC encoder failed");
    }

    public boolean configAndStartEncoder() {
        MediaFormat r1 = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);     // Catch: Exception -> L5
        r1.setInteger("bitrate", this.mBitrate);     // Catch: Exception -> L5
        r1.setInteger("aac-profile", this.mProfile);     // Catch: Exception -> L5
        r1.setInteger("profile", this.mProfile);     // Catch: Exception -> L5
        r1.setInteger("max-input-size", (this.mChannels * this.mFrameSize) * 100);     // Catch: Exception -> L5
        this.mAACEncoder.configure(r1, null, null, 1);     // Catch: Exception -> L5
        this.mAACEncoder.start();     // Catch: Exception -> L5
        this.mBufferInfo = new MediaCodec.BufferInfo();     // Catch: Exception -> L5
        RXLogging.e(TAG, "config AAC encoder success");     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Config and Start Encoder Error");
        return false;
    }

    public boolean openEncoder() {
        this.mAACEncoder = MediaCodec.createEncoderByType(this.mMimeType);     // Catch: Exception -> L9
        RXLogging.e(TAG, "open AAC encoder success");     // Catch: Exception -> L9
        if (this.mAACEncoder == null) goto L8;
        return true;
    L8:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        this.mAACEncoder = null;
        RXLogging.e(TAG, "Open AAC encoder failed");
        return false;
    }

    public MediaCodecAACEncoder() {
        this.mMimeType = "audio/mp4a-latm";
        this.mSampleRate = 44100;
        this.mChannels = 1;
        this.mProfile = 2;
        this.mBitrate = 64000;
        this.mFrameSize = 1024;
        this.mAACEncoder = null;
        RXLogging.e(TAG, "MediaCodecAAC Encoder Created");
    }

    public byte[] getEncodedData() {
        return this.mEncodedData;
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public boolean encodeProcess(byte[] r12) {
        MediaCodec r1 = this.mAACEncoder;     // Catch: Exception -> L18
        if (r1 != null) goto L6;
        return false;
    L6:
        this.mEncodedData = null;     // Catch: Exception -> L18
        int r5 = r1.dequeueInputBuffer(300);     // Catch: Exception -> L18
        if (r5 < 0) goto L9;
        ByteBuffer r2 = this.mAACEncoder.getInputBuffer(r5);     // Catch: Exception -> L18
        r2.clear();     // Catch: Exception -> L18
        r2.put(r12);     // Catch: Exception -> L18
        this.mAACEncoder.queueInputBuffer(r5, 0, r12.length, 0, 0);     // Catch: Exception -> L18
    L9:
        int r13 = this.mAACEncoder.dequeueOutputBuffer(this.mBufferInfo, 0);     // Catch: Exception -> L18
        MediaCodec.BufferInfo r3 = this.mBufferInfo;     // Catch: Exception -> L18
        int r4 = r3.size;     // Catch: Exception -> L18
        int r6 = r3.flags & 2;     // Catch: Exception -> L18
        if (r4 <= 0) goto L17;
        if (r13 < 0) goto L17;
        if (r6 != 2) goto L16;
        this.mAACEncoder.releaseOutputBuffer(r13, false);     // Catch: Exception -> L18
        return true;
    L16:
        ByteBuffer r7 = this.mAACEncoder.getOutputBuffer(r13);     // Catch: Exception -> L18
        byte[] r8 = new byte[r4];     // Catch: Exception -> L18
        this.mEncodedData = r8;     // Catch: Exception -> L18
        r7.get(r8, this.mBufferInfo.offset, r4);     // Catch: Exception -> L18
        r7.clear();     // Catch: Exception -> L18
        this.mAACEncoder.releaseOutputBuffer(r13, false);     // Catch: Exception -> L18
    L17:
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "AAC Encoder Encode failed");
        return false;
    }

    public void setBitRateValue(int r1) {
        this.mBitrate = r1;
    }

    public boolean setBitrate(int r6) {
        MediaCodec r1 = this.mAACEncoder;     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return false;
    L6:
        r1.stop();     // Catch: Exception -> L9
        MediaFormat r2 = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);     // Catch: Exception -> L9
        r2.setInteger("bitrate", r6);     // Catch: Exception -> L9
        r2.setInteger("aac-profile", this.mProfile);     // Catch: Exception -> L9
        this.mAACEncoder.configure(r2, null, null, 1);     // Catch: Exception -> L9
        this.mAACEncoder.start();     // Catch: Exception -> L9
        this.mBitrate = r6;
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Config and Start Encoder Error");
        return false;
    }

    public void setChannelsValue(int r1) {
        this.mChannels = r1;
    }

    public void setProfileValue(String r3) {
        if (r3.equals("he_aac") == false) goto L6;
        this.mProfile = 5;
        this.mFrameSize = 2048;
        return;
    L6:
        if (r3.equals("he_aac_v2") == false) goto L8;
        this.mProfile = 29;
        this.mFrameSize = 2048;
        return;
    L8:
        this.mProfile = 2;
        this.mFrameSize = 1024;
    }

    public void setSampeRateValue(int r1) {
        this.mSampleRate = r1;
    }
}
