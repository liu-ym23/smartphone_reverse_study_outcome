package so8;

import ib8.a0;
import ib8.y;
import ib8.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    public final Function1<j, Unit> a;
    public final Function1<j, Unit> b;
    public final Function0<Unit> c;
    public final Function1<j, Unit> d;

    public s(y r2, z r3, a0 r4, ib8.p r5) {
        Intrinsics.checkNotNullParameter(r2, "onZoomInAnimationStart");
        Intrinsics.checkNotNullParameter(r3, "onZoomOutAnimationEnd");
        Intrinsics.checkNotNullParameter(r4, "onZoomInUpdate");
        Intrinsics.checkNotNullParameter(r5, "onZoomInRefresh");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
