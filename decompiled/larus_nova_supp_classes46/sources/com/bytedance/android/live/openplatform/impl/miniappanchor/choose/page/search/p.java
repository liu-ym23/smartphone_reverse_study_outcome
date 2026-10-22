package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class p {

    public static final class a extends p {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends p {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends p {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends p {
        public final List<MiniAppEntranceCell> a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((d) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<MiniAppEntranceCell> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(resultList=" + this.a + ")";
        }

        public d(List<MiniAppEntranceCell> r2) {
            Intrinsics.checkNotNullParameter(r2, "resultList");
            this.a = r2;
        }
    }

    public p() {
    }
}
