package l30;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    static {
    }

    public static String a(Uri r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeGetQueryParameter");
        Intrinsics.checkNotNullParameter(r2, "key");
        return UriProtector.getQueryParameter(r1, r2);
    L5:
        return null;
    }

    public static void b(JSONObject r14, CallContext r15) {
        Intrinsics.checkNotNullParameter(r14, "$this$setXSecurityArgusHeader");
        Intrinsics.checkNotNullParameter(r15, "context");
        if (LiveHybridSettingKeys.NETWORK_JSB_ADD_X_SECURITY_ARGUS.getValue().booleanValue() == false) goto L69;
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r14.keys();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = r2.next();
        if (StringsKt.equals(r3, "x-security-argus", true) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r14.remove((String) r4.next());
        goto L12
    L14:
        IMiddleWareHostContext r5 = k.f(IMiddleWareHostContext.class);
        String r6 = "";
        if (r5 == null) goto L17;
        Object r7 = Integer.valueOf(r5.appId());
    L18:
        if (r5 == null) goto L21;
        String r8 = r5.getChannel();
        if (r8 == null) goto L21;
    L22:
        if (r5 == null) goto L25;
        String r9 = r5.getVersionName();
        if (r9 == null) goto L25;
    L26:
        String r11 = r15.b;
        if (r11 == null) goto L45;
        Uri r12 = UriProtector.parse(r11);
        Intrinsics.checkNotNullParameter(r12, "$this$getCDN");
        if (Intrinsics.areEqual(r12.getScheme(), "http") == false) goto L31;
    L38:
        String r13 = r12.toString();
    L39:
        if (r13 == null) goto L45;
        int r16 = StringsKt.indexOf$default(r13, "?", 0, false, 6, null);
        if (r16 != (-1)) goto L44;
        r6 = r13;
        goto L45
    L44:
        r6 = r13.substring(0, r16);
        goto L45
    L31:
        if (Intrinsics.areEqual(r12.getScheme(), "https") == true) goto L38;
        r13 = a(r12, "a_surl");
        if (r13 != null) goto L36;
        r13 = a(r12, "surl");
    L36:
        if (r13 != null) goto L39;
        r13 = a(r12, LiveSlardarConstants.EXTRA_KEY_URL);
    L45:
        Intrinsics.checkNotNullParameter(r15, "context");
        View r17 = r15.d;
        if ((r17 instanceof WebView) == false) goto L48;
        String r18 = "h5";
    L55:
        String r19 = "BridgeNetworkRequest/unknown aid/" + r7 + '/' + r8 + "/Android/" + r9 + '/' + r18 + "/-1 " + r6;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L58
        Result.constructor-impl(r14.put("x-security-argus", r19));     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L48:
        if (r17 == null) goto L54;
        ILatchService r21 = com.bytedance.android.annie.a.c(ILatchService.class);
        if (r21.c(r17) == false) goto L52;
    L53:
        r18 = "lynx";
        goto L55
    L52:
        if (r21.O0(r17) == true) goto L53;
    L54:
        r18 = "unknown";
    L25:
        r9 = "";
    L21:
        r8 = "";
        goto L22
    L17:
        r7 = "";
        goto L18
    }
}
