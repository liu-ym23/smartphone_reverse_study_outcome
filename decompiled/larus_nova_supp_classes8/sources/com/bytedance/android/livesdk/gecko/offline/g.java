package com.bytedance.android.livesdk.gecko.offline;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.core.setting.s1;
import com.bytedance.android.live.core.setting.t1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.gecko.LiveGeckoConfig;
import java.io.File;
import jc1.k;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static String a() {
        IMiddleWareHostContext r0 = k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L9;
        if (r0.isBoe() == false) goto L9;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L9:
        if (v.a() == false) goto L12;
        return "36723dc3e85a23e701d1697d57de07ed";
    L12:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    }

    public static String b() {
        IHostWebView r0 = k.f(IHostWebView.class);
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getHostGeckoCacheDir();
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L26;
        Lazy r3 = LiveGeckoConfig.a;
        String r4 = (String) s1.a.getValue();
        if (TextUtils.isEmpty(r4) == true) goto L11;
        StringBuilder r5 = new StringBuilder();
        Application r6 = jc1.a.b();
        if (r6 == null) goto L25;
        File r7 = r6.getFilesDir();
        if (r7 == null) goto L25;
        r1 = r7.getAbsolutePath();
    L25:
        r5.append(r1);
        r5.append(File.separator);
        r5.append(r4);
        return r5.toString();
    L11:
        if (((Boolean) t1.a.getValue()).booleanValue() == false) goto L13;
        String r8 = "offlineX/5fb33cde3ebff01c8433ddc22aac0816";
    L14:
        StringBuilder r9 = new StringBuilder();
        Application r10 = jc1.a.b();
        if (r10 == null) goto L19;
        File r11 = r10.getFilesDir();
        if (r11 == null) goto L19;
        r1 = r11.getAbsolutePath();
    L19:
        r9.append(r1);
        r9.append(File.separator);
        r9.append(r8);
        return r9.toString();
    L13:
        r8 = "live_sdk_gecko";
        goto L14
    L26:
        Intrinsics.checkNotNull(r2);
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    static {
    }
}
