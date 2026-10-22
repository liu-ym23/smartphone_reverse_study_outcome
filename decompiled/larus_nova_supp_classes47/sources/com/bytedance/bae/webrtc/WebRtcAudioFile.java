package com.bytedance.bae.webrtc;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import f06.b;
import f06.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Vector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
class WebRtcAudioFile {
    private static final int MAX_DECODER_RETRY_COUNT = 100;
    private static final String TAG = "WebRtcAudioRecordFile";
    private boolean eoInputStream;
    private boolean eoOutputStream;
    private int mChannels;
    private byte[] mDecodedData;
    private MediaExtractor mExtractor;
    private long mFileLength;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private int mRetryCount;
    private int mSampleRate;
    private Vector<Integer> mTrackIds;
    private MediaFormat mUsedTrackFormat;
    private int mUsedTrackIdx;
    private HttpURLConnection oc;

    private boolean checkInfoChange() {
        MediaFormat r1 = this.mMediaCodec.getOutputFormat();     // Catch: Exception -> L12
        int r2 = r1.getInteger("sample-rate");     // Catch: Exception -> L12
        int r3 = r1.getInteger("channel-count");     // Catch: Exception -> L12
        if (this.mSampleRate == r2) goto L6;
    L9:
        boolean r4 = true;
    L10:
        this.mSampleRate = r2;     // Catch: Exception -> L12
        this.mChannels = r3;     // Catch: Exception -> L12
        return r4;
    L6:
        if (this.mChannels != r3) goto L9;
        r4 = false;
    L12:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when checking file's new format");
        return false;
    }

    public void disConnectURL() {
        RXLogging.e(TAG, "disConnectURL");
        HttpURLConnection r0 = this.oc;
        if (r0 == null) goto L6;
        r0.disconnect();
        return;
    }

