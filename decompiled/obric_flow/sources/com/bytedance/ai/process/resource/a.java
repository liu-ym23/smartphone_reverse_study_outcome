package com.bytedance.ai.process.resource;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2452a;

    public a(AtomicReference r5) {
        this.f2452a = r5;
        attachInterface(this, "com.bytedance.ai.process.ILoadFileCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
        if (r5 != 1) goto L5;
        r10.enforceInterface("com.bytedance.ai.process.ILoadFileCallback");
        if (r10.readInt() == 0) goto L13;
        ParcelFileDescriptor r13 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r10);
    L14:
        Function1 r14 = (Function1) this.f2452a.getAndSet(null);
        if (r14 == null) goto L17;
        r14.invoke(r13);
    L17:
        r11.writeNoException();
        return true;
    L13:
        r13 = null;
        goto L14
    L5:
        if (r5 != 1598968902) goto L7;
        r11.writeString("com.bytedance.ai.process.ILoadFileCallback");
        return true;
    L7:
        return super.onTransact(r5, r10, r11, r12);
    }
}
