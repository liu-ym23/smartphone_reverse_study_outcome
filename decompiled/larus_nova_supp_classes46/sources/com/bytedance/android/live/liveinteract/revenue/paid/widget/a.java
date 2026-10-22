package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import android.content.Context;
import android.text.TextUtils;
import cj0.f;
import cj0.g;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ BasePaidLinkMicWidget a;

    public a(BasePaidLinkMicWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        String r5 = (String) r4;
        BasePaidLinkMicWidget r0 = this.a;
        r0.getClass();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        Context r1 = r0.getContext();
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "tips");
        z0.a().getClass();
        x0.b r2 = new x0.b(r1, 4);
        r2.m(2131923055);
        r2.a.d = r5;
        r2.i(0, 2131920806, new f(r1));
        r2.i(1, 2131915442, g.a);
        r2.n();
        return;
    }
}
