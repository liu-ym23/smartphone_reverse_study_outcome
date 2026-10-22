package com.larksuite.framework.ui;

import android.app.Activity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static boolean a(Activity r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isDestroyed() == false) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r3.isFinishing() == true) goto L9;
        r4 = true;
        goto L10
    }
}
