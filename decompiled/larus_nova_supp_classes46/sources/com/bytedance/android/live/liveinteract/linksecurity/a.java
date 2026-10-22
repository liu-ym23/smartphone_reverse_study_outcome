package com.bytedance.android.live.liveinteract.linksecurity;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends LinkSecurityMonitor {
    public static final a g = null;

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final String f() {
        return "multi_link_interact";
    }

    static {
        g = new a();
    }

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final void g() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r1 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r2 = com.bytedance.android.live.core.privacy.av.api.a.b;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        Intrinsics.checkNotNullParameter(r2, "config");
        c("on_close_broadcast", r0, r1, r2);
    }

    public a() {
    }

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final void h(ILinkPlayerInfoBridge r4, ILinkPlayerInfoBridge r5, LinkSecurityMonitor.b r6) {
        Intrinsics.checkNotNullParameter(r5, "new");
        Intrinsics.checkNotNullParameter(r5, "new");
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = "";
        if (r4 == null) goto L6;
        String r7 = String.valueOf(r4.getLinkType());
        if (r7 == null) goto L6;
    L7:
        r0.put("last_link_type", r7);
        r0.put("current_link_type", String.valueOf(r5.getLinkType()));
        if (r6 == null) goto L13;
        String r8 = r6.toString();
        if (r8 == null) goto L13;
        r1 = r8;
    L13:
        r0.put("last_log_info", r1);
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        e("on_user_list_camera_closed", r0, com.bytedance.android.live.core.privacy.av.api.b.a.a, com.bytedance.android.live.core.privacy.av.api.a.b);
        return;
    L6:
        r7 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final void i(ILinkPlayerInfoBridge r4, ILinkPlayerInfoBridge r5, LinkSecurityMonitor.b r6) {
        Intrinsics.checkNotNullParameter(r5, "new");
        Intrinsics.checkNotNullParameter(r5, "new");
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = "";
        if (r4 == null) goto L6;
        String r7 = String.valueOf(r4.getSilenceStatus());
        if (r7 == null) goto L6;
    L7:
        r0.put("last_silence_state", r7);
        r0.put("current_silence_state", String.valueOf(r5.getSilenceStatus()));
        if (r6 == null) goto L13;
        String r8 = r6.toString();
        if (r8 == null) goto L13;
        r1 = r8;
    L13:
        r0.put("last_log_info", r1);
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        d("on_user_list_self_mute", r0, com.bytedance.android.live.core.privacy.av.api.b.a.a, com.bytedance.android.live.core.privacy.av.api.a.b);
        return;
    L6:
        r7 = "";
        goto L7
    }
}
