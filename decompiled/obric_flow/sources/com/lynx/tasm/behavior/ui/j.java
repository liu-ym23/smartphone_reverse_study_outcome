package com.lynx.tasm.behavior.ui;

import com.lynx.base.log.LynxLog;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxUI f10490a;

    public j(LynxUI r5) {
        this.f10490a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        LynxUI r5 = this.f10490a;
    L7:
        th = move-exception;
        LynxLog.b(4, "LynxUI", th.toString());
        return null;
    L4:
        if (r5.createView(r5.mContext, r5.mParam) != null) goto L13;
        return r5.createView(r5.mContext);
    L13:
        return null;
    }
}
