package com.qualcomm.qti.qesdk.Dcf;

import android.os.Bundle;
import android.util.Log;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.qualcomm.qti.qesdk.QesdkStatusException;
import com.qualcomm.qti.qesdkIntf.IQesdk;
import com.qualcomm.qti.qesdkIntf.IQesdkEventCallBack;
import com.qualcomm.qti.qesdkIntf.IQesdkWrapperCallBack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class DcfManager {
    private static final int HIGHEST_VERSION = 6;
    private static final int OPCODE = 99;
    private static final int SUBSYSTEM_ID = 2682;
    private final AtomicBoolean init_flag;
    private IQesdk qesdkManager;
    private int sessionId;
    private final IQesdkWrapperCallBack wrapperCallback;

    public class DcfWrapperCallBack implements IQesdkWrapperCallBack {
        final /* synthetic */ DcfManager this$0;

        public DcfWrapperCallBack(DcfManager r8) {
            this.this$0 = r8;
        }

        @Override // com.qualcomm.qti.qesdkIntf.IQesdkWrapperCallBack
        public void onSessionEvent(int r8) {
        }
    }

    public DcfManager(IQesdk r8) {
        this.qesdkManager = null;
        this.init_flag = new AtomicBoolean(false);
        this.wrapperCallback = new DcfWrapperCallBack(this);
        this.qesdkManager = r8;
        this.sessionId = 0;
    }

    public static /* synthetic */ int a(int r8) {
        return lambda$deinit$0(r8);
    }

    public static /* synthetic */ DcfUDT.BleScanData access$000(DcfManager r8, Bundle r10) {
        return r8.unpackBleScanData(r10);
    }

    public static /* synthetic */ DcfUDT.Properties access$100(DcfManager r8, Bundle r10) {
        return r8.unpackProperties(r10);
    }

    private static /* synthetic */ int lambda$deinit$0(int r8) {
        if (r8 > 0) goto L6;
        return 0;
    L6:
        return r8 - 1;
    }

    private Bundle packAdvertiseData(DcfUDT.AdvertiseData r11) {
        Bundle r8 = new Bundle();
        r8.putBundle("0", packBnryBlb(r11.serviceData));
        r8.putBundle("1", packBnryBlb(r11.serviceDataUuids));
        Object[] r10 = r11.manufacturerIds.toArray();
        long[] r12 = new long[r10.length];
        int r13 = r10.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = ((Long) r10[r14]).longValue();
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        r8.putLongArray(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, r12);
        r8.putBundle(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, packBnryBlb(r11.manufacturerData));
        r8.putBundle("4", packBnryBlb(r11.serviceUuids));
        r8.putByteArray("5", r11.rawAdvertiseData);
        r8.putInt("6", r11.includeLocalName);
        return r8;
    }

    private ArrayList<Integer> packAdvertisingInterval(ArrayList<DcfEnums.AdvertisingInterval> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.AdvertisingInterval> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packAdvertisingParameters(DcfUDT.AdvertisingParameters r8) {
        Bundle r10 = new Bundle();
        r10.putInt("0", r8.interval.getValue());
        r10.putInt("1", r8.txPowerLevel.getValue());
        r10.putInt(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, r8.includeTxPower);
        r10.putInt(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, r8.legacy);
        return r10;
    }

    private ArrayList<Integer> packBleAdvertiseStatus(ArrayList<DcfEnums.BleAdvertiseStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.BleAdvertiseStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packBleScanData(DcfUDT.BleScanData r11) {
        Bundle r8 = new Bundle();
        r8.putByteArray("0", r11.rawData);
        r8.putBundle("1", packBnryBlb(r11.serviceDataUuids));
        r8.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packBnryBlb(r11.serviceData));
        Object[] r10 = r11.manufacturerIds.toArray();
        long[] r12 = new long[r10.length];
        int r13 = r10.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = ((Long) r10[r14]).longValue();
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        r8.putLongArray(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, r12);
        r8.putBundle("4", packBnryBlb(r11.manufacturerData));
        r8.putString("5", r11.deviceName);
        r8.putBundle("6", packBnryBlb(r11.serviceUuids));
        return r8;
    }

    private ArrayList<Integer> packBleScanStatus(ArrayList<DcfEnums.BleScanStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.BleScanStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packBnryBlb(ArrayList<byte[]> r8) {
        Bundle r10 = new Bundle();
        int r11 = r8.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.putByteArray(String.valueOf(r12), r8.get(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    private ArrayList<Integer> packClientRegistrationStatus(ArrayList<DcfEnums.ClientRegistrationStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.ClientRegistrationStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packCondition(ArrayList<DcfEnums.Condition> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.Condition> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packCustomRequestStatus(ArrayList<DcfEnums.CustomRequestStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.CustomRequestStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packDataFilters(DcfUDT.DataFilters r11) {
        Bundle r8 = new Bundle();
        r8.putBundle("0", packBnryBlb(r11.serviceDataUuids));
        r8.putBundle("1", packBnryBlb(r11.serviceData));
        r8.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packBnryBlb(r11.serviceDataMasks));
        Object[] r10 = r11.manufacturerIds.toArray();
        long[] r12 = new long[r10.length];
        int r13 = r10.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = ((Long) r10[r14]).longValue();
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        r8.putLongArray(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, r12);
        r8.putBundle("4", packBnryBlb(r11.manufacturerData));
        r8.putBundle("5", packBnryBlb(r11.manufacturerDataMasks));
        return r8;
    }

    private ArrayList<Integer> packDuplicateDetectionStatus(ArrayList<DcfEnums.DuplicateDetectionStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.DuplicateDetectionStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packPlatformStatus(ArrayList<DcfEnums.PlatformStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.PlatformStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packProperties(DcfUDT.Properties r10) {
        Bundle r8 = new Bundle();
        r8.putIntegerArrayList("0", packPropertyId(r10.propertyIds));
        Object[] r11 = r10.propertyValues.toArray();
        long[] r12 = new long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = ((Long) r11[r14]).longValue();
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        r8.putLongArray("1", r12);
        return r8;
    }

    private Bundle packPropertyFilters(DcfUDT.PropertyFilters r11) {
        Bundle r8 = new Bundle();
        r8.putIntegerArrayList("0", packPropertyId(r11.propertyIds));
        Object[] r10 = r11.propertyValues.toArray();
        long[] r12 = new long[r10.length];
        int r13 = r10.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = ((Long) r10[r14]).longValue();
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        r8.putLongArray("1", r12);
        r8.putIntegerArrayList(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packCondition(r11.acceptIf));
        return r8;
    }

    private ArrayList<Integer> packPropertyId(ArrayList<DcfEnums.PropertyId> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.PropertyId> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packReferenceClientId(ArrayList<DcfEnums.ReferenceClientId> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.ReferenceClientId> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packScanFilters(DcfUDT.ScanFilters r11) {
        Bundle r8 = new Bundle();
        r8.putBundle("0", packBnryBlb(r11.serviceDataUuids));
        r8.putBundle("1", packBnryBlb(r11.serviceData));
        r8.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packBnryBlb(r11.serviceDataMasks));
        Object[] r10 = r11.manufacturerIds.toArray();
        long[] r12 = new long[r10.length];
        int r13 = r10.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = ((Long) r10[r14]).longValue();
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        r8.putLongArray(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, r12);
        r8.putBundle("4", packBnryBlb(r11.manufacturerData));
        r8.putBundle("5", packBnryBlb(r11.manufacturerDataMasks));
        r8.putStringArrayList("6", r11.deviceNames);
        r8.putBundle("7", packBnryBlb(r11.serviceUuids));
        r8.putBundle("8", packBnryBlb(r11.serviceUuidMasks));
        return r8;
    }

    private ArrayList<Integer> packScanMode(ArrayList<DcfEnums.ScanMode> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.ScanMode> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private Bundle packScanSettings(DcfUDT.ScanSettings r8) {
        Bundle r10 = new Bundle();
        r10.putInt("0", r8.mode.getValue());
        r10.putLong("1", r8.maxLatency);
        r10.putInt(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, r8.highRssiThreshold);
        return r10;
    }

    private ArrayList<Integer> packTriggerRequestType(ArrayList<DcfEnums.TriggerRequestType> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.TriggerRequestType> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packTriggerStatus(ArrayList<DcfEnums.TriggerStatus> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.TriggerStatus> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packTxPowerLevel(ArrayList<DcfEnums.TxPowerLevel> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.TxPowerLevel> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private ArrayList<Integer> packVersion(ArrayList<DcfEnums.Version> r8) {
        ArrayList<Integer> r10 = new ArrayList();
        Iterator<DcfEnums.Version> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(r11.next().getValue()));
        goto L4
    L6:
        return r10;
    }

    private DcfUDT.AdvertiseData unpackAdvertiseData(Bundle r10) {
        DcfUDT.AdvertiseData r8 = new DcfUDT.AdvertiseData();
        r8.serviceData = unpackBnryBlb(r10.getBundle("0"));
        r8.serviceDataUuids = unpackBnryBlb(r10.getBundle("1"));
        long[] r11 = r10.getLongArray(AwareStateListener.USER_INFO_FILE_REMOTE_MODE);
        Long[] r12 = new Long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = Long.valueOf(r11[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        r8.manufacturerIds = new ArrayList(Arrays.asList(r12));
        r8.manufacturerData = unpackBnryBlb(r10.getBundle(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE));
        r8.serviceUuids = unpackBnryBlb(r10.getBundle("4"));
        r8.rawAdvertiseData = r10.getByteArray("5");
        r8.includeLocalName = r10.getInt("6");
        return r8;
    }

    private ArrayList<DcfEnums.AdvertisingInterval> unpackAdvertisingInterval(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.AdvertisingInterval> r10 = new ArrayList();
        DcfEnums.AdvertisingInterval[] r11 = DcfEnums.AdvertisingInterval.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.AdvertisingInterval r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private DcfUDT.AdvertisingParameters unpackAdvertisingParameters(Bundle r8) {
        DcfUDT.AdvertisingParameters r10 = new DcfUDT.AdvertisingParameters();
        int r11 = r8.getInt("0");
        DcfEnums.AdvertisingInterval[] r12 = DcfEnums.AdvertisingInterval.values();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L8;
        DcfEnums.AdvertisingInterval r16 = r12[r15];
        if (r16.getValue() == r11) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        r10.interval = r16;
    L8:
        int r17 = r8.getInt("1");
        DcfEnums.TxPowerLevel[] r18 = DcfEnums.TxPowerLevel.values();
        int r19 = r18.length;
    L9:
        if (r14 >= r19) goto L14;
        DcfEnums.TxPowerLevel r20 = r18[r14];
        if (r20.getValue() == r17) goto L12;
        r14 = r14 + 1;
        goto L9
    L12:
        r10.txPowerLevel = r20;
    L14:
        r10.includeTxPower = r8.getInt(AwareStateListener.USER_INFO_FILE_REMOTE_MODE);
        if (r8.containsKey(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE) == false) goto L17;
        r10.legacy = r8.getInt(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE);
    L17:
        return r10;
    }

    private ArrayList<DcfEnums.BleAdvertiseStatus> unpackBleAdvertiseStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.BleAdvertiseStatus> r10 = new ArrayList();
        DcfEnums.BleAdvertiseStatus[] r11 = DcfEnums.BleAdvertiseStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.BleAdvertiseStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private DcfUDT.BleScanData unpackBleScanData(Bundle r10) {
        DcfUDT.BleScanData r8 = new DcfUDT.BleScanData();
        r8.rawData = r10.getByteArray("0");
        r8.serviceDataUuids = unpackBnryBlb(r10.getBundle("1"));
        r8.serviceData = unpackBnryBlb(r10.getBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE));
        long[] r11 = r10.getLongArray(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE);
        Long[] r12 = new Long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = Long.valueOf(r11[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        r8.manufacturerIds = new ArrayList(Arrays.asList(r12));
        r8.manufacturerData = unpackBnryBlb(r10.getBundle("4"));
        r8.deviceName = r10.getString("5");
        r8.serviceUuids = unpackBnryBlb(r10.getBundle("6"));
        return r8;
    }

    private ArrayList<DcfEnums.BleScanStatus> unpackBleScanStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.BleScanStatus> r10 = new ArrayList();
        DcfEnums.BleScanStatus[] r11 = DcfEnums.BleScanStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.BleScanStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<byte[]> unpackBnryBlb(Bundle r8) {
        ArrayList<byte[]> r10 = new ArrayList();
        int r11 = r8.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(r8.getByteArray(String.valueOf(r12)));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    private ArrayList<DcfEnums.ClientRegistrationStatus> unpackClientRegistrationStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.ClientRegistrationStatus> r10 = new ArrayList();
        DcfEnums.ClientRegistrationStatus[] r11 = DcfEnums.ClientRegistrationStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.ClientRegistrationStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.Condition> unpackCondition(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.Condition> r10 = new ArrayList();
        DcfEnums.Condition[] r11 = DcfEnums.Condition.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.Condition r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.CustomRequestStatus> unpackCustomRequestStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.CustomRequestStatus> r10 = new ArrayList();
        DcfEnums.CustomRequestStatus[] r11 = DcfEnums.CustomRequestStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.CustomRequestStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private DcfUDT.DataFilters unpackDataFilters(Bundle r10) {
        DcfUDT.DataFilters r8 = new DcfUDT.DataFilters();
        r8.serviceDataUuids = unpackBnryBlb(r10.getBundle("0"));
        r8.serviceData = unpackBnryBlb(r10.getBundle("1"));
        r8.serviceDataMasks = unpackBnryBlb(r10.getBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE));
        long[] r11 = r10.getLongArray(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE);
        Long[] r12 = new Long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = Long.valueOf(r11[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        r8.manufacturerIds = new ArrayList(Arrays.asList(r12));
        r8.manufacturerData = unpackBnryBlb(r10.getBundle("4"));
        r8.manufacturerDataMasks = unpackBnryBlb(r10.getBundle("5"));
        return r8;
    }

    private ArrayList<DcfEnums.DuplicateDetectionStatus> unpackDuplicateDetectionStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.DuplicateDetectionStatus> r10 = new ArrayList();
        DcfEnums.DuplicateDetectionStatus[] r11 = DcfEnums.DuplicateDetectionStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.DuplicateDetectionStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.PlatformStatus> unpackPlatformStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.PlatformStatus> r10 = new ArrayList();
        DcfEnums.PlatformStatus[] r11 = DcfEnums.PlatformStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.PlatformStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private DcfUDT.Properties unpackProperties(Bundle r8) {
        DcfUDT.Properties r10 = new DcfUDT.Properties();
        r10.propertyIds = unpackPropertyId(r8.getIntegerArrayList("0"));
        long[] r11 = r8.getLongArray("1");
        Long[] r12 = new Long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = Long.valueOf(r11[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        r10.propertyValues = new ArrayList(Arrays.asList(r12));
        return r10;
    }

    private DcfUDT.PropertyFilters unpackPropertyFilters(Bundle r10) {
        DcfUDT.PropertyFilters r8 = new DcfUDT.PropertyFilters();
        r8.propertyIds = unpackPropertyId(r10.getIntegerArrayList("0"));
        long[] r11 = r10.getLongArray("1");
        Long[] r12 = new Long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = Long.valueOf(r11[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        r8.propertyValues = new ArrayList(Arrays.asList(r12));
        r8.acceptIf = unpackCondition(r10.getIntegerArrayList(AwareStateListener.USER_INFO_FILE_REMOTE_MODE));
        return r8;
    }

    private ArrayList<DcfEnums.PropertyId> unpackPropertyId(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.PropertyId> r10 = new ArrayList();
        DcfEnums.PropertyId[] r11 = DcfEnums.PropertyId.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.PropertyId r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.ReferenceClientId> unpackReferenceClientId(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.ReferenceClientId> r10 = new ArrayList();
        DcfEnums.ReferenceClientId[] r11 = DcfEnums.ReferenceClientId.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.ReferenceClientId r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private DcfUDT.ScanFilters unpackScanFilters(Bundle r10) {
        DcfUDT.ScanFilters r8 = new DcfUDT.ScanFilters();
        r8.serviceDataUuids = unpackBnryBlb(r10.getBundle("0"));
        r8.serviceData = unpackBnryBlb(r10.getBundle("1"));
        r8.serviceDataMasks = unpackBnryBlb(r10.getBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE));
        long[] r11 = r10.getLongArray(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE);
        Long[] r12 = new Long[r11.length];
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r15] = Long.valueOf(r11[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        r8.manufacturerIds = new ArrayList(Arrays.asList(r12));
        r8.manufacturerData = unpackBnryBlb(r10.getBundle("4"));
        r8.manufacturerDataMasks = unpackBnryBlb(r10.getBundle("5"));
        r8.deviceNames = r10.getStringArrayList("6");
        r8.serviceUuids = unpackBnryBlb(r10.getBundle("7"));
        r8.serviceUuidMasks = unpackBnryBlb(r10.getBundle("8"));
        return r8;
    }

    private ArrayList<DcfEnums.ScanMode> unpackScanMode(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.ScanMode> r10 = new ArrayList();
        DcfEnums.ScanMode[] r11 = DcfEnums.ScanMode.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.ScanMode r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private DcfUDT.ScanSettings unpackScanSettings(Bundle r8) {
        DcfUDT.ScanSettings r10 = new DcfUDT.ScanSettings();
        int r11 = r8.getInt("0");
        DcfEnums.ScanMode[] r12 = DcfEnums.ScanMode.values();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        DcfEnums.ScanMode r15 = r12[r14];
        if (r15.getValue() == r11) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        r10.mode = r15;
    L8:
        r10.maxLatency = r8.getLong("1");
        r10.highRssiThreshold = r8.getInt(AwareStateListener.USER_INFO_FILE_REMOTE_MODE);
        return r10;
    }

    private ArrayList<DcfEnums.TriggerRequestType> unpackTriggerRequestType(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.TriggerRequestType> r10 = new ArrayList();
        DcfEnums.TriggerRequestType[] r11 = DcfEnums.TriggerRequestType.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.TriggerRequestType r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.TriggerStatus> unpackTriggerStatus(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.TriggerStatus> r10 = new ArrayList();
        DcfEnums.TriggerStatus[] r11 = DcfEnums.TriggerStatus.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.TriggerStatus r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.TxPowerLevel> unpackTxPowerLevel(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.TxPowerLevel> r10 = new ArrayList();
        DcfEnums.TxPowerLevel[] r11 = DcfEnums.TxPowerLevel.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.TxPowerLevel r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    private ArrayList<DcfEnums.Version> unpackVersion(ArrayList<Integer> r8) {
        ArrayList<DcfEnums.Version> r10 = new ArrayList();
        DcfEnums.Version[] r11 = DcfEnums.Version.values();
        Iterator<Integer> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = r12.next();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        DcfEnums.Version r16 = r11[r15];
        if (r16.getValue() != r13.intValue()) goto L10;
        r10.add(r16);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r10;
    }

    public int cancelDuplicateDetection(long r8, int r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        r11.putInt("1", r10);
        Bundle r15 = this.qesdkManager.PerformTask(r14, DcfApis.DCF_API_CANCELDUPLICATEDETECTION, r11);
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int cancelTrigger(long r8, int r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        r11.putInt("1", r10);
        Bundle r15 = this.qesdkManager.PerformTask(r14, DcfApis.DCF_API_CANCELTRIGGER, r11);
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int configureDuplicateDetection(long r8, int r10, DcfUDT.DataFilters r11, DcfUDT.PropertyFilters r12) {
        Bundle r13 = new Bundle();
        IQesdk r14 = this.qesdkManager;
        if (r14 != null) goto L7;
        String r15 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r15);
        return -1;
    L7:
        int r16 = r14.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r13.putLong("0", r8);
        r13.putInt("1", r10);
        r13.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packDataFilters(r11));
        r13.putBundle(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, packPropertyFilters(r12));
        Bundle r17 = this.qesdkManager.PerformTask(r16, DcfApis.DCF_API_CONFIGUREDUPLICATEDETECTION, r13);
        int r18 = r17.getInt("status");
        if (r18 != 0) goto L17;
        return r17.getInt("0");
    L17:
        throw new QesdkStatusException(r18);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r15 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int configureDuplicateDetection2(long r8, int r10, long r11, DcfUDT.DataFilters r12, DcfUDT.PropertyFilters r13) {
        Bundle r14 = new Bundle();
        IQesdk r15 = this.qesdkManager;
        if (r15 != null) goto L7;
        String r16 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r16);
        return -1;
    L7:
        int r17 = r15.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r14.putLong("0", r8);
        r14.putInt("1", r10);
        r14.putLong(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, r11);
        r14.putBundle(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, packDataFilters(r12));
        r14.putBundle("4", packPropertyFilters(r13));
        Bundle r18 = this.qesdkManager.PerformTask(r17, DcfApis.DCF_API_CONFIGUREDUPLICATEDETECTION2, r14);
        int r19 = r18.getInt("status");
        if (r19 != 0) goto L17;
        return r18.getInt("0");
    L17:
        throw new QesdkStatusException(r19);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r16 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int deinit() {
        if (this.qesdkManager != null) goto L6;
        return -1;
    L6:
        if (this.init_flag.get() != true) goto L13;
        AtomicInteger r8 = DcfManagerReference.init_count;
        r8.updateAndGet(new a());
        if (r8.get() != 0) goto L10;
        int r10 = this.qesdkManager.deinit(99, SUBSYSTEM_ID);
    L11:
        this.init_flag.set(false);
    L21:
        this.sessionId = 0;
        return r10;
    L10:
        r10 = 0;
        goto L11
    L13:
        if (this.qesdkManager.checkGlobalInit() == false) goto L18;
        if (DcfManagerReference.init_count.get() != 0) goto L18;
        r10 = this.qesdkManager.deinit(99, SUBSYSTEM_ID);
    L18:
        if (this.init_flag.get() == true) goto L20;
        return -1;
    L20:
        r10 = 0;
        goto L21
    }

    public int deregisterClient(long r8) {
        Bundle r10 = new Bundle();
        IQesdk r11 = this.qesdkManager;
        if (r11 != null) goto L7;
        String r12 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r12);
        return -1;
    L7:
        int r13 = r11.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r10.putLong("0", r8);
        Bundle r14 = this.qesdkManager.PerformTask(r13, DcfApis.DCF_API_DEREGISTERCLIENT, r10);
        int r15 = r14.getInt("status");
        if (r15 != 0) goto L17;
        return r14.getInt("0");
    L17:
        throw new QesdkStatusException(r15);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r12 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public DcfEnums.Version getVersion() {
        Bundle r8 = new Bundle();
        IQesdk r10 = this.qesdkManager;
        if (r10 != null) goto L7;
        String r11 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r11);
        return null;
    L7:
        int r12 = r10.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        Bundle r13 = this.qesdkManager.PerformTask(r12, DcfApis.DCF_API_GETVERSION, r8);
        int r14 = r13.getInt("status");
        if (r14 != 0) goto L22;
        int r15 = r13.getInt("0");
        DcfEnums.Version[] r16 = DcfEnums.Version.values();
        int r17 = r16.length;
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L20;
        DcfEnums.Version r19 = r16[r18];
        if (r19.getValue() == r15) goto L18;
        r18 = r18 + 1;
        goto L15
    L18:
        return r19;
    L20:
        return null;
    L22:
        throw new QesdkStatusException(r14);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r11 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int get_highest_version() {
        return 6;
    }

    public int init(IQesdkEventCallBack r8) {
        if (this.qesdkManager != null) goto L7;
        return -1;
    L7:
        if (this.init_flag.get() == true) goto L16;
        AtomicInteger r10 = DcfManagerReference.init_count;
        if (r10.get() != 0) goto L14;
        int r11 = this.qesdkManager.init(r8, 99, SUBSYSTEM_ID);
        this.sessionId = r11;
        DcfManagerReference.gsession_id = r11;
        if (r11 <= 0) goto L13;
        r10.incrementAndGet();
    L15:
        this.init_flag.set(true);
    L20:
        return this.sessionId;
    L13:
        return r11;
    L14:
        r10.incrementAndGet();
        this.sessionId = DcfManagerReference.gsession_id;
        goto L15
    L16:
        int r12 = this.sessionId;
        int r13 = DcfManagerReference.gsession_id;
        if (r12 == r13) goto L20;
        this.sessionId = r13;
        goto L20
    }

    public int registerClient(long r8, final IDcfCBs.IClientRegistrationCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_REGISTERCLIENT, r11, new AnonymousClass1(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int sendCustomRequest(long r8, byte[] r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        r11.putByteArray("1", r10);
        Bundle r15 = this.qesdkManager.PerformTask(r14, DcfApis.DCF_API_SENDCUSTOMREQUEST, r11);
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setBatchPeriodPreference(long r8, long r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        r11.putLong("1", r10);
        Bundle r15 = this.qesdkManager.PerformTask(r14, DcfApis.DCF_API_SETBATCHPERIODPREFERENCE, r11);
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setBleAdvertiseStatusCallback(long r8, final IDcfCBs.IBleAdvertiseStatusCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETBLEADVERTISESTATUSCALLBACK, r11, new AnonymousClass7(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setBleScanStatusCallback(long r8, final IDcfCBs.IBleScanStatusCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETBLESCANSTATUSCALLBACK, r11, new AnonymousClass6(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setCustomEventCallback(long r8, final IDcfCBs.ICustomEventCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETCUSTOMEVENTCALLBACK, r11, new AnonymousClass9(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setCustomRequestStatusCallback(long r8, final IDcfCBs.ICustomRequestStatusCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETCUSTOMREQUESTSTATUSCALLBACK, r11, new AnonymousClass8(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setDataReadyCallback(long r8, final IDcfCBs.IDataReadyCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETDATAREADYCALLBACK, r11, new AnonymousClass3(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setDuplicateDetectionStatusCallback(long r8, final IDcfCBs.IDuplicateDetectionStatusCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETDUPLICATEDETECTIONSTATUSCALLBACK, r11, new AnonymousClass5(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setPlatformStatusCallback(long r8, final IDcfCBs.IPlatformStatusCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETPLATFORMSTATUSCALLBACK, r11, new AnonymousClass2(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setTrigger(long r8, DcfUDT.DataFilters r10, DcfUDT.PropertyFilters r11) {
        Bundle r12 = new Bundle();
        IQesdk r13 = this.qesdkManager;
        if (r13 != null) goto L7;
        String r14 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r14);
        return -1;
    L7:
        int r15 = r13.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r12.putLong("0", r8);
        r12.putBundle("1", packDataFilters(r10));
        r12.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packPropertyFilters(r11));
        Bundle r16 = this.qesdkManager.PerformTask(r15, DcfApis.DCF_API_SETTRIGGER, r12);
        int r17 = r16.getInt("status");
        if (r17 != 0) goto L17;
        return r16.getInt("0");
    L17:
        throw new QesdkStatusException(r17);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r14 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int setTriggerStatusCallback(long r8, final IDcfCBs.ITriggerStatusCallback r10) {
        Bundle r11 = new Bundle();
        IQesdk r12 = this.qesdkManager;
        if (r12 != null) goto L7;
        String r13 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r13);
        return -1;
    L7:
        int r14 = r12.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r11.putLong("0", r8);
        Bundle r15 = this.qesdkManager.PerformTaskAsync(r14, DcfApis.DCF_API_SETTRIGGERSTATUSCALLBACK, r11, new AnonymousClass4(this, r10));
        int r16 = r15.getInt("status");
        if (r16 != 0) goto L17;
        return r15.getInt("0");
    L17:
        throw new QesdkStatusException(r16);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r13 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int startBleAdvertising(long r8, DcfUDT.AdvertisingParameters r10, DcfUDT.AdvertiseData r11, long r12) {
        Bundle r13 = new Bundle();
        IQesdk r14 = this.qesdkManager;
        if (r14 != null) goto L7;
        String r15 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r15);
        return -1;
    L7:
        int r16 = r14.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r13.putLong("0", r8);
        r13.putBundle("1", packAdvertisingParameters(r10));
        r13.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packAdvertiseData(r11));
        r13.putLong(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, r12);
        Bundle r17 = this.qesdkManager.PerformTask(r16, DcfApis.DCF_API_STARTBLEADVERTISING, r13);
        int r18 = r17.getInt("status");
        if (r18 != 0) goto L17;
        return r17.getInt("0");
    L17:
        throw new QesdkStatusException(r18);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r15 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int startBleAdvertising2(long r8, DcfUDT.AdvertisingParameters r10, DcfUDT.AdvertiseData r11, DcfUDT.AdvertiseData r12, long r13) {
        Bundle r14 = new Bundle();
        IQesdk r15 = this.qesdkManager;
        if (r15 != null) goto L7;
        String r16 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r16);
        return -1;
    L7:
        int r17 = r15.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r14.putLong("0", r8);
        r14.putBundle("1", packAdvertisingParameters(r10));
        r14.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packAdvertiseData(r11));
        r14.putBundle(AwareStateListener.USER_INFO_FILE_BOTH_REMOTE_MODE, packAdvertiseData(r12));
        r14.putLong("4", r13);
        Bundle r18 = this.qesdkManager.PerformTask(r17, DcfApis.DCF_API_STARTBLEADVERTISING2, r14);
        int r19 = r18.getInt("status");
        if (r19 != 0) goto L17;
        return r18.getInt("0");
    L17:
        throw new QesdkStatusException(r19);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r16 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int startBleScan(long r8, DcfUDT.ScanSettings r10, DcfUDT.ScanFilters r11) {
        Bundle r12 = new Bundle();
        IQesdk r13 = this.qesdkManager;
        if (r13 != null) goto L7;
        String r14 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r14);
        return -1;
    L7:
        int r15 = r13.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r12.putLong("0", r8);
        r12.putBundle("1", packScanSettings(r10));
        r12.putBundle(AwareStateListener.USER_INFO_FILE_REMOTE_MODE, packScanFilters(r11));
        Bundle r16 = this.qesdkManager.PerformTask(r15, DcfApis.DCF_API_STARTBLESCAN, r12);
        int r17 = r16.getInt("status");
        if (r17 != 0) goto L17;
        return r16.getInt("0");
    L17:
        throw new QesdkStatusException(r17);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r14 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int stopBleAdvertising(long r8) {
        Bundle r10 = new Bundle();
        IQesdk r11 = this.qesdkManager;
        if (r11 != null) goto L7;
        String r12 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r12);
        return -1;
    L7:
        int r13 = r11.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r10.putLong("0", r8);
        Bundle r14 = this.qesdkManager.PerformTask(r13, DcfApis.DCF_API_STOPBLEADVERTISING, r10);
        int r15 = r14.getInt("status");
        if (r15 != 0) goto L17;
        return r14.getInt("0");
    L17:
        throw new QesdkStatusException(r15);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r12 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int stopBleScan(long r8) {
        Bundle r10 = new Bundle();
        IQesdk r11 = this.qesdkManager;
        if (r11 != null) goto L7;
        String r12 = "the handle to qesdk is null. Consider IQesdk.createInstance(..)";
    L5:
        Log.e("Qesdk", r12);
        return -1;
    L7:
        int r13 = r11.getSessionId();
        if (this.sessionId <= 0) goto L10;
    L12:
        r10.putLong("0", r8);
        Bundle r14 = this.qesdkManager.PerformTask(r13, DcfApis.DCF_API_STOPBLESCAN, r10);
        int r15 = r14.getInt("status");
        if (r15 != 0) goto L17;
        return r14.getInt("0");
    L17:
        throw new QesdkStatusException(r15);
    L10:
        if (this.qesdkManager.checkGlobalInit() == true) goto L12;
        r12 = "session isn't initialized. Consider initializing a session!";
        goto L5
    }

    public int init(String r8, IQesdkEventCallBack r10) {
        if (this.qesdkManager != null) goto L7;
        return -1;
    L7:
        if (this.init_flag.get() == true) goto L16;
        AtomicInteger r11 = DcfManagerReference.init_count;
        if (r11.get() != 0) goto L14;
        int r12 = this.qesdkManager.init(r8, 99, SUBSYSTEM_ID, r10);
        this.sessionId = r12;
        DcfManagerReference.gsession_id = r12;
        if (r12 <= 0) goto L13;
        r11.incrementAndGet();
    L15:
        this.init_flag.set(true);
    L20:
        return this.sessionId;
    L13:
        return r12;
    L14:
        r11.incrementAndGet();
        this.sessionId = DcfManagerReference.gsession_id;
        goto L15
    L16:
        int r13 = this.sessionId;
        int r14 = DcfManagerReference.gsession_id;
        if (r13 == r14) goto L20;
        this.sessionId = r14;
        goto L20
    }
}
