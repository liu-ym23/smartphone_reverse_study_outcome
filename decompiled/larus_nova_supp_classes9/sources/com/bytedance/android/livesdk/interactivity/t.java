package com.bytedance.android.livesdk.interactivity;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Rect a(View r4) {
        if (r4 == null) goto L5;
        return new Rect(MathKt.roundToInt(r4.getX()), MathKt.roundToInt(r4.getY()), r4.getWidth(), r4.getHeight());
    L5:
        return new Rect(0, 0, 0, 0);
    }
}
