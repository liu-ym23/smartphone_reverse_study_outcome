package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements IIMCallback<Boolean> {
    public f() {
    }

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        ((Boolean) r1).booleanValue();
    }
}
