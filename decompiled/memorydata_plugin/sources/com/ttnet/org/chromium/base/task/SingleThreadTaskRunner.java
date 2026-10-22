package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes6.dex */
public interface SingleThreadTaskRunner extends SequencedTaskRunner {
    boolean belongsToCurrentThread();
}
