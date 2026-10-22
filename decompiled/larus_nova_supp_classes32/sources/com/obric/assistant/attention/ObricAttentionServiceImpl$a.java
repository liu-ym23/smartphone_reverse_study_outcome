package com.obric.assistant.attention;

import android.os.Binder;
import android.os.Parcel;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import oba.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricAttentionServiceImpl$a extends Binder {
    public final ObricAttentionServiceImpl$b a;
    public final /* synthetic */ ObricAttentionServiceImpl b;

    public ObricAttentionServiceImpl$a(ObricAttentionServiceImpl r2, ObricAttentionServiceImpl$b r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this.b = r2;
        this.a = r3;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.DATA_KEY);
        final boolean r0 = false;
        if (r5 != 1) goto L5;
        r6.enforceInterface("android.service.attention.IAttentionCallback");
        if (r6.readInt() != 1) goto L17;
        r0 = true;
    L17:
        r6.readLong();
    L18:
        final ObricAttentionServiceImpl r9 = this.b;
        r9.a.post(new f(r9, this, r0));
        return true;
    L5:
        if (r5 != 2) goto L7;
        r6.enforceInterface("android.service.attention.IAttentionCallback");
        r6.readInt();
        goto L18
    L7:
        if (r5 != 1598968902) goto L9;
        if (r7 == null) goto L12;
        r7.writeString("android.service.attention.IAttentionCallback");
    L12:
        return true;
    L9:
        return super.onTransact(r5, r6, r7, r8);
    }
}
