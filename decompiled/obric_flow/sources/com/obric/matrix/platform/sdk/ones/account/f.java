package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0 f11892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2 f11893c;
    public Function1 d;

    public f(String r5, Function0 r10, Function2 r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        attachInterface(this, "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
        this.f11891a = r5;
        this.f11892b = r10;
        this.f11893c = r11;
        this.d = r12;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
        if (r10 != 1) goto L5;
        r11.enforceInterface("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
        if (r11.readInt() == 0) goto L13;
        final boolean r5 = true;
    L15:
        if (r11.readInt() == 0) goto L18;
        Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
    L17:
        final Bundle r15 = r14;
        AtomicBoolean r16 = h.f11894a;
        final Function0 r17 = this.f11892b;
        final Function1 r18 = this.d;
        final Function2 r19 = this.f11893c;
        final Function0<Unit> r20 = new OAccount$AsyncResultCallback$onResult$1(this);
        Handler r110 = h.f11896c;
        final String r21 = this.f11891a;
        r110.post(new e(r5, r21, r18, r15, r17, r20, r19));
        return true;
    L18:
        r14 = null;
        goto L17
    L13:
        r5 = false;
        goto L15
    L5:
        if (r10 != 1598968902) goto L7;
        r12.writeString("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");
        return true;
    L7:
        return super.onTransact(r10, r11, r12, r13);
    }
}
