package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.obric.common.oui.R$dimen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverFilterMenuView extends OPopoverMenuView {
    public final ArrayList e;

    @JvmOverloads
    public OPopoverFilterMenuView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        Iterator r13 = this.e.iterator();
    L4:
        if (r13.hasNext() == false) goto L24;
        ViewGroup r14 = (ViewGroup) r13.next();
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L23;
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        ViewGroup.LayoutParams r17 = null;
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r16 = null;
    L10:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r16;
        int r19 = 0;
        if (r18 == null) goto L13;
        int r20 = r18.leftMargin;
    L14:
        int r21 = r5 - r20;
        ViewGroup.LayoutParams r22 = r14.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r17 = r22;
    L18:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r17;
        if (r23 == null) goto L21;
        r19 = r23.rightMargin;
    L21:
        r15.width = r21 - r19;
        r14.setLayoutParams(r15);
        goto L4
    L13:
        r20 = 0;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmOverloads
    public OPopoverFilterMenuView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPopoverFilterMenuView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        new ArrayList();
        new LinkedHashMap();
        this.e = new ArrayList();
        com.lynx.tasm.utils.a.B(4, this);
        com.lynx.tasm.utils.a.B(188, this);
        r5.getResources().getDimension(R$dimen.oui_h_list_item_menu);
    }
}
