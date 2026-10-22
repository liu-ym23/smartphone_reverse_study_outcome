package com.bytedance.android.live.effect.beauty.body;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.utils.BeautyWithSwitchItemDecoration;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/body/LiveBodyBeautyListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBodyBeautyListFragment extends BaseFragment {
    public static final /* synthetic */ int y = 0;
    public Map<Integer, View> d;
    public Disposable e;
    public Sticker f;
    public boolean g;
    public View h;
    public View i;
    public int j;
    public int k;
    public LiveEffectContextFactoryDelegate$Type l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final Lazy q;
    public boolean r;
    public final e s;
    public final c t;
    public final Lazy u;
    public final Lazy v;
    public View w;
    public final b x;

    public static final class a {
    }

    public static final class b implements LiveSmallItemBeautyHelper.c {
        public final /* synthetic */ LiveBodyBeautyListFragment a;

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131386947);
            if (r0 == null) goto L6;
            r0.showError();
            return;
        }

        public b(LiveBodyBeautyListFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onSuccess(List<Sticker> r6) {
            Intrinsics.checkNotNullParameter(r6, "stickerList");
            LiveBodyBeautyListFragment r0 = this.a;
            int r1 = LiveBodyBeautyListFragment.y;
            LiveBodyBeautyAdapter r2 = r0.U90();
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
        L4:
            if (r8.hasNext() == false) goto L6;
            r7.add(((Sticker) r8.next()).getEffectId());
            goto L4
        L6:
            ((ArrayList) r4).addAll(r7);
            r2.notifyDataSetChanged();
            LiveBodyBeautyListFragment r9 = this.a;
            if (r9.f != null) goto L12;
            if (m90.b.j.c(r9.l).booleanValue() == false) goto L12;
            LiveBodyBeautyListFragment r11 = this.a;
            r11.f = (Sticker) ListProtector.get(r6, 0);
        L12:
            if (this.a.S90(2131386947) == null) goto L14;
            this.a.S90(2131386947).setVisibility(8);
        L14:
            this.a.X90();
        }
    }

    public static final class c implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveBodyBeautyListFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveBodyBeautyListFragment r0 = this.a;
            int r1 = LiveBodyBeautyListFragment.y;
            r0.X90();
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveBodyBeautyListFragment r0 = this.a;
            int r1 = LiveBodyBeautyListFragment.y;
            r0.getClass();
            List<String> r2 = LiveEffectContext.h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r0.l).a(), "livebody", "LiveBodyBeautyListFragment_onBeautyModeChange");
            LiveEffectContext.a.a(r0.l).b().p().b(r0.x);
        }

        public c(LiveBodyBeautyListFragment r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveBodyBeautyListFragment a;

        public d(LiveBodyBeautyListFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            n90.b r4 = (n90.b) r3;
            if (Intrinsics.areEqual(r4.a, "livebody") == false) goto L6;
            LiveBodyBeautyListFragment r0 = this.a;
            r0.n = true;
            r0.o = r4.b;
            return;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {
        public final /* synthetic */ LiveBodyBeautyListFragment a;

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
                LiveBodyBeautyListFragment r0 = this.a.a;     // Catch: Throwable -> L4
                int r1 = LiveBodyBeautyListFragment.y;     // Catch: Throwable -> L4
                LiveBodyBeautyAdapter r2 = r0.U90();     // Catch: Throwable -> L4
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

        public e(LiveBodyBeautyListFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r1, Sticker r2, String r3, float r4) {
            ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
            LiveBodyBeautyListFragment r14 = this.a;
            if (r14.m == false) goto L7;
            if (r14.r == false) goto L7;
        L10:
            RecyclerView r15 = r14.S90(2131386948);
            if (r15 == null) goto L16;
            r15.post(new a(this, r8, r9, r11, r12));
            return;
        L16:
            return;
        L7:
            if (r14.p == true) goto L9;
            return;
        L9:
            if (r14.r == true) goto L10;
        }
    }

    static {
    }

    public final LiveBodyBeautyAdapter U90() {
        return (LiveBodyBeautyAdapter) this.q.getValue();
    }

    public final View V90() {
        return (View) this.v.getValue();
    }

    public final View W90() {
        return (View) this.u.getValue();
    }

    public final void T90() {
        List<String> r0 = LiveEffectContext.h;
        Iterator<T> r1 = LiveEffectContext.a.a(this.l).a().o("livebody").iterator();
        boolean r2 = false;
    L4:
        if (r1.hasNext() == false) goto L39;
        Sticker r3 = (Sticker) r1.next();
        float r6 = 0.0f;
        String r7 = "";
        if (this.m == true) goto L7;
        Sticker.ComposerConfig r5 = r3.getSmallItemConfig();
        if (r5 == null) goto L26;
        int r8 = r5.getDefaultValue();
    L27:
        List<String> r9 = LiveEffectContext.h;
        ILiveEffectComposerManager r11 = LiveEffectContext.a.a(this.l).a();
        String r12 = r3.getEffectId();
        Sticker.ComposerConfig r4 = r3.getSmallItemConfig();
        if (r4 == null) goto L33;
        String r13 = r4.getTag();
        if (r13 == null) goto L33;
        r7 = r13;
    L33:
        Float r14 = r11.G(r12, r7);
        if (r14 == null) goto L37;
        r6 = r14.floatValue();
    L37:
        if (r6 <= r8) goto L4;
    L38:
        r2 = true;
        goto L4
    L26:
        r8 = 0;
        goto L27
    L7:
        Sticker.ComposerConfig r15 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r3.getComposerConfigList());
        if (r15 == null) goto L10;
        int r16 = r15.getDefaultValue();
    L11:
        float r17 = com.bytedance.android.live.effect.q.d(r3, r16);
        List<String> r18 = LiveEffectContext.h;
        ILiveEffectComposerManager r19 = LiveEffectContext.a.a(this.l).a();
        String r21 = r3.getEffectId();
        Sticker.ComposerConfig r22 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r3.getComposerConfigList());
        if (r22 == null) goto L17;
        String r23 = r22.getTag();
        if (r23 == null) goto L17;
        r7 = r23;
    L17:
        Float r24 = r19.G(r21, r7);
        if (r24 == null) goto L21;
        r6 = r24.floatValue();
    L21:
        if (r6 == r17) goto L4;
    L10:
        r16 = 0;
        goto L11
    L39:
        this.g = r2;
        if (r2 == false) goto L42;
        V90().setClickable(true);
        V90().setAlpha(1.0f);
        V90().setContentDescription(s1.B(2131916374));
        return;
    L42:
        V90().setClickable(false);
        V90().setAlpha(0.5f);
        V90().setContentDescription(s1.B(2131916377));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.l).a().K(this.s);
        super.onDestroy();
        Disposable r1 = this.e;
        if (r1 != null) goto L5;
    L7:
        this.e = null;
        return;
    L5:
        if (r1.isDisposed() == true) goto L7;
        r1.dispose();
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.l).b().h().a(this.t, "livebody");
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public LiveBodyBeautyListFragment() {
        this.d = new LinkedHashMap();
        this.g = true;
        this.j = 2131565895;
        this.k = 2131565892;
        this.l = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        new com.bytedance.android.live.effect.sticker.e(FileUtils.BEAUTY);
        this.q = LazyKt.lazy(new LiveBodyBeautyListFragment$beautyAdapter$2(this));
        this.s = new e(this);
        this.t = new c(this);
        this.u = LazyKt.lazy(new LiveBodyBeautyListFragment$smallItemBeautySeekBar$2(this));
        this.v = LazyKt.lazy(new LiveBodyBeautyListFragment$smallItemBeautyResetView$2(this));
        this.x = new b(this);
    }

    public final void X90() {
        if (W90() != null) goto L6;
        return;
    L6:
        if (m90.b.j.c(this.l).booleanValue() == true) goto L12;
        W90().setVisibility(8);
        RecyclerView r0 = S90(2131386948);
        if (r0 == null) goto L10;
        r0.setAlpha(0.75f);
    L10:
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.l).a().T("ttlive_anchor_effect_LiveBodyBeautyListFragment_refreshView_enable", false);
        return;
    L12:
        RecyclerView r2 = S90(2131386948);
        if (r2 == null) goto L15;
        r2.setAlpha(1.0f);
    L15:
        List<String> r3 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.l).a().T("ttlive_anchor_effect_LiveBodyBeautyListFragment_refreshView_disable", false);
        if (LiveEffectContext.a.a(this.l).a().U("livebody") <= 0) goto L19;
        W90().setVisibility(8);
        return;
    L19:
        Sticker r4 = this.f;
        Object r5 = null;
        if (r4 == null) goto L22;
        Sticker.ComposerConfig r6 = r4.getSmallItemConfig();
    L23:
        if (r6 != null) goto L26;
        W90().setVisibility(8);
        return;
    L26:
        W90().setVisibility(0);
        View r7 = W90();
        Sticker r8 = this.f;
        if (r8 == null) goto L29;
        String r9 = r8.getName();
    L30:
        r7.setTag(r9);
        ILiveEffectComposerManager r11 = LiveEffectContext.a.a(this.l).a();
        Sticker r12 = this.f;
        String r13 = "";
        if (r12 == null) goto L34;
        String r14 = r12.getEffectId();
        if (r14 == null) goto L34;
    L35:
        Sticker r15 = this.f;
        if (r15 == null) goto L43;
        Sticker.ComposerConfig r16 = r15.getSmallItemConfig();
        if (r16 == null) goto L43;
        String r17 = r16.getTag();
        if (r17 == null) goto L43;
        r13 = r17;
    L43:
        Float r18 = r11.G(r14, r13);
        if (r18 != null) goto L52;
        Sticker r19 = this.f;
        Intrinsics.checkNotNull(r19);
        Sticker r21 = this.f;
        if (r21 == null) goto L50;
        Sticker.ComposerConfig r22 = r21.getSmallItemConfig();
        if (r22 == null) goto L50;
        Integer r23 = Integer.valueOf(r22.getDefaultValue());
    L51:
        Intrinsics.checkNotNull(r23);
        r18 = Float.valueOf(com.bytedance.android.live.effect.q.d(r19, r23.intValue()));
    L50:
        r23 = null;
    L52:
        Sticker r24 = this.f;
        if (r24 == null) goto L75;
        Sticker.ComposerConfig r25 = r24.getSmallItemConfig();
        if (r25 == null) goto L75;
        if (r25.getDoubleDirection() != true) goto L75;
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L67;
        Object r26 = W90();
        if ((r26 instanceof BeautifyAdjustPercentBar) == true) goto L63;
        r26 = null;
    L63:
        BeautifyAdjustPercentBar r27 = (BeautifyAdjustPercentBar) r26;
        if (r27 == null) goto L91;
        r27.Y5(50, -50, 0, false);
    L91:
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L100;
        View r28 = W90();
        if ((r28 instanceof BeautifyAdjustPercentBar) == false) goto L96;
        r5 = r28;
    L96:
        BeautifyAdjustPercentBar r29 = (BeautifyAdjustPercentBar) r5;
        if (r29 == null) goto L108;
        Sticker r31 = this.f;
        Intrinsics.checkNotNull(r31);
        r29.setPercent(com.bytedance.android.live.effect.q.b(r31, r18.floatValue()));
    L108:
        Sticker r32 = this.f;
        if (r32 == null) goto L112;
        LiveEffectContext.a.a(this.l).a().a("livebody", r32, "ttlive_anchor_effect_LiveBodyBeautyListFragment_refreshView");
        return;
    L112:
        return;
    L100:
        if ((W90() instanceof AdjustPercentBar) == false) goto L108;
        View r33 = W90();
        if ((r33 instanceof AdjustPercentBar) == false) goto L105;
        r5 = r33;
    L105:
        AdjustPercentBar r34 = (AdjustPercentBar) r5;
        if (r34 == null) goto L108;
        Sticker r35 = this.f;
        Intrinsics.checkNotNull(r35);
        r34.setPercent(com.bytedance.android.live.effect.q.b(r35, r18.floatValue()));
        goto L108
    L67:
        if ((W90() instanceof AdjustPercentBar) == false) goto L91;
        View r36 = W90();
        if ((r36 instanceof AdjustPercentBar) == true) goto L71;
        r36 = null;
    L71:
        AdjustPercentBar r37 = (AdjustPercentBar) r36;
        if (r37 == null) goto L91;
        r37.e(50, -50, 0, false);
    L75:
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L83;
        Object r38 = W90();
        if ((r38 instanceof BeautifyAdjustPercentBar) == true) goto L79;
        r38 = null;
    L79:
        BeautifyAdjustPercentBar r39 = (BeautifyAdjustPercentBar) r38;
        if (r39 == null) goto L91;
        r39.Y5(100, 0, 0, true);
        goto L91
    L83:
        if ((W90() instanceof AdjustPercentBar) == false) goto L91;
        View r41 = W90();
        if ((r41 instanceof AdjustPercentBar) == true) goto L87;
        r41 = null;
    L87:
        AdjustPercentBar r42 = (AdjustPercentBar) r41;
        if (r42 == null) goto L91;
        r42.e(100, 0, 0, true);
    L34:
        r14 = "";
        goto L35
    L29:
        r9 = null;
        goto L30
    L22:
        r6 = null;
        goto L23
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        LiveBodyBeautyAdapter r0 = U90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        g r2 = LiveEffectContext.a.a(r0.l).b().p();
        LiveBodyBeautyAdapter.c r3 = r0.h;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((ArrayList) r2.b).contains(r3) == false) goto L5;
        ((ArrayList) r2.b).remove(r3);
    L5:
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveBodyBeautyAdapter r0 = U90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        g r2 = LiveEffectContext.a.a(r0.l).b().p();
        LiveBodyBeautyAdapter.c r3 = r0.h;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((ArrayList) r2.b).contains(r3) == true) goto L6;
        ((ArrayList) r2.b).add(r3);
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

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        View r7 = LayoutInflater.from(getContext()).inflate(2131563550, null);
        r7.setOnClickListener(new l(this));
        S90(2131386947).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r7).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        S90(2131386947).showLoading();
        if (this.p == false) goto L5;
        int r8 = 2131107406;
    L7:
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L15;
        Object r9 = W90();
        if ((r9 instanceof BeautifyAdjustPercentBar) == true) goto L11;
        r9 = null;
    L11:
        BeautifyAdjustPercentBar r11 = (BeautifyAdjustPercentBar) r9;
        if (r11 == null) goto L22;
        r11.U5(s1.h(r8), s1.h(2131107403), s1.h(2131107402));
    L22:
        this.w = V90().findViewById(2131384418);
        TextView r12 = (TextView) V90().findViewById(2131384419);
        n r13 = new n(this);
        if ((W90() instanceof BeautifyAdjustPercentBar) == false) goto L31;
        Object r14 = W90();
        if ((r14 instanceof BeautifyAdjustPercentBar) == true) goto L27;
        r14 = null;
    L27:
        BeautifyAdjustPercentBar r15 = (BeautifyAdjustPercentBar) r14;
        if (r15 == null) goto L38;
        r15.setOnLevelChangeListener(r13);
    L38:
        List<String> r16 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.l).a().l(this.s);
        RecyclerView r17 = S90(2131386948);
        r17.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r17.setAdapter(U90());
        if (this.p == false) goto L42;
        r17.addItemDecoration(new BeautyWithSwitchItemDecoration());
    L42:
        if (this.m == false) goto L47;
        View r18 = getView();
        if (r18 == null) goto L46;
        a1.k(r18, s1.f(102.0f));
    L46:
        a1.k(S90(2131386948), s1.f(102.0f));
        S90(2131386948).addItemDecoration(new LiveBodyBeautyListFragment$initView$2());
    L47:
        V90().setOnClickListener(new m(this));
        X90();
        T90();
        LiveEffectContext.a.a(this.l).b().p().b(this.x);
        if (LiveEffectContext.a.a(this.l).b().h().c() == false) goto L50;
        LiveEffectContext.a.a(this.l).b().h().f(this.t, "livebody");
    L50:
        Disposable r19 = this.e;
        if (r19 != null) goto L53;
    L55:
        this.e = null;
        this.e = xs2.b.a().b(n90.b.class).subscribe(new d(this));
        return;
    L53:
        if (r19.isDisposed() == true) goto L55;
        r19.dispose();
        goto L55
    L31:
        if ((W90() instanceof AdjustPercentBar) == false) goto L38;
        View r21 = W90();
        if ((r21 instanceof AdjustPercentBar) == true) goto L35;
        r21 = null;
    L35:
        AdjustPercentBar r22 = (AdjustPercentBar) r21;
        if (r22 == null) goto L38;
        r22.setOnLevelChangeListener(r13);
        goto L38
    L15:
        if ((W90() instanceof AdjustPercentBar) == false) goto L22;
        View r23 = W90();
        if ((r23 instanceof AdjustPercentBar) == true) goto L19;
        r23 = null;
    L19:
        AdjustPercentBar r24 = (AdjustPercentBar) r23;
        if (r24 == null) goto L22;
        r24.c(s1.h(r8), s1.h(2131107403), s1.h(2131107402));
        goto L22
    L5:
        r8 = 2131107405;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.p == false) goto L5;
        int r5 = 2131565873;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565872;
        goto L7
    }
}
