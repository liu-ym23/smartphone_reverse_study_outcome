package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.z5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements z5.a {
    public final /* synthetic */ i a;
    public final /* synthetic */ long b;

    public final void onQuit() {
        ALogger.i("CarnivalBinarySeiHandler", "handler thread quit");
    }

    public final void a(z5 r7) {
        Intrinsics.checkNotNullParameter(r7, "thread");
        if (this.a.a.compareAndSet(1, 2) == false) goto L5;
        ALogger.i("CarnivalBinarySeiHandler", "handler start success. cost=" + (System.currentTimeMillis() - this.b));
        this.a.c = new Handler(r7.getLooper());
        return;
    L5:
        ALogger.i("CarnivalBinarySeiHandler", "handler start failed. cur state is " + this.a.a.get());
    }

    public j(i r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
