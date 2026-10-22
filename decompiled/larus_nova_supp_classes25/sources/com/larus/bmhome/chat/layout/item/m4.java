package com.larus.bmhome.chat.layout.item;

import android.view.SurfaceHolder;
import com.larus.platform.api.IVideoController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m4 implements SurfaceHolder.Callback {
    public final /* synthetic */ l4 a;

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public m4(l4 r1) {
        this.a = r1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        IVideoController r0 = this.a.A;
        if (r0 == null) goto L6;
        r0.setSurfaceHolder(r2);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        IVideoController r5 = this.a.A;
        if (r5 == null) goto L6;
        r5.setSurfaceHolder(r1);
        return;
    }
}
