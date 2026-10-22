package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.graphics.Path;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.ui.ClipImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ List b;

    public e(d r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ClipImageView r1 = null;
        if (ListUtils.isEmpty(this.b) == false) goto L14;
        ClipImageView r0 = this.a.f;
        if ((r0 instanceof ClipImageView) == false) goto L8;
        r1 = r0;
    L8:
        ClipImageView r2 = r1;
        if (r2 == null) goto L34;
        Path r3 = r2.getMClipPath();
        if (r3 == null) goto L35;
        r3.reset();
        return;
    L35:
        return;
    L34:
        return;
    L14:
        if (this.b == null) goto L37;
        Path r4 = new Path();
        Iterator r5 = this.b.iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        int r6 = ((Number) r5.next()).intValue();
        com.bytedance.android.live.liveinteract.videotalk.utils.c r7 = this.a.v;
        if (r7 == null) goto L21;
        Path r8 = r7.a(r6, 0.0f, 0.0f);
    L22:
        r4.addPath(r8);
        goto L17
    L21:
        r8 = new Path();
        goto L22
    L23:
        ClipImageView r9 = this.a.f;
        if ((r9 instanceof ClipImageView) == false) goto L27;
        r1 = r9;
    L27:
        ClipImageView r10 = r1;
        if (r10 == null) goto L38;
        r10.setMClipPath(r4);
        return;
    L38:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
