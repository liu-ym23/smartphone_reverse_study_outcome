package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a1 implements af1.c {
    public final /* synthetic */ vlc.d a;

    public a1(vlc.d r1) {
        this.a = r1;
    }

    public final void a(int r2, ye1.e.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a.addMessageListener(r2, r3);
    }

    public final void b(int r2, ye1.e.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a.removeMessageListener(r2, r3);
    }
}
