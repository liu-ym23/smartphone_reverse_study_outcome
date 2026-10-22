package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r10) {
        long r11 = r10 / 1000;
        long r2 = r11 / 3600;
        long r0 = (r11 % 3600) / 60;
        long r12 = r11 % 60;
        if (r2 <= 0) goto L5;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2), Long.valueOf(r0), Long.valueOf(r12)}, 3));
    L5:
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r0), Long.valueOf(r12)}, 2));
    }
}
