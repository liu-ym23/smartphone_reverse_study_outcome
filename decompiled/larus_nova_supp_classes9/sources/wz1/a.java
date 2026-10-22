package wz1;

import com.bytedance.android.livesdk.gift.model.k2;
import com.bytedance.android.scope.o;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements o {
    public final Map<Integer, JsonObject> a;
    public boolean b;
    public Map<Long, ? extends k2> c;
    public b d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a() {
        this.a = new LinkedHashMap();
        this.c = MapsKt.emptyMap();
    }
}
