package com.lynx.devtool;

import com.lynx.devtoolwrapper.MessageHandler;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DevToolMessageHandlerDelegate {
    private WeakReference<MessageHandler> handlerRef;

    public DevToolMessageHandlerDelegate(MessageHandler r2) {
        this.handlerRef = new WeakReference(r2);
    }

    public void onMessage(String r2) {
        MessageHandler r0 = this.handlerRef.get();
        if (r0 == null) goto L6;
        r0.onMessage(r2);
        return;
    }
}
