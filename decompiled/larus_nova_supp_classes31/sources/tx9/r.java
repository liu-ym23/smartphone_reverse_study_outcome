package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r {
    public static void b(String r2, String r3, String r4, by7.e r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "clickFrom");
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_from", r2);     // Catch: JSONException -> L8
        r0.put("current_page", r3);     // Catch: JSONException -> L8
        if (r4 == null) goto L6;
        r0.put("disk_operation_id", r4);     // Catch: JSONException -> L8
    L6:
        r0.put("disk_schema_version", 2);     // Catch: JSONException -> L8
    L10:
        by7.a r6 = new by7.a("click_clear_cache");
        if (r5 == null) goto L13;
        r6.b = r5;
    L13:
        TrackParams r7 = new TrackParams().merge(r0);
        r6.a.merge(r7);
        r6.b();
        return;
    L8:
        e = move-exception;
        FLogger.a.e("CacheCleanEventHelper", "build click clear cache event failed", e);
        goto L10
    }

    public static void a(String r12, long r13, String r15, String r16, String r17, String r18, String r19, String r20, Long r21, Long r22, Long r23) {
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, "status");
        Intrinsics.checkNotNullParameter(r15, "operationId");
        Intrinsics.checkNotNullParameter(r16, "errorCode");
        Intrinsics.checkNotNullParameter(r17, "errorReason");
        Intrinsics.checkNotNullParameter(r18, "failureStage");
        Intrinsics.checkNotNullParameter(r19, "failureOwner");
        Intrinsics.checkNotNullParameter(r20, "currentPage");
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.put("disk_clean_status", r12);     // Catch: JSONException -> L21
        if (r21 != null) goto L6;
    L8:
        if (r22 != null) goto L10;
    L12:
        if (r23 != null) goto L14;
    L16:
        r7.put("disk_clean_duration_ms", RangesKt.coerceAtLeast(r13, 0));     // Catch: JSONException -> L21
        if ((!StringsKt.isBlank(r15)) == false) goto L19;
        r7.put("disk_operation_id", r15);     // Catch: JSONException -> L21
    L19:
        r7.put("disk_error_code", r16);     // Catch: JSONException -> L21
        r7.put("disk_error_reason", r17);     // Catch: JSONException -> L21
        r7.put("disk_failure_stage", r18);     // Catch: JSONException -> L21
        r7.put("disk_failure_owner", r19);     // Catch: JSONException -> L21
        r7.put("current_page", r20);     // Catch: JSONException -> L21
        r7.put("disk_schema_version", 2);     // Catch: JSONException -> L21
    L23:
        by7.a r0 = new by7.a("clear_cache_result");
        r0.a.merge(new TrackParams().merge(r7));
        r0.b();
        return;
    L14:
        if (r23.longValue() < 0) goto L16;
        r7.put("reclaimed_bytes", r23.longValue());     // Catch: JSONException -> L21
        goto L16
    L10:
        if (r22.longValue() < 0) goto L12;
        r7.put("remaining_bytes", r22.longValue());     // Catch: JSONException -> L21
        goto L12
    L6:
        if (r21.longValue() < 0) goto L8;
        r7.put("before_bytes", r21.longValue());     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.a.e("CacheCleanEventHelper", "build clear cache result event failed", e);
        goto L23
    }
}
