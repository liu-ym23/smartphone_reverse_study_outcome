package j6;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements h6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f18258c;

    public d(String r5, String r10, float r11) {
        this.f18256a = r5;
        this.f18257b = r10;
        this.f18258c = r11;
    }

    @Override // h6.b
    public final String a() {
        return "timer";
    }

    @Override // h6.b
    public final boolean b(JSONObject r5) {
        return false;
    }

    @Override // h6.b
    public final JSONObject c() {
        JSONObject r5 = new JSONObject();
        r5.put("type", this.f18256a);     // Catch: JSONException -> L5
        r5.put(STGroup.DICT_KEY, this.f18257b);     // Catch: JSONException -> L5
        r5.put("value", this.f18258c);     // Catch: JSONException -> L5
        return r5;
    L5:
        return null;
    }

    @Override // h6.b
    public final boolean d() {
        return false;
    }

    @Override // h6.b
    public final String e() {
        return "timer";
    }
}
