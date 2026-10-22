package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import com.obric.capabilitykit.common.UiType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class HarShmPacketsReader {
    public ByteBuffer a;
    public SharedMemory b;

    public HarShmPacketsReader() {
    }

    public static int getSingleBufferSize() {
        return UiType.FLAG_ALARM_CLOCK_CARD;
    }

    public void closeShm() {
        ByteBuffer r0 = this.a;
        if (r0 == null) goto L5;
        SharedMemory.unmap(r0);
        this.a = null;
    L5:
        SharedMemory r1 = this.b;
        if (r1 == null) goto L9;
        r1.close();
        this.b = null;
        return;
    }

    public ByteBuffer getHarShmMappedBuffer() {
        return this.a;
    }

    public boolean openShm(ParcelFileDescriptor r4) {
        this.b = SharedMemory.fromFileDescriptor(r4);     // Catch: Throwable -> L6 ErrnoException -> L8
        r4.close();     // Catch: Throwable -> L6 ErrnoException -> L8
        SharedMemory r5 = this.b;     // Catch: Throwable -> L6 ErrnoException -> L8
        this.a = r5.map(OsConstants.PROT_READ, 0, r5.getSize());     // Catch: Throwable -> L6 ErrnoException -> L8
        return true;
    L6:
        e = move-exception;
        this.a = null;
        e.printStackTrace();
        return false;
    }

    public List<UnifiedDataPacket> processDataBatch(ByteBuffer r9, int r10, int r11) {
        int r12 = r10 * UiType.FLAG_ALARM_CLOCK_CARD;
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L3:
        if (r3 >= r11) goto L24;
        r9.position(r12 + r3);
        if (r9.remaining() < 4) goto L24;
        int r4 = r9.getInt();
        if (r4 <= 0) goto L24;
        if (r4 > 65536) goto L24;
        if (r9.remaining() < r4) goto L24;
        byte[] r5 = new byte[r4];
        r9.get(r5);
        Parcelable.Creator r6 = UnifiedDataPacket.CREATOR;
        Parcel r7 = Parcel.obtain();
        r7.unmarshall(r5, 0, r4);     // Catch: Throwable -> L20
        r7.setDataPosition(0);     // Catch: Throwable -> L20
        UnifiedDataPacket r8 = (Parcelable) r6.createFromParcel(r7);     // Catch: Throwable -> L20
        r7.recycle();
        UnifiedDataPacket r13 = r8;
        if (r13 == null) goto L19;
        r1.add(r13);
    L19:
        r3 = r3 + (r4 + 4);
    L20:
        th = move-exception;
        r7.recycle();
        throw th;
    L24:
        return r1;
    }
}
