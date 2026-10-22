package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends ActionRateListener {
    public final Function0<Unit> j;

    public static void j(c r10, int r11) {
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        r10.k(r11, "", r10.b);
    }

    public c(String r10, String r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r12, "fullFill");
        super(r10, r11, r12);
        this.j = r12;
    }

    public final void k(int r10, String r11, JSONObject r12) {
        boolean r1 = false;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        if (r10 != (-1)) goto L12;
        r11 = "接口请求失败";
    L10:
        String r13 = r11;
        Set<String> r14 = ECProcessMonitor.a;
        ECProcessMonitor.m(this, this.g, this.h, Integer.valueOf(r10), r13, r12, this.c);
        this.j.invoke();
        return;
    L12:
        if (r11.length() != 0) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L20;
        if (r10 != (-2)) goto L20;
        r11 = "schema为空";
    L20:
        if (r11.length() != 0) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L10;
        if (r10 != (-3)) goto L10;
        r11 = "法务检查失败";
        goto L10
    L14:
        r15 = false;
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    public final void l(int r10, String r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        JSONObject r0 = x0.a(this.b);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        Iterator<Map.Entry<String, ? extends Object>> r13 = r12.entrySet().iterator();     // Catch: Throwable -> L15
    L7:
        if (r13.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r14 = r13.next();     // Catch: Throwable -> L15
        if (r14.getValue() == null) goto L7;
        r0.put(r14.getKey(), r14.getValue());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r15);     // Catch: Throwable -> L15
    L17:
        k(r10, r11, r0);
        return;
    L12:
        r15 = null;
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
