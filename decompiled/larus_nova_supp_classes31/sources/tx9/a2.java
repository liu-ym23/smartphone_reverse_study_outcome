package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a2 {
    public static void a(int r2, String r3, Long r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "mediaType");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("is_success", Integer.valueOf(r2));     // Catch: JSONException -> L5
        r0.putOpt("media_type", r3);     // Catch: JSONException -> L5
        r0.putOpt("data_type", null);     // Catch: JSONException -> L5
        r0.putOpt("duration", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("anchor_meta_data_save");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MetaDataTrack", "error in MetaDataTrack anchor meta data save " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(int r2, long r3, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "mediaType");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("is_success", Integer.valueOf(r2));     // Catch: JSONException -> L5
        r0.putOpt("duration", Long.valueOf(r3));     // Catch: JSONException -> L5
        r0.putOpt("media_type", r5);     // Catch: JSONException -> L5
    L7:
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("save_media_duration");
        r6.a.merge(r4);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MetaDataTrack", "error in MetaDataTrack save media duration " + e.getLocalizedMessage());
        goto L7
    }
}
