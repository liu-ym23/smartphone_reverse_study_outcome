package com.larus.drive.sdk.impl.service;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements IIMCallback<wc9.e> {
    public final /* synthetic */ kotlinx.coroutines.i<wc9.e> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public n(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("DriveLocalConvHelper", "createLocalSubConversation failed, code=" + r4.getCode() + ", tips=" + r4.getTips());
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess(Object r2) {
        wc9.e r3 = (wc9.e) r2;
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
