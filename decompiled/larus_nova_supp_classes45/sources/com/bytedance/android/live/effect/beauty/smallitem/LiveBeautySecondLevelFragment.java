package com.bytedance.android.live.effect.beauty.smallitem;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveBeautySecondLevelFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "DivideItemDecoration", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautySecondLevelFragment extends BaseFragment {
    public static final /* synthetic */ int C = 0;
    public final d A;
    public boolean B;
    public Map<Integer, View> d;
    public Sticker e;
    public View f;
    public boolean g;
    public View h;
    public final int i;
    public final int j;
    public LiveEffectContextFactoryDelegate$Type k;
    public final com.bytedance.android.live.effect.sticker.e l;
    public String m;
    public final ArrayList<Integer> n;
    public final ArrayList<Integer> o;
    public final boolean p;
    public final Handler q;
    public final Lazy r;
    public final b s;
    public final Lazy t;
    public final Lazy u;
    public View v;
    public View w;
    public final c x;
    public final e y;
    public boolean z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveBeautySecondLevelFragment$DivideItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DivideItemDecoration extends RecyclerView.ItemDecoration {
        public final Paint a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final int f;
        public final ArrayList<Integer> g;

        public DivideItemDecoration(ArrayList<Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "conditionList");
            this.g = r2;
            Paint r3 = new Paint(5);
            r3.setColor(872415231);
            r3.setStyle(Paint.Style.FILL);
            Unit r0 = Unit.INSTANCE;
            this.a = r3;
            this.b = UtilityKotlinExtentionsKt.h(15);
            this.c = UtilityKotlinExtentionsKt.h(36);
            this.d = UtilityKotlinExtentionsKt.h(0.5f);
            float r4 = UtilityKotlinExtentionsKt.h(4.5f);
            this.e = r4;
            this.f = (int) (r4 * 2);
        }

        public final void onDraw(Canvas r11, RecyclerView r12, RecyclerView.State r13) {
            Intrinsics.checkNotNullParameter(r11, "c");
            Intrinsics.checkNotNullParameter(r12, "parent");
            Intrinsics.checkNotNullParameter(r13, "state");
            super.onDraw(r11, r12, r13);
            int r14 = r12.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r14) goto L8;
            View r1 = r12.getChildAt(r0);
            if (this.g.contains(Integer.valueOf(r12.getChildAdapterPosition(r1))) == false) goto L7;
            float r4 = r1.getLeft() - this.e;
            float r5 = this.b;
            r11.drawRect(r4, r5, r4 + this.d, r5 + this.c, this.a);
        L7:
            r0 = r0 + 1;
            goto L3
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            super.getItemOffsets(r2, r3, r4, r5);
            int r6 = r4.getChildAdapterPosition(r3);
            if (this.g.contains(Integer.valueOf(r6)) == false) goto L6;
            r2.set(this.f, 0, 0, 0);
            return;
        L6:
            if (r6 != 1) goto L8;
            r2.set((int) this.e, 0, 0, 0);
            return;
        L8:
            r2.set(0, 0, 0, 0);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveBeautySecondLevelFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveBeautySecondLevelFragment r0 = this.a;
            int r1 = LiveBeautySecondLevelFragment.C;
            r0.Z90("BeautyModeChangeListener_onChangeComplete");
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveBeautySecondLevelFragment r0 = this.a;
            int r1 = LiveBeautySecondLevelFragment.C;
            r0.getClass();
            List<String> r2 = LiveEffectContext.h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r0.k).a(), com.bytedance.android.live.effect.api.d0.i, "LiveBeautySecondLevelFragment_onBeautyModeChange");
            LiveEffectContext.a.a(r0.k).b().l().c("beautyclassify", r0.k, new WeakReference(r0.x), true);
        }

        public b(LiveBeautySecondLevelFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.android.live.effect.beauty.smallitem.b {
        public final /* synthetic */ LiveBeautySecondLevelFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ List b;

            public a(c r1, List r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                LiveBeautySecondLevelFragment r0 = this.a.a;
                List<EffectCategoryModel> r1 = this.b;
                int r2 = LiveBeautySecondLevelFragment.C;
                if (r0.isDestroyed() == true) goto L21;
                List<EffectCategoryModel> r3 = r1;
                if (r3 != null) goto L8;
            L11:
                boolean r4 = true;
            L12:
                if (r4 == true) goto L22;
                List<EffectCategoryModel> r5 = r1;
                ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
                Iterator r7 = r5.iterator();
            L16:
                if (r7.hasNext() == false) goto L18;
                r6.add(((EffectCategoryModel) r7.next()).getName());
                goto L16
            L18:
                LiveBeautySecLevelSlidingTab r8 = (LiveBeautySecLevelSlidingTab) r0.S90(2131364572);
                ((ArrayList) r8.A).clear();
                ((ArrayList) r8.A).addAll(r6);
                r8.a();
                ((LiveBeautySecLevelSlidingTab) r0.S90(2131364572)).setOnClickItemListener(new m(r0));
                ((LiveBeautySecLevelSlidingTab) r0.S90(2131364572)).b(0);
                List<String> r9 = LiveEffectContext.h;
                LiveEffectContext.a.a(r0.k).b().l().a(r0.k, "beautyclassify", r1, r0.A);
                return;
            L22:
                return;
            L8:
                if (r3.isEmpty() == true) goto L11;
                r4 = false;
                goto L12
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.b
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131386947);
            if (r0 == null) goto L5;
            r0.showError();
        L5:
            this.a.l.m();
        }

        public c(LiveBeautySecondLevelFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.b
        public final void onSuccess(List<EffectCategoryModel> r3) {
            Intrinsics.checkNotNullParameter(r3, "stickerCategoryList");
            this.a.q.post(new a(this, r3));
        }
    }

    public static final class d implements q {
        public final /* synthetic */ LiveBeautySecondLevelFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ List b;
            public final /* synthetic */ List c;

            public a(d r1, List r2, List r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                LiveBeautySecondLevelFragment r0 = this.a.a;
                List r1 = this.b;
                List r2 = this.c;
                r0.getClass();
                Intrinsics.checkNotNullParameter(r1, "stickerList");
                if (r0.isDestroyed() == false) goto L6;
                return;
            L6:
                if (r1.isEmpty() == false) goto L8;
                LiveEffectMonitor.d(com.bytedance.android.live.effect.api.d0.i, 1000, "empty list");
            L8:
                int r4 = 1;
                if (r0.p == false) goto L31;
                List r3 = r1;
                LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
                Iterator r8 = r3.iterator();
            L12:
                if (r8.hasNext() == false) goto L14;
                Object r11 = r8.next();
                r9.put(((Sticker) r11).getResourceId(), r11);
                goto L12
            L14:
                List<String> r12 = LiveEffectContext.h;
                com.bytedance.android.live.effect.beauty.smallitem.c r13 = LiveEffectContext.a.a(r0.k).b().b();
                int r14 = r13.d;
                if (r14 <= 0) goto L17;
                List r15 = CollectionsKt.take(r13.c, r14);
            L19:
                if ((!r15.isEmpty()) == false) goto L27;
                ArrayList r5 = new ArrayList();
                Iterator r16 = r15.iterator();
            L22:
                if (r16.hasNext() == false) goto L26;
                Sticker r17 = (Sticker) r9.get((String) r16.next());
                if (r17 == null) goto L22;
                r5.add(r17);
                goto L22
            L26:
                List r6 = CollectionsKt.plus(r5, r3);
                int r7 = r5.size();
            L28:
                if (r7 <= 0) goto L30;
                LiveBeautySecLevelSlidingTab r18 = (LiveBeautySecLevelSlidingTab) r0.S90(2131364572);
                ListProtector.add(r18.A, 0, "我的常用");
                r18.a();
                ((LiveBeautySecLevelSlidingTab) r0.S90(2131364572)).b(0);
            L30:
                List r19 = r6;
                int r21 = r7;
                r1 = r19;
            L32:
                LiveSmallItemBeautyTemplateAdapter r22 = r0.V90();
                r22.getClass();
                Intrinsics.checkNotNullParameter(r1, "list");
                ((ArrayList) r22.a).clear();
                ((ArrayList) r22.b).clear();
                ((LinkedHashMap) r22.c).clear();
                List r110 = r1;
                ((ArrayList) r22.a).addAll(r110);
                List<String> r23 = r22.b;
                List r111 = r1;
                ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
                Iterator r24 = r111.iterator();
            L34:
                if (r24.hasNext() == false) goto L36;
                r112.add(((Sticker) r24.next()).getEffectId());
                goto L34
            L36:
                ((ArrayList) r23).addAll(r112);
                r22.notifyDataSetChanged();
                r0.aa0(0);
                if (r0.e != null) goto L44;
                if (m90.b.a.c(r0.k).booleanValue() == false) goto L44;
                if ((!r110.isEmpty()) == false) goto L44;
                r0.e = (Sticker) ListProtector.get(r1, 0);
            L44:
                if (r0.S90(2131386947) == null) goto L46;
                r0.S90(2131386947).setVisibility(8);
            L46:
                if (r2 == null) goto L65;
                r0.n.clear();
                if (r0.p == false) goto L51;
                if (r21 <= 0) goto L51;
                r0.n.add(Integer.valueOf(r21));
            L51:
                Iterator r25 = r2.iterator();
                int r26 = 0;
            L53:
                if (r25.hasNext() == false) goto L64;
                int r27 = ((Number) r25.next()).intValue();
                if (r27 != 0) goto L62;
                LiveBeautySecLevelSlidingTab r28 = (LiveBeautySecLevelSlidingTab) r0.S90(2131364572);
                if (r26 >= 0) goto L59;
                r28.getClass();
            L63:
                r26 = r26 + 1;
                goto L53
            L59:
                if (r26 >= ((ArrayList) r28.A).size()) goto L63;
                ListProtector.remove(r28.A, r26);
                r28.a();
                goto L63
            L62:
                r0.n.add(Integer.valueOf(r27));
                goto L63
            L64:
                ((LiveBeautySecLevelSlidingTab) r0.S90(2131364572)).b(0);
            L65:
                r0.o.clear();
                int r29 = r0.n.size();
            L66:
                if (r4 >= r29) goto L68;
                r0.o.add(Integer.valueOf(r0.W90(r4)));
                r4 = r4 + 1;
                goto L66
            L68:
                r0.Z90("ttlive_anchor_effect_LiveBeautySecondLevelFragment_beautyLoadCallback_onSuccess");
                return;
            L27:
                r6 = r1;
                r7 = 0;
                goto L28
            L17:
                r15 = CollectionsKt.emptyList();
                goto L19
            L31:
                r21 = 0;
                goto L32
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void onError() {
            LoadingStatusView r0 = this.a.S90(2131386947);
            if (r0 == null) goto L5;
            r0.showError();
        L5:
            this.a.l.m();
        }

        public d(LiveBeautySecondLevelFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r3, List<Integer> r4) {
            Intrinsics.checkNotNullParameter(r3, "stickerList");
            if (r3.isEmpty() == false) goto L7;
            LoadingStatusView r5 = this.a.S90(2131386947);
            if (r5 == null) goto L9;
            r5.showError();
            return;
        L9:
            return;
        L7:
            this.a.q.post(new a(this, r3, r4));
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {
        public final /* synthetic */ LiveBeautySecondLevelFragment a;

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
                LiveBeautySecondLevelFragment r0 = this.a.a;     // Catch: Throwable -> L4
                int r1 = LiveBeautySecondLevelFragment.C;     // Catch: Throwable -> L4
                LiveSmallItemBeautyTemplateAdapter r2 = r0.V90();     // Catch: Throwable -> L4
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

        public e(LiveBeautySecondLevelFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r1, Sticker r2, String r3, float r4) {
            ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
            LiveBeautySecondLevelFragment r14 = this.a;
            if (r14.z == false) goto L8;
            RecyclerView r15 = r14.S90(2131386948);
            if (r15 == null) goto L9;
            r15.post(new a(this, r8, r9, r11, r12));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final LiveSmallItemBeautyTemplateAdapter V90() {
        return (LiveSmallItemBeautyTemplateAdapter) this.r.getValue();
    }

    public final View X90() {
        return (View) this.u.getValue();
    }

    public final View Y90() {
        return (View) this.t.getValue();
    }

    public final void U90() {
        List<String> r0 = LiveEffectContext.h;
        Iterator<T> r1 = LiveEffectContext.a.a(this.k).a().o(com.bytedance.android.live.effect.api.d0.i).iterator();
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
        ILiveEffectComposerManager r9 = LiveEffectContext.a.a(this.k).a();
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
        this.g = r2;
        if (r2 == false) goto L24;
        X90().setClickable(true);
        X90().setAlpha(1.0f);
        X90().setContentDescription(s1.B(2131916374));
        return;
    L24:
        X90().setClickable(false);
        X90().setAlpha(0.5f);
        X90().setContentDescription(s1.B(2131916377));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().K(this.y);
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).b().h().a(this.s, "beautyclassify");
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public LiveBeautySecondLevelFragment() {
        this.d = new LinkedHashMap();
        this.g = true;
        this.i = 2131565897;
        this.j = 2131565848;
        this.k = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.l = new com.bytedance.android.live.effect.sticker.e("beautyclassify");
        this.m = "";
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().b();
        this.q = new Handler(Looper.getMainLooper());
        this.r = LazyKt.lazy(new LiveBeautySecondLevelFragment$beautyAdapter$2(this));
        this.s = new b(this);
        this.t = LazyKt.lazy(new LiveBeautySecondLevelFragment$smallItemBeautySeekBar$2(this));
        this.u = LazyKt.lazy(new LiveBeautySecondLevelFragment$smallItemBeautyResetView$2(this));
        this.x = new c(this);
        this.y = new e(this);
        this.A = new d(this);
        this.B = true;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        LiveSmallItemBeautyTemplateAdapter r0 = V90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.m).b().g().e(r0.j);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveSmallItemBeautyTemplateAdapter r0 = V90();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.m).b().g().a(r0.j);
        if (this.B == true) goto L5;
        Z90("on resume");
        return;
    L5:
        this.B = false;
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

    public final int W90(int r4) {
        int r1 = 0;
        if (this.n.size() > r4) goto L5;
        return 0;
    L5:
        int r0 = 0;
    L6:
        if (r1 >= r4) goto L8;
        r0 = r0 + ((Number) ListProtector.get(this.n, r1)).intValue();
        r1 = r1 + 1;
        goto L6
    L8:
        if (r0 > 0) goto L10;
        return r0;
    L10:
        return r0 + 1;
    }

    public final void Z90(String r9) {
        if (Y90() != null) goto L5;
        return;
    L5:
        int r1 = 0;
        if (m90.b.a.c(this.k).booleanValue() == true) goto L13;
        Y90().setVisibility(8);
        if (S90(2131386948) == null) goto L10;
        S90(2131386948).setAlpha(0.75f);
    L10:
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().T(r9, false);
        return;
    L13:
        if (S90(2131386948) == null) goto L15;
        S90(2131386948).setAlpha(1.0f);
    L15:
        List<String> r2 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().T(r9, false);
        ILiveEffectComposerManager r11 = LiveEffectContext.a.a(this.k).a();
        String r3 = com.bytedance.android.live.effect.api.d0.i;
        if (r11.U(r3) <= 0) goto L19;
        Y90().setVisibility(8);
        return;
    L19:
        Sticker r12 = this.e;
        Object r4 = null;
        if (r12 == null) goto L22;
        Sticker.ComposerConfig r13 = r12.getSmallItemConfig();
    L23:
        if (r13 != null) goto L26;
        Y90().setVisibility(8);
        return;
    L26:
        Y90().setVisibility(0);
        View r14 = Y90();
        Sticker r5 = this.e;
        if (r5 == null) goto L29;
        String r6 = r5.getName();
    L30:
        r14.setTag(r6);
        ILiveEffectComposerManager r15 = LiveEffectContext.a.a(this.k).a();
        Sticker r7 = this.e;
        String r8 = "";
        if (r7 == null) goto L34;
        String r16 = r7.getEffectId();
        if (r16 == null) goto L34;
    L35:
        Sticker r17 = this.e;
        if (r17 == null) goto L43;
        Sticker.ComposerConfig r18 = r17.getSmallItemConfig();
        if (r18 == null) goto L43;
        String r19 = r18.getTag();
        if (r19 == null) goto L43;
        r8 = r19;
    L43:
        Float r21 = r15.G(r16, r8);
        if (r21 != null) goto L52;
        Sticker r22 = this.e;
        Intrinsics.checkNotNull(r22);
        Sticker r23 = this.e;
        if (r23 == null) goto L50;
        Sticker.ComposerConfig r24 = r23.getSmallItemConfig();
        if (r24 == null) goto L50;
        Integer r25 = Integer.valueOf(r24.getDefaultValue());
    L51:
        Intrinsics.checkNotNull(r25);
        r21 = Float.valueOf(com.bytedance.android.live.effect.q.d(r22, r25.intValue()));
    L50:
        r25 = null;
    L52:
        Sticker r26 = this.e;
        int r27 = 100;
        boolean r28 = true;
        if (r26 == null) goto L64;
        Sticker.ComposerConfig r29 = r26.getSmallItemConfig();
        if (r29 == null) goto L64;
        if (r29.getDoubleDirection() != true) goto L64;
        Object r31 = Y90();
        if ((r31 instanceof BeautifyAdjustPercentBar) == true) goto L61;
        r31 = null;
    L61:
        BeautifyAdjustPercentBar r32 = (BeautifyAdjustPercentBar) r31;
        if (r32 == null) goto L70;
        r32.Y5(50, -50, 0, false);
    L70:
        View r33 = Y90();
        if ((r33 instanceof BeautifyAdjustPercentBar) == false) goto L74;
        r4 = r33;
    L74:
        BeautifyAdjustPercentBar r34 = (BeautifyAdjustPercentBar) r4;
        if (r34 == null) goto L94;
        int r35 = com.bytedance.android.live.effect.q.a;
        Sticker r36 = this.e;
        Intrinsics.checkNotNull(r36);
        float r37 = r21.floatValue();
        Intrinsics.checkNotNullParameter(r36, "sticker");
        Sticker.ComposerConfig r38 = r36.getSmallItemConfig();
        if (r37 == 0.0f) goto L93;
        if (r38 == null) goto L81;
        r27 = r38.getMaxValue();
        int r39 = r38.getMinValue();
    L82:
        if (r39 < 0) goto L85;
        r28 = false;
    L85:
        if (r28 == true) goto L87;
        float r41 = r37 * 10000;
        float r42 = r27 - r39;
    L92:
        r1 = MathKt.roundToInt(r41 / r42);
        goto L93
    L87:
        if (r37 <= 0) goto L89;
        int r43 = 5000 / r27;
    L90:
        r41 = r37 * r43;
        r42 = 2;
        goto L92
    L89:
        r43 = (-5000) / r39;
        goto L90
    L81:
        r39 = 0;
    L93:
        r34.setPercent(r1);
    L94:
        ILiveEffectComposerManager r44 = LiveEffectContext.a.a(this.k).a();
        Sticker r45 = this.e;
        Intrinsics.checkNotNull(r45);
        r44.a(r3, r45, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_refreshView");
        return;
    L64:
        Object r46 = Y90();
        if ((r46 instanceof BeautifyAdjustPercentBar) == true) goto L67;
        r46 = null;
    L67:
        BeautifyAdjustPercentBar r47 = (BeautifyAdjustPercentBar) r46;
        if (r47 == null) goto L70;
        r47.Y5(100, 0, 0, true);
    L34:
        r16 = "";
        goto L35
    L29:
        r6 = null;
        goto L30
    L22:
        r13 = null;
        goto L23
    }

    public final void aa0(int r5) {
        LiveBeautySecLevelSlidingTab r0 = (LiveBeautySecLevelSlidingTab) S90(2131364572);
        if (r0 == null) goto L11;
        List<String> r1 = r0.getDatas();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.size() > r5) goto L9;
        return;
    L9:
        Disposable r2 = com.bytedance.android.live.effect.utils.k.a;
        String r3 = this.m;
        String r6 = (String) ListProtector.get(r1, r5);
        Intrinsics.checkNotNullParameter(r3, "eventPage");
        Intrinsics.checkNotNullParameter(r6, "tabName");
        HashMap r4 = new HashMap();
        r4.put("live_type", "video_live");
        r4.put("tab_name", r6);
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_subitem_tab_show", r4, r3);
        return;
    }

    public final void ba0(String r5) {
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r1 = LiveEffectContext.a.a(this.k).e();
        HashMap<String, String> r2 = new HashMap();
        r2.put("event_page", "live_take_detail");
        r2.put("evnet_type", "click");
        r2.put("evnet_belong", "live_take");
        Unit r3 = Unit.INSTANCE;
        r1.sendLog(r5, r2);
    }

    public final void onHiddenChanged(boolean r3) {
        super.onHiddenChanged(r3);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        ALogger.i("ttlive_anchor_effect_LiveBeautySecondLevelFragment", "onHiddenChanged,hidden:" + r3);
        if (r3 == true) goto L12;
        Z90("onHiddenChanged");
        LiveBeautySecLevelSlidingTab r4 = (LiveBeautySecLevelSlidingTab) S90(2131364572);
        if (r4 == null) goto L10;
        aa0(r4.getCurrentPosition());
    L10:
        LiveSmallItemBeautyTemplateAdapter r5 = V90();
        r5.n = m90.b.a.c(this.k).booleanValue();
        r5.notifyItemChanged(0);
        return;
    }

    public static final int T90(LiveBeautySecondLevelFragment r5, int r6) {
        int r0 = r5.n.size();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r0) goto L9;
        r2 = r2 + ((Number) ListProtector.get(r5.n, r1)).intValue();
        if (((-1) + r6) < r2) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return -1;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        Object r0 = null;
        View r7 = LayoutInflater.from(getContext()).inflate(2131563550, null);
        r7.setOnClickListener(new j(this));
        S90(2131386947).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r7).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        S90(2131386947).showLoading();
        Object r8 = Y90();
        if ((r8 instanceof BeautifyAdjustPercentBar) == true) goto L5;
        r8 = null;
    L5:
        BeautifyAdjustPercentBar r9 = (BeautifyAdjustPercentBar) r8;
        if (r9 == null) goto L8;
        r9.U5(s1.h(2131107405), s1.h(2131107403), s1.h(2131107402));
    L8:
        this.v = X90().findViewById(2131374718);
        this.w = X90().findViewById(2131384419);
        View r11 = Y90();
        if ((r11 instanceof BeautifyAdjustPercentBar) == false) goto L12;
        r0 = r11;
    L12:
        BeautifyAdjustPercentBar r1 = (BeautifyAdjustPercentBar) r0;
        if (r1 == null) goto L15;
        r1.setOnLevelChangeListener(new k(this));
    L15:
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.k).a().l(this.y);
        S90(2131386948).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        S90(2131386948).setAdapter(V90());
        S90(2131386948).addItemDecoration(new DivideItemDecoration(this.o));
        S90(2131386948).addOnScrollListener(new LiveBeautySecondLevelFragment$initView$3(this));
        X90().setOnClickListener(new l(this));
        Z90("ttlive_anchor_effect_LiveBeautySecondLevelFragment_beautyInitView");
        U90();
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().a().a();
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.k).b().l(), "beautyclassify", this.k, new WeakReference(this.x), 8);
        if (LiveEffectContext.a.a(this.k).b().h().c() == false) goto L19;
        LiveEffectContext.a.a(this.k).b().h().f(this.s, "beautyclassify");
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565874, r3, false);
    }
}
