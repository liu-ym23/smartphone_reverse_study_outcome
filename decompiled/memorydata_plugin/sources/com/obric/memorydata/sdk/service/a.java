package com.obric.memorydata.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes5.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.service.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0703a extends Binder implements a {
        public AbstractBinderC0703a() {
            attachInterface(this, "com.obric.memorydata.sdk.service.IMemoryDataService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.service.IMemoryDataService");
            IBinder r3 = a(r5.readInt());
            r6.writeNoException();
            r6.writeStrongBinder(r3);
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString("com.obric.memorydata.sdk.service.IMemoryDataService");
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    IBinder a(int r1);
}
