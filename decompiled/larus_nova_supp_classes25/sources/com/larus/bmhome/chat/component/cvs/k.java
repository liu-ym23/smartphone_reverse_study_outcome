package com.larus.bmhome.chat.component.cvs;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements IIMCallback<e> {
    public final /* synthetic */ kotlinx.coroutines.i<e> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public k(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ChatConversationComponent", r4.getCode() + "; " + r4.getTips(), r4.getException());
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess(Object r4) {
        e r5 = (e) r4;
        FLogger.a.i("ChatConversationComponent", "getMainBotConversationInfo success");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r5));
        return;
    }
}
