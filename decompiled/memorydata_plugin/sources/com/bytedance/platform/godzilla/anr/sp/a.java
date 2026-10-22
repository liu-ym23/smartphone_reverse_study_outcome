package com.bytedance.platform.godzilla.anr.sp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f2985a;

    public static void a() {
        Handler r0 = f2985a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasMessages(1) == true) goto L7;
        Log.d("LinkedListForWorks", "Handler in QueuedWork has no MSG_RUN message,so we send one.");
        final Message r1 = Message.obtain(f2985a);
        r1.what = 1;
        new Handler().post(new AnonymousClass1(r1));
        return;
    L7:
        Log.d("LinkedListForWorks", "Handler in QueuedWork has MSG_RUN message,no need to send one.");
    }
}
