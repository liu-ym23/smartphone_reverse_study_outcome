package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.loc.o;
import com.obric.oui.common.util.h;
import com.obric.oui.popover.OPopoverLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J\u000e\u0010\u0010\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\nJ(\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001cH\u0004J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0007H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006+"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forceDark", "", "getForceDark", "()Z", "setForceDark", "(Z)V", "hasAligned", "ignoreWidthConstraint", "getIgnoreWidthConstraint", "setIgnoreWidthConstraint", "pressedWithArrow", "getPressedWithArrow", "setPressedWithArrow", "collectMenuItemLayout", "", "view", "Landroid/view/View;", Constants.KEY_LIST, "", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "findMenuItem", "", "findOPopoverLayout", "Lcom/obric/oui/popover/OPopoverLayout;", "ignore", "onSizeChanged", "w", o.g, "oldw", "oldh", "registerPressedCallback", "itemView", "setPopoverMaxHeight", "maxHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OPopoverMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14344b;
    private boolean c;
    private boolean d;

    public OPopoverMenuView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPopoverMenuView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPopoverMenuView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.c = true;
    }

    public /* synthetic */ OPopoverMenuView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final List<PopoverMenuLinearLayout> a() {
        List<PopoverMenuLinearLayout> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(View r4, List<PopoverMenuLinearLayout> r5) {
        List<PopoverMenuLinearLayout> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, PopoverMenuLinearLayout.class) == false) goto L7;
        r6.add(r4);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L12;
        Iterator<View> r7 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        a((View) ZeusTransformUtils.preCheckCast(r7.next(), View.class, "com.obric.memorydata.plugin"), r6);
        goto L10
    L14:
        return;
    }

    public final OPopoverLayout a(View r4) {
        if (r4 != null) goto L5;
    L10:
        Object r3 = ZeusTransformUtils.preCheckCast(null, OPopoverLayout.class, "com.obric.memorydata.plugin");
    L12:
        return (OPopoverLayout) r3;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, OPopoverLayout.class) == false) goto L8;
        r3 = ZeusTransformUtils.preCheckCast(r4, OPopoverLayout.class, "com.obric.memorydata.plugin");
        goto L12
    L8:
        if (r4.getParent() == null) goto L10;
        ViewParent r5 = r4.getParent();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        return a((View) ZeusTransformUtils.preCheckCast((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin"), View.class, "com.obric.memorydata.plugin"));
    }

    public final void a(final PopoverMenuLinearLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        if (this.f14344b == false) goto L6;
        r3.setNotifyPressedCallback((Function2) ZeusTransformUtils.preCheckCast(new OPopoverMenuView$registerPressedCallback$1(this, r3), Function2.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final boolean getForceDark() {
        return this.f14343a;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.c;
    }

    public final boolean getPressedWithArrow() {
        return this.f14344b;
    }

    @Override // android.view.View
    public void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        StringBuilder r8 = new StringBuilder().append("onSizeChanged() called with: w = ");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        Log.e("OPopoverMenu", r8.append(h.a(r9, r4)).append("dp").toString());
        if (r4 > 0) goto L5;
    L10:
        h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 188);
        return;
    L5:
        if (this.d == true) goto L10;
        this.d = true;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        View r11 = (View) ZeusTransformUtils.preCheckCast((PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(r10.next(), PopoverMenuLinearLayout.class, "com.obric.memorydata.plugin"), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r0.width = (r4 - getPaddingLeft()) - getPaddingRight();
        r11.setLayoutParams(r0);
        goto L8
    }

    public final void setForceDark(boolean r1) {
        this.f14343a = r1;
    }

    public final void setIgnoreWidthConstraint(boolean r1) {
        this.c = r1;
    }

    public void setPopoverMaxHeight(int r1) {
    }

    public final void setPressedWithArrow(boolean r1) {
        this.f14344b = r1;
    }
}
