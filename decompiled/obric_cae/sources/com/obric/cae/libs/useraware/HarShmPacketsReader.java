package com.obric.cae.libs.useraware;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.OsConstants;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HarShmPacketsReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f5524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedMemory f5525b;

    public HarShmPacketsReader() {
    }

    public static int getSingleBufferSize() {
        return 65536;
    }

    @SuppressLint({"NewApi"})
    public void closeShm() {
        ByteBuffer r8 = this.f5524a;
        if (r8 == null) goto L5;
        SharedMemory.unmap(r8);
        this.f5524a = null;
    L5:
        SharedMemory r10 = this.f5525b;
        if (r10 == null) goto L9;
        r10.close();
        this.f5525b = null;
        return;
    }

    public ByteBuffer getHarShmMappedBuffer() {
        return this.f5524a;
    }

    @SuppressLint({"NewApi"})
    public boolean openShm(ParcelFileDescriptor r8) {
        this.f5525b = SharedMemory.fromFileDescriptor(r8);     // Catch: Throwable -> L6
        r8.close();     // Catch: Throwable -> L6
        SharedMemory r10 = this.f5525b;     // Catch: Throwable -> L6
        this.f5524a = r10.map(OsConstants.PROT_READ, 0, r10.getSize());     // Catch: Throwable -> L6
        return true;
    L6:
        e = move-exception;
        this.f5524a = null;
        e.printStackTrace();
        return false;
    }

    public List<UnifiedDataPacket> processDataBatch(ByteBuffer r8, int r10, int r11) {
        int r12 = r10 * 65536;
        ArrayList r13 = new ArrayList();
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L26;
        r8.position(r12 + r14);
        if (r8.remaining() < 4) goto L6;
        int r15 = r8.getInt();
        if (r15 <= 0) goto L24;
        if (r15 > 65536) goto L24;
        if (r8.remaining() < r15) goto L14;
        byte[] r16 = new byte[r15];
        r8.get(r16);
        Parcelable.Creator<UnifiedDataPacket> r17 = UnifiedDataPacket.CREATOR;
        Parcel r18 = Parcel.obtain();
        r18.unmarshall(r16, 0, r15);     // Catch: Throwable -> L21
        r18.setDataPosition(0);     // Catch: Throwable -> L21
        UnifiedDataPacket r19 = r17.createFromParcel(r18);     // Catch: Throwable -> L21
        r18.recycle();
        UnifiedDataPacket r20 = r19;
        if (r20 == null) goto L20;
        r13.add(r20);
    L20:
        r14 = r14 + (r15 + 4);
    L21:
        th = move-exception;
        r18.recycle();
        throw th;
    L14:
        StringBuilder r21 = new StringBuilder("Buffer underflow when reading packet data. Declared length: ");
    L25:
        r21.append(r15);
        String r22 = r21.toString();
    L7:
        Log.e("HarShmPacketsReader", r22);
    L24:
        r21 = new StringBuilder("Invalid packet length detected: ");
        goto L25
    L6:
        r22 = "Buffer underflow when reading packet length.";
    L26:
        return r13;
    }
}
