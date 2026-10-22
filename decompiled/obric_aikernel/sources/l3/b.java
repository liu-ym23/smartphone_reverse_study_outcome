package l3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static JSONObject a(JSONObject r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r10.toString());
    L7:
        return r10;
    }
}
