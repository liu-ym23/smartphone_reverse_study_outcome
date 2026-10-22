package com.bytedance.byted_bach_sdk.llm;

import com.bytedance.byted_bach_sdk.listener.BachCallbackListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class LLMStreamListener extends BachCallbackListener {
    public LLMStreamListener() {
        enableOnEvent(false);
    }

    public abstract void onEvent(String r1, boolean r2);
}
