package com.bytedance.keva;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class KevaImpl$3 implements Callable<KevaImpl> {
    final /* synthetic */ Context val$context;
    final /* synthetic */ boolean val$isMainThreadAndEnableOpt;
    final /* synthetic */ int val$mode;
    final /* synthetic */ String val$repoName;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public KevaImpl call() {
        if (this.val$isMainThreadAndEnableOpt == false) goto L5;
        Process.setThreadPriority(Process.myTid(), KevaImpl.access$200());
    L5:
        KevaImpl r0 = KevaImpl.getEmptyRepoImpl(this.val$repoName, null, this.val$mode);
        KevaImpl.access$300(r0, this.val$context);
        if (this.val$isMainThreadAndEnableOpt == false) goto L8;
        Process.setThreadPriority(Process.myTid(), 0);
    L8:
        return r0;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ KevaImpl call() throws Exception {
        return call();
    }

    public KevaImpl$3(boolean r1, String r2, int r3, Context r4) {
        this.val$isMainThreadAndEnableOpt = r1;
        this.val$repoName = r2;
        this.val$mode = r3;
        this.val$context = r4;
    }
}
