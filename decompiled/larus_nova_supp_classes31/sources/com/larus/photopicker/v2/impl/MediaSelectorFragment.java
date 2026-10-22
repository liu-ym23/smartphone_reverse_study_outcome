package com.larus.photopicker.v2.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.databinding.LarusItemTitleHintAllowAlbumPermissionBinding;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.ui.BottomSelectorClickType;
import com.larus.photopicker.v2.impl.ui.MediaFolderSelectorAdapter;
import com.larus.photopicker.v2.impl.ui.MediaListBottomSelectorAdapter;
import com.larus.photopicker.v2.impl.ui.MediaListTabPagerAdapter;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaSelectorViewModel;
import com.larus.platform.model.MediaPickerUIMode;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\u001d\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020*H\u0000¢\u0006\u0002\b/J\r\u00100\u001a\u00020(H\u0000¢\u0006\u0002\b1J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010<\u001a\u00020(H\u0016J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u000203H\u0002J\b\u0010?\u001a\u00020(H\u0002J\u0012\u0010@\u001a\u00020(2\b\b\u0002\u0010A\u001a\u00020BH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/photopicker/v2/impl/MediaSelectorFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TAG", "", "clickArrow", "", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentMediaSelectorBinding;", "viewPagerAdapter", "Lcom/larus/photopicker/v2/impl/ui/MediaListTabPagerAdapter;", "bottomSelectorAdapter", "Lcom/larus/photopicker/v2/impl/ui/MediaListBottomSelectorAdapter;", "bottomSheetViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getBottomSheetViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "bottomSheetViewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "mediaSelectorViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "getMediaSelectorViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "mediaSelectorViewModel$delegate", "mediaStateManager", "Lcom/larus/photopicker/v2/impl/strategy/GenericStateManager;", "Lcom/larus/photopicker/v2/impl/strategy/MediaSelectorState;", "tabSwitchIsFromViewPager", "updateInputFooterHeight", "", "extraHeight", "", "updateInputFooterHeight$impl_mainlandRelease", "adjustScrollForInput", "addedItemUri", "extraPadding", "adjustScrollForInput$impl_mainlandRelease", "scrollToTop", "scrollToTop$impl_mainlandRelease", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDestroyView", "initViews", "contentView", "initViewModel", "clickTitleEntranceArrow", "animDuration", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaSelectorFragment extends Fragment {
    public static final /* synthetic */ int o = 0;
    public final String d;
    public boolean e;
    public LarusFragmentMediaSelectorBinding f;
    public MediaListTabPagerAdapter g;
    public MediaListBottomSelectorAdapter h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final up9.x<up9.i0> m;
    public boolean n;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MediaPickerUIMode.values().length];
            r0[MediaPickerUIMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[BottomSelectorClickType.values().length];
            r1[BottomSelectorClickType.CLICK_ITEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[BottomSelectorClickType.DEL_ITEM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ RecyclerView b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == false) goto L6;
            RecyclerView r3 = this.b;
            Intrinsics.checkNotNull(r3);
            r3.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == true) goto L6;
            RecyclerView r3 = this.b;
            Intrinsics.checkNotNull(r3);
            r3.setVisibility(0);
            return;
        }

        public b(boolean r1, RecyclerView r2) {
            this.a = r1;
            this.b = r2;
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
            final a2 r3 = new a2(r1);
            b2 r4 = new b2(r2);
            return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(r2, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new MediaSelectorFragment$special$$inlined$findViewModel$1$3(r3), r4).getValue();
        }
    }

    public final BottomSheetViewModel T90() {
        return (BottomSheetViewModel) this.i.getValue();
    }

    public final MediaGalleryLiveDataViewModel U90() {
        return (MediaGalleryLiveDataViewModel) this.k.getValue();
    }

    public final MediaSelectorViewModel V90() {
        return (MediaSelectorViewModel) this.l.getValue();
    }

    public MediaSelectorFragment() {
        this.d = "MediaSelectorFragment";
        int r0 = e0.a;
        this.i = LazyKt.lazy(new d(this, c0.class));
        d0 r1 = new d0(this, c0.class);
        this.j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r1), new Injection$provideViewModel$$inlined$viewModels$default$2(r1, this));
        d0 r2 = new d0(this, MediaGalleryFragment.class);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r2), new Injection$provideViewModel$$inlined$viewModels$default$2(r2, this));
        final Function0<Fragment> r3 = new MediaSelectorFragment$special$$inlined$viewModels$default$1(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaSelectorViewModel.class), new MediaSelectorFragment$special$$inlined$viewModels$default$2(r3), new MediaSelectorFragment$special$$inlined$viewModels$default$3(r3, this));
        this.m = new up9.x();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((up9.i0) this.m.a()).onDestroyView();
    }

    public final void S90(long r6) {
        LarusFragmentMediaSelectorBinding r0 = this.f;
        LarusFragmentMediaSelectorBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        ViewPropertyAnimator r2 = r0.k.animate();
        float r4 = 0.0f;
        if (this.e == false) goto L8;
        float r3 = 0.0f;
    L9:
        r2.rotation(r3).setDuration(r6).start();
        boolean r5 = true;
        this.e = !this.e;
        LarusFragmentMediaSelectorBinding r7 = this.f;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        RecyclerView r8 = r1.f;
        Intrinsics.checkNotNull(r8);
        if (r8.getVisibility() == 0) goto L17;
        r5 = false;
    L17:
        if (r5 == false) goto L20;
        r4 = -r8.getMeasuredHeight();
    L20:
        r8.animate().cancel();
        r8.animate().translationY(r4).setDuration(r6).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new b(r5, r8)).start();
        return;
    L12:
        r1 = r7;
        goto L13
    L8:
        r3 = 180.0f;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.larus.photopicker.v2.impl.w1] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.photopicker.v2.impl.u1] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.photopicker.v2.impl.i1, java.lang.Object] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        int r0 = e0.a;
        e0.d(this.d, "onViewCreated");
        super.onViewCreated(r8, r9);
        up9.x<up9.i0> r10 = this.m;
        ?? r11 = new i1(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "initialStateFactory");
        r10.a = (S) r11.invoke();
        up9.i0 r12 = (up9.i0) this.m.a();
        LarusFragmentMediaSelectorBinding r13 = this.f;
        LarusFragmentMediaSelectorBinding r1 = null;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L5:
        r12.f(r13);
        LarusFragmentMediaSelectorBinding r14 = this.f;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L8:
        r14.i.setOnClickListener(new q1(this));
        LarusFragmentMediaSelectorBinding r15 = this.f;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L11:
        r15.l.setOnClickListener(new r1(this));
        LarusFragmentMediaSelectorBinding r16 = this.f;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L14:
        r16.k.setOnClickListener(new s1(this));
        int r17 = 0;
        if (U90().getUiConfig().E == false) goto L23;
        LarusFragmentMediaSelectorBinding r18 = this.f;
        if (r18 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L19:
        r18.n.setVisibility(0);
        LarusFragmentMediaSelectorBinding r19 = this.f;
        if (r19 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L22:
        r19.n.setOnClickListener(new t1(this));
    L23:
        final List<MediaTab> r20 = U90().getUiConfig().a;
        if (U90().canShowTabs() == false) goto L33;
        LarusFragmentMediaSelectorBinding r2 = this.f;
        if (r2 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L28:
        TabLayout r3 = r2.h;
        r3.setVisibility(0);
        Iterator<T> r4 = r20.iterator();
    L30:
        if (r4.hasNext() == false) goto L32;
        MediaTab r5 = (MediaTab) r4.next();
        TabLayout.Tab r6 = r3.newTab();
        r6.setText(r5.getTitle());
        r3.addTab(r6);
        goto L30
    L32:
        r3.addOnTabSelectedListener(new z1(r20, this));
    L33:
        LarusFragmentMediaSelectorBinding r7 = this.f;
        if (r7 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L36:
        RecyclerView r21 = r7.f;
        r21.setNestedScrollingEnabled(false);
        r21.setLayoutManager(new LinearLayoutManager(r21.getContext(), 1, false));
        r21.setAdapter(new MediaFolderSelectorAdapter(new u1(this)));
        this.g = new MediaListTabPagerAdapter(this, r20);
        Iterator<MediaTab> r22 = r20.iterator();
        int r23 = 0;
    L38:
        if (r22.hasNext() == false) goto L46;
        if (r22.next().getId() != U90().getUiConfig().F) goto L42;
        boolean r24 = true;
    L43:
        if (r24 == true) goto L47;
        r23 = r23 + 1;
    L47:
        int r25 = RangesKt.coerceAtLeast(r23, 0);
        LarusFragmentMediaSelectorBinding r26 = this.f;
        if (r26 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L50:
        final ViewPager2 r27 = r26.g;
        RecyclerView.Adapter r28 = this.g;
        if (r28 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
        r28 = null;
    L53:
        r27.setAdapter(r28);
        up9.i0 r29 = (up9.i0) this.m.a();
        Intrinsics.checkNotNull(r27);
        r29.h(r27);
        r27.registerOnPageChangeCallback(new MediaSelectorFragment$initViews$7$1(r20, this));
        if (r27.getCurrentItem() == r25) goto L56;
        r27.setCurrentItem(r25, false);
    L56:
        r27.postDelayed(new v1(r27), U90().getLazyLoadConfig().d);
        LarusFragmentMediaSelectorBinding r30 = this.f;
        if (r30 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L59:
        RecyclerView r31 = r30.d;
        r31.setLayoutManager(new LinearLayoutManager(r31.getContext(), 0, false));
        MediaListBottomSelectorAdapter r32 = new MediaListBottomSelectorAdapter(new w1(this));
        this.h = r32;
        r31.setAdapter(r32);
        LarusFragmentMediaSelectorBinding r33 = this.f;
        if (r33 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L62:
        AppCompatTextView r34 = r33.e;
        Context r35 = requireContext();
        String r36 = U90().getNonUiSettings().e;
        Set r37 = (Set) U90().getSelectionManager().g.getValue();
        if (r37 == null) goto L65;
        r17 = r37.size();
    L65:
        r34.setText(wp9.i.a(r35, r36, r17));
        LarusFragmentMediaSelectorBinding r38 = this.f;
        if (r38 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r38 = null;
    L68:
        r38.e.setOnClickListener(new x1(this));
        BottomSheetViewModel r39 = T90();
        if (r39 == null) goto L75;
        up9.i0 r40 = (up9.i0) this.m.a();
        LifecycleOwner r41 = getViewLifecycleOwner();
        LarusFragmentMediaSelectorBinding r42 = this.f;
        if (r42 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L74:
        r40.g(r41, r1, r39, U90());
        goto L75
    L73:
        r1 = r42;
    L75:
        BottomSheetViewModel r43 = T90();
        if (r43 == null) goto L80;
        MutableLiveData<Boolean> r44 = r43.isOriginalImageChecked();
        if (r44 == null) goto L80;
        r44.observe(getViewLifecycleOwner(), new c(new y1(this)));
    L80:
        V90().getRecyclerViewCanScroll().observe(getViewLifecycleOwner(), new c(new j1(this)));
        U90().getSelectionManager().g.observe(getViewLifecycleOwner(), new c(new k1(this)));
        U90().getCurrentFolder().observe(getViewLifecycleOwner(), new c(new l1(this)));
        U90().getFolders().observe(getViewLifecycleOwner(), new c(new m1(this)));
        U90().getCloseTitleFolder().observe(getViewLifecycleOwner(), new c(new n1(this)));
        U90().getEnterOrExitPreviewPage().observe(getViewLifecycleOwner(), new c(new o1(this)));
        return;
    L42:
        r24 = false;
        goto L43
    L46:
        r23 = -1;
        goto L47
    }

    public final View onCreateView(LayoutInflater r20, ViewGroup r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r20, "inflater");
        CoordinatorLayout r0 = r20.inflate(2131562403, r21, false);
        int r1 = 2131363085;
        AppBarLayout r5 = ViewBindings.findChildViewById(r0, 2131363085);
        if (r5 == null) goto L35;
        r1 = 2131379797;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131379797);
        if (r6 == null) goto L35;
        r1 = 2131379798;
        RecyclerView r7 = ViewBindings.findChildViewById(r0, 2131379798);
        if (r7 == null) goto L35;
        r1 = 2131379799;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r0, 2131379799);
        if (r8 == null) goto L35;
        r1 = 2131379801;
        RecyclerView r9 = ViewBindings.findChildViewById(r0, 2131379801);
        if (r9 == null) goto L35;
        r1 = 2131379756;
        ViewPager2 r10 = ViewBindings.findChildViewById(r0, 2131379756);
        if (r10 == null) goto L35;
        r1 = 2131387992;
        TabLayout r11 = ViewBindings.findChildViewById(r0, 2131387992);
        if (r11 == null) goto L35;
        r1 = 2131388840;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131388840);
        if (r12 == null) goto L35;
        r1 = 2131388843;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131388843);
        if (r13 == null) goto L35;
        r1 = 2131388862;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r0, 2131388862);
        if (r14 == null) goto L35;
        r1 = 2131388866;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131388866);
        if (r15 == null) goto L35;
        r1 = 2131388870;
        View r2 = ViewBindings.findChildViewById(r0, 2131388870);
        if (r2 == null) goto L35;
        LarusItemTitleHintAllowAlbumPermissionBinding r3 = new LarusItemTitleHintAllowAlbumPermissionBinding((TextView) r2);
        int r4 = 2131388881;
        if (ViewBindings.findChildViewById(r0, 2131388881) == null) goto L37;
        r4 = 2131388887;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131388887);
        if (r17 == null) goto L37;
        r4 = 2131388888;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r0, 2131388888);
        if (r18 == null) goto L37;
        CoordinatorLayout r16 = r0;
        this.f = new LarusFragmentMediaSelectorBinding(r16, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r17, r18);
        return r16;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r4)));
    L35:
        r4 = r1;
        goto L37
    }
}
