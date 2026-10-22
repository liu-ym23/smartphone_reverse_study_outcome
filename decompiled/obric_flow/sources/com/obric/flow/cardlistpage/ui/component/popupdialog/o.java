package com.obric.flow.cardlistpage.ui.component.popupdialog;

import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.popup.ScrimView;
import com.obric.flow.cardlistpage.ui.popup.WidgetLayer;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends com.obric.flow.cardlistpage.mvi.c {
    public final WidgetLayer d;
    public e e;

    public o(WidgetLayer r5, CoroutineScope r10, CardFeedLayout r11) {
        Intrinsics.checkNotNullParameter(r5, "widgetLayer");
        Intrinsics.checkNotNullParameter(r10, "coroutineScope");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(new com.obric.flow.cardlistpage.ui.component.feedlist.w(new x(), 3), r10, r11);
        this.d = r5;
        i();
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void g(com.obric.flow.cardlistpage.mvi.e r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.COMMAND);
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void h() {
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void j() {
        PopupDialogComponent$observeState$$inlined$collectState$1 r5 = new PopupDialogComponent$observeState$$inlined$collectState$1(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r5, 3, null);
    }

    public final void k(w r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        boolean r5 = r10 instanceof s;
        WidgetLayer r11 = this.d;
        if (r5 == false) goto L9;
        WidgetBox r12 = ((s) r10).f11743a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "widgetBox");
        if (r11.f != null) goto L7;
        r11.f = r12;
        r11.a(r12);
    L7:
        int r13 = WidgetBox.f11830j;
        r12.c(true, true);
    L13:
        d(r10);
        return;
    L9:
        if ((r10 instanceof r) == false) goto L13;
        WidgetBox r14 = ((r) r10).f11742a;
        int r15 = WidgetLayer.f11798l;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r14, "widgetBox");
        r14.c(false, true);
        if (Intrinsics.areEqual(r14, r11.f) == false) goto L13;
        r11.d();
        goto L13
    }

    public final void l(final WidgetBox r5, final OPopoverEntranceMenuView r10) {
        final n r11 = new n(this);
        final WidgetLayer r12 = this.d;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "widgetBox");
        Intrinsics.checkNotNullParameter(r10, "menu");
        Intrinsics.checkNotNullParameter(r11, "showListener");
        r12.f = r5;
        if (r5 == null) goto L5;
        int r13 = WidgetBox.f11830j;
        r5.d(true, true);
    L5:
        ScrimView r14 = r12.e;
        if (r14 == null) goto L9;
        r14.setVisibility(0);
    L9:
        ScrimView r15 = r12.e;
        if (r15 == null) goto L13;
        r15.setAlpha(0.0f);
    L13:
        Runnable r16 = new com.obric.flow.cardlistpage.ui.popup.c(r12, r5, r10, r11);
        r12.f11802h = r16;
        r12.postDelayed(r16, 200);
    }
}
