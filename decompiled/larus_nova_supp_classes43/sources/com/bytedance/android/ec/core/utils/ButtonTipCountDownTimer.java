package com.bytedance.android.ec.core.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ButtonTipCountDownTimer {
    public static final Lazy a = null;

    public static final class a {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ButtonTipCountDownTimer$Companion$INSTANCE$2.INSTANCE);
    }

    public ButtonTipCountDownTimer() {
    }
}
