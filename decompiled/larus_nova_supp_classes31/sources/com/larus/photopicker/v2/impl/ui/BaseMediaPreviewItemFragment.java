package com.larus.photopicker.v2.impl.ui;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.larus.photopicker.v2.impl.Injection$provideViewModel$$inlined$viewModels$default$1;
import com.larus.photopicker.v2.impl.Injection$provideViewModel$$inlined$viewModels$default$2;
import com.larus.photopicker.v2.impl.MediaGalleryFragment;
import com.larus.photopicker.v2.impl.MediaPreviewFragment;
import com.larus.photopicker.v2.impl.d0;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaPreviewViewModel;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import op9.d;
import qp9.a0;
import qp9.k;
import wp9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020-H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/BaseMediaPreviewItemFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "Lkotlin/Lazy;", "mediaPreviewViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "getMediaPreviewViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "mediaPreviewViewModel$delegate", "updateThrottler", "Lcom/larus/photopicker/v2/impl/utils/UpdateThrottler;", "uiMediaItem", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "getUiMediaItem", "()Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "setUiMediaItem", "(Lcom/larus/photopicker/v2/impl/model/UIMediaItem;)V", "curPosition", "", "getCurPosition", "()I", "setCurPosition", "(I)V", "provideGestureLayout", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "initView", "nonNullMediaItem", "initViewModel", "onResume", "onPause", "onDestroyView", "provideAnimationConfiguration", "Lcom/larus/photopicker/v2/impl/others/scale/AppearOrDisappearAnimationConfiguration;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class BaseMediaPreviewItemFragment extends Fragment {
    public static final /* synthetic */ int i = 0;
    public final Lazy d;
    public final Lazy e;
    public final g f;
    public d g;
    public int h;

    public static final class a {
    }

    public static final class b implements a0 {
        public final /* synthetic */ BaseMediaPreviewItemFragment a;

        @Override // qp9.a0
        public final void a() {
        }

        @Override // qp9.a0
        public final void b() {
        }

        @Override // qp9.a0
        public final void onClick() {
        }

        @Override // qp9.a0
        public final void onExit() {
            this.a.S90().getEnterOrExitPreviewPage().setValue(TuplesKt.to(Boolean.FALSE, Integer.valueOf(this.a.h)));
        }

        public b(BaseMediaPreviewItemFragment r1) {
            this.a = r1;
        }

        @Override // qp9.a0
        public final void c(float r4) {
            if (this.a.f.a() == true) goto L14;
            boolean r1 = true;
            if (r4 != 1.0f) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L14;
            if (r4 == 0.0f) goto L13;
            r1 = false;
        L13:
            if (r1 == true) goto L14;
            return;
        L7:
            r0 = false;
        L14:
            ((MediaPreviewViewModel) this.a.e.getValue()).getPreviewPageAlphaPercentChange().setValue(Float.valueOf(r4));
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(vp9.a r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public abstract ScaleGestureLayout V90();

    public static qp9.a U90() {
        qp9.a r0 = new qp9.a();
        r0.e = 220;
        r0.f = 220;
        r0.g = 220;
        r0.h = 220;
        Pair<? extends PointF, ? extends PointF> r1 = qp9.b.a;
        PointF r2 = (PointF) r1.component1();
        PointF r3 = (PointF) r1.component2();
        rp9.b r4 = new rp9.b(r2, r3);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
        rp9.b r5 = new rp9.b(r2, r3);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.b = r5;
        rp9.b r6 = new rp9.b(r2, r3);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.c = r6;
        rp9.b r7 = new rp9.b(r2, r3);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.d = r7;
        return r0;
    }

    public final MediaGalleryLiveDataViewModel S90() {
        return (MediaGalleryLiveDataViewModel) this.d.getValue();
    }

    public BaseMediaPreviewItemFragment() {
        int r0 = e0.a;
        d0 r1 = new d0(this, MediaGalleryFragment.class);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r1), new Injection$provideViewModel$$inlined$viewModels$default$2(r1, this));
        d0 r2 = new d0(this, MediaPreviewFragment.class);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaPreviewViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r2), new Injection$provideViewModel$$inlined$viewModels$default$2(r2, this));
        this.f = new g(8);
        this.h = -1;
    }

    public void onDestroyView() {
        super.onDestroyView();
        V90().k();
    }

    public void onPause() {
        super.onPause();
        V90().k();
    }

    public void onResume() {
        super.onResume();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        int r4 = r3.getInt("media_item_position");
        this.h = r4;
        List r0 = (List) S90().getCurrentPreviewItems().getValue();
        if (r0 == null) goto L7;
        d r5 = (d) CollectionsKt.getOrNull(r0, r4);
    L8:
        this.g = r5;
        return;
    L7:
        r5 = null;
        goto L8
    }

    public void T90(d r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "nonNullMediaItem");
        Intrinsics.checkNotNullParameter(r5, "view");
        final ScaleGestureLayout r6 = V90();
        mp9.c r7 = r4.a;
        int r0 = r7.j;
        int r8 = r7.k;
        r6.getClass();
        r6.p = new Rect(0, 0, r0, r8);
        r6.post(new k(r6));
        r6.setZoomListener(new b(this));
        if (this.h == S90().getCurPreviewPosition()) goto L5;
        return;
    L5:
        if (S90().isNeedAnimWhenEnterPreview() == false) goto L9;
        S90().getEnterOrExitPreviewPage().setValue(TuplesKt.to(Boolean.TRUE, Integer.valueOf(this.h)));
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [vp9.a] */
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        d r5 = this.g;
        if (r5 != null) goto L5;
        return;
    L5:
        T90(r5, r3);
        S90().getCapturePositionViewRect().observe(getViewLifecycleOwner(), new c(new vp9.a(this)));
    }
}
