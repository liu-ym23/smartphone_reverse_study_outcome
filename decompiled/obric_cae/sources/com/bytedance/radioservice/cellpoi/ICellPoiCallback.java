package com.bytedance.radioservice.cellpoi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICellPoiCallback extends IInterface {

    public static class Default implements ICellPoiCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICellPoiCallback {
        static final int TRANSACTION_onCellPoiStatusChange = 1;

        public static class Proxy implements ICellPoiCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4035a;

            public Proxy(IBinder r8) {
                this.f4035a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4035a;
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.radioservice.cellpoi.ICellPoiCallback");
        }

        public static ICellPoiCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.bytedance.radioservice.cellpoi.ICellPoiCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof ICellPoiCallback) == false) goto L12;
            return (ICellPoiCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) {
            if (r12 < 1) goto L8;
            if (r12 > 16777215) goto L8;
            r13.enforceInterface("com.bytedance.radioservice.cellpoi.ICellPoiCallback");
        L8:
            if (r12 != 1598968902) goto L11;
            r14.writeString("com.bytedance.radioservice.cellpoi.ICellPoiCallback");
            return true;
        L11:
            if (r12 != 1) goto L13;
            int r8 = r13.readInt();
            int r10 = r13.readInt();
            int r11 = r13.readInt();
            int r16 = r13.readInt();
            long r17 = r13.readLong();
            int r18 = r13.readInt();
            String r19 = r13.readString();
            r13.enforceNoDataAvail();
            onCellPoiStatusChange(r8, r10, r11, r16, r17, r18, r19);
            return true;
        L13:
            return super.onTransact(r12, r13, r14, r15);
        }
    }

    void onCellPoiStatusChange(int r8, int r10, int r11, int r12, long r13, int r14, String r15);
}
