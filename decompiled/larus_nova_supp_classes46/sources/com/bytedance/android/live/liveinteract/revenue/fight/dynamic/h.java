package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import android.content.Context;
import com.bytedance.android.live.liveinteract.revenue.fight.dialog.TeamFightInviteDialog;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public h(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 != null) goto L5;
        return;
    L5:
        Context r0 = ((Widget) this.a).context;
        TeamFightInviteDialog r4 = new TeamFightInviteDialog(r0, (com.bytedance.android.live.liveinteract.videolink.a) r3);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
    }
}
