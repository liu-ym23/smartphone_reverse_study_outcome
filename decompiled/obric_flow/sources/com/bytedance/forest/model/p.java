package com.bytedance.forest.model;

import java.io.Closeable;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements Closeable {
    public com.bytedance.forest.utils.e context;
    private final HashSet<Function0<Unit>> fulfillListeners;

    public p() {
        this.fulfillListeners = new HashSet();
    }

    public void fulfillListener$forest_release(Function0<Unit> r5) {
        HashSet<Function0<Unit>> r10 = this.fulfillListeners;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isCacheReady$forest_release() == false) goto L9;
        r5.invoke();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);
        return;
    L9:
        this.fulfillListeners.add(r5);     // Catch: Throwable -> L7
        goto L10
    }

    public com.bytedance.forest.utils.e getContext$forest_release() {
        com.bytedance.forest.utils.e r5 = this.context;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r5;
    }

    public abstract boolean isCacheClear$forest_release();

    public abstract boolean isCacheProvided$forest_release();

    public abstract boolean isCacheReady$forest_release();

    public final void onFulFilled() {
        HashSet<Function0<Unit>> r5 = this.fulfillListeners;
        monitor-enter(r5);
        Iterator<T> r10 = this.fulfillListeners.iterator();     // Catch: Throwable -> L8
    L6:
        if (r10.hasNext() == false) goto L10;
        ((Function0) r10.next()).invoke();     // Catch: Throwable -> L8
        goto L6
    L10:
        this.fulfillListeners.clear();     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public abstract byte[] provideBytes();

    public abstract InputStream provideInputStream(w r5);

    public void setContext$forest_release(com.bytedance.forest.utils.e r5) {
        this.context = r5;
    }

    public abstract int size();

    public abstract boolean supportReuse();

    public abstract void tryLoadToMemory$forest_release(w r5);
}
