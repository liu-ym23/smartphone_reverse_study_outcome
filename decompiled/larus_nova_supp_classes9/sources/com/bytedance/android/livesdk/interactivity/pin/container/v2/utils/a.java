package com.bytedance.android.livesdk.interactivity.pin.container.v2.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(l r9, Throwable r10, long r11, String r13, Room r14) {
        Intrinsics.checkNotNullParameter(r9, "event");
        a("request_unpin", r9.a, r10, r11, r13, r14, String.valueOf(r9.c));
    }

    public static void b(String r1, PinType r2, long r3, String r5, Room r6, String r7) {
        LiveMonitor.a r8 = InteractivityMonitor.a(InteractivityMonitor.Event.PinRequest, r6, r7);
        r8.l(0);
        r8.m("success");
        r8.e("request_type", r1);
        r8.e("pin_type", r2.getDesc());
        r8.h(System.currentTimeMillis() - r3);
        if (r5 != null) goto L5;
        r5 = "0";
    L5:
        r8.i("log_id", r5);
        r8.a().report();
    }

    public static void a(String r1, PinType r2, Throwable r3, long r4, String r6, Room r7, String r8) {
        LiveMonitor.a r9 = InteractivityMonitor.a(InteractivityMonitor.Event.PinRequest, r7, r8);
        if ((r3 instanceof ApiServerException) == false) goto L5;
        int r10 = ((ApiServerException) r3).getErrorCode();
    L6:
        r9.l(r10);
        if (r3 != null) goto L10;
        String r5 = CardLockInfo.sUNKNOWN;
    L13:
        r9.m(r5);
        r9.e("request_type", r1);
        r9.e("pin_type", r2.getDesc());
        r9.h(System.currentTimeMillis() - r4);
        if (r6 != null) goto L16;
        r6 = "0";
    L16:
        r9.i("log_id", r6);
        r9.a().report();
        return;
    L10:
        if ((r3 instanceof ApiServerException) == false) goto L12;
        r5 = "api error";
        goto L13
    L12:
        r5 = "local error";
        goto L13
    L5:
        r10 = 999;
        goto L6
    }
}
