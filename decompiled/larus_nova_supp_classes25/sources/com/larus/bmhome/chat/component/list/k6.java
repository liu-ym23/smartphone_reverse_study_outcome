package com.larus.bmhome.chat.component.list;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k6 implements IIMCallback<String> {
    public k6() {
    }

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        String r2 = (String) r1;
    }
}
