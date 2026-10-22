package com.ss.android.lark.keyboard.edittext2.list;

import android.content.Context;
import androidx.core.util.Pools;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int f = 0;
    public final Context a;
    public final c b;
    public final Pools.SimplePool<y9b.c> c;
    public final Pools.SimplePool<y9b.b> d;
    public C0144b e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.list.b$b, reason: collision with other inner class name */
    public static final class C0144b {
        public final Float a;
        public final Integer b;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.list.b$b$a */
        public static final class a {
            public Float a;
            public Integer b;

            public a() {
            }
        }

        public C0144b(Float r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final float c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d;
        }

        public final String toString() {
            return "ListTheme(listTextSize=" + this.a + ", labelColor=" + this.b + ", listItemRightMargin=" + this.c + ", floorWidth=" + this.d + ')';
        }

        public c(int r1, int r2, float r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, new c(-1, UIUtils.getColor(r5, 2131108619), -1.0f, -1));
    }

    public final y9b.a a(y9b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "prefixSpan");
        if ((r2 instanceof y9b.c) == false) goto L8;
        y9b.c r3 = (y9b.c) this.c.acquire();
        if (r3 == null) goto L15;
        return r3;
    L15:
        return new y9b.c();
    L8:
        if ((r2 instanceof y9b.b) == false) goto L13;
        y9b.b r4 = (y9b.b) this.d.acquire();
        if (r4 == null) goto L17;
        return r4;
    L17:
        return new y9b.b();
    L13:
        return new y9b.c();
    }

    public final void b(y9b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "span");
        if ((r2 instanceof y9b.c) == false) goto L6;
        this.c.release(r2);
        return;
    L6:
        if ((r2 instanceof y9b.b) == false) goto L10;
        this.d.release(r2);
        return;
    }

    public final void d(y9b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "span");
        ((CommonPrefixSpan) r4).a.d = com.ss.android.lark.coremd.utils.a.d(r4);
        ((CommonPrefixSpan) r4).a.c = com.ss.android.lark.coremd.utils.a.b(this.a, r4) + com.ss.android.lark.coremd.utils.a.a(this.a, this.b.d, r4.b());
        ((CommonPrefixSpan) r4).a.e = com.ss.android.lark.coremd.utils.a.c(this.a, r4, this.b.c);
    }

    public b(Context r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "listTheme");
        this.a = r2;
        this.b = r3;
        this.c = new Pools.SimplePool(16);
        this.d = new Pools.SimplePool(16);
        C0144b.a r4 = new C0144b.a();
        this.e = new C0144b(r4.a, r4.b);
    }

    public static void c(y9b.a r2, y9b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "newSpan");
        Intrinsics.checkNotNullParameter(r3, "prefixSpan");
        r2.h(r3.c() + 1);
        r2.f(r3.b());
        CommonPrefixSpan.c r4 = ((CommonPrefixSpan) r3).a;
        float r0 = r4.e;
        CommonPrefixSpan.c r1 = ((CommonPrefixSpan) r2).a;
        r1.e = r0;
        r1.j = r4.j;
        r1.g = r4.g;
        r2.g(ListHeadType.None);
    }
}
