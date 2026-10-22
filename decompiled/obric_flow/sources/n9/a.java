package n9;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mh.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final HashMap f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f20212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f20213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f20214c;
    public JSONObject d;
    public boolean e;

    static {
        f = new HashMap();
    }

    public static JSONArray a() {
        JSONArray r5 = new JSONArray();
        Iterator r10 = f.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r10.next();
        JSONObject r12 = new JSONObject();
        String r13 = (String) r11.getKey();
        e.g(((a) r11.getValue()).f20212a, r13, r12);
        r5.put(r12);
        goto L4
    L6:
        return r5;
    }

    public final boolean b(String r10) {
        JSONObject r5 = this.f20212a;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.f20214c != null) goto L10;
        JSONObject r11 = e.q(r5, new String[]{"exception_modules", "exception", "metric_sampling", "test"});
        this.f20214c = r11;
        if (r11 != null) goto L10;
        this.f20214c = new JSONObject();
    L10:
        double r12 = this.f20214c.optDouble(r10, 1.0d);
        if (Math.random() > r12) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean c(String r10) {
        if (this.f20212a != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r10, "block_monitor") == false) goto L9;
        r10 = "caton_monitor";
    L9:
        if (TextUtils.equals(r10, "core_exception_monitor") == false) goto L13;
        return this.e;
    L13:
        if (this.f20213b != null) goto L18;
        JSONObject r5 = e.q(this.f20212a, new String[]{"custom_event_settings", "allow_log_type", "test"});
        this.f20213b = r5;
        if (r5 != null) goto L18;
        this.f20213b = new JSONObject();
    L18:
        if (this.f20213b.optInt(r10) != 1) goto L20;
        return true;
    L20:
        return false;
    }
}
