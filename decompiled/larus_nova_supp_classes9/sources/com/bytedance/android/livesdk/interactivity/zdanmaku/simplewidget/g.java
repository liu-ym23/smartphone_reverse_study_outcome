package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import p22.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public final ArrayList<uc2.b> a;
    public final ArrayList<Integer> b;
    public final a c;
    public n d;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((Integer) r1).intValue() - ((Integer) r2).intValue();
        }
    }

    public g(n r7) {
        Intrinsics.checkNotNullParameter(r7, "danmakuConfig");
        this.d = r7;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = a.a;
        n r8 = this.d;
        Intrinsics.checkNotNullParameter(r8, "danmakuConfig");
        int r9 = r8.c;
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        this.a.add(new uc2.h(r1, true, false, null));
        r1 = r1 + 1;
        goto L3
    }

    public static void a(com.bytedance.android.livesdk.interactivity.zdanmaku.i r2) {
        Intrinsics.checkNotNullParameter(r2, "danmaku");
        float r0 = r2.c();
        uc2.b r1 = r2.e;
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = r1.c;
        if (r3 == null) goto L7;
        float r4 = r3.c();
    L9:
        if (r0 <= r4) goto L14;
        uc2.b r5 = r2.e;
        if (r5 == null) goto L15;
        r5.c = r2;
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r4 = 0.0f;
        goto L9
    }
}
