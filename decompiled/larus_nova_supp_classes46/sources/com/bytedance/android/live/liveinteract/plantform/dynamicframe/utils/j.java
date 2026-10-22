package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.net.Uri;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.livesdk.config.oa0;
import com.bytedance.android.livesdk.config.pa0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    static {
    }

    public static Uri a(String r4, String r5, Long r6, boolean r7, int r8, boolean r9, int r10) {
        if ((r10 & 4) == 0) goto L9;
        Room r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r11 == null) goto L7;
        r6 = Long.valueOf(r11.getRoomId());
        goto L9
    L7:
        r6 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r7 = false;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r8 = -1;
    L15:
        if ((r10 & 32) == 0) goto L17;
        r9 = false;
    L17:
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r4, "url");
        if (r7 == false) goto L24;
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r4, "lynxUrl");
        Uri.Builder r12 = UriProtector.parse(r4).buildUpon();
        w0.a();
        r12.appendQueryParameter("show_from", String.valueOf(r8));
        if (FoldScreenUtils.f() == false) goto L22;
        String r13 = "1";
    L23:
        r12.appendQueryParameter("is_android_fold", r13);
        String r14 = r12.build().toString();
    L25:
        int r15 = c.a;
        String r16 = c.b(r14, r6, r7, "");
        Uri.Builder r17 = UriProtector.parse(r5).buildUpon();
        if (((Boolean) oa0.a.getValue()).booleanValue() == false) goto L29;
        r17.appendQueryParameter("enable_canvas", "1").appendQueryParameter("enable_canvas_optimize", "1").appendQueryParameter("enable_dynamic_v8", "1");
    L40:
        return r17.appendQueryParameter("url", r16).build();
    L29:
        if (w0.e() == false) goto L31;
        r17.appendQueryParameter("thread_strategy", String.valueOf(ThreadStrategyForRendering.MULTI_THREADS.id()));
    L37:
        if (((Boolean) pa0.a.getValue()).booleanValue() == false) goto L40;
        r17.appendQueryParameter("enable_dynamic_v8", "1");
        goto L40
    L31:
        if (r9 == false) goto L34;
        r17.appendQueryParameter("thread_strategy", String.valueOf(ThreadStrategyForRendering.MULTI_THREADS.id()));
        goto L37
    L34:
        if (((Boolean) vm2.h.z6.getValue(null, vm2.h.a[388(0x184, float:5.44E-43)])).booleanValue() == false) goto L37;
        r17.appendQueryParameter("thread_strategy", String.valueOf(ThreadStrategyForRendering.PART_ON_LAYOUT.id()));
        goto L37
    L22:
        r13 = "0";
        goto L23
    L24:
        r14 = c.a(r4, r8, 4);
        goto L25
    }
}
