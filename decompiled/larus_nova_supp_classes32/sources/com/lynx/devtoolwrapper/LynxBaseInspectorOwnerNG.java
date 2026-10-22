package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface LynxBaseInspectorOwnerNG extends LynxBaseInspectorOwner {
    void sendMessage(CustomizedMessage r1);

    void subscribeMessage(String r1, MessageHandler r2);

    void unsubscribeMessage(String r1);
}
