package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IStarPoiCallback extends IInterface {
    public static final String AOI_CONFIDENCE = "aoi_confidence";
    public static final String AOI_ID = "aoi_id";
    public static final String AOI_NAME = "aoi_name";
    public static final String IS_ACC_QUALIFIED_POI = "is_acc_qualified_poi";
    public static final String NEAR_THE_AOI = "near_the_aoi";
    public static final String NEAR_THE_POI = "near_the_poi";
    public static final String NEW_TYPE_CODE_L1 = "new_type_code_l1";
    public static final String NEW_TYPE_CODE_L2 = "new_type_code_l2";
    public static final String NEW_TYPE_CODE_L3 = "new_type_code_l3";
    public static final String NEW_TYPE_NAME_L1 = "new_type_name_l1";
    public static final String NEW_TYPE_NAME_L2 = "new_type_name_l2";
    public static final String NEW_TYPE_NAME_L3 = "new_type_name_l3";
    public static final String POI_CONFIDENCE = "poi_confidence";
    public static final String POI_ID = "poi_id";
    public static final String POI_NAME = "poi_name";
    public static final String SCENE_LOGID = "scene_logid";
    public static final String SDK_LOGID = "sdk_logid";
    public static final String TIMESTAMP = "timestamp";

    public static class Default implements IStarPoiCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarPoiCallback
        public void onNearPoiReport(Bundle r8) {
        }
    }

    public static abstract class Stub extends Binder implements IStarPoiCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarPoiCallback";
        static final int TRANSACTION_onNearPoiReport = 1;

        public static class Proxy implements IStarPoiCallback {
            public static IStarPoiCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarPoiCallback
            public void onNearPoiReport(Bundle r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r10, null, 1) == false) goto L10;
            L14:
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onNearPoiReport(r8);     // Catch: Throwable -> L16
                r10.recycle();
                return;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarPoiCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IStarPoiCallback) == false) goto L12;
            return (IStarPoiCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static IStarPoiCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IStarPoiCallback r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L13;
            Bundle r13 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L14:
            onNearPoiReport(r13);
            return true;
        L13:
            r13 = null;
            goto L14
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onNearPoiReport(Bundle r8);
}
