package com.larus.dora.impl.guide;

import android.app.Application;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a() {
        if (com.larus.dora.impl.util.h0.b("https://audioaccessory.com.cn/ios/qr_code/index.html") == false) goto L6;
        g49.d.d("GuideRouter", "open hw smart audio download page success");
        DoraBuryPointManager.a.O(true);
        return;
    L6:
        t19.s r0 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r0.getClass();
        t19.s.b(r2, 2131903850, false);
        g49.d.b("GuideRouter", "open hw smart audio download page failed");
    }

    public static void b(String r3, ActivityResultLauncher r4) {
        Intrinsics.checkNotNullParameter(r3, "mac");
        Intrinsics.checkNotNullParameter(r4, "launcher");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r5 = String.format("smartaudio://controlpage/head?mac=%s", Arrays.copyOf(new Object[]{r3}, 1));
        Intent r1 = new Intent("android.intent.action.VIEW");
        r1.setData(UriProtector.parse(r5));
        r1.addFlags(67108864);
        if (r1.resolveActivity(AppHost.a.getApplication().getPackageManager()) == null) goto L6;
        r4.launch(r1);
        DoraBuryPointManager.a.O(false);
        g49.d.d("GuideRouter", "open hw smart audio head control page with launcher success");
        return;
    L6:
        a();
    }
}
