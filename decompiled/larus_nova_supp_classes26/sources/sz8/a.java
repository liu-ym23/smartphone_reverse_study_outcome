package sz8;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static void a(String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("type", r4);     // Catch: JSONException -> L5
        r1.put("current_page", "credit_invite_new_user");     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r0 = new by7.a("credit_share_link");
        r0.a.merge(r5);
        r0.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CommerceCreditEventHelper", "error in CommerceCreditEventHelper mobCreditShareLink " + e.getLocalizedMessage());
        goto L7
    }
}
