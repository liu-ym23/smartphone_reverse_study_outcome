package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gh.b f6985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6986c;
    public final /* synthetic */ n0 d;

    public /* synthetic */ h(gh.b r5, String r10, n0 r11, int r12) {
        this.f6984a = r12;
        this.f6985b = r5;
        this.f6986c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6984a) {
            case 0: goto L20;
            default: goto L44;
        };
    L20:
        String r5 = this.f6986c;
        boolean r10 = jh.c.e.get();     // Catch: Exception -> L25
        gh.b r11 = this.f6985b;
        String r12 = "";
        if (r10 == true) goto L27;
        r11.accept(new g(""));     // Catch: Exception -> L25
        return;
    L27:
        String r13 = null;
        jh.a r14 = jh.c.m(null, r5);     // Catch: Exception -> L25
        if (r14 == null) goto L37;
        Number r15 = r14.a();     // Catch: Exception -> L25
        String r16 = r14.g();     // Catch: Exception -> L25
        if (r15 == null) goto L37;
        if (r15.longValue() <= System.currentTimeMillis()) goto L37;
        if (TextUtils.isEmpty(r16) == true) goto L37;
        r13 = jh.c.k(r5);     // Catch: Exception -> L25
    L37:
        if (r13 == null) goto L40;
        r12 = r13;
    L40:
        r11.accept(new g(r12));     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        this.d.accept(new PiaMethod$Error("[Cache] PIA Cache Get Content Failed, reason: (" + e.getMessage() + ')'));
        return;
    L44:
        boolean r17 = jh.c.e.get();     // Catch: Exception -> L8
        gh.b r18 = this.f6985b;
        if (r17 == true) goto L10;
        r18.accept(new k(new JsonObject()));     // Catch: Exception -> L8
        return;
    L10:
        JsonObject r19 = null;
        jh.a r20 = jh.c.m(null, this.f6986c);     // Catch: Exception -> L8
        if (r20 == null) goto L14;
        r19 = r20.h();     // Catch: Exception -> L8
    L14:
        if (r19 != null) goto L16;
        r19 = new JsonObject();     // Catch: Exception -> L8
    L16:
        r18.accept(new k(r19));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        this.d.accept(new PiaMethod$Error("[Cache] PIA Cache Get Headers Failed, reason: (" + e.getMessage() + ')'));
    }
}
