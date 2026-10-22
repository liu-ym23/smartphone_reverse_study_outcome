package l7;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.client.Header;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f9155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f9156b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f9157c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f9158d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile ArrayList f9159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile ArrayList f9160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f9161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile ArrayList f9162h;

    static {
        f9159e = new ArrayList();
        f9160f = new ArrayList();
        f9161g = false;
        f9162h = new ArrayList();
    }

    public static String a(Context r8) {
        InputStream r10 = r8.getAssets().open("ttnet_config.json");     // Catch: Throwable -> L9
        byte[] r11 = new byte[r10.available()];     // Catch: Throwable -> L17
        r10.read(r11);     // Catch: Throwable -> L17
        String r12 = new String(r11, "UTF-8");     // Catch: Throwable -> L17
        r10.close();     // Catch: IOException -> L7
        return r12;
    L7:
        e = move-exception;
        e.printStackTrace();
        return r12;
    L10:
        if (r10 != null) goto L18;
    L15:
        return "";
    L18:
        r10.close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        r10 = null;
        goto L10
    }

    public static boolean b(Context r8) {
        String r10 = r8.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r10) == true) goto L14;
        if (new File(r10 + "/ttnet_boe.flag").exists() == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L14:
        return false;
    }

    public static String c(Context r8, String r10, List<Header> r11) {
        boolean r12 = true;
        if (f9161g == true) goto L22;
        if (f9157c == true) goto L22;
        String r13 = a(r8);
        if (TextUtils.isEmpty(r13) == false) goto L128;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == false) goto L16;
    L19:
        boolean r15 = true;
    L20:
        f9157c = r15;
        f9161g = true;
        goto L22
    L16:
        if (b(r8) == true) goto L19;
        r15 = false;
        goto L20
    L128:
        if (new JSONObject(r13).optBoolean("boe_proxy_enabled", false) == false) goto L13;
        r14 = true;
    L11:
        th = move-exception;
        th.printStackTrace();
    L22:
        if (f9157c == true) goto L24;
        return r10;
    L24:
        if (TextUtils.isEmpty(f9155a) == true) goto L26;
    L28:
        Uri r16 = Uri.parse(r10);
        if (r5.f.b(r16.getScheme()) == false) goto L31;
        return r10;
    L31:
        if (r5.f.b(r16.getHost()) == false) goto L33;
        return r10;
    L33:
        if (r5.f.b(r16.getPath()) == true) goto L156;
        String r17 = r16.getHost();
        String r18 = r16.getPath();
        if (f9159e.isEmpty() == true) goto L38;
    L42:
        Iterator r19 = f9159e.iterator();
    L44:
        if (r19.hasNext() == false) goto L48;
        if (g.b(r17, (String) r19.next()) == false) goto L44;
    L59:
        boolean r20 = true;
    L61:
        if (r20 == false) goto L63;
        return r10;
    L63:
        Iterator<Header> r21 = r11.iterator();
    L65:
        if (r21.hasNext() == false) goto L76;
        Header r22 = r21.next();
        if (r5.f.b(r22.getName()) == true) goto L65;
        if (r5.f.b(r22.getValue()) == true) goto L65;
        if (r22.getName().equals("bypass-boe") == false) goto L65;
        if (r22.getValue().equals("1") == false) goto L65;
        return r10;
    L76:
        String r23 = r16.getScheme();
        if (f9158d == false) goto L90;
        if (r23.equals(LocationInfoConst.HTTPS) == false) goto L83;
        String r24 = "http";
    L87:
        if (r5.f.b(r24) == true) goto L90;
        r10 = r10.replaceFirst(r23, r24);
        goto L90
    L83:
        if (r23.equals("wss") == false) goto L85;
        r24 = "ws";
        goto L87
    L85:
        r24 = null;
    L90:
        if (c.f9163a.matcher(r16.getHost()).matches() == false) goto L92;
    L97:
        if (r12 == false) goto L99;
        return r10;
    L99:
        boolean r25 = f9158d;
        String r26 = r16.getHost();
        if (r25 == false) goto L106;
        if (r26.contains(f9155a) == true) goto L151;
        StringBuilder r27 = android.aimedia.a.j(r26);
        r27.append(f9155a);
        return r10.replaceFirst(r26, r27.toString());
    L151:
        return r10;
    L106:
        if (TextUtils.isEmpty(f9156b) == true) goto L157;
        String[] r28 = r26.split("\\.");
        int r29 = r28.length;
        if (r29 < 2) goto L158;
        if (r29 != 2) goto L113;
        String r30 = r28[0];
        int r31 = 0;
    L124:
        if (r30.contains(f9156b) == true) goto L159;
        StringBuilder r32 = android.aimedia.a.j(r30);
        r32.append(f9156b);
        return defpackage.a.e(r10.substring(0, r31), r10.substring(r31).replaceFirst(r30, r32.toString()));
    L159:
        return r10;
    L113:
        int r33 = r29 - 3;
        String r34 = r28[r33];
        int r35 = 0;
        r31 = 0;
    L114:
        if (r35 >= r33) goto L122;
        if (r35 != 0) goto L117;
        int r36 = 0;
    L118:
        r31 = r26.indexOf(".", r36);
        if (r31 == (-1)) goto L120;
        r35 = r35 + 1;
        goto L114
    L120:
        r31 = 0;
        goto L122
    L117:
        r36 = r31 + 1;
    L122:
        r30 = r34;
        goto L124
    L158:
        return r10;
    L157:
        return r10;
    L92:
        if (c.f9164b.matcher(r16.getHost()).matches() == true) goto L97;
        if (c.f9165c.matcher(r16.getHost()).matches() == true) goto L97;
        r12 = false;
        goto L97
    L48:
        Iterator r37 = f9160f.iterator();
    L50:
        if (r37.hasNext() == false) goto L54;
        if (g.b(r18, (String) r37.next()) == false) goto L50;
    L54:
        String r38 = defpackage.a.e(r17, r18);
        Iterator r39 = f9162h.iterator();
    L56:
        if (r39.hasNext() == false) goto L60;
        if (((Pattern) r39.next()).matcher(r38).matches() == false) goto L56;
    L60:
        r20 = false;
        goto L61
    L38:
        if (f9160f.isEmpty() == false) goto L42;
        if (f9162h.isEmpty() == false) goto L42;
    L156:
        return r10;
    L26:
        if (TextUtils.isEmpty(f9156b) == false) goto L28;
        return r10;
    }
}
