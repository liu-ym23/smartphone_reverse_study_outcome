package db8;

import android.view.View;
import android.view.ViewGroup;
import jc8.b;
import jc8.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends b<jc8.a> {
    @Override // jc8.b
    public final String c() {
        return "EmptyBlockHolder";
    }

    public a() {
    }

    @Override // jc8.b
    public final d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        return new d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        View r0 = new View(r3.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        return r0;
    }
}
