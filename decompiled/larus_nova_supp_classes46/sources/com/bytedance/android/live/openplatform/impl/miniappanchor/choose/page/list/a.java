package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.a$a, reason: collision with other inner class name */
    public static final class C0143a extends a {
        public static final C0143a a = null;

        static {
            a = new C0143a();
        }

        public C0143a() {
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {
        public final List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> a;
        public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L10;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(bannerList=" + this.a + ", groupProperty=" + this.b + ")";
        }

        public c(List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r2, com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r3) {
            Intrinsics.checkNotNullParameter(r2, "bannerList");
            Intrinsics.checkNotNullParameter(r3, "groupProperty");
            this.a = r2;
            this.b = r3;
        }
    }

    public a() {
    }
}
