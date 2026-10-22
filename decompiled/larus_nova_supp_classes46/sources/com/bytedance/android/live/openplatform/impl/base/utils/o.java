package com.bytedance.android.live.openplatform.impl.base.utils;

import android.os.SystemClock;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements Consumer<Throwable> {
    public final Function0<Unit> a;

    public o(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        CustomApiServerException r12 = (Throwable) r11;
        if ((r12 instanceof ApiServerException) == false) goto L34;
        String r0 = ((ApiServerException) r12).getPrompt();
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L12:
        if ((!r3) == true) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L24;
        long r5 = SystemClock.uptimeMillis();
        if ((true ^ Intrinsics.areEqual(r0, p.a)) == false) goto L19;
    L20:
        p.a = r0;
        p.b = r5;
        f2.c(r0, 0);
        Function0<Unit> r1 = this.a;
        if (r1 == null) goto L24;
        Unit r2 = (Unit) r1.invoke();
        goto L24
    L19:
        if ((r5 - p.b) >= 3500) goto L20;
    L24:
        if ((r12 instanceof CustomApiServerException) == false) goto L35;
        int r4 = qo0.a.a;
        StringBuilder r6 = new StringBuilder("url: ");
        CustomApiServerException r13 = r12;
        String r7 = r13.getUrl();
        String r8 = "null";
        if (r7 != null) goto L28;
        r7 = "null";
    L28:
        r6.append(r7);
        r6.append(", logId: ");
        String r14 = r13.getXTtLogId();
        if (r14 == null) goto L32;
        r8 = r14;
    L32:
        r6.append(r8);
        qo0.a.b("ApiErrorHandler", r6.toString(), null);
        return;
    L35:
        return;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r3 = false;
        goto L12
    }
}
