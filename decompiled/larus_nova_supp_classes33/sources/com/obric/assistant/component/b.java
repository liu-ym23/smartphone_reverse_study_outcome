package com.obric.assistant.component;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.service.IMessageService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ Message a;
    public final /* synthetic */ List<Message> b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("ObricActionBarSendServiceImpl", "delete message failed, error = " + r4);
    }

    public final void onSuccess(Object r10) {
        Intrinsics.checkNotNullParameter((List) r10, WindowEvent.Params.RESULT);
        NativeMessageServiceImpl r1 = com.larus.im.d.e();
        String r11 = this.a.getConversationId();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        IMessageService.a.a(r1, r11, this.b, true, false, false, null, 48);
    }

    public b(Message r1, List<Message> r2) {
        this.a = r1;
        this.b = r2;
    }
}
