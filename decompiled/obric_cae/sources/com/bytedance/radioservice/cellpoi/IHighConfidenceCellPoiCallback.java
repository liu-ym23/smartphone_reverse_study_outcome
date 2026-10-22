package com.bytedance.radioservice.cellpoi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IHighConfidenceCellPoiCallback extends IInterface {

    public static class Default implements IHighConfidenceCellPoiCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IHighConfidenceCellPoiCallback {
        static final int TRANSACTION_onCellPoiStatusChange = 1;

        public static class Proxy implements IHighConfidenceCellPoiCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4037a;

            public Proxy(IBinder r8) {
                this.f4037a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4037a;
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
        }

        public static IHighConfidenceCellPoiCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IHighConfidenceCellPoiCallback) == false) goto L12;
            return (IHighConfidenceCellPoiCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback");
            return true;
        L11:
            if (r8 != 1) goto L13;
            int r13 = r10.readInt();
            int r14 = r10.readInt();
            String r15 = r10.readString();
            r10.enforceNoDataAvail();
            onCellPoiStatusChange(r13, r14, r15);
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onCellPoiStatusChange(int r8, int r10, String r11);
}
