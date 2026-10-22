package com.larus.feedback.impl.service;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import wc9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements IIMCallback<s> {
    public final /* synthetic */ i<s> a;

    public final boolean mustInMain() {
        return false;
    }

    public b(j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("RecentFeedbackMessageCollector", "select conversations failed, code=" + r4.getCode());
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess(Object r2) {
        s r3 = (s) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
