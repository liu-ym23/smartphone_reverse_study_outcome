package com.lynx.debugrouter.app;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface MessageHandler {
    String getName();

    MessageHandleResult handle(Map<String, String> r1);
}
