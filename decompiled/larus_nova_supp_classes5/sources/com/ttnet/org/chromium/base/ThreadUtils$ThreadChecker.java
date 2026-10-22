package com.ttnet.org.chromium.base;

import android.os.Process;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ThreadUtils$ThreadChecker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mThreadId;

    public void assertOnValidThread() {
    }

    public ThreadUtils$ThreadChecker() {
        this.mThreadId = Process.myTid();
    }

    static {
    }
}
