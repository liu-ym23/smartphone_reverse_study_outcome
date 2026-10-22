package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.adapter.LiveBeautyTemplateAdapter;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/LiveBeautyTemplateDetailFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyTemplateDetailFragment extends BaseFragment {
    public static final /* synthetic */ int r = 0;
    public Map<Integer, View> d;
    public o90.a e;
    public View f;
    public AdjustPercentBar g;
    public LiveEffectContextFactoryDelegate$Type h;
    public String i;
    public final Handler j;
    public final Lazy k;
    public final b l;
    public long m;
    public final e n;
    public final c o;
    public final d p;
    public final com.bytedance.android.live.effect.beauty.c q;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveBeautyTemplateDetailFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveBeautyTemplateDetailFragment r0 = this.a;
            int r1 = LiveBeautyTemplateDetailFragment.r;
            LiveBeautyTemplateAdapter r2 = r0.U90();
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

        public b(LiveBeautyTemplateDetailFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.android.live.effect.beauty.smallitem.b {
        public final /* synthetic */ LiveBeautyTemplateDetailFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ List b;

            public a(c r1, List r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                LiveBeautyTemplateDetailFragment r0 = this.a.a;
                List<EffectCategoryModel> r1 = this.b;
                r0.getClass();
                Intrinsics.checkNotNullParameter(r1, "stickerCategoryList");
                if (r1.isEmpty() == false) goto L6;
                return;
            L6:
                if (r0.isDestroyed() == true) goto L31;
                List<EffectCategoryModel> r2 = r1;
                ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
                Iterator r4 = r2.iterator();
            L10:
                if (r4.hasNext() == false) goto L19;
                EffectCategoryModel r5 = (EffectCategoryModel) r4.next();
                String r6 = r5.getKey();
                String r7 = r5.getName();
                UrlModel r8 = new UrlModel();
                com.ss.ugc.effectplatform.model.UrlModel r9 = r5.getIcon_selected();
                List<String> r11 = null;
                if (r9 == null) goto L14;
                String r12 = r9.getUri();
            L15:
                r8.setUri(r12);
                com.ss.ugc.effectplatform.model.UrlModel r13 = r5.getIcon_selected();
                if (r13 == null) goto L18;
                r11 = r13.getUrl_list();
            L18:
                r8.setUrlList(r11);
                Unit r14 = Unit.INSTANCE;
                r3.add(new o90.a(r6, r7, r8, r5.getId(), 0));
                goto L10
            L14:
                r12 = null;
                goto L15
            L19:
                LiveBeautyTemplateAdapter r15 = r0.U90();
                if (r15 == null) goto L23;
                Intrinsics.checkNotNullParameter(r3, "beautyTemplateModelList");
                ((ArrayList) r15.c).clear();
                ((ArrayList) r15.c).addAll(r3);
                r15.notifyDataSetChanged();
            L23:
                if (r0.e != null) goto L25;
                r0.e = (o90.a) ListProtector.get(r3, 0);
            L25:
                List<String> r16 = LiveEffectContext.h;
                LiveEffectContext.a.a(r0.h).b().l().a(r0.h, "style", r1, r0.p);
                return;
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
            if (r0 == null) goto L6;
            r0.showError();
            return;
        }

        public c(LiveBeautyTemplateDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.b
        public final void onSuccess(List<EffectCategoryModel> r3) {
            Intrinsics.checkNotNullParameter(r3, "stickerCategoryList");
            this.a.j.post(new a(this, r3));
        }
    }

    public static final class d implements q {
        public final /* synthetic */ LiveBeautyTemplateDetailFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ List b;

            public a(d r1, List r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                if (this.a.a.S90(2131386947) == null) goto L6;
                this.a.a.S90(2131386947).setVisibility(8);
            L6:
                if (this.a.a.S90(2131386948) == null) goto L8;
                this.a.a.S90(2131386948).setVisibility(0);
            L8:
                this.a.a.V90(this.b);
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

        public d(LiveBeautyTemplateDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r2, List<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "stickerList");
            this.a.j.post(new a(this, r2));
        }
    }

    public static final class e implements LiveBeautyTemplateAdapter.b {
        public final /* synthetic */ LiveBeautyTemplateDetailFragment a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ e a;
            public final /* synthetic */ o90.a b;
            public final /* synthetic */ int c;

            public a(e r1, o90.a r2, int r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r3, int r4) {
                m90.b.e.e(this.a.a.h, Boolean.TRUE);
                if (r3 == null) goto L5;
                r3.dismiss();
            L5:
                Disposable r5 = com.bytedance.android.live.effect.utils.k.a;
                String r6 = this.a.a.i;
                o90.a r7 = this.b;
                com.bytedance.android.live.effect.utils.k.a(r6, r7.b, r7.d, "apply");
                LiveBeautyTemplateDetailFragment.T90(this.a.a, this.c);
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ e a;
            public final /* synthetic */ o90.a b;

            public b(e r1, o90.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r3, int r4) {
                if (r3 == null) goto L4;
                r3.dismiss();
            L4:
                Disposable r5 = com.bytedance.android.live.effect.utils.k.a;
                String r6 = this.a.a.i;
                o90.a r7 = this.b;
                com.bytedance.android.live.effect.utils.k.a(r6, r7.b, r7.d, "cancel");
            }
        }

        public e(LiveBeautyTemplateDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.adapter.LiveBeautyTemplateAdapter.b
        public final void onItemClick(int r11) {
            long r0 = System.currentTimeMillis();
            LiveBeautyTemplateDetailFragment r2 = this.a;
            if ((r0 - r2.m) >= 1500) goto L6;
            f2.c("模板切换过快，请稍后再试", 0);
            return;
        L6:
            r2.m = r0;
            LiveBeautyTemplateAdapter r1 = r2.U90();
            if (r1 != null) goto L10;
            return;
        L10:
            if (((ArrayList) r1.c).size() > r11) goto L13;
            return;
        L13:
            if (m90.b.e.c(this.a.h).booleanValue() == true) goto L20;
            o90.a r3 = (o90.a) ListProtector.get(r1.c, r11);
            Context r4 = this.a.getContext();
            c9.b r5 = new c9.b();
            r5.a = r4;
            r5.b = 2;
            r5.p = false;
            String r6 = s1.B(2131916383);
            a r7 = new a(this, r3, r11);
            r5.l = r6;
            r5.m = r7;
            String r12 = s1.B(2131916382);
            b r8 = new b(this, r3);
            r5.j = r12;
            r5.k = r8;
            r5.f = s1.B(2131916381);
            r5.e = s1.B(2131916380);
            c9 r13 = new c9(r5.a, r5);
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L23;
            DialogLancet.handleBlockedDialogShow(r13);
        L19:
            Disposable r14 = com.bytedance.android.live.effect.utils.k.a;
            String r15 = this.a.i;
            String r9 = r3.b;
            String r16 = r3.d;
            Intrinsics.checkNotNullParameter(r15, "eventPage");
            Intrinsics.checkNotNullParameter(r9, "modelName");
            Intrinsics.checkNotNullParameter(r16, "modelId");
            HashMap r17 = new HashMap();
            r17.put("live_type", "video_live");
            r17.put("model_name", r9);
            r17.put("model_id", r16);
            com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_model_popup_window_show", r17, r15);
            return;
        L23:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
        L18:
            DialogLancet.beforeDialogShow(r13);
            r13.show();
            DialogLancet.afterDialogShow(r13);
            goto L19
        L20:
            LiveBeautyTemplateDetailFragment.T90(this.a, r11);
        }
    }

    static {
    }

    public final LiveBeautyTemplateAdapter U90() {
        return (LiveBeautyTemplateAdapter) this.k.getValue();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        List<String> r0 = LiveEffectContext.h;
        n.b.b(LiveEffectContext.a.a(this.h).b().h(), this.l);
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public LiveBeautyTemplateDetailFragment() {
        this.d = new LinkedHashMap();
        this.h = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.i = "";
        this.j = new Handler(Looper.getMainLooper());
        this.k = LazyKt.lazy(new LiveBeautyTemplateDetailFragment$beautyAdapter$2(this));
        this.l = new b(this);
        this.n = new e(this);
        this.o = new c(this);
        this.p = new d(this);
        this.q = new com.bytedance.android.live.effect.beauty.c();
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

    public final boolean V90(List<Sticker> r11) {
        List<String> r0 = LiveEffectContext.h;
        List<Sticker> r1 = LiveEffectContext.a.a(this.h).b().g().e;
        ArrayList<Sticker> r2 = ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.h).b().f()).a;
        if (((ArrayList) r1).isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<T> r12 = r11.iterator();
        boolean r3 = true;
    L7:
        if (r12.hasNext() == false) goto L28;
        Sticker r4 = (Sticker) r12.next();
        int r5 = r4.getStyleType();
        if (r5 != 0) goto L10;
        if (W90(r4) == true) goto L7;
    L27:
        r3 = false;
        goto L7
    L10:
        if (r5 != 1) goto L7;
        Iterator<Sticker> r6 = r2.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Sticker r7 = r6.next();
        if (Intrinsics.areEqual(r7.getResourceId(), r4.getResourceId()) == false) goto L14;
    L20:
        if (r7 == null) goto L7;
        if (W90(r4) == true) goto L7;
    L18:
        r7 = null;
        goto L20
    L28:
        return r3;
    }

    public final boolean W90(Sticker r4) {
        if (r4.isDownloaded() == true) goto L9;
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.h).b().r().q(r4) == true) goto L8;
        ALogger.d("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment", "item not download,id:" + r4.getId() + ",name:" + r4.getName());
        LiveEffectContext.a.a(this.h).b().r().g("style", r4, this.q);
        return false;
    L8:
        r4.setDownloaded(true);
    L9:
        return true;
    }

    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r5 == true) goto L10;
        LiveBeautyTemplateAdapter r6 = U90();
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

    public static final void T90(LiveBeautyTemplateDetailFragment r16, int r17) {
        LiveBeautyTemplateAdapter r2 = r16.U90();
        if (r2 != null) goto L6;
        return;
    L6:
        if (((ArrayList) r2.c).size() <= r17) goto L137;
        o90.a r3 = (o90.a) ListProtector.get(r2.c, r17);
        if (r3 == null) goto L138;
        List<String> r4 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.smallitem.d r5 = LiveEffectContext.a.a(r16.h).b().l();
        String r6 = r3.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter("style", "panel");
        Intrinsics.checkNotNullParameter(r6, "category");
        Map r7 = (Map) ((LinkedHashMap) r5.b).get("style");
        if (r7 == null) goto L14;
        List<Sticker> r8 = (List) r7.get(r6);
    L15:
        List<Sticker> r9 = r8;
        if (r9 != null) goto L18;
    L21:
        boolean r11 = true;
    L22:
        if (r11 == false) goto L24;
    L105:
        f2.c("资源正在下载中，请稍后重试", 0);
        return;
    L24:
        if (r16.V90(r8) == false) goto L105;
        Disposable r12 = com.bytedance.android.live.effect.utils.k.a;
        String r13 = r16.i;
        String r14 = r3.b;
        String r15 = r3.d;
        Intrinsics.checkNotNullParameter(r13, "eventPage");
        Intrinsics.checkNotNullParameter("", "modelValue");
        Intrinsics.checkNotNullParameter(r14, "modelName");
        Intrinsics.checkNotNullParameter(r15, "modelId");
        HashMap r18 = new HashMap();
        r18.put("live_type", "video_live");
        r18.put("model_value", "");
        r18.put("model_name", r14);
        r18.put("model_id", r15);
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_model_select", r18, r13);
        String r19 = r16.i;
        String r21 = r3.b;
        String r22 = r3.d;
        Intrinsics.checkNotNullParameter(r19, "eventPage");
        Intrinsics.checkNotNullParameter(r21, "modelName");
        Intrinsics.checkNotNullParameter(r22, "modelId");
        com.bytedance.android.live.effect.utils.k.b();
        com.bytedance.android.live.effect.utils.k.a = Observable.timer(30, TimeUnit.SECONDS).subscribe(new com.bytedance.android.live.effect.utils.i(r21, r22, r19), com.bytedance.android.live.effect.utils.j.a);
        int r23 = r2.e;
        r2.e = r17;
        m90.b.c.e(r2.b, Integer.valueOf(r17));
        r2.notifyItemChanged(r23);
        r2.notifyItemChanged(r2.e);
        r16.e = r3;
        List<Sticker> r1 = LiveEffectContext.a.a(r16.h).b().g().e;
        List<Sticker> r24 = LiveEffectContext.a.a(r16.h).b().g().e;
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(LiveEffectContext.a.a(r16.h).b().f(), null, "ttlive_anchor_effect_LiveBeautyTemlateDetaillFragmenttemplate_reset");
        Iterator r25 = ((ArrayList) r24).iterator();
    L28:
        if (r25.hasNext() == false) goto L46;
        Sticker r26 = (Sticker) r25.next();
        Iterator<T> r27 = r8.iterator();
    L31:
        if (r27.hasNext() == false) goto L35;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(r26.getResourceId(), ((Sticker) r28).getResourceId()) == false) goto L31;
    L37:
        if (((Sticker) r28) == null) goto L39;
        boolean r29 = true;
    L40:
        if (r29 == true) goto L28;
        if (r26.isSubItem() == false) goto L45;
        List<String> r31 = LiveEffectContext.h;
        LiveEffectContext.a.a(r16.h).a().O(d0.i, r26, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_reset");
    L45:
        List<String> r32 = LiveEffectContext.h;
        ILiveEffectComposerManager r33 = LiveEffectContext.a.a(r16.h).a();
        String r34 = d0.i;
        Sticker.ComposerConfig r35 = r26.getSmallItemConfig();
        Intrinsics.checkNotNull(r35);
        ILiveEffectComposerManager.f.e(r33, r34, r26, r35.getTag(), com.bytedance.android.live.effect.q.d(r26, 0));
        goto L28
    L39:
        r29 = false;
        goto L40
    L35:
        r28 = null;
        goto L37
    L46:
        m90.c<Boolean> r36 = m90.b.a;
        if (r36.c(r16.h).booleanValue() == true) goto L50;
        r36.e(r16.h, Boolean.TRUE);
        xs2.b.a().post(new n90.c(true, d0.i));
        List<String> r37 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
    L50:
        Iterator<T> r38 = r8.iterator();
    L52:
        if (r38.hasNext() == false) goto L104;
        Sticker r39 = (Sticker) r38.next();
        int r41 = r39.getStyleType();
        if (r41 != 0) goto L56;
        Iterator r42 = ((ArrayList) r1).iterator();
    L83:
        if (r42.hasNext() == false) goto L87;
        Object r43 = r42.next();
        if (Intrinsics.areEqual(r39.getResourceId(), ((Sticker) r43).getResourceId()) == false) goto L83;
    L88:
        Sticker r44 = (Sticker) r43;
        if (r44 != null) goto L92;
        r44 = r39;
    L92:
        if (r44.getSmallItemConfig() == null) goto L52;
        List<String> r45 = LiveEffectContext.h;
        ILiveEffectComposerManager r46 = LiveEffectContext.a.a(r16.h).a();
        String r47 = d0.i;
        r46.a(r47, r44, "ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment_refreshView");
        ILiveEffectComposerManager r48 = LiveEffectContext.a.a(r16.h).a();
        Sticker.ComposerConfig r49 = r44.getSmallItemConfig();
        if (r49 == null) goto L98;
        String r51 = r49.getTag();
        if (r51 == null) goto L98;
    L99:
        Sticker.ComposerConfig r52 = r39.getSmallItemConfig();
        if (r52 == null) goto L102;
        int r53 = r52.getDefaultValue();
    L103:
        ILiveEffectComposerManager.f.e(r48, r47, r44, r51, com.bytedance.android.live.effect.q.d(r44, r53));
        goto L52
    L102:
        r53 = 0;
    L98:
        r51 = "";
        goto L99
    L87:
        r43 = null;
        goto L88
    L56:
        if (r41 != 1) goto L52;
        List<String> r54 = LiveEffectContext.h;
        Iterator<Sticker> r55 = ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(r16.h).b().f()).a.iterator();
    L60:
        if (r55.hasNext() == false) goto L64;
        Sticker r56 = r55.next();
        if (Intrinsics.areEqual(r56.getResourceId(), r39.getResourceId()) == false) goto L60;
    L65:
        Sticker r57 = r56;
        if (r57 == null) goto L52;
        List r58 = r57.getComposerConfigList();
        if (r58 != null) goto L71;
    L74:
        boolean r59 = true;
    L75:
        if (r59 == true) goto L52;
        List<String> r61 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(LiveEffectContext.a.a(r16.h).b().f(), r57, "ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment_OnSelectItemChange_");
        Iterator r62 = r39.getComposerConfigList().iterator();
    L79:
        if (r62.hasNext() == false) goto L52;
        Sticker.ComposerConfig r63 = (Sticker.ComposerConfig) r62.next();
        List<String> r64 = LiveEffectContext.h;
        ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(r16.h).b().f()).e(r57, r63, r63.getDefaultValue());
        goto L79
    L71:
        if (r58.isEmpty() == true) goto L74;
        r59 = false;
        goto L75
    L64:
        r56 = null;
        goto L65
    L104:
        List<String> r65 = LiveEffectContext.h;
        LiveEffectContext.a.a(r16.h).a().x("ttlive_anchor_effect_LiveBeautyTemlateDetaillFragment_OnSelectItemChange_");
        return;
    L18:
        if (r9.isEmpty() == true) goto L21;
        r11 = false;
        goto L22
    L14:
        r8 = null;
        goto L15
    L138:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        AdjustPercentBar r8 = this.g;
        if (r8 == null) goto L5;
        r8.setVisibility(8);
    L5:
        View r9 = this.f;
        if (r9 == null) goto L8;
        r9.setVisibility(8);
    L8:
        View r11 = LayoutInflater.from(getContext()).inflate(2131563550, null);
        r11.setOnClickListener(new j(this));
        S90(2131386948).setVisibility(8);
        S90(2131386947).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r11).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        S90(2131386947).showLoading();
        S90(2131386948).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        S90(2131386948).setAdapter(U90());
        List<String> r12 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.h).b().l(), "style", this.h, new WeakReference(this.o), 8);
        if (LiveEffectContext.a.a(this.h).b().h().c() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.i, "live_take_page") == false) goto L15;
        n.b.a(LiveEffectContext.a.a(this.h).b().h(), this.l);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565875, r3, false);
    }
}
