package com.bytedance.android.live.revenuelink.multimsg;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.revenuelink.multimsg.api.TaskMainHandler;
import com.bytedance.android.live.revenuelink.multimsg.api.h;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends a {
    public final h k;
    public final com.bytedance.android.live.revenuelink.multimsg.api.f l;

    public d(i r2, yz0.f r3) {
        super(r2, r3);
        this.k = new h(this);
        this.l = new com.bytedance.android.live.revenuelink.multimsg.api.f(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MultiMsgManager")));
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void S3(String r4, ByteBuffer r5) {
        if (this.a == false) goto L11;
        if (r5 == null) goto L13;
        com.bytedance.android.live.revenuelink.multimsg.api.f r6 = this.l;
        f r0 = new f();
        h r1 = this.k;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        Intrinsics.checkNotNullParameter(r1, "resultHandler");
        com.bytedance.android.live.revenuelink.multimsg.api.g r2 = new com.bytedance.android.live.revenuelink.multimsg.api.g(r6, r0, r1, r5);
        Lazy r7 = TaskMainHandler.a;
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        r2.run();
        return;
    L9:
        ((Handler) TaskMainHandler.a.getValue()).post(r2);
        return;
    L13:
        return;
    }
}
