package com.bytedance.android.livesdk.chatroom.ui.framework.widget.util;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ Function1 b;

    public a(Bitmap r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r3) {
        ALogger.e("BlackFrameDetectionUtil", "onPixelCopyFinished:" + r3);
        if (r3 != 0) goto L7;
        Function1 r4 = this.b;
        if (r4 == null) goto L11;
        Unit r5 = (Unit) r4.invoke(this.a);
        return;
    L11:
        return;
    L7:
        Function1 r6 = this.b;
        if (r6 == null) goto L13;
        Unit r7 = (Unit) r6.invoke(null);
        return;
    }
}
