package w21;

import android.content.Context;
import android.widget.FrameLayout;
import b31.d;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final d a;
    public IMProgressBarLayout b;
    public final Context c;
    public final FrameLayout d;

    public a(Context r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.c = r2;
        this.d = r3;
        this.a = new d();
    }
}
