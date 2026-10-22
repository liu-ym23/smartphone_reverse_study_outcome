package fs8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.home.impl.sdk.d;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.o;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("image_upload_keva", 0);
    }

    public static String a() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.getAccountService();
        boolean r1 = true;
        if (d.a.a() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        return "_minor";
    L10:
        return "";
    L7:
        r1 = false;
        goto L8
    }

    public static void b(boolean r3) {
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r1.put("cached", r4);
        r1.put("resource_center_enabled", false);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("uploader_token_used", r1);
        return;
    L5:
        r4 = TriggerSendLoading.NO_LOADING;
        goto L6
    }
}
