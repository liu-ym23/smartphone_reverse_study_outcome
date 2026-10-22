package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ BaseGuestLinkMainPageDialog b;
    public final /* synthetic */ Ref.FloatRef c;

    public a(View r1, BaseGuestLinkMainPageDialog r2, Ref.FloatRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        float r0 = this.a.getMeasuredWidth() - (this.a.getPaddingLeft() + this.a.getPaddingRight());
        float r1 = r0 / this.c.element;
        ALogger.d("BaseGuestLinkMainPageDialog", "initPageBackground, mClipStrategy info, playContainerWidth: " + r0 + ", playContainerHeight: " + r1 + ", sx: " + (this.a.getX() + this.a.getPaddingLeft()) + ", sy: " + this.a.getY());
        View r2 = this.b.f;
        if (r2 == null) goto L5;
        a1.k(r2, (int) r1);
    L5:
        this.b.A = new vi0.a(this.a.getX() + this.a.getPaddingLeft(), this.a.getY(), r0, r1);
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
