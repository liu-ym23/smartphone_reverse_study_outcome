package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IDataService extends IInterface {

    public static class Default implements IDataService {
        public Default() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public final void V0(IDeviceInfoCallback r8) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public final String getDeviceId() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public final void onEvent(String r8, String r10) {
        }
    }

    public static abstract class Stub extends Binder implements IDataService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f6119a = 0;

        public static class Proxy implements IDataService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f6120a;

            public Proxy(IBinder r8) {
                this.f6120a = r8;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public final void V0(IDeviceInfoCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L13
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L13
                if (this.f6120a.transact(3, r10, r11, 0) == true) goto L10;
                int r13 = Stub.f6119a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r12 = null;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6120a;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public final String getDeviceId() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L9
                if (this.f6120a.transact(1, r8, r10, 0) == true) goto L6;
                int r11 = Stub.f6119a;     // Catch: Throwable -> L9
            L6:
                r10.readException();     // Catch: Throwable -> L9
                String r12 = r10.readString();     // Catch: Throwable -> L9
                r10.recycle();
                r8.recycle();
                return r12;
            L9:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public final void onEvent(String r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L9
                r11.writeString(r8);     // Catch: Throwable -> L9
                r11.writeString(r10);     // Catch: Throwable -> L9
                if (this.f6120a.transact(5, r11, r12, 0) == true) goto L6;
                int r13 = Stub.f6119a;     // Catch: Throwable -> L9
            L6:
                r12.readException();     // Catch: Throwable -> L9
                r12.recycle();
                r11.recycle();
                return;
            L9:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            String r13 = getDeviceId();
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            String r14 = j();
            r11.writeNoException();
            r11.writeString(r14);
            return true;
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            V0(IDeviceInfoCallback.Stub.H2(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L9:
            if (r8 != 4) goto L11;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            IDeviceInfoCallback.Stub.H2(r10.readStrongBinder());
            G();
            r11.writeNoException();
            return true;
        L11:
            if (r8 != 5) goto L13;
            r10.enforceInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            onEvent(r10.readString(), r10.readString());
            r11.writeNoException();
            return true;
        L13:
            if (r8 != 1598968902) goto L15;
            r11.writeString("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            return true;
        L15:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void G();

    void V0(IDeviceInfoCallback r8);

    String getDeviceId();

    String j();

    void onEvent(String r8, String r10);
}
