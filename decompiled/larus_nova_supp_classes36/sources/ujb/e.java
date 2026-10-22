package ujb;

import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends a {
    public final AnchorConfig d;
    public final MaskConfig e;
    public final String f;
    public final String g;
    public final boolean h;
    public final Function0<Unit> i;
    public final Integer j;
    public final Integer k;

    public e(AnchorConfig r2, String r3, String r4, boolean r5, Function0 r6, Integer r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r2, "anchorConfig");
        Intrinsics.checkNotNullParameter(r4, "detail");
        this.d = r2;
        this.e = null;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
    }
}
