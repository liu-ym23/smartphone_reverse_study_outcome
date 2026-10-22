package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.b$b, reason: collision with other inner class name */
    public static final class C0144b extends b {
        public static final C0144b a = null;

        static {
            a = new C0144b();
        }

        public C0144b() {
        }
    }

    public static final class c extends b {
        public final List<MiniAppEntranceCell> a;
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
            List<MiniAppEntranceCell> r0 = this.a;
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
            return "Success(entranceCellList=" + this.a + ", groupProperty=" + this.b + ")";
        }

        public c(List<MiniAppEntranceCell> r2, com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r3) {
            Intrinsics.checkNotNullParameter(r2, "entranceCellList");
            Intrinsics.checkNotNullParameter(r3, "groupProperty");
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }
}
