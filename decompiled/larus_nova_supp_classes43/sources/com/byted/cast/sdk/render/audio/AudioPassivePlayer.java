package com.byted.cast.sdk.render.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.RTCAudioProfile;
import com.byted.cast.sdk.utils.HexDump;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import fna.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AudioPassivePlayer implements AudioJitterBufferCallback {
    private static int AAC_PROFILE = 1;
    private static int CHAN_COUNT = 2;
    private static int SAMPLE_IDX = 3;
    private static final String TAG = "AudioPassivePlayer";
    private static String mMineType = "audio/mp4a-latm";
    private int mAACProfile;
    private int mAudioFormat;
    private IAudioListener mAudioListener;
    private RTCAudioProfile mAudioProfile;
    private Boolean mAutoPlayAudio;
    private MediaCodec.BufferInfo mBufferInfo;
    private ContextManager.CastContext mCastContext;
    private int mChannel;
    private MediaCodec mDecoder;
    private ByteBuffer[] mInputBuffers;
    private volatile boolean mIsPlayStarted;
    private CastLogger mLogger;
    private ByteBuffer[] mOutputBuffers;
    private SortedSet<Long> mPtsSet;
    private int mSampleFrame;
    private int mSampleRate;
    private ExecutorService mSingleExecutor;
    private AudioTrack mTrack;
    private String mUserId;

    public static /* synthetic */ void a(AudioPassivePlayer r0, byte[] r1, long r10) {
        r0.lambda$callbackAudioData$0(r1, r10);
    }

    private void releaseDecoder() {
        MediaCodec r0 = this.mDecoder;
        if (r0 == null) goto L5;
        r0.stop();
        this.mDecoder.release();
    L5:
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
    }

    public int getAudioSessionId() {
        AudioTrack r0 = this.mTrack;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getAudioSessionId();
    }

    @Override // com.byted.cast.sdk.render.audio.AudioJitterBufferCallback
    public void onAudioReadyToPlay() {
        if (this.mTrack == null) goto L6;
        this.mLogger.i(TAG, "Start to play");
        INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioPassivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(this.mTrack);
        return;
    }

    public boolean prepareDecoder() {
        this.mLogger.i(TAG, "prepareDecoder audio");
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mDecoder = MediaCodec.createDecoderByType(mMineType);     // Catch: IOException -> L9
        MediaFormat r10 = new MediaFormat();     // Catch: IOException -> L9
        r10.setString("mime", mMineType);     // Catch: IOException -> L9
        r10.setInteger("channel-count", 2);     // Catch: IOException -> L9
        r10.setInteger("sample-rate", 48000);     // Catch: IOException -> L9
        r10.setInteger("is-adts", 1);     // Catch: IOException -> L9
        this.mLogger.i(TAG, "prepareDecoder, before dump");     // Catch: IOException -> L9
        byte[] r11 = {17, -112};     // Catch: IOException -> L9
        this.mLogger.i(TAG, "prepareDecoder, csd-0:" + HexDump.toHexString(r11[0]) + " " + HexDump.toHexString(r11[1]));     // Catch: IOException -> L9
        r10.setByteBuffer("csd-0", ByteBuffer.wrap(r11));     // Catch: IOException -> L9
        this.mDecoder.configure(r10, null, null, 0);     // Catch: IOException -> L9
        MediaCodec r0 = this.mDecoder;
        if (r0 != null) goto L7;
        return false;
    L7:
        r0.start();
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void startPlay() {
        this.mLogger.i(TAG, "AudioTrack start !");
        this.mIsPlayStarted = true;
        this.mSampleFrame = (RTCAudioProfile.getFrameSize(this.mSampleRate) / 2) / 2;
        AudioJitterBuffer.getInstance().setJitterCallback(this).setAudioFormat(this.mSampleRate, 2, 2);
        AudioJitterBuffer.getInstance().start();
        prepareDecoder();
    }

    public void stopPlay() {
        this.mLogger.i(TAG, "AudioTrack stop !");
        if (this.mIsPlayStarted == true) goto L5;
        return;
    L5:
        releaseDecoder();
        AudioJitterBuffer.getInstance().stop();
        AudioTrack r0 = this.mTrack;
        if (r0 == null) goto L8;
        r0.release();
        this.mTrack = null;
    L8:
        this.mIsPlayStarted = false;
    }

    public static void INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioPassivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.play();
        return;
    L6:
        r1.play();
        gna.a.c(r1.hashCode());
    }

    @Override // com.byted.cast.sdk.render.audio.AudioJitterBufferCallback
    public void onAudioSmoothOutput(byte[] r10) {
        AudioTrack r0 = this.mTrack;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.write(r10, 0, r10.length) == r10.length) goto L9;
        this.mLogger.e(TAG, "onAudioSmoothOutput output len invalid：" + r10.length);
        return;
    }

    public void setVolume(float r10) {
        if (this.mTrack == null) goto L6;
        this.mLogger.i(TAG, "setVolume:" + r10);
        this.mTrack.setVolume(r10);
        return;
    }

    private void callbackAudioData(final byte[] r10, final long r11) {
        if (this.mAudioListener == null) goto L6;
        this.mSingleExecutor.execute(new b(this, r10, r11));
        return;
    }

    private void decode(byte[] r12, long r13) {
        int r10 = this.mDecoder.dequeueInputBuffer(10000);
        if (Build.VERSION.SDK_INT <= 21) goto L15;
        if (r10 < 0) goto L9;
        ByteBuffer r0 = this.mDecoder.getInputBuffer(r10);
        if (r0 != null) goto L8;
        return;
    L8:
        r0.clear();
        r0.put(r12, 0, r12.length);
        this.mDecoder.queueInputBuffer(r10, 0, r12.length, r13, 0);
    L9:
        int r14 = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 10000);
        if (r14 < 0) goto L26;
        ByteBuffer r15 = this.mDecoder.getOutputBuffer(r14);
        int r16 = this.mBufferInfo.size;
        byte[] r1 = new byte[r16];
        r15.get(r1, 0, r16);
        r15.clear();
        callbackAudioData(r1, this.mBufferInfo.presentationTimeUs);
        if (this.mAutoPlayAudio.booleanValue() == false) goto L14;
        AudioJitterBuffer.getInstance().append(r1, this.mBufferInfo.presentationTimeUs);
    L14:
        this.mDecoder.releaseOutputBuffer(r14, false);
        goto L9
    L26:
        return;
    L15:
        if (r10 < 0) goto L20;
        ByteBuffer r11 = this.mInputBuffers[r10];
        if (r11 != null) goto L19;
        return;
    L19:
        r11.clear();
        r11.put(r12, 0, r12.length);
        this.mDecoder.queueInputBuffer(r10, 0, r12.length, r13, 0);
    L20:
        int r17 = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 10000);
        if (r17 < 0) goto L35;
        ByteBuffer r18 = this.mOutputBuffers[r17];
        int r19 = this.mBufferInfo.size;
        byte[] r20 = new byte[r19];
        r18.get(r20, 0, r19);
        r18.clear();
        callbackAudioData(r20, this.mBufferInfo.presentationTimeUs);
        if (this.mAutoPlayAudio.booleanValue() == false) goto L25;
        AudioJitterBuffer.getInstance().append(r20, this.mBufferInfo.presentationTimeUs);
    L25:
        this.mDecoder.releaseOutputBuffer(r17, false);
        goto L20
    }

    private /* synthetic */ void lambda$callbackAudioData$0(byte[] r10, long r11) {
        this.mAudioListener.onAudioOutput(this.mUserId, r10, this.mSampleRate, this.mChannel, this.mAudioFormat, this.mAudioProfile.getBitrate(), r11);
    }

    public void addFrame(byte[] r10, long r11) {
        if (this.mPtsSet.contains(Long.valueOf(r11)) == true) goto L8;
        this.mLogger.i(TAG, "addFrame...New...frame.length=" + r10.length + " timestamp=" + r11);
        this.mPtsSet.add(Long.valueOf(r11));
        decode(r10, r11);
        Iterator<Long> r12 = this.mPtsSet.headSet(Long.valueOf(r11 - ((long) (this.mSampleFrame * 5)))).iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        long r13 = r12.next().longValue();
        this.mLogger.i(TAG, "addFrame...Flush...timestamp=" + r13);
        this.mPtsSet.remove(Long.valueOf(r13));
        goto L6
    L11:
        return;
    L8:
        this.mLogger.i(TAG, "addFrame...Skip...frame.length=" + r10.length + " timestamp=" + r11);
    }

    public void addPcm(byte[] r10, long r11) {
        if (this.mAutoPlayAudio.booleanValue() == false) goto L6;
        AudioJitterBuffer.getInstance().append(r10, r11);
        return;
    }

    public AudioPassivePlayer(String r11, ContextManager.CastContext r12, Boolean r13, RTCAudioProfile r14, IAudioListener r15) {
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mAACProfile = 2;
        this.mChannel = 12;
        this.mSampleRate = 48000;
        this.mSampleFrame = 1024;
        this.mIsPlayStarted = false;
        this.mAudioFormat = 2;
        this.mSingleExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory(TAG));
        this.mPtsSet = new ConcurrentSkipListSet();
        this.mUserId = r11;
        this.mCastContext = r12;
        this.mAutoPlayAudio = r13;
        this.mAudioListener = r15;
        this.mAudioProfile = r14;
        CastLogger r16 = ContextManager.getLogger(r12);
        this.mLogger = r16;
        r16.i(TAG, "AudioPassivePlayer, mUserId: " + this.mUserId + ", autoplay: " + this.mAutoPlayAudio + ", mAudioListener: " + this.mAudioListener);
        int r17 = AudioTrack.getMinBufferSize(this.mSampleRate, this.mChannel, this.mAudioFormat);
        if (r17 != (-2)) goto L5;
        this.mLogger.e(TAG, "Invalid parameter !");
    L5:
        int r10 = r17 * 4;
        this.mLogger.i(TAG, "AudioTrack init...minBufferSize=" + r10);
        if (Build.VERSION.SDK_INT < 26) goto L8;
        this.mTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setPerformanceMode(1).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.mSampleRate).setEncoding(this.mAudioFormat).setChannelMask(this.mChannel).build()).setTransferMode(1).setBufferSizeInBytes(r10).build();
        return;
    L8:
        this.mTrack = new AudioTrack(3, this.mSampleRate, this.mChannel, this.mAudioFormat, r10, 1);
    }
}
