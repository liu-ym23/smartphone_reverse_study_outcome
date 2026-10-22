package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import androidx.recyclerview.widget.RecyclerView;
import eka.b;
import eka.c;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class FPSMonitorOnScrollListener extends RecyclerView.OnScrollListener {
    public static final ConcurrentLinkedQueue<b> f = null;
    public boolean a;
    public long b;
    public int c;
    public int d;
    public b e;

    public static final class a {
    }

    static {
        f = new ConcurrentLinkedQueue();
    }

    public final void onScrollStateChanged(RecyclerView r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        super.onScrollStateChanged(r9, r10);
        if (r10 != 0) goto L5;
        b r11 = this.e;
        if (r11 != null) goto L40;
    L43:
        this.c = 0;
        this.d = 0;
        this.b = -1;
        b r12 = this.e;
        if (r12 == null) goto L52;
        f.add(r12);
        this.e = null;
        throw null;
    L52:
        throw null;
    L40:
        if (this.b <= 0) goto L42;
        r11.b = SystemClock.elapsedRealtime() - this.b;
    L42:
        r11.g = this.c;
        r11.h = this.d;
        r11.e = r9.computeHorizontalScrollOffset();
        r11.f = r9.computeVerticalScrollOffset();
        goto L43
    L5:
        if (r10 == 1) goto L8;
        return;
    L8:
        if (this.b >= 0) goto L20;
        if (this.e != null) goto L15;
        b r13 = (b) b.n.acquire();
        if (r13 != null) goto L14;
        r13 = new b(0);
    L14:
        this.e = r13;
    L15:
        b r14 = this.e;
        if (r14 == null) goto L18;
        r14.c = r9.computeHorizontalScrollOffset();
        r14.d = r9.computeVerticalScrollOffset();
    L18:
        this.b = SystemClock.elapsedRealtime();
    L20:
        if (this.a == true) goto L49;
        Field r15 = eka.a.a().getDeclaredField("mLogging");     // Catch: Exception -> L26
        r15.setAccessible(true);     // Catch: Exception -> L26
        Object r16 = r15.get(Looper.getMainLooper());     // Catch: Exception -> L26
        if (r16 == null) goto L25;
        Printer r17 = (Printer) r16;     // Catch: Exception -> L26
    L27:
        if (r17 != null) goto L50;
        gka.b.a("FPSMonitorOnScrollListener", "CurrentPrinter() == null, now reset.");
        Field r18 = c.class.getDeclaredField("a");     // Catch: Exception -> L34
        r18.setAccessible(true);     // Catch: Exception -> L34
        Object r19 = r18.get(null);     // Catch: Exception -> L34
        if (r19 == null) goto L33;
        Looper.getMainLooper().setMessageLogging((Printer) r19);     // Catch: Exception -> L34
        this.a = true;     // Catch: Exception -> L34
        throw null;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        throw null;
    L50:
        throw null;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L26
    L26:
        r17 = null;
        goto L27
    L49:
        throw null;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        this.c += Math.abs(r3);
        this.d += Math.abs(r4);
    }
}
