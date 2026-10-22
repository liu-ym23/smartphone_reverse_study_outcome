package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.liveinteract.revenue.fight.dialog.TeamFightWaitingDialog;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public i(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        DynamicTeamFightWidget r4 = this.a;
        TeamFightWaitingDialog r5 = new TeamFightWaitingDialog(((Widget) r4).context, ((Widget) r4).dataCenter);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }
}
