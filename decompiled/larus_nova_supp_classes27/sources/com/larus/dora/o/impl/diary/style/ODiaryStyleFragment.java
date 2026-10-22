package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.o.impl.databinding.DoraOFragmentDiaryStyleBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010&H\u0002J,\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190.2\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0018\u00100\u001a\u00020\u00192\u0006\u0010+\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u00020\u0019H\u0002J\b\u00108\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/dora/o/impl/diary/style/ODiaryStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentDiaryStyleBinding;", "viewModel", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleAdapter;", "hasRenderedContent", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupContentTopInset", "setupTitleBar", "setupList", "setupPinnedAddRow", "onAddStyleClick", "observeViewModel", "renderListState", "state", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$ListState;", "selectStyle", "item", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$StyleUiItem;", "showDeleteConfirmDialog", "showInputDialog", "editItem", "handleSaveResult", "result", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$OpResult;", "onDone", "Lkotlin/Function1;", "scrollToBottomOnSuccess", "toastOpFailure", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$OpResult$Failed;", "defaultResId", "", "resolveStyleName", "", "rawName", "scrollListToBottom", "onDestroyView", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryStyleFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public DoraOFragmentDiaryStyleBinding d;
    public final Lazy e;
    public ODiaryStyleAdapter f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public final ODiaryStyleViewModel S90() {
        return (ODiaryStyleViewModel) this.e.getValue();
    }

    public ODiaryStyleFragment() {
        final Function0<Fragment> r0 = new ODiaryStyleFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ODiaryStyleViewModel.class), new ODiaryStyleFragment$special$$inlined$viewModels$default$2(r0), new ODiaryStyleFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f = null;
        this.d = null;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.dora.o.impl.diary.style.v, java.lang.Object] */
    public final void U90(final ODiaryStyleViewModel.d r8) {
        if (r8 == null) goto L4;
        boolean r0 = true;
    L5:
        Context r2 = getContext();
        if (r2 != null) goto L8;
        return;
    L8:
        int r1 = b0.e;
        if (r0 == false) goto L11;
        int r3 = 2131903420;
    L12:
        String r4 = null;
        if (r8 == null) goto L15;
        String r5 = r8.b;
    L17:
        if (r5 != null) goto L19;
        String r6 = "";
    L20:
        if (r8 == null) goto L22;
        r4 = r8.c;
    L22:
        if (r4 != null) goto L24;
        r4 = "";
    L24:
        ?? r7 = new v(this, r8);
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "initialName");
        Intrinsics.checkNotNullParameter(r4, "initialPrompt");
        Intrinsics.checkNotNullParameter(r7, "onSave");
        OSheet r9 = new b0(r2, r3, r6, r4, r7).b;
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L28:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        return;
    L19:
        r6 = r5;
        goto L20
    L15:
        r5 = null;
        goto L17
    L11:
        r3 = 2131903419;
        goto L12
    L4:
        r0 = false;
        goto L5
    }

    public final void V90(ODiaryStyleViewModel.c.a r3, int r4) {
        String r5 = r3.a;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        t19.s r6 = t19.s.a;
        Context r2 = getContext();
        r6.getClass();
        t19.s.b(r2, r4, false);
        return;
    L11:
        t19.s r7 = t19.s.a;
        Context r0 = getContext();
        r7.getClass();
        t19.s.c(r0, r5);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.o.impl.diary.style.o] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.dora.o.impl.diary.style.p] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.dora.o.impl.diary.style.q] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        DoraOFragmentDiaryStyleBinding r10 = this.d;
        if (r10 == null) goto L12;
        Resources r1 = getResources();
        final int r0 = (int) ((72 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f);
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r10.a);
        if (r2 == null) goto L10;
        Insets r3 = r2.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r3 == null) goto L10;
        int r4 = r3.top;
    L11:
        RecyclerView r5 = r10.d;
        r5.setPadding(r5.getPaddingLeft(), r4 + r0, r5.getPaddingRight(), r5.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(r10.d, new s(r0));
    L10:
        Resources r6 = getResources();
        r4 = (int) ((40 * WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density) + 0.5f);
    L12:
        DoraOFragmentDiaryStyleBinding r11 = this.d;
        if (r11 == null) goto L17;
        OFloatingTitleBar r12 = r11.f;
        if (r12 == null) goto L17;
        r12.setCenterTitle(getString(2131903869));
        OFloatingTitleBar.k(r12, new n(this), 2);
    L17:
        ODiaryStyleAdapter r13 = new ODiaryStyleAdapter(new o(this), new p(this), new q(this));
        this.f = r13;
        DoraOFragmentDiaryStyleBinding r7 = this.d;
        if (r7 == null) goto L22;
        final RecyclerView r14 = r7.d;
        if (r14 == null) goto L22;
        r14.setLayoutManager(new LinearLayoutManager(r14.getContext()));
        r14.setAdapter(r13);
        r14.addItemDecoration(new ODiaryStyleFragment$setupList$1$1(r14));
    L22:
        DoraOFragmentDiaryStyleBinding r15 = this.d;
        if (r15 == null) goto L27;
        TextView r16 = r15.c;
        if (r16 == null) goto L27;
        r16.setOnClickListener(new r(this));
    L27:
        DoraOFragmentDiaryStyleBinding r17 = this.d;
        if (r17 == null) goto L39;
        OCardListItem r18 = r17.b;
        if (r18 == null) goto L39;
        ColorStateList r20 = ContextCompat.getColorStateList(r18.getContext(), 2131101350);
        if (r20 != null) goto L35;
        r20 = ColorStateList.valueOf(ContextCompat.getColor(r18.getContext(), 2131101350));
    L35:
        r18.setContentContainerBgColor(r20);
        r18.getContentContainer().setForeground(ContextCompat.getDrawable(r18.getContext(), 2131233947));
        u69.b.a(r18, null);
        r18.setEnableSwipe(false);
        r18.s(false);
        r18.i(2131560166, true);
        TextView r21 = (TextView) r18.getTitleContainer().findViewById(2131387498);
        if (r21 == null) goto L38;
        r21.setText(getString(2131903415));
    L38:
        OUICardConstraintLayout r22 = r18.getContentContainer();
        Resources r23 = getResources();
        r22.setMinimumHeight((int) ((WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()).density * 64) + 0.5f));
        r18.setOnContentClickListener(new t(this));
        Resources r24 = getResources();
        final int r25 = (int) ((16 * WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics()).density) + 0.5f);
        ViewCompat.setOnApplyWindowInsetsListener(r18, new u(r25));
    L39:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiaryStyleFragment$observeViewModel$1(this, null), 3, null);
        S90().loadStyles();
    }

    public final void T90(ODiaryStyleViewModel.c r2, Function1<? super Boolean, Unit> r3, boolean r4) {
        if ((r2 instanceof ODiaryStyleViewModel.c.b) == false) goto L13;
        r3.invoke(Boolean.TRUE);
        if (r4 == false) goto L18;
        DoraOFragmentDiaryStyleBinding r5 = this.d;
        if (r5 == null) goto L19;
        final RecyclerView r6 = r5.d;
        if (r6 == null) goto L21;
        r6.post(new m(this, r6));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    L13:
        if ((r2 instanceof ODiaryStyleViewModel.c.a) == false) goto L17;
        V90((ODiaryStyleViewModel.c.a) r2, 2131903427);
        r3.invoke(Boolean.FALSE);
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131560146, r9, false);
        int r12 = 2131387497;
        OCardListItem r2 = ViewBindings.findChildViewById(r11, 2131387497);
        if (r2 == null) goto L15;
        r12 = 2131387500;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131387500);
        if (r3 == null) goto L15;
        r12 = 2131387502;
        RecyclerView r4 = ViewBindings.findChildViewById(r11, 2131387502);
        if (r4 == null) goto L15;
        r12 = 2131387503;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131387503);
        if (r5 == null) goto L15;
        r12 = 2131387511;
        OFloatingTitleBar r6 = ViewBindings.findChildViewById(r11, 2131387511);
        if (r6 == null) goto L15;
        ConstraintLayout r13 = r11;
        this.d = new DoraOFragmentDiaryStyleBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
