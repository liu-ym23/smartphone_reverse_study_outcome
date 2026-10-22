package w8;

import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements e {
    public b() {
    }

    @Override // w8.e
    public final void b(String r1, JSONArray r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "stateSubscriber");
    }

    @Override // w8.e
    public final void release() {
    }

    @Override // w8.e
    public final Map<String, Object> a() {
        return MapsKt.emptyMap();
    }
}
