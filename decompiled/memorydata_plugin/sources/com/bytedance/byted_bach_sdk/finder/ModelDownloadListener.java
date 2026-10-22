package com.bytedance.byted_bach_sdk.finder;

/* JADX INFO: loaded from: classes.dex */
public abstract class ModelDownloadListener {
    protected long m_nativeListener;

    public ModelDownloadListener() {
        this.m_nativeListener = 0;
    }

    private native void deleteNativeObject(long r1);

    public void finalize() {
        super.finalize();
        deleteNativeObject(this.m_nativeListener);
        this.m_nativeListener = 0;
    }

    public abstract void onFailed();

    public abstract void onSuccess();

    public final void setNativeListener(long r1) {
        this.m_nativeListener = r1;
    }
}
