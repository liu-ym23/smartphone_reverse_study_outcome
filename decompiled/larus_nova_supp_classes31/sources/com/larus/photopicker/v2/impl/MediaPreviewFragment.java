package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentPreviewBinding;
import com.larus.photopicker.v2.impl.others.CenterLayoutManager;
import com.larus.photopicker.v2.impl.ui.MediaPreviewBottomSelectorAdapter;
import com.larus.photopicker.v2.impl.ui.MediaPreviewListPagerAdapterV2;
import com.larus.photopicker.v2.impl.ui.PreviewBottomSelectorClickType;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaPreviewViewModel;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Set;
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
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0002J \u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020,H\u0002J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/photopicker/v2/impl/MediaPreviewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TAG", "", "bottomSheetViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getBottomSheetViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "bottomSheetViewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "mediaPreviewViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "getMediaPreviewViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "mediaPreviewViewModel$delegate", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentPreviewBinding;", "viewPagerAdapter", "Lcom/larus/photopicker/v2/impl/ui/MediaPreviewListPagerAdapterV2;", "bottomSelectorAdapter", "Lcom/larus/photopicker/v2/impl/ui/MediaPreviewBottomSelectorAdapter;", "currentMediaItem", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initViews", "clickItem", "mediaItem", "position", "", "type", "Lcom/larus/photopicker/v2/impl/ui/PreviewBottomSelectorClickType;", "initViewModel", "updateCheckboxStatus", "updateOriginalImageVisibility", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaPreviewFragment extends Fragment {
    public static final /* synthetic */ int m = 0;
    public final String d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public LarusFragmentPreviewBinding i;
    public MediaPreviewListPagerAdapterV2 j;
    public MediaPreviewBottomSelectorAdapter k;
    public op9.d l;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreviewBottomSelectorClickType.values().length];
            r0[PreviewBottomSelectorClickType.CLICK_ITEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PreviewBottomSelectorClickType.DEL_ITEM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    public static final class c implements Function0<BottomSheetViewModel> {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ Class b;

        public c(Fragment r1, Class r2) {
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
            final g1 r3 = new g1(r1);
            h1 r4 = new h1(r2);
            return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(r2, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new MediaPreviewFragment$special$$inlined$findViewModel$1$3(r3), r4).getValue();
        }
    }

    public final BottomSheetViewModel S90() {
        return (BottomSheetViewModel) this.e.getValue();
    }

    public final MediaGalleryLiveDataViewModel T90() {
        return (MediaGalleryLiveDataViewModel) this.g.getValue();
    }

    public final void V90() {
        LarusFragmentPreviewBinding r0 = this.i;
        MediaType r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayout r2 = r0.j;
        if (T90().getUiConfig().E == false) goto L15;
        op9.d r3 = this.l;
        if (r3 == null) goto L13;
        mp9.c r4 = r3.a;
        if (r4 == null) goto L13;
        r1 = r4.getType();
    L13:
        if (r1 != MediaType.IMAGE) goto L15;
        boolean r5 = true;
    L16:
        wp9.i.c(r2, r5);
        return;
    L15:
        r5 = false;
        goto L16
    }

    public final void onDestroyView() {
        int r0 = e0.a;
        e0.d(this.d, "onDestroyView");
        super.onDestroyView();
        BottomSheetViewModel r1 = S90();
        if (r1 == null) goto L6;
        r1.requestDisallowInterceptTouchEvent(false);
        return;
    }

    public MediaPreviewFragment() {
        this.d = "MediaPreviewFragment";
        int r0 = e0.a;
        this.e = LazyKt.lazy(new c(this, c0.class));
        d0 r1 = new d0(this, c0.class);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r1), new Injection$provideViewModel$$inlined$viewModels$default$2(r1, this));
        d0 r2 = new d0(this, MediaGalleryFragment.class);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r2), new Injection$provideViewModel$$inlined$viewModels$default$2(r2, this));
        final Function0<Fragment> r3 = new MediaPreviewFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaPreviewViewModel.class), new MediaPreviewFragment$special$$inlined$viewModels$default$2(r3), new MediaPreviewFragment$special$$inlined$viewModels$default$3(r3, this));
    }

    public final void U90() {
        List r0 = (List) T90().getCurrentPreviewItems().getValue();
        if (r0 == null) goto L31;
        op9.d r1 = (op9.d) CollectionsKt.getOrNull(r0, T90().getCurPreviewPosition());
        if (r1 == null) goto L32;
        LarusFragmentPreviewBinding r3 = null;
        Context r4 = null;
        if (T90().getSelectionManager().g(r1.a.a) == false) goto L10;
        LarusFragmentPreviewBinding r2 = this.i;
        if (r2 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L28:
        r3.e.setBackgroundResource(2131243500);
    L29:
        T90().toggleSelection(r1);
        return;
    L27:
        r3 = r2;
        goto L28
    L10:
        if (T90().getSelectionManager().a(r1) == true) goto L12;
        return;
    L12:
        LarusFragmentPreviewBinding r5 = this.i;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L15:
        AppCompatTextView r6 = r5.e;
        if (r6 == null) goto L29;
        LarusFragmentPreviewBinding r7 = this.i;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        AppCompatTextView r8 = r7.e;
        if (r8 == null) goto L23;
        r4 = r8.getContext();
    L23:
        r6.setBackgroundResource(v19.c.b(2130971616, r4, 2131240746));
        goto L29
    L32:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.photopicker.v2.impl.w0] */
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        int r0 = e0.a;
        e0.d(this.d, "onViewCreated");
        super.onViewCreated(r5, r6);
        BottomSheetViewModel r7 = S90();
        if (r7 == null) goto L5;
        r7.requestDisallowInterceptTouchEvent(true);
    L5:
        this.j = new MediaPreviewListPagerAdapterV2(this);
        LarusFragmentPreviewBinding r8 = this.i;
        LarusFragmentPreviewBinding r1 = null;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L8:
        ViewPager2 r9 = r8.k;
        RecyclerView.Adapter r2 = this.j;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
        r2 = null;
    L11:
        r9.setAdapter(r2);
        r9.setOffscreenPageLimit(1);
        r9.registerOnPageChangeCallback(new MediaPreviewFragment$initViews$1$1(this));
        LarusFragmentPreviewBinding r10 = this.i;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L14:
        RecyclerView r11 = r10.c;
        MediaPreviewBottomSelectorAdapter r12 = new MediaPreviewBottomSelectorAdapter(new w0(this));
        this.k = r12;
        r11.setAdapter(r12);
        r11.setLayoutManager(new CenterLayoutManager(r11.getContext()));
        LarusFragmentPreviewBinding r13 = this.i;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L17:
        r13.f.setOnClickListener(new x0(this));
        LarusFragmentPreviewBinding r14 = this.i;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L20:
        r14.e.setOnClickListener(new y0(this));
        LarusFragmentPreviewBinding r15 = this.i;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L23:
        AppCompatTextView r16 = r15.d;
        Context r17 = requireContext();
        String r3 = T90().getNonUiSettings().e;
        Set r4 = (Set) T90().getSelectionManager().g.getValue();
        if (r4 == null) goto L26;
        int r18 = r4.size();
    L27:
        r16.setText(wp9.i.a(r17, r3, r18));
        LarusFragmentPreviewBinding r19 = this.i;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L30:
        r19.g.setOnClickListener(new z0(this));
        if (T90().getUiConfig().E == false) goto L36;
        V90();
        LarusFragmentPreviewBinding r20 = this.i;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L35:
        r20.j.setOnClickListener(new a1(this));
    L36:
        LarusFragmentPreviewBinding r21 = this.i;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L40:
        r1.d.setOnClickListener(new b1(this));
        T90().getCurrentPreviewItems().observe(getViewLifecycleOwner(), new b(new c1(this)));
        T90().getSelectionManager().g.observe(getViewLifecycleOwner(), new b(new d1(this)));
        ((MediaPreviewViewModel) this.h.getValue()).getPreviewPageAlphaPercentChange().observe(getViewLifecycleOwner(), new b(new e1(this)));
        BottomSheetViewModel r22 = S90();
        if (r22 == null) goto L46;
        MutableLiveData<Boolean> r23 = r22.isOriginalImageChecked();
        if (r23 == null) goto L47;
        r23.observe(getViewLifecycleOwner(), new b(new f1(this)));
        return;
    L47:
        return;
    L46:
        return;
    L39:
        r1 = r21;
        goto L40
    L26:
        r18 = 0;
        goto L27
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131562425, r14, false);
        int r17 = 2131379807;
        View r2 = ViewBindings.findChildViewById(r16, 2131379807);
        if (r2 == null) goto L25;
        r17 = 2131379808;
        RecyclerView r3 = ViewBindings.findChildViewById(r16, 2131379808);
        if (r3 == null) goto L25;
        r17 = 2131379810;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r16, 2131379810);
        if (r4 == null) goto L25;
        r17 = 2131379811;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r16, 2131379811);
        if (r5 == null) goto L25;
        r17 = 2131379812;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r16, 2131379812);
        if (r6 == null) goto L25;
        r17 = 2131379815;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r16, 2131379815);
        if (r7 == null) goto L25;
        r17 = 2131379816;
        View r8 = ViewBindings.findChildViewById(r16, 2131379816);
        if (r8 == null) goto L25;
        r17 = 2131379817;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r16, 2131379817);
        if (r9 == null) goto L25;
        r17 = 2131379818;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131379818);
        if (r10 == null) goto L25;
        r17 = 2131379819;
        ViewPager2 r11 = ViewBindings.findChildViewById(r16, 2131379819);
        if (r11 == null) goto L25;
        LarusFragmentPreviewBinding r18 = new LarusFragmentPreviewBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        this.i = r18;
        return r18.a;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
