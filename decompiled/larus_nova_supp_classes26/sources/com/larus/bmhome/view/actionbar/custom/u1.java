package com.larus.bmhome.view.actionbar.custom;

import android.graphics.Color;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u1 {
    public static final Integer a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Integer.valueOf(Color.parseColor(r3));
    L5:
        FLogger.a.e("CustomActionBarNormalHolder", " to color fail:" + r3);
        return null;
    }
}
