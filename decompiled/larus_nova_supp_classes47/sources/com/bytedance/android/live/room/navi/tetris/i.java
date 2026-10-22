package com.bytedance.android.live.room.navi.tetris;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.view.EllipsizedScrollTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements Runnable {
    public final /* synthetic */ AudienceRoomNavigatorTetris a;

    public i(AudienceRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final void a() {
        if (this.a.t != null) goto L5;
        return;
    L5:
        int r1 = 0;
        int r0 = s1.f(12.0f) + 0;
        TextView r2 = this.a.C;
        if (r2 != null) goto L8;
    L9:
        r0 = r0 + s1.f(39.0f);
    L10:
        TextView r3 = this.a.B;
        if (r3 != null) goto L13;
    L14:
        int r4 = r0 + s1.f(4.0f);
        TextView r5 = this.a.B;
        if (r5 == null) goto L17;
        int r6 = r5.getWidth();
    L18:
        r0 = r4 + r6;
    L19:
        int r7 = r0 + s1.f(33.0f);
        AudienceRoomNavigatorTetris r8 = this.a;
        EllipsizedScrollTextView r9 = r8.z;
        if (r9 == null) goto L26;
        View r10 = r8.t;
        if (r10 == null) goto L24;
        r1 = r10.getWidth();
    L24:
        r9.setMaxWidth(Math.max(r1 - r7, s1.f(130.0f)));
        return;
    L26:
        return;
    L17:
        r6 = 0;
        goto L18
    L13:
        if (r3.getVisibility() == 8) goto L19;
    L8:
        if (r2.getVisibility() == 8) goto L10;
        goto L9
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
