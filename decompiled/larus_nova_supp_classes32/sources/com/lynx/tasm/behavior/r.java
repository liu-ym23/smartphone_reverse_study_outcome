package com.lynx.tasm.behavior;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class r extends MutableContextWrapper {
    private boolean mHasAttached;
    private MutableContextWrapper mWrapper;

    public Context getContext() {
        if (this.mHasAttached == false) goto L7;
        return getBaseContext();
    L7:
        return this.mWrapper;
    }

    public Activity getActivity() {
        return com.lynx.tasm.utils.a.getActivity(this);
    }

    public r(Context r3) {
        super(r3);
        this.mHasAttached = false;
        MutableContextWrapper r0 = new MutableContextWrapper(null);
        this.mWrapper = r0;
        r0.setBaseContext(r3);
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context r2) {
        super.setBaseContext(r2);
        this.mWrapper.setBaseContext(r2);
    }

    public void setHasLynxViewAttached(boolean r1) {
        this.mHasAttached = r1;
    }
}
