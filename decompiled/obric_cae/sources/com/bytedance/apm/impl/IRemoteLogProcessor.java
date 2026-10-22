package com.bytedance.apm.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IRemoteLogProcessor extends IInterface {

    public static abstract class Stub extends Binder implements IRemoteLogProcessor {

        public static class Proxy implements IRemoteLogProcessor {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.apm.impl.ICrossLogProcessor");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface("com.bytedance.apm.impl.ICrossLogProcessor");
            String r13 = p1();
            r11.writeNoException();
            r11.writeString(r13);
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("com.bytedance.apm.impl.ICrossLogProcessor");
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    String p1();
}
