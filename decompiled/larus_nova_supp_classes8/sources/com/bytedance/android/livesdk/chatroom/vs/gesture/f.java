package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.GestureDetector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends GestureDetector {
    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scrollGestureListener");
        super(r2, r3);
        new GestureDetector(r2, r3);
    }
}
