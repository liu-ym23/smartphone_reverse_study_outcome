package com.obric.cae.userAware.mediaaware;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.obric.cae.log.a;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class AudioAwareInfoManger {
    public static long MAX_FILE_SIZE = 20971520;
    private static final String TAG = "AudioAwareInfoManger";
    private static volatile AudioAwareInfoManger sInstance;
    private int fileCounter;
    private volatile boolean isRecording;
    private File mAudioScanFileDir;
    private String mAudioScanFileKey;
    private final Context mContext;
    private final Handler mMainHandler;
    private MediaRecorder mMediaRecorder;
    private final Handler mRecorderHandler;
    private final HandlerThread mRecorderThread;
    private String outputFilePath;

    public AudioAwareInfoManger(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.isRecording = false;
        this.fileCounter = 1;
        HandlerThread r0 = new HandlerThread("AudioRecorderThread");
        this.mRecorderThread = r0;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mAudioScanFileKey = "";
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        r0.start();
        this.mRecorderHandler = new Handler(r0.getLooper());
    }

    private String generateFileName() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + "_" + this.fileCounter + ".aac";
    }

    public static String getDeviceIMEI(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
    L15:
        e = move-exception;
        a.a(TAG, "Permission denied for getting IMEI", e);
        return UserAwareUtil.DEFULT_DEVICE_IMEI;
    L4:
        if (Settings.Global.getInt(r6.getContentResolver(), "device_provisioned", 0) != 0) goto L7;
        a.g(TAG, "can not get IMEI when device initializing");     // Catch: SecurityException -> L15
        return UserAwareUtil.DEFULT_DEVICE_IMEI;
    L7:
        TelephonyManager r7 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L15
        if (r7 != null) goto L11;
        a.i(TAG, "TelephonyManager is null");     // Catch: SecurityException -> L15
        return UserAwareUtil.DEFULT_DEVICE_IMEI;
    L11:
        String r8 = r7.getImei();     // Catch: SecurityException -> L15
        if (r8 != null) goto L14;
        return UserAwareUtil.DEFULT_DEVICE_IMEI;
    L14:
        return r8;
    }

    public static AudioAwareInfoManger getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(AudioAwareInfoManger.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AudioAwareInfoManger(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AudioAwareInfoManger.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static /* synthetic */ void lambda$0tNBD53GIK5dkKbm0bMnjdlLBKA(AudioAwareInfoManger r0) {
        r0.pauseRecording();
    }

    /* JADX INFO: renamed from: lambda$q0ZGJUpzjzNS5-46Uzdwn6C2wLg, reason: not valid java name */
    public static /* synthetic */ void m405lambda$q0ZGJUpzjzNS546Uzdwn6C2wLg(AudioAwareInfoManger r0) {
        r0.resumeRecording();
    }

    public static /* synthetic */ void lambda$qM5ZxzW3yF40vtZYde22SwVbdZI(AudioAwareInfoManger r0) {
        r0.stopRecording();
    }

    private void pauseRecording() {
        if (this.isRecording == false) goto L14;
        MediaRecorder r3 = this.mMediaRecorder;
        if (r3 == null) goto L15;
        r3.pause();     // Catch: IllegalStateException -> L9
        a.c(TAG, "record paused");     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "pause recording fail: " + e.getMessage());
        return;
    L15:
        return;
    }

    private void resumeRecording() {
        if (this.isRecording == false) goto L14;
        MediaRecorder r3 = this.mMediaRecorder;
        if (r3 == null) goto L15;
        r3.resume();     // Catch: IllegalStateException -> L9
        a.c(TAG, "record resumed");     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "resume recording fail: " + e.getMessage());
        return;
    L15:
        return;
    }

    private void runOnUiThread(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mMainHandler.post(r4);
    }

    private void startRecording(final String r8) {
        String r2 = TAG;
        a.c(r2, "startRecording: " + r8);
        if (this.isRecording == false) goto L6;
        return;
    L6:
        if (this.mMediaRecorder == null) goto L36;
        a.g(r2, "startRecording: mMediaRecorder was not null. Releasing previous instance as a precaution.");
        this.mMediaRecorder.release();     // Catch: Exception -> L10
    L12:
        this.mMediaRecorder = null;
    L10:
        e = move-exception;
        a.g(TAG, "Error releasing previous MediaRecorder" + e);
    L36:
        File r3 = new File(r8);     // Catch: Throwable -> L19
        if (r3.exists() == false) goto L16;
    L21:
        this.outputFilePath = r8 + File.separator + generateFileName();     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 31) goto L24;
        this.mMediaRecorder = new MediaRecorder(this.mContext);     // Catch: Throwable -> L19
    L24:
        this.mMediaRecorder.setAudioSource(1);     // Catch: Throwable -> L19
        this.mMediaRecorder.setOutputFormat(6);     // Catch: Throwable -> L19
        this.mMediaRecorder.setAudioEncoder(3);     // Catch: Throwable -> L19
        this.mMediaRecorder.setAudioEncodingBitRate(128000);     // Catch: Throwable -> L19
        this.mMediaRecorder.setAudioSamplingRate(44100);     // Catch: Throwable -> L19
        this.mMediaRecorder.setOutputFile(this.outputFilePath);     // Catch: Throwable -> L19
        this.mMediaRecorder.setMaxFileSize(MAX_FILE_SIZE);     // Catch: Throwable -> L19
        this.mMediaRecorder.prepare();     // Catch: Throwable -> L19
        this.mMediaRecorder.start();     // Catch: Throwable -> L19
        runOnUiThread(new $$Lambda$AudioAwareInfoManger$bO2yiiC8VyP7i9QLvbLHMYpXRXc(this));     // Catch: Throwable -> L19
        a.c(TAG, "start audio recording: " + this.outputFilePath);     // Catch: Throwable -> L19
        this.mMediaRecorder.setOnInfoListener(new $$Lambda$AudioAwareInfoManger$YFK7tlDDozAW6kE39vmAQESCM(this, r8));     // Catch: Throwable -> L19
        return;
    L16:
        if (r3.mkdirs() == true) goto L21;
        runOnUiThread(new $$Lambda$AudioAwareInfoManger$ObWeGbZWNYnqjNHw6kIkmSKoq40(this));     // Catch: Throwable -> L19
        a.i(TAG, "Failed to create directory: " + r8);     // Catch: Throwable -> L19
        return;
    L19:
        e = move-exception;
        runOnUiThread(new $$Lambda$AudioAwareInfoManger$J3OCEZgCxFVO503lrgA7G1Npids(this));
        a.i(TAG, "start audio record fail: " + e);
        MediaRecorder r9 = this.mMediaRecorder;
        if (r9 == null) goto L39;
        r9.release();     // Catch: Exception -> L30
    L32:
        this.mMediaRecorder = null;
        return;
    L30:
        e = move-exception;
        a.g(TAG, "Error releasing MediaRecorder after failure" + e);
        goto L32
    }

    private void stopRecording() {
        if (this.isRecording == false) goto L18;
        MediaRecorder r2 = this.mMediaRecorder;
        if (r2 != null) goto L19;
        return;
    L19:
        r2.stop();     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mMediaRecorder.release();     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mMediaRecorder = null;     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mAudioScanFileDir = null;     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mAudioScanFileKey = "";     // Catch: Throwable -> L10 IllegalStateException -> L12
        runOnUiThread(new $$Lambda$AudioAwareInfoManger$12bIV9kl5rMoTzaioXsbg2mCc(this));     // Catch: Throwable -> L10 IllegalStateException -> L12
        a.c(TAG, "stop recording success: " + this.outputFilePath);     // Catch: Throwable -> L10 IllegalStateException -> L12
    L14:
        this.mMediaRecorder = null;
        return;
    L10:
        th = move-exception;
        this.mMediaRecorder = null;
        throw th;
    L12:
        e = move-exception;
        a.i(TAG, "stop recording fail: " + e.getMessage());     // Catch: Throwable -> L10
        goto L14
    }

    public void cleanup() {
        this.mRecorderThread.quitSafely();
        MediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.release();
        this.mMediaRecorder = null;
        return;
    }

    public boolean getIsRecording() {
        return this.isRecording;
    }

    public /* synthetic */ void lambda$startRecording$2$AudioAwareInfoManger() {
        this.isRecording = false;
    }

    public /* synthetic */ void lambda$startRecording$3$AudioAwareInfoManger() {
        this.isRecording = true;
    }

    public /* synthetic */ void lambda$startRecording$4$AudioAwareInfoManger(String r2) {
        stopRecording();
        this.fileCounter++;
        startRecording(r2);
    }

    public /* synthetic */ void lambda$startRecording$5$AudioAwareInfoManger(final String r1, MediaRecorder r2, int r3, int r4) {
        if (r3 != 801) goto L6;
        a.c(TAG, "file size limit reached, stop and start new file");
        this.mRecorderHandler.post(new $$Lambda$AudioAwareInfoManger$mNQlrjWqMa5sWoWwl6LAE73LbVg(this, r1));
        return;
    }

    public /* synthetic */ void lambda$startRecording$6$AudioAwareInfoManger() {
        this.isRecording = false;
    }

    public /* synthetic */ void lambda$startRecordingExternal$0$AudioAwareInfoManger(String r1) {
        startRecording(r1);
    }

    public /* synthetic */ void lambda$startRecordingExternal$1$AudioAwareInfoManger() {
        startRecording(this.mAudioScanFileDir.getAbsolutePath());
    }

    public /* synthetic */ void lambda$stopRecording$7$AudioAwareInfoManger() {
        this.isRecording = false;
    }

    public void pauseRecordingExternal() {
        this.mRecorderHandler.post(new $$Lambda$AudioAwareInfoManger$0tNBD53GIK5dkKbm0bMnjdlLBKA(this));
    }

    public void recordAudioFile(String r1, File r2) {
        this.mAudioScanFileKey = r1;
        this.mAudioScanFileDir = r2;
        a.a(r1, r2);
    }

    public void resumeRecordingExternal() {
        this.mRecorderHandler.post(new $$Lambda$AudioAwareInfoManger$q0ZGJUpzjzNS546Uzdwn6C2wLg(this));
    }

    public void startRecordingExternal() {
        if (this.isRecording == false) goto L6;
        return;
    L6:
        if (this.mAudioScanFileKey.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mAudioScanFileDir != null) goto L11;
        return;
    L11:
        this.mRecorderHandler.post(new $$Lambda$AudioAwareInfoManger$E5RKoBTqIK7F8OLFk6Kw4J9WAo(this));
    }

    public void startRecordingExternal(final String r3) {
        if (this.isRecording == false) goto L6;
        a.c(TAG, "Already recording, skip");
        return;
    L6:
        this.mRecorderHandler.post(new $$Lambda$AudioAwareInfoManger$qfqdXqH1Q_JXeVb4s6RavLp9SFg(this, r3));
    }

    public void stopRecordingExternal() {
        this.mRecorderHandler.post(new $$Lambda$AudioAwareInfoManger$qM5ZxzW3yF40vtZYde22SwVbdZI(this));
    }
}
