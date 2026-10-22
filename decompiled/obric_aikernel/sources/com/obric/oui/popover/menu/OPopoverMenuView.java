package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.common.util.f;
import com.obric.oui.popover.OPopoverLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/widget/LinearLayout;", "", "g", "Z", "getPressedWithArrow", "()Z", "setPressedWithArrow", "(Z)V", "pressedWithArrow", "c", "getForceDark", "setForceDark", "forceDark", "h", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "ignoreWidthConstraint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OPopoverMenuView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7153c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7156i;

    @JvmOverloads
    public OPopoverMenuView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPopoverMenuView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPopoverMenuView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7155h = true;
    }

    public /* synthetic */ OPopoverMenuView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(View r10, List<PopoverMenuLinearLayout> r11) {
        if ((r10 instanceof PopoverMenuLinearLayout) == false) goto L7;
        r11.add(r10);
        return;
    L7:
        if ((r10 instanceof ViewGroup) == false) goto L12;
        Iterator<View> r12 = ViewGroupKt.getChildren((ViewGroup) r10).iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        a(r12.next(), r11);
        goto L10
    L14:
        return;
    }

    private final List<PopoverMenuLinearLayout> b() {
        ArrayList r10 = new ArrayList();
        a(this, r10);
        return r10;
    }

    protected final OPopoverLayout c(View r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r10 instanceof OPopoverLayout) == false) goto L8;
        return (OPopoverLayout) r10;
    L8:
        if (r10.getParent() == null) goto L13;
        ViewParent r11 = r10.getParent();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup");
        return c((ViewGroup) r11);
    L13:
        return null;
    }

    protected final boolean getForceDark() {
        return this.f7153c;
    }

    protected final boolean getIgnoreWidthConstraint() {
        return this.f7155h;
    }

    protected final boolean getPressedWithArrow() {
        return this.f7154g;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        StringBuilder r14 = new StringBuilder();
        r14.append("onSizeChanged() called with: w = ");
        Context r15 = getContext();
        Intrinsics.checkNotNullExpressionValue(r15, "context");
        r14.append(f.f(r15, r10));
        r14.append("dp");
        Log.e("OPopoverMenu", r14.toString());
        if (r10 > 0) goto L5;
    L14:
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        MathKt.roundToInt(TypedValue.applyDimension(1, 188, r16.getDisplayMetrics()));
        return;
    L5:
        if (this.f7156i == true) goto L14;
        this.f7156i = true;
        Iterator<T> r17 = b().iterator();
    L8:
        if (r17.hasNext() == false) goto L14;
        PopoverMenuLinearLayout r18 = (PopoverMenuLinearLayout) r17.next();
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L13;
        r19.width = (r10 - getPaddingLeft()) - getPaddingRight();
        r18.setLayoutParams(r19);
        goto L8
    L13:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    protected final void setForceDark(boolean r10) {
        this.f7153c = r10;
    }

    protected final void setIgnoreWidthConstraint(boolean r10) {
        this.f7155h = r10;
    }

    protected final void setPressedWithArrow(boolean r10) {
        this.f7154g = r10;
    }
}
