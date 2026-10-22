package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$l implements IIMCallback<List<? extends Message>> {
    public MessageIDLStub$l() {
    }

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.w("IFlowMessageIDLSPI", "refreshLatestMessages failed, error=" + r4);
    }

    public final void onSuccess(Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        FLogger.a.i("IFlowMessageIDLSPI", "refreshLatestMessages success, size=" + r5.size());
    }
}
