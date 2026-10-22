package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatPinExtraPushHandler implements c0.a {
    public final MessageListPinExtraLoader a;
    public final Function1<Function1<? super f5b.b, ? extends f5b.b>, Unit> b;
    public final Lazy c;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        MessageListPinExtraLoader r0 = this.a;
        if (r0 == null) goto L9;
        MessageListPinExtraLoader.b r1 = (MessageListPinExtraLoader.b) this.c.getValue();
        Intrinsics.checkNotNullParameter(r1, "listener");
        if (r0.b == false) goto L10;
        ((CopyOnWriteArrayList) r0.e.getValue()).add(r1);
        return;
    L10:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        MessageListPinExtraLoader r0 = this.a;
        if (r0 == null) goto L9;
        MessageListPinExtraLoader.b r1 = (MessageListPinExtraLoader.b) this.c.getValue();
        Intrinsics.checkNotNullParameter(r1, "listener");
        if (r0.b == false) goto L10;
        ((CopyOnWriteArrayList) r0.e.getValue()).remove(r1);
        return;
    L10:
        return;
    }

    public ChatPinExtraPushHandler(MessageListPinExtraLoader r2, Function1<? super Function1<? super f5b.b, ? extends f5b.b>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "updateExecutor");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ChatPinExtraPushHandler$observer$2(this));
    }
}
