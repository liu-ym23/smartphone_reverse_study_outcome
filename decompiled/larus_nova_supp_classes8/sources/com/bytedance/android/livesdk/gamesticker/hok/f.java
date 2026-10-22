package com.bytedance.android.livesdk.gamesticker.hok;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import df6.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements hf6.f {
    public final String a;

    public final void onComplete(Uri r1, View r2, o r3, Animatable r4) {
    }

    public final void onIntermediateImageSet(Uri r1, o r2) {
    }

    public final void onRelease(Uri r1) {
    }

    public final void onStart(Uri r1, View r2) {
    }

    public f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.a = r2;
    }

    public final void onIntermediateImageFailed(Uri r3, Throwable r4) {
        StringBuilder r0 = new StringBuilder("l");
        r0.append(this.a);
        r0.append(" load icon ");
        r0.append(r3);
        r0.append(" onIntermediateImageFailed ");
        if (r4 == null) goto L5;
        String r5 = r4.getMessage();
    L6:
        r0.append(r5);
        ALogger.e("GameStickerService", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onFailed(Uri r2, View r3, Throwable r4) {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.a);
        r5.append(" load icon ");
        r5.append(r2);
        r5.append(" onFailed ");
        if (r4 == null) goto L5;
        String r6 = r4.getMessage();
    L6:
        r5.append(r6);
        ALogger.e("GameStickerService", r5.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }
}
