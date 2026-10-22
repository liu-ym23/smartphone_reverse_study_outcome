package com.ttnet.org.chromium.base.task;

import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class ChainedTasks {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean mCanceled;
    private boolean mFinalized;
    private final Runnable mRunAndPost;
    private final LinkedList<Pair<TaskTraits, Runnable>> mTasks;

    static {
    }

    public ChainedTasks() {
        this.mTasks = new LinkedList();
        this.mRunAndPost = new AnonymousClass1(this);
    }

    public static /* synthetic */ void a(ChainedTasks r10) {
        r10.lambda$start$0();
    }

    static /* synthetic */ boolean access$000(ChainedTasks r10) {
        return r10.mCanceled;
    }

    static /* synthetic */ LinkedList access$100(ChainedTasks r10) {
        return r10.mTasks;
    }

    private /* synthetic */ void lambda$start$0() {
        Iterator<Pair<TaskTraits, Runnable>> r10 = this.mTasks.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        ((Runnable) r10.next().second).run();
        if (this.mCanceled == false) goto L4;
        return;
    }

    public void add(TaskTraits r10, Runnable r11) {
        LinkedList<Pair<TaskTraits, Runnable>> r12 = this.mTasks;
        monitor-enter(r12);
        this.mTasks.add(new Pair(r10, r11));     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void cancel() {
        LinkedList<Pair<TaskTraits, Runnable>> r10 = this.mTasks;
        monitor-enter(r10);
        this.mFinalized = true;     // Catch: Throwable -> L8
        this.mCanceled = true;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void start(boolean r10) {
        LinkedList<Pair<TaskTraits, Runnable>> r11 = this.mTasks;
        monitor-enter(r11);
        this.mFinalized = true;     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        if (this.mTasks.isEmpty() == false) goto L10;
        return;
    L10:
        if (r10 == false) goto L12;
        PostTask.runOrPostTask((TaskTraits) this.mTasks.peek().first, new c(this));
        return;
    L12:
        PostTask.postTask((TaskTraits) this.mTasks.peek().first, this.mRunAndPost);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
