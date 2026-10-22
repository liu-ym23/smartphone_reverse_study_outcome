package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.ui.DynamicGridItemDecoration;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaSelectorViewModel;
import com.larus.platform.model.MediaPickerUIMode;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001d\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020+H\u0000¢\u0006\u0002\b4J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u0002062\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010=\u001a\u00020+H\u0002J\b\u0010>\u001a\u00020+H\u0002J\u0015\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u000201H\u0000¢\u0006\u0002\bAJ\b\u0010B\u001a\u00020+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/photopicker/v2/impl/MediaSelectorListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TAG", "", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentMediaListBinding;", "myAdapter", "Lcom/larus/photopicker/v2/impl/ui/MediaListAdapterV2;", "dynamicGridItemDecoration", "Lcom/larus/photopicker/v2/impl/ui/DynamicGridItemDecoration;", "recyclerViewScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "bottomSheetViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getBottomSheetViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "bottomSheetViewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "mediaSelectorViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "getMediaSelectorViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "mediaSelectorViewModel$delegate", "curMediaTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "mediaStateManager", "Lcom/larus/photopicker/v2/impl/strategy/GenericStateManager;", "Lcom/larus/photopicker/v2/impl/strategy/MediaSelectorListState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "adjustScrollForInput", "addedItemUri", "extraPadding", "", "adjustScrollForInput$impl_mainlandRelease", "scrollToTop", "scrollToTop$impl_mainlandRelease", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "initViewModel", "updateInputFooterHeight", "height", "updateInputFooterHeight$impl_mainlandRelease", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaSelectorListFragment extends Fragment {
    public static final /* synthetic */ int p = 0;
    public final String d;
    public final et3.c e;
    public LarusFragmentMediaListBinding f;
    public MediaListAdapterV2 g;
    public DynamicGridItemDecoration h;
    public MediaSelectorListFragment$initViews$1$scrollListener$1 i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public MediaTab n;
    public final up9.x<up9.g0> o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaPickerUIMode.values().length];
            r0[MediaPickerUIMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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

    public static final class d implements Function0<BottomSheetViewModel> {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ Class b;

        public d(Fragment r1, Class r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke() {
            int r0 = e0.a;
            Fragment r1 = e0.a(this.a, this.b);
            if (r1 != null) goto L5;
            return null;
        L5:
            Fragment r2 = this.a;
            final n2 r3 = new n2(r1);
            o2 r4 = new o2(r2);
            return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(r2, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new MediaSelectorListFragment$special$$inlined$findViewModel$1$3(r3), r4).getValue();
        }
    }

    static {
    }

    public final MediaGalleryLiveDataViewModel S90() {
        return (MediaGalleryLiveDataViewModel) this.l.getValue();
    }

    public final void onDestroyView() {
        LarusFragmentMediaListBinding r0 = this.f;
        if (r0 == null) goto L12;
        RecyclerView r1 = r0.c;
        if (r1 == null) goto L12;
        MediaSelectorListFragment$initViews$1$scrollListener$1 r2 = this.i;
        if (r2 == null) goto L9;
        r1.removeOnScrollListener(r2);
    L9:
        r1.setOnTouchListener(null);
        r1.setAdapter(null);
        DynamicGridItemDecoration r3 = this.h;
        if (r3 == null) goto L12;
        r1.removeItemDecoration(r3);
    L12:
        this.i = null;
        MediaListAdapterV2 r4 = this.g;
        if (r4 == null) goto L15;
        r4.c = new vp9.h();
        r4.d = new vp9.i();
    L15:
        this.e.f();
        ((up9.g0) this.o.a()).onDestroyView();
        this.f = null;
        super.onDestroyView();
    }

    public MediaSelectorListFragment() {
        this.d = "MediaSelectorListFragment";
        this.e = new et3.c("photo_album", false, null);
        int r0 = e0.a;
        this.j = LazyKt.lazy(new d(this, c0.class));
        d0 r1 = new d0(this, c0.class);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r1), new Injection$provideViewModel$$inlined$viewModels$default$2(r1, this));
        d0 r2 = new d0(this, MediaGalleryFragment.class);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r2), new Injection$provideViewModel$$inlined$viewModels$default$2(r2, this));
        d0 r3 = new d0(this, MediaSelectorFragment.class);
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaSelectorViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r3), new Injection$provideViewModel$$inlined$viewModels$default$2(r3, this));
        this.n = MediaTab.ALL;
        this.o = new up9.x();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.photopicker.v2.impl.l2, java.lang.Object] */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L7;
        String r5 = r4.getString("media_type");
        if (r5 == null) goto L7;
        this.n = MediaTab.valueOf(r5);
    L7:
        up9.x<up9.g0> r6 = this.o;
        ?? r0 = new l2(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "initialStateFactory");
        r6.a = (S) r0.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.photopicker.v2.impl.j2] */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.photopicker.v2.impl.MediaSelectorListFragment$initViews$1$scrollListener$1] */
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusFragmentMediaListBinding r9 = this.f;
        if (r9 == null) goto L26;
        final GestureDetectorCompat r10 = new GestureDetectorCompat(requireContext(), new vp9.t(r9.c, (MediaSelectorViewModel) this.m.getValue()));
        ?? r0 = new j2(this);
        MediaGalleryUIConfig r1 = S90().getUiConfig();
        this.g = ((up9.g0) this.o.a()).n(requireContext(), r1.b, S90().getLazyLoadConfig().a, r0);
        if (this.n != CollectionsKt.first(r1.a)) goto L11;
        Integer r2 = r1.l;
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L12:
        this.h = new DynamicGridItemDecoration(r1.b, r3);
        RecyclerView r11 = r9.c;
        r11.setHasFixedSize(true);
        DynamicGridItemDecoration r4 = this.h;
        MediaListAdapterV2 r5 = null;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicGridItemDecoration");
        r4 = null;
    L15:
        r11.addItemDecoration(r4);
        r11.setNestedScrollingEnabled(false);
        r11.setItemAnimator(null);
        r11.setLayoutManager(new GridLayoutManager(requireContext(), r1.b));
        RecyclerView.Adapter r6 = this.g;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("myAdapter");
        r6 = null;
    L18:
        r11.setAdapter(r6);
        ?? r12 = new MediaSelectorListFragment$initViews$1$scrollListener$1(this);
        this.i = r12;
        r11.addOnScrollListener(r12);
        r11.setOnTouchListener(new k2(r10));
        if (this.n != CollectionsKt.first(r1.a)) goto L21;
        int r13 = r1.n;
        ViewCompat.setPaddingRelative(r11, r13, 0, r13, 0);
    L21:
        up9.g0.a r14 = ((up9.g0) this.o.a()).c();
        Context r15 = requireContext();
        MediaListAdapterV2 r16 = this.g;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("myAdapter");
    L25:
        r14.a(r15, r5);
        goto L26
    L24:
        r5 = r16;
        goto L25
    L10:
        r3 = r1.k;
        goto L12
    L11:
        r3 = r1.k;
    L26:
        final LarusFragmentMediaListBinding r17 = this.f;
        if (r17 == null) goto L31;
        ((MediaSelectorViewModel) this.m.getValue()).getInjectInputFooterHeight().observe(getViewLifecycleOwner(), new c(new c2(this)));
        ((up9.g0) this.o.a()).c().b(getViewLifecycleOwner(), (BottomSheetViewModel) this.j.getValue(), r17);
        S90().getEnterOrExitPreviewPage().observe(getViewLifecycleOwner(), new c(new e2(this, r17)));
        ((MediaSelectorViewModel) this.m.getValue()).getBottomSelectorHeight().observe(getViewLifecycleOwner(), new c(new f2(this)));
        S90().getFastMediaItems().observe(getViewLifecycleOwner(), new c(new g2(this, r17)));
        S90().getCurrentFolder().observe(getViewLifecycleOwner(), new c(new h2(this, r17)));
        S90().getSelectionManager().i.observe(getViewLifecycleOwner(), new c(new i2(this)));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562402, r3, false);
        int r6 = 2131371592;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r5, 2131371592);
        if (r7 == null) goto L9;
        r6 = 2131384076;
        RecyclerView r0 = ViewBindings.findChildViewById(r5, 2131384076);
        if (r0 == null) goto L9;
        FrameLayout r8 = (FrameLayout) r5;
        this.f = new LarusFragmentMediaListBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
