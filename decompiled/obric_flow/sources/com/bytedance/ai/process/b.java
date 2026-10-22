package com.bytedance.ai.process;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.ai.resource.f0;
import com.bytedance.ai.resource.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2414a;

    public /* synthetic */ b(int r5) {
        this.f2414a = r5;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int r5 = this.f2414a;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
        switch(this.f2414a) {
            case 0: goto L15;
            default: goto L5;
        };
    L5:
        if (r10 == 1) goto L9;
        if (r10 != 1598968902) goto L39;
        r12.writeString("com.bytedance.ai.process.IAISDKInitializeCallback");
        return true;
    L39:
        return super.onTransact(r10, r11, r12, r13);
    L9:
        r11.enforceInterface("com.bytedance.ai.process.IAISDKInitializeCallback");
        if (d.f2417c.isCompleted() == true) goto L12;
        d.f2417c.N(Unit.INSTANCE);
    L12:
        r12.writeNoException();
        return true;
    L15:
        if (r10 == 1) goto L19;
        if (r10 != 1598968902) goto L41;
        r12.writeString("com.bytedance.ai.process.IAISDKClientCallback");
        return true;
    L41:
        return super.onTransact(r10, r11, r12, r13);
    L19:
        r11.enforceInterface("com.bytedance.ai.process.IAISDKClientCallback");
        String r14 = r11.readString();
        long r5 = r11.readLong();
        String r15 = r11.readString();
        r11.readString();
        if (r14 == null) goto L37;
        ConcurrentHashMap r16 = com.bytedance.ai.multiprocess.c.f2405a;
        Intrinsics.checkNotNullParameter(r14, "packageName");
        com.bytedance.ai.multiprocess.c.f2405a.put(r14, new com.bytedance.ai.multiprocess.b(r5, r15));
        Intrinsics.checkNotNullParameter(j.f2734a, "<this>");
        Intrinsics.checkNotNullParameter(r14, "packageName");
        Intrinsics.checkNotNullParameter(r14, "packageName");
        f0 r17 = (f0) j.d.get(r14);
        if (r17 != null) goto L25;
        com.bytedance.ai.resource.b r18 = null;
    L31:
        if (r18 == null) goto L37;
        if (r18.f2564c > 0) goto L37;
        Intrinsics.checkNotNullParameter(r14, "packageName");
        j.q(r14);
        goto L37
    L25:
        long r19 = r17.f2721i;
        String r20 = r17.f2722j;
        if (r17.f2720h == false) goto L29;
        int r21 = r17.d.get();
    L28:
        int r22 = r21;
        r18 = new com.bytedance.ai.resource.b(r22, r19, r20, r17.e);
        goto L31
    L29:
        r21 = 0;
    L37:
        r12.writeNoException();
        return true;
    }
}
