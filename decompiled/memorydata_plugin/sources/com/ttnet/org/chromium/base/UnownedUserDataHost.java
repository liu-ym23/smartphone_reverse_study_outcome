package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class UnownedUserDataHost {
    private final DestroyChecker mDestroyChecker;
    private Handler mHandler;
    private final ThreadUtils.ThreadChecker mThreadChecker;
    private HashMap<UnownedUserDataKey<?>, WeakReference<? extends UnownedUserData>> mUnownedUserDataMap;

    public UnownedUserDataHost() {
        this(new Handler(retrieveNonNullLooperOrThrow()));
    }

    UnownedUserDataHost(Handler r2) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mUnownedUserDataMap = new HashMap();
        this.mHandler = r2;
    }

    private void checkState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    private static Looper retrieveNonNullLooperOrThrow() {
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException();
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mDestroyChecker.isDestroyed() == false) goto L5;
        return;
    L5:
        Iterator r0 = new HashSet(this.mUnownedUserDataMap.keySet()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((UnownedUserDataKey) ZeusTransformUtils.preCheckCast(r0.next(), UnownedUserDataKey.class, "com.obric.memorydata.plugin")).detachFromHost(this);
        goto L7
    L9:
        this.mUnownedUserDataMap = null;
        this.mHandler = null;
        this.mDestroyChecker.destroy();
    }

    <T extends UnownedUserData> T get(UnownedUserDataKey<T> r5) {
        checkState();
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mUnownedUserDataMap.get(r5), WeakReference.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        UnownedUserData r1 = (UnownedUserData) ZeusTransformUtils.preCheckCast(r0.get(), UnownedUserData.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        r5.detachFromHost(this);
        return null;
    L10:
        return (T) ZeusTransformUtils.preCheckCast(r5.getValueClass().cast(r1), UnownedUserData.class, "com.obric.memorydata.plugin");
    }

    int getMapSize() {
        checkState();
        return this.mUnownedUserDataMap.size();
    }

    boolean isDestroyed() {
        return this.mDestroyChecker.isDestroyed();
    }

    public /* synthetic */ void lambda$remove$0$UnownedUserDataHost(UnownedUserData r3) {
        ((UnownedUserData) ZeusTransformUtils.wrapperContextForParams(r3, UnownedUserData.class, "com.obric.memorydata.plugin")).onDetachedFromHost(this);
    }

    <T extends UnownedUserData> void remove(UnownedUserDataKey<T> r3) {
        checkState();
        WeakReference r4 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mUnownedUserDataMap.remove(r3), WeakReference.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        final UnownedUserData r5 = (UnownedUserData) ZeusTransformUtils.preCheckCast(r4.get(), UnownedUserData.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.informOnDetachmentFromHost() == false) goto L12;
        this.mHandler.post(new $$Lambda$UnownedUserDataHost$6G9lCMrHVwYTpOOPLKkjOF0WjXk(this, r5));
        return;
    }

    <T extends UnownedUserData> void set(UnownedUserDataKey<T> r3, T r4) {
        UnownedUserData r5 = (UnownedUserData) ZeusTransformUtils.wrapperContextForParams(r4, UnownedUserData.class, "com.obric.memorydata.plugin");
        checkState();
        if (this.mUnownedUserDataMap.containsKey(r3) == true) goto L5;
    L7:
        this.mUnownedUserDataMap.put(r3, new WeakReference(r5));
        return;
    L5:
        if (r5.equals(get(r3)) == true) goto L7;
        r3.detachFromHost(this);
        goto L7
    }
}
