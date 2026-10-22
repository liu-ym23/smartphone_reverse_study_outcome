package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.RecommendKeywordView;
import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerSearchViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR#\u0010\u0015\u001a\n \u0003*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u0003*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0003*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerSearchTabView;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerBaseTabView;", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getStickerRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "stickerRecyclerView", "Landroid/widget/TextView;", "e", "getEmptySearchResultTextView", "()Landroid/widget/TextView;", "emptySearchResultTextView", "f", "getSearchRecommendTextView", "searchRecommendTextView", "Lcom/bytedance/android/livesdk/widget/FlowLayout;", "g", "getRecommendKeywordContainer", "()Lcom/bytedance/android/livesdk/widget/FlowLayout;", "recommendKeywordContainer", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "h", "getLoading", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loading", "Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "i", "getSearchBox", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "searchBox", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter;", "j", "getSearchAdapter", "()Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter;", "searchAdapter", "", "l", "Ljava/lang/String;", "getPanel", "()Ljava/lang/String;", "panel", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel;", "getSearchViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel;", "searchViewModel", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchTabView extends StickerBaseTabView {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final WeakReference<LifecycleOwner> k;
    public final String l;

    public static final class a extends com.bytedance.android.live.effect.sticker.ui.k {
        public final /* synthetic */ StickerSearchTabView a;

        @Override // com.bytedance.android.live.effect.sticker.ui.j
        public final void c(boolean r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "newContent");
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.k, com.bytedance.android.live.effect.sticker.ui.j
        public final void a() {
            StickerSearchViewModel r0 = StickerSearchTabView.Z5(this.a);
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.k<Unit> r1 = r0.getTabViewSearchFailEvent();
            if (r1 == null) goto L9;
            r1.post(Unit.INSTANCE);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.k, com.bytedance.android.live.effect.sticker.ui.j
        public final void b() {
            StickerSearchViewModel r0 = StickerSearchTabView.Z5(this.a);
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.k<Unit> r1 = r0.getTabViewCoverClickEvent();
            if (r1 == null) goto L9;
            r1.post(Unit.INSTANCE);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.k, com.bytedance.android.live.effect.sticker.ui.j
        public final void d() {
            StickerSearchViewModel r0 = StickerSearchTabView.Z5(this.a);
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.k<Unit> r1 = r0.getTabViewClearContentEvent();
            if (r1 == null) goto L9;
            r1.post(Unit.INSTANCE);
            return;
        L9:
            return;
        }

        public a(StickerSearchTabView r1) {
            this.a = r1;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ StickerSearchTabView a;

        public b(StickerSearchTabView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            LoadingStatusView r2 = StickerSearchTabView.U5(this.a);
            if (r2 == null) goto L5;
            r2.showLoading();
        L5:
            StickerSearchBox r3 = StickerSearchTabView.Y5(this.a);
            if (r3 == null) goto L9;
            r3.Y5();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ StickerSearchTabView a;

        public c(StickerSearchTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Sticker r2 = (Sticker) r1;
            StickerSearchTabView.V5(this.a).C2();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ StickerSearchTabView a;

        public d(StickerSearchTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerSearchTabView r0 = this.a;
            StickerSearchTabView.n6(r0, (com.bytedance.android.live.effect.sticker.viewmodel.a) r2);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ StickerSearchTabView a;

        public e(StickerSearchTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerSearchTabView r0 = this.a;
            StickerSearchTabView.i6(r0, (String) r2);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ StickerSearchTabView a;

        public f(StickerSearchTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerSearchTabView r0 = this.a;
            StickerSearchTabView.k6(r0, (StickerSearchViewModel.SearchStatus) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ StickerSearchTabView a;

        public g(StickerSearchTabView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveStickerDialogListAdapter r0 = StickerSearchTabView.V5(this.a);
            r0.B2((Sticker) r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ StickerSearchTabView a;

        public h(StickerSearchTabView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveStickerDialogListAdapter r0 = StickerSearchTabView.V5(this.a);
            r0.B2((Sticker) r2);
        }
    }

    public StickerSearchTabView() {
        throw null;
    }

    private final TextView getEmptySearchResultTextView() {
        return (TextView) this.e.getValue();
    }

    private final LoadingStatusView getLoading() {
        return (LoadingStatusView) this.h.getValue();
    }

    private final FlowLayout getRecommendKeywordContainer() {
        return (FlowLayout) this.g.getValue();
    }

    private final LiveStickerDialogListAdapter getSearchAdapter() {
        return (LiveStickerDialogListAdapter) this.j.getValue();
    }

    private final StickerSearchBox getSearchBox() {
        return (StickerSearchBox) this.i.getValue();
    }

    private final TextView getSearchRecommendTextView() {
        return (TextView) this.f.getValue();
    }

    private final RecyclerView getStickerRecyclerView() {
        return (RecyclerView) this.d.getValue();
    }

    private final StickerSearchViewModel getSearchViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = getScene();
        r0.getClass();
        return (StickerSearchViewModel) StickerBaseViewModel.a.a(r1, StickerSearchViewModel.class);
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerBaseTabView
    public final void T5() {
        super.T5();
        StickerDataViewModel r0 = getStickerDataViewModel();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.effect.sticker.p> r1 = r0.getPanelExtraInfo();
        if (r1 == null) goto L9;
        Disposable r2 = com.bytedance.android.live.effect.sticker.viewmodel.d.a(r1, new StickerSearchTabView$registerLiveData$1(this));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, getCompositeDisposable());
    L9:
        StickerDialogUIViewModel r3 = getUiViewModel();
        if (r3 == null) goto L18;
        com.bytedance.live.datacontext.k<Sticker> r4 = r3.getStickerDownloadCompleteEvent();
        if (r4 == null) goto L18;
        PublishSubject r5 = r4.onEvent();
        if (r5 == null) goto L18;
        Disposable r6 = r5.subscribe(new g(this));
        if (r6 == null) goto L18;
        RxUtilKt.c(r6, getCompositeDisposable());
    L18:
        StickerDialogUIViewModel r7 = getUiViewModel();
        if (r7 == null) goto L27;
        com.bytedance.live.datacontext.k<Sticker> r8 = r7.getStickerDownloadStartEvent();
        if (r8 == null) goto L27;
        PublishSubject r9 = r8.onEvent();
        if (r9 == null) goto L27;
        Disposable r11 = r9.subscribe(new h(this));
        if (r11 == null) goto L27;
        RxUtilKt.c(r11, getCompositeDisposable());
    L27:
        LifecycleOwner r12 = this.k.get();
        if (r12 == null) goto L50;
        StickerDialogUIViewModel r13 = getUiViewModel();
        if (r13 == null) goto L34;
        LiveData<Sticker> r14 = r13.getCurrentSelectStickerData();
        if (r14 == null) goto L34;
        r14.observe(r12, new c(this));
    L34:
        StickerSearchViewModel r15 = getSearchViewModel();
        if (r15 == null) goto L39;
        LiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, StickerSearchViewModel.b>> r16 = r15.getStickerSearchResultData();
        if (r16 == null) goto L39;
        r16.observe(r12, new d(this));
    L39:
        StickerSearchViewModel r17 = getSearchViewModel();
        if (r17 == null) goto L44;
        LiveData<String> r18 = r17.getSearchContent();
        if (r18 == null) goto L44;
        r18.observe(r12, new e(this));
    L44:
        StickerSearchViewModel r19 = getSearchViewModel();
        if (r19 == null) goto L51;
        LiveData<StickerSearchViewModel.SearchStatus> r21 = r19.getSearchStatus();
        if (r21 == null) goto L52;
        r21.observe(r12, new f(this));
        return;
    L52:
        return;
    L51:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerBaseTabView
    public final void initView() {
        R5(getLoading(), new b(this));
        RecyclerView r0 = getStickerRecyclerView();
        if (r0 == null) goto L5;
        r0.setAdapter(getSearchAdapter());
    L5:
        RecyclerView r1 = getStickerRecyclerView();
        if (r1 == null) goto L8;
        r1.setLayoutManager(new SSGridLayoutManager(getContext(), 5, 1));
    L8:
        FlowLayout r2 = getRecommendKeywordContainer();
        if (r2 == null) goto L11;
        r2.setItemSpacing(UtilityKotlinExtentionsKt.i(12));
        r2.setLineSpacing(UtilityKotlinExtentionsKt.i(12));
    L11:
        StickerSearchBox r3 = getSearchBox();
        if (r3 == null) goto L14;
        r3.V5();
        r3.U5(false);
        r3.setOnChangeListener(new a(this));
    L14:
        StickerDialogUIViewModel r4 = getUiViewModel();
        if (r4 == null) goto L29;
        com.bytedance.android.live.effect.base.f r5 = r4.getShowTraceInfo();
        if (r5 != null) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r5.c, SpecialTabType.SEARCH.getTabKey()) == false) goto L31;
        StickerDialogUIViewModel r6 = getUiViewModel();
        if (r6 != null) goto L23;
        return;
    L23:
        if (r6.getHasReportPanelShow() == true) goto L33;
        StickerDialogUIViewModel r7 = getUiViewModel();
        if (r7 == null) goto L27;
        r7.setHasReportPanelShow(true);
    L27:
        long r8 = System.currentTimeMillis();
        r5.k = r8;
        r5.l = r8;
        r5.m = r8;
        List<String> r9 = com.bytedance.android.live.effect.utils.q.a;
        com.bytedance.android.live.effect.utils.q.i(r5, getScene().getPage());
        return;
    L33:
        return;
    L31:
        return;
    }

    public final String getPanel() {
        return this.l;
    }

    public static final /* synthetic */ LoadingStatusView U5(StickerSearchTabView r0) {
        return r0.getLoading();
    }

    public static final /* synthetic */ LiveStickerDialogListAdapter V5(StickerSearchTabView r0) {
        return r0.getSearchAdapter();
    }

    public static final /* synthetic */ StickerSearchBox Y5(StickerSearchTabView r0) {
        return r0.getSearchBox();
    }

    public static final /* synthetic */ StickerSearchViewModel Z5(StickerSearchTabView r0) {
        return r0.getSearchViewModel();
    }

    public static final /* synthetic */ RecyclerView b6(StickerSearchTabView r0) {
        return r0.getStickerRecyclerView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.view.View, com.bytedance.android.live.effect.sticker.ui.RecommendKeywordView] */
    public static final void c6(final StickerSearchTabView r8, com.bytedance.android.live.effect.sticker.p r9) {
        TextView r0 = r8.getEmptySearchResultTextView();
        String r1 = r9.a;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1 = s1.B(2131916436);
    L8:
        r0.setText(r1);
        String r3 = r9.c;
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L16;
        StickerSearchBox r5 = r8.getSearchBox();
        if (r5 == null) goto L16;
        r5.setSearchHint(r3);
    L16:
        List<String> r11 = r9.b;
        final LiveEffectScene r6 = r8.getScene();
        FlowLayout r7 = r8.getRecommendKeywordContainer();
        if (r7 == null) goto L19;
        r7.removeAllViews();
    L19:
        Iterator<String> r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L34;
        final String r13 = r12.next();
        if (r8.getContext() == null) goto L21;
        if (r13.length() <= 0) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == false) goto L21;
        if ((!StringsKt.isBlank(r13)) == false) goto L21;
        Context r15 = r8.getContext();
        Intrinsics.checkNotNull(r15);
        ?? r16 = new RecommendKeywordView(r15, null, 6, 0);
        r16.setKeyword(r13);
        r16.setOnClick(new StickerSearchTabView$setRecommendKeyword$$inlined$apply$lambda$1(r8, r13, r6));
        FlowLayout r17 = r8.getRecommendKeywordContainer();
        if (r17 == 0) goto L21;
        r17.addView(r16);
        goto L21
    L27:
        r14 = false;
        goto L28
    L34:
        return;
    L11:
        r4 = false;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public static final void i6(StickerSearchTabView r3, String r4) {
        StickerSearchBox r0 = r3.getSearchBox();
        if (r0 == null) goto L6;
        r0.T5(r4);
    L6:
        if (r4.length() != 0) goto L8;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L26;
        LoadingStatusView r6 = r3.getLoading();
        if (r6 == null) goto L14;
        r6.reset();
    L14:
        TextView r7 = r3.getEmptySearchResultTextView();
        if (r7 == null) goto L17;
        r7.setVisibility(8);
    L17:
        RecyclerView r8 = r3.getStickerRecyclerView();
        if (r8 == null) goto L20;
        r8.setVisibility(4);
    L20:
        TextView r9 = r3.getSearchRecommendTextView();
        if (r9 == null) goto L23;
        r9.setVisibility(0);
    L23:
        FlowLayout r11 = r3.getRecommendKeywordContainer();
        if (r11 == null) goto L33;
        r11.setVisibility(0);
        return;
    L33:
        return;
    L26:
        TextView r12 = r3.getSearchRecommendTextView();
        if (r12 == null) goto L29;
        r12.setVisibility(4);
    L29:
        FlowLayout r13 = r3.getRecommendKeywordContainer();
        if (r13 == null) goto L35;
        r13.setVisibility(4);
        return;
    L35:
        return;
    L8:
        r5 = false;
        goto L10
    }

    public static final void k6(StickerSearchTabView r3, StickerSearchViewModel.SearchStatus r4) {
        r3.getClass();
        int r5 = w0.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        r3.getSearchAdapter().y2(CollectionsKt.emptyList());
        LoadingStatusView r6 = r3.getLoading();
        if (r6 == null) goto L19;
        r6.reset();
    L19:
        TextView r7 = r3.getEmptySearchResultTextView();
        if (r7 == null) goto L22;
        r7.setVisibility(8);
    L22:
        RecyclerView r8 = r3.getStickerRecyclerView();
        if (r8 == null) goto L25;
        r8.setVisibility(4);
    L25:
        TextView r9 = r3.getSearchRecommendTextView();
        if (r9 == null) goto L28;
        r9.setVisibility(0);
    L28:
        FlowLayout r11 = r3.getRecommendKeywordContainer();
        if (r11 == null) goto L34;
        r11.setVisibility(0);
        return;
    L34:
        return;
    L5:
        if (r5 != 2) goto L35;
        RecyclerView r12 = r3.getStickerRecyclerView();
        if (r12 == null) goto L10;
        r12.setVisibility(4);
    L10:
        TextView r13 = r3.getEmptySearchResultTextView();
        if (r13 == null) goto L13;
        r13.setVisibility(8);
    L13:
        LoadingStatusView r14 = r3.getLoading();
        if (r14 == null) goto L32;
        r14.showLoading();
        return;
    L32:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n6(StickerSearchTabView r6, com.bytedance.android.live.effect.sticker.viewmodel.a r7) {
        RecyclerView r0 = r6.getStickerRecyclerView();
        if (r0 == null) goto L6;
        r0.setAdapter(r6.getSearchAdapter());
    L6:
        if ((r7 instanceof com.bytedance.android.live.effect.sticker.viewmodel.a.b) == false) goto L53;
        LoadingStatusView r1 = r6.getLoading();
        if (r1 == null) goto L10;
        r1.reset();
    L10:
        com.bytedance.android.live.effect.sticker.viewmodel.a.b r8 = (com.bytedance.android.live.effect.sticker.viewmodel.a.b) r7;
        boolean r2 = Intrinsics.areEqual(((SearchEffectModel) r8.a).getUse_hot(), Boolean.TRUE);
        StickerSearchViewModel.b r3 = (StickerSearchViewModel.b) r8.b;
        boolean r4 = true;
        if (r3 == null) goto L13;
        boolean r5 = r3.b;
    L14:
        int r9 = 0;
        if (r5 == true) goto L18;
        if (r2 == false) goto L18;
    L19:
        List r11 = ((SearchEffectModel) r8.a).getEffectList();
        if (r11 != null) goto L22;
        r11 = CollectionsKt.emptyList();
    L22:
        List r12 = r11;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L24:
        if (r14.hasNext() == false) goto L26;
        r13.add(com.bytedance.android.live.effect.sticker.d.d((Effect) r14.next(), r6.l));
        goto L24
    L26:
        LiveStickerDialogListAdapter r15 = r6.getSearchAdapter();
        List<Sticker> r16 = r13;
        if (r4 == false) goto L29;
        r16 = CollectionsKt.emptyList();
    L29:
        r15.y2(r16);
        if (r4 == false) goto L43;
        RecyclerView r17 = r6.getStickerRecyclerView();
        if (r17 == null) goto L34;
        r17.setVisibility(4);
    L34:
        TextView r18 = r6.getSearchRecommendTextView();
        if (r18 == null) goto L37;
        r18.setVisibility(0);
    L37:
        FlowLayout r19 = r6.getRecommendKeywordContainer();
        if (r19 == null) goto L40;
        r19.setVisibility(0);
    L40:
        TextView r21 = r6.getEmptySearchResultTextView();
        if (r21 == null) goto L59;
        r21.setVisibility(8);
        return;
    L59:
        return;
    L43:
        RecyclerView r22 = r6.getStickerRecyclerView();
        if (r22 == null) goto L46;
        r22.setVisibility(0);
    L46:
        TextView r23 = r6.getEmptySearchResultTextView();
        if (r23 == null) goto L61;
        if (r2 == true) goto L51;
        r9 = 8;
    L51:
        r23.setVisibility(r9);
        return;
    L61:
        return;
    L18:
        r4 = false;
        goto L19
    L13:
        r5 = true;
        goto L14
    L53:
        if ((r7 instanceof com.bytedance.android.live.effect.sticker.viewmodel.a.C0196a) == false) goto L63;
        LoadingStatusView r24 = r6.getLoading();
        if (r24 == null) goto L64;
        r24.showError();
        return;
    L64:
        return;
    }

    public StickerSearchTabView(Context r3, final LiveEffectContextFactoryDelegate$Type r4, final LiveEffectScene r5, WeakReference r6) {
        String r0 = com.bytedance.android.live.effect.api.d0.c;
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "panel");
        super(r3, 2131565935, r4, r5);
        this.k = r6;
        this.l = r0;
        this.d = LazyKt.lazy(new StickerSearchTabView$stickerRecyclerView$2(this));
        this.e = LazyKt.lazy(new StickerSearchTabView$emptySearchResultTextView$2(this));
        this.f = LazyKt.lazy(new StickerSearchTabView$searchRecommendTextView$2(this));
        this.g = LazyKt.lazy(new StickerSearchTabView$recommendKeywordContainer$2(this));
        this.h = LazyKt.lazy(new StickerSearchTabView$loading$2(this));
        this.i = LazyKt.lazy(new StickerSearchTabView$searchBox$2(this));
        this.j = LazyKt.lazy(new StickerSearchTabView$searchAdapter$2(this, r4, r5));
    }
}
