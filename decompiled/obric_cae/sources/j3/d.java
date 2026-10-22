package j3;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements k3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f8581a;

    public d(JSONArray r8) {
        this.f8581a = r8;
    }

    @Override // k3.c
    public final boolean isValid() {
        return true;
    }

    public d(JSONObject r8) {
        JSONArray r10 = new JSONArray();
        r10.put(r8);
        this.f8581a = r10;
    }
}
