package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class t extends r22.a<q22.d> {
    public final Deque<q22.d> c;

    @Override // r22.a
    public final q22.d j() {
        return (q22.d) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final Queue<q22.d> h() {
        return this.c;
    }

    public t(r22.b<q22.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.c = new LinkedList();
    }

    @Override // r22.a
    public final void b(q22.d r4, r22.a.b<q22.d> r5) {
        q22.d r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r5, "notifier");
        if (r6.a.d != null) goto L5;
        r5.a(r6);
        return;
    L5:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r6.a.d, new s(r6, r5));
    }
}
