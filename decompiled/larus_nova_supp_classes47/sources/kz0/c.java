package kz0;

import com.bytedance.android.annie.api.data.subscribe.g;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.scope.o;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o, b {
    public c() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // kz0.b
    public final a getCurrentLinkMicState() {
        com.bytedance.android.annie.service.data.b r0 = com.bytedance.android.annie.service.data.b.a;
        i.g.f r1 = i.g.f.b;
        g r2 = com.bytedance.android.annie.service.data.b.a("linkmic");
        Object r3 = null;
        if (r2 == null) goto L5;
        Object r4 = r2.g();
    L7:
        if ((r4 instanceof JsonObject) == false) goto L10;
        r3 = r4;
    L10:
        JsonObject r5 = (JsonObject) r3;
        if (r5 != null) goto L15;
        return new a(0);
    L15:
        return new a(a(r5));
    L5:
        r4 = null;
        goto L7
    }

    public static JsonObject a(JsonObject r9) {
        JsonObject r0 = new JsonObject();
        Iterator r10 = r9.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) r10.next();
        JsonObject r2 = (JsonElement) r1.getValue();
        if ((r2 instanceof JsonPrimitive) == true) goto L7;
        if ((r2 instanceof JsonObject) == true) goto L18;
        r0.add((String) r1.getKey(), (JsonElement) r1.getValue());
        goto L4
    L18:
        r0.add((String) r1.getKey(), a(r2));
        goto L4
    L7:
        JsonPrimitive r3 = (JsonPrimitive) r2;
        if (r3.isNumber() == true) goto L10;
        r0.add((String) r1.getKey(), (JsonElement) r1.getValue());
        goto L4
    L10:
        if (r3.getAsLong() > Integer.MAX_VALUE) goto L14;
        if (r3.getAsLong() < (-2147483647)) goto L14;
        r0.add((String) r1.getKey(), r2);
    L14:
        r0.add((String) r1.getKey(), new JsonPrimitive(r3.getAsString()));
        goto L4
    L20:
        return r0;
    }
}
