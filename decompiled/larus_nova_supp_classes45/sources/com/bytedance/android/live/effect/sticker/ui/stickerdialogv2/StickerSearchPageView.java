package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.RecommendKeywordView;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerSearchViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00102\u001a\u000201¢\u0006\u0004\b3\u00104R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \u0003*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0015\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R#\u0010\u001a\u001a\n \u0003*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0003*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001eR#\u0010\"\u001a\n \u0003*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u001eR#\u0010'\u001a\n \u0003*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010&R#\u0010,\u001a\n \u0003*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010+¨\u00065"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerSearchPageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getSearchBeyondView", "()Landroid/view/View;", "searchBeyondView", "Landroidx/recyclerview/widget/RecyclerView;", "b", "getStickerRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "stickerRecyclerView", "Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "c", "getSearchBox", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerSearchBox;", "searchBox", "d", "getCancelButton", "cancelButton", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "e", "getLoading", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loading", "Landroid/widget/TextView;", "f", "getSearchEmptyTextView", "()Landroid/widget/TextView;", "searchEmptyTextView", "g", "getSearchRecommendTextView", "searchRecommendTextView", "Lcom/bytedance/android/livesdk/widget/FlowLayout;", "h", "getRecommendKeywordContainer", "()Lcom/bytedance/android/livesdk/widget/FlowLayout;", "recommendKeywordContainer", "Landroid/widget/EditText;", "i", "getEditText", "()Landroid/widget/EditText;", "editText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchPageView extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public LiveEffectContextFactoryDelegate$Type j;
    public LiveEffectScene k;
    public String l;
    public StickerDataViewModel m;
    public StickerSearchViewModel n;
    public StickerDialogUIViewModel o;
    public LiveStickerDialogListAdapter p;
    public boolean q;
    public int r;
    public final CompositeDisposable s;
    public WeakReference<LifecycleOwner> t;

    public static final class a {
    }

    static {
    }

    public StickerSearchPageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerSearchPageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getCancelButton() {
        return (View) this.d.getValue();
    }

    private final EditText getEditText() {
        return (EditText) this.i.getValue();
    }

    private final LoadingStatusView getLoading() {
        return (LoadingStatusView) this.e.getValue();
    }

    private final FlowLayout getRecommendKeywordContainer() {
        return (FlowLayout) this.h.getValue();
    }

    private final View getSearchBeyondView() {
        return (View) this.a.getValue();
    }

    private final StickerSearchBox getSearchBox() {
        return (StickerSearchBox) this.c.getValue();
    }

    private final TextView getSearchEmptyTextView() {
        return (TextView) this.f.getValue();
    }

    private final TextView getSearchRecommendTextView() {
        return (TextView) this.g.getValue();
    }

    private final RecyclerView getStickerRecyclerView() {
        return (RecyclerView) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I() {
        EditText r0 = getEditText();
        if (r0 == null) goto L5;
        r0.requestFocus();
    L5:
        t2.b(getContext(), getEditText());
        StickerSearchBox r1 = getSearchBox();
        if (r1 == null) goto L9;
        r1.U5(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hideKeyboard() {
        EditText r0 = getEditText();
        if (r0 == null) goto L5;
        r0.clearFocus();
    L5:
        t2.a(getContext(), getEditText());
        StickerSearchBox r1 = getSearchBox();
        if (r1 == null) goto L9;
        r1.U5(false);
        return;
    }

    public static final /* synthetic */ LoadingStatusView R5(StickerSearchPageView r0) {
        return r0.getLoading();
    }

    public static final /* synthetic */ FlowLayout S5(StickerSearchPageView r0) {
        return r0.getRecommendKeywordContainer();
    }

    public static final /* synthetic */ StickerSearchBox T5(StickerSearchPageView r0) {
        return r0.getSearchBox();
    }

    public static final /* synthetic */ TextView U5(StickerSearchPageView r0) {
        return r0.getSearchEmptyTextView();
    }

    public static final /* synthetic */ TextView V5(StickerSearchPageView r0) {
        return r0.getSearchRecommendTextView();
    }

    public static final /* synthetic */ RecyclerView Y5(StickerSearchPageView r0) {
        return r0.getStickerRecyclerView();
    }

    public static final void c6(StickerSearchPageView r1) {
        LoadingStatusView r0 = r1.getLoading();
        if (r0 == null) goto L5;
        r0.showLoading();
    L5:
        StickerSearchBox r2 = r1.getSearchBox();
        if (r2 == null) goto L9;
        r2.Z5();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, com.bytedance.android.live.effect.sticker.ui.RecommendKeywordView] */
    public static final void Z5(final StickerSearchPageView r8, com.bytedance.android.live.effect.sticker.p r9) {
        StickerSearchBox r0 = r8.getSearchBox();
        if (r0 == null) goto L5;
        r0.setSearchHint(r9.c);
    L5:
        List<String> r1 = r9.b;
        final LiveEffectScene r2 = r8.k;
        FlowLayout r3 = r8.getRecommendKeywordContainer();
        if (r3 == null) goto L8;
        r3.removeAllViews();
    L8:
        Iterator<String> r4 = r1.iterator();
    L9:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L23;
        final String r6 = r4.next();
        if (r8.getContext() == null) goto L9;
        if (r6.length() <= 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L9;
        if ((true ^ StringsKt.isBlank(r6)) == false) goto L9;
        Context r11 = r8.getContext();
        Intrinsics.checkNotNull(r11);
        ?? r12 = new RecommendKeywordView(r11, null, 6, 0);
        r12.setKeyword(r6);
        r12.setOnClick(new StickerSearchPageView$setRecommendKeyword$$inlined$apply$lambda$1(r8, r6, r2));
        FlowLayout r13 = r8.getRecommendKeywordContainer();
        if (r13 == 0) goto L9;
        r13.addView(r12);
        goto L9
    L16:
        r7 = false;
        goto L17
    L23:
        TextView r14 = r8.getSearchEmptyTextView();
        if (r14 == null) goto L44;
        String r15 = r9.a;
        if (r15.length() == 0) goto L29;
        r5 = false;
    L29:
        if (r5 == false) goto L31;
        r15 = s1.B(2131916436);
    L31:
        r14.setText(r15);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b6(StickerSearchPageView r5, com.bytedance.android.live.effect.sticker.viewmodel.a r6) {
        r5.getClass();
        if ((r6 instanceof com.bytedance.android.live.effect.sticker.viewmodel.a.C0196a) == false) goto L8;
        LoadingStatusView r7 = r5.getLoading();
        if (r7 == null) goto L74;
        r7.showError();
        return;
    L74:
        return;
    L8:
        if ((r6 instanceof com.bytedance.android.live.effect.sticker.viewmodel.a.b) == false) goto L76;
        TextView r0 = r5.getSearchRecommendTextView();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.getVisibility() != 4) goto L78;
        com.bytedance.android.live.effect.sticker.viewmodel.a.b r8 = (com.bytedance.android.live.effect.sticker.viewmodel.a.b) r6;
        StickerSearchViewModel.b r1 = (StickerSearchViewModel.b) r8.b;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.c == r5.r) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(((SearchEffectModel) r8.a).getUse_hot(), Boolean.TRUE) == true) goto L20;
        LiveStickerDialogListAdapter r2 = r5.p;
        if (r2 == null) goto L62;
        List r9 = ((SearchEffectModel) r8.a).getEffectList();
        if (r9 != null) goto L57;
        r9 = CollectionsKt.emptyList();
    L57:
        List r11 = r9;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L59:
        if (r12.hasNext() == false) goto L61;
        r3.add(com.bytedance.android.live.effect.sticker.d.d((Effect) r12.next(), r5.l));
        goto L59
    L61:
        r2.y2(r3);
    L62:
        LoadingStatusView r13 = r5.getLoading();
        if (r13 == null) goto L65;
        r13.reset();
    L65:
        RecyclerView r14 = r5.getStickerRecyclerView();
        if (r14 == null) goto L68;
        r14.scrollToPosition(0);
    L68:
        RecyclerView r15 = r5.getStickerRecyclerView();
        if (r15 == null) goto L85;
        r15.setVisibility(0);
        return;
    L85:
        return;
    L20:
        if (((StickerSearchViewModel.b) r8.b).b == false) goto L43;
        LiveStickerDialogListAdapter r4 = r5.p;
        if (r4 == null) goto L31;
        List r16 = ((SearchEffectModel) r8.a).getEffectList();
        if (r16 != null) goto L26;
        r16 = CollectionsKt.emptyList();
    L26:
        List r17 = r16;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        r18.add(com.bytedance.android.live.effect.sticker.d.d((Effect) r19.next(), r5.l));
        goto L28
    L30:
        r4.y2(r18);
    L31:
        LoadingStatusView r21 = r5.getLoading();
        if (r21 == null) goto L34;
        r21.reset();
    L34:
        RecyclerView r22 = r5.getStickerRecyclerView();
        if (r22 == null) goto L37;
        r22.scrollToPosition(0);
    L37:
        RecyclerView r23 = r5.getStickerRecyclerView();
        if (r23 == null) goto L40;
        r23.setVisibility(0);
    L40:
        TextView r24 = r5.getSearchEmptyTextView();
        if (r24 == null) goto L81;
        r24.setVisibility(0);
        return;
    L81:
        return;
    L43:
        LiveStickerDialogListAdapter r25 = r5.p;
        if (r25 == null) goto L46;
        r25.y2(CollectionsKt.emptyList());
    L46:
        LoadingStatusView r26 = r5.getLoading();
        if (r26 == null) goto L49;
        r26.reset();
    L49:
        RecyclerView r27 = r5.getStickerRecyclerView();
        if (r27 == null) goto L83;
        r27.setVisibility(0);
        return;
    L83:
        return;
    L78:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerSearchPageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new StickerSearchPageView$searchBeyondView$2(this));
        this.b = LazyKt.lazy(new StickerSearchPageView$stickerRecyclerView$2(this));
        this.c = LazyKt.lazy(new StickerSearchPageView$searchBox$2(this));
        this.d = LazyKt.lazy(new StickerSearchPageView$cancelButton$2(this));
        this.e = LazyKt.lazy(new StickerSearchPageView$loading$2(this));
        this.f = LazyKt.lazy(new StickerSearchPageView$searchEmptyTextView$2(this));
        this.g = LazyKt.lazy(new StickerSearchPageView$searchRecommendTextView$2(this));
        this.h = LazyKt.lazy(new StickerSearchPageView$recommendKeywordContainer$2(this));
        this.i = LazyKt.lazy(new StickerSearchPageView$editText$2(this));
        this.j = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.k = LiveEffectScene.Live;
        this.l = com.bytedance.android.live.effect.api.d0.c;
        this.s = new CompositeDisposable();
        this.t = new WeakReference(null);
        ViewGroup.inflate(r2, 2131565938, this);
    }

    public /* synthetic */ StickerSearchPageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i6(final StickerSearchPageView r6, LiveEffectContextFactoryDelegate$Type r7, LiveEffectScene r8, LifecycleOwner r9) {
        String r0 = com.bytedance.android.live.effect.api.d0.c;
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r0, "panel");
        r6.j = r7;
        r6.k = r8;
        r6.l = r0;
        r6.t.clear();
        r6.t = new WeakReference(r9);
        StickerBaseViewModel.a r11 = StickerBaseViewModel.Companion;
        LiveEffectScene r12 = r6.k;
        r11.getClass();
        r6.m = (StickerDataViewModel) StickerBaseViewModel.a.a(r12, StickerDataViewModel.class);
        r6.n = (StickerSearchViewModel) StickerBaseViewModel.a.a(r6.k, StickerSearchViewModel.class);
        r6.o = (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r6.k, StickerDialogUIViewModel.class);
        StickerDataViewModel r13 = r6.m;
        if (r13 == null) goto L9;
        Completable r14 = r13.getOnCleared();
        if (r14 == null) goto L9;
        Disposable r15 = r14.subscribe(new p0(r6));
        if (r15 == null) goto L9;
        RxUtilKt.c(r15, r6.s);
    L9:
        StickerDialogUIViewModel r16 = r6.o;
        if (r16 == null) goto L18;
        com.bytedance.live.datacontext.k<Sticker> r17 = r16.getStickerDownloadCompleteEvent();
        if (r17 == null) goto L18;
        PublishSubject r18 = r17.onEvent();
        if (r18 == null) goto L18;
        Disposable r19 = r18.subscribe(new q0(r6));
        if (r19 == null) goto L18;
        RxUtilKt.c(r19, r6.s);
    L18:
        StickerDialogUIViewModel r21 = r6.o;
        if (r21 == null) goto L27;
        com.bytedance.live.datacontext.k<Sticker> r22 = r21.getStickerDownloadStartEvent();
        if (r22 == null) goto L27;
        PublishSubject r23 = r22.onEvent();
        if (r23 == null) goto L27;
        Disposable r24 = r23.subscribe(new r0(r6));
        if (r24 == null) goto L27;
        RxUtilKt.c(r24, r6.s);
    L27:
        LifecycleOwner r25 = r6.t.get();
        if (r25 == null) goto L39;
        StickerDialogUIViewModel r26 = r6.o;
        if (r26 == null) goto L34;
        LiveData<Sticker> r27 = r26.getCurrentSelectStickerData();
        if (r27 == null) goto L34;
        r27.observe(r25, new n0(r6));
    L34:
        StickerSearchViewModel r28 = r6.n;
        if (r28 == null) goto L39;
        LiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, StickerSearchViewModel.b>> r29 = r28.getStickerSearchResultData();
        if (r29 == null) goto L39;
        r29.observe(r25, new o0(r6));
    L39:
        StickerDataViewModel r31 = r6.m;
        if (r31 == null) goto L46;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.effect.sticker.p> r32 = r31.getPanelExtraInfo();
        if (r32 == null) goto L46;
        Disposable r33 = com.bytedance.android.live.effect.sticker.viewmodel.d.a(r32, new StickerSearchPageView$registerLiveData$5(r6));
        if (r33 == null) goto L46;
        RxUtilKt.c(r33, r6.s);
    L46:
        StickerSearchViewModel r34 = r6.n;
        if (r34 == null) goto L55;
        com.bytedance.live.datacontext.k<Unit> r35 = r34.getTabViewClearContentEvent();
        if (r35 == null) goto L55;
        PublishSubject r36 = r35.onEvent();
        if (r36 == null) goto L55;
        Disposable r37 = r36.subscribe(new s0(r6));
        if (r37 == null) goto L55;
        RxUtilKt.c(r37, r6.s);
    L55:
        StickerSearchViewModel r38 = r6.n;
        if (r38 == null) goto L64;
        com.bytedance.live.datacontext.k<Unit> r39 = r38.getTabViewCoverClickEvent();
        if (r39 == null) goto L64;
        PublishSubject r41 = r39.onEvent();
        if (r41 == null) goto L64;
        Disposable r42 = r41.subscribe(new t0(r6));
        if (r42 == null) goto L64;
        RxUtilKt.c(r42, r6.s);
    L64:
        StickerSearchViewModel r43 = r6.n;
        if (r43 == null) goto L73;
        com.bytedance.live.datacontext.k<Unit> r44 = r43.getTabViewSearchFailEvent();
        if (r44 == null) goto L73;
        PublishSubject r45 = r44.onEvent();
        if (r45 == null) goto L73;
        Disposable r46 = r45.subscribe(new u0(r6));
        if (r46 == null) goto L73;
        RxUtilKt.c(r46, r6.s);
    L73:
        StickerSearchViewModel r47 = r6.n;
        if (r47 == null) goto L82;
        com.bytedance.live.datacontext.k<String> r48 = r47.getTabViewKeywordClickEvent();
        if (r48 == null) goto L82;
        PublishSubject r49 = r48.onEvent();
        if (r49 == null) goto L82;
        Disposable r51 = r49.subscribe(new v0(r6));
        if (r51 == null) goto L82;
        RxUtilKt.c(r51, r6.s);
    L82:
        r6.p = new LiveStickerDialogListAdapter(r6.j, r6.k, "search_0", "", new WeakReference(r6.getStickerRecyclerView()));
        View r52 = r6.getSearchBeyondView();
        if (r52 == null) goto L85;
        r52.setOnClickListener(new j0(r6));
    L85:
        RecyclerView r53 = r6.getStickerRecyclerView();
        if (r53 == null) goto L88;
        r53.setAdapter(r6.p);
        r53.setLayoutManager(new SSGridLayoutManager(r53.getContext(), 5, 1));
        r53.setOnTouchListener(new h0(r53, r6));
    L88:
        View r54 = r6.getCancelButton();
        if (r54 == null) goto L91;
        r54.setOnClickListener(new k0(r6));
    L91:
        LoadingStatusView r55 = r6.getLoading();
        if (r55 == null) goto L97;
        LoadingStatusView.Builder r56 = LoadingStatusView.Builder.createDefaultBuilder(r6.getContext());
        FrameLayout r1 = null;
        View r57 = LayoutInflater.from(r6.getContext()).inflate(2131565944, null, false);
        r57.setOnClickListener(new i0(r6));
        Unit r2 = Unit.INSTANCE;
        LoadingStatusView.Builder r58 = r56.setErrorView(r57);
        Context r59 = r6.getContext();
        if (r59 == null) goto L96;
        r1 = new LiveDoubleColorBallAnimationView(r59);
        int r61 = r1.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r61, r61);
        r3.gravity = 17;
        r1.setLayoutParams(r3);
    L96:
        r55.setBuilder(r58.setLoadingView(r1));
    L97:
        FlowLayout r62 = r6.getRecommendKeywordContainer();
        if (r62 == null) goto L100;
        r62.setItemSpacing(UtilityKotlinExtentionsKt.i(12));
        r62.setLineSpacing(UtilityKotlinExtentionsKt.i(12));
    L100:
        StickerSearchBox r63 = r6.getSearchBox();
        if (r63 == null) goto L103;
        r63.setEditTextOnKeyListener(new l0(r6));
    L103:
        StickerSearchBox r64 = r6.getSearchBox();
        if (r64 == null) goto L107;
        r64.setOnChangeListener(new m0(r6));
        return;
    }
}
