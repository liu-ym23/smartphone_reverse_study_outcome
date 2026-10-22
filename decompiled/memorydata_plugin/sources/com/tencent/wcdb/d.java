package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f15823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f15824b;

    public d(IBinder r3) {
        this.f15823a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        this.f15824b = null;
    }

    @Override // com.tencent.wcdb.j
    public int a(k r5) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r5, k.class, "com.obric.memorydata.plugin");
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L10
        r0.writeStrongInterface(r6);     // Catch: Throwable -> L10
        boolean r7 = this.f15823a.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
        h.a(r1);     // Catch: Throwable -> L10
        if (r7 == true) goto L6;
        int r4 = -1;
    L8:
        r0.recycle();
        r1.recycle();
        return r4;
    L6:
        int r8 = r1.readInt();     // Catch: Throwable -> L10
        this.f15824b = r1.readBundle(getClass().getClassLoader());     // Catch: Throwable -> L10
        r4 = r8;
    L10:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.j
    public Bundle a(Bundle r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L6
        r0.writeBundle(r5);     // Catch: Throwable -> L6
        this.f15823a.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
        h.a(r1);     // Catch: Throwable -> L6
        Bundle r4 = r1.readBundle(getClass().getClassLoader());     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return r4;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.j
    public CursorWindow a(int r4) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L8
        r0.writeInt(r4);     // Catch: Throwable -> L8
        this.f15823a.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
        h.a(r1);     // Catch: Throwable -> L8
        CursorWindow r3 = null;
        if (r1.readInt() != 1) goto L6;
        r3 = CursorWindow.newFromParcel(r1);     // Catch: Throwable -> L8
    L6:
        r0.recycle();
        r1.recycle();
        return r3;
    L8:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.j
    public void a() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L6
        this.f15823a.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
        h.a(r1);     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f15823a;
    }

    @Override // com.tencent.wcdb.j
    public void b() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L6
        this.f15823a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
        h.a(r1);     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.j
    public void b(int r4) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L6
        r0.writeInt(r4);     // Catch: Throwable -> L6
        this.f15823a.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
        h.a(r1);     // Catch: Throwable -> L6
        r0.recycle();
        r1.recycle();
        return;
    L6:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    }

    @Override // com.tencent.wcdb.j
    public Bundle c() {
        if (this.f15824b != null) goto L11;
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("android.content.IBulkCursor");     // Catch: Throwable -> L7
        this.f15823a.transact(5, r0, r1, 0);     // Catch: Throwable -> L7
        h.a(r1);     // Catch: Throwable -> L7
        this.f15824b = r1.readBundle(getClass().getClassLoader());     // Catch: Throwable -> L7
        r0.recycle();
        r1.recycle();
    L7:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    L11:
        return this.f15824b;
    }
}
