package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.google.gson.JsonObject;
import java.util.concurrent.Callable;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<V> implements Callable {
    public final /* synthetic */ JsonObject a;

    public o(JsonObject r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final JsonObject call() {
        JsonObject r0 = new JsonObject();
        Lazy r1 = MultiLinkLynxSettingPanelActionHandler.a;
        JsonObject r2 = MultiLinkLynxSettingPanelActionHandler.b(this.a);
        if (r2 == null) goto L5;
        r0.add("settings", r2);
    L5:
        JsonObject r3 = MultiLinkLynxSettingPanelActionHandler.a(this.a);
        if (r3 == null) goto L8;
        r0.add("local_storage", r3);
    L8:
        return r0;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
