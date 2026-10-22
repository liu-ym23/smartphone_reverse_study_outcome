package com.ss.android.lark.flow.group;

import android.content.Context;
import com.ss.android.lark.applink.api.AppLinkHandlerPlugin;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppLinkHandlerPlugin
public final class b implements pva.b {
    public b() {
    }

    public final Map<String, ova.d> a(Context r3) {
        HashMap r4 = new HashMap();
        r4.put("/client/chat/chatter/add_by_link", new e());
        return r4;
    }
}
