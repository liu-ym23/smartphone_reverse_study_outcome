package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final String a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.pk.service.f r1 = r0.Aa();
    L6:
        if (r1 == null) goto L11;
        IPkAudienceLoadService.LoadType r2 = r1.getLoadType();
        if (r2 == null) goto L11;
        return r2.getType();
    L11:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a;
        if (r3 == null) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r4 = r3.rb();
    L15:
        if (r4 == null) goto L22;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.launchcontext.b> r5 = r4.getAudienceLaunchContext();
        if (r5 == null) goto L22;
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r6 = (com.bytedance.android.live.revlink.impl.control.launchcontext.b) r5.getValue();
        if (r6 == null) goto L22;
        return r6.b.a;
    L22:
        return null;
    L14:
        r4 = null;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final String b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        ox0.a r1 = r0.getModeMerge();
    L6:
        if (r1 == null) goto L51;
        int r2 = r1.a();
        if (r2 != 0) goto L10;
        return "none";
    L10:
        if (r2 != 2) goto L12;
        return "video_audience";
    L12:
        if (r2 != 4) goto L14;
        return "cross_room";
    L14:
        if (r2 != 8) goto L16;
        return "audio_talk";
    L16:
        if (r2 != 32) goto L18;
        return "video_talk";
    L18:
        if (r2 != 64) goto L20;
        return "multi_anchor";
    L20:
        if (r2 != 128) goto L22;
        return "screen_live";
    L22:
        if (r2 != 256) goto L24;
        return "media_multi_anchor";
    L24:
        if (com.bytedance.android.live.utils.c.a(r2, 2) == false) goto L33;
        if (com.bytedance.android.live.utils.c.a(r2, 4) == false) goto L29;
        return "pk_and_interact_audience";
    L29:
        if (com.bytedance.android.live.utils.c.a(r2, 64) == false) goto L55;
        return "multi_anchor_interact_audience";
    L55:
        return "mode:" + r2;
    L33:
        if (com.bytedance.android.live.utils.c.a(r2, 32) == false) goto L59;
        if (com.bytedance.android.live.utils.c.a(r2, 4) == false) goto L38;
        return "pk_with_audience";
    L38:
        if (com.bytedance.android.live.utils.c.a(r2, 64) == false) goto L58;
        return "multi_anchor_with_audience";
    L58:
        return "mode:" + r2;
    L59:
        return "mode:" + r2;
    L51:
        return "null";
    L5:
        r1 = null;
        goto L6
    }

    public a(LinkFakeGlobalService r1) {
        this.a = r1;
    }
}
