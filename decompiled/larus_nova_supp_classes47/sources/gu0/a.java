package gu0;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import cy0.f;
import e33.k;
import fu0.c;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, m {
    public final f a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        f r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "parent");
        c r1 = new c(r0);
        Intrinsics.checkNotNullParameter(r1, "scope");
        Object r2 = k.a;
        if (r1.e != r2) goto L6;
        String r3 = "revenueInstance";
    L12:
        if (r3 != null) goto L16;
        l.a(r1);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r3);
    L6:
        if (r1.f != r2) goto L9;
        r3 = "revenueInstanceExt";
        goto L12
    L9:
        if (r1.g != r2) goto L11;
        r3 = "roomInstance";
        goto L12
    L11:
        r3 = null;
        goto L12
    }

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        this.a = r2;
    }
}
