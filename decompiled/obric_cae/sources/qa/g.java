package qa;

import android.content.Context;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Locale;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g implements k4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f10442a;

    public g() {
        this.f10442a = new h();
    }

    public final String a(Context r8, String r10) {
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L44
        if (r11.optInt(t4.n("UY29kZQ")) != 1) goto L46;
        String r12 = new JSONObject(r11.optString(t4.n("FZGF0YQ"))).optString(t4.n("FYWRpdQ"));     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(r12) == true) goto L46;
        if (c.f10249c == null) goto L9;
    L18:
        c r13 = c.f10249c;     // Catch: JSONException -> L44
        Context r14 = r13.f10250a;     // Catch: JSONException -> L44
        if (e.f10335d == null) goto L21;
    L30:
        e r15 = e.f10335d;     // Catch: JSONException -> L44
        r15.f10336a = r13.f10251b;     // Catch: JSONException -> L44
        if (r15 == null) goto L33;
    L42:
        e.f10335d.a(273, r12);     // Catch: JSONException -> L44
        return r12;
    L33:
        monitor-enter(e.class);     // Catch: JSONException -> L44
    L39:
        th = move-exception;
        throw th;     // Catch: JSONException -> L44
    L35:
        if (e.f10335d != null) goto L37;
        e.f10335d = new e(r14);     // Catch: Throwable -> L39
    L37:
        monitor-exit(e.class);     // Catch: Throwable -> L39
    L21:
        monitor-enter(e.class);     // Catch: JSONException -> L44
    L27:
        th = move-exception;
        throw th;     // Catch: JSONException -> L44
    L23:
        if (e.f10335d != null) goto L25;
        e.f10335d = new e(r14);     // Catch: Throwable -> L27
    L25:
        monitor-exit(e.class);     // Catch: Throwable -> L27
    L9:
        monitor-enter(c.class);     // Catch: JSONException -> L44
    L15:
        th = move-exception;
        throw th;     // Catch: JSONException -> L44
    L11:
        if (c.f10249c != null) goto L13;
        c.f10249c = new c(r8);     // Catch: Throwable -> L15
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
    L46:
        return "";
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    }

    public final String b(String r8) {
        h r10 = this.f10442a;
        r10.getClass();
        JSONObject r11 = new JSONObject();
        r11.put(t4.n("LdGlk"), r8);     // Catch: Throwable -> L5
        r11.put(t4.n("FZGl1"), "");     // Catch: Throwable -> L5
        r11.put(t4.n("AZGl1Mg"), "");     // Catch: Throwable -> L5
        r11.put(t4.n("EZGl1Mw"), "");     // Catch: Throwable -> L5
    L7:
        String r12 = r11.toString();
        if (TextUtils.isEmpty(r12) == true) goto L31;
        String r13 = i.c();
        if (TextUtils.isEmpty(r13) == true) goto L29;
        String r14 = defpackage.c.i(defpackage.c.l((r12 + "\u0000").getBytes(), r13.getBytes()));
        if (TextUtils.isEmpty(r14) == true) goto L30;
        PublicKey r15 = l6.a.k(r10.a());     // Catch: Throwable -> L20
        byte[] r16 = r13.getBytes("utf-8");     // Catch: Throwable -> L20
        Cipher r17 = Cipher.getInstance(t4.n("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L17
        r17.init(1, r15);     // Catch: Throwable -> L17
        byte[] r18 = r17.doFinal(r16);     // Catch: Throwable -> L17
    L18:
        return t4.n("Fa2V5PQ") + URLEncoder.encode(defpackage.c.i(r18)) + t4.n("SJmRhdGE9") + URLEncoder.encode(r14);
    L17:
        r18 = null;
    L20:
        th = move-exception;
        th.printStackTrace();
        return null;
    L30:
        return null;
    L29:
        return null;
    L31:
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public final HashMap c() {
        h r8 = this.f10442a;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (h.f10491g == false) goto L9;
        monitor-exit(r8);
        return null;
    L9:
        h.f10491g = true;     // Catch: Throwable -> L13
        HashMap r10 = new HashMap();     // Catch: Throwable -> L13
        r10.put(t4.n("FZW50"), t4.n("FMg"));     // Catch: Throwable -> L13
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L13
        r11.append(t4.n("SY2hhbm5lbD0"));     // Catch: Throwable -> L13
        String r12 = h.f10487c;     // Catch: Throwable -> L13
        r11.append(r12);     // Catch: Throwable -> L13
        r11.append(t4.n("SJmRpdj0"));     // Catch: Throwable -> L13
        String r13 = h.f10489e;     // Catch: Throwable -> L13
        r11.append(r13);     // Catch: Throwable -> L13
        StringBuffer r14 = new StringBuffer();     // Catch: Throwable -> L13
        r14.append(r12);     // Catch: Throwable -> L13
        r14.append(r13);     // Catch: Throwable -> L13
        r14.append(t4.n("FQA"));     // Catch: Throwable -> L13
        r14.append(h.f10488d);     // Catch: Throwable -> L13
        String r15 = l6.a.j(r14.toString());     // Catch: Throwable -> L13
        r11.append(t4.n("FJnNpZ249"));     // Catch: Throwable -> L13
        r11.append(r15.toUpperCase(Locale.US));     // Catch: Throwable -> L13
        r11.append(t4.n("SJm91dHB1dD1qc29u").concat("\u0000"));     // Catch: Throwable -> L13
        byte[] r16 = defpackage.c.l(r11.toString().getBytes(), h.f10486b.getBytes());     // Catch: Throwable -> L13
        r10.put(t4.n("FaW4"), defpackage.c.i(r16));     // Catch: Throwable -> L13
        r10.put(t4.n("Sa2V5dA"), h.f10490f);     // Catch: Throwable -> L13
        monitor-exit(r8);
        return r10;
    }
}
