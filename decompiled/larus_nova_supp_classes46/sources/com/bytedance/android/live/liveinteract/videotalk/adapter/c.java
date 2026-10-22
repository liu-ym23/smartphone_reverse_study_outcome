package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.c0;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.liveinteract.plantform.model.d0;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements q {
    public final /* synthetic */ c1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ VideoRoomAudiencePreApplyViewHolder c;

    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public final void b(SpannableString r3, q.a r4) {
        Intrinsics.checkNotNullParameter(r3, "spannable");
        Intrinsics.checkNotNullParameter(r4, "info");
        TextView r5 = this.c.c;
        c0 r0 = this.a.c();
        if (r0 == null) goto L5;
        Spannable r6 = d0.a(r0, r3, this.b);
    L6:
        r5.setText(r6);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public c(c1 r1, String r2, VideoRoomAudiencePreApplyViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
