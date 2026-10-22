package up9;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o extends ViewOutlineProvider {
    public o() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r2, Outline r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "outline");
        r3.setEmpty();
    }
}
