package w4;

import android.net.Uri;
import android.util.Pair;
import b7.b;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import e9.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r5.c;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public a() {
    }

    public static ArrayList c(Map r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r8.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.add(new Header((String) r12.getKey(), (String) r12.getValue()));
        goto L7
    L9:
        return r10;
    }

    public static String d(String r8, Map r10) {
        Pair<String, String> r11 = e(r8);
        String r12 = (String) r11.first;
        String r13 = (String) r11.second;
        return ((ICommonApi) d.c(ICommonApi.class, r12)).get(-1, r13, c(r10), false).execute().body();
    }

    public static Pair<String, String> e(String r8) {
        Uri r10 = Uri.parse(r8);
        StringBuilder r11 = new StringBuilder();
        String r12 = r10.getScheme();
        String r13 = r10.getHost();
        int r14 = r10.getPort();
        if (r13 == null) goto L9;
        if (r12 == null) goto L6;
        r11.append(r12);
        r11.append("://");
    L6:
        r11.append(r13);
        if (r14 <= 0) goto L9;
        r11.append(':');
        r11.append(r14);
    L9:
        String r15 = r11.toString();
        String r16 = r10.getPath();
        String r17 = r10.getQuery();
        if (r17 == null) goto L13;
        r16 = defpackage.a.f(r16, "?", r17);
    L13:
        return new Pair(r15, r16);
    }

    @Override // r5.c
    public final String b(String r8, byte[] r10, Map<String, String> r11, c.a r12) {
        Pair<String, String> r13 = e(r8);     // Catch: Exception -> L12
        String r14 = (String) r13.first;     // Catch: Exception -> L12
        String r15 = (String) r13.second;     // Catch: Exception -> L12
        ICommonApi r16 = (ICommonApi) d.c(ICommonApi.class, r14);     // Catch: Exception -> L12
        if (r11 == null) goto L5;
        String r17 = r11.get("Content-Type");     // Catch: Exception -> L12
        r11.remove("Content-Type");     // Catch: Exception -> L12
    L6:
        ArrayList r18 = c(r11);     // Catch: Exception -> L12
        if (r12 == null) goto L9;
        boolean r19 = r12.f11501a;     // Catch: Exception -> L12
    L10:
        return r16.postData(-1, r15, new TypedByteArray(r17, r10, new String[0]), r18, r19).execute().body();
    L9:
        r19 = false;
        goto L10
    L5:
        r17 = null;
    L12:
        e = move-exception;
        if ((e instanceof b) == false) goto L18;
        b r20 = (b) e;
        throw new r5.a(e.getMessage());
    L18:
        throw new r5.a(e.getMessage());
    }

    public final String f(String r8, List r10, c.a r11) {
        Pair<String, String> r12 = e(r8);     // Catch: Exception -> L10
        String r13 = (String) r12.first;     // Catch: Exception -> L10
        String r14 = (String) r12.second;     // Catch: Exception -> L10
        ICommonApi r15 = (ICommonApi) d.c(ICommonApi.class, r13);     // Catch: Exception -> L10
        ArrayList r16 = c(null);     // Catch: Exception -> L10
        LinkedHashMap r17 = new LinkedHashMap();     // Catch: Exception -> L10
        if (r10 == null) goto L8;
        Iterator r18 = r10.iterator();     // Catch: Exception -> L10
    L6:
        if (r18.hasNext() == false) goto L8;
        Pair r19 = (Pair) r18.next();     // Catch: Exception -> L10
        r17.put(r19.first, r19.second);     // Catch: Exception -> L10
    L8:
        return r15.postForm(-1, r14, r17, r16, r11.f11501a).execute().body();
    L10:
        e = move-exception;
        if ((e instanceof b) == false) goto L16;
        b r20 = (b) e;
        throw new r5.a(e.getMessage());
    L16:
        throw new r5.a(e.getMessage());
    }
}
