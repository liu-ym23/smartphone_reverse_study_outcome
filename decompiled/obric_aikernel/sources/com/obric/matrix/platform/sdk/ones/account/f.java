package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.f$a$a, reason: collision with other inner class name */
        private static class C0125a implements f {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static f f5838g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f5839c;

            C0125a(IBinder r10) {
                this.f5839c = r10;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void H1(String r10, e r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r12.writeString(r10);     // Catch: Throwable -> L17
                if (r11 == null) goto L6;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L17
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L17
                if (this.f5839c.transact(12, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().H1(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = null;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void J1(String r10, String r11, int r12, e r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r14.writeString(r10);     // Catch: Throwable -> L17
                r14.writeString(r11);     // Catch: Throwable -> L17
                r14.writeInt(r12);     // Catch: Throwable -> L17
                if (r13 == null) goto L6;
                IBinder r16 = r13.asBinder();     // Catch: Throwable -> L17
            L7:
                r14.writeStrongBinder(r16);     // Catch: Throwable -> L17
                if (this.f5839c.transact(9, r14, r15, 0) == false) goto L10;
            L14:
                r15.readException();     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().J1(r10, r11, r12, r13);     // Catch: Throwable -> L17
                r15.recycle();
                r14.recycle();
                return;
            L6:
                r16 = null;
            L17:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void N1(String r10, String r11, e r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f5839c.transact(10, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().N1(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void S1(String r10, String r11, e r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f5839c.transact(8, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().S1(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void W1(String r10, String r11, e r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f5839c.transact(16, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().W1(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void X0(String r10, String r11, e r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f5839c.transact(13, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().X0(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5839c;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void c2(String r10, String r11, e r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L17
                if (this.f5839c.transact(15, r13, r14, 0) == false) goto L10;
            L14:
                r14.readException();     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().c2(r10, r11, r12);     // Catch: Throwable -> L17
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L17:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.f
            public void q1(String r10, e r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L17
                r12.writeString(r10);     // Catch: Throwable -> L17
                if (r11 == null) goto L6;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L17
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L17
                if (this.f5839c.transact(11, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().q1(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = null;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public static f U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
            if (r11 == null) goto L12;
            if ((r11 instanceof f) == false) goto L12;
            return (f) r11;
        L12:
            return new C0125a(r10);
        }

        public static f k1() {
            return C0125a.f5838g;
        }
    }

    void H1(String r10, e r11);

    void J1(String r10, String r11, int r12, e r13);

    void N1(String r10, String r11, e r12);

    void S1(String r10, String r11, e r12);

    void W1(String r10, String r11, e r12);

    void X0(String r10, String r11, e r12);

    void c2(String r10, String r11, e r12);

    void q1(String r10, e r11);
}
