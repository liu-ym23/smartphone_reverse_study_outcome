package com.bytedance.android.live.effect.beauty.makeups;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.live.effect.utils.BeautyItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/makeups/LiveMakeupsBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMakeupsBeautyFragment extends BaseFragment {
    public static final /* synthetic */ int p = 0;
    public Map<Integer, View> d;
    public Sticker e;
    public final Lazy f;
    public final Lazy g;
    public final Map<String, b> h;
    public LiveEffectContextFactoryDelegate$Type i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final e m;
    public final d n;
    public final c o;

    public static final class a {
    }

    public final class b {
        public final AdjustPercentBar a;
        public final View b;
        public final Sticker c;
        public final Sticker.ComposerConfig d;
        public final /* synthetic */ LiveMakeupsBeautyFragment e;

        public static final class a implements AdjustPercentBar.d {
            public final /* synthetic */ b a;

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void a(int r1) {
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void b() {
            }

            public a(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void onChanged(int r4) {
                List<String> r0 = LiveEffectContext.h;
                com.bytedance.android.live.effect.beauty.makeups.a r1 = LiveEffectContext.a.a(this.a.e.i).b().f();
                b r2 = this.a;
                com.bytedance.android.live.effect.beauty.makeups.d r3 = (com.bytedance.android.live.effect.beauty.makeups.d) r1;
                r3.e(r2.c, r2.d, r4);
                int r5 = com.bytedance.android.live.effect.beauty.smallitem.d.e;
                com.bytedance.android.live.effect.beauty.smallitem.d.a.a(this.a.e.i);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.makeups.LiveMakeupsBeautyFragment$b$b, reason: collision with other inner class name */
        public static final class C0184b implements AdjustPercentBar.d {
            public final /* synthetic */ b a;

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void a(int r1) {
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void b() {
            }

            public C0184b(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
            public final void onChanged(int r4) {
                List<String> r0 = LiveEffectContext.h;
                com.bytedance.android.live.effect.beauty.makeups.a r1 = LiveEffectContext.a.a(this.a.e.i).b().f();
                b r2 = this.a;
                com.bytedance.android.live.effect.beauty.makeups.d r3 = (com.bytedance.android.live.effect.beauty.makeups.d) r1;
                r3.e(r2.c, r2.d, r4);
                int r5 = com.bytedance.android.live.effect.beauty.smallitem.d.e;
                com.bytedance.android.live.effect.beauty.smallitem.d.a.a(this.a.e.i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(LiveMakeupsBeautyFragment r11, View r12, Sticker r13, Sticker.ComposerConfig r14) {
            Intrinsics.checkNotNullParameter(r12, "view");
            Intrinsics.checkNotNullParameter(r13, "sticker");
            Intrinsics.checkNotNullParameter(r14, "composerConfig");
            this.e = r11;
            this.b = r12;
            this.c = r13;
            this.d = r14;
            AdjustPercentBar r0 = (AdjustPercentBar) r12.findViewById(2131379486);
            this.a = r0;
            TextView r1 = (TextView) r12.findViewById(2131379487);
            if ((r12 instanceof BeautifyAdjustPercentBar) == false) goto L14;
            if (r14.getDoubleDirection() == false) goto L7;
            ((BeautifyAdjustPercentBar) r12).Y5(50, -50, 0, false);
        L8:
            BeautifyAdjustPercentBar r15 = (BeautifyAdjustPercentBar) r12;
            if (r11.l == false) goto L11;
            int r16 = 2131107406;
        L12:
            r15.U5(s1.h(r16), s1.h(2131107403), s1.h(2131107402));
            r15.setOnLevelChangeListener(new a(this));
            r15.V5(true, r14.getName());
            return;
        L11:
            r16 = 2131107405;
            goto L12
        L7:
            ((BeautifyAdjustPercentBar) r12).Y5(100, 0, 0, true);
            goto L8
        L14:
            if (r14.getDoubleDirection() == false) goto L16;
            r0.e(50, -50, 0, false);
        L17:
            ((AdjustPercentBar) r12.findViewById(2131379486)).c(s1.h(2131107404), s1.h(2131107403), s1.h(2131107402));
            r0.setOnLevelChangeListener(new C0184b(this));
            r1.setText(r14.getName());
            return;
        L16:
            r0.e(100, 0, 0, true);
            goto L17
        }
    }

    public static final class c implements com.bytedance.android.live.effect.beauty.makeups.a.c {
        public final /* synthetic */ LiveMakeupsBeautyFragment a;

        @Override // com.bytedance.android.live.effect.beauty.makeups.a.c
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131379484);
            if (r0 == null) goto L6;
            r0.showError();
            return;
        }

        public c(LiveMakeupsBeautyFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.makeups.a.c
        public final void onSuccess(List<Sticker> r5) {
            Intrinsics.checkNotNullParameter(r5, "stickerList");
            if (r5.isEmpty() == false) goto L5;
            LiveEffectMonitor.d(d0.k, 1000, "empty list");
        L5:
            LiveMakeupsBeautyFragment r0 = this.a;
            int r1 = LiveMakeupsBeautyFragment.p;
            LiveMakeupsBeautyAdapter r2 = r0.T90();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "list");
            ((ArrayList) r2.a).clear();
            ArrayList r3 = (ArrayList) r2.a;
            r3.addAll(r5);
            ((ArrayList) r2.b).clear();
            List<String> r4 = r2.b;
            List<Sticker> r6 = r5;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            r7.add(((Sticker) r8.next()).getEffectId());
            goto L7
        L9:
            ((ArrayList) r4).addAll(r7);
            r2.notifyDataSetChanged();
            LiveMakeupsBeautyFragment r9 = this.a;
            if (r9.j == false) goto L15;
            LoadingStatusView r11 = r9.S90(2131379484);
            if (r11 == null) goto L17;
            r11.reset();
        L17:
            this.a.V90();
            return;
        L15:
            if (r9.S90(2131379484) == null) goto L17;
            this.a.S90(2131379484).setVisibility(8);
            goto L17
        }
    }

    public static final class d implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveMakeupsBeautyFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveMakeupsBeautyFragment r0 = this.a;
            int r1 = LiveMakeupsBeautyFragment.p;
            r0.V90();
            this.a.U90();
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveMakeupsBeautyFragment r0 = this.a;
            int r1 = LiveMakeupsBeautyFragment.p;
            r0.getClass();
            List<String> r2 = LiveEffectContext.h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r0.i).a(), d0.k, "LiveMakeupsBeautyFragment_onBeautyModeChange");
            com.bytedance.android.live.effect.beauty.makeups.a r3 = LiveEffectContext.a.a(r0.i).b().f();
            com.bytedance.android.live.effect.beauty.makeups.d r4 = (com.bytedance.android.live.effect.beauty.makeups.d) r3;
            r4.b(r0.o);
        }

        public d(LiveMakeupsBeautyFragment r1) {
            this.a = r1;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {
        public final /* synthetic */ LiveMakeupsBeautyFragment a;

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
                LiveMakeupsBeautyFragment r0 = this.a.a;     // Catch: Throwable -> L4
                int r1 = LiveMakeupsBeautyFragment.p;     // Catch: Throwable -> L4
                LiveMakeupsBeautyAdapter r2 = r0.T90();     // Catch: Throwable -> L4
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

        public e(LiveMakeupsBeautyFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r1, Sticker r2, String r3, float r4) {
            ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
            LiveMakeupsBeautyFragment r14 = this.a;
            if (r14.j == true) goto L5;
            return;
        L5:
            if (r14.k == false) goto L11;
            RecyclerView r15 = r14.S90(2131379485);
            if (r15 == null) goto L12;
            r15.post(new a(this, r8, r9, r11, r12));
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final LiveMakeupsBeautyAdapter T90() {
        return (LiveMakeupsBeautyAdapter) this.f.getValue();
    }

    public final void V90() {
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.d r1 = (com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.i).b().f();
        r1.getClass();
        this.e = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(r1.c).a().o(d0.k));
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(LiveEffectContext.a.a(this.i).b().f(), this.e, "ttlive_anchor_effect_LiveMakeupsBeautyFragment_resetSelectSticker_");
        LiveMakeupsBeautyAdapter r2 = T90();
        Sticker r3 = this.e;
        int r4 = r2.c;
        Iterator r5 = ((ArrayList) r2.a).iterator();
        int r6 = 0;
    L4:
        if (r5.hasNext() == false) goto L9;
        if (((Sticker) r5.next()).equals(r3) == true) goto L10;
        r6 = r6 + 1;
    L10:
        int r7 = r6 + 1;
        r2.c = r7;
        if (r7 >= 0) goto L13;
    L16:
        U90();
        return;
    L13:
        if (r7 >= r2.getItemCount()) goto L16;
        r2.notifyItemChanged(r4);
        r2.notifyItemChanged(r2.c);
        goto L16
    L9:
        r6 = -1;
        goto L10
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.i).a().K(this.m);
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.i).b().h().a(this.n, d0.k);
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public LiveMakeupsBeautyFragment() {
        this.d = new LinkedHashMap();
        this.f = LazyKt.lazy(new LiveMakeupsBeautyFragment$makeupsAdapter$2(this));
        this.g = LazyKt.lazy(new LiveMakeupsBeautyFragment$inflater$2(this));
        this.h = new HashMap();
        this.i = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.m = new e(this);
        this.n = new d(this);
        this.o = new c(this);
    }

    public final void U90() {
        LinearLayout r1 = (LinearLayout) S90(2131385751);
        if (r1 == null) goto L5;
        r1.removeAllViews();
    L5:
        List<String> r2 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U(d0.k) <= 0) goto L9;
        return;
    L9:
        if (getContext() != null) goto L11;
        return;
    L11:
        Sticker r3 = this.e;
        if (r3 == null) goto L14;
        List r4 = r3.getComposerConfigList();
    L16:
        if (Lists.isEmpty(r4) == false) goto L18;
        return;
    L18:
        Sticker r5 = this.e;
        if (r5 == null) goto L56;
        List r6 = r5.getComposerConfigList();
        if (r6 == null) goto L65;
        Iterator r7 = r6.iterator();
    L24:
        if (r7.hasNext() == false) goto L66;
        Sticker.ComposerConfig r8 = (Sticker.ComposerConfig) r7.next();
        if (((HashMap) this.h).containsKey(r8.getTag()) == true) goto L37;
        Context r9 = getContext();
        if (this.j == false) goto L31;
        if (r9 == null) goto L31;
        ConstraintLayout r11 = new BeautifyAdjustPercentBar(r9, null, 6, 0);
    L32:
        Sticker r12 = this.e;
        Intrinsics.checkNotNull(r12);
        b r13 = new b(this, r11, r12, r8);
        Map<String, b> r14 = this.h;
        Sticker r15 = this.e;
        if (r15 == null) goto L35;
        String r16 = r15.getEffectId();
    L36:
        ((HashMap) r14).put(Intrinsics.stringPlus(r16, r8.getTag()), r13);
        goto L37
    L35:
        r16 = null;
    L31:
        r11 = ((LayoutInflater) this.g.getValue()).inflate(2131565910, (ViewGroup) S90(2131385751), false);
    L37:
        Map<String, b> r17 = this.h;
        Sticker r18 = this.e;
        if (r18 == null) goto L40;
        String r19 = r18.getEffectId();
    L41:
        b r21 = (b) ((HashMap) r17).get(Intrinsics.stringPlus(r19, r8.getTag()));
        if (r21 == null) goto L24;
        ((LinearLayout) S90(2131385751)).addView(r21.b);
        List<String> r22 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.a r23 = LiveEffectContext.a.a(this.i).b().f();
        Sticker r24 = this.e;
        if (r24 == null) goto L47;
        String r25 = r24.getEffectId();
        if (r25 == null) goto L47;
    L48:
        com.bytedance.android.live.effect.beauty.makeups.d r26 = (com.bytedance.android.live.effect.beauty.makeups.d) r23;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r25, "effectId");
        Intrinsics.checkNotNullParameter(r8, "composerConfig");
        Float r27 = LiveEffectContext.a.a(r26.c).a().G(r25, r8.getTag());
        if (r27 != null) goto L51;
        int r28 = r8.getDefaultValue();
    L52:
        Object r29 = r21.b;
        if ((r29 instanceof BeautifyAdjustPercentBar) == true) goto L54;
        r21.a.setPercent(r28);
        goto L24
    L54:
        ((BeautifyAdjustPercentBar) r29).setPercent(r28);
        goto L24
    L51:
        r28 = q.a(r8, r27.floatValue());
    L47:
        r25 = "";
        goto L48
    L40:
        r19 = null;
        goto L41
    L66:
        return;
    L65:
        return;
    L56:
        return;
    L14:
        r4 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        LiveMakeupsBeautyAdapter r0 = T90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.a r2 = LiveEffectContext.a.a(r0.h).b().f();
        LiveMakeupsBeautyAdapter.b r3 = r0.f;
        com.bytedance.android.live.effect.beauty.makeups.d r4 = (com.bytedance.android.live.effect.beauty.makeups.d) r2;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r4.b.contains(r3) == false) goto L5;
        r4.b.remove(r3);
    L5:
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveMakeupsBeautyAdapter r0 = T90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.a r2 = LiveEffectContext.a.a(r0.h).b().f();
        LiveMakeupsBeautyAdapter.b r3 = r0.f;
        com.bytedance.android.live.effect.beauty.makeups.d r4 = (com.bytedance.android.live.effect.beauty.makeups.d) r2;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r4.b.contains(r3) == true) goto L6;
        r4.b.add(r3);
        return;
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

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        View r6 = LayoutInflater.from(getContext()).inflate(2131565849, null);
        r6.setOnClickListener(new com.bytedance.android.live.effect.beauty.makeups.c(this));
        S90(2131379484).setBuilder(new LoadingStatusView.Builder(getContext()).setErrorView(r6).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        if (this.j == true) goto L5;
    L6:
        S90(2131379484).showLoading();
    L7:
        List<String> r7 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.i).a().l(this.m);
        if (this.j == false) goto L10;
        S90(2131379485).addItemDecoration(new LiveMakeupsBeautyFragment$initView$2());
    L10:
        RecyclerView r8 = S90(2131379485);
        r8.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r8.setAdapter(T90());
        if (this.l == false) goto L14;
        r8.addItemDecoration(new BeautyItemDecoration());
    L14:
        if (this.j == false) goto L16;
        a1.k(S90(2131379485), s1.f(102.0f));
        a1.l(S90(2131385751), s1.f(228.0f));
    L16:
        U90();
        com.bytedance.android.live.effect.beauty.makeups.a r9 = LiveEffectContext.a.a(this.i).b().f();
        com.bytedance.android.live.effect.beauty.makeups.d r11 = (com.bytedance.android.live.effect.beauty.makeups.d) r9;
        r11.b(this.o);
        V90();
        if (LiveEffectContext.a.a(this.i).b().h().c() == false) goto L20;
        LiveEffectContext.a.a(this.i).b().h().f(this.n, d0.k);
        return;
    L20:
        return;
    L5:
        if (((ArrayList) T90().a).isEmpty() == false) goto L7;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.l == false) goto L5;
        int r5 = 2131565869;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565868;
        goto L7
    }
}
