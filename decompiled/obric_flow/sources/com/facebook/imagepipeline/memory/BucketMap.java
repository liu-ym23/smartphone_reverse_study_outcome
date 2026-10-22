package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import androidx.constraintlayout.motion.widget.a;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@ThreadSafe
public class BucketMap<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f8209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedEntry f8210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedEntry f8211c;

    public static class LinkedEntry<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LinkedEntry f8212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedList f8214c;
        public LinkedEntry d;

        public LinkedEntry(int r5, LinkedList r10) {
            this.f8212a = null;
            this.f8213b = r5;
            this.f8214c = r10;
            this.d = null;
        }

        public final String toString() {
            return a.s(new StringBuilder("LinkedEntry(key: "), this.f8213b, ")");
        }
    }

    public BucketMap() {
        this.f8209a = new SparseArray();
    }

    public final synchronized Object a(int r5) {
        monitor-enter(this);
        LinkedEntry r10 = (LinkedEntry) this.f8209a.get(r5);     // Catch: Throwable -> L17
        if (r10 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Object r11 = r10.f8214c.pollFirst();     // Catch: Throwable -> L17
        if (this.f8210b != r10) goto L12;
        monitor-exit(this);
        return r11;
    L12:
        a(r10);     // Catch: Throwable -> L17
        LinkedEntry r12 = this.f8210b;     // Catch: Throwable -> L17
        if (r12 != null) goto L19;
        this.f8210b = r10;     // Catch: Throwable -> L17
        this.f8211c = r10;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r11;
    L19:
        r10.d = r12;     // Catch: Throwable -> L17
        r12.f8212a = r10;     // Catch: Throwable -> L17
        this.f8210b = r10;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r11;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(int r5, Object r10) {
        monitor-enter(this);
        LinkedEntry r11 = (LinkedEntry) this.f8209a.get(r5);     // Catch: Throwable -> L6
        if (r11 != null) goto L8;
        r11 = new LinkedEntry(r5, new LinkedList());     // Catch: Throwable -> L6
        this.f8209a.put(r5, r11);     // Catch: Throwable -> L6
    L8:
        r11.f8214c.addLast(r10);     // Catch: Throwable -> L6
        if (this.f8210b != r11) goto L12;
        monitor-exit(this);
        return;
    L12:
        a(r11);     // Catch: Throwable -> L6
        LinkedEntry r12 = this.f8210b;     // Catch: Throwable -> L6
        if (r12 != null) goto L17;
        this.f8210b = r11;     // Catch: Throwable -> L6
        this.f8211c = r11;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L17:
        r11.d = r12;     // Catch: Throwable -> L6
        r12.f8212a = r11;     // Catch: Throwable -> L6
        this.f8210b = r11;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(LinkedEntry r5) {
        monitor-enter(this);
        LinkedEntry r10 = r5.f8212a;     // Catch: Throwable -> L6
        LinkedEntry r11 = r5.d;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        r10.d = r11;     // Catch: Throwable -> L6
    L8:
        if (r11 == null) goto L10;
        r11.f8212a = r10;     // Catch: Throwable -> L6
    L10:
        r5.f8212a = null;     // Catch: Throwable -> L6
        r5.d = null;     // Catch: Throwable -> L6
        if (r5 != this.f8210b) goto L14;
        this.f8210b = r11;     // Catch: Throwable -> L6
    L14:
        if (r5 != this.f8211c) goto L18;
        this.f8211c = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L18:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Object a() {
        monitor-enter(this);
        LinkedEntry r5 = this.f8211c;     // Catch: Throwable -> L13
        if (r5 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Object r10 = r5.f8214c.pollLast();     // Catch: Throwable -> L13
        if (r5.f8214c.isEmpty() == false) goto L15;
        a(r5);     // Catch: Throwable -> L13
        this.f8209a.remove(r5.f8213b);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r10;
    L15:
        monitor-exit(this);
        return r10;
    L13:
        th = move-exception;
        throw th;
    }
}
