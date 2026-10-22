package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDidAidlInterface extends IInterface {

    public static abstract class Stub extends Binder implements IDidAidlInterface {

        public static class Proxy implements IDidAidlInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f3798a;

            public Proxy(IBinder r8) {
                this.f3798a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f3798a;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDidAidlInterface
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L6
                this.f3798a.transact(3, r8, r10, 0);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public static IDidAidlInterface H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDidAidlInterface) == false) goto L12;
            return (IDidAidlInterface) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            boolean r13 = g();
            r11.writeNoException();
            r11.writeInt(r13 ? 1 : 0);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            String r14 = getUDID();
        L19:
            r11.writeNoException();
            r11.writeString(r14);
            return true;
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r14 = b();
            goto L19
        L9:
            if (r8 != 4) goto L11;
            r10.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r14 = e();
            goto L19
        L11:
            if (r8 != 5) goto L13;
            r10.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r14 = d();
            goto L19
        L13:
            if (r8 != 1598968902) goto L15;
            r11.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return true;
        L15:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String b();

    String d();

    String e();

    boolean g();

    String getUDID();
}
