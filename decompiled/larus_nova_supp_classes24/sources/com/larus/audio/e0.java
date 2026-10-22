package com.larus.audio;

import android.os.Build;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        String r0 = Build.MANUFACTURER;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r0.toUpperCase(Locale.getDefault()), "HONOR", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
