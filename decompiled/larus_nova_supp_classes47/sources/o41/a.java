package o41;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import cy0.c;
import cy0.f;
import dy0.d;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import o11.b;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, d {
    public b a;
    public final xq2.b b;
    public final f c;
    public final g d;

    /* JADX INFO: renamed from: o41.a$a, reason: collision with other inner class name */
    public static final class C0282a {
    }

    static {
    }

    public final void onStart() {
        jy0.b.d("LinkScopeProvideService", "onStart, create link scope");
        jy0.b.d("LinkScopeProvideService", "roomDataService = " + this.d.hashCode() + ", roomId = " + IRoomKtKt.getId(this.d.mo444getRoom()));
        c r0 = this.b.c0();
        if (r0 != null) goto L5;
        return;
    L5:
        f r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "instanceScope");
        String r2 = "linkDataScope";
        Intrinsics.checkNotNullParameter(r0, "linkDataScope");
        b r3 = new b(r1);
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r0, "value");
        r3.e = r0;
        Object r4 = k.a;
        if (r0 != r4) goto L9;
    L18:
        if (r2 != null) goto L22;
        l.a(r3);
        this.a = r3;
        return;
    L22:
        throw new UninitializedPropertyAccessException(r2);
    L9:
        if (r3.f != r4) goto L12;
        r2 = "revenueInstance";
        goto L18
    L12:
        if (r3.g != r4) goto L15;
        r2 = "revenueInstanceExt";
        goto L18
    L15:
        if (r3.h != r4) goto L17;
        r2 = "roomInstance";
        goto L18
    L17:
        r2 = null;
        goto L18
    }

    public final void onStop() {
        jy0.b.d("LinkScopeProvideService", "onStop, leave link scope");
        jy0.b.d("LinkScopeProvideService", "roomDataService = " + this.d.hashCode() + ", roomId = " + IRoomKtKt.getId(this.d.mo444getRoom()));
        this.a = null;
    }

    public a(xq2.b r2, f r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "revenueDataScopeProviderService");
        Intrinsics.checkNotNullParameter(r3, "instanceScope");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
