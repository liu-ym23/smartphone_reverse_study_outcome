package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public static final void a(String r3, JSONObject r4, by7.e r5, Function1<? super JSONObject, Unit> r6) {
        r6.invoke(r4);     // Catch: JSONException -> L4
    L6:
        TrackParams r7 = new TrackParams().merge(r4);
        by7.a r0 = new by7.a(r3);
        if (r5 == null) goto L9;
        r0.b = r5;
    L9:
        r0.a.merge(r7);
        r0.b();
        com.larus.platform.service.g.a.monitorEventForSlardar(r3, r4, null, null);
        return;
    L4:
        e = move-exception;
        FLogger.a.e("AigcMetadataWriteEventHelper", "error in AigcMetadataWriteEventHelper " + r3 + ' ' + e.getLocalizedMessage());
        goto L6
    }

    public static void b(final boolean r10, final String r11, final long r12, final boolean r14, final String r15, final int r16) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r15, "produceIdType");
        Intrinsics.checkNotNullParameter(r0, "params");
        a("aigc_metadata_write_result", r0, null, new g(r10, r11, r12, r14, r15, r16));
    }
}
