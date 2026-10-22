package com.obric.cae.userAware.mediaaware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.obric.cae.log.CommSenseLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AudioAwareInfoManger {
    public static long MAX_FILE_SIZE = 20971520;
    private static final String TAG = "AudioAwareInfoManger";

    @SuppressLint({"StaticFieldLeak"})
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

    public AudioAwareInfoManger(Context r8) {
        this.isRecording = false;
        this.fileCounter = 1;
        HandlerThread r10 = new HandlerThread("AudioRecorderThread");
        this.mRecorderThread = r10;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mAudioScanFileKey = "";
        this.mContext = r8;
        r10.start();
        this.mRecorderHandler = new Handler(r10.getLooper());
    }

    public static /* synthetic */ void a(AudioAwareInfoManger r8) {
        r8.pauseRecording();
    }

    public static /* synthetic */ void b(AudioAwareInfoManger r8) {
        r8.lambda$stopRecording$7();
    }

    public static /* synthetic */ void c(AudioAwareInfoManger r8) {
        r8.lambda$startRecordingExternal$1();
    }

    public static /* synthetic */ void d(AudioAwareInfoManger r8) {
        r8.lambda$startRecording$6();
    }

    public static /* synthetic */ void e(AudioAwareInfoManger r8) {
        r8.lambda$startRecording$2();
    }

    public static /* synthetic */ void f(AudioAwareInfoManger r8, String r10, MediaRecorder r11, int r12, int r13) {
        r8.lambda$startRecording$5(r10, r11, r12, r13);
    }

    public static /* synthetic */ void g(AudioAwareInfoManger r8) {
        r8.lambda$startRecording$3();
    }

    private String generateFileName() {
        return android.aimedia.a.h(android.aimedia.a.k(new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()), "_"), this.fileCounter, ".aac");
    }

    public static String getDeviceIMEI(Context r8) {
    L15:
        e = move-exception;
        CommSenseLog.e(TAG, "Permission denied for getting IMEI", e);
        return "1111111111";
    L4:
        if (Settings.Global.getInt(r8.getContentResolver(), "device_provisioned", 0) != 0) goto L7;
        CommSenseLog.w(TAG, "can not get IMEI when device initializing");     // Catch: SecurityException -> L15
        return "1111111111";
    L7:
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");     // Catch: SecurityException -> L15
        if (r10 != null) goto L11;
        CommSenseLog.e(TAG, "TelephonyManager is null");     // Catch: SecurityException -> L15
        return "1111111111";
    L11:
        String r11 = r10.getImei();     // Catch: SecurityException -> L15
        if (r11 != null) goto L14;
        return "1111111111";
    L14:
        return r11;
    }

    public static AudioAwareInfoManger getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(AudioAwareInfoManger.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AudioAwareInfoManger(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AudioAwareInfoManger.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static /* synthetic */ void h(AudioAwareInfoManger r8, String r10) {
        r8.lambda$startRecording$4(r10);
    }

    public static /* synthetic */ void i(AudioAwareInfoManger r8) {
        r8.resumeRecording();
    }

    public static /* synthetic */ void j(AudioAwareInfoManger r8) {
        r8.stopRecording();
    }

    public static /* synthetic */ void k(AudioAwareInfoManger r8, String r10) {
        r8.lambda$startRecordingExternal$0(r10);
    }

    private /* synthetic */ void lambda$startRecording$2() {
        this.isRecording = false;
    }

    private /* synthetic */ void lambda$startRecording$3() {
        this.isRecording = true;
    }

    private /* synthetic */ void lambda$startRecording$4(String r8) {
        stopRecording();
        this.fileCounter++;
        startRecording(r8);
    }

    private /* synthetic */ void lambda$startRecording$5(String r8, MediaRecorder r10, int r11, int r12) {
        if (r11 != 801) goto L6;
        CommSenseLog.d(TAG, "file size limit reached, stop and start new file");
        this.mRecorderHandler.post(new b(this, r8, 0));
        return;
    }

    private /* synthetic */ void lambda$startRecording$6() {
        this.isRecording = false;
    }

    private /* synthetic */ void lambda$startRecordingExternal$0(String r8) {
        startRecording(r8);
    }

    private /* synthetic */ void lambda$startRecordingExternal$1() {
        startRecording(this.mAudioScanFileDir.getAbsolutePath());
    }

    private /* synthetic */ void lambda$stopRecording$7() {
        this.isRecording = false;
    }

    private void pauseRecording() {
        if (this.isRecording == false) goto L14;
        MediaRecorder r8 = this.mMediaRecorder;
        if (r8 == null) goto L15;
        r8.pause();     // Catch: IllegalStateException -> L9
        CommSenseLog.d(TAG, "record paused");     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "pause recording fail: " + e.getMessage());
        return;
    L15:
        return;
    }

    private void resumeRecording() {
        if (this.isRecording == false) goto L14;
        MediaRecorder r8 = this.mMediaRecorder;
        if (r8 == null) goto L15;
        r8.resume();     // Catch: IllegalStateException -> L9
        CommSenseLog.d(TAG, "record resumed");     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "resume recording fail: " + e.getMessage());
        return;
    L15:
        return;
    }

    private void runOnUiThread(Runnable r8) {
        this.mMainHandler.post(r8);
    }

    private void startRecording(final String r8) {
        String r10 = TAG;
        CommSenseLog.d(r10, "startRecording: " + r8);
        if (this.isRecording == false) goto L6;
        return;
    L6:
        if (this.mMediaRecorder == null) goto L13;
        CommSenseLog.w(r10, "startRecording: mMediaRecorder was not null. Releasing previous instance as a precaution.");
        this.mMediaRecorder.release();     // Catch: Exception -> L10
    L12:
        this.mMediaRecorder = null;
    L10:
        e = move-exception;
        CommSenseLog.w(TAG, "Error releasing previous MediaRecorder" + e);
    L13:
        int r11 = 2;
        File r12 = new File(r8);     // Catch: Throwable -> L22
        int r13 = 1;
        if (r12.exists() == false) goto L17;
    L20:
        this.outputFilePath = r8 + File.separator + generateFileName();     // Catch: Throwable -> L22
        MediaRecorder r14 = new MediaRecorder(this.mContext);     // Catch: Throwable -> L22
        this.mMediaRecorder = r14;     // Catch: Throwable -> L22
        r14.setAudioSource(1);     // Catch: Throwable -> L22
        this.mMediaRecorder.setOutputFormat(6);     // Catch: Throwable -> L22
        this.mMediaRecorder.setAudioEncoder(3);     // Catch: Throwable -> L22
        this.mMediaRecorder.setAudioEncodingBitRate(128000);     // Catch: Throwable -> L22
        this.mMediaRecorder.setAudioSamplingRate(44100);     // Catch: Throwable -> L22
        this.mMediaRecorder.setOutputFile(this.outputFilePath);     // Catch: Throwable -> L22
        this.mMediaRecorder.setMaxFileSize(MAX_FILE_SIZE);     // Catch: Throwable -> L22
        this.mMediaRecorder.prepare();     // Catch: Throwable -> L22
        this.mMediaRecorder.start();     // Catch: Throwable -> L22
        runOnUiThread(new a(this, r11));     // Catch: Throwable -> L22
        CommSenseLog.d(TAG, "start audio recording: " + this.outputFilePath);     // Catch: Throwable -> L22
        this.mMediaRecorder.setOnInfoListener(new d(this, r8));     // Catch: Throwable -> L22
        return;
    L17:
        if (r12.mkdirs() == true) goto L20;
        runOnUiThread(new c(this, r13));     // Catch: Throwable -> L22
        CommSenseLog.e(TAG, "Failed to create directory: " + r8);     // Catch: Throwable -> L22
        return;
    L22:
        e = move-exception;
        runOnUiThread(new c(this, r11));
        CommSenseLog.e(TAG, "start audio record fail: " + e);
        MediaRecorder r15 = this.mMediaRecorder;
        if (r15 == null) goto L36;
        r15.release();     // Catch: Exception -> L27
    L29:
        this.mMediaRecorder = null;
        return;
    L27:
        e = move-exception;
        CommSenseLog.w(TAG, "Error releasing MediaRecorder after failure" + e);
        goto L29
    }

    private void stopRecording() {
        if (this.isRecording == false) goto L18;
        MediaRecorder r8 = this.mMediaRecorder;
        if (r8 != null) goto L19;
        return;
    L19:
        r8.stop();     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mMediaRecorder.release();     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mMediaRecorder = null;     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mAudioScanFileDir = null;     // Catch: Throwable -> L10 IllegalStateException -> L12
        this.mAudioScanFileKey = "";     // Catch: Throwable -> L10 IllegalStateException -> L12
        runOnUiThread(new a(this, 3));     // Catch: Throwable -> L10 IllegalStateException -> L12
        CommSenseLog.d(TAG, "stop recording success: " + this.outputFilePath);     // Catch: Throwable -> L10 IllegalStateException -> L12
    L14:
        this.mMediaRecorder = null;
        return;
    L10:
        th = move-exception;
        this.mMediaRecorder = null;
        throw th;
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "stop recording fail: " + e.getMessage());     // Catch: Throwable -> L10
        goto L14
    }

    public void cleanup() {
        this.mRecorderThread.quitSafely();
        MediaRecorder r8 = this.mMediaRecorder;
        if (r8 == null) goto L6;
        r8.release();
        this.mMediaRecorder = null;
        return;
    }

    public boolean getIsRecording() {
        return this.isRecording;
    }

    public void pauseRecordingExternal() {
        this.mRecorderHandler.post(new a(this, 1));
    }

    public void recordAudioFile(String r8, File r10) {
        this.mAudioScanFileKey = r8;
        this.mAudioScanFileDir = r10;
        CommSenseLog.recordFileWithKey(r8, r10);
    }

    public void resumeRecordingExternal() {
        this.mRecorderHandler.post(new androidx.activity.d(this, 28));
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
        this.mRecorderHandler.post(new a(this, 0));
    }

    public void stopRecordingExternal() {
        this.mRecorderHandler.post(new c(this, 0));
    }

    public void startRecordingExternal(String r8) {
        if (this.isRecording == false) goto L6;
        CommSenseLog.d(TAG, "Already recording, skip");
        return;
    L6:
        this.mRecorderHandler.post(new b(this, r8, 1));
    }
}
