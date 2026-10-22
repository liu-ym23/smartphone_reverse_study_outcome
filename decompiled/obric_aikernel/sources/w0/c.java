package w0;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.ICustomExtraHeader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class c implements ICustomExtraHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f13237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile SharedPreferences f13238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile JSONObject f13239c;

    c(com.bytedance.applog.c r10) {
        this.f13237a = r10;
    }

    private JSONObject a(Context r10) {
        if (this.f13239c != null) goto L12;
        if (r10 == null) goto L12;
        SharedPreferences r11 = b(r10);     // Catch: Exception -> L13
        if (r11 == null) goto L14;
        String r12 = r11.getString("header_custom_info", null);     // Catch: Exception -> L13
        if (r12 == null) goto L10;
        this.f13239c = new JSONObject(r12);     // Catch: Exception -> L13
        goto L14
    L10:
        this.f13239c = new JSONObject();     // Catch: Exception -> L13
    L14:
    L12:
        return this.f13239c;
    }

    private SharedPreferences b(Context r10) {
        if (this.f13238b != null) goto L6;
        this.f13238b = r10.getSharedPreferences(com.bytedance.applog.b.b(this.f13237a, "header_custom"), 0);
    L6:
        return this.f13238b;
    }

    @Override // com.bytedance.bdinstall.ICustomExtraHeader
    public Map<String, Object> getExtraParams() {
        JSONObject r10 = a(this.f13237a.w());
        if (r10 == null) goto L5;
        HashMap r11 = new HashMap();
        Iterator<String> r12 = r10.keys();
    L8:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();
        if (r13 == null) goto L8;
        r11.put(r13, r10.opt(r13));
        goto L8
    L12:
        return r11;
    L5:
        return Collections.emptyMap();
    }
}
