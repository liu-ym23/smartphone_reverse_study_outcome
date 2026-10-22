package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d1 {
    public static void a() {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("content_type", "soda");     // Catch: JSONException -> L5
    L7:
        TrackParams r0 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("vip_gift_banner_click");
        r2.a.merge(r0);
        r2.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FirstPartyEventHelper", "error in FirstPartyEventHelper mobVipGiftBannerClick " + e.getLocalizedMessage());
        goto L7
    }
}
