package com.bytedance.android.live.effect.beauty.smallitem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.utils.BeautyWithSwitchItemDecoration;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallItemBeautyFragment extends BaseFragment {
    public static final /* synthetic */ int y = 0;
    public Map<Integer, View> d;
    public Disposable e;
    public Sticker f;
    public View g;
    public AdjustPercentBar h;
    public int i;
    public int j;
    public LiveEffectContextFactoryDelegate$Type k;
    public final com.bytedance.android.live.effect.sticker.e l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Lazy p;
    public boolean q;
    public final e r;
    public final c s;
    public final Lazy t;
    public final Lazy u;
    public View v;
    public View w;
    public final b x;

    public static final class a {
    }

    public static final class b implements LiveSmallItemBeautyHelper.c {
        public final /* synthetic */ LiveSmallItemBeautyFragment a;

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131386947);
            if (r0 == null) goto L5;
            r0.showError();
        L5:
            this.a.l.m();
        }

        public b(LiveSmallItemBeautyFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
        public final void onSuccess(List<Sticker> r4) {
            Intrinsics.checkNotNullParameter(r4, "stickerList");
            if (r4.isEmpty() == false) goto L5;
            LiveEffectMonitor.d(com.bytedance.android.live.effect.api.d0.i, 1000, "empty list");
        L5:
            LiveSmallItemBeautyFragment r0 = this.a;
            int r1 = LiveSmallItemBeautyFragment.y;
            LiveSmallItemBeautyAdapter r2 = r0.T90();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "list");
            ((ArrayList) r2.a).clear();
            ArrayList r3 = (ArrayList) r2.a;
            r3.addAll(r4);
            r2.notifyDataSetChanged();
            List<String> r5 = LiveEffectContext.h;
            if (LiveEffectContext.a.a(this.a.k).b().h().c() == true) goto L8;
            LiveSmallItemBeautyFragment r6 = this.a;
            if (r6.f == null) goto L13;
        L16:
            if (m90.b.a.c(this.a.k).booleanValue() == false) goto L19;
            LiveSmallItemBeautyFragment r7 = this.a;
            r7.f = (Sticker) ListProtector.get(r4, 0);
        L19:
            if (this.a.S90(2131386947) == null) goto L21;
            this.a.S90(2131386947).setVisibility(8);
        L21:
            this.a.V90("ttlive_anchor_effect_LiveSmallItemBeautyFragment_beautyLoadCallback_onSuccess");
            this.a.getClass();
            return;
        L13:
            if (m90.b.a.c(r6.k).booleanValue() == false) goto L16;
            LiveSmallItemBeautyFragment r8 = this.a;
            r8.f = (Sticker) ListProtector.get(r4, 0);
            goto L16
        L8:
            if (m90.b.a.c(this.a.k).booleanValue() == false) goto L16;
            LiveSmallItemBeautyFragment r9 = this.a;
            r9.f = (Sticker) ListProtector.get(r4, 0);
            goto L16
        }
    }

    public static final class c implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveSmallItemBeautyFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveSmallItemBeautyFragment r0 = this.a;
            int r1 = LiveSmallItemBeautyFragment.y;
            r0.V90("BeautyModeChangeListener_onChangeComplete");
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveSmallItemBeautyFragment r0 = this.a;
            int r1 = LiveSmallItemBeautyFragment.y;
            r0.getClass();
            List<String> r2 = LiveEffectContext.h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r0.k).a(), com.bytedance.android.live.effect.api.d0.i, "LiveSmallItemBeautyFragment_onBeautyModeChange");
            LiveSmallItemBeautyHelper.d(LiveEffectContext.a.a(r0.k).b().g(), r0.x, 10);
        }

        public c(LiveSmallItemBeautyFragment r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveSmallItemBeautyFragment a;

        public d(LiveSmallItemBeautyFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            n90.b r4 = (n90.b) r3;
            if (Intrinsics.areEqual(r4.a, com.bytedance.android.live.effect.api.d0.i) == false) goto L6;
            LiveSmallItemBeautyFragment r0 = this.a;
            r0.m = true;
            r0.n = r4.b;
            return;
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {
        public final /* synthetic */ LiveSmallItemBeautyFragment a;

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
                LiveSmallItemBeautyFragment r0 = this.a.a;     // Catch: Throwable -> L4
                int r1 = LiveSmallItemBeautyFragment.y;     // Catch: Throwable -> L4
                LiveSmallItemBeautyAdapter r2 = r0.T90();     // Catch: Throwable -> L4
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

        public e(LiveSmallItemBeautyFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r1, Sticker r2, String r3, float r4) {
            ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
            LiveSmallItemBeautyFragment r14 = this.a;
            if (r14.o == true) goto L5;
            return;
        L5:
            if (r14.q == false) goto L11;
            RecyclerView r15 = r14.S90(2131386948);
            if (r15 == null) goto L12;
            r15.post(new a(this, r8, r9, r11, r12));
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final LiveSmallItemBeautyAdapter T90() {
        return (LiveSmallItemBeautyAdapter) this.p.getValue();
    }

    public final AdjustPercentBar U90() {
        return (AdjustPercentBar) this.t.getValue();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().K(this.r);
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
        LiveEffectContext.a.a(this.k).b().h().a(this.s, com.bytedance.android.live.effect.api.d0.i);
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public LiveSmallItemBeautyFragment() {
        this.d = new LinkedHashMap();
        this.i = 2131565895;
        this.j = 2131565892;
        this.k = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.l = new com.bytedance.android.live.effect.sticker.e(FileUtils.BEAUTY);
        this.p = LazyKt.lazy(new LiveSmallItemBeautyFragment$beautyAdapter$2(this));
        this.r = new e(this);
        this.s = new c(this);
        this.t = LazyKt.lazy(new LiveSmallItemBeautyFragment$smallItemBeautySeekBar$2(this));
        this.u = LazyKt.lazy(new LiveSmallItemBeautyFragment$smallItemBeautyResetView$2(this));
        this.x = new b(this);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        LiveSmallItemBeautyAdapter r0 = T90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.k).b().g().e(r0.g);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveSmallItemBeautyAdapter r0 = T90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.k).b().g().a(r0.g);
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
        if (U90() != null) goto L6;
        return;
    L6:
        if (m90.b.a.c(this.k).booleanValue() == true) goto L13;
        U90().setVisibility(8);
        if (S90(2131386948) == null) goto L10;
        S90(2131386948).setAlpha(0.75f);
    L10:
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().T(r7, false);
        return;
    L13:
        if (S90(2131386948) == null) goto L15;
        S90(2131386948).setAlpha(1.0f);
    L15:
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().T(r7, false);
        ILiveEffectComposerManager r8 = LiveEffectContext.a.a(this.k).a();
        String r2 = com.bytedance.android.live.effect.api.d0.i;
        if (r8.U(r2) <= 0) goto L19;
        U90().setVisibility(8);
        return;
    L19:
        Sticker r9 = this.f;
        Integer r3 = null;
        if (r9 == null) goto L22;
        Sticker.ComposerConfig r11 = r9.getSmallItemConfig();
    L23:
        if (r11 != null) goto L26;
        U90().setVisibility(8);
        return;
    L26:
        U90().setVisibility(0);
        AdjustPercentBar r12 = U90();
        Sticker r4 = this.f;
        if (r4 == null) goto L29;
        String r5 = r4.getName();
    L30:
        r12.setTag(r5);
        ILiveEffectComposerManager r13 = LiveEffectContext.a.a(this.k).a();
        Sticker r6 = this.f;
        String r14 = "";
        if (r6 == null) goto L34;
        String r15 = r6.getEffectId();
        if (r15 == null) goto L34;
    L35:
        Sticker r16 = this.f;
        if (r16 == null) goto L43;
        Sticker.ComposerConfig r17 = r16.getSmallItemConfig();
        if (r17 == null) goto L43;
        String r18 = r17.getTag();
        if (r18 == null) goto L43;
        r14 = r18;
    L43:
        Float r19 = r13.G(r15, r14);
        if (r19 != null) goto L51;
        Sticker r21 = this.f;
        Intrinsics.checkNotNull(r21);
        Sticker r22 = this.f;
        if (r22 == null) goto L50;
        Sticker.ComposerConfig r23 = r22.getSmallItemConfig();
        if (r23 == null) goto L50;
        r3 = Integer.valueOf(r23.getDefaultValue());
    L50:
        Intrinsics.checkNotNull(r3);
        r19 = Float.valueOf(com.bytedance.android.live.effect.q.d(r21, r3.intValue()));
    L51:
        AdjustPercentBar r24 = U90();
        Sticker r25 = this.f;
        Intrinsics.checkNotNull(r25);
        r24.setPercent(com.bytedance.android.live.effect.q.b(r25, r19.floatValue()));
        Sticker r26 = this.f;
        if (r26 == null) goto L58;
        Sticker.ComposerConfig r27 = r26.getSmallItemConfig();
        if (r27 == null) goto L58;
        if (r27.getDoubleDirection() != true) goto L58;
        U90().e(50, -50, 0, false);
    L59:
        ILiveEffectComposerManager r28 = LiveEffectContext.a.a(this.k).a();
        Sticker r29 = this.f;
        Intrinsics.checkNotNull(r29);
        r28.a(r2, r29, "ttlive_anchor_effect_LiveSmallItemBeautyFragment_refreshView");
        return;
    L58:
        U90().e(100, 0, 0, true);
    L34:
        r15 = "";
        goto L35
    L29:
        r5 = null;
        goto L30
    L22:
        r11 = null;
        goto L23
    }

    public final void W90(String r5) {
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r1 = LiveEffectContext.a.a(this.k).e();
        HashMap<String, String> r2 = new HashMap();
        r2.put("event_page", "live_take_detail");
        r2.put("evnet_type", "click");
        r2.put("evnet_belong", "live_take");
        Unit r3 = Unit.INSTANCE;
        r1.sendLog(r5, r2);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        View r7 = LayoutInflater.from(getContext()).inflate(2131563550, null);
        r7.setOnClickListener(new z(this));
        S90(2131386947).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r7).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        S90(2131386947).showLoading();
        U90().c(s1.h(2131107404), s1.h(2131107403), s1.h(2131107402));
        this.v = ((View) this.u.getValue()).findViewById(2131374718);
        this.w = ((View) this.u.getValue()).findViewById(2131384419);
        U90().setOnLevelChangeListener(new a0(this));
        if (this.o == false) goto L5;
        List<String> r8 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().l(this.r);
    L5:
        RecyclerView r9 = S90(2131386948);
        r9.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        if (this.o == false) goto L8;
        r9.addItemDecoration(new BeautyWithSwitchItemDecoration());
    L8:
        r9.setAdapter(T90());
        ((View) this.u.getValue()).setOnClickListener(new b0(this));
        V90("ttlive_anchor_effect_LiveSmallItemBeautyFragment_beautyInitView");
        List<String> r11 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().a().a();
        LiveSmallItemBeautyHelper.d(LiveEffectContext.a.a(this.k).b().g(), this.x, 10);
        if (LiveEffectContext.a.a(this.k).b().h().c() == false) goto L11;
        LiveEffectContext.a.a(this.k).b().h().f(this.s, com.bytedance.android.live.effect.api.d0.i);
    L11:
        Disposable r12 = this.e;
        if (r12 != null) goto L14;
    L16:
        this.e = null;
        this.e = xs2.b.a().b(n90.b.class).subscribe(new d(this));
        return;
    L14:
        if (r12.isDisposed() == true) goto L16;
        r12.dispose();
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.o == false) goto L5;
        int r5 = 2131565873;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565872;
        goto L7
    }
}
