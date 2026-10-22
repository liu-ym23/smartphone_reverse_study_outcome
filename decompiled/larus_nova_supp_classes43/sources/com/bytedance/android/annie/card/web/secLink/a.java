package com.bytedance.android.annie.card.web.secLink;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.ng.g;
import com.larus.apm.impl.protector.RunnableProtector;
import k9.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import o8.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public a(String r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        String r1 = this.a;
        String r10 = this.b;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
        int r12 = x8.a.a;     // Catch: Throwable -> L15
        x8.a.b("LiveSecLinkManager", "hint secLink mode " + LiveSecLinkManager.a(), false);     // Catch: Throwable -> L15
        j9.b r13 = ((e) Annie.getService$default(e.class, null, 2, null)).H0();     // Catch: Throwable -> L15
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L15
        if (r1 == null) goto L6;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_URL, r1);     // Catch: Throwable -> L15
    L6:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L15
        com.bytedance.android.annie.ng.a r16 = g.c.get(r10);     // Catch: Throwable -> L15
        if (r16 == null) goto L12;
        f r17 = r16.b;     // Catch: Throwable -> L15
        if (r17 == null) goto L12;
        String r18 = r17.a;     // Catch: Throwable -> L15
        if (r18 == null) goto L12;
    L13:
        r15.put("virtual_aid", r18);     // Catch: Throwable -> L15
        j9.b.a.a(r13, null, "ttlive_hybrid_unsafe_domain", null, r14, null, null, r15, 0, 256);     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L12:
        r18 = "host";
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
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
