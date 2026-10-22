package com.larus.dora.obric.device_management.explore;

import android.os.SystemClock;
import android.widget.LinearLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGlassesExploreFragment a;

    public p0(DoraObricGlassesExploreFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r8, Continuation r9) {
        w0 r10 = (w0) r8;
        DoraObricGlassesExploreFragment r0 = this.a;
        LinearLayout r1 = r0.h;
        if (r1 == null) goto L20;
        if (r0.j == r10) goto L8;
    L12:
        r0.j = r10;
        long r5 = SystemClock.elapsedRealtime();
        r0.i++;
        int r3 = r0.i;
        r1.removeAllViews();
        if (r10.a == true) goto L20;
        List<u0> r11 = r10.c;
        if (r11 != null) goto L18;
        r11 = CollectionsKt.emptyList();
    L18:
        r0.Z90(r1, r11, r3, 0, r5);
        goto L20
    L8:
        if (r10.a == false) goto L10;
    L11:
        g49.d.d("DoraObricGlassesExploreFragment", "skip explore render for unchanged state");
        goto L20
    L10:
        if (r1.getChildCount() <= 0) goto L12;
    L20:
        return Unit.INSTANCE;
    }
}
