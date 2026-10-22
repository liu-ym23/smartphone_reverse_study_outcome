package s51;

import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.core.service.q;
import com.bytedance.android.live.revlink.link.domain.mic.component.FollowComponent;
import com.bytedance.android.live.revlink.link.domain.mic.component.KickOutComponent;
import com.bytedance.android.live.revlink.link.domain.mic.component.e;
import com.bytedance.android.live.revlink.link.domain.mic.component.f;
import com.bytedance.android.live.revlink.link.domain.mic.component.l;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements b, f, e {
    public q a;
    public final List<a> b;
    public final g c;
    public final String d;
    public final String e;
    public final AnchorLinkUserCenterV2 f;
    public final i g;
    public final n h;
    public final l i;
    public final FollowComponent j;
    public final KickOutComponent k;

    @Override // com.bytedance.android.live.revlink.link.domain.mic.component.e
    public final int g() {
        return this.j.g();
    }

    @Override // s51.b
    public final boolean a() {
        return Intrinsics.areEqual(this.d, this.c.d.k);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.mic.component.f
    public final NextLiveData<Boolean> b() {
        return this.i.b;
    }

    @Override // s51.b
    public final boolean e() {
        return Intrinsics.areEqual(this.d, this.c.d.n);
    }

    @Override // s51.b
    public final String f() {
        p r0 = this.f.getGuestInfo(this.d, null);
        if (r0 == null) goto L7;
        String r1 = r0.getInteractId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.e;
    }

    @Override // s51.b
    public final String c() {
        return this.e;
    }

    @Override // s51.b
    public final q d() {
        return this.a;
    }

    @Override // s51.b
    public final String getUid() {
        return this.d;
    }

    public c(q r8, g r9, String r10, String r12, String r13, AnchorLinkUserCenterV2 r14, i r15, n r16) {
        l r6 = new l(r9, r10, r13, r14, r15);
        FollowComponent r0 = new FollowComponent(r10, r9);
        KickOutComponent r1 = new KickOutComponent(r10, r12, r16, r9);
        com.bytedance.android.live.revlink.link.domain.mic.component.g r2 = new com.bytedance.android.live.revlink.link.domain.mic.component.g(r10, r14, r9);
        Intrinsics.checkNotNullParameter(r8, "initLayoutState");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "uid");
        Intrinsics.checkNotNullParameter(r12, "secUID");
        Intrinsics.checkNotNullParameter(r13, "linkerID");
        Intrinsics.checkNotNullParameter(r14, "userCenter");
        Intrinsics.checkNotNullParameter(r16, "linkOutManager");
        Intrinsics.checkNotNullParameter(r6, "muteComponent");
        Intrinsics.checkNotNullParameter(r0, "followComponent");
        Intrinsics.checkNotNullParameter(r1, "kickOutComponent");
        Intrinsics.checkNotNullParameter(r2, "layoutComponent");
        this.c = r9;
        this.d = r10;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r6;
        this.j = r0;
        this.k = r1;
        this.a = r8;
        this.b = CollectionsKt.listOf(new a[]{r6, r0, r1, r2});
    }
}
