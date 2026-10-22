package rb8;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends ViewOutlineProvider {
    public final /* synthetic */ int a;

    public d(int r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        int r4 = r8.getWidth();
        int r10 = r8.getHeight();
        int r0 = this.a;
        r9.setRoundRect(0, 0, r4, r10 + r0, r0);
    }
}
