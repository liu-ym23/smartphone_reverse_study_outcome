package com.lynx.tasm.behavior;

import android.content.Context;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends MutableContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableContextWrapper f10314b;

    public q(Context r5) {
        super(r5);
        this.f10313a = false;
        MutableContextWrapper r10 = new MutableContextWrapper(null);
        this.f10314b = r10;
        r10.setBaseContext(r5);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context r5) {
        super.setBaseContext(r5);
        this.f10314b.setBaseContext(r5);
    }
}
