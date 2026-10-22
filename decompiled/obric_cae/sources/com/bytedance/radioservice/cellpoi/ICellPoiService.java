package com.bytedance.radioservice.cellpoi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICellPoiService extends IInterface {

    public static class Default implements ICellPoiService {
        public Default() {
        }

        @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
        public final void I(int r8) {
        }

        @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
        public final int T(ICellPoiCallback r8) {
            return 0;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
        public final void c(int r8) {
        }

        @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
        public final int i1(IHighConfidenceCellPoiCallback r8) {
            return 0;
        }

        @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
        public final String o1(int r8, int r10, int r11, long r12) {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICellPoiService {

        public static class Proxy implements ICellPoiService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4036a;

            public Proxy(IBinder r8) {
                this.f4036a = r8;
            }

            @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
            public final void I(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                r10.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.f4036a.transact(5, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
            public final int T(ICellPoiCallback r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.f4036a.transact(2, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4036a;
            }

            @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
            public final void c(int r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                r10.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r10.writeInt(r8);     // Catch: Throwable -> L6
                this.f4036a.transact(3, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
            public final int i1(IHighConfidenceCellPoiCallback r8) {
                Parcel r10 = Parcel.obtain(asBinder());
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r10.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.f4036a.transact(4, r10, r11, 0);     // Catch: Throwable -> L6
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

            @Override // com.bytedance.radioservice.cellpoi.ICellPoiService
            public final String o1(int r8, int r10, int r11, long r12) {
                Parcel r13 = Parcel.obtain(asBinder());
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.bytedance.radioservice.cellpoi.ICellPoiService");     // Catch: Throwable -> L6
                r13.writeInt(r8);     // Catch: Throwable -> L6
                r13.writeInt(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeLong(r12);     // Catch: Throwable -> L6
                this.f4036a.transact(1, r13, r14, 0);     // Catch: Throwable -> L6
                r14.readException();     // Catch: Throwable -> L6
                String r15 = r14.readString();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return r15;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.radioservice.cellpoi.ICellPoiService");
        }

        public static ICellPoiService H2(IBinder r8) {
            IInterface r10 = r8.queryLocalInterface("com.bytedance.radioservice.cellpoi.ICellPoiService");
            if (r10 == null) goto L9;
            if ((r10 instanceof ICellPoiService) == false) goto L9;
            return (ICellPoiService) r10;
        L9:
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
            r11.enforceInterface("com.bytedance.radioservice.cellpoi.ICellPoiService");
        L8:
            if (r10 != 1598968902) goto L11;
            r12.writeString("com.bytedance.radioservice.cellpoi.ICellPoiService");
            return true;
        L11:
            if (r10 != 1) goto L13;
            int r8 = r11.readInt();
            int r14 = r11.readInt();
            int r15 = r11.readInt();
            long r16 = r11.readLong();
            r11.enforceNoDataAvail();
            String r17 = o1(r8, r14, r15, r16);
            r12.writeNoException();
            r12.writeString(r17);
        L28:
            return true;
        L13:
            if (r10 != 2) goto L15;
            ICellPoiCallback r18 = ICellPoiCallback.Stub.asInterface(r11.readStrongBinder());
            r11.enforceNoDataAvail();
            int r19 = T(r18);
        L26:
            r12.writeNoException();
            r12.writeInt(r19);
            goto L28
        L15:
            if (r10 != 3) goto L17;
            int r20 = r11.readInt();
            r11.enforceNoDataAvail();
            c(r20);
            goto L28
        L17:
            if (r10 != 4) goto L19;
            IHighConfidenceCellPoiCallback r21 = IHighConfidenceCellPoiCallback.Stub.asInterface(r11.readStrongBinder());
            r11.enforceNoDataAvail();
            r19 = i1(r21);
            goto L26
        L19:
            if (r10 != 5) goto L21;
            int r22 = r11.readInt();
            r11.enforceNoDataAvail();
            I(r22);
            goto L28
        L21:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void I(int r8);

    int T(ICellPoiCallback r8);

    void c(int r8);

    int i1(IHighConfidenceCellPoiCallback r8);

    String o1(int r8, int r10, int r11, long r12);
}
