package k5;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.c0;
import x4.j0;
import x4.r;
import x4.t;
import x4.u0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8944b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f8945c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f8946d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f8947e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f8948f = null;

    public static class a extends l<String> {
        @Override // k5.l
        public final String a(Object[] r8) {
            boolean r10 = false;
            Context r11 = (Context) r8[0];
            j0 r12 = (j0) r8[1];
            if (r11 == null) goto L12;
            if (r12 != null) goto L14;
            if (r11.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L11;
            r10 = true;
        L11:
            if (r10 == false) goto L12;
        L14:
            return u0.a(String.valueOf(r12.f13463a)).e(r11, r12);
        L12:
            return null;
        }
    }

    public static class b extends l<String[]> {
        @Override // k5.l
        public final String[] a(Object[] r8) {
            Context r10 = (Context) r8[0];
            j0 r11 = (j0) r8[1];
            if (r10 == null) goto L6;
            j.a r12 = j.f8942a;
        L6:
            return new String[0];
        }
    }

    public static class c extends l<JSONArray> {
        @Override // k5.l
        public final JSONArray a(Object[] r8) {
            Context r10 = (Context) r8[0];
            j0 r11 = (j0) r8[1];
            JSONArray r12 = new JSONArray();
            if (r11 == null) goto L50;
        L49:
            r12.put(k.a(0, u0.a(String.valueOf(r11.f13463a)).a(0, r11), "meid"));     // Catch: Throwable -> L14 Exception -> L16
        L56:
            r12.put(k.a(1, u0.a(String.valueOf(r11.f13463a)).a(1, r11), "meid"));     // Catch: Throwable -> L14 Exception -> L23
        L54:
            r12.put(k.a(0, u0.a(String.valueOf(r11.f13463a)).f(0, r11), "imei"));     // Catch: Throwable -> L14 Exception -> L30
        L52:
            r12.put(k.a(1, u0.a(String.valueOf(r11.f13463a)).f(1, r11), "imei"));     // Catch: Throwable -> L14 Exception -> L37
        L62:
            return r12;
        L37:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L41;
            int r13 = r.f13543a;     // Catch: Throwable -> L14
            return r12;
        L41:
            e.printStackTrace();     // Catch: Throwable -> L14
            return r12;
        L30:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L34;
            int r14 = r.f13543a;     // Catch: Throwable -> L14
            goto L52
        L34:
            e.printStackTrace();     // Catch: Throwable -> L14
            goto L52
        L23:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L27;
            int r15 = r.f13543a;     // Catch: Throwable -> L14
            goto L54
        L27:
            e.printStackTrace();     // Catch: Throwable -> L14
            goto L54
        L14:
            th = move-exception;
            if ((th instanceof SecurityException) == false) goto L46;
            int r16 = r.f13543a;
            return r12;
        L46:
            th.printStackTrace();
            return r12;
        L16:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L20;
            int r17 = r.f13543a;     // Catch: Throwable -> L14
            goto L56
        L20:
            e.printStackTrace();     // Catch: Throwable -> L14
            goto L56
        L50:
            if (r10.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L9;
            boolean r18 = true;
        L10:
            if (r18 == true) goto L49;
            return new JSONArray();
        L9:
            r18 = false;
            goto L10
        }
    }

    public static class d extends l<String> {
        @Override // k5.l
        public final String a(Object[] r8) {
            boolean r10 = false;
            Context r11 = (Context) r8[0];
            j0 r12 = (j0) r8[1];
            if (r11 != null) goto L6;
        L14:
            return null;
        L6:
            if (r11.getApplicationInfo().targetSdkVersion < 26) goto L16;
            if (r12 != null) goto L16;
            if (r11.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L13;
            r10 = true;
        L13:
            if (r10 == false) goto L14;
        L16:
            return u0.a(String.valueOf(r12.f13463a)).c(r11, r12);
        }
    }

    public static class e extends l<String> {
        @Override // k5.l
        public final String a(Object[] r8) {
            j.a r10 = j.f8942a;
            if (((Context) r8[0]).getApplicationInfo().targetSdkVersion < 29) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L9;
            return "";
        L9:
            return u0.a((String) r8[1]).b((Context) r8[0], (j0) r8[2]);
        L5:
            r11 = false;
            goto L6
        }
    }

    public static class f extends l<JSONArray> {
        @Override // k5.l
        public final JSONArray a(Object[] r8) {
            c0 r10 = u0.a((String) r8[1]);
            Context r11 = (Context) r8[0];
            return r10.d();
        }
    }

    public static class g extends l<String> {
        @Override // k5.l
        public final String a(Object[] r8) {
            j0 r10 = (j0) r8[0];
            if (r10 == null) goto L15;
            j0 r11 = r10.H.f7907c;
            if (TextUtils.isEmpty(k5.a.a(r11.f13465c, r11).getString("device_id", "")) == true) goto L10;
            h5.a r12 = new h5.a();
            Future r13 = t.c(t.a(t.f13550b)).submit(r12);
            return (String) r13.get(100, TimeUnit.MILLISECONDS);
        L10:
            int r14 = r.f13543a;
            return "";
        L15:
            return "";
        }
    }

    static {
        f8943a = new a();
        f8944b = new b();
        f8945c = new c();
        f8946d = new d();
        f8947e = new e();
        f8948f = new f();
        new g();
    }

    public static JSONObject a(int r8, String r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (TextUtils.isEmpty(r10) == true) goto L5;
        r12.put("id", r10);
        r12.put("slot_index", r8);
        r12.put("type", r11);
    L5:
        return r12;
    }

    public static String b(Context r8, j0 r10) {
        if (r10.F == true) goto L5;
        return null;
    L5:
        return f8946d.b(new Object[]{r8, r10});
    }
}
