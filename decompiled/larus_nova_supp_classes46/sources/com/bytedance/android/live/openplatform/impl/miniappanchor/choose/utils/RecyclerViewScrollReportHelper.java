package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import np0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class RecyclerViewScrollReportHelper<T> {
    public List<? extends T> a;
    public boolean b;
    public List<? extends T> c;
    public int d;
    public int e;
    public final Set<T> f;
    public final RecyclerView g;
    public final int h;
    public final int i;
    public final a<T> j;

    public interface a<T> {
        void a(T r1, int r2);

        boolean b(T r1, T r2);
    }

    public final void d(List<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataList");
        this.a = new ArrayList(r3);
        this.g.post(new c(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(RecyclerViewScrollReportHelper r7, List r8) {
        LinearLayoutManager r0 = r7.g.getLayoutManager();
        if (r0 == null) goto L28;
        int r1 = r0.findFirstVisibleItemPosition();
        LinearLayoutManager r2 = r7.g.getLayoutManager();
        if (r2 == null) goto L26;
        int r3 = r2.findLastVisibleItemPosition();
        if (r1 >= 0) goto L9;
        return;
    L9:
        if (r3 >= r8.size()) goto L34;
        if (r1 > r3) goto L23;
        int r4 = r1;
    L12:
        Iterator<T> r5 = r7.c.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        T r6 = r5.next();
        if (r7.j.b((T) ListProtector.get(r8, r4), r6) == false) goto L14;
    L19:
        if (r6 != null) goto L21;
        r7.c(ListProtector.get(r8, r4), r4);
    L21:
        if (r4 == r3) goto L23;
        r4 = r4 + 1;
        goto L12
    L18:
        r6 = null;
    L23:
        r7.c = r8.subList(r1, r3 + 1);
        r7.d = r1;
        r7.e = r3;
        return;
    L34:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(RecyclerViewScrollReportHelper r6, int r7) {
        List<? extends T> r0 = r6.a;
        if (r0 == null) goto L31;
        LinearLayoutManager r1 = r6.g.getLayoutManager();
        if (r1 == null) goto L30;
        int r2 = r1.findFirstVisibleItemPosition();
        LinearLayoutManager r3 = r6.g.getLayoutManager();
        if (r3 == null) goto L28;
        int r4 = r3.findLastVisibleItemPosition();
        if (r2 < 0) goto L34;
        ArrayList r5 = (ArrayList) r0;
        if (r4 >= r5.size()) goto L35;
        if (r7 <= 0) goto L20;
        int r8 = r6.e;
        if (r8 < 0) goto L20;
        int r9 = r8 + 1;
        if (r9 > r4) goto L26;
    L17:
        r6.c(ListProtector.get(r0, r9), r9);
        if (r9 == r4) goto L26;
        r9 = r9 + 1;
    L26:
        r6.c = r5.subList(r2, r4 + 1);
        r6.d = r2;
        r6.e = r4;
        return;
    L20:
        if (r7 >= 0) goto L26;
        if (r6.d > r5.size()) goto L26;
        int r10 = r6.d;
        int r11 = r2;
    L24:
        if (r11 >= r10) goto L26;
        r6.c(ListProtector.get(r0, r11), r11);
        r11 = r11 + 1;
        goto L24
    L35:
        return;
    L34:
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void c(T r4, int r5) {
        boolean r0 = this.f.contains(r4);
        if (this.i != 2) goto L6;
        if (r0 == true) goto L7;
        this.j.a(r4, r5);
    L7:
        if (r0 == true) goto L10;
        this.f.add(r4);
        return;
    L10:
        return;
    L6:
        this.j.a(r4, r5);
        goto L7
    }

    public RecyclerViewScrollReportHelper(RecyclerView r2, int r3, int r4, a<T> r5) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.b = true;
        this.c = new ArrayList();
        this.d = -1;
        this.e = -1;
        this.f = new LinkedHashSet();
        r2.addOnScrollListener(new AnonymousClass1(this));
    }
}
