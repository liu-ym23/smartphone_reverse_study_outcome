package ujb;

import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends a {
    public final AnchorConfig d;
    public final MaskConfig e;
    public final String f;
    public final String g;
    public final d h;
    public final d i;

    public c(AnchorConfig r2, MaskConfig r3, String r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "anchorConfig");
        Intrinsics.checkNotNullParameter(r3, "maskConfig");
        Intrinsics.checkNotNullParameter(r4, "detail");
        Intrinsics.checkNotNullParameter(r5, "rightButton");
        this.d = r2;
        this.e = r3;
        this.f = null;
        this.g = r4;
        this.h = null;
        this.i = r5;
    }
}
