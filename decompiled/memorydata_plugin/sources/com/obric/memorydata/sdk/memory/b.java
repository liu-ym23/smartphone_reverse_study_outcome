package com.obric.memorydata.sdk.memory;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.obric.memorydata.sdk.memory.IMemoryService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface("com.obric.memorydata.sdk.memory.IMemoryService");
            a(com.obric.memorydata.sdk.memory.a.AbstractBinderC0696a.a(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface("com.obric.memorydata.sdk.memory.IMemoryService");
            String r8 = r5.readString();
            String r9 = r5.readString();
            if (r5.readInt() == 0) goto L23;
            Bundle r10 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.memorydata.plugin");
        L24:
            a(r8, r9, r10);
            return true;
        L23:
            r10 = null;
            goto L24
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface("com.obric.memorydata.sdk.memory.IMemoryService");
            boolean r3 = a();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface("com.obric.memorydata.sdk.memory.IMemoryService");
            a(r5.readString());
            return true;
        L11:
            if (r4 != 1598968902) goto L13;
            r6.writeString("com.obric.memorydata.sdk.memory.IMemoryService");
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void a(com.obric.memorydata.sdk.memory.a r1);

    void a(String r1);

    void a(String r1, String r2, Bundle r3);

    boolean a();
}
