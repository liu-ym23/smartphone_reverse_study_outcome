package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020$H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/TransparentSelectorComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "<init>", "()V", "creationInputAbility", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "getCreationInputAbility", "()Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "creationInputAbility$delegate", "Lkotlin/Lazy;", "creationFragmentAbility", "Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "getCreationFragmentAbility", "()Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "creationFragmentAbility$delegate", "rootBinding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentCreationPageBinding;", "getRootBinding", "()Lcom/larus/uaigc/impl/databinding/LarusFragmentCreationPageBinding;", "rootBinding$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "feedMaskView", "Landroid/view/View;", "statusBarMask", "onViewCreated", "", "view", "onDestroy", "removeTemplateFeedMask", "addMaskToTemplateFeed", "showVisualMask", "", "observeImeChange", "updateImeMask", "isImeShown", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TransparentSelectorComponent extends BaseContentWidget {
    public static final /* synthetic */ int s = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public View q;
    public View r;

    public final void h3() {
        View r0 = this.q;
        if (r0 == null) goto L12;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L7;
        ViewGroup r2 = (ViewGroup) r1;
    L8:
        if (r2 == null) goto L10;
        r2.removeView(r0);
    L10:
        this.q = null;
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroy() {
        com.larus.uaigc.createpage.v r0 = (com.larus.uaigc.createpage.v) this.n.getValue();
        if (r0 == null) goto L5;
        r0.UV(false);
    L5:
        h3();
    }

    public TransparentSelectorComponent() {
        this.m = LazyKt.lazy(new z4(this));
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.n = LazyKt.lazy(r0, new a5(this));
        this.o = LazyKt.lazy(r0, new b5(this));
        this.p = LazyKt.lazy(new c5(this));
    }

    public final void onViewCreated(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        View r10 = new View(getContext());
        r10.setBackgroundColor(0);
        F2().setBackgroundColor(0);
        F2().setClickable(false);
        View r0 = F2();
        View r2 = null;
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 == null) goto L8;
        r1.addView(r10, -1, -1);
    L8:
        com.larus.utils.i0.a.getClass();
        int r11 = com.larus.utils.i0.g();
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r3 == null) goto L17;
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131388347);
        if (r4 == null) goto L17;
        com.larus.utils.e1.x(r4);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L16;
        r5.height = r11;
        r4.setLayoutParams(r5);
        com.larus.utils.e1.d(r4, new y4(this));
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r6 == null) goto L26;
        View r7 = r6.findViewById(2131388349);
        if (r7 == null) goto L26;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L25;
        r8.height = r11;
        r7.setLayoutParams(r8);
        r7.setBackgroundColor(ContextCompat.getColor(r7.getContext(), v19.c.b(2130970529, r7.getContext(), 2131102529)));
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L26:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r12 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r12 == null) goto L35;
        View r13 = r12.findViewById(2131388348);
        if (r13 == null) goto L35;
        com.larus.utils.e1.o(r13);
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L34;
        r14.height = r11;
        r13.setLayoutParams(r14);
        r13.setBackgroundColor(ContextCompat.getColor(r13.getContext(), 2131103293));
        r2 = r13;
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L35:
        this.r = r2;
        py9.a r15 = (py9.a) this.m.getValue();
        if (r15 == null) goto L39;
        r15.Tf(new e5(this));
        return;
    L39:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void Y2(final TransparentSelectorComponent r6, boolean r7) {
        com.larus.uaigc.createpage.v r0 = (com.larus.uaigc.createpage.v) r6.n.getValue();
        if (r0 == null) goto L5;
        r0.UV(r7);
    L5:
        com.larus.uaigc.createpage.v r1 = (com.larus.uaigc.createpage.v) r6.n.getValue();
        int r2 = 0;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        com.larus.uaigc.createpage.v r4 = (com.larus.uaigc.createpage.v) r6.n.getValue();
        if (r4 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        boolean r8 = true ^ r5;
        if (r7 == false) goto L39;
        r6.h3();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        View r9 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6).getView();
        if (r9 == null) goto L28;
        ViewGroup r10 = (ViewGroup) r9.findViewById(2131388328);
        if (r10 == null) goto L28;
        View r11 = new View(r6.getContext());
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (r8 == false) goto L27;
        r2 = ContextCompat.getColor(r11.getContext(), 2131103293);
    L27:
        r11.setBackgroundColor(r2);
        r6.q = r11;
        com.larus.utils.e1.d(r11, new d5(r6));
        r10.addView(r6.q);
    L28:
        if (r3 == false) goto L32;
        View r12 = r6.r;
        if (r12 == null) goto L43;
        com.larus.utils.e1.o(r12);
        return;
    L43:
        return;
    L32:
        if (r8 == false) goto L36;
        View r13 = r6.r;
        if (r13 == null) goto L45;
        com.larus.utils.e1.x(r13);
        return;
    L45:
        return;
    L36:
        View r14 = r6.r;
        if (r14 == null) goto L47;
        com.larus.utils.e1.o(r14);
        return;
    L47:
        return;
    L39:
        r6.h3();
        View r15 = r6.r;
        if (r15 == null) goto L49;
        com.larus.utils.e1.o(r15);
        return;
    L49:
        return;
    L14:
        if (r4.VV() == true) goto L16;
        r5 = true;
        goto L17
    L8:
        if (r1.IA() != true) goto L10;
        r3 = true;
        goto L11
    }
}
