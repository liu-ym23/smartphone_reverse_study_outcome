package w4;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f13358a;

    private b() {
    }

    public static b a() {
        if (f13358a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13358a != null) goto L9;
        f13358a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f13358a;
    }

    public void b(ArrayList<String> r27, String r28) {
        String r10 = "GET";
        String r11 = "x-tt-tnc-abtest";
        String r12 = "x-tt-tnc-config";
        if (r27 != null) goto L5;
        return;
    L5:
        if (r27.isEmpty() == true) goto L131;
        Context r13 = TTNetInit.getTTNetDepend().getContext();
        if (r13 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("CronetRetryEventHandler", "start get-domain request.");
    L13:
        Iterator<String> r14 = r27.iterator();
    L15:
        if (r14.hasNext() == false) goto L132;
        String r15 = r14.next();
        a5.a r16 = new a5.a();     // Catch: Throwable -> L99
        r16.f102b = true;     // Catch: Throwable -> L99
        r16.f103c = false;     // Catch: Throwable -> L99
        j r17 = new j(r15);     // Catch: Throwable -> L99
        r17.b("tnc_src", "7");     // Catch: Throwable -> L99
        String r18 = r17.toString();     // Catch: Throwable -> L99
        HashMap r19 = new HashMap();     // Catch: Throwable -> L99
        HashMap r110 = new HashMap();     // Catch: Throwable -> L99
        if (TextUtils.isEmpty(r28) == true) goto L24;
        r110.put("x-tt-tnc-summary", r28);     // Catch: Throwable -> L97
    L97:
        th = th;
    L101:
        String r23 = r10;
        String r25 = r11;
        String r24 = r12;
    L102:
        th.printStackTrace();
        r10 = r23;
        r12 = r24;
        r11 = r25;
    L24:
        if (TNCManager.m().y(r10, r18, r110, "") == false) goto L25;
        String r111 = a5.c.a(r18, r110, r19, r16);     // Catch: Throwable -> L97
        if (Logger.debug() == false) goto L30;
        Logger.d("CronetRetryEventHandler", "response: " + r111);     // Catch: Throwable -> L97
    L30:
        if (TNCManager.m().z(r10, r18, r19, r111) == false) goto L31;
        if (com.bytedance.common.utility.g.b(r111) == true) goto L15;
        if ("success".equals(new JSONObject(r111).getString("message")) == false) goto L15;
        if (r19.get("x-ss-etag") != null) goto L41;
    L43:
        String r20 = "";
    L45:
        if (r19.get("x-ss-canary") != null) goto L47;
    L49:
        String r112 = "";
    L51:
        if (r19.get(r12) != null) goto L53;
        r23 = r10;
    L58:
        String r21 = "";
    L60:
        if (r19.get(r11) != null) goto L110;
        r24 = r12;
    L69:
        String r22 = "";
    L71:
        if (r19.get("x-tt-tnc-control") == null) goto L77;
        r25 = r11;
    L84:
        th = th;
    L108:
        th.printStackTrace();     // Catch: Throwable -> L95
        return;
    L95:
        th = th;
        goto L102
    L75:
        if (TextUtils.isEmpty((CharSequence) ((List) r19.get("x-tt-tnc-control")).get(0)) == true) goto L78;
        String r26 = (String) ((List) r19.get("x-tt-tnc-control")).get(0);     // Catch: Throwable -> L84
    L80:
        if (Logger.debug() == false) goto L82;
        Logger.d("CronetRetryEventHandler", "tnc verion: " + r20 + " canary: " + r112 + " configid: " + r21 + " abtest: " + r22);     // Catch: Throwable -> L84
    L82:
        i.w(r13).C(r20, r112, r21, r22, r26, r111);     // Catch: Throwable -> L84
        return;
    L78:
        r26 = "";
    L86:
        th = th;
    L87:
        r25 = r11;
        goto L108
    L77:
        r25 = r11;
        goto L78
    L110:
        r24 = r12;
        if (TextUtils.isEmpty((CharSequence) ((List) r19.get(r11)).get(0)) == true) goto L69;
        r22 = (String) ((List) r19.get(r11)).get(0);     // Catch: Throwable -> L86
    L66:
        th = th;
        r24 = r12;
        goto L87
    L53:
        r23 = r10;
        if (TextUtils.isEmpty((CharSequence) ((List) r19.get(r12)).get(0)) == true) goto L58;
        r21 = (String) ((List) r19.get(r12)).get(0);     // Catch: Throwable -> L88
    L88:
        th = th;
    L92:
        r25 = r11;
        r24 = r12;
        goto L108
    L47:
        if (TextUtils.isEmpty((CharSequence) ((List) r19.get("x-ss-canary")).get(0)) == true) goto L49;
        r112 = (String) ((List) r19.get("x-ss-canary")).get(0);     // Catch: Throwable -> L90
        goto L51
    L41:
        if (TextUtils.isEmpty((CharSequence) ((List) r19.get("x-ss-etag")).get(0)) == true) goto L43;
        r20 = (String) ((List) r19.get("x-ss-etag")).get(0);     // Catch: Throwable -> L90
    L90:
        th = th;
        r23 = r10;
        goto L92
    L31:
        return;
    L25:
        return;
    L99:
        th = th;
        goto L101
    L132:
        return;
    }
}
