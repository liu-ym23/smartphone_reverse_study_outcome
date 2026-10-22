package z2;

import android.text.TextUtils;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f13775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ReentrantReadWriteLock f13776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Lock f13777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Lock f13778d;

    static {
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        f13776b = r10;
        f13777c = r10.readLock();
        f13778d = f13776b.writeLock();
    }

    public static int a(URL r17) {
        if (r17 != null) goto L61;
        return -1;
    L61:
        f13777c.lock();     // Catch: Throwable -> L60
        JSONObject r10 = f13775a;     // Catch: Throwable -> L60
        if (r10 != null) goto L10;
    L7:
        f13777c.unlock();
        return -1;
    L10:
        if (r10.optInt("enabled", 0) <= 0) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L7;
        JSONArray r12 = f13775a.optJSONArray("rule_list");     // Catch: Throwable -> L60
        if (r12 == null) goto L7;
        if (r12.length() == 0) goto L7;
        int r13 = 0;
    L22:
        if (r13 >= r12.length()) goto L58;
        JSONObject r14 = r12.optJSONObject(r13);     // Catch: Throwable -> L60
        if (r14 == null) goto L57;
        JSONArray r15 = null;
        if (r14.has("host_eq") == false) goto L30;
        JSONArray r16 = r14.optJSONArray("host_eq");     // Catch: Throwable -> L60
        int r18 = 1;
    L33:
        if (r16 == null) goto L57;
        if (b(r17.getHost(), r16, r18) == false) goto L57;
        if (r14.has("path_eq") == false) goto L41;
        int r19 = 3;
        r15 = r14.optJSONArray("path_eq");     // Catch: Throwable -> L60
    L50:
        if (r15 == null) goto L57;
        if (b(r17.getPath(), r15, r19) == false) goto L57;
        int r20 = r14.optInt(EventBody.KEY_VALUE, -1);     // Catch: Throwable -> L60
        f13777c.unlock();
        return r20;
    L41:
        if (r14.has("path_prefix") == false) goto L44;
        r19 = 4;
        r15 = r14.optJSONArray("path_prefix");     // Catch: Throwable -> L60
        goto L50
    L44:
        if (r14.has("path_contain") == false) goto L47;
        r19 = 5;
        r15 = r14.optJSONArray("path_contain");     // Catch: Throwable -> L60
        goto L50
    L47:
        if (r14.has("path_pattern") == false) goto L49;
        r19 = 6;
        r15 = r14.optJSONArray("path_pattern");     // Catch: Throwable -> L60
        goto L50
    L49:
        r19 = 0;
        goto L50
    L30:
        if (r14.has("host_wc") == false) goto L32;
        r18 = 2;
        r16 = r14.optJSONArray("host_wc");     // Catch: Throwable -> L60
        goto L33
    L32:
        r18 = 0;
        r16 = null;
    L57:
        r13 = r13 + 1;
        goto L22
    L12:
        r11 = false;
    L58:
        f13777c.unlock();
        return -1;
    }

    private static boolean b(String r10, JSONArray r11, int r12) {
        if (r10 != null) goto L5;
    L61:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L61;
        if (r11 == null) goto L61;
        if (r11.length() == 0) goto L61;
        switch(r12) {
            case 1: goto L49;
            case 2: goto L40;
            case 3: goto L49;
            case 4: goto L31;
            case 5: goto L22;
            case 6: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    L13:
        int r13 = 0;
    L15:
        if (r13 >= r11.length()) goto L58;
        String r14 = r11.optString(r13);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r14) == true) goto L21;
        if (r10.matches(r14) == false) goto L21;
        return true;
    L21:
        r13 = r13 + 1;     // Catch: Throwable -> L59
    L58:
        return false;
    L22:
        int r15 = 0;
    L24:
        if (r15 >= r11.length()) goto L58;
        String r16 = r11.optString(r15);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r16) == true) goto L30;
        if (r10.contains(r16) == false) goto L30;
        return true;
    L30:
        r15 = r15 + 1;     // Catch: Throwable -> L59
        goto L24
    L31:
        int r17 = 0;
    L33:
        if (r17 >= r11.length()) goto L58;
        String r18 = r11.optString(r17);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r18) == true) goto L39;
        if (r10.startsWith(r18) == false) goto L39;
        return true;
    L39:
        r17 = r17 + 1;     // Catch: Throwable -> L59
        goto L33
    L40:
        int r19 = 0;
    L42:
        if (r19 >= r11.length()) goto L58;
        String r20 = r11.optString(r19);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r20) == true) goto L48;
        if (k.i(r10, r20) == false) goto L48;
        return true;
    L48:
        r19 = r19 + 1;     // Catch: Throwable -> L59
        goto L42
    L49:
        int r21 = 0;
    L51:
        if (r21 >= r11.length()) goto L58;
        String r22 = r11.optString(r21);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r22) == true) goto L57;
        if (r10.equals(r22) == false) goto L57;
        return true;
    L57:
        r21 = r21 + 1;
    L59:
        th = move-exception;
        th.printStackTrace();
        goto L61
    }

    public static void c(JSONObject r10) {
        if (r10 != null) goto L10;
        return;
    L10:
        f13778d.lock();     // Catch: Throwable -> L7
        f13775a = r10.optJSONObject("to_config");     // Catch: Throwable -> L7
        f13778d.unlock();
        return;
    L7:
        th = move-exception;
        f13778d.unlock();
        throw th;
    }
}
