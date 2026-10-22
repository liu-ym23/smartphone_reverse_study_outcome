package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final /* synthetic */ int d = 0;
    public final LinkedList<d> a;
    public volatile boolean b;
    public long c;

    public static final class a {
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.c = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        d r0 = this.a.poll();     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        boolean r1 = true;
    L7:
        this.b = r1;     // Catch: Throwable -> L12
        v.a();     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        r0.a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        r1 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public e() {
        this.a = new LinkedList();
    }

    public final synchronized void a(String r2, Function1 r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "taskName");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r3, "block");     // Catch: Throwable -> L12
        f r0 = new f(this, r3, r2);     // Catch: Throwable -> L12
        this.a.offer(r0);     // Catch: Throwable -> L12
        v.a();     // Catch: Throwable -> L12
        this.a.size();     // Catch: Throwable -> L12
        LinkedList<d> r4 = this.a;     // Catch: Throwable -> L12
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Throwable -> L12
        Iterator<T> r6 = r4.iterator();     // Catch: Throwable -> L12
    L5:
        if (r6.hasNext() == false) goto L7;
        r5.add(((d) r6.next()).a);     // Catch: Throwable -> L12
        goto L5
    L7:
        r5.toString();     // Catch: Throwable -> L12
        v.a();     // Catch: Throwable -> L12
        if (this.b == true) goto L10;
        b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
