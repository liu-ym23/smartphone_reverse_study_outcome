package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.bytedance.realx.base.RXLogging;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class MediaCodecAACDecoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACDecoder";
    private long input_ts;
    private MediaCodec mAACDecoder;
    private byte[] mAsc;
    private MediaCodec.BufferInfo mBufferInfo;
    private int mChannels;
    private byte[] mDecodedData;
    private int mHasADTS;
    private ByteBuffer[] mInputBuffers;
    private String mMimeType;
    private ByteBuffer[] mOutputBuffers;
    private MediaFormat mOutputFormat;
    private int mProfile;
    private int mSampleRate;
    private long output_ts;

    public boolean configAndStartDecoder() {
        MediaFormat r1 = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);     // Catch: Exception -> L6
        r1.setInteger("aac-profile", this.mProfile);     // Catch: Exception -> L6
        r1.setInteger("is-adts", this.mHasADTS);     // Catch: Exception -> L6
        r1.setInteger("aac-max-output-channel_count", this.mChannels);     // Catch: Exception -> L6
        genAsc();     // Catch: Exception -> L6
        r1.setByteBuffer("csd-0", ByteBuffer.wrap(this.mAsc));     // Catch: Exception -> L6
        this.mAACDecoder.configure(r1, null, null, 0);     // Catch: Exception -> L6
        this.mAACDecoder.start();     // Catch: Exception -> L6
        this.mBufferInfo = new MediaCodec.BufferInfo();     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        closeDecoder();
        RXLogging.e(TAG, "Config and Start Decoder Error");
        return false;
    }

    public boolean openEncoder() {
        MediaCodec r1 = MediaCodec.createDecoderByType(this.mMimeType);     // Catch: Exception -> L7
        this.mAACDecoder = r1;     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        this.mAACDecoder = null;
        RXLogging.e(TAG, "Open AAC Decoder failed");
        return false;
    }

    private void genAsc() {
        int r0 = this.mProfile;
        int r1 = 4;
        if (r0 != 2) goto L5;
        this.mAsc = new byte[2];
    L6:
        int r3 = this.mSampleRate;
        if (48000 != r3) goto L10;
        r1 = 3;
        int r4 = 6;
    L16:
        int r9 = this.mChannels;
        if (1 != r9) goto L19;
        int r10 = 1;
    L22:
        byte r12 = (byte) r0;
        if (2 != r0) goto L25;
        byte[] r2 = this.mAsc;
        r2[0] = (byte) ((r12 << 3) | (r1 >> 1));
        r2[1] = (byte) ((r1 << 7) | (r10 << 3));
        return;
    L25:
        if (5 != r0) goto L28;
        byte[] r5 = this.mAsc;
        r5[0] = (byte) ((r12 << 3) | (r4 >> 1));
        r5[1] = (byte) (((r4 << 7) | (r10 << 3)) | (r1 >> 1));
        r5[2] = (byte) ((r1 << 7) | 8);
        r5[3] = 0;
        return;
    L28:
        if (29 != r0) goto L33;
        byte[] r6 = this.mAsc;
        r6[0] = (byte) ((r12 << 3) | (r4 >> 1));
        r6[1] = (byte) (((r4 << 7) | 8) | (r1 >> 1));
        r6[2] = (byte) ((r1 << 7) | 8);
        r6[3] = 0;
        return;
    L33:
        return;
    L19:
        if (2 != r9) goto L21;
        r10 = 2;
        goto L22
    L21:
        r10 = 0;
        goto L22
    L10:
        if (44100 != r3) goto L13;
        r4 = 7;
        goto L16
    L13:
        if (32000 != r3) goto L15;
        r1 = 5;
        r4 = 8;
        goto L16
    L15:
        r1 = 0;
        r4 = 0;
        goto L16
    L5:
        this.mAsc = new byte[4];
        goto L6
    }

    public void closeDecoder() {
        MediaCodec r0 = this.mAACDecoder;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.stop();     // Catch: Exception -> L6
        this.mAACDecoder.release();     // Catch: Exception -> L6
        this.mAACDecoder = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "close AAC decoder failed");
    }

    public int getOutputChannels() {
        return this.mOutputFormat.getInteger("channel-count");
    }

    public int getOutputSampleRate() {
        return this.mOutputFormat.getInteger("sample-rate");
    }

    public MediaCodecAACDecoder() {
        this.mMimeType = "audio/mp4a-latm";
        this.mSampleRate = 44100;
        this.mChannels = 1;
        this.mProfile = 2;
        this.mHasADTS = 0;
        this.input_ts = 0;
        this.output_ts = 0;
        this.mAACDecoder = null;
        RXLogging.e(TAG, "MediaCodecAAC Decoder Created");
    }

    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    public long getOutputTs() {
        return this.output_ts;
    }

    public boolean decodeProcess(byte[] r13) {
        MediaCodec r1 = this.mAACDecoder;     // Catch: Exception -> L15
        if (r1 != null) goto L6;
        return false;
    L6:
        this.mDecodedData = null;     // Catch: Exception -> L15
        int r5 = r1.dequeueInputBuffer(300);     // Catch: Exception -> L15
        if (r5 < 0) goto L9;
        ByteBuffer r3 = this.mAACDecoder.getInputBuffer(r5);     // Catch: Exception -> L15
        r3.clear();     // Catch: Exception -> L15
        r3.put(r13);     // Catch: Exception -> L15
        this.mAACDecoder.queueInputBuffer(r5, 0, r13.length, (this.input_ts * 1000000) / ((long) this.mSampleRate), 0);     // Catch: Exception -> L15
    L9:
        int r14 = this.mAACDecoder.dequeueOutputBuffer(this.mBufferInfo, 0);     // Catch: Exception -> L15
        MediaCodec.BufferInfo r4 = this.mBufferInfo;     // Catch: Exception -> L15
        int r6 = r4.size;     // Catch: Exception -> L15
        if (r6 <= 0) goto L14;
        if (r14 < 0) goto L14;
        this.output_ts = (r4.presentationTimeUs * ((long) this.mSampleRate)) / 1000000;     // Catch: Exception -> L15
        ByteBuffer r2 = this.mAACDecoder.getOutputBuffer(r14);     // Catch: Exception -> L15
        byte[] r7 = new byte[r6];     // Catch: Exception -> L15
        this.mDecodedData = r7;     // Catch: Exception -> L15
        MediaCodec.BufferInfo r8 = this.mBufferInfo;     // Catch: Exception -> L15
        r2.get(r7, r8.offset, r8.size);     // Catch: Exception -> L15
        r2.clear();     // Catch: Exception -> L15
        this.mOutputFormat = this.mAACDecoder.getOutputFormat(r14);     // Catch: Exception -> L15
        this.mAACDecoder.releaseOutputBuffer(r14, false);     // Catch: Exception -> L15
    L14:
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "AAC Decoder Decode failed");
        return false;
    }

    public void setADTSValue(int r1) {
        this.mHasADTS = r1;
    }

    public void setChannelsValue(int r1) {
        this.mChannels = r1;
    }

    public void setInputTs(long r1) {
        this.input_ts = r1;
    }

    public void setProfileValue(String r2) {
        if (r2.equals("he_aac") == false) goto L6;
        this.mProfile = 5;
        return;
    L6:
        if (r2.equals("he_aac_v2") == false) goto L8;
        this.mProfile = 29;
        return;
    L8:
        this.mProfile = 2;
    }

    public void setSampeRateValue(int r1) {
        this.mSampleRate = r1;
    }
}
