package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.popover.OPopoverLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "", "setPopoverMaxHeight", "(I)V", "", "a", "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "b", "getPressedWithArrow", "setPressedWithArrow", "pressedWithArrow", "c", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "ignoreWidthConstraint", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OPopoverMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14140c;
    public boolean d;

    @JvmOverloads
    public OPopoverMenuView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(View r5, ArrayList r10) {
        if ((r5 instanceof PopoverMenuLinearLayout) == false) goto L7;
        r10.add(r5);
        return;
    L7:
        if ((r5 instanceof ViewGroup) == false) goto L12;
        Iterator<View> r11 = ViewGroupKt.getChildren((ViewGroup) r5).iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        a(r11.next(), r10);
        goto L10
    L14:
        return;
    }

    public static OPopoverLayout b(View r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if ((r5 instanceof OPopoverLayout) == false) goto L8;
        return (OPopoverLayout) r5;
    L8:
        if (r5.getParent() == null) goto L16;
        ViewParent r10 = r5.getParent();
        if (r10 == null) goto L13;
        return b((ViewGroup) r10);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L16:
        return null;
    }

    public final boolean getForceDark() {
        return this.f14138a;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.f14140c;
    }

    public final boolean getPressedWithArrow() {
        return this.f14139b;
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        Log.e("OPopoverMenu", "onSizeChanged() called with: w = " + com.lynx.tasm.utils.a.y(getContext(), r5) + "dp");
        if (r5 > 0) goto L5;
    L14:
        com.lynx.tasm.utils.a.B(188, this);
        return;
    L5:
        if (this.d == true) goto L14;
        this.d = true;
        ArrayList r13 = new ArrayList();
        a(this, r13);
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L14;
        PopoverMenuLinearLayout r15 = (PopoverMenuLinearLayout) r14.next();
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L13;
        r16.width = (r5 - getPaddingLeft()) - getPaddingRight();
        r15.setLayoutParams(r16);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setForceDark(boolean r5) {
        this.f14138a = r5;
    }

    public final void setIgnoreWidthConstraint(boolean r5) {
        this.f14140c = r5;
    }

    public void setPopoverMaxHeight(int r5) {
    }

    public final void setPressedWithArrow(boolean r5) {
        this.f14139b = r5;
    }

    @JvmOverloads
    public OPopoverMenuView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPopoverMenuView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPopoverMenuView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14140c = true;
    }
}
