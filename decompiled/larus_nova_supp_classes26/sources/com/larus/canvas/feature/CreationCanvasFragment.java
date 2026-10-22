package com.larus.canvas.feature;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.canvas.feature.component.title.widget.CanvasTitleView;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.impl.databinding.LarusFragmentCreationCanvasBinding;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.v;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import my8.q;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020\u0017J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0017H\u0002J\b\u00107\u001a\u00020\u0017H\u0002J\f\u00108\u001a\u00020\u0017*\u00020\u001eH\u0002J\f\u00109\u001a\u00020\u0017*\u00020:H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006;"}, d2 = {"Lcom/larus/canvas/feature/CreationCanvasFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "<init>", "()V", "binding", "Lcom/larus/canvas/impl/databinding/LarusFragmentCreationCanvasBinding;", "inputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "canvasArgumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "hasHostBackHandlingEntry", "", "_uiActionFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/canvas/feature/ability/CanvasContainerUIAction;", "uiActionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiActionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "", "onBackPressed", "ensureBackPressedCallback", "shouldHandleCanvasBackPressed", "ensureRootSystemBackHandling", "onResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "bindToVContext", "attachComponent", "initStatusBarArea", "adaptHostBottomPadding", "applyCanvasBackground", "addChatSpeakerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationCanvasFragment extends TraceFragment implements fy8.b {
    public static final /* synthetic */ int k = 0;
    public LarusFragmentCreationCanvasBinding e;
    public q f;
    public FragmentExtKt.addOnBackPressed.callback.1 g;
    public boolean h;
    public final MutableSharedFlow<fy8.c> i;
    public final a1 j;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "creation_canvas";
    }

    public CreationCanvasFragment() {
        MutableSharedFlow<fy8.c> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.i = r0;
        this.j = kotlinx.coroutines.flow.e.a(r0);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.g;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        this.g = null;
        this.e = null;
    }

    public final void onResume() {
        super.onResume();
        if (this.g != null) goto L6;
        this.g = v.a(this, new i(this));
    L6:
        int r0 = CanvasHostUiPolicy.c;
        CanvasHostUiPolicy r1 = CanvasHostUiPolicy.a.a(this.f);
        if (r1.a == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        if (this.h == true) goto L22;
        FragmentManager r3 = getParentFragmentManager();
        if (r3.getBackStackEntryCount() > 1) goto L23;
        r3.beginTransaction().addToBackStack(null).commitAllowingStateLoss();
        this.h = true;
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if (r1.b == false) goto L11;
        r2 = true;
        goto L12
    }

    @Override // fy8.b
    public final a1 U4() {
        return this.j;
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        t1a.b r4 = s1a.a.g(this);
        de8.c r0 = de8.c.s;
        r4.n(de8.c.a.a(getArguments()), de8.c.class);
        q r5 = new q(getArguments());
        s1a.a.g(this).n(r5, q.class);
        this.f = r5;
        s1a.a.g(this).c(this, fy8.b.class);
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new f(this));
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        int r6 = CanvasHostUiPolicy.c;
        CanvasHostUiPolicy r7 = CanvasHostUiPolicy.a.a(this.f);
        LarusFragmentCreationCanvasBinding r8 = this.e;
        if (r8 == null) goto L11;
        View r9 = r8.i;
        if (r9 == null) goto L11;
        ViewGroup.LayoutParams r1 = r9.getLayoutParams();
        if (r1 == null) goto L10;
        i0.a.getClass();
        r1.height = i0.g();
        r9.setLayoutParams(r1);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        LarusFragmentCreationCanvasBinding r10 = this.e;
        if (r10 == null) goto L23;
        ConstraintLayout r11 = r10.j;
        if (r11 == null) goto L23;
        ViewGroup.LayoutParams r2 = r11.getLayoutParams();
        if (r2 == null) goto L22;
        int r0 = i5.k0();
        int r3 = i5.c0();
        if (r7.a == false) goto L20;
        r0 = r3;
    L20:
        r2.height = r0;
        r11.setLayoutParams(r2);
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L23:
        LarusFragmentCreationCanvasBinding r12 = this.e;
        if (r12 == null) goto L30;
        final ChatConstraintLayout r13 = r12.h;
        if (r13 == null) goto L31;
        final CanvasHostUiPolicy r14 = CanvasHostUiPolicy.a.a(this.f);
        final int r15 = c7.b(16);
        final Function2 r16 = r13.getInterruptBottomPaddingUpdate();
        r13.setInterruptBottomPaddingUpdate(new g(r13, r15, r14, r16));
        r13.post(new h(r13, r15, r14));
        return;
    L31:
        return;
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        ChatConstraintLayout r1 = r18.inflate(2131562371, r19, false);
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131365537);
        if (r7 == null) goto L43;
        ViewStub r8 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375364);
        if (r8 == null) goto L42;
        View r9 = ViewBindings.findChildViewById(r1, 2131375421);
        if (r9 == null) goto L41;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131375451);
        if (r10 == null) goto L40;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131375452);
        if (r11 == null) goto L39;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131384447);
        if (r12 == null) goto L38;
        ChatConstraintLayout r15 = r1;
        View r14 = ViewBindings.findChildViewById(r1, 2131387283);
        if (r14 == null) goto L37;
        CanvasTitleView r16 = (CanvasTitleView) ViewBindings.findChildViewById(r1, 2131388772);
        if (r16 == null) goto L36;
        this.e = new LarusFragmentCreationCanvasBinding(r15, r7, r8, r9, r10, r11, r12, r15, r14, r16);
        if (r15 == null) goto L21;
        r15.setBackgroundColor(ContextCompat.getColor(r15.getContext(), v19.c.b(2130970531, r15.getContext(), 2131102535)));
    L21:
        LarusFragmentCreationCanvasBinding r2 = this.e;
        if (r2 == null) goto L26;
        ViewStub r3 = r2.c;
        if (r3 == null) goto L26;
        InputViewCreatorDelegate.b.a(r3, 2131375364);
    L26:
        LarusFragmentCreationCanvasBinding r4 = this.e;
        if (r4 == null) goto L31;
        ChatConstraintLayout r5 = r4.h;
        if (r5 == null) goto L31;
        View r6 = IAIChatUgcAIGCService.a.K(r5.getContext());
        r6.setId(2131387057);
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r13).bottomMargin = i5.h();
        r6.setLayoutParams(r13);
        e1.o(r6);
        r5.addView(r6);
        ConstraintSet r17 = new ConstraintSet();
        r17.clone(r5);
        r17.connect(2131387057, 4, 2131365537, 4);
        r17.applyTo(r5);
    L31:
        LarusFragmentCreationCanvasBinding r21 = this.e;
        if (r21 != null) goto L46;
        return null;
    L46:
        return r21.h;
    L36:
        int r22 = 2131388772;
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r22)));
    L37:
        r22 = 2131387283;
        goto L45
    L38:
        r22 = 2131384447;
        goto L45
    L39:
        r22 = 2131375452;
        goto L45
    L40:
        r22 = 2131375451;
        goto L45
    L41:
        r22 = 2131375421;
        goto L45
    L42:
        r22 = 2131375364;
        goto L45
    L43:
        r22 = 2131365537;
        goto L45
    }
}
