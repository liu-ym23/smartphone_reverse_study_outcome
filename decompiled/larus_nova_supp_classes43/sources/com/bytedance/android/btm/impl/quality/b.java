package com.bytedance.android.btm.impl.quality;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.setting.f;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final f a = null;

    public b() {
    }

    static {
        f r0 = BtmSetting.d.c().c().i();
        a = r0;
        final String r1 = "config switch:" + r0.b() + " error_codes:" + r0.a();
        ALogger.d.b("QualityCenter", false, new QualityCenter$log$1(r1));
    }

    public static void a(final int r10, final String r11, final Map r12) {
        if (a.b() != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        final String r13 = "";
        Function0<Unit> r1 = new QualityCenter$sendErrorCodeData$1(r11, r10, r13, r12);
        BtmSDK.INSTANCE.getThreadExecutor().b(new a(r1), true);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void b(final int r10, final String r11, final JSONObject r12) {
        f r0 = a;
        if (r0.b() != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        return;
    L9:
        if (r0.a().contains(Integer.valueOf(r10)) == false) goto L14;
        final String r13 = "";
        Function0<Unit> r14 = new QualityCenter$sendErrorCodeData$2(r11, r10, r13, r12);
        BtmSDK.INSTANCE.getThreadExecutor().b(new a(r14), true);
        return;
    L14:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
