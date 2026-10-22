package sr9;

import android.content.Context;
import android.view.View;
import com.larus.common_ui.video.progress.PlayerProgressView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 implements qs8.a {
    public final View a;

    public final void I4(boolean r1) {
    }

    public final void J1(float r1, boolean r2) {
    }

    public final void d5(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
    }

    public final void h3() {
    }

    public final void setProgressViewVisibility(boolean r1) {
    }

    public final void z1(Function1<? super PlayerProgressView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    public final View asView() {
        return this.a;
    }

    public c0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new View(r2);
    }
}
