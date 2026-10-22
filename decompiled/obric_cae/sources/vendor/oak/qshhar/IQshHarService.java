package vendor.oak.qshhar;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IQshHarService extends IInterface {

    public static class Default implements IQshHarService {
        public Default() {
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void L1(IQshHarEventListener r8, int r10, int r11, int r12) {
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void M1(IQshHarEventListener r8, int r10) {
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void Q1(QshHarWifiStandardData r8) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void c1(HarEventData r8) {
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void g1(int[] r8) {
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void m1(QshHarRuntimeParamParcel r8) {
        }

        @Override // vendor.oak.qshhar.IQshHarService
        public final void w(HarMonitorParam r8) {
        }
    }

    public static abstract class Stub extends Binder implements IQshHarService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f12924a = 0;

        public static class Proxy implements IQshHarService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f12925a;

            public Proxy(IBinder r8) {
                this.f12925a = r8;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void L1(IQshHarEventListener r8, int r10, int r11, int r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                IBinder r15 = r8.asBinder();     // Catch: Throwable -> L13
            L7:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L13
                r13.writeInt(r10);     // Catch: Throwable -> L13
                r13.writeInt(r11);     // Catch: Throwable -> L13
                r13.writeInt(r12);     // Catch: Throwable -> L13
                if (this.f12925a.transact(2, r13, r14, 0) == true) goto L10;
                int r16 = Stub.f12924a;     // Catch: Throwable -> L13
            L10:
                r14.readException();     // Catch: Throwable -> L13
                r14.recycle();
                r13.recycle();
                return;
            L6:
                r15 = null;
            L13:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void M1(IQshHarEventListener r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                IBinder r13 = r8.asBinder();     // Catch: Throwable -> L13
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L13
                r11.writeInt(r10);     // Catch: Throwable -> L13
                if (this.f12925a.transact(3, r11, r12, 0) == true) goto L10;
                int r14 = Stub.f12924a;     // Catch: Throwable -> L13
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r13 = null;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void Q1(QshHarWifiStandardData r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L13
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L13
            L8:
                if (this.f12925a.transact(5, r10, r11, 0) == true) goto L10;
                int r12 = Stub.f12924a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f12925a;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void c1(HarEventData r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L13
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L13
            L8:
                if (this.f12925a.transact(7, r10, r11, 0) == true) goto L10;
                int r12 = Stub.f12924a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void g1(int[] r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L9
                r10.writeIntArray(r8);     // Catch: Throwable -> L9
                if (this.f12925a.transact(4, r10, r11, 0) == true) goto L6;
                int r12 = Stub.f12924a;     // Catch: Throwable -> L9
            L6:
                r11.readException();     // Catch: Throwable -> L9
                r11.recycle();
                r10.recycle();
                return;
            L9:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void m1(QshHarRuntimeParamParcel r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L13
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L13
            L8:
                if (this.f12925a.transact(1, r10, r11, 0) == true) goto L10;
                int r12 = Stub.f12924a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // vendor.oak.qshhar.IQshHarService
            public final void w(HarMonitorParam r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("vendor.oak.qshhar.IQshHarService");     // Catch: Throwable -> L13
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L13
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L13
            L8:
                if (this.f12925a.transact(6, r10, r11, 0) == true) goto L10;
                int r12 = Stub.f12924a;     // Catch: Throwable -> L13
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "vendor.oak.qshhar.IQshHarService");
        }

        public static IQshHarService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("vendor.oak.qshhar.IQshHarService");
            if (r10 == null) goto L12;
            if ((r10 instanceof IQshHarService) == false) goto L12;
            return (IQshHarService) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 == 1598968902) goto L29;
            QshHarRuntimeParamParcel r13 = null;
            HarEventData r14 = null;
            HarMonitorParam r15 = null;
            QshHarWifiStandardData r16 = null;
            switch(r8) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L18;
                case 6: goto L14;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            if (r10.readInt() == 0) goto L11;
            r14 = HarEventData.CREATOR.createFromParcel(r10);
        L11:
            c1(r14);
        L12:
            r11.writeNoException();
            return true;
        L14:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            if (r10.readInt() == 0) goto L17;
            r15 = HarMonitorParam.CREATOR.createFromParcel(r10);
        L17:
            w(r15);
            goto L12
        L18:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            if (r10.readInt() == 0) goto L21;
            r16 = QshHarWifiStandardData.CREATOR.createFromParcel(r10);
        L21:
            Q1(r16);
            goto L12
        L22:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            g1(r10.createIntArray());
            goto L12
        L23:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            M1(IQshHarEventListener.Stub.asInterface(r10.readStrongBinder()), r10.readInt());
            goto L12
        L24:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            L1(IQshHarEventListener.Stub.asInterface(r10.readStrongBinder()), r10.readInt(), r10.readInt(), r10.readInt());
            goto L12
        L25:
            r10.enforceInterface("vendor.oak.qshhar.IQshHarService");
            if (r10.readInt() == 0) goto L28;
            r13 = QshHarRuntimeParamParcel.CREATOR.createFromParcel(r10);
        L28:
            m1(r13);
            goto L12
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L29:
            r11.writeString("vendor.oak.qshhar.IQshHarService");
            return true;
        }
    }

    void L1(IQshHarEventListener r8, int r10, int r11, int r12);

    void M1(IQshHarEventListener r8, int r10);

    void Q1(QshHarWifiStandardData r8);

    void c1(HarEventData r8);

    void g1(int[] r8);

    void m1(QshHarRuntimeParamParcel r8);

    void w(HarMonitorParam r8);
}
