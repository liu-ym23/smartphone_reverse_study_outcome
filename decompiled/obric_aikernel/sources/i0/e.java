package i0;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f9301c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f9302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f9303b;

    private e() {
        this.f9302a = new CopyOnWriteArraySet();
        this.f9303b = new ConcurrentHashMap();
    }

    public static e a() {
        if (f9301c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9301c != null) goto L9;
        f9301c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f9301c;
    }

    public JSONObject b(boolean r10) {
        JSONObject r11 = new JSONObject();
        Iterator<Map.Entry<String, String>> r12 = this.f9303b.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r12.hasNext() == false) goto L7;
        Map.Entry<String, String> r13 = r12.next();     // Catch: JSONException -> L10
        r11.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r10 == false) goto L9;
        com.bytedance.apm.util.d.k().e(r11);     // Catch: JSONException -> L10
        com.bytedance.apm.util.d.k().a(r11);     // Catch: JSONException -> L10
    L9:
        return r11;
    }

    public String c() {
        String r10 = j.a(this.f9302a.toArray(), "#");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }
}
