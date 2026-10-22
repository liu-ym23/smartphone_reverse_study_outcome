package com.bytedance.byted_bach_sdk;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class BachResourceFinder {
    private static final String TAG = "BachResourceFinder";
    boolean isDestroyed;
    protected long m_nativePtr;
    protected WeakReference<BachAlgorithmSystem> m_system;

    static {
        System.loadLibrary("bach-sdk-jni");
    }

    public BachResourceFinder() {
        this.m_nativePtr = 0;
        this.isDestroyed = false;
        this.m_system = null;
    }

    private BachAlgorithmSystem getAlgorithmSystem() {
        WeakReference<BachAlgorithmSystem> r2 = this.m_system;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (BachAlgorithmSystem) ZeusTransformUtils.preCheckCast(r2.get(), BachAlgorithmSystem.class, "com.obric.memorydata.plugin");
    }

    void bindAlgorithmSystem(BachAlgorithmSystem r2) {
        if (r2 == null) goto L5;
        this.m_system = new WeakReference(r2);
        return;
    L5:
        WeakReference<BachAlgorithmSystem> r3 = this.m_system;
        if (r3 == null) goto L9;
        r3.clear();
        this.m_system = null;
        return;
    }

    public final void destroy() {
        if (this.isDestroyed == false) goto L6;
        Log.e(TAG, "BachResourceFinder already destroyed");
        return;
    L6:
        BachAlgorithmSystem r0 = getAlgorithmSystem();
        if (r0 == null) goto L9;
        r0.resetResourceFinder(this);
    L9:
        this.m_system = null;
        this.isDestroyed = true;
        doDestroy();
    }

    public void doDestroy() {
    }
}
