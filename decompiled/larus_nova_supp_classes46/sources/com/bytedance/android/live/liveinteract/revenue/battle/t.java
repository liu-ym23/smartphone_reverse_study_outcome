package com.bytedance.android.live.liveinteract.revenue.battle;

import android.text.SpannableString;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements com.bytedance.android.livesdk.interactivity.service.textrender.core.q {
    public final /* synthetic */ GuestBattleWidget a;
    public final /* synthetic */ eb b;

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public t(GuestBattleWidget r1, eb r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(SpannableString r14, com.bytedance.android.livesdk.interactivity.service.textrender.core.q.a r15) {
        Intrinsics.checkNotNullParameter(r14, "spannable");
        Intrinsics.checkNotNullParameter(r15, "info");
        pp1.c r16 = new pp1.c(null, this.b.getRichText(), this.b.getSchema(), 5, null, null, 1, 0, this.b.getExtra(), 0, 7856);
        r16.a = r14;
        DataCenter r17 = ((Widget) this.a).dataCenter;
        if (r17 == null) goto L6;
        r17.put("cmd_show_self_bubble_on_openplatform_behavior", r16);
        return;
    }
}
