package com.larksuite.component.card.component.text;

import android.view.View;
import com.larksuite.component.card.protocol.data.at.AtProperty;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l implements mcc.b {
    public final rcc.a a;
    public final /* synthetic */ UniversalCardTextLynxUI b;

    public final boolean c(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        return false;
    }

    public l(UniversalCardTextLynxUI r1) {
        this.b = r1;
        this.a = new rcc.a();
    }

    public final void d(View r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r12, "opUserId");
        if (this.a.a() == false) goto L6;
        Log.e("UniversalCardTextLynxUI", "url check isDuplicate: " + r11.hashCode());
        return;
    L6:
        UniversalCardTextLynxUI r13 = this.b;
        int r14 = UniversalCardTextLynxUI.g;
        com.larksuite.component.card.cardcontainer.c r15 = r13.O();
        if (r15 != null) goto L10;
        Log.e("UniversalCardTextLynxUI", "card ShareData null");
        return;
    L10:
        com.larksuite.component.card.monitor.a.b(r15.b.getVersion(), "open_profile", "markdown", r15.c.getMonitorData(), r15.b.getCardID(), null, r15.b.isStreamingMode(), null, 160);
        String r16 = r15.c.getCardActionDependencyData().getSelectPersonCurrentChatId();
        if (r16 != null) goto L14;
        r16 = "";
    L14:
        HashMap<String, AtProperty> r0 = r15.b.getCardContent().getAttachment().getAtUsers();
        if (r0 == null) goto L17;
        AtProperty r1 = r0.get(r12);
    L18:
        if (r1 == null) goto L20;
        r12 = r1.getUserId();
    L20:
        r15.c.getDependency().openProfilePage(UniversalCardTextLynxUI.M(this.b).getContext(), r12, r16);
        return;
    L17:
        r1 = null;
        goto L18
    }
}
