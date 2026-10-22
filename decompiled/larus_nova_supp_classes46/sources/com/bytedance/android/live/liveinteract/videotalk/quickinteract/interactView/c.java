package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements q {
    public final /* synthetic */ Function2 a;

    public c(Function2 r1) {
        this.a = r1;
    }

    public final void a(py.k r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r3, "model");
        this.a.invoke(Boolean.FALSE, null);
    }

    public final void b(SpannableString r2, q.a r3) {
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r3, "info");
        this.a.invoke(Boolean.TRUE, r2);
    }
}
