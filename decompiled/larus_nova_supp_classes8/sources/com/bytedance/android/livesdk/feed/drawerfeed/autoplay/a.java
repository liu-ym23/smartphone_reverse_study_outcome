package com.bytedance.android.livesdk.feed.drawerfeed.autoplay;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ DrawerFeedPreviewHelper.b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ uv1.a c;

    public a(DrawerFeedPreviewHelper.b r1, int r2, uv1.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        this.a.a.c();
        int r0 = this.a.a.a();
        if (r0 >= 0) goto L6;
        return;
    L6:
        if (this.b == 0) goto L8;
    L10:
        RecyclerView.ViewHolder r1 = this.a.b.findViewHolderForAdapterPosition(r0);
        if ((r1 instanceof an2.a) == true) goto L13;
        r1 = null;
    L13:
        an2.a r2 = (an2.a) r1;
        if (r2 != null) goto L16;
    L18:
        int[] r3 = {r0};
        this.a.a.a = r3;
        return;
    L16:
        if (r2.t7() == false) goto L18;
        r2.play();
        goto L18
    L8:
        if (this.c.a == false) goto L10;
        r0 = r0 + 1;
        goto L10
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
