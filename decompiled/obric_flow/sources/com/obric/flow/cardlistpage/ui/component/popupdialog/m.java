package com.obric.flow.cardlistpage.ui.component.popupdialog;

import android.view.View;
import com.obric.flow.cardlistpage.R$drawable;
import com.obric.flow.cardlistpage.R$string;
import com.obric.flow.cardlistpage.ui.popup.WidgetLayer;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f11738a;

    public m(o r5) {
        this.f11738a = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r10, Continuation r11) {
        b0 r12 = (b0) r10;
        boolean r13 = Intrinsics.areEqual(r12, z.f11751a);
        final o r14 = this.f11738a;
        if (r13 == false) goto L6;
        r14.e = null;
    L32:
        return Unit.INSTANCE;
    L6:
        if ((r12 instanceof a0) == false) goto L27;
        a0 r15 = (a0) r12;
        boolean r16 = Intrinsics.areEqual(r14.e, r15.f11717a);
        WidgetLayer r5 = r14.d;
        if (r16 == true) goto L10;
    L11:
        e r17 = r15.f11717a;
        r14.e = r17;
        if ((r17 instanceof c) == false) goto L21;
        c r18 = (c) r17;
        final WidgetBox r19 = r18.f11721a.f11716a;
        if (r19 == null) goto L32;
        com.obric.oui.popover.menu.b r20 = new com.obric.oui.popover.menu.b(r19.getContext());
        final c0 r21 = r18.f11723c;
        final b r110 = r18.f11722b;
        if (r21.f11725b == null) goto L19;
        com.obric.oui.popover.menu.b.a(r20, Integer.valueOf(R$drawable.icon_widget_edit_svg), r5.getContext().getString(R$string.edit_widget), false, new PopupDialogComponent$showEditPopup$menu$1$1(r21, r14, r110), 245);
    L19:
        com.obric.oui.popover.menu.b.a(r20, Integer.valueOf(R$drawable.icon_add_widget_svg), r5.getContext().getString(R$string.add_widget), false, new PopupDialogComponent$showEditPopup$menu$1$2(r14, r110), 245);
        com.obric.oui.popover.menu.b.a(r20, Integer.valueOf(R$drawable.icon_widget_remove_svg), r5.getContext().getString(R$string.delete_widget), true, new PopupDialogComponent$showEditPopup$menu$1$3(r14, r19, r21, r110), 181);
        r14.l(r19, r20.b());
        goto L32
    L21:
        if ((r17 instanceof d) == false) goto L32;
        final d r111 = (d) r17;
        WidgetBox r112 = r111.f11726a.f11716a;
        if (r112 == null) goto L32;
        com.obric.oui.popover.menu.b r22 = new com.obric.oui.popover.menu.b(r112.getContext());
        Integer r23 = Integer.valueOf(R$drawable.icon_widget_remove_svg);
        String r24 = r5.getContext().getString(R$string.card_feed_delete_travel_service);
        final View r25 = r111.f11727b;
        com.obric.oui.popover.menu.b.a(r22, r23, r24, true, new PopupDialogComponent$showExternalLongClickPopup$menu$1$1(r14, r25, r111), 181);
        r22.e = true;
        OPopoverEntranceMenuView r113 = r22.b();
        r112.setAnchorView(r25);
        r14.l(r112, r113);
        goto L32
    L10:
        if (r5.c() == true) goto L32;
    L27:
        if ((r12 instanceof y) == false) goto L32;
        r14.e = null;
        boolean r114 = ((y) r12).f11750c;
        WidgetLayer r115 = r14.d;
        r115.b(r114);
        if (r115.c() == true) goto L32;
        ((com.obric.flow.cardlistpage.mvi.a) r14.f11531a).a(t.f11744a);
        goto L32
    }
}
