package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.graphics.Path;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ui.ClipImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ BaseGuestLinkMainPageDialog a;
    public final /* synthetic */ HSImageView b;

    public d(BaseGuestLinkMainPageDialog r1, HSImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.a.T90() != null) goto L5;
        return;
    L5:
        Path r0 = new Path();
        com.bytedance.android.live.base.model.message.guestlink.a r1 = this.a.T90();
        Intrinsics.checkNotNull(r1);
        if (BaseGuestLinkMainPageDialog.W90(BaseGuestLinkMainPageDialog.U90(r1)) == false) goto L12;
        vi0.a r2 = this.a.A;
        if (r2 == null) goto L10;
        Path r3 = r2.c(0, 0.0f, 0.0f);
    L11:
        r0.addPath(r3);
        goto L12
    L10:
        r3 = new Path();
    L12:
        com.bytedance.android.live.base.model.message.guestlink.a r4 = this.a.T90();
        Intrinsics.checkNotNull(r4);
        if (BaseGuestLinkMainPageDialog.W90(BaseGuestLinkMainPageDialog.V90(r4)) == false) goto L19;
        vi0.a r5 = this.a.A;
        if (r5 == null) goto L17;
        Path r6 = r5.c(1, 0.0f, 0.0f);
    L18:
        r0.addPath(r6);
        goto L19
    L17:
        r6 = new Path();
    L19:
        HSImageView r7 = this.b;
        if ((r7 instanceof ClipImageView) == true) goto L22;
        r7 = null;
    L22:
        ClipImageView r8 = (ClipImageView) r7;
        if (r8 == null) goto L26;
        r8.setMClipPath(r0);
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
