package vs9;

import com.ixigua.lib.track.TrackParams;
import com.larus.ivykit.web.TTWebViewService;
import com.larus.search.api.event.HybridEventParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a() {
        TTWebViewService r0 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a() ? 1 : 0;
    }

    public static void b(String r3, boolean r4, HybridEventParams r5) {
        by7.a r0 = new by7.a("rich_media_picture_link_page_show");
        JSONObject r1 = new JSONObject();
        r1.put("url", r3);
        r1.put("webview_type", "self_webview");
        if (r4 == false) goto L5;
        String r6 = "1";
    L6:
        r1.put("is_success", r6);
        r1.put("is_ttwebview", a());
        if (r5 == null) goto L21;
        r1.put("enter_method", r5.a);
        r1.put("local_page", r5.b);
        r1.put("chat_type", r5.c);
        String r7 = r5.g;     // Catch: JSONException -> L14
        if (r7 != null) goto L12;
        r7 = "{}";
    L12:
        JSONObject r8 = new JSONObject(r7);     // Catch: JSONException -> L14
    L15:
        if (r8 == null) goto L21;
        Iterator<String> r9 = r8.keys();     // Catch: JSONException -> L23
    L18:
        if (r9.hasNext() == false) goto L21;
        String r10 = r9.next();     // Catch: JSONException -> L23
        r1.put(r10, r8.get(r10));     // Catch: JSONException -> L23
    L14:
        r8 = null;
    L21:
        TrackParams r11 = new TrackParams().merge(r1);
        r0.a.merge(r11);
        r0.b();
        return;
    L5:
        r6 = "0";
        goto L6
    }
}
