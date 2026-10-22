package com.bytedance.ai.applet.render.core.lynx;

import androidx.core.util.Consumer;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    void sendMessage(JavaOnlyMap r1, Long r10);

    void setMessageHandle(Consumer<ReadableMap> r1);
}
