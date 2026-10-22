package com.larus.voicecall.impl.component.feedback;

import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final List<String> a;
    public final List<String> b;
    public final List<String> c;
    public String d;
    public String e;

    public final Map<String, String> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        boolean r2 = true;
        Object r4 = null;
        if ((!((ArrayList) this.a).isEmpty()) == false) goto L20;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Lazy r3 = com.larus.utils.gson.b.a;     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl(com.larus.utils.gson.b.a(this.a));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r5) == false) goto L11;
        r5 = null;
    L11:
        String r6 = (String) r5;
        if (r6 == null) goto L20;
        if (r6.length() <= 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L20;
        r0.put("call_error_details", r6);
        goto L20
    L16:
        r7 = false;
    L6:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        if ((!((ArrayList) this.b).isEmpty()) == false) goto L37;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        Lazy r10 = com.larus.utils.gson.b.a;     // Catch: Throwable -> L23
        Object r11 = Result.constructor-impl(com.larus.utils.gson.b.a(this.b));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r11) == false) goto L28;
        r11 = null;
    L28:
        String r12 = (String) r11;
        if (r12 == null) goto L37;
        if (r12.length() <= 0) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L37;
        r0.put("call_type_trace", r12);
        goto L37
    L33:
        r13 = false;
    L23:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L37:
        if ((!((ArrayList) this.c).isEmpty()) == false) goto L55;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L40
        Lazy r16 = com.larus.utils.gson.b.a;     // Catch: Throwable -> L40
        Object r17 = Result.constructor-impl(com.larus.utils.gson.b.a(this.c));     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r17) == true) goto L46;
        r4 = r17;
    L46:
        String r18 = (String) r4;
        if (r18 == null) goto L55;
        if (r18.length() <= 0) goto L51;
        boolean r19 = true;
    L52:
        if (r19 == false) goto L55;
        r0.put("room_id", r18);
        goto L55
    L51:
        r19 = false;
    L40:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        if (this.d.length() <= 0) goto L57;
        boolean r21 = true;
    L58:
        if (r21 == false) goto L61;
        r0.put("log_id", this.d);
    L61:
        if (this.e.length() > 0) goto L64;
        r2 = false;
    L64:
        if (r2 == false) goto L66;
        r0.put("task_id", this.e);
    L66:
        r0.put("device_type", "android");
        return r0;
    L57:
        r21 = false;
        goto L58
    }

    public c() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = NameKeys.UnloadStrategy_No_Strategy;
        this.e = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void a(CallTypeTrace r2) {
        Intrinsics.checkNotNullParameter(r2, "callTypeTrace");
        List<String> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(r2.getCallType());
    }
}
