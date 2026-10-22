package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageUniversalPinExtra;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Runnable {
    public final /* synthetic */ Map<Long, MessageUniversalPinExtra> a;
    public final /* synthetic */ ChatPinExtraPushHandler b;

    public h(Map<Long, MessageUniversalPinExtra> r1, ChatPinExtraPushHandler r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (CollectionUtils.isEmpty(this.a) == true) goto L10;
        this.b.b.invoke(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.o(this.a));     // Catch: Throwable -> L7
        return;
    }
}
