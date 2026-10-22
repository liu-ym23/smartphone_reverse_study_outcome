package com.larus.voicecall.impl.plugins;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.service.IMessageService;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g0 implements IIMCallback<Message> {
    public final /* synthetic */ d0 a;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public g0(d0 r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r12) {
        Message r13 = (Message) r12;
        Intrinsics.checkNotNullParameter(r13, "result");
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.j(r13), "is_mock_sending") == false) goto L9;
        FLogger.a.i(this.a.f, "delete fake loading local msg id : " + this.a.j);
        NativeMessageServiceImpl r3 = com.larus.im.d.e();
        String r0 = r13.getConversationId();
        if (r0 != null) goto L7;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        IMessageService.a.a(r3, r0, CollectionsKt.listOf(r13), false, false, false, null, 48);
        this.a.j = null;
        return;
    }
}
