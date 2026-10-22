package r4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c4.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f11482b;

    public h(String r8, JSONArray r10) {
        this.f11481a = r8;
        this.f11482b = r10;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        JSONObject r8 = new JSONObject();
        r8.put("$$APP_ID", this.f11481a);     // Catch: JSONException -> L5
        r8.put("$$EVENT_LOCAL_ID_ARRAY", this.f11482b);     // Catch: JSONException -> L5
    L4:
        return r8;
    }
}
