package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements Runnable {
    public final /* synthetic */ OGCFixedInputDialog a;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r4, Outline r5) {
            if (r4 == null) goto L5;
            int r2 = r4.getWidth();
        L6:
            if (r4 == null) goto L8;
            int r6 = r4.getHeight();
        L9:
            Rect r0 = new Rect(0, 0, r2, r6);
            if (r5 == null) goto L13;
            r5.setRoundRect(r0, UtilityKotlinExtentionsKt.h(12));
            return;
        L13:
            return;
        L8:
            r6 = 0;
            goto L9
        L5:
            r2 = 0;
            goto L6
        }
    }

    public m(OGCFixedInputDialog r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.v;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.setOutlineProvider(new a());     // Catch: Throwable -> L9
    L5:
        View r1 = this.a.v;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.setClipToOutline(true);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
