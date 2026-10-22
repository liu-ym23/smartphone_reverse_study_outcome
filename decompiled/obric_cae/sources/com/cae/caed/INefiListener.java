package com.cae.caed;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface INefiListener extends IInterface {

    public static class Default implements INefiListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INefiListener {
        static final int TRANSACTION_OnInfoChanged = 1;
        static final int TRANSACTION_OnWifiStatsChanged = 2;

        public static class Proxy implements INefiListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4125a;

            public Proxy(IBinder r8) {
                this.f4125a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4125a;
            }
        }

        public Stub() {
            attachInterface(this, "com.cae.caed.INefiListener");
        }

        public static INefiListener asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.INefiListener");
            if (r10 == null) goto L12;
            if ((r10 instanceof INefiListener) == false) goto L12;
            return (INefiListener) r10;
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
            r10.enforceInterface("com.cae.caed.INefiListener");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.cae.caed.INefiListener");
            return true;
        L11:
            if (r8 != 1) goto L13;
            OnInfoChanged(r10.readInt(), r10.createTypedArrayList(NefiInfoParcel.CREATOR));
        L18:
            r11.writeNoException();
            return true;
        L13:
            if (r8 != 2) goto L15;
            OnWifiStatsChanged(r10.createTypedArrayList(WifiStatsParcel.CREATOR));
            goto L18
        L15:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void OnInfoChanged(int r8, List<NefiInfoParcel> r10);

    void OnWifiStatsChanged(List<WifiStatsParcel> r8);
}
