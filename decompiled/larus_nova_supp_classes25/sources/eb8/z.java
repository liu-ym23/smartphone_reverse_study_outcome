package eb8;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z extends jc8.b<fb8.f> {
    public com.larus.bmhome.chat.layout.widget.t d;

    @Override // jc8.b
    public final String c() {
        return "DocTextBlockHolder";
    }

    public z() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r6) {
        fb8.f r7 = (fb8.f) r6;
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        boolean r0 = r7.m();
        boolean r8 = r7.n();
        if (r0 == false) goto L7;
        if (r8 == false) goto L7;
        return new jc8.d(0, c7.b(12), 0, c7.b(14));
    L7:
        if (r0 == true) goto L14;
        if (r8 == false) goto L12;
        return new jc8.d(0, c7.b(6), 0, c7.b(14));
    L12:
        return new jc8.d(0, c7.b(10), 0, c7.b(6));
    L14:
        return new jc8.d(0, c7.b(12), 0, c7.b(6));
    }

    @Override // jc8.b
    public final void g(jc8.a r3) {
        fb8.f r4 = (fb8.f) r3;
        Intrinsics.checkNotNullParameter(r4, "blockModel");
        com.larus.bmhome.chat.layout.widget.t r0 = this.d;
        if (r0 == null) goto L6;
        r0.c(r4, (kc8.b) jc8.c.a(this, kc8.b.class));
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        com.larus.bmhome.chat.layout.widget.t r0 = new com.larus.bmhome.chat.layout.widget.t(r2.getContext());
        this.d = r0;
        return r0;
    }
}
