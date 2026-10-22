package m7;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import l7.g;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f9297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f9298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9299j;

    public d(int r8) {
        super(r8);
        this.f9297h = new ArrayList();
        this.f9298i = new ArrayList();
        this.f9299j = false;
    }

    public static void d(JSONArray r8, ArrayList r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r8.length()) goto L21;
        String r12 = r8.getString(r11);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r10.add(r12);     // Catch: JSONException -> L13
    L11:
        r11 = r11 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // m7.b
    public final boolean a(Request r8, LinkedHashMap r10) {
        if (this.f9299j == true) goto L67;
        HashSet r11 = this.f9288c;
        if (b.b(r11) == true) goto L12;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        if (g.b(r8.getHost(), (String) r12.next()) == false) goto L9;
    L13:
        boolean r13 = false;
    L14:
        if (r13 == true) goto L16;
        StringBuilder r14 = new StringBuilder("Domain not match: ");
        String r15 = r8.getHost();
    L19:
        r14.append(r15);
        Logger.d("b", r14.toString());
    L48:
        boolean r16 = false;
    L49:
        if (r16 == false) goto L67;
        ArrayList r17 = this.f9297h;
        if (r17.isEmpty() == true) goto L60;
        LinkedHashMap r18 = new LinkedHashMap();
        Iterator r19 = r17.iterator();
    L55:
        if (r19.hasNext() == false) goto L59;
        String r20 = (String) r19.next();
        if (r10.containsKey(r20) == false) goto L55;
        r18.put(r20, r10.get(r20));
        goto L55
    L59:
        r10.clear();
        r10.putAll(r18);
    L66:
        return true;
    L60:
        ArrayList r21 = this.f9298i;
        if (r21.isEmpty() == true) goto L66;
        Iterator r22 = r21.iterator();
    L64:
        if (r22.hasNext() == false) goto L66;
        r10.remove((String) r22.next());
        goto L64
    L16:
        r15 = r8.getPath();
        if (TextUtils.isEmpty(r15) == false) goto L20;
        r14 = new StringBuilder("Path is empty: ");
        goto L19
    L20:
        int r23 = r15.length();
        if (r23 <= 1) goto L25;
        int r24 = r23 - 1;
        if (r15.substring(r24).equals("/") == false) goto L25;
        r15 = r15.substring(0, r24);
    L25:
        HashSet r25 = this.f9289d;
        if (b.b(r25) == false) goto L28;
    L30:
        HashSet r26 = this.f9290e;
        if (b.b(r26) == true) goto L38;
        Iterator r27 = r26.iterator();
    L34:
        if (r27.hasNext() == false) goto L38;
        if (r15.startsWith((String) r27.next()) == false) goto L34;
    L47:
        r16 = true;
    L38:
        HashSet r28 = this.f9291f;
        if (b.b(r28) == true) goto L48;
        Iterator r29 = r28.iterator();
    L42:
        if (r29.hasNext() == false) goto L48;
        Pattern r30 = (Pattern) r29.next();
        if (r30 == null) goto L42;
        if (r30.matcher(r15).matches() == false) goto L42;
    L28:
        if (r25.contains(r15) == false) goto L30;
    L12:
        r13 = true;
    L67:
        return false;
    }
}
