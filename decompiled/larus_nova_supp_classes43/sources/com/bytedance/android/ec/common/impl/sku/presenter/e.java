package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.utils.ActivityCountDownTimer;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<T> implements Observer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void onChanged(Object r1) {
        Boolean r10 = (Boolean) r1;
        if (r10 == null) goto L8;
        r10.booleanValue();
        if (r10.booleanValue() == false) goto L9;
        Lazy r11 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().b();
        return;
    L9:
        return;
    }
}
