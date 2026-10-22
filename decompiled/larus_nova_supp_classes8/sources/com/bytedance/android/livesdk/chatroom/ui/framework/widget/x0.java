package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x0 implements js0.b {
    public final /* synthetic */ ScreenLinkTriggerWidget a;

    public x0(ScreenLinkTriggerWidget r1) {
        this.a = r1;
    }

    public final void onSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "track");
        this.a.wq();
    }
}
