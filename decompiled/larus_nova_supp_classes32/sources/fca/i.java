package fca;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends ViewOutlineProvider {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        int r0 = this.a.i;
        if (r0 > 0) goto L6;
        r0 = r8.getWidth();
    L6:
        r9.setRoundRect(0, 0, r0, r8.getHeight(), this.a.j);
    }
}
