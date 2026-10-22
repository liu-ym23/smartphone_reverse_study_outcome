package com.ss.android.account;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class c {
    public c() {
    }

    public boolean a(hb7.b r4) {
        Activity r0 = com.bytedance.sdk.account.utils.d.b();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isFinishing() == false) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        hb7.c r1 = new hb7.c(r0);
        r1.a = r4;
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r1);
        return true;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L13:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return true;
    L14:
        new Handler(Looper.getMainLooper()).post(new a(r0, r4));
        return true;
    }
}
