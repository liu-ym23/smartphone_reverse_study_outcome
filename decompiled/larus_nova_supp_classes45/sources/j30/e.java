package j30;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        LinkedHashMap r0 = new LinkedHashMap();
        JsonObject r1 = new JsonObject();
        u.l().c(x.class).a(r0);
        u.l().c(Room.class).a(r0);
        u.l().c(am2.u.class).a(r0);
        Iterator r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (((String) r3.getValue()) == null) goto L4;
        r1.addProperty((String) r3.getKey(), (String) r3.getValue());
        goto L4
    L8:
        return r1;
    }

    public e() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.C0112g.b;
    }
}
