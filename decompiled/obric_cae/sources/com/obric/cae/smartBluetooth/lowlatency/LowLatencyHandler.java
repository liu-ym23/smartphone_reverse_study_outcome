package com.obric.cae.smartBluetooth.lowlatency;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlBqrCallbackController;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import com.obric.cae.utils.CaeUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import defpackage.a;
import defpackage.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LowLatencyHandler {
    private static final int[] BITS_PER_SAMPLES = null;
    private static final int[] CHANNEL_MODES = null;
    private static final int MSG_RECOVER_CODEC = 1;
    private static final long RECOVER_CODEC_DELAY_MS = 1000;
    private static final int[] SAMPLE_RATES = null;
    private static final String TAG = "LowLatencyHandler";
    private AppObserver mAppObserver;
    private AudioManager mAudioManager;
    private AudioManagerPlaybackListener mAudioManagerPlaybackListener;
    private BluetoothA2dp mBluetoothA2dp;
    private BluetoothAdapter mBluetoothAdapter;
    private CodecRecoverHandler mCodecRecoverHandler;
    private boolean mCodecRecovery;
    private final Context mContext;
    private final List<String> mGamePackageNames;
    private InnerProcessStateCallback mInnerProcessStateCallback;
    private final Object mRecoverLock;

    public class AudioManagerPlaybackListener extends AudioManager.AudioPlaybackCallback {
        final /* synthetic */ LowLatencyHandler this$0;

        private AudioManagerPlaybackListener(LowLatencyHandler r8) {
            this.this$0 = r8;
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> r8) {
            CaeLog.d(LowLatencyHandler.TAG, "onPlaybackConfigChanged");
            Iterator<AudioPlaybackConfiguration> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L14;
            AudioPlaybackConfiguration r11 = r10.next();
            AudioAttributes r12 = r11.getAudioAttributes();
            if (r12 == null) goto L4;
            if (r12.getContentType() != 2) goto L4;
            if (r11.isActive() == false) goto L14;
            if (LowLatencyHandler.access$500(this.this$0).isMusicActive() == false) goto L14;
            boolean r13 = true;
        L15:
            if (r13 == true) goto L26;
            CaeLog.d(LowLatencyHandler.TAG, "all playback is not in active.");
            if (LowLatencyHandler.access$600(this.this$0) == false) goto L27;
            LowLatencyHandler.access$700(this.this$0, false);
            LowLatencyHandler.access$800(this.this$0, 1);
            return;
        L27:
            return;
        L26:
            return;
        L14:
            r13 = false;
            goto L15
        }

        public /* synthetic */ AudioManagerPlaybackListener(LowLatencyHandler r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class CodecRecoverHandler extends Handler {
        final /* synthetic */ LowLatencyHandler this$0;

        public CodecRecoverHandler(LowLatencyHandler r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != 1) goto L7;
            LowLatencyHandler.access$300(this.this$0, true);
            return;
        }
    }

    public class InnerProcessStateCallback implements ProcessStateCallback {
        final /* synthetic */ LowLatencyHandler this$0;

        private InnerProcessStateCallback(LowLatencyHandler r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.smartBluetooth.lowlatency.ProcessStateCallback
        public void onProcessDied(String r8, int r10, int r11) {
            StringBuilder r12 = new StringBuilder("onProcessDied: pkg = ");
            r12.append(r8);
            r12.append(", pid = ");
            r12.append(r10);
            r12.append(", uid = ");
            a.j(r12, r11, LowLatencyHandler.TAG);
            Message r13 = LowLatencyHandler.access$400(this.this$0).obtainMessage(1);
            LowLatencyHandler.access$400(this.this$0).sendMessageDelayed(r13, 1000);
        }

        @Override // com.obric.cae.smartBluetooth.lowlatency.ProcessStateCallback
        public void onProcessStart(String r8, int r10, int r11) {
            StringBuilder r12 = new StringBuilder("onProcessStart: pkg = ");
            r12.append(r8);
            r12.append(", pid = ");
            r12.append(r10);
            r12.append(", uid = ");
            a.j(r12, r11, LowLatencyHandler.TAG);
            LowLatencyHandler.access$300(this.this$0, false);
        }

        public /* synthetic */ InnerProcessStateCallback(LowLatencyHandler r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        SAMPLE_RATES = new int[]{32, 16, 8, 4, 2, 1};
        BITS_PER_SAMPLES = new int[]{4, 2, 1};
        CHANNEL_MODES = new int[]{2, 1};
    }

    public LowLatencyHandler(Context r8) {
        this.mGamePackageNames = new ArrayList();
        this.mRecoverLock = new Object();
        this.mContext = r8;
        initAppObserver();
        initAudioPlayback();
        initBluetoothA2dp();
    }

    public static /* synthetic */ BluetoothA2dp access$102(LowLatencyHandler r8, BluetoothA2dp r10) {
        r8.mBluetoothA2dp = r10;
        return r10;
    }

    public static /* synthetic */ void access$300(LowLatencyHandler r8, boolean r10) {
        r8.switchCodecCheck(r10);
    }

    public static /* synthetic */ CodecRecoverHandler access$400(LowLatencyHandler r8) {
        return r8.mCodecRecoverHandler;
    }

    public static /* synthetic */ AudioManager access$500(LowLatencyHandler r8) {
        return r8.mAudioManager;
    }

    public static /* synthetic */ boolean access$600(LowLatencyHandler r8) {
        return r8.isCodecRecovery();
    }

    public static /* synthetic */ void access$700(LowLatencyHandler r8, boolean r10) {
        r8.setCodecRecovery(r10);
    }

    public static /* synthetic */ void access$800(LowLatencyHandler r8, int r10) {
        r8.switchCodec(r10);
    }

    private int getHighestBitsPerSample(BluetoothCodecConfig r8) {
        if (r8 != null) goto L6;
        CaeLog.d(TAG, "Unable to get highest bits per sample. Config is empty");
        return 0;
    L6:
        int r10 = r8.getBitsPerSample();
        int r11 = 0;
    L7:
        int[] r12 = BITS_PER_SAMPLES;
        if (r11 >= r12.length) goto L13;
        int r13 = r12[r11];
        if ((r10 & r13) != 0) goto L11;
        r11 = r11 + 1;
        goto L7
    L11:
        return r13;
    L13:
        return 0;
    }

    private int getHighestChannelMode(BluetoothCodecConfig r8) {
        if (r8 != null) goto L6;
        CaeLog.d(TAG, "Unable to get highest channel mode. Config is empty");
        return 0;
    L6:
        int r10 = r8.getChannelMode();
        int r11 = 0;
    L7:
        int[] r12 = CHANNEL_MODES;
        if (r11 >= r12.length) goto L13;
        int r13 = r12[r11];
        if ((r10 & r13) != 0) goto L11;
        r11 = r11 + 1;
        goto L7
    L11:
        return r13;
    L13:
        return 0;
    }

    private int getHighestSampleRate(BluetoothCodecConfig r8) {
        if (r8 != null) goto L6;
        CaeLog.d(TAG, "Unable to get highest sample rate. Config is empty");
        return 0;
    L6:
        int r10 = r8.getSampleRate();
        int r11 = 0;
    L7:
        int[] r12 = SAMPLE_RATES;
        if (r11 >= r12.length) goto L13;
        int r13 = r12[r11];
        if ((r10 & r13) != 0) goto L11;
        r11 = r11 + 1;
        goto L7
    L11:
        return r13;
    L13:
        return 0;
    }

    private void initAppObserver() {
        this.mAppObserver = new AppObserver(this.mContext);
        this.mInnerProcessStateCallback = new InnerProcessStateCallback(this, null);
        this.mGamePackageNames.clear();
        String[] r8 = CaeUtil.getLowLatencyPackageNamesPrefs(this.mContext, "low_latency_package_names").split(",");
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        String r12 = r8[r11];
        if (r12.isEmpty() == true) goto L7;
        this.mGamePackageNames.add(r12);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        CaeLog.d(TAG, "Game packages name: " + Arrays.toString(r8));
        this.mAppObserver.registerObserver(this.mGamePackageNames, this.mInnerProcessStateCallback);
    }

    private void initAudioPlayback() {
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(AIMediaEventSchema.MEDIA_TYPE_AUDIO);
        HandlerThread r8 = new HandlerThread("Audio play back");
        r8.start();
        Handler r10 = new Handler(r8.getLooper());
        AudioManagerPlaybackListener r11 = new AudioManagerPlaybackListener(this, null);
        this.mAudioManagerPlaybackListener = r11;
        this.mAudioManager.registerAudioPlaybackCallback(r11, r10);
        HandlerThread r12 = new HandlerThread("Codec recover");
        r12.start();
        this.mCodecRecoverHandler = new CodecRecoverHandler(this, r12.getLooper());
    }

    private void initBluetoothA2dp() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r8;
        r8.getProfileProxy(this.mContext, new AnonymousClass1(this), 2);
    }

    private boolean isA2dpJitterOptimizationActive() {
        A2dpJitterMlBqrCallbackController r8 = SmartBluetoothManager.getInstance(this.mContext).getJitterBqrCallbackController();
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isA2dpJitterOptimizationActive() == false) goto L7;
        return true;
    }

    private boolean isCodecRecovery() {
        Object r8 = this.mRecoverLock;
        monitor-enter(r8);
        boolean r10 = this.mCodecRecovery;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    private void setCodecRecovery(boolean r8) {
        Object r10 = this.mRecoverLock;
        monitor-enter(r10);
        this.mCodecRecovery = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void switchCodec(int r8) {
        b.m("switchCodec: ", r8, TAG);
        if (this.mBluetoothAdapter.isEnabled() == true) goto L5;
        String r10 = "bluetooth is not enabled, return !";
    L14:
        CaeLog.w(TAG, r10);
        return;
    L5:
        BluetoothA2dp r11 = this.mBluetoothA2dp;
        if (r11 != null) goto L8;
        r10 = "bluetooth a2dp is null, return !";
        goto L14
    L8:
        BluetoothDevice r12 = r11.getActiveDevice();
        if (r12 != null) goto L11;
        r10 = "active device is null, return !";
        goto L14
    L11:
        BluetoothCodecStatus r13 = this.mBluetoothA2dp.getCodecStatus(r12);
        if (r13 != null) goto L16;
        r10 = "codec status is null, return !";
        goto L14
    L16:
        Iterator<BluetoothCodecConfig> r14 = r13.getCodecsSelectableCapabilities().iterator();
    L18:
        if (r14.hasNext() == false) goto L22;
        BluetoothCodecConfig r15 = r14.next();
        if (r15.getCodecType() != r8) goto L18;
    L23:
        if (r15 == null) goto L29;
        BluetoothCodecConfig.Builder r16 = new BluetoothCodecConfig.Builder();
        r16.setCodecType(r8).setCodecPriority(TimeUtils.NANOSECONDS_PER_MILLISECOND).setSampleRate(getHighestSampleRate(r15)).setBitsPerSample(getHighestBitsPerSample(r15)).setChannelMode(getHighestChannelMode(r15));
        this.mBluetoothA2dp.setCodecConfigPreference(r12, r16.build());
        return;
    L29:
        return;
    L22:
        r15 = null;
        goto L23
    }

    private void switchCodecCheck(boolean r8) {
        if (r8 == true) goto L9;
        if (isA2dpJitterOptimizationActive() == false) goto L9;
        CaeLog.d(TAG, "a2dp jitter optimization is active, skip low latency codec switch.");
        return;
    L9:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L12;
        CaeLog.w(TAG, "bluetooth is not enabled, return !");
        return;
    L12:
        BluetoothA2dp r10 = this.mBluetoothA2dp;
        if (r10 != null) goto L16;
        CaeLog.w(TAG, "bluetooth a2dp is null, return !");
        return;
    L16:
        BluetoothDevice r11 = r10.getActiveDevice();
        if (r11 != null) goto L20;
        CaeLog.w(TAG, "active device is null, return !");
        return;
    L20:
        BluetoothCodecStatus r12 = this.mBluetoothA2dp.getCodecStatus(r11);
        if (r12 != null) goto L24;
        CaeLog.w(TAG, "codec status is null, return !");
        return;
    L24:
        BluetoothCodecConfig r13 = r12.getCodecConfig();
        if (r13 != null) goto L28;
        CaeLog.w(TAG, "codec config is null, return !");
        return;
    L28:
        int r14 = r13.getCodecType();
        if (r8 == false) goto L41;
        if (r14 == 0) goto L32;
        String r15 = "codec is not sbc, no need to recover to aac codec.";
    L47:
        CaeLog.d(TAG, r15);
        return;
    L32:
        if (this.mAudioManager.isMusicActive() == false) goto L34;
        CaeLog.d(TAG, "music is active, codec will be recovered when music paused.");
        if (isCodecRecovery() == true) goto L50;
        setCodecRecovery(true);
        return;
    L50:
        return;
    L34:
        if (isCodecRecovery() == false) goto L36;
        setCodecRecovery(false);
    L36:
        switchCodec(1);
        return;
    L41:
        if (r14 == 1) goto L43;
        r15 = "codec is not aac, no need switch for low latency.";
        goto L47
    L43:
        if (this.mAudioManager.isMusicActive() == true) goto L45;
        switchCodec(0);
        return;
    L45:
        r15 = "music is active, codec should not be switched.";
        goto L47
    }

    public void updateGamePackageNames(List<String> r8) {
        this.mGamePackageNames.clear();
        this.mGamePackageNames.addAll(r8);
        CaeLog.d(TAG, "Game packages name have been updated: " + this.mGamePackageNames);
        AppObserver r10 = this.mAppObserver;
        if (r10 == null) goto L6;
        r10.unregisterObserver();
        this.mAppObserver.registerObserver(this.mGamePackageNames, this.mInnerProcessStateCallback);
        return;
    }
}
