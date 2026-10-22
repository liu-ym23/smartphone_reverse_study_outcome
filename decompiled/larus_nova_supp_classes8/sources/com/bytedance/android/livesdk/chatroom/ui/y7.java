package com.bytedance.android.livesdk.chatroom.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y7 implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ long a;
    public final /* synthetic */ boolean b;

    public y7(long r1, boolean r3) {
        this.a = r1;
        this.b = r3;
    }

    public final String generate() {
        return "setExpDelayTime = " + this.a + ", setEnableInvalidateDelay =" + this.b;
    }
}
