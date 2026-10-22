package com.bytedance.android.live.ktv.common.search.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J+\u0010\u000b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010!R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchContainer;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lkotlin/Function1;", "Lcom/bytedance/android/live/ktv/common/ordersong/feedback/a;", "Lkotlin/ParameterName;", "name", "predicateContent", "", "goFeedbackAction", "setGoFeedbackAction", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchEnterView;", "a", "Lkotlin/Lazy;", "getMSearchView", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchEnterView;", "mSearchView", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchResultView;", "b", "getMSearchResult", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchResultView;", "mSearchResult", "Landroid/widget/LinearLayout;", "c", "getFeedbackContainer", "()Landroid/widget/LinearLayout;", "feedbackContainer", "Landroid/widget/TextView;", "d", "getSearchGoFeedbackTips", "()Landroid/widget/TextView;", "searchGoFeedbackTips", "e", "getSearchGoFeedback", "searchGoFeedback", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "f", "getCommonSearchViewModel", "()Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchContainer extends FrameLayout implements LifecycleOwnerCompat {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public Function1<? super com.bytedance.android.live.ktv.common.ordersong.feedback.a, Unit> g;
    public final LifecycleRegistry h;
    public final q i;

    private final com.bytedance.android.live.ktv.common.search.viewmodel.a getCommonSearchViewModel() {
        return (com.bytedance.android.live.ktv.common.search.viewmodel.a) this.f.getValue();
    }

    private final LinearLayout getFeedbackContainer() {
        return (LinearLayout) this.c.getValue();
    }

    private final CommonSearchResultView getMSearchResult() {
        return (CommonSearchResultView) this.b.getValue();
    }

    private final CommonSearchEnterView getMSearchView() {
        return (CommonSearchEnterView) this.a.getValue();
    }

    private final TextView getSearchGoFeedback() {
        return (TextView) this.e.getValue();
    }

    private final TextView getSearchGoFeedbackTips() {
        return (TextView) this.d.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final void f() {
        this.i.onSearchEnter();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r0 = getCommonSearchViewModel();
        if (r0 == null) goto L5;
        xb0.a r1 = r0.getExtraRequestData();
    L6:
        pb0.a r2 = pb0.b.a;
        if (r1 == null) goto L10;
        String r3 = r1.c;
        if (r3 == null) goto L10;
    L11:
        if (r1 == null) goto L13;
        String r4 = r1.b;
    L14:
        String r5 = this.i.a();
        Intrinsics.checkNotNullParameter(r3, "source");
        pb0.a r6 = pb0.b.a;
        if (r6 == null) goto L17;
        r6.r(com.bytedance.android.live.ktv.common.util.j.g(), r3, r4, r5);
    L17:
        CommonSearchEnterView r7 = getMSearchView();
        if (r7 == null) goto L24;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r8 = getCommonSearchViewModel();
        if (r8 == null) goto L22;
        String r9 = r8.getCurSearchInitText();
    L23:
        r7.d(r9);
        goto L24
    L22:
        r9 = null;
    L24:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r11 = getCommonSearchViewModel();
        if (r11 == null) goto L28;
        r11.updateSearchInitText(null);
        return;
    L28:
        return;
    L13:
        r4 = null;
    L10:
        r3 = "";
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void g() {
        CommonSearchEnterView r0 = getMSearchView();
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public Lifecycle getLifecycleCompat() {
        return this.h;
    }

    public static final /* synthetic */ com.bytedance.android.live.ktv.common.search.viewmodel.a a(CommonSearchContainer r0) {
        return r0.getCommonSearchViewModel();
    }

    public static final /* synthetic */ CommonSearchResultView b(CommonSearchContainer r0) {
        return r0.getMSearchResult();
    }

    public static final /* synthetic */ CommonSearchEnterView c(CommonSearchContainer r0) {
        return r0.getMSearchView();
    }

    public void setGoFeedbackAction(Function1<? super com.bytedance.android.live.ktv.common.ordersong.feedback.a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "goFeedbackAction");
        this.g = r2;
    }

    public static final void e(CommonSearchContainer r7, List r8) {
        if (r8 == null) goto L4;
        r7.getClass();
        ((SingleSubscribeProxy) Single.create(new h(r7, r8)).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r7))).subscribe(new i(r7, r8), j.a);
    L4:
        CommonSearchEnterView r0 = r7.getMSearchView();
        if (r0 == null) goto L7;
        r0.g();
    L7:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r1 = r7.getCommonSearchViewModel();
        Long r2 = null;
        if (r1 == null) goto L10;
        String r3 = r1.getCurSearchKeyword();
    L11:
        boolean r4 = false;
        if (r8 == null) goto L16;
        MusicPanel r9 = (MusicPanel) CollectionsKt.getOrNull(r8, 0);
        if (r9 == null) goto L16;
        KtvMusic r11 = r9.a;
    L18:
        if (r3 == null) goto L44;
        if (r11 == null) goto L44;
        int r5 = yb0.a.a;
        String r6 = yb0.a.a(r11.getMTitle(), r3);
        String r12 = yb0.a.a(r11.getMAuthor(), r3);
        if (r6.length() <= 0) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == false) goto L33;
        if (r11.getMTitle() == null) goto L33;
        if (Intrinsics.areEqual(r6, r11.getMTitle()) == false) goto L33;
        r12 = r11.getMAuthor();
        if (r12 != null) goto L33;
        r12 = "";
    L33:
        if (r12.length() <= 0) goto L35;
        r4 = true;
    L35:
        if (r4 == true) goto L37;
    L43:
        com.bytedance.android.live.ktv.common.ordersong.feedback.a r14 = new com.bytedance.android.live.ktv.common.ordersong.feedback.a(r6, r12);
    L45:
        if (r14 != null) goto L47;
        r14 = new com.bytedance.android.live.ktv.common.ordersong.feedback.a("", "");
    L47:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r15 = r7.getCommonSearchViewModel();
        if (r15 == null) goto L50;
        r15.updatePredicateContent(r14);
    L50:
        CommonSearchEnterView r16 = r7.getMSearchView();
        if (r16 == null) goto L53;
        r2 = Long.valueOf(r16.getSearchStartTime());
    L53:
        if (r2 != null) goto L55;
        return;
    L55:
        if (r2.longValue() == 0) goto L63;
        CommonSearchResultView r17 = r7.getMSearchResult();
        if (r17 == null) goto L64;
        ViewTreeObserver r18 = r17.getViewTreeObserver();
        if (r18 == null) goto L65;
        r18.addOnGlobalLayoutListener(new k(r7, r2));
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L37:
        if (r11.getMAuthor() == null) goto L43;
        if (Intrinsics.areEqual(r12, r11.getMAuthor()) == false) goto L43;
        r6 = r11.getMTitle();
        if (r6 != null) goto L43;
        r6 = "";
        goto L43
    L23:
        r13 = false;
    L44:
        r14 = null;
    L16:
        r11 = null;
        goto L18
    L10:
        r3 = null;
        goto L11
    }

    public CommonSearchContainer(q r2, Context r3, boolean r4, int r5) {
        int r0 = 0;
        if ((r5 & 16) == 0) goto L5;
        r4 = false;
    L5:
        Intrinsics.checkNotNullParameter(r2, "outerCallback");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.i = r2;
        this.a = LazyKt.lazy(new CommonSearchContainer$mSearchView$2(this));
        this.b = LazyKt.lazy(new CommonSearchContainer$mSearchResult$2(this));
        this.c = LazyKt.lazy(new CommonSearchContainer$feedbackContainer$2(this));
        this.d = LazyKt.lazy(new CommonSearchContainer$searchGoFeedbackTips$2(this));
        this.e = LazyKt.lazy(new CommonSearchContainer$searchGoFeedback$2(this));
        this.f = LazyKt.lazy(new CommonSearchContainer$commonSearchViewModel$2(this));
        LifecycleRegistry r6 = new LifecycleRegistry(this);
        this.h = r6;
        if (r4 == false) goto L8;
        int r7 = 2131566460;
    L9:
        LayoutInflater.from(r3).inflate(r7, this);
        r6.setCurrentState(Lifecycle.State.CREATED);
        CommonSearchResultView r8 = getMSearchResult();
        if (r8 == null) goto L12;
        r8.setOuterCallback(r2);
    L12:
        CommonSearchEnterView r9 = getMSearchView();
        if (r9 == null) goto L15;
        r9.setOuterCallback(r2);
    L15:
        CommonSearchEnterView r11 = getMSearchView();
        if (r11 == null) goto L18;
        r11.setSearchResultView(getMSearchResult());
    L18:
        CommonSearchEnterView r12 = getMSearchView();
        if (r12 == null) goto L21;
        r12.setCancelAction(new AnonymousClass1(this));
    L21:
        TextView r13 = getSearchGoFeedback();
        if (r13 == null) goto L24;
        r13.setOnClickListener(new g(this));
    L24:
        TextView r14 = getSearchGoFeedbackTips();
        if (r14 == null) goto L27;
        KtvOrderSongThemeManager.d(r14, KtvOrderSongThemeManager.f);
    L27:
        KtvOrderSongThemeManager.b(this, 1);
        com.bytedance.android.live.ktv.common.search.viewmodel.a r15 = getCommonSearchViewModel();
        if (r15 == null) goto L30;
        r15.observeHistoryListChange(this, new c(this));
    L30:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r16 = getCommonSearchViewModel();
        if (r16 == null) goto L33;
        r16.observeHotWordListChange(this, new d(this));
    L33:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r17 = getCommonSearchViewModel();
        if (r17 == null) goto L36;
        r17.observeGuessWordListChange(this, new e(this));
    L36:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r18 = getCommonSearchViewModel();
        if (r18 == null) goto L39;
        r18.observeSearchedMusicListChange(this, new f(this));
    L39:
        LinearLayout r19 = getFeedbackContainer();
        if (r19 != null) goto L42;
    L46:
        setClickable(true);
        setEnabled(true);
        return;
    L42:
        if (r2.f() == true) goto L45;
        r0 = 8;
    L45:
        r19.setVisibility(r0);
        goto L46
    L8:
        r7 = 2131566471;
        goto L9
    }
}
