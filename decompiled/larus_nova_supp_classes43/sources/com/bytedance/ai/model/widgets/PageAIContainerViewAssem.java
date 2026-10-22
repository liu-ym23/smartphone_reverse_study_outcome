package com.bytedance.ai.model.widgets;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.model.viewmodel.AIPrivateViewModel;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.assem.arch.core.AssemSupervisor;
import com.bytedance.assem.arch.core.Assembler;
import com.bytedance.assem.arch.core.UIAssem;
import com.bytedance.assem.arch.extensions.AssemExtKt;
import com.bytedance.assem.arch.extensions.AssembleExtKt;
import com.bytedance.assem.arch.extensions.VMExtKt;
import com.bytedance.assem.arch.view.UIContentAssem;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/bytedance/ai/model/widgets/PageAIContainerViewAssem;", "Lcom/bytedance/assem/arch/view/UIContentAssem;", "Lcom/bytedance/ai/api/model/view/IAIContainerViewService;", "<init>", "()V", "mRenderData", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "getMRenderData", "()Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "mRenderData$delegate", "Lcom/bytedance/assem/arch/extensions/HierarchyLazy;", "mAIPrivateViewModel", "Lcom/bytedance/ai/model/viewmodel/AIPrivateViewModel;", "getMAIPrivateViewModel", "()Lcom/bytedance/ai/model/viewmodel/AIPrivateViewModel;", "mAIPrivateViewModel$delegate", "Lcom/bytedance/assem/arch/viewModel/AssemVMLazy;", "mRenderView", "Lcom/bytedance/ai/api/model/view/IAIRenderEngineService;", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onViewCreated", "", "view", "Landroid/view/View;", "getViewModel", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "isShared", "", "groupId", "", "getRenderEngine", "onResume", "onPause", "onDestroy", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageAIContainerViewAssem extends UIContentAssem implements k2.m {
    public static final /* synthetic */ int n = 0;
    public final com.bytedance.assem.arch.extensions.f j;
    public final com.bytedance.assem.arch.viewModel.b k;
    public k2.q l;
    public WeakReference<LifecycleOwner> m;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void f() {
    }

    public final void onDestroy() {
        com.bytedance.ai.utils.g.a.i("PageWebViewRenderAssem", "onDestroy");
        k2.b r0 = (k2.b) this.j.getValue();
        if (r0 == null) goto L8;
        k2.j r1 = r0.n;
        if (r1 == null) goto L9;
        r1.onDestroy();
        return;
    L9:
        return;
    }

    public final void onPause() {
        com.bytedance.ai.utils.g.a.i("PageWebViewRenderAssem", "onPause");
        k2.b r0 = (k2.b) this.j.getValue();
        if (r0 == null) goto L8;
        k2.j r1 = r0.n;
        if (r1 == null) goto L9;
        r1.onHide();
        return;
    L9:
        return;
    }

    public final void onResume() {
        com.bytedance.ai.utils.g.a.i("PageWebViewRenderAssem", "onResume");
        k2.b r0 = (k2.b) this.j.getValue();
        if (r0 == null) goto L8;
        k2.j r1 = r0.n;
        if (r1 == null) goto L9;
        r1.onShow();
        return;
    L9:
        return;
    }

    public PageAIContainerViewAssem() {
        if (((Assem) this).d == null) goto L5;
        boolean r1 = true;
    L6:
        this.j = new com.bytedance.assem.arch.extensions.f(r1, com.bytedance.assem.arch.extensions.d.a(this, k2.b.class));
        final KClass r10 = Reflection.getOrCreateKotlinClass(AIPrivateViewModel.class);
        Function0<String> r11 = new PageAIContainerViewAssem$special$$inlined$assemViewModel$default$1(r10);
        PageAIContainerViewAssem$special$$inlined$assemViewModel$default$2 r12 = PageAIContainerViewAssem$special$$inlined$assemViewModel$default$2.INSTANCE;
        this.k = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.m(this), VMExtKt.o(this), VMExtKt.g(this), r12, VMExtKt.j(this), VMExtKt.k(this));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final Lifecycle getLifecycle() {
        return ((Assem) this).c;
    }

    @Override // k2.m
    public final k2.q h() {
        return this.l;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.model.widgets.c0] */
    public final void r(final View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.m = new WeakReference(AssemExtKt.a(this));
        ?? r0 = new c0(this, r10);
        FragmentActivity r11 = AssemExtKt.a(this);
        if (r11 == null) goto L21;
        Assembler r1 = ViewModelProviders.of(r11).get(Assembler.class);
        com.bytedance.assem.arch.core.b r12 = r1.findAssemDataNode(this);
        if (r12 != null) goto L7;
        com.bytedance.assem.arch.core.b r13 = new com.bytedance.assem.arch.core.b(r1.findAssemDataNode(j().g));
        r1.setAssemDataNode(this, r13);
        r12 = r13;
    L7:
        com.bytedance.assem.arch.core.d r14 = r1.findAssemServiceStore(this);
        if (r14 != null) goto L12;
        com.bytedance.assem.arch.core.d r15 = new com.bytedance.assem.arch.core.d(r1.findAssemServiceStore(j().g));
        r1.setAssemServiceStore(this, r15);
        r14 = r15;
    L12:
        if (r1.findAssemSupervisor(this) != null) goto L20;
        AssemSupervisor r16 = new AssemSupervisor(this, r11, r12, r14);
        View r17 = ((UIAssem) this).h;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L16:
        if (r17 == null) goto L19;
        r16.f(r17);
        r1.setAssemSupervisor(this, r16);
        ((Assem) this).c.addObserver(new AssembleExtKt.assemble.3(this, r1));
        goto L20
    L19:
        throw new IllegalArgumentException("The UIAssem's root view is null, check if it has no layout or the assemble called before UIAssem#onViewCreated}.".toString());
    L20:
        r0.invoke(r1);
    L21:
        com.bytedance.ai.utils.g.a.i("PageWebViewRenderAssem", "onViewCreated");
    }

    @Override // k2.m
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        if (r10 == false) goto L11;
        WeakReference<LifecycleOwner> r12 = this.m;
        if (r12 == null) goto L9;
        LifecycleOwner r13 = r12.get();
        if (r13 == null) goto L9;
        return SharedViewModelExtKt.b(r13, r11);
    L9:
        return null;
    L11:
        return ((AIPrivateViewModel) this.k.getValue()).getIAIViewModel(r11);
    }
}
