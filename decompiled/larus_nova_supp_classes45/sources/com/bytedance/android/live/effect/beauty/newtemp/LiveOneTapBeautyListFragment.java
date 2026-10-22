package com.bytedance.android.live.effect.beauty.newtemp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOneTapBeautyListFragment extends BaseFragment {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public final LiveEffectContextFactoryDelegate$Type e;
    public final String f;
    public final Handler g;
    public final Lazy h;
    public final b i;
    public long j;
    public final d k;
    public final c l;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveOneTapBeautyListFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveOneTapBeautyListFragment r0 = this.a;
            int r1 = LiveOneTapBeautyListFragment.m;
            LiveOneTapBeautyAdapter r2 = r0.T90();
            if (r2 == null) goto L6;
            m90.c<Integer> r3 = m90.b.c;
            int r4 = r3.c(r2.b).intValue();
            int r5 = r2.e;
            r2.e = r4;
            r3.e(r2.b, Integer.valueOf(r4));
            r2.notifyItemChanged(r5);
            r2.notifyItemChanged(r2.e);
            return;
        }

        public b(LiveOneTapBeautyListFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements q {
        public final /* synthetic */ LiveOneTapBeautyListFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ List b;

            public a(c r1, List r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                if (this.a.a.S90(2131386947) == null) goto L5;
                this.a.a.S90(2131386947).setVisibility(8);
            L5:
                int r2 = 0;
                if (this.a.a.S90(2131386948) == null) goto L8;
                this.a.a.S90(2131386948).setVisibility(0);
            L8:
                LiveOneTapBeautyListFragment r0 = this.a.a;
                List r1 = this.b;
                r0.getClass();
                Intrinsics.checkNotNullParameter(r1, "stickerCategoryList");
                if (r1.isEmpty() == false) goto L12;
            L39:
                LiveOneTapBeautyListFragment r3 = this.a.a;
                List r4 = this.b;
                r3.getClass();
                List<String> r5 = LiveEffectContext.h;
                if (((CopyOnWriteArrayList) LiveEffectContext.a.a(r3.e).b().g().b).isEmpty() == true) goto L46;
                Iterator r6 = r4.iterator();
            L44:
                if (r6.hasNext() == false) goto L51;
                LiveOneTapBeautyListFragment.U90((Sticker) r6.next());
                goto L44
            L51:
                return;
            L46:
                return;
            L12:
                if (r0.isDestroyed() == true) goto L39;
                Sticker r7 = (Sticker) CollectionsKt.getOrNull(r1, m90.b.c.c(r0.e).intValue());
                List r8 = r1;
                ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
                Iterator r11 = r8.iterator();
            L16:
                if (r11.hasNext() == false) goto L36;
                Object r12 = r11.next();
                int r13 = r2 + 1;
                if (r2 >= 0) goto L20;
                CollectionsKt.throwIndexOverflow();
            L20:
                Sticker r14 = (Sticker) r12;
                String r15 = r14.getName();
                if (r15 != null) goto L23;
                String r16 = "";
            L24:
                String r17 = r14.getName();
                if (r17 != null) goto L27;
                String r18 = "";
            L28:
                UrlModel r19 = new UrlModel();
                UrlModel r21 = r14.getIcon();
                List<String> r22 = null;
                if (r21 == null) goto L31;
                String r23 = r21.getUri();
            L32:
                r19.setUri(r23);
                UrlModel r24 = r14.getIcon();
                if (r24 == null) goto L35;
                r22 = r24.getUrlList();
            L35:
                r19.setUrlList(r22);
                Unit r25 = Unit.INSTANCE;
                r9.add(new o90.a(r16, r18, r19, String.valueOf(r14.getId()), r13));
                r2 = r13;
                goto L16
            L31:
                r23 = null;
                goto L32
            L27:
                r18 = r17;
                goto L28
            L23:
                r16 = r15;
                goto L24
            L36:
                LiveOneTapBeautyAdapter r26 = r0.T90();
                if (r26 == null) goto L39;
                Intrinsics.checkNotNullParameter(r9, "beautyTemplateModelList");
                ((ArrayList) r26.c).clear();
                ((ArrayList) r26.c).addAll(r9);
                r26.notifyDataSetChanged();
                goto L39
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
            if (r0 == null) goto L6;
            r0.showError();
            return;
        }

        public c(LiveOneTapBeautyListFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r2, List<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "stickerList");
            this.a.g.post(new a(this, r2));
        }
    }

    public static final class d implements LiveOneTapBeautyAdapter.b {
        public final /* synthetic */ LiveOneTapBeautyListFragment a;

        public d(LiveOneTapBeautyListFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.newtemp.LiveOneTapBeautyAdapter.b
        public final void onItemClick(int r18) {
            long r2 = System.currentTimeMillis();
            LiveOneTapBeautyListFragment r4 = this.a;
            if ((r2 - r4.j) >= 1500) goto L6;
            f2.c("模板切换过快，请稍后再试", 0);
            return;
        L6:
            r4.j = r2;
            LiveOneTapBeautyAdapter r3 = r4.T90();
            if (r3 != null) goto L10;
            return;
        L10:
            if (((ArrayList) r3.c).size() > r18) goto L12;
            return;
        L12:
            LiveOneTapBeautyListFragment r5 = this.a;
            LiveOneTapBeautyAdapter r6 = r5.T90();
            if (r6 != null) goto L16;
            return;
        L16:
            if (((ArrayList) r6.c).size() <= r18) goto L171;
            o90.a r7 = (o90.a) ListProtector.get(r6.c, r18);
            List<String> r8 = LiveEffectContext.h;
            com.bytedance.android.live.effect.beauty.newtemp.c r9 = LiveEffectContext.a.a(r5.e).b().c();
            r9.getClass();
            Intrinsics.checkNotNullParameter("inspiration_beautification", "panel");
            List r11 = (List) ((LinkedHashMap) r9.a).get("inspiration_beautification");
            if (r11 == null) goto L28;
            Iterator r12 = r11.iterator();
        L22:
            if (r12.hasNext() == false) goto L26;
            Object r13 = r12.next();
            if (Intrinsics.areEqual(String.valueOf(((Sticker) r13).getId()), r7.d) == false) goto L22;
        L27:
            Sticker r14 = (Sticker) r13;
        L30:
            if (r14 != null) goto L32;
            ALogger.e("ttlive_inspiration_panel", "onItemSelect sticker not found");
            return;
        L32:
            List r15 = r11;
            if (r15 != null) goto L35;
        L38:
            boolean r16 = true;
        L39:
            if (r16 == false) goto L41;
        L120:
            f2.c("资源正在下载中，请稍后重试", 0);
            return;
        L41:
            if (LiveOneTapBeautyListFragment.U90(r14) == false) goto L120;
            int r17 = r6.e;
            r6.e = r18;
            m90.b.c.e(r6.b, Integer.valueOf(r18));
            r6.notifyItemChanged(r17);
            r6.notifyItemChanged(r6.e);
            List r1 = r14.getSubItemStickerList();
            if (r1.isEmpty() == false) goto L46;
            ALogger.e("ttlive_inspiration_panel", "useTemplate subItems is empty");
            return;
        L46:
            List<String> r19 = LiveEffectContext.h;
            com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(LiveEffectContext.a.a(r5.e).b().f(), null, "ttlive_inspiration_panelinspiration_reset");
            LiveComposerFilterHelper.a(LiveEffectContext.a.a(r5.e).b().m(), null, "ttlive_inspiration_panelinspiration_reset", "inspiration", false, false, 56);
            Iterator r21 = ((CopyOnWriteArrayList) LiveEffectContext.a.a(r5.e).b().g().b).iterator();
        L48:
            if (r21.hasNext() == false) goto L66;
            Sticker r22 = (Sticker) r21.next();
            Iterator r23 = r1.iterator();
        L51:
            if (r23.hasNext() == false) goto L55;
            Object r110 = r23.next();
            if (Intrinsics.areEqual(r22.getResourceId(), ((LocalSubStickerItem) r110).getResId()) == false) goto L51;
        L57:
            if (((LocalSubStickerItem) r110) == null) goto L59;
            boolean r24 = true;
        L60:
            if (r24 == true) goto L48;
            if (r22.isSubItem() == false) goto L65;
            List<String> r25 = LiveEffectContext.h;
            LiveEffectContext.a.a(r5.e).a().O(d0.i, r22, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_reset");
        L65:
            List<String> r26 = LiveEffectContext.h;
            ILiveEffectComposerManager r27 = LiveEffectContext.a.a(r5.e).a();
            String r111 = d0.i;
            Sticker.ComposerConfig r112 = r22.getSmallItemConfig();
            Intrinsics.checkNotNull(r112);
            ILiveEffectComposerManager.f.e(r27, r111, r22, r112.getTag(), com.bytedance.android.live.effect.q.d(r22, 0));
            goto L48
        L59:
            r24 = false;
            goto L60
        L55:
            r110 = null;
            goto L57
        L66:
            m90.c<Boolean> r28 = m90.b.a;
            if (r28.c(r5.e).booleanValue() == true) goto L70;
            r28.e(r5.e, Boolean.TRUE);
            xs2.b.a().post(new n90.c(true, d0.i));
            List<String> r29 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
        L70:
            Iterator r31 = r1.iterator();
        L72:
            if (r31.hasNext() == false) goto L119;
            LocalSubStickerItem r32 = (LocalSubStickerItem) r31.next();
            String r33 = r32.getType();
            int r34 = r33.hashCode();
            if (r34 != (-2028190455)) goto L76;
            if (r33.equals("MAKEUP") == false) goto L72;
            Sticker r35 = r32.getMappingSticker();
            ArrayList r36 = r32.getConfigList();
            if (r35 == null) goto L72;
            if (r36.isEmpty() == true) goto L72;
            List<String> r37 = LiveEffectContext.h;
            com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(LiveEffectContext.a.a(r5.e).b().f(), r35, "ttlive_inspiration_panel_OnSelectItemChange_");
            Iterator r38 = r36.iterator();
        L117:
            if (r38.hasNext() == false) goto L72;
            Sticker.ComposerConfig r39 = (Sticker.ComposerConfig) r38.next();
            ALogger.e("ttlive_inspiration_panel", "MAKEUP updateValue," + r35.getName() + ' ' + r39.getTag() + ' ' + r39.getDefaultValue());
            List<String> r41 = LiveEffectContext.h;
            ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(r5.e).b().f()).e(r35, r39, r39.getDefaultValue());
            goto L117
        L76:
            if (r34 != 1955267708) goto L78;
            if (r33.equals("BEAUTY") == false) goto L72;
            Sticker r42 = r32.getMappingSticker();
            Sticker.ComposerConfig r43 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r32.getConfigList());
            if (r42 == null) goto L72;
            if (r43 == null) goto L72;
            List<String> r44 = LiveEffectContext.h;
            ILiveEffectComposerManager r45 = LiveEffectContext.a.a(r5.e).a();
            String r46 = d0.i;
            r45.a(r46, r42, "ttlive_inspiration_panel_refreshView");
            ALogger.i("ttlive_inspiration_panel", "BEAUTY updateValue," + r42.getName() + ' ' + r43.getDefaultValue());
            ILiveEffectComposerManager r47 = LiveEffectContext.a.a(r5.e).a();
            Sticker.ComposerConfig r48 = r42.getSmallItemConfig();
            if (r48 == null) goto L106;
            String r49 = r48.getTag();
            if (r49 == null) goto L106;
        L107:
            ILiveEffectComposerManager.f.e(r47, r46, r42, r49, com.bytedance.android.live.effect.q.d(r42, r43.getDefaultValue()));
        L106:
            r49 = "";
            goto L107
        L78:
            if (r34 != 2073804664) goto L72;
            if (r33.equals("FILTER") == false) goto L72;
            Sticker r51 = r32.getMappingSticker();
            Sticker.ComposerConfig r52 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r32.getConfigList());
            if (r51 == null) goto L72;
            if (r52 == null) goto L72;
            List<String> r53 = LiveEffectContext.h;
            ILiveEffectComposerManager r54 = LiveEffectContext.a.a(r5.e).a();
            Iterator<T> r55 = r54.o(d0.a).iterator();
        L88:
            if (r55.hasNext() == false) goto L92;
            Object r113 = r55.next();
            if (Intrinsics.areEqual(((Sticker) r113).getResourceId(), r51.getResourceId()) == false) goto L88;
        L94:
            if (((Sticker) r113) != null) goto L72;
            ALogger.i("ttlive_inspiration_panel", "Filter updateValue," + r51.getName() + ' ' + r52.getDefaultValue());
            List<String> r56 = LiveEffectContext.h;
            com.bytedance.android.live.effect.beauty.makeups.a r57 = LiveEffectContext.a.a(r5.e).b().f();
            String r58 = d0.a;
            ((com.bytedance.android.live.effect.beauty.makeups.d) r57).c(r58, r51, r5.f);
            r54.b(r58, "ttlive_inspiration_panel");
            r54.a(r58, r51, "ttlive_inspiration_panel");
            Unit r59 = Unit.INSTANCE;
            goto L72
        L92:
            r113 = null;
            goto L94
        L119:
            List<String> r61 = LiveEffectContext.h;
            LiveEffectContext.a.a(r5.e).a().x("ttlive_inspiration_panel_OneTapItemChange_");
            return;
        L35:
            if (r15.isEmpty() == true) goto L38;
            r16 = false;
            goto L39
        L26:
            r13 = null;
            goto L27
        L28:
            r14 = null;
            goto L30
        }
    }

    static {
    }

    public final LiveOneTapBeautyAdapter T90() {
        return (LiveOneTapBeautyAdapter) this.h.getValue();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        List<String> r0 = LiveEffectContext.h;
        n.b.b(LiveEffectContext.a.a(this.e).b().h(), this.i);
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public LiveOneTapBeautyListFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f = "";
        this.g = new Handler(Looper.getMainLooper());
        this.h = LazyKt.lazy(new LiveOneTapBeautyListFragment$beautyAdapter$2(this));
        this.i = new b(this);
        this.k = new d(this);
        this.l = new c(this);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
    }

    public static boolean U90(Sticker r9) {
        LiveEffectContextFactoryDelegate$Type r0 = i.a;
        Intrinsics.checkNotNullParameter(r9, "localSticker");
        if (r9.getSubItemStickerList().size() == r9.getComposerConfigList().size()) goto L5;
        i.a(CollectionsKt.mutableListOf(new Sticker[]{r9}));
    L5:
        Iterator r11 = r9.getSubItemStickerList().iterator();
        boolean r1 = true;
    L7:
        if (r11.hasNext() == false) goto L24;
        Sticker r2 = ((LocalSubStickerItem) r11.next()).getMappingSticker();
        if (r2 == null) goto L12;
        String r4 = r2.getStickerPanel();
        if (r4 == null) goto L12;
    L13:
        if (r2 == null) goto L23;
        if (r2.isDownloaded() == true) goto L21;
        List<String> r5 = LiveEffectContext.h;
        LiveEffectContextFactoryDelegate$Type r6 = i.a;
        if (LiveEffectContext.a.a(r6).b().r().q(r2) == true) goto L20;
        ALogger.d("ttlive_inspiration_panel", "item not download,id:" + r2.getId() + ",name:" + r2.getName());
        LiveEffectContext.a.a(r6).b().r().g(r4, r2, i.b);
        boolean r3 = false;
    L22:
        if (r3 == true) goto L7;
    L20:
        r2.setDownloaded(true);
    L21:
        r3 = true;
    L23:
        r1 = false;
    L12:
        r4 = d0.i;
        goto L13
    L24:
        return r1;
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

    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r5 == true) goto L10;
        LiveOneTapBeautyAdapter r6 = T90();
        if (r6 == null) goto L11;
        m90.c<Integer> r0 = m90.b.c;
        int r1 = r0.c(r6.b).intValue();
        int r2 = r6.e;
        r6.e = r1;
        r0.e(r6.b, Integer.valueOf(r1));
        r6.notifyItemChanged(r2);
        r6.notifyItemChanged(r6.e);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FrameLayout r0 = null;
        View r7 = LayoutInflater.from(getContext()).inflate(2131565944, null);
        r7.setOnClickListener(new g(this));
        View r8 = getView();
        if (r8 != null) goto L5;
    L6:
        Context r9 = getContext();
        if (r9 == null) goto L9;
        r0 = new LiveDoubleColorBallAnimationView(r9);
        int r11 = r0.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(r11, r11);
        r1.gravity = 17;
        r0.setLayoutParams(r1);
        Unit r12 = Unit.INSTANCE;
    L9:
        S90(2131386948).setVisibility(8);
        S90(2131386947).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r7).setLoadingView(r0));
        S90(2131386947).showLoading();
        S90(2131386948).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        S90(2131386948).setAdapter(T90());
        ALogger.i("ttlive_inspiration_panel", "refreshView, reason = OneTapInitView");
        List<String> r13 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.e).a().U(d0.i) <= 0) goto L12;
    L20:
        S90(2131386948).setAlpha(0.5f);
        View r14 = S90(2131388958);
        if (r14 == null) goto L23;
        r14.setVisibility(0);
        r14.setOnClickListener(h.a);
    L23:
        com.bytedance.android.live.effect.beauty.newtemp.c.a(LiveEffectContext.a.a(this.e).b().c(), this.e, new WeakReference(this.l));
        if (LiveEffectContext.a.a(this.e).b().h().c() == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(this.f, "live_take_page") == false) goto L30;
        n.b.a(LiveEffectContext.a.a(this.e).b().h(), this.i);
        return;
    L30:
        return;
    L12:
        if (LiveEffectContext.a.a(this.e).a().U(d0.k) > 0) goto L20;
        if (LiveEffectContext.a.a(this.e).a().U(d0.a) > 0) goto L20;
        View r15 = S90(2131388958);
        if (r15 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r15);
    L19:
        S90(2131386948).setAlpha(1.0f);
        goto L23
    L5:
        if (r8.getContext() != null) goto L9;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565876, r3, false);
    }
}
