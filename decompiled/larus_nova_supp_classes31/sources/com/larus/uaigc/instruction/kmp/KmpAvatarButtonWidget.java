package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.instruction.AvatarTemplateWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import cq8.a0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpAvatarButtonWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "legacyController", "Lcom/larus/uaigc/instruction/AvatarTemplateController;", "boundTemplate", "", "pendingBind", "Lkotlin/Pair;", "Lcom/larus/bmhome/instruction/core/model/widget/AvatarButtonDescriptor;", "init", "", "bindInstructionViewModel", "viewModel", "onDescriptorChanged", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onAttachedToWindow", "resolveFragment", "Landroidx/fragment/app/Fragment;", "bindLegacy", "d", "template", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpAvatarButtonWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b {
    public com.larus.bmhome.view.actionbar.edit.c f;
    public com.larus.uaigc.instruction.a g;
    public String h;
    public Pair<cq8.a, String> i;

    public static final class a {
    }

    static {
    }

    public KmpAvatarButtonWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpAvatarButtonWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        Pair<cq8.a, String> r0 = this.i;
        if (r0 == null) goto L6;
        cq8.a r1 = (cq8.a) r0.component1();
        String r2 = (String) r0.component2();
        this.i = null;
        V5(r1, r2);
        return;
    }

    public final void L4(com.larus.bmhome.view.actionbar.edit.c r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        if ((r3 instanceof cq8.a) == true) goto L5;
        r3 = null;
    L5:
        cq8.a r4 = (cq8.a) r3;
        if (r4 == null) goto L29;
        String r0 = r4.f;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        FLogger.a.w("KmpAvatarButtonWidget", "[onDescriptorChanged] empty template, skip");
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
        this.i = TuplesKt.to(r4, r0);
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(cq8.a r8, String r9) {
        removeAllViews();
        com.larus.uaigc.instruction.a r6 = new com.larus.uaigc.instruction.a();
        ((up8.b) r6).g = r8.g;
        wa8.a0 r0 = r6.r(r9, this.f, null, null, null);
        if (Intrinsics.areEqual(r0.a, Boolean.TRUE) == true) goto L6;
        FLogger.a.e("KmpAvatarButtonWidget", "[bindLegacy] legacy setUp failed: " + r0.b);
        return;
    L6:
        this.g = r6;
        this.h = r9;
        Fragment r10 = getFragment();
        LifecycleCoroutineScope r1 = null;
        if (r10 == null) goto L30;
    L16:
        AbsInstructionWidget r2 = new AvatarTemplateWidget(getContext());
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
        addView(r2);
        r2.T5(r6);
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[bindLegacy] bound, parentType=");
        r5.append(r8.g);
        r5.append(", hasFragment=");
        if (r10 == null) goto L27;
        boolean r11 = true;
    L28:
        r5.append(r11);
        r4.i("KmpAvatarButtonWidget", r5.toString());
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

    public KmpAvatarButtonWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KmpAvatarButtonWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
