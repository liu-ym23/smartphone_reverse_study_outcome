package com.bytedance.byted_bach_sdk.llm;

/* JADX INFO: loaded from: classes.dex */
public class LLMLoraAdapter {
    public String m_loraModelPath;
    public String m_loraName;
    public float m_loraScale;

    public LLMLoraAdapter(String r2, String r3, float r4) {
        this.m_loraScale = 1.0f;
        this.m_loraName = r2;
        this.m_loraModelPath = r3;
        this.m_loraScale = r4;
    }
}
