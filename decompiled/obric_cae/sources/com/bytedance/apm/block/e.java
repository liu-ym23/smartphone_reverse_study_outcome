package com.bytedance.apm.block;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Thread f3757a = null;

    public static class a {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<d> mAddObservers;
        final List<d> mObservers;
        List<d> mRemoveObservers;

        public a() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void addMessageObserver(d r8) {
            List<d> r10 = this.mObservers;
            monitor-enter(r10);
            if (r8 != null) goto L13;
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mAddObservers.contains(r8) == true) goto L8;
            this.mAddObservers.add(r8);     // Catch: Throwable -> L10
            this.haveAdd = true;     // Catch: Throwable -> L10
            goto L8
        }

        public void messageDispatchStarting(String r8) {
            if (this.haveAdd == false) goto L18;
            List<d> r10 = this.mObservers;
            monitor-enter(r10);
            Iterator<d> r11 = this.mAddObservers.iterator();     // Catch: Throwable -> L15
        L8:
            if (r11.hasNext() == false) goto L12;
            d r12 = r11.next();     // Catch: Throwable -> L15
            if (this.mObservers.contains(r12) == true) goto L8;
            this.mObservers.add(r12);     // Catch: Throwable -> L15
            goto L8
        L12:
            this.mAddObservers.clear();     // Catch: Throwable -> L15
            this.haveAdd = false;     // Catch: Throwable -> L15
            monitor-exit(r10);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L18:
            Iterator<d> r13 = this.mObservers.iterator();
        L20:
            if (r13.hasNext() == false) goto L24;
            d r14 = r13.next();
            if (r14 == null) goto L20;
            r14.a(r8);
            goto L20
        }

        public void messageDispatched(String r8, Message r10) {
            Iterator<d> r11 = this.mObservers.iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            d r12 = r11.next();
            if (r12 == null) goto L4;
            r12.b(r8, r10);
            goto L4
        L9:
            if (this.haveRemove == false) goto L22;
            List<d> r13 = this.mObservers;
            monitor-enter(r13);
            Iterator<d> r14 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L19
        L14:
            if (r14.hasNext() == false) goto L16;
            d r15 = r14.next();     // Catch: Throwable -> L19
            this.mObservers.remove(r15);     // Catch: Throwable -> L19
            this.mAddObservers.remove(r15);     // Catch: Throwable -> L19
            goto L14
        L16:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L19
            this.haveRemove = false;     // Catch: Throwable -> L19
            monitor-exit(r13);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void removeMessageObserver(d r8) {
            List<d> r10 = this.mObservers;
            monitor-enter(r10);
            if (r8 != null) goto L13;
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mRemoveObservers.contains(r8) == true) goto L8;
            this.mRemoveObservers.add(r8);     // Catch: Throwable -> L10
            this.haveRemove = true;     // Catch: Throwable -> L10
            goto L8
        }

        public void setup(Object r8) {
        }
    }

    static {
        f3757a = Looper.getMainLooper().getThread();
    }
}
