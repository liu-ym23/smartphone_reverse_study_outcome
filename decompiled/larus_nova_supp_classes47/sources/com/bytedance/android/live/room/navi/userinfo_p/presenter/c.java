package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements q {
    public final /* synthetic */ UserInfoTabPresenter a;
    public final /* synthetic */ TextView b;

    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public c(UserInfoTabPresenter r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(SpannableString r3, q.a r4) {
        Intrinsics.checkNotNullParameter(r3, "spannable");
        Intrinsics.checkNotNullParameter(r4, "info");
        Intrinsics.checkNotNullParameter(r3, "spannable");
        Intrinsics.checkNotNullParameter(r4, "info");
        this.b.setText(r3);
        UserInfoTabPresenter.i(this.a, this.b, r3);
    }
}
