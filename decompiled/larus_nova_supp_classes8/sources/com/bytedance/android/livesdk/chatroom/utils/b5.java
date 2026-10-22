package com.bytedance.android.livesdk.chatroom.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b5 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Uri a(DataCenter r3, Uri.Builder r4) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r3, true) == false) goto L6;
        r4.appendQueryParameter("web_bg_color", "#CC161616");
    L10:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r3).isPaidRoom() == false) goto L12;
        String r5 = "1";
    L13:
        r4.appendQueryParameter("is_paidlive", r5);
        return r4.build();
    L12:
        r5 = "0";
        goto L13
    L6:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r4.build(), "horizontal_width")) == false) goto L8;
        r4.appendQueryParameter("horizontal_width", String.valueOf(491)).build();
    L8:
        r4.appendQueryParameter("web_bg_color", "#00000000");
        goto L10
    }

    public static Uri b(DataCenter r2, Uri.Builder r3) {
        IEpisodeExtraInfo r0 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r2).getEpisodeExtra();
        if (r0 == null) goto L7;
        IBaseEpisodeMod r1 = r0.getMod();
        if (r1 == null) goto L7;
        String r4 = String.valueOf(r1.getEpisodeType());
    L8:
        r3.appendQueryParameter("tab", r4).appendQueryParameter("is_hor", String.valueOf(!com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r2, true) ? 1 : 0));
        return r3.build();
    L7:
        r4 = null;
        goto L8
    }
}