    public int getAudioTrackCount() {
        Vector<Integer> r0 = this.mTrackIds;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public long getCurrentFilePosition() {
        return this.mExtractor.getSampleTime() / 1000;
    L4:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when getCurrentFilePosition");
        return 0;
    }

    public long getFileLength() {
        return this.mFileLength / 1000;
    }

    public boolean readAudioData() {
        MediaCodec r4 = this.mMediaCodec;     // Catch: Exception -> L60
        if (r4 == null) goto L59;
        if (this.mExtractor == null) goto L59;
        if (this.eoInputStream == true) goto L21;
        int r12 = r4.dequeueInputBuffer(0);     // Catch: Exception -> L60
        if (r12 < 0) goto L21;
        int r5 = this.mExtractor.readSampleData(this.mMediaCodec.getInputBuffer(r12), 0);     // Catch: Exception -> L60
        if (r5 > 0) goto L15;
        this.eoInputStream = true;     // Catch: Exception -> L60
        int r13 = 0;
    L16:
        long r14 = this.mExtractor.getSampleTime();     // Catch: Exception -> L60
        int r6 = this.mExtractor.getSampleFlags();     // Catch: Exception -> L60
        if (this.eoInputStream == false) goto L19;
        r6 = r6 | 4;     // Catch: Exception -> L60
    L19:
        this.mMediaCodec.queueInputBuffer(r12, 0, r13, r14, r6);     // Catch: Exception -> L60
        this.mExtractor.advance();     // Catch: Exception -> L60
        goto L21
    L15:
        r13 = r5;
    L21:
        if (this.eoOutputStream == true) goto L63;
        MediaCodec.BufferInfo r7 = new MediaCodec.BufferInfo();     // Catch: Exception -> L60
        int r8 = this.mMediaCodec.dequeueOutputBuffer(r7, 0);     // Catch: Exception -> L60
        this.mDecodedData = null;     // Catch: Exception -> L60
        if (r8 != (-3)) goto L25;
    L57:
        this.mDecodedData = new byte[0];     // Catch: Exception -> L60
        goto L63
    L25:
        if (r8 == (-2)) goto L57;
        if (r8 == (-1)) goto L45;
        this.mRetryCount = 0;     // Catch: Exception -> L60
        if (r8 < 0) goto L63;
        if ((r7.flags & 4) != 4) goto L33;
        this.eoOutputStream = true;     // Catch: Exception -> L60
    L33:
        ByteBuffer r0 = this.mMediaCodec.getOutputBuffer(r8);     // Catch: Exception -> L60
        int r2 = this.mUsedTrackFormat.getInteger("channel-count");     // Catch: Exception -> L60
        int r3 = this.mChannels;     // Catch: Exception -> L60
        if (r2 != r3) goto L36;
    L42:
        if (r2 != r3) goto L44;
        byte[] r9 = new byte[r0.limit()];     // Catch: Exception -> L60
        this.mDecodedData = r9;     // Catch: Exception -> L60
        r0.get(r9, r7.offset, r7.size);     // Catch: Exception -> L60
        r0.clear();     // Catch: Exception -> L60
    L44:
        this.mMediaCodec.releaseOutputBuffer(r8, false);     // Catch: Exception -> L60
        goto L63
    L36:
        if (r3 != 2) goto L42;
        this.mDecodedData = new byte[r0.limit() * 2];     // Catch: Exception -> L60
        int r10 = 0;
    L39:
        if (r10 >= (r7.size / 2)) goto L41;
        int r15 = r10 * 4;     // Catch: Exception -> L60
        this.mDecodedData[r15] = r0.get();     // Catch: Exception -> L60
        byte[] r16 = this.mDecodedData;     // Catch: Exception -> L60
        r16[r15 + 2] = r16[r15];     // Catch: Exception -> L60
        int r17 = r15 + 1;     // Catch: Exception -> L60
        r16[r17] = r0.get();     // Catch: Exception -> L60
        byte[] r18 = this.mDecodedData;     // Catch: Exception -> L60
        r18[r15 + 3] = r18[r17];     // Catch: Exception -> L60
        r10 = r10 + 1;     // Catch: Exception -> L60
        goto L39
    L41:
        r0.clear();     // Catch: Exception -> L60
        goto L44
    L45:
        int r19 = this.mRetryCount + 1;     // Catch: Exception -> L60
        this.mRetryCount = r19;     // Catch: Exception -> L60
        if (r19 < MAX_DECODER_RETRY_COUNT) goto L56;
        String r20 = Build.BRAND;     // Catch: Exception -> L60
        if (r20.toLowerCase().contains("meizu") == true) goto L55;
        String r22 = Build.MANUFACTURER;     // Catch: Exception -> L60
        if (r22.toLowerCase().contains("meizu") == true) goto L55;
        if (r20.toLowerCase().contains("vivo") == true) goto L55;
        if (r22.toLowerCase().contains("vivo") == false) goto L56;
    L55:
        RXLogging.e(TAG, "EAGAIN count=" + this.mRetryCount + " presentationTimeUs=" + r7.presentationTimeUs + " totalUs=" + this.mFileLength + " Force EOS");     // Catch: Exception -> L60
        this.eoOutputStream = true;     // Catch: Exception -> L60
        this.mRetryCount = 0;     // Catch: Exception -> L60
    L56:
        this.mDecodedData = new byte[0];     // Catch: Exception -> L60
        Thread.sleep(3);     // Catch: Exception -> L60
    L63:
        return this.eoOutputStream;
    L59:
        return this.eoInputStream;
    L60:
        e = move-exception;
        e.printStackTrace();
        goto L63
    }

    public void uninit() {
        MediaCodec r0 = this.mMediaCodec;     // Catch: Exception -> L9
        if (r0 == null) goto L5;
        r0.stop();     // Catch: Exception -> L9
        this.mMediaCodec.release();     // Catch: Exception -> L9
        this.mMediaCodec = null;     // Catch: Exception -> L9
    L5:
        MediaExtractor r1 = this.mExtractor;     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        r1.release();     // Catch: Exception -> L9
        this.mExtractor = null;     // Catch: Exception -> L9
    L11:
        this.eoOutputStream = false;
        this.eoInputStream = false;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when releasing audio file stream" + e.getMessage());
        goto L11
    }

    public WebRtcAudioFile() {
        this.mSampleRate = 0;
        this.mChannels = 0;
        RXLogging.e(TAG, "AudioMix WebRtcAudioFile");
    }

    public int getChannelCount() {
        return this.mChannels;
    }

    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int getUsedTrackIdx() {
        return this.mUsedTrackIdx;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_bytedance_bae_webrtc_WebRtcAudioFile_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private boolean checkUrlEncoded(String r2) {
        return !TextUtils.equals(r2, URLDecoder.decode(r2, "UTF-8"));
    L5:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when releasing audio file stream");
        return false;
    }

    private String encodeUrl(String r12) {
        RXLogging.e(TAG, "encodedUrl");
        URL r0 = new URL(r12);     // Catch: Exception -> L5
        return new URI(r0.getProtocol(), r0.getUserInfo(), r0.getHost(), r0.getPort(), r0.getPath(), r0.getQuery(), r0.getRef()).toASCIIString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return r12;
    }

    private boolean isAvailableOnlineURL(String r6) {
        RXLogging.e(TAG, "isAvailableOnlineURL");
        this.oc = null;
        HttpURLConnection r7 = (HttpURLConnection) INVOKEVIRTUAL_com_bytedance_bae_webrtc_WebRtcAudioFile_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r6));     // Catch: Throwable -> L14 Exception -> L16
        this.oc = r7;     // Catch: Throwable -> L14 Exception -> L16
        r7.setUseCaches(false);     // Catch: Throwable -> L14 Exception -> L16
        this.oc.setConnectTimeout(4000);     // Catch: Throwable -> L14 Exception -> L16
        RXLogging.e(TAG, "connect done....");     // Catch: Throwable -> L14 Exception -> L16
        int r8 = this.oc.getResponseCode();     // Catch: Throwable -> L14 Exception -> L16
        if (200 != r8) goto L6;
        boolean r9 = true;
    L7:
        InputStream r0 = this.oc.getInputStream();     // Catch: Throwable -> L14 Exception -> L16
        if (r0 == null) goto L10;
        r0.close();     // Catch: Throwable -> L14 Exception -> L16
    L10:
        HttpURLConnection r1 = this.oc;
        if (r1 == null) goto L29;
        r1.disconnect();
    L29:
        return r9;
    L6:
        RXLogging.e(TAG, "url is not available, error:" + r8);     // Catch: Throwable -> L14 Exception -> L16
        r9 = false;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        RXLogging.e(TAG, "++Error when test online url: " + e.getMessage());     // Catch: Throwable -> L14
        HttpURLConnection r10 = this.oc;
        if (r10 == null) goto L30;
        r10.disconnect();
        return false;
    L30:
        return false;
    L14:
        th = move-exception;
        HttpURLConnection r2 = this.oc;
        if (r2 == null) goto L25;
        r2.disconnect();
    L25:
        throw th;
    }

