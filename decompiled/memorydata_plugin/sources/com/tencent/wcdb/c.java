package com.tencent.wcdb;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c extends Binder implements j {
    public static j a(IBinder r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        j r0 = (j) ZeusTransformUtils.preCheckCast(r4.queryLocalInterface("android.content.IBulkCursor"), j.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        return r0;
    L10:
        return new d(r4);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r3, Parcel r4, Parcel r5, int r6) {
        switch(r3) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L26;
        };
    L5:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        b();     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        return true;
    L7:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        Bundle r2 = a(r4.readBundle(getClass().getClassLoader()));     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        r5.writeBundle(r2);     // Catch: Exception -> L22
        return true;
    L9:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        Bundle r7 = c();     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        r5.writeBundle(r7);     // Catch: Exception -> L22
        return true;
    L11:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        b(r4.readInt());     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        return true;
    L13:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        int r8 = a(k.a.a(r4.readStrongBinder()));     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        r5.writeInt(r8);     // Catch: Exception -> L22
        r5.writeBundle(c());     // Catch: Exception -> L22
        return true;
    L15:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        a();     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        return true;
    L17:
        r4.enforceInterface("android.content.IBulkCursor");     // Catch: Exception -> L22
        CursorWindow r9 = a(r4.readInt());     // Catch: Exception -> L22
        r5.writeNoException();     // Catch: Exception -> L22
        if (r9 != null) goto L20;
        r5.writeInt(0);     // Catch: Exception -> L22
    L21:
        return true;
    L20:
        r5.writeInt(1);     // Catch: Exception -> L22
        r9.writeToParcel(r5, 1);     // Catch: Exception -> L22
        goto L21
    L26:
        return super.onTransact(r3, r4, r5, r6);
    L22:
        e = move-exception;
        h.a(r5, e);
        return true;
    }
}
