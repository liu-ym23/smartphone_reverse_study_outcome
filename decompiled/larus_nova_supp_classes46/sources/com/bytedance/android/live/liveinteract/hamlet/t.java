package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final void accept(Object r10) {
        ApiServerException r11 = (Throwable) r10;
        String r0 = ff0.c.a(r11);
        if ((r11 instanceof ApiServerException) == false) goto L5;
        r11.getMessage();
        int r12 = r11.getErrorCode();
    L6:
        af0.a.a.getClass();
        LinkMonitorData r1 = LinkMonitorData.HamletAvatarCameraCreateFail;     // Catch: Exception -> L10
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L10
        r3.put("error_code", r12);     // Catch: Exception -> L10
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L10
        af0.a.l(r1, r3);     // Catch: Exception -> L10
    L8:
        ff0.d r14 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "createNewCamera fail", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("logId", String.valueOf(r0))}), 12);
        return;
    L5:
        r12 = 0;
        goto L6
    }
}