    public void selectTrack(int r8) {
        Vector<Integer> r5 = this.mTrackIds;     // Catch: Exception -> L25
        if (r5 != null) goto L7;
        return;
    L7:
        if ((r8 + 1) <= r5.size()) goto L10;
        return;
    L10:
        if (this.mUsedTrackIdx != r8) goto L12;
        return;
    L12:
        MediaExtractor r6 = this.mExtractor;     // Catch: Exception -> L25
        if (r6 != null) goto L15;
    L23:
        RXLogging.e(TAG, "mExtractor or mMediaCodec is null, mExtractor = " + this.mExtractor + ", mMediaCodec = " + this.mMediaCodec);     // Catch: Exception -> L25
        return;
    L15:
        if (this.mMediaCodec == null) goto L23;
        MediaFormat r4 = r6.getTrackFormat(this.mTrackIds.get(r8).intValue());     // Catch: Exception -> L25
        if (this.mSampleRate == r4.getInteger("sample-rate")) goto L21;
        RXLogging.e(TAG, "mSampleRate = " + this.mSampleRate + ", used_SampleRate = " + r4.getInteger("sample-rate"));     // Catch: Exception -> L25
        return;
    L21:
        long r7 = this.mExtractor.getSampleTime();     // Catch: Exception -> L25
        RXLogging.e(TAG, "++current_postion = " + r7);     // Catch: Exception -> L25
        this.mExtractor.unselectTrack(this.mTrackIds.get(this.mUsedTrackIdx).intValue());     // Catch: Exception -> L25
        this.mMediaCodec.stop();     // Catch: Exception -> L25
        r4.getString("mime");     // Catch: Exception -> L25
        this.mExtractor.selectTrack(this.mTrackIds.get(r8).intValue());     // Catch: Exception -> L25
        this.mExtractor.seekTo(r7, 2);     // Catch: Exception -> L25
        this.mMediaCodec.configure(r4, null, null, 0);     // Catch: Exception -> L25
        this.mMediaCodec.start();     // Catch: Exception -> L25
        this.mUsedTrackFormat = r4;     // Catch: Exception -> L25
        this.mUsedTrackIdx = r8;     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when selectTrack");
    }

    public void setCurrentFilePosition(long r5) {
        if (this.eoOutputStream == false) goto L15;
        this.mMediaCodec.flush();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when setCurrentFilePosition, mMediaCodec.flush");
    L15:
        this.mExtractor.seekTo(r5 * 1000, 2);     // Catch: Exception -> L10
        this.eoInputStream = false;     // Catch: Exception -> L10
        this.eoOutputStream = false;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when setCurrentFilePosition, mExtractor.seekTo");
    }

