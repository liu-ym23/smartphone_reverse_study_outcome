package com.bytedance.gkfs;

import ai.j0;
import android.util.Log;
import com.bytedance.geckox.logger.DefaultLogger;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.logger.Logger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f4829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4830b;

    public d() {
        this.f4829a = new AtomicInteger(-1);
        this.f4830b = hashCode();
    }

    public static void b(int r5, String r10, Throwable r11) {
        if (((Boolean) e.f4831a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r5 != 4) goto L8;
        Log.i("gkfs-debug-tag", r10);
        return;
    L8:
        if (r5 != 5) goto L10;
        Log.w("gkfs-debug-tag", r10, r11);
        return;
    L10:
        if (r5 == 6) goto L12;
        return;
    L12:
        Log.e("gkfs-debug-tag", r10, r11);
    }

    public static /* synthetic */ void c(d r5, String r10, String r11, int r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5.f4829a.get();
    L6:
        if ((r13 & 8) == 0) goto L8;
        boolean r14 = false;
    L9:
        r5.e(r10, r12, r11, r14);
        return;
    L8:
        r14 = true;
        goto L9
    }

    public static void d(d r5, String r10, String r11, Throwable r12, boolean r13, int r14) {
        int r15 = r5.f4829a.get();
        if ((r14 & 8) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 16) == 0) goto L8;
        r13 = true;
    L8:
        String r16 = r5.a(r15, r10, r11);
        if (r13 == false) goto L17;
        CopyOnWriteArrayList r17 = GeckoLogger.f4756a;
        if (r17.size() != 0) goto L13;
        GeckoLogger.f4757b.a("gkfs-debug-tag", r16, r12);
        goto L17
    L13:
        Iterator r18 = r17.iterator();
    L15:
        if (r18.hasNext() == false) goto L17;
        ((DefaultLogger) ((Logger) r18.next())).a("gkfs-debug-tag", r16, r12);
    L17:
        b(6, r16, r12);
    }

    public static void f(d r5, String r10, String r11, int r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r12 = r5.f4829a.get();
    L5:
        r5.getClass();
        String r14 = r5.a(r12, r10, r11);
        CopyOnWriteArrayList r15 = GeckoLogger.f4756a;
        if (r15.size() != 0) goto L8;
        GeckoLogger.f4757b.getClass();
        Log.w("gkfs-debug-tag", r14, null);
    L12:
        b(5, r14, null);
        return;
    L8:
        Iterator r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        ((DefaultLogger) ((Logger) r16.next())).getClass();
        Log.w("gkfs-debug-tag", r14, null);
        goto L10
    }

    public final String a(int r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder("[");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r12, this.f4830b, "][", r10, "][");
        r12.append(r5);
        r12.append(']');
        if (((Boolean) e.f4831a.getValue()).booleanValue() == false) goto L5;
        String r13 = "[" + Thread.currentThread().getName() + ']';
    L7:
        return j0.q(r12, r13, r11);
    L5:
        r13 = "";
        goto L7
    }

    public final void e(String r5, int r10, String r11, boolean r12) {
        String r13 = a(r10, r5, r11);
        if (r12 == false) goto L11;
        CopyOnWriteArrayList r14 = GeckoLogger.f4756a;
        if (r14.size() != 0) goto L7;
        GeckoLogger.f4757b.a("gkfs-debug-tag", new Object[]{r13});
        goto L11
    L7:
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        DefaultLogger r16 = (DefaultLogger) ((Logger) r15.next());
        r16.a("gkfs-debug-tag", new Object[]{r13});
    L11:
        b(4, r13, null);
    }
}
