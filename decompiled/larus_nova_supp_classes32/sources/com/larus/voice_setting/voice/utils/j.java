package com.larus.voice_setting.voice.utils;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static final String a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        if (AppHost.a.isOversea() == false) goto L5;
        String r0 = "7241547611541340167";
    L6:
        a = r0;
        b = LazyKt.lazy(new h());
        c = LazyKt.lazy(new i());
        return;
    L5:
        r0 = "7234781073513644036";
        goto L6
    }

    public static boolean a(BotModel r1) {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L8;
        LaunchInfo r2 = r0.a;
        if (r2 == null) goto L8;
        String r3 = r2.W();
        if (r3 == null) goto L8;
    L9:
        if (r1 == null) goto L11;
        String r4 = r1.getBotId();
    L13:
        return Intrinsics.areEqual(r4, r3);
    L11:
        r4 = null;
    L8:
        r3 = a;
        goto L9
    }
}
