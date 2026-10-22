package com.ss.android.token;

import android.text.TextUtils;
import com.bytedance.sdk.account.settings.common.a;
import com.bytedance.sdk.account.settings.common.b;
import com.bytedance.sdk.account.utils.j;
import com.ss.android.account.PassportExtraHeaderManager;
import com.ss.android.account.k;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ TokenFactory a;

    public /* synthetic */ u(TokenFactory r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TokenFactory r0 = this.a;
        PassportExtraHeaderManager r2 = r0.v;
        r2.getClass();
        b.a();
        String r8 = "";
        if (b.b == true) goto L5;
        String r3 = "";
    L16:
        PassportExtraHeaderManager r4 = r0.v;
        r4.getClass();
        b.a();
        if (b.b == false) goto L32;
        b.a();
        if (b.f <= 0) goto L32;
        r4.h();
        StringBuffer r9 = new StringBuffer();
        b.a();
        Iterator r10 = b.c.c.iterator();
    L23:
        if (r10.hasNext() == false) goto L31;
        String r11 = (String) r10.next();
        if (r9.length() <= 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        r9.append(",");
    L30:
        r9.append(r11);
        r9.append("=");
        r9.append(!TextUtils.isEmpty(r4.b().getString(r11, "")) ? 1 : 0);
        goto L23
    L27:
        r12 = false;
        goto L28
    L31:
        r8 = r9.toString();
    L32:
        String r5 = com.bytedance.sdk.account.utils.r.b(r0.h.a, "sessionid");
        r0.d.getClass();
        e0 r7 = r.e();
        String r13 = r7.a;
        String r14 = r7.b;
        if (TextUtils.isEmpty(r13) == false) goto L35;
    L39:
        boolean r15 = false;
    L40:
        boolean r16 = ((ta7.f) r0.o.a()).isLogin();
        boolean r6 = !TextUtils.isEmpty(r5);
        r0.d.getClass();
        boolean r17 = r.k;
        boolean r18 = !TextUtils.isEmpty(r14);
        sa7.i.b();
        boolean r19 = !TextUtils.isEmpty(sa7.i.c);
        String r110 = k.d().S();
        String r111 = com.bytedance.sdk.account.utils.r.b(r110, "passport_csrf_token");
        if (TextUtils.isEmpty(r111) == false) goto L43;
        r111 = com.bytedance.sdk.account.utils.r.b(r110, "passport_csrf_token_default");
    L43:
        boolean r112 = !TextUtils.isEmpty(r111);
        String r113 = "none";
        if (r19 == false) goto L47;
        if (r112 == false) goto L47;
        String r114 = "both";
    L52:
        long r115 = ((ta7.f) r0.o.a()).getUserId();
        a.a();
        boolean r1 = a.U;
        a.a();
        boolean r116 = a.V;
        HashSet<String> r117 = TTTokenMonitor.b;
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L91
        if (r16 == false) goto L56;
        int r118 = 1;
    L57:
        r20.put("is_login", r118);     // Catch: Throwable -> L91
        if (r6 == false) goto L60;
        int r21 = 1;
    L61:
        r20.put("sessionid", r21);     // Catch: Throwable -> L91
        if (r17 == false) goto L64;
        r113 = "default";
    L64:
        r20.put("xtttoken_location", r113);     // Catch: Throwable -> L91
        if (r18 == false) goto L67;
        int r22 = 1;
    L68:
        r20.put("has_tssign", r22);     // Catch: Throwable -> L91
        r20.put("csrf_token_location", r114);     // Catch: Throwable -> L91
        r20.put("extra_headers", r3);     // Catch: Throwable -> L91
        r20.put("backup_extra_headers", r8);     // Catch: Throwable -> L91
        r20.put("uid", String.valueOf(r115));     // Catch: Throwable -> L91
        if (r15 == false) goto L71;
        int r23 = 1;
    L72:
        r20.put("token_contains_sessionid", r23);     // Catch: Throwable -> L91
        if ((!TextUtils.isEmpty(r7.f)) == false) goto L75;
        int r24 = 1;
    L76:
        r20.put("encrypt_token_valid", r24);     // Catch: Throwable -> L91
        if (r1 == false) goto L79;
        int r25 = 1;
    L80:
        r20.put("is_encrypt_open", r25);     // Catch: Throwable -> L91
        if (r116 == false) goto L83;
        int r26 = 1;
    L84:
        r20.put("is_plaintext_close", r26);     // Catch: Throwable -> L91
        r20.put("token_tlb_tag", !TextUtils.isEmpty(r7.g) ? 1 : 0);     // Catch: Throwable -> L91
        r20.put("is_login_v2", r7.h);     // Catch: Throwable -> L91
        j<TicketTrackData> r27 = r7.d;     // Catch: Throwable -> L91
        if (r27 != null) goto L87;
    L89:
        TTTokenMonitor.r("passport_load_login_token", r20);     // Catch: Throwable -> L91
        return;
    L87:
        if (r27.getData() == null) goto L89;
        r20.put("token_update_time", ((TicketTrackData) r27.getData()).h);     // Catch: Throwable -> L91
        r20.put("token_update_app_version", ((TicketTrackData) r27.getData()).i);     // Catch: Throwable -> L91
        goto L89
    L83:
        r26 = 0;
        goto L84
    L79:
        r25 = 0;
        goto L80
    L75:
        r24 = 0;
        goto L76
    L71:
        r23 = 0;
        goto L72
    L67:
        r22 = 0;
        goto L68
    L60:
        r21 = 0;
        goto L61
    L56:
        r118 = 0;
    L91:
        th = move-exception;
        tb7.a.c("TTTokenMonitor", "eventLoadToken error", th);
        return;
    L47:
        if (r19 == false) goto L49;
        r114 = "sp";
        goto L52
    L49:
        if (r112 == false) goto L51;
        r114 = "cookie";
        goto L52
    L51:
        r114 = "none";
        goto L52
    L35:
        if (TextUtils.isEmpty(r5) == true) goto L39;
        if (r13.contains(r5) == false) goto L39;
        r15 = true;
        goto L40
    L5:
        r2.h();
        StringBuffer r28 = new StringBuffer();
        b.a();
        Iterator r29 = b.c.c.iterator();
    L7:
        if (r29.hasNext() == false) goto L15;
        String r119 = (String) r29.next();
        if (r28.length() <= 0) goto L11;
        boolean r120 = true;
    L12:
        if (r120 == false) goto L14;
        r28.append(",");
    L14:
        r28.append(r119);
        r28.append("=");
        r28.append(r2.a.containsKey(r119) ? 1 : 0);
        goto L7
    L11:
        r120 = false;
        goto L12
    L15:
        r3 = r28.toString();
        goto L16
    }
}
