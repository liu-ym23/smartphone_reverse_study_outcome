package com.bytedance.badger.z;

import android.os.Build;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class l extends Lambda implements Function0 {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
        super(0);
    }

    public Object invoke() {
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return "";
    L7:
        return Build.SOC_MODEL;
    }
}
