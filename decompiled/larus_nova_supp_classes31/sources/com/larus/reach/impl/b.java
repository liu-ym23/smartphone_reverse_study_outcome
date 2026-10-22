package com.larus.reach.impl;

import android.os.SystemClock;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachClickTarget;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ns9.d;
import ns9.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final ConcurrentHashMap<String, Long> a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ReachClickTarget.values().length];
            r0[ReachClickTarget.CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[ReachClickTarget.BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L32:
            r0[ReachClickTarget.CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L7:
            a = r0;
            int[] r1 = new int[ReachButtonType.values().length];
            r1[ReachButtonType.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[ReachButtonType.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L10:
            b = r1;
            int[] r2 = new int[ReachPosition.values().length];
            r2[ReachPosition.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L28:
            r2[ReachPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L13:
            c = r2;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static JSONObject a(ns9.t r5) {
        String r0 = r5.e.a.get("tracking_info");
        String r1 = null;
        if (r0 != null) goto L5;
    L18:
        JSONObject r2 = new JSONObject();
    L19:
        int r3 = a.c[r5.b.b().ordinal()];
        if (r3 != 1) goto L22;
        String r4 = "top";
    L27:
        r2.put("position", r4);
        r2.put("push_scene", r5.a.c);
        String r6 = r5.a.a;
        if (r6 != null) goto L30;
    L34:
        r6 = r5.a.h;
    L35:
        r2.put("push_id", r6);
        String r7 = r5.a.d;
        if (r7 != null) goto L38;
    L42:
        return r2;
    L38:
        if ((true ^ StringsKt.isBlank(r7)) == false) goto L40;
        r1 = r7;
    L40:
        if (r1 == null) goto L42;
        r2.put("template_id", r1);
        goto L42
    L30:
        if ((!StringsKt.isBlank(r6)) == true) goto L33;
        r6 = null;
    L33:
        if (r6 != null) goto L35;
    L22:
        if (r3 != 2) goto L25;
        r4 = "bottom";
        goto L27
    L25:
        throw new NoWhenBranchMatchedException();
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L18;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(new JSONObject(r0));     // Catch: Throwable -> L12
    L14:
        JSONObject r10 = new JSONObject();
        if (Result.isFailure-impl(r9) == false) goto L17;
        r9 = r10;
    L17:
        r2 = (JSONObject) r9;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static void e(ns9.t r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        if (c.a(r4) == true) goto L5;
        return;
    L5:
        a.put(r4.a.h, Long.valueOf(SystemClock.uptimeMillis()));
        com.larus.platform.service.o.a.reportEvent("inapp_push_show", a(r4));
    }

    public static void d(ns9.t r2, ReachRejectReason r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        if (c.a(r2) == true) goto L5;
        return;
    L5:
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r4 = a(r2);
        r4.put("discard_reason", r3.getDiscardReason());
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("inapp_push_discard", r4);
    }

    public static void b(JSONObject r2, boolean r3, String r4) {
        if (r3 == false) goto L4;
        String r0 = "success";
    L5:
        r2.put("result", r0);
        if (r3 == true) goto L16;
        if (r4 != null) goto L9;
    L13:
        r4 = "system_error";
    L14:
        r2.put("fail_reason", r4);
        return;
    L9:
        if ((!StringsKt.isBlank(r4)) == true) goto L12;
        r4 = null;
    L12:
        if (r4 != null) goto L14;
    L16:
        return;
    L4:
        r0 = "fail";
        goto L5
    }

    public static void c(ns9.t r6, e r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "click");
        if (c.a(r6) == false) goto L28;
        int r2 = a.a[r7.a.ordinal()];
        if (r2 != 1) goto L7;
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r4 = a(r6);
        b(r4, r8, r9);
        Unit r5 = Unit.INSTANCE;
        r3.reportEvent("inapp_push_click_result", r4);
        goto L28
    L7:
        if (r2 != 2) goto L9;
    L13:
        d r10 = r7.b;
        if (r10 == null) goto L24;
        ReachButtonType r11 = r10.getType();
        if (r11 == null) goto L24;
        int r12 = a.b[r11.ordinal()];
        if (r12 == 1) goto L23;
        if (r12 != 2) goto L22;
        String r13 = "close";
    L25:
        if (r13 == null) goto L28;
        com.larus.platform.service.o r14 = com.larus.platform.service.o.a;
        JSONObject r15 = a(r6);
        r15.put("button_type", r13);
        b(r15, r8, r9);
        Unit r16 = Unit.INSTANCE;
        r14.reportEvent("inapp_push_click_button_result", r15);
        goto L28
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        r13 = "normal";
    L24:
        r13 = null;
        goto L25
    L9:
        if (r2 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    L28:
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r17 = com.larus.reach.runtime.y.a;
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "click");
        Iterator r0 = com.larus.reach.runtime.y.h(r6.a.c).iterator();
    L30:
        if (r0.hasNext() == false) goto L39;
        ReachSceneLifecycleListener r1 = (ReachSceneLifecycleListener) r0.next();
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L34
        r1.c(r6, r7, r8, r9);     // Catch: Throwable -> L34
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L30;
        FLogger.a.w("ReachSceneDispatcher", "reach scene onClickResult failed, reachUniqueId=" + r6.a.h + ", scene=" + r6.a.c, r20);
    L34:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    }
}
