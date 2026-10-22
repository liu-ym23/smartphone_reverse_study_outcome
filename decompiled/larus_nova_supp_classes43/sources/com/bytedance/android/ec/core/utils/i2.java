package com.bytedance.android.ec.core.utils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r10) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        TimeUnit r11 = TimeUnit.MILLISECONDS;
        return String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r11.toMinutes(r10) - TimeUnit.HOURS.toMinutes(r11.toHours(r10))), Long.valueOf(r11.toSeconds(r10) - TimeUnit.MINUTES.toSeconds(r11.toMinutes(r10)))}, 2));
    }
}
