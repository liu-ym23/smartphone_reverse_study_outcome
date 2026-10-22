package com.bytedance.android.live.liveinteract.linkpanel.util;

import java.util.Comparator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Comparator<T> {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            com.bytedance.android.live.liveinteract.linkpanel.util.a r4 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r2;
            if (this.a == false) goto L5;
            int r0 = b.a;
            int r5 = b.b(r4.b());
        L6:
            Integer r6 = Integer.valueOf(r5);
            boolean r1 = this.a;
            c r7 = ((com.bytedance.android.live.liveinteract.linkpanel.util.a) r3).b();
            if (r1 == false) goto L9;
            int r8 = b.b(r7);
        L11:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r8));
        L9:
            r8 = b.a(r7);
            goto L11
        L5:
            int r9 = b.a;
            r5 = b.a(r4.b());
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.util.b$b, reason: collision with other inner class name */
    public static final class C0042b<T> implements Comparator<T> {
        public C0042b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = b.a;
            return ComparisonsKt.compareValues(Integer.valueOf(b.c(((com.bytedance.android.live.liveinteract.linkpanel.util.a) r2).b())), Integer.valueOf(b.c(((com.bytedance.android.live.liveinteract.linkpanel.util.a) r3).b())));
        }
    }

    public b() {
    }

    static {
    }

    public static final int a(c r1) {
        if ((r1 instanceof c.b) == false) goto L6;
        return 0;
    L6:
        if ((r1 instanceof c.e) == false) goto L9;
        return 1;
    L9:
        if ((r1 instanceof c.a) == false) goto L12;
        return 2;
    L12:
        if ((r1 instanceof c.AbstractC0043c) == false) goto L15;
        return 3;
    L15:
        if ((r1 instanceof c.d) == false) goto L19;
        return 4;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static final int b(c r1) {
        if ((r1 instanceof c.b) == false) goto L6;
        return 0;
    L6:
        if ((r1 instanceof c.a) == false) goto L9;
        return 1;
    L9:
        if ((r1 instanceof c.AbstractC0043c) == false) goto L12;
        return 2;
    L12:
        if ((r1 instanceof c.e) == false) goto L15;
        return 3;
    L15:
        if ((r1 instanceof c.d) == false) goto L19;
        return 4;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static final int c(c r1) {
        if ((r1 instanceof c.d) == false) goto L6;
        return 0;
    L6:
        if ((r1 instanceof c.AbstractC0043c) == false) goto L9;
        return 1;
    L9:
        if ((r1 instanceof c.b) == false) goto L12;
        return 2;
    L12:
        if ((r1 instanceof c.e) == false) goto L15;
        return 3;
    L15:
        if ((r1 instanceof c.a) == false) goto L19;
        return 4;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public static List d(List r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "providers");
        return CollectionsKt.sortedWith(CollectionsKt.take(CollectionsKt.sortedWith(r1, new a(r2)), 3), new C0042b());
    }
}
