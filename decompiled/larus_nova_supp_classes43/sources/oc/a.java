package oc;

import android.util.Log;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Throwable r10) {
        String r11 = Log.getStackTraceString(r10);
        int r0 = RangesKt.coerceAtMost(r11.length(), BtmSetting.d.c().c().d());
        if (r0 > 0) goto L5;
        return "";
    L5:
        return r11.substring(0, r0);
    }
}
