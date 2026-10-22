package m;

import android.text.TextUtils;
import android.util.Log;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.a;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f19902c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f19904b;

    static {
        f19902c = "Mi_R_".concat(q.class.getSimpleName());
    }

    public static ArrayList a(String r11, ArrayList r12) {
        ArrayList r5 = new ArrayList();
        int r10 = 0;
    L4:
        if (r10 >= r12.size()) goto L32;
        ArrayList r13 = (ArrayList) r12.get(r10);
        int r14 = 0;
    L7:
        if (r14 >= r5.size()) goto L30;
        ArrayList r15 = (ArrayList) r5.get(r14);
        HashMap r16 = b(r13);
        HashMap r17 = b(r15);
        if (r16.keySet().equals(r17.keySet()) == false) goto L23;
        Iterator r18 = r16.keySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L24;
        String r19 = (String) r18.next();
        if (r19.equals(r11) == true) goto L20;
        if (r17.containsKey(r19) == false) goto L23;
    L20:
        if (r19.equals(r11) == true) goto L13;
        if (Objects.equals(r16.get(r19), r17.get(r19)) == true) goto L13;
    L24:
        String r20 = ((String) b(r15).get(r11)) + "," + ((String) b(r13).get(r11));
        Iterator r21 = r15.iterator();
    L26:
        if (r21.hasNext() == false) goto L31;
        p r22 = (p) r21.next();
        if (r22.f19900a.equals(r11) == false) goto L26;
        r22.f19901b = r20;
    L31:
        r10 = r10 + 1;
    L23:
        r14 = r14 + 1;
        goto L7
    L30:
        r5.add(r13);
        goto L31
    L32:
        return r5;
    }

    public static HashMap b(ArrayList r5) {
        HashMap r10 = new HashMap();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        p r12 = (p) r11.next();
        r10.put(r12.f19900a, r12.f19901b);
        goto L4
    L6:
        return r10;
    }

    public static void d(ArrayList r5, HashMap r10, HashMap r11) {
        Iterator r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        p r13 = (p) r12.next();
        String r14 = (String) r11.get(r13.f19900a);
        if (TextUtils.isEmpty(r14) == true) goto L4;
        r10.put(r14, r13.f19901b);
        goto L4
    }

    public final void c() {
        String r5 = f19902c;
        int r10 = 0;
    L4:
        if (r10 >= this.f19904b.size()) goto L44;
        ArrayList r11 = (ArrayList) this.f19904b.get(r10);
        p r12 = null;
        int r13 = 0;
        String r14 = "";
        String r15 = r14;
        String r16 = r15;
    L7:
        if (r13 >= r11.size()) goto L29;
        p r17 = (p) r11.get(r13);
        String r18 = r17.f19900a;
        r18.getClass();
        byte r19 = -1;
        switch(r18.hashCode()) {
            case 641101284: goto L20;
            case 641104480: goto L16;
            case 1123220569: goto L12;
            default: goto L23;
        };
    L23:
        switch(r19) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            default: goto L28;
        };
    L25:
        r16 = r17.f19901b;
        r12 = r17;
        goto L28
    L26:
        r14 = r17.f19901b;
        goto L28
    L27:
        r15 = r17.f19901b;
    L28:
        r13 = r13 + 1;
        goto L7
    L12:
        if (r18.equals("退房日期") == false) goto L23;
        r19 = 2;
        goto L23
    L16:
        if (r18.equals("入住晚数") == false) goto L23;
        r19 = 1;
        goto L23
    L20:
        if (r18.equals("入住日期") == false) goto L23;
        r19 = 0;
        goto L23
    L29:
        if (r14 == null) goto L32;
        r14 = r14.replaceAll("[\\u4e00-\\u9fa5]", "");
    L32:
        if (TextUtils.isEmpty(r15) == true) goto L43;
        if (TextUtils.isEmpty(r16) == false) goto L43;
        if (TextUtils.isEmpty(r14) == true) goto L43;
        DateTimeFormatter r20 = DateTimeFormatter.ofPattern("yyyy-MM-dd");     // Catch: Exception -> L41
        String r21 = LocalDate.parse(r15, r20).plusDays(Integer.parseInt(r14)).format(r20);     // Catch: Exception -> L41
        if (r12 == null) goto L43;
        Log.d(r5, "mergeHotelDay. endItem.value=" + r21);     // Catch: Exception -> L41
        r12.f19901b = r21;     // Catch: Exception -> L41
    L41:
        e = move-exception;
        a.m(e, "mergeHotelDay. e=", r5);
    L43:
        r10 = r10 + 1;
        goto L4
    }
}
