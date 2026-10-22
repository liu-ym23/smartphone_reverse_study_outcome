package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements vr1.z {
    public final WeakReference<com.bytedance.android.live.pushstream.d> a;

    public r(WeakReference<com.bytedance.android.live.pushstream.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        this.a = r2;
    }
}
