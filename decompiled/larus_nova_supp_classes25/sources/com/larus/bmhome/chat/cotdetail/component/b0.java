package com.larus.bmhome.chat.cotdetail.component;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements IIMCallback<Boolean> {
    public b0() {
    }

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("CotDetailMessageListComponent", "interruptMessage onFailure error: " + r4);
    }

    public final void onSuccess(Object r3) {
        ((Boolean) r3).booleanValue();
        FLogger.a.d("CotDetailMessageListComponent", "interruptMessage onSuccess");
    }
}
