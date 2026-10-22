package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$syncPendingWidgetUpdate$2 implements IIMCallback<Message> {
    public final /* synthetic */ MessageIDLStub a;
    public final /* synthetic */ String b;
    public final /* synthetic */ MessageIDLStub$c c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r13) {
        Intrinsics.checkNotNullParameter(r13, "error");
        BuildersKt.launch$default(MessageIDLStub.access$getScope$p(this.a), null, null, new MessageIDLStub$syncPendingWidgetUpdate$2$onFailure$1(this.a, this.b, this.c, r13, this.d, this.e, null), 3, null);
    }

    public final void onSuccess(Object r11) {
        Intrinsics.checkNotNullParameter((Message) r11, "result");
        BuildersKt.launch$default(MessageIDLStub.access$getScope$p(this.a), null, null, new MessageIDLStub$syncPendingWidgetUpdate$2$onSuccess$1(this.a, this.b, this.c, this.d, this.e, null), 3, null);
    }

    public MessageIDLStub$syncPendingWidgetUpdate$2(MessageIDLStub r1, String r2, MessageIDLStub$c r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
