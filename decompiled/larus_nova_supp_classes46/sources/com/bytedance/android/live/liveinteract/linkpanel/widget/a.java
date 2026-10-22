package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.IncreasePriceApplyDialog;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = GuestApplyContentWidget.wq(this.a.a);
        if (hd0.c.f().j() == false) goto L13;
        GuestApplyContentWidget r0 = this.a.a;
        Context r1 = ((Widget) r0).context;
        if (r1 == null) goto L11;
        int r2 = IncreasePriceApplyDialog.g;
        GuestApplyViewModel r3 = r0.q;
        Intrinsics.checkNotNullParameter(r1, "context");
        IncreasePriceApplyDialog r6 = new IncreasePriceApplyDialog(r1, r5, r3);
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r6);
        goto L11
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L10:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    L11:
        ALogger.i("GuestApplyDialog", "audience clicks the increase price button");
    L15:
        MultiLinkEventModule r7 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a(((Integer) ((ge1.a) hd0.c.f()).b).intValue(), r5);
        return;
    L13:
        if (hd0.c.f().g() == false) goto L15;
        f2.b(2131915053, 0);
        goto L15
    }
}
