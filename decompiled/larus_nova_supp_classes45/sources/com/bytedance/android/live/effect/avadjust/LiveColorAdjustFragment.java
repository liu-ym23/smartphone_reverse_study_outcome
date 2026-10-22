package com.bytedance.android.live.effect.avadjust;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.utils.BeautyWithSwitchItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "p", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveColorAdjustFragment extends BaseFragment {
    public static final /* synthetic */ int r = 0;
    public Map<Integer, View> d;
    public Sticker e;
    public final int f;
    public final com.bytedance.android.live.effect.sticker.e g;
    public final Lazy h;
    public boolean i;
    public View j;
    public View k;
    public View l;
    public boolean m;
    public final b n;
    public final d o;
    public final LiveEffectContextFactoryDelegate$Type p;
    public final String q;

    public static final class a {
    }

    public static final class b implements l.c {
        public final /* synthetic */ LiveColorAdjustFragment a;

        @Override // com.bytedance.android.live.effect.avadjust.l.c
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131386947);
            if (r0 == null) goto L5;
            r0.showError();
        L5:
            this.a.g.m();
        }

        public b(LiveColorAdjustFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.avadjust.l.c
        public final void onSuccess(List<Sticker> r6) {
            Intrinsics.checkNotNullParameter(r6, "stickerList");
            if (r6.isEmpty() == false) goto L5;
            LiveEffectMonitor.d("live_adjustment", 1000, "empty list");
        L5:
            LiveColorAdjustFragment r0 = this.a;
            int r1 = LiveColorAdjustFragment.r;
            LiveColorAdjustAdapter r2 = r0.U90();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r6, "list");
            ((ArrayList) r2.a).clear();
            ArrayList r3 = (ArrayList) r2.a;
            r3.addAll(r6);
            ((ArrayList) r2.b).clear();
            List<String> r4 = r2.b;
            List<Sticker> r5 = r6;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r8 = r5.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            r7.add(((Sticker) r8.next()).getEffectId());
            goto L7
        L9:
            ((ArrayList) r4).addAll(r7);
            r2.notifyDataSetChanged();
            if (m90.b.b.c(this.a.getType()).booleanValue() == false) goto L13;
            LiveColorAdjustFragment r9 = this.a;
            r9.e = (Sticker) ListProtector.get(r6, 0);
        L13:
            if (this.a.S90(2131386947) == null) goto L15;
            this.a.S90(2131386947).setVisibility(8);
        L15:
            this.a.V90("ttlive_anchor_effect_LiveColorAdjustFragment_colorAdjustLoadCallback_onSuccess");
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveColorAdjustFragment a;

        public c(LiveColorAdjustFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveColorAdjustFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LiveColorAdjustFragment.r;     // Catch: Throwable -> L4
            r0.V90("onHiddenChanged");     // Catch: Throwable -> L4
            this.a.T90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements ILiveEffectComposerManager.c {
        public final /* synthetic */ LiveColorAdjustFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Sticker c;
            public final /* synthetic */ String d;
            public final /* synthetic */ float e;

            public a(d r1, String r2, Sticker r3, String r4, float r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveColorAdjustFragment r0 = this.a.a;     // Catch: Throwable -> L4
                int r1 = LiveColorAdjustFragment.r;     // Catch: Throwable -> L4
                LiveColorAdjustAdapter r2 = r0.U90();     // Catch: Throwable -> L4
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

        public d(LiveColorAdjustFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r1, Sticker r2, String r3, float r4) {
            ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
            LiveColorAdjustFragment r14 = this.a;
            if (r14.i == false) goto L8;
            RecyclerView r15 = r14.S90(2131386948);
            if (r15 == null) goto L9;
            r15.post(new a(this, r8, r9, r11, r12));
            return;
        L9:
            return;
        }
    }

    public final LiveColorAdjustAdapter U90() {
        return (LiveColorAdjustAdapter) this.h.getValue();
    }

    static {
        UtilityKotlinExtentionsKt.i(15);
    }

    public final void T90() {
        List<String> r0 = LiveEffectContext.h;
        Iterator<T> r1 = LiveEffectContext.a.a(this.p).a().o("live_adjustment").iterator();
        boolean r2 = false;
    L4:
        if (r1.hasNext() == false) goto L21;
        Sticker r3 = (Sticker) r1.next();
        Sticker.ComposerConfig r5 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r3.getComposerConfigList());
        if (r5 == null) goto L8;
        int r6 = r5.getDefaultValue();
    L9:
        float r7 = com.bytedance.android.live.effect.q.d(r3, r6);
        List<String> r8 = LiveEffectContext.h;
        ILiveEffectComposerManager r9 = LiveEffectContext.a.a(this.p).a();
        String r11 = r3.getEffectId();
        Sticker.ComposerConfig r4 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r3.getComposerConfigList());
        if (r4 == null) goto L13;
        String r12 = r4.getTag();
        if (r12 == null) goto L13;
    L14:
        Float r13 = r9.G(r11, r12);
        if (r13 == null) goto L17;
        float r14 = r13.floatValue();
    L19:
        if (r14 == r7) goto L4;
        r2 = true;
        goto L4
    L17:
        r14 = 0.0f;
    L13:
        r12 = "";
        goto L14
    L8:
        r6 = 0;
        goto L9
    L21:
        ALogger.i("LiveColorAdjustFragment", "checkResetStatus newResetStatus = " + r2);
        this.m = r2;
        if (r2 == false) goto L32;
        View r15 = this.l;
        if (r15 == null) goto L26;
        r15.setClickable(true);
    L26:
        View r16 = this.l;
        if (r16 == null) goto L29;
        r16.setAlpha(1.0f);
    L29:
        View r17 = this.l;
        if (r17 == null) goto L47;
        r17.setContentDescription(s1.B(2131916374));
        return;
    L47:
        return;
    L32:
        View r18 = this.l;
        if (r18 == null) goto L35;
        r18.setClickable(false);
    L35:
        View r19 = this.l;
        if (r19 == null) goto L38;
        r19.setAlpha(0.5f);
    L38:
        View r21 = this.l;
        if (r21 == null) goto L49;
        r21.setContentDescription(s1.B(2131916377));
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.p).a().K(this.o);
        U90().c = 0;
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        LiveColorAdjustAdapter r0 = U90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.k).b().g().e(r0.g);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveColorAdjustAdapter r0 = U90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.k).b().g().a(r0.g);
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.p;
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

    public final void V90(String r7) {
        if (isDestroyed() == false) goto L6;
        return;
    L6:
        if (S90(2131367174) != null) goto L9;
        return;
    L9:
        if (m90.b.b.c(this.p).booleanValue() == true) goto L16;
        ((AdjustPercentBar) S90(2131367174)).setVisibility(8);
        if (S90(2131386948) == null) goto L13;
        S90(2131386948).setAlpha(0.75f);
    L13:
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.p).a().T(r7, false);
        return;
    L16:
        if (S90(2131386948) == null) goto L18;
        S90(2131386948).setAlpha(1.0f);
    L18:
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.p).a().T(r7, false);
        Sticker r8 = this.e;
        Integer r2 = null;
        if (r8 == null) goto L21;
        Sticker.ComposerConfig r9 = r8.getSmallItemConfig();
    L22:
        if (r9 != null) goto L25;
        ((AdjustPercentBar) S90(2131367174)).setVisibility(8);
        return;
    L25:
        ((AdjustPercentBar) S90(2131367174)).setVisibility(0);
        AdjustPercentBar r11 = (AdjustPercentBar) S90(2131367174);
        Sticker r3 = this.e;
        if (r3 == null) goto L28;
        String r4 = r3.getName();
    L29:
        r11.setTag(r4);
        ILiveEffectComposerManager r12 = LiveEffectContext.a.a(this.p).a();
        Sticker r5 = this.e;
        String r6 = "";
        if (r5 == null) goto L33;
        String r13 = r5.getEffectId();
        if (r13 == null) goto L33;
    L34:
        Sticker r14 = this.e;
        if (r14 == null) goto L42;
        Sticker.ComposerConfig r15 = r14.getSmallItemConfig();
        if (r15 == null) goto L42;
        String r16 = r15.getTag();
        if (r16 == null) goto L42;
        r6 = r16;
    L42:
        Float r17 = r12.G(r13, r6);
        if (r17 != null) goto L50;
        Sticker r18 = this.e;
        Intrinsics.checkNotNull(r18);
        Sticker r19 = this.e;
        if (r19 == null) goto L49;
        Sticker.ComposerConfig r21 = r19.getSmallItemConfig();
        if (r21 == null) goto L49;
        r2 = Integer.valueOf(r21.getDefaultValue());
    L49:
        Intrinsics.checkNotNull(r2);
        r17 = Float.valueOf(com.bytedance.android.live.effect.q.d(r18, r2.intValue()));
    L50:
        Sticker r22 = this.e;
        Intrinsics.checkNotNull(r22);
        ((AdjustPercentBar) S90(2131367174)).setPercent(com.bytedance.android.live.effect.q.b(r22, r17.floatValue()));
        Sticker r23 = this.e;
        if (r23 == null) goto L57;
        Sticker.ComposerConfig r24 = r23.getSmallItemConfig();
        if (r24 == null) goto L57;
        if (r24.getDoubleDirection() != true) goto L57;
        ((AdjustPercentBar) S90(2131367174)).e(50, -50, 0, false);
    L58:
        ILiveEffectComposerManager r25 = LiveEffectContext.a.a(this.p).a();
        Sticker r26 = this.e;
        Intrinsics.checkNotNull(r26);
        r25.a("live_adjustment", r26, "ttlive_anchor_effect_LiveColorAdjustFragment_refreshView");
        return;
    L57:
        ((AdjustPercentBar) S90(2131367174)).e(100, 0, 0, true);
    L33:
        r13 = "";
        goto L34
    L28:
        r4 = null;
        goto L29
    L21:
        r9 = null;
        goto L22
    }

    public final void onHiddenChanged(boolean r2) {
        super.onHiddenChanged(r2);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L10;
        View r3 = getView();
        if (r3 == null) goto L11;
        r3.post(new c(this));
        return;
    L11:
        return;
    }

    public LiveColorAdjustFragment(LiveEffectContextFactoryDelegate$Type r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "eventPage");
        this.p = r2;
        this.q = r3;
        this.d = new LinkedHashMap();
        this.f = 2131565886;
        this.g = new com.bytedance.android.live.effect.sticker.e("live_adjustment");
        this.h = LazyKt.lazy(new LiveColorAdjustFragment$avAdjustAdapter$2(this));
        this.n = new b(this);
        this.o = new d(this);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FrameLayout r0 = null;
        View r7 = LayoutInflater.from(getContext()).inflate(2131563550, null);
        r7.setOnClickListener(new f(this));
        Context r8 = getContext();
        if (r8 == null) goto L5;
        r0 = new LiveDoubleColorBallAnimationView(r8);
        int r9 = r0.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(r9, r9);
        r1.gravity = 17;
        r0.setLayoutParams(r1);
    L5:
        S90(2131386947).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r7).setLoadingView(r0));
        S90(2131386947).showLoading();
        ((AdjustPercentBar) S90(2131367174)).c(s1.h(2131107404), s1.h(2131107395), s1.h(2131107402));
        ((AdjustPercentBar) S90(2131367174)).setDefaultCircleConfig(2131109391);
        ((AdjustPercentBar) S90(2131367174)).setDefaultCircleRadius(s1.f(3.0f));
        this.l = S90(2131367173);
        this.j = S90(2131367173).findViewById(2131374718);
        this.k = S90(2131367173).findViewById(2131384419);
        ((AdjustPercentBar) S90(2131367174)).setOnLevelChangeListener(new g(this));
        List<String> r11 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.p).a().l(this.o);
        S90(2131386948).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        S90(2131386948).setAdapter(U90());
        S90(2131386948).addItemDecoration(new BeautyWithSwitchItemDecoration());
        S90(2131367173).setOnClickListener(new h(this));
        V90("ttlive_anchor_effect_LiveColorAdjustFragment_colorAdjustInitView");
        T90();
        l.b(LiveEffectContext.a.a(this.p).b().n(), this.n);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565865, r3, false);
    }
}
