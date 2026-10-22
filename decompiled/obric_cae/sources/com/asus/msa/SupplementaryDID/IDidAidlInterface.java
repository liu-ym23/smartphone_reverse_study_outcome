package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IDidAidlInterface extends IInterface {

    public static class Default implements IDidAidlInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
        public final String b() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDidAidlInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f3679a = 0;

        public static class Proxy implements IDidAidlInterface {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public final String b() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");     // Catch: Throwable -> L5
                throw null;     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
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
            String r14 = a();
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
            r14 = c();
            goto L19
        L11:
            if (r8 != 5) goto L13;
            r10.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            r14 = i();
            goto L19
        L13:
            if (r8 != 1598968902) goto L15;
            r11.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return true;
        L15:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String a();

    String b();

    String c();

    boolean g();

    String i();
}
