package com.bytedance.android.live.revlink.impl.pk.feedview.layout;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revlink.impl.pk.feedview.frame.ModeType;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import z31.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedPkWindowManager implements c {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public final Lazy h;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.sei.c i;
    public final boolean j;
    public final boolean k;

    public final z31.b b() {
        return (z31.b) this.h.getValue();
    }

    public final a c() {
        return (a) this.a.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.layout.c
    public final boolean a() {
        Boolean r0 = b().b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final void g(final pc0.a r3) {
        this.i.b(r3);
        b().b(new FeedPkWindowManager$onSeiUpdated$1(r3));
    }

    public final void h(View r3) {
        a41.a r0 = (a41.a) this.c.getValue();
        r0.getClass();
        if (t41.a.m.b() == true) goto L6;
        return;
    L6:
        if (PadConfigUtils.a() == false) goto L8;
        return;
    L8:
        if (FoldScreenUtils.f() == true) goto L32;
        if (r3 != null) goto L17;
        FrameLayout r4 = r0.a;
        if (r4 == null) goto L14;
        r4.removeAllViews();
    L14:
        FrameLayout r5 = r0.a;
        if (r5 == null) goto L28;
        r5.setVisibility(8);
        return;
    L28:
        return;
    L17:
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L20;
        r1.removeAllViews();
    L20:
        FrameLayout r2 = r0.a;
        if (r2 == null) goto L23;
        r2.addView(r3);
    L23:
        FrameLayout r6 = r0.a;
        if (r6 == null) goto L30;
        r6.setVisibility(0);
        return;
    L30:
        return;
    }

    public final void i(final long r3) {
        b().b(new FeedPkWindowManager$updateBackgroundSkin$1(r3));
    }

    public final void j(final r r3) {
        Intrinsics.checkNotNullParameter(r3, "effectInfo");
        b().b(new FeedPkWindowManager$updateBattlePropCardInfoData$1(r3));
    }

    public final void k(final IBattleUserInfo r3) {
        b().b(new FeedPkWindowManager$updateGuestInfo$1(r3));
    }

    public final void l(final q11.a r3) {
        Intrinsics.checkNotNullParameter(r3, "pkResult");
        b().b(new FeedPkWindowManager$updatePkResult$1(r3));
    }

    public final void m(final d r3) {
        b().b(new FeedPkWindowManager$updateScore$1(r3));
    }

    public final void n(final aa r3) {
        Intrinsics.checkNotNullParameter(r3, "voteData");
        b().b(new FeedPkWindowManager$updateVoteData$1(r3));
    }

    public final void d(final l.a r3, final Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        b().b(new FeedPkWindowManager$layoutAsLink$1(r3, r4));
    }

    public final void e(final l.b r3, final ModeType r4, final int r5) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        b().b(new FeedPkWindowManager$layoutAsPenal$1(r3, r5, r4));
    }

    public final void f(final l.c r3, final ModeType r4, final int r5) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        b().b(new FeedPkWindowManager$layoutAsPk$1(r3, r5, r4));
    }

    public FeedPkWindowManager(final FrameLayout r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.j = r3;
        this.k = r4;
        this.a = LazyKt.lazy(new FeedPkWindowManager$inflate$2(r2));
        this.b = LazyKt.lazy(new FeedPkWindowManager$skeleton$2(this));
        this.c = LazyKt.lazy(new FeedPkWindowManager$breakThroughBar$2(this));
        this.d = LazyKt.lazy(new FeedPkWindowManager$background$2(this));
        this.e = LazyKt.lazy(new FeedPkWindowManager$imBar$2(this));
        this.g = true;
        this.h = LazyKt.lazy(new FeedPkWindowManager$frame$2(this, r2));
        this.i = new com.bytedance.android.live.revlink.impl.pk.feedview.sei.c(b(), r5);
    }
}
