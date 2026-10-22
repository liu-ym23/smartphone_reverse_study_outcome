package np0;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.config.l90;
import com.bytedance.android.livesdk.config.m90;
import com.bytedance.android.livesdk.config.tc1;
import com.bytedance.android.livesdk.config.ud0;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r3) {
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L5;
        xs2.b.a().post(new ep0.a());
        return;
    L5:
        if (r3 == true) goto L26;
        l90 r4 = l90.a;
        if (((tc1) r4.getValue()).a() != 1) goto L17;
        String r5 = ((tc1) r4.getValue()).b();
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        k.n(IBrowserService.class).sendEventToAllJsBridges("live_mini_app_close_choose_page", new JSONObject());
        return;
    L11:
        if (r5.length() == 0) goto L14;
        r6 = false;
    L17:
        Integer r7 = (Integer) m90.a.getValue();
        if (r7 != null) goto L21;
    L23:
        xs2.b.a().post(new d10.b(false));
        return;
    L21:
        if (r7.intValue() != 1) goto L23;
        xs2.b.a().post(new ep0.a());
        return;
    }
}
