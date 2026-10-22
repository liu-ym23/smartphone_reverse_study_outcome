package b39;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.applog.api.IApplog;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.push.api.IPushService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Uri r2) {
        IDeeplinkService r0 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r0 != null) goto L5;
    L13:
        return "";
    L5:
        if (r0.k(r2) == false) goto L8;
        return "push";
    L8:
        if (r0.a(r2) == false) goto L11;
        return "bot_share";
    L11:
        if (r0.g(r2) == false) goto L13;
        return "outer_schema";
    }

    public static void b(Uri r8) {
        String r0 = a(r8);
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        IApplog.Companion r3 = IApplog.a;
        JSONObject r4 = new JSONObject();
        r4.put("source_type", r0);
        r4.put("absolute_schema", String.valueOf(r8));
        r4.put("handle_status", "fail");
        r4.put("fail_reason", "block");
        Set r5 = null;
        if (r8 == null) goto L11;
        String r6 = r8.getHost();
    L12:
        r4.put("schema_host", r6);
        if (r8 == null) goto L15;
        String r7 = r8.getPath();
    L16:
        r4.put("schema_path", r7);
        if (r8 == null) goto L19;
        r5 = UriProtector.getQueryParameterNames(r8);
    L19:
        r4.put("schema_queries", String.valueOf(r5));
        Unit r9 = Unit.INSTANCE;
        r3.reportEvent("rd_external_schema_did_handle", r4);
        IDeeplinkService r10 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r10 != null) goto L22;
    L24:
        if (r2 == false) goto L29;
        IPushService r11 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r11 == null) goto L30;
        r11.g(String.valueOf(r8), "block");
        return;
    L30:
        return;
    L29:
        return;
    L22:
        if (r10.k(r8) != true) goto L24;
        r2 = true;
        goto L24
    L15:
        r7 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public static void c(Uri r7) {
        String r0 = a(r7);
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        IApplog.Companion r3 = IApplog.a;
        JSONObject r4 = new JSONObject();
        r4.put("source_type", r0);
        r4.put("absolute_schema", String.valueOf(r7));
        r4.put("handle_status", FlowDoraConnectReason.SUCCESS);
        Set r5 = null;
        if (r7 == null) goto L11;
        String r6 = r7.getHost();
    L12:
        r4.put("schema_host", r6);
        if (r7 == null) goto L15;
        String r8 = r7.getPath();
    L16:
        r4.put("schema_path", r8);
        if (r7 == null) goto L19;
        r5 = UriProtector.getQueryParameterNames(r7);
    L19:
        r4.put("schema_queries", String.valueOf(r5));
        Unit r9 = Unit.INSTANCE;
        r3.reportEvent("rd_external_schema_did_handle", r4);
        IDeeplinkService r10 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r10 != null) goto L22;
    L24:
        if (r2 == false) goto L29;
        IPushService r11 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r11 == null) goto L30;
        r11.f(String.valueOf(r7));
        return;
    L30:
        return;
    L29:
        return;
    L22:
        if (r10.k(r7) != true) goto L24;
        r2 = true;
        goto L24
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L5:
        r1 = false;
        goto L6
    }
}
