package com.obric.cae.smartBluetooth.dcf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.qualcomm.qti.qesdk.Dcf.DcfEnums;
import com.qualcomm.qti.qesdk.Dcf.DcfUDT;
import com.qualcomm.qti.qesdk.Dcf.IDcfCBs;
import com.qualcomm.qti.qesdk.QesdkStatusException;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import defpackage.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DcfScanManager implements QeSdkHelper.platformStatusChangeListener {
    private static final int AD_TYPE_COMPLETE_128_BIT_SERVICE_UUIDS = 7;
    private static final int AD_TYPE_FLAGS = 1;
    private static final int AD_TYPE_SERVICE_DATA_128_BIT_UUID = 33;
    private static final int AD_TYPE_SERVICE_DATA_16_BIT_UUID = 22;
    private static final int AD_TYPE_TX_POWER = 10;
    public static final int DE_TAG_DEVICE_ID = 64;
    private static final int HIGH_RSSI_THRESHOLD = -128;
    private static final long LIFE_CHECK_IMMEDIATELY = 0;
    private static final long LIFE_CHECK_INTERVAL = 1000;
    private static final long MANUFACTURER_ID_IGNORE = 4294967295L;
    private static final long MAX_LATENCY = 2147483647L;
    private static final String TAG = "DcfScanManager";
    private static volatile DcfScanManager sInstance;
    private Context mApplicationContext;
    private IDcfCBs.IDataReadyCallback mDataReadyCallback;
    private final ConcurrentHashMap<String, DcfDevice> mDevices;
    private final CopyOnWriteArrayList<DcfDevicesListener> mDevicesListeners;
    private long mDupDetectionPeriodMills;
    private IDcfCBs.IDuplicateDetectionStatusCallback mDupDetectionStatusCallback;
    private QeSdkHelper mQesdkHelper;
    private IDcfCBs.IBleScanStatusCallback mScanCallback;
    private DcfScanHandler mScanHandler;
    private boolean mScanStarted;
    private int mStartScanToken;
    private int mStopScanToken;
    private int mTriggerId;
    private IDcfCBs.ITriggerStatusCallback mTriggerStatusCallback;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.dcf.DcfScanManager$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId = null;

        static {
            int[] r8 = new int[DcfEnums.PropertyId.values().length];
            $SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId = r8;
            r8[DcfEnums.PropertyId.PROPERTYID_RSSI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId[DcfEnums.PropertyId.PROPERTYID_TXPOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId[DcfEnums.PropertyId.PROPERTYID_ADDRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId[DcfEnums.PropertyId.PROPERTYID_TIMESTAMP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId[DcfEnums.PropertyId.PROPERTYID_ADDRESSTYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class DcfScanHandler extends Handler {
        static final int MSG_CANCEL_DUP_DETECTION = 310;
        static final int MSG_CONFIG_DUP_DETECTION = 309;
        static final int MSG_LIFE_CHECK = 307;
        static final int MSG_PARSE_SCAN_DATA = 306;
        static final int MSG_SET_DATA_READY_CALLBACK = 301;
        static final int MSG_SET_DUP_STATUS_CALLBACK = 308;
        static final int MSG_SET_SCAN_CALLBACK = 300;
        static final int MSG_SET_TRIGGER = 303;
        static final int MSG_SET_TRIGGER_CALLBACK = 302;
        static final int MSG_START_SCAN = 304;
        static final int MSG_STOP_SCAN = 305;
        final /* synthetic */ DcfScanManager this$0;

        public DcfScanHandler(DcfScanManager r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            super.handleMessage(r8);
            switch(r8.what) {
                case 300: goto L15;
                case 301: goto L14;
                case 302: goto L13;
                case 303: goto L12;
                case 304: goto L11;
                case 305: goto L10;
                case 306: goto L9;
                case 307: goto L8;
                case 308: goto L7;
                case 309: goto L6;
                case 310: goto L5;
                default: goto L27;
            };
        L5:
            DcfScanManager.access$1000(this.this$0);
            return;
        L6:
            DcfScanManager.access$900(this.this$0);
            return;
        L7:
            DcfScanManager.access$800(this.this$0);
            return;
        L8:
            DcfScanManager.access$700(this.this$0);
            return;
        L9:
            DcfScanManager.access$600(this.this$0, r8);
            return;
        L10:
            DcfScanManager.access$500(this.this$0);
            return;
        L11:
            DcfScanManager.access$400(this.this$0);
            return;
        L12:
            DcfScanManager.access$300(this.this$0);
            return;
        L13:
            DcfScanManager.access$200(this.this$0);
            return;
        L14:
            DcfScanManager.access$100(this.this$0);
            return;
        L15:
            DcfScanManager.access$000(this.this$0);
            return;
        }
    }

    public class ScanDataPack {
        DcfUDT.BleScanData mBleScanData;
        long mPlatformClientId;
        DcfUDT.Properties mProperties;
        ArrayList<Integer> mTriggerIds;
        final /* synthetic */ DcfScanManager this$0;

        public ScanDataPack(DcfScanManager r8, long r10, ArrayList<Integer> r11, DcfUDT.BleScanData r12, DcfUDT.Properties r13) {
            this.this$0 = r8;
            this.mPlatformClientId = r10;
            this.mTriggerIds = r11;
            this.mBleScanData = r12;
            this.mProperties = r13;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScanMode {
        public static final int AMBIENT_DISCOVERY = 4;
        public static final int BALANCED = 2;
        public static final int LOW_LATENCY = 3;
        public static final int LOW_POWER = 1;
    }

    public DcfScanManager() {
        this.mDupDetectionPeriodMills = 10;
        this.mDevicesListeners = new CopyOnWriteArrayList();
        this.mDevices = new ConcurrentHashMap();
        this.mStartScanToken = -1;
        this.mStopScanToken = -1;
        this.mTriggerId = -1;
        this.mTriggerStatusCallback = new AnonymousClass1(this);
        this.mScanCallback = new AnonymousClass2(this);
        this.mDataReadyCallback = new AnonymousClass3(this);
        this.mDupDetectionStatusCallback = new AnonymousClass4(this);
    }

    public static /* synthetic */ void access$000(DcfScanManager r8) {
        r8.handleSetScanCallback();
    }

    public static /* synthetic */ void access$100(DcfScanManager r8) {
        r8.handleSetDataReadyCallback();
    }

    public static /* synthetic */ void access$1000(DcfScanManager r8) {
        r8.handleCancelDuplicateDetection();
    }

    public static /* synthetic */ String access$1100() {
        return TAG;
    }

    public static /* synthetic */ QeSdkHelper access$1200(DcfScanManager r8) {
        return r8.mQesdkHelper;
    }

    public static /* synthetic */ int access$1300(DcfScanManager r8) {
        return r8.mStartScanToken;
    }

    public static /* synthetic */ boolean access$1402(DcfScanManager r8, boolean r10) {
        r8.mScanStarted = r10;
        return r10;
    }

    public static /* synthetic */ int access$1500(DcfScanManager r8) {
        return r8.mStopScanToken;
    }

    public static /* synthetic */ void access$1600(DcfScanManager r8, ScanDataPack r10) {
        r8.scheduleParseScanData(r10);
    }

    public static /* synthetic */ void access$200(DcfScanManager r8) {
        r8.handleSetTriggerCallback();
    }

    public static /* synthetic */ void access$300(DcfScanManager r8) {
        r8.handleSetTrigger();
    }

    public static /* synthetic */ void access$400(DcfScanManager r8) {
        r8.handleStartScan();
    }

    public static /* synthetic */ void access$500(DcfScanManager r8) {
        r8.handleStopScan();
    }

    public static /* synthetic */ void access$600(DcfScanManager r8, Message r10) {
        r8.handleParseScanData(r10);
    }

    public static /* synthetic */ void access$700(DcfScanManager r8) {
        r8.handleCheckDeviceLifePeriodically();
    }

    public static /* synthetic */ void access$800(DcfScanManager r8) {
        r8.handleSetDuplicateDetectionStatusCallback();
    }

    public static /* synthetic */ void access$900(DcfScanManager r8) {
        r8.handleConfigureDuplicateDetection();
    }

    private void classifyDevice(DcfDevice r8, List<DcfDevice> r10, List<DcfDevice> r11) {
        String r12 = r8.getDeviceId();
        DcfDevice r13 = this.mDevices.get(r12);
        if (r13 != null) goto L5;
        this.mDevices.put(r12, r8);
        r11.add(r8);
        return;
    L5:
        if (r13.equals(r8) == true) goto L7;
        this.mDevices.put(r12, r8);
        r10.add(r8);
        return;
    L7:
        r13.updatePulseTime();
    }

    private DcfUDT.DataFilters createEmptyDataFilters() {
        return new DcfUDT.DataFilters(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    private DcfUDT.PropertyFilters createEmptyPropertyFilters() {
        return new DcfUDT.PropertyFilters(new ArrayList(), new ArrayList(), new ArrayList());
    }

    private DcfUDT.DataFilters createTriggerDataFilters() {
        ArrayList r8 = new ArrayList();
        r8.add(4294967295L);
        ArrayList r10 = new ArrayList();
        r10.add(new byte[]{-1});
        ArrayList r11 = new ArrayList();
        r11.add(new byte[]{0});
        return new DcfUDT.DataFilters(new ArrayList(), new ArrayList(), new ArrayList(), r8, r10, r11);
    }

    private DcfUDT.PropertyFilters createTriggerPropertyFilters() {
        DcfUDT.PropertyFilters r8 = new DcfUDT.PropertyFilters();
        ArrayList<DcfEnums.PropertyId> r10 = new ArrayList();
        r10.add(DcfEnums.PropertyId.PROPERTYID_RSSI);
        r8.propertyIds = r10;
        ArrayList<Long> r11 = new ArrayList();
        r11.add(127L);
        r8.propertyValues = r11;
        ArrayList<DcfEnums.Condition> r12 = new ArrayList();
        r12.add(DcfEnums.Condition.CONDITION_LESSOREQUAL);
        r8.acceptIf = r12;
        return r8;
    }

    private void ensureBleScanDataLists(DcfUDT.BleScanData r8) {
        if (r8.serviceDataUuids != null) goto L6;
        r8.serviceDataUuids = new ArrayList();
    L6:
        if (r8.serviceData != null) goto L9;
        r8.serviceData = new ArrayList();
    L9:
        if (r8.manufacturerIds != null) goto L12;
        r8.manufacturerIds = new ArrayList();
    L12:
        if (r8.manufacturerData != null) goto L15;
        r8.manufacturerData = new ArrayList();
    L15:
        if (r8.serviceUuids != null) goto L18;
        r8.serviceUuids = new ArrayList();
        return;
    }

    private List<DcfDevice> fetchDevicesFromScanData(ScanDataPack r12) {
        DcfUDT.BleScanData r8 = r12.mBleScanData;
        DcfUDT.Properties r10 = r12.mProperties;
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "BleScanData is null");
        return new ArrayList();
    L6:
        if (r10 != null) goto L9;
        CaeLog.w(TAG, "Properties is null");
        r10 = new DcfUDT.Properties();
    L9:
        if (r10.propertyIds != null) goto L11;
    L12:
        CaeLog.w(TAG, "Property id/value is null");
        r10.propertyIds = new ArrayList();
        r10.propertyValues = new ArrayList();
    L13:
        ensureBleScanDataLists(r8);
        int r11 = Math.min(r10.propertyIds.size(), r10.propertyValues.size());
        if (r10.propertyIds.size() == r10.propertyValues.size()) goto L16;
        CaeLog.w(TAG, "Property id/value size mismatch, ids=" + r10.propertyIds.size() + ", values=" + r10.propertyValues.size());
    L16:
        int r13 = 0;
        String r14 = null;
        int r15 = 0;
    L17:
        if (r15 >= r11) goto L39;
        DcfEnums.PropertyId r16 = r10.propertyIds.get(r15);
        Long r17 = r10.propertyValues.get(r15);
        if (r16 == null) goto L37;
        if (r17 == null) goto L37;
        String r18 = TAG;
        CaeLog.d(r18, "property = " + r16 + " value is " + r17);
        int r19 = AnonymousClass5.$SwitchMap$com$qualcomm$qti$qesdk$Dcf$DcfEnums$PropertyId[r16.ordinal()];
        if (r19 != 1) goto L25;
        StringBuilder r20 = new StringBuilder("rssi signed8 = ");
    L35:
        r20.append(toSignedByteValue(r17.longValue()));
    L36:
        CaeLog.d(r18, r20.toString());
    L38:
        r15 = r15 + 1;
        goto L17
    L25:
        if (r19 != 2) goto L27;
        r20 = new StringBuilder("txPower signed8 = ");
        goto L35
    L27:
        if (r19 != 3) goto L29;
        r14 = formatBleAddress(r17.longValue());
        r20 = new StringBuilder("address = ");
        r20.append(r14);
        goto L36
    L29:
        if (r19 != 5) goto L38;
        r20 = new StringBuilder("propertyValue = ");
        r20.append(r17);
    L37:
        CaeLog.w(TAG, "Invalid property at index " + r15 + ", property=" + r16 + ", value=" + r17);
        goto L38
    L39:
        ArrayList r21 = new ArrayList();
        String r22 = TAG;
        CaeLog.d(r22, "serviceDataUuids size " + r8.serviceDataUuids.size());
        CaeLog.d(r22, "serviceData rawdata " + DcfByteUtils.byteToString(r8.rawData));
        logRawAdvertisingData(r8.rawData);
        int r23 = Math.min(r8.serviceDataUuids.size(), r8.serviceData.size());
        if (r8.serviceDataUuids.size() == r8.serviceData.size()) goto L42;
        CaeLog.w(r22, "serviceData uuid/data size mismatch, uuids=" + r8.serviceDataUuids.size() + ", data=" + r8.serviceData.size());
    L42:
        int r24 = 0;
    L44:
        if (r24 >= r23) goto L57;
        String r25 = TAG;
        StringBuilder r26 = b.f("serviceDataUuids [", r24, "] = ");
        r26.append(DcfByteUtils.byteToString(r8.serviceDataUuids.get(r24)));
        CaeLog.d(r25, r26.toString());
        CaeLog.d(r25, "serviceData [" + r24 + "] = " + DcfByteUtils.byteToString(r8.serviceData.get(r24)));
        if (Arrays.equals(r8.serviceDataUuids.get(r24), QeSdkHelper.UUID) == false) goto L55;
        byte[] r27 = r8.serviceData.get(r24);
        DcfAdvertisement r28 = DcfAdvertisement.fromBytes(r27);
        if (r28 == null) goto L55;
        List<DcfDataElement> r29 = r28.getDataElements();
        String r30 = getDeviceId(r29);
        if (TextUtils.isEmpty(r30) == false) goto L53;
        StringBuilder r31 = new StringBuilder("Received data without deviceId, TriggerId = ");
    L54:
        r31.append(r12.mTriggerIds.toString());
        CaeLog.d(r25, r31.toString());
        goto L55
    L53:
        r21.add(new DcfDevice(r30, r29, r27));
        r31 = new StringBuilder("Received data from [");
        r31.append(r30);
        r31.append("], TriggerId = ");
    L55:
        r24 = r24 + 1;
        goto L44
    L57:
        if (r8.serviceDataUuids.isEmpty() == false) goto L60;
        String r110 = TAG;
        StringBuilder r111 = new StringBuilder("No serviceData in scan result, skip DCF payload parse. address=");
    L62:
        r111.append(r14);
        CaeLog.d(r110, r111.toString());
    L63:
        int r112 = 0;
    L65:
        if (r112 >= r8.manufacturerIds.size()) goto L68;
        String r113 = TAG;
        StringBuilder r32 = b.f("manufacturerIds [", r112, "] = ");
        r32.append(r8.manufacturerIds.get(r112));
        CaeLog.d(r113, r32.toString());
        CaeLog.d(r113, "manufacturerData [" + r112 + "] = " + DcfByteUtils.byteToString(r8.manufacturerData.get(r112)));
        r112 = r112 + 1;
    L68:
        if (r13 >= r8.serviceUuids.size()) goto L70;
        String r114 = TAG;
        StringBuilder r115 = b.f("serviceUuids [", r13, "] = ");
        r115.append(DcfByteUtils.byteToString(r8.serviceUuids.get(r13)));
        CaeLog.d(r114, r115.toString());
        r13 = r13 + 1;
        goto L68
    L70:
        CaeLog.d(TAG, "device name " + r8.deviceName);
        return r21;
    L60:
        if (r21.isEmpty() == false) goto L63;
        r110 = TAG;
        r111 = new StringBuilder("No DCF device parsed from serviceData. address=");
        goto L62
    L11:
        if (r10.propertyValues != null) goto L13;
        goto L12
    }

    private String formatBleAddress(long r8) {
        if (((-281474976710656L) & r8) == 0) goto L5;
        CaeLog.w(TAG, "Address value exceeds 48 bits: " + r8);
    L5:
        String r10 = String.format(Locale.US, "%012X", new Object[]{Long.valueOf(r8 & 281474976710655L)});
        return r10.substring(10) + BdimCategoryConstants.SEPARATOR_COLON + r10.substring(8, 10) + BdimCategoryConstants.SEPARATOR_COLON + r10.substring(6, 8) + BdimCategoryConstants.SEPARATOR_COLON + r10.substring(4, 6) + BdimCategoryConstants.SEPARATOR_COLON + r10.substring(2, 4) + BdimCategoryConstants.SEPARATOR_COLON + r10.substring(0, 2);
    }

    private DcfUDT.ScanFilters generateScanFilters() {
        ArrayList r8 = new ArrayList();
        r8.add(new byte[0]);
        ArrayList r10 = new ArrayList();
        r10.add(new byte[0]);
        ArrayList r11 = new ArrayList();
        r11.add(new byte[0]);
        ArrayList r12 = new ArrayList();
        r12.add(4294967295L);
        ArrayList r13 = new ArrayList();
        r13.add(new byte[0]);
        ArrayList r14 = new ArrayList();
        r14.add(new byte[0]);
        ArrayList r15 = new ArrayList();
        r15.add("");
        byte[] r16 = new byte[16];
        r16[0] = 0;
        r16[1] = 0;
        ArrayList r17 = new ArrayList();
        r17.add(r16);
        ArrayList r18 = new ArrayList();
        r18.add(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        return new DcfUDT.ScanFilters(r8, r10, r11, r12, r13, r14, r15, r17, r18);
    }

    private DcfUDT.ScanSettings generateScanSettings() {
        DcfEnums.ScanMode r8 = DcfEnums.ScanMode.SCANMODE_BALANCED;
        CaeLog.i(TAG, "set ScanMode to " + r8);
        return new DcfUDT.ScanSettings(r8, MAX_LATENCY, -128);
    }

    private String getAdvertisingDataTypeName(int r8) {
        if (r8 != 1) goto L5;
        return "FLAGS";
    L5:
        if (r8 != 7) goto L7;
        return "COMPLETE_128_BIT_SERVICE_UUIDS";
    L7:
        if (r8 != 10) goto L9;
        return "TX_POWER";
    L9:
        if (r8 != 22) goto L11;
        return "SERVICE_DATA_16_BIT_UUID";
    L11:
        if (r8 == 33) goto L14;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L14:
        return "SERVICE_DATA_128_BIT_UUID";
    }

    private ArrayList<DcfDevice> getAliveDevices() {
        return new ArrayList(this.mDevices.values());
    }

    private String getDeviceId(List<DcfDataElement> r8) {
        Iterator<DcfDataElement> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        DcfDataElement r11 = r10.next();
        if (r11.getTag() != 64) goto L4;
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L9:
        if (r13 >= r11.getData().length) goto L12;
        r12.append(String.format(Locale.US, "%02X", new Object[]{Integer.valueOf(r11.getData()[r13] & 255)}));
        r13 = r13 + 1;
        goto L9
    L12:
        return r12.toString();
    L13:
        return null;
    }

    public static DcfScanManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DcfScanManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DcfScanManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DcfScanManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleCancelDuplicateDetection() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L8;
        String r8 = TAG;
        String r10 = "Platform not Ready to cancel Dup Detection. Pending...";
    L5:
        CaeLog.i(r8, r10);
        return;
    L8:
        if (this.mTriggerId >= 0) goto L10;
        r8 = TAG;
        r10 = "Invalid TriggerId to cancel Duplicate Detection!";
        goto L5
    L10:
        String r11 = TAG;
        CaeLog.d(r11, "handleCancelDuplicateDetection");
        int r12 = this.mQesdkHelper.getDcfManager().cancelDuplicateDetection(this.mQesdkHelper.getDcfClientId(), this.mTriggerId);     // Catch: QesdkStatusException -> L16
        if (r12 >= 0) goto L14;
        CaeLog.w(r11, "cancelDuplicateDetection error " + r12);     // Catch: QesdkStatusException -> L16
    L14:
        CaeLog.d(r11, "cancelDupDetect " + r12);     // Catch: QesdkStatusException -> L16
        return;
    L16:
        e = move-exception;
        CaeLog.w(TAG, "cancelDupDetect Exception: " + e.getMessage());
    }

    private void handleCheckDeviceLifePeriodically() {
        Iterator<String> r8 = this.mDevices.keySet().iterator();
        ArrayList r10 = new ArrayList();
        boolean r11 = false;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r12 = r8.next();
        DcfDevice r13 = this.mDevices.get(r12);
        if (r13 == null) goto L9;
        if (r13.isAlive(this.mDupDetectionPeriodMills) == true) goto L4;
    L9:
        r10.add(r12);
        r11 = true;
        goto L4
    L10:
        Iterator r14 = r10.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        String r15 = (String) r14.next();
        b.o("Remove zombie device ", r15, TAG);
        this.mDevices.remove(r15);
        goto L12
    L14:
        if (r11 == false) goto L17;
        dispatchScanResults();
    L17:
        if (this.mDevices.size() <= 0) goto L19;
        scheduleLifeCheckDelay(1000);
        return;
    L19:
        CaeLog.d(TAG, "No alive devices, stop checking device life");
        this.mScanHandler.removeMessages(307);
    }

    private void handleConfigureDuplicateDetection() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L8;
        String r12 = TAG;
        String r8 = "Platform not Ready to configure Dup Detection. Pending...";
    L5:
        CaeLog.i(r12, r8);
        return;
    L8:
        if (this.mTriggerId >= 0) goto L10;
        r12 = TAG;
        r8 = "No valid TriggerId for duplicate detection";
        goto L5
    L10:
        String r10 = TAG;
        CaeLog.d(r10, "handleConfigureDuplicateDetection");
        int r13 = this.mQesdkHelper.getDcfManager().configureDuplicateDetection2(this.mQesdkHelper.getDcfClientId(), this.mTriggerId, this.mDupDetectionPeriodMills, createEmptyDataFilters(), createEmptyPropertyFilters());     // Catch: QesdkStatusException -> L16
        if (r13 >= 0) goto L14;
        CaeLog.w(r10, "configureDuplicateDetection2 error " + r13);     // Catch: QesdkStatusException -> L16
    L14:
        CaeLog.d(r10, "configureDupDetect " + r13);     // Catch: QesdkStatusException -> L16
        return;
    L16:
        e = move-exception;
        CaeLog.w(TAG, "configureDupDetect Exception: " + e.getMessage());
    }

    private void handleParseScanData(Message r8) {
        CaeLog.i(TAG, "handleParseScanData");
        List<DcfDevice> r10 = fetchDevicesFromScanData((ScanDataPack) r8.obj);     // Catch: Exception -> L16
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L16
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L16
        Iterator<DcfDevice> r13 = r10.iterator();     // Catch: Exception -> L16
    L5:
        if (r13.hasNext() == false) goto L8;
        classifyDevice(r13.next(), r11, r12);     // Catch: Exception -> L16
        goto L5
    L8:
        if (r11.isEmpty() == true) goto L10;
    L11:
        CaeLog.d(TAG, "Updated Count : " + r11.size() + ", new Added count " + r12.size());     // Catch: Exception -> L16
        dispatchScanResults();     // Catch: Exception -> L16
    L13:
        if (this.mDevices.isEmpty() == true) goto L22;
        scheduleLifeCheckDelay(0);     // Catch: Exception -> L16
        return;
    L22:
        return;
    L10:
        if (r12.isEmpty() == true) goto L13;
    L16:
        e = move-exception;
        CaeLog.w(TAG, "parse scan data Exception: " + e.getMessage());
    }

    private void handleSetDataReadyCallback() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L18;
        CaeLog.i(TAG, "Platform not Ready to set DataReadyCallback. Pending...");
        return;
    L18:
        int r8 = this.mQesdkHelper.getDcfManager().setDataReadyCallback(this.mQesdkHelper.getDcfClientId(), this.mDataReadyCallback);     // Catch: QesdkStatusException -> L15
        if (r8 >= 0) goto L9;
        CaeLog.w(TAG, "setDataReadyCallback error " + r8);     // Catch: QesdkStatusException -> L15
    L9:
        String r10 = TAG;     // Catch: QesdkStatusException -> L15
        if (r8 >= 0) goto L12;
        String r11 = "FAIL";
    L13:
        CaeLog.d(r10, "setDataReadyCallback ".concat(r11));     // Catch: QesdkStatusException -> L15
        return;
    L12:
        r11 = "SUCCESS";
    L15:
        e = move-exception;
        CaeLog.w(TAG, "setDataReadyCallback Exception: " + e.getMessage());
    }

    private void handleSetDuplicateDetectionStatusCallback() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L6;
        CaeLog.i(TAG, "Platform not Ready to set Dup Detection Status Callback. Pending...");
        return;
    L6:
        String r8 = TAG;
        CaeLog.d(r8, "handleSetDuplicateDetectionStatusCallback");
        int r10 = this.mQesdkHelper.getDcfManager().setDuplicateDetectionStatusCallback(this.mQesdkHelper.getDcfClientId(), this.mDupDetectionStatusCallback);     // Catch: QesdkStatusException -> L12
        if (r10 >= 0) goto L10;
        CaeLog.w(r8, "setDuplicateDetectionStatusCallback error " + r10);     // Catch: QesdkStatusException -> L12
    L10:
        CaeLog.d(r8, "setDupDetectCallback " + r10);     // Catch: QesdkStatusException -> L12
        return;
    L12:
        e = move-exception;
        CaeLog.w(TAG, "setDupDetectCallback Exception: " + e.getMessage());
    }

    private void handleSetScanCallback() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L18;
        CaeLog.i(TAG, "Platform not Ready to set ScanStatusCallback callback. Pending...");
        return;
    L18:
        int r8 = this.mQesdkHelper.getDcfManager().setBleScanStatusCallback(this.mQesdkHelper.getDcfClientId(), this.mScanCallback);     // Catch: QesdkStatusException -> L15
        if (r8 >= 0) goto L9;
        CaeLog.w(TAG, "setBleScanStatusCallback error " + r8);     // Catch: QesdkStatusException -> L15
    L9:
        String r10 = TAG;     // Catch: QesdkStatusException -> L15
        if (r8 >= 0) goto L12;
        String r11 = "FAIL";
    L13:
        CaeLog.d(r10, "setBleScanStatusCallback ".concat(r11));     // Catch: QesdkStatusException -> L15
        return;
    L12:
        r11 = "SUCCESS";
    L15:
        e = move-exception;
        CaeLog.w(TAG, "setScanStatusCallback Exception: " + e.getMessage());
    }

    private void handleSetTrigger() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L14;
        CaeLog.i(TAG, "Platform not Ready to set SetTrigger.");
        return;
    L14:
        int r8 = this.mQesdkHelper.getDcfManager().setTrigger(this.mQesdkHelper.getDcfClientId(), createEmptyDataFilters(), createEmptyPropertyFilters());     // Catch: Exception -> L11
        if (r8 >= 0) goto L9;
        CaeLog.w(TAG, "setTrigger error " + r8);     // Catch: Exception -> L11
    L9:
        this.mTriggerId = r8;     // Catch: Exception -> L11
        CaeLog.d(TAG, "SetTrigger " + r8);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        CaeLog.w(TAG, "SetTrigger Exception: " + e.getMessage());
    }

    private void handleSetTriggerCallback() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L18;
        CaeLog.i(TAG, "Platform not Ready to set setTrigger.");
        return;
    L18:
        int r8 = this.mQesdkHelper.getDcfManager().setTriggerStatusCallback(this.mQesdkHelper.getDcfClientId(), this.mTriggerStatusCallback);     // Catch: Exception -> L15
        if (r8 >= 0) goto L9;
        CaeLog.w(TAG, "setTriggerStatusCallback error " + r8);     // Catch: Exception -> L15
    L9:
        String r10 = TAG;     // Catch: Exception -> L15
        if (r8 >= 0) goto L12;
        String r11 = "FAIL";
    L13:
        CaeLog.d(r10, "setTriggerCallback ".concat(r11));     // Catch: Exception -> L15
        return;
    L12:
        r11 = "SUCCESS";
    L15:
        e = move-exception;
        CaeLog.w(TAG, "setTriggerCallback Exception: " + e.getMessage());
    }

    private void handleStartScan() {
        if (this.mDevicesListeners.isEmpty() == false) goto L8;
        String r8 = TAG;
        String r10 = "No DCF listener, skip start scan";
    L5:
        CaeLog.i(r8, r10);
        return;
    L8:
        if (this.mScanStarted == false) goto L11;
        r8 = TAG;
        r10 = "Scan already started";
        goto L5
    L11:
        if (this.mQesdkHelper.isPlatformReady() == true) goto L25;
        r8 = TAG;
        r10 = "Platform not Ready to start scan. Pending...";
        goto L5
    L25:
        int r11 = this.mQesdkHelper.getDcfManager().startBleScan(this.mQesdkHelper.getDcfClientId(), generateScanSettings(), generateScanFilters());     // Catch: QesdkStatusException -> L22
        this.mStartScanToken = r11;     // Catch: QesdkStatusException -> L22
        if (r11 >= 0) goto L16;
        CaeLog.w(TAG, "startBleScan error " + r11);     // Catch: QesdkStatusException -> L22
        this.mStartScanToken = -1;     // Catch: QesdkStatusException -> L22
    L16:
        String r12 = TAG;     // Catch: QesdkStatusException -> L22
        if (r11 >= 0) goto L19;
        String r13 = "FAIL";
    L20:
        CaeLog.d(r12, "StartScan ".concat(r13));     // Catch: QesdkStatusException -> L22
        return;
    L19:
        r13 = "SUCCESS";
    L22:
        e = move-exception;
        CaeLog.w(TAG, "StartScan Exception: " + e.getMessage());
    }

    private void handleStopScan() {
        if (this.mScanStarted == true) goto L7;
        CaeLog.i(TAG, "Scan not started, skip stop scan");
        return;
    L7:
        if (this.mQesdkHelper.isPlatformReady() == true) goto L22;
        CaeLog.i(TAG, "Platform not Ready to stop scan. Pending...");
        this.mScanStarted = false;
        return;
    L22:
        int r8 = this.mQesdkHelper.getDcfManager().stopBleScan(this.mQesdkHelper.getDcfClientId());     // Catch: QesdkStatusException -> L19
        this.mStopScanToken = r8;     // Catch: QesdkStatusException -> L19
        if (r8 >= 0) goto L13;
        CaeLog.w(TAG, "stopBleScan error " + r8);     // Catch: QesdkStatusException -> L19
        this.mStopScanToken = -1;     // Catch: QesdkStatusException -> L19
    L13:
        String r10 = TAG;     // Catch: QesdkStatusException -> L19
        if (r8 >= 0) goto L16;
        String r11 = "FAIL";
    L17:
        CaeLog.d(r10, "StopScan ".concat(r11));     // Catch: QesdkStatusException -> L19
        return;
    L16:
        r11 = "SUCCESS";
    L19:
        e = move-exception;
        CaeLog.w(TAG, "StopScan Exception: " + e.getMessage());
    }

    private boolean inIntRange(Long r8) {
        if (r8.longValue() >= (-2147483648L)) goto L5;
    L7:
        return false;
    L5:
        if (r8.longValue() > MAX_LATENCY) goto L7;
        return true;
    }

    private void logRawAdvertisingData(byte[] r8) {
        if (r8 != null) goto L4;
    L20:
        CaeLog.d(TAG, "raw advertising data is empty");
        return;
    L4:
        if (r8.length == 0) goto L20;
        int r10 = 0;
    L8:
        if (r10 >= r8.length) goto L26;
        int r11 = r8[r10] & 255;
        if (r11 == 0) goto L27;
        int r12 = (r10 + r11) + 1;
        if (r12 > r8.length) goto L18;
        int r13 = r10 + 1;
        if (r13 >= r8.length) goto L18;
        int r14 = r8[r13] & 255;
        byte[] r15 = Arrays.copyOfRange(r8, r10 + 2, r12);
        CaeLog.d(TAG, "AD structure type=" + getAdvertisingDataTypeName(r14) + String.format(Locale.US, "(0x%02X)", new Object[]{Integer.valueOf(r14)}) + ", data=" + DcfByteUtils.byteToString(r15));
        r10 = r12;
    L18:
        String r16 = TAG;
        StringBuilder r17 = defpackage.a.g("Malformed AD structure at index ", r10, ", length=", r11, ", rawLength=");
        r17.append(r8.length);
        CaeLog.w(r16, r17.toString());
        return;
    L27:
        return;
    }

    private void scheduleCancelDuplicateDetection() {
        this.mScanHandler.removeMessages(310);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, 310));
    }

    private void scheduleConfigureDuplicateDetection() {
        this.mScanHandler.removeMessages(309);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, 309));
    }

    private void scheduleLifeCheckDelay(long r8) {
        this.mScanHandler.removeMessages(307);
        DcfScanHandler r10 = this.mScanHandler;
        r10.sendMessageDelayed(Message.obtain(r10, 307), r8);
    }

    private void scheduleParseScanData(ScanDataPack r8) {
        if (r8 == null) goto L5;
        Message r10 = Message.obtain(this.mScanHandler, 306);
        r10.obj = r8;
        this.mScanHandler.sendMessage(r10);
        return;
    }

    private void scheduleSetDataReadyCallback() {
        this.mScanHandler.removeMessages(BWDLInnerConstant.BondStateChange);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, BWDLInnerConstant.BondStateChange));
    }

    private void scheduleSetDuplicateDetectionStatusCallback() {
        this.mScanHandler.removeMessages(308);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, 308));
    }

    private void scheduleSetScanCallback() {
        this.mScanHandler.removeMessages(300);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, 300));
    }

    private void scheduleSetTrigger() {
        this.mScanHandler.removeMessages(BWDLInnerConstant.AL_CONNECTION_STATE_CHANGE);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, BWDLInnerConstant.AL_CONNECTION_STATE_CHANGE));
    }

    private void scheduleSetTriggerCallback() {
        this.mScanHandler.removeMessages(BWDLInnerConstant.LL_CONNECTION_STATE_CHANGE);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, BWDLInnerConstant.LL_CONNECTION_STATE_CHANGE));
    }

    private void scheduleSetupDcfCallbacksAndTrigger() {
        scheduleSetDataReadyCallback();
        scheduleSetScanCallback();
        scheduleSetTriggerCallback();
        scheduleSetTrigger();
        scheduleSetDuplicateDetectionStatusCallback();
    }

    private void scheduleStartScan() {
        this.mScanHandler.removeMessages(BWDLInnerConstant.LL_PARAM_AVAILABLE);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, BWDLInnerConstant.LL_PARAM_AVAILABLE));
    }

    private void scheduleStopScan() {
        this.mScanHandler.removeMessages(BWDLInnerConstant.LL_PARAM_FAIL);
        DcfScanHandler r8 = this.mScanHandler;
        r8.sendMessage(Message.obtain(r8, BWDLInnerConstant.LL_PARAM_FAIL));
    }

    private int toSignedByteValue(long r8) {
        return (byte) (r8 & 255);
    }

    public void dispatchScanResults() {
        if (this.mDevicesListeners.size() >= 1) goto L5;
        return;
    L5:
        ArrayList<DcfDevice> r8 = getAliveDevices();
        Iterator<DcfDevicesListener> r10 = this.mDevicesListeners.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().onDevicesChanged(r8);
        goto L7
    }

    public void init(Context r8) {
        this.mApplicationContext = r8.getApplicationContext();
        QeSdkHelper r10 = QeSdkHelper.getInstance();
        this.mQesdkHelper = r10;
        if (this.mScanHandler == null) goto L6;
        CaeLog.i(TAG, "DcfScanManager already initialized");
        return;
    L6:
        r10.addPlatformStatusChangeListener(this);
        this.mScanHandler = new DcfScanHandler(this, this.mQesdkHelper.getWorkerLooper());
        if (this.mQesdkHelper.isPlatformReady() == false) goto L9;
        scheduleSetupDcfCallbacksAndTrigger();
        return;
    L9:
        CaeLog.i(TAG, "QeSDK platform is not ready, wait for platform callback");
    }

    @Override // com.obric.cae.smartBluetooth.dcf.QeSdkHelper.platformStatusChangeListener
    public void onPlatformStatusChanged() {
        if (this.mQesdkHelper.isPlatformReady() == true) goto L6;
        this.mScanStarted = false;
        this.mStartScanToken = -1;
        this.mStopScanToken = -1;
        return;
    L6:
        scheduleSetupDcfCallbacksAndTrigger();
        if (this.mDevicesListeners.isEmpty() == true) goto L10;
        scheduleStartScan();
        return;
    }

    public void registerDcfDevicesListener(DcfDevicesListener r8) {
        this.mDevicesListeners.addIfAbsent(r8);
        CaeLog.d(TAG, "Register scan listener. Registered count " + this.mDevicesListeners.size());
        r8.onDevicesChanged(getAliveDevices());
        if (this.mScanStarted == false) goto L5;
        return;
    L5:
        if (this.mQesdkHelper.isPlatformReady() == false) goto L7;
        scheduleSetupDcfCallbacksAndTrigger();
    L7:
        scheduleStartScan();
    }

    public void unregisterDcfDevicesListener(DcfDevicesListener r8) {
        this.mDevicesListeners.remove(r8);
        CaeLog.d(TAG, "Unregister scan listener. Registered count " + this.mDevicesListeners.size());
        if (this.mDevicesListeners.isEmpty() == false) goto L6;
        this.mScanHandler.removeMessages(BWDLInnerConstant.LL_PARAM_AVAILABLE);
        scheduleStopScan();
        return;
    }
}
