package xib;

import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final c a;
    public final f b;
    public final g c;

    public b(RecentForwardAdapterV3.b r2, RecentForwardAdapterV3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r3, "onItemBusinessConsumeClickListener");
        this.a = new c(r2, r3);
        this.b = new f(r2, r3);
        this.c = new g(r2, r3);
    }
}
