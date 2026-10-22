package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements q {
    public final /* synthetic */ eb a;
    public final /* synthetic */ DataCenter b;

    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public h(eb r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(SpannableString r14, q.a r15) {
        Intrinsics.checkNotNullParameter(r14, "spannable");
        Intrinsics.checkNotNullParameter(r15, "info");
        pp1.c r16 = new pp1.c(null, this.a.getRichText(), this.a.getSchema(), 5, null, null, 1, 0, this.a.getExtra(), 0, 7856);
        r16.a = r14;
        DataCenter r17 = this.b;
        if (r17 == null) goto L6;
        r17.put("cmd_show_self_bubble_on_openplatform_behavior", r16);
        return;
    }
}
