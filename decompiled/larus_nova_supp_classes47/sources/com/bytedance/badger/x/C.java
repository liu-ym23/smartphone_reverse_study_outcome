package com.bytedance.badger.x;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.bytedance.badger.BadgerCore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class C extends Binder implements D {
    public static final /* synthetic */ int a = 0;

    public static D a(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        BadgerCore.Companion.getClass();
        IInterface r0 = r2.queryLocalInterface(com.bytedance.badger.j.b(2418618557650235769L));
        if (r0 == null) goto L12;
        if ((r0 instanceof D) == false) goto L12;
        return (D) r0;
    L12:
        return new B(r2);
    }
}
