package oca;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e0 implements pca.c {
    public final /* synthetic */ b0 a;

    public e0(b0 r1) {
        this.a = r1;
    }

    @Override // pca.c
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        View.OnLongClickListener r0 = this.a.getMOnLongClickListener();
        if (r0 == null) goto L6;
        r0.onLongClick(r2);
        return;
    }
}
