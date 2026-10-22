package com.bytedance.android.live.broadcast;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements IHostPlugin.Callback {
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final a d = null;

    public a() {
    }

    public final void onCancel(String r1) {
    }

    static {
        d = new a();
    }

    public final void onSuccess(String r2) {
        if (b == false) goto L5;
        return;
    L5:
        f2.b(2131915102, 0);
        b = true;
    }
}
