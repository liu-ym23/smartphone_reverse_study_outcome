package com.obric.cae.smartBluetooth.a2dpJitterML;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.AttributionSource;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.ttnet.org.chromium.base.TimeUtils;
import defpackage.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterAction {
    private static final long A2DP_CHOPPY_EVENT_REPORT_TIMEOUT_MS = 5000;
    private static final int A2DP_CODEC_SWITCH_MAX_RETRY_COUNT = 10;
    private static final long A2DP_CODEC_SWITCH_RETRY_DELAY_MS = 500;
    private static final int[] BITS_PER_SAMPLES = null;
    private static final int[] CHANNEL_MODES = null;
    public static final int CODEC_ACTION_NONE = 0;
    public static final int CODEC_ACTION_OPTIMIZE = 1;
    public static final int CODEC_ACTION_RESTORE = 2;
    private static final int MSG_A2DP_CHOPPY_EVENT_REPORT_TIMEOUT = 1;
    private static final int MSG_A2DP_CODEC_SWITCH_RETRY = 2;
    public static final String OPTIMIZE_ACTION_ADJUST_AAC_PACKET_FORMAT = "adjust_aac_packet_format";
    public static final String OPTIMIZE_ACTION_CODEC_OPTIMIZE = "codec_optimize";
    public static final String OPTIMIZE_ACTION_CODEC_RESTORE = "codec_restore";
    public static final String OPTIMIZE_ACTION_SWITCH_CODEC = "switch_codec";
    private static final int[] SAMPLE_RATES = null;
    private static final String TAG = "A2dpJitterAction";
    private static final String WIFI_BACKGROUND_SCAN_MODE = "wifi_background_scan_mode";
    private static final int WIFI_BACKGROUND_SCAN_MODE_DISABLE_24_GHZ = 1;
    private static final int WIFI_BACKGROUND_SCAN_MODE_ENABLE_24_GHZ = 2;
    private boolean mAacPacketFormatAdjusted;
    private BluetoothA2dp mBluetoothA2dp;
    private final BluetoothAdapter mBluetoothAdapter;
    private int mCodecSwitchRetryCount;
    private boolean mCodecSwitchedToAac;
    private final Context mContext;
    private final ActionHandler mHandler;
    private String mLastOptimizeAction;
    private final BluetoothProfile.ServiceListener mListener;
    private final Map<String, BluetoothCodecConfig> mOriginalCodecConfigByAddress;
    private int mPendingCodecAction;
    private OptimizeActionCallback mPendingOptimizeCallback;

    public class ActionHandler extends Handler {
        final /* synthetic */ A2dpJitterAction this$0;

        public ActionHandler(A2dpJitterAction r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            A2dpJitterAction.access$600(this.this$0, 2);
            return;
        L5:
            if (r10 != 2) goto L12;
            int r11 = A2dpJitterAction.access$100(this.this$0);
            A2dpJitterAction r12 = this.this$0;
            if (r11 != 2) goto L9;
            A2dpJitterAction.access$300(r12);
            return;
        L9:
            A2dpJitterAction.access$200(r12);
            return;
        }
    }

    public interface OptimizeActionCallback {
        void onOptimizeAction(String r8);
    }

    static {
        SAMPLE_RATES = new int[]{32, 16, 8, 4, 2, 1};
        BITS_PER_SAMPLES = new int[]{4, 2, 1};
        CHANNEL_MODES = new int[]{2, 1};
    }

    public A2dpJitterAction(Context r8) {
        this.mOriginalCodecConfigByAddress = new HashMap();
        this.mPendingCodecAction = 0;
        this.mLastOptimizeAction = OPTIMIZE_ACTION_CODEC_OPTIMIZE;
        this.mListener = new AnonymousClass1(this);
        this.mContext = r8.getApplicationContext();
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mHandler = new ActionHandler(this, Looper.getMainLooper());
    }

    public static /* synthetic */ BluetoothA2dp access$002(A2dpJitterAction r8, BluetoothA2dp r10) {
        r8.mBluetoothA2dp = r10;
        return r10;
    }

    public static /* synthetic */ int access$100(A2dpJitterAction r8) {
        return r8.mPendingCodecAction;
    }

    public static /* synthetic */ void access$200(A2dpJitterAction r8) {
        r8.tryRunPendingOptimizeAction();
    }

    public static /* synthetic */ void access$300(A2dpJitterAction r8) {
        r8.tryRunPendingRestoreAction();
    }

    public static /* synthetic */ ActionHandler access$400(A2dpJitterAction r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ int access$502(A2dpJitterAction r8, int r10) {
        r8.mCodecSwitchRetryCount = r10;
        return r10;
    }

    public static /* synthetic */ void access$600(A2dpJitterAction r8, int r10) {
        r8.updateWifiBackgroundScanMode(r10);
    }

    private void adjustAacPacketFormat(BluetoothDevice r8) {
        StringBuilder r10 = new StringBuilder("adjust AAC packet format for robustness, device: ");
        if (r8 == null) goto L5;
        String r11 = r8.getAddress();
    L6:
        android.aimedia.a.r(r10, r11, TAG);
        SmartBluetoothBinderClient r12 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r12 != null) goto L10;
        CaeLog.w(TAG, "binderClient is null, cannot adjust AAC packet format.");
        return;
    L10:
        r12.setAac3mPacketEnabled(false);
        this.mAacPacketFormatAdjusted = true;
        return;
    L5:
        r11 = "null";
        goto L6
    }

    private boolean codecSwitchIfNecessary() {
        BluetoothA2dp r8 = this.mBluetoothA2dp;
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "mBluetoothA2dp is null.");
        return true;
    L6:
        BluetoothDevice r10 = r8.getActiveDevice();
        if (r10 != null) goto L10;
        CaeLog.d(TAG, "no active a2dp device.");
        return false;
    L10:
        BluetoothCodecStatus r11 = this.mBluetoothA2dp.getCodecStatus(r10);
        if (r11 != null) goto L13;
    L27:
        CaeLog.w(TAG, "codecStatus or codecConfig is null.");
        return false;
    L13:
        if (r11.getCodecConfig() == null) goto L27;
        BluetoothCodecConfig r12 = r11.getCodecConfig();
        if (r12.getCodecType() != 1) goto L21;
        CaeLog.i(TAG, "current codec is already AAC, skip codec reselection.");
        this.mLastOptimizeAction = OPTIMIZE_ACTION_ADJUST_AAC_PACKET_FORMAT;
        if (this.mAacPacketFormatAdjusted == true) goto L20;
        adjustAacPacketFormat(r10);
    L20:
        return true;
    L21:
        BluetoothCodecConfig r13 = findSelectableCodec(r11.getCodecsSelectableCapabilities(), 1);
        if (r13 != null) goto L25;
        CaeLog.d(TAG, "aac codec is not selectable.");
        return false;
    L25:
        saveOriginalCodecConfigIfNeeded(r10, r12);
        this.mCodecSwitchedToAac = true;
        this.mLastOptimizeAction = OPTIMIZE_ACTION_SWITCH_CODEC;
        switchCodec(r10, r13, 1);
        adjustAacPacketFormat(r10);
        return true;
    }

    private void dispatchPendingOptimizeCallback() {
        OptimizeActionCallback r8 = this.mPendingOptimizeCallback;
        this.mPendingOptimizeCallback = null;
        if (r8 != null) goto L5;
        return;
    L5:
        String r10 = this.mLastOptimizeAction;
        if (r10 != null) goto L8;
        r10 = OPTIMIZE_ACTION_CODEC_OPTIMIZE;
    L8:
        r8.onOptimizeAction(r10);
    }

    private BluetoothCodecConfig findSelectableCodec(List<BluetoothCodecConfig> r8, int r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Iterator<BluetoothCodecConfig> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        BluetoothCodecConfig r12 = r11.next();
        if (r12 == null) goto L7;
        if (r12.getCodecType() != r10) goto L7;
        return r12;
    L13:
        return null;
    }

    private int getHighestBitsPerSample(BluetoothCodecConfig r8) {
        if (r8 != null) goto L6;
        CaeLog.d(TAG, "Unable to get highest bits per sample. Config is empty");
        return 0;
    L6:
        int r10 = r8.getBitsPerSample();
        int[] r11 = BITS_PER_SAMPLES;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L12;
        int r14 = r11[r13];
        if ((r10 & r14) != 0) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        return r14;
    L12:
        return 0;
    }

    private int getHighestChannelMode(BluetoothCodecConfig r8) {
        if (r8 != null) goto L6;
        CaeLog.d(TAG, "Unable to get highest channel mode. Config is empty");
        return 0;
    L6:
        int r10 = r8.getChannelMode();
        int[] r11 = CHANNEL_MODES;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L12;
        int r14 = r11[r13];
        if ((r10 & r14) != 0) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        return r14;
    L12:
        return 0;
    }

    private int getHighestSampleRate(BluetoothCodecConfig r8) {
        if (r8 != null) goto L6;
        CaeLog.d(TAG, "Unable to get highest sample rate. Config is empty");
        return 0;
    L6:
        int r10 = r8.getSampleRate();
        int[] r11 = SAMPLE_RATES;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L12;
        int r14 = r11[r13];
        if ((r10 & r14) != 0) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        return r14;
    L12:
        return 0;
    }

    private void limitWifiBackgroundScan() {
        this.mHandler.removeMessages(1);
        updateWifiBackgroundScanMode(1);
        this.mHandler.sendEmptyMessageDelayed(1, 5000);
    }

    private void requestBalancedLeConnection() {
        requestLeConnectionPriority(0);
    }

    private void requestLeConnectionPriority(int r8) {
        SmartBluetoothBinderClient r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r10 == null) goto L6;
        r10.requestLeConnectionPriority(r8, AttributionSource.myAttributionSource());
        return;
    }

    private void requestLowPowerLeConnection() {
        requestLeConnectionPriority(2);
    }

    private void restoreAacPacketFormat(BluetoothDevice r8) {
        StringBuilder r10 = new StringBuilder("restore AAC packet format for device: ");
        if (r8 == null) goto L5;
        String r11 = r8.getAddress();
    L6:
        android.aimedia.a.r(r10, r11, TAG);
        SmartBluetoothBinderClient r12 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r12 != null) goto L10;
        CaeLog.w(TAG, "binderClient is null, cannot restore AAC packet format.");
        return;
    L10:
        r12.setAac3mPacketEnabled(true);
        this.mAacPacketFormatAdjusted = false;
        return;
    L5:
        r11 = "null";
        goto L6
    }

    private void restoreCodecAction() {
        BluetoothAdapter r8 = this.mBluetoothAdapter;
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "mBluetoothAdapter is null.");
        return;
    L6:
        this.mPendingCodecAction = 2;
        this.mPendingOptimizeCallback = null;
        this.mCodecSwitchRetryCount = 0;
        if (this.mBluetoothA2dp == null) goto L10;
        tryRunPendingRestoreAction();
        return;
    L10:
        r8.getProfileProxy(this.mContext, this.mListener, 2);
    }

    private boolean restoreCodecIfNecessary() {
        BluetoothA2dp r8 = this.mBluetoothA2dp;
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "mBluetoothA2dp is null.");
        return true;
    L6:
        BluetoothDevice r10 = r8.getActiveDevice();
        if (r10 != null) goto L11;
        CaeLog.d(TAG, "no active a2dp device for restore.");
        return false;
    L11:
        if (this.mAacPacketFormatAdjusted == false) goto L14;
        restoreAacPacketFormat(r10);
    L14:
        if (this.mCodecSwitchedToAac == true) goto L16;
        return true;
    L16:
        String r11 = r10.getAddress();
        if (r11 != null) goto L19;
        BluetoothCodecConfig r12 = null;
    L20:
        if (r12 != null) goto L23;
        CaeLog.i(TAG, "no saved codec config, skip codec restore.");
        this.mCodecSwitchedToAac = false;
        return true;
    L23:
        CaeLog.i(TAG, "restore codec config: " + r12);
        switchCodec(r10, r12, r12.getCodecType());
        this.mCodecSwitchedToAac = false;
        return true;
    L19:
        r12 = this.mOriginalCodecConfigByAddress.remove(r11);
        goto L20
    }

    private void restoreWifiBackgroundScan() {
        this.mHandler.removeMessages(1);
        updateWifiBackgroundScanMode(2);
    }

    private void saveOriginalCodecConfigIfNeeded(BluetoothDevice r8, BluetoothCodecConfig r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getAddress() == null) goto L12;
        if (r10 == null) goto L14;
        String r11 = r8.getAddress();
        if (this.mOriginalCodecConfigByAddress.containsKey(r11) == true) goto L13;
        this.mOriginalCodecConfigByAddress.put(r11, r10);
        CaeLog.i(TAG, "save original codec config: " + r10 + ", device: " + r11);
        return;
    L13:
        return;
    L14:
        return;
    }

    private void switchCodec(BluetoothDevice r8, BluetoothCodecConfig r10, int r11) {
        CaeLog.d(TAG, "switchCodec: " + r11);
        BluetoothCodecConfig.Builder r12 = new BluetoothCodecConfig.Builder();
        r12.setCodecType(r11).setCodecPriority(TimeUtils.NANOSECONDS_PER_MILLISECOND).setSampleRate(getHighestSampleRate(r10)).setBitsPerSample(getHighestBitsPerSample(r10)).setChannelMode(getHighestChannelMode(r10)).setCodecSpecific1(r10.getCodecSpecific1()).setCodecSpecific2(r10.getCodecSpecific2()).setCodecSpecific3(r10.getCodecSpecific3()).setCodecSpecific4(r10.getCodecSpecific4());
        this.mBluetoothA2dp.setCodecConfigPreference(r8, r12.build());
    }

    private void triggerCodecAction(OptimizeActionCallback r8) {
        BluetoothAdapter r10 = this.mBluetoothAdapter;
        if (r10 != null) goto L8;
        CaeLog.w(TAG, "mBluetoothAdapter is null.");
        if (r8 == null) goto L16;
        r8.onOptimizeAction(OPTIMIZE_ACTION_CODEC_OPTIMIZE);
        return;
    L16:
        return;
    L8:
        this.mPendingCodecAction = 1;
        this.mPendingOptimizeCallback = r8;
        this.mCodecSwitchRetryCount = 0;
        if (this.mBluetoothA2dp == null) goto L13;
        tryRunPendingOptimizeAction();
        return;
    L13:
        if (r10.getProfileProxy(this.mContext, this.mListener, 2) == true) goto L17;
        CaeLog.w(TAG, "getProfileProxy failed.");
        this.mPendingCodecAction = 0;
        dispatchPendingOptimizeCallback();
        return;
    }

    private void tryRunPendingOptimizeAction() {
        if (this.mPendingCodecAction == 1) goto L6;
        return;
    L6:
        if (codecSwitchIfNecessary() == false) goto L9;
        this.mPendingCodecAction = 0;
        this.mCodecSwitchRetryCount = 0;
        this.mHandler.removeMessages(2);
        dispatchPendingOptimizeCallback();
        return;
    L9:
        int r8 = this.mCodecSwitchRetryCount;
        if (r8 < 10) goto L13;
        CaeLog.w(TAG, "active a2dp device not ready after retry, skip codec switch.");
        this.mPendingCodecAction = 0;
        this.mCodecSwitchRetryCount = 0;
        this.mHandler.removeMessages(2);
        dispatchPendingOptimizeCallback();
        return;
    L13:
        this.mCodecSwitchRetryCount = r8 + 1;
        b.p(new StringBuilder("active a2dp device not ready, retry codec switch: "), this.mCodecSwitchRetryCount, TAG);
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, A2DP_CODEC_SWITCH_RETRY_DELAY_MS);
    }

    private void tryRunPendingRestoreAction() {
        if (this.mPendingCodecAction == 2) goto L6;
        return;
    L6:
        if (restoreCodecIfNecessary() == false) goto L9;
        this.mPendingCodecAction = 0;
        this.mCodecSwitchRetryCount = 0;
        this.mHandler.removeMessages(2);
        return;
    L9:
        int r8 = this.mCodecSwitchRetryCount;
        if (r8 < 10) goto L13;
        CaeLog.w(TAG, "active a2dp device not ready after retry, skip codec restore.");
        this.mPendingCodecAction = 0;
        this.mCodecSwitchRetryCount = 0;
        this.mHandler.removeMessages(2);
        return;
    L13:
        this.mCodecSwitchRetryCount = r8 + 1;
        b.p(new StringBuilder("active a2dp device not ready, retry codec restore: "), this.mCodecSwitchRetryCount, TAG);
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, A2DP_CODEC_SWITCH_RETRY_DELAY_MS);
    }

    private void updateWifiBackgroundScanMode(int r8) {
        defpackage.a.i("updateWifiBackgroundScanMode: ", r8, TAG);
        Settings.Global.putInt(this.mContext.getContentResolver(), WIFI_BACKGROUND_SCAN_MODE, r8);
    }

    public String restoreA2dpJitterEvent() {
        CaeLog.i(TAG, "restoreA2dpJitterEvent");
        restoreCodecAction();
        return OPTIMIZE_ACTION_CODEC_RESTORE;
    }

    public void triggerA2dpJitterEvent(OptimizeActionCallback r8) {
        CaeLog.i(TAG, "triggerA2dpJitterEvent");
        this.mLastOptimizeAction = null;
        triggerCodecAction(r8);
    }
}
