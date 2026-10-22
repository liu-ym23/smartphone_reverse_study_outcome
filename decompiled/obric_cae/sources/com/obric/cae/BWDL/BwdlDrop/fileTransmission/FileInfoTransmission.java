package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import androidx.appcompat.app.r;
import androidx.room.m;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropEventHandler;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import defpackage.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class FileInfoTransmission {
    private static final int BUFFER_SIZE = 102400;
    private static final int HEADER_SIZE = 4;
    private static final String TAG = "FileInfoTransmission";
    private static final ExecutorService mExecutor = null;

    static {
        mExecutor = Executors.newSingleThreadExecutor();
    }

    public FileInfoTransmission() {
    }

    public static /* synthetic */ void a(BWDLDevice r8, byte[] r10) {
        lambda$sendDataAsync$0(r8, r10);
    }

    public static /* synthetic */ void b(BWDLDevice r8, BwdlDropEventHandler r10, BwdlDropDeviceManager r11) {
        lambda$receiveDataAsync$1(r8, r10, r11);
    }

    private static /* synthetic */ void lambda$receiveDataAsync$1(BWDLDevice r8, BwdlDropEventHandler r10, BwdlDropDeviceManager r11) {
        SocketChannel r12 = validateChannel(r8);
        if (r12 != null) goto L14;
        return;
    L14:
        byte[] r13 = receiveWithHeader(r12);     // Catch: IOException -> L11
        CaeLog.d(TAG, "Received data length: " + r13.length);     // Catch: IOException -> L11
        if (r13.length != 0) goto L9;
        CaeLog.e(TAG, "Received data is empty");     // Catch: IOException -> L11
        return;
    L9:
        CaeLog.d(TAG, "receiveDataAsync: ".concat(new String(r13, StandardCharsets.UTF_8)));     // Catch: IOException -> L11
        r10.sendMessageWithParam(9, 0, r11.getDeviceId(), r13);     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "Receive error: " + e.getMessage());
    }

    private static /* synthetic */ void lambda$sendDataAsync$0(BWDLDevice r8, byte[] r10) {
        SocketChannel r11 = validateChannel(r8);
        if (r11 != null) goto L5;
        return;
    L5:
        sendBytes(r11, r10);
        a.j(new StringBuilder("sendDataAsync finish: "), r10.length, TAG);
    }

    private static void readFully(SocketChannel r8, ByteBuffer r10) {
    L3:
        if (r10.hasRemaining() == false) goto L6;
        if (r8.read(r10) != (-1)) goto L3;
        return;
    }

    public static void receiveDataAsync(BWDLDevice r8, BwdlDropEventHandler r10, BwdlDropDeviceManager r11) {
        mExecutor.execute(new m(r8, r10, r11, 1));
    }

    private static byte[] receiveWithHeader(SocketChannel r8) {
        ByteBuffer r10 = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
        readFully(r8, r10);
        int r11 = r10.getInt(0);
        if (r11 > 0) goto L5;
    L9:
        android.aimedia.a.p("Invalid data length: ", r11, TAG);
        return new byte[0];
    L5:
        if (r11 > BUFFER_SIZE) goto L9;
        ByteBuffer r12 = ByteBuffer.allocate(r11);
        readFully(r8, r12);
        return r12.array();
    }

    private static void sendBytes(SocketChannel r8, byte[] r10) {
        ByteBuffer r11 = (ByteBuffer) ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(r10.length).flip();
        ByteBuffer r12 = ByteBuffer.wrap(r10);
    L4:
        if (r11.hasRemaining() == false) goto L10;
        r8.write(r11);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        CaeLog.e(TAG, "Error sending header: " + e.getMessage());
    L10:
        if (r12.hasRemaining() == false) goto L15;
        r8.write(r12);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "Error sending payload: " + e.getMessage());
        goto L10
    }

    public static void sendDataAsync(BWDLDevice r8, byte[] r10, BwdlDropManager r11) {
        mExecutor.execute(new r(10, r8, r10));
    }

    private static SocketChannel validateChannel(BWDLDevice r8) {
        if (r8 != null) goto L4;
    L8:
        CaeLog.e(TAG, "Invalid device or channel type");
        return null;
    L4:
        if (r8.getConnectivityType() != BWDLInnerConstant.ConnectivityType.SocketChannel) goto L8;
        return (SocketChannel) r8.getDeviceInfo();
    }
}
