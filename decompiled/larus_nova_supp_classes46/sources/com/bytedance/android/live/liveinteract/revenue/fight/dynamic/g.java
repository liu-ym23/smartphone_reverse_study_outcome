package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.liveinteract.revenue.fight.dialog.TeamFightApplyDialog;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public g(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "store");
        if (r8 != null) goto L5;
        return;
    L5:
        mi0.d r9 = (mi0.d) r8;
        DynamicTeamFightWidget r0 = this.a;
        TeamFightApplyDialog r10 = new TeamFightApplyDialog(((Widget) r0).context, ((Widget) r0).dataCenter, r9.a, String.valueOf(r9.b), r9.c);
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
    }
}
