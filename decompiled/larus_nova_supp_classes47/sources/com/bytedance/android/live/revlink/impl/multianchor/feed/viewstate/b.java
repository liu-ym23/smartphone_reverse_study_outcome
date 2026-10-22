package com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough.FeedMultiBreakThroughBarManager;
import com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough.FeedMultiBreakThroughBarState;
import com.bytedance.android.live.revlink.impl.multianchor.feed.widget.FeedMultiBreakThroughBarWidget;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IPreviewIMExtend;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import java.util.List;
import k31.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public FeedMultiWindowManager a;
    public FeedMultiBreakThroughBarManager b;
    public x21.d c;
    public FeedMultiPlayMode d;
    public e e;
    public Integer f;
    public Integer g;
    public final MutableLiveData<pc0.d> h;
    public h3 i;
    public m3 j;
    public n3 k;
    public List<? extends af2.b> l;
    public Long m;
    public boolean n;
    public final Function0<Unit> o;

    public final void a() {
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        if (r0.a().R8() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        FeedMultiWindowManager r2 = this.a;
        if (r2 == null) goto L14;
        r2.c(null, true);
        return;
    L14:
        return;
    L5:
        if (r0.a().h7() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void b() {
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        if (r0.a().R8() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        if (this.d != FeedMultiPlayMode.BREAK_THROUGH) goto L20;
        FeedMultiBreakThroughBarManager r2 = this.b;
        if (r2 == null) goto L15;
        FrameLayout r3 = r2.b;
    L16:
        FeedMultiWindowManager r4 = this.a;
        if (r4 == null) goto L21;
        r4.c(r3, true);
        return;
    L21:
        return;
    L15:
        r3 = null;
        goto L16
    L20:
        return;
    L5:
        if (r0.a().h7() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void d() {
        Function0<Unit> r0 = this.o;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        x21.d r2 = this.c;
        boolean r3 = r2 instanceof x21.d.c;
        if (r3 == false) goto L9;
        IPreviewIMExtend.IMFeedPkViewState r4 = IPreviewIMExtend.IMFeedPkViewState.PK;
    L12:
        if (r3 == false) goto L20;
        if (r2 == null) goto L18;
        x21.h r5 = ((x21.d.c) r2).b;
        if (r5 == null) goto L27;
        IBaseBattleSetting r6 = r5.e;
    L28:
        if (r6 == null) goto L46;
        IBattleConfigSetting r7 = r6.getBattleConfigSetting();
        if (r7 == null) goto L46;
        if (r7.getVoteData() == null) goto L39;
        aa r8 = r7.getVoteData();
        if (r8 != null) goto L36;
    L37:
        IPreviewIMExtend.IMFeedPkPlayMode r9 = IPreviewIMExtend.IMFeedPkPlayMode.VOTE;
    L45:
        if (r9 == null) goto L46;
    L47:
        MutableLiveData<pc0.d> r10 = this.h;
        Integer r12 = this.g;
        if (r12 == null) goto L50;
        int r13 = r12.intValue();
    L51:
        Integer r14 = Integer.valueOf(r4.ordinal());
        Integer r15 = Integer.valueOf(r9.ordinal());
        if (this.n == false) goto L54;
        int r16 = 1;
    L55:
        r10.setValue(new pc0.d(r13, r14, r15, 2131251763, r16));
        return;
    L54:
        r16 = 2;
        goto L55
    L50:
        r13 = 0;
        goto L51
    L36:
        if (r8.getVoteType() != 0) goto L37;
    L39:
        if (r7.getShellConfig() == null) goto L42;
        r9 = IPreviewIMExtend.IMFeedPkPlayMode.SHELLCONFIG;
        goto L45
    L42:
        if (r7.getBreakthroughConfig() == null) goto L44;
        r9 = IPreviewIMExtend.IMFeedPkPlayMode.PVE;
        goto L45
    L44:
        r9 = IPreviewIMExtend.IMFeedPkPlayMode.PK;
    L46:
        r9 = IPreviewIMExtend.IMFeedPkPlayMode.CONNECTION;
    L27:
        r6 = null;
        goto L28
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.multianchor.feed.machine.state.FeedMultiState.PK");
    L20:
        if ((r2 instanceof x21.d.b) == false) goto L27;
        if (r2 == null) goto L26;
        x21.g r17 = ((x21.d.b) r2).b;
        if (r17 == null) goto L27;
        r6 = r17.c;
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.multianchor.feed.machine.state.FeedMultiState.PENAL");
    L9:
        if ((r2 instanceof x21.d.b) == false) goto L11;
        r4 = IPreviewIMExtend.IMFeedPkViewState.PENAL;
        goto L12
    L11:
        r4 = IPreviewIMExtend.IMFeedPkViewState.LINK;
        goto L12
    }

    public b(Function0 r3) {
        this.o = r3;
        this.h = new MutableLiveData();
        Intrinsics.checkNotNullParameter(n.c, "$this$default");
        y.f(new n(com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.a().s6(), 0));
    }

    public final void c(final int r12) {
        final Integer r7 = this.g;
        final h3 r6 = this.i;
        final m3 r3 = this.j;
        final n3 r4 = this.k;
        final List<? extends af2.b> r5 = this.l;
        FeedMultiBreakThroughBarManager r8 = this.b;
        if (r8 == null) goto L32;
        Function1<FeedMultiBreakThroughBarState, Unit> r9 = new FeedMultiViewState$onBreakThroughBarUpdate$1(this, r12, r3, r4, r5, r6, r7);
        Intrinsics.checkNotNullParameter(r9, "procedure");
        FeedMultiBreakThroughBarState r13 = r8.d;
        if (r13 == null) goto L36;
        x21.d r0 = r13.a;
        r9.invoke(r13);
        x21.d r14 = r13.a;
        String r1 = null;
        if (r0 == null) goto L10;
        String r2 = r0.a;
    L11:
        if (r14 == null) goto L14;
        r1 = r14.a;
    L14:
        if (Intrinsics.areEqual(r2, r1) == false) goto L17;
        return;
    L17:
        if (r8.g == false) goto L33;
        FeedMultiBreakThroughBarWidget r15 = r8.h;
        if (r15 == null) goto L34;
        ViewGroup r10 = r15.a;
        if (r10 == null) goto L23;
        r10.removeAllViews();
    L23:
        zy0.b r16 = r15.c;
        if (r16 == null) goto L28;
        xy0.a<?> r17 = r16.g();
        if (r17 == null) goto L28;
        r17.load();
    L28:
        FeedMultiBreakThroughBarWidget.a r18 = r15.b;
        if (r18 == null) goto L35;
        r18.a();
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L10:
        r2 = null;
        goto L11
    L36:
        return;
    }
}
