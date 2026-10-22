package com.obric.assistant.remote_card_container;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RemoteCardImpl$init$1$a implements IIMCallback<Message> {
    public final /* synthetic */ kotlinx.coroutines.i<Message> a;
    public final /* synthetic */ String b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("RemoteCardImpl", "getMessageById failed: messageId = " + this.b + ", code = " + r4.getCode() + ", tips = " + r4.getTips());
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
        this.a.resumeWith(Result.constructor-impl(r3));
    }

    public RemoteCardImpl$init$1$a(kotlinx.coroutines.j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
