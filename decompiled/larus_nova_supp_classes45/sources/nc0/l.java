package nc0;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc0.t;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements lc0.b {
    public final kc0.m a;

    @Override // lc0.b
    public final kc0.l b() {
        return this.a.b();
    }

    @Override // lc0.b
    public final boolean blockDigg() {
        return this.a.blockDigg();
    }

    @Override // lc0.b
    public final kc0.p c() {
        return this.a.c();
    }

    @Override // lc0.b
    public final List<AnchorLinkUser> d() {
        List<com.bytedance.android.livesdk.link.model.bridge.k> r0 = this.a.d();
        if (r0 == null) goto L12;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        AnchorLinkUser r4 = k.a((com.bytedance.android.livesdk.link.model.bridge.k) r3.next());
        if (r4 == null) goto L11;
        r2.add(r4);
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L16:
        return r2;
    L12:
        return null;
    }

    @Override // lc0.b
    public final t e() {
        return this.a.e();
    }

    @Override // lc0.b
    public final int g() {
        return this.a.g();
    }

    @Override // lc0.b
    public final kc0.n i() {
        return this.a.i();
    }

    @Override // lc0.b
    public final List<AnchorLinkUser> j() {
        List<com.bytedance.android.livesdk.link.model.bridge.k> r0 = this.a.j();
        if (r0 == null) goto L12;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        AnchorLinkUser r4 = k.a((com.bytedance.android.livesdk.link.model.bridge.k) r3.next());
        if (r4 == null) goto L11;
        r2.add(r4);
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L16:
        return r2;
    L12:
        return null;
    }

    public l(kc0.m r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    @Override // lc0.b
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.a.a(r2);
    }
}
