package jsb;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.ss.android.lark.movable.island.ScrollIsland;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends ViewOutlineProvider {
    public final /* synthetic */ ScrollIsland a;

    public c(ScrollIsland r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a.c);
    }
}
