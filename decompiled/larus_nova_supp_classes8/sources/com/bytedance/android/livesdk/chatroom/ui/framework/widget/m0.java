package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 extends Handler {
    public final /* synthetic */ PlatformGuideMessageServiceWidget a;

    @Override // android.os.Handler
    public final void handleMessage(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (r4.what != this.a.d) goto L6;
        xs2.b.a().post(new u22.j(true, 2));
        return;
    }

    public m0(PlatformGuideMessageServiceWidget r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
