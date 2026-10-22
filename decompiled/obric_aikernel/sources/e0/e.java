package e0;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f8551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f8552b;

    static class a implements d {
        a() {
        }

        @Override // e0.d
        public void a(String r10, Throwable r11, String... r12) {
            String r13 = e.a(r12);
            if (r13 != null) goto L5;
            r13 = "";
        L5:
            Log.e(r10, r13 + "  " + Log.getStackTraceString(r11));
        }

        @Override // e0.d
        public void b(String r10, String... r11) {
            Log.i(r10, e.a(r11));
        }

        @Override // e0.d
        public void c(String r10, String... r11) {
            Log.d(r10, e.a(r11));
        }

        @Override // e0.d
        public void d(String r10, String... r11) {
            Log.w(r10, e.a(r11));
        }

        @Override // e0.d
        public void e(String r10, String... r11) {
            Log.e(r10, e.a(r11));
        }
    }

    static {
        a r10 = new a();
        f8551a = r10;
        f8552b = r10;
    }

    static /* synthetic */ String a(String[] r10) {
        return h(r10);
    }

    public static void b(String r10, String... r11) {
        d r12 = f8552b;
        if (r12 == null) goto L6;
        r12.c(r10, r11);
        return;
    }

    public static void c(String r10, String... r11) {
        d r12 = f8552b;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void d(String r10, String... r11) {
        d r12 = f8552b;
        if (r12 == null) goto L6;
        r12.b(r10, r11);
        return;
    }

    public static void e(String r10, Object... r11) {
        if (f8552b == null) goto L15;
        JSONObject r12 = new JSONObject();
        int r13 = r11.length;
        if ((r13 % 2) != 0) goto L14;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L12;
        r12.put(String.valueOf(r11[r14]), String.valueOf(r11[r14 + 1]));     // Catch: JSONException -> L10
        r14 = r14 + 2;
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        f8552b.b(r10, new String[]{r12.toString()});
        return;
    L14:
        throw new IllegalArgumentException();
    }

    public static void f(String r10, Throwable r11, String... r12) {
        d r13 = f8552b;
        if (r13 == null) goto L6;
        r13.a(r10, r11, r12);
        return;
    }

    public static void g(String r10, String... r11) {
        d r12 = f8552b;
        if (r12 == null) goto L6;
        r12.d(r10, r11);
        return;
    }

    private static String h(String... r10) {
        StringBuilder r11 = new StringBuilder(400);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.append(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }
}
