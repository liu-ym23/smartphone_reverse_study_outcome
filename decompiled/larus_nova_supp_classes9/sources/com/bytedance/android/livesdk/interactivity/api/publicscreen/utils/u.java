package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends m {
    public static u a;

    public static u a() {
        if (a != null) goto L6;
        a = new u();
    L6:
        return a;
    }

    public u() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.m, android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r1, Spannable r2, MotionEvent r3) {
        return super.onTouchEvent(r1, r2, r3);
    L4:
        th = move-exception;
        ALogger.e("SafeLinkMovementMethod", th.getMessage());
        return false;
    }
}
