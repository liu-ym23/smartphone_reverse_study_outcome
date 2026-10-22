package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$f implements IIMCallback<Message> {
    public final /* synthetic */ String a;

    public final boolean mustInMain() {
        return true;
    }

    public MessageIDLStub$f(String r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("IFlowMessageIDLSPI", "add app action reply msg failed: " + r4);
    }

    public final void onSuccess(Object r4) {
        Message r5 = (Message) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r5.getMessageStatus() == MessageStatus.MessageStatus_INVISIBLE) goto L10;
        String r0 = this.a;
        if (Intrinsics.areEqual(r0, OAppIntentBizContentType.USER_REMIND_CARD) == false) goto L8;
        ObricActionBarSendServiceDelegate.b.l(r5);
        goto L10
    L8:
        if (Intrinsics.areEqual(r0, OAppIntentBizContentType.REMOTE_CARD) == false) goto L10;
        ObricActionBarSendServiceDelegate.b.o(r5);
    L10:
        FLogger.a.i("IFlowMessageIDLSPI", "add app action reply msg success: " + r5);
    }
}
