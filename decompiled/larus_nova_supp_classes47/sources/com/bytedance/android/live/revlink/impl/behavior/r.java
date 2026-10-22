package com.bytedance.android.live.revlink.impl.behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.link.model.IPKIconBubble;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ ToolbarPkBehavior a;
    public final /* synthetic */ IPKIconBubble b;

    public r(ToolbarPkBehavior r1, IPKIconBubble r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        pq2.a r4 = com.bytedance.android.live.revenue.core.util.e.a(pq2.a.class);
        Context r0 = this.a.d;
        Intrinsics.checkNotNull(r0);
        r4.s3(r0, UriProtector.parse(this.b.getSchema()));
    }
}
