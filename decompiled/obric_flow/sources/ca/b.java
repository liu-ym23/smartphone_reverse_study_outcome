package ca;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.client.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1150k;

    @Override // ca.c
    public final boolean a(Request r10, LinkedHashMap r11) {
        boolean r5 = false;
        if (this.f1149j == false) goto L5;
    L58:
        return r5;
    L5:
        if (b(r10) == false) goto L58;
        if (this.f1150k == false) goto L10;
        r10.setBodyEncryptEnabled(true);
        r5 = true;
    L10:
        ArrayList r12 = this.f1148i;
        if (r12.isEmpty() == true) goto L58;
        if (r11.containsKey("x-tt-encrypt-queries") == true) goto L58;
        LinkedList r13 = new LinkedList();
        Iterator r14 = r12.iterator();
    L17:
        if (r14.hasNext() == false) goto L22;
        String r15 = (String) r14.next();
        if (r11.containsKey(r15) == false) goto L17;
        r13.add(new Pair(r15, r11.get(r15)));
        goto L17
    L22:
        if (r13.isEmpty() == false) goto L24;
        return r5;
    L24:
        StringBuilder r16 = new StringBuilder();
        Iterator r17 = r13.iterator();
    L26:
        if (r17.hasNext() == false) goto L38;
        Pair r18 = (Pair) r17.next();
        String r19 = (String) r18.first;
        List r20 = (List) r18.second;
        if (r20 == null) goto L26;
        if (r20.size() <= 0) goto L26;
        Iterator r21 = r20.iterator();
    L33:
        if (r21.hasNext() == false) goto L26;
        String r22 = (String) r21.next();
        if (r16.length() <= 0) goto L37;
        r16.append("&");
    L37:
        r16.append(r19);
        r16.append("=");
        r16.append(r22);
        goto L33
    L38:
        String r23 = r16.toString();
        if (TextUtils.isEmpty(r23) == false) goto L59;
        return r5;
    L59:
        byte[] r24 = r23.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L43
    L45:
        if (r24 != null) goto L47;
        return r5;
    L47:
        byte[] r25 = EncryptorUtil.a(r24.length, r24);
        if (r25 != null) goto L50;
        return r5;
    L50:
        String r26 = Base64.encodeToString(r25, 2);
        if (Logger.debug() == false) goto L53;
        Logger.d("b", "encryptBytes:" + r25 + " , encryptString:" + r26);
    L53:
        LinkedList r27 = new LinkedList();
        r27.add(r26);
        r10.setQueryEncryptEnabled(true);
        r11.put("x-tt-encrypt-queries", r27);
        Iterator r28 = r12.iterator();
    L55:
        if (r28.hasNext() == false) goto L57;
        r11.remove((String) r28.next());
        goto L55
    L57:
        return true;
    L43:
        e = move-exception;
        e.printStackTrace();
        r24 = null;
        goto L45
    }

    @Override // ca.c
    public final void c(JSONObject r5) {
        d(r5);
        JSONArray r10 = r5.optJSONArray("encrypt_query_list");
        ArrayList r11 = this.f1148i;
        e.d(r10, r11);
        boolean r12 = false;
        if (r5.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r12 = true;
    L5:
        this.f1150k = r12;
        if (r11.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.f1150k == true) goto L12;
        this.f1149j = true;
        return;
    }
}
