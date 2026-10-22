package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OPopoverFilterMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<ViewGroup> f7152j;

    @JvmOverloads
    public OPopoverFilterMenuView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPopoverFilterMenuView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPopoverFilterMenuView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        new ArrayList();
        new LinkedHashMap();
        this.f7152j = new ArrayList();
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        MathKt.roundToInt(TypedValue.applyDimension(1, 188, r13.getDisplayMetrics()));
        r10.getResources().getDimension(d.oui_h_list_item_menu);
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        Iterator<T> r14 = this.f7152j.iterator();
    L4:
        if (r14.hasNext() == false) goto L24;
        ViewGroup r15 = (ViewGroup) r14.next();
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L23;
        ViewGroup.LayoutParams r17 = r15.getLayoutParams();
        ViewGroup.LayoutParams r18 = null;
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r17 = null;
    L10:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r17;
        int r20 = 0;
        if (r19 == null) goto L13;
        int r21 = r19.leftMargin;
    L14:
        int r22 = r10 - r21;
        ViewGroup.LayoutParams r23 = r15.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r18 = r23;
    L18:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r18;
        if (r24 == null) goto L21;
        r20 = r24.rightMargin;
    L21:
        r16.width = r22 - r20;
        r15.setLayoutParams(r16);
        goto L4
    L13:
        r21 = 0;
        goto L14
    L23:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
