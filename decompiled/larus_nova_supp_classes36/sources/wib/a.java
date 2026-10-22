package wib;

import android.content.Context;
import com.ss.android.lark.applink.api.AppLinkHandlerPlugin;
import java.util.HashMap;
import java.util.Map;
import ova.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppLinkHandlerPlugin
public final class a implements pva.b {
    public a() {
    }

    public final Map<String, d> a(Context r3) {
        HashMap r4 = new HashMap();
        r4.put("/client/forward/share_text", new b());
        return r4;
    }
}
