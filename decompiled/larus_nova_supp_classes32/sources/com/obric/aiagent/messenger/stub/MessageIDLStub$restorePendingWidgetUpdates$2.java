package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$restorePendingWidgetUpdates$2 implements IIMCallback<Message> {
    public final /* synthetic */ MessageIDLStub a;
    public final /* synthetic */ MessageIDLStub$e b;
    public final /* synthetic */ Map<String, String> c;
    public final /* synthetic */ MessageIDLStub$d d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        BuildersKt.launch$default(MessageIDLStub.access$getScope$p(this.a), null, null, new MessageIDLStub$restorePendingWidgetUpdates$2$onFailure$1(this.a, this.b, r8, null), 3, null);
    }

    public final void onSuccess(Object r12) {
        Message r13 = (Message) r12;
        Intrinsics.checkNotNullParameter(r13, "result");
        MessageIDLStub$e r4 = MessageIDLStub.access$toWidgetRenderSnapshot(this.a, r13);
        BuildersKt.launch$default(MessageIDLStub.access$getScope$p(this.a), null, null, new MessageIDLStub$restorePendingWidgetUpdates$2$onSuccess$1(this.a, this.b, r4, this.c, this.d, null), 3, null);
    }

    public MessageIDLStub$restorePendingWidgetUpdates$2(MessageIDLStub r1, MessageIDLStub$e r2, Map<String, String> r3, MessageIDLStub$d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
