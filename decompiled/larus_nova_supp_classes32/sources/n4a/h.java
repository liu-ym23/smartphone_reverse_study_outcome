package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements x4.c {
    public final i a;

    public h() {
        this.a = new i();
    }

    public final Map<String, String> c() {
        i r0 = this.a;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        String r3 = null;
        if (i.g == false) goto L10;
        monitor-exit(r0);
        return null;
    L10:
        i.g = true;     // Catch: Throwable -> L16
        HashMap r2 = new HashMap();     // Catch: Throwable -> L16
        r2.put(f5.o("FZW50"), f5.o("FMg"));     // Catch: Throwable -> L16
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L16
        r4.append(f5.o("SY2hhbm5lbD0"));     // Catch: Throwable -> L16
        String r5 = i.c;     // Catch: Throwable -> L16
        r4.append(r5);     // Catch: Throwable -> L16
        r4.append(f5.o("SJmRpdj0"));     // Catch: Throwable -> L16
        String r6 = i.e;     // Catch: Throwable -> L16
        r4.append(r6);     // Catch: Throwable -> L16
        StringBuffer r7 = new StringBuffer();     // Catch: Throwable -> L16
        r7.append(r5);     // Catch: Throwable -> L16
        r7.append(r6);     // Catch: Throwable -> L16
        r7.append(f5.o("FQA"));     // Catch: Throwable -> L16
        r7.append(i.d);     // Catch: Throwable -> L16
        String r8 = r7.toString();     // Catch: Throwable -> L16
        byte[] r9 = k.a;     // Catch: Throwable -> L16
        String r10 = b5.a(r8);     // Catch: Throwable -> L16
        r4.append(f5.o("FJnNpZ249"));     // Catch: Throwable -> L16
        r4.append(r10.toUpperCase(Locale.US));     // Catch: Throwable -> L16
        r4.append(f5.o("SJm91dHB1dD1qc29u").concat("\u0000"));     // Catch: Throwable -> L16
        byte[] r1 = g0.a(r4.toString().getBytes(), i.b.getBytes());     // Catch: Throwable -> L16
        String r11 = f5.o("FaW4");     // Catch: Throwable -> L16
        r3 = f.a(r1, r1.length);     // Catch: IOException -> L19 Throwable -> L16
    L12:
        r2.put(r11, r3);     // Catch: Throwable -> L16
        r2.put(f5.o("Sa2V5dA"), i.f);     // Catch: Throwable -> L16
        monitor-exit(r0);
        return r2;
    }

    public final String b(String r6) {
        i r1 = this.a;
        r1.getClass();
        JSONObject r2 = new JSONObject();
        r2.put(f5.o("LdGlk"), r6);     // Catch: Throwable -> L5
        r2.put(f5.o("FZGl1"), NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L5
        r2.put(f5.o("AZGl1Mg"), NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L5
        r2.put(f5.o("EZGl1Mw"), NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L5
    L7:
        String r7 = r2.toString();
        if (TextUtils.isEmpty(r7) == true) goto L48;
        byte[] r0 = k.a;
        SecureRandom r3 = new SecureRandom();
        KeyGenerator r4 = KeyGenerator.getInstance(f5.o("EQUVT"));     // Catch: Throwable -> L13
        r4.init(LynxTouchEvent.kPseudoStateFocusTransition, r3);     // Catch: Throwable -> L13
        byte[] r5 = r4.generateKey().getEncoded();     // Catch: Throwable -> L13
        byte[] r8 = f.a;     // Catch: Throwable -> L13
        String r9 = f.a(r5, r5.length);
    L15:
        if (TextUtils.isEmpty(r9) == true) goto L46;
        byte[] r10 = g0.a((r7 + "\u0000").getBytes(), r9.getBytes());
        String r11 = f.a(r10, r10.length);     // Catch: IOException -> L19
    L21:
        if (TextUtils.isEmpty(r11) == true) goto L47;
        PublicKey r12 = j.a(r1.a());     // Catch: Throwable -> L31
        byte[] r13 = r9.getBytes("utf-8");     // Catch: Throwable -> L31
        Cipher r14 = Cipher.getInstance(f5.o("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L25
        r14.init(1, r12);     // Catch: Throwable -> L25
        byte[] r15 = r14.doFinal(r13);     // Catch: Throwable -> L25
    L36:
        String r16 = f.a(r15, r15.length);     // Catch: IOException -> L28 Throwable -> L31
    L29:
        return f5.o("Fa2V5PQ") + URLEncoder.encode(r16) + f5.o("SJmRhdGE9") + URLEncoder.encode(r11);
    L28:
        r16 = null;
    L25:
        r15 = null;
    L31:
        th = move-exception;
        th.printStackTrace();
        return null;
    L47:
        return null;
    L19:
        r11 = null;
        goto L21
    L46:
        return null;
    L13:
        r9 = null;
        goto L15
    L48:
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public final String a(Context r4, String r5) {
        JSONObject r0 = new JSONObject(r5);     // Catch: JSONException -> L20
        if (r0.optInt(f5.o("UY29kZQ")) != 1) goto L22;
        String r6 = new JSONObject(r0.optString(f5.o("FZGF0YQ"))).optString(f5.o("FYWRpdQ"));     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r6) == true) goto L22;
        d r7 = d.a(r4);     // Catch: JSONException -> L20
        Context r1 = r7.a;     // Catch: JSONException -> L20
        if (e.d == null) goto L9;
    L18:
        e r2 = e.d;     // Catch: JSONException -> L20
        r2.a = r7.b;     // Catch: JSONException -> L20
        e.a(r7.a).b(r6, 273);     // Catch: JSONException -> L20
        return r6;
    L9:
        monitor-enter(e.class);     // Catch: JSONException -> L20
    L15:
        th = move-exception;
        throw th;     // Catch: JSONException -> L20
    L11:
        if (e.d != null) goto L13;
        e.d = new e(r1);     // Catch: Throwable -> L15
    L13:
        monitor-exit(e.class);     // Catch: Throwable -> L15
    L22:
        return NameKeys.UnloadStrategy_No_Strategy;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
