package com.sdk.bwdl.StateMachine;

import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLCommandBuilder {
    public static final byte CHANNEL_CONFIG_REQ = 21;
    public static final byte CHANNEL_CONFIG_RESP = 22;
    public static final byte CUSTOMIZED_CMD = 80;
    public static final byte DATA_LINK_REQ = 19;
    public static final byte DATA_LINK_RESP = 20;
    public static final byte DEVICE_CAPABILITIES = 23;
    private static final String TAG = "BWDLCommandBuilder";
    public static final byte TYPE_CUSTOMIZED = 2;
    public static final byte TYPE_GENERIC = 1;
    public static final short TYPE_INDICATE = -1176;
    public static final short TYPE_NOTIFICATION = -1196;
    public static final short TYPE_READ = -1236;
    public static final short TYPE_WRITE = -1216;
    private static final Object mLock = null;

    static {
        mLock = new Object();
    }

    public BWDLCommandBuilder() {
    }

    public static byte[] buildChannelConfigReq(short r10, String r11, int r12) {
        Object r8 = mLock;
        monitor-enter(r8);
        byte[] r13 = new byte[0];     // Catch: Throwable -> L19
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        r14.write(BWDLUtil.intToBytes(r12));     // Catch: IOException -> L8 Throwable -> L19
        r14.write(r11.getBytes("UTF-8"));     // Catch: IOException -> L8 Throwable -> L19
        r13 = r14.toByteArray();     // Catch: IOException -> L8 Throwable -> L19
    L25:
        byte[] r15 = new BWDLDataStructure.BWDLCommandStructure(TYPE_WRITE, (byte) 1, r10, CHANNEL_CONFIG_REQ, r13).buildCmd();     // Catch: IOException -> L14 Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return r15;
    L14:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L19
        return null;
    L8:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static byte[] buildChannelConfigResp(short r10, String r11, int r12) {
        Object r8 = mLock;
        monitor-enter(r8);
        byte[] r13 = new byte[0];     // Catch: Throwable -> L19
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        r14.write(BWDLUtil.intToBytes(r12));     // Catch: IOException -> L8 Throwable -> L19
        r14.write(r11.getBytes("UTF-8"));     // Catch: IOException -> L8 Throwable -> L19
        r13 = r14.toByteArray();     // Catch: IOException -> L8 Throwable -> L19
    L25:
        byte[] r15 = new BWDLDataStructure.BWDLCommandStructure(TYPE_WRITE, (byte) 1, r10, CHANNEL_CONFIG_RESP, r13).buildCmd();     // Catch: IOException -> L14 Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return r15;
    L14:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L19
        return null;
    L8:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static byte[] buildCustomizedWriteCmd(short r10, byte[] r11) {
        Object r8 = mLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L17:
        byte[] r12 = new BWDLDataStructure.BWDLCommandStructure(TYPE_WRITE, (byte) 2, r10, CUSTOMIZED_CMD, r11).buildCmd();     // Catch: IOException -> L8 Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return r12;
    L8:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L13
        return null;
    }

    public static byte[] buildDataLinkExchangeInfoCmd(short r10, byte[] r11) {
        Object r8 = mLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L17:
        byte[] r12 = new BWDLDataStructure.BWDLCommandStructure(TYPE_WRITE, (byte) 1, r10, DEVICE_CAPABILITIES, r11).buildCmd();     // Catch: IOException -> L8 Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return r12;
    L8:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L13
        return null;
    }

    public static byte[] buildDataLinkReq(byte[] r10, short r11) {
        Object r8 = mLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L17:
        byte[] r12 = new BWDLDataStructure.BWDLCommandStructure(TYPE_WRITE, (byte) 1, r11, (byte) 19, r10).buildCmd();     // Catch: IOException -> L8 Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return r12;
    L8:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L13
        return null;
    }

    public static byte[] buildDataLinkResp(byte[] r10, short r11) {
        Object r8 = mLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L17:
        byte[] r12 = new BWDLDataStructure.BWDLCommandStructure(TYPE_WRITE, (byte) 1, r11, DATA_LINK_RESP, r10).buildCmd();     // Catch: IOException -> L8 Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return r12;
    L8:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());     // Catch: Throwable -> L13
        return null;
    }
}
