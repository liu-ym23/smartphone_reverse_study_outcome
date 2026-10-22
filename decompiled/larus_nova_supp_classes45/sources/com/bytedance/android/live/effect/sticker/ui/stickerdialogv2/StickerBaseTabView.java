package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerBaseTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lio/reactivex/disposables/CompositeDisposable;", "a", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "b", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "c", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "getScene", "()Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "stickerDataViewModel", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "getUiViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "uiViewModel", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class StickerBaseTabView extends ConstraintLayout {
    public final CompositeDisposable a;
    public final LiveEffectContextFactoryDelegate$Type b;
    public final LiveEffectScene c;

    public static final class a implements Action {
        public final /* synthetic */ StickerBaseTabView a;

        public a(StickerBaseTabView r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.getCompositeDisposable().clear();
        }
    }

    public void initView() {
    }

    public final StickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.c;
        r0.getClass();
        return (StickerDataViewModel) StickerBaseViewModel.a.a(r1, StickerDataViewModel.class);
    }

    public final StickerDialogUIViewModel getUiViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.c;
        r0.getClass();
        return (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r1, StickerDialogUIViewModel.class);
    }

    public void T5() {
        StickerDataViewModel r0 = getStickerDataViewModel();
        if (r0 == null) goto L10;
        Completable r1 = r0.getOnCleared();
        if (r1 == null) goto L11;
        Disposable r2 = r1.subscribe(new a(this));
        if (r2 == null) goto L12;
        RxUtilKt.c(r2, this.a);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        T5();
        initView();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.a;
    }

    public final LiveEffectScene getScene() {
        return this.c;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.b;
    }

    public static void S5(LoadingStatusView r1, StickerLoadingStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "loadingStatus");
        int r3 = e0.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        if (r1 == null) goto L17;
        r1.showLoading();
        return;
    L17:
        return;
    L5:
        if (r3 == 2) goto L8;
        if (r1 == null) goto L13;
        r1.reset();
        return;
    L13:
        return;
    L8:
        if (r1 == null) goto L15;
        r1.showError();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(LoadingStatusView r6, View.OnClickListener r7) {
        Intrinsics.checkNotNullParameter(r7, "onClickListener");
        if (r6 == null) goto L9;
        LoadingStatusView.Builder r0 = LoadingStatusView.Builder.createDefaultBuilder(getContext());
        FrameLayout r3 = null;
        View r1 = LayoutInflater.from(getContext()).inflate(2131565944, null, false);
        r1.setOnClickListener(r7);
        Unit r8 = Unit.INSTANCE;
        LoadingStatusView.Builder r9 = r0.setErrorView(r1);
        Context r2 = getContext();
        if (r2 == null) goto L7;
        r3 = new LiveDoubleColorBallAnimationView(r2);
        int r4 = r3.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r4, r4);
        r5.gravity = 17;
        r3.setLayoutParams(r5);
    L7:
        r6.setBuilder(r9.setLoadingView(r3));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerBaseTabView(Context r2, int r3, LiveEffectContextFactoryDelegate$Type r4, LiveEffectScene r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "scene");
        super(r2);
        this.b = r4;
        this.c = r5;
        this.a = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(r3, this, true);
    }
}
