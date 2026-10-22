package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ IMessageListComponent b;

    public e(int r1, IMessageListComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Unit invoke() {
        Log.i("FlowChatReadablePlugin", "update message readable is true, chat readable is " + this.a);
        IMessageListComponent r0 = this.b;
        if (r0 == null) goto L6;
        r0.z6(true);
    L6:
        return Unit.INSTANCE;
    }
}
