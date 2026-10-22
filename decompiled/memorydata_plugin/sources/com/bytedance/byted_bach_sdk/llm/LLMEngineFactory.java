package com.bytedance.byted_bach_sdk.llm;

/* JADX INFO: loaded from: classes.dex */
public abstract class LLMEngineFactory {
    private int m_initErrorCode;

    public LLMEngineFactory() {
        this.m_initErrorCode = 0;
    }

    public abstract int applyLora(long r1, LLMLoraAdapter r3);

    public abstract long getOrCreateEngine(LLMEngineConfig r1);

    public abstract int releaseEngine(long r1, int r3);

    public abstract int removeLora(long r1, LLMLoraAdapter r3);

    public void setInitErrorCode(int r1) {
        this.m_initErrorCode = r1;
    }
}
