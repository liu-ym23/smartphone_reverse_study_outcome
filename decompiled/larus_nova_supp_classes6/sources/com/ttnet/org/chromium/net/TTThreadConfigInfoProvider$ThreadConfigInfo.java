package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTThreadConfigInfoProvider$ThreadConfigInfo {
    private TTThreadConfigInfoProvider$BindCore mBindCore;
    private int mThreadPriority;
    private int mThreadStackSize;
    private TTThreadConfigInfoProvider.ThreadType mThreadType;

    public int getThreadType() {
        return this.mThreadType.ordinal();
    }

    public TTThreadConfigInfoProvider$ThreadConfigInfo() {
        this.mThreadPriority = 20;
    }

    public int getThreadPriority() {
        return this.mThreadPriority;
    }

    public int getThreadStackSize() {
        return this.mThreadStackSize;
    }

    public void setThreadPriority(int r1) {
        this.mThreadPriority = r1;
    }

    public void setThreadStackSize(int r1) {
        this.mThreadStackSize = r1;
    }

    public void setThreadType(TTThreadConfigInfoProvider.ThreadType r1) {
        this.mThreadType = r1;
    }
}
