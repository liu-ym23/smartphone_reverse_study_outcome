package com.bytedance.platform.thread;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f7203c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f7204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Field f7205b;

    static {
        f7203c = new ArrayList();
    }

    public final long a() {
        monitor-enter(this);
        Object r5 = this.f7205b.get(Looper.myQueue());     // Catch: Throwable -> L7 IllegalAccessException -> L9
        if (r5 == null) goto L11;
        long r10 = ((Message) r5).getWhen();     // Catch: Throwable -> L7 IllegalAccessException -> L9
    L15:
        monitor-exit(this);     // Catch: Throwable -> L7
        return r10;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
        return Long.MIN_VALUE;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        r10 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        if (this.f7205b == null) goto L37;
    L9:
        long r5 = a();
        if ((r5 - SystemClock.uptimeMillis()) <= 0) goto L12;
    L13:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L15:
        if (this.f7204a.isEmpty() == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L20:
        MessageQueue.IdleHandler r10 = (MessageQueue.IdleHandler) this.f7204a.poll();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        boolean r11 = r10.queueIdle();
        SystemClock.uptimeMillis();
        a();
        if (r11 == false) goto L28;
        monitor-enter(this);
        this.f7204a.offer(r10);     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L28:
        return true;
    L12:
        if (r5 != Long.MIN_VALUE) goto L28;
    L37:
        this.f7205b = MessageQueue.class.getDeclaredField("mMessages");     // Catch: NoSuchFieldException -> L6
    L8:
        this.f7205b.setAccessible(true);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
