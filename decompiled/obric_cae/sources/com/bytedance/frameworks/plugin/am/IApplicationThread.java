package com.bytedance.frameworks.plugin.am;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IApplicationThread extends IInterface {

    public static abstract class Stub extends Binder implements IApplicationThread {

        public static class Proxy implements IApplicationThread {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.frameworks.plugin.am.IApplicationThread");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1598968902) goto L5;
            r11.writeString("com.bytedance.frameworks.plugin.am.IApplicationThread");
            return true;
        L5:
            return super.onTransact(r8, r10, r11, r12);
        }
    }
}
