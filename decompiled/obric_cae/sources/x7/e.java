package x7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a[] f13601a = null;

        static {
            f13601a = new a[]{new a(BdimCategoryConstants.VALUE_NONE, 0), new a("GZIP", 1), new a("DEFLATER", 2)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f13601a.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f13602b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f13603m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f13604n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f13605o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f13606p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ b[] f13607q = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13608a;

        static {
            b r8 = new b(BdimCategoryConstants.VALUE_NONE, 0, 0);
            f13602b = r8;
            b r10 = new b("MOBILE", 1, 1);
            f13603m = r10;
            b r11 = new b("MOBILE_2G", 2, 2);
            b r12 = new b("MOBILE_3G", 3, 3);
            f13604n = r12;
            b r13 = new b("WIFI", 4, 4);
            f13605o = r13;
            b r14 = new b("MOBILE_4G", 5, 5);
            f13606p = r14;
            f13607q = new b[]{r8, r10, r11, r12, r13, r14};
        }

        public b(String r8, int r10, int r11) {
            super(r8, r10);
            this.f13608a = r11;
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f13607q.clone();
        }
    }

    public static u8.b a(String r11, byte[] r12, boolean r13) {
        a[] r8 = a.f13601a;
        String r10 = "application/json; charset=utf-8";
        String r14 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r12 != null) goto L8;
        r12 = new byte[0];
    L8:
        if (r12.length <= 128) goto L14;
        ByteArrayOutputStream r15 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r16 = new GZIPOutputStream(r15);
        r16.write(r12);     // Catch: Throwable -> L12
        r16.close();
        r12 = r15.toByteArray();
        r14 = "gzip";
    L15:
        byte[] r17 = r12;
        String r18 = r14;
        if (r13 == false) goto L24;
        byte[] r19 = EncryptorUtil.a(r17.length, r17);
        if (r19 == null) goto L20;
        r10 = "application/octet-stream;tt-data=a";
        String r20 = r11.concat("&tt_data=a");
        byte[] r21 = r19;
    L22:
        return b(r20, r21, r10, r18, HttpMethodContrants.POST, true, true);
    L20:
        r20 = r11;
        r21 = r17;
        goto L22
    L24:
        return b(r11, r17, "application/json; charset=utf-8", r18, HttpMethodContrants.POST, true, false);
    L12:
        r16.close();
        return null;
    L14:
        a[] r22 = a.f13601a;
        goto L15
    }

    public static u8.b b(String r8, byte[] r10, String r11, String r12, String r13, boolean r14, boolean r15) {
        InputStream r16 = null;
        LinkedList r17 = new LinkedList();     // Catch: Throwable -> L73
        if (r15 == false) goto L6;
        URL r18 = new URL(n7.a.f(r8, r17));     // Catch: Throwable -> L73
    L7:
        HttpURLConnection r19 = (HttpURLConnection) r18.openConnection();     // Catch: Throwable -> L73
        if (r15 == false) goto L21;
    L18:
        Throwable th = th;
    L87:
        throw th;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        t2.b.q(r16);
        if (r19 != null) goto L85;
    L80:
        throw th;
    L85:
        r19.disconnect();     // Catch: Exception -> L82
        goto L80
    L10:
        if (r17.isEmpty() == true) goto L21;
        Iterator r110 = r17.iterator();     // Catch: Throwable -> L18
    L13:
        if (r110.hasNext() == false) goto L21;
        Pair r20 = (Pair) r110.next();     // Catch: Throwable -> L18
        if (r20 == null) goto L13;
        r19.setRequestProperty((String) r20.first, (String) r20.second);     // Catch: Throwable -> L18
    L21:
        if (r14 == false) goto L23;
        r19.setDoOutput(true);     // Catch: Throwable -> L18
    L24:
        if (r11 == null) goto L26;
        r19.setRequestProperty("Content-Type", r11);     // Catch: Throwable -> L18
    L26:
        if (r12 == null) goto L28;
        r19.setRequestProperty("Content-Encoding", r12);     // Catch: Throwable -> L18
    L28:
        r19.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L18
        r19.setRequestProperty("Version-Code", "1");     // Catch: Throwable -> L18
        r19.setRequestMethod(r13);     // Catch: Throwable -> L18
        if (r10 != null) goto L31;
    L41:
        int r21 = r19.getResponseCode();     // Catch: Throwable -> L18
        if (r21 != 200) goto L71;
        InputStream r22 = r19.getInputStream();     // Catch: Throwable -> L18
        String r23 = r19.getContentEncoding();     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r23) == false) goto L47;
    L56:
        byte[] r24 = e(r22);     // Catch: Throwable -> L69
    L57:
        Map<String, List<String>> r25 = r19.getHeaderFields();     // Catch: Throwable -> L69
        HashMap r26 = new HashMap();     // Catch: Throwable -> L69
        Iterator<String> r27 = r25.keySet().iterator();     // Catch: Throwable -> L69
    L59:
        if (r27.hasNext() == false) goto L65;
        String r28 = r27.next();     // Catch: Throwable -> L69
        List<String> r29 = r25.get(r28);     // Catch: Throwable -> L69
        if (r29 == null) goto L59;
        if (defpackage.c.P(r29) == true) goto L59;
        r26.put(r28, r29.get(0));     // Catch: Throwable -> L69
        goto L59
    L65:
        u8.b r30 = new u8.b(r21, r26, r24);     // Catch: Throwable -> L69
        t2.b.q(r22);
        r19.disconnect();     // Catch: Exception -> L81
    L68:
        return r30;
    L47:
        if (r23.equalsIgnoreCase("gzip") == false) goto L56;
        GZIPInputStream r31 = new GZIPInputStream(r22);     // Catch: Throwable -> L53
        r24 = e(r31);     // Catch: Throwable -> L51
        t2.b.q(r31);     // Catch: Throwable -> L69
    L51:
        th = th;
        r16 = r31;
    L54:
        t2.b.q(r16);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L53:
        th = th;
    L69:
        th = th;
        r16 = r22;
        goto L87
    L71:
        r19.getResponseMessage();     // Catch: Throwable -> L18
        throw new d(r21);     // Catch: Throwable -> L18
    L31:
        if (r10.length <= 0) goto L41;
        DataOutputStream r32 = new DataOutputStream(r19.getOutputStream());     // Catch: Throwable -> L37
        r32.write(r10);     // Catch: Throwable -> L35
        r32.flush();     // Catch: Throwable -> L35
        t2.b.q(r32);     // Catch: Throwable -> L18
    L35:
        th = th;
    L39:
        t2.b.q(r32);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L37:
        th = th;
        r32 = null;
        goto L39
    L23:
        r19.setDoOutput(false);     // Catch: Throwable -> L18
        goto L24
    L6:
        r18 = new URL(r8);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        th = th;
        r19 = null;
        goto L87
    }

    public static b c(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r10 == null) goto L22;
        if (r10.isAvailable() == false) goto L22;
        int r11 = r10.getType();     // Catch: Throwable -> L23
        if (1 == r11) goto L10;
        if (r11 != 0) goto L20;
        switch(((TelephonyManager) r8.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L26;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L26;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L26;
        };     // Catch: Throwable -> L23
    L26:
        return b.f13603m;
    L16:
        return b.f13606p;
    L18:
        return b.f13604n;
    L20:
        return b.f13603m;
    L10:
        return b.f13605o;
    L22:
        return b.f13602b;
    L24:
        return b.f13603m;
    }

    public static boolean d(Context r8) {
        if (r8 != null) goto L14;
        return false;
    L14:
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r10 == null) goto L16;
        if (r10.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static byte[] e(InputStream r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        byte[] r11 = new byte[8192];
    L3:
        int r12 = r8.read(r11);
        if ((-1) == r12) goto L6;
        r10.write(r11, 0, r12);
        goto L3
    L6:
        r8.close();
        return r10.toByteArray();
    }
}
