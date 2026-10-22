package com.obric.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        if (Intrinsics.areEqual(r1, "1") == false) goto L5;
        return r1;
    L5:
        if (Intrinsics.areEqual(r1, RiskPreferenceSettings.SMART_BALANCE) == true) goto L10;
        return "0";
    L10:
        return r1;
    }
}
