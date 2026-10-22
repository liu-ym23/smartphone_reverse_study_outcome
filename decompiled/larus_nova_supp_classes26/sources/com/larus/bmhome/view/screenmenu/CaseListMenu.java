package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutCaseMenuBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/CaseListMenu;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/larus/bmhome/view/screenmenu/ICaseListMenu;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuBinding", "Lcom/larus/bmhome/databinding/LarusLayoutCaseMenuBinding;", "init", "", "setOnDeleteListener", "listener", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseListMenu extends LinearLayoutCompat {
    public static final /* synthetic */ int b = 0;
    public LarusLayoutCaseMenuBinding a;

    public CaseListMenu(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        d(r2, null);
    }

    public void setOnDeleteListener(final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        LarusLayoutCaseMenuBinding r0 = this.a;
        LarusLayoutCaseMenuBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r0 = null;
    L5:
        r0.b.setVisibility(0);
        LarusLayoutCaseMenuBinding r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L9:
        com.larus.utils.e1.d(r1.b, new e(r5));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public CaseListMenu(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        d(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(Context r2, AttributeSet r3) {
        LayoutInflater.from(r2).inflate(2131562774, this);
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372788);
        if (r0 == null) goto L7;
        this.a = new LarusLayoutCaseMenuBinding(this, r0);
        setOrientation(1);
        setDividerDrawable(AppCompatResources.getDrawable(r2, 2131240110));
        setShowDividers(2);
        setBackgroundResource(2131238896);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(2131372788)));
    }

    public CaseListMenu(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        d(r2, r3);
    }
}
