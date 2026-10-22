package com.obric.assistant.audio;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q implements IIMCallback<Message> {
    public final /* synthetic */ Ref.ObjectRef<Message> a;
    public final /* synthetic */ CountDownLatch b;

    public final boolean mustInMain() {
        return false;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("ObricTtsControlServiceImpl", "queryMessageFromDb failed: code=" + r4.getCode() + ", tips=" + r4.getTips());
        this.b.countDown();
    }

    public final void onSuccess(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
        this.a.element = r3;
        this.b.countDown();
    }

    public q(Ref.ObjectRef<Message> r1, CountDownLatch r2) {
        this.a = r1;
        this.b = r2;
    }
}
