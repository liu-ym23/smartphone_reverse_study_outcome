package com.larus.search.impl.combine;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x implements IIMCallback<Boolean> {
    public final /* synthetic */ String a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public x(String r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.w("CombineSearchFragment", "keepConversationOnTop failed, conversationId: " + this.a + " error: " + r4);
    }

    public final void onSuccess(Object r4) {
        boolean r5 = ((Boolean) r4).booleanValue();
        FLogger.a.i("CombineSearchFragment", "keepConversationOnTop success, conversationId: " + this.a + " result: " + r5);
    }
}
