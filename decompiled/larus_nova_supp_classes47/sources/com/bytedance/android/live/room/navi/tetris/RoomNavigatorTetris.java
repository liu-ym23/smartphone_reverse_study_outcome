package com.bytedance.android.live.room.navi.tetris;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.IAudienceRankService;
import com.bytedance.android.live.room.api.rank.IAudienceRankType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/RoomNavigatorTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lo70/a;", "Lp70/d;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomNavigatorTetris extends LiveTetris<d90.d> implements o70.a, p70.d {
    public ViewGroup o;
    public ViewGroup p;
    public ViewGroup q;
    public ImageView r;
    public DataCenter s;
    public View t;
    public final Lazy u;

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{bh1.b.class, bh1.a.class, m0.class});
    }

    public final Set<p70.c<?>> ud() {
        return SetsKt.setOf((RoomNavigatorTetris$fullInterceptProcessor$2.a) this.u.getValue());
    }

    public RoomNavigatorTetris() {
        this.u = LazyKt.lazy(new RoomNavigatorTetris$fullInterceptProcessor$2(this));
    }

    public final void V(h70.b r8) {
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        ViewGroup r3 = this.p;
        if (r3 != null) goto L5;
        return;
    L5:
        if (d90.e.i(K()) == false) goto L7;
        Class<? extends LiveRecyclableWidget> r9 = ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).getVSRoomRankWidget();
    L8:
        Class<? extends LiveRecyclableWidget> r2 = r9;
        if (r2 == null) goto L13;
        LiveTetris.Q(this, r2, r3, true, null, 16);
        return;
    L13:
        return;
    L7:
        ALogger.i("RoomNavigatorTetris", "LiveRoomAudienceWidget load...");
        r9 = ((IAudienceRankService) jc1.k.n(IAudienceRankService.class)).getAudienceRankWidget(IAudienceRankType.LIVE_PORTRAIT_RANK_WIDGET);
        goto L8
    }

    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof bh1.b) == false) goto L16;
        int r4 = ((bh1.b) r3).a;
        ImageView r0 = this.r;
        if (r0 == null) goto L7;
        r0.setTranslationY(r4);
    L7:
        View r1 = this.t;
        if (r1 == null) goto L11;
        r1.setTranslationY(r4);
    L11:
        if (d90.e.i(K()) == false) goto L38;
        ViewGroup r2 = this.p;
        if (r2 == null) goto L39;
        r2.setTranslationY(r4);
        return;
    L39:
        return;
    L38:
        return;
    L16:
        if ((r3 instanceof bh1.a) == false) goto L41;
        bh1.a r5 = (bh1.a) r3;
        boolean r6 = r5.a;
        boolean r7 = r5.b;
        if (r6 == false) goto L20;
        int r8 = 4;
    L21:
        ViewGroup r9 = this.o;
        if (r9 == null) goto L24;
        r9.setVisibility(r8);
    L24:
        ViewGroup r10 = this.p;
        if (r10 == null) goto L27;
        r10.setVisibility(r8);
    L27:
        ViewGroup r12 = this.q;
        if (r12 == null) goto L30;
        r12.setVisibility(r8);
    L30:
        View r13 = this.t;
        if (r13 == null) goto L33;
        r13.setVisibility(r8);
    L33:
        if (r7 == true) goto L42;
        ImageView r14 = this.r;
        if (r14 == null) goto L43;
        r14.setVisibility(r8);
        return;
    L43:
        return;
    L42:
        return;
    L20:
        r8 = 0;
        goto L21
    }
}
