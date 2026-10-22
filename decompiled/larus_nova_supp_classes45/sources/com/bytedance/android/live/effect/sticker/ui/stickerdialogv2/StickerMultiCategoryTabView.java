package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.LiveEffectPagerSlidingTabStrip;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.live.uikit.rtl.RtlViewPager;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \u0003*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \u0003*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerMultiCategoryTabView;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerBaseTabView;", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getLoading", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loading", "Lcom/bytedance/android/live/effect/base/LiveEffectPagerSlidingTabStrip;", "e", "getSlideTab", "()Lcom/bytedance/android/live/effect/base/LiveEffectPagerSlidingTabStrip;", "slideTab", "Lcom/bytedance/android/live/uikit/rtl/RtlViewPager;", "f", "getStickerPager", "()Lcom/bytedance/android/live/uikit/rtl/RtlViewPager;", "stickerPager", "Landroid/widget/TextView;", "g", "getEmptyTextView", "()Landroid/widget/TextView;", "emptyTextView", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerMultiCategoryTabView extends StickerBaseTabView {
    public static final /* synthetic */ int m = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final LiveStickerDialogViewPagerAdapter h;
    public final WeakReference<LifecycleOwner> i;
    public final String j;
    public final List<Integer> k;
    public final String l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ StickerMultiCategoryTabView a;

        public a(StickerMultiCategoryTabView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            StickerMultiCategoryTabView r4 = this.a;
            int r0 = StickerMultiCategoryTabView.m;
            StickerDataViewModel r1 = r4.getStickerDataViewModel();
            if (r1 == null) goto L6;
            r1.fetchCategoryInfo(r4.j, r4.k);
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ StickerMultiCategoryTabView a;

        public b(StickerMultiCategoryTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerMultiCategoryTabView r0 = this.a;
            StickerMultiCategoryTabView.V5(r0, (CategoryInfoModelList) r2);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ StickerMultiCategoryTabView a;

        public c(StickerMultiCategoryTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadingStatusView r0 = StickerMultiCategoryTabView.U5(this.a);
            StickerBaseTabView.S5(r0, (StickerLoadingStatus) r2);
        }
    }

    private final TextView getEmptyTextView() {
        return (TextView) this.g.getValue();
    }

    private final LoadingStatusView getLoading() {
        return (LoadingStatusView) this.d.getValue();
    }

    private final LiveEffectPagerSlidingTabStrip getSlideTab() {
        return (LiveEffectPagerSlidingTabStrip) this.e.getValue();
    }

    private final RtlViewPager getStickerPager() {
        return (RtlViewPager) this.f.getValue();
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerBaseTabView
    public final void T5() {
        super.T5();
        LifecycleOwner r0 = this.i.get();
        if (r0 == null) goto L15;
        StickerDataViewModel r1 = getStickerDataViewModel();
        if (r1 == null) goto L9;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, CategoryInfoModelList> r2 = r1.getMultiCategoryInfoMap();
        if (r2 == null) goto L9;
        r2.b(this.j, r0, new b(this));
    L9:
        StickerDataViewModel r3 = getStickerDataViewModel();
        if (r3 == null) goto L16;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, StickerLoadingStatus> r4 = r3.getTabLoadingStatusMap();
        if (r4 == null) goto L17;
        r4.b(this.j, r0, new c(this));
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerBaseTabView
    public final void initView() {
        R5(getLoading(), new a(this));
        LiveEffectPagerSlidingTabStrip r0 = getSlideTab();
        if (r0 == null) goto L5;
        r0.setOnPageChangeListener(new AnonymousClass2(this));
    L5:
        RtlViewPager r1 = getStickerPager();
        if (r1 == null) goto L10;
        r1.setOffscreenPageLimit(1);
        r1.setAdapter(this.h);
        LiveEffectPagerSlidingTabStrip r2 = getSlideTab();
        if (r2 == null) goto L10;
        r2.setViewPager(r1);
    L10:
        StickerDataViewModel r3 = getStickerDataViewModel();
        if (r3 == null) goto L14;
        r3.fetchCategoryInfo(this.j, this.k);
        return;
    }

    public static final /* synthetic */ LoadingStatusView U5(StickerMultiCategoryTabView r0) {
        return r0.getLoading();
    }

    public static final void V5(StickerMultiCategoryTabView r3, CategoryInfoModelList r4) {
        r3.getClass();
        List r5 = r4.getCategoryList();
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        int r1 = 0;
        if (r5.isEmpty() == false) goto L13;
        TextView r6 = r3.getEmptyTextView();
        if (r6 == null) goto L10;
        r6.setText(r3.l);
    L10:
        TextView r7 = r3.getEmptyTextView();
        if (r7 == null) goto L41;
        r7.setVisibility(0);
        return;
    L41:
        return;
    L13:
        TextView r0 = r3.getEmptyTextView();
        if (r0 == null) goto L16;
        r0.setVisibility(4);
    L16:
        LiveStickerDialogViewPagerAdapter r2 = r3.h;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "tabList");
        ((ArrayList) r2.a).clear();
        ((ArrayList) r2.a).addAll(r5);
        r2.notifyDataSetChanged();
        LiveEffectPagerSlidingTabStrip r8 = r3.getSlideTab();
        if (r8 == null) goto L19;
        r8.d();
    L19:
        StickerDataViewModel r9 = r3.getStickerDataViewModel();
        f0 r11 = null;
        if (r9 == null) goto L24;
        f0 r12 = r9.getInitialPageStatus();
        if (r12 == null) goto L24;
        String r13 = r12.a;
    L26:
        if (Intrinsics.areEqual(r13, r3.j) == false) goto L43;
        StickerDataViewModel r14 = r3.getStickerDataViewModel();
        if (r14 == null) goto L30;
        r11 = r14.getInitialPageStatus();
    L30:
        RtlViewPager r15 = r3.getStickerPager();
        if (r15 == null) goto L44;
        StickerDataViewModel r16 = r3.getStickerDataViewModel();
        if (r16 == null) goto L39;
        if (r11 == null) goto L37;
        String r17 = r11.b;
        if (r17 == null) goto L37;
    L38:
        r1 = r16.getSecondaryTabPositionByTabKey(r17, r3.j);
    L37:
        r17 = r3.j;
    L39:
        r15.setCurrentItem(r1);
        return;
    L44:
        return;
    L43:
        return;
    L24:
        r13 = null;
        goto L26
    }

    public StickerMultiCategoryTabView(Context r9, LiveEffectContextFactoryDelegate$Type r11, LiveEffectScene r12, WeakReference<LifecycleOwner> r13, String r14, List<Integer> r15, String r16) {
        Intrinsics.checkNotNullParameter(r9, "mContext");
        Intrinsics.checkNotNullParameter(r11, "mType");
        Intrinsics.checkNotNullParameter(r12, "mScene");
        Intrinsics.checkNotNullParameter(r13, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r14, "tabKey");
        Intrinsics.checkNotNullParameter(r15, "childrenCategoryIDs");
        Intrinsics.checkNotNullParameter(r16, "emptyText");
        super(r9, 2131565930, r11, r12);
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.d = LazyKt.lazy(new StickerMultiCategoryTabView$loading$2(this));
        this.e = LazyKt.lazy(new StickerMultiCategoryTabView$slideTab$2(this));
        this.f = LazyKt.lazy(new StickerMultiCategoryTabView$stickerPager$2(this));
        this.g = LazyKt.lazy(new StickerMultiCategoryTabView$emptyTextView$2(this));
        this.h = new LiveStickerDialogViewPagerAdapter(r9, r13, r11, r12, false, true, r14);
    }
}
