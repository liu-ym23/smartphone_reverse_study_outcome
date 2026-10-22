package com.facebook.drawee.components;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeferredReleaser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DeferredReleaserConcurrentImpl f7750a;

    public interface Releasable {
        void release();
    }

    public DeferredReleaser() {
    }

    public static boolean a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return true;
    L6:
        return false;
    }
}