    public boolean init(String r10, int r12) {
        RXLogging.i(TAG, "Try to decode audio file : " + r10);     // Catch: Exception -> L45
        this.mTrackIds = new Vector();     // Catch: Exception -> L45
        if (URLUtil.isNetworkUrl(r10) == true) goto L6;
    L13:
        this.mRetryCount = 0;     // Catch: Exception -> L45
        this.mExtractor = new MediaExtractor();     // Catch: Exception -> L45
        Context r1 = ContextUtils.getApplicationContext();     // Catch: Exception -> L45
        if (r10.startsWith("/assets/") == false) goto L18;
        if (r1 == null) goto L18;
        AssetFileDescriptor r13 = r1.getAssets().openFd(r10.substring(8));     // Catch: Exception -> L45
        this.mExtractor.setDataSource(r13.getFileDescriptor(), r13.getStartOffset(), r13.getLength());     // Catch: Exception -> L45
    L22:
        int r14 = this.mExtractor.getTrackCount();     // Catch: Exception -> L45
        int r2 = 0;
    L23:
        if (r2 >= r14) goto L26;
        this.mExtractor.unselectTrack(r2);     // Catch: Exception -> L45
        r2 = r2 + 1;     // Catch: Exception -> L45
        goto L23
    L26:
        if ((r12 + 1) <= r14) goto L29;
        RXLogging.e(TAG, "useTrack > trackCount");     // Catch: Exception -> L45
        return false;
    L29:
        this.mChannels = 0;     // Catch: Exception -> L45
        int r3 = 0;
        int r4 = 0;
    L30:
        if (r3 >= r14) goto L39;
        MediaFormat r5 = this.mExtractor.getTrackFormat(r3);     // Catch: Exception -> L45
        String r6 = r5.getString("mime");     // Catch: Exception -> L45
        if (r6.contains("audio/") == false) goto L38;
        if (r12 != r4) goto L35;
        this.mExtractor.selectTrack(r3);     // Catch: Exception -> L45
        MediaCodec r7 = MediaCodec.createDecoderByType(r6);     // Catch: Exception -> L45
        this.mMediaCodec = r7;     // Catch: Exception -> L45
        r7.configure(r5, null, null, 0);     // Catch: Exception -> L45
        this.mUsedTrackFormat = r5;     // Catch: Exception -> L45
        this.mUsedTrackIdx = r4;     // Catch: Exception -> L45
    L35:
        r4 = r4 + 1;     // Catch: Exception -> L45
        this.mTrackIds.addElement(new Integer(r3));     // Catch: Exception -> L45
        int r8 = r5.getInteger("channel-count");     // Catch: Exception -> L45
        if (r8 <= this.mChannels) goto L38;
        this.mChannels = r8;     // Catch: Exception -> L45
    L38:
        r3 = r3 + 1;     // Catch: Exception -> L45
        goto L30
    L39:
        MediaCodec r15 = this.mMediaCodec;     // Catch: Exception -> L45
        if (r15 == null) goto L43;
        r15.start();     // Catch: Exception -> L45
        this.mSampleRate = this.mUsedTrackFormat.getInteger("sample-rate");     // Catch: Exception -> L45
        this.mFileLength = this.mUsedTrackFormat.getLong("durationUs");     // Catch: Exception -> L45
        return true;
    L43:
        RXLogging.e(TAG, "mMediaCodec is null");     // Catch: Exception -> L45
        return false;
    L18:
        if (r10.startsWith("content://") == false) goto L21;
        if (r1 == null) goto L21;
        this.mExtractor.setDataSource(com_bytedance_bae_webrtc_WebRtcAudioFile_android_content_ContentResolver_openFileDescriptor(r1.getContentResolver(), UriProtector.parse(r10), "r").getFileDescriptor());     // Catch: Exception -> L45
    L21:
        this.mExtractor.setDataSource(r10);     // Catch: Exception -> L45
        goto L22
    L6:
        if (checkUrlEncoded(r10) == true) goto L9;
        r10 = encodeUrl(r10);     // Catch: Exception -> L45
    L9:
        if (r10 != null) goto L11;
    L12:
        return false;
    L11:
        if (isAvailableOnlineURL(r10) == true) goto L13;
    L45:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when creating audio file decode, error:" + e.getMessage());
        RXLogging.e(TAG, "stack track: " + Log.getStackTraceString(e));
        return false;
    }

    private static ParcelFileDescriptor com_bytedance_bae_webrtc_WebRtcAudioFile_android_content_ContentResolver_openFileDescriptor(ContentResolver r18, Uri r19, String r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        b r12 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240020);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r18, r1, "android.os.ParcelFileDescriptor", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ParcelFileDescriptor) r4.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r18, r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
