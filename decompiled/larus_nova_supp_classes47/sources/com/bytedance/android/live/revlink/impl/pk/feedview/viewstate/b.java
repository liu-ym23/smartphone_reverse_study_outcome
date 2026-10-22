package com.bytedance.android.live.revlink.impl.pk.feedview.viewstate;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.FeedBreakThroughBarState;
import com.bytedance.android.live.revlink.impl.pk.feedview.frame.ModeType;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkWindowManager;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.FeedBreakThroughBarWidget;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.s;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.v;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.IPreviewIMExtend;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.link.model.x2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qc0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements d {
    public FeedPkWindowManager a;
    public com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a b;
    public Long c;
    public ModeType d;
    public l e;
    public IBattleUserInfo f;
    public Integer g;
    public Integer h;
    public h3 i;
    public z31.d j;
    public aa k;
    public q11.a l;
    public String m;
    public m3 n;
    public n3 o;
    public List<? extends af2.b> p;
    public r q;
    public final MutableLiveData<pc0.d> r;
    public Long s;
    public zy0.b t;
    public boolean u;
    public Function0<Unit> v;

    public final IBaseBattleSetting b() {
        l r0 = this.e;
        if ((r0 instanceof l.c) == false) goto L12;
        if (r0 == null) goto L10;
        v r1 = ((l.c) r0).c;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.e;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L12:
        if ((r0 instanceof l.b) == false) goto L20;
        if (r0 == null) goto L19;
        s r2 = ((l.b) r0).c;
        if (r2 != null) goto L17;
        return null;
    L17:
        return r2.c;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L20:
        return null;
    }

    public final x2 c() {
        l r0 = this.e;
        if ((r0 instanceof l.c) == false) goto L12;
        if (r0 == null) goto L10;
        v r1 = ((l.c) r0).c;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.f;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L12:
        if ((r0 instanceof l.b) == false) goto L20;
        if (r0 == null) goto L19;
        s r2 = ((l.b) r0).c;
        if (r2 != null) goto L17;
        return null;
    L17:
        return r2.d;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L20:
        return null;
    }

    public final int d() {
        l r0 = this.e;
        Integer r2 = null;
        if ((r0 instanceof l.c) == false) goto L13;
        if (r0 == null) goto L11;
        v r1 = ((l.c) r0).c;
        if (r1 == null) goto L9;
        r2 = Integer.valueOf(r1.g);
    L9:
        return r2.intValue();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L13:
        if ((r0 instanceof l.b) == false) goto L22;
        if (r0 == null) goto L21;
        s r3 = ((l.b) r0).c;
        if (r3 == null) goto L19;
        r2 = Integer.valueOf(r3.e);
    L19:
        return r2.intValue();
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L22:
        return 0;
    }

    public final void e() {
        if (this.d != ModeType.BreakThough) goto L12;
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r0 = this.b;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.b;
    L8:
        FeedPkWindowManager r2 = this.a;
        if (r2 == null) goto L13;
        r2.h(r1);
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void g() {
        l r0 = this.e;
        ModeType r1 = this.d;
        aa r2 = this.k;
        Integer r3 = this.g;
        Integer r4 = this.h;
        q11.a r5 = this.l;
        z31.d r6 = this.j;
        Long r7 = this.c;
        IBattleUserInfo r8 = this.f;
        r r9 = this.q;
        if ((r0 instanceof l.c) == false) goto L10;
        if (r1 == null) goto L10;
        if (r3 == null) goto L10;
        FeedPkWindowManager r10 = this.a;
        if (r10 == null) goto L10;
        r10.f((l.c) r0, r1, r3.intValue());
    L10:
        if ((r0 instanceof l.b) == false) goto L17;
        if (r1 == null) goto L17;
        if (r3 == null) goto L17;
        FeedPkWindowManager r12 = this.a;
        if (r12 == null) goto L17;
        r12.e((l.b) r0, r1, r3.intValue());
    L17:
        if ((r0 instanceof l.a) == false) goto L21;
        FeedPkWindowManager r13 = this.a;
        if (r13 == null) goto L21;
        r13.d((l.a) r0, r4);
    L21:
        if (r5 == null) goto L25;
        FeedPkWindowManager r14 = this.a;
        if (r14 == null) goto L25;
        r14.l(r5);
    L25:
        if (r2 == null) goto L29;
        FeedPkWindowManager r15 = this.a;
        if (r15 == null) goto L29;
        r15.n(r2);
    L29:
        if (r9 == null) goto L33;
        FeedPkWindowManager r16 = this.a;
        if (r16 == null) goto L33;
        r16.j(r9);
    L33:
        FeedPkWindowManager r17 = this.a;
        if (r17 == null) goto L36;
        r17.m(r6);
    L36:
        if (r7 == null) goto L40;
        FeedPkWindowManager r18 = this.a;
        if (r18 == null) goto L40;
        r18.i(r7.longValue());
    L40:
        if (r8 == null) goto L44;
        FeedPkWindowManager r19 = this.a;
        if (r19 == null) goto L44;
        r19.k(r8);
    L44:
        FeedPkWindowManager r20 = this.a;
        if (r20 == null) goto L47;
        r20.b().c();
    L47:
        l r22 = this.e;
        if (r22 != null) goto L50;
    L60:
        IPreviewIMExtend.IMFeedPkViewState r23 = IPreviewIMExtend.IMFeedPkViewState.Other;
    L62:
        if ((r22 instanceof l.a) == false) goto L64;
        IPreviewIMExtend.IMFeedPkPlayMode r24 = IPreviewIMExtend.IMFeedPkPlayMode.CONNECTION;
    L106:
        MutableLiveData<pc0.d> r25 = this.r;
        Integer r26 = this.g;
        if (r26 == null) goto L109;
        int r27 = r26.intValue();
    L110:
        Integer r28 = Integer.valueOf(r23.ordinal());
        Integer r29 = Integer.valueOf(r24.ordinal());
        if (this.u == false) goto L113;
        int r30 = 1;
    L114:
        r25.setValue(new pc0.d(r27, r28, r29, 2131251763, r30));
        return;
    L113:
        r30 = 2;
        goto L114
    L109:
        r27 = 0;
        goto L110
    L64:
        aa r32 = this.k;
        if (r32 == null) goto L70;
        if (r32.getVoteType() == 0) goto L70;
        r24 = IPreviewIMExtend.IMFeedPkPlayMode.VOTE;
    L70:
        if (this.d != ModeType.BreakThough) goto L76;
        l r33 = this.e;
        if ((r33 instanceof l.c) == false) goto L74;
    L75:
        r24 = IPreviewIMExtend.IMFeedPkPlayMode.PVE;
        goto L106
    L74:
        if ((r33 instanceof l.a) == true) goto L75;
    L76:
        l r34 = this.e;
        w2 r35 = null;
        if ((r34 instanceof l.c) == false) goto L91;
        if (r34 == null) goto L90;
        v r36 = ((l.c) r34).c;
        if (r36 == null) goto L86;
        IBaseBattleSetting r37 = r36.e;
        if (r37 == null) goto L86;
        IBattleConfigSetting r38 = r37.getBattleConfigSetting();
        if (r38 == null) goto L86;
        w2 r39 = r38.getShellConfig();
    L87:
        if (r39 == null) goto L91;
        r24 = IPreviewIMExtend.IMFeedPkPlayMode.SHELLCONFIG;
    L86:
        r39 = null;
        goto L87
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L91:
        l r40 = this.e;
        if ((r40 instanceof l.b) == false) goto L105;
        if (r40 == null) goto L104;
        s r42 = ((l.b) r40).c;
        if (r42 == null) goto L101;
        IBaseBattleSetting r43 = r42.c;
        if (r43 == null) goto L101;
        IBattleConfigSetting r44 = r43.getBattleConfigSetting();
        if (r44 == null) goto L101;
        r35 = r44.getShellConfig();
    L101:
        if (r35 == null) goto L105;
        r24 = IPreviewIMExtend.IMFeedPkPlayMode.SHELLCONFIG;
        goto L106
    L104:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L105:
        r24 = IPreviewIMExtend.IMFeedPkPlayMode.PK;
        goto L106
    L50:
        if ((r22 instanceof l.c) == false) goto L53;
        r23 = IPreviewIMExtend.IMFeedPkViewState.PK;
    L59:
        if (r23 != null) goto L62;
    L53:
        if ((r22 instanceof l.b) == false) goto L56;
        r23 = IPreviewIMExtend.IMFeedPkViewState.PENAL;
        goto L59
    L56:
        if ((r22 instanceof l.a) == false) goto L58;
        r23 = IPreviewIMExtend.IMFeedPkViewState.LINK;
        goto L59
    L58:
        r23 = IPreviewIMExtend.IMFeedPkViewState.Other;
        goto L59
    }

    public b() {
        this.r = new MutableLiveData();
    }

    public final Function0<Unit> a() {
        return this.v;
    }

    public final void f(final int r12) {
        final Integer r7 = this.g;
        final h3 r6 = this.i;
        final m3 r3 = this.n;
        final n3 r4 = this.o;
        final List<? extends af2.b> r5 = this.p;
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r8 = this.b;
        if (r8 == null) goto L32;
        Function1<FeedBreakThroughBarState, Unit> r9 = new FeedPkViewState$onBreakThroughBarUpdate$1(this, r12, r3, r4, r5, r6, r7);
        Intrinsics.checkNotNullParameter(r9, "procedure");
        FeedBreakThroughBarState r13 = r8.d;
        if (r13 == null) goto L36;
        l r0 = r13.a;
        r9.invoke(r13);
        l r14 = r13.a;
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
        FeedBreakThroughBarWidget r15 = r8.h;
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
        FeedBreakThroughBarWidget.a r18 = r15.b;
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
