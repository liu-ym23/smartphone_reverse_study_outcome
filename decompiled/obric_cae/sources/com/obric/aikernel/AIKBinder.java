package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface AIKBinder extends IInterface {

    public static class Default implements AIKBinder {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aikernel.AIKBinder
        public final void h2(Bundle r8, AIKListener r10) {
        }

        @Override // com.obric.aikernel.AIKBinder
        public final void o0(Bundle r8, AIKListener r10) {
        }

        @Override // com.obric.aikernel.AIKBinder
        public final Bundle s1(Bundle r8) {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements AIKBinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5212a = 0;

        public static class Proxy implements AIKBinder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f5213a;

            public Proxy(IBinder r8) {
                this.f5213a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5213a;
            }

            @Override // com.obric.aikernel.AIKBinder
            public final void h2(Bundle r8, AIKListener r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L7:
                if (r10 == null) goto L9;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L16
            L10:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L16
                if (this.f5213a.transact(3, r11, r12, 0) == true) goto L13;
                int r14 = Stub.f5212a;     // Catch: Throwable -> L16
            L13:
                r12.readException();     // Catch: Throwable -> L16
                r12.recycle();
                r11.recycle();
                return;
            L9:
                r13 = null;
                goto L10
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.AIKBinder
            public final void o0(Bundle r8, AIKListener r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L7:
                if (r10 == null) goto L9;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L16
            L10:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L16
                if (this.f5213a.transact(2, r11, r12, 0) == true) goto L13;
                int r14 = Stub.f5212a;     // Catch: Throwable -> L16
            L13:
                r12.readException();     // Catch: Throwable -> L16
                r12.recycle();
                r11.recycle();
                return;
            L9:
                r13 = null;
                goto L10
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.AIKBinder
            public final Bundle s1(Bundle r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.aikernel.AIKBinder");     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L17
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f5213a.transact(1, r10, r11, 0) == true) goto L10;
                int r12 = Stub.f5212a;     // Catch: Throwable -> L17
            L10:
                r11.readException();     // Catch: Throwable -> L17
                if (r11.readInt() == 0) goto L14;
                Bundle r13 = (Bundle) Bundle.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L17
            L15:
                r11.recycle();
                r10.recycle();
                return r13;
            L14:
                r13 = null;
                goto L15
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.aikernel.AIKBinder");
        }

        public static AIKBinder H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.obric.aikernel.AIKBinder");
            if (r10 == null) goto L12;
            if ((r10 instanceof AIKBinder) == false) goto L12;
            return (AIKBinder) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            Bundle r13 = null;
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r10.readInt() == 0) goto L27;
            r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L27:
            Bundle r14 = s1(r13);
            r11.writeNoException();
            if (r14 == null) goto L30;
            r11.writeInt(1);
            r14.writeToParcel(r11, 1);
        L31:
            return true;
        L30:
            r11.writeInt(0);
            goto L31
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r10.readInt() == 0) goto L23;
            r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L23:
            o0(r13, AIKListener.Stub.H2(r10.readStrongBinder()));
        L18:
            r11.writeNoException();
            return true;
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.obric.aikernel.AIKBinder");
            if (r10.readInt() == 0) goto L17;
            r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L17:
            h2(r13, AIKListener.Stub.H2(r10.readStrongBinder()));
            goto L18
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.obric.aikernel.AIKBinder");
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void h2(Bundle r8, AIKListener r10);

    void o0(Bundle r8, AIKListener r10);

    Bundle s1(Bundle r8);
}
