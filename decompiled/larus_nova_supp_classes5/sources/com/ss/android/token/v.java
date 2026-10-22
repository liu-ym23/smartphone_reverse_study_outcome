package com.ss.android.token;

import android.text.TextUtils;
import com.ss.android.ShowDialogActivity;
import java.util.ArrayList;
import org.json.JSONObject;
import ua7.b;
import xa7.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v extends va7.h {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ TokenFactory g;

    public final void onSuccess(b r7) {
        l r8 = (l) r7;
        this.g.a = false;     // Catch: Exception -> L5
        this.g.j.sendEmptyMessageDelayed(1000, this.g.h.g);     // Catch: Exception -> L5
        this.g.getClass();     // Catch: Exception -> L5
    L7:
        TokenFactory.a(this.g, this.a, this.b, this.c, this.d, TTTokenMonitor.SessionExpiredHandleResult.ignore);
        return;
    L5:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L7
    }

    public v(TokenFactory r1, String r2) {
        this.g = r1;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = r2;
        this.f = null;
    }

    public final void onError(b r7, int r8) {
        l r9 = (l) r7;
        this.g.a = false;     // Catch: Exception -> L24
        this.g.getClass();     // Catch: Exception -> L24
        String r1 = r9.p;     // Catch: Exception -> L24
        String r3 = ((b) r9).a;     // Catch: Exception -> L24
        TTTokenMonitor.SessionExpiredHandleResult r4 = TTTokenMonitor.SessionExpiredHandleResult.ignore;     // Catch: Exception -> L24
        if ("session_expired".equalsIgnoreCase(r1) == false) goto L10;
        r4 = TTTokenMonitor.SessionExpiredHandleResult.logout;     // Catch: Exception -> L24
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r10.add(new o("X-TT-LOGID", r3));     // Catch: Exception -> L24
    L8:
        TokenFactory r11 = this.g;     // Catch: Exception -> L24
        r11.w(this.e, r10, ((ta7.f) r11.o.a()).isLogin(), this.f);     // Catch: Exception -> L24
    L22:
        TokenFactory.a(this.g, this.a, this.b, this.c, this.d, r4);     // Catch: Exception -> L24
        this.g.j.sendEmptyMessageDelayed(1000, this.g.h.g);     // Catch: Exception -> L24
        return;
    L10:
        if (r8 != 400) goto L12;
        ShowDialogActivity.a(this.g.i, "token sdk status error", "SDK self-check failed:" + ((b) r9).i + ";please check network interceptor work fine");     // Catch: Exception -> L24
        goto L22
    L12:
        String r0 = ((b) r9).j;     // Catch: Exception -> L24
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        TTTokenMonitor.k(((b) r9).g, r0);     // Catch: Exception -> L24
        if (this.g.t != null) goto L20;
        this.g.t = new JSONObject();     // Catch: Exception -> L24
        this.g.t.put("error_code", r8);     // Catch: Exception -> L24
        this.g.t.put("error_detail_msg", r0);     // Catch: Exception -> L24
    L20:
        if ("Not Found".equalsIgnoreCase(r0) == false) goto L22;
        this.g.q = false;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        TTTokenMonitor.d(e);
    }
}
