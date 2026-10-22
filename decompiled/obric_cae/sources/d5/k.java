package d5;

import org.json.JSONException;
import org.json.JSONObject;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class k extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6801e;

    public k(j0 r8) {
        super(true, true);
        this.f6801e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        this.f6801e.getClass();     // Catch: JSONException -> L5
        r8.put("device_category", null);     // Catch: JSONException -> L5
        return true;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
