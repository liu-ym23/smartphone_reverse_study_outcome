package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n1 implements IIMCallback<Boolean> {
    public final /* synthetic */ List<String> a;
    public final /* synthetic */ CompletableDeferred<Boolean> b;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.b.complete(Boolean.FALSE);
    }

    public final void onSuccess(Object r4) {
        boolean r5 = ((Boolean) r4).booleanValue();
        if (r5 == false) goto L8;
        Iterator<T> r0 = this.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) r0.next();
        com.larus.bmhome.chat.adapter.p0.a.a(r1);
    L8:
        this.b.complete(Boolean.valueOf(r5));
    }

    public n1(List<String> r1, CompletableDeferred<Boolean> r2) {
        this.a = r1;
        this.b = r2;
    }
}
