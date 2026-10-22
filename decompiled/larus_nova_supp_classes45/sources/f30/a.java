package f30;

import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.fr;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "apiParam")
public final class a extends g<Object, JSONObject> {

    /* JADX INFO: renamed from: f30.a$a, reason: collision with other inner class name */
    public static class C0231a {
        public static final C0231a c = null;
        public static final int d = 0;
        public Map<String, String> a;
        public long b;

        public C0231a() {
        }

        static {
            c = new C0231a();
            d = ((Integer) fr.a.getValue()).intValue();
        }
    }

    public a() {
    }

    public final Object invoke(Object r6, CallContext r7) throws Exception {
        JSONObject r8 = new JSONObject();
        C0231a r9 = C0231a.c;
        if (r9.a == null) goto L8;
        if ((System.currentTimeMillis() - r9.b) <= C0231a.d) goto L8;
        r9.a = null;
    L8:
        if (r9.a != null) goto L10;
        r9.a = k.f(IMiddlewareNetworkService.class).getCommonParams();
        r9.b = System.currentTimeMillis();
    L10:
        Map<String, String> r11 = r9.a;
        Iterator<String> r0 = r11.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L19;
        String r1 = r0.next();
        String r2 = r11.get(r1);
        if (StringUtils.isEmpty(r1) == true) goto L12;
        if (StringUtils.isEmpty(r2) == true) goto L12;
        r8.put(r1, r2);
        goto L12
    L19:
        if (LiveHybridSettingKeys.ARGUS_API_PARAM_JSB_DELETE_TOKEN.getValue().booleanValue() == true) goto L28;
        JSONObject r12 = new JSONObject();
        Map r3 = k.f(IHostWebView.class).getHeaderMap("https://hotsoon.snssdk.com");
        if (r3 == null) goto L27;
        Iterator r4 = r3.entrySet().iterator();
    L25:
        if (r4.hasNext() == false) goto L27;
        Map.Entry r5 = (Map.Entry) r4.next();
        r12.put((String) r5.getKey(), r5.getValue());
    L27:
        r8.put("tt_token", r12);
    L28:
        return r8;
    }
}
