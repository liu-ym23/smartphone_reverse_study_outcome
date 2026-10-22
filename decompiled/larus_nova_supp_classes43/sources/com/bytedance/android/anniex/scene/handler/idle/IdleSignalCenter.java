package com.bytedance.android.anniex.scene.handler.idle;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class IdleSignalCenter {
    public static final IdleSignalCenter a = null;
    public static final List<a> b = null;
    public static final Handler c = null;

    public static final class a {
        public final String a;
        public final int b;
        public final long c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            long r1 = this.c;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "Signal(source=" + this.a + ", level=" + this.b + ", expiryTime=" + this.c + ')';
        }

        public a(long r10) {
            Intrinsics.checkNotNullParameter("page_switch", "source");
            this.a = "page_switch";
            this.b = 1;
            this.c = r10;
        }
    }

    public IdleSignalCenter() {
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        boolean r0 = ((ArrayList) b).isEmpty();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        final long r0 = System.currentTimeMillis();     // Catch: Throwable -> L6
        CollectionsKt.removeAll(b, new IdleSignalCenter$removeExpiredSignals$1(r0));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        a = new IdleSignalCenter();
        b = new ArrayList();
        c = new Handler(Looper.getMainLooper());
    }
}
