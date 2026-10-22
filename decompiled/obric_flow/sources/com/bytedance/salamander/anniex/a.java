package com.bytedance.salamander.anniex;

import com.ss.android.agilelogger.ALog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f7241a;

    public static final String a(SLEventType r5) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        switch(r5.ordinal()) {
            case 0: goto L40;
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L34;
            case 4: goto L32;
            case 5: goto L30;
            case 6: goto L28;
            case 7: goto L26;
            case 8: goto L24;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L18;
            case 12: goto L16;
            case 13: goto L14;
            case 14: goto L12;
            case 15: goto L10;
            case 16: goto L8;
            case 17: goto L6;
            default: goto L5;
        };
    L6:
        return "static_sri";
    L8:
        return "static";
    L10:
        return "ajax";
    L12:
        return "res_loader_error_template";
    L14:
        return "res_loader_error";
    L16:
        return "res_loader_perf_template";
    L18:
        return "res_loader_perf";
    L20:
        return "resource_performance";
    L22:
        return "container_error";
    L24:
        return "native_error";
    L26:
        return "jsb_pv";
    L28:
        return "blank";
    L30:
        return "performance";
    L32:
        return "js_exception";
    L34:
        return "jsb_perf";
    L36:
        return "jsb_error";
    L38:
        return "fetch_error";
    L40:
        return "navigation_start";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void b(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ALog.d(r5, r10);
    }
}
