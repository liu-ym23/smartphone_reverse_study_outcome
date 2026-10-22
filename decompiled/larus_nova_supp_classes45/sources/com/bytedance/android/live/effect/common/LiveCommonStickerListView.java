package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerListView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getLoadingView", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loadingView", "Landroidx/recyclerview/widget/RecyclerView;", "b", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "com/bytedance/android/live/effect/common/LiveCommonStickerListView$stickerListAdapterListener$2$a", "d", "getStickerListAdapterListener", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerListView$stickerListAdapterListener$2$a;", "stickerListAdapterListener", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter;", "e", "getStickerListAdapter", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter;", "stickerListAdapter", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "stickerDataViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "stickerRenderViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "getStickerUIViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "stickerUIViewModel", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerListView extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final CompositeDisposable c;
    public final Lazy d;
    public final Lazy e;
    public final String f;
    public final LiveEffectScene g;
    public final LiveEffectContextFactoryDelegate$Type h;
    public final WeakReference<LifecycleOwner> i;
    public final o j;

    public LiveCommonStickerListView() {
        throw null;
    }

    private final LoadingStatusView getLoadingView() {
        return (LoadingStatusView) this.a.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.b.getValue();
    }

    private final LiveCommonStickerListAdapter getStickerListAdapter() {
        return (LiveCommonStickerListAdapter) this.e.getValue();
    }

    private final LiveCommonStickerListView$stickerListAdapterListener$2.a getStickerListAdapterListener() {
        return (LiveCommonStickerListView$stickerListAdapterListener$2.a) this.d.getValue();
    }

    private final LiveCommonStickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.g;
        String r2 = this.f;
        r0.getClass();
        return (LiveCommonStickerDataViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerDataViewModel.class);
    }

    private final LiveCommonStickerRenderViewModel getStickerRenderViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.g;
        String r2 = this.f;
        r0.getClass();
        return (LiveCommonStickerRenderViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerRenderViewModel.class);
    }

    private final LiveCommonStickerUIViewModel getStickerUIViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.g;
        String r2 = this.f;
        r0.getClass();
        return (LiveCommonStickerUIViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerUIViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        LiveCommonStickerDataViewModel r0 = getStickerDataViewModel();
        if (r0 == null) goto L9;
        Completable r1 = r0.getOnCleared();
        if (r1 == null) goto L9;
        Disposable r2 = r1.subscribe(new v(this));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, this.c);
    L9:
        LifecycleOwner r3 = this.i.get();
        if (r3 == null) goto L31;
        LiveCommonStickerDataViewModel r4 = getStickerDataViewModel();
        if (r4 == null) goto L16;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, List<Sticker>> r5 = r4.getStickerListMap();
        if (r5 == null) goto L16;
        r5.b(this.f, r3, new r(this));
    L16:
        LiveCommonStickerDataViewModel r6 = getStickerDataViewModel();
        if (r6 == null) goto L21;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, StickerLoadingStatus> r7 = r6.getStickerListLoadingStatusMap();
        if (r7 == null) goto L21;
        r7.b(this.f, r3, new s(this));
    L21:
        LiveCommonStickerRenderViewModel r8 = getStickerRenderViewModel();
        if (r8 == null) goto L26;
        LiveData<Sticker> r9 = r8.getRenderStickerData();
        if (r9 == null) goto L26;
        r9.observe(r3, new t(this));
    L26:
        LiveCommonStickerUIViewModel r11 = getStickerUIViewModel();
        if (r11 == null) goto L31;
        LiveData<Boolean> r12 = r11.getRepelStatus();
        if (r12 == null) goto L31;
        r12.observe(r3, new u(this));
    L31:
        LiveCommonStickerUIViewModel r13 = getStickerUIViewModel();
        if (r13 == null) goto L34;
        r13.startObserveRepelStatus();
    L34:
        LiveCommonStickerUIViewModel r14 = getStickerUIViewModel();
        if (r14 == null) goto L43;
        com.bytedance.live.datacontext.k<Sticker> r15 = r14.getStickerDownloadStartEvent();
        if (r15 == null) goto L43;
        PublishSubject r16 = r15.onEvent();
        if (r16 == null) goto L43;
        Disposable r17 = r16.subscribe(new w(this));
        if (r17 == null) goto L43;
        RxUtilKt.c(r17, this.c);
    L43:
        LiveCommonStickerUIViewModel r18 = getStickerUIViewModel();
        if (r18 == null) goto L52;
        com.bytedance.live.datacontext.k<Sticker> r19 = r18.getStickerDownloadCompleteEvent();
        if (r19 == null) goto L52;
        PublishSubject r21 = r19.onEvent();
        if (r21 == null) goto L52;
        Disposable r22 = r21.subscribe(new x(this));
        if (r22 == null) goto L52;
        RxUtilKt.c(r22, this.c);
    L52:
        LoadingStatusView r23 = getLoadingView();
        if (r23 == null) goto L58;
        LoadingStatusView.Builder r24 = LoadingStatusView.Builder.createDefaultBuilder(getContext());
        FrameLayout r25 = null;
        View r26 = LayoutInflater.from(getContext()).inflate(2131565944, null, false);
        r26.setOnClickListener(new q(this));
        Unit r27 = Unit.INSTANCE;
        LoadingStatusView.Builder r28 = r24.setErrorView(r26);
        Context r29 = getContext();
        if (r29 == null) goto L57;
        r25 = new LiveDoubleColorBallAnimationView(r29);
        int r31 = r25.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r32 = new FrameLayout.LayoutParams(r31, r31);
        r32.gravity = 17;
        r25.setLayoutParams(r32);
    L57:
        r23.setBuilder(r28.setLoadingView(r25));
    L58:
        RecyclerView r33 = getRecyclerView();
        if (r33 == null) goto L61;
        r33.setAdapter(getStickerListAdapter());
    L61:
        RecyclerView r34 = getRecyclerView();
        if (r34 == null) goto L64;
        r34.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L64:
        RecyclerView.ItemDecoration r35 = this.j.b;
        if (r35 == null) goto L69;
        RecyclerView r36 = getRecyclerView();
        if (r36 == null) goto L69;
        r36.addItemDecoration(r35);
    L69:
        LiveCommonStickerDataViewModel r37 = getStickerDataViewModel();
        if (r37 == null) goto L73;
        r37.fetchStickerList(this.f);
        return;
    }

    public static final /* synthetic */ RecyclerView R5(LiveCommonStickerListView r0) {
        return r0.getRecyclerView();
    }

    public static final /* synthetic */ LiveCommonStickerDataViewModel S5(LiveCommonStickerListView r0) {
        return r0.getStickerDataViewModel();
    }

    public static final /* synthetic */ LiveCommonStickerListAdapter T5(LiveCommonStickerListView r0) {
        return r0.getStickerListAdapter();
    }

    public static final /* synthetic */ LiveCommonStickerListView$stickerListAdapterListener$2.a U5(LiveCommonStickerListView r0) {
        return r0.getStickerListAdapterListener();
    }

    public static final /* synthetic */ LiveCommonStickerRenderViewModel V5(LiveCommonStickerListView r0) {
        return r0.getStickerRenderViewModel();
    }

    public static final /* synthetic */ LiveCommonStickerUIViewModel Y5(LiveCommonStickerListView r0) {
        return r0.getStickerUIViewModel();
    }

    public static final void b6(LiveCommonStickerListView r7) {
        LiveCommonStickerListAdapter r8 = r7.getStickerListAdapter();
        Sticker r0 = r8.k.d();
        if (r0 == null) goto L5;
        long r1 = r0.getId();
    L6:
        long r3 = r8.e;
        r8.e = r1;
        List<Long> r5 = r8.d;
        ArrayList r6 = (ArrayList) r5;
        int r2 = r6.indexOf(Long.valueOf(r1));
        if (r0 == null) goto L12;
        if (r2 < 0) goto L12;
        if (r2 >= ((ArrayList) r8.c).size()) goto L12;
        ListProtector.set(r8.c, r2, r0);
    L12:
        List<Long> r4 = r8.d;
        ArrayList r9 = (ArrayList) r4;
        if (r9.contains(Long.valueOf(r3)) == true) goto L15;
    L17:
        List<Long> r11 = r8.d;
        ArrayList r12 = (ArrayList) r11;
        if (r12.contains(Long.valueOf(r8.e)) == true) goto L20;
        return;
    L20:
        if (r3 == r8.e) goto L24;
        r8.notifyItemChanged(r2, "payload");
        return;
    L24:
        return;
    L15:
        if (r3 == r8.e) goto L17;
        List<Long> r13 = r8.d;
        ArrayList r14 = (ArrayList) r13;
        r8.notifyItemChanged(r14.indexOf(Long.valueOf(r3)), "payload");
        goto L17
    L5:
        r1 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveCommonStickerListView(Context r5, WeakReference r6) {
        o r0 = new o(new j(), 2);
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        Intrinsics.checkNotNullParameter(null, "scene");
        Intrinsics.checkNotNullParameter(null, "type");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "styleConfig");
        super(r5);
        this.f = "live_camera_move";
        this.g = null;
        this.h = null;
        this.i = r6;
        this.j = r0;
        LayoutInflater.from(getContext()).inflate(2131565932, this, true);
        this.a = LazyKt.lazy(new LiveCommonStickerListView$loadingView$2(this));
        this.b = LazyKt.lazy(new LiveCommonStickerListView$recyclerView$2(this));
        this.c = new CompositeDisposable();
        this.d = LazyKt.lazy(new LiveCommonStickerListView$stickerListAdapterListener$2(this));
        this.e = LazyKt.lazy(new LiveCommonStickerListView$stickerListAdapter$2(this));
    }

    public static final void Z5(LiveCommonStickerListView r1, StickerLoadingStatus r2) {
        r1.getClass();
        int r3 = p.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        LoadingStatusView r4 = r1.getLoadingView();
        if (r4 == null) goto L23;
        r4.showLoading();
        return;
    L23:
        return;
    L5:
        if (r3 != 2) goto L7;
        LoadingStatusView r5 = r1.getLoadingView();
        if (r5 == null) goto L21;
        r5.showError();
        return;
    L21:
        return;
    L7:
        if (r3 != 3) goto L24;
        LoadingStatusView r6 = r1.getLoadingView();
        if (r6 == null) goto L19;
        r6.reset();
        return;
    L19:
        return;
    }

    public static final void c6(LiveCommonStickerListView r4, List r5) {
        LiveCommonStickerListAdapter r6 = r4.getStickerListAdapter();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        Sticker r0 = r6.k.d();
        if (r0 == null) goto L5;
        long r1 = r0.getId();
    L6:
        r6.e = r1;
        ((ArrayList) r6.c).clear();
        ArrayList r2 = (ArrayList) r6.c;
        r2.addAll(r5);
        ((ArrayList) r6.d).clear();
        List<Long> r7 = r6.d;
        List<Sticker> r3 = r6.c;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r9 = ((ArrayList) r3).iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r8.add(Long.valueOf(((Sticker) r9.next()).getId()));
        goto L8
    L10:
        ((ArrayList) r7).addAll(r8);
        r6.notifyDataSetChanged();
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
