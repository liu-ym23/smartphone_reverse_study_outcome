package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.content.a;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import com.sdk.bwdl.NearFieldSwap.AdvCustomizedStructure;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLAdvDataParser {
    private static String TAG = "BWDLAdvDataParser";
    private boolean hasValidBWDLData;
    private BWDLDevice mBWDLDevice;
    private BWDLDiscoveryData mBWDLDiscoveryData;
    private Context mContext;
    private byte mFeatureType;
    private ScanResult mResult;
    private short mServiceUuid;
    private Map<Integer, byte[]> tlvMap;

    public BWDLAdvDataParser(Context r8, ScanResult r10) {
        this.tlvMap = new HashMap();
        this.mContext = r8;
        this.mResult = r10;
        parseResultData();
    }

    public static boolean checkBWDLDataValid(SparseArray<byte[]> r8) {
        if (r8 != null) goto L5;
    L18:
        return false;
    L5:
        if (r8.size() == 0) goto L18;
        int r10 = 0;
    L9:
        if (r10 >= r8.size()) goto L18;
        byte[] r11 = r8.valueAt(r10);
        if (r11 == null) goto L17;
        if (r11[0] != BwdlAdvConstants.BwdlFlagsLengh) goto L17;
        if (r11[1] != BwdlAdvConstants.BwdlFlagsType) goto L17;
        return true;
    L17:
        r10 = r10 + 1;
        goto L9
    }

    public static boolean checkBWDLDataValidByte(byte[] r8) {
        if (r8 != null) goto L5;
    L11:
        return false;
    L5:
        if (r8.length <= 2) goto L11;
        if (r8[0] != BwdlAdvConstants.BwdlFlagsLengh) goto L11;
        if (r8[1] != BwdlAdvConstants.BwdlFlagsType) goto L11;
        return true;
    }

    private static List<AdvCustomizedStructure> parseTLVBytes(byte[] r8) {
        CopyOnWriteArrayList r10 = new CopyOnWriteArrayList();
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L6;
        int r12 = r11 + 1;
        int r13 = r8[r11];
        int r14 = r12 + 1;
        byte r15 = r8[r12];
        byte[] r16 = new byte[r13];
        System.arraycopy(r8, r14, r16, 0, r13);
        r10.add(new AdvCustomizedStructure((short) r13, r15, r16));
        r11 = r14 + r13;
        goto L4
    L6:
        return r10;
    }

    private void setHasValidBWDLData(boolean r8) {
        this.hasValidBWDLData = r8;
    }

    public BWDLDiscoveryData getBWDLDiscoveryData() {
        parseBWDLDiscoveryData();
        return this.mBWDLDiscoveryData;
    }

    public byte getFeatureType() {
        return this.mFeatureType;
    }

    public boolean getHasValidBWDLData() {
        return this.hasValidBWDLData;
    }

    public short getServiceUuid() {
        return this.mServiceUuid;
    }

    public void parseBWDLDiscoveryData() {
        if (a.a(this.mContext, "android.permission.BLUETOOTH_CONNECT") == 0) goto L5;
        return;
    L5:
        BWDLDiscoveryData.Builder r8 = new BWDLDiscoveryData.Builder();
        r8.setBluetoothDevice(this.mResult.getDevice());
        r8.setDeviceType(this.mResult.getDevice().getType());
        r8.setConnected(this.mResult.isConnectable());
        r8.setMacAddress(this.mResult.getDevice().getAddress());
        r8.setDeviceName(this.mResult.getScanRecord().getDeviceName());
        r8.setRssi(this.mResult.getRssi());
        r8.setPeriodMillis((int) (((double) this.mResult.getPeriodicAdvertisingInterval()) / 1000.0d));
        r8.setTxPower(this.mResult.getTxPower());
        r8.setUuids(this.mResult.getScanRecord().getServiceUuids());
        r8.setManufacturerData(this.mResult.getScanRecord().getManufacturerSpecificData());
        SparseArray<byte[]> r10 = this.mResult.getScanRecord().getManufacturerSpecificData();
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r12 >= r10.size()) goto L9;
        r13 = r13 + r10.valueAt(r12).length;
        r12 = r12 + 1;
        goto L7
    L9:
        if (r13 != 0) goto L12;
        BWDLLog.d(TAG, "onScanResult Len: " + r13);
        return;
    L12:
        byte[] r14 = new byte[r13];
        int r15 = 0;
        int r16 = 0;
    L14:
        if (r15 >= r10.size()) goto L16;
        System.arraycopy(r10.valueAt(r15), 0, r14, r16, r10.valueAt(r15).length);
        r16 = r16 + r10.valueAt(r15).length;
        r15 = r15 + 1;
        goto L14
    L16:
        if (r13 <= 0) goto L47;
        int r17 = 0;
    L19:
        if (r17 > (r13 - 1)) goto L47;
        int r18 = r14[r17] & 255;
        if (r18 == 0) goto L47;
        if (r18 > ((r13 - r17) - 2)) goto L47;
        byte r19 = r14[r17 + 1];
        int r20 = r18 - 1;
        byte[] r110 = new byte[r20];
        System.arraycopy(r14, r17 + 2, r110, r11, r20);
        int r21 = r17 + r18;
        UUID r22 = BwdlAdvConstants.SERVICE_UUID;
        if (r19 != BwdlAdvConstants.BwdlAdVServiceDataType) goto L45;
        int r23 = BwdlAdvConstants.BwdlServiceCommonDataLen;
        if (r20 < r23) goto L29;
        byte[] r24 = Arrays.copyOfRange(r110, r11, r23);
        short r25 = (short) (r24[r11] | (r24[1] << 8));
        byte r111 = r24[2];
        short r112 = (short) (r24[3] & (r24[4] << 8));
        byte r26 = r24[5];
        byte r113 = r24[6];
        short r27 = (short) (r26 & (r113 << 8));
        byte r114 = r24[7];
        byte r28 = r24[8];
        int r29 = ((((r114 & 255) << 16) | ((r28 & 255) << 24)) | ((r113 & 255) << 8)) | (r26 & 255);
        r8.setCompanyID(r25);
        r8.setAdvVersion(r111);
        r8.setServiceCapabilities(r112);
        if (r25 != 0) goto L34;
        r8.setDeviceId(r29);
    L35:
        int r30 = BwdlAdvConstants.BwdlServiceCommonDataLen;
        if (r20 <= r30) goto L37;
        byte[] r31 = Arrays.copyOfRange(r110, r30, r20);
        int r32 = 0;
        short r33 = (short) ((r31[1] << 8) | (r31[0] & 255));
        int r34 = Byte.toUnsignedInt(r31[2]);
        int r35 = Byte.toUnsignedInt(r31[3]);
        byte r36 = r31[4];
        byte[] r115 = null;
        if (r35 <= 0) goto L41;
        byte[] r116 = Arrays.copyOfRange(r31, 5, r35 + 4);
    L42:
        if (r34 <= r35) goto L44;
        r115 = Arrays.copyOfRange(r31, r35 + 4, r34 + 3);
    L44:
        r8.setBWDLAdvertisingData(r33, r36, r116, r115);
        int r37 = 1;
    L46:
        r17 = r21 + r37;
        r11 = r32;
        r14 = r14;
        goto L19
    L41:
        r116 = null;
        goto L42
    L37:
        String r38 = TAG;
        StringBuilder r39 = new StringBuilder("BWDL Service no user data: ");
        r39.append(r110);
    L30:
        BWDLLog.d(r38, r39.toString());
        goto L47
    L34:
        r8.setProductPriPID(r27);
        r8.setProductSubPID(r114);
        r8.setBattery(r28);
        goto L35
    L29:
        r38 = TAG;
        r39 = new StringBuilder("BWDLServiceData error: ");
        r39.append(Arrays.toString(r14));
        goto L30
    L45:
        r32 = r11;
        r37 = 1;
    L47:
        r8.setBWDLDevice(this.mResult.getDevice());
        r8.setTimeStamp(-1);
        this.mBWDLDiscoveryData = r8.build();
    }

    public void parseData(byte[] r8, Consumer<byte[]> r10) {
        r10.accept(r8);
    }

    public void parseResultData() {
        if (this.mResult.getScanRecord() != null) goto L6;
        setHasValidBWDLData(false);
        return;
    L6:
        byte[] r8 = this.mResult.getScanRecord().getManufacturerSpecificData(BwdlAdvConstants.MANUFACTURER_ID);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.length <= 0) goto L13;
        setHasValidBWDLData(checkBWDLDataValidByte(r8));
        return;
    }
}
