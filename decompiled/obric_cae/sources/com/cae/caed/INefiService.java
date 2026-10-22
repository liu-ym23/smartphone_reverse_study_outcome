package com.cae.caed;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.cae.caed.net.IL4NetInfoUpdateCb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface INefiService extends IInterface {

    public static class Default implements INefiService {
        public Default() {
        }

        @Override // com.cae.caed.INefiService
        public final void A2(IEventListener r8) {
        }

        @Override // com.cae.caed.INefiService
        public final void D(INefiListener r8) {
        }

        @Override // com.cae.caed.INefiService
        public final void D1(IEventListener r8) {
        }

        @Override // com.cae.caed.INefiService
        public final boolean E0(IL4NetInfoUpdateCb r8) {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final int F2(int r8, int r10, int r11) {
            return 0;
        }

        @Override // com.cae.caed.INefiService
        public final void R1(int r8, int r10) {
        }

        @Override // com.cae.caed.INefiService
        public final void T1() {
        }

        @Override // com.cae.caed.INefiService
        public final boolean W0() {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final VendorAttrParcel Y0(int r8, int r10, int r11, VendorAttrParcel r12, int[] r13) {
            return null;
        }

        @Override // com.cae.caed.INefiService
        public final void Z(int r8, int r10, int r11, int r12) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.cae.caed.INefiService
        public final void b2(INefiListener r8, int r10, String r11, int r12, int r13, int r14) {
        }

        @Override // com.cae.caed.INefiService
        public final String e2() {
            return null;
        }

        @Override // com.cae.caed.INefiService
        public final int f1() {
            return 0;
        }

        @Override // com.cae.caed.INefiService
        public final boolean l1(int r8, int r10, String r11) {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final void n(int r8) {
        }

        @Override // com.cae.caed.INefiService
        public final boolean n0(int r8, int r10) {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final int p(int r8, int r10, int r11) {
            return 0;
        }

        @Override // com.cae.caed.INefiService
        public final void p2() {
        }

        @Override // com.cae.caed.INefiService
        public final boolean r2(int r8, DbamParamParcel r10) {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final int s(int r8) {
            return 0;
        }

        @Override // com.cae.caed.INefiService
        public final void s0() {
        }

        @Override // com.cae.caed.INefiService
        public final boolean t2(int r8, DbamParamParcel r10) {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final boolean u(int r8, int r10) {
            return false;
        }

        @Override // com.cae.caed.INefiService
        public final int u1(String r8) {
            return 0;
        }

        @Override // com.cae.caed.INefiService
        public final void w0(String r8, String r10) {
        }

        @Override // com.cae.caed.INefiService
        public final int w1(int r8, int r10, String r11) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements INefiService {

        public static class Proxy implements INefiService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4126a;

            public Proxy(IBinder r8) {
                this.f4126a = r8;
            }

            @Override // com.cae.caed.INefiService
            public final void A2(IEventListener r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.f4126a.transact(7, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.INefiService
            public final void D(INefiListener r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.f4126a.transact(5, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.INefiService
            public final void D1(IEventListener r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.f4126a.transact(6, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.INefiService
            public final boolean E0(IL4NetInfoUpdateCb r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L8
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L8
                boolean r12 = false;
                this.f4126a.transact(23, r10, r11, 0);     // Catch: Throwable -> L8
                r11.readException();     // Catch: Throwable -> L8
                if (r11.readInt() == 0) goto L6;
                r12 = true;
            L6:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final int F2(int r8, int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.f4126a.transact(27, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                int r14 = r13.readInt();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void R1(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.f4126a.transact(8, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void T1() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                this.f4126a.transact(25, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final boolean W0() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L8
                boolean r11 = false;
                this.f4126a.transact(19, r8, r10, 0);     // Catch: Throwable -> L8
                r10.readException();     // Catch: Throwable -> L8
                if (r10.readInt() == 0) goto L6;
                r11 = true;
            L6:
                r10.recycle();
                r8.recycle();
                return r11;
            L8:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final VendorAttrParcel Y0(int r8, int r10, int r11, VendorAttrParcel r12, int[] r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r14.writeInt(r8);     // Catch: Throwable -> L6
                r14.writeInt(r10);     // Catch: Throwable -> L6
                r14.writeInt(r11);     // Catch: Throwable -> L6
                r14.writeTypedObject(r12, 0);     // Catch: Throwable -> L6
                r14.writeIntArray(r13);     // Catch: Throwable -> L6
                this.f4126a.transact(17, r14, r15, 0);     // Catch: Throwable -> L6
                r15.readException();     // Catch: Throwable -> L6
                VendorAttrParcel r16 = (VendorAttrParcel) r15.readTypedObject(VendorAttrParcel.CREATOR);     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return r16;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void Z(int r8, int r10, int r11, int r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeInt(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeInt(r12);     // Catch: Throwable -> L6
                this.f4126a.transact(30, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4126a;
            }

            @Override // com.cae.caed.INefiService
            public final void b2(INefiListener r8, int r10, String r11, int r12, int r13, int r14) {
                Parcel r15 = Parcel.obtain();
                Parcel r16 = Parcel.obtain();
                r15.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r15.writeStrongInterface(r8);     // Catch: Throwable -> L6
                r15.writeInt(r10);     // Catch: Throwable -> L6
                r15.writeString(r11);     // Catch: Throwable -> L6
                r15.writeInt(r12);     // Catch: Throwable -> L6
                r15.writeInt(r13);     // Catch: Throwable -> L6
                r15.writeInt(r14);     // Catch: Throwable -> L6
                this.f4126a.transact(4, r15, r16, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.INefiService
            public final String e2() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                this.f4126a.transact(11, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                String r11 = r10.readString();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final int f1() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                this.f4126a.transact(9, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                int r11 = r10.readInt();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final boolean l1(int r8, int r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L8
                r12.writeString(r11);     // Catch: Throwable -> L8
                r12.writeInt(r8);     // Catch: Throwable -> L8
                r12.writeInt(r10);     // Catch: Throwable -> L8
                boolean r14 = false;
                this.f4126a.transact(18, r12, r13, 0);     // Catch: Throwable -> L8
                r13.readException();     // Catch: Throwable -> L8
                if (r13.readInt() == 0) goto L6;
                r14 = true;
            L6:
                r13.recycle();
                r12.recycle();
                return r14;
            L8:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void n(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.f4126a.transact(28, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.cae.caed.INefiService
            public final boolean n0(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L8
                r11.writeInt(r8);     // Catch: Throwable -> L8
                r11.writeInt(r10);     // Catch: Throwable -> L8
                boolean r13 = false;
                this.f4126a.transact(12, r11, r12, 0);     // Catch: Throwable -> L8
                r12.readException();     // Catch: Throwable -> L8
                if (r12.readInt() == 0) goto L6;
                r13 = true;
            L6:
                r12.recycle();
                r11.recycle();
                return r13;
            L8:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final int p(int r8, int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.f4126a.transact(26, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                int r14 = r13.readInt();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void p2() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                this.f4126a.transact(20, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final boolean r2(int r8, DbamParamParcel r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L11
                r11.writeInt(r8);     // Catch: Throwable -> L11
                boolean r13 = false;
                this.f4126a.transact(16, r11, r12, 0);     // Catch: Throwable -> L11
                r12.readException();     // Catch: Throwable -> L11
                if (r12.readInt() == 0) goto L7;
                r13 = true;
            L7:
                if (r12.readInt() == 0) goto L9;
                r10.t(r12);     // Catch: Throwable -> L11
            L9:
                r12.recycle();
                r11.recycle();
                return r13;
            L11:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final int s(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.f4126a.transact(14, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int r12 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void s0() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                this.f4126a.transact(31, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final boolean t2(int r8, DbamParamParcel r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L8
                r11.writeInt(r8);     // Catch: Throwable -> L8
                boolean r13 = false;
                r11.writeTypedObject(r10, 0);     // Catch: Throwable -> L8
                this.f4126a.transact(15, r11, r12, 0);     // Catch: Throwable -> L8
                r12.readException();     // Catch: Throwable -> L8
                if (r12.readInt() == 0) goto L6;
                r13 = true;
            L6:
                r12.recycle();
                r11.recycle();
                return r13;
            L8:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final boolean u(int r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L8
                r11.writeInt(r8);     // Catch: Throwable -> L8
                r11.writeInt(r10);     // Catch: Throwable -> L8
                boolean r13 = false;
                this.f4126a.transact(13, r11, r12, 0);     // Catch: Throwable -> L8
                r12.readException();     // Catch: Throwable -> L8
                if (r12.readInt() == 0) goto L6;
                r13 = true;
            L6:
                r12.recycle();
                r11.recycle();
                return r13;
            L8:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final int u1(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r10.writeString(r8);     // Catch: Throwable -> L6
                this.f4126a.transact(24, r10, r11, 0);     // Catch: Throwable -> L6
                r11.readException();     // Catch: Throwable -> L6
                int r12 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final void w0(String r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r11.writeString(r8);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.f4126a.transact(10, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.cae.caed.INefiService
            public final int w1(int r8, int r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.cae.caed.INefiService");     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                this.f4126a.transact(29, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                int r14 = r13.readInt();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.cae.caed.INefiService");
        }

        public static INefiService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.INefiService");
            if (r10 == null) goto L12;
            if ((r10 instanceof INefiService) == false) goto L12;
            return (INefiService) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface("com.cae.caed.INefiService");
        L8:
            if (r10 != 1598968902) goto L11;
            r12.writeString("com.cae.caed.INefiService");
            return true;
        L11:
            switch(r10) {
                case 1: goto L47;
                case 2: goto L45;
                case 3: goto L44;
                case 4: goto L43;
                case 5: goto L42;
                case 6: goto L41;
                case 7: goto L40;
                case 8: goto L39;
                case 9: goto L37;
                case 10: goto L36;
                case 11: goto L35;
                case 12: goto L34;
                case 13: goto L33;
                case 14: goto L32;
                case 15: goto L31;
                case 16: goto L30;
                case 17: goto L29;
                case 18: goto L28;
                case 19: goto L27;
                case 20: goto L26;
                case 21: goto L25;
                case 22: goto L24;
                case 23: goto L23;
                case 24: goto L22;
                case 25: goto L21;
                case 26: goto L20;
                case 27: goto L19;
                case 28: goto L18;
                case 29: goto L17;
                case 30: goto L16;
                case 31: goto L15;
                case 32: goto L14;
                default: goto L13;
            };
        L14:
            float r14 = e1();
            r12.writeNoException();
            r12.writeFloat(r14);
        L49:
            return true;
        L15:
            s0();
        L48:
            r12.writeNoException();
            goto L49
        L16:
            Z(r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt());
            goto L48
        L17:
            String r15 = r11.readString();
            int r16 = w1(r11.readInt(), r11.readInt(), r15);
        L38:
            r12.writeNoException();
            r12.writeInt(r16);
            goto L49
        L18:
            n(r11.readInt());
            goto L48
        L19:
            r16 = F2(r11.readInt(), r11.readInt(), r11.readInt());
            goto L38
        L20:
            r16 = p(r11.readInt(), r11.readInt(), r11.readInt());
            goto L38
        L21:
            T1();
            goto L48
        L22:
            r16 = u1(r11.readString());
            goto L38
        L23:
            r16 = E0(IL4NetInfoUpdateCb.Stub.asInterface(r11.readStrongBinder()));
            goto L38
        L24:
            IPowerPredictionCallback.Stub.H2(r11.readStrongBinder());
            q0();
            goto L48
        L25:
            IPowerPredictionCallback.Stub.H2(r11.readStrongBinder());
            C0();
            goto L48
        L26:
            p2();
            goto L48
        L27:
            r16 = W0();
            goto L38
        L28:
            String r17 = r11.readString();
            r16 = l1(r11.readInt(), r11.readInt(), r17);
            goto L38
        L29:
            VendorAttrParcel r18 = Y0(r11.readInt(), r11.readInt(), r11.readInt(), (VendorAttrParcel) r11.readTypedObject(VendorAttrParcel.CREATOR), r11.createIntArray());
            r12.writeNoException();
            r12.writeTypedObject(r18, 1);
            goto L49
        L30:
            int r19 = r11.readInt();
            DbamParamParcel r110 = new DbamParamParcel();
            boolean r20 = r2(r19, r110);
            r12.writeNoException();
            r12.writeInt(r20 ? 1 : 0);
            r12.writeTypedObject(r110, 1);
            goto L49
        L31:
            r16 = t2(r11.readInt(), (DbamParamParcel) r11.readTypedObject(DbamParamParcel.CREATOR));
            goto L38
        L32:
            r16 = s(r11.readInt());
            goto L38
        L33:
            r16 = u(r11.readInt(), r11.readInt());
            goto L38
        L34:
            r16 = n0(r11.readInt(), r11.readInt());
            goto L38
        L35:
            String r21 = e2();
            r12.writeNoException();
            r12.writeString(r21);
            goto L49
        L36:
            w0(r11.readString(), r11.readString());
            goto L48
        L37:
            r16 = f1();
            goto L38
        L39:
            R1(r11.readInt(), r11.readInt());
            goto L48
        L40:
            A2(IEventListener.Stub.asInterface(r11.readStrongBinder()));
            goto L48
        L41:
            D1(IEventListener.Stub.asInterface(r11.readStrongBinder()));
            goto L48
        L42:
            D(INefiListener.Stub.asInterface(r11.readStrongBinder()));
            goto L48
        L43:
            b2(INefiListener.Stub.asInterface(r11.readStrongBinder()), r11.readInt(), r11.readString(), r11.readInt(), r11.readInt(), r11.readInt());
            goto L48
        L44:
            ArrayList r111 = new ArrayList();
            B1();
        L46:
            r12.writeNoException();
            a.a(r12, r111);
            goto L49
        L45:
            r111 = new ArrayList();
            e0();
            goto L46
        L47:
            IIpDetcCallback.Stub.H2(r11.readStrongBinder());
            r11.readString();
            r11.readInt();
            F();
            goto L48
        L13:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    public static class a {
        public static void a(Parcel r8, ArrayList r10) {
            int r11 = r10.size();
            r8.writeInt(r11);
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r8.writeTypedObject((Parcelable) r10.get(r12), 1);
            r12 = r12 + 1;
            goto L3
        }
    }

    void A2(IEventListener r8);

    void B1();

    void C0();

    void D(INefiListener r8);

    void D1(IEventListener r8);

    boolean E0(IL4NetInfoUpdateCb r8);

    void F();

    int F2(int r8, int r10, int r11);

    void R1(int r8, int r10);

    void T1();

    boolean W0();

    VendorAttrParcel Y0(int r8, int r10, int r11, VendorAttrParcel r12, int[] r13);

    void Z(int r8, int r10, int r11, int r12);

    void b2(INefiListener r8, int r10, String r11, int r12, int r13, int r14);

    void e0();

    float e1();

    String e2();

    int f1();

    boolean l1(int r8, int r10, String r11);

    void n(int r8);

    boolean n0(int r8, int r10);

    int p(int r8, int r10, int r11);

    void p2();

    void q0();

    boolean r2(int r8, DbamParamParcel r10);

    int s(int r8);

    void s0();

    boolean t2(int r8, DbamParamParcel r10);

    boolean u(int r8, int r10);

    int u1(String r8);

    void w0(String r8, String r10);

    int w1(int r8, int r10, String r11);
}
