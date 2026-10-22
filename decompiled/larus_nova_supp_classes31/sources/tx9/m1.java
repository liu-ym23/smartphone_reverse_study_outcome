package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m1 {
    public static void a(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        r4.put("click_option", r3);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("hyperlink_selection_popup_window_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("HyperLinkSelectionEventHelper", "error in HyperLinkSelectionEventHelper mobHyperlinkSelectionPopupWindowClick " + e.getLocalizedMessage());
        goto L7
    }
}
