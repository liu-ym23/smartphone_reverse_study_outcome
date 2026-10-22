package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.OsConstants;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f7009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedMemory f7010b;

    public b() {
    }

    public static int a() {
        return 65536;
    }

    public List<UnifiedDataPacket> a(ByteBuffer r9, int r10, int r11) {
        int r12 = r10 * 65536;
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L3:
        if (r3 >= r11) goto L26;
        r9.position(r12 + r3);
        if (r9.remaining() < 4) goto L6;
        int r4 = r9.getInt();
        if (r4 <= 0) goto L24;
        if (r4 > 65536) goto L24;
        if (r9.remaining() < r4) goto L14;
        byte[] r5 = new byte[r4];
        r9.get(r5);
        Parcelable.Creator<UnifiedDataPacket> r6 = UnifiedDataPacket.CREATOR;
        Parcel r7 = Parcel.obtain();
        r7.unmarshall(r5, 0, r4);     // Catch: Throwable -> L21
        r7.setDataPosition(0);     // Catch: Throwable -> L21
        Parcelable r8 = (Parcelable) ZeusTransformUtils.preCheckCast(r6.createFromParcel(r7), Parcelable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r7.recycle();
        UnifiedDataPacket r13 = (UnifiedDataPacket) ZeusTransformUtils.preCheckCast(r8, UnifiedDataPacket.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L20;
        r1.add(r13);
    L20:
        r3 = r3 + (r4 + 4);
    L21:
        th = move-exception;
        r7.recycle();
        throw th;
    L14:
        StringBuilder r14 = new StringBuilder("Buffer underflow when reading packet data. Declared length: ");
    L25:
        String r15 = r14.append(r4).toString();
    L7:
        Log.e("HarShmPacketsReader", r15);
    L24:
        r14 = new StringBuilder("Invalid packet length detected: ");
        goto L25
    L6:
        r15 = "Buffer underflow when reading packet length.";
    L26:
        return r1;
    }

    public boolean a(ParcelFileDescriptor r4) {
        this.f7010b = SharedMemory.fromFileDescriptor(r4);     // Catch: Throwable -> L6
        r4.close();     // Catch: Throwable -> L6
        SharedMemory r5 = this.f7010b;     // Catch: Throwable -> L6
        this.f7009a = r5.map(OsConstants.PROT_READ, 0, r5.getSize());     // Catch: Throwable -> L6
        return true;
    L6:
        e = move-exception;
        this.f7009a = null;
        e.printStackTrace();
        return false;
    }

    public void b() {
        ByteBuffer r0 = this.f7009a;
        if (r0 == null) goto L5;
        SharedMemory.unmap(r0);
        this.f7009a = null;
    L5:
        SharedMemory r1 = this.f7010b;
        if (r1 == null) goto L9;
        r1.close();
        this.f7010b = null;
        return;
    }

    public ByteBuffer c() {
        return this.f7009a;
    }
}
