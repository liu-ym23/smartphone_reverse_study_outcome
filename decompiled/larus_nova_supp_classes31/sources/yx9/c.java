package yx9;

import kotlin.jvm.internal.Intrinsics;
import vx9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements a {
    public static final c c = null;
    public final /* synthetic */ a b;

    static {
        c = new c();
    }

    public final void d(String r3) {
        Intrinsics.checkNotNullParameter("TRACE_SPAN", "tag");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.b.d(r3);
    }

    public final void e(String r3) {
        Intrinsics.checkNotNullParameter("TRACE_SPAN", "tag");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.b.e(r3);
    }

    public final void w(String r3) {
        Intrinsics.checkNotNullParameter("TRACE_SPAN", "tag");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.b.w(r3);
    }

    public c() {
        b.a.getClass();
        this.b = b.d;
    }
}
