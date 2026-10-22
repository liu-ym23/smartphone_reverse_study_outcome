package com.larus.bmhome.taskskill.view;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements IIMCallback<OmniDispatchCommandResponse> {
    public o() {
    }

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("PcConnectionStatusManager", "[sendPermissionControlCommand] failed, error=" + r4, r4.getException());
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((OmniDispatchCommandResponse) r2, "result");
    }
}
