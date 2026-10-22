package com.bytedance.android.annie.service.network;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ LinkedHashMap<String, String> b;
    public final /* synthetic */ j c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ int e;

    public o(String r1, LinkedHashMap<String, String> r10, j r11, Integer r12, int r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a() {
        String r0 = "";
        String r1 = this.a;
        LinkedHashMap<String, String> r10 = this.b;
        j r11 = this.c;
        Integer r12 = this.d;
        int r13 = this.e;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L36
        Unit r15 = null;
        JSONObject r16 = new JSONObject(r1);     // Catch: Throwable -> L7
        r1 = null;
        th = null;
        String r17 = null;
    L14:
        boolean r18 = false;
        if (r17 != null) goto L17;
    L22:
        if (r18 == true) goto L27;
        if (th != null) goto L27;
        if (r1 != null) goto L27;
        r11.a(r16, r10, r12, r13);     // Catch: Throwable -> L36
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L34:
        Object r19 = Result.constructor-impl(r15);     // Catch: Throwable -> L36
    L38:
        j r20 = this.c;
        LinkedHashMap<String, String> r21 = this.b;
        Integer r22 = this.d;
        int r23 = this.e;
        Throwable r24 = Result.exceptionOrNull-impl(r19);
        if (r24 == null) goto L47;
        r20.b(new JSONObject(), r21, "", r24, r22, r23);
        return;
    L47:
        return;
    L27:
        if (r1 == null) goto L30;
        r0 = r1;
    L30:
        if (th != null) goto L32;
        Throwable r25 = new Throwable(r17);     // Catch: Throwable -> L36
    L33:
        r11.b(r16, r10, r0, r25, r12, r13);     // Catch: Throwable -> L36
        goto L34
    L32:
        r25 = th;
        goto L33
    L17:
        if (r17.length() <= 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 != true) goto L22;
        r18 = true;
        goto L22
    L19:
        r110 = false;
        goto L20
    L7:
        th = th;
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L36
        n.a.getClass();     // Catch: Throwable -> L36
        if (r10.containsKey("x-tt-logid") == false) goto L12;
        String r111 = r10.get("x-tt-logid");     // Catch: Throwable -> L36
        if (r111 == null) goto L12;
    L13:
        r16 = r26.put("_Header_RequestID", r111);     // Catch: Throwable -> L36
        r17 = th.getClass().toString() + ':' + th.getMessage();     // Catch: Throwable -> L36
    L12:
        r111 = "";
    L36:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
