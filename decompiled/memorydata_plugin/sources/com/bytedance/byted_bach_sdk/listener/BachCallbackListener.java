package com.bytedance.byted_bach_sdk.listener;

/* JADX INFO: loaded from: classes.dex */
public abstract class BachCallbackListener {
    protected boolean m_enableEvent;
    protected long m_nativeListener;

    public BachCallbackListener() {
        this.m_enableEvent = true;
        this.m_nativeListener = 0;
    }

    private native void deleteNativeObject(long r1);

    public void enableOnEvent(boolean r1) {
        this.m_enableEvent = r1;
    }

    public void finalize() {
        super.finalize();
        deleteNativeObject(this.m_nativeListener);
        this.m_nativeListener = 0;
    }

    public void onEvent(BachCallbackEvent r1) {
    }

    public final void setNativeListener(long r1) {
        this.m_nativeListener = r1;
    }
}
