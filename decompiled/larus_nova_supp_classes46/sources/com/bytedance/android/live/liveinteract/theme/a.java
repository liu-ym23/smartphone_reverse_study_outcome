package com.bytedance.android.live.liveinteract.theme;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final String a(int r2, String r3) {
        Intrinsics.checkNotNullParameter("play", "scene");
        return r2 + "13play13" + r3;
    }

    public static boolean c(int r3, String r4) {
        Intrinsics.checkNotNullParameter("play", "scene");
        if (TextUtils.isEmpty(r4) == true) goto L14;
        Map r0 = (Map) b6.o0.getValue();
        if (r0 == null) goto L10;
        Double r5 = (Double) r0.get(a(r3, r4));
        if (r5 == null) goto L10;
        double r6 = r5.doubleValue();
    L12:
        if (r6 >= 2.0d) goto L14;
        return true;
    L10:
        r6 = 0.0d;
    L14:
        return false;
    }

    public static final void b(int r4, String r5, double r6) {
        Intrinsics.checkNotNullParameter("play", "scene");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        e r0 = b6.o0;
        Map r1 = (Map) r0.getValue();
        String r7 = a(r4, r5);
        Double r8 = (Double) r1.get(r7);
        if (r8 == null) goto L8;
        double r2 = r8.doubleValue();
    L9:
        r1.put(r7, Double.valueOf(r2 + r6));
        f.d(r0, r1);
        return;
    L8:
        r2 = 0.0d;
        goto L9
    }
}
