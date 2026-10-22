package com.bytedance.android.live.effect.beauty.filter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.effect.utils.BeautyItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdk.config.w1;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "m", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveComposerFilterFragment extends BaseFragment {
    public static final /* synthetic */ int q = 0;
    public Map<Integer, View> d;
    public boolean e;
    public boolean f;
    public final e g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final b k;
    public final c l;
    public final LiveEffectContextFactoryDelegate$Type m;
    public final q90.b n;
    public final String o;
    public final boolean p;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveComposerFilterFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveComposerFilterFragment r0 = this.a;
            int r1 = LiveComposerFilterFragment.q;
            r0.V90();
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveComposerFilterFragment r0 = this.a;
            int r1 = LiveComposerFilterFragment.q;
            LiveComposerFilterHelper.a(r0.U90(), null, "ttlive_anchor_effect_LiveComposerFilterFragment_onBeautyModeChange", r0.o, true, false, 48);
            r0.U90().d(r0.l, r0.o);
        }

        public b(LiveComposerFilterFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements LiveSmallItemBeautyHelper.c {
        public final /* synthetic */ LiveComposerFilterFragment a;

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131379091);
            if (r0 == null) goto L6;
            r0.showError();
            return;
        }

        public c(LiveComposerFilterFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onSuccess(List<Sticker> r6) {
            Intrinsics.checkNotNullParameter(r6, "stickerList");
            if (r6.isEmpty() == false) goto L8;
            LiveEffectMonitor.d(d0.a, 1000, "ttlive_anchor_effect_LiveComposerFilterFragment empty list");
            LoadingStatusView r7 = this.a.S90(2131379091);
            if (r7 == null) goto L18;
            r7.showError();
            return;
        L18:
            return;
        L8:
            LiveComposerFilterFragment r0 = this.a;
            int r2 = LiveComposerFilterFragment.q;
            LiveComposerFilterAdapter r1 = r0.T90();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r6, "list");
            ((ArrayList) r1.a).clear();
            ArrayList r3 = (ArrayList) r1.a;
            r3.addAll(r6);
            ((ArrayList) r1.b).clear();
            List<String> r4 = r1.b;
            List<Sticker> r8 = r6;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L12;
            r5.add(((Sticker) r9.next()).getEffectId());
            goto L10
        L12:
            ((ArrayList) r4).addAll(r5);
            r1.notifyDataSetChanged();
            LoadingStatusView r11 = this.a.S90(2131379091);
            if (r11 == null) goto L15;
            r11.reset();
        L15:
            this.a.V90();
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LiveComposerFilterFragment a;

        public d(LiveComposerFilterFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r0 = this.a.S90(2131383723);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.scrollToPosition(this.a.T90().d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {
        public final /* synthetic */ LiveComposerFilterFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Sticker c;
            public final /* synthetic */ String d;
            public final /* synthetic */ float e;

            public a(e r1, String r2, Sticker r3, String r4, float r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveComposerFilterFragment r0 = this.a.a;     // Catch: Throwable -> L4
                int r1 = LiveComposerFilterFragment.q;     // Catch: Throwable -> L4
                LiveComposerFilterAdapter r2 = r0.T90();     // Catch: Throwable -> L4
                String r3 = this.b;     // Catch: Throwable -> L4
                Sticker r4 = this.c;     // Catch: Throwable -> L4
                String r5 = this.d;     // Catch: Throwable -> L4
                float r6 = this.e;     // Catch: Throwable -> L4
                r2.getClass();     // Catch: Throwable -> L4
                ILiveEffectComposerManager.c.a.a(r2, r3, r4, r5, r6);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(LiveComposerFilterFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r1, Sticker r2, String r3, float r4) {
            ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
            LiveComposerFilterFragment r14 = this.a;
            if (r14.p == true) goto L5;
            return;
        L5:
            if (r14.f == false) goto L11;
            RecyclerView r15 = r14.S90(2131383723);
            if (r15 == null) goto L12;
            r15.post(new a(this, r8, r9, r11, r12));
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final LiveComposerFilterAdapter T90() {
        return (LiveComposerFilterAdapter) this.j.getValue();
    }

    public final LiveComposerFilterHelper U90() {
        return (LiveComposerFilterHelper) this.h.getValue();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.m).a().K(this.g);
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        ((n) this.i.getValue()).a(this.k, d0.l);
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final void V90() {
        LiveComposerFilterAdapter r0 = T90();
        int r1 = r0.d;
        if (r1 >= 0) goto L5;
    L23:
        r0.notifyDataSetChanged();
    L24:
        List<String> r2 = LiveEffectContext.h;
        LiveEffectContextFactoryDelegate$Type r3 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        ILiveEffectComposerManager r4 = LiveEffectContext.a.a(r3).a();
        String r5 = d0.a;
        if (r4.U(r5) <= 0) goto L27;
        boolean r6 = true;
    L28:
        View r7 = S90(2131388958);
        if (r7 == null) goto L34;
        if (r6 == false) goto L32;
        int r8 = 0;
    L33:
        r7.setVisibility(r8);
        goto L34
    L32:
        r8 = 4;
    L34:
        ul r9 = ul.a;
        if (r9.getValue() != null) goto L37;
    L41:
        boolean r11 = false;
    L42:
        if (r11 == true) goto L44;
    L55:
        boolean r12 = false;
    L56:
        T90().c = !r12;
        if (r6 == true) goto L63;
        if (r12 == true) goto L63;
        RecyclerView r13 = S90(2131383723);
        if (r13 == null) goto L67;
        r13.setAlpha(1.0f);
    L67:
        if (LiveEffectContext.a.a(r3).a().U(r5) <= 0) goto L69;
        boolean r14 = true;
    L70:
        LiveComposerFilterAdapter r15 = T90();
        int r16 = r15.d;
        if (r16 >= 0) goto L73;
    L76:
        Sticker r17 = new Sticker();
    L78:
        if (this.p == false) goto L99;
        if (r14 == true) goto L95;
        Sticker.ComposerConfig r18 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r17.getComposerConfigList());
        if (r18 == null) goto L92;
        BeautifyAdjustPercentBar r19 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r19 == null) goto L86;
        r19.Y5(100, 0, r18.getDefaultValue(), true);
    L86:
        BeautifyAdjustPercentBar r21 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r21 == null) goto L89;
        r21.setPercent(U90().c(r17, r18));
    L89:
        ConstraintLayout r22 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r22 == null) goto L117;
        r22.setVisibility(0);
    L117:
        RecyclerView r23 = S90(2131383723);
        if (r23 == null) goto L123;
        r23.post(new d(this));
        return;
    L123:
        return;
    L92:
        ConstraintLayout r24 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r24 == null) goto L117;
        r24.setVisibility(4);
        goto L117
    L95:
        ConstraintLayout r25 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r25 == null) goto L117;
        r25.setVisibility(4);
        goto L117
    L99:
        if (r14 == true) goto L114;
        Sticker.ComposerConfig r26 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r17.getComposerConfigList());
        if (r26 == null) goto L111;
        AdjustPercentBar r27 = (AdjustPercentBar) S90(2131372513);
        if (r27 == null) goto L105;
        r27.setPercent(U90().c(r17, r26));
    L105:
        AdjustPercentBar r28 = (AdjustPercentBar) S90(2131372513);
        if (r28 == null) goto L108;
        r28.e(100, 0, r26.getDefaultValue(), true);
    L108:
        AdjustPercentBar r29 = (AdjustPercentBar) S90(2131372513);
        if (r29 == null) goto L117;
        r29.setVisibility(0);
        goto L117
    L111:
        AdjustPercentBar r31 = (AdjustPercentBar) S90(2131372513);
        if (r31 == null) goto L117;
        r31.setVisibility(4);
        goto L117
    L114:
        AdjustPercentBar r32 = (AdjustPercentBar) S90(2131372513);
        if (r32 == null) goto L117;
        r32.setVisibility(4);
        goto L117
    L73:
        if (r16 >= r15.getItemCount()) goto L76;
        r17 = (Sticker) ListProtector.get(r15.a, r15.d);
        goto L78
    L69:
        r14 = false;
    L63:
        RecyclerView r33 = S90(2131383723);
        if (r33 == null) goto L67;
        r33.setAlpha(0.5f);
        goto L67
    L44:
        if (m90.b.D.c(r3).booleanValue() == false) goto L55;
        if (r9.getValue() != null) goto L48;
    L52:
        boolean r34 = false;
    L53:
        if (r34 == true) goto L55;
        r12 = true;
        goto L56
    L48:
        if (((w1) r9.getValue()).a() == null) goto L52;
        Boolean r35 = ((w1) r9.getValue()).a();
        Intrinsics.checkNotNull(r35);
        if (r35.booleanValue() == false) goto L52;
        r34 = true;
        goto L53
    L37:
        if (((w1) r9.getValue()).b() == null) goto L41;
        Boolean r36 = ((w1) r9.getValue()).b();
        Intrinsics.checkNotNull(r36);
        if (r36.booleanValue() == false) goto L41;
        r11 = true;
        goto L42
    L27:
        r6 = false;
        goto L28
    L5:
        if (r1 >= r0.getItemCount()) goto L23;
        List<String> r37 = LiveEffectContext.h;
        Sticker r38 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(r0.g).a().o(d0.a));
        if (r38 == null) goto L11;
        String r39 = r38.getResourceId();
        if (r39 == null) goto L11;
    L12:
        Iterator r41 = ((ArrayList) r0.a).iterator();
        int r42 = 0;
    L14:
        if (r41.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((Sticker) r41.next()).getResourceId(), r39) == true) goto L20;
        r42 = r42 + 1;
    L20:
        int r43 = r0.d;
        if (r43 == r42) goto L24;
        r0.notifyItemChanged(r43);
        r0.notifyItemChanged(r42);
        r0.d = r42;
        goto L24
    L19:
        r42 = -1;
    L11:
        r39 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        super.onPause();
        LiveComposerFilterAdapter r0 = T90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveComposerFilterHelper r2 = LiveEffectContext.a.a(r0.g).b().m();
        com.bytedance.android.live.effect.beauty.filter.a r3 = r0.e;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((ArrayList) r2.c).contains(r3) == false) goto L6;
        ((ArrayList) r2.c).remove(r3);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveComposerFilterAdapter r0 = T90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveComposerFilterHelper r2 = LiveEffectContext.a.a(r0.g).b().m();
        com.bytedance.android.live.effect.beauty.filter.a r3 = r0.e;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((ArrayList) r2.c).contains(r3) == true) goto L6;
        ((ArrayList) r2.c).add(r3);
        return;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.m;
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        if (r1 == true) goto L6;
        V90();
        return;
    }

    /* JADX WARN: Type inference failed for: r8v32, types: [android.view.View, com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar] */
    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        View r9 = LayoutInflater.from(getContext()).inflate(2131565849, null);
        if (r9 == null) goto L5;
        r9.setOnClickListener(new com.bytedance.android.live.effect.beauty.filter.b(this));
    L5:
        LoadingStatusView r0 = S90(2131379091);
        if (r0 == null) goto L8;
        r0.setBuilder(new LoadingStatusView.Builder(getContext()).setErrorView(r9));
    L8:
        LoadingStatusView r11 = S90(2131379091);
        if (r11 == null) goto L11;
        r11.showLoading();
    L11:
        com.bytedance.android.live.effect.beauty.filter.d r12 = new com.bytedance.android.live.effect.beauty.filter.d(this);
        if (this.p == false) goto L26;
        AdjustPercentBar r13 = (AdjustPercentBar) S90(2131372513);
        if (r13 == null) goto L16;
        r13.setVisibility(8);
    L16:
        ConstraintLayout r14 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r14 == null) goto L19;
        r14.setVisibility(0);
    L19:
        ?? r15 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r15 != 0) goto L22;
    L35:
        List<String> r16 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.m).a().l(this.g);
        RecyclerView r17 = S90(2131383723);
        if (r17 == null) goto L38;
        r17.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L38:
        RecyclerView.ItemDecoration r18 = this.n.b;
        if (r18 == null) goto L46;
        RecyclerView r1 = S90(2131383723);
        if (r1 == null) goto L46;
        if (this.e == false) goto L45;
        r18 = new BeautyItemDecoration();
    L45:
        r1.addItemDecoration(r18);
    L46:
        RecyclerView r19 = S90(2131383723);
        if (r19 == null) goto L49;
        r19.setAdapter(T90());
    L49:
        View r21 = S90(2131388958);
        if (r21 == null) goto L53;
        r21.setOnClickListener(com.bytedance.android.live.effect.beauty.filter.c.a);
    L53:
        if (this.p == false) goto L60;
        RecyclerView r22 = S90(2131383723);
        if (r22 == null) goto L57;
        a1.k(r22, s1.f(102.0f));
    L57:
        RecyclerView r23 = S90(2131383723);
        if (r23 == null) goto L60;
        r23.addItemDecoration(new LiveComposerFilterFragment$initView$6());
    L60:
        V90();
        U90().d(this.l, this.o);
        if (((n) this.i.getValue()).c() == false) goto L64;
        ((n) this.i.getValue()).f(this.k, d0.l);
        return;
    L64:
        return;
    L22:
        if (this.e == false) goto L24;
        int r2 = 2131107406;
    L25:
        r15.U5(s1.h(r2), s1.h(2131107403), s1.h(2131107402));
        r15.setOnLevelChangeListener(r12);
        a1.l(r15, s1.f(69.0f));
        goto L35
    L24:
        r2 = 2131107405;
        goto L25
    L26:
        AdjustPercentBar r24 = (AdjustPercentBar) S90(2131372513);
        if (r24 == null) goto L29;
        r24.setVisibility(0);
    L29:
        ConstraintLayout r25 = (BeautifyAdjustPercentBar) S90(2131372514);
        if (r25 == null) goto L32;
        r25.setVisibility(8);
    L32:
        AdjustPercentBar r26 = (AdjustPercentBar) S90(2131372513);
        if (r26 == null) goto L35;
        r26.c(s1.h(2131107404), s1.h(2131107403), s1.h(2131107402));
        r26.setDefaultCircleConfig(2131109391);
        r26.setOnLevelChangeListener(r12);
        goto L35
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.e == false) goto L5;
        int r5 = 2131565880;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565879;
        goto L7
    }

    public LiveComposerFilterFragment(LiveEffectContextFactoryDelegate$Type r2, q90.b r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "template");
        Intrinsics.checkNotNullParameter(r4, "page");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.d = new LinkedHashMap();
        this.g = new e(this);
        this.h = LazyKt.lazy(new LiveComposerFilterFragment$filterHelper$2(this));
        this.i = LazyKt.lazy(new LiveComposerFilterFragment$beautyModeManager$2(this));
        this.j = LazyKt.lazy(new LiveComposerFilterFragment$filterAdapter$2(this));
        this.k = new b(this);
        this.l = new c(this);
    }
}
