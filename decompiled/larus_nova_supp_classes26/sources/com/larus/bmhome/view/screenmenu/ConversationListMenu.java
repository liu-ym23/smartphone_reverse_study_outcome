package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutMenuBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J \u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J \u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u0019\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/ConversationListMenu;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/larus/bmhome/view/screenmenu/IConversationListMenu;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuBinding", "Lcom/larus/bmhome/databinding/LarusLayoutMenuBinding;", "init", "", "setOnPinListener", "listener", "Lkotlin/Function0;", "setOnUnpinListener", "setOnEditNameListener", "menuExtra", "Lcom/larus/bmhome/view/screenmenu/MenuExtra;", "setOnDeleteListener", "setOnShareMessageListener", "setOnRefreshListener", "setOnHideListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationListMenu extends LinearLayoutCompat implements e0 {
    public static final /* synthetic */ int b = 0;
    public LarusLayoutMenuBinding a;

    public ConversationListMenu(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        d(r2, null);
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnCopyWorkingDirectoryPathListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnHideListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        LarusLayoutMenuBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.c.setVisibility(0);
        LarusLayoutMenuBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.j.setText(getContext().getString(2131900827));
        LarusLayoutMenuBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L12:
        com.larus.utils.e1.d(r1.c, new i(r6));
        return;
    L11:
        r1 = r3;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnPinListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        LarusLayoutMenuBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.d.setVisibility(0);
        LarusLayoutMenuBinding r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r1 = null;
    L8:
        r1.k.setText(getContext().getString(2131908358));
        LarusLayoutMenuBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.h.setImageResource(v19.c.b(2130971687, null, 2131241112));
        LarusLayoutMenuBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r2.d, new k(r6));
        return;
    L14:
        r2 = r4;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnRefreshListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        LarusLayoutMenuBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.e.setVisibility(0);
        LarusLayoutMenuBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.l.setText(getContext().getString(2131900775));
        LarusLayoutMenuBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.i.setImageResource(2131241154);
        LarusLayoutMenuBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r1.e, new h(r6));
        return;
    L14:
        r1 = r4;
        goto L15
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnRemoveFromProjectListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnShareMessageListener(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        FrameLayout r1 = r0.g;
        r1.setVisibility(0);
        com.larus.utils.e1.d(r1, new j(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnUnpinListener(final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        LarusLayoutMenuBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.d.setVisibility(0);
        LarusLayoutMenuBinding r1 = this.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r1 = null;
    L8:
        r1.k.setText(getContext().getString(2131910875));
        LarusLayoutMenuBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.h.setImageResource(v19.c.b(2130971689, null, 2131241120));
        LarusLayoutMenuBinding r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r2.d, new l(r6));
        return;
    L14:
        r2 = r4;
        goto L15
    }

    public ConversationListMenu(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        d(r2, r3);
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void a(k0 r1, com.larus.bmhome.chat.manager.k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void b(k0 r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        LarusLayoutMenuBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.b.setVisibility(0);
        if (r5 == null) goto L14;
        LarusLayoutMenuBinding r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L10:
        r2.b.setAlpha(r5.b);
        LarusLayoutMenuBinding r3 = this.a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L13:
        r3.b.setEnabled(r5.a);
    L21:
        LarusLayoutMenuBinding r7 = this.a;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L25:
        com.larus.utils.e1.d(r1.b, new m(r6));
        return;
    L24:
        r1 = r7;
        goto L25
    L14:
        LarusLayoutMenuBinding r8 = this.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r8 = null;
    L17:
        r8.b.setAlpha(1.0f);
        LarusLayoutMenuBinding r9 = this.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r9 = null;
    L20:
        r9.b.setEnabled(true);
        goto L21
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void c(k0 r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        LarusLayoutMenuBinding r0 = this.a;
        LarusLayoutMenuBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.f.setVisibility(0);
        LarusLayoutMenuBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r2 = null;
    L8:
        r2.f.setAlpha(r5.b);
        LarusLayoutMenuBinding r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r3 = null;
    L11:
        r3.f.setEnabled(r5.a);
        LarusLayoutMenuBinding r7 = this.a;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r1.f, new n(r6));
        return;
    L14:
        r1 = r7;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(Context r17, AttributeSet r18) {
        LayoutInflater.from(r17).inflate(2131562847, this);
        int r0 = 2131372782;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372782);
        if (r2 == null) goto L29;
        r0 = 2131372784;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372784);
        if (r3 == null) goto L29;
        r0 = 2131372786;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372786);
        if (r4 == null) goto L29;
        r0 = 2131372787;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372787);
        if (r5 == null) goto L29;
        r0 = 2131372788;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372788);
        if (r6 == null) goto L29;
        r0 = 2131372789;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372789);
        if (r7 == null) goto L29;
        r0 = 2131376402;
        if (ViewBindings.findChildViewById(this, 2131376402) == null) goto L29;
        r0 = 2131376405;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131376405);
        if (r8 == null) goto L29;
        r0 = 2131376406;
        AppCompatImageView r9 = ViewBindings.findChildViewById(this, 2131376406);
        if (r9 == null) goto L29;
        r0 = 2131390936;
        AppCompatTextView r10 = ViewBindings.findChildViewById(this, 2131390936);
        if (r10 == null) goto L29;
        r0 = 2131390940;
        AppCompatTextView r11 = ViewBindings.findChildViewById(this, 2131390940);
        if (r11 == null) goto L29;
        r0 = 2131390941;
        AppCompatTextView r12 = ViewBindings.findChildViewById(this, 2131390941);
        if (r12 == null) goto L29;
        this.a = new LarusLayoutMenuBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        setOrientation(1);
        setDividerDrawable(AppCompatResources.getDrawable(r17, v19.c.b(2130970952, r17, 2131240110)));
        setShowDividers(2);
        setBackgroundResource(v19.c.b(2130970630, null, 2131238896));
        return;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public ConversationListMenu(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        d(r2, r3);
    }
}
