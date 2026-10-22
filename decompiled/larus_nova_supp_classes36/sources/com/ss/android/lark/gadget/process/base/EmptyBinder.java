package com.ss.android.lark.gadget.process.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class EmptyBinder extends Binder implements IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.gadget.process.base.EmptyBinder";

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public EmptyBinder() {
        attachInterface(this, DESCRIPTOR);
    }
}
