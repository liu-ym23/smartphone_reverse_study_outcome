package com.larus.bmhome.auth;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 implements IIMCallback<e> {
    public final /* synthetic */ i<e> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public a0(j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("AuthViewModel", "getMainBotConversationInfoV2 failed " + r4.getCode() + "; " + r4.getTips(), r4.getException());
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess(Object r4) {
        e r5 = (e) r4;
        FLogger.a.i("AuthViewModel", "getMainBotConversationInfoV2 success");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r5));
        return;
    }
}
