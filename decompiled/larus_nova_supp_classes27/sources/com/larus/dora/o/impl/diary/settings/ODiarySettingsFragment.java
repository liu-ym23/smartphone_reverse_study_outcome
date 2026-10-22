package com.larus.dora.o.impl.diary.settings;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.o.impl.databinding.DoraOFragmentDiarySettingsBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J \u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/o/impl/diary/settings/ODiarySettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentDiarySettingsBinding;", "viewModel", "Lcom/larus/dora/o/impl/diary/settings/ODiarySettingsViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/diary/settings/ODiarySettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "photoSwitchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupContentTopInset", "setupRowCards", "onResume", "setupTitleBar", "setupListeners", "observeViewModel", "restoreSwitch", "switchView", "Lcom/obric/oui/oswitch/OSwitch;", "listener", "target", "", "onDestroyView", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiarySettingsFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public DoraOFragmentDiarySettingsBinding d;
    public final Lazy e;
    public final com.larus.dora.o.impl.diary.settings.a f;

    public static final class a {
    }

    static {
    }

    public final ODiarySettingsViewModel S90() {
        return (ODiarySettingsViewModel) this.e.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.o.impl.diary.settings.a] */
    public ODiarySettingsFragment() {
        final Function0<Fragment> r0 = new ODiarySettingsFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ODiarySettingsViewModel.class), new ODiarySettingsFragment$special$$inlined$viewModels$default$2(r0), new ODiarySettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = new com.larus.dora.o.impl.diary.settings.a(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onResume() {
        super.onResume();
        S90().refreshStyleName();
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        DoraOFragmentDiarySettingsBinding r13 = this.d;
        if (r13 == null) goto L12;
        Resources r1 = getResources();
        final int r0 = (int) ((72 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f);
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r13.a);
        if (r2 == null) goto L10;
        Insets r3 = r2.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r3 == null) goto L10;
        int r4 = r3.top;
    L11:
        ScrollView r5 = r13.c;
        r5.setPadding(r5.getPaddingLeft(), r4 + r0, r5.getPaddingRight(), r5.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(r13.c, new c(r0));
    L10:
        Resources r6 = getResources();
        r4 = (int) ((40 * WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density) + 0.5f);
    L12:
        DoraOFragmentDiarySettingsBinding r14 = this.d;
        if (r14 == null) goto L28;
        Iterator r15 = CollectionsKt.listOf(new OCardListItem[]{r14.b, r14.e}).iterator();
    L17:
        if (r15.hasNext() == false) goto L28;
        OCardListItem r7 = (OCardListItem) r15.next();
        ColorStateList r8 = ContextCompat.getColorStateList(r7.getContext(), 2131101350);
        if (r8 != null) goto L21;
        r8 = ColorStateList.valueOf(ContextCompat.getColor(r7.getContext(), 2131101350));
    L21:
        r7.setContentContainerBgColor(r8);
        r7.getContentContainer().setForeground(ContextCompat.getDrawable(r7.getContext(), 2131233947));
        Resources r9 = r7.getResources();
        float r10 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density;
        ViewGroup.LayoutParams r16 = r7.getCardContainer().getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
    L25:
        if (r17 == null) goto L27;
        int r18 = (int) ((12 * r10) + 0.5f);
        r17.setMarginStart(r18);
        r17.setMarginEnd(r18);
        r7.getCardContainer().setLayoutParams(r17);
    L27:
        LinearLayout r20 = r7.getTitleContainer();
        r20.setPaddingRelative((int) ((20 * r10) + 0.5f), r20.getPaddingTop(), r20.getPaddingEnd(), r20.getPaddingBottom());
        OUICardConstraintLayout r21 = r7.getContentContainer();
        int r22 = (int) ((7 * r10) + 0.5f);
        r21.setPaddingRelative(r21.getPaddingStart(), r22, r21.getPaddingEnd(), r22);
        goto L17
    L24:
        r17 = null;
    L28:
        DoraOFragmentDiarySettingsBinding r110 = this.d;
        if (r110 == null) goto L33;
        OFloatingTitleBar r111 = r110.d;
        if (r111 == null) goto L33;
        OFloatingTitleBar.k(r111, new b(this), 2);
        r111.setCenterTitle(getString(2131903405));
    L33:
        final DoraOFragmentDiarySettingsBinding r112 = this.d;
        if (r112 == null) goto L40;
        OSwitch r113 = r112.b.getEndSwitch();
        if (r113 == null) goto L39;
        r113.setOnCheckedChangeListener(this.f);
    L39:
        r112.e.setOnContentClickListener(new d(this));
        r112.b.setOnContentClickListener(new e(r112));
    L40:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiarySettingsFragment$observeViewModel$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiarySettingsFragment$observeViewModel$2(this, null), 3, null);
        S90().loadPhotoEnabled();
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131560145, r8, false);
        int r11 = 2131382244;
        OCardListItem r2 = ViewBindings.findChildViewById(r10, 2131382244);
        if (r2 == null) goto L13;
        r11 = 2131386022;
        ScrollView r3 = (ScrollView) ViewBindings.findChildViewById(r10, 2131386022);
        if (r3 == null) goto L13;
        r11 = 2131386023;
        OFloatingTitleBar r4 = ViewBindings.findChildViewById(r10, 2131386023);
        if (r4 == null) goto L13;
        r11 = 2131387507;
        OCardListItem r5 = ViewBindings.findChildViewById(r10, 2131387507);
        if (r5 == null) goto L13;
        ConstraintLayout r12 = r10;
        this.d = new DoraOFragmentDiarySettingsBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
