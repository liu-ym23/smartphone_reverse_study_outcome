package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements q {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public final void b(SpannableString r2, q.a r3) {
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r3, "info");
        TextView r4 = this.a.h;
        if (r4 == null) goto L6;
        r4.setText(r2);
        return;
    }
}
