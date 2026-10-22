package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bt8.j;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.component.CollaboratedMultiFeatureSelectorWidget;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.f;
import cq8.g;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import xs8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpCollaboratedMultiFeatureSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "legacyController", "Lcom/larus/bmhome/view/actionbar/edit/controller/CollaboratedMultiFeatureSelectorController;", "legacyWidget", "Lcom/larus/bmhome/view/actionbar/edit/component/CollaboratedMultiFeatureSelectorWidget;", "boundTemplate", "", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/CollaboratedMultiFeatureSelectorDescriptor;", "pendingBind", "Lkotlin/Pair;", "init", "", "bindInstructionViewModel", "viewModel", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onAttachedToWindow", "resolveFragment", "Landroidx/fragment/app/Fragment;", "bindLegacy", "d", "template", "syncToCore", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCollaboratedMultiFeatureSelectorWidget extends AbsKmpInstructionWidget implements b {
    public static final /* synthetic */ int k = 0;
    public c f;
    public d g;
    public String h;
    public f i;
    public Pair<f, String> j;

    public static final class a {
    }

    static {
    }

    public KmpCollaboratedMultiFeatureSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpCollaboratedMultiFeatureSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final void Y5() {
        f r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        d r1 = this.g;
        if (r1 != null) goto L8;
        return;
    L8:
        r0.d.a(new g(r0.c, r1.g(), r1.a()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        Pair<f, String> r0 = this.j;
        if (r0 == null) goto L6;
        f r1 = (f) r0.component1();
        String r2 = (String) r0.component2();
        this.j = null;
        V5(r1, r2);
        return;
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(c r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        if ((r3 instanceof f) == true) goto L5;
        r3 = null;
    L5:
        f r4 = (f) r3;
        if (r4 == null) goto L29;
        this.i = r4;
        String r0 = r4.f;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        FLogger.a.w("KmpCollaboratedMultiFeatureSelectorWidget", "[onDescriptorChanged] empty template, skip");
        return;
    L18:
        if (this.g == null) goto L22;
        if (Intrinsics.areEqual(r0, this.h) == false) goto L22;
        return;
    L22:
        if (isAttachedToWindow() == false) goto L24;
        V5(r4, r0);
        return;
    L24:
        this.j = TuplesKt.to(r4, r0);
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View, com.larus.bmhome.instruction.base.AbsInstructionWidget, com.larus.bmhome.view.actionbar.edit.component.CollaboratedMultiFeatureSelectorWidget] */
    public final void V5(f r8, String r9) {
        removeAllViews();
        d r6 = new d();
        r6.g = r8.g;
        wa8.a0 r0 = r6.r(r9, this.f, null, null, null);
        if (Intrinsics.areEqual(r0.a, Boolean.TRUE) == true) goto L6;
        FLogger.a.e("KmpCollaboratedMultiFeatureSelectorWidget", "[bindLegacy] legacy setUp failed: " + r0.b);
        return;
    L6:
        this.g = r6;
        this.h = r9;
        Fragment r10 = getFragment();
        LifecycleCoroutineScope r1 = null;
        if (r10 == null) goto L30;
    L16:
        ?? r2 = new CollaboratedMultiFeatureSelectorWidget(getContext());
        if (r10 == null) goto L21;
        LifecycleOwner r3 = r10.getViewLifecycleOwner();
        if (r3 == null) goto L21;
        r1 = LifecycleOwnerKt.getLifecycleScope(r3);
    L21:
        r2.setComponentScope(r1);
        if (r10 == null) goto L24;
        Intrinsics.checkNotNullParameter(r10, "fragment");
        r2.a = r10;
    L24:
        r2.setOnDataChanged(new j(this));
        addView(r2);
        r2.T5(r6);
        Y5();
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[bindLegacy] bound, parentType=");
        r5.append(r8.g);
        r5.append(", hasFragment=");
        if (r10 == null) goto L27;
        boolean r11 = true;
    L28:
        r5.append(r11);
        r4.i("KmpCollaboratedMultiFeatureSelectorWidget", r5.toString());
        return;
    L27:
        r11 = false;
        goto L28
    L30:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L10
        Object r13 = Result.constructor-impl(FragmentManager.findFragment(this));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r13) == false) goto L15;
        r13 = null;
    L15:
        r10 = (Fragment) r13;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public KmpCollaboratedMultiFeatureSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KmpCollaboratedMultiFeatureSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
