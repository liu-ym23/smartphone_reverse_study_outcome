package com.bytedance.ai.process;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f2425a;

    public e(IBinder r5) {
        this.f2425a = r5;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2425a;
    }

    public final void d(Binder r5, b r10) {
        Parcel r11 = Parcel.obtain();
        Parcel r12 = Parcel.obtain();
        r11.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L10
        r11.writeStrongBinder(r5);     // Catch: Throwable -> L10
        if (r10 != null) goto L7;
        r10 = null;
    L7:
        r11.writeStrongBinder(r10);     // Catch: Throwable -> L10
        if (this.f2425a.transact(6, r11, r12, 0) == true) goto L12;
        int r13 = f.f2426a;     // Catch: Throwable -> L10
    L12:
        r12.readException();     // Catch: Throwable -> L10
        r12.recycle();
        r11.recycle();
        return;
    L10:
        th = move-exception;
        r12.recycle();
        r11.recycle();
        throw th;
    }

    public final void e(Binder r5, String r10, String r11) {
        Parcel r12 = Parcel.obtain();
        Parcel r13 = Parcel.obtain();
        r12.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L6
        r12.writeStrongBinder(r5);     // Catch: Throwable -> L6
        r12.writeString(r10);     // Catch: Throwable -> L6
        r12.writeString(r11);     // Catch: Throwable -> L6
        if (this.f2425a.transact(5, r12, r13, 0) == true) goto L8;
        int r14 = f.f2426a;     // Catch: Throwable -> L6
    L8:
        r13.readException();     // Catch: Throwable -> L6
        r13.recycle();
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r13.recycle();
        r12.recycle();
        throw th;
    }

    public final void f(Binder r5, String r10, String r11, long r12, Map r13, com.bytedance.ai.process.resource.c r14) {
        Parcel r15 = Parcel.obtain();
        Parcel r16 = Parcel.obtain();
        r15.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L6
        r15.writeStrongBinder(r5);     // Catch: Throwable -> L6
        r15.writeString(r10);     // Catch: Throwable -> L6
        r15.writeString(r11);     // Catch: Throwable -> L6
        r15.writeLong(r12);     // Catch: Throwable -> L6
        r15.writeMap(r13);     // Catch: Throwable -> L6
        r15.writeStrongBinder(r14);     // Catch: Throwable -> L6
        if (this.f2425a.transact(1, r15, r16, 0) == true) goto L8;
        int r17 = f.f2426a;     // Catch: Throwable -> L6
    L8:
        r16.readException();     // Catch: Throwable -> L6
        r16.recycle();
        r15.recycle();
        return;
    L6:
        th = move-exception;
        r16.recycle();
        r15.recycle();
        throw th;
    }

    public final void g(b r5) {
        Parcel r10 = Parcel.obtain();
        Parcel r11 = Parcel.obtain();
        r10.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L6
        r10.writeStrongBinder(r5);     // Catch: Throwable -> L6
        if (this.f2425a.transact(7, r10, r11, 0) == true) goto L8;
        int r12 = f.f2426a;     // Catch: Throwable -> L6
    L8:
        r11.readException();     // Catch: Throwable -> L6
        r11.recycle();
        r10.recycle();
        return;
    L6:
        th = move-exception;
        r11.recycle();
        r10.recycle();
        throw th;
    }

    public final void h(String r5, String r10, com.bytedance.ai.process.resource.a r11) {
        Parcel r12 = Parcel.obtain();
        Parcel r13 = Parcel.obtain();
        r12.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L10
        r12.writeString(r5);     // Catch: Throwable -> L10
        r12.writeString(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L7;
        r11 = null;
    L7:
        r12.writeStrongBinder(r11);     // Catch: Throwable -> L10
        if (this.f2425a.transact(4, r12, r13, 0) == true) goto L12;
        int r14 = f.f2426a;     // Catch: Throwable -> L10
    L12:
        r13.readException();     // Catch: Throwable -> L10
        r13.recycle();
        r12.recycle();
        return;
    L10:
        th = move-exception;
        r13.recycle();
        r12.recycle();
        throw th;
    }

    public final void i(Binder r5, String r10, String r11, long r12, Map r13, com.bytedance.ai.process.resource.c r14) {
        Parcel r15 = Parcel.obtain();
        Parcel r16 = Parcel.obtain();
        r15.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L6
        r15.writeStrongBinder(r5);     // Catch: Throwable -> L6
        r15.writeString(r10);     // Catch: Throwable -> L6
        r15.writeString(r11);     // Catch: Throwable -> L6
        r15.writeLong(r12);     // Catch: Throwable -> L6
        r15.writeMap(r13);     // Catch: Throwable -> L6
        r15.writeStrongBinder(r14);     // Catch: Throwable -> L6
        if (this.f2425a.transact(2, r15, r16, 0) == true) goto L8;
        int r17 = f.f2426a;     // Catch: Throwable -> L6
    L8:
        r16.readException();     // Catch: Throwable -> L6
        r16.recycle();
        r15.recycle();
        return;
    L6:
        th = move-exception;
        r16.recycle();
        r15.recycle();
        throw th;
    }

    public final void j(Binder r5, String r10, String r11) {
        Parcel r12 = Parcel.obtain();
        Parcel r13 = Parcel.obtain();
        r12.writeInterfaceToken("com.bytedance.ai.process.IAISDKRemoteBinder");     // Catch: Throwable -> L6
        r12.writeStrongBinder(r5);     // Catch: Throwable -> L6
        r12.writeString(r10);     // Catch: Throwable -> L6
        r12.writeString(r11);     // Catch: Throwable -> L6
        if (this.f2425a.transact(3, r12, r13, 0) == true) goto L8;
        int r14 = f.f2426a;     // Catch: Throwable -> L6
    L8:
        r13.readException();     // Catch: Throwable -> L6
        r13.recycle();
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r13.recycle();
        r12.recycle();
        throw th;
    }
}
