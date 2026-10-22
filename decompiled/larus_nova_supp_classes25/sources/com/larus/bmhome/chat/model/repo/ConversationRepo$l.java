package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.a;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationRepo$l implements IIMCallback<wc9.e> {
    public final /* synthetic */ CompletableDeferred<a<wc9.e>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public ConversationRepo$l(CompletableDeferred<a<wc9.e>> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        Intrinsics.checkNotNullParameter(r7, "error");
        CompletableDeferred<a<wc9.e>> r0 = this.a;
        long r3 = r7.getCode();
        String r5 = r7.getTips();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        AsyncThrowable r8 = r7.getException();
        if (r8 != null) goto L8;
        AsyncThrowable.Companion.getClass();
        r8 = AsyncThrowable.access$getDEFAULT$cp();
    L8:
        r0.complete(new com.larus.network.http.f(new AsyncThrowable(r3, r5, r8), null));
    }

    public final void onSuccess(Object r5) {
        this.a.complete(new com.larus.network.http.y((wc9.e) r5, null, 14));
    }
}
