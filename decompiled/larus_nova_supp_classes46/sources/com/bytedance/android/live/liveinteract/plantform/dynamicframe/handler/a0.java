package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ v a;
    public final /* synthetic */ DataCenter b;

    public a0(v r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r12) {
        IVoiceLiveTheme r13 = (IVoiceLiveTheme) r12;
        String r0 = this.a.d;
        StringBuilder r1 = new StringBuilder("themeObserver, changeTheme, theme=");
        r1.append(r13);
        r1.append(", url=");
        if (r13 == null) goto L5;
        py.k r2 = r13.getStaticBackground();
    L6:
        r1.append(ImageUtil.getImageUrl(r2));
        ALogger.i(r0, r1.toString());
        if (r13 != null) goto L16;
    L10:
        JsonObject r14 = new JsonObject();     // Catch: Exception -> L13
    L11:
        JsonObject r5 = r14;
        this.b.put("data_multi_lick_dynamic_event_change", new nh0.f("bg_theme", null, null, null, r5, null, false, 222));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ALogger.e(this.a.d, "send AudioBGData to Lynx failed!", e);
        return;
    L16:
        r14 = GsonHelper.get().toJsonTree(r13).getAsJsonObject();     // Catch: Exception -> L13
        if (r14 != null) goto L11;
    L5:
        r2 = null;
        goto L6
    }
}
