package u7;

import com.obric.aikernel.middleware.api.traker.TrackerApi;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final void a(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        TrackerApi.INSTANCE.monitorEvent(r10, r11, r12, r13);
    }

    public static final void b(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        TrackerApi.INSTANCE.onEvent(r10, r11);
    }
}
