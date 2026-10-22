package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutMenuAdaptSideBarBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010#\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010$\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J\u0016\u0010'\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J \u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J\u0016\u0010+\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J \u0010,\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J\u0016\u0010-\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J\u0016\u0010.\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J\u0016\u0010/\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016J&\u00100\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\u0016\u00101\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/ConversationListMenuAdaptSideBar;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/larus/bmhome/view/screenmenu/IConversationListMenu;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuBinding", "Lcom/larus/bmhome/databinding/LarusLayoutMenuAdaptSideBarBinding;", "onForkClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnForkClick", "()Lkotlin/jvm/functions/Function1;", "setOnForkClick", "(Lkotlin/jvm/functions/Function1;)V", "hideActionTitleOverride", "", "getHideActionTitleOverride", "()Ljava/lang/CharSequence;", "setHideActionTitleOverride", "(Ljava/lang/CharSequence;)V", "hideActionIconOverride", "getHideActionIconOverride", "()Ljava/lang/Integer;", "setHideActionIconOverride", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "init", "setOnPinListener", "listener", "Lkotlin/Function0;", "setOnUnpinListener", "setOnEditNameListener", "menuExtra", "Lcom/larus/bmhome/view/screenmenu/MenuExtra;", "setOnCopyWorkingDirectoryPathListener", "setOnDeleteListener", "setOnShareMessageListener", "setOnRefreshListener", "setOnHideListener", "setOnMoveToProjectListener", "setOnRemoveFromProjectListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationListMenuAdaptSideBar extends LinearLayoutCompat implements e0 {
    public static final /* synthetic */ int e = 0;
    public LarusLayoutMenuAdaptSideBarBinding a;
    public Function1<? super View, Unit> b;
    public CharSequence c;
    public Integer d;

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnRemoveFromProjectListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final Integer getHideActionIconOverride() {
        return this.d;
    }

    public final CharSequence getHideActionTitleOverride() {
        return this.c;
    }

    public final Function1<View, Unit> getOnForkClick() {
        return this.b;
    }

    public ConversationListMenuAdaptSideBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        d(r2, null);
    }

    public final void setHideActionIconOverride(Integer r1) {
        this.d = r1;
    }

    public final void setHideActionTitleOverride(CharSequence r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnCopyWorkingDirectoryPathListener(final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.b.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.p.setText(getContext().getString(2131906198));
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.k.setImageResource(v19.c.b(2130971813, getContext(), 2131241927));
        LarusLayoutMenuAdaptSideBarBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r1.b, new t(r7));
        return;
    L14:
        r1 = r4;
        goto L15
    }

    public final void setOnForkClick(Function1<? super View, Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnHideListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        AppCompatTextView r2 = r0.q;
        CharSequence r3 = this.c;
        if (r3 != null) goto L8;
        r3 = getContext().getString(2131900827);
    L8:
        r2.setText(r3);
        Integer r4 = this.d;
        if (r4 == null) goto L14;
        LarusLayoutMenuAdaptSideBarBinding r5 = this.a;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r5 = null;
    L13:
        r5.l.setImageResource(r4.intValue());
    L14:
        LarusLayoutMenuAdaptSideBarBinding r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r7 = null;
    L17:
        r7.e.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r8 = this.a;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L21:
        com.larus.utils.e1.d(r1.e, new q(r6));
        return;
    L20:
        r1 = r8;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnPinListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.g.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r1 = null;
    L8:
        r1.s.setText(getContext().getString(2131908358));
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.n.setImageResource(v19.c.b(2130971687, null, 2131241112));
        LarusLayoutMenuAdaptSideBarBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r2.g, new o(r6));
        return;
    L14:
        r2 = r4;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnRefreshListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.h.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.t.setText(getContext().getString(2131900775));
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.o.setImageResource(2131241154);
        LarusLayoutMenuAdaptSideBarBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r1.h, new p(r6));
        return;
    L14:
        r1 = r4;
        goto L15
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnShareMessageListener(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        FrameLayout r1 = r0.j;
        r1.setVisibility(0);
        com.larus.utils.e1.d(r1, new u(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnUnpinListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.g.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r1 = null;
    L8:
        r1.s.setText(getContext().getString(2131910875));
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.n.setImageResource(v19.c.b(2130971689, null, 2131241120));
        LarusLayoutMenuAdaptSideBarBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r2.g, new r(r6));
        return;
    L14:
        r2 = r4;
        goto L15
    }

    public ConversationListMenuAdaptSideBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        d(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void a(k0 r6, final com.larus.bmhome.chat.manager.k r7) {
        Intrinsics.checkNotNullParameter(r7, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.r.setText(getContext().getString(2131906203));
        LarusLayoutMenuAdaptSideBarBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.m.setImageResource(2131242085);
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.f.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r4 = null;
    L14:
        FrameLayout r5 = r4.f;
        if (r6 == null) goto L17;
        float r8 = r6.b;
    L18:
        r5.setAlpha(r8);
        LarusLayoutMenuAdaptSideBarBinding r9 = this.a;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r9 = null;
    L21:
        FrameLayout r10 = r9.f;
        if (r6 == null) goto L24;
        boolean r11 = r6.a;
    L25:
        r10.setEnabled(r11);
        LarusLayoutMenuAdaptSideBarBinding r12 = this.a;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L29:
        com.larus.utils.e1.d(r1.f, new x(r7, this));
        return;
    L28:
        r1 = r12;
        goto L29
    L24:
        r11 = true;
        goto L25
    L17:
        r8 = 1.0f;
        goto L18
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void b(k0 r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.c.setVisibility(0);
        if (r5 == null) goto L14;
        LarusLayoutMenuAdaptSideBarBinding r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L10:
        r2.c.setAlpha(r5.b);
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L13:
        r3.c.setEnabled(r5.a);
    L21:
        LarusLayoutMenuAdaptSideBarBinding r7 = this.a;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L25:
        com.larus.utils.e1.d(r1.c, new v(r6));
        return;
    L24:
        r1 = r7;
        goto L25
    L14:
        LarusLayoutMenuAdaptSideBarBinding r8 = this.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r8 = null;
    L17:
        r8.c.setAlpha(1.0f);
        LarusLayoutMenuAdaptSideBarBinding r9 = this.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r9 = null;
    L20:
        r9.c.setEnabled(true);
        goto L21
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void c(k0 r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuAdaptSideBarBinding r0 = this.a;
        LarusLayoutMenuAdaptSideBarBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.i.setVisibility(0);
        LarusLayoutMenuAdaptSideBarBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.i.setAlpha(r5.b);
        LarusLayoutMenuAdaptSideBarBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.i.setEnabled(r5.a);
        LarusLayoutMenuAdaptSideBarBinding r7 = this.a;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        final com.larus.bmhome.chat.manager.f r8 = (com.larus.bmhome.chat.manager.f) r6;
        com.larus.utils.e1.d(r1.i, new w(r8));
        return;
    L14:
        r1 = r7;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(Context r25, AttributeSet r26) {
        LayoutInflater.from(r25).inflate(2131562848, this);
        int r0 = 2131372781;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372781);
        if (r2 == null) goto L49;
        r0 = 2131372782;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372782);
        if (r3 == null) goto L49;
        r0 = 2131372783;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372783);
        if (r4 == null) goto L49;
        r0 = 2131372784;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372784);
        if (r5 == null) goto L49;
        r0 = 2131372785;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372785);
        if (r6 == null) goto L49;
        r0 = 2131372786;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372786);
        if (r7 == null) goto L49;
        r0 = 2131372787;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372787);
        if (r8 == null) goto L49;
        r0 = 2131372788;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372788);
        if (r9 == null) goto L49;
        r0 = 2131372789;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372789);
        if (r10 == null) goto L49;
        r0 = 2131376401;
        AppCompatImageView r11 = ViewBindings.findChildViewById(this, 2131376401);
        if (r11 == null) goto L49;
        r0 = 2131376402;
        AppCompatImageView r12 = ViewBindings.findChildViewById(this, 2131376402);
        if (r12 == null) goto L49;
        r0 = 2131376404;
        AppCompatImageView r13 = ViewBindings.findChildViewById(this, 2131376404);
        if (r13 == null) goto L49;
        r0 = 2131376405;
        AppCompatImageView r16 = ViewBindings.findChildViewById(this, 2131376405);
        if (r16 == null) goto L49;
        r0 = 2131376406;
        AppCompatImageView r17 = ViewBindings.findChildViewById(this, 2131376406);
        if (r17 == null) goto L49;
        r0 = 2131390934;
        AppCompatTextView r18 = ViewBindings.findChildViewById(this, 2131390934);
        if (r18 == null) goto L49;
        r0 = 2131390935;
        if (ViewBindings.findChildViewById(this, 2131390935) == null) goto L49;
        r0 = 2131390936;
        AppCompatTextView r19 = ViewBindings.findChildViewById(this, 2131390936);
        if (r19 == null) goto L49;
        r0 = 2131390939;
        AppCompatTextView r20 = ViewBindings.findChildViewById(this, 2131390939);
        if (r20 == null) goto L49;
        r0 = 2131390940;
        AppCompatTextView r21 = ViewBindings.findChildViewById(this, 2131390940);
        if (r21 == null) goto L49;
        r0 = 2131390941;
        AppCompatTextView r22 = ViewBindings.findChildViewById(this, 2131390941);
        if (r22 == null) goto L49;
        this.a = new LarusLayoutMenuAdaptSideBarBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r16, r17, r18, r19, r20, r21, r22);
        setOrientation(1);
        setDividerDrawable(AppCompatResources.getDrawable(r25, v19.c.b(2130970952, r25, 2131240110)));
        setShowDividers(2);
        LarusLayoutMenuAdaptSideBarBinding r14 = null;
        setBackgroundResource(v19.c.b(2130970630, null, 2131238896));
        LarusLayoutMenuAdaptSideBarBinding r1 = this.a;
        if (r1 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L46:
        com.larus.utils.e1.d(r14.d, new s(this));
        return;
    L45:
        r14 = r1;
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public ConversationListMenuAdaptSideBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        d(r2, r3);
    }
}
