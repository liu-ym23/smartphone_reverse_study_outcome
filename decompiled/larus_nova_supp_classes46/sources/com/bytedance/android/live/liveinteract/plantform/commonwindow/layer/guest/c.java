package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final void a() {
        d r0 = this.a;
        int r1 = com.bytedance.android.live.liveinteract.videotalk.utils.d.a;
        int r2 = r0.q().getWidth();
        int r3 = this.a.q().getHeight();
        this.a.q().getWidth();
        this.a.q().getHeight();
        r0.v = com.bytedance.android.live.liveinteract.videotalk.utils.d.a(r2, r3, this.a.w);
        d r4 = this.a;
        MultiLinkGuestViewBinder.a r5 = r4.e;
        if (r5 == null) goto L5;
        List<Integer> r6 = r5.o;
    L6:
        HSImageView r7 = r4.f;
        if (r7 == null) goto L10;
        r7.post(new e(r4, r6));
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
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
