package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g7 extends ScaleGestureDetector {
    @Override // android.view.ScaleGestureDetector
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super.onTouchEvent(r2);
    }

    public g7(Context r2, com.bytedance.android.live.pushstream.d r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, new h7(r3, r4));
    }
}
