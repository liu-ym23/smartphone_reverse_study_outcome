package com.bytedance.android.live.profit.vote.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.StateBuffer;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.profit.vote.model.VoteConfig;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteIconModel extends com.bytedance.android.live.revenue.common.a<com.bytedance.android.live.profit.vote.model.b> implements o {
    public d f;
    public b g;
    public final c h;
    public final VoteViewModel i;
    public final VotePanelHandler j;
    public final c01.a k;
    public final yz0.k l;
    public final com.bytedance.android.live.profit.vote.f m;

    public static final class a {
    }

    public final class b {
        public final ViewGroup a;
        public final TextView b;
        public final TextView c;
        public final HSImageView d;
        public final HSImageView e;
        public final TextView f;

        public b(VoteIconModel r2) {
            View r3 = r2.inflateEntryView(2131567925).a;
            if (r3 == null) goto L7;
            ViewGroup r4 = (ViewGroup) r3;
            this.a = r4;
            this.b = (TextView) r4.findViewById(2131390859);
            this.c = (TextView) r4.findViewById(2131391315);
            this.d = r4.findViewById(2131376352);
            this.e = r4.findViewById(2131376563);
            this.f = (TextView) r4.findViewById(2131390410);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final class c {
        public final /* synthetic */ VoteIconModel a;

        public final void a() {
            VoteIconModel r0 = this.a;
            b r1 = r0.g;
            d r2 = r0.f;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.q == true) goto L10;
            r2.q = true;
            AnimatorSet r3 = new AnimatorSet();
            r3.playTogether(new Animator[]{ObjectAnimator.ofFloat(r2.c, "scaleY", new float[]{1.0f}), ObjectAnimator.ofFloat(r2.d, "scaleY", new float[]{1.0f})});
            r3.setDuration(300);
            r3.setInterpolator(new DecelerateInterpolator());
            r3.start();
            return;
        }

        public c(VoteIconModel r1) {
            this.a = r1;
        }

        public final void b(boolean r4) {
            VoteIconModel r0 = this.a;
            b r1 = r0.g;
            d r2 = r0.f;
            if (r2 == null) goto L8;
            if (r4 == false) goto L6;
            r2.i.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse("asset://com.ss.android.ies.live.sdk/vote_time.webp")).setControllerListener(com.bytedance.android.live.profit.util.c.a()).build());
            r2.e.setVisibility(8);
            r2.a().setText("");
            return;
        L6:
            r2.i.setController(null);
            r2.e.setVisibility(0);
            return;
        }

        public final void c(com.bytedance.android.live.profit.vote.b r8) {
            Intrinsics.checkNotNullParameter(r8, "vote");
            b r1 = this.a.g;
            if (r1 == null) goto L15;
            Intrinsics.checkNotNullParameter(r8, "vote");
            List r2 = CollectionsKt.take((Iterable) r8.getItems().d, 2);
            if (r2.size() != 2) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == true) goto L11;
            r2 = null;
        L11:
            if (r2 == null) goto L15;
            com.bytedance.android.live.profit.vote.g r4 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r2, 0);
            com.bytedance.android.live.profit.vote.g r5 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r2, 1);
            r1.b.setText(VoteUtilsKt.f(r4));
            r1.c.setText(VoteUtilsKt.f(r5));
            ImageUtil.loadImage(r1.d, r4.e, 0);
            ImageUtil.loadImage(r1.e, r5.e, 0);
            goto L15
        L7:
            r3 = false;
        L15:
            if (this.a.f == null) goto L18;
            Intrinsics.checkNotNullParameter(r8, "vote");
            return;
        }
    }

    public final class d {
        public final xr2.b a;
        public final Guideline b;
        public final View c;
        public final View d;
        public final Group e;
        public final TextView f;
        public final TextView g;
        public final Guideline h;
        public final HSImageView i;
        public final Guideline j;
        public final Group k;
        public final HSImageView l;
        public final View m;
        public final Group n;
        public final HSImageView o;
        public final View p;
        public boolean q;
        public final CompositeDisposable r;
        public float s;
        public boolean t;
        public final /* synthetic */ VoteIconModel u;

        public final TextView a() {
            if (this.t == false) goto L6;
            return this.f;
        L6:
            return this.g;
        }

        public d(VoteIconModel r5) {
            this.u = r5;
            xr2.b r6 = r5.createIconTemplate(xr2.b.class);
            this.a = r6;
            this.r = new CompositeDisposable();
            this.s = 0.5f;
            this.t = true;
            View r0 = r6.inflateContentView(2131567924);
            this.b = r0.findViewById(2131392790);
            this.c = r0.findViewById(2131377723);
            this.d = r0.findViewById(2131384542);
            Group r1 = r0.findViewById(2131374758);
            this.e = r1;
            this.f = (TextView) r0.findViewById(2131391698);
            this.g = (TextView) r0.findViewById(2131391699);
            this.h = r0.findViewById(2131392813);
            r1.setReferencedIds(new int[]{2131391698, 2131391699});
            this.i = r0.findViewById(2131376150);
            this.j = r0.findViewById(2131392817);
            Group r2 = r0.findViewById(2131377826);
            this.k = r2;
            this.l = r0.findViewById(2131376353);
            this.m = r0.findViewById(2131377809);
            r2.setReferencedIds(new int[]{2131377809, 2131376353});
            Group r3 = r0.findViewById(2131384644);
            this.n = r3;
            this.o = r0.findViewById(2131376565);
            this.p = r0.findViewById(2131384625);
            r3.setReferencedIds(new int[]{2131384625, 2131376565});
            Unit r4 = Unit.INSTANCE;
            r6.setContentView(r0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VoteIconModel a;
        public final /* synthetic */ com.bytedance.android.live.profit.vote.b b;

        public e(VoteIconModel r1, com.bytedance.android.live.profit.vote.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            this.a.j(this.b);
        }
    }

    static {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        int r0 = StateBuffer.d;
        StateBuffer r1 = StateBuffer.Companion.a(new VoteIconModel$onCreate$stateBuffer$1(this));
        final VoteIconModel$onCreate$1 r2 = new VoteIconModel$onCreate$1(this);
        bindModel(r1.subscribe(new f(r2)));
        PropertyOwnersKt.c(this.i.e).subscribe(r1);
    }

    public final void i() {
        if (this.l.isAnchor() == false) goto L5;
        n r0 = new n();
        m r1 = new m();
        r1.b(LogCommon.ROOM);
        r1.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r2 = r0.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r1.a);
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r5 = com.bytedance.android.scope.m.b(r4).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r5);
        ((mz0.i) ((f80.a) r5)).w3("livesdk_anchorcheck_click", r0.a, r0.b);
    L6:
        VotePanelHandler r6 = this.j;
        int r7 = VotePanelHandler.f;
        r6.a(null);
        return;
    L5:
        Map<? extends String, ? extends String> r8 = MapsKt.mapOf(TuplesKt.to("user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString()));
        n r9 = new n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r10.putAll(r8);
        m r12 = new m();
        r12.b(LogCommon.ROOM);
        r12.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r13 = r9.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_audiencecheck_click", r9.a, r9.b);
        goto L6
    }

    public final void onStart() {
        this.k.D9(VoteIconModel.class, new AnonymousClass1(this));
    }

    public final void onClick() {
        i();
    }

    public final xr2.h getViewForState(Object r2) {
        com.bytedance.android.live.profit.vote.model.b r3 = (com.bytedance.android.live.profit.vote.model.b) r2;
        Intrinsics.checkNotNullParameter(r3, "state");
        if (Intrinsics.areEqual(r3, com.bytedance.android.live.profit.vote.model.b.c.a) == false) goto L6;
        this.f = null;
        return null;
    L6:
        if (this.f != null) goto L8;
        this.f = new d(this);
    L8:
        d r4 = this.f;
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.a;
    }

    public final void h(com.bytedance.android.live.profit.vote.b r3) {
        bindState(PropertyOwnersKt.c(r3.getItems()).subscribe(new e(this, r3)));
    }

    public final void j(com.bytedance.android.live.profit.vote.b r18) {
        Object r1 = r18.getItems().d;
        if (((List) r1).size() < 2) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        List r3 = (List) r1;
        if (r3 == null) goto L134;
        com.bytedance.android.live.profit.vote.g r4 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r3, 0);
        com.bytedance.android.live.profit.vote.g r5 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r3, 1);
        c r8 = this.h;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r18, "vote");
        Intrinsics.checkNotNullParameter(r4, "left");
        Intrinsics.checkNotNullParameter(r5, "right");
        if (r8.a.g == null) goto L15;
        Intrinsics.checkNotNullParameter(r18, "vote");
        Intrinsics.checkNotNullParameter(r4, "left");
        Intrinsics.checkNotNullParameter(r5, "right");
    L15:
        d r9 = r8.a.f;
        if (r9 == null) goto L140;
        Intrinsics.checkNotNullParameter(r18, "vote");
        Intrinsics.checkNotNullParameter(r4, "left");
        Intrinsics.checkNotNullParameter(r5, "right");
        r9.r.clear();
        long r10 = r4.a;
        long r6 = r5.a;
        if (r10 != r6) goto L21;
        float r7 = 0.5f;
    L27:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{r9.s, RangesKt.coerceIn(r7, 0.2f, 0.8f)});
        r12.setDuration(200);
        r12.addUpdateListener(new com.bytedance.android.live.profit.vote.ui.a(r9));
        CompositeDisposable r13 = r9.r;
        Intrinsics.checkNotNullParameter(r12, "$this$bind");
        Intrinsics.checkNotNullParameter(r13, "cd");
        RxUtilKt.c(RxUtilKt.a(r12, false), r13);
        r12.start();
        if ((r9.u.getCurrentState() instanceof com.bytedance.android.live.profit.vote.model.b.e) == false) goto L30;
        String r0 = r9.u.getContext().getString(2131923233);
    L127:
        if ((!Intrinsics.areEqual(r0, r9.a().getText().toString())) == false) goto L141;
        r9.t = !r9.t;
        r9.a().setText(r0);
        AnimatorSet r14 = new AnimatorSet();
        if (r9.t == true) goto L131;
        TextView r15 = r9.f;
    L132:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{0.0f}).setDuration(67);
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r9.a(), "alpha", new float[]{1.0f}).setDuration(67);
        r17.setStartDelay(33);
        r14.playTogether(new Animator[]{r16, r17});
        CompositeDisposable r19 = r9.r;
        Intrinsics.checkNotNullParameter(r14, "$this$bind");
        Intrinsics.checkNotNullParameter(r19, "cd");
        RxUtilKt.c(RxUtilKt.a(r14, false), r19);
        r14.start();
        return;
    L131:
        r15 = r9.g;
        goto L132
    L141:
        return;
    L30:
        int r20 = com.bytedance.android.live.profit.vote.ui.e.a;
        Context r22 = r9.u.getContext();
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r18, "vote");
        Object r23 = r18.getItems().d;
        if (((List) r23).size() < 2) goto L33;
        boolean r24 = true;
    L34:
        if (r24 == true) goto L37;
        r23 = null;
    L37:
        List r25 = (List) r23;
        if (r25 != null) goto L40;
        r0 = "";
    L109:
        int r26 = r0.codePointCount(0, r0.length());
        if (r26 != 4) goto L127;
        Sequence r27 = SequencesKt.sequence(new VoteTextMapper$getComposedVoteText$seq$1(r26, r0, null));
        Iterator r28 = r27.iterator();
    L113:
        if (r28.hasNext() == false) goto L123;
        int r29 = ((Number) r28.next()).intValue();
        if (19968 <= r29) goto L118;
    L120:
        boolean r30 = false;
    L121:
        if (r30 == true) goto L113;
        boolean r32 = false;
    L124:
        if (r32 == false) goto L127;
        int[] r33 = CollectionsKt.toIntArray(SequencesKt.toList(SequencesKt.plus(SequencesKt.plus(SequencesKt.take(r27, 2), 10), SequencesKt.drop(r27, 2))));
        r0 = new String(r33, 0, r33.length);
        goto L127
    L118:
        if (40869 < r29) goto L120;
        r30 = true;
        goto L121
    L123:
        r32 = true;
        goto L124
    L40:
        com.bytedance.android.live.profit.vote.g r34 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r25, 0);
        com.bytedance.android.live.profit.vote.g r35 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r25, 1);
        if (((VoteState) r18.getState().d) != VoteState.FINISHED) goto L74;
        if (VoteUtilsKt.h(r18) == true) goto L45;
        int r36 = com.bytedance.android.live.profit.vote.ui.d.c[VoteUtilsKt.a(r34, r35).ordinal()];
        if (r36 == 1) goto L72;
        if (r36 == 2) goto L71;
        if (r36 != 3) goto L70;
        r0 = r22.getString(2131923234);
        goto L109
    L70:
        throw new NoWhenBranchMatchedException();
    L71:
        r0 = VoteUtilsKt.f(r35);
        goto L109
    L72:
        r0 = VoteUtilsKt.f(r34);
        goto L109
    L45:
        if (VoteConfig.c() != VoteConfig.Plan.C) goto L55;
        int r37 = com.bytedance.android.live.profit.vote.ui.d.a[VoteUtilsKt.a(r34, r35).ordinal()];
        if (r37 == 1) goto L54;
        if (r37 == 2) goto L53;
        if (r37 != 3) goto L52;
        r0 = r22.getString(2131923234);
        goto L109
    L52:
        throw new NoWhenBranchMatchedException();
    L53:
        r0 = r22.getString(2131923238);
        goto L109
    L54:
        r0 = r22.getString(2131923237);
        goto L109
    L55:
        int r38 = com.bytedance.android.live.profit.vote.ui.d.b[VoteUtilsKt.a(r34, r35).ordinal()];
        if (r38 == 1) goto L63;
        if (r38 == 2) goto L62;
        if (r38 != 3) goto L61;
        r0 = r22.getString(2131923234);
        goto L109
    L61:
        throw new NoWhenBranchMatchedException();
    L62:
        r0 = r22.getString(2131923236);
        goto L109
    L63:
        r0 = r22.getString(2131923235);
        goto L109
    L74:
        if (VoteUtilsKt.h(r18) == false) goto L100;
        int r39 = com.bytedance.android.live.profit.vote.ui.d.f[VoteConfig.c().ordinal()];
        if (r39 == 1) goto L91;
        if (r39 == 2) goto L82;
        if (r39 != 3) goto L81;
        r0 = r22.getString(2131923244);
        goto L109
    L81:
        throw new NoWhenBranchMatchedException();
    L82:
        int r40 = com.bytedance.android.live.profit.vote.ui.d.e[VoteUtilsKt.a(r34, r35).ordinal()];
        if (r40 == 1) goto L90;
        if (r40 == 2) goto L89;
        if (r40 != 3) goto L88;
        r0 = r22.getString(2131923239);
        goto L109
    L88:
        throw new NoWhenBranchMatchedException();
    L89:
        r0 = r22.getString(2131923243);
        goto L109
    L90:
        r0 = r22.getString(2131923242);
        goto L109
    L91:
        int r42 = com.bytedance.android.live.profit.vote.ui.d.d[VoteUtilsKt.a(r34, r35).ordinal()];
        if (r42 == 1) goto L99;
        if (r42 == 2) goto L98;
        if (r42 != 3) goto L97;
        r0 = r22.getString(2131923239);
        goto L109
    L97:
        throw new NoWhenBranchMatchedException();
    L98:
        r0 = r22.getString(2131923241);
        goto L109
    L99:
        r0 = r22.getString(2131923240);
        goto L109
    L100:
        int r43 = com.bytedance.android.live.profit.vote.ui.d.g[VoteUtilsKt.a(r34, r35).ordinal()];
        if (r43 == 1) goto L108;
        if (r43 == 2) goto L107;
        if (r43 != 3) goto L106;
        r0 = r22.getString(2131923239);
        goto L109
    L106:
        throw new NoWhenBranchMatchedException();
    L107:
        r0 = VoteUtilsKt.f(r35);
        goto L109
    L108:
        r0 = VoteUtilsKt.f(r34);
        goto L109
    L33:
        r24 = false;
        goto L34
    L21:
        if (r10 > 0) goto L24;
        r7 = 0.0f;
        goto L27
    L24:
        if (r6 > 0) goto L26;
        r7 = 1.0f;
        goto L27
    L26:
        r7 = r10 / (r10 + r6);
        goto L27
    L140:
        return;
    L134:
        return;
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void a(IRevIconModel.a r2, IRevIconModel.EntryEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "entryView");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != IRevIconModel.EntryEvent.End) goto L5;
    L6:
        this.h.a();
        this.g = null;
        return;
    L5:
        if (r3 == IRevIconModel.EntryEvent.Skip) goto L6;
    }

    public final IRevIconModel.a getEntryViewForState(Object r5, Object r6) {
        com.bytedance.android.live.profit.vote.model.b r7 = (com.bytedance.android.live.profit.vote.model.b) r5;
        com.bytedance.android.live.profit.vote.model.b r8 = (com.bytedance.android.live.profit.vote.model.b) r6;
        Intrinsics.checkNotNullParameter(r7, "state");
        if ((r7 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L12;
        if (r8 == null) goto L10;
        com.bytedance.android.live.profit.vote.b r9 = r8.a();
        if (r9 == null) goto L10;
        if (r9.getVoteId() == ((com.bytedance.android.live.profit.vote.model.b.d) r7).a.getVoteId()) goto L12;
    L10:
        if (((com.bytedance.android.live.profit.vote.model.b.d) r7).a.a() < 5000) goto L12;
        b r10 = new b(this);
        this.g = r10;
        r10.a.setOnClickListener(new com.bytedance.android.live.profit.vote.ui.c(this));
        return new IRevIconModel.a(r10.a, 5000, 4);
    L12:
        this.g = null;
        return null;
    }

    public final void c(Object r18, Object r19, xr2.h r20) {
        com.bytedance.android.live.profit.vote.model.b r1 = (com.bytedance.android.live.profit.vote.model.b) r18;
        com.bytedance.android.live.profit.vote.model.b r2 = (com.bytedance.android.live.profit.vote.model.b) r19;
        Intrinsics.checkNotNullParameter(r2, "curState");
        if (r1 == null) goto L7;
        com.bytedance.android.live.profit.vote.b r4 = r1.a();
        if (r4 == null) goto L7;
        Long r5 = Long.valueOf(r4.getVoteId());
    L8:
        com.bytedance.android.live.profit.vote.b r6 = r2.a();
        if (r6 == null) goto L11;
        Long r7 = Long.valueOf(r6.getVoteId());
    L12:
        String r8 = "";
        if ((!Intrinsics.areEqual(r5, r7)) == false) goto L18;
        d r9 = this.f;
        if (r9 == null) goto L18;
        r9.b.setGuidelinePercent(0.5f);
        r9.c.setScaleY(0.0f);
        r9.d.setScaleY(0.0f);
        r9.f.setText("");
        r9.f.setAlpha(0.0f);
        r9.g.setText("");
        r9.g.setAlpha(0.0f);
        r9.h.setGuidelineBegin(MathKt.roundToInt(t6.a(r9.u.getContext(), 13.0f)));
        r9.i.setController(null);
        r9.j.setGuidelinePercent(1.0f);
        r9.k.setVisibility(8);
        r9.m.setAlpha(0.0f);
        r9.l.setController(null);
        VoteIconModel r10 = r9.u;
        HSImageView r13 = r9.l;
        r10.getClass();
        r13.setScaleX(0.0f);
        r13.setScaleY(0.0f);
        r9.l.setAlpha(1.0f);
        r9.n.setVisibility(8);
        r9.p.setAlpha(0.0f);
        r9.o.setController(null);
        VoteIconModel r12 = r9.u;
        HSImageView r14 = r9.o;
        r12.getClass();
        r14.setScaleX(0.0f);
        r14.setScaleY(0.0f);
        r9.o.setAlpha(1.0f);
        r9.q = false;
        r9.r.clear();
        r9.s = 0.5f;
        r9.t = true;
    L18:
        if ((r2 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L22;
        com.bytedance.android.live.profit.vote.model.b.d r15 = (com.bytedance.android.live.profit.vote.model.b.d) r2;
        this.h.c(r15.a);
        h(r15.a);
        bindState(r15.b.subscribe(new com.bytedance.android.live.profit.vote.ui.b(this)));
        this.h.b(false);
    L20:
        String r16 = null;
    L71:
        if (r1 != null) goto L73;
    L76:
        LinkedHashMap r3 = new LinkedHashMap();
        com.bytedance.android.live.profit.vote.b r17 = r2.a();
        if (r17 == null) goto L79;
        VoteUtilsKt.j(r3, r17);
    L79:
        com.bytedance.android.live.profit.vote.f r22 = this.m;
        r22.c(r3);
        r22.a(r3);
        r22.d(r3);
        Intrinsics.checkNotNullParameter(r3, "$this$putToUserInfo");
        iq2.f r23 = VoteUtilsKt.e();
        if (r23 == null) goto L99;
        iq2.g r24 = r23.b();
        if (r24 == null) goto L90;
        iq2.c r25 = r24.a();
        if (r25 == null) goto L90;
        String r26 = r25.a();
        if (r26 == null) goto L90;
        r8 = r26;
    L90:
        r3.put("to_user_id", r8);
        IBaseUser r27 = r22.b.mo444getRoom().getOwnerKt();
        if (r27 == null) goto L93;
        String r28 = r27.getIdString();
    L95:
        if (Intrinsics.areEqual(r28, r8) == false) goto L97;
        String r29 = "anchor";
    L98:
        r3.put("to_user_type", r29);
        goto L99
    L97:
        r29 = "user";
        goto L98
    L93:
        r28 = r16;
    L99:
        VoteUtilsKt.i(r3);
        n r30 = new n();
        Map<String, String> r32 = r30.a;
        Intrinsics.checkNotNullParameter(r32, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r32.putAll(r3);
        m r33 = new m();
        r33.b(LogCommon.ROOM);
        ((ArrayList) r30.b).addAll(r33.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((mz0.i) ((f80.a) r35)).w3("livesdk_ksong_poll_icon_show", r30.a, r30.b);
        return;
    L73:
        if ((r1 instanceof com.bytedance.android.live.profit.vote.model.b.c) == true) goto L75;
        return;
    L75:
        if ((r2 instanceof com.bytedance.android.live.profit.vote.model.b.c) == false) goto L76;
        return;
    L22:
        if ((r2 instanceof com.bytedance.android.live.profit.vote.model.b.a) == false) goto L29;
        this.h.a();
        com.bytedance.android.live.profit.vote.model.b.a r36 = (com.bytedance.android.live.profit.vote.model.b.a) r2;
        this.h.c(r36.a);
        h(r36.a);
        this.h.b(true);
        d r37 = this.f;
        if (r37 == null) goto L20;
        xr2.b r38 = r37.a;
        if (r38 == null) goto L20;
        r38.setLabel(null);
        goto L20
    L29:
        if ((r2 instanceof com.bytedance.android.live.profit.vote.model.b.e) == false) goto L41;
        this.h.a();
        com.bytedance.android.live.profit.vote.model.b.e r39 = (com.bytedance.android.live.profit.vote.model.b.e) r2;
        this.h.c(r39.a);
        h(r39.a);
        this.h.b(false);
        d r40 = this.f;
        if (r40 == null) goto L35;
        Guideline r42 = r40.h;
        if (r42 == null) goto L35;
        r42.setGuidelinePercent(0.5f);
    L35:
        d r43 = this.f;
        if (r43 == null) goto L20;
        xr2.b r44 = r43.a;
        if (r44 == null) goto L20;
        r44.setLabel(null);
        goto L20
    L41:
        if ((r2 instanceof com.bytedance.android.live.profit.vote.model.b.C0056b) == false) goto L20;
        this.h.a();
        com.bytedance.android.live.profit.vote.model.b.C0056b r45 = (com.bytedance.android.live.profit.vote.model.b.C0056b) r2;
        this.h.c(r45.a);
        j(r45.a);
        this.h.b(false);
        c r46 = this.h;
        com.bytedance.android.live.profit.vote.b r47 = r45.a;
        r46.getClass();
        Intrinsics.checkNotNullParameter(r47, "vote");
        if (r46.a.g == null) goto L45;
        Intrinsics.checkNotNullParameter(r47, "vote");
    L45:
        d r48 = r46.a.f;
        if (r48 == null) goto L65;
        Intrinsics.checkNotNullParameter(r47, "vote");
        List r49 = (List) r47.getItems().d;
        if (r49.size() < 2) goto L50;
        boolean r110 = true;
    L51:
        if (r110 == true) goto L54;
        r49 = null;
    L54:
        if (r49 == null) goto L65;
        Pair r50 = TuplesKt.to(Long.valueOf(((com.bytedance.android.live.profit.vote.g) ListProtector.get(r49, 0)).a), Long.valueOf(((com.bytedance.android.live.profit.vote.g) ListProtector.get(r49, 1)).a));
        long r111 = ((Number) r50.component1()).longValue();
        long r52 = ((Number) r50.component2()).longValue();
        r48.a.setLabel(null);
        r48.h.setGuidelinePercent(0.5f);
        if (r111 != r52) goto L59;
        AnimatorSet r53 = com.bytedance.android.live.revenue.common.e.c(r48.a(), new float[]{0.0f, 1.05f, 1.0f});
        r53.setDuration(333);
    L64:
        r53.start();
        goto L65
    L59:
        ObjectAnimator r54 = ObjectAnimator.ofFloat(r48.j, "guidelinePercent", new float[]{1.0f, 0.0f});
        r54.setDuration(233);
        r54.setStartDelay(200);
        r54.setInterpolator(new DecelerateInterpolator());
        TextView r112 = r48.a();
        if (r111 >= r52) goto L62;
        r48.n.setVisibility(0);
        View r113 = r48.p;
        final HSImageView r55 = r48.o;
    L63:
        r55.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse("asset://com.ss.android.ies.live.sdk/vote_shine.webp")).setAutoPlayAnimations(true).build());
        ObjectAnimator r56 = ObjectAnimator.ofFloat(r113, "alpha", new float[]{0.0f, 1.0f});
        r56.setDuration(200);
        r56.setStartDelay(200);
        AnimatorSet r114 = com.bytedance.android.live.revenue.common.e.c(r55, new float[]{0.0f, 1.0f});
        r114.setDuration(400);
        r114.setStartDelay(433);
        ObjectAnimator r57 = ObjectAnimator.ofFloat(r55, "alpha", new float[]{1.0f, 0.0f});
        r57.setDuration(300);
        r57.setStartDelay(633);
        com.bytedance.android.live.revenue.common.e.b(r57, new VoteIconModel$ViewHolder$showFinishAnim$$inlined$apply$lambda$1(r55));
        AnimatorSet r58 = com.bytedance.android.live.revenue.common.e.c(r112, new float[]{1.0f, 1.05f, 1.0f});
        r58.setDuration(200);
        AnimatorSet r115 = new AnimatorSet();
        r115.playTogether(new Animator[]{r54, r56, r114, r57, r58});
        r53 = r115;
        goto L64
    L62:
        r48.k.setVisibility(0);
        r113 = r48.m;
        r55 = r48.l;
        goto L63
    L50:
        r110 = false;
    L65:
        d r59 = this.f;
        if (r59 == null) goto L70;
        xr2.b r60 = r59.a;
        if (r60 == null) goto L70;
        r16 = null;
        r60.setLabel(null);
    L70:
        r16 = null;
        goto L71
    L11:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    public VoteIconModel(VoteViewModel r3, VotePanelHandler r4, c01.a r5, yz0.k r6, com.bytedance.android.live.profit.vote.f r7) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "panelHandler");
        Intrinsics.checkNotNullParameter(r5, "stiService");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        Intrinsics.checkNotNullParameter(r7, "etHelper");
        super(com.bytedance.android.live.profit.vote.model.b.c.a, RevStiElementType.GiftVote.getTypeId());
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.h = new c(this);
    }
}
