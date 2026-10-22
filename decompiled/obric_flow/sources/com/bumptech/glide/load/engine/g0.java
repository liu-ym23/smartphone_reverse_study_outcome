package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r5) {
        if (r5.what != 1) goto L6;
        ((d0) r5.obj).recycle();
        return true;
    L6:
        return false;
    }
}
