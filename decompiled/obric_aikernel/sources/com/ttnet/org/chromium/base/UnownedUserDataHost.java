package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnownedUserDataHost {
    private final DestroyChecker mDestroyChecker;
    private Handler mHandler;
    private final ThreadUtils.ThreadChecker mThreadChecker;
    private HashMap<UnownedUserDataKey<?>, WeakReference<? extends UnownedUserData>> mUnownedUserDataMap;

    public UnownedUserDataHost() {
        this(new Handler(retrieveNonNullLooperOrThrow()));
    }

    @VisibleForTesting(otherwise = 2)
    UnownedUserDataHost(Handler r10) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mUnownedUserDataMap = new HashMap();
        this.mHandler = r10;
    }

    public static /* synthetic */ void a(UnownedUserDataHost r10, UnownedUserData r11) {
        r10.lambda$remove$0(r11);
    }

    private void checkState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    private /* synthetic */ void lambda$remove$0(UnownedUserData r10) {
        r10.onDetachedFromHost(this);
    }

    private static Looper retrieveNonNullLooperOrThrow() {
        Looper r10 = Looper.myLooper();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException();
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mDestroyChecker.isDestroyed() == false) goto L5;
        return;
    L5:
        Iterator r10 = new HashSet(this.mUnownedUserDataMap.keySet()).iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        ((UnownedUserDataKey) r10.next()).detachFromHost(this);
        goto L7
    L9:
        this.mUnownedUserDataMap = null;
        this.mHandler = null;
        this.mDestroyChecker.destroy();
    }

    @Nullable
    <T extends UnownedUserData> T get(@NonNull UnownedUserDataKey<T> r10) {
        checkState();
        WeakReference<? extends UnownedUserData> r11 = this.mUnownedUserDataMap.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        UnownedUserData r12 = r11.get();
        if (r12 != null) goto L10;
        r10.detachFromHost(this);
        return null;
    L10:
        return r10.getValueClass().cast(r12);
    }

    @VisibleForTesting(otherwise = 5)
    int getMapSize() {
        checkState();
        return this.mUnownedUserDataMap.size();
    }

    boolean isDestroyed() {
        return this.mDestroyChecker.isDestroyed();
    }

    <T extends UnownedUserData> void remove(@NonNull UnownedUserDataKey<T> r10) {
        checkState();
        WeakReference<? extends UnownedUserData> r11 = this.mUnownedUserDataMap.remove(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        final UnownedUserData r12 = r11.get();
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.informOnDetachmentFromHost() == false) goto L12;
        this.mHandler.post(new m(this, r12));
        return;
    }

    <T extends UnownedUserData> void set(@NonNull UnownedUserDataKey<T> r10, @NonNull T r11) {
        checkState();
        if (this.mUnownedUserDataMap.containsKey(r10) == true) goto L5;
    L7:
        this.mUnownedUserDataMap.put(r10, new WeakReference(r11));
        return;
    L5:
        if (r11.equals(get(r10)) == true) goto L7;
        r10.detachFromHost(this);
        goto L7
    }
}
