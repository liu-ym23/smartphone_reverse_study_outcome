package x11;

import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y11.f;
import y11.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements a, o {
    public final g a;
    public final y11.d b;
    public final y11.b c;
    public final f d;
    public final yz0.g e;
    public final com.bytedance.android.live.revlink.impl.global.c f;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final long a() {
        Long r0 = StringsKt.toLongOrNull(this.e.mo444getRoom().getIdStr());
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.longValue();
    }

    @Override // x11.a
    public final g Dn() {
        return this.a;
    }

    @Override // x11.a
    public final f G9() {
        return this.d;
    }

    @Override // x11.a
    /* JADX INFO: renamed from: do */
    public final y11.b mo1159do() {
        return this.c;
    }

    @Override // x11.a
    public final y11.d getPkService() {
        return this.b;
    }

    public d(yz0.g r3, com.bytedance.android.live.revlink.impl.global.c r4, PkScopeProviderService r5) {
        Intrinsics.checkNotNullParameter(r3, "revRoomDataService");
        Intrinsics.checkNotNullParameter(r4, "linkFakeGlobalService");
        this.e = r3;
        this.f = r4;
        a();
        this.a = new g(r4, this);
        this.b = new y11.d(a(), r4, r5);
        a();
        this.c = new y11.b(r4, this);
        a();
        this.d = new f(r4, this);
    }
}
