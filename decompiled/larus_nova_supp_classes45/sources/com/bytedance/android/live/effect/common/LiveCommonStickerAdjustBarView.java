package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerAdjustBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getAdjustBarRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "adjustBarRecyclerView", "Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter;", "d", "getAdjustBarListAdapter", "()Lcom/bytedance/android/live/effect/common/AdjustBarListAdapter;", "adjustBarListAdapter", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerDataViewModel;", "stickerDataViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "stickerRenderViewModel", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "getStickerUIViewModel", "()Lcom/bytedance/android/live/effect/common/LiveCommonStickerUIViewModel;", "stickerUIViewModel", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerAdjustBarView extends ConstraintLayout {
    public final Lazy a;
    public final CompositeDisposable b;
    public final g c;
    public final Lazy d;
    public final String e;
    public final LiveEffectScene f;
    public final WeakReference<LifecycleOwner> g;

    private final AdjustBarListAdapter getAdjustBarListAdapter() {
        return (AdjustBarListAdapter) this.d.getValue();
    }

    private final RecyclerView getAdjustBarRecyclerView() {
        return (RecyclerView) this.a.getValue();
    }

    private final LiveCommonStickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.f;
        String r2 = this.e;
        r0.getClass();
        return (LiveCommonStickerDataViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerDataViewModel.class);
    }

    private final LiveCommonStickerRenderViewModel getStickerRenderViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.f;
        String r2 = this.e;
        r0.getClass();
        return (LiveCommonStickerRenderViewModel) StickerBaseViewModel.a.b(r1, r2, LiveCommonStickerRenderViewModel.class);
    }

    private final LiveCommonStickerUIViewModel getStickerUIViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.f;
        String r2 = this.e;
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
        Disposable r2 = r1.subscribe(new i(this));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, this.b);
    L9:
        LifecycleOwner r3 = this.g.get();
        if (r3 == null) goto L16;
        LiveCommonStickerRenderViewModel r4 = getStickerRenderViewModel();
        if (r4 == null) goto L16;
        LiveData<Sticker> r5 = r4.getRenderStickerData();
        if (r5 == null) goto L16;
        r5.observe(r3, new h(this));
    L16:
        RecyclerView r6 = getAdjustBarRecyclerView();
        if (r6 == null) goto L20;
        final Context r7 = r6.getContext();
        r6.setLayoutManager(new LiveCommonStickerAdjustBarView$initView$1$1(r7));
        r6.setAdapter(getAdjustBarListAdapter());
        return;
    }

    public static final /* synthetic */ LiveCommonStickerRenderViewModel R5(LiveCommonStickerAdjustBarView r0) {
        return r0.getStickerRenderViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveCommonStickerAdjustBarView(Context r4, WeakReference r5) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        Intrinsics.checkNotNullParameter(null, "scene");
        Intrinsics.checkNotNullParameter(null, "type");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        super(r4);
        this.e = "live_camera_move";
        this.f = null;
        this.g = r5;
        LayoutInflater.from(getContext()).inflate(2131565925, this, true);
        this.a = LazyKt.lazy(new LiveCommonStickerAdjustBarView$adjustBarRecyclerView$2(this));
        this.b = new CompositeDisposable();
        this.c = new g(this);
        this.d = LazyKt.lazy(new LiveCommonStickerAdjustBarView$adjustBarListAdapter$2(this));
    }

    public static final void S5(LiveCommonStickerAdjustBarView r2, Sticker r3) {
        AdjustBarListAdapter r0 = r2.getAdjustBarListAdapter();
        LiveCommonStickerRenderViewModel r4 = r2.getStickerRenderViewModel();
        if (r4 == null) goto L6;
        Map<String, Integer> r5 = r4.generateValueMapBySticker(r3);
        if (r5 == null) goto L6;
    L7:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "initValueMap");
        r0.a = r3;
        ((LinkedHashMap) r0.b).clear();
        r0.b.putAll(r5);
        r0.notifyDataSetChanged();
        return;
    L6:
        r5 = MapsKt.emptyMap();
        goto L7
    }
}
