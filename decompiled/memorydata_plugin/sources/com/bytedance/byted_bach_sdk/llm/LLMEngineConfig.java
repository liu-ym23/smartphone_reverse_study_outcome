package com.bytedance.byted_bach_sdk.llm;

/* JADX INFO: loaded from: classes.dex */
public class LLMEngineConfig {
    private String m_modelPath;
    private long m_nativeHandle;

    private LLMEngineConfig(String r3) {
        this.m_nativeHandle = 0;
        this.m_modelPath = r3;
    }

    private native void deleteNativeObject(long r1);

    public void finalize() {
        super.finalize();
        deleteNativeObject(this.m_nativeHandle);
        this.m_nativeHandle = 0;
    }

    public String getModelPath() {
        return this.m_modelPath;
    }

    public long getNativeHandle() {
        return this.m_nativeHandle;
    }

    public final void setNativeHandle(long r1) {
        this.m_nativeHandle = r1;
    }
}
