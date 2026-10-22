package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationRepo$g implements IIMCallback<List<? extends wc9.e>> {
    public final /* synthetic */ kotlinx.coroutines.i<wc9.e> a;
    public final /* synthetic */ ConversationRepo b;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r6) {
        List r7 = (List) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        kotlinx.coroutines.i<wc9.e> r0 = this.a;
        Iterator r8 = ConversationRepo.z(this.b, r7).iterator();
    L4:
        if (r8.hasNext() == false) goto L19;
        Object r1 = r8.next();
        wc9.e r2 = (wc9.e) r1;
        Integer r3 = r2.j;
        if (r3 != null) goto L9;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L4;
    L20:
        r0.resumeWith(Result.constructor-impl(r1));
        return;
    L9:
        if (r3.intValue() != 3) goto L16;
        Integer r5 = r2.f;
        if (r5 == null) goto L16;
        r4 = true;
        if (r5.intValue() != 1) goto L16;
    L19:
        r1 = null;
        goto L20
    }

    public ConversationRepo$g(kotlinx.coroutines.j r1, ConversationRepo r2) {
        this.a = r1;
        this.b = r2;
    }
}
