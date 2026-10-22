package kw1;

import am2.j;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.log.filter.g;
import com.bytedance.android.livesdk.log.filter.j0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Intent r2) {
        Bundle r3 = r2.getExtras();
        if (r3 == null) goto L10;
        Bundle r4 = r3.getBundle("live_play_params");
        if (r4 == null) goto L10;
        Bundle r5 = m0.a(r4);
        if (r5 == null) goto L10;
        return r5.getString("gd_label", "");
    L10:
        return "";
    }

    public static void b(Context r3, Bundle r4) {
        if ((r3 instanceof Activity) == false) goto L15;
        if (r4 == null) goto L16;
        Intent r5 = ((Activity) r3).getIntent();
        if (r5 != null) goto L8;
        return;
    L8:
        String r1 = r5.getStringExtra("gd_label");
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = a(r5);
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r4.putString("gd_label", r1);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static void c(Map r3, Context r4) {
        if ((r4 instanceof Activity) == false) goto L14;
        Intent r5 = ((Activity) r4).getIntent();
        if (r5 != null) goto L7;
        return;
    L7:
        String r1 = r5.getStringExtra("gd_label");
        if (TextUtils.isEmpty(r1) == false) goto L11;
        r1 = a(r5);
    L11:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        ((HashMap) r3).put("gd_label", r1);
        return;
    L15:
        return;
    }

    public static void d(String r6, Map r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L9:
        if (r7 != null) goto L11;
        r7 = new HashMap();
    L11:
        r7.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r7.put("_param_live_platform", "live");
        j.a().getClass();
        String r1 = "1";
        if (j.d == false) goto L14;
        Object r0 = "1";
    L15:
        r7.put("is_first_start", r0);
        j.a r2 = j.a().a;
        if (r2 != null) goto L18;
        String r3 = "";
    L19:
        r7.put("definition", r3);
        j.b r4 = j.a().c;
        int r5 = -1;
        if (r4 != null) goto L22;
        int r8 = -1;
    L23:
        r7.put("downstream_throughput_kbps", String.valueOf(r8));
        j.c r9 = j.a().b;
        if (r9 == null) goto L27;
        r5 = r9.getNetQuality();
    L27:
        r7.put("net_quality", String.valueOf(r5));
        r7.put("fold_state", FoldScreenUtils.a() + "");
        if (FoldScreenUtils.f() == true) goto L31;
        r1 = "0";
    L31:
        r7.put("is_fold", r1);
        g.b.L9(r6, r7);
        j0.a.L9(r6, r7);
        LiveFeedContext.hostService().log().logV3(r6, r7);
        return;
    L22:
        r8 = r4.a();
        goto L23
    L18:
        r3 = r2.getDefinition();
        goto L19
    L14:
        r0 = "0";
        goto L15
    L5:
        if (r6.startsWith("livesdk_") == true) goto L9;
        if ("live_enter".equals(r6) == true) goto L9;
        r6 = "livesdk_".concat(r6);
        goto L9
    }
}
