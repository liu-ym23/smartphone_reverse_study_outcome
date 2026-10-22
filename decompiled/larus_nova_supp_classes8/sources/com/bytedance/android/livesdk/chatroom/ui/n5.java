package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n5 extends b7.a {
    public final /* synthetic */ AutoFallbackHybridComponentContainer a;

    public n5(AutoFallbackHybridComponentContainer r1) {
        this.a = r1;
    }

    public final void onInnerFallback(int r2, String r3) {
        super.onInnerFallback(r2, r3);
        this.a.b("lynx view load error. url is " + this.a.a);
    }

    public final void onLoadFail(View r3, String r4, String r5) {
        super.onLoadFail(r3, r4, r5);
        AutoFallbackHybridComponentContainer r6 = this.a;
        String r7 = "h5 view load error. url is " + r4 + ", msg is " + r5;
        int r8 = AutoFallbackHybridComponentContainer.e;
        r6.b(r7);
    }
}
