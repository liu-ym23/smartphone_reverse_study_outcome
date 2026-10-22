package w4;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f13374a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f13375b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f13376c;

    public interface a {
        String a(String r10, String[] r11);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f13378b;

        public b(String r10, JSONObject r11) {
            this.f13377a = r10;
            this.f13378b = r11;
        }

        public boolean a() {
            if (TextUtils.isEmpty(this.f13377a) == false) goto L10;
            JSONObject r10 = this.f13378b;
            if (r10 != null) goto L7;
        L9:
            return false;
        L7:
            if (r10.length() <= 0) goto L9;
        L10:
            return true;
        }

        public JSONObject b() {
            if (this.f13378b != null) goto L6;
            this.f13378b = new JSONObject(this.f13377a);
        L6:
            return this.f13378b;
        }

        public String c() {
            if (TextUtils.isEmpty(this.f13377a) == false) goto L6;
            this.f13377a = this.f13378b.toString();
        L6:
            return this.f13377a;
        }
    }

    static {
    }

    public static boolean a() {
        return f13374a;
    }

    public static boolean b() {
        return f13375b;
    }

    public static boolean c(Object r10) {
        if ((r10 instanceof String) == false) goto L10;
        if (((String) r10).length() <= 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r10 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r10).length() <= 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if ((r10 instanceof b) == true) goto L19;
        return false;
    L19:
        return ((b) r10).a();
    }

    public static JSONObject d(Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return new JSONObject((String) r10);
    L7:
        if ((r10 instanceof JSONObject) == false) goto L11;
        return (JSONObject) r10;
    L11:
        if ((r10 instanceof b) == true) goto L13;
        return null;
    L13:
        return ((b) r10).b();
    }

    public static String e(Object r10, JSONObject r11, String[] r12) {
        if (r12 != null) goto L5;
    L7:
        String r13 = null;
    L9:
        if (TextUtils.isEmpty(r13) == false) goto L12;
        return null;
    L12:
        if (f13376c == null) goto L18;
        if ((r10 instanceof b) == false) goto L18;
        return f13376c.a(((b) r10).c(), r12);
    L18:
        return r11.optString(r13);
    L5:
        if (r12.length <= 0) goto L7;
        r13 = r12[r12.length - 1];
        goto L9
    }

    public static JSONObject f(Object r10) {
        if ((r10 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r10;
    L7:
        if ((r10 instanceof b) == false) goto L13;
        return ((b) r10).b().optJSONObject("data");
    L10:
        th = move-exception;
        th.printStackTrace();
    L13:
        return new JSONObject();
    }
}
