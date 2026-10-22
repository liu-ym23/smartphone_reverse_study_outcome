package y3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c4.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f13962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f13963c;

    public h(String r8, HashSet r10, boolean r11) {
        this.f13961a = r8;
        this.f13962b = r10;
        this.f13963c = r11;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        JSONObject r8 = new JSONObject();
        r8.put("$$APP_ID", this.f13961a);     // Catch: JSONException -> L13
        JSONArray r10 = new JSONArray();     // Catch: JSONException -> L13
        Iterator r11 = this.f13962b.iterator();     // Catch: JSONException -> L13
    L5:
        if (r11.hasNext() == false) goto L7;
        r10.put((Long) r11.next());     // Catch: JSONException -> L13
        goto L5
    L7:
        r8.put("$$EVENT_LOCAL_ID_ARRAY", r10);     // Catch: JSONException -> L13
        if (this.f13963c == false) goto L10;
        String r12 = "success";
    L11:
        r8.put("$$UPLOAD_STATUS", r12);     // Catch: JSONException -> L13
        goto L12
    L10:
        r12 = "failed";
    L12:
        return r8;
    }
}
