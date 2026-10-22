package c4;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3349a;

    public k(Object r8) {
        this.f3349a = r8;
    }

    @Override // c4.e.b
    public final JSONObject a() {
        Object r8 = this.f3349a;
        JSONObject r10 = ((r4.a) r8).m();
        JSONObject r11 = new JSONObject();
        v4.e.b(r10, r11);
        r11.put("$$APP_ID", ((r4.a) r8).f11461w);     // Catch: JSONException -> L5
        r11.put("$$EVENT_TYPE", l.a((r4.a) r8));     // Catch: JSONException -> L5
        r11.put("$$PRIORITY", ((r4.a) r8).f11463y);     // Catch: JSONException -> L5
        r11.put("$$EVENT_LOCAL_ID", ((r4.a) r8).A);     // Catch: JSONException -> L5
    L4:
        return r11;
    }
}
