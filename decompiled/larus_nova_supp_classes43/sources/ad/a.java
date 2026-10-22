package ad;

import android.app.Dialog;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Dialog r10) {
        BtmSDK r0 = BtmSDK.INSTANCE;
        r0.getPageLifecycle().c(r10, BtmPageLifecycle.State.RESUMED);
        r0.getPageLifecycle().g(r10, null, null);
    }

    public static void a(Dialog r10, Boolean r11) {
        BtmSDK r0 = BtmSDK.INSTANCE;
        r0.getPageLifecycle().c(r10, BtmPageLifecycle.State.DESTROYED);
        BtmPageLifecycle.a.a(r0.getPageLifecycle(), r10, r11, 4);
        r0.getPageLifecycle().a(r10);
    }
}
