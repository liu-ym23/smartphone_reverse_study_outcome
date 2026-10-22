package com.ss.android.lark.message.card;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import jrb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static boolean a(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        if (r2.toLowerCase().startsWith("lark://msgcard/unsupported_action") == false) goto L10;
        d r3 = d.f;
        OPMonitor r0 = jrb.c.a(r3);
        r0.setErrorMessage(((OPMonitorCode) r3).message);
        r0.flush();
        LKUIToast.show(r1, 2131891987);
        return true;
    L10:
        return false;
    }
}
